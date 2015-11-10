package com.google.android.m4b.maps.p021z;

import com.google.android.m4b.maps.ad.b;
import com.google.android.m4b.maps.ay.bh;
import com.google.android.m4b.maps.ay.bi;
import com.google.android.m4b.maps.ba.d;
import com.google.android.m4b.maps.bg.f;
import com.google.android.m4b.maps.bq.bs;
import com.google.android.m4b.maps.bq.bv;
import com.google.android.m4b.maps.bq.bx;
import com.google.android.m4b.maps.p009m.C1480a.C1483c;
import com.google.android.m4b.maps.p009m.C1486c;
import com.google.common.collect.C1872p;
import com.google.common.collect.C1876q;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: com.google.android.m4b.maps.z.i */
public final class C1608i implements b {
    private static C1608i f1860c;
    private static final C1486c f1861q;
    private final Map<C1607a, Object> f1862a;
    private final Map<bx, Object> f1863b;
    private final f<C1483c, C1486c> f1864d;
    private final f<C1483c, C1486c> f1865e;
    private C1483c f1866f;
    private C1486c f1867g;
    private bh f1868h;
    private final Set<C1483c> f1869i;
    private final List<bs> f1870j;
    private final Set<C1483c> f1871k;
    private final Object f1872l;
    private final d f1873m;
    private final Map<Integer, C1600f> f1874n;
    private final Map<C1483c, C1600f> f1875o;
    private final C1595c f1876p;
    private volatile C1486c f1877r;
    private volatile C1486c f1878s;

    /* renamed from: com.google.android.m4b.maps.z.i.1 */
    class C16061 implements b {
        private /* synthetic */ C1608i f1859a;

        C16061(C1608i c1608i) {
            this.f1859a = c1608i;
        }

        public final void m2915a(C1483c c1483c, int i, bh bhVar) {
            if (i != 2 && i == 0) {
                this.f1859a.m2927e(bhVar);
            }
        }
    }

    /* renamed from: com.google.android.m4b.maps.z.i.a */
    public interface C1607a {
        void m2916a(bs bsVar);

        void m2917a(C1608i c1608i);

        void m2918c();
    }

    static {
        f1861q = new C1486c(new C1483c(0, 0), 0);
    }

    public static C1608i m2921a(d dVar) {
        if (f1860c == null) {
            f1860c = new C1608i(dVar);
        }
        return f1860c;
    }

    public static C1608i m2920a() {
        return f1860c;
    }

    private C1608i(d dVar) {
        this.f1862a = Collections.synchronizedMap(new WeakHashMap());
        this.f1863b = Collections.synchronizedMap(new WeakHashMap());
        this.f1869i = Sets.m4227a();
        this.f1870j = C1872p.m4309a();
        this.f1871k = Sets.m4227a();
        this.f1872l = new Object();
        this.f1874n = C1876q.m4328a();
        this.f1875o = Collections.synchronizedMap(new HashMap());
        this.f1864d = new f(100);
        this.f1865e = new f(100);
        this.f1873m = dVar;
        this.f1876p = new C1598d();
    }

    public final void m2938a(C1607a c1607a) {
        this.f1862a.put(c1607a, null);
    }

    public final void m2943b(C1607a c1607a) {
        this.f1862a.remove(c1607a);
    }

    public final void m2934a(bx bxVar) {
        this.f1863b.put(bxVar, null);
    }

    public final void m2935a(C1483c c1483c, int i, bh bhVar) {
        C1486c c1486c = null;
        if (i != 2 && i == 0) {
            Object obj;
            synchronized (this.f1872l) {
                if (this.f1867g != null && this.f1867g.m2309a().equals(c1483c)) {
                    c1486c = this.f1867g;
                    this.f1867g = null;
                }
            }
            if (c1486c != null) {
                bi a = bhVar.m1795a(c1486c);
                if (a != null) {
                    for (C1483c c1483c2 : a.m1810c()) {
                        if (m2924a(c1483c2, a.m1808a())) {
                            m2922a(c1483c2, new C16061(this));
                        }
                    }
                }
            }
            m2919a(bhVar);
            synchronized (this.f1872l) {
                if (c1483c.equals(this.f1866f)) {
                    if (this.f1868h == null || !bhVar.m1796a().equals(this.f1868h.m1796a())) {
                        if (!bhVar.m1799b().isEmpty()) {
                            this.f1868h = bhVar;
                            int i2 = 1;
                        } else if (this.f1868h != null) {
                            this.f1868h = null;
                            obj = 1;
                        }
                        this.f1866f = null;
                    }
                    obj = null;
                    this.f1866f = null;
                } else {
                    obj = null;
                }
            }
            if (obj != null) {
                m2928i();
            }
            synchronized (this.f1872l) {
                if (this.f1869i.contains(c1483c)) {
                    this.f1869i.remove(c1483c);
                    this.f1870j.add(bhVar);
                    obj = 1;
                } else {
                    obj = null;
                }
            }
            if (obj != null) {
                m2929j();
            }
        }
    }

