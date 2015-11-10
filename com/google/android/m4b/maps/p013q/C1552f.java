package com.google.android.m4b.maps.p013q;

import com.google.android.m4b.maps.bo.o;
import com.google.android.m4b.maps.ch.a;

/* renamed from: com.google.android.m4b.maps.q.f */
public final class C1552f {
    private final int f1714a;
    private final int f1715b;
    private final int f1716c;
    private final int f1717d;
    private final int f1718e;
    private final int f1719f;

    public final String toString() {
        return "maxTiles: " + this.f1714a + " maxServerTiles: " + this.f1715b + " prefetchPeriod: " + this.f1716c + " prefetchInitiatorDelay: " + this.f1717d + " prefetchInitiatorPeriod: " + this.f1718e + " timeToWipe: " + this.f1719f;
    }

    public C1552f(a aVar) {
        this.f1714a = aVar.d(1);
        this.f1715b = aVar.d(2);
        this.f1716c = aVar.d(3);
        this.f1717d = aVar.d(4);
        this.f1718e = aVar.d(5);
        this.f1719f = aVar.d(6);
        aVar.d(7);
        aVar.e(8);
        aVar.b(9);
    }

    public final long m2726a() {
        return ((long) this.f1719f) * 86400000;
    }

    public static a m2725b() {
        return new a(o.l);
    }
}
