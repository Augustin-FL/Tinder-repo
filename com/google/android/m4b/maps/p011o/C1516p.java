package com.google.android.m4b.maps.p011o;

import com.google.android.m4b.maps.al.b;
import com.google.android.m4b.maps.am.e;
import com.google.android.m4b.maps.ay.C1440g;
import com.google.android.m4b.maps.ay.C1446k;
import com.google.android.m4b.maps.ay.C1446k.C1445a;
import com.google.android.m4b.maps.bh.ab;
import com.google.android.m4b.maps.bh.aj;
import com.google.android.m4b.maps.bh.k;
import com.google.android.m4b.maps.bq.ad;
import com.google.android.m4b.maps.bq.ad.a;
import com.google.android.m4b.maps.model.LatLng;
import com.google.common.collect.C1872p;
import java.util.List;

/* renamed from: com.google.android.m4b.maps.o.p */
public final class C1516p implements a, C1500m {
    private final ad f1561a;
    private final List<C1446k> f1562b;
    private final List<aj> f1563c;
    private float f1564d;
    private final C1514n f1565e;

    public C1516p(C1514n c1514n, ad adVar) {
        this.f1562b = C1872p.m4309a();
        this.f1563c = C1872p.m4309a();
        this.f1565e = c1514n;
        this.f1561a = adVar;
        m2538a(-1);
    }

    public final void m2538a(int i) {
        if ((i & 1) != 0) {
            m2536g();
        }
        if ((i & 8) != 0) {
            for (aj b : this.f1563c) {
                b.b(C1493b.m2355a(this.f1561a.f()));
            }
        }
        if ((i & 4) != 0) {
            for (aj b2 : this.f1563c) {
                b2.a(this.f1561a.e());
            }
        }
        if ((i & 64) != 0) {
            synchronized (this.f1565e) {
                this.f1564d = this.f1561a.i();
                this.f1565e.m2515c();
            }
            this.f1565e.m2514b();
        }
        this.f1565e.m2514b();
    }

    public final void m2537a() {
        synchronized (this.f1565e) {
            this.f1565e.m2510a((C1500m) this);
        }
        this.f1565e.m2514b();
    }

    private synchronized void m2536g() {
        List<LatLng> b = this.f1561a.b();
        List list = this.f1562b;
        list.clear();
        C1445a c1445a = new C1445a();
        C1440g c1440g = null;
        for (LatLng b2 : b) {
            C1445a c1445a2;
            C1440g b3 = C1493b.m2363b(b2);
            if (c1440g == null || Math.abs(b3.m1958f() - c1440g.m1958f()) <= 536870912) {
                c1445a.m2006a(b3);
                c1445a2 = c1445a;
            } else if (b3.m1958f() - c1440g.m1958f() > 536870912) {
                r0 = ((float) (b3.m1960g() - c1440g.m1960g())) / ((float) ((b3.m1958f() - c1440g.m1958f()) - 1073741824));
                r6 = new C1440g(-536870912, (int) ((((float) (-536870912 - c1440g.m1958f())) * r0) + ((float) c1440g.m1960g())));
                c1440g = new C1440g(536870911, (int) ((r0 * ((float) (536870912 - b3.m1958f()))) + ((float) b3.m1960g())));
                c1445a.m2006a(r6);
                list.add(c1445a.m2008c());
                c1445a2 = new C1445a();
                c1445a2.m2006a(c1440g);
                c1445a2.m2006a(b3);
            } else if (b3.m1958f() - c1440g.m1958f() < -536870912) {
                r0 = ((float) (c1440g.m1960g() - b3.m1960g())) / ((float) ((c1440g.m1958f() - b3.m1958f()) - 1073741824));
                r6 = new C1440g(536870911, (int) ((((float) (536870911 - c1440g.m1958f())) * r0) + ((float) c1440g.m1960g())));
                c1440g = new C1440g(-536870912, (int) ((r0 * ((float) (-536870912 - b3.m1958f()))) + ((float) b3.m1960g())));
                c1445a.m2006a(r6);
                list.add(c1445a.m2008c());
                c1445a2 = new C1445a();
                c1445a2.m2006a(c1440g);
                c1445a2.m2006a(b3);
            } else {
                throw new AssertionError();
            }
            c1440g = b3;
            c1445a = c1445a2;
        }
        list.add(c1445a.m2008c());
        C1516p.m2535a(this.f1562b, this.f1561a.e(), this.f1561a.f(), this.f1563c);
    }

    private static void m2535a(List<C1446k> list, float f, int i, List<aj> list2) {
        list2.clear();
        int a = C1493b.m2355a(i);
        for (C1446k c1446k : list) {
            if (c1446k.m2020b() > 0) {
                list2.add(new aj(c1446k, f, a, null));
            }
        }
    }

    public final synchronized void m2543a(e eVar, k kVar) {
    }

    public final void m2541a(e eVar) {
    }

    public final void m2544a(boolean z) {
    }

    public final void m2546b() {
    }

    public final void m2547b(int i) {
    }

    public final synchronized void m2540a(b bVar, e eVar) {
        if (this.f1561a != null && this.f1561a.h()) {
            for (aj a : this.f1563c) {
                a.a(bVar, eVar);
            }
        }
    }

    public final synchronized void m2542a(e eVar, b bVar, ab abVar) {
        if (this.f1561a != null && this.f1561a.h()) {
            for (aj a : this.f1563c) {
                a.a(eVar, bVar, abVar);
            }
        }
    }

    public final boolean m2545a(float f, float f2, C1440g c1440g, b bVar) {
        return false;
    }

    public final void m2539a(long j) {
    }

    public final synchronized boolean m2548c() {
        boolean z;
        if (this.f1561a == null || !this.f1561a.h()) {
            z = true;
        } else {
            for (aj e : this.f1563c) {
                if (!e.e()) {
                    z = false;
                    break;
                }
            }
            z = true;
        }
        return z;
    }

    public final String m2550e() {
        return this.f1561a.a();
    }

    public final float m2551f() {
        return this.f1564d;
    }

    public final void m2549d() {
    }
}
