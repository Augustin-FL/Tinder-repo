package com.google.android.m4b.maps.p011o;

import android.content.res.Resources;
import com.facebook.share.internal.ShareConstants;
import com.google.android.m4b.maps.al.b;
import com.google.android.m4b.maps.am.e;
import com.google.android.m4b.maps.ay.C1440g;
import com.google.android.m4b.maps.ay.ac;
import com.google.android.m4b.maps.ay.ag;
import com.google.android.m4b.maps.ay.ah;
import com.google.android.m4b.maps.bh.ab;
import com.google.android.m4b.maps.bh.k;
import com.google.android.m4b.maps.bh.m;
import com.google.android.m4b.maps.bm.q;
import com.google.android.m4b.maps.bq.aw;
import com.google.android.m4b.maps.bq.aw.a;
import com.google.android.m4b.maps.model.TileOverlayOptions;
import com.google.android.m4b.maps.p011o.C1532t.C1530a;
import com.google.android.m4b.maps.p011o.C1532t.C1531b;
import com.google.android.m4b.maps.p019x.C1575g;
import com.google.android.m4b.maps.p019x.C1582i;
import com.google.android.m4b.maps.p019x.C1583h;
import com.google.common.base.C1647e;
import com.google.common.base.C1650g;
import com.google.common.collect.C1872p;
import com.google.common.collect.Sets;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: com.google.android.m4b.maps.o.u */
public final class C1534u implements a, C1500m, C1530a {
    private static final C1582i f1620n;
    private final int f1621a;
    private final int f1622b;
    private final boolean f1623c;
    private final C1532t f1624d;
    private final ArrayList<q> f1625e;
    private final C1533a f1626f;
    private C1575g f1627g;
    private volatile k f1628h;
    private boolean f1629i;
    private volatile boolean f1630j;
    private boolean f1631k;
    private volatile boolean f1632l;
    private final C1582i f1633m;
    private final Set<q> f1634o;
    private final ag f1635p;
    private WeakReference<e> f1636q;
    private float f1637r;
    private final C1514n f1638s;
    private final aw f1639t;

    /* renamed from: com.google.android.m4b.maps.o.u.a */
    public static class C1533a implements Comparator<ac> {
        private int f1618a;
        private int f1619b;

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            ac acVar = (ac) obj;
            ac acVar2 = (ac) obj2;
            int b = acVar.m1449b();
            int b2 = acVar2.m1449b();
            if (b != b2) {
                return b2 - b;
            }
            b = 536870912 >> b;
            b2 = acVar.m1452e() + b;
            int f = acVar.m1453f() + b;
            int e = acVar2.m1452e() + b;
            b += acVar2.m1453f();
            return (Math.abs(b2 - this.f1618a) + Math.abs(f - this.f1619b)) - (Math.abs(b - this.f1619b) + Math.abs(e - this.f1618a));
        }

