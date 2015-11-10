package com.google.android.m4b.maps.au;

import com.google.android.m4b.maps.an.d;
import com.google.android.m4b.maps.an.l;
import com.google.android.m4b.maps.au.C1357e.C1352b;
import com.google.android.m4b.maps.au.C1357e.C1356d;
import com.google.android.m4b.maps.ay.C1440g;
import com.google.android.m4b.maps.ay.C1446k;
import java.util.List;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.google.android.m4b.maps.au.f */
public final class C1360f {

    /* renamed from: com.google.android.m4b.maps.au.f.1 */
    static /* synthetic */ class C13581 {
        static final /* synthetic */ int[] f889a;

        static {
            f889a = new int[C1359a.values().length];
            try {
                f889a[C1359a.AREA_VERIFICATION.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f889a[C1359a.AREA_VERIFICATION_WITH_REASON.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f889a[C1359a.COMPLETE_VERIFICATION.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f889a[C1359a.NO_VERIFICATION_WITH_REASON.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* renamed from: com.google.android.m4b.maps.au.f.a */
    public enum C1359a {
        NO_VERIFICATION,
        NO_VERIFICATION_WITH_REASON,
        AREA_VERIFICATION,
        AREA_VERIFICATION_WITH_REASON,
        COMPLETE_VERIFICATION
    }

    public static C1364k m1224a(List<C1446k> list, C1359a c1359a) {
        if (list.size() == 0) {
            return C1364k.m1269a();
        }
        int[] iArr = new int[(list.size() + 1)];
        int i = 0;
        int i2 = 0;
        for (C1446k c1446k : list) {
            int i3;
            iArr[i2] = i;
            i += c1446k.m2020b() - 1;
            if (c1446k.m2023c().equals(c1446k.m2014a(0))) {
                i3 = i;
            } else {
                i3 = i + 1;
            }
            i2++;
            i = i3;
        }
        iArr[i2] = i;
        double[] dArr = new double[(i * 2)];
        C1360f.m1227a((C1446k) list.get(0), false, dArr, 0);
        i = 1;
        for (C1446k c1446k2 : list.subList(1, list.size())) {
            C1360f.m1227a(c1446k2, true, dArr, iArr[i]);
            i++;
        }
        C1350d c1350d = new C1350d(C1361g.m1229a(dArr, iArr));
        if (c1359a == C1359a.COMPLETE_VERIFICATION) {
            C1356d b = C1357e.m1223b(c1350d);
            if (b != null) {
                throw new C1352b("Verification failed, the polygon violates " + b.toString(), null);
            }
        }
        try {
            C1364k a = C1357e.m1219a(c1350d);
            switch (C13581.f889a[c1359a.ordinal()]) {
                case C3374b.SmoothProgressBar_spb_color /*1*/:
                case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                    if (a.m1274a(c1350d)) {
                        return a;
                    }
                    throw new C1352b("Could not tessellate polygon, area not equal", null);
                default:
                    return a;
            }
        } catch (C1352b e) {
            switch (C13581.f889a[c1359a.ordinal()]) {
                case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                    C1357e.m1223b(c1350d);
                    break;
            }
            throw e;
        }
    }

    private static void m1227a(C1446k c1446k, boolean z, double[] dArr, int i) {
        int i2 = 0;
        C1440g c1440g = new C1440g();
        int b = z ? c1446k.m2020b() - 1 : 0;
        int i3 = z ? -1 : 1;
        int b2 = c1446k.m2020b();
        if (c1446k.m2023c().equals(c1446k.m2014a(0))) {
            b2--;
        }
        while (i2 < b2) {
            c1446k.m2016a((i3 * i2) + b, c1440g);
            dArr[(i + i2) * 2] = (double) c1440g.m1958f();
            dArr[((i + i2) * 2) + 1] = (double) c1440g.m1960g();
            i2++;
        }
    }

    public static void m1226a(C1364k c1364k, l lVar, C1440g c1440g, int i) {
        C1440g c1440g2 = new C1440g();
        int e = c1364k.m1279e();
        lVar.a(lVar.a() + e);
        for (int i2 = 0; i2 < e; i2++) {
            c1440g2.m1955d((int) c1364k.m1271a(i2), (int) c1364k.m1275b(i2));
            C1440g.m1936b(c1440g2, c1440g, c1440g2);
            lVar.a(c1440g2, i);
        }
    }

    public static void m1225a(C1364k c1364k, d dVar, int i) {
        dVar.b(dVar.b() + (c1364k.m1278d() * 3));
        int d = c1364k.m1278d();
        for (int i2 = 0; i2 < d; i2++) {
            dVar.a(c1364k.m1272a(i2, 0) + i, c1364k.m1272a(i2, 1) + i, c1364k.m1272a(i2, 2) + i);
        }
    }
}
