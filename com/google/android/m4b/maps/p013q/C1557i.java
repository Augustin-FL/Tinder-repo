package com.google.android.m4b.maps.p013q;

import com.google.android.m4b.maps.ch.a;

/* renamed from: com.google.android.m4b.maps.q.i */
public final class C1557i {
    private final int f1741a;
    private final boolean f1742b;
    private final int f1743c;
    private final int f1744d;
    private final int f1745e;
    private int f1746f;
    private boolean f1747g;
    private final boolean f1748h;
    private final boolean f1749i;

    public final String toString() {
        return "personalizedSmartMapsTileDuration: " + this.f1741a + " onlyRequestPsmWhenPoiInBaseTile: " + this.f1742b + " minPsmRequestZoom: " + this.f1743c + " pertileDuration: " + this.f1744d + " pertileClientCoverage: " + this.f1745e + " diskCacheServerSchemaVersion:" + this.f1746f + " offlineBorderTiles:" + this.f1747g;
    }

    public C1557i(a aVar) {
        this.f1741a = aVar.d(1);
        this.f1742b = aVar.b(2);
        this.f1743c = aVar.d(3);
        this.f1744d = aVar.d(4);
        this.f1745e = aVar.d(6);
        this.f1746f = aVar.d(7);
        this.f1747g = aVar.b(8);
        this.f1748h = aVar.h(9);
        this.f1749i = aVar.b(9);
    }

    public final long m2757a() {
        return ((long) this.f1744d) * 60000;
    }

    public final int m2758b() {
        return this.f1746f;
    }

    public final boolean m2759c() {
        return this.f1747g;
    }

    public final boolean m2760d() {
        return this.f1748h;
    }

    public final boolean m2761e() {
        return this.f1749i;
    }
}
