package com.google.android.m4b.maps.p011o;

import com.google.android.m4b.maps.al.b;
import com.google.android.m4b.maps.am.e;
import com.google.android.m4b.maps.ay.C1440g;
import com.google.android.m4b.maps.ay.C1446k;
import com.google.android.m4b.maps.ay.C1446k.C1445a;
import com.google.android.m4b.maps.bh.ab;
import com.google.android.m4b.maps.bh.al;
import com.google.android.m4b.maps.bh.k;
import com.google.android.m4b.maps.bq.ad;
import com.google.android.m4b.maps.bq.ad.a;
import com.google.android.m4b.maps.model.LatLng;
import com.google.common.collect.C1872p;
import java.util.List;

/* renamed from: com.google.android.m4b.maps.o.o */
public final class C1515o implements a, C1500m {
    private final ad f1553a;
    private C1446k f1554b;
    private List<C1446k> f1555c;
    private al f1556d;
    private float f1557e;
    private e f1558f;
    private k f1559g;
    private final C1514n f1560h;

    public C1515o(C1514n c1514n, ad adVar) {
        this.f1560h = c1514n;
        this.f1553a = adVar;
        m2521a(-1);
    }

    public final void m2521a(int i) {
        if ((i & 3) != 0) {
            this.f1554b = C1515o.m2519a(this.f1553a.b());
            this.f1555c = C1872p.m4309a();
            for (List a : this.f1553a.d()) {
                this.f1555c.add(C1515o.m2519a(a));
            }
            this.f1556d = new al(this.f1554b, this.f1555c, (int) this.f1553a.e(), C1493b.m2355a(this.f1553a.f()), C1493b.m2355a(this.f1553a.g()), true);
            if (!(this.f1558f == null || this.f1559g == null)) {
                this.f1556d.a(this.f1558f, this.f1559g);
            }
        }
        if ((i & 16) != 0) {
            this.f1556d.c(C1493b.m2355a(this.f1553a.g()));
        }
        if ((i & 8) != 0) {
            this.f1556d.b(C1493b.m2355a(this.f1553a.f()));
        }
        if ((i & 4) != 0) {
            this.f1556d.d((int) this.f1553a.e());
        }
        if ((i & 64) != 0) {
            synchronized (this.f1560h) {
                this.f1557e = this.f1553a.i();
                this.f1560h.m2515c();
            }
        }
        this.f1560h.m2514b();
    }

    public final void m2520a() {
        synchronized (this.f1560h) {
            this.f1560h.m2510a((C1500m) this);
        }
        this.f1560h.m2514b();
    }

    private static C1446k m2519a(List<LatLng> list) {
        C1445a c1445a = new C1445a();
        for (LatLng b : list) {
            c1445a.m2006a(C1493b.m2363b(b));
        }
        C1446k c = c1445a.m2008c();
        if (c.m2025c(c.m2030g()).m2029f()) {
            return c;
        }
        return c.m2031h();
    }

    public final synchronized void m2526a(e eVar, k kVar) {
        this.f1558f = eVar;
        this.f1559g = kVar;
        this.f1556d.a(eVar, kVar);
    }

    public final void m2524a(e eVar) {
    }

    public final void m2527a(boolean z) {
    }

    public final void m2529b() {
    }

    public final void m2530b(int i) {
    }

    public final synchronized void m2523a(b bVar, e eVar) {
        if (this.f1553a != null && this.f1553a.h()) {
            this.f1556d.a(bVar, eVar);
        }
    }

    public final synchronized void m2525a(e eVar, b bVar, ab abVar) {
        if (this.f1553a != null && this.f1553a.h()) {
            this.f1556d.a(eVar, bVar, abVar);
        }
    }

    public final boolean m2528a(float f, float f2, C1440g c1440g, b bVar) {
        return false;
    }

    public final void m2522a(long j) {
    }

    public final synchronized boolean m2531c() {
        boolean z;
        z = this.f1553a == null || !this.f1553a.h() || this.f1556d.e();
        return z;
    }

    public final String m2533e() {
        return this.f1553a.a();
    }

    public final float m2534f() {
        return this.f1557e;
    }

    public final void m2532d() {
    }
}
