package com.facebook.stetho.dumpapp;

import android.content.Context;
import android.net.Uri;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.server.SecureHttpRequestHandler;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HttpContext;

public abstract class DumpappHandler extends SecureHttpRequestHandler {
    private static final String QUERY_PARAM_ARGV = "argv";
    private static final String RESPONSE_HEADER_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
    private final Dumper mDumper;

    protected abstract HttpEntity getResponseEntity(HttpRequest httpRequest, InputStream inputStream, HttpResponse httpResponse) throws IOException;

    public DumpappHandler(Context context, Dumper dumper) {
        super(context);
        this.mDumper = dumper;
    }

    protected Dumper getDumper() {
        return this.mDumper;
    }

    protected void handleSecured(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
        httpResponse.setEntity(getResponseEntity(httpRequest, bufferInput(httpRequest), httpResponse));
        httpResponse.addHeader(RESPONSE_HEADER_ALLOW_ORIGIN, "*");
        httpResponse.setStatusCode(HttpStatus.SC_OK);
    }

    private static InputStream bufferInput(HttpRequest httpRequest) throws IOException {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Util.copy(getCallerInput(httpRequest), byteArrayOutputStream, new byte[AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY]);
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    private static InputStream getCallerInput(HttpRequest httpRequest) throws IOException {
        if (httpRequest instanceof HttpEntityEnclosingRequest) {
            HttpEntity entity = ((HttpEntityEnclosingRequest) httpRequest).getEntity();
            if (entity != null) {
                return entity.getContent();
            }
        }
        return new ByteArrayInputStream(new byte[0]);
    }

    protected static String[] getArgs(HttpRequest httpRequest) {
        List queryParameters = Uri.parse(httpRequest.getRequestLine().getUri()).getQueryParameters(QUERY_PARAM_ARGV);
        return (String[]) queryParameters.toArray(new String[queryParameters.size()]);
    }
}
