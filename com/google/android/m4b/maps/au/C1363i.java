package com.google.android.m4b.maps.au;

import com.google.android.m4b.maps.ay.C1440g;

/* renamed from: com.google.android.m4b.maps.au.i */
public final class C1363i {
    private final double f898a;
    private final double f899b;

    private C1363i(double d, double d2, boolean z) {
        this.f898a = d;
        this.f899b = d2;
    }

    public static C1363i m1258a() {
        return new C1363i(3.141592653589793d, -3.141592653589793d, true);
    }

    private static C1363i m1261e() {
        return new C1363i(-3.141592653589793d, 3.141592653589793d, true);
    }

    public static C1363i m1259a(double d, double d2) {
        double d3;
        double d4;
        if (d == -3.141592653589793d) {
            d3 = 3.141592653589793d;
        } else {
            d3 = d;
        }
        if (d2 == -3.141592653589793d) {
            d4 = 3.141592653589793d;
        } else {
            d4 = d2;
        }
        if (C1363i.m1260b(d3, d4) <= 3.141592653589793d) {
            return new C1363i(d3, d4, true);
        }
        return new C1363i(d4, d3, true);
    }

    public final boolean m1266b() {
        return this.f899b - this.f898a == 6.283185307179586d;
    }

    private boolean m1262f() {
        return this.f898a - this.f899b == 6.283185307179586d;
    }

    private boolean m1263g() {
        return this.f898a > this.f899b;
    }

    public final double m1267c() {
        double d = 0.5d * (this.f898a + this.f899b);
        if (m1263g()) {
            return d <= 0.0d ? d + 3.141592653589793d : d - 3.141592653589793d;
        } else {
            return d;
        }
    }

    public final C1363i m1268d() {
        if (this.f898a == this.f899b) {
            return C1363i.m1261e();
        }
        return new C1363i(this.f899b, this.f898a, true);
    }

    public final boolean m1265a(double d) {
        if (m1263g()) {
            if ((d >= this.f898a || d <= this.f899b) && !m1262f()) {
                return true;
            }
            return false;
        } else if (d < this.f898a || d > this.f899b) {
            return false;
        } else {
            return true;
        }
    }

    public final C1363i m1264a(C1363i c1363i) {
        boolean z = true;
        if (c1363i.m1262f()) {
            return this;
        }
        if (m1265a(c1363i.f898a)) {
            if (!m1265a(c1363i.f899b)) {
                return new C1363i(this.f898a, c1363i.f899b, true);
            }
            if (m1263g()) {
                if (c1363i.m1263g()) {
                    if (c1363i.f898a < this.f898a || c1363i.f899b > this.f899b) {
                        z = false;
                    }
                } else if ((c1363i.f898a < this.f898a && c1363i.f899b > this.f899b) || m1262f()) {
                    z = false;
                }
            } else if (c1363i.m1263g()) {
                if (!(m1266b() || c1363i.m1262f())) {
                    z = false;
                }
            } else if (c1363i.f898a < this.f898a || c1363i.f899b > this.f899b) {
                z = false;
            }
            if (z) {
                return this;
            }
            return C1363i.m1261e();
        } else if (m1265a(c1363i.f899b)) {
            return new C1363i(c1363i.f898a, this.f899b, true);
        } else {
            if (m1262f() || c1363i.m1265a(this.f898a)) {
                return c1363i;
            }
            if (C1363i.m1260b(c1363i.f899b, this.f898a) < C1363i.m1260b(this.f899b, c1363i.f898a)) {
                return new C1363i(c1363i.f898a, this.f899b, true);
            }
            return new C1363i(this.f898a, c1363i.f899b, true);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C1363i)) {
            return false;
        }
        C1363i c1363i = (C1363i) obj;
        if (this.f898a == c1363i.f898a && this.f899b == c1363i.f899b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        long doubleToLongBits = ((629 + Double.doubleToLongBits(this.f898a)) * 37) + Double.doubleToLongBits(this.f899b);
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }

    public final String toString() {
        return "[" + this.f898a + ", " + this.f899b + "]";
    }

    private static double m1260b(double d, double d2) {
        double d3 = d2 - d;
        return d3 >= 0.0d ? d3 : (d2 + 3.141592653589793d) - (d - 3.141592653589793d);
    }

    public static double m1257a(int i) {
        return (((double) C1440g.m1933b(i)) / 5.36870912E8d) * 3.141592653589793d;
    }
}