    private void m2922a(C1483c c1483c, b bVar) {
        if (!this.f1873m.b(c1483c)) {
            this.f1873m.a(c1483c, bVar);
        }
    }

    public final void m2936a(C1486c c1486c) {
        synchronized (this.f1872l) {
            if (c1486c.equals(this.f1867g) || this.f1864d.d().contains(c1486c)) {
                return;
            }
            this.f1867g = c1486c;
            m2922a(c1486c.m2309a(), (b) this);
        }
    }

    public final void m2933a(bs bsVar) {
        if (bsVar != null) {
            m2924a(bsVar.a(), f1861q);
            m2927e(bsVar);
        }
    }

    public final bv m2940b(bs bsVar) {
        C1486c a = m2931a(bsVar.a());
        if (a != null) {
            return bsVar.c(a);
        }
        return null;
    }

    public static int m2925c(bs bsVar) {
        return bsVar.d();
    }

    public static boolean m2926d(bs bsVar) {
        return bsVar.e();
    }

    public final void m2937a(C1486c c1486c, C1486c c1486c2) {
        this.f1877r = c1486c;
        this.f1878s = c1486c2;
        m2930k();
    }

    public final void m2942b() {
        this.f1877r = null;
        this.f1878s = null;
        m2930k();
    }

    public final boolean m2944b(C1486c c1486c, C1486c c1486c2) {
        return c1486c != null && c1486c2 != null && c1486c.equals(this.f1877r) && c1486c2.equals(this.f1878s);
    }

    public final C1486c m2931a(C1483c c1483c) {
        C1486c c1486c;
        synchronized (this.f1864d) {
            c1486c = (C1486c) this.f1864d.b(c1483c);
        }
        if (c1486c == null) {
            bh a = this.f1873m.a(c1483c);
            if (a != null) {
                c1486c = m2919a(a);
            } else {
                m2922a(c1483c, (b) this);
            }
        }
        return c1486c == f1861q ? null : c1486c;
    }

    public final C1486c m2941b(C1483c c1483c) {
        C1486c c1486c;
        synchronized (this.f1864d) {
            c1486c = (C1486c) this.f1865e.b(c1483c);
            if (c1486c == f1861q) {
                c1486c = null;
            }
        }
        return c1486c;
    }

    public final void m2946c(C1483c c1483c) {
        if (c1483c == null) {
            Object obj = null;
            synchronized (this.f1872l) {
                if (this.f1868h != null) {
                    this.f1866f = null;
                    this.f1868h = null;
                    obj = 1;
                }
            }
            if (obj != null) {
                m2928i();
                return;
            }
            return;
        }
        synchronized (this.f1872l) {
            if (c1483c.equals(this.f1866f) || (this.f1868h != null && this.f1868h.m1796a().equals(c1483c))) {
                return;
            }
            this.f1866f = c1483c;
            m2922a(c1483c, (b) this);
        }
    }

    public final bh m2945c() {
        bh bhVar;
        synchronized (this.f1872l) {
            bhVar = this.f1868h;
        }
        return bhVar;
    }

    private void m2928i() {
        synchronized (this.f1863b) {
            for (C1607a a : this.f1862a.keySet()) {
                a.m2917a(this);
            }
            for (bx a2 : this.f1863b.keySet()) {
                a2.a();
            }
        }
    }

    public final void m2939a(Set<C1483c> set) {
        synchronized (this.f1872l) {
            if (set == null) {
                set = ImmutableSet.m3678g();
            }
            if (set.equals(this.f1871k)) {
                return;
            }
            this.f1871k.clear();
            this.f1871k.addAll(set);
            this.f1869i.clear();
            this.f1869i.addAll(set);
            this.f1870j.clear();
            for (C1483c c1483c : this.f1871k) {
                bh a = this.f1873m.a(c1483c);
                if (a != null) {
                    this.f1870j.add(a);
                    this.f1869i.remove(c1483c);
                } else {
                    m2922a(c1483c, (b) this);
                }
            }
            m2929j();
        }
    }

    public final boolean m2948d() {
        boolean z;
        synchronized (this.f1872l) {
            z = !this.f1870j.isEmpty();
        }
        return z;
    }

    public final List<bs> m2949e() {
        List a;
        synchronized (this.f1872l) {
            a = ImmutableList.m3651a(this.f1870j);
        }
        return a;
    }

