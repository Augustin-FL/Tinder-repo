package com.google.android.m4b.maps.ay;

import com.google.android.m4b.maps.p009m.C1480a;

public final class au implements bb {
    private final C1480a f1137a;
    private final ak f1138b;
    private final byte[] f1139c;
    private final C1455t f1140d;
    private final int f1141e;
    private final String f1142f;
    private final int f1143g;
    private final int f1144h;
    private final int[] f1145i;

    public au(int i, C1480a c1480a, ak akVar, byte[] bArr, C1455t c1455t, int i2, String str, int i3, int i4, int[] iArr) {
        this.f1137a = c1480a;
        this.f1138b = akVar;
        this.f1139c = bArr;
        this.f1140d = c1455t;
        this.f1141e = i2;
        this.f1142f = str;
        this.f1143g = i3;
        this.f1144h = i4;
        this.f1145i = iArr;
    }

    public final C1480a m1694d() {
        return this.f1137a;
    }

    public final ak m1691a() {
        return this.f1138b;
    }

    public final boolean m1693c() {
        return this.f1139c != null;
    }

    public final byte[] m1697g() {
        return this.f1139c;
    }

    public final C1455t m1695e() {
        return this.f1140d;
    }

    public final int m1698h() {
        return this.f1141e;
    }

    public final String m1699i() {
        return this.f1142f;
    }

    public final int m1692b() {
        return 3;
    }

    public final int m1696f() {
        return this.f1143g;
    }

    public final boolean m1700j() {
        return C1436d.m1887a(this.f1144h, 4);
    }

    public final boolean m1702l() {
        return C1436d.m1887a(this.f1144h, 8);
    }

    public final int[] m1701k() {
        return this.f1145i;
    }

    public final int m1703q() {
        return ((this.f1138b.m1574b() + 60) + this.f1139c.length) + ((C1436d.m1884a(this.f1137a) + C1436d.m1885a(this.f1142f)) + C1436d.m1883a(this.f1140d));
    }
}
