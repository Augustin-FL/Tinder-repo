package com.google.android.m4b.maps.ay;

import com.google.android.m4b.maps.ay.C1446k.C1445a;
import java.util.ArrayList;
import java.util.List;

public final class aw {
    private C1420n f1161a;
    private int f1162b;
    private C1440g[] f1163c;
    private boolean f1164d;
    private final ArrayList<C1445a> f1165e;
    private final ArrayList<C1418a> f1166f;
    private int f1167g;

    /* renamed from: com.google.android.m4b.maps.ay.aw.a */
    static class C1418a {
        private int[] f1159a;
        private int f1160b;

        C1418a() {
            this(16);
        }

        private C1418a(int i) {
            this.f1159a = new int[16];
            this.f1160b = 0;
        }

        final void m1717a(int i) {
            if (this.f1160b == this.f1159a.length) {
                Object obj = new int[(this.f1159a.length * 2)];
                System.arraycopy(this.f1159a, 0, obj, 0, this.f1159a.length);
                this.f1159a = obj;
            }
            int[] iArr = this.f1159a;
            int i2 = this.f1160b;
            this.f1160b = i2 + 1;
            iArr[i2] = i;
        }

        final int[] m1718a() {
            Object obj = new int[this.f1160b];
            System.arraycopy(this.f1159a, 0, obj, 0, this.f1160b);
            return obj;
        }

        final void m1719b() {
            this.f1160b = 0;
        }

        final int m1720c() {
            return this.f1160b;
        }
    }

    public aw(C1420n c1420n) {
        this.f1165e = new ArrayList();
        this.f1166f = new ArrayList();
        m1722a(c1420n);
    }

    private void m1722a(C1420n c1420n) {
        this.f1161a = c1420n;
        this.f1162b = c1420n.m1750b();
        this.f1163c = new C1440g[this.f1162b];
        for (int i = 0; i < this.f1163c.length; i++) {
            this.f1163c[i] = new C1440g();
        }
    }

    public final void m1723a(C1446k c1446k, List<C1446k> list) {
        List list2 = null;
        int i = 0;
        this.f1167g = 0;
        this.f1164d = false;
        C1420n a = c1446k.m2015a();
        if (!this.f1161a.m1749a(a)) {
            return;
        }
        if (this.f1161a.m1751b(a)) {
            list.add(c1446k);
            if (this.f1164d) {
                list2.add(list2);
                return;
            }
            return;
        }
        C1440g c1440g = new C1440g();
        int b = c1446k.m2020b();
        c1446k.m2016a(0, c1440g);
        m1721a(0, c1440g, this.f1164d ? list2[0] : 0, true);
        int i2 = 1;
        while (i2 < b) {
            c1446k.m2016a(i2, c1440g);
            m1721a(0, c1440g, this.f1164d ? list2[i2] : 0, false);
            i2++;
        }
        while (i < this.f1167g) {
            C1445a c1445a = (C1445a) this.f1165e.get(i);
            if (c1445a.m2004a() > 1) {
                list.add(c1445a.m2008c());
            }
            c1445a.m2007b();
            if (this.f1164d) {
                C1418a c1418a = (C1418a) this.f1166f.get(i);
                if (c1418a.m1720c() > 1) {
                    list2.add(c1418a.m1718a());
                }
                c1418a.m1719b();
            }
            i++;
        }
    }

    private void m1721a(int i, C1440g c1440g, int i2, boolean z) {
        if (i == this.f1162b) {
            if (z) {
                if (this.f1167g == this.f1165e.size()) {
                    this.f1165e.add(new C1445a());
                    this.f1166f.add(new C1418a());
                }
                this.f1167g++;
            }
            if (((C1445a) this.f1165e.get(this.f1167g - 1)).m2006a(c1440g) && this.f1164d) {
                ((C1418a) this.f1166f.get(this.f1167g - 1)).m1717a(i2);
                return;
            }
            return;
        }
        C1440g h;
        C1440g a;
        if (i == 0) {
            h = this.f1161a.m1752h();
            a = this.f1161a.m1746a(0);
        } else {
            h = this.f1161a.m1746a(i - 1);
            a = this.f1161a.m1746a(i);
        }
        C1440g c1440g2;
        if (C1442i.m1988a(h, a, c1440g) >= 0) {
            if (!z && C1442i.m1988a(h, a, this.f1163c[i]) < 0) {
                c1440g2 = new C1440g();
                C1442i.m1992a(h, a, c1440g, this.f1163c[i], c1440g2);
                m1721a(i + 1, c1440g2, i2, true);
            }
            m1721a(i + 1, c1440g, i2, z);
        } else if (!z && C1442i.m1988a(h, a, this.f1163c[i]) >= 0) {
            c1440g2 = new C1440g();
            C1442i.m1992a(h, a, this.f1163c[i], c1440g, c1440g2);
            m1721a(i + 1, c1440g2, i2, false);
        }
        this.f1163c[i].m1950b(c1440g);
    }
}
