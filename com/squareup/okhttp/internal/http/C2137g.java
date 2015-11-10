package com.squareup.okhttp.internal.http;

import com.facebook.appevents.AppEventsConstants;
import com.squareup.okhttp.C2067a;
import com.squareup.okhttp.C2079v;
import com.squareup.okhttp.C2088e;
import com.squareup.okhttp.C2090g;
import com.squareup.okhttp.C2210m;
import com.squareup.okhttp.C2210m.C2209a;
import com.squareup.okhttp.C2214o;
import com.squareup.okhttp.C2214o.C2135a;
import com.squareup.okhttp.C2217q;
import com.squareup.okhttp.C2222s;
import com.squareup.okhttp.C2222s.C2221a;
import com.squareup.okhttp.C2227u;
import com.squareup.okhttp.C2227u.C2226a;
import com.squareup.okhttp.C2228w;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.C2069e;
import com.squareup.okhttp.internal.C2113d;
import com.squareup.okhttp.internal.C2157k;
import com.squareup.okhttp.internal.C2158l;
import com.squareup.okhttp.internal.http.C2121c.C2120a;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.CookieHandler;
import java.net.ProtocolException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okio.C2071q;
import okio.C2076r;
import okio.C2201s;
import okio.C3332d;
import okio.C3333e;
import okio.C3334c;
import okio.C3337j;
import okio.C3342l;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;

/* renamed from: com.squareup.okhttp.internal.http.g */
public final class C2137g {
    private static final C2079v f3276d;
    final C2217q f3277a;
    long f3278b;
    public final boolean f3279c;
    private C2090g f3280e;
    private C2067a f3281f;
    private C2146n f3282g;
    private C2228w f3283h;
    private final C2227u f3284i;
    private C2139r f3285j;
    private boolean f3286k;
    private final C2222s f3287l;
    private C2222s f3288m;
    private C2227u f3289n;
    private C2227u f3290o;
    private C2071q f3291p;
    private C3332d f3292q;
    private final boolean f3293r;
    private final boolean f3294s;
    private C2074b f3295t;
    private C2121c f3296u;

    /* renamed from: com.squareup.okhttp.internal.http.g.1 */
    static class C21331 extends C2079v {
        C21331() {
        }

        public long m5191a() {
            return 0;
        }

        public C3333e m5192b() {
            return new C3334c();
        }
    }

    /* renamed from: com.squareup.okhttp.internal.http.g.2 */
    class C21342 implements C2076r {
        boolean f3267a;
        final /* synthetic */ C3333e f3268b;
        final /* synthetic */ C2074b f3269c;
        final /* synthetic */ C3332d f3270d;
        final /* synthetic */ C2137g f3271e;

        C21342(C2137g c2137g, C3333e c3333e, C2074b c2074b, C3332d c3332d) {
            this.f3271e = c2137g;
            this.f3268b = c3333e;
            this.f3269c = c2074b;
            this.f3270d = c3332d;
        }

        public long m5193a(C3334c c3334c, long j) throws IOException {
            try {
                long a = this.f3268b.m4901a(c3334c, j);
                if (a == -1) {
                    if (!this.f3267a) {
                        this.f3267a = true;
                        this.f3270d.close();
                    }
                    return -1;
                }
                c3334c.m10205a(this.f3270d.m10168c(), c3334c.m10210b() - a, a);
                this.f3270d.m10178w();
                return a;
            } catch (IOException e) {
                if (!this.f3267a) {
                    this.f3267a = true;
                    this.f3269c.m4895a();
                }
                throw e;
            }
        }

        public C2201s m5194a() {
            return this.f3268b.m4902a();
        }

        public void close() throws IOException {
            if (!(this.f3267a || C2157k.m5359a((C2076r) this, 100, TimeUnit.MILLISECONDS))) {
                this.f3267a = true;
                this.f3269c.m4895a();
            }
            this.f3268b.close();
        }
    }

