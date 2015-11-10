package com.squareup.okhttp.internal.p026a;

import com.squareup.okhttp.C2090g;
import com.squareup.okhttp.C2207l;
import com.squareup.okhttp.C2210m;
import com.squareup.okhttp.C2210m.C2209a;
import com.squareup.okhttp.C2217q;
import com.squareup.okhttp.C2222s;
import com.squareup.okhttp.C2222s.C2221a;
import com.squareup.okhttp.C2223t;
import com.squareup.okhttp.C2227u;
import com.squareup.okhttp.C2228w;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.C2113d;
import com.squareup.okhttp.internal.C2151i;
import com.squareup.okhttp.internal.C2157k;
import com.squareup.okhttp.internal.http.C2132f;
import com.squareup.okhttp.internal.http.C2137g;
import com.squareup.okhttp.internal.http.C2138h;
import com.squareup.okhttp.internal.http.C2142j;
import com.squareup.okhttp.internal.http.C2145m;
import com.squareup.okhttp.internal.http.C2150q;
import com.squareup.okhttp.internal.http.RequestException;
import com.squareup.okhttp.internal.http.RouteException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketPermission;
import java.net.URL;
import java.security.Permission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okio.C3332d;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;

/* renamed from: com.squareup.okhttp.internal.a.b */
public class C2097b extends HttpURLConnection {
    private static final Set<String> f3144e;
    private static final C2223t f3145f;
    final C2217q f3146a;
    protected IOException f3147b;
    protected C2137g f3148c;
    C2207l f3149d;
    private C2209a f3150g;
    private long f3151h;
    private int f3152i;
    private C2210m f3153j;
    private C2228w f3154k;

    static {
        f3144e = new LinkedHashSet(Arrays.asList(new String[]{"OPTIONS", "GET", "HEAD", "POST", "PUT", "DELETE", "TRACE", "PATCH"}));
        f3145f = C2223t.m5820a(null, new byte[0]);
    }

    public C2097b(URL url, C2217q c2217q) {
        super(url);
        this.f3150g = new C2209a();
        this.f3151h = -1;
        this.f3146a = c2217q;
    }

    public final void connect() throws IOException {
        m5012b();
        do {
        } while (!m5011a(false));
    }

    public final void disconnect() {
        if (this.f3148c != null) {
            this.f3148c.m5234l();
        }
    }

    public final InputStream getErrorStream() {
        InputStream inputStream = null;
        try {
            C2137g d = m5014d();
            if (C2137g.m5205a(d.m5230h()) && d.m5230h().m5865c() >= HttpStatus.SC_BAD_REQUEST) {
                inputStream = d.m5230h().m5869g().m4907c();
            }
        } catch (IOException e) {
        }
        return inputStream;
    }

    private C2210m m5008a() throws IOException {
        if (this.f3153j == null) {
            C2227u h = m5014d().m5230h();
            this.f3153j = h.m5868f().m5690b().m5680a(C2151i.m5320a().m5328b() + "-Response-Source", C2097b.m5009a(h)).m5681a();
        }
        return this.f3153j;
    }

    private static String m5009a(C2227u c2227u) {
        if (c2227u.m5871i() == null) {
            if (c2227u.m5872j() == null) {
                return "NONE";
            }
            return "CACHE " + c2227u.m5865c();
        } else if (c2227u.m5872j() == null) {
            return "NETWORK " + c2227u.m5865c();
        } else {
            return "CONDITIONAL_CACHE " + c2227u.m5871i().m5865c();
        }
    }

    public final String getHeaderField(int i) {
        try {
            return m5008a().m5691b(i);
        } catch (IOException e) {
            return null;
        }
    }

    public final String getHeaderField(String str) {
        if (str != null) {
            return m5008a().m5689a(str);
        }
        try {
            return C2150q.m5318a(m5014d().m5230h()).toString();
        } catch (IOException e) {
            return null;
        }
    }

