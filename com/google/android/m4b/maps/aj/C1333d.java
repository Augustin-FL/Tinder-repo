package com.google.android.m4b.maps.aj;

import android.view.animation.Interpolator;

/* renamed from: com.google.android.m4b.maps.aj.d */
public final class C1333d implements Interpolator {
    private final float f825a;

    public C1333d(float f) {
        this.f825a = 0.99f;
    }

    public final float getInterpolation(float f) {
        if (f < 0.0f) {
            return 0.0f;
        }
        return (float) (1.0d - Math.pow((double) (1.0f - this.f825a), (double) f));
    }
}
