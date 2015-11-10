package com.google.android.m4b.maps.av;

import com.google.android.m4b.maps.av.C1383i.C1377b;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.google.android.m4b.maps.av.e */
public abstract class C1376e {
    protected final C1377b f918a;
    private boolean f919b;

    /* renamed from: com.google.android.m4b.maps.av.e.a */
    public enum C1375a {
        NO,
        MAYBE,
        YES
    }

    protected abstract C1375a m1322a(long j, LinkedList<C1367h> linkedList, List<C1376e> list);

    protected abstract boolean m1327b(C1383i c1383i);

    protected abstract void m1330d(C1383i c1383i);

    protected abstract boolean m1333f(C1383i c1383i);

    public C1376e(C1377b c1377b) {
        this.f918a = c1377b;
    }

    public final boolean m1324a() {
        return this.f919b;
    }

    public boolean m1326b() {
        return false;
    }

    public boolean m1329c() {
        return false;
    }

    public boolean m1331d() {
        return false;
    }

    public final C1375a m1323a(long j, LinkedList<C1367h> linkedList, boolean z, List<C1376e> list, StringBuilder stringBuilder) {
        if (m1326b() && !list.isEmpty()) {
            return C1375a.NO;
        }
        for (C1376e b : list) {
            if (b.m1326b()) {
                return C1375a.NO;
            }
        }
        if (z != m1331d()) {
            return C1375a.NO;
        }
        return m1322a(j, linkedList, list);
    }

    public final boolean m1325a(C1383i c1383i) {
        if (this.f919b) {
            throw new IllegalStateException("Gesture already active: " + getClass().getName());
        }
        this.f919b = m1327b(c1383i);
        return this.f919b;
    }

    public final void m1328c(C1383i c1383i) {
        if (this.f919b) {
            this.f919b = false;
            m1330d(c1383i);
            return;
        }
        throw new IllegalStateException("Gesture already inactive: " + getClass().getName());
    }

    public final boolean m1332e(C1383i c1383i) {
        if (this.f919b) {
            return m1333f(c1383i);
        }
        throw new IllegalStateException("Gesture is not active: " + getClass().getName());
    }

    protected static float m1321a(float f, float f2) {
        if (f2 >= f) {
            return Math.min(f2 - f, (float) ((6.283185307179586d + ((double) f)) - ((double) f2)));
        }
        return -C1376e.m1321a(f2, f);
    }
}
