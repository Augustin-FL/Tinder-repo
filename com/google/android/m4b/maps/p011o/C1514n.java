package com.google.android.m4b.maps.p011o;

import android.content.Context;
import android.content.res.Resources;
import android.os.RemoteException;
import android.util.TypedValue;
import com.google.android.m4b.maps.ag.h;
import com.google.android.m4b.maps.al.b;
import com.google.android.m4b.maps.am.e;
import com.google.android.m4b.maps.ay.C1440g;
import com.google.android.m4b.maps.ay.ah;
import com.google.android.m4b.maps.bh.m;
import com.google.android.m4b.maps.bh.r;
import com.google.android.m4b.maps.bh.r.a;
import com.google.android.m4b.maps.bq.ab;
import com.google.android.m4b.maps.bq.aw;
import com.google.android.m4b.maps.bq.bp;
import com.google.android.m4b.maps.bq.k;
import com.google.android.m4b.maps.bq.o;
import com.google.android.m4b.maps.bq.p;
import com.google.android.m4b.maps.bq.s;
import com.google.android.m4b.maps.bq.u;
import com.google.android.m4b.maps.by.ad;
import com.google.android.m4b.maps.model.LatLng;
import com.google.android.m4b.maps.model.LatLngBounds;
import com.google.android.m4b.maps.model.RuntimeRemoteException;
import com.google.common.collect.C1872p;
import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: com.google.android.m4b.maps.o.n */
public final class C1514n extends r implements ab, C1513w {
    private static final a f1542a;
    private static final Comparator<C1500m> f1543b;
    private final k f1544c;
    private final Set<C1500m> f1545d;
    private final List<C1500m> f1546e;
    private final ScheduledExecutorService f1547f;
    private com.google.android.m4b.maps.bh.k f1548g;
    private e f1549h;
    private ad f1550i;
    private s f1551j;
    private long f1552k;

