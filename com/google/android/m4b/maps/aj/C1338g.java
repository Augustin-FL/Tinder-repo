package com.google.android.m4b.maps.aj;

import android.view.animation.Interpolator;

/* renamed from: com.google.android.m4b.maps.aj.g */
public final class C1338g extends C1328l {
    private int f836a;
    private int f837b;
    private int f838c;
    private boolean f839d;

    public C1338g(Interpolator interpolator) {
        this.f839d = false;
        setInterpolator(interpolator);
    }

    public final void m1114a(int i) {
        if (this.f839d) {
            this.f836a = this.f838c;
            this.f837b = i;
            return;
        }
        this.f836a = i;
        this.f837b = i;
        this.f838c = i;
        this.f839d = true;
    }

    public final boolean isInitialized() {
        return this.f839d;
    }

    public final int m1113a() {
        return this.f837b;
    }

    public final int m1116b() {
        return this.f838c;
    }

    public final void m1115a(long j) {
        float f = (float) this.f836a;
        this.f838c = Math.round((c(j) * ((float) (this.f837b - this.f836a))) + f);
    }
}
