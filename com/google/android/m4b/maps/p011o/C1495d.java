package com.google.android.m4b.maps.p011o;

import android.view.View;
import com.google.android.m4b.maps.bh.ah;
import com.google.android.m4b.maps.bh.ah.a;
import com.google.android.m4b.maps.bh.ak;
import com.google.android.m4b.maps.bh.r;
import com.google.android.m4b.maps.bh.x;
import com.google.android.m4b.maps.bh.y;
import com.google.android.m4b.maps.bm.m;
import com.google.android.m4b.maps.bq.av;
import com.google.android.m4b.maps.bq.k;
import com.google.android.m4b.maps.bq.w;
import com.google.common.collect.C1876q;
import java.util.Map;
import org.apache.http.HttpStatus;

/* renamed from: com.google.android.m4b.maps.o.d */
public final class C1495d implements a, ak.a, x.a {
    private final Map<String, w> f1480a;
    private final C1535v f1481b;
    private final k f1482c;
    private final ak f1483d;
    private final ah f1484e;
    private final av f1485f;

    private C1495d(k kVar, C1535v c1535v, ak akVar, ah ahVar, av avVar) {
        this.f1480a = C1876q.m4328a();
        this.f1482c = kVar;
        this.f1481b = c1535v;
        this.f1483d = akVar;
        this.f1484e = ahVar;
        this.f1485f = avVar;
        this.f1483d.a(this);
        this.f1483d.a(this);
        ahVar.a(this);
    }

    public static C1495d m2368a(k kVar, C1535v c1535v) {
        return new C1495d(kVar, c1535v, kVar.a(r.a.o), kVar.e(), av.a());
    }

    protected final void m2371a() {
        this.f1482c.d();
    }

    protected final void m2375b() {
        this.f1483d.c();
    }

    protected final void m2374a(C1496e c1496e) {
        this.f1483d.a(c1496e.m2390e());
        w f = c1496e.m2391f();
        this.f1480a.put(f.a(), f);
        m2371a();
    }

    public final void m2373a(m mVar) {
        this.f1480a.remove(mVar.o());
        this.f1483d.b(mVar);
    }

    public final void m2377b(C1496e c1496e) {
        m e = c1496e.m2390e();
        w f = c1496e.m2391f();
        if (e.d()) {
            View b = f.G().b(c1496e.m2391f());
            if (b != null) {
                this.f1482c.a(e, new y(b));
            }
        }
    }

    public final void m2381c(C1496e c1496e) {
        m e = c1496e.m2390e();
        if (e.d()) {
            synchronized (this.f1484e) {
                if (e.l()) {
                    this.f1482c.y();
                }
            }
        }
    }

    protected final boolean m2378b(m mVar) {
        boolean l;
        synchronized (this.f1484e) {
            l = mVar.l();
        }
        return l;
    }

    public final r m2379c() {
        return this.f1483d;
    }

    public final void m2372a(com.google.android.m4b.maps.bh.w wVar) {
        this.f1485f.b();
        w c = m2369c(wVar);
        if (c != null && !c.G().g(c)) {
            m d = C1495d.m2370d(wVar);
            if (d != null) {
                this.f1481b.m2660a(d.f(), (int) HttpStatus.SC_MULTIPLE_CHOICES);
            }
        }
    }

    public final void m2380c(m mVar) {
        this.f1485f.b();
        w c = m2369c((com.google.android.m4b.maps.bh.w) mVar);
        if (c != null) {
            c.G().d(c);
        }
    }

    public final void m2382d(m mVar) {
        this.f1485f.b();
        w c = m2369c((com.google.android.m4b.maps.bh.w) mVar);
        if (c != null) {
            c.G().e(c);
        }
    }

    public final void m2383e(m mVar) {
        this.f1485f.b();
        w c = m2369c((com.google.android.m4b.maps.bh.w) mVar);
        if (c != null) {
            c.G().f(c);
        }
    }

    public final void m2376b(com.google.android.m4b.maps.bh.w wVar) {
        this.f1485f.b();
        w c = m2369c(wVar);
        if (c != null) {
            c.G().h(c);
        }
    }

    private w m2369c(com.google.android.m4b.maps.bh.w wVar) {
        m d = C1495d.m2370d(wVar);
        if (d == null) {
            return null;
        }
        String o = d.o();
        this.f1485f.b();
        return (w) this.f1480a.get(o);
    }

    private static m m2370d(com.google.android.m4b.maps.bh.w wVar) {
        if (wVar instanceof m) {
            return (m) wVar;
        }
        return null;
    }
}
