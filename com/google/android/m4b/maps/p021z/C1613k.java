package com.google.android.m4b.maps.p021z;

import com.google.android.m4b.maps.ay.aa;
import com.google.android.m4b.maps.ay.ac;
import com.google.android.m4b.maps.ay.ah;
import com.google.android.m4b.maps.ba.d;
import com.google.android.m4b.maps.ba.j;
import com.google.android.m4b.maps.ba.j.a;
import com.google.android.m4b.maps.ba.l;
import com.google.android.m4b.maps.bg.f;
import com.google.android.m4b.maps.p009m.C1480a;
import com.google.android.m4b.maps.p021z.C1593b.C1592b;
import com.google.android.m4b.maps.p021z.C1595c.C1594a;
import com.google.common.collect.C1876q;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: com.google.android.m4b.maps.z.k */
public final class C1613k implements C1592b, C1595c {
    private final j f1891b;
    private final d f1892c;
    private final a f1893d;
    private final Map<ac, C1593b> f1894e;
    private final f<ac, Collection<C1590a>> f1895f;
    private final Set<C1594a> f1896g;
    private volatile int f1897h;
    private volatile int f1898i;
    private volatile int f1899j;

    /* renamed from: com.google.android.m4b.maps.z.k.1 */
    class C16121 implements a {
        private /* synthetic */ C1613k f1890a;

        C16121(C1613k c1613k) {
            this.f1890a = c1613k;
        }

        public final void m2961a() {
            this.f1890a.m2968a();
        }

        public final void m2962a(aa aaVar) {
            synchronized (this.f1890a.f1894e) {
                C1593b c1593b = (C1593b) this.f1890a.f1894e.remove(aaVar.m1025a());
            }
            synchronized (this.f1890a.f1895f) {
                Collection collection = (Collection) this.f1890a.f1895f.c(aaVar.m1025a());
            }
            if (c1593b != null || collection != null) {
                this.f1890a.m2965b();
            }
        }
    }

    public C1613k() {
        this.f1894e = C1876q.m4328a();
        this.f1895f = new f(48);
        this.f1896g = new CopyOnWriteArraySet();
        if (l.a(ah.f1033a)) {
            this.f1891b = l.b(ah.f1033a);
            this.f1892c = d.c();
            this.f1893d = new C16121(this);
            this.f1891b.a(this.f1893d);
            return;
        }
        this.f1891b = null;
        this.f1892c = null;
        this.f1893d = null;
    }

    public final Collection<C1590a> m2967a(ac acVar) {
        ac a;
        this.f1897h++;
        if (acVar.m1449b() > 14) {
            a = acVar.m1442a(14);
        } else {
            a = acVar;
        }
        synchronized (this.f1895f) {
            Collection collection = (Collection) this.f1895f.b(a);
        }
        if (collection != null) {
            this.f1898i++;
            return C1590a.m2851a(collection, acVar.m1456i());
        }
        Object obj;
        synchronized (this.f1894e) {
            C1593b c1593b = (C1593b) this.f1894e.get(a);
            if (c1593b == null) {
                c1593b = new C1593b(this.f1891b, this.f1892c, a);
                this.f1894e.put(a, c1593b);
                obj = 1;
            } else {
                obj = null;
            }
        }
        if (obj != null) {
            c1593b.m2865a(this);
            this.f1899j++;
        }
        return C1595c.f1832a;
    }

    public final void m2968a() {
        synchronized (this.f1894e) {
            this.f1894e.clear();
        }
        synchronized (this.f1895f) {
            this.f1895f.a();
        }
        m2965b();
    }

    private void m2965b() {
        for (C1594a a : this.f1896g) {
            a.m2866a();
        }
    }

    public final boolean m2971a(C1480a c1480a) {
        return false;
    }

    public final void m2970a(C1594a c1594a) {
        this.f1896g.add(c1594a);
    }

    public final void m2972b(C1594a c1594a) {
        this.f1896g.remove(c1594a);
    }

    public final void m2969a(C1593b c1593b, Collection<C1590a> collection) {
        synchronized (this.f1894e) {
            if (((C1593b) this.f1894e.get(c1593b.m2862a())) != c1593b) {
                return;
            }
            this.f1894e.remove(c1593b.m2862a());
            if (collection != null) {
                synchronized (this.f1895f) {
                    this.f1895f.c(c1593b.m2862a(), collection);
                }
                m2965b();
            }
        }
    }
}
