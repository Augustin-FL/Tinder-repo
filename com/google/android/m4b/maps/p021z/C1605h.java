package com.google.android.m4b.maps.p021z;

import com.google.android.m4b.maps.ad.d;
import com.google.android.m4b.maps.ay.aa;
import com.google.android.m4b.maps.ay.ac;
import com.google.android.m4b.maps.ay.ah;
import com.google.android.m4b.maps.ay.ap;
import com.google.android.m4b.maps.ay.ap.C1415b;
import com.google.android.m4b.maps.ay.au;
import com.google.android.m4b.maps.ay.bb;
import com.google.android.m4b.maps.ba.j;
import com.google.android.m4b.maps.ba.j.a;
import com.google.android.m4b.maps.ba.l;
import com.google.android.m4b.maps.bg.f;
import com.google.android.m4b.maps.p021z.C1602g.C1601a;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.google.android.m4b.maps.z.h */
public final class C1605h implements d {
    public static final C1602g f1852a;
    private final j f1853b;
    private final a f1854c;
    private final f<ac, C1602g> f1855d;
    private int f1856e;
    private final Set<ac> f1857f;
    private final Set<C1604a> f1858g;

    /* renamed from: com.google.android.m4b.maps.z.h.1 */
    class C16031 implements a {
        private /* synthetic */ C1605h f1851a;

        C16031(C1605h c1605h) {
            this.f1851a = c1605h;
        }

        public final void m2906a() {
            this.f1851a.m2911a();
        }

        public final void m2907a(aa aaVar) {
            if (aaVar != null) {
                this.f1851a.m2912a(aaVar.m1025a(), 0, aaVar);
            }
        }
    }

    /* renamed from: com.google.android.m4b.maps.z.h.a */
    public interface C1604a {
        void m2908b();
    }

    static {
        f1852a = new C1602g(ImmutableList.m3656g());
    }

    public C1605h() {
        this.f1857f = Sets.m4227a();
        this.f1858g = new CopyOnWriteArraySet();
        if (l.a(ah.f1046n)) {
            this.f1853b = l.b(ah.f1046n);
            this.f1855d = new f(100);
            this.f1854c = new C16031(this);
            this.f1853b.a(this.f1854c);
            return;
        }
        this.f1853b = null;
        this.f1855d = null;
        this.f1854c = null;
    }

    public final synchronized C1602g m2910a(ac acVar) {
        C1602g c1602g;
        c1602g = (C1602g) this.f1855d.b(acVar);
        if (c1602g == null) {
            m2909b(acVar);
            this.f1856e++;
            c1602g = null;
        }
        return c1602g;
    }

    public final synchronized void m2911a() {
        this.f1855d.a();
        this.f1857f.clear();
    }

    private synchronized void m2909b(ac acVar) {
        if (!this.f1857f.contains(acVar)) {
            this.f1857f.add(acVar);
            this.f1853b.a(acVar, this);
        }
    }

    public final void m2912a(ac acVar, int i, aa aaVar) {
        Object obj = null;
        Object obj2 = 1;
        Object obj3 = null;
        int i2;
        switch (i) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
            case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                C1602g a;
                if (aaVar instanceof ap) {
                    ap apVar = (ap) aaVar;
                    C1601a c1601a = new C1601a();
                    C1415b i3 = apVar.m1640i();
                    while (i3.hasNext()) {
                        bb bbVar = (bb) i3.next();
                        if (bbVar instanceof au) {
                            au auVar = (au) bbVar;
                            if (auVar.m1700j()) {
                                c1601a.m2902a(auVar);
                            }
                        }
                    }
                    a = c1601a.m2901a();
                } else {
                    a = f1852a;
                }
                C1602g c1602g = a;
                i2 = 1;
                break;
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                break;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                obj3 = f1852a;
                i2 = 1;
                break;
            default:
                obj2 = null;
                break;
        }
        if (obj != null) {
            synchronized (this) {
                this.f1855d.c(acVar, obj3);
            }
        }
        if (obj2 != null) {
            for (C1604a b : this.f1858g) {
                b.m2908b();
            }
            synchronized (this) {
                this.f1857f.remove(acVar);
            }
        }
    }

    public final void m2913a(C1604a c1604a) {
        this.f1858g.add(c1604a);
    }

    public final void m2914b(C1604a c1604a) {
        this.f1858g.remove(c1604a);
    }
}
