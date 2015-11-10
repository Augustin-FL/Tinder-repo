package com.google.android.m4b.maps.p009m;

/* renamed from: com.google.android.m4b.maps.m.b */
public final class C1485b {
    private final int f1443a;
    private final int f1444b;

    public C1485b(int i, int i2) {
        if (i2 == -180000000) {
            i2 *= -1;
        }
        this.f1443a = i;
        this.f1444b = i2;
    }

    public final int m2307a() {
        return this.f1443a;
    }

    public final int m2308b() {
        return this.f1444b;
    }

    public final String toString() {
        return String.valueOf(this.f1443a) + "," + String.valueOf(this.f1444b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1485b)) {
            return false;
        }
        C1485b c1485b = (C1485b) obj;
        if (c1485b.f1443a == this.f1443a && c1485b.f1444b == this.f1444b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.f1443a * 29) + this.f1444b;
    }
}
