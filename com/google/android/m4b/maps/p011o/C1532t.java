package com.google.android.m4b.maps.p011o;

import com.facebook.stetho.BuildConfig;
import com.google.android.m4b.maps.ak.a;
import com.google.android.m4b.maps.ak.a.d;
import com.google.android.m4b.maps.am.e;
import com.google.android.m4b.maps.ay.ac;
import com.google.android.m4b.maps.ay.ah;
import com.google.android.m4b.maps.ay.bg;
import com.google.android.m4b.maps.bm.f;
import com.google.android.m4b.maps.bm.q;
import com.google.android.m4b.maps.bm.u;
import com.google.android.m4b.maps.cf.b;
import com.google.android.m4b.maps.model.Tile;
import com.google.android.m4b.maps.model.ad;
import com.google.android.m4b.maps.p010n.C1489b;
import com.google.common.base.C1650g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.m4b.maps.o.t */
public final class C1532t {
    private static q f1609b;
    final Set<C1531b> f1610a;
    private final d f1611c;
    private final ad f1612d;
    private final ScheduledExecutorService f1613e;
    private final Set<ac> f1614f;
    private volatile e f1615g;
    private final a f1616h;
    private volatile C1530a f1617i;

    /* renamed from: com.google.android.m4b.maps.o.t.a */
    public interface C1530a {
        void m2608b(boolean z);
    }

    /* renamed from: com.google.android.m4b.maps.o.t.b */
    class C1531b implements Runnable {
        private final Random f1604a;
        private final ac f1605b;
        private ScheduledFuture f1606c;
        private int f1607d;
        private /* synthetic */ C1532t f1608e;

        public C1531b(C1532t c1532t, ac acVar, Random random) {
            this.f1608e = c1532t;
            this.f1606c = null;
            this.f1607d = 0;
            this.f1605b = acVar;
            this.f1604a = random;
            c1532t.f1610a.add(this);
        }

        public final synchronized void m2611a() {
            if (this.f1606c != null) {
                this.f1606c.cancel(false);
                this.f1606c = null;
            }
        }

        private synchronized void m2610b() {
            this.f1606c = null;
            this.f1608e.f1610a.remove(this);
            C1532t.m2616a(this.f1608e, this.f1605b);
        }

        private synchronized void m2609a(Tile tile) {
            boolean z = true;
            synchronized (this) {
                C1650g.m3086a(tile.a > 0, (Object) "width of tile image must be positive");
                if (tile.b <= 0) {
                    z = false;
                }
                C1650g.m3086a(z, (Object) "height of tile image must be positive");
                try {
                    bg bgVar = new bg(this.f1605b, 0, tile.a, tile.b, tile.c, ah.f1052t);
                    this.f1606c = null;
                    this.f1608e.f1610a.remove(this);
                    C1532t.m2617a(this.f1608e, this.f1605b, bgVar);
                } catch (IOException e) {
                    m2610b();
                }
            }
        }

        public final synchronized void run() {
            Tile a = this.f1608e.f1612d.a(this.f1605b.m1450c(), this.f1605b.m1451d(), this.f1605b.m1449b());
            if (a == null) {
                int i = this.f1607d;
                this.f1607d = i + 1;
                long pow = (long) ((200.0d * Math.pow(2.0d, (double) i)) + ((double) this.f1604a.nextInt(100)));
                if (pow < 300000) {
                    this.f1606c = this.f1608e.f1613e.schedule(this, pow, TimeUnit.MILLISECONDS);
                } else {
                    m2610b();
                }
            } else if (a == ad.a) {
                m2610b();
            } else {
                m2609a(a);
            }
        }
    }

    static /* synthetic */ void m2616a(C1532t c1532t, ac acVar) {
        C1650g.m3091b(c1532t.f1615g != null);
        c1532t.m2615a(acVar, f1609b, c1532t.f1615g);
    }

    static /* synthetic */ void m2617a(C1532t c1532t, ac acVar, bg bgVar) {
        C1650g.m3091b(c1532t.f1615g != null);
        e eVar = c1532t.f1615g;
        q qVar = null;
        if (eVar != null) {
            qVar = f.a(bgVar, eVar);
        }
        c1532t.m2615a(acVar, qVar, eVar);
    }

