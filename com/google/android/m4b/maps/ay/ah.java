package com.google.android.m4b.maps.ay;

import android.content.res.Resources;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.stetho.BuildConfig;
import com.google.android.m4b.maps.ab.C1317b;
import com.google.android.m4b.maps.ae.d;
import com.google.android.m4b.maps.ae.j.c;
import com.google.android.m4b.maps.ae.k;
import com.google.android.m4b.maps.ae.l;
import com.google.android.m4b.maps.ag.i;
import com.google.android.m4b.maps.ah.C1325b;
import com.google.android.m4b.maps.ah.C1326c;
import com.google.android.m4b.maps.ba.e;
import com.google.android.m4b.maps.ba.h;
import com.google.android.m4b.maps.ba.j;
import com.google.android.m4b.maps.ba.n;
import com.google.android.m4b.maps.bh.m;
import com.google.android.m4b.maps.bh.p;
import com.google.android.m4b.maps.ci.a;
import java.io.DataInput;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;

public abstract class ah implements Comparable<ah> {
    private static final Map<Integer, ah> f1024D;
    private static final C1454s f1025J;
    private static final C1460y f1026K;
    private static final C1460y f1027L;
    private static final C1460y f1028M;
    private static final C1461z f1029N;
    private static final C1455t f1030O;
    private static final C1455t f1031P;
    private static final C1455t f1032Q;
    public static final ah f1033a;
    public static final ah f1034b;
    public static final ah f1035c;
    public static final ah f1036d;
    public static final ah f1037e;
    public static final ah f1038f;
    public static final ah f1039g;
    public static final ah f1040h;
    public static final ah f1041i;
    public static final ah f1042j;
    public static final ah f1043k;
    public static final ah f1044l;
    public static final ah f1045m;
    public static final ah f1046n;
    public static final ah f1047o;
    public static final ah f1048p;
    public static final ah f1049q;
    public static final ah f1050r;
    public static final ah f1051s;
    public static final ah f1052t;
    public static final ah f1053u;
    public static final ah f1054v;
    public static final ah f1055w;
    public static final ah f1056x;
    public final boolean f1057A;
    public final int f1058B;
    public final String f1059C;
    private final int f1060E;
    private final boolean f1061F;
    private final boolean f1062G;
    private final boolean f1063H;
    private final c f1064I;
    public final int f1065y;
    public final int f1066z;

    /* renamed from: com.google.android.m4b.maps.ay.ah.b */
    static abstract class C1393b {
        private final int f1015a;
        private int f1016b;
        private String f1017c;
        private boolean f1018d;
        private boolean f1019e;
        private boolean f1020f;
        private boolean f1021g;

        abstract ah m1486a();

        private C1393b(int i) {
            this.f1016b = 0;
            this.f1017c = BuildConfig.FLAVOR;
            this.f1018d = false;
            this.f1019e = true;
            this.f1020f = false;
            this.f1021g = false;
            this.f1015a = i;
        }

        final C1393b m1484a(int i) {
            this.f1016b = AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS;
            return this;
        }

        final C1393b m1485a(String str) {
            this.f1017c = str;
            return this;
        }

        final C1393b m1487b(boolean z) {
            this.f1018d = true;
            return this;
        }

        final C1393b m1488c(boolean z) {
            this.f1019e = false;
            return this;
        }

        final C1393b m1489d(boolean z) {
            this.f1020f = true;
            return this;
        }

        final C1393b m1490e(boolean z) {
            this.f1021g = z;
            return this;
        }
    }

    /* renamed from: com.google.android.m4b.maps.ay.ah.i */
    static class C1396i extends ah {
        private final boolean f1067D;

        /* renamed from: com.google.android.m4b.maps.ay.ah.i.a */
        static class C1394a extends C1393b {
            private boolean f1022a;

            private C1394a(int i) {
                super((byte) 0);
                this.f1022a = false;
            }

            final C1394a m1493f(boolean z) {
                this.f1022a = true;
                return this;
            }

            ah m1492a() {
                return new C1396i();
            }
        }

        public /* synthetic */ int compareTo(Object obj) {
            return super.m1504a((ah) obj);
        }

        public final j m1514a(i iVar, Resources resources, Locale locale, File file, boolean z, boolean z2) {
            if (this == n && !C1325b.m1067g()) {
                return null;
            }
            float f = this.f1061F ? resources.getDisplayMetrics().density : 1.0f;
            int a = m.a(resources, AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY);
            if (this == ah.f1053u) {
                return null;
            }
            boolean z3 = z && this.f1062G;
            if (this.f1057A) {
                return new com.google.android.m4b.maps.ba.m(iVar, this, a, f, locale, z3, file, com.google.android.m4b.maps.ba.m.e, null);
            }
            j nVar = new n(iVar, this, a, f, locale, z3, file, null);
            if (this == ah.f1038f || this == ah.f1039g) {
                nVar.a(120000);
            }
            if (!this.f1067D || !z2) {
                return nVar;
            }
            nVar.a(C1326c.m1071a((byte) 1));
            return nVar;
        }

