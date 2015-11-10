package com.android.volley.toolbox;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;
import org.apache.http.protocol.HTTP;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.android.volley.toolbox.f */
public class C0326f implements C0322e {
    private final C0325a f303a;
    private final SSLSocketFactory f304b;

    /* renamed from: com.android.volley.toolbox.f.a */
    public interface C0325a {
        String m330a(String str);
    }

    public C0326f() {
        this(null);
    }

    public C0326f(C0325a c0325a) {
        this(c0325a, null);
    }

    public C0326f(C0325a c0325a, SSLSocketFactory sSLSocketFactory) {
        this.f303a = c0325a;
        this.f304b = sSLSocketFactory;
    }

    public HttpResponse m336a(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError {
        String a;
        String d = request.m228d();
        HashMap hashMap = new HashMap();
        hashMap.putAll(request.m233i());
        hashMap.putAll(map);
        if (this.f303a != null) {
            a = this.f303a.m330a(d);
            if (a == null) {
                throw new IOException("URL blocked by rewriter: " + d);
            }
        }
        a = d;
        HttpURLConnection a2 = m331a(new URL(a), (Request) request);
        for (String a3 : hashMap.keySet()) {
            a2.addRequestProperty(a3, (String) hashMap.get(a3));
        }
        C0326f.m333a(a2, (Request) request);
        ProtocolVersion protocolVersion = new ProtocolVersion(HttpVersion.HTTP, 1, 1);
        if (a2.getResponseCode() == -1) {
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        }
        HttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(protocolVersion, a2.getResponseCode(), a2.getResponseMessage()));
        basicHttpResponse.setEntity(C0326f.m332a(a2));
        for (Entry entry : a2.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                basicHttpResponse.addHeader(new BasicHeader((String) entry.getKey(), (String) ((List) entry.getValue()).get(0)));
            }
        }
        return basicHttpResponse;
    }

    private static HttpEntity m332a(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        HttpEntity basicHttpEntity = new BasicHttpEntity();
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (IOException e) {
            inputStream = httpURLConnection.getErrorStream();
        }
        basicHttpEntity.setContent(inputStream);
        basicHttpEntity.setContentLength((long) httpURLConnection.getContentLength());
        basicHttpEntity.setContentEncoding(httpURLConnection.getContentEncoding());
        basicHttpEntity.setContentType(httpURLConnection.getContentType());
        return basicHttpEntity;
    }

    protected HttpURLConnection m335a(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    private HttpURLConnection m331a(URL url, Request<?> request) throws IOException {
        HttpURLConnection a = m335a(url);
        int t = request.m244t();
        a.setConnectTimeout(t);
        a.setReadTimeout(t);
        a.setUseCaches(false);
        a.setDoInput(true);
        if ("https".equals(url.getProtocol()) && this.f304b != null) {
            ((HttpsURLConnection) a).setSSLSocketFactory(this.f304b);
        }
        return a;
    }

    static void m333a(HttpURLConnection httpURLConnection, Request<?> request) throws IOException, AuthFailureError {
        switch (request.m212a()) {
            case ContentLengthStrategy.IDENTITY /*-1*/:
                byte[] m = request.m237m();
                if (m != null) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.addRequestProperty(HTTP.CONTENT_TYPE, request.m236l());
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream.write(m);
                    dataOutputStream.close();
                }
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                httpURLConnection.setRequestMethod("GET");
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                httpURLConnection.setRequestMethod("POST");
                C0326f.m334b(httpURLConnection, request);
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                httpURLConnection.setRequestMethod("PUT");
                C0326f.m334b(httpURLConnection, request);
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                httpURLConnection.setRequestMethod("DELETE");
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    private static void m334b(HttpURLConnection httpURLConnection, Request<?> request) throws IOException, AuthFailureError {
        byte[] q = request.m241q();
        if (q != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty(HTTP.CONTENT_TYPE, request.m240p());
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(q);
            dataOutputStream.close();
        }
    }
}
