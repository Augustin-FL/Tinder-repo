package com.squareup.okhttp;

import com.squareup.okhttp.C2210m.C2209a;
import com.squareup.okhttp.internal.http.C2142j;
import java.util.Collections;
import java.util.List;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;

/* renamed from: com.squareup.okhttp.u */
public final class C2227u {
    private final C2222s f3639a;
    private final Protocol f3640b;
    private final int f3641c;
    private final String f3642d;
    private final C2207l f3643e;
    private final C2210m f3644f;
    private final C2079v f3645g;
    private C2227u f3646h;
    private C2227u f3647i;
    private final C2227u f3648j;
    private volatile C2085d f3649k;

    /* renamed from: com.squareup.okhttp.u.a */
    public static class C2226a {
        private C2222s f3629a;
        private Protocol f3630b;
        private int f3631c;
        private String f3632d;
        private C2207l f3633e;
        private C2209a f3634f;
        private C2079v f3635g;
        private C2227u f3636h;
        private C2227u f3637i;
        private C2227u f3638j;

        public C2226a() {
            this.f3631c = -1;
            this.f3634f = new C2209a();
        }

        private C2226a(C2227u c2227u) {
            this.f3631c = -1;
            this.f3629a = c2227u.f3639a;
            this.f3630b = c2227u.f3640b;
            this.f3631c = c2227u.f3641c;
            this.f3632d = c2227u.f3642d;
            this.f3633e = c2227u.f3643e;
            this.f3634f = c2227u.f3644f.m5690b();
            this.f3635g = c2227u.f3645g;
            this.f3636h = c2227u.f3646h;
            this.f3637i = c2227u.f3647i;
            this.f3638j = c2227u.f3648j;
        }

        public C2226a m5842a(C2222s c2222s) {
            this.f3629a = c2222s;
            return this;
        }

        public C2226a m5839a(Protocol protocol) {
            this.f3630b = protocol;
            return this;
        }

        public C2226a m5838a(int i) {
            this.f3631c = i;
            return this;
        }

        public C2226a m5845a(String str) {
            this.f3632d = str;
            return this;
        }

        public C2226a m5840a(C2207l c2207l) {
            this.f3633e = c2207l;
            return this;
        }

        public C2226a m5846a(String str, String str2) {
            this.f3634f.m5684c(str, str2);
            return this;
        }

        public C2226a m5849b(String str, String str2) {
            this.f3634f.m5680a(str, str2);
            return this;
        }

        public C2226a m5841a(C2210m c2210m) {
            this.f3634f = c2210m.m5690b();
            return this;
        }

        public C2226a m5844a(C2079v c2079v) {
            this.f3635g = c2079v;
            return this;
        }

        public C2226a m5843a(C2227u c2227u) {
            if (c2227u != null) {
                m5827a("networkResponse", c2227u);
            }
            this.f3636h = c2227u;
            return this;
        }

        public C2226a m5848b(C2227u c2227u) {
            if (c2227u != null) {
                m5827a("cacheResponse", c2227u);
            }
            this.f3637i = c2227u;
            return this;
        }

        private void m5827a(String str, C2227u c2227u) {
            if (c2227u.f3645g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            } else if (c2227u.f3646h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            } else if (c2227u.f3647i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            } else if (c2227u.f3648j != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        public C2226a m5850c(C2227u c2227u) {
            if (c2227u != null) {
                m5831d(c2227u);
            }
            this.f3638j = c2227u;
            return this;
        }

        private void m5831d(C2227u c2227u) {
            if (c2227u.f3645g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public C2227u m5847a() {
            if (this.f3629a == null) {
                throw new IllegalStateException("request == null");
            } else if (this.f3630b == null) {
                throw new IllegalStateException("protocol == null");
            } else if (this.f3631c >= 0) {
                return new C2227u();
            } else {
                throw new IllegalStateException("code < 0: " + this.f3631c);
            }
        }
    }

    private C2227u(C2226a c2226a) {
        this.f3639a = c2226a.f3629a;
        this.f3640b = c2226a.f3630b;
        this.f3641c = c2226a.f3631c;
        this.f3642d = c2226a.f3632d;
        this.f3643e = c2226a.f3633e;
        this.f3644f = c2226a.f3634f.m5681a();
        this.f3645g = c2226a.f3635g;
        this.f3646h = c2226a.f3636h;
        this.f3647i = c2226a.f3637i;
        this.f3648j = c2226a.f3638j;
    }

    public C2222s m5861a() {
        return this.f3639a;
    }

    public Protocol m5864b() {
        return this.f3640b;
    }

    public int m5865c() {
        return this.f3641c;
    }

    public String m5866d() {
        return this.f3642d;
    }

    public C2207l m5867e() {
        return this.f3643e;
    }

    public String m5862a(String str) {
        return m5863a(str, null);
    }

    public String m5863a(String str, String str2) {
        String a = this.f3644f.m5689a(str);
        return a != null ? a : str2;
    }

    public C2210m m5868f() {
        return this.f3644f;
    }

    public C2079v m5869g() {
        return this.f3645g;
    }

    public C2226a m5870h() {
        return new C2226a();
    }

    public C2227u m5871i() {
        return this.f3646h;
    }

    public C2227u m5872j() {
        return this.f3647i;
    }

    public List<C2089f> m5873k() {
        String str;
        if (this.f3641c == HttpStatus.SC_UNAUTHORIZED) {
            str = HttpHeaders.WWW_AUTHENTICATE;
        } else if (this.f3641c != HttpStatus.SC_PROXY_AUTHENTICATION_REQUIRED) {
            return Collections.emptyList();
        } else {
            str = HttpHeaders.PROXY_AUTHENTICATE;
        }
        return C2142j.m5272b(m5868f(), str);
    }

    public C2085d m5874l() {
        C2085d c2085d = this.f3649k;
        if (c2085d != null) {
            return c2085d;
        }
        c2085d = C2085d.m4938a(this.f3644f);
        this.f3649k = c2085d;
        return c2085d;
    }

    public String toString() {
        return "Response{protocol=" + this.f3640b + ", code=" + this.f3641c + ", message=" + this.f3642d + ", url=" + this.f3639a.m5813c() + '}';
    }
}
