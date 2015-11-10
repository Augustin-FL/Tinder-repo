package com.google.android.m4b.maps.ay;

import com.google.android.m4b.maps.p010n.C1489b;
import java.io.DataInput;
import java.util.Arrays;

/* renamed from: com.google.android.m4b.maps.ay.s */
public final class C1454s {
    private static C1454s f1314e;
    private final int f1315a;
    private final float f1316b;
    private final int[] f1317c;
    private final int f1318d;

    static {
        f1314e = new C1454s(0, 1.0f, new int[0], 0);
    }

    public C1454s(int i, float f, int[] iArr, int i2) {
        this.f1315a = i;
        this.f1316b = f;
        this.f1317c = iArr;
        this.f1318d = i2;
    }

    public static C1454s m2082a(DataInput dataInput) {
        int readInt = dataInput.readInt();
        float readUnsignedByte = ((float) dataInput.readUnsignedByte()) / 8.0f;
        int a = am.m1577a(dataInput);
        int[] iArr = new int[a];
        for (int i = 0; i < a; i++) {
            iArr[i] = dataInput.readShort();
        }
        if (C1489b.f1448b) {
            iArr = new int[0];
        }
        for (int i2 : r0) {
            if (i2 == 0) {
                iArr = new int[0];
                break;
            }
        }
        return new C1454s(readInt, readUnsignedByte, iArr, dataInput.readUnsignedByte());
    }

    public static C1454s m2081a() {
        return f1314e;
    }

    public final int m2083b() {
        return this.f1315a;
    }

    public final float m2084c() {
        return this.f1316b;
    }

    public final int[] m2085d() {
        return this.f1317c;
    }

    public final boolean m2086e() {
        return this.f1317c != null && this.f1317c.length > 0;
    }

    public final boolean m2087f() {
        return (this.f1318d & 1) != 0;
    }

    public final boolean m2088g() {
        return (this.f1318d & 2) != 0;
    }

    public final int hashCode() {
        return ((((((this.f1315a + 31) * 31) + Arrays.hashCode(this.f1317c)) * 31) + this.f1318d) * 31) + Float.floatToIntBits(this.f1316b);
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
        C1454s c1454s = (C1454s) obj;
        if (this.f1315a != c1454s.f1315a) {
            return false;
        }
        if (!Arrays.equals(this.f1317c, c1454s.f1317c)) {
            return false;
        }
        if (this.f1318d != c1454s.f1318d) {
            return false;
        }
        if (Float.floatToIntBits(this.f1316b) != Float.floatToIntBits(c1454s.f1316b)) {
            return false;
        }
        return true;
    }

    public final int m2089h() {
        return (this.f1317c.length * 4) + 24;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Stroke{color=").append(Integer.toHexString(this.f1315a)).append(", width=").append(this.f1316b).append(", dashes=").append(Arrays.toString(this.f1317c)).append(", endCaps=");
        if ((this.f1318d & 1) != 0) {
            stringBuilder.append("S");
        }
        if ((this.f1318d & 2) != 0) {
            stringBuilder.append("E");
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