    public final String getHeaderFieldKey(int i) {
        try {
            return m5008a().m5688a(i);
        } catch (IOException e) {
            return null;
        }
    }

    public final Map<String, List<String>> getHeaderFields() {
        try {
            return C2142j.m5267a(m5008a(), C2150q.m5318a(m5014d().m5230h()).toString());
        } catch (IOException e) {
            return Collections.emptyMap();
        }
    }

    public final Map<String, List<String>> getRequestProperties() {
        if (!this.connected) {
            return C2142j.m5267a(this.f3150g.m5681a(), null);
        }
        throw new IllegalStateException("Cannot access request header fields after connection is set");
    }

    public final InputStream getInputStream() throws IOException {
        if (this.doInput) {
            C2137g d = m5014d();
            if (getResponseCode() < HttpStatus.SC_BAD_REQUEST) {
                return d.m5230h().m5869g().m4907c();
            }
            throw new FileNotFoundException(this.url.toString());
        }
        throw new ProtocolException("This protocol does not support input");
    }

    public final OutputStream getOutputStream() throws IOException {
        connect();
        C3332d e = this.f3148c.m5227e();
        if (e == null) {
            throw new ProtocolException("method does not support a request body: " + this.method);
        } else if (!this.f3148c.m5228f()) {
            return e.m10171d();
        } else {
            throw new ProtocolException("cannot write request body after response has been read");
        }
    }

