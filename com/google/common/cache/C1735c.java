package com.google.common.cache;

import com.google.common.base.C1647e;
import com.google.common.base.C1650g;

/* renamed from: com.google.common.cache.c */
public final class C1735c {
    private final long f2178a;
    private final long f2179b;
    private final long f2180c;
    private final long f2181d;
    private final long f2182e;
    private final long f2183f;

    public C1735c(long j, long j2, long j3, long j4, long j5, long j6) {
        C1650g.m3085a(j >= 0);
        C1650g.m3085a(j2 >= 0);
        C1650g.m3085a(j3 >= 0);
        C1650g.m3085a(j4 >= 0);
        C1650g.m3085a(j5 >= 0);
        C1650g.m3085a(j6 >= 0);
        this.f2178a = j;
        this.f2179b = j2;
        this.f2180c = j3;
        this.f2181d = j4;
        this.f2182e = j5;
        this.f2183f = j6;
    }

    public int hashCode() {
        return C1647e.m3071a(Long.valueOf(this.f2178a), Long.valueOf(this.f2179b), Long.valueOf(this.f2180c), Long.valueOf(this.f2181d), Long.valueOf(this.f2182e), Long.valueOf(this.f2183f));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1735c)) {
            return false;
        }
        C1735c c1735c = (C1735c) obj;
        if (this.f2178a == c1735c.f2178a && this.f2179b == c1735c.f2179b && this.f2180c == c1735c.f2180c && this.f2181d == c1735c.f2181d && this.f2182e == c1735c.f2182e && this.f2183f == c1735c.f2183f) {
            return true;
        }
        return false;
    }

    public String toString() {
        return C1647e.m3072a((Object) this).m3068a("hitCount", this.f2178a).m3068a("missCount", this.f2179b).m3068a("loadSuccessCount", this.f2180c).m3068a("loadExceptionCount", this.f2181d).m3068a("totalLoadTime", this.f2182e).m3068a("evictionCount", this.f2183f).toString();
    }
}
