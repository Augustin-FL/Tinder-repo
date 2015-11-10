package com.google.android.m4b.maps.av;

import android.content.Context;
import android.view.MotionEvent;
import com.google.android.m4b.maps.av.C1383i.C1377b;
import com.google.android.m4b.maps.av.C1383i.C1382a;

/* renamed from: com.google.android.m4b.maps.av.f */
public final class C1378f implements C1377b {
    private C1382a f920a;
    private C1383i f921b;
    private boolean f922c;

    public final void m1346a(Context context, C1382a c1382a) {
        this.f920a = c1382a;
        this.f921b = new C1383i(context, this);
    }

    public final boolean m1347a(MotionEvent motionEvent) {
        return this.f921b.m1379a(motionEvent);
    }

    public final boolean m1349a(C1383i c1383i, boolean z) {
        if (z) {
            return true;
        }
        return this.f920a.m1369a(new C1372c(0, c1383i));
    }

    public final boolean m1351b(C1383i c1383i, boolean z) {
        if (z) {
            return true;
        }
        return this.f920a.m1369a(new C1372c(1, c1383i));
    }

    public final void m1353c(C1383i c1383i, boolean z) {
        if (z) {
            this.f920a.m1369a(new C1372c(3, c1383i));
        } else {
            this.f920a.m1369a(new C1372c(2, c1383i));
        }
    }

    public final boolean m1348a(C1383i c1383i) {
        return this.f920a.m1370a(new C1374d(0, c1383i));
    }

    public final boolean m1350b(C1383i c1383i) {
        boolean a = this.f920a.m1370a(new C1374d(1, c1383i));
        if (a) {
            this.f922c = true;
        }
        return a;
    }

    public final void m1352c(C1383i c1383i) {
        this.f922c = false;
        this.f920a.m1370a(new C1374d(2, c1383i));
    }

    public final boolean m1354d(C1383i c1383i) {
        return this.f920a.m1368a(new C1370b(0, c1383i));
    }

    public final boolean m1355e(C1383i c1383i) {
        return this.f920a.m1368a(new C1370b(1, c1383i));
    }

    public final void m1356f(C1383i c1383i) {
        this.f920a.m1368a(new C1370b(2, c1383i));
    }

    public final boolean m1357g(C1383i c1383i) {
        return this.f920a.m1368a(new C1386n(0, c1383i));
    }

    public final boolean m1358h(C1383i c1383i) {
        return this.f920a.m1368a(new C1386n(1, c1383i));
    }

    public final void m1359i(C1383i c1383i) {
        this.f920a.m1368a(new C1386n(2, c1383i));
    }

    public final boolean onDown(MotionEvent motionEvent) {
        return this.f920a.onDown(motionEvent);
    }

    public final void onShowPress(MotionEvent motionEvent) {
        this.f920a.onShowPress(motionEvent);
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        return this.f920a.onSingleTapUp(motionEvent);
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return !this.f922c && this.f920a.onScroll(motionEvent, motionEvent2, f, f2);
    }

    public final void onLongPress(MotionEvent motionEvent) {
        this.f920a.onLongPress(motionEvent);
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return this.f920a.onFling(motionEvent, motionEvent2, f, f2);
    }

    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return this.f920a.onSingleTapConfirmed(motionEvent);
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        return this.f920a.onDoubleTap(motionEvent);
    }

    public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return this.f920a.onDoubleTapEvent(motionEvent);
    }
}
