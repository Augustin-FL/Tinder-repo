package com.google.android.m4b.maps.p011o;

import com.google.android.m4b.maps.al.b;
import com.google.android.m4b.maps.am.e;
import com.google.android.m4b.maps.ay.C1440g;
import com.google.android.m4b.maps.ay.br;
import com.google.android.m4b.maps.bh.ab;
import com.google.android.m4b.maps.bh.ae;
import com.google.android.m4b.maps.bh.k;
import com.google.android.m4b.maps.bq.p;
import com.google.android.m4b.maps.bq.s;
import com.google.android.m4b.maps.bq.u;
import com.google.android.m4b.maps.bq.u.a;
import java.util.Collection;
import java.util.List;

/* renamed from: com.google.android.m4b.maps.o.l */
public final class C1510l implements a, C1500m {
    private float f1534a;
    private final s f1535b;
    private final C1514n f1536c;
    private final ae f1537d;
    private final u f1538e;

    C1510l(u uVar, s sVar, ae aeVar, C1514n c1514n) {
        this.f1538e = uVar;
        this.f1535b = sVar;
        this.f1536c = c1514n;
        this.f1537d = aeVar;
        m2477a(-1);
    }

    public final void m2477a(int i) {
        if ((i & 2) != 0) {
            synchronized (this.f1536c) {
                this.f1534a = this.f1538e.g();
                this.f1536c.m2515c();
            }
        }
    }

    public final void m2475a() {
        synchronized (this.f1536c) {
            this.f1536c.m2510a((C1500m) this);
        }
        this.f1536c.m2514b();
    }

    public final void m2482a(e eVar, k kVar) {
        this.f1537d.a(eVar, kVar);
    }

    public final void m2480a(e eVar) {
        this.f1537d.a(eVar);
    }

    public final void m2484a(boolean z) {
        this.f1537d.a(z);
    }

    public final void m2486b() {
        this.f1537d.f_();
    }

    public final void m2487b(int i) {
        this.f1537d.a(i);
    }

    public final void m2479a(b bVar, e eVar) {
        synchronized (this) {
            if (this.f1538e.i()) {
                this.f1537d.a(bVar, eVar);
                return;
            }
        }
    }

    public final void m2481a(e eVar, b bVar, ab abVar) {
        synchronized (this) {
            if (this.f1538e.i()) {
                this.f1537d.a(eVar, bVar, abVar);
                return;
            }
        }
    }

    public final boolean m2485a(float f, float f2, C1440g c1440g, b bVar) {
        synchronized (this) {
            if (this.f1538e.i()) {
                List a = this.f1537d.a(c1440g, bVar, this);
                if (a.isEmpty()) {
                    return false;
                }
                this.f1536c.m2502a(f, f2, c1440g, bVar, this, a);
                return true;
            }
            return false;
        }
    }

    public final void m2476a(float f, float f2, C1440g c1440g, b bVar, List<p> list, List<p> list2) {
        Collection a = this.f1537d.a(c1440g, bVar, this);
        list.addAll(a);
        if (this.f1538e.k()) {
            list2.addAll(a);
        }
    }

    public final void m2478a(long j) {
        this.f1537d.a(j);
    }

    public final boolean m2488c() {
        return this.f1537d.e();
    }

    public final void m2483a(com.google.android.m4b.maps.ch.a aVar) {
        this.f1537d.a(new br(aVar));
        this.f1536c.m2514b();
    }

    public final String m2490e() {
        return this.f1538e.e();
    }

    public final synchronized void m2489d() {
        p c = this.f1535b.c();
        if (c != null && c.a() == this.f1538e) {
            this.f1535b.b();
        }
        this.f1537d.a(null);
    }

    public final float m2491f() {
        return this.f1534a;
    }

    public final u m2492g() {
        return this.f1538e;
    }
}
