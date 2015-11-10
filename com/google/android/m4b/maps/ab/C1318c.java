package com.google.android.m4b.maps.ab;

import com.google.android.m4b.maps.ay.C1440g;
import com.google.android.m4b.maps.ay.C1446k;
import com.google.android.m4b.maps.ay.ac;

/* renamed from: com.google.android.m4b.maps.ab.c */
public final class C1318c {
    public static final C1319d f773a;
    private static final C1316a[] f774b;
    private final int f775c;
    private final long f776d;
    private final C1319d[] f777e;
    private final C1446k f778f;
    private C1316a[] f779g;

    static {
        f773a = new C1319d("Unknown Road", null, false);
        f774b = new C1316a[0];
    }

    public C1318c(long j, C1319d[] c1319dArr, C1446k c1446k, int i, int i2, int i3, int i4) {
        if (c1319dArr.length == 0) {
            throw new IllegalArgumentException("Segments must have at least one name");
        }
        this.f775c = i;
        this.f776d = j;
        this.f777e = c1319dArr;
        this.f778f = c1446k;
        this.f779g = f774b;
    }

    public static long m1051a(ac acVar, int i) {
        return ((((long) acVar.m1450c()) << 48) | (((long) acVar.m1451d()) << 32)) | ((long) i);
    }

    public final void m1054a(C1316a... c1316aArr) {
        if (c1316aArr.length == 0) {
            this.f779g = f774b;
        } else {
            this.f779g = c1316aArr;
        }
    }

    private C1440g m1052a(int i) {
        C1440g c1440g = new C1440g();
        m1053a(i, c1440g);
        return c1440g;
    }

    public final void m1053a(int i, C1440g c1440g) {
        if ((this.f775c & 4) != 0) {
            i = (this.f778f.m2020b() - i) - 1;
        }
        this.f778f.m2016a(i, c1440g);
    }

    public final int hashCode() {
        return (int) (((((this.f776d >>> 48) & 255) << 24) | (((this.f776d >>> 32) & 255) << 16)) | (this.f776d & 65535));
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof C1318c) && this.f776d == ((C1318c) obj).f776d) {
            return true;
        }
        return false;
    }

    public final String toString() {
        boolean z;
        boolean z2 = true;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[name: ").append(this.f777e[0]);
        stringBuilder.append(" unroutable: ").append((this.f775c & 8) != 0);
        StringBuilder append = stringBuilder.append(" leaves-region: ");
        if ((this.f775c & 1) != 0) {
            z = true;
        } else {
            z = false;
        }
        append.append(z);
        StringBuilder append2 = stringBuilder.append(" enters-region: ");
        if ((this.f775c & 2) == 0) {
            z2 = false;
        }
        append2.append(z2);
        stringBuilder.append(" num-points: ").append(this.f778f.m2020b());
        stringBuilder.append(" first-point: ").append(m1052a(0).m1966j());
        stringBuilder.append(" last-point: ").append(m1052a(this.f778f.m2020b() - 1).m1966j());
        stringBuilder.append(" num-arcs: ").append(this.f779g.length);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
