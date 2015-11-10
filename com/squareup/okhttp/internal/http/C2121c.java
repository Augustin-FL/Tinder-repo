package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.C2085d;
import com.squareup.okhttp.C2210m;
import com.squareup.okhttp.C2222s;
import com.squareup.okhttp.C2222s.C2221a;
import com.squareup.okhttp.C2227u;
import com.squareup.okhttp.C2227u.C2226a;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;

/* renamed from: com.squareup.okhttp.internal.http.c */
public final class C2121c {
    public final C2222s f3236a;
    public final C2227u f3237b;

    /* renamed from: com.squareup.okhttp.internal.http.c.a */
    public static class C2120a {
        final long f3224a;
        final C2222s f3225b;
        final C2227u f3226c;
        private Date f3227d;
        private String f3228e;
        private Date f3229f;
        private String f3230g;
        private Date f3231h;
        private long f3232i;
        private long f3233j;
        private String f3234k;
        private int f3235l;

        public C2120a(long j, C2222s c2222s, C2227u c2227u) {
            this.f3235l = -1;
            this.f3224a = j;
            this.f3225b = c2222s;
            this.f3226c = c2227u;
            if (c2227u != null) {
                C2210m f = c2227u.m5868f();
                int a = f.m5687a();
                for (int i = 0; i < a; i++) {
                    String a2 = f.m5688a(i);
                    String b = f.m5691b(i);
                    if (HTTP.DATE_HEADER.equalsIgnoreCase(a2)) {
                        this.f3227d = C2132f.m5189a(b);
                        this.f3228e = b;
                    } else if (HttpHeaders.EXPIRES.equalsIgnoreCase(a2)) {
                        this.f3231h = C2132f.m5189a(b);
                    } else if (HttpHeaders.LAST_MODIFIED.equalsIgnoreCase(a2)) {
                        this.f3229f = C2132f.m5189a(b);
                        this.f3230g = b;
                    } else if (HttpHeaders.ETAG.equalsIgnoreCase(a2)) {
                        this.f3234k = b;
                    } else if (HttpHeaders.AGE.equalsIgnoreCase(a2)) {
                        this.f3235l = C2122d.m5150b(b, -1);
                    } else if (C2142j.f3300b.equalsIgnoreCase(a2)) {
                        this.f3232i = Long.parseLong(b);
                    } else if (C2142j.f3301c.equalsIgnoreCase(a2)) {
                        this.f3233j = Long.parseLong(b);
                    }
                }
            }
        }

        public C2121c m5146a() {
            C2121c b = m5142b();
            if (b.f3236a == null || !this.f3225b.m5818h().m4948i()) {
                return b;
            }
            return new C2121c(null, null);
        }

        private C2121c m5142b() {
            long j = 0;
            if (this.f3226c == null) {
                return new C2121c(null, null);
            }
            if (this.f3225b.m5819i() && this.f3226c.m5867e() == null) {
                return new C2121c(null, null);
            }
            if (!C2121c.m5147a(this.f3226c, this.f3225b)) {
                return new C2121c(null, null);
            }
            C2085d h = this.f3225b.m5818h();
            if (h.m4940a() || C2120a.m5141a(this.f3225b)) {
                return new C2121c(null, null);
            }
            long toMillis;
            long d = m5144d();
            long c = m5143c();
            if (h.m4942c() != -1) {
                c = Math.min(c, TimeUnit.SECONDS.toMillis((long) h.m4942c()));
            }
            if (h.m4947h() != -1) {
                toMillis = TimeUnit.SECONDS.toMillis((long) h.m4947h());
            } else {
                toMillis = 0;
            }
            C2085d l = this.f3226c.m5874l();
            if (!(l.m4945f() || h.m4946g() == -1)) {
                j = TimeUnit.SECONDS.toMillis((long) h.m4946g());
            }
            if (l.m4940a() || d + toMillis >= r4 + c) {
                C2221a g = this.f3225b.m5817g();
                if (this.f3234k != null) {
                    g.m5799a(HttpHeaders.IF_NONE_MATCH, this.f3234k);
                } else if (this.f3229f != null) {
                    g.m5799a(HttpHeaders.IF_MODIFIED_SINCE, this.f3230g);
                } else if (this.f3227d != null) {
                    g.m5799a(HttpHeaders.IF_MODIFIED_SINCE, this.f3228e);
                }
                C2222s a = g.m5801a();
                if (C2120a.m5141a(a)) {
                    return new C2121c(this.f3226c, null);
                }
                return new C2121c(null, null);
            }
            C2226a h2 = this.f3226c.m5870h();
            if (toMillis + d >= c) {
                h2.m5849b(HttpHeaders.WARNING, "110 HttpURLConnection \"Response is stale\"");
            }
            if (d > 86400000 && m5145e()) {
                h2.m5849b(HttpHeaders.WARNING, "113 HttpURLConnection \"Heuristic expiration\"");
            }
            return new C2121c(h2.m5847a(), null);
        }

