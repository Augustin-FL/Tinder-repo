package com.google.android.m4b.maps.p011o;

import android.util.FloatMath;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.m4b.maps.al.b;
import com.google.android.m4b.maps.al.c;
import com.google.android.m4b.maps.al.d;
import com.google.android.m4b.maps.ay.C1440g;
import com.google.android.m4b.maps.bh.e;
import com.google.android.m4b.maps.bh.q;
import com.google.android.m4b.maps.bq.k;
import org.apache.http.HttpStatus;

/* renamed from: com.google.android.m4b.maps.o.v */
public final class C1535v {
    private int f1640a;
    private int f1641b;
    private int f1642c;
    private int f1643d;
    private int f1644e;
    private int f1645f;
    private int f1646g;
    private int f1647h;
    private k f1648i;
    private final q f1649j;

    public C1535v(q qVar, k kVar) {
        this.f1640a = 0;
        this.f1641b = 0;
        this.f1642c = 0;
        this.f1643d = 0;
        this.f1644e = 0;
        this.f1645f = 0;
        this.f1646g = 0;
        this.f1647h = 0;
        this.f1648i = null;
        this.f1649j = qVar;
        this.f1648i = kVar;
    }

    public final void m2658a(int i, int i2, int i3, int i4) {
        this.f1640a = i;
        this.f1641b = i2;
        this.f1642c = i3;
        this.f1643d = i4;
    }

    public final int m2655a() {
        return this.f1640a + this.f1642c;
    }

    public final int m2663b() {
        return this.f1641b + this.f1643d;
    }

    private void m2651f() {
        if (this.f1648i != null) {
            this.f1644e = (this.f1648i.getWidth() - this.f1640a) - this.f1642c;
            this.f1645f = (this.f1648i.getHeight() - this.f1641b) - this.f1643d;
            this.f1646g = this.f1640a + (this.f1644e / 2);
            this.f1647h = this.f1641b + (this.f1645f / 2);
        }
    }

    public final c m2656a(c cVar, float f) {
        m2651f();
        b x = this.f1648i.x();
        float pow = ((float) Math.pow(2.0d, (double) (x.m() - cVar.a()))) * f;
        float width = ((float) ((((double) this.f1648i.getWidth()) / 2.0d) - ((double) this.f1646g))) * pow;
        width *= x.s();
        pow = ((-(pow * ((float) ((((double) this.f1648i.getHeight()) / 2.0d) - ((double) this.f1647h))))) * x.s()) / FloatMath.cos(x.l() * 0.017453292f);
        C1440g p = x.p();
        C1440g q = x.q();
        C1440g c1440g = new C1440g(p.m1958f(), p.m1960g());
        p = new C1440g(q.m1958f(), q.m1960g());
        C1440g.m1935b(c1440g, width, c1440g);
        C1440g.m1935b(p, pow, p);
        q = cVar.c();
        width = cVar.a();
        int h = q.m1962h();
        C1440g e = q.m1957e(c1440g);
        C1440g.m1931a(e, p, e);
        e.m1944a(h);
        return new c(e, width, cVar.d(), cVar.e(), 0.0f);
    }

    public final void m2659a(d dVar, int i, int i2) {
        Object obj = (this.f1648i == null || (this.f1640a == 0 && this.f1642c == 0 && this.f1641b == 0 && this.f1643d == 0)) ? null : 1;
        if (obj != null) {
            this.f1649j.a(m2656a(dVar.b(), 1.0f), i, i2);
        } else {
            this.f1649j.a(dVar, i, i2);
        }
    }

    private void m2650a(d dVar, int i) {
        m2659a(dVar, i, i == 0 ? 0 : -1);
    }

    public final void m2660a(C1440g c1440g, int i) {
        b x = this.f1648i.x();
        m2650a(new c(c1440g, x.m(), x.l(), x.k(), 0.0f), (int) HttpStatus.SC_MULTIPLE_CHOICES);
    }

    public final c m2665c() {
        return m2656a(this.f1649j.b(), (float) GroundOverlayOptions.NO_DIMENSION);
    }

    public final float m2654a(C1440g c1440g) {
        return this.f1649j.a(c1440g);
    }

    public final float m2666d() {
        return this.f1649j.a();
    }

    public final void m2657a(float f, float f2) {
        this.f1649j.a(0.0f, 0.0f);
    }

    public final void m2661a(e eVar) {
        this.f1649j.a(eVar);
    }

    public final float m2667e() {
        return this.f1649j.c();
    }

    public final float m2653a(float f, int i) {
        m2651f();
        return m2652a(f, (float) this.f1646g, (float) this.f1647h, i);
    }

    public final void m2664b(float f, int i) {
        m2651f();
        c c = m2665c();
        m2650a(new c(c.c(), f, c.d(), c.e(), c.f()), i);
    }

    public final float m2652a(float f, float f2, float f3, int i) {
        return this.f1649j.a(f, f2, f3, i);
    }

    public final void m2662a(q.e eVar) {
        this.f1649j.a(eVar);
    }
}