    /* renamed from: com.squareup.okhttp.internal.http.g.a */
    class C2136a implements C2135a {
        final /* synthetic */ C2137g f3272a;
        private final int f3273b;
        private final C2222s f3274c;
        private int f3275d;

        C2136a(C2137g c2137g, int i, C2222s c2222s) {
            this.f3272a = c2137g;
            this.f3273b = i;
            this.f3274c = c2222s;
        }

        public C2090g m5195a() {
            return this.f3272a.f3280e;
        }

        public C2227u m5196a(C2222s c2222s) throws IOException {
            C2214o c2214o;
            this.f3275d++;
            if (this.f3273b > 0) {
                c2214o = (C2214o) this.f3272a.f3277a.m5783t().get(this.f3273b - 1);
                C2067a a = m5195a().m4966c().m5875a();
                if (!c2222s.m5810a().getHost().equals(a.m4868a()) || C2157k.m5347a(c2222s.m5810a()) != a.m4869b()) {
                    throw new IllegalStateException("network interceptor " + c2214o + " must retain the same host and port");
                } else if (this.f3275d > 1) {
                    throw new IllegalStateException("network interceptor " + c2214o + " must call proceed() exactly once");
                }
            }
            if (this.f3273b < this.f3272a.f3277a.m5783t().size()) {
                Object c2136a = new C2136a(this.f3272a, this.f3273b + 1, c2222s);
                c2214o = (C2214o) this.f3272a.f3277a.m5783t().get(this.f3273b);
                C2227u a2 = c2214o.m5739a(c2136a);
                if (c2136a.f3275d == 1) {
                    return a2;
                }
                throw new IllegalStateException("network interceptor " + c2214o + " must call proceed() exactly once");
            }
            this.f3272a.f3285j.m5246a(c2222s);
            this.f3272a.f3288m = c2222s;
            if (this.f3272a.m5225c() && c2222s.m5816f() != null) {
                C3332d a3 = C3342l.m10279a(this.f3272a.f3285j.m5242a(c2222s, c2222s.m5816f().m5822a()));
                c2222s.m5816f().m5823a(a3);
                a3.close();
            }
            C2227u c = this.f3272a.m5217t();
            int c2 = c.m5865c();
            if ((c2 != HttpStatus.SC_NO_CONTENT && c2 != HttpStatus.SC_RESET_CONTENT) || c.m5869g().m4905a() <= 0) {
                return c;
            }
            throw new ProtocolException("HTTP " + c2 + " had non-zero Content-Length: " + c.m5869g().m4905a());
        }
    }

    static {
        f3276d = new C21331();
    }

    public C2137g(C2217q c2217q, C2222s c2222s, boolean z, boolean z2, boolean z3, C2090g c2090g, C2146n c2146n, C2145m c2145m, C2227u c2227u) {
        this.f3278b = -1;
        this.f3277a = c2217q;
        this.f3287l = c2222s;
        this.f3279c = z;
        this.f3293r = z2;
        this.f3294s = z3;
        this.f3280e = c2090g;
        this.f3282g = c2146n;
        this.f3291p = c2145m;
        this.f3284i = c2227u;
        if (c2090g != null) {
            C2113d.f3215b.m5121b(c2090g, this);
            this.f3283h = c2090g.m4966c();
            return;
        }
        this.f3283h = null;
    }