    public final Permission getPermission() throws IOException {
        String host = getURL().getHost();
        int a = C2157k.m5347a(getURL());
        if (usingProxy()) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) this.f3146a.m5767d().address();
            host = inetSocketAddress.getHostName();
            a = inetSocketAddress.getPort();
        }
        return new SocketPermission(host + ":" + a, "connect, resolve");
    }

    public final String getRequestProperty(String str) {
        if (str == null) {
            return null;
        }
        return this.f3150g.m5685c(str);
    }

    public void setConnectTimeout(int i) {
        this.f3146a.m5762a((long) i, TimeUnit.MILLISECONDS);
    }

    public void setInstanceFollowRedirects(boolean z) {
        this.f3146a.m5763a(z);
    }

    public int getConnectTimeout() {
        return this.f3146a.m5756a();
    }

    public void setReadTimeout(int i) {
        this.f3146a.m5765b((long) i, TimeUnit.MILLISECONDS);
    }

    public int getReadTimeout() {
        return this.f3146a.m5764b();
    }

    private void m5012b() throws IOException {
        if (this.f3147b != null) {
            throw this.f3147b;
        } else if (this.f3148c == null) {
            this.connected = true;
            try {
                if (this.doOutput) {
                    if (this.method.equals("GET")) {
                        this.method = "POST";
                    } else if (!C2138h.m5240c(this.method)) {
                        throw new ProtocolException(this.method + " does not support writing");
                    }
                }
                this.f3148c = m5007a(this.method, null, null, null);
            } catch (IOException e) {
                this.f3147b = e;
                throw e;
            }
        }
    }

    private C2137g m5007a(String str, C2090g c2090g, C2145m c2145m, C2227u c2227u) {
        C2221a a = new C2221a().m5800a(getURL()).m5798a(str, C2138h.m5239b(str) ? f3145f : null);
        C2210m a2 = this.f3150g.m5681a();
        int a3 = a2.m5687a();
        for (int i = 0; i < a3; i++) {
            a.m5803b(a2.m5688a(i), a2.m5691b(i));
        }
        boolean z = false;
        if (C2138h.m5240c(str)) {
            if (this.f3151h != -1) {
                a.m5799a(HTTP.CONTENT_LEN, Long.toString(this.f3151h));
            } else if (this.chunkLength > 0) {
                a.m5799a(HTTP.TRANSFER_ENCODING, HTTP.CHUNK_CODING);
            } else {
                z = true;
            }
            if (a2.m5689a(HTTP.CONTENT_TYPE) == null) {
                a.m5799a(HTTP.CONTENT_TYPE, "application/x-www-form-urlencoded");
            }
        }
        boolean z2 = z;
        if (a2.m5689a(HTTP.USER_AGENT) == null) {
            a.m5799a(HTTP.USER_AGENT, m5013c());
        }
        C2222s a4 = a.m5801a();
        C2217q c2217q = this.f3146a;
        if (!(C2113d.f3215b.m5110a(c2217q) == null || getUseCaches())) {
            c2217q = this.f3146a.m5785v().m5757a(null);
        }
        return new C2137g(c2217q, a4, z2, true, false, c2090g, null, c2145m, c2227u);
    }

    private String m5013c() {
        String property = System.getProperty("http.agent");
        return property != null ? property : "Java" + System.getProperty("java.version");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.squareup.okhttp.internal.http.C2137g m5014d() throws java.io.IOException {
        /*
        r5 = this;
        r5.m5012b();
        r0 = r5.f3148c;
        r0 = r0.m5228f();
        if (r0 == 0) goto L_0x000e;
    L_0x000b:
        r0 = r5.f3148c;
    L_0x000d:
        return r0;
    L_0x000e:
        r0 = 1;
        r0 = r5.m5011a(r0);
        if (r0 == 0) goto L_0x000e;
    L_0x0015:
        r0 = r5.f3148c;
        r1 = r0.m5230h();
        r0 = r5.f3148c;
        r2 = r0.m5237o();
        if (r2 != 0) goto L_0x002b;
    L_0x0023:
        r0 = r5.f3148c;
        r0.m5233k();
        r0 = r5.f3148c;
        goto L_0x000d;
    L_0x002b:
        r0 = r5.f3152i;
        r0 = r0 + 1;
        r5.f3152i = r0;
        r3 = 20;
        if (r0 <= r3) goto L_0x0050;
    L_0x0035:
        r0 = new java.net.ProtocolException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Too many follow-up requests: ";
        r1 = r1.append(r2);
        r2 = r5.f3152i;
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0050:
        r0 = r2.m5810a();
        r5.url = r0;
        r0 = r2.m5815e();
        r0 = r0.m5690b();
        r5.f3150g = r0;
        r0 = r5.f3148c;
        r0 = r0.m5226d();
        r3 = r2.m5814d();
        r4 = r5.method;
        r3 = r3.equals(r4);
        if (r3 != 0) goto L_0x0073;
    L_0x0072:
        r0 = 0;
    L_0x0073:
        if (r0 == 0) goto L_0x0083;
    L_0x0075:
        r3 = r0 instanceof com.squareup.okhttp.internal.http.C2145m;
        if (r3 != 0) goto L_0x0083;
    L_0x0079:
        r0 = new java.net.HttpRetryException;
        r1 = "Cannot retry streamed HTTP body";
        r2 = r5.responseCode;
        r0.<init>(r1, r2);
        throw r0;
    L_0x0083:
        r3 = r5.f3148c;
        r4 = r2.m5810a();
        r3 = r3.m5224b(r4);
        if (r3 != 0) goto L_0x0094;
    L_0x008f:
        r3 = r5.f3148c;
        r3.m5233k();
    L_0x0094:
        r3 = r5.f3148c;
        r3 = r3.m5235m();
        r2 = r2.m5814d();
        r0 = (com.squareup.okhttp.internal.http.C2145m) r0;
        r0 = r5.m5007a(r2, r3, r0, r1);
        r5.f3148c = r0;
        goto L_0x000e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.a.b.d():com.squareup.okhttp.internal.http.g");
    }

    private boolean m5011a(boolean z) throws IOException {
        IOException a;
        C2137g a2;
        try {
            this.f3148c.m5221a();
            this.f3154k = this.f3148c.m5232j();
            this.f3149d = this.f3148c.m5231i() != null ? this.f3148c.m5231i().m4973j() : null;
            if (z) {
                this.f3148c.m5236n();
            }
            return true;
        } catch (RequestException e) {
            a = e.m5134a();
            this.f3147b = a;
            throw a;
        } catch (RouteException e2) {
            a2 = this.f3148c.m5218a(e2);
            if (a2 != null) {
                this.f3148c = a2;
                return false;
            }
            a = e2.m5136a();
            this.f3147b = a;
            throw a;
        } catch (IOException e3) {
            a2 = this.f3148c.m5219a(e3);
            if (a2 != null) {
                this.f3148c = a2;
                return false;
            }
            this.f3147b = e3;
            throw e3;
        }
    }

    public final boolean usingProxy() {
        Proxy b;
        if (this.f3154k != null) {
            b = this.f3154k.m5876b();
        } else {
            b = this.f3146a.m5767d();
        }
        return (b == null || b.type() == Type.DIRECT) ? false : true;
    }

    public String getResponseMessage() throws IOException {
        return m5014d().m5230h().m5866d();
    }

    public final int getResponseCode() throws IOException {
        return m5014d().m5230h().m5865c();
    }

    public final void setRequestProperty(String str, String str2) {
        if (this.connected) {
            throw new IllegalStateException("Cannot set request property after connection is made");
        } else if (str == null) {
            throw new NullPointerException("field == null");
        } else if (str2 == null) {
            C2151i.m5320a().m5323a("Ignoring header " + str + " because its value was null.");
        } else if ("X-Android-Transports".equals(str) || "X-Android-Protocols".equals(str)) {
            m5010a(str2, false);
        } else {
            this.f3150g.m5684c(str, str2);
        }
    }

    public void setIfModifiedSince(long j) {
        super.setIfModifiedSince(j);
        if (this.ifModifiedSince != 0) {
            this.f3150g.m5684c(HttpHeaders.IF_MODIFIED_SINCE, C2132f.m5188a(new Date(this.ifModifiedSince)));
        } else {
            this.f3150g.m5682b(HttpHeaders.IF_MODIFIED_SINCE);
        }
    }

    public final void addRequestProperty(String str, String str2) {
        if (this.connected) {
            throw new IllegalStateException("Cannot add request property after connection is made");
        } else if (str == null) {
            throw new NullPointerException("field == null");
        } else if (str2 == null) {
            C2151i.m5320a().m5323a("Ignoring header " + str + " because its value was null.");
        } else if ("X-Android-Transports".equals(str) || "X-Android-Protocols".equals(str)) {
            m5010a(str2, true);
        } else {
            this.f3150g.m5680a(str, str2);
        }
    }

    private void m5010a(String str, boolean z) {
        List arrayList = new ArrayList();
        if (z) {
            arrayList.addAll(this.f3146a.m5781r());
        }
        String[] split = str.split(",", -1);
        int length = split.length;
        int i = 0;
        while (i < length) {
            try {
                arrayList.add(Protocol.m4866a(split[i]));
                i++;
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
        this.f3146a.m5759a(arrayList);
    }

    public void setRequestMethod(String str) throws ProtocolException {
        if (f3144e.contains(str)) {
            this.method = str;
            return;
        }
        throw new ProtocolException("Expected one of " + f3144e + " but was " + str);
    }

    public void setFixedLengthStreamingMode(int i) {
        setFixedLengthStreamingMode((long) i);
    }

    public void setFixedLengthStreamingMode(long j) {
        if (this.connected) {
            throw new IllegalStateException("Already connected");
        } else if (this.chunkLength > 0) {
            throw new IllegalStateException("Already in chunked mode");
        } else if (j < 0) {
            throw new IllegalArgumentException("contentLength < 0");
        } else {
            this.f3151h = j;
            this.fixedContentLength = (int) Math.min(j, 2147483647L);
        }
    }
}