    public final Set<bv> m2950f() {
        List<bs> e = m2949e();
        Set<bv> a = Sets.m4227a();
        for (bs b : e) {
            bv b2 = m2940b(b);
            if (b2 != null) {
                a.add(b2);
            }
        }
        return a;
    }

    private void m2929j() {
        m2930k();
        synchronized (this.f1863b) {
            for (C1607a c : this.f1862a.keySet()) {
                c.m2918c();
            }
            Iterator it = this.f1863b.keySet().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    private C1486c m2919a(bh bhVar) {
        C1486c c1486c;
        Object obj = null;
        synchronized (this.f1864d) {
            c1486c = (C1486c) this.f1864d.b(bhVar.m1796a());
            if (c1486c == null) {
                bi c = bhVar.m1800c();
                c1486c = c == null ? f1861q : c.m1808a();
                this.f1864d.c(bhVar.m1796a(), c1486c);
                if (c1486c != f1861q) {
                    obj = 1;
                }
            }
        }
        if (obj != null) {
            m2927e(bhVar);
        }
        return c1486c;
    }

    private void m2927e(bs bsVar) {
        m2930k();
        synchronized (this.f1863b) {
            for (C1607a a : this.f1862a.keySet()) {
                a.m2916a(bsVar);
            }
            for (bx a2 : this.f1863b.keySet()) {
                a2.a(bsVar);
            }
        }
    }

    private boolean m2924a(C1483c c1483c, C1486c c1486c) {
        synchronized (this.f1864d) {
            C1486c c1486c2 = (C1486c) this.f1864d.b(c1483c);
            if (c1486c.equals(c1486c2)) {
                return false;
            }
            this.f1864d.c(c1483c, c1486c);
            if (c1486c2 != null) {
                synchronized (this.f1864d) {
                    this.f1865e.c(c1483c, c1486c2);
                    bi c = this.f1873m.c(c1486c2.m2309a());
                    if (c == null) {
                    } else {
                        List g;
                        if (c1486c == f1861q) {
                            g = ImmutableList.m3656g();
                        } else {
                            bi c2 = this.f1873m.c(c1486c.m2309a());
                            if (c2 == null) {
                            } else {
                                g = c2.m1810c();
                            }
                        }
                        for (C1483c c1483c2 : c.m1810c()) {
                            if (!(c1483c2.equals(c1483c) || r1.contains(c1483c2))) {
                                this.f1865e.c(c1483c2, this.f1864d.b(c1483c2));
                                this.f1864d.c(c1483c2, f1861q);
                            }
                        }
                    }
                }
            }
            return true;
        }
    }

    public final C1600f m2932a(C1483c c1483c, boolean z, boolean z2, boolean z3) {
        synchronized (this.f1875o) {
            C1600f c1600f;
            C1600f c1600f2 = (C1600f) this.f1875o.get(c1483c);
            if (!z2 || c1600f2 == null || c1600f2.m2900f().size() <= 1) {
                c1600f = null;
            } else {
                c1600f = c1600f2;
                c1600f2 = null;
            }
            if (c1600f2 != null) {
                return c1600f2;
            }
            bh a = this.f1873m.a(c1483c);
            if (a == null) {
                m2922a(c1483c, null);
                return null;
            }
            bv a2 = a.m1794a(c1483c);
            if (a2 == null) {
                return null;
            }
            C1600f c1600f3 = new C1600f(a2);
            if (z3) {
                this.f1875o.put(c1483c, c1600f3);
                if (c1600f != null) {
                    c1600f = c1600f.m2890a(c1483c);
                    for (C1483c put : c1600f.m2900f()) {
                        this.f1875o.put(put, c1600f);
                    }
                }
            }
            return c1600f3;
        }
    }

    public final C1600f m2947d(C1483c c1483c) {
        return m2932a(c1483c, true, false, false);
    }

    public final Set<C1600f> m2951g() {
        Set a;
        synchronized (this.f1875o) {
            a = ImmutableSet.m3672a(this.f1875o.values());
        }
        return a;
    }

    private void m2930k() {
        synchronized (this.f1875o) {
            this.f1874n.clear();
            this.f1875o.clear();
            for (bv bvVar : m2950f()) {
                C1486c a = bvVar.a();
                Object obj = (a == null || !(a.equals(this.f1877r) || a.equals(this.f1878s))) ? null : 1;
                if (obj == null) {
                    obj = (C1600f) this.f1874n.get(Integer.valueOf(bvVar.f()));
                    if (obj == null) {
                        obj = new C1600f(bvVar);
                        this.f1874n.put(Integer.valueOf(bvVar.f()), obj);
                    } else {
                        obj.m2895a(bvVar);
                    }
                    this.f1875o.put(bvVar.b(), obj);
                }
            }
        }
    }

    public final C1595c m2952h() {
        return this.f1876p;
    }
}