        private long m5143c() {
            C2085d l = this.f3226c.m5874l();
            if (l.m4942c() != -1) {
                return TimeUnit.SECONDS.toMillis((long) l.m4942c());
            }
            long time;
            if (this.f3231h != null) {
                time = this.f3231h.getTime() - (this.f3227d != null ? this.f3227d.getTime() : this.f3233j);
                if (time <= 0) {
                    time = 0;
                }
                return time;
            } else if (this.f3229f == null || this.f3226c.m5861a().m5810a().getQuery() != null) {
                return 0;
            } else {
                time = (this.f3227d != null ? this.f3227d.getTime() : this.f3232i) - this.f3229f.getTime();
                if (time > 0) {
                    return time / 10;
                }
                return 0;
            }
        }

        private long m5144d() {
            long j = 0;
            if (this.f3227d != null) {
                j = Math.max(0, this.f3233j - this.f3227d.getTime());
            }
            if (this.f3235l != -1) {
                j = Math.max(j, TimeUnit.SECONDS.toMillis((long) this.f3235l));
            }
            return (j + (this.f3233j - this.f3232i)) + (this.f3224a - this.f3233j);
        }

        private boolean m5145e() {
            return this.f3226c.m5874l().m4942c() == -1 && this.f3231h == null;
        }

        private static boolean m5141a(C2222s c2222s) {
            return (c2222s.m5809a(HttpHeaders.IF_MODIFIED_SINCE) == null && c2222s.m5809a(HttpHeaders.IF_NONE_MATCH) == null) ? false : true;
        }
    }

    private C2121c(C2222s c2222s, C2227u c2227u) {
        this.f3236a = c2222s;
        this.f3237b = c2227u;
    }

    public static boolean m5147a(C2227u c2227u, C2222s c2222s) {
        switch (c2227u.m5865c()) {
            case HttpStatus.SC_OK /*200*/:
            case HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION /*203*/:
            case HttpStatus.SC_NO_CONTENT /*204*/:
            case HttpStatus.SC_MULTIPLE_CHOICES /*300*/:
            case HttpStatus.SC_MOVED_PERMANENTLY /*301*/:
            case 308:
            case HttpStatus.SC_NOT_FOUND /*404*/:
            case HttpStatus.SC_METHOD_NOT_ALLOWED /*405*/:
            case HttpStatus.SC_GONE /*410*/:
            case HttpStatus.SC_REQUEST_URI_TOO_LONG /*414*/:
            case HttpStatus.SC_NOT_IMPLEMENTED /*501*/:
                break;
            case HttpStatus.SC_MOVED_TEMPORARILY /*302*/:
            case HttpStatus.SC_TEMPORARY_REDIRECT /*307*/:
                if (c2227u.m5862a(HttpHeaders.EXPIRES) == null && c2227u.m5874l().m4942c() == -1 && !c2227u.m5874l().m4944e() && !c2227u.m5874l().m4943d()) {
                    return false;
                }
            default:
                return false;
        }
        return (c2227u.m5874l().m4941b() || c2222s.m5818h().m4941b()) ? false : true;
    }
}
