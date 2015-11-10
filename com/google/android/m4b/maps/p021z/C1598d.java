package com.google.android.m4b.maps.p021z;

import com.google.android.m4b.maps.ay.ac;
import com.google.android.m4b.maps.bg.i;
import com.google.android.m4b.maps.p009m.C1480a;
import com.google.android.m4b.maps.p021z.C1595c.C1594a;
import com.google.common.collect.C1872p;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.m4b.maps.z.d */
public final class C1598d implements C1595c {
    private final Object f1833b;
    private boolean f1834c;
    private boolean f1835d;
    private volatile C1595c f1836e;
    private volatile C1595c f1837f;
    private final List<C1594a> f1838g;
    private final C1596a f1839h;

    /* renamed from: com.google.android.m4b.maps.z.d.a */
    public interface C1596a {
        C1595c m2871a();

        C1595c m2872a(String str);
    }

    /* renamed from: com.google.android.m4b.maps.z.d.1 */
    class C15971 implements C1596a {
        C15971(C1598d c1598d) {
        }

        public final C1595c m2873a() {
            return new C1613k();
        }

        public final C1595c m2874a(String str) {
            return new C1611j(str);
        }
    }

    private boolean m2875a() {
        boolean z = false;
        synchronized (this.f1833b) {
            if (this.f1835d) {
                return true;
            }
            boolean z2;
            if (this.f1834c && i.b()) {
                this.f1834c = false;
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                return false;
            }
            boolean z3;
            C1595c a;
            C1595c a2;
            if (i.a().d()) {
                z3 = false;
            } else {
                z3 = true;
                z = true;
            }
            if (z) {
                a = this.f1839h.m2871a();
            } else {
                a = null;
            }
            if (z3) {
                a2 = this.f1839h.m2872a("/new.building.list");
            } else {
                a2 = null;
            }
            if (a2 == null) {
                a2 = this.f1839h.m2872a("/building.list");
            }
            this.f1837f = a2;
            this.f1836e = a;
            synchronized (this.f1833b) {
                this.f1835d = true;
                for (C1594a c : this.f1838g) {
                    m2876c(c);
                }
                this.f1838g.clear();
            }
            return true;
        }
    }

    public C1598d() {
        this.f1833b = new Object();
        this.f1834c = true;
        this.f1838g = C1872p.m4309a();
        this.f1839h = new C15971(this);
        m2875a();
    }

    public final Collection<C1590a> m2877a(ac acVar) {
        if (!m2875a()) {
            return C1595c.f1832a;
        }
        ImmutableList g = ImmutableList.m3656g();
        Collection g2 = ImmutableList.m3656g();
        if (this.f1837f != null) {
            Iterable a = this.f1837f.m2867a(acVar);
        } else {
            Object obj = g;
        }
        if (this.f1836e != null) {
            g2 = this.f1836e.m2867a(acVar);
        }
        if (r1 == C1595c.f1832a || r2 == C1595c.f1832a) {
            return C1595c.f1832a;
        }
        if (r1.isEmpty() && r2.isEmpty()) {
            return ImmutableList.m3656g();
        }
        Set a2 = Sets.m4227a();
        for (C1590a a3 : r1) {
            a2.add(a3.m2852a());
        }
        Collection<C1590a> a4 = C1872p.m4310a((Iterable) r1);
        for (C1590a a32 : r2) {
            if (!a2.contains(a32.m2852a())) {
                a4.add(a32);
            }
        }
        return a4;
    }

    public final boolean m2879a(C1480a c1480a) {
        boolean z = false;
        if (!m2875a()) {
            return false;
        }
        if (this.f1837f != null) {
            z = this.f1837f.m2869a(c1480a);
        }
        if (z || this.f1836e == null) {
            return z;
        }
        return this.f1836e.m2869a(c1480a);
    }

    private void m2876c(C1594a c1594a) {
        if (this.f1837f != null) {
            this.f1837f.m2868a(c1594a);
        }
        if (this.f1836e != null) {
            this.f1836e.m2868a(c1594a);
        }
    }

    public final void m2878a(C1594a c1594a) {
        m2875a();
        synchronized (this.f1833b) {
            if (this.f1835d) {
                m2876c(c1594a);
                return;
            }
            this.f1838g.add(c1594a);
        }
    }

    public final void m2880b(C1594a c1594a) {
        m2875a();
        synchronized (this.f1833b) {
            if (this.f1835d) {
                if (this.f1837f != null) {
                    this.f1837f.m2870b(c1594a);
                }
                if (this.f1836e != null) {
                    this.f1836e.m2870b(c1594a);
                    return;
                }
                return;
            }
            this.f1838g.remove(c1594a);
        }
    }
}