        public final c m1515g() {
            return new C1408j(this);
        }

        final int m1513a() {
            return AccessibilityNodeInfoCompat.ACTION_SCROLL_FORWARD;
        }

        private C1396i(C1394a c1394a) {
            super((byte) 0);
            this.f1067D = c1394a.f1022a;
        }
    }

    /* renamed from: com.google.android.m4b.maps.ay.ah.a */
    static class C1397a extends C1396i {
        private final boolean f1068D;

        /* renamed from: com.google.android.m4b.maps.ay.ah.a.a */
        static class C1395a extends C1394a {
            private boolean f1023a;

            private C1395a(int i) {
                super((byte) 0);
                this.f1023a = false;
            }

            final C1395a m1495a(boolean z) {
                this.f1023a = true;
                return this;
            }

            final ah m1496a() {
                return new C1397a();
            }
        }

        private C1397a(C1395a c1395a) {
            super((byte) 0);
            this.f1068D = c1395a.f1023a;
        }

        public final boolean m1518e() {
            return true;
        }

        public final int m1516a(int i, com.google.android.m4b.maps.bh.i iVar) {
            if (this.f1068D && iVar != com.google.android.m4b.maps.bh.i.b) {
                return i;
            }
            if (iVar == com.google.android.m4b.maps.bh.i.e || iVar == com.google.android.m4b.maps.bh.i.d) {
                return 0;
            }
            if (iVar == com.google.android.m4b.maps.bh.i.a || iVar == com.google.android.m4b.maps.bh.i.c) {
                return i;
            }
            return i & -6663;
        }

        public final boolean m1519f() {
            return true;
        }

        public final void m1517a(GL10 gl10) {
            gl10.glColor4f(0.0f, 0.0f, 0.0f, 0.3f);
        }
    }

    /* renamed from: com.google.android.m4b.maps.ay.ah.c */
    static class C1399c extends ah {

        /* renamed from: com.google.android.m4b.maps.ay.ah.c.a */
        static class C1398a extends C1393b {
            private C1398a(int i) {
                super((byte) 0);
            }

            final ah m1520a() {
                return new C1399c();
            }
        }

        public final /* synthetic */ int compareTo(Object obj) {
            return super.m1504a((ah) obj);
        }

        public final j m1522a(i iVar, Resources resources, Locale locale, File file, boolean z, boolean z2) {
            int b;
            float f;
            float f2 = 3.0f;
            int b2 = ah.m1498b(resources.getDisplayMetrics().densityDpi);
            if (this == ah.f1036d) {
                b = m.b(resources, AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY);
            } else {
                b = m.a(resources, AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY);
            }
            if (this.f1061F) {
                f = resources.getDisplayMetrics().density;
            } else {
                f = 1.0f;
            }
            if (this != x) {
                f2 = f;
            } else if (f != 4.0f) {
                f2 = f == 3.0f ? 2.0f : f == 2.0f ? 1.5f : 1.0f;
            }
            return new com.google.android.m4b.maps.ba.c(iVar, this, b2, b, f2, locale, file, null);
        }

        public final c m1525g() {
            return new C1400d(this);
        }

        public final boolean m1524f() {
            return true;
        }

        public final void m1523a(GL10 gl10) {
            gl10.glColor4f(0.0f, 0.0f, 1.0f, 0.3f);
        }

        final int m1521a() {
            return AccessibilityNodeInfoCompat.ACTION_PREVIOUS_HTML_ELEMENT;
        }

        private C1399c(C1398a c1398a) {
            super((byte) 0);
        }
    }

    /* renamed from: com.google.android.m4b.maps.ay.ah.d */
    static class C1400d implements c {
        private ah f1069a;

        public C1400d(ah ahVar) {
            this.f1069a = ahVar;
        }

        public final aa m1526a(ac acVar, byte[] bArr, int i, long j, long j2) {
            DataInput aVar = new a(bArr);
            aVar.skipBytes(i);
            ah ahVar = this.f1069a;
            int readInt = aVar.readInt();
            if (readInt != 1146241364) {
                throw new IOException("TILE_MAGIC expected: " + readInt);
            }
            readInt = am.m1577a(aVar);
            if (readInt == 7 || readInt == 8) {
                ac a = ac.m1435a(aVar);
                if (a.m1450c() == acVar.m1450c() && a.m1451d() == acVar.m1451d() && a.m1449b() == acVar.m1449b()) {
                    int a2 = am.m1577a(aVar);
                    int a3 = am.m1577a(aVar);
                    int a4 = am.m1577a(aVar);
                    byte[] bArr2 = new byte[am.m1577a(aVar)];
                    aVar.readFully(bArr2);
                    return new bg(acVar, a2, a3, a4, bArr2, ahVar);
                }
                throw new IOException("Expected tile coords: " + acVar + " but received " + a);
            }
            throw new IOException("Version mismatch: 7 or 8 expected, " + readInt + " found");
        }
    }

