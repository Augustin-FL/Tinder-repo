package com.google.android.m4b.maps.ay;

import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.m4b.maps.p014r.C1567f;
import java.io.DataInput;
import java.util.ArrayList;
import java.util.List;

public final class bk {
    private static final C1458w f1216a;
    private final List<C1434a> f1217b;
    private final ab f1218c;
    private final String f1219d;

    /* renamed from: com.google.android.m4b.maps.ay.bk.a */
    public static class C1434a {
        private final int f1208a;
        private final String f1209b;
        private final int f1210c;
        private final float f1211d;
        private final String f1212e;
        private final C1455t f1213f;
        private final String f1214g;
        private final float f1215h;

        public C1434a(int i, String str, int i2, String str2, C1455t c1455t, int i3, String str3, float f) {
            this.f1208a = i;
            this.f1209b = str;
            this.f1210c = i2;
            this.f1211d = 1.0f / ((float) i2);
            this.f1212e = str2;
            this.f1213f = c1455t;
            this.f1214g = str3;
            this.f1215h = f;
        }

        public static void m1823a(DataInput dataInput, ae aeVar, C1458w c1458w, List<C1434a> list) {
            String intern;
            int readUnsignedByte;
            String intern2;
            int b;
            float f;
            int readUnsignedByte2 = dataInput.readUnsignedByte();
            if (C1436d.m1887a(readUnsignedByte2, 1) && aeVar.m1459a() == 10) {
                intern = dataInput.readUTF().intern();
                readUnsignedByte = dataInput.readUnsignedByte();
            } else {
                readUnsignedByte = 1;
                intern = null;
            }
            if (C1436d.m1887a(readUnsignedByte2, 2)) {
                intern2 = C1567f.m2782a(dataInput.readUTF()).intern();
            } else {
                intern2 = null;
            }
            if (C1436d.m1887a(readUnsignedByte2, 4)) {
                c1458w = C1458w.m2111a(dataInput, aeVar);
            } else if (!C1434a.m1824a(readUnsignedByte2)) {
                c1458w = bk.f1216a;
            }
            if (aeVar.m1459a() != 10 && C1436d.m1887a(readUnsignedByte2, 1)) {
                C1455t a = c1458w.m2112a();
                if (a.m2101h()) {
                    bf l = a.m2105l();
                    intern = l.m1778a();
                    b = l.m1779b();
                    f = 0.0f;
                    if (C1436d.m1887a(readUnsignedByte2, 16)) {
                        f = ((float) am.m1577a(dataInput)) / 8.0f;
                    }
                    if (C1436d.m1887a(readUnsignedByte2, 32)) {
                        am.m1577a(dataInput);
                    }
                    if (C1436d.m1887a(readUnsignedByte2, 8) || readUnsignedByte2 == 8) {
                        list.add(new C1434a(readUnsignedByte2, intern, b, intern2, c1458w.m2112a(), c1458w.m2114c(), c1458w.m2113b(), f));
                    }
                    list.add(new C1434a(readUnsignedByte2 ^ 8, intern, b, intern2, c1458w.m2112a(), c1458w.m2114c(), c1458w.m2113b(), f));
                    list.add(new C1434a(8, null, 1, null, null, -1, null, GroundOverlayOptions.NO_DIMENSION));
                    return;
                }
            }
            b = readUnsignedByte;
            f = 0.0f;
            if (C1436d.m1887a(readUnsignedByte2, 16)) {
                f = ((float) am.m1577a(dataInput)) / 8.0f;
            }
            if (C1436d.m1887a(readUnsignedByte2, 32)) {
                am.m1577a(dataInput);
            }
            if (C1436d.m1887a(readUnsignedByte2, 8)) {
            }
            list.add(new C1434a(readUnsignedByte2, intern, b, intern2, c1458w.m2112a(), c1458w.m2114c(), c1458w.m2113b(), f));
        }

        public final boolean m1825a() {
            return C1434a.m1824a(this.f1208a);
        }

        private static boolean m1824a(int i) {
            return C1436d.m1887a(i, 2) && !C1436d.m1887a(i, 1);
        }

        public final boolean m1826b() {
            return C1436d.m1887a(this.f1208a, 1);
        }

        public final boolean m1827c() {
            return C1436d.m1887a(this.f1208a, 2);
        }

        public final boolean m1828d() {
            return C1436d.m1887a(this.f1208a, 4);
        }

        public final boolean m1829e() {
            return C1436d.m1887a(this.f1208a, 16);
        }

