package com.google.android.m4b.maps.ay;

import android.support.v7.widget.RecyclerView.SmoothScroller.Action;
import com.facebook.stetho.BuildConfig;
import com.google.android.m4b.maps.bq.bv;
import com.google.android.m4b.maps.ch.a;
import com.google.android.m4b.maps.p009m.C1480a;
import com.google.android.m4b.maps.p009m.C1480a.C1483c;
import com.google.android.m4b.maps.p009m.C1486c;
import com.google.common.base.C1430c;
import com.google.common.collect.C1872p;
import java.util.List;

public final class bi implements bv {
    private final List<C1483c> f1201a;
    private final String f1202b;
    private final String f1203c;
    private final int f1204d;
    private final C1486c f1205e;

    /* renamed from: com.google.android.m4b.maps.ay.bi.a */
    public static class C1432a {
        public static final C1430c<bi, C1480a> f1200a;

        /* renamed from: com.google.android.m4b.maps.ay.bi.a.1 */
        static class C14311 implements C1430c<bi, C1480a> {
            C14311() {
            }

            public final /* synthetic */ Object m1806a(Object obj) {
                return ((bi) obj).m1809b();
            }
        }

        static {
            f1200a = new C14311();
        }
    }

    private bi(C1483c c1483c, List<C1483c> list, String str, String str2, int i, int i2, ar arVar) {
        this.f1201a = list;
        this.f1202b = str;
        this.f1203c = str2;
        this.f1204d = i;
        this.f1205e = new C1486c(c1483c, i2);
    }

    public static bi m1807a(a aVar) {
        int i = 0;
        C1483c b = C1483c.m2303b(aVar.g(1));
        if (b == null) {
            return null;
        }
        int j = aVar.j(2);
        List b2 = C1872p.m4317b(j);
        for (int i2 = 0; i2 < j; i2++) {
            C1483c b3 = C1483c.m2303b(aVar.d(2, i2));
            if (b3 != null) {
                b2.add(b3);
            }
        }
        String g = aVar.g(3);
        String g2 = aVar.g(4);
        if (g == null) {
            g = g2 != null ? g2 : BuildConfig.FLAVOR;
        }
        if (g2 == null) {
            g2 = g;
        }
        if (aVar.i(5)) {
            i = aVar.d(5);
        }
        int i3 = Action.UNDEFINED_DURATION;
        if (aVar.i(8)) {
            i3 = aVar.d(8);
        }
        ar arVar = null;
        if (aVar.i(7)) {
            a f = aVar.f(7);
            C1440g a = C1440g.m1927a(f.f(1));
            C1440g a2 = C1440g.m1927a(f.f(2));
            if (a.f1264a > a2.f1264a) {
                a2.f1264a += 1073741824;
            }
            arVar = ar.m1671a(new C1448m(a, a2));
        }
        return new bi(b, b2, g, g2, i, i3, arVar);
    }

    public final C1486c m1808a() {
        return this.f1205e;
    }

    public final C1483c m1809b() {
        return this.f1205e.m2309a();
    }

    public final List<C1483c> m1810c() {
        return this.f1201a;
    }

    public final String m1811d() {
        return this.f1202b;
    }

    public final String m1812e() {
        return this.f1203c;
    }

    public final int m1813f() {
        return this.f1204d;
    }

    public final String toString() {
        return "[Level: " + this.f1205e + "]";
    }
}
