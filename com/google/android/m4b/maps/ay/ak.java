package com.google.android.m4b.maps.ay;

import java.io.DataInput;
import java.io.IOException;
import java.util.Arrays;

public final class ak {
    private final int[] f1082a;
    private final int[] f1083b;

    private ak(int[] iArr, int[] iArr2) {
        this.f1082a = iArr;
        this.f1083b = iArr2;
    }

    public static ak m1568a(DataInput dataInput, ac acVar) {
        int a = am.m1577a(dataInput);
        if (a % 3 != 0) {
            throw new IOException("Malformed TriangleList, " + a + " vertices");
        }
        int[] iArr = new int[(a * 3)];
        for (int i = 0; i < a; i++) {
            C1440g.m1932a(dataInput, acVar, iArr, i);
        }
        return new ak(iArr, null);
    }

    public static ak m1569a(DataInput dataInput, ae aeVar) {
        int i = 0;
        int a = am.m1577a(dataInput);
        if (a % 3 != 0) {
            throw new IOException("Malformed TriangleList, " + a + " vertices");
        }
        int i2;
        int[] iArr = new int[(a * 3)];
        ac b = aeVar.m1461b();
        for (i2 = 0; i2 < a; i2++) {
            C1440g.m1937b(dataInput, b, iArr, i2);
        }
        i2 = am.m1577a(dataInput);
        int[] iArr2 = new int[i2];
        while (i < i2) {
            iArr2[i] = am.m1577a(dataInput);
            i++;
        }
        return new ak(iArr, iArr2);
    }

    public final int m1570a() {
        return this.f1082a.length / 9;
    }

    public final void m1571a(int i, C1440g c1440g, C1440g c1440g2, C1440g c1440g3) {
        int i2 = i * 9;
        int i3 = i2 + 1;
        c1440g.f1264a = this.f1082a[i2];
        int i4 = i3 + 1;
        c1440g.f1265b = this.f1082a[i3];
        i3 = i4 + 1;
        c1440g.f1266c = this.f1082a[i4];
        i4 = i3 + 1;
        c1440g2.f1264a = this.f1082a[i3];
        i3 = i4 + 1;
        c1440g2.f1265b = this.f1082a[i4];
        i4 = i3 + 1;
        c1440g2.f1266c = this.f1082a[i3];
        i3 = i4 + 1;
        c1440g3.f1264a = this.f1082a[i4];
        i4 = i3 + 1;
        c1440g3.f1265b = this.f1082a[i3];
        c1440g3.f1266c = this.f1082a[i4];
    }

    public final void m1572a(int i, C1440g c1440g, C1440g c1440g2, C1440g c1440g3, C1440g c1440g4) {
        int i2 = i * 9;
        int i3 = i2 + 1;
        c1440g2.f1264a = this.f1082a[i2] - c1440g.f1264a;
        int i4 = i3 + 1;
        c1440g2.f1265b = this.f1082a[i3] - c1440g.f1265b;
        i3 = i4 + 1;
        c1440g2.f1266c = this.f1082a[i4] - c1440g.f1266c;
        i4 = i3 + 1;
        c1440g3.f1264a = this.f1082a[i3] - c1440g.f1264a;
        i3 = i4 + 1;
        c1440g3.f1265b = this.f1082a[i4] - c1440g.f1265b;
        i4 = i3 + 1;
        c1440g3.f1266c = this.f1082a[i3] - c1440g.f1266c;
        i3 = i4 + 1;
        c1440g4.f1264a = this.f1082a[i4] - c1440g.f1264a;
        i4 = i3 + 1;
        c1440g4.f1265b = this.f1082a[i3] - c1440g.f1265b;
        c1440g4.f1266c = this.f1082a[i4] - c1440g.f1266c;
    }

    public final void m1573a(ay ayVar) {
        for (int i = 0; i < m1570a(); i++) {
            C1440g[] c1440gArr = new C1440g[]{new C1440g(), new C1440g(), new C1440g()};
            m1571a(i, c1440gArr[0], c1440gArr[1], c1440gArr[2]);
            ayVar.m1728a(new C1443j(c1440gArr));
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ak)) {
            return false;
        }
        ak akVar = (ak) obj;
        if (Arrays.equals(this.f1082a, akVar.f1082a) && Arrays.equals(this.f1083b, akVar.f1083b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f1082a) + Arrays.hashCode(this.f1083b);
    }

    public final int m1574b() {
        return (((this.f1083b == null ? 0 : this.f1083b.length) + this.f1082a.length) * 4) + 28;
    }
}
