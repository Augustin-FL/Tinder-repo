package com.google.android.m4b.maps.av;

import com.google.android.m4b.maps.ag.r;
import com.google.android.m4b.maps.av.C1376e.C1375a;
import com.google.android.m4b.maps.av.C1383i.C1377b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.google.android.m4b.maps.av.k */
public final class C1384k extends C1376e {
    public C1384k(C1377b c1377b) {
        super(c1377b);
    }

    public final C1375a m1385a(long j, LinkedList<C1367h> linkedList, List<C1376e> list) {
        for (C1376e c : list) {
            if (c.m1329c()) {
                return C1375a.NO;
            }
        }
        if (linkedList.size() < 3) {
            return C1375a.MAYBE;
        }
        C1367h c1367h;
        C1367h c1367h2 = null;
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            c1367h = (C1367h) it.next();
            if (c1367h.m1290b() > 1) {
                c1367h2 = c1367h;
                break;
            }
        }
        c1367h = (C1367h) linkedList.getLast();
        if (c1367h2 == null) {
            return C1375a.NO;
        }
        if (c1367h.m1290b() <= 1) {
            return C1375a.NO;
        }
        float f = list.isEmpty() ? 0.08726646f : 0.17453292f;
        float abs = Math.abs(C1376e.m1321a(c1367h2.m1294f(), c1367h.m1294f()));
        if (abs < f) {
            return C1375a.NO;
        }
        f = (c1367h.m1291c() + c1367h.m1292d()) * 0.5f;
        float g = c1367h.m1295g() / f;
        if (g < 0.75f) {
            return C1375a.NO;
        }
        g = Math.abs(g - (c1367h2.m1295g() / f));
        if (g != 0.0f) {
            g = abs / g;
            if (g < 0.5f) {
                return C1375a.NO;
            }
            if (g < 0.9f) {
                return C1375a.MAYBE;
            }
        }
        return C1375a.YES;
    }

    protected final boolean m1386b(C1383i c1383i) {
        r.a(99, "r");
        return this.a.m1341e(c1383i);
    }

    protected final void m1387d(C1383i c1383i) {
        this.a.m1342f(c1383i);
    }

    protected final boolean m1388f(C1383i c1383i) {
        return this.a.m1340d(c1383i);
    }
}
