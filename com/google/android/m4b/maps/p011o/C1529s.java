package com.google.android.m4b.maps.p011o;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.view.SurfaceView;
import android.view.View;
import com.google.android.m4b.maps.ag.h;
import com.google.android.m4b.maps.ah.C1324a;
import com.google.android.m4b.maps.ah.C1324a.C1323c;
import com.google.android.m4b.maps.ah.C1325b;
import com.google.android.m4b.maps.ay.C1440g;
import com.google.android.m4b.maps.ay.ah;
import com.google.android.m4b.maps.ay.at.C1417a;
import com.google.android.m4b.maps.bh.ao;
import com.google.android.m4b.maps.bh.ao.b;
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

/* renamed from: com.google.android.m4b.maps.o.s */
public class C1529s extends ao implements k {
    private static /* synthetic */ boolean f1581w;
    private final q f1582a;
    private final C1535v f1583b;
    private final C1492a f1584c;
    private final C1514n f1585d;
    private final s f1586e;
    private final bq f1587f;
    private final b f1588g;
    private final a f1589h;
    private final C1506j f1590i;
    private final C1520c f1591j;
    private final C1527a f1592k;
    private final C1505i f1593l;
    private final C1465z.a f1594m;
    private final C1519r f1595n;
    private aa f1596o;
    private ac f1597p;
    private g f1598q;
    private r f1599r;
    private r f1600s;
    private r f1601t;
    private com.google.android.m4b.maps.bh.b f1602u;
    private boolean f1603v;

    /* renamed from: com.google.android.m4b.maps.o.s.c */
    interface C1520c {
        com.google.android.m4b.maps.bh.b m2557a(Context context, Resources resources);

        m m2558a(Resources resources);

        m m2559a(ah ahVar, Resources resources);

        m m2560a(m mVar, Resources resources);

        m m2561b(ah ahVar, Resources resources);
    }

    /* renamed from: com.google.android.m4b.maps.o.s.1 */
    static class C15211 implements C1520c {
        private /* synthetic */ String f1574a;
        private /* synthetic */ C1505i f1575b;

        C15211(String str, C1505i c1505i) {
            this.f1574a = str;
            this.f1575b = c1505i;
        }

        public final /* bridge */ /* synthetic */ m m2563a(Resources resources) {
            n a = m.a(resources, ah.f1038f);
            C1529s.m2578a(a, this.f1574a);
            return a;
        }

        public final m m2564a(ah ahVar, Resources resources) {
            return m.b(ahVar, resources);
        }

        public final m m2566b(ah ahVar, Resources resources) {
            m a = m.a(ahVar, resources);
            C1529s.m2578a(a, this.f1574a);
            return a;
        }

        public final com.google.android.m4b.maps.bh.b m2562a(Context context, Resources resources) {
            return (com.google.android.m4b.maps.bh.b) m.a(context, resources, this.f1575b.m2447f());
        }

        public final m m2565a(m mVar, Resources resources) {
            m a = m.a(mVar.o(), ah.f1033a, resources);
            C1529s.m2578a(a, this.f1574a);
            return a;
        }
    }

    /* renamed from: com.google.android.m4b.maps.o.s.2 */
    class C15222 implements s.b {
        C15222(C1529s c1529s) {
        }
    }

    /* renamed from: com.google.android.m4b.maps.o.s.3 */
    class C15233 implements a {
        private /* synthetic */ C1495d f1576a;

        C15233(C1529s c1529s, C1495d c1495d) {
            this.f1576a = c1495d;
        }

        public final w.a m2567a(w wVar) {
            return new C1496e(wVar, this.f1576a);
        }
    }

    /* renamed from: com.google.android.m4b.maps.o.s.4 */
    class C15244 implements b {
        private /* synthetic */ C1529s f1577a;

        C15244(C1529s c1529s) {
            this.f1577a = c1529s;
        }

