package com.google.android.m4b.maps.aj;

import android.view.animation.Interpolator;

/* renamed from: com.google.android.m4b.maps.aj.f */
public class C1337f extends C1328l {
    private float f832a;
    private float f833b;
    private float f834c;
    private boolean f835d;

    public C1337f(Interpolator interpolator) {
        this.f835d = false;
        setInterpolator(interpolator);
    }

    public final void m1111a(float f) {
        if (this.f835d) {
            this.f832a = this.f834c;
            this.f833b = f;
            return;
        }
        this.f832a = f;
        this.f833b = f;
        this.f834c = f;
        this.f835d = true;
    }

    public boolean isInitialized() {
        return this.f835d;
    }

    public final float m1110a() {
        return this.f833b;
    }

    public final float m1112b() {
        return this.f834c;
    }
}
