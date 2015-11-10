package com.facebook.stetho.volley;

import android.os.SystemClock;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.android.volley.C0290a.C0289a;
import com.android.volley.C0293k;
import com.android.volley.C0299e;
import com.android.volley.C0310l;
import com.android.volley.Request;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.C0317a;
import com.android.volley.toolbox.C0322e;
import com.android.volley.toolbox.C0338l;
import com.facebook.stetho.inspector.network.DefaultResponseHandler;
import com.facebook.stetho.inspector.network.NetworkEventReporter;
import com.facebook.stetho.inspector.network.NetworkEventReporterImpl;
import com.google.android.gms.location.places.Place;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.impl.cookie.DateUtils;
import org.apache.http.protocol.HttpRequestExecutor;

public class StethoNetwork implements C0299e {
    protected static final boolean DEBUG;
    private static int DEFAULT_POOL_SIZE;
    private static int SLOW_REQUEST_THRESHOLD_MS;
    private static final AtomicInteger sSequenceNumberGenerator;
    protected final C0322e mHttpStack;
    protected final C0317a mPool;
    private final NetworkEventReporter mStethoHook;

    static {
        sSequenceNumberGenerator = new AtomicInteger(0);
        DEBUG = C0310l.f270b;
        SLOW_REQUEST_THRESHOLD_MS = HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE;
        DEFAULT_POOL_SIZE = AccessibilityNodeInfoCompat.ACTION_SCROLL_FORWARD;
    }

    public StethoNetwork(C0322e c0322e) {
        this(c0322e, new C0317a(DEFAULT_POOL_SIZE));
    }

