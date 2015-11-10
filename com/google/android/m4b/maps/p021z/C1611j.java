package com.google.android.m4b.maps.p021z;

import com.google.android.m4b.maps.ag.k;
import com.google.android.m4b.maps.ag.q;
import com.google.android.m4b.maps.ai.a;
import com.google.android.m4b.maps.ai.b;
import com.google.android.m4b.maps.ay.C1420n;
import com.google.android.m4b.maps.ay.C1440g;
import com.google.android.m4b.maps.ay.C1448m;
import com.google.android.m4b.maps.ay.ac;
import com.google.android.m4b.maps.ay.ar;
import com.google.android.m4b.maps.e.c;
import com.google.android.m4b.maps.p009m.C1480a;
import com.google.android.m4b.maps.p021z.C1595c.C1594a;
import com.google.common.collect.ImmutableSet;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.http.protocol.HTTP;

/* renamed from: com.google.android.m4b.maps.z.j */
public final class C1611j implements b, C1595c {
    private final String f1883b;
    private final C1440g f1884c;
    private final C1440g f1885d;
    private volatile boolean f1886e;
    private volatile C1440g f1887f;
    private final CopyOnWriteArrayList<C1594a> f1888g;
    private volatile C1610a f1889h;

    /* renamed from: com.google.android.m4b.maps.z.j.1 */
    class C16091 extends com.google.android.m4b.maps.e.b {
        private /* synthetic */ C1611j f1879b;

        C16091(C1611j c1611j, c cVar) {
            this.f1879b = c1611j;
            super(cVar);
        }

        public final void m2953f() {
            C1611j.m2955a(this.f1879b);
        }
    }

    /* renamed from: com.google.android.m4b.maps.z.j.a */
    static class C1610a {
        final C1599e f1880a;
        final ar f1881b;
        final ar f1882c;

        C1610a() {
            this.f1880a = new C1599e();
            this.f1881b = ar.m1671a(new C1448m(new C1440g(), new C1440g()));
            this.f1882c = ar.m1671a(new C1448m(new C1440g(), new C1440g()));
        }

        C1610a(C1599e c1599e, ar arVar, ar arVar2) {
            this.f1880a = c1599e;
            this.f1881b = arVar;
            this.f1882c = arVar2;
        }
    }

    static /* synthetic */ void m2955a(C1611j c1611j) {
        com.google.android.m4b.maps.ai.c c = com.google.android.m4b.maps.ai.c.c();
        if (c != null) {
            c1611j.m2957a(c.a(c1611j.f1883b, c1611j, false));
        }
    }

    private C1611j(String str, C1440g c1440g, C1440g c1440g2) {
        this.f1883b = str;
        this.f1884c = c1440g;
        if (c1440g.m1958f() < c1440g2.m1958f() || c1440g.m1960g() < c1440g2.m1960g()) {
            this.f1885d = this.f1884c;
        } else {
            this.f1885d = c1440g2;
        }
        this.f1888g = new CopyOnWriteArrayList();
        this.f1887f = new C1440g();
        this.f1889h = new C1610a();
    }

    public C1611j(String str) {
        this(str, new C1440g(5000000, 5000000), new C1440g(4000000, 4000000));
    }

    private static ar m2954a(C1440g c1440g, C1440g c1440g2) {
        C1440g g = ac.m1439b(15, c1440g.m1959f(c1440g2)).m1454g();
        C1440g h = ac.m1439b(15, c1440g.m1957e(c1440g2)).m1455h();
        if (g.m1958f() > h.m1958f()) {
            h = h.m1957e(new C1440g(1073741824, 0));
        }
        return ar.m1671a(new C1448m(g, h));
    }

    public final Collection<C1590a> m2956a(ac acVar) {
        if (acVar.m1449b() < 15) {
            return ImmutableSet.m3678g();
        }
        C1420n i = acVar.m1456i();
        C1610a c1610a = this.f1889h;
        if (!(this.f1886e || c1610a.f1882c.m1676a(i))) {
            C1440g e = i.m2052e();
            synchronized (this) {
                if (this.f1886e) {
                } else {
                    this.f1886e = true;
                    this.f1887f = e;
                    new C16091(this, q.a()).d();
                }
            }
        }
        if (c1610a.f1881b.m1676a(i)) {
            return c1610a.f1880a.m2882a(acVar);
        }
        return a;
    }

    public final boolean m2959a(C1480a c1480a) {
        return this.f1889h.f1880a.m2884a(c1480a);
    }

    public final void m2958a(C1594a c1594a) {
        if (c1594a != null) {
            this.f1888g.add(c1594a);
        }
    }

    public final void m2960b(C1594a c1594a) {
        if (c1594a != null) {
            this.f1888g.remove(c1594a);
        }
    }

    public final void m2957a(a aVar) {
        if (aVar != null) {
            synchronized (aVar) {
                if (this.f1886e) {
                    if (aVar.b()) {
                        byte[] d = aVar.d();
                        if (d != null && d.length > 0) {
                            try {
                                ar a = C1611j.m2954a(this.f1887f, this.f1884c);
                                this.f1889h = new C1610a(C1599e.m2881a(new InputStreamReader(new ByteArrayInputStream(d), HTTP.UTF_8), a), a, C1611j.m2954a(this.f1887f, this.f1885d));
                            } catch (Throwable e) {
                                k.a("LazyBuildingBoundProvider", e);
                            }
                        }
                        this.f1886e = false;
                        Iterator it = this.f1888g.iterator();
                        while (it.hasNext()) {
                            ((C1594a) it.next()).m2866a();
                        }
                    }
                    return;
                }
            }
        }
    }
}