        public final boolean m1830f() {
            return C1436d.m1887a(this.f1208a, 8);
        }

        public final String m1831g() {
            return this.f1209b;
        }

        public final float m1832h() {
            return this.f1211d;
        }

        public final String m1833i() {
            return this.f1212e;
        }

        public final C1455t m1834j() {
            return this.f1213f;
        }

        public final float m1835k() {
            return this.f1215h;
        }

        public final int hashCode() {
            int i = 0;
            int hashCode = ((((this.f1214g == null ? 0 : this.f1214g.hashCode()) + (((this.f1213f == null ? 0 : this.f1213f.hashCode()) + (((this.f1209b == null ? 0 : this.f1209b.hashCode()) + ((((this.f1208a + 31) * 31) + Float.floatToIntBits(this.f1215h)) * 31)) * 31)) * 31)) * 31) + Float.floatToIntBits((float) this.f1210c)) * 31;
            if (this.f1212e != null) {
                i = this.f1212e.hashCode();
            }
            return hashCode + i;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            C1434a c1434a = (C1434a) obj;
            if (this.f1208a != c1434a.f1208a) {
                return false;
            }
            if (Float.floatToIntBits(this.f1215h) != Float.floatToIntBits(c1434a.f1215h)) {
                return false;
            }
            if (this.f1209b == null) {
                if (c1434a.f1209b != null) {
                    return false;
                }
            } else if (!this.f1209b.equals(c1434a.f1209b)) {
                return false;
            }
            if (this.f1213f == null) {
                if (c1434a.f1213f != null) {
                    return false;
                }
            } else if (!this.f1213f.equals(c1434a.f1213f)) {
                return false;
            }
            if (this.f1214g == null) {
                if (c1434a.f1214g != null) {
                    return false;
                }
            } else if (!this.f1214g.equals(c1434a.f1214g)) {
                return false;
            }
            if (Float.floatToIntBits((float) this.f1210c) != Float.floatToIntBits((float) c1434a.f1210c)) {
                return false;
            }
            if (this.f1212e != null) {
                return this.f1212e.equals(c1434a.f1212e);
            }
            if (c1434a.f1212e != null) {
                return false;
            }
            return true;
        }

        public final int m1836l() {
            return (((C1436d.m1885a(this.f1209b) + 48) + C1436d.m1885a(this.f1212e)) + C1436d.m1885a(this.f1214g)) + C1436d.m1883a(this.f1213f);
        }
    }

    static {
        f1216a = new C1458w(null, null, -1);
    }

    public bk(List<C1434a> list, ab abVar) {
        StringBuilder stringBuilder = new StringBuilder();
        for (C1434a c1434a : list) {
            if (c1434a.m1827c()) {
                stringBuilder.append(c1434a.m1833i());
            }
            if (c1434a.m1830f()) {
                stringBuilder.append('\n');
            }
        }
        this.f1219d = stringBuilder.toString();
        this.f1218c = abVar;
        this.f1217b = list;
    }

    public static bk m1837a(DataInput dataInput, ae aeVar, C1458w c1458w) {
        ab a;
        int a2 = am.m1577a(dataInput);
        List arrayList = new ArrayList();
        for (int i = 0; i < a2; i++) {
            C1434a.m1823a(dataInput, aeVar, c1458w, arrayList);
        }
        if (a2 > 1) {
            a = ab.m1427a(dataInput);
        } else {
            a = ab.f996b;
        }
        return new bk(arrayList, a);
    }

    public final String m1840a() {
        return this.f1219d;
    }

    public final int m1841b() {
        return this.f1217b.size();
    }

    public final C1434a m1839a(int i) {
        return (C1434a) this.f1217b.get(i);
    }

    public final ab m1842c() {
        return this.f1218c;
    }

    public final int hashCode() {
        return (((this.f1218c == null ? 0 : this.f1218c.hashCode()) + 31) * 31) + this.f1217b.hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        bk bkVar = (bk) obj;
        if (this.f1218c == null) {
            if (bkVar.f1218c != null) {
                return false;
            }
        } else if (!this.f1218c.equals(bkVar.f1218c)) {
            return false;
        }
        return this.f1217b.equals(bkVar.f1217b);
    }

    public final int m1843d() {
        int i = 0;
        for (C1434a l : this.f1217b) {
            i = l.m1836l() + i;
        }
        int a = (i + 24) + C1436d.m1885a(this.f1219d);
        ab abVar = this.f1218c;
        return a + ab.m1428c();
    }
}
