package com.google.android.m4b.maps.p019x;

import android.util.FloatMath;
import com.google.android.m4b.maps.al.b;
import com.google.android.m4b.maps.ay.C1440g;
import com.google.android.m4b.maps.ay.ac;
import com.google.android.m4b.maps.ay.ag;
import com.google.android.m4b.maps.ay.ah;
import com.google.android.m4b.maps.ay.aq;
import com.google.android.m4b.maps.ay.bc;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.m4b.maps.x.d */
public final class C1581d extends C1577j {
    private aq f1799d;
    private final List<ac> f1800e;
    private final C1440g f1801f;
    private b f1802g;
    private aq f1803h;
    private float f1804i;
    private final float f1805j;
    private long f1806k;

    public C1581d(ah ahVar, int i, ag agVar) {
        super(ahVar, agVar);
        this.f1800e = new ArrayList();
        this.f1801f = new C1440g();
        this.f1806k = 0;
        this.f1805j = (float) (i * i);
    }

    public final List<ac> m2841a(b bVar) {
        aq v = bVar.v();
        if (this.f1799d != null && v.equals(this.f1799d)) {
            if (this.f1800e.isEmpty() ? true : ((ac) this.f1800e.get(0)).m1457j().equals(this.b.m1472a())) {
                return this.f1800e;
            }
        }
        this.f1806k++;
        bc bcVar = (bc) v.m1665c();
        int c = (int) bVar.c(bcVar.m1760d().m1951c(bcVar.m1759c()), (float) bVar.f());
        this.f1800e.clear();
        this.f1802g = bVar;
        this.f1803h = bVar.v();
        this.f1804i = FloatMath.cos(bVar.l() * 0.017453292f);
        ArrayList a = ac.m1437a(v.m1659a(), c, this.b.m1472a());
        for (int i = 0; i < a.size(); i++) {
            m2839a((ac) a.get(i), bVar.c(), false);
        }
        this.f1799d = v;
        return this.f1800e;
    }

    public final long m2840a() {
        return this.f1806k;
    }

    private void m2839a(ac acVar, C1440g c1440g, boolean z) {
        if (!z || this.f1803h.m1653b(acVar.m1456i())) {
            int b = acVar.m1449b();
            int i = 536870912 >> b;
            this.f1801f.m1955d(acVar.m1452e() + i, acVar.m1453f() + i);
            float b2 = this.f1802g.b((float) (i * 2), this.f1802g.a(this.f1801f, true));
            if (b2 * (this.f1804i * b2) < this.f1805j || b >= 30) {
                this.f1800e.add(acVar);
                return;
            }
            List<ac> b3 = m2829b(acVar, c1440g);
            if (b3.isEmpty()) {
                this.f1800e.add(acVar);
                return;
            }
            for (ac a : b3) {
                m2839a(a, c1440g, true);
            }
        }
    }
}
