package com.google.android.m4b.maps.p011o;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.view.View;
import com.google.android.m4b.maps.ag.h;
import com.google.android.m4b.maps.ah.C1324a;
import com.google.android.m4b.maps.ah.C1324a.C1323c;
import com.google.android.m4b.maps.ah.C1325b;
import com.google.android.m4b.maps.ay.C1440g;
import com.google.android.m4b.maps.ay.ah;
import com.google.android.m4b.maps.ay.at.C1417a;
import com.google.android.m4b.maps.bh.ap;
import com.google.android.m4b.maps.bh.ap.b;
import com.google.android.m4b.maps.bh.g;
import com.google.android.m4b.maps.bh.i;
import com.google.android.m4b.maps.bh.m;
import com.google.android.m4b.maps.bh.n;
import com.google.android.m4b.maps.bh.p;
import com.google.android.m4b.maps.bh.q;
import com.google.android.m4b.maps.bh.r;
import com.google.android.m4b.maps.bh.s;
import com.google.android.m4b.maps.bq.C1465z;
import com.google.android.m4b.maps.bq.ab;
import com.google.android.m4b.maps.bq.ag;
import com.google.android.m4b.maps.bq.ak;
import com.google.android.m4b.maps.bq.bh;
import com.google.android.m4b.maps.bq.bk;
import com.google.android.m4b.maps.bq.bq;
import com.google.android.m4b.maps.bq.bu;
import com.google.android.m4b.maps.bq.bw;
import com.google.android.m4b.maps.bq.j;
import com.google.android.m4b.maps.bq.k;
import com.google.android.m4b.maps.bq.w;
import com.google.android.m4b.maps.bq.x.a;
import com.google.android.m4b.maps.by.aa;
import com.google.android.m4b.maps.by.ac;
import com.google.android.m4b.maps.e.c;
import com.google.android.m4b.maps.model.RuntimeRemoteException;
import com.google.android.m4b.maps.p021z.C1608i;
import com.google.common.base.C1659k;
import com.viewpagerindicator.C3169d.C3168f;
import java.util.concurrent.ScheduledExecutorService;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.google.android.m4b.maps.o.x */
public class C1545x extends ap implements k {
    private static /* synthetic */ boolean f1657w;
    private final q f1658a;
    private final C1535v f1659b;
    private final C1492a f1660c;
    private final C1514n f1661d;
    private final s f1662e;
    private final bq f1663f;
    private final b f1664g;
    private final a f1665h;
    private final C1506j f1666i;
    private final C1536c f1667j;
    private final C1543a f1668k;
    private final C1505i f1669l;
    private final C1465z.a f1670m;
    private final C1519r f1671n;
    private aa f1672o;
    private ac f1673p;
    private g f1674q;
    private r f1675r;
    private r f1676s;
    private r f1677t;
    private com.google.android.m4b.maps.bh.b f1678u;
    private boolean f1679v;

    /* renamed from: com.google.android.m4b.maps.o.x.c */
    interface C1536c {
        com.google.android.m4b.maps.bh.b m2668a(Context context, Resources resources);

        m m2669a(Resources resources);

        m m2670a(ah ahVar, Resources resources);

        m m2671a(m mVar, Resources resources);

        m m2672b(ah ahVar, Resources resources);
    }

    /* renamed from: com.google.android.m4b.maps.o.x.1 */
    static class C15371 implements C1536c {
        private /* synthetic */ String f1650a;
        private /* synthetic */ C1505i f1651b;

        C15371(String str, C1505i c1505i) {
            this.f1650a = str;
            this.f1651b = c1505i;
        }

        public final /* bridge */ /* synthetic */ m m2674a(Resources resources) {
            n a = m.a(resources, ah.f1038f);
            C1545x.m2689a(a, this.f1650a);
            return a;
        }

        public final m m2675a(ah ahVar, Resources resources) {
            return m.b(ahVar, resources);
        }

        public final m m2677b(ah ahVar, Resources resources) {
            m a = m.a(ahVar, resources);
            C1545x.m2689a(a, this.f1650a);
            return a;
        }

        public final com.google.android.m4b.maps.bh.b m2673a(Context context, Resources resources) {
            return (com.google.android.m4b.maps.bh.b) m.a(context, resources, this.f1651b.m2447f());
        }

        public final m m2676a(m mVar, Resources resources) {
            m a = m.a(mVar.o(), ah.f1033a, resources);
            C1545x.m2689a(a, this.f1650a);
            return a;
        }
    }

    /* renamed from: com.google.android.m4b.maps.o.x.2 */
    class C15382 implements s.b {
        C15382(C1545x c1545x) {
        }
    }

    /* renamed from: com.google.android.m4b.maps.o.x.3 */
    class C15393 implements a {
        private /* synthetic */ C1495d f1652a;

        C15393(C1545x c1545x, C1495d c1495d) {
            this.f1652a = c1495d;
        }

        public final w.a m2678a(w wVar) {
            return new C1496e(wVar, this.f1652a);
        }
    }

