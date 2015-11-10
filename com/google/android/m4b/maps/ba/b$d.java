package com.google.android.m4b.maps.ba;

import com.google.android.m4b.maps.ad.d;
import com.google.android.m4b.maps.ay.ac;
import com.google.android.m4b.maps.ay.ah;
import com.google.android.m4b.maps.ba.C1464a.C1463b;

public class b$d {
    final ac f1373a;
    final d f1374b;
    final boolean f1375c;
    final C1463b f1376d;
    final boolean f1377e;
    final boolean f1378f;
    final boolean f1379g;
    final ah f1380h;
    int f1381i;
    private volatile boolean f1382j;
    private b$d f1383k;

    protected b$d(ah ahVar, ac acVar, d dVar, C1463b c1463b, boolean z, boolean z2, int i, boolean z3) {
        boolean z4 = false;
        this.j = false;
        this.k = null;
        this.h = ahVar;
        this.a = acVar;
        this.b = dVar;
        this.d = c1463b;
        if (c1463b.equals(C1463b.PREFETCH_AREA) || c1463b.equals(C1463b.PREFETCH_ROUTE)) {
            z4 = true;
        }
        this.c = z4;
        this.e = z;
        this.i = i;
        this.f = z2;
        this.g = z3;
    }

    protected b$d(ah ahVar, ac acVar, d dVar) {
        this(ahVar, acVar, dVar, C1463b.NORMAL, false, false, -1, false);
    }

    protected b$d(ah ahVar, ac acVar, d dVar, boolean z, boolean z2) {
        this(ahVar, acVar, dVar, C1463b.NORMAL, false, true, -1, false);
    }

    protected final boolean m2165a() {
        return this.k != null;
    }

    final void m2164a(b$d com_google_android_m4b_maps_ba_b_d) {
        com_google_android_m4b_maps_ba_b_d.k = this.k;
        this.k = com_google_android_m4b_maps_ba_b_d;
    }

    public final String toString() {
        return this.h + "/" + this.a;
    }
}
