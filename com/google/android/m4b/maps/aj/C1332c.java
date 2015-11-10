package com.google.android.m4b.maps.aj;

import android.view.animation.Interpolator;
import com.google.common.base.C1650g;

/* renamed from: com.google.android.m4b.maps.aj.c */
public final class C1332c implements Interpolator {
    private final float f824a;

    public C1332c(float f) {
        boolean z = 0.0f <= f && f < 1.0f;
        C1650g.m3085a(z);
        this.f824a = f;
    }

    public final float getInterpolation(float f) {
        float min = Math.min(Math.max(f, 0.0f), 1.0f);
        if (min < this.f824a) {
            return 0.0f;
        }
        return (float) (((double) (min - this.f824a)) / (1.0d - ((double) this.f824a)));
    }
}
