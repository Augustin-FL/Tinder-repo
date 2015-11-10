package com.android.volley.toolbox;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import java.io.IOException;
import java.net.CookieHandler;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.android.volley.toolbox.c */
public class C0323c implements C0322e {
    protected final HttpClient f301a;
    private final HttpContext f302b;

    public C0323c(HttpClient httpClient) {
        this.f302b = new BasicHttpContext();
        this.f301a = httpClient;
        this.f302b.setAttribute("http.cookie-store", CookieHandler.getDefault());
    }

    private static void m323a(HttpUriRequest httpUriRequest, Map<String, String> map) {
        for (String str : map.keySet()) {
            httpUriRequest.setHeader(str, (String) map.get(str));
        }
    }

    public HttpResponse m325a(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError {
        HttpUriRequest b = C0323c.m324b(request, map);
        C0323c.m323a(b, (Map) map);
        C0323c.m323a(b, request.m233i());
        m326a(b);
        HttpParams params = b.getParams();
        int t = request.m244t();
        HttpConnectionParams.setConnectionTimeout(params, 5000);
        HttpConnectionParams.setSoTimeout(params, t);
        return this.f301a.execute(b, this.f302b);
    }

    static HttpUriRequest m324b(Request<?> request, Map<String, String> map) throws AuthFailureError {
        HttpEntityEnclosingRequestBase httpPost;
        switch (request.m212a()) {
            case ContentLengthStrategy.IDENTITY /*-1*/:
                byte[] m = request.m237m();
                if (m == null) {
                    return new HttpGet(request.m228d());
                }
                HttpUriRequest httpPost2 = new HttpPost(request.m228d());
                httpPost2.addHeader(HTTP.CONTENT_TYPE, request.m236l());
                httpPost2.setEntity(new ByteArrayEntity(m));
                return httpPost2;
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                return new HttpGet(request.m228d());
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                httpPost = new HttpPost(request.m228d());
                httpPost.addHeader(HTTP.CONTENT_TYPE, request.m240p());
                C0323c.m322a(httpPost, (Request) request);
                return httpPost;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                httpPost = new HttpPut(request.m228d());
                httpPost.addHeader(HTTP.CONTENT_TYPE, request.m240p());
                C0323c.m322a(httpPost, (Request) request);
                return httpPost;
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                return new HttpDelete(request.m228d());
            default:
                throw new IllegalStateException("Unknown request method.");
        }
    }

    private static void m322a(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, Request<?> request) throws AuthFailureError {
        byte[] q = request.m241q();
        if (q != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(q));
        }
    }

    protected void m326a(HttpUriRequest httpUriRequest) throws IOException {
    }
}