    /* renamed from: com.google.android.m4b.maps.ay.ah.e */
    static class C1402e extends C1396i {

        /* renamed from: com.google.android.m4b.maps.ay.ah.e.a */
        static class C1401a extends C1394a {
            private C1401a(int i) {
                super((byte) 0);
            }

            final ah m1527a() {
                return new C1402e();
            }
        }

        private C1402e(C1401a c1401a) {
            super((byte) 0);
        }

        public final boolean m1529f() {
            return true;
        }

        public final void m1528a(GL10 gl10) {
            gl10.glColor4f(1.0f, 0.0f, 0.0f, 0.3f);
        }
    }

    /* renamed from: com.google.android.m4b.maps.ay.ah.f */
    static class C1404f extends ah {

        /* renamed from: com.google.android.m4b.maps.ay.ah.f.a */
        static class C1403a extends C1393b {
            private C1403a(int i) {
                super((byte) 0);
            }

            final ah m1530a() {
                return new C1404f();
            }
        }

        public final /* synthetic */ int compareTo(Object obj) {
            return super.m1504a((ah) obj);
        }

        public final j m1532a(i iVar, Resources resources, Locale locale, File file, boolean z, boolean z2) {
            return new e(iVar, m.a(resources, AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY), locale, file);
        }

        public final c m1533g() {
            return null;
        }

        final int m1531a() {
            return 0;
        }

        private C1404f(C1403a c1403a) {
            super((byte) 0);
        }
    }

    /* renamed from: com.google.android.m4b.maps.ay.ah.g */
    static class C1406g extends ah {

        /* renamed from: com.google.android.m4b.maps.ay.ah.g.a */
        static class C1405a extends C1393b {
            private C1405a(int i) {
                super((byte) 0);
            }

            final ah m1534a() {
                return new C1406g();
            }
        }

        public final /* synthetic */ int compareTo(Object obj) {
            return super.m1504a((ah) obj);
        }

        public final j m1536a(i iVar, Resources resources, Locale locale, File file, boolean z, boolean z2) {
            return new h(iVar, this, locale, file, null);
        }

        public final c m1538g() {
            return new C1407h();
        }

        final int m1535a() {
            return AccessibilityNodeInfoCompat.ACTION_PREVIOUS_HTML_ELEMENT;
        }

        public final l m1537b() {
            return new k(Math.max(Math.min(AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS, (p.f() >> 3) * 18), 36));
        }

        private C1406g(C1405a c1405a) {
            super((byte) 0);
        }
    }

    /* renamed from: com.google.android.m4b.maps.ay.ah.h */
    static class C1407h implements c {
        private C1407h() {
        }

        public final aa m1539a(ac acVar, byte[] bArr, int i, long j, long j2) {
            return C1317b.m1036a(acVar, bArr, i, j);
        }
    }

    /* renamed from: com.google.android.m4b.maps.ay.ah.j */
    static class C1408j implements c {
        private ah f1070a;

        public C1408j(ah ahVar) {
            this.f1070a = ahVar;
        }

        public final aa m1540a(ac acVar, byte[] bArr, int i, long j, long j2) {
            return ap.m1619a(acVar, bArr, i, this.f1070a, j, j2);
        }
    }

    abstract int m1502a();

    public abstract j m1506a(i iVar, Resources resources, Locale locale, File file, boolean z, boolean z2);

    abstract c m1512g();

    static /* synthetic */ int m1498b(int i) {
        return i > 160 ? 3 : 1;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m1504a((ah) obj);
    }

