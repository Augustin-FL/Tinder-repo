package com.google.android.m4b.maps.ay;

import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public final class ar extends as {
    private C1448m f1123b;
    private C1440g f1124c;
    private C1440g f1125d;
    private int f1126e;
    private int f1127f;
    private int f1128g;
    private volatile C1440g f1129h;
    private volatile C1440g f1130i;
    private volatile C1440g f1131j;
    private volatile C1440g f1132k;
    private volatile C1440g f1133l;
    private volatile C1440g f1134m;

    public final /* bridge */ /* synthetic */ C1420n m1679c() {
        return this.f1123b;
    }

    private ar(C1448m c1448m) {
        this.f1123b = c1448m;
        C1440g c = c1448m.m2050c();
        C1440g d = c1448m.m2051d();
        if (c.f1264a < 0) {
            this.f1126e = -c.f1264a;
        } else if (d.f1264a > 1073741824) {
            this.f1126e = 1073741824 - d.f1264a;
        }
        this.f1124c = new C1440g();
        c.m1965i(this.f1124c);
        this.f1125d = new C1440g();
        d.m1965i(this.f1125d);
        this.a = this.f1124c.f1264a > this.f1125d.f1264a;
        this.f1127f = c.f1264a + this.f1126e;
        this.f1128g = d.f1264a + this.f1126e;
    }

    public static ar m1671a(C1448m c1448m) {
        return new ar(c1448m);
    }

    public final C1448m m1677b() {
        return this.f1123b;
    }

    public final int m1680d() {
        return this.f1123b.m2053f();
    }

    public final int m1681e() {
        return this.f1125d.f1265b - this.f1124c.f1265b;
    }

    public final C1440g m1682f() {
        return this.f1124c;
    }

    public final C1440g m1683g() {
        return this.f1125d;
    }

    public final boolean m1675a(C1440g c1440g) {
        int i = (c1440g.f1264a + this.f1126e) & 1073741823;
        return i >= this.f1127f && i <= this.f1128g && c1440g.f1265b >= this.f1124c.f1265b && c1440g.f1265b <= this.f1125d.f1265b;
    }

    public final ar m1672a() {
        return this;
    }

    public final boolean m1676a(C1420n c1420n) {
        if (!this.a) {
            return this.f1123b.m2049b(c1420n);
        }
        C1448m a = c1420n.m1747a();
        if (this.f1124c.f1265b > a.f1297a.f1265b || this.f1125d.f1265b < a.f1298b.f1265b) {
            return false;
        }
        int i = a.f1297a.f1264a;
        int i2 = a.f1298b.f1264a;
        if ((this.f1124c.f1264a <= i && 536870912 > i2) || (-536870912 <= i && this.f1125d.f1264a >= i2)) {
            return true;
        }
        if (i < -536870912) {
            i += 1073741824;
        } else if (i >= 536870912) {
            i -= 1073741824;
        }
        if (i2 < -536870912) {
            i2 += 1073741824;
        } else if (i2 >= 536870912) {
            i2 -= 1073741824;
        }
        if (this.f1124c.f1264a > i || this.f1125d.f1264a < r0) {
            return false;
        }
        return true;
    }

    public final boolean m1678b(C1420n c1420n) {
        if (!this.a) {
            return this.f1123b.m2047a(c1420n);
        }
        if (!(c1420n instanceof C1448m)) {
            return super.m1653b(c1420n);
        }
        C1448m c1448m = (C1448m) c1420n;
        if (this.f1124c.f1265b > c1448m.f1298b.f1265b || this.f1125d.f1265b < c1448m.f1297a.f1265b) {
            return false;
        }
        if ((this.f1124c.f1264a > c1448m.f1298b.f1264a || 536870912 <= c1448m.f1297a.f1264a) && (-536870912 > c1448m.f1298b.f1264a || this.f1125d.f1264a < c1448m.f1297a.f1264a)) {
            return false;
        }
        return true;
    }

    public final C1440g m1673a(int i) {
        switch (i) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                if (this.f1129h == null) {
                    this.f1129h = new C1440g(this.f1125d.f1264a, this.f1124c.f1265b);
                }
                return this.f1129h;
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                return this.f1125d;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                if (this.f1130i == null) {
                    this.f1130i = new C1440g(this.f1124c.f1264a, this.f1125d.f1265b);
                }
                return this.f1130i;
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                return this.f1124c;
            default:
                throw new ArrayIndexOutOfBoundsException();
        }
    }

    public final int m1684h() {
        return this.a ? 6 : 4;
    }

    public final void m1674a(int i, C1440g[] c1440gArr) {
        if (this.a) {
            switch (i) {
                case C3374b.SmoothProgressBar_spbStyle /*0*/:
                    c1440gArr[0] = m1673a(0);
                    c1440gArr[1] = m1673a(1);
                    return;
                case C3374b.SmoothProgressBar_spb_color /*1*/:
                    c1440gArr[0] = m1673a(1);
                    if (this.f1131j == null) {
                        this.f1131j = new C1440g(-536870913, this.f1125d.f1265b);
                    }
                    c1440gArr[1] = this.f1131j;
                    return;
                case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                    if (this.f1132k == null) {
                        this.f1132k = new C1440g(536870912, this.f1125d.f1265b);
                    }
                    c1440gArr[0] = this.f1132k;
                    c1440gArr[1] = m1673a(2);
                    return;
                case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                    c1440gArr[0] = m1673a(2);
                    c1440gArr[1] = m1673a(3);
                    return;
                case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                    c1440gArr[0] = m1673a(3);
                    if (this.f1133l == null) {
                        this.f1133l = new C1440g(536870912, this.f1124c.f1265b);
                    }
                    c1440gArr[1] = this.f1133l;
                    return;
                case C3374b.SmoothProgressBar_spb_speed /*5*/:
                    if (this.f1134m == null) {
                        this.f1134m = new C1440g(-536870913, this.f1124c.f1265b);
                    }
                    c1440gArr[0] = this.f1134m;
                    c1440gArr[1] = m1673a(0);
                    return;
                default:
                    return;
            }
        }
        c1440gArr[0] = m1673a(i);
        c1440gArr[1] = m1673a((i + 1) % 4);
    }
}
