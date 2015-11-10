package com.google.android.m4b.maps.ay;

import com.google.android.m4b.maps.p009m.C1480a;
import java.io.DataInput;

public final class av implements bb {
    private static final byte[] f1146l;
    private static final int[] f1147m;
    private final C1480a f1148a;
    private final ak f1149b;
    private final ak f1150c;
    private final byte[] f1151d;
    private final C1455t f1152e;
    private final String f1153f;
    private final int f1154g;
    private final int f1155h;
    private final int f1156i;
    private final int f1157j;
    private final int[] f1158k;

    static {
        f1146l = new byte[]{(byte) 1, (byte) 2, (byte) 4};
        f1147m = new int[]{0, 1, 1, 2, 1, 2, 2, 3};
    }

    private av(int i, C1480a c1480a, ak akVar, ak akVar2, byte[] bArr, int i2, int i3, C1455t c1455t, int i4, String str, int i5, int i6, int[] iArr) {
        this.f1148a = c1480a;
        this.f1149b = akVar;
        this.f1150c = akVar2;
        this.f1151d = bArr;
        this.f1154g = i2;
        this.f1155h = i3;
        this.f1152e = c1455t;
        this.f1153f = str;
        this.f1156i = i5;
        this.f1157j = i6;
        this.f1158k = iArr;
    }

    public static av m1704a(DataInput dataInput, ae aeVar, C1449o c1449o) {
        int a;
        ak a2 = ak.m1568a(dataInput, aeVar.m1461b());
        ak a3 = ak.m1569a(dataInput, aeVar);
        if ((a3.m1570a() != 0 ? 1 : null) != null) {
            a = a3.m1570a();
        } else {
            a = a2.m1570a();
        }
        byte[] bArr = new byte[a];
        dataInput.readFully(bArr);
        int a4 = am.m1577a(dataInput);
        int a5 = am.m1577a(dataInput);
        C1458w a6 = C1458w.m2111a(dataInput, aeVar);
        byte readByte = dataInput.readByte();
        int readInt = dataInput.readInt();
        C1480a c1480a = null;
        if (C1436d.m1887a(1, readInt)) {
            c1480a = C1480a.m2293a(dataInput);
        } else if (C1436d.m1887a(2, readInt)) {
            c1480a = C1480a.m2296b(dataInput);
        }
        int a7 = am.m1577a(dataInput);
        int[] iArr = new int[a7];
        for (a = 0; a < a7; a++) {
            iArr[a] = am.m1577a(dataInput);
        }
        return new av(c1449o.m2056a(), c1480a, a2, a3, bArr, a4, a5, a6.m2112a(), a6.m2114c(), a6.m2113b(), readByte, readInt, iArr);
    }

    public final C1480a m1709d() {
        return this.f1148a;
    }

    public final ak m1705a() {
        return this.f1149b;
    }

    public final boolean m1706a(int i, int i2) {
        return (this.f1151d[i] & f1146l[i2]) != 0;
    }

    public final int m1708c() {
        int i = 0;
        int i2 = 0;
        while (i < this.f1151d.length) {
            i2 += f1147m[this.f1151d[i] & 7];
            i++;
        }
        return i2;
    }

    public final boolean m1712g() {
        return C1436d.m1887a(this.f1157j, 4);
    }

    public final int m1713h() {
        return this.f1154g;
    }

    public final int m1714i() {
        return this.f1155h;
    }

    public final C1455t m1710e() {
        return this.f1152e;
    }

    public final int m1707b() {
        return 4;
    }

    public final int m1711f() {
        return this.f1156i;
    }

    public final int[] m1715k() {
        return this.f1158k;
    }

    public final int m1716q() {
        int i;
        int length = this.f1151d.length + (this.f1149b.m1574b() + 68);
        if (this.f1150c == null) {
            i = 0;
        } else {
            i = this.f1150c.m1574b();
        }
        return (((i + C1436d.m1884a(this.f1148a)) + C1436d.m1885a(this.f1153f)) + C1436d.m1883a(this.f1152e)) + length;
    }
}
