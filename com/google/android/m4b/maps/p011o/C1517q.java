package com.google.android.m4b.maps.p011o;

import android.graphics.Point;
import com.google.android.m4b.maps.al.b;
import com.google.android.m4b.maps.ay.C1440g;
import com.google.android.m4b.maps.ay.aq;
import com.google.android.m4b.maps.ay.ar;
import com.google.android.m4b.maps.bq.ag.a;
import com.google.android.m4b.maps.model.LatLng;
import com.google.android.m4b.maps.model.LatLngBounds;
import com.google.android.m4b.maps.model.VisibleRegion;
import com.google.common.base.C1647e;

/* renamed from: com.google.android.m4b.maps.o.q */
public final class C1517q implements a {
    private final b f1566a;
    private final int f1567b;
    private final int f1568c;
    private final int f1569d;
    private final int f1570e;

    public C1517q(b bVar, int i, int i2, int i3, int i4) {
        this.f1566a = bVar;
        this.f1567b = i;
        this.f1568c = i2;
        this.f1569d = i3;
        this.f1570e = i4;
    }

    public final LatLng m2553a(Point point) {
        C1440g d = this.f1566a.d((float) point.x, (float) point.y);
        return d == null ? null : C1493b.m2360a(d);
    }

    public final Point m2552a(LatLng latLng) {
        int[] b = this.f1566a.b(C1493b.m2363b(latLng));
        return new Point(b[0], b[1]);
    }

    public final VisibleRegion m2554a() {
        aq a = this.f1566a.a(this.f1567b, this.f1568c, this.f1569d, this.f1570e);
        LatLng a2 = C1493b.m2360a(a.m1666d());
        LatLng a3 = C1493b.m2360a(a.m1667e());
        LatLng a4 = C1493b.m2360a(a.m1669g());
        LatLng a5 = C1493b.m2360a(a.m1668f());
        ar a6 = a.m1659a();
        return new VisibleRegion(a2, a3, a4, a5, LatLngBounds.b().a(C1493b.m2360a(a6.m1683g())).a(C1493b.m2360a(a6.m1682f())).a());
    }

    public final String toString() {
        return C1647e.m3072a((Object) this).m3069a("camera", this.f1566a).toString();
    }
}
