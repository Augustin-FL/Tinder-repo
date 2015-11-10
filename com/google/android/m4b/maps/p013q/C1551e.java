package com.google.android.m4b.maps.p013q;

import com.google.android.m4b.maps.ch.a;

/* renamed from: com.google.android.m4b.maps.q.e */
public final class C1551e {
    private final int f1707a;
    private final int f1708b;
    private final int f1709c;
    private final long f1710d;
    private final long f1711e;
    private final String f1712f;
    private String f1713g;

    public final String toString() {
        return "mapMoveDelayInMs: " + this.f1707a + " refreshPeriodInMs: " + this.f1708b + " minZoomLevel: " + this.f1709c + " distanceThresholdInMeters: " + this.f1710d + " useSavedSearchDistanceThresholdInmeters: " + this.f1711e + " mobileOffersHubBaseUrl: " + this.f1712f + " offersHubLogUrl: " + this.f1713g;
    }

    public C1551e(a aVar) {
        this.f1707a = aVar.d(1);
        this.f1708b = aVar.d(2);
        this.f1709c = aVar.d(3);
        this.f1710d = aVar.e(4);
        this.f1711e = aVar.e(6);
        this.f1712f = aVar.g(5);
        this.f1713g = aVar.g(7);
    }
}