    static {
        f1024D = new HashMap();
        f1033a = new C1395a((byte) 0).m1493f(true).m1489d(true).m1490e(true).m1486a();
        f1034b = new C1395a((byte) 0).m1493f(true).m1489d(true).m1490e(true).m1486a();
        f1035c = new C1395a((byte) 0).m1493f(true).m1485a("_tran_base").m1489d(true).m1490e(true).m1486a();
        f1036d = new C1398a((byte) 0).m1488c(false).m1490e(true).m1486a();
        f1037e = new C1398a((byte) 0).m1485a("_ter").m1488c(false).m1490e(true).m1486a();
        f1038f = new C1394a((byte) 0).m1485a("_traf").m1486a();
        f1039g = new C1394a((byte) 0).m1485a("_traf").m1486a();
        f1040h = new C1403a((byte) 0).m1530a();
        f1041i = new C1405a((byte) 0).m1490e(true).m1486a();
        f1042j = new C1395a((byte) 0).m1495a(true).m1485a("_vec_bic").m1490e(true).m1486a();
        f1043k = new C1398a((byte) 0).m1484a((int) AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS).m1485a("_ter_bic").m1486a();
        f1044l = new C1398a((byte) 0).m1484a((int) AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS).m1485a("_hy_bic").m1486a();
        f1045m = new C1394a((byte) 0).m1485a("_tran").m1490e(true).m1486a();
        f1046n = new C1394a((byte) 0).m1490e(true).m1485a("_inaka").m1486a();
        f1047o = new C1401a((byte) 0).m1485a("_labl").m1489d(true).m1490e(true).m1486a();
        f1048p = new C1401a((byte) 0).m1485a("_tran_labl").m1489d(true).m1490e(true).m1486a();
        f1049q = new C1394a((byte) 0).m1485a("_psm").m1487b(true).m1486a();
        f1050r = new C1394a((byte) 0).m1485a("_related").m1487b(true).m1486a();
        f1051s = new C1394a((byte) 0).m1485a("_high").m1487b(true).m1490e(true).m1486a();
        f1052t = new C1394a((byte) 0).m1485a("_api").m1486a();
        f1053u = new C1394a((byte) 0).m1485a("_star").m1487b(true).m1490e(false).m1486a();
        f1054v = new C1394a((byte) 0).m1485a("_spotlight").m1486a();
        f1055w = new C1394a((byte) 0).m1485a("_maps_engine_vector").m1490e(true).m1486a();
        f1056x = new C1398a((byte) 0).m1485a("_maps_engine_image").m1490e(true).m1486a();
        f1025J = new C1454s(0, 0.0f, new int[0], 0);
        f1026K = new C1460y(ViewCompat.MEASURED_STATE_MASK, f1025J);
        f1027L = new C1460y(-16776961, f1025J);
        f1028M = new C1460y(SupportMenu.CATEGORY_MASK, f1025J);
        f1029N = new C1461z(-1, 0, 10, 1.2f, 1.0f, 0);
        f1030O = new C1455t(-1, 12, null, null, f1029N, f1026K, null, null);
        f1031P = new C1455t(-1, 12, null, null, f1029N, f1028M, null, null);
        f1032Q = new C1455t(-1, 12, null, null, f1029N, f1027L, null, null);
    }

    private ah(C1393b c1393b) {
        this.f1065y = c1393b.f1015a;
        this.f1066z = c1393b.f1016b;
        this.f1059C = c1393b.f1017c;
        this.f1057A = c1393b.f1018d;
        this.f1061F = c1393b.f1019e;
        this.f1062G = c1393b.f1020f;
        this.f1063H = c1393b.f1021g;
        this.f1064I = this.f1063H ? m1512g() : null;
        this.f1058B = this.f1065y + (this.f1066z << 8);
        this.f1060E = f1024D.size();
        f1024D.put(Integer.valueOf(this.f1065y + this.f1066z), this);
    }

    public final int m1504a(ah ahVar) {
        return this.f1060E - ahVar.f1060E;
    }

    public final com.google.android.m4b.maps.ae.c m1505a(String str, boolean z, d dVar) {
        if (!this.f1063H) {
            return null;
        }
        int i;
        if (z) {
            i = -1;
        } else {
            i = m1502a();
        }
        return new com.google.android.m4b.maps.ae.j(str, i, this.f1064I, this, dVar);
    }

    public l m1508b() {
        return new k(Math.max(Math.min(AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY, (p.f() >> 3) * 32), 64));
    }

    public static ah m1497a(int i) {
        return (ah) f1024D.get(Integer.valueOf(i));
    }

    public static Iterable<ah> m1500c() {
        return f1024D.values();
    }

    public final int m1509d() {
        return this.f1060E;
    }

    public String toString() {
        Field[] fields = getClass().getFields();
        int length = fields.length;
        int i = 0;
        while (i < length) {
            Field field = fields[i];
            try {
                if (this == field.get(this)) {
                    return field.getName();
                }
                i++;
            } catch (IllegalAccessException e) {
            }
        }
        return AnalyticsEvents.PARAMETER_SHARE_OUTCOME_UNKNOWN;
    }

    public int m1503a(int i, com.google.android.m4b.maps.bh.i iVar) {
        return i;
    }

    public boolean m1510e() {
        return false;
    }

    public boolean m1511f() {
        return false;
    }

    public void m1507a(GL10 gl10) {
    }
}
