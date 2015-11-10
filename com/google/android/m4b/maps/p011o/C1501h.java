package com.google.android.m4b.maps.p011o;

import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.m4b.maps.al.b;
import com.google.android.m4b.maps.am.e;
import com.google.android.m4b.maps.am.l;
import com.google.android.m4b.maps.an.g;
import com.google.android.m4b.maps.an.k;
import com.google.android.m4b.maps.ay.C1440g;
import com.google.android.m4b.maps.ay.C1448m;
import com.google.android.m4b.maps.ay.ar;
import com.google.android.m4b.maps.bh.ab;
import com.google.android.m4b.maps.bh.o;
import com.google.android.m4b.maps.bq.bp;
import com.google.android.m4b.maps.bq.bp.a;
import com.google.android.m4b.maps.model.LatLngBounds;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.google.android.m4b.maps.o.h */
public final class C1501h implements a, C1500m {
    private final C1514n f1494a;
    private final bp f1495b;
    private C1440g f1496c;
    private ar f1497d;
    private k f1498e;
    private l f1499f;
    private g f1500g;
    private float f1501h;

    public C1501h(C1514n c1514n, bp bpVar) {
        this.f1496c = new C1440g();
        this.f1494a = c1514n;
        this.f1495b = bpVar;
        m2412a(-1);
    }

    public final synchronized void m2412a(int i) {
        if ((i & 16) != 0) {
            LatLngBounds g = this.f1495b.g();
            C1440g e = g.b.b < g.a.b ? C1493b.m2363b(g.b).m1957e(new C1440g(1073741824, 0)) : C1493b.m2363b(g.b);
            C1440g b = C1493b.m2363b(g.a);
            float k = this.f1495b.k();
            float l = this.f1495b.l();
            this.f1496c = new C1440g((int) ((k * ((float) e.m1958f())) + ((1.0f - k) * ((float) b.m1958f()))), (int) ((((float) e.m1960g()) * (1.0f - l)) + (((float) b.m1960g()) * l)));
        }
        if ((i & 23) != 0) {
            this.f1498e = new k(4);
            this.f1498e.a(-this.f1495b.k(), this.f1495b.l(), 0.0f);
            this.f1498e.a(-this.f1495b.k(), this.f1495b.l() - 1.0f, 0.0f);
            this.f1498e.a(1.0f - this.f1495b.k(), this.f1495b.l(), 0.0f);
            this.f1498e.a(1.0f - this.f1495b.k(), this.f1495b.l() - 1.0f, 0.0f);
            ar a = C1493b.m2356a(this.f1495b.g());
            if (this.f1495b.e() == 0.0f) {
                this.f1497d = a;
            } else {
                double hypot = Math.hypot((double) a.m1680d(), (double) a.m1681e());
                C1440g c1440g = new C1440g((int) hypot, (int) hypot);
                this.f1497d = ar.m1671a(new C1448m(this.f1496c.m1959f(c1440g), this.f1496c.m1957e(c1440g)));
            }
        }
        if ((i & 4) != 0) {
            m2410g();
        }
        if ((i & 8) != 0) {
            synchronized (this.f1494a) {
                this.f1501h = this.f1495b.p();
                this.f1494a.m2515c();
            }
        }
        this.f1494a.m2514b();
    }

    public final void m2411a() {
        synchronized (this.f1494a) {
            this.f1494a.m2510a((C1500m) this);
        }
        this.f1494a.m2514b();
    }

    public final void m2417a(e eVar, com.google.android.m4b.maps.bh.k kVar) {
    }

    public final synchronized void m2415a(e eVar) {
        m2410g();
    }

    public final void m2418a(boolean z) {
    }

    public final void m2420b() {
    }

    public final void m2421b(int i) {
    }

    public final synchronized void m2416a(e eVar, b bVar, ab abVar) {
        synchronized (this.f1495b) {
            if (!this.f1495b.r()) {
            } else if (bVar.v().m1653b(this.f1497d.m1677b()) || this.f1497d.m1682f().m1958f() > this.f1497d.m1683g().m1958f()) {
                float b;
                GL10 x = eVar.x();
                this.f1498e.d(eVar);
                eVar.p();
                if (this.f1499f == null) {
                    this.f1499f = new l(eVar);
                    this.f1499f.c(true);
                    this.f1499f.d(true);
                    this.f1499f.a(this.f1495b.s().c());
                }
                if (this.f1500g == null) {
                    this.f1500g = new g(8);
                    b = this.f1499f.b();
                    float c = this.f1499f.c();
                    this.f1500g.a(0.0f, 0.0f);
                    this.f1500g.a(0.0f, c);
                    this.f1500g.a(b, 0.0f);
                    this.f1500g.a(b, c);
                }
                x.glBlendFunc(1, 771);
                x.glTexEnvx(8960, 8704, 8448);
                b = this.f1495b.n();
                x.glColor4f(1.0f - b, 1.0f - b, 1.0f - b, 1.0f - b);
                x.glPushMatrix();
                o.a(eVar, bVar, this.f1496c, 1.0f);
                x.glRotatef(this.f1495b.e(), 0.0f, 0.0f, GroundOverlayOptions.NO_DIMENSION);
                ar a = C1493b.m2356a(this.f1495b.g());
                x.glScalef((float) a.m1680d(), (float) a.m1681e(), 1.0f);
                this.f1500g.d(eVar);
                this.f1499f.a(x);
                x.glDrawArrays(5, 0, 4);
                x.glPopMatrix();
            }
        }
    }

    public final void m2414a(b bVar, e eVar) {
    }

    public final boolean m2419a(float f, float f2, C1440g c1440g, b bVar) {
        return false;
    }

    public final void m2413a(long j) {
    }

    public final boolean m2422c() {
        return true;
    }

    public final synchronized void m2423d() {
        m2410g();
    }

    public final String m2424e() {
        return this.f1495b.a();
    }

    public final float m2425f() {
        return this.f1501h;
    }

    private void m2410g() {
        if (this.f1499f != null) {
            this.f1499f.f();
            this.f1499f = null;
        }
    }
}
