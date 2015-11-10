package com.google.android.m4b.maps.p013q;

import com.google.android.m4b.maps.ag.b;
import com.google.android.m4b.maps.ag.h;
import com.google.android.m4b.maps.ag.q;
import com.google.android.m4b.maps.ah.C1325b;
import com.google.android.m4b.maps.ar.e;
import com.google.android.m4b.maps.bo.o;
import com.google.android.m4b.maps.ch.a;
import com.google.android.m4b.maps.e.c;
import com.google.android.m4b.maps.e.d;
import com.google.common.collect.C1872p;
import com.google.common.collect.ImmutableMap;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.util.LangUtils;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.google.android.m4b.maps.q.g */
public final class C1555g {
    private static volatile boolean f1724a;
    private static volatile a f1725b;
    private static volatile C1549c f1726c;
    private static volatile C1556h f1727d;
    private static volatile C1552f f1728e;
    private static volatile C1557i f1729f;
    private static volatile C1551e f1730g;
    private static volatile C1547a f1731h;
    private static volatile C1548b f1732i;
    private static volatile C1550d f1733j;
    private static volatile a f1734k;
    private static volatile d f1735l;
    private static volatile boolean f1736m;
    private static volatile boolean f1737n;
    private static Object f1738o;
    private static Map<Integer, Integer> f1739p;
    private static List f1740q;

    /* renamed from: com.google.android.m4b.maps.q.g.a */
    static class C1554a extends b {
        private final String f1721a;
        private final boolean f1722b;
        private final a f1723c;

        /* renamed from: com.google.android.m4b.maps.q.g.a.1 */
        class C15531 extends d {
            private /* synthetic */ C1554a f1720b;

            C15531(C1554a c1554a, c cVar) {
                this.f1720b = c1554a;
                super(cVar);
            }

            protected final void m2727f() {
                C1555g.m2745b(h.a(), this.f1720b.f1721a, true, this.f1720b.f1723c);
            }
        }

        public C1554a(String str, boolean z, a aVar) {
            this.f1721a = str;
            this.f1722b = z;
            this.f1723c = aVar;
        }

        public final int m2734i() {
            return 75;
        }

        public final boolean m2731a() {
            return false;
        }

        public final boolean m2733d() {
            return false;
        }

        public final boolean m2732a(DataInput dataInput) {
            boolean z = false;
            a a = com.google.android.m4b.maps.ch.c.a(o.c, dataInput);
            int j = a.j(1);
            synchronized (C1555g.class) {
                for (int i = 0; i < j; i++) {
                    a c = a.c(1, i);
                    if (c.i(2) && C1555g.m2748c(c)) {
                        C1555g.m2750d(c);
                        z = true;
                    }
                }
                if (z) {
                    C1555g.m2742a(C1555g.f1725b, this.f1721a);
                }
            }
            if (z || !this.f1722b) {
                List a2;
                C1872p.m4309a();
                synchronized (C1555g.f1740q) {
                    a2 = C1872p.m4310a(C1555g.f1740q);
                    C1555g.f1740q.clear();
                }
                if (C1555g.f1724a) {
                    Iterator it = a2.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
            }
            if (C1555g.f1724a) {
                synchronized (C1555g.f1738o) {
                    C1555g.f1737n = false;
                    if (C1555g.f1736m) {
                        C1555g.m2745b(h.a(), this.f1721a, false, this.f1723c);
                    } else {
                        C1555g.f1735l = new C15531(this, q.a());
                        C1555g.f1735l.a(10800000);
                        C1555g.f1735l.d();
                    }
                }
            }
            return true;
        }

        public final void m2730a(DataOutput dataOutput) {
            a aVar = new a(o.a);
            synchronized (C1555g.class) {
                int j = C1555g.f1725b.j(1);
                for (int i = 0; i < j; i++) {
                    a c = C1555g.f1725b.c(1, i);
                    a aVar2 = new a(o.d);
                    int a = com.google.android.m4b.maps.ch.c.a(c, 1, -1);
                    if (a != -1) {
                        aVar2.f(1, a);
                    }
                    if (c.i(2)) {
                        aVar2.a(2, c.e(2));
                    }
                    aVar.a(1, aVar2);
                }
            }
            C1555g.m2739a(aVar, this.f1723c);
            aVar.a((OutputStream) dataOutput);
        }
    }

