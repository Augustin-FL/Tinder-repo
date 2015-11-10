package com.google.android.m4b.maps.ay;

import com.google.android.m4b.maps.p009m.C1480a;

/* renamed from: com.google.android.m4b.maps.ay.d */
public final class C1436d {
    public static int m1881a(bk bkVar) {
        return bkVar == null ? 0 : bkVar.m1843d();
    }

    public static int m1882a(C1440g c1440g) {
        return c1440g == null ? 0 : 24;
    }

    public static int m1884a(C1480a c1480a) {
        return c1480a == null ? 0 : C1480a.m2295b();
    }

    public static int m1883a(C1455t c1455t) {
        return c1455t == null ? 0 : c1455t.m2106m();
    }

    public static int m1885a(String str) {
        if (str == null) {
            return 0;
        }
        return ((((str.length() + 1) / 4) * 4) * 2) + 40;
    }

    public static boolean m1887a(int i, int i2) {
        return (i & i2) != 0;
    }

    public static void m1886a(int i, byte[] bArr, int i2) {
        int i3 = i2 + 1;
        bArr[i2] = (byte) (i >> 24);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i >> 16);
        i3 = i4 + 1;
        bArr[i4] = (byte) (i >> 8);
        bArr[i3] = (byte) i;
    }
}
