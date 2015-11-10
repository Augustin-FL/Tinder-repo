package com.google.android.m4b.maps.av;

import com.google.android.m4b.maps.ag.r;
import com.google.android.m4b.maps.av.C1383i.C1377b;

/* renamed from: com.google.android.m4b.maps.av.o */
public final class C1388o extends C1387r {
    public C1388o(C1377b c1377b) {
        super(c1377b);
        this.b = 0.05f;
        this.c = (float) Math.tan(0.3490658503988659d);
    }

    protected final float m1404a(C1367h c1367h, int i) {
        return c1367h.m1289b(i);
    }

    protected final float m1405b(C1367h c1367h, int i) {
        return c1367h.m1287a(i);
    }

    protected final float m1403a(float f) {
        return Math.min(Math.abs(f), (float) Math.abs(((double) Math.abs(f)) - 3.141592653589793d));
    }

    protected final boolean m1406b(C1383i c1383i) {
        r.a(99, "s");
        return this.a.m1344h(c1383i);
    }

    protected final void m1407d(C1383i c1383i) {
        this.a.m1345i(c1383i);
    }

    protected final boolean m1408f(C1383i c1383i) {
        return this.a.m1343g(c1383i);
    }
}
