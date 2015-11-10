package com.squareup.okhttp;

import com.squareup.okhttp.C2210m.C2209a;
import com.squareup.okhttp.internal.C2069e;
import com.squareup.okhttp.internal.C2113d;
import com.squareup.okhttp.internal.C2115g;
import com.squareup.okhttp.internal.C2155j;
import com.squareup.okhttp.internal.C2157k;
import com.squareup.okhttp.internal.http.C2118a;
import com.squareup.okhttp.internal.http.C2137g;
import com.squareup.okhttp.internal.http.C2139r;
import com.squareup.okhttp.internal.http.RouteException;
import com.squareup.okhttp.internal.p028c.C2112b;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: com.squareup.okhttp.q */
public class C2217q implements Cloneable {
    private static final List<Protocol> f3582a;
    private static final List<C2095i> f3583b;
    private static SSLSocketFactory f3584c;
    private int f3585A;
    private final C2155j f3586d;
    private C2206k f3587e;
    private Proxy f3588f;
    private List<Protocol> f3589g;
    private List<C2095i> f3590h;
    private final List<C2214o> f3591i;
    private final List<C2214o> f3592j;
    private ProxySelector f3593k;
    private CookieHandler f3594l;
    private C2069e f3595m;
    private C2082c f3596n;
    private SocketFactory f3597o;
    private SSLSocketFactory f3598p;
    private HostnameVerifier f3599q;
    private C2088e f3600r;
    private C2068b f3601s;
    private C2092h f3602t;
    private C2115g f3603u;
    private boolean f3604v;
    private boolean f3605w;
    private boolean f3606x;
    private int f3607y;
    private int f3608z;

    /* renamed from: com.squareup.okhttp.q.1 */
    static class C22161 extends C2113d {
        C22161() {
        }

        public C2139r m5741a(C2090g c2090g, C2137g c2137g) throws IOException {
            return c2090g.m4957a(c2137g);
        }

        public boolean m5748a(C2090g c2090g) {
            return c2090g.m4963a();
        }

        public void m5743a(C2090g c2090g, Object obj) throws IOException {
            c2090g.m4964b(obj);
        }

        public int m5749b(C2090g c2090g) {
            return c2090g.m4977n();
        }

        public void m5742a(C2090g c2090g, Protocol protocol) {
            c2090g.m4960a(protocol);
        }

        public void m5751b(C2090g c2090g, C2137g c2137g) {
            c2090g.m4962a((Object) c2137g);
        }

        public boolean m5753c(C2090g c2090g) {
            return c2090g.m4969f();
        }

        public void m5746a(C2209a c2209a, String str) {
            c2209a.m5679a(str);
        }

        public C2069e m5740a(C2217q c2217q) {
            return c2217q.m5770g();
        }

        public void m5744a(C2092h c2092h, C2090g c2090g) {
            c2092h.m4983a(c2090g);
        }

        public C2155j m5750b(C2217q c2217q) {
            return c2217q.m5780q();
        }

        public C2115g m5752c(C2217q c2217q) {
            return c2217q.f3603u;
        }

        public void m5747a(C2217q c2217q, C2090g c2090g, C2137g c2137g, C2222s c2222s) throws RouteException {
            c2090g.m4961a(c2217q, c2137g, c2222s);
        }

        public void m5745a(C2095i c2095i, SSLSocket sSLSocket, boolean z) {
            c2095i.m5002a(sSLSocket, z);
        }
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m5785v();
    }

    static {
        f3582a = C2157k.m5349a(Protocol.HTTP_2, Protocol.SPDY_3, Protocol.HTTP_1_1);
        f3583b = C2157k.m5349a(C2095i.f3135a, C2095i.f3136b, C2095i.f3137c);
        C2113d.f3215b = new C22161();
    }

    public C2217q() {
        this.f3591i = new ArrayList();
        this.f3592j = new ArrayList();
        this.f3604v = true;
        this.f3605w = true;
        this.f3606x = true;
        this.f3586d = new C2155j();
        this.f3587e = new C2206k();
    }

    private C2217q(C2217q c2217q) {
        this.f3591i = new ArrayList();
        this.f3592j = new ArrayList();
        this.f3604v = true;
        this.f3605w = true;
        this.f3606x = true;
        this.f3586d = c2217q.f3586d;
        this.f3587e = c2217q.f3587e;
        this.f3588f = c2217q.f3588f;
        this.f3589g = c2217q.f3589g;
        this.f3590h = c2217q.f3590h;
        this.f3591i.addAll(c2217q.f3591i);
        this.f3592j.addAll(c2217q.f3592j);
        this.f3593k = c2217q.f3593k;
        this.f3594l = c2217q.f3594l;
        this.f3596n = c2217q.f3596n;
        this.f3595m = this.f3596n != null ? this.f3596n.f3080a : c2217q.f3595m;
        this.f3597o = c2217q.f3597o;
        this.f3598p = c2217q.f3598p;
        this.f3599q = c2217q.f3599q;
        this.f3600r = c2217q.f3600r;
        this.f3601s = c2217q.f3601s;
        this.f3602t = c2217q.f3602t;
        this.f3603u = c2217q.f3603u;
        this.f3604v = c2217q.f3604v;
        this.f3605w = c2217q.f3605w;
        this.f3606x = c2217q.f3606x;
        this.f3607y = c2217q.f3607y;
        this.f3608z = c2217q.f3608z;
        this.f3585A = c2217q.f3585A;
    }

