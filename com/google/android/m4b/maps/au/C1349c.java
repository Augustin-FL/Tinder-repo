package com.google.android.m4b.maps.au;

import com.google.android.m4b.maps.au.C1357e.C1353a;
import java.util.Arrays;

/* renamed from: com.google.android.m4b.maps.au.c */
final class C1349c extends C1348j {
    private boolean[] f867d;

    C1349c(C1361g c1361g) {
        super(c1361g);
        this.f867d = new boolean[(m1177d() + 2)];
        Arrays.fill(this.f867d, false);
        this.f867d[0] = true;
    }

    public final boolean m1209a(int i, int i2) {
        int f = this.a.m1136f(i);
        int f2 = this.a.m1136f(i2);
        if (f == f2) {
            return false;
        }
        if (this.f867d[f] && this.f867d[f2]) {
            return false;
        }
        if (this.f867d[f]) {
            this.f867d[f2] = true;
            return true;
        } else if (this.f867d[f2]) {
            this.f867d[f] = true;
            return true;
        } else {
            throw new C1353a("Some outer chains have not been cut.");
        }
    }

    public final C1348j m1208a(int[] iArr) {
        if (m1177d() == 0) {
            return this;
        }
        double[] dArr = new double[((m1179e() + iArr.length) * 2)];
        int g = this.a.m1137g(1);
        this.a.m1130a(0, dArr, 0, g);
        Arrays.fill(this.f867d, false);
        this.f867d[0] = true;
        for (int i = 0; i < iArr.length; i += 2) {
            int f;
            int i2;
            int i3 = iArr[i];
            int i4 = iArr[i + 1];
            int f2 = this.a.m1136f(i4);
            if (this.f867d[f2]) {
                f = this.a.m1136f(i3);
                i2 = i3;
                f2 = i4;
            } else {
                f = f2;
                i2 = i4;
                f2 = i3;
            }
            int g2 = this.a.m1137g(f);
            int g3 = this.a.m1137g(f + 1);
            double a = this.a.m1126a(f2);
            double b = this.a.m1132b(f2);
            int a2 = C1349c.m1206a(dArr, 2, a, b, 0, g);
            if (C1349c.m1206a(dArr, 2, a, b, a2 + 1, g) != -1) {
                Object obj = null;
                int i5 = a2;
                while (obj == null) {
                    f2 = (i5 - 1) % g;
                    if (f2 < 0) {
                        f2 += g;
                    }
                    int i6 = (i5 + 1) % g;
                    if (i6 < 0) {
                        i6 += g;
                    }
                    boolean a3 = C1349c.m1207a(dArr[f2 * 2], dArr[(f2 * 2) + 1], dArr[i5 * 2], dArr[(i5 * 2) + 1], dArr[i6 * 2], dArr[(i6 * 2) + 1]);
                    boolean a4 = C1349c.m1207a(m1170b(i2), m1174c(i2), dArr[i5 * 2], dArr[(i5 * 2) + 1], dArr[i6 * 2], dArr[(i6 * 2) + 1]);
                    boolean a5 = C1349c.m1207a(dArr[f2 * 2], dArr[(f2 * 2) + 1], dArr[i5 * 2], dArr[(i5 * 2) + 1], m1170b(i2), m1174c(i2));
                    if (a3 ? a4 && a5 : a4 || a5) {
                        i5 = C1349c.m1206a(dArr, 2, a, b, i5 + 1, g);
                    } else {
                        obj = 1;
                    }
                }
                f2 = i5;
            } else {
                f2 = a2;
            }
            if (this.a.m1126a(i2) == a && this.a.m1132b(i2) == b) {
                System.arraycopy(dArr, (f2 + 1) * 2, dArr, ((f2 + g3) - g2) * 2, ((g - f2) - 1) * 2);
                f2++;
                i3 = (g3 - i2) - 1;
                this.a.m1130a(i2, dArr, f2, i3);
                this.a.m1130a(g2, dArr, f2 + i3, (i2 - g2) + 1);
                g += (g3 - g2) + 2;
                this.f867d[f] = true;
            } else {
                System.arraycopy(dArr, f2 * 2, dArr, (((f2 + g3) - g2) + 2) * 2, (g - f2) * 2);
                f2++;
                i3 = g3 - i2;
                this.a.m1130a(i2, dArr, f2, i3);
                this.a.m1130a(g2, dArr, f2 + i3, (i2 - g2) + 1);
                g += (g3 - g2) + 2;
                this.f867d[f] = true;
            }
        }
        super(dArr);
        return this;
    }

    private static int m1206a(double[] dArr, int i, double d, double d2, int i2, int i3) {
        int i4 = i2;
        while (i4 < i3) {
            if (dArr[i4 * 2] == d && dArr[(i4 * 2) + 1] == d2) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    private static boolean m1207a(double d, double d2, double d3, double d4, double d5, double d6) {
        return ((d - d3) * (d6 - d4)) - ((d2 - d4) * (d5 - d3)) > 0.0d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1349c)) {
            return false;
        }
        C1349c c1349c = (C1349c) obj;
        if ((this instanceof C1349c) && super.equals(c1349c) && !Arrays.equals(this.f867d, c1349c.f867d)) {
            return true;
        }
        return false;
    }

    public final boolean m1210a(Object obj) {
        return obj instanceof C1349c;
    }

    public final int hashCode() {
        return super.hashCode() + (Arrays.hashCode(this.f867d) * 31);
    }
}
