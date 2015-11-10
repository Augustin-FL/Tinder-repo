package com.google.android.m4b.maps.ay;

import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.google.android.m4b.maps.ay.m */
public final class C1448m extends C1420n {
    protected C1440g f1297a;
    protected C1440g f1298b;
    private volatile C1440g f1299c;
    private volatile C1440g f1300d;

    public C1448m(C1440g c1440g, C1440g c1440g2) {
        this.f1297a = c1440g;
        this.f1298b = c1440g2;
    }

    public static C1448m m2042a(C1440g[] c1440gArr) {
        C1440g c1440g = c1440gArr[0];
        int i = c1440g.f1264a;
        int i2 = c1440g.f1265b;
        int i3 = i;
        int i4 = i;
        i = i2;
        for (int i5 = 1; i5 < c1440gArr.length; i5++) {
            C1440g c1440g2 = c1440gArr[i5];
            if (c1440g2.f1264a < i4) {
                i4 = c1440g2.f1264a;
            }
            if (c1440g2.f1264a > i3) {
                i3 = c1440g2.f1264a;
            }
            if (c1440g2.f1265b < i) {
                i = c1440g2.f1265b;
            }
            if (c1440g2.f1265b > i2) {
                i2 = c1440g2.f1265b;
            }
        }
        return new C1448m(new C1440g(i4, i), new C1440g(i3, i2));
    }

    public static C1448m m2041a(C1440g c1440g, C1440g c1440g2) {
        int i;
        int i2;
        int i3;
        int i4;
        if (c1440g.f1264a < c1440g2.f1264a) {
            i = c1440g.f1264a;
            i2 = c1440g2.f1264a;
        } else {
            i = c1440g2.f1264a;
            i2 = c1440g.f1264a;
        }
        if (c1440g.f1265b < c1440g2.f1265b) {
            i3 = c1440g.f1265b;
            i4 = c1440g2.f1265b;
        } else {
            i3 = c1440g2.f1265b;
            i4 = c1440g.f1265b;
        }
        return new C1448m(new C1440g(i, i3), new C1440g(i2, i4));
    }

    public static C1448m m2040a(C1440g c1440g, int i) {
        return new C1448m(new C1440g(c1440g.f1264a - i, c1440g.f1265b - i), new C1440g(c1440g.f1264a + i, c1440g.f1265b + i));
    }

    public final C1440g m2050c() {
        return this.f1297a;
    }

    public final C1440g m2051d() {
        return this.f1298b;
    }

    public final C1440g m2052e() {
        return new C1440g((this.f1297a.f1264a + this.f1298b.f1264a) / 2, (this.f1297a.f1265b + this.f1298b.f1265b) / 2);
    }

    public final int m2053f() {
        return this.f1298b.f1264a - this.f1297a.f1264a;
    }

    public final int m2054g() {
        return this.f1298b.f1265b - this.f1297a.f1265b;
    }

    public final boolean m2046a(C1440g c1440g) {
        return c1440g.f1264a >= this.f1297a.f1264a && c1440g.f1264a <= this.f1298b.f1264a && c1440g.f1265b >= this.f1297a.f1265b && c1440g.f1265b <= this.f1298b.f1265b;
    }

    public final C1448m m2044a() {
        return this;
    }

    public final boolean m2049b(C1420n c1420n) {
        C1448m a = c1420n.m1747a();
        return this.f1297a.f1264a <= a.f1297a.f1264a && this.f1297a.f1265b <= a.f1297a.f1265b && this.f1298b.f1264a >= a.f1298b.f1264a && this.f1298b.f1265b >= a.f1298b.f1265b;
    }

    public final boolean m2047a(C1420n c1420n) {
        if (!(c1420n instanceof C1448m)) {
            return super.m1749a(c1420n);
        }
        C1448m c1448m = (C1448m) c1420n;
        return this.f1297a.f1264a <= c1448m.f1298b.f1264a && this.f1297a.f1265b <= c1448m.f1298b.f1265b && this.f1298b.f1264a >= c1448m.f1297a.f1264a && this.f1298b.f1265b >= c1448m.f1297a.f1265b;
    }

    public final int m2048b() {
        return 4;
    }

    public final C1440g m2043a(int i) {
        switch (i) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                if (this.f1299c == null) {
                    this.f1299c = new C1440g(this.f1298b.f1264a, this.f1297a.f1265b);
                }
                return this.f1299c;
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                return this.f1298b;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                if (this.f1300d == null) {
                    this.f1300d = new C1440g(this.f1297a.f1264a, this.f1298b.f1265b);
                }
                return this.f1300d;
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                return this.f1297a;
            default:
                throw new ArrayIndexOutOfBoundsException();
        }
    }

    public final C1440g m2055h() {
        return this.f1297a;
    }

    final void m2045a(C1448m c1448m) {
        this.f1297a.f1264a = Math.min(this.f1297a.f1264a, c1448m.f1297a.f1264a);
        this.f1297a.f1265b = Math.min(this.f1297a.f1265b, c1448m.f1297a.f1265b);
        this.f1298b.f1264a = Math.max(this.f1298b.f1264a, c1448m.f1298b.f1264a);
        this.f1298b.f1265b = Math.max(this.f1298b.f1265b, c1448m.f1298b.f1265b);
        this.f1299c = null;
        this.f1300d = null;
    }

    public final int hashCode() {
        return ((this.f1298b.hashCode() + 31) * 31) + this.f1297a.hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1448m)) {
            return false;
        }
        C1448m c1448m = (C1448m) obj;
        if (c1448m.f1298b.equals(this.f1298b) && c1448m.f1297a.equals(this.f1297a)) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return "[" + this.f1297a + ", " + this.f1298b + "]";
    }
}