    public StethoNetwork(C0322e c0322e, C0317a c0317a) {
        this.mStethoHook = NetworkEventReporterImpl.get();
        this.mHttpStack = c0322e;
        this.mPool = c0317a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.android.volley.C0301g performRequest(com.android.volley.Request<?> r13) throws com.android.volley.VolleyError {
        /*
        r12 = this;
        r10 = android.os.SystemClock.elapsedRealtime();
    L_0x0004:
        r2 = 0;
        r5 = 0;
        r1 = new java.util.HashMap;
        r1.<init>();
        r0 = new java.util.HashMap;	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x00e5 }
        r0.<init>();	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x00e5 }
        r3 = r13.m230f();	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x00e5 }
        r12.addCacheHeaders(r0, r3);	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x00e5 }
        r3 = sSequenceNumberGenerator;	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x00e5 }
        r3 = r3.incrementAndGet();	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x00e5 }
        r4 = r12.mStethoHook;	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x00e5 }
        r4 = r4.isEnabled();	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x00e5 }
        if (r4 == 0) goto L_0x0048;
    L_0x0025:
        r4 = r12.mStethoHook;	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x00e5 }
        r6 = new com.facebook.stetho.volley.VolleyNetworkInspectorRequest;	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x00e5 }
        r6.<init>(r3, r13);	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x00e5 }
        r4.requestWillBeSent(r6);	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x00e5 }
        r4 = r13.m241q();	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x00e5 }
        if (r4 == 0) goto L_0x0048;
    L_0x0035:
        r4 = r12.mStethoHook;	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x00e5 }
        r6 = java.lang.String.valueOf(r3);	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x00e5 }
        r7 = r13.m241q();	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x00e5 }
        r7 = r7.length;	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x00e5 }
        r8 = r13.m241q();	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x00e5 }
        r8 = r8.length;	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x00e5 }
        r4.dataSent(r6, r7, r8);	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x00e5 }
    L_0x0048:
        r4 = r12.mHttpStack;	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x00e5 }
        r8 = r4.m321a(r13, r0);	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x00e5 }
        r6 = r8.getStatusLine();	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x0135 }
        r9 = r6.getStatusCode();	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x0135 }
        r0 = r8.getAllHeaders();	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x0135 }
        r7 = convertHeaders(r0);	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x0135 }
        r0 = r12.mStethoHook;	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x0138 }
        r0 = r0.isEnabled();	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x0138 }
        if (r0 == 0) goto L_0x0074;
    L_0x0066:
        r0 = r12.mStethoHook;	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x0138 }
        r1 = new com.facebook.stetho.volley.VolleyNetworkInspectorResponse;	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x0138 }
        r2 = java.lang.String.valueOf(r13);	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x0138 }
        r1.<init>(r13, r8, r2);	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x0138 }
        r0.responseHeadersReceived(r1);	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x0138 }
    L_0x0074:
        r0 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        if (r9 != r0) goto L_0x0087;
    L_0x0078:
        r0 = new com.android.volley.g;	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x0138 }
        r1 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        r2 = r13.m230f();	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x0138 }
        r2 = r2.f213a;	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x0138 }
        r3 = 1;
        r0.<init>(r1, r2, r7, r3);	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x0138 }
    L_0x0086:
        return r0;
    L_0x0087:
        r0 = r8.getEntity();	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x0138 }
        r5 = r12.entityToBytes(r0, r3);	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x0138 }
        r0 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x0138 }
        r2 = r0 - r10;
        r1 = r12;
        r4 = r13;
        r1.logSlowRequests(r2, r4, r5, r6);	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x0138 }
        r0 = r12.statusCodeIsGood(r9);	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x0138 }
        if (r0 != 0) goto L_0x00b3;
    L_0x00a0:
        r0 = new java.io.IOException;	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x0138 }
        r0.<init>();	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x0138 }
        throw r0;	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x0138 }
    L_0x00a6:
        r0 = move-exception;
        r0 = "socket";
        r1 = new com.android.volley.TimeoutError;
        r1.<init>();
        attemptRetryOnException(r0, r13, r1);
        goto L_0x0004;
    L_0x00b3:
        r0 = new com.android.volley.g;	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x0138 }
        r1 = 0;
        r0.<init>(r9, r5, r7, r1);	 Catch:{ SocketTimeoutException -> 0x00a6, ConnectTimeoutException -> 0x00ba, MalformedURLException -> 0x00c7, IOException -> 0x0138 }
        goto L_0x0086;
    L_0x00ba:
        r0 = move-exception;
        r0 = "connection";
        r1 = new com.android.volley.TimeoutError;
        r1.<init>();
        attemptRetryOnException(r0, r13, r1);
        goto L_0x0004;
    L_0x00c7:
        r0 = move-exception;
        r1 = new java.lang.RuntimeException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Bad URL ";
        r2 = r2.append(r3);
        r3 = r13.m228d();
        r2 = r2.append(r3);
        r2 = r2.toString();
        r1.<init>(r2, r0);
        throw r1;
    L_0x00e5:
        r0 = move-exception;
    L_0x00e6:
        r3 = 0;
        if (r2 == 0) goto L_0x0123;
    L_0x00e9:
        r0 = r2.getStatusLine();
        r0 = r0.getStatusCode();
        r2 = "Unexpected response code %d for %s";
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r6 = 0;
        r7 = java.lang.Integer.valueOf(r0);
        r4[r6] = r7;
        r6 = 1;
        r7 = r13.m228d();
        r4[r6] = r7;
        com.android.volley.C0310l.m289c(r2, r4);
        if (r5 == 0) goto L_0x012f;
    L_0x0109:
        r2 = new com.android.volley.g;
        r3 = 0;
        r2.<init>(r0, r5, r1, r3);
        r1 = 401; // 0x191 float:5.62E-43 double:1.98E-321;
        if (r0 == r1) goto L_0x0117;
    L_0x0113:
        r1 = 403; // 0x193 float:5.65E-43 double:1.99E-321;
        if (r0 != r1) goto L_0x0129;
    L_0x0117:
        r0 = "auth";
        r1 = new com.android.volley.AuthFailureError;
        r1.<init>(r2);
        attemptRetryOnException(r0, r13, r1);
        goto L_0x0004;
    L_0x0123:
        r1 = new com.android.volley.NoConnectionError;
        r1.<init>(r0);
        throw r1;
    L_0x0129:
        r0 = new com.android.volley.ServerError;
        r0.<init>(r2);
        throw r0;
    L_0x012f:
        r0 = new com.android.volley.NetworkError;
        r0.<init>(r3);
        throw r0;
    L_0x0135:
        r0 = move-exception;
        r2 = r8;
        goto L_0x00e6;
    L_0x0138:
        r0 = move-exception;
        r1 = r7;
        r2 = r8;
        goto L_0x00e6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.volley.StethoNetwork.performRequest(com.android.volley.Request):com.android.volley.g");
    }

    protected boolean statusCodeIsGood(int i) {
        return i < HttpStatus.SC_BAD_REQUEST;
    }

    private void logSlowRequests(long j, Request<?> request, byte[] bArr, StatusLine statusLine) {
        if (DEBUG || j > ((long) SLOW_REQUEST_THRESHOLD_MS)) {
            String str = "HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]";
            Object[] objArr = new Object[5];
            objArr[0] = request;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(statusLine.getStatusCode());
            objArr[4] = Integer.valueOf(request.m245u().m257b());
            C0310l.m288b(str, objArr);
        }
    }

    private static void attemptRetryOnException(String str, Request<?> request, VolleyError volleyError) throws VolleyError {
        C0293k u = request.m245u();
        int t = request.m244t();
        try {
            u.m256a(volleyError);
            request.m221a(String.format("%s-retry [timeout=%s]", new Object[]{str, Integer.valueOf(t)}));
        } catch (VolleyError e) {
            request.m221a(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{str, Integer.valueOf(t)}));
            throw e;
        }
    }

    private void addCacheHeaders(Map<String, String> map, C0289a c0289a) {
        if (c0289a != null) {
            if (c0289a.f214b != null) {
                map.put(HttpHeaders.IF_NONE_MATCH, c0289a.f214b);
            }
            if (c0289a.f215c > 0) {
                map.put(HttpHeaders.IF_MODIFIED_SINCE, DateUtils.formatDate(new Date(c0289a.f215c)));
            }
        }
    }

    protected void logError(String str, String str2, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        C0310l.m286a("HTTP ERROR(%s) %d ms to fetch %s", str, Long.valueOf(elapsedRealtime - j), str2);
    }

    private byte[] entityToBytes(HttpEntity httpEntity, int i) throws IOException, ServerError {
        Throwable th;
        C0338l c0338l = new C0338l(this.mPool, (int) httpEntity.getContentLength());
        byte[] a;
        try {
            InputStream content = httpEntity.getContent();
            if (this.mStethoHook.isEnabled()) {
                String value;
                if (httpEntity.getContentEncoding() != null) {
                    value = httpEntity.getContentEncoding().getValue();
                } else {
                    value = "utf-8";
                }
                content = this.mStethoHook.interpretResponseStream(String.valueOf(i), httpEntity.getContentType().getValue(), value, content, new DefaultResponseHandler(this.mStethoHook, String.valueOf(i)));
            }
            if (content == null) {
                throw new ServerError();
            }
            a = this.mPool.m304a((int) Place.TYPE_SUBLOCALITY_LEVEL_2);
            while (true) {
                try {
                    int read = content.read(a);
                    if (read == -1) {
                        break;
                    }
                    c0338l.write(a, 0, read);
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            byte[] toByteArray = c0338l.toByteArray();
            try {
                httpEntity.consumeContent();
            } catch (IOException e) {
                C0310l.m286a("Error occured when calling consumingContent", new Object[0]);
            }
            this.mPool.m303a(a);
            c0338l.close();
            return toByteArray;
        } catch (Throwable th3) {
            th = th3;
            a = null;
            try {
                httpEntity.consumeContent();
            } catch (IOException e2) {
                C0310l.m286a("Error occured when calling consumingContent", new Object[0]);
            }
            this.mPool.m303a(a);
            c0338l.close();
            throw th;
        }
    }

    private static Map<String, String> convertHeaders(Header[] headerArr) {
        Map<String, String> hashMap = new HashMap();
        for (int i = 0; i < headerArr.length; i++) {
            hashMap.put(headerArr[i].getName(), headerArr[i].getValue());
        }
        return hashMap;
    }
}
