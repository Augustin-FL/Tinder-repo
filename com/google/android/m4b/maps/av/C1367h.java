package com.google.android.m4b.maps.av;

import android.util.FloatMath;

/* renamed from: com.google.android.m4b.maps.av.h */
public abstract class C1367h {
    private Float f905a;
    private Float f906b;

    public abstract float m1287a(int i);

    public abstract long m1288a();

    public abstract float m1289b(int i);

    public abstract int m1290b();

    public abstract float m1291c();

    public abstract float m1292d();

    public abstract void m1293e();

    public final float m1294f() {
        if (this.f905a == null) {
            this.f905a = Float.valueOf(C1367h.m1286a(m1287a(0), m1289b(0), m1287a(m1290b() - 1), m1289b(m1290b() - 1)));
        }
        return this.f905a.floatValue();
    }

    public static float m1286a(float f, float f2, float f3, float f4) {
        return (float) Math.atan2((double) (f3 - f), (double) (f4 - f2));
    }

    public final float m1295g() {
        if (this.f906b == null) {
            float a = m1287a(0) - m1287a(m1290b() - 1);
            float b = m1289b(0) - m1289b(m1290b() - 1);
            this.f906b = Float.valueOf(FloatMath.sqrt((a * a) + (b * b)));
        }
        return this.f906b.floatValue();
    }
}
