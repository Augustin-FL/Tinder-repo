package com.squareup.okhttp;

import com.squareup.okhttp.internal.http.C2130e;
import com.squareup.okhttp.internal.http.C2137g;
import com.squareup.okhttp.internal.http.C2139r;
import com.squareup.okhttp.internal.http.C2140i;
import com.squareup.okhttp.internal.http.C2148o;
import com.squareup.okhttp.internal.http.C2148o.C2147a;
import com.squareup.okhttp.internal.http.C2149p;
import com.squareup.okhttp.internal.http.RouteException;
import com.squareup.okhttp.internal.spdy.C2197m;
import com.squareup.okhttp.internal.spdy.C2197m.C2193a;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.util.List;

/* renamed from: com.squareup.okhttp.g */
public final class C2090g {
    private final C2092h f3113a;
    private final C2228w f3114b;
    private Socket f3115c;
    private boolean f3116d;
    private C2130e f3117e;
    private C2197m f3118f;
    private Protocol f3119g;
    private long f3120h;
    private C2207l f3121i;
    private int f3122j;
    private Object f3123k;

    public C2090g(C2092h c2092h, C2228w c2228w) {
        this.f3116d = false;
        this.f3119g = Protocol.HTTP_1_1;
        this.f3113a = c2092h;
        this.f3114b = c2228w;
    }

    void m4962a(Object obj) {
        if (!m4974k()) {
            synchronized (this.f3113a) {
                if (this.f3123k != null) {
                    throw new IllegalStateException("Connection already has an owner!");
                }
                this.f3123k = obj;
            }
        }
    }

    boolean m4963a() {
        boolean z;
        synchronized (this.f3113a) {
            if (this.f3123k == null) {
                z = false;
            } else {
                this.f3123k = null;
                z = true;
            }
        }
        return z;
    }

    void m4964b(Object obj) throws IOException {
        if (m4974k()) {
            throw new IllegalStateException();
        }
        synchronized (this.f3113a) {
            if (this.f3123k != obj) {
                return;
            }
            this.f3123k = null;
            this.f3115c.close();
        }
    }

    void m4959a(int i, int i2, int i3, C2222s c2222s, List<C2095i> list, boolean z) throws RouteException {
        if (this.f3116d) {
            throw new IllegalStateException("already connected");
        }
        C2147a a;
        C2148o c2148o = new C2148o(this, this.f3113a);
        if (this.f3114b.f3650a.m4871d() != null) {
            a = c2148o.m5303a(i, i2, i3, c2222s, this.f3114b, list, z);
        } else if (list.contains(C2095i.f3137c)) {
            a = c2148o.m5304a(i, i2, this.f3114b);
        } else {
            throw new RouteException(new UnknownServiceException("CLEARTEXT communication not supported: " + list));
        }
        this.f3115c = a.f3322b;
        this.f3121i = a.f3324d;
        this.f3119g = a.f3323c == null ? Protocol.HTTP_1_1 : a.f3323c;
        try {
            if (this.f3119g == Protocol.SPDY_3 || this.f3119g == Protocol.HTTP_2) {
                this.f3115c.setSoTimeout(0);
                this.f3118f = new C2193a(this.f3114b.f3650a.f3045b, true, this.f3115c).m5550a(this.f3119g).m5551a();
                this.f3118f.m5612e();
            } else {
                this.f3117e = new C2130e(this.f3113a, this, this.f3115c);
            }
            this.f3116d = true;
        } catch (IOException e) {
            throw new RouteException(e);
        }
    }

    void m4961a(C2217q c2217q, Object obj, C2222s c2222s) throws RouteException {
        m4962a(obj);
        if (!m4965b()) {
            C2222s c2222s2 = c2222s;
            m4959a(c2217q.m5756a(), c2217q.m5764b(), c2217q.m5766c(), c2222s2, this.f3114b.f3650a.m4875h(), c2217q.m5779p());
            if (m4974k()) {
                c2217q.m5776m().m4984b(this);
            }
            c2217q.m5780q().m5342b(m4966c());
        }
        m4958a(c2217q.m5764b(), c2217q.m5766c());
    }

    boolean m4965b() {
        return this.f3116d;
    }

    public C2228w m4966c() {
        return this.f3114b;
    }

    public Socket m4967d() {
        return this.f3115c;
    }

    boolean m4968e() {
        return (this.f3115c.isClosed() || this.f3115c.isInputShutdown() || this.f3115c.isOutputShutdown()) ? false : true;
    }

    boolean m4969f() {
        if (this.f3117e != null) {
            return this.f3117e.m5183f();
        }
        return true;
    }

    void m4970g() {
        if (this.f3118f != null) {
            throw new IllegalStateException("spdyConnection != null");
        }
        this.f3120h = System.nanoTime();
    }

    boolean m4971h() {
        return this.f3118f == null || this.f3118f.m5609b();
    }

    long m4972i() {
        return this.f3118f == null ? this.f3120h : this.f3118f.m5610c();
    }

    public C2207l m4973j() {
        return this.f3121i;
    }

    C2139r m4957a(C2137g c2137g) throws IOException {
        return this.f3118f != null ? new C2149p(c2137g, this.f3118f) : new C2140i(c2137g, this.f3117e);
    }

    boolean m4974k() {
        return this.f3118f != null;
    }

    public Protocol m4975l() {
        return this.f3119g;
    }

    void m4960a(Protocol protocol) {
        if (protocol == null) {
            throw new IllegalArgumentException("protocol == null");
        }
        this.f3119g = protocol;
    }

    void m4958a(int i, int i2) throws RouteException {
        if (!this.f3116d) {
            throw new IllegalStateException("setTimeouts - not connected");
        } else if (this.f3117e != null) {
            try {
                this.f3115c.setSoTimeout(i);
                this.f3117e.m5173a(i, i2);
            } catch (IOException e) {
                throw new RouteException(e);
            }
        }
    }

    void m4976m() {
        this.f3122j++;
    }

    int m4977n() {
        return this.f3122j;
    }

    public String toString() {
        return "Connection{" + this.f3114b.f3650a.f3045b + ":" + this.f3114b.f3650a.f3046c + ", proxy=" + this.f3114b.f3651b + " hostAddress=" + this.f3114b.f3652c.getAddress().getHostAddress() + " cipherSuite=" + (this.f3121i != null ? this.f3121i.m5673a() : "none") + " protocol=" + this.f3119g + '}';
    }
}
