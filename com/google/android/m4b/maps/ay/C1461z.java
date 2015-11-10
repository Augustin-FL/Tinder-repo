package com.google.android.m4b.maps.ay;

import java.io.DataInput;

/* renamed from: com.google.android.m4b.maps.ay.z */
public final class C1461z {
    private static C1461z f1339g;
    private final int f1340a;
    private final int f1341b;
    private final int f1342c;
    private final float f1343d;
    private final float f1344e;
    private final int f1345f;

    static {
        f1339g = new C1461z(0, 0, 12, 0.0f, 0.0f, 0);
    }

    public C1461z(int i, int i2, int i3, float f, float f2, int i4) {
        this.f1340a = i;
        this.f1341b = i2;
        this.f1342c = i3;
        this.f1343d = f;
        this.f1344e = f2;
        this.f1345f = i4;
    }

    public static C1461z m2121a(DataInput dataInput) {
        return new C1461z(dataInput.readInt(), dataInput.readInt(), dataInput.readUnsignedByte(), ((float) dataInput.readUnsignedShort()) / 100.0f, ((float) dataInput.readUnsignedShort()) / 100.0f, dataInput.readUnsignedByte());
    }

    public static C1461z m2120a() {
        return f1339g;
    }

    public final boolean m2122b() {
        return C1436d.m1887a(1, this.f1345f);
    }

    public final boolean m2123c() {
        return C1436d.m1887a(2, this.f1345f);
    }

    public final int m2124d() {
        return this.f1340a;
    }

    public final int m2125e() {
        return this.f1341b;
    }

    public final int m2126f() {
        return this.f1342c;
    }

    public final float m2127g() {
        return this.f1343d;
    }

    public final int hashCode() {
        return ((((((((((this.f1345f + 31) * 31) + this.f1340a) * 31) + Float.floatToIntBits(this.f1343d)) * 31) + this.f1341b) * 31) + this.f1342c) * 31) + Float.floatToIntBits(this.f1344e);
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
        C1461z c1461z = (C1461z) obj;
        if (this.f1345f != c1461z.f1345f) {
            return false;
        }
        if (this.f1340a != c1461z.f1340a) {
            return false;
        }
        if (this.f1343d != c1461z.f1343d) {
            return false;
        }
        if (this.f1341b != c1461z.f1341b) {
            return false;
        }
        if (this.f1342c != c1461z.f1342c) {
            return false;
        }
        if (this.f1344e != c1461z.f1344e) {
            return false;
        }
        return true;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TextStyle{color=").append(Integer.toHexString(this.f1340a)).append(", outlineColor=").append(Integer.toHexString(this.f1341b)).append(", size=").append(this.f1342c).append(", leadingRatio=").append(this.f1343d).append(", trackingRatio=").append(this.f1344e).append(", attributes=").append(this.f1345f).append('}');
        return stringBuilder.toString();
    }
}