    public void m5221a() throws RequestException, RouteException, IOException {
        if (this.f3296u == null) {
            if (this.f3285j != null) {
                throw new IllegalStateException();
            }
            C2222s a = m5201a(this.f3287l);
            C2069e a2 = C2113d.f3215b.m5110a(this.f3277a);
            C2227u a3 = a2 != null ? a2.m4882a(a) : null;
            this.f3296u = new C2120a(System.currentTimeMillis(), a, a3).m5146a();
            this.f3288m = this.f3296u.f3236a;
            this.f3289n = this.f3296u.f3237b;
            if (a2 != null) {
                a2.m4884a(this.f3296u);
            }
            if (a3 != null && this.f3289n == null) {
                C2157k.m5355a(a3.m5869g());
            }
            if (this.f3288m != null) {
                if (this.f3280e == null) {
                    m5213p();
                }
                this.f3285j = C2113d.f3215b.m5111a(this.f3280e, this);
                if (this.f3293r && m5225c() && this.f3291p == null) {
                    long a4 = C2142j.m5262a(a);
                    if (!this.f3279c) {
                        this.f3285j.m5246a(this.f3288m);
                        this.f3291p = this.f3285j.m5242a(this.f3288m, a4);
                        return;
                    } else if (a4 > 2147483647L) {
                        throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
                    } else if (a4 != -1) {
                        this.f3285j.m5246a(this.f3288m);
                        this.f3291p = new C2145m((int) a4);
                        return;
                    } else {
                        this.f3291p = new C2145m();
                        return;
                    }
                }
                return;
            }
            if (this.f3280e != null) {
                C2113d.f3215b.m5114a(this.f3277a.m5776m(), this.f3280e);
                this.f3280e = null;
            }
            if (this.f3289n != null) {
                this.f3290o = this.f3289n.m5870h().m5842a(this.f3287l).m5850c(C2137g.m5208b(this.f3284i)).m5848b(C2137g.m5208b(this.f3289n)).m5847a();
            } else {
                this.f3290o = new C2226a().m5842a(this.f3287l).m5850c(C2137g.m5208b(this.f3284i)).m5839a(Protocol.HTTP_1_1).m5838a((int) HttpStatus.SC_GATEWAY_TIMEOUT).m5845a("Unsatisfiable Request (only-if-cached)").m5844a(f3276d).m5847a();
            }
            this.f3290o = m5212c(this.f3290o);
        }
    }

    private static C2227u m5208b(C2227u c2227u) {
        return (c2227u == null || c2227u.m5869g() == null) ? c2227u : c2227u.m5870h().m5844a(null).m5847a();
    }

    private void m5213p() throws RequestException, RouteException {
        if (this.f3280e != null) {
            throw new IllegalStateException();
        }
        if (this.f3282g == null) {
            this.f3281f = C2137g.m5197a(this.f3277a, this.f3288m);
            try {
                this.f3282g = C2146n.m5287a(this.f3281f, this.f3288m, this.f3277a);
            } catch (IOException e) {
                throw new RequestException(e);
            }
        }
        this.f3280e = m5214q();
        this.f3283h = this.f3280e.m4966c();
    }

