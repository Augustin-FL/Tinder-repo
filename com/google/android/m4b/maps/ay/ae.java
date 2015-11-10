package com.google.android.m4b.maps.ay;

public final class ae {
    private final int f1008a;
    private final ac f1009b;
    private final C1459x f1010c;
    private final String[] f1011d;
    private final C1457v f1012e;

    public ae(int i, ac acVar, C1459x c1459x, String[] strArr, C1457v c1457v) {
        this.f1008a = i;
        this.f1009b = acVar;
        this.f1010c = c1459x;
        this.f1011d = strArr;
        this.f1012e = c1457v;
    }

    public final int m1459a() {
        return this.f1008a;
    }

    public final ac m1461b() {
        return this.f1009b;
    }

    public final C1455t m1460a(int i) {
        return this.f1010c.m2116a(i);
    }

    public final C1456u m1462b(int i) {
        return this.f1012e.m2110a(i);
    }

    public final String m1463c(int i) {
        String[] strArr = this.f1011d;
        Object obj = (strArr == null || i < 0 || i >= strArr.length) ? null : 1;
        return obj != null ? this.f1011d[i] : null;
    }
}
