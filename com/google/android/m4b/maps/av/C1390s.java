package com.google.android.m4b.maps.av;

import com.google.android.m4b.maps.av.C1376e.C1375a;
import com.google.android.m4b.maps.av.C1383i.C1377b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* renamed from: com.google.android.m4b.maps.av.s */
public final class C1390s extends C1376e {
    public C1390s(C1377b c1377b) {
        super(c1377b);
    }

    public final boolean m1416b() {
        return true;
    }

    public final boolean m1418c() {
        return true;
    }

    public final boolean m1420d() {
        return true;
    }

    public final C1375a m1415a(long j, LinkedList<C1367h> linkedList, List<C1376e> list) {
        C1367h c1367h;
        C1367h c1367h2;
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            c1367h = (C1367h) it.next();
            if (c1367h.m1290b() == 2) {
                c1367h2 = c1367h;
                break;
            }
        }
        c1367h2 = null;
        ListIterator listIterator = linkedList.listIterator(linkedList.size());
        while (listIterator.hasPrevious()) {
            c1367h = (C1367h) listIterator.previous();
            if (c1367h.m1290b() == 2) {
                break;
            }
        }
        c1367h = null;
        if (c1367h2 == null || c1367h == null) {
            return C1375a.NO;
        }
        if (c1367h.m1288a() - j > 300) {
            return C1375a.NO;
        }
        if (Math.max(Math.max(Math.abs(c1367h.m1287a(0) - c1367h2.m1287a(0)) / c1367h.m1291c(), Math.abs(c1367h.m1289b(0) - c1367h2.m1289b(0)) / c1367h.m1292d()), Math.max(Math.abs(c1367h.m1287a(1) - c1367h2.m1287a(1)) / c1367h.m1291c(), Math.abs(c1367h.m1289b(1) - c1367h2.m1289b(1)) / c1367h.m1292d())) > 0.125f) {
            return C1375a.NO;
        }
        return C1375a.YES;
    }

    protected final boolean m1417b(C1383i c1383i) {
        return this.a.m1337b(c1383i, true);
    }

    protected final void m1419d(C1383i c1383i) {
        this.a.m1339c(c1383i, true);
    }

    protected final boolean m1421f(C1383i c1383i) {
        return this.a.m1335a(c1383i, true);
    }
}
