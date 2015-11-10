package com.facebook.stetho.inspector;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.share.internal.ShareConstants;
import com.facebook.stetho.BuildConfig;
import com.facebook.stetho.common.ProcessUtil;
import com.facebook.stetho.server.SecureHttpRequestHandler;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandlerRegistry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChromeDiscoveryHandler extends SecureHttpRequestHandler {
    private static final String PAGE_ID = "1";
    private static final String PATH_ACTIVATE = "/json/activate/1";
    private static final String PATH_PAGE_LIST = "/json";
    private static final String PATH_VERSION = "/json/version";
    private static final String PROTOCOL_VERSION = "1.1";
    private static final String USER_AGENT = "Stetho";
    private static final String WEBKIT_REV = "@188492";
    private static final String WEBKIT_VERSION = "537.36 (@188492)";
    private final Context mContext;
    private final String mInspectorPath;
    private StringEntity mPageListResponse;
    private StringEntity mVersionResponse;

    public ChromeDiscoveryHandler(Context context, String str) {
        super(context);
        this.mContext = context;
        this.mInspectorPath = str;
    }

    public void register(HttpRequestHandlerRegistry httpRequestHandlerRegistry) {
        httpRequestHandlerRegistry.register(PATH_PAGE_LIST, this);
        httpRequestHandlerRegistry.register(PATH_VERSION, this);
        httpRequestHandlerRegistry.register("/json/activate/1*", this);
    }

    protected void handleSecured(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
        Uri parse = Uri.parse(httpRequest.getRequestLine().getUri());
        String path = parse.getPath();
        try {
            if (PATH_VERSION.equals(path)) {
                handleVersion(httpResponse);
            } else if (PATH_PAGE_LIST.equals(path)) {
                handlePageList(httpResponse);
            } else if (PATH_ACTIVATE.equals(path)) {
                handleActivate(httpResponse);
            } else {
                httpResponse.setStatusCode(HttpStatus.SC_NOT_IMPLEMENTED);
                httpResponse.setReasonPhrase("Not Implemented");
                httpResponse.setEntity(new StringEntity("No support for " + parse.getPath()));
            }
        } catch (JSONException e) {
            httpResponse.setStatusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
            httpResponse.setReasonPhrase("Internal Server Error");
            httpResponse.setEntity(new StringEntity(e.toString(), HTTP.UTF_8));
        }
    }

    private void handleVersion(HttpResponse httpResponse) throws JSONException, UnsupportedEncodingException {
        if (this.mVersionResponse == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("WebKit-Version", WEBKIT_VERSION);
            jSONObject.put(HTTP.USER_AGENT, USER_AGENT);
            jSONObject.put("Protocol-Version", PROTOCOL_VERSION);
            jSONObject.put("Browser", getAppLabelAndVersion());
            jSONObject.put("Android-Package", this.mContext.getPackageName());
            this.mVersionResponse = createStringEntity("application/json", jSONObject.toString());
        }
        setSuccessfulResponse(httpResponse, this.mVersionResponse);
    }

    private void handlePageList(HttpResponse httpResponse) throws JSONException, UnsupportedEncodingException {
        if (this.mPageListResponse == null) {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "app");
            jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_TITLE, makeTitle());
            jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_ID, PAGE_ID);
            jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_DESCRIPTION, BuildConfig.FLAVOR);
            jSONObject.put("webSocketDebuggerUrl", "ws://" + this.mInspectorPath);
            jSONObject.put("devtoolsFrontendUrl", new Builder().scheme(HttpHost.DEFAULT_SCHEME_NAME).authority("chrome-devtools-frontend.appspot.com").appendEncodedPath("serve_rev").appendEncodedPath(WEBKIT_REV).appendEncodedPath("devtools.html").appendQueryParameter("ws", this.mInspectorPath).build().toString());
            jSONArray.put(jSONObject);
            this.mPageListResponse = createStringEntity("application/json", jSONArray.toString());
        }
        setSuccessfulResponse(httpResponse, this.mPageListResponse);
    }

    private String makeTitle() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getAppLabel());
        stringBuilder.append(" (powered by Stetho)");
        String processName = ProcessUtil.getProcessName();
        int indexOf = processName.indexOf(58);
        if (indexOf >= 0) {
            stringBuilder.append(processName.substring(indexOf));
        }
        return stringBuilder.toString();
    }

    private void handleActivate(HttpResponse httpResponse) throws UnsupportedEncodingException {
        setSuccessfulResponse(httpResponse, createStringEntity(HTTP.PLAIN_TEXT_TYPE, "Target activation ignored"));
    }

    private static StringEntity createStringEntity(String str, String str2) throws UnsupportedEncodingException {
        StringEntity stringEntity = new StringEntity(str2, HTTP.UTF_8);
        stringEntity.setContentType(str);
        return stringEntity;
    }

    private static void setSuccessfulResponse(HttpResponse httpResponse, HttpEntity httpEntity) {
        httpResponse.setStatusCode(HttpStatus.SC_OK);
        httpResponse.setReasonPhrase("OK");
        httpResponse.setEntity(httpEntity);
    }

    private String getAppLabelAndVersion() {
        StringBuilder stringBuilder = new StringBuilder();
        PackageManager packageManager = this.mContext.getPackageManager();
        stringBuilder.append(getAppLabel());
        stringBuilder.append('/');
        try {
            stringBuilder.append(packageManager.getPackageInfo(this.mContext.getPackageName(), 0).versionName);
            return stringBuilder.toString();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private CharSequence getAppLabel() {
        return this.mContext.getPackageManager().getApplicationLabel(this.mContext.getApplicationInfo());
    }
}
