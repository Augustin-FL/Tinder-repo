package com.google.android.m4b.maps.av;

import com.google.android.m4b.maps.av.C1376e.C1375a;
import com.google.android.m4b.maps.av.C1383i.C1377b;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* renamed from: com.google.android.m4b.maps.av.r */
public abstract class C1387r extends C1376e {
    protected float f985b;
    protected float f986c;
    private float f987d;
    private float f988e;

    protected abstract float m1398a(float f);

    protected abstract float m1399a(C1367h c1367h, int i);

    protected abstract float m1401b(C1367h c1367h, int i);

    public C1387r(C1377b c1377b) {
        super(c1377b);
        this.f987d = 0.7853982f;
        this.f988e = 0.25f;
        this.f985b = 0.125f;
        this.f986c = 1.0f;
    }

    public final boolean m1402b() {
        return true;
    }

    public final C1375a m1400a(long j, LinkedList<C1367h> linkedList, List<C1376e> list) {
        if (linkedList.size() < 3) {
            return C1375a.MAYBE;
        }
        C1367h c1367h = (C1367h) linkedList.getLast();
        if (c1367h.m1290b() != 2) {
            return C1375a.NO;
        }
        float abs;
        ListIterator listIterator = linkedList.listIterator(linkedList.size());
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        C1367h c1367h2 = c1367h;
        C1367h c1367h3 = null;
        while (listIterator.hasPrevious()) {
            C1367h c1367h4 = (C1367h) listIterator.previous();
            if (c1367h4.m1290b() != c1367h.m1290b()) {
                break;
            } else if (m1398a(c1367h4.m1294f()) >= this.f987d) {
                return C1375a.NO;
            } else {
                if (c1367h4.m1295g() / c1367h4.m1291c() < this.f988e) {
                    return C1375a.NO;
                }
                float abs2;
                if (c1367h3 != null) {
                    f2 += Math.abs(m1399a(c1367h4, 0) - m1399a(c1367h3, 0));
                    f += Math.abs(m1399a(c1367h4, c1367h4.m1290b() - 1) - m1399a(c1367h3, c1367h3.m1290b() - 1));
                    abs = Math.abs(m1401b(c1367h4, c1367h4.m1290b() - 1) - m1401b(c1367h3, c1367h3.m1290b() - 1)) + f3;
                    abs2 = f4 + Math.abs(m1401b(c1367h4, 0) - m1401b(c1367h3, 0));
                    f3 = f;
                    f4 = f2;
                } else {
                    abs = f3;
                    abs2 = f4;
                    f3 = f;
                    f4 = f2;
                }
                f = f3;
                f2 = f4;
                f3 = abs;
                f4 = abs2;
                c1367h2 = c1367h4;
                c1367h3 = c1367h4;
            }
        }
        if (f2 + f > (f4 + f3) * this.f986c) {
            return C1375a.NO;
        }
        float b = m1401b(c1367h, 0) - m1401b(c1367h2, 0);
        abs = m1401b(c1367h, c1367h.m1290b() - 1) - m1401b(c1367h2, c1367h2.m1290b() - 1);
        if (b * abs < 0.0f) {
            return C1375a.NO;
        }
        if (Math.min(Math.abs(b) / c1367h.m1292d(), Math.abs(abs) / c1367h.m1292d()) < this.f985b) {
            return C1375a.MAYBE;
        }
        return C1375a.YES;
    }
}
