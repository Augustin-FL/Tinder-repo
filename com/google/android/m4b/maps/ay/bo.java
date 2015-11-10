package com.google.android.m4b.maps.ay;

import com.google.android.m4b.maps.p009m.C1480a;

public final class bo implements bb {
    private C1446k f1232a;
    private C1455t f1233b;
    private final String f1234c;
    private int f1235d;
    private final int[] f1236e;

    public bo(int i, C1446k c1446k, C1455t c1455t, int i2, String str, int i3, int i4, int[] iArr) {
        this.f1232a = c1446k;
        this.f1233b = c1455t;
        this.f1234c = str;
        this.f1235d = i3;
        this.f1236e = iArr;
    }

    public final C1446k m1863a() {
        return this.f1232a;
    }

    public final C1455t m1866e() {
        return this.f1233b;
    }

    public final int m1867f() {
        return this.f1235d;
    }

    public final int m1864b() {
        return 5;
    }

    public final int[] m1868k() {
        return this.f1236e;
    }

    public final C1480a m1865d() {
        return null;
    }

    public final int m1869q() {
        return ((this.f1232a.m2032i() + 44) + C1436d.m1885a(this.f1234c)) + C1436d.m1883a(this.f1233b);
    }
}
