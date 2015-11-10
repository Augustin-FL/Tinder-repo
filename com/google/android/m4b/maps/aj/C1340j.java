package com.google.android.m4b.maps.aj;

import android.view.animation.Interpolator;
import com.google.android.m4b.maps.ay.C1440g;

/* renamed from: com.google.android.m4b.maps.aj.j */
public final class C1340j extends C1329i<C1440g> {
    protected final /* synthetic */ void m1120a(Object obj) {
        ((C1440g) this.a).m1950b((C1440g) obj);
    }

    protected final /* bridge */ /* synthetic */ void m1121b(Object obj) {
        ((C1440g) this.b).m1950b((C1440g) obj);
    }

    protected final /* synthetic */ void m1122c(Object obj) {
        ((C1440g) this.c).m1950b((C1440g) obj);
    }

    public C1340j(Interpolator interpolator) {
        super(interpolator);
        this.a = new C1440g();
        this.b = new C1440g();
        this.c = new C1440g();
    }

    protected final void m1119a(long j) {
        C1440g.m1930a((C1440g) this.a, (C1440g) this.b, c(j), (C1440g) this.c);
    }
}