    public void m5762a(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0");
        } else if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        } else {
            long toMillis = timeUnit.toMillis(j);
            if (toMillis > 2147483647L) {
                throw new IllegalArgumentException("Timeout too large.");
            } else if (toMillis != 0 || j <= 0) {
                this.f3607y = (int) toMillis;
            } else {
                throw new IllegalArgumentException("Timeout too small.");
            }
        }
    }

    public int m5756a() {
        return this.f3607y;
    }

    public void m5765b(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0");
        } else if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        } else {
            long toMillis = timeUnit.toMillis(j);
            if (toMillis > 2147483647L) {
                throw new IllegalArgumentException("Timeout too large.");
            } else if (toMillis != 0 || j <= 0) {
                this.f3608z = (int) toMillis;
            } else {
                throw new IllegalArgumentException("Timeout too small.");
            }
        }
    }

    public int m5764b() {
        return this.f3608z;
    }

    public int m5766c() {
        return this.f3585A;
    }

    public C2217q m5758a(Proxy proxy) {
        this.f3588f = proxy;
        return this;
    }

    public Proxy m5767d() {
        return this.f3588f;
    }

    public ProxySelector m5768e() {
        return this.f3593k;
    }

    public CookieHandler m5769f() {
        return this.f3594l;
    }

    C2069e m5770g() {
        return this.f3595m;
    }

    public C2217q m5757a(C2082c c2082c) {
        this.f3596n = c2082c;
        this.f3595m = null;
        return this;
    }

    public SocketFactory m5771h() {
        return this.f3597o;
    }

    public C2217q m5761a(SSLSocketFactory sSLSocketFactory) {
        this.f3598p = sSLSocketFactory;
        return this;
    }

    public SSLSocketFactory m5772i() {
        return this.f3598p;
    }

    public C2217q m5760a(HostnameVerifier hostnameVerifier) {
        this.f3599q = hostnameVerifier;
        return this;
    }

    public HostnameVerifier m5773j() {
        return this.f3599q;
    }

    public C2088e m5774k() {
        return this.f3600r;
    }

    public C2068b m5775l() {
        return this.f3601s;
    }

    public C2092h m5776m() {
        return this.f3602t;
    }

    public boolean m5777n() {
        return this.f3604v;
    }

    public void m5763a(boolean z) {
        this.f3605w = z;
    }

    public boolean m5778o() {
        return this.f3605w;
    }

    public boolean m5779p() {
        return this.f3606x;
    }

    C2155j m5780q() {
        return this.f3586d;
    }

    public C2217q m5759a(List<Protocol> list) {
        List a = C2157k.m5348a((List) list);
        if (!a.contains(Protocol.HTTP_1_1)) {
            throw new IllegalArgumentException("protocols doesn't contain http/1.1: " + a);
        } else if (a.contains(Protocol.HTTP_1_0)) {
            throw new IllegalArgumentException("protocols must not contain http/1.0: " + a);
        } else if (a.contains(null)) {
            throw new IllegalArgumentException("protocols must not contain null");
        } else {
            this.f3589g = C2157k.m5348a(a);
            return this;
        }
    }

    public List<Protocol> m5781r() {
        return this.f3589g;
    }

    public List<C2095i> m5782s() {
        return this.f3590h;
    }

    public List<C2214o> m5783t() {
        return this.f3592j;
    }

    C2217q m5784u() {
        C2217q c2217q = new C2217q(this);
        if (c2217q.f3593k == null) {
            c2217q.f3593k = ProxySelector.getDefault();
        }
        if (c2217q.f3594l == null) {
            c2217q.f3594l = CookieHandler.getDefault();
        }
        if (c2217q.f3597o == null) {
            c2217q.f3597o = SocketFactory.getDefault();
        }
        if (c2217q.f3598p == null) {
            c2217q.f3598p = m5755w();
        }
        if (c2217q.f3599q == null) {
            c2217q.f3599q = C2112b.f3212a;
        }
        if (c2217q.f3600r == null) {
            c2217q.f3600r = C2088e.f3109a;
        }
        if (c2217q.f3601s == null) {
            c2217q.f3601s = C2118a.f3223a;
        }
        if (c2217q.f3602t == null) {
            c2217q.f3602t = C2092h.m4978a();
        }
        if (c2217q.f3589g == null) {
            c2217q.f3589g = f3582a;
        }
        if (c2217q.f3590h == null) {
            c2217q.f3590h = f3583b;
        }
        if (c2217q.f3603u == null) {
            c2217q.f3603u = C2115g.f3217a;
        }
        return c2217q;
    }

    private synchronized SSLSocketFactory m5755w() {
        if (f3584c == null) {
            try {
                SSLContext instance = SSLContext.getInstance("TLS");
                instance.init(null, null, null);
                f3584c = instance.getSocketFactory();
            } catch (GeneralSecurityException e) {
                throw new AssertionError();
            }
        }
        return f3584c;
    }

    public C2217q m5785v() {
        return new C2217q(this);
    }
}