    static {
        f1609b = new u();
    }

    public C1532t(ad adVar, String str, ScheduledExecutorService scheduledExecutorService) {
        this.f1614f = Collections.synchronizedSet(new HashSet());
        this.f1610a = Collections.synchronizedSet(new HashSet());
        C1650g.m3080a((Object) adVar);
        C1650g.m3080a((Object) scheduledExecutorService);
        this.f1612d = adVar;
        this.f1611c = new d(ah.f1052t, null, C1532t.m2612a(Integer.valueOf(str.replaceAll("\\D", BuildConfig.FLAVOR)).intValue()));
        this.f1613e = scheduledExecutorService;
        a.a(new b());
        this.f1616h = a.a();
    }

    private static com.google.android.m4b.maps.bg.a m2612a(int i) {
        Object obj = new int[32];
        int i2 = 0;
        int i3 = 0;
        while (i2 < 32) {
            int i4;
            if (((1 << i2) & i) != 0) {
                i4 = i3 + 1;
                obj[i3] = i2;
            } else {
                i4 = i3;
            }
            i2++;
            i3 = i4;
        }
        Object obj2 = new int[i3];
        System.arraycopy(obj, 0, obj2, 0, i3);
        return com.google.android.m4b.maps.bg.a.a(obj2);
    }

    public final void m2622a(C1530a c1530a) {
        boolean z = true;
        if (this.f1617i == null) {
            if (c1530a == null) {
                z = false;
            }
            C1650g.m3085a(z);
        } else {
            if (c1530a != null) {
                z = false;
            }
            C1650g.m3085a(z);
        }
        this.f1617i = c1530a;
    }

    public final void m2621a(e eVar) {
        C1650g.m3081a((Object) eVar, (Object) "state must not be null.");
        this.f1615g = eVar;
    }

    public final q m2619a(ac acVar) {
        return m2613a(acVar, false);
    }

    public final q m2625b(ac acVar) {
        q a = m2613a(acVar, true);
        if (a != null) {
            return a;
        }
        if (this.f1614f.add(acVar)) {
            this.f1613e.execute(new C1531b(this, acVar, new Random()));
        }
        return null;
    }

    private q m2613a(ac acVar, boolean z) {
        if (this.f1615g == null) {
            return null;
        }
        return this.f1616h.a(this.f1615g, this.f1611c, acVar, z);
    }

    public final void m2620a() {
        C1650g.m3091b(this.f1615g != null);
        this.f1616h.d(this.f1615g, this.f1611c);
    }

    public final void m2626b() {
        C1650g.m3091b(this.f1615g != null);
        if (C1489b.f1447a) {
            this.f1616h.c(this.f1615g, this.f1611c);
        }
    }

    public final void m2623a(List<q> list) {
        C1650g.m3091b(this.f1615g != null);
        List arrayList = new ArrayList(list.size());
        for (q qVar : list) {
            if (qVar != f1609b) {
                arrayList.add(qVar.b());
            }
        }
        this.f1616h.a(this.f1615g, this.f1611c, arrayList);
    }

    public final void m2627b(List<q> list) {
        C1650g.m3091b(this.f1615g != null);
        List arrayList = new ArrayList(list.size());
        for (q qVar : list) {
            if (qVar != f1609b) {
                arrayList.add(qVar.b());
            }
        }
        this.f1616h.b(this.f1615g, this.f1611c, arrayList);
    }

    public final void m2629c() {
        if (this.f1615g != null) {
            this.f1616h.b(this.f1615g, this.f1611c);
        }
    }

    public final void m2624a(boolean z) {
        e eVar = this.f1615g;
        if (eVar != null) {
            this.f1616h.a(eVar, this.f1611c);
        }
    }

    public final void m2628b(boolean z) {
        this.f1616h.a(z);
    }

    public final void m2630d() {
        this.f1616h.b();
    }

    private void m2615a(ac acVar, q qVar, e eVar) {
        if (this.f1616h != null) {
            this.f1616h.a(eVar, this.f1611c, acVar, qVar);
        }
        this.f1614f.remove(acVar);
        boolean z = qVar != null;
        C1530a c1530a = this.f1617i;
        if (c1530a != null) {
            c1530a.m2608b(z);
        }
    }
}