    static {
        f1724a = true;
        f1735l = null;
        f1736m = false;
        f1737n = false;
        f1738o = new Object();
        f1739p = ImmutableMap.m3630j().m3765b(Integer.valueOf(2), Integer.valueOf(4)).m3765b(Integer.valueOf(3), Integer.valueOf(5)).m3765b(Integer.valueOf(6), Integer.valueOf(8)).m3765b(Integer.valueOf(8), Integer.valueOf(10)).m3765b(Integer.valueOf(9), Integer.valueOf(11)).m3765b(Integer.valueOf(12), Integer.valueOf(14)).m3765b(Integer.valueOf(13), Integer.valueOf(15)).m3765b(Integer.valueOf(37), Integer.valueOf(39)).m3767b();
        f1740q = C1872p.m4309a();
    }

    private C1555g() {
    }

    public static synchronized C1549c m2736a() {
        C1549c c1549c;
        synchronized (C1555g.class) {
            c1549c = f1726c;
        }
        return c1549c;
    }

    public static synchronized C1552f m2744b() {
        C1552f c1552f;
        synchronized (C1555g.class) {
            c1552f = f1728e;
        }
        return c1552f;
    }

    public static synchronized C1557i m2747c() {
        C1557i c1557i;
        synchronized (C1555g.class) {
            c1557i = f1729f;
        }
        return c1557i;
    }

    public static C1548b m2749d() {
        return f1732i;
    }

    public static synchronized void m2737a(h hVar, a aVar) {
        synchronized (C1555g.class) {
            String str = "ServerControlledParametersManager.data";
            if (f1725b == null) {
                C1555g.m2740a(str);
                int j = f1725b.j(1);
                for (int i = 0; i < j; i++) {
                    C1555g.m2748c(f1725b.c(1, i));
                }
                C1555g.m2745b(hVar, str, true, aVar);
            }
        }
    }

    private static synchronized void m2745b(h hVar, String str, boolean z, a aVar) {
        synchronized (C1555g.class) {
            if (hVar != null) {
                synchronized (f1738o) {
                    if (f1735l != null) {
                        f1735l.a();
                        f1735l = null;
                    }
                    if (f1737n) {
                        f1736m = true;
                    } else {
                        f1737n = true;
                        f1736m = false;
                        hVar.c(new C1554a(str, z, aVar));
                    }
                }
            }
        }
    }

    private static boolean m2748c(a aVar) {
        int a = com.google.android.m4b.maps.ch.c.a(aVar, 1, -1);
        if (!f1739p.containsKey(Integer.valueOf(a))) {
            return false;
        }
        int intValue = ((Integer) f1739p.get(Integer.valueOf(a))).intValue();
        if (!aVar.i(intValue)) {
            return false;
        }
        a f = aVar.f(intValue);
        switch (a) {
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                if (f1726c != null) {
                    f1726c.m2723a(f);
                } else {
                    f1726c = new C1549c(f);
                }
                return true;
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                f1727d = new C1556h(f);
                C1325b.m1061a();
                C1325b.m1068h();
                return true;
            case C3374b.SmoothProgressBar_spb_progressiveStart_speed /*6*/:
                f1728e = new C1552f(f);
                return true;
            case C3374b.SmoothProgressBar_spb_interpolator /*8*/:
                f1729f = new C1557i(f);
                return true;
            case C3374b.SmoothProgressBar_spb_reversed /*9*/:
                f1730g = new C1551e(f);
                return true;
            case C3374b.SmoothProgressBar_spb_colors /*11*/:
                f1731h = new C1547a(f);
                return true;
            case C3374b.SmoothProgressBar_spb_progressiveStart_activated /*12*/:
                f1732i = new C1548b(f);
                return true;
            case C3374b.SmoothProgressBar_spb_background /*13*/:
                f1733j = new C1550d(f);
                return true;
            case LangUtils.HASH_OFFSET /*37*/:
                try {
                    f1734k = com.google.android.m4b.maps.ch.c.a(f);
                    return true;
                } catch (IOException e) {
                    return false;
                }
            default:
                return false;
        }
    }