    private C2090g m5214q() throws RouteException {
        C2090g r = m5215r();
        C2113d.f3215b.m5117a(this.f3277a, r, this, this.f3288m);
        return r;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.squareup.okhttp.C2090g m5215r() throws com.squareup.okhttp.internal.http.RouteException {
        /*
        r4 = this;
        r0 = r4.f3277a;
        r1 = r0.m5776m();
    L_0x0006:
        r0 = r4.f3281f;
        r0 = r1.m4982a(r0);
        if (r0 == 0) goto L_0x002d;
    L_0x000e:
        r2 = r4.f3288m;
        r2 = r2.m5814d();
        r3 = "GET";
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0024;
    L_0x001c:
        r2 = com.squareup.okhttp.internal.C2113d.f3215b;
        r2 = r2.m5123c(r0);
        if (r2 == 0) goto L_0x0025;
    L_0x0024:
        return r0;
    L_0x0025:
        r0 = r0.m4967d();
        com.squareup.okhttp.internal.C2157k.m5357a(r0);
        goto L_0x0006;
    L_0x002d:
        r0 = r4.f3282g;	 Catch:{ IOException -> 0x0039 }
        r2 = r0.m5299b();	 Catch:{ IOException -> 0x0039 }
        r0 = new com.squareup.okhttp.g;	 Catch:{ IOException -> 0x0039 }
        r0.<init>(r1, r2);	 Catch:{ IOException -> 0x0039 }
        goto L_0x0024;
    L_0x0039:
        r0 = move-exception;
        r1 = new com.squareup.okhttp.internal.http.RouteException;
        r1.<init>(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.http.g.r():com.squareup.okhttp.g");
    }

    public void m5223b() {
        if (this.f3278b != -1) {
            throw new IllegalStateException();
        }
        this.f3278b = System.currentTimeMillis();
    }

    boolean m5225c() {
        return C2138h.m5240c(this.f3287l.m5814d());
    }

    public C2071q m5226d() {
        if (this.f3296u != null) {
            return this.f3291p;
        }
        throw new IllegalStateException();
    }

    public C3332d m5227e() {
        C3332d c3332d = this.f3292q;
        if (c3332d != null) {
            return c3332d;
        }
        C2071q d = m5226d();
        if (d == null) {
            return null;
        }
        c3332d = C3342l.m10279a(d);
        this.f3292q = c3332d;
        return c3332d;
    }

    public boolean m5228f() {
        return this.f3290o != null;
    }

    public C2222s m5229g() {
        return this.f3287l;
    }

    public C2227u m5230h() {
        if (this.f3290o != null) {
            return this.f3290o;
        }
        throw new IllegalStateException();
    }

    public C2090g m5231i() {
        return this.f3280e;
    }

    public C2137g m5218a(RouteException routeException) {
        if (!(this.f3282g == null || this.f3280e == null)) {
            m5204a(this.f3282g, routeException.m5136a());
        }
        if ((this.f3282g == null && this.f3280e == null) || ((this.f3282g != null && !this.f3282g.m5298a()) || !m5209b(routeException))) {
            return null;
        }
        return new C2137g(this.f3277a, this.f3287l, this.f3279c, this.f3293r, this.f3294s, m5235m(), this.f3282g, (C2145m) this.f3291p, this.f3284i);
    }

    private boolean m5209b(RouteException routeException) {
        if (!this.f3277a.m5779p()) {
            return false;
        }
        IOException a = routeException.m5136a();
        if ((a instanceof ProtocolException) || (a instanceof InterruptedIOException)) {
            return false;
        }
        if (((a instanceof SSLHandshakeException) && (a.getCause() instanceof CertificateException)) || (a instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return true;
    }

    public C2137g m5220a(IOException iOException, C2071q c2071q) {
        if (!(this.f3282g == null || this.f3280e == null)) {
            m5204a(this.f3282g, iOException);
        }
        Object obj = (c2071q == null || (c2071q instanceof C2145m)) ? 1 : null;
        if ((this.f3282g == null && this.f3280e == null) || ((this.f3282g != null && !this.f3282g.m5298a()) || !m5210b(iOException) || obj == null)) {
            return null;
        }
        return new C2137g(this.f3277a, this.f3287l, this.f3279c, this.f3293r, this.f3294s, m5235m(), this.f3282g, (C2145m) c2071q, this.f3284i);
    }

    private void m5204a(C2146n c2146n, IOException iOException) {
        if (C2113d.f3215b.m5119b(this.f3280e) <= 0) {
            c2146n.m5297a(this.f3280e.m4966c(), iOException);
        }
    }

    public C2137g m5219a(IOException iOException) {
        return m5220a(iOException, this.f3291p);
    }

    private boolean m5210b(IOException iOException) {
        if (!this.f3277a.m5779p() || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        return true;
    }

    public C2228w m5232j() {
        return this.f3283h;
    }

    private void m5216s() throws IOException {
        C2069e a = C2113d.f3215b.m5110a(this.f3277a);
        if (a != null) {
            if (C2121c.m5147a(this.f3290o, this.f3288m)) {
                this.f3295t = a.m4881a(C2137g.m5208b(this.f3290o));
            } else if (C2138h.m5238a(this.f3288m.m5814d())) {
                try {
                    a.m4886b(this.f3288m);
                } catch (IOException e) {
                }
            }
        }
    }

    public void m5233k() throws IOException {
        if (!(this.f3285j == null || this.f3280e == null)) {
            this.f3285j.m5248c();
        }
        this.f3280e = null;
    }

    public void m5234l() {
        if (this.f3285j != null) {
            try {
                this.f3285j.m5244a(this);
            } catch (IOException e) {
            }
        }
    }

    public C2090g m5235m() {
        if (this.f3292q != null) {
            C2157k.m5355a(this.f3292q);
        } else if (this.f3291p != null) {
            C2157k.m5355a(this.f3291p);
        }
        if (this.f3290o == null) {
            if (this.f3280e != null) {
                C2157k.m5357a(this.f3280e.m4967d());
            }
            this.f3280e = null;
            return null;
        }
        C2157k.m5355a(this.f3290o.m5869g());
        if (this.f3285j == null || this.f3280e == null || this.f3285j.m5249d()) {
            if (!(this.f3280e == null || C2113d.f3215b.m5118a(this.f3280e))) {
                this.f3280e = null;
            }
            C2090g c2090g = this.f3280e;
            this.f3280e = null;
            return c2090g;
        }
        C2157k.m5357a(this.f3280e.m4967d());
        this.f3280e = null;
        return null;
    }

    private C2227u m5212c(C2227u c2227u) throws IOException {
        if (!this.f3286k || !"gzip".equalsIgnoreCase(this.f3290o.m5862a(HTTP.CONTENT_ENCODING)) || c2227u.m5869g() == null) {
            return c2227u;
        }
        C2076r c3337j = new C3337j(c2227u.m5869g().m4906b());
        C2210m a = c2227u.m5868f().m5690b().m5682b(HTTP.CONTENT_ENCODING).m5682b(HTTP.CONTENT_LEN).m5681a();
        return c2227u.m5870h().m5841a(a).m5844a(new C2143k(a, C3342l.m10280a(c3337j))).m5847a();
    }

    public static boolean m5205a(C2227u c2227u) {
        if (c2227u.m5861a().m5814d().equals("HEAD")) {
            return false;
        }
        int c = c2227u.m5865c();
        if ((c < 100 || c >= HttpStatus.SC_OK) && c != HttpStatus.SC_NO_CONTENT && c != HttpStatus.SC_NOT_MODIFIED) {
            return true;
        }
        if (C2142j.m5263a(c2227u) != -1 || HTTP.CHUNK_CODING.equalsIgnoreCase(c2227u.m5862a(HTTP.TRANSFER_ENCODING))) {
            return true;
        }
        return false;
    }

    private C2222s m5201a(C2222s c2222s) throws IOException {
        C2221a g = c2222s.m5817g();
        if (c2222s.m5809a(HTTP.TARGET_HOST) == null) {
            g.m5799a(HTTP.TARGET_HOST, C2137g.m5203a(c2222s.m5810a()));
        }
        if ((this.f3280e == null || this.f3280e.m4975l() != Protocol.HTTP_1_0) && c2222s.m5809a(HTTP.CONN_DIRECTIVE) == null) {
            g.m5799a(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        }
        if (c2222s.m5809a(HttpHeaders.ACCEPT_ENCODING) == null) {
            this.f3286k = true;
            g.m5799a(HttpHeaders.ACCEPT_ENCODING, "gzip");
        }
        CookieHandler f = this.f3277a.m5769f();
        if (f != null) {
            C2142j.m5268a(g, f.get(c2222s.m5811b(), C2142j.m5267a(g.m5801a().m5815e(), null)));
        }
        if (c2222s.m5809a(HTTP.USER_AGENT) == null) {
            g.m5799a(HTTP.USER_AGENT, C2158l.m5363a());
        }
        return g.m5801a();
    }

    public static String m5203a(URL url) {
        if (C2157k.m5347a(url) != C2157k.m5344a(url.getProtocol())) {
            return url.getHost() + ":" + url.getPort();
        }
        return url.getHost();
    }

    public void m5236n() throws IOException {
        if (this.f3290o == null) {
            if (this.f3288m == null && this.f3289n == null) {
                throw new IllegalStateException("call sendRequest() first!");
            } else if (this.f3288m != null) {
                C2227u t;
                if (this.f3294s) {
                    this.f3285j.m5246a(this.f3288m);
                    t = m5217t();
                } else if (this.f3293r) {
                    if (this.f3292q != null && this.f3292q.m10168c().m10210b() > 0) {
                        this.f3292q.m10172f();
                    }
                    if (this.f3278b == -1) {
                        if (C2142j.m5262a(this.f3288m) == -1 && (this.f3291p instanceof C2145m)) {
                            this.f3288m = this.f3288m.m5817g().m5799a(HTTP.CONTENT_LEN, Long.toString(((C2145m) this.f3291p).m5286b())).m5801a();
                        }
                        this.f3285j.m5246a(this.f3288m);
                    }
                    if (this.f3291p != null) {
                        if (this.f3292q != null) {
                            this.f3292q.close();
                        } else {
                            this.f3291p.close();
                        }
                        if (this.f3291p instanceof C2145m) {
                            this.f3285j.m5245a((C2145m) this.f3291p);
                        }
                    }
                    t = m5217t();
                } else {
                    t = new C2136a(this, 0, this.f3288m).m5196a(this.f3288m);
                }
                m5222a(t.m5868f());
                if (this.f3289n != null) {
                    if (C2137g.m5206a(this.f3289n, t)) {
                        this.f3290o = this.f3289n.m5870h().m5842a(this.f3287l).m5850c(C2137g.m5208b(this.f3284i)).m5841a(C2137g.m5199a(this.f3289n.m5868f(), t.m5868f())).m5848b(C2137g.m5208b(this.f3289n)).m5843a(C2137g.m5208b(t)).m5847a();
                        t.m5869g().close();
                        m5233k();
                        C2069e a = C2113d.f3215b.m5110a(this.f3277a);
                        a.m4883a();
                        a.m4885a(this.f3289n, C2137g.m5208b(this.f3290o));
                        this.f3290o = m5212c(this.f3290o);
                        return;
                    }
                    C2157k.m5355a(this.f3289n.m5869g());
                }
                this.f3290o = t.m5870h().m5842a(this.f3287l).m5850c(C2137g.m5208b(this.f3284i)).m5848b(C2137g.m5208b(this.f3289n)).m5843a(C2137g.m5208b(t)).m5847a();
                if (C2137g.m5205a(this.f3290o)) {
                    m5216s();
                    this.f3290o = m5212c(m5202a(this.f3295t, this.f3290o));
                }
            }
        }
    }

    private C2227u m5217t() throws IOException {
        this.f3285j.m5243a();
        C2227u a = this.f3285j.m5247b().m5842a(this.f3288m).m5840a(this.f3280e.m4973j()).m5846a(C2142j.f3300b, Long.toString(this.f3278b)).m5846a(C2142j.f3301c, Long.toString(System.currentTimeMillis())).m5847a();
        if (!this.f3294s) {
            a = a.m5870h().m5844a(this.f3285j.m5241a(a)).m5847a();
        }
        C2113d.f3215b.m5112a(this.f3280e, a.m5864b());
        return a;
    }

    private C2227u m5202a(C2074b c2074b, C2227u c2227u) throws IOException {
        if (c2074b == null) {
            return c2227u;
        }
        C2071q b = c2074b.m4896b();
        if (b == null) {
            return c2227u;
        }
        return c2227u.m5870h().m5844a(new C2143k(c2227u.m5868f(), C3342l.m10280a(new C21342(this, c2227u.m5869g().m4906b(), c2074b, C3342l.m10279a(b))))).m5847a();
    }

    private static boolean m5206a(C2227u c2227u, C2227u c2227u2) {
        if (c2227u2.m5865c() == HttpStatus.SC_NOT_MODIFIED) {
            return true;
        }
        Date b = c2227u.m5868f().m5692b(HttpHeaders.LAST_MODIFIED);
        if (b != null) {
            Date b2 = c2227u2.m5868f().m5692b(HttpHeaders.LAST_MODIFIED);
            if (b2 != null && b2.getTime() < b.getTime()) {
                return true;
            }
        }
        return false;
    }

    private static C2210m m5199a(C2210m c2210m, C2210m c2210m2) throws IOException {
        int i;
        int i2 = 0;
        C2209a c2209a = new C2209a();
        int a = c2210m.m5687a();
        for (i = 0; i < a; i++) {
            String a2 = c2210m.m5688a(i);
            String b = c2210m.m5691b(i);
            if (!(HttpHeaders.WARNING.equalsIgnoreCase(a2) && b.startsWith(AppEventsConstants.EVENT_PARAM_VALUE_YES)) && (!C2142j.m5270a(a2) || c2210m2.m5689a(a2) == null)) {
                c2209a.m5680a(a2, b);
            }
        }
        i = c2210m2.m5687a();
        while (i2 < i) {
            String a3 = c2210m2.m5688a(i2);
            if (!HTTP.CONTENT_LEN.equalsIgnoreCase(a3) && C2142j.m5270a(a3)) {
                c2209a.m5680a(a3, c2210m2.m5691b(i2));
            }
            i2++;
        }
        return c2209a.m5681a();
    }

    public void m5222a(C2210m c2210m) throws IOException {
        CookieHandler f = this.f3277a.m5769f();
        if (f != null) {
            f.put(this.f3287l.m5811b(), C2142j.m5267a(c2210m, null));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.squareup.okhttp.C2222s m5237o() throws java.io.IOException {
        /*
        r4 = this;
        r1 = 0;
        r0 = r4.f3290o;
        if (r0 != 0) goto L_0x000b;
    L_0x0005:
        r0 = new java.lang.IllegalStateException;
        r0.<init>();
        throw r0;
    L_0x000b:
        r0 = r4.m5232j();
        if (r0 == 0) goto L_0x0024;
    L_0x0011:
        r0 = r4.m5232j();
        r0 = r0.m5876b();
    L_0x0019:
        r2 = r4.f3290o;
        r2 = r2.m5865c();
        switch(r2) {
            case 300: goto L_0x0066;
            case 301: goto L_0x0066;
            case 302: goto L_0x0066;
            case 303: goto L_0x0066;
            case 307: goto L_0x0048;
            case 308: goto L_0x0048;
            case 401: goto L_0x003b;
            case 407: goto L_0x002b;
            default: goto L_0x0022;
        };
    L_0x0022:
        r0 = r1;
    L_0x0023:
        return r0;
    L_0x0024:
        r0 = r4.f3277a;
        r0 = r0.m5767d();
        goto L_0x0019;
    L_0x002b:
        r1 = r0.type();
        r2 = java.net.Proxy.Type.HTTP;
        if (r1 == r2) goto L_0x003b;
    L_0x0033:
        r0 = new java.net.ProtocolException;
        r1 = "Received HTTP_PROXY_AUTH (407) code while not using proxy";
        r0.<init>(r1);
        throw r0;
    L_0x003b:
        r1 = r4.f3277a;
        r1 = r1.m5775l();
        r2 = r4.f3290o;
        r0 = com.squareup.okhttp.internal.http.C2142j.m5265a(r1, r2, r0);
        goto L_0x0023;
    L_0x0048:
        r0 = r4.f3287l;
        r0 = r0.m5814d();
        r2 = "GET";
        r0 = r0.equals(r2);
        if (r0 != 0) goto L_0x0066;
    L_0x0056:
        r0 = r4.f3287l;
        r0 = r0.m5814d();
        r2 = "HEAD";
        r0 = r0.equals(r2);
        if (r0 != 0) goto L_0x0066;
    L_0x0064:
        r0 = r1;
        goto L_0x0023;
    L_0x0066:
        r0 = r4.f3277a;
        r0 = r0.m5778o();
        if (r0 != 0) goto L_0x0070;
    L_0x006e:
        r0 = r1;
        goto L_0x0023;
    L_0x0070:
        r0 = r4.f3290o;
        r2 = "Location";
        r0 = r0.m5862a(r2);
        if (r0 != 0) goto L_0x007c;
    L_0x007a:
        r0 = r1;
        goto L_0x0023;
    L_0x007c:
        r2 = new java.net.URL;
        r3 = r4.f3287l;
        r3 = r3.m5810a();
        r2.<init>(r3, r0);
        r0 = r2.getProtocol();
        r3 = "https";
        r0 = r0.equals(r3);
        if (r0 != 0) goto L_0x00a1;
    L_0x0093:
        r0 = r2.getProtocol();
        r3 = "http";
        r0 = r0.equals(r3);
        if (r0 != 0) goto L_0x00a1;
    L_0x009f:
        r0 = r1;
        goto L_0x0023;
    L_0x00a1:
        r0 = r2.getProtocol();
        r3 = r4.f3287l;
        r3 = r3.m5810a();
        r3 = r3.getProtocol();
        r0 = r0.equals(r3);
        if (r0 != 0) goto L_0x00c0;
    L_0x00b5:
        r0 = r4.f3277a;
        r0 = r0.m5777n();
        if (r0 != 0) goto L_0x00c0;
    L_0x00bd:
        r0 = r1;
        goto L_0x0023;
    L_0x00c0:
        r0 = r4.f3287l;
        r0 = r0.m5817g();
        r3 = r4.f3287l;
        r3 = r3.m5814d();
        r3 = com.squareup.okhttp.internal.http.C2138h.m5240c(r3);
        if (r3 == 0) goto L_0x00e6;
    L_0x00d2:
        r3 = "GET";
        r0.m5798a(r3, r1);
        r1 = "Transfer-Encoding";
        r0.m5802b(r1);
        r1 = "Content-Length";
        r0.m5802b(r1);
        r1 = "Content-Type";
        r0.m5802b(r1);
    L_0x00e6:
        r1 = r4.m5224b(r2);
        if (r1 != 0) goto L_0x00f1;
    L_0x00ec:
        r1 = "Authorization";
        r0.m5802b(r1);
    L_0x00f1:
        r0 = r0.m5800a(r2);
        r0 = r0.m5801a();
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.http.g.o():com.squareup.okhttp.s");
    }

    public boolean m5224b(URL url) {
        URL a = this.f3287l.m5810a();
        return a.getHost().equals(url.getHost()) && C2157k.m5347a(a) == C2157k.m5347a(url) && a.getProtocol().equals(url.getProtocol());
    }

    private static C2067a m5197a(C2217q c2217q, C2222s c2222s) throws RequestException {
        C2088e c2088e = null;
        String host = c2222s.m5810a().getHost();
        if (host == null || host.length() == 0) {
            throw new RequestException(new UnknownHostException(c2222s.m5810a().toString()));
        }
        SSLSocketFactory i;
        HostnameVerifier j;
        if (c2222s.m5819i()) {
            i = c2217q.m5772i();
            j = c2217q.m5773j();
            c2088e = c2217q.m5774k();
        } else {
            j = null;
            i = null;
        }
        return new C2067a(host, C2157k.m5347a(c2222s.m5810a()), c2217q.m5771h(), i, j, c2088e, c2217q.m5775l(), c2217q.m5767d(), c2217q.m5781r(), c2217q.m5782s(), c2217q.m5768e());
    }
}
