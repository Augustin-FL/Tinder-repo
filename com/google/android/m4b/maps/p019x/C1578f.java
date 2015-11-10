package com.google.android.m4b.maps.p019x;

import com.google.android.m4b.maps.ag.e;
import com.google.android.m4b.maps.al.b;
import com.google.android.m4b.maps.ay.C1440g;
import com.google.android.m4b.maps.ay.ac;
import com.google.android.m4b.maps.ay.ag;
import com.google.android.m4b.maps.ay.ah;
import com.google.android.m4b.maps.ay.aq;
import com.google.android.m4b.maps.bh.t;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.m4b.maps.x.f */
public class C1578f extends C1577j {
    private boolean f1792d;
    private long f1793e;
    private aq f1794f;
    private aq f1795g;
    private List<ac> f1796h;
    private List<ac> f1797i;

    public C1578f(ah ahVar, ag agVar) {
        super(ahVar, agVar);
        this.f1793e = 0;
        boolean z = (ahVar == ah.f1042j || ahVar == ah.f1043k || ahVar == ah.f1044l) && e.a().i() > 1.0d;
        this.f1792d = z;
    }

    public List<ac> m2833a(b bVar) {
        aq v = bVar.v();
        if (this.f1794f != null && v.equals(this.f1794f)) {
            if (this.f1796h.isEmpty() ? true : ((ac) this.f1796h.get(0)).m1457j().equals(this.b.m1472a())) {
                return this.f1796h;
            }
        }
        this.f1793e++;
        List a = ac.m1437a(v.m1659a(), m2835c(bVar), this.b.m1472a());
        int i = (bVar.l() == 0.0f && bVar.k() == 0.0f) ? 1 : 0;
        if (i == 0) {
            C1578f.m2830a(v, a);
        }
        this.f1796h = a;
        this.f1794f = v;
        return this.f1796h;
    }

    public final long m2832a() {
        return this.f1793e;
    }

    public final List<ac> m2834b(b bVar) {
        aq v = bVar.v();
        if (this.f1795g != null && v.equals(this.f1795g)) {
            return this.f1797i;
        }
        List b = ac.m1440b(v.m1659a(), m2835c(bVar));
        Object obj = (bVar.l() == 0.0f && bVar.k() == 0.0f) ? 1 : null;
        if (obj == null) {
            C1578f.m2830a(v, b);
        }
        this.f1795g = v;
        this.f1797i = b;
        return this.f1797i;
    }

    private static void m2830a(aq aqVar, ArrayList<ac> arrayList) {
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            ac acVar = (ac) arrayList.get(i);
            if (aqVar.m1653b(acVar.m1456i())) {
                int i4 = i2 + 1;
                arrayList.set(i2, acVar);
                i3 = i4;
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        for (i3 = size - 1; i3 >= i2; i3--) {
            arrayList.remove(i3);
        }
    }

    public final float m2831a(C1440g c1440g) {
        if (this.f1792d) {
            return super.m2826a(c1440g) - 1.0f;
        }
        return super.m2826a(c1440g);
    }

    protected int m2835c(b bVar) {
        float m = bVar.m();
        t a = this.c.a(bVar.c(), this.a);
        if (a != null) {
            return a.a(m);
        }
        return (int) m;
    }
}
