package com.google.android.m4b.maps.p021z;

import com.google.android.m4b.maps.ad.b;
import com.google.android.m4b.maps.ad.d;
import com.google.android.m4b.maps.ay.C1440g;
import com.google.android.m4b.maps.ay.aa;
import com.google.android.m4b.maps.ay.ac;
import com.google.android.m4b.maps.ay.ap;
import com.google.android.m4b.maps.ay.ap.C1415b;
import com.google.android.m4b.maps.ay.au;
import com.google.android.m4b.maps.ay.ay;
import com.google.android.m4b.maps.ay.bb;
import com.google.android.m4b.maps.ay.bh;
import com.google.android.m4b.maps.ba.j;
import com.google.android.m4b.maps.p009m.C1480a;
import com.google.android.m4b.maps.p009m.C1480a.C1483c;
import com.google.common.collect.C1872p;
import com.google.common.collect.C1876q;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.m4b.maps.z.b */
public final class C1593b implements b, d {
    private final j f1825a;
    private final com.google.android.m4b.maps.ba.d f1826b;
    private final ac f1827c;
    private final Map<C1483c, C1591a> f1828d;
    private final Collection<C1590a> f1829e;
    private volatile boolean f1830f;
    private volatile C1592b f1831g;

    /* renamed from: com.google.android.m4b.maps.z.b.a */
    static class C1591a {
        private final C1483c f1822a;
        private final ay f1823b;
        private C1440g f1824c;

        public C1591a(au auVar) {
            this.f1822a = C1483c.m2303b(auVar.m1694d().toString());
            this.f1823b = new ay();
            auVar.m1691a().m1573a(this.f1823b);
        }

        public final void m2859a(C1440g c1440g) {
            this.f1824c = c1440g;
        }

        public final C1590a m2858a() {
            return new C1590a(this.f1822a, this.f1823b, this.f1824c, new String[0]);
        }
    }

    /* renamed from: com.google.android.m4b.maps.z.b.b */
    public interface C1592b {
        void m2860a(C1593b c1593b, Collection<C1590a> collection);
    }

    public C1593b(j jVar, com.google.android.m4b.maps.ba.d dVar, ac acVar) {
        this.f1828d = Collections.synchronizedMap(C1876q.m4328a());
        this.f1829e = Collections.synchronizedList(C1872p.m4309a());
        this.f1825a = jVar;
        this.f1826b = dVar;
        this.f1827c = acVar;
    }

    public final void m2865a(C1592b c1592b) {
        this.f1831g = c1592b;
        this.f1825a.a(this.f1827c, this);
    }

    public final ac m2862a() {
        return this.f1827c;
    }

    public final void m2863a(ac acVar, int i, aa aaVar) {
        if (i != 3) {
            au auVar;
            if (i != 2 && i == 1) {
                this.f1830f = true;
            }
            Collection collection = null;
            if (aaVar != null) {
                ap apVar = (ap) aaVar;
                List a = C1872p.m4309a();
                C1415b i2 = apVar.m1640i();
                while (i2.hasNext()) {
                    bb bbVar = (bb) i2.next();
                    if (bbVar.m1541b() == 3) {
                        auVar = (au) bbVar;
                        if (auVar.m1702l()) {
                            C1480a d = auVar.m1694d();
                            if (!(d == null || d == C1480a.f1436a)) {
                                a.add(auVar);
                            }
                        }
                    }
                }
                collection = a;
            }
            if (r0 == null || r0.size() == 0) {
                m2861b();
                return;
            }
            for (au auVar2 : r0) {
                C1591a c1591a = new C1591a(auVar2);
                this.f1828d.put(c1591a.f1822a, c1591a);
            }
            for (C1591a a2 : C1872p.m4310a(this.f1828d.values())) {
                this.f1826b.a(a2.f1822a, this);
            }
        }
    }

    public final void m2864a(C1483c c1483c, int i, bh bhVar) {
        synchronized (this.f1828d) {
            C1591a c1591a = (C1591a) this.f1828d.remove(c1483c);
            boolean isEmpty = this.f1828d.isEmpty();
        }
        if (c1591a != null) {
            if (bhVar != null) {
                c1591a.m2859a(bhVar.m1804f());
                this.f1829e.add(c1591a.m2858a());
            }
            if (i == 1) {
                this.f1830f = true;
            }
            if (isEmpty) {
                m2861b();
            }
        }
    }

    private void m2861b() {
        if (this.f1831g != null) {
            if (this.f1830f) {
                this.f1831g.m2860a(this, null);
            } else {
                this.f1831g.m2860a(this, this.f1829e);
            }
        }
    }
}
