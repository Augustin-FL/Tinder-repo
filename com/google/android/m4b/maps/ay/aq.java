package com.google.android.m4b.maps.ay;

import java.lang.reflect.Array;
import java.util.Arrays;

public final class aq extends as {
    private final C1440g[] f1117b;
    private final C1440g[] f1118c;
    private final bc f1119d;
    private final ar f1120e;
    private final C1448m f1121f;
    private C1440g[][] f1122g;

    private aq(C1440g[] c1440gArr) {
        int i;
        this.f1118c = new C1440g[4];
        for (i = 0; i < 4; i++) {
            this.f1118c[i] = new C1440g();
            c1440gArr[i].m1965i(this.f1118c[i]);
        }
        this.f1117b = c1440gArr;
        this.f1119d = new bc(c1440gArr);
        this.f1121f = this.f1119d.m1755a();
        this.f1120e = ar.m1671a(this.f1121f);
        this.a = this.f1120e.a;
        if (this.a) {
            this.f1122g = (C1440g[][]) Array.newInstance(C1440g.class, new int[]{6, 2});
            int i2 = 0;
            i = 0;
            int i3 = 0;
            while (i2 < 4) {
                int i4 = !this.f1118c[i2].equals(this.f1117b[i2]) ? 1 : 0;
                if (i4 == i3) {
                    i4 = i3;
                } else if (i2 > 0 && i < 5) {
                    m1658a(this.f1117b[i2 - 1], this.f1117b[i2], i);
                    i++;
                }
                if (i2 > 0) {
                    this.f1122g[i - 1][1] = this.f1118c[i2];
                }
                this.f1122g[i][0] = this.f1118c[i2];
                i2++;
                i++;
                i3 = i4;
            }
            if (i < 6) {
                m1658a(this.f1117b[3], this.f1117b[0], i);
            }
            this.f1122g[5][1] = this.f1118c[0];
        }
    }

    private void m1658a(C1440g c1440g, C1440g c1440g2, int i) {
        int i2 = (int) (((((double) ((c1440g2.f1264a > 0 ? 536870913 : -536870913) - c1440g.f1264a)) / ((double) (c1440g2.f1264a - c1440g.f1264a))) * ((double) (c1440g2.f1265b - c1440g.f1265b))) + ((double) c1440g.f1265b));
        if (c1440g.f1264a > c1440g2.f1264a) {
            this.f1122g[i - 1][1] = new C1440g(-536870913, i2);
            this.f1122g[i][0] = new C1440g(536870913, i2);
            return;
        }
        this.f1122g[i - 1][1] = new C1440g(536870913, i2);
        this.f1122g[i][0] = new C1440g(-536870913, i2);
    }

    public static aq m1657a(C1440g c1440g, C1440g c1440g2, C1440g c1440g3, C1440g c1440g4) {
        return new aq(new C1440g[]{c1440g, c1440g2, c1440g4, c1440g3});
    }

    public static aq m1656a(aq aqVar, C1440g c1440g, float f) {
        return m1657a(C1440g.m1926a(aqVar.f1118c[0], c1440g, 0.2f), C1440g.m1926a(aqVar.f1118c[1], c1440g, 0.2f), C1440g.m1926a(aqVar.f1118c[3], c1440g, 0.2f), C1440g.m1926a(aqVar.f1118c[2], c1440g, 0.2f));
    }

    public final ar m1659a() {
        return this.f1120e;
    }

    public final C1448m m1664b() {
        return this.f1121f;
    }

    public final C1420n m1665c() {
        return this.f1119d;
    }

    public final C1440g m1666d() {
        return this.f1118c[0];
    }

    public final C1440g m1667e() {
        return this.f1118c[1];
    }

    public final C1440g m1668f() {
        return this.f1118c[2];
    }

    public final C1440g m1669g() {
        return this.f1118c[3];
    }

    public final C1440g m1660a(int i) {
        return this.f1118c[i];
    }

    public final int m1670h() {
        return this.a ? 6 : 4;
    }

    public final void m1661a(int i, C1440g[] c1440gArr) {
        if (this.a) {
            c1440gArr[0] = this.f1122g[i][0];
            c1440gArr[1] = this.f1122g[i][1];
            return;
        }
        c1440gArr[0] = this.f1118c[i];
        c1440gArr[1] = this.f1118c[(i + 1) % 4];
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f1117b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof aq)) {
            return false;
        }
        return Arrays.equals(this.f1117b, ((aq) obj).f1117b);
    }

    public final boolean m1662a(C1440g c1440g) {
        if (!this.a) {
            return this.f1119d.m1756a(c1440g);
        }
        int i = 0;
        for (int i2 = 0; i2 < 6; i2++) {
            if (C1442i.m1994b(this.f1122g[i2][0], this.f1122g[i2][1], c1440g)) {
                i++;
            }
        }
        return i == 1;
    }

    public final boolean m1663a(C1420n c1420n) {
        if (!this.f1120e.m1678b(c1420n.m1747a())) {
            return false;
        }
        for (int i = 0; i < c1420n.m1750b(); i++) {
            if (!m1662a(c1420n.m1746a(i))) {
                return false;
            }
        }
        return true;
    }

    public final String toString() {
        return "[" + this.f1117b[0] + "," + this.f1117b[1] + "," + this.f1117b[2] + "," + this.f1117b[3] + "]";
    }
}
