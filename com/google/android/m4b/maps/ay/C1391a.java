package com.google.android.m4b.maps.ay;

import java.io.DataInput;

/* renamed from: com.google.android.m4b.maps.ay.a */
public final class C1391a {
    private final C1440g f989a;
    private final int f990b;
    private final float f991c;
    private final C1440g f992d;
    private final float f993e;
    private final float f994f;
    private final float f995g;

    public C1391a(C1440g c1440g, int i, float f, C1440g c1440g2, float f2, float f3, float f4) {
        this.f989a = c1440g;
        this.f990b = i;
        this.f991c = f;
        this.f992d = c1440g2;
        this.f993e = f2;
        this.f994f = f3;
        this.f995g = f4;
    }

    public static C1391a m1422a(DataInput dataInput, ac acVar) {
        float a;
        float a2;
        float a3;
        float a4;
        C1440g a5 = C1440g.m1928a(dataInput, acVar);
        int readUnsignedByte = dataInput.readUnsignedByte();
        if (C1436d.m1887a(readUnsignedByte, 1)) {
            a = ((float) am.m1577a(dataInput)) / 10.0f;
        } else {
            a = Float.NaN;
        }
        C1440g c1440g = null;
        if (C1436d.m1887a(readUnsignedByte, 2)) {
            c1440g = C1440g.m1928a(dataInput, acVar);
            a2 = ((float) am.m1577a(dataInput)) / 10.0f;
            a3 = ((float) am.m1577a(dataInput)) / 8.0f;
            a4 = ((float) am.m1577a(dataInput)) / 8.0f;
        } else {
            a4 = Float.NaN;
            a3 = Float.NaN;
            a2 = Float.NaN;
        }
        return new C1391a(a5, readUnsignedByte, a, c1440g, a2, a3, a4);
    }

    public final boolean m1423a() {
        return C1436d.m1887a(this.f990b, 1);
    }

    public final C1440g m1424b() {
        return this.f989a;
    }

    public final float m1425c() {
        return this.f991c;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((((((((this.f992d == null ? 0 : this.f992d.hashCode()) + 31) * 31) + Float.floatToIntBits(this.f994f)) * 31) + Float.floatToIntBits(this.f993e)) * 31) + Float.floatToIntBits(this.f995g)) * 31) + this.f990b) * 31;
        if (this.f989a != null) {
            i = this.f989a.hashCode();
        }
        return ((hashCode + i) * 31) + Float.floatToIntBits(this.f991c);
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
        C1391a c1391a = (C1391a) obj;
        if (this.f992d == null) {
            if (c1391a.f992d != null) {
                return false;
            }
        } else if (!this.f992d.equals(c1391a.f992d)) {
            return false;
        }
        if (Float.floatToIntBits(this.f994f) != Float.floatToIntBits(c1391a.f994f)) {
            return false;
        }
        if (Float.floatToIntBits(this.f993e) != Float.floatToIntBits(c1391a.f993e)) {
            return false;
        }
        if (Float.floatToIntBits(this.f995g) != Float.floatToIntBits(c1391a.f995g)) {
            return false;
        }
        if (this.f990b != c1391a.f990b) {
            return false;
        }
        if (this.f989a == null) {
            if (c1391a.f989a != null) {
                return false;
            }
        } else if (!this.f989a.equals(c1391a.f989a)) {
            return false;
        }
        if (Float.floatToIntBits(this.f991c) != Float.floatToIntBits(c1391a.f991c)) {
            return false;
        }
        return true;
    }

    public final int m1426d() {
        return (C1436d.m1882a(this.f989a) + 40) + C1436d.m1882a(this.f992d);
    }
}
