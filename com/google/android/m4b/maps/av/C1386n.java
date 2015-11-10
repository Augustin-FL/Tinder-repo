package com.google.android.m4b.maps.av;

/* renamed from: com.google.android.m4b.maps.av.n */
public final class C1386n extends C1370b {
    private float f983b;
    private float f984c;

    public C1386n(int i, C1383i c1383i) {
        super(i, c1383i);
    }

    public final void m1395a(float f, float f2) {
        this.f983b = f / 2.0f;
        this.f984c = f2 / 2.0f;
    }

    public final float m1394a() {
        return this.f983b;
    }

    public final float m1396b() {
        return this.f984c;
    }

    public final float m1397c() {
        float c = this.a.m1381c();
        return (float) ((((double) ((this.a.m1378a() - c) * Math.signum(this.a.m1380b() - this.f984c))) * 3.141592653589793d) / 256.0d);
    }
}
