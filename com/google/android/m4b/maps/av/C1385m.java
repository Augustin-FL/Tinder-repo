package com.google.android.m4b.maps.av;

import com.google.android.m4b.maps.av.C1376e.C1375a;
import com.google.android.m4b.maps.av.C1383i.C1377b;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* renamed from: com.google.android.m4b.maps.av.m */
public final class C1385m extends C1376e {
    public C1385m(C1377b c1377b) {
        super(c1377b);
    }

    public final boolean m1391c() {
        return true;
    }

    public final C1375a m1389a(long j, LinkedList<C1367h> linkedList, List<C1376e> list) {
        if (linkedList.size() < 3) {
            return C1375a.MAYBE;
        }
        float f;
        C1367h c1367h = (C1367h) linkedList.getLast();
        float f2 = c1367h.m1294f();
        ListIterator listIterator = linkedList.listIterator(linkedList.size());
        C1367h c1367h2 = c1367h;
        while (listIterator.hasPrevious()) {
            C1367h c1367h3 = (C1367h) listIterator.previous();
            if (c1367h3.m1290b() != c1367h.m1290b()) {
                break;
            } else if (Math.abs(C1376e.m1321a(f2, c1367h3.m1294f())) > 0.17453292f) {
                return C1375a.NO;
            } else {
                c1367h2 = c1367h3;
            }
        }
        if (list.isEmpty()) {
            f = 0.1f;
        } else {
            f = 0.2f;
        }
        float g = c1367h2.m1295g();
        f2 = c1367h.m1295g();
        if (Math.abs(g - f2) / ((c1367h.m1292d() + c1367h.m1291c()) * 0.5f) < f) {
            return C1375a.MAYBE;
        }
        return C1375a.YES;
    }

    protected final boolean m1390b(C1383i c1383i) {
        return this.a.m1337b(c1383i, false);
    }

    protected final void m1392d(C1383i c1383i) {
        this.a.m1339c(c1383i, false);
    }

    protected final boolean m1393f(C1383i c1383i) {
        return this.a.m1335a(c1383i, false);
    }
}
