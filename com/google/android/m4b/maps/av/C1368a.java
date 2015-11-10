package com.google.android.m4b.maps.av;

import android.view.MotionEvent;
import com.google.android.m4b.maps.ag.e;

/* renamed from: com.google.android.m4b.maps.av.a */
public final class C1368a extends C1367h {
    private MotionEvent f907a;

    public C1368a(MotionEvent motionEvent) {
        this.f907a = motionEvent;
    }

    public final long m1297a() {
        return this.f907a.getEventTime();
    }

    public final int m1299b() {
        return this.f907a.getPointerCount();
    }

    public final float m1296a(int i) {
        return this.f907a.getX(i);
    }

    public final float m1298b(int i) {
        return this.f907a.getY(i);
    }

    public final float m1300c() {
        return e.a().f();
    }

    public final float m1301d() {
        return e.a().g();
    }

    public final void m1302e() {
        this.f907a.recycle();
        this.f907a = null;
    }
}