    /* renamed from: com.google.android.m4b.maps.o.n.1 */
    static class C15111 implements Comparator<C1500m> {
        C15111() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            C1500m c1500m = (C1500m) obj;
            C1500m c1500m2 = (C1500m) obj2;
            int compare = Float.compare(c1500m.m2409f(), c1500m2.m2409f());
            return compare != 0 ? compare : c1500m.m2408e().compareTo(c1500m2.m2408e());
        }
    }

    /* renamed from: com.google.android.m4b.maps.o.n.2 */
    class C15122 implements o.a {
        private /* synthetic */ List f1539a;
        private /* synthetic */ List f1540b;
        private /* synthetic */ C1514n f1541c;

        C15122(C1514n c1514n, List list, List list2) {
            this.f1541c = c1514n;
            this.f1539a = list;
            this.f1540b = list2;
        }

        public final void m2493a() {
            if (this.f1541c.f1551j != null) {
                this.f1541c.f1551j.a(this.f1539a);
            }
            if (this.f1541c.f1550i != null) {
                List b = C1872p.m4317b(this.f1540b.size());
                for (p add : this.f1540b) {
                    b.add(add);
                }
                try {
                    this.f1541c.f1550i.b(b);
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
        }
    }

    static {
        f1542a = a.e;
        f1543b = new C15111();
    }

    public C1514n(k kVar, ScheduledExecutorService scheduledExecutorService) {
        this.f1545d = Sets.m4227a();
        this.f1546e = C1872p.m4309a();
        this.f1544c = kVar;
        this.f1547f = scheduledExecutorService;
        this.f1544c.a(this);
    }

    public final synchronized void m2507a(e eVar, com.google.android.m4b.maps.bh.k kVar) {
        this.f1549h = eVar;
        this.f1548g = kVar;
        for (C1500m a : this.f1546e) {
            a.m2401a(this.f1549h, this.f1548g);
        }
    }

    public final synchronized void m2505a(e eVar) {
        for (C1500m a : this.f1546e) {
            a.m2399a(eVar);
        }
    }

    public final synchronized void m2511a(boolean z) {
        for (C1500m a : this.f1546e) {
            a.m2402a(z);
        }
    }

    public final synchronized void f_() {
        for (C1500m b : this.f1546e) {
            b.m2404b();
        }
    }

    public final synchronized void m2503a(int i) {
        for (C1500m b : this.f1546e) {
            b.m2405b(i);
        }
    }

    final void m2514b() {
        this.f1544c.d();
    }

    public final com.google.android.m4b.maps.bq.ad.a m2498a(com.google.android.m4b.maps.bq.ad adVar, boolean z) {
        if (z) {
            C1500m c1515o = new C1515o(this, adVar);
            m2497b(c1515o);
            return c1515o;
        }
        c1515o = new C1516p(this, adVar);
        m2497b(c1515o);
        return c1515o;
    }

    public final bp.a m2500a(bp bpVar) {
        C1500m c1501h = new C1501h(this, bpVar);
        m2497b(c1501h);
        return c1501h;
    }

    public final u.a m2501a(u uVar) {
        s sVar = this.f1551j;
        Context context = this.f1544c.getContext();
        Resources resources = this.f1544c.getResources();
        ScheduledExecutorService scheduledExecutorService = this.f1547f;
        com.google.android.m4b.maps.bh.p.a(ah.f1056x, new C1509k(h.a(), scheduledExecutorService), context, resources);
        C1500m c1510l = new C1510l(uVar, sVar, m.c(ah.f1056x, resources), this);
        m2497b(c1510l);
        return c1510l;
    }

    public final aw.a m2499a(aw awVar) {
        C1500m a = C1534u.m2632a(awVar, this.f1544c.getResources(), this, this.f1547f);
        m2497b(a);
        return a;
    }

    private void m2497b(C1500m c1500m) {
        synchronized (this) {
            this.f1545d.add(c1500m);
            this.f1546e.add(c1500m);
            m2515c();
            if (this.f1549h != null) {
                c1500m.m2401a(this.f1549h, this.f1548g);
            }
            c1500m.m2397a(this.f1552k);
        }
        m2514b();
    }

    public final void m2508a(s sVar) {
        this.f1551j = sVar;
    }

    public final void m2509a(ad adVar) {
        this.f1550i = adVar;
    }

    final synchronized void m2510a(C1500m c1500m) {
        if (this.f1545d.contains(c1500m)) {
            this.f1546e.remove(c1500m);
            this.f1545d.remove(c1500m);
            c1500m.m2407d();
        }
    }

    final void m2515c() {
        Collections.sort(this.f1546e, f1543b);
        m2514b();
    }

    public final synchronized boolean m2513a(b bVar, e eVar) {
        for (C1500m a : this.f1546e) {
            a.m2398a(bVar, eVar);
        }
        return true;
    }

    public final synchronized void m2506a(e eVar, b bVar, com.google.android.m4b.maps.bh.ab abVar) {
        for (C1500m c1500m : this.f1546e) {
            eVar.z();
            c1500m.m2400a(eVar, bVar, abVar);
            eVar.A();
        }
    }

    public final a m2516d() {
        return f1542a;
    }

    public final synchronized boolean m2512a(float f, float f2, C1440g c1440g, b bVar) {
        boolean z;
        for (C1500m a : C1872p.m4313a(this.f1546e)) {
            if (a.m2403a(f, f2, c1440g, bVar)) {
                z = true;
                break;
            }
        }
        z = false;
        return z;
    }

    public final void m2502a(float f, float f2, C1440g c1440g, b bVar, C1510l c1510l, List<p> list) {
        List a = C1872p.m4309a();
        if (c1510l.m2492g().k()) {
            a.addAll(list);
        }
        for (Object obj : C1872p.m4313a(this.f1546e)) {
            if ((obj instanceof C1510l) && obj != c1510l) {
                ((C1510l) obj).m2476a(f, f2, c1440g, bVar, list, a);
            }
        }
        if (!(a.isEmpty() || this.f1551j == null)) {
            s sVar = this.f1551j;
            float applyDimension = TypedValue.applyDimension(1, 52.0f, this.f1544c.getResources().getDisplayMetrics());
            float a2 = bVar.a(applyDimension, bVar.a(c1440g, true));
            applyDimension = bVar.a(applyDimension, bVar.a(c1440g, true));
            C1440g c1440g2 = new C1440g((int) (((float) c1440g.m1958f()) + a2), (int) (((float) c1440g.m1960g()) - applyDimension));
            C1440g c1440g3 = new C1440g((int) (((float) c1440g.m1958f()) - a2), (int) (applyDimension + ((float) c1440g.m1960g())));
            LatLng a3 = C1493b.m2360a(c1440g2);
            LatLng a4 = C1493b.m2360a(c1440g3);
            LatLngBounds.a b = LatLngBounds.b();
            b.a(a3);
            b.a(a4);
            sVar.a(b.a(), a);
        }
        if (this.f1550i != null) {
            List b2 = C1872p.m4317b(list.size());
            for (p add : list) {
                b2.add(add);
            }
            try {
                this.f1550i.a(b2);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        h.a().c(new o(list, new C15122(this, a, list)));
    }

    public final synchronized void m2504a(long j) {
        this.f1552k = j;
        for (C1500m a : this.f1546e) {
            a.m2397a(j);
        }
    }

    public final synchronized boolean m2517e() {
        boolean z;
        for (C1500m c : this.f1546e) {
            if (!c.m2406c()) {
                z = false;
                break;
            }
        }
        z = true;
        return z;
    }

    public final boolean m2518f() {
        if (this.f1551j != null) {
            this.f1551j.b();
        }
        return false;
    }
}
