package com.google.android.m4b.maps.ay;

import java.util.Arrays;

/* renamed from: com.google.android.m4b.maps.ay.j */
public final class C1443j extends C1420n {
    private C1440g[] f1285a;
    private volatile C1448m f1286b;

    public C1443j(C1440g[] c1440gArr) {
        this.f1285a = c1440gArr;
    }

    public final int m2003b() {
        return this.f1285a.length;
    }

    public final C1440g m2000a(int i) {
        return this.f1285a[i];
    }

    public final C1448m m2001a() {
        if (this.f1286b == null) {
            this.f1286b = C1448m.m2042a(this.f1285a);
        }
        return this.f1286b;
    }

    public final boolean m2002a(C1440g c1440g) {
        if (!m2001a().m2046a(c1440g)) {
            return false;
        }
        int length = this.f1285a.length;
        int i = 0;
        C1440g c1440g2 = this.f1285a[length - 1];
        int i2 = 0;
        while (i < length) {
            C1440g c1440g3 = this.f1285a[i];
            if (C1442i.m1994b(c1440g2, c1440g3, c1440g)) {
                i2++;
            }
            i++;
            c1440g2 = c1440g3;
        }
        return (i2 & 1) == 1;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f1285a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1443j)) {
            return false;
        }
        return Arrays.equals(this.f1285a, ((C1443j) obj).f1285a);
    }
}