        public final void m2631a(C1440g c1440g) {
            this.f1618a = c1440g.m1958f();
            this.f1619b = c1440g.m1960g();
        }
    }

    static {
        TileOverlayOptions tileOverlayOptions = new TileOverlayOptions();
        f1620n = new C1583h();
    }

    public static C1534u m2632a(aw awVar, Resources resources, C1514n c1514n, ScheduledExecutorService scheduledExecutorService) {
        int a = m.a(resources, 332);
        C1650g.m3086a(awVar.d() != null, (Object) "TileOverlay.Options must specify a TileProvider");
        C1532t c1532t = new C1532t(awVar.d(), awVar.a(), scheduledExecutorService);
        C1530a c1534u = new C1534u(c1514n, awVar, c1532t, f1620n, a, 332, false);
        c1532t.m2622a(c1534u);
        return c1534u;
    }

    public final void m2639a(e eVar, k kVar) {
        this.f1636q = new WeakReference(eVar);
        this.f1624d.m2621a(eVar);
        this.f1628h = kVar;
        if (this.f1627g == null) {
            this.f1627g = this.f1633m.m2843a(ah.f1036d, this.f1622b, this.f1623c, this.f1635p);
        }
    }

    public final void m2637a(e eVar) {
        this.f1636q = null;
        this.f1628h = null;
        this.f1624d.m2629c();
        C1532t c1532t = this.f1624d;
        synchronized (c1532t.f1610a) {
            for (C1531b a : c1532t.f1610a) {
                a.m2611a();
            }
            c1532t.f1610a.clear();
        }
        this.f1630j = true;
    }

    public final void m2640a(boolean z) {
        this.f1624d.m2628b(z);
        this.f1630j = true;
    }

    public final void m2642b() {
        this.f1624d.m2630d();
        this.f1630j = true;
    }

    private C1534u(C1514n c1514n, aw awVar, C1532t c1532t, C1582i c1582i, int i, int i2, boolean z) {
        this.f1625e = C1872p.m4309a();
        this.f1626f = new C1533a();
        this.f1632l = false;
        this.f1634o = Sets.m4237c();
        this.f1638s = c1514n;
        this.f1639t = awVar;
        this.f1624d = c1532t;
        this.f1633m = c1582i;
        this.f1621a = i;
        this.f1622b = 332;
        this.f1623c = false;
        this.f1635p = new ag();
        m2634a(-1);
    }

    public final void m2634a(int i) {
        if ((i & 2) != 0) {
            synchronized (this.f1638s) {
                this.f1637r = this.f1639t.g();
                this.f1638s.m2515c();
            }
        }
        if ((i & 4) != 0) {
            this.f1638s.m2514b();
        }
    }

    public final void m2633a() {
        synchronized (this.f1638s) {
            this.f1638s.m2510a((C1500m) this);
        }
        this.f1638s.m2514b();
    }

    public final void m2644b(boolean z) {
        k kVar = this.f1628h;
        if (kVar != null && z) {
            kVar.a(true, false);
        }
    }

    public final void m2643b(int i) {
        this.f1629i = (i & 2) != 0;
    }

    public final void m2636a(b bVar, e eVar) {
        this.f1632l = false;
        if (this.f1639t.i()) {
            q a;
            this.f1631k = true;
            List<ac> a2 = this.f1627g.m2812a(bVar);
            if (a2.size() > 1) {
                this.f1626f.m2631a(bVar.d());
                Collections.sort(a2, this.f1626f);
            }
            this.f1634o.addAll(this.f1625e);
            this.f1625e.clear();
            this.f1624d.m2620a();
            boolean z = this.f1629i;
            for (ac acVar : a2) {
                if (z) {
                    a = this.f1624d.m2619a(acVar);
                } else {
                    a = this.f1624d.m2625b(acVar);
                }
                if (a != null) {
                    this.f1625e.add(a);
                    this.f1636q.get();
                    if (!this.f1634o.remove(a)) {
                        a.a(true);
                    }
                    this.f1625e.size();
                    if (this.f1625e.size() == this.f1621a) {
                        break;
                    }
                }
                this.f1624d.m2626b();
            }
            this.f1632l = this.f1625e.size() == a2.size();
            this.f1630j = this.f1629i;
            for (q a3 : this.f1634o) {
                a3.a(false);
            }
            this.f1634o.clear();
        }
    }

    public final void m2638a(e eVar, b bVar, ab abVar) {
        if (this.f1639t.i() && abVar.b() <= 0) {
            ab abVar2 = new ab(abVar);
            if (this.f1630j && !this.f1629i) {
                m2636a(bVar, eVar);
            }
            if (this.f1631k) {
                this.f1624d.m2623a(this.f1625e);
            }
            if (this.f1625e.size() > 0) {
                eVar.z();
                abVar2.a(1);
                ((q) this.f1625e.get(0)).b(eVar, bVar, abVar2);
                Iterator it = this.f1625e.iterator();
                while (it.hasNext()) {
                    q qVar = (q) it.next();
                    if (!this.f1639t.k()) {
                        qVar.d();
                    }
                    qVar.a(eVar, bVar, abVar2);
                }
                eVar.A();
            }
            if (this.f1631k) {
                this.f1624d.m2627b(this.f1625e);
                this.f1631k = false;
            }
        }
    }

    public final boolean m2641a(float f, float f2, C1440g c1440g, b bVar) {
        return false;
    }

    public final void m2635a(long j) {
    }

    public final synchronized boolean m2645c() {
        boolean z;
        z = !this.f1639t.i() || this.f1632l;
        return z;
    }

    public final String m2647e() {
        return this.f1639t.a();
    }

    public final synchronized void m2646d() {
        this.f1628h = null;
        this.f1624d.m2629c();
        this.f1624d.m2622a(null);
    }

    public final void m2649g() {
        this.f1624d.m2624a(false);
        this.f1638s.m2514b();
    }

    public final float m2648f() {
        return this.f1637r;
    }

    public final String toString() {
        return C1647e.m3072a((Object) this).m3069a(ShareConstants.WEB_DIALOG_PARAM_ID, this.f1639t.a()).toString();
    }
}
