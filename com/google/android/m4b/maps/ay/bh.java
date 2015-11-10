package com.google.android.m4b.maps.ay;

import com.google.android.m4b.maps.bq.bs;
import com.google.android.m4b.maps.bq.bv;
import com.google.android.m4b.maps.cf.b;
import com.google.android.m4b.maps.ch.a;
import com.google.android.m4b.maps.p009m.C1480a.C1483c;
import com.google.android.m4b.maps.p009m.C1486c;
import com.google.common.collect.C1872p;
import java.util.List;

public class bh implements bs {
    private final C1483c f1194a;
    private final List<bi> f1195b;
    private final int f1196c;
    private final C1440g f1197d;
    private final long f1198e;
    private boolean f1199f;

    public final /* synthetic */ bv m1801c(C1486c c1486c) {
        return m1795a(c1486c);
    }

    protected bh(C1483c c1483c, List<bi> list, int i, boolean z, C1440g c1440g, long j) {
        this.f1194a = c1483c;
        this.f1195b = list;
        this.f1196c = i;
        this.f1199f = z;
        this.f1197d = c1440g;
        this.f1198e = j;
    }

    public static bh m1793a(a aVar, long j) {
        C1440g c1440g = null;
        C1483c b = C1483c.m2303b(aVar.g(1));
        if (b == null) {
            return null;
        }
        int i;
        int j2 = aVar.j(2);
        List b2 = C1872p.m4317b(j2);
        for (i = 0; i < j2; i++) {
            bi a = bi.m1807a(aVar.c(2, i));
            if (a != null) {
                b2.add(a);
            }
        }
        boolean b3 = aVar.b(4);
        i = aVar.d(3);
        if (i < 0 || i >= j2) {
            i = 0;
        }
        if (b3 || j2 == 0) {
            i = -1;
        }
        if (aVar.i(5)) {
            c1440g = C1440g.m1927a(aVar.f(5));
        }
        return new bh(b, b2, i, b3, c1440g, j);
    }

    public final C1483c m1796a() {
        return this.f1194a;
    }

    public final List<bi> m1799b() {
        return this.f1195b;
    }

    public final bi m1794a(C1483c c1483c) {
        for (bi biVar : this.f1195b) {
            if (c1483c.equals(biVar.m1809b())) {
                return biVar;
            }
        }
        return null;
    }

    public final bi m1795a(C1486c c1486c) {
        return m1794a(c1486c.m2309a());
    }

    public final int m1798b(C1486c c1486c) {
        bi a = m1794a(c1486c.m2309a());
        if (a == null) {
            return -1;
        }
        return this.f1195b.indexOf(m1794a(a.m1809b()));
    }

    public final bi m1800c() {
        int i = this.f1196c;
        return (i < 0 || i >= this.f1195b.size()) ? null : (bi) this.f1195b.get(i);
    }

    public final int m1802d() {
        return this.f1196c;
    }

    public final boolean m1803e() {
        return this.f1199f;
    }

    public final C1440g m1804f() {
        return this.f1197d;
    }

    public final boolean m1797a(b bVar) {
        return this.f1198e >= 0 && bVar.a() > this.f1198e;
    }

    public String toString() {
        return "[Building: " + this.f1194a + "]";
    }
}