        public final void m2568a(C1440g c1440g) {
            if (this.f1577a.f1597p != null) {
                try {
                    this.f1577a.f1597p.a(C1493b.m2360a(c1440g));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
        }

        public final void m2569b(C1440g c1440g) {
            if (this.f1577a.f1596o != null) {
                try {
                    this.f1577a.f1596o.a(C1493b.m2360a(c1440g));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
        }
    }

    /* renamed from: com.google.android.m4b.maps.o.s.5 */
    class C15255 implements Runnable {
        private /* synthetic */ C1529s f1578a;

        C15255(C1529s c1529s) {
            this.f1578a = c1529s;
        }

        public final void run() {
            super.a(true, false);
        }
    }

    /* renamed from: com.google.android.m4b.maps.o.s.6 */
    class C15266 implements ao.a {
        private /* synthetic */ C1513w f1579a;

        C15266(C1529s c1529s, C1513w c1513w) {
            this.f1579a = c1513w;
        }

        public final boolean m2570a(C1440g c1440g) {
            return this.f1579a.m2494f();
        }

        public final boolean m2571b(C1440g c1440g) {
            C1513w c1513w = this.f1579a;
            return false;
        }
    }

    /* renamed from: com.google.android.m4b.maps.o.s.a */
    interface C1527a {
        C1527a() {
        }

        void m2572a() {
            c a = com.google.android.m4b.maps.ag.q.a();
            C1324a.m1056a();
            C1324a.m1058a(C1323c.ON_RESUME, a);
        }

        void m2573b() {
            C1324a.m1059b();
        }
    }

    /* renamed from: com.google.android.m4b.maps.o.s.b */
    static final class C1528b implements s.a {
        private C1505i f1580a;

        private C1528b(C1505i c1505i) {
            this.f1580a = c1505i;
        }

        public final void m2574a(int i) {
            if (this.f1580a != null && this.f1580a.m2445d()) {
                com.google.android.m4b.maps.ag.r.a(C3168f.Theme_ratingBarStyle, "v", "|z=" + i + '|');
            }
        }
    }

    static {
        f1581w = !C1529s.class.desiredAssertionStatus();
    }

    static /* synthetic */ void m2578a(m mVar, String str) {
        if (!C1659k.m3119b(str)) {
            mVar.a(new C1417a().m1685a(str).m1686a());
        }
    }

    public final /* synthetic */ ag.a m2581a(int i, int i2, int i3, int i4) {
        return new C1517q(x(), i, i2, i3, i4);
    }

    public static k m2576a(Context context, Resources resources, com.google.android.m4b.maps.bq.m mVar, ScheduledExecutorService scheduledExecutorService, View view, bu buVar, String str, boolean z) {
        C1498f.m2393a(context, mVar);
        h a = mVar.a();
        q qVar = new q(resources);
        s sVar = new s(a);
        C1505i a2 = C1505i.m2429a(C1608i.m2920a(), new Handler(Looper.getMainLooper()), buVar);
        C1520c c15211 = new C15211(str, a2);
        if (!C1659k.m3119b(str)) {
            p.a(ah.f1042j, context, resources, a);
            p.a(ah.f1045m, context, resources, a);
        }
        return new C1529s(context, resources, qVar, sVar, c15211, a2, new C1527a(), scheduledExecutorService, view, str, z);
    }

    private C1529s(Context context, Resources resources, q qVar, s sVar, C1520c c1520c, C1505i c1505i, C1527a c1527a, ScheduledExecutorService scheduledExecutorService, View view, String str, boolean z) {
        super(context, resources);
        this.f1582a = qVar;
        this.f1582a.a(67.5f);
        this.f1583b = new C1535v(this.f1582a, this);
        a(this.f1582a);
        k(true);
        l(!z);
        this.f1586e = sVar;
        this.f1586e.a(new C15222(this));
        this.f1582a.a(this.f1586e);
        this.f1585d = new C1514n(this, scheduledExecutorService);
        C1495d a = C1495d.m2368a(this, this.f1583b);
        this.f1589h = new C15233(this, a);
        Handler handler = new Handler(Looper.getMainLooper());
        this.f1584c = new C1492a(this, this.f1583b, handler);
        this.f1594m = new C1465z.a(this);
        this.f1590i = C1506j.m2448a(this, handler);
        this.f1593l = c1505i;
        this.f1591j = c1520c;
        if (!C1659k.m3119b(str)) {
            a(this.f1591j.m2561b(ah.f1033a, getResources()));
        }
        this.f1592k = c1527a;
        this.f1595n = new C1519r(view, this, !(this instanceof SurfaceView), com.google.android.m4b.maps.bq.n.a(new Handler(Looper.getMainLooper())));
        this.f1598q = new g(resources, g.a.a);
        this.f1598q.b(true);
        this.f1588g = new C15244(this);
        this.f1587f = new bq(new C15255(this));
        a(this.f1591j.m2561b(ah.f1047o, getResources()));
        C1325b.m1061a();
        a(C1325b.m1062a(resources) ? com.google.android.m4b.maps.ap.c.u : com.google.android.m4b.maps.ap.c.t);
        a(a.m2379c());
        a(this.f1585d);
    }

    private void m2575G() {
        if (this.f1596o == null && this.f1597p == null) {
            a(null);
        } else {
            a(this.f1588g);
        }
    }

    public final void m2582a() {
        this.f1592k.m2572a();
        super.a();
    }

    public final void m2588b() {
        this.f1592k.m2573b();
        super.b();
    }

    public final void m2590c() {
        m2589b(false);
        l(false);
        super.c();
    }

    public final void m2592d() {
        this.f1590i.m2450a();
        this.f1587f.a();
    }

    public final void m2584a(aa aaVar) {
        this.f1596o = aaVar;
        m2575G();
    }

    public final void m2585a(ac acVar) {
        this.f1597p = acVar;
        m2575G();
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    public final void m2586a(C1513w c1513w) {
        if (c1513w == null) {
            a(null);
        } else {
            a(new C15266(this, c1513w));
        }
    }

    public boolean canScrollHorizontally(int i) {
        return z();
    }

    public boolean canScrollVertically(int i) {
        return z();
    }

    public final com.google.android.m4b.maps.bh.ah m2594e() {
        return D().e();
    }

    public final View m2595f() {
        return this;
    }

    public final bh m2596g() {
        return this.f1584c;
    }

    public final a m2597h() {
        return this.f1589h;
    }

    public final ab m2598i() {
        return this.f1585d;
    }

    public final C1465z.a m2599j() {
        return this.f1594m;
    }

    public final bw m2600k() {
        return this.f1593l;
    }

    public final ak m2601l() {
        return this.f1595n;
    }

    public final j m2602m() {
        return this.f1590i;
    }

    public final bk m2603n() {
        return this.f1598q;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        a(i3, i4);
        this.f1598q.a(i, i2, i3, i4);
        m2592d();
    }

    public final boolean m2604o() {
        return this.f1599r != null;
    }

    public final void m2587a(boolean z) {
        if (z) {
            if (this.f1599r == null) {
                this.f1599r = this.f1591j.m2558a(getResources());
                a(this.f1599r);
            }
        } else if (this.f1599r != null) {
            b(this.f1599r);
            this.f1599r = null;
        }
        if (!f1581w) {
            boolean z2;
            if (this.f1599r != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z != z2) {
                throw new AssertionError();
            }
        }
    }

    public final boolean m2605p() {
        return this.f1593l != null && this.f1593l.m2446e();
    }

    public final boolean m2589b(boolean z) {
        if (!(this.f1593l == null || m2605p() == z)) {
            if (!z) {
                this.f1586e.a(null);
                b(this.f1602u);
                this.f1602u.e_();
                this.f1602u = null;
                this.f1593l.m2440b();
            } else if (this.f1593l.m2438a()) {
                this.f1602u = this.f1591j.m2557a(getContext(), getResources());
                a(this.f1602u);
                this.f1586e.a(new C1528b((byte) 0));
            }
        }
        return m2605p();
    }

    public final boolean m2606q() {
        return this.f1600s != null;
    }

    public final void m2591c(boolean z) {
        if (z) {
            if (this.f1600s == null) {
                this.f1600s = this.f1591j.m2560a(E(), getResources());
                a(this.f1600s);
            }
        } else if (this.f1600s != null) {
            b(this.f1600s);
            this.f1600s = null;
        }
        if (!f1581w) {
            boolean z2;
            if (this.f1600s != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z != z2) {
                throw new AssertionError();
            }
        }
    }

    public final void m2583a(int i) {
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
        if (this.f1601t != null) {
            b(this.f1601t);
            this.f1601t = null;
        }
        if (!(ahVar == null || ahVar == ah.f1033a)) {
            this.f1601t = this.f1591j.m2559a(ahVar, getResources());
            a(this.f1601t);
        }
        a(iVar);
    }

    public final boolean m2607r() {
        return this.f1603v;
    }

    public final void m2593d(boolean z) {
        if (this.f1603v != z) {
            this.f1603v = z;
            if (z) {
                a(this.f1598q);
            } else {
                b(this.f1598q);
            }
        }
    }
}