    /* renamed from: com.google.android.m4b.maps.o.x.4 */
    class C15404 implements b {
        private /* synthetic */ C1545x f1653a;

        C15404(C1545x c1545x) {
            this.f1653a = c1545x;
        }

        public final void m2679a(C1440g c1440g) {
            if (this.f1653a.f1673p != null) {
                try {
                    this.f1653a.f1673p.a(C1493b.m2360a(c1440g));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
        }

        public final void m2680b(C1440g c1440g) {
            if (this.f1653a.f1672o != null) {
                try {
                    this.f1653a.f1672o.a(C1493b.m2360a(c1440g));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
        }
    }

    /* renamed from: com.google.android.m4b.maps.o.x.5 */
    class C15415 implements Runnable {
        private /* synthetic */ C1545x f1654a;

        C15415(C1545x c1545x) {
            this.f1654a = c1545x;
        }

        public final void run() {
            super.a(true, false);
        }
    }

    /* renamed from: com.google.android.m4b.maps.o.x.6 */
    class C15426 implements ap.a {
        private /* synthetic */ C1513w f1655a;

        C15426(C1545x c1545x, C1513w c1513w) {
            this.f1655a = c1513w;
        }

        public final boolean m2681a(C1440g c1440g) {
            return this.f1655a.m2494f();
        }

        public final boolean m2682b(C1440g c1440g) {
            C1513w c1513w = this.f1655a;
            return false;
        }
    }

    /* renamed from: com.google.android.m4b.maps.o.x.a */
    interface C1543a {
        C1543a() {
        }

        void m2683a() {
            c a = com.google.android.m4b.maps.ag.q.a();
            C1324a.m1056a();
            C1324a.m1058a(C1323c.ON_RESUME, a);
        }

        void m2684b() {
            C1324a.m1059b();
        }
    }

    /* renamed from: com.google.android.m4b.maps.o.x.b */
    static final class C1544b implements s.a {
        private C1505i f1656a;

        private C1544b(C1505i c1505i) {
            this.f1656a = c1505i;
        }

        public final void m2685a(int i) {
            if (this.f1656a != null && this.f1656a.m2445d()) {
                com.google.android.m4b.maps.ag.r.a(C3168f.Theme_ratingBarStyle, "v", "|z=" + i + '|');
            }
        }
    }

    static {
        f1657w = !C1545x.class.desiredAssertionStatus();
    }

    static /* synthetic */ void m2689a(m mVar, String str) {
        if (!C1659k.m3119b(str)) {
            mVar.a(new C1417a().m1685a(str).m1686a());
        }
    }

    public final /* synthetic */ ag.a m2692a(int i, int i2, int i3, int i4) {
        return new C1517q(x(), i, i2, i3, i4);
    }

    public static k m2687a(Context context, Resources resources, com.google.android.m4b.maps.bq.m mVar, ScheduledExecutorService scheduledExecutorService, View view, bu buVar, String str, boolean z) {
        C1498f.m2393a(context, mVar);
        h a = mVar.a();
        q qVar = new q(resources);
        s sVar = new s(a);
        C1505i a2 = C1505i.m2429a(C1608i.m2920a(), new Handler(Looper.getMainLooper()), buVar);
        C1536c c15371 = new C15371(str, a2);
        if (!C1659k.m3119b(str)) {
            p.a(ah.f1042j, context, resources, a);
            p.a(ah.f1045m, context, resources, a);
        }
        return new C1545x(context, resources, qVar, sVar, c15371, a2, new C1543a(), scheduledExecutorService, view, str, z);
    }

    private C1545x(Context context, Resources resources, q qVar, s sVar, C1536c c1536c, C1505i c1505i, C1543a c1543a, ScheduledExecutorService scheduledExecutorService, View view, String str, boolean z) {
        super(context, resources);
        this.f1658a = qVar;
        this.f1658a.a(67.5f);
        this.f1659b = new C1535v(this.f1658a, this);
        a(this.f1658a);
        k(true);
        l(!z);
        this.f1662e = sVar;
        this.f1662e.a(new C15382(this));
        this.f1658a.a(this.f1662e);
        this.f1661d = new C1514n(this, scheduledExecutorService);
        C1495d a = C1495d.m2368a(this, this.f1659b);
        this.f1665h = new C15393(this, a);
        Handler handler = new Handler(Looper.getMainLooper());
        this.f1660c = new C1492a(this, this.f1659b, handler);
        this.f1670m = new C1465z.a(this);
        this.f1666i = C1506j.m2448a(this, handler);
        this.f1669l = c1505i;
        this.f1667j = c1536c;
        if (!C1659k.m3119b(str)) {
            a(this.f1667j.m2672b(ah.f1033a, getResources()));
        }
        this.f1668k = c1543a;
        this.f1671n = new C1519r(view, this, false, com.google.android.m4b.maps.bq.n.a(new Handler(Looper.getMainLooper())));
        this.f1674q = new g(resources, g.a.a);
        this.f1674q.b(true);
        this.f1664g = new C15404(this);
        this.f1663f = new bq(new C15415(this));
        a(this.f1667j.m2672b(ah.f1047o, getResources()));
        C1325b.m1061a();
        a(C1325b.m1062a(resources) ? com.google.android.m4b.maps.ap.c.u : com.google.android.m4b.maps.ap.c.t);
        a(a.m2379c());
        a(this.f1661d);
    }

    private void m2686G() {
        if (this.f1672o == null && this.f1673p == null) {
            a(null);
        } else {
            a(this.f1664g);
        }
    }

    public final void m2693a() {
        this.f1668k.m2683a();
        super.a();
    }

    public final void m2699b() {
        this.f1668k.m2684b();
        super.b();
    }

    public final void m2701c() {
        m2700b(false);
        l(false);
        super.c();
    }

    public final void m2703d() {
        this.f1666i.m2450a();
        this.f1663f.a();
    }

    public final void m2695a(aa aaVar) {
        this.f1672o = aaVar;
        m2686G();
    }

    public final void m2696a(ac acVar) {
        this.f1673p = acVar;
        m2686G();
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    public final void m2697a(C1513w c1513w) {
        if (c1513w == null) {
            a(null);
        } else {
            a(new C15426(this, c1513w));
        }
    }

    public boolean canScrollHorizontally(int i) {
        return z();
    }

    public boolean canScrollVertically(int i) {
        return z();
    }

    public final com.google.android.m4b.maps.bh.ah m2705e() {
        return D().e();
    }

    public final View m2706f() {
        return this;
    }

    public final bh m2707g() {
        return this.f1660c;
    }

    public final a m2708h() {
        return this.f1665h;
    }

    public final ab m2709i() {
        return this.f1661d;
    }

    public final C1465z.a m2710j() {
        return this.f1670m;
    }

    public final bw m2711k() {
        return this.f1669l;
    }

    public final ak m2712l() {
        return this.f1671n;
    }

    public final j m2713m() {
        return this.f1666i;
    }

    public final bk m2714n() {
        return this.f1674q;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        a(i3, i4);
        this.f1674q.a(i, i2, i3, i4);
        m2703d();
    }

    public final boolean m2715o() {
        return this.f1675r != null;
    }

    public final void m2698a(boolean z) {
        if (z) {
            if (this.f1675r == null) {
                this.f1675r = this.f1667j.m2669a(getResources());
                a(this.f1675r);
            }
        } else if (this.f1675r != null) {
            b(this.f1675r);
            this.f1675r = null;
        }
        if (!f1657w) {
            boolean z2;
            if (this.f1675r != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z != z2) {
                throw new AssertionError();
            }
        }
    }

    public final boolean m2716p() {
        return this.f1669l != null && this.f1669l.m2446e();
    }

    public final boolean m2700b(boolean z) {
        if (!(this.f1669l == null || m2716p() == z)) {
            if (!z) {
                this.f1662e.a(null);
                b(this.f1678u);
                this.f1678u.e_();
                this.f1678u = null;
                this.f1669l.m2440b();
            } else if (this.f1669l.m2438a()) {
                this.f1678u = this.f1667j.m2668a(getContext(), getResources());
                a(this.f1678u);
                this.f1662e.a(new C1544b((byte) 0));
            }
        }
        return m2716p();
    }

    public final boolean m2717q() {
        return this.f1676s != null;
    }

    public final void m2702c(boolean z) {
        if (z) {
            if (this.f1676s == null) {
                this.f1676s = this.f1667j.m2671a(E(), getResources());
                a(this.f1676s);
            }
        } else if (this.f1676s != null) {
            b(this.f1676s);
            this.f1676s = null;
        }
        if (!f1657w) {
            boolean z2;
            if (this.f1676s != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z != z2) {
                throw new AssertionError();
            }
        }
    }

    public final void m2694a(int i) {
        i iVar;
        ah ahVar;
        switch (i) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                iVar = i.e;
                ahVar = null;
                break;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                ahVar = ah.f1036d;
                iVar = i.e;
                break;
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                ahVar = ah.f1037e;
                iVar = i.d;
                break;
            case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                ahVar = ah.f1036d;
                iVar = i.b;
                break;
            default:
                ahVar = ah.f1033a;
                iVar = i.a;
                break;
        }
        if (this.f1677t != null) {
            b(this.f1677t);
            this.f1677t = null;
        }
        if (!(ahVar == null || ahVar == ah.f1033a)) {
            this.f1677t = this.f1667j.m2670a(ahVar, getResources());
            a(this.f1677t);
        }
        a(iVar);
    }

    public final boolean m2718r() {
        return this.f1679v;
    }

    public final void m2704d(boolean z) {
        if (this.f1679v != z) {
            this.f1679v = z;
            if (z) {
                a(this.f1674q);
            } else {
                b(this.f1674q);
            }
        }
    }
}
