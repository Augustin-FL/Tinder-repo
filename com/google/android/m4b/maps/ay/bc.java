package com.google.android.m4b.maps.ay;

import java.util.Arrays;

public final class bc extends C1420n {
    private C1440g[] f1172a;
    private C1448m f1173b;

    protected bc(C1440g[] c1440gArr) {
        this.f1172a = c1440gArr;
        this.f1173b = C1448m.m2042a(c1440gArr);
    }

    public static bc m1753a(C1440g c1440g, C1440g c1440g2, C1440g c1440g3, C1440g c1440g4) {
        return new bc(new C1440g[]{c1440g, c1440g2, c1440g4, c1440g3});
    }

    public final int m1757b() {
        return 4;
    }

    public final C1440g m1754a(int i) {
        return this.f1172a[i];
    }

    public final C1440g m1761h() {
        return this.f1172a[3];
    }

    public final C1448m m1755a() {
        return this.f1173b;
    }

    public final C1440g m1759c() {
        return this.f1172a[2];
    }

    public final C1440g m1760d() {
        return this.f1172a[3];
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f1172a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bc)) {
            return false;
        }
        return Arrays.equals(this.f1172a, ((bc) obj).f1172a);
    }

    public final boolean m1756a(C1440g c1440g) {
        int i;
        if (C1442i.m1994b(this.f1172a[0], this.f1172a[1], c1440g)) {
            i = 1;
        } else {
            i = 0;
        }
        if (C1442i.m1994b(this.f1172a[1], this.f1172a[2], c1440g)) {
            i++;
        }
        if (C1442i.m1994b(this.f1172a[2], this.f1172a[3], c1440g)) {
            i++;
        }
        if (C1442i.m1994b(this.f1172a[3], this.f1172a[0], c1440g)) {
            i++;
        }
        if (i == 1) {
            return true;
        }
        return false;
    }

    public final boolean m1758b(C1420n c1420n) {
        if (!this.f1173b.m2047a(c1420n.m1747a())) {
            return false;
        }
        for (int i = 0; i < c1420n.m1750b(); i++) {
            if (!m1756a(c1420n.m1746a(i))) {
                return false;
            }
        }
        return true;
    }

    public final String toString() {
        return "[" + this.f1172a[0] + "," + this.f1172a[1] + "," + this.f1172a[2] + "," + this.f1172a[3] + "]";
    }
}
