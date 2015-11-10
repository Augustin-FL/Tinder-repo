package com.squareup.okhttp;

import com.squareup.okhttp.C2210m.C2209a;
import com.squareup.okhttp.internal.http.C2138h;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.List;

/* renamed from: com.squareup.okhttp.s */
public final class C2222s {
    private final C2213n f3617a;
    private final String f3618b;
    private final C2210m f3619c;
    private final C2223t f3620d;
    private final Object f3621e;
    private volatile URL f3622f;
    private volatile URI f3623g;
    private volatile C2085d f3624h;

    /* renamed from: com.squareup.okhttp.s.a */
    public static class C2221a {
        private C2213n f3612a;
        private String f3613b;
        private C2209a f3614c;
        private C2223t f3615d;
        private Object f3616e;

        public C2221a() {
            this.f3613b = "GET";
            this.f3614c = new C2209a();
        }

        private C2221a(C2222s c2222s) {
            this.f3612a = c2222s.f3617a;
            this.f3613b = c2222s.f3618b;
            this.f3615d = c2222s.f3620d;
            this.f3616e = c2222s.f3621e;
            this.f3614c = c2222s.f3619c.m5690b();
        }

        public C2221a m5796a(C2213n c2213n) {
            if (c2213n == null) {
                throw new IllegalArgumentException("url == null");
            }
            this.f3612a = c2213n;
            return this;
        }

        public C2221a m5797a(String str) {
            if (str == null) {
                throw new IllegalArgumentException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else {
                if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    str = "https:" + str.substring(4);
                }
            }
            C2213n c = C2213n.m5730c(str);
            if (c != null) {
                return m5796a(c);
            }
            throw new IllegalArgumentException("unexpected url: " + str);
        }

        public C2221a m5800a(URL url) {
            if (url == null) {
                throw new IllegalArgumentException("url == null");
            }
            C2213n a = C2213n.m5716a(url);
            if (a != null) {
                return m5796a(a);
            }
            throw new IllegalArgumentException("unexpected url: " + url);
        }

        public C2221a m5799a(String str, String str2) {
            this.f3614c.m5684c(str, str2);
            return this;
        }

        public C2221a m5803b(String str, String str2) {
            this.f3614c.m5680a(str, str2);
            return this;
        }

        public C2221a m5802b(String str) {
            this.f3614c.m5682b(str);
            return this;
        }

        public C2221a m5795a(C2210m c2210m) {
            this.f3614c = c2210m.m5690b();
            return this;
        }

        public C2221a m5798a(String str, C2223t c2223t) {
            if (str == null || str.length() == 0) {
                throw new IllegalArgumentException("method == null || method.length() == 0");
            } else if (c2223t != null && !C2138h.m5240c(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            } else if (c2223t == null && C2138h.m5239b(str)) {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            } else {
                this.f3613b = str;
                this.f3615d = c2223t;
                return this;
            }
        }

        public C2222s m5801a() {
            if (this.f3612a != null) {
                return new C2222s();
            }
            throw new IllegalStateException("url == null");
        }
    }

    private C2222s(C2221a c2221a) {
        Object e;
        this.f3617a = c2221a.f3612a;
        this.f3618b = c2221a.f3613b;
        this.f3619c = c2221a.f3614c.m5681a();
        this.f3620d = c2221a.f3615d;
        if (c2221a.f3616e != null) {
            e = c2221a.f3616e;
        } else {
            C2222s c2222s = this;
        }
        this.f3621e = e;
    }

    public URL m5810a() {
        URL url = this.f3622f;
        if (url != null) {
            return url;
        }
        url = this.f3617a.m5732a();
        this.f3622f = url;
        return url;
    }

    public URI m5811b() throws IOException {
        try {
            URI uri = this.f3623g;
            if (uri == null) {
                uri = this.f3617a.m5733b();
                this.f3623g = uri;
            }
            return uri;
        } catch (IllegalStateException e) {
            throw new IOException(e.getMessage());
        }
    }

    public String m5813c() {
        return this.f3617a.toString();
    }

    public String m5814d() {
        return this.f3618b;
    }

    public C2210m m5815e() {
        return this.f3619c;
    }

    public String m5809a(String str) {
        return this.f3619c.m5689a(str);
    }

    public List<String> m5812b(String str) {
        return this.f3619c.m5693c(str);
    }

    public C2223t m5816f() {
        return this.f3620d;
    }

    public C2221a m5817g() {
        return new C2221a();
    }

    public C2085d m5818h() {
        C2085d c2085d = this.f3624h;
        if (c2085d != null) {
            return c2085d;
        }
        c2085d = C2085d.m4938a(this.f3619c);
        this.f3624h = c2085d;
        return c2085d;
    }

    public boolean m5819i() {
        return this.f3617a.m5734c();
    }

    public String toString() {
        return "Request{method=" + this.f3618b + ", url=" + this.f3617a + ", tag=" + (this.f3621e != this ? this.f3621e : null) + '}';
    }
}
