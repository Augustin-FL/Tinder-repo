package com.google.android.m4b.maps.ay;

import java.io.DataInput;
import java.util.Arrays;

/* renamed from: com.google.android.m4b.maps.ay.t */
public final class C1455t {
    private static final int[] f1319a;
    private static C1455t f1320b;
    private final int f1321c;
    private final int f1322d;
    private final int[] f1323e;
    private final C1454s[] f1324f;
    private final C1461z f1325g;
    private final C1460y f1326h;
    private final C1454s f1327i;
    private final bf f1328j;

    static {
        f1319a = new int[0];
        f1320b = new C1455t(-1, 0, f1319a, new C1454s[0], C1461z.m2120a(), C1460y.m2117a(), C1454s.m2081a(), null);
    }

    public static C1455t m2091a(int i, DataInput dataInput, int i2) {
        int a;
        int[] iArr;
        C1454s[] c1454sArr;
        C1461z a2;
        C1460y a3;
        C1454s a4;
        bf bfVar;
        int i3 = 0;
        int readUnsignedByte = dataInput.readUnsignedByte();
        if (C1436d.m1887a(readUnsignedByte, 1)) {
            a = am.m1577a(dataInput);
            iArr = new int[a];
            for (int i4 = 0; i4 < a; i4++) {
                iArr[i4] = dataInput.readInt();
            }
        } else {
            iArr = null;
        }
        if (C1436d.m1887a(readUnsignedByte, 2)) {
            a = am.m1577a(dataInput);
            c1454sArr = new C1454s[a];
            while (i3 < a) {
                c1454sArr[i3] = C1454s.m2082a(dataInput);
                i3++;
            }
        } else {
            c1454sArr = null;
        }
        if (C1436d.m1887a(readUnsignedByte, 4)) {
            a2 = C1461z.m2121a(dataInput);
        } else {
            a2 = null;
        }
        if (C1436d.m1887a(readUnsignedByte, 8)) {
            a3 = C1460y.m2118a(dataInput, i2);
        } else {
            a3 = null;
        }
        if (C1436d.m1887a(readUnsignedByte, 16)) {
            a4 = C1454s.m2082a(dataInput);
        } else {
            a4 = null;
        }
        if (i2 == 11 && C1436d.m1887a(readUnsignedByte, 32)) {
            bfVar = new bf(dataInput.readUTF(), dataInput.readUnsignedByte());
        } else {
            bfVar = null;
        }
        return new C1455t(i, readUnsignedByte, iArr, c1454sArr, a2, a3, a4, bfVar);
    }

    public static C1455t m2090a() {
        return f1320b;
    }

    public C1455t(int i, int i2, int[] iArr, C1454s[] c1454sArr, C1461z c1461z, C1460y c1460y, C1454s c1454s, bf bfVar) {
        this.f1321c = i;
        this.f1322d = i2;
        this.f1323e = iArr;
        this.f1324f = c1454sArr;
        this.f1325g = c1461z;
        this.f1326h = c1460y;
        this.f1327i = c1454s;
        this.f1328j = bfVar;
    }

    public final int m2094b() {
        return this.f1324f == null ? 0 : this.f1324f.length;
    }

    public final int m2096c() {
        return this.f1323e == null ? 0 : this.f1323e.length;
    }

    public final int m2093a(int i) {
        return this.f1323e[i];
    }

    public final boolean m2097d() {
        return C1436d.m1887a(this.f1322d, 2);
    }

    public final boolean m2098e() {
        return C1436d.m1887a(this.f1322d, 4);
    }

    public final boolean m2099f() {
        return C1436d.m1887a(this.f1322d, 8);
    }

    public final boolean m2100g() {
        return C1436d.m1887a(this.f1322d, 16);
    }

    public final boolean m2101h() {
        return C1436d.m1887a(this.f1322d, 32);
    }

    public final C1454s m2095b(int i) {
        return this.f1324f[i];
    }

    public final C1461z m2102i() {
        return this.f1325g;
    }

    public final C1460y m2103j() {
        return this.f1326h;
    }

    public final C1454s m2104k() {
        return this.f1327i;
    }

    public final bf m2105l() {
        return this.f1328j;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.f1326h == null ? 0 : this.f1326h.hashCode()) + (((((((((((this.f1327i == null ? 0 : this.f1327i.hashCode()) + 31) * 31) + this.f1322d) * 31) + Arrays.hashCode(this.f1323e)) * 31) + this.f1321c) * 31) + Arrays.hashCode(this.f1324f)) * 31)) * 31;
        if (this.f1325g != null) {
            i = this.f1325g.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Style{id=").append(this.f1321c).append(", ");
        C1455t.m2092a("fillColors", this.f1323e, stringBuilder);
        stringBuilder.append(", ");
        stringBuilder.append(", components=").append(this.f1322d).append(", strokes=").append(this.f1324f == null ? null : Arrays.asList(this.f1324f)).append(", textStyle=").append(this.f1325g).append(", textBoxStyle=").append(this.f1326h).append(", arrowStyle=").append(this.f1327i).append(", icon=").append(this.f1328j).append('}');
        return stringBuilder.toString();
    }

    private static void m2092a(String str, int[] iArr, StringBuilder stringBuilder) {
        stringBuilder.append(str).append("=");
        if (iArr == null) {
            stringBuilder.append(iArr);
            return;
        }
        stringBuilder.append("[");
        Object obj = 1;
        for (int i : iArr) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append(",");
            }
            stringBuilder.append(Integer.toHexString(i));
        }
        stringBuilder.append("]");
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
        C1455t c1455t = (C1455t) obj;
        if (this.f1327i == null) {
            if (c1455t.f1327i != null) {
                return false;
            }
        } else if (!this.f1327i.equals(c1455t.f1327i)) {
            return false;
        }
        if (this.f1322d != c1455t.f1322d) {
            return false;
        }
        if (!Arrays.equals(this.f1323e, c1455t.f1323e)) {
            return false;
        }
        if (this.f1321c != c1455t.f1321c) {
            return false;
        }
        if (!Arrays.equals(this.f1324f, c1455t.f1324f)) {
            return false;
        }
        if (this.f1326h == null) {
            if (c1455t.f1326h != null) {
                return false;
            }
        } else if (!this.f1326h.equals(c1455t.f1326h)) {
            return false;
        }
        if (this.f1325g == null) {
            if (c1455t.f1325g != null) {
                return false;
            }
            return true;
        } else if (this.f1325g.equals(c1455t.f1325g)) {
            return true;
        } else {
            return false;
        }
    }

    public final int m2106m() {
        int i;
        int i2 = 0;
        int length = this.f1323e == null ? 0 : this.f1323e.length * 4;
        if (this.f1324f != null) {
            C1454s[] c1454sArr = this.f1324f;
            int i3 = 0;
            i = 0;
            while (i3 < c1454sArr.length) {
                int h = c1454sArr[i3].m2089h() + i;
                i3++;
                i = h;
            }
        } else {
            i = 0;
        }
        C1454s c1454s = this.f1327i;
        if (c1454s != null) {
            i2 = c1454s.m2089h();
        }
        return ((length + 60) + i) + i2;
    }
}