    private static void m2750d(a aVar) {
        int d = aVar.d(1);
        if (f1739p.containsKey(Integer.valueOf(d))) {
            int j = f1725b.j(1);
            for (int i = 0; i < j; i++) {
                if (d == f1725b.c(1, i).d(1)) {
                    f1725b.e(1, i);
                    break;
                }
            }
            f1725b.a(1, aVar);
        }
    }

    private static void m2740a(String str) {
        a aVar = new a(o.c);
        for (Entry entry : f1739p.entrySet()) {
            a aVar2;
            a aVar3 = new a(o.d);
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            aVar3.f(1, intValue);
            switch (intValue) {
                case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                    aVar3.b(intValue2, new a(o.e));
                    aVar2 = aVar3;
                    break;
                case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                    aVar3.b(intValue2, new a(o.k));
                    aVar2 = aVar3;
                    break;
                case C3374b.SmoothProgressBar_spb_progressiveStart_speed /*6*/:
                    aVar3.b(intValue2, C1552f.m2725b());
                    aVar2 = aVar3;
                    break;
                case C3374b.SmoothProgressBar_spb_interpolator /*8*/:
                    aVar3.b(intValue2, new a(o.m));
                    aVar2 = aVar3;
                    break;
                case C3374b.SmoothProgressBar_spb_reversed /*9*/:
                    aVar3.b(intValue2, new a(o.n));
                    aVar2 = aVar3;
                    break;
                case C3374b.SmoothProgressBar_spb_colors /*11*/:
                    aVar3.b(intValue2, new a(o.f));
                    aVar2 = aVar3;
                    break;
                case C3374b.SmoothProgressBar_spb_progressiveStart_activated /*12*/:
                    aVar3.b(intValue2, new a(o.g));
                    aVar2 = aVar3;
                    break;
                case C3374b.SmoothProgressBar_spb_background /*13*/:
                    aVar3.b(intValue2, new a(o.h));
                    aVar2 = aVar3;
                    break;
                case LangUtils.HASH_OFFSET /*37*/:
                    aVar3.b(intValue2, new a(e.b));
                    aVar2 = aVar3;
                    break;
                default:
                    aVar2 = null;
                    break;
            }
            if (aVar2 != null) {
                aVar.a(1, aVar2);
            }
        }
        f1725b = aVar;
        try {
            byte[] c = com.google.android.m4b.maps.ag.e.a().q().c(str);
            if (c != null) {
                a aVar4 = new a(o.c);
                aVar4.a(c);
                int j = aVar4.j(1);
                for (intValue2 = 0; intValue2 < j; intValue2++) {
                    C1555g.m2750d(aVar4.c(1, intValue2));
                }
            }
        } catch (IOException e) {
        }
    }

    static boolean m2742a(a aVar, String str) {
        try {
            com.google.android.m4b.maps.ag.e.a().q().a(aVar.d(), str);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static void m2739a(a aVar, a aVar2) {
        a aVar3 = new a(o.b);
        boolean d = C1325b.m1061a().m1070d();
        aVar3.a(1, true);
        aVar3.a(2, d);
        aVar3.b(4, aVar2);
        aVar.a(2, aVar3);
    }
}
