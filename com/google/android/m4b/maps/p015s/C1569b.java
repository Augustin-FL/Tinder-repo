package com.google.android.m4b.maps.p015s;

/* renamed from: com.google.android.m4b.maps.s.b */
public final class C1569b {
    private int f1768a;
    private int f1769b;
    private int f1770c;
    private int f1771d;
    private int f1772e;

    public C1569b(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i5 == 0 || i5 == 1) {
            this.f1768a = i;
            this.f1769b = i2;
            this.f1770c = i3;
            this.f1771d = i4;
            this.f1772e = i5;
            return;
        }
        throw new IllegalArgumentException("qualityAlgorithm = " + i5);
    }

    public final int m2786a() {
        return this.f1768a;
    }

    public final int m2787b() {
        return this.f1769b;
    }

    public final int m2788c() {
        return this.f1770c;
    }

    public final int m2789d() {
        return this.f1771d;
    }

    public final int m2790e() {
        return this.f1772e;
    }
}
