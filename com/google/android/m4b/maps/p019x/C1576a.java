package com.google.android.m4b.maps.p019x;

import com.google.android.m4b.maps.al.b;
import com.google.android.m4b.maps.ay.C1420n;
import com.google.android.m4b.maps.ay.C1440g;
import com.google.android.m4b.maps.ay.C1448m;
import com.google.android.m4b.maps.ay.ac;
import com.google.android.m4b.maps.ay.af;
import com.google.android.m4b.maps.ay.bd;
import com.google.android.m4b.maps.ay.bh;
import com.google.android.m4b.maps.ay.bi;
import com.google.android.m4b.maps.ay.bj;
import com.google.android.m4b.maps.ay.bj.C1433a;
import com.google.android.m4b.maps.ba.d;
import com.google.android.m4b.maps.bg.f;
import com.google.android.m4b.maps.p009m.C1480a.C1483c;
import com.google.android.m4b.maps.p009m.C1486c;
import com.google.android.m4b.maps.p021z.C1590a;
import com.google.android.m4b.maps.p021z.C1595c;
import com.google.android.m4b.maps.p021z.C1608i;
import com.google.common.collect.C1872p;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.m4b.maps.x.a */
public final class C1576a implements C1575g {
    private final C1575g f1777a;
    private final C1595c f1778b;
    private volatile boolean f1779c;
    private List<ac> f1780d;
    private List<ac> f1781e;
    private Set<ac> f1782f;
    private Set<C1483c> f1783g;
    private C1483c f1784h;
    private bj f1785i;
    private final f<ac, Collection<C1590a>> f1786j;
    private final C1608i f1787k;
    private long f1788l;

    public C1576a(C1575g c1575g, C1595c c1595c, d dVar, int i, C1608i c1608i) {
        this.f1779c = false;
        this.f1784h = null;
        this.f1785i = null;
        this.f1788l = 0;
        this.f1777a = c1575g;
        this.f1778b = c1595c;
        this.f1786j = new f(i);
        this.f1787k = c1608i;
    }

    private void m2813e(b bVar) {
        List<ac> a = this.f1777a.m2812a(bVar);
        if (this.f1779c || a == null || !a.equals(this.f1780d)) {
            this.f1788l++;
            this.f1779c = false;
            bh c = this.f1787k.m2945c();
            Object a2;
            if (c != null) {
                a2 = c.m1796a();
            } else {
                a2 = null;
            }
            Iterable a3 = Sets.m4227a();
            Set a4 = Sets.m4227a();
            Set a5 = Sets.m4227a();
            for (ac acVar : a) {
                Collection collection = (Collection) this.f1786j.b(acVar);
                if (collection == null) {
                    collection = this.f1778b.m2867a(acVar);
                    if (collection != C1595c.f1832a) {
                        this.f1786j.c(acVar, collection);
                    }
                }
                for (C1590a c1590a : r3) {
                    bd bdVar;
                    af afVar;
                    a5.add(c1590a.m2852a());
                    C1486c a6 = this.f1787k.m2931a(c1590a.m2852a());
                    if (a6 == null) {
                        bdVar = null;
                    } else {
                        bdVar = new C1433a().m1814a(a6).m1815a();
                    }
                    if (bdVar != null) {
                        afVar = new af();
                        afVar.m1470a(bdVar);
                        a3.add(acVar.m1444a(afVar));
                    }
                    synchronized (this) {
                        if (c1590a.m2852a().equals(this.f1784h)) {
                            afVar = new af();
                            afVar.m1470a(this.f1785i);
                            a3.add(acVar.m1444a(afVar));
                        }
                    }
                    if (bdVar != null && c1590a.m2852a().equals(r4)) {
                        int b = c.m1798b(bdVar.m1822c());
                        if (b != -1) {
                            List b2 = c.m1799b();
                            int max = Math.max(b - 1, 0);
                            int min = Math.min((b + 1) + 1, b2.size());
                            for (int i = max; i < min; i++) {
                                if (i != b) {
                                    af afVar2 = new af();
                                    afVar2.m1470a(bj.m1816a(((bi) b2.get(i)).m1808a()));
                                    Object a7 = acVar.m1444a(afVar2);
                                    ac a8 = m2816a((ac) a7, bVar.c());
                                    if (a8 != null) {
                                        ac acVar2 = a8;
                                    }
                                    a4.add(a7);
                                }
                            }
                        }
                    }
                }
            }
            this.f1780d = a;
            this.f1781e = C1872p.m4310a(a3);
            this.f1782f = a4;
            this.f1783g = a5;
        }
    }

    public final List<ac> m2818a(b bVar) {
        m2813e(bVar);
        return this.f1781e;
    }

    public final long m2815a() {
        return this.f1788l;
    }

    public final Set<ac> m2820b(b bVar) {
        m2813e(bVar);
        return this.f1782f;
    }

    public final Set<C1483c> m2822c(b bVar) {
        m2813e(bVar);
        return this.f1783g;
    }

    public final C1483c m2824d(b bVar) {
        double d = 8.0d;
        C1483c c1483c = null;
        m2813e(bVar);
        for (Object obj : this.f1780d) {
            if (obj.m1456i().m2046a(bVar.d())) {
                break;
            }
        }
        Object obj2 = null;
        Collection<C1590a> collection = (Collection) this.f1786j.b(obj2);
        if (collection != null) {
            C1440g d2 = bVar.d();
            double n = (double) bVar.n();
            if (n > 19.0d) {
                d = 8.0d / Math.pow(2.0d, n - 19.0d);
            }
            C1420n a = C1448m.m2040a(d2, (int) (d * d2.m1956e()));
            float f = 0.0f;
            for (C1590a c1590a : collection) {
                C1483c a2;
                float f2;
                if (c1590a.m2854a(a)) {
                    float d3 = c1590a.m2856c().m1954d(d2);
                    if (c1483c == null || d3 < f) {
                        a2 = c1590a.m2852a();
                        f2 = d3;
                        f = f2;
                        c1483c = a2;
                    }
                }
                a2 = c1483c;
                f2 = f;
                f = f2;
                c1483c = a2;
            }
        }
        return c1483c;
    }

    public final void m2821b() {
        this.f1779c = true;
    }

    public final synchronized void m2819a(C1483c c1483c, C1486c c1486c) {
        this.f1784h = c1483c;
        this.f1785i = new C1433a().m1814a(c1486c).m1815a();
        this.f1779c = true;
    }

    public final synchronized void m2823c() {
        this.f1784h = null;
        this.f1785i = null;
        this.f1779c = true;
    }

    public final ac m2816a(ac acVar, C1440g c1440g) {
        return this.f1777a.m2810a(acVar, c1440g);
    }

    public final float m2814a(C1440g c1440g) {
        return this.f1777a.m2808a(c1440g);
    }

    public final List<ac> m2817a(int i, C1440g c1440g) {
        return ImmutableList.m3656g();
    }
}
