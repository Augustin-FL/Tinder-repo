package com.google.android.m4b.maps.aj;

import android.view.animation.Interpolator;
import com.google.common.base.C1650g;

/* renamed from: com.google.android.m4b.maps.aj.a */
public final class C1330a<V> extends C1329i<V> {
    private final V[] f822e;

    public C1330a(Interpolator interpolator, V[] vArr) {
        super(interpolator);
        C1650g.m3085a(vArr.length >= 2);
        this.f822e = vArr;
        this.a = vArr[0];
        this.b = vArr[vArr.length - 1];
        this.c = vArr[0];
        this.d = true;
    }

    protected final void m1104a(long j) {
        this.c = this.f822e[Math.min(Math.max((int) (c(j) * ((float) (this.f822e.length - 1))), 0), this.f822e.length - 1)];
    }

    protected final void m1105a(V v) {
        this.a = v;
    }

    protected final void m1106b(V v) {
        this.b = v;
    }

    protected final void m1107c(V v) {
        this.c = v;
    }
}
