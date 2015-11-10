package com.google.android.m4b.maps.aj;

import android.view.animation.Interpolator;

/* renamed from: com.google.android.m4b.maps.aj.i */
public abstract class C1329i<V> extends C1328l {
    protected V f818a;
    protected V f819b;
    protected V f820c;
    protected boolean f821d;

    protected abstract void m1096a(long j);

    protected abstract void m1097a(V v);

    protected abstract void m1101b(V v);

    protected abstract void m1102c(V v);

    public C1329i(Interpolator interpolator) {
        this.f821d = false;
        setInterpolator(interpolator);
    }

    public final void m1098a(V v, V v2) {
        if (v != null && v2 != null) {
            m1097a((Object) v);
            m1101b((Object) v2);
            m1102c(v);
            this.f821d = true;
        }
    }

    public final void m1103d(V v) {
        if (v != null) {
            if (this.f821d) {
                m1097a(this.f820c);
                m1101b((Object) v);
                return;
            }
            m1098a(v, v);
        }
    }

    public boolean isInitialized() {
        return this.f821d;
    }

    public final V m1095a() {
        return this.f819b;
    }

    public final V m1099b() {
        return this.f820c;
    }

    public final void m1100b(long j) {
        m1096a(j);
    }
}
