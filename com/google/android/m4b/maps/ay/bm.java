package com.google.android.m4b.maps.ay;

import com.google.android.m4b.maps.p009m.C1480a;
import java.io.DataInput;

public class bm implements bb {
    private final C1480a f1223a;
    private final C1446k f1224b;
    private final bk[] f1225c;
    private final C1455t f1226d;
    private final String f1227e;
    private final int f1228f;
    private final float f1229g;
    private final boolean f1230h;
    private final int[] f1231i;

    public bm(int i, C1480a c1480a, C1446k c1446k, bk[] bkVarArr, C1455t c1455t, int i2, String str, int i3, float f, int i4, int[] iArr) {
        this(i, c1480a, c1446k, bkVarArr, c1455t, i2, str, i3, f, i4, iArr, false);
    }

    public bm(int i, C1480a c1480a, C1446k c1446k, bk[] bkVarArr, C1455t c1455t, int i2, String str, int i3, float f, int i4, int[] iArr, boolean z) {
        this.f1223a = c1480a;
        this.f1224b = c1446k;
        this.f1225c = bkVarArr;
        this.f1226d = c1455t;
        this.f1227e = str;
        this.f1228f = i3;
        this.f1229g = f;
        this.f1231i = iArr;
        this.f1230h = z;
    }

    public static bm m1848a(DataInput dataInput, ae aeVar, C1449o c1449o) {
        return m1849a(dataInput, aeVar, c1449o, false);
    }

    protected static bm m1849a(DataInput dataInput, ae aeVar, C1449o c1449o, boolean z) {
        int i;
        int i2 = 0;
        C1446k a = C1446k.m2011a(dataInput, aeVar.m1461b());
        C1458w a2 = C1458w.m2111a(dataInput, aeVar);
        int a3 = am.m1577a(dataInput);
        bk[] bkVarArr = new bk[a3];
        for (i = 0; i < a3; i++) {
            bkVarArr[i] = bk.m1837a(dataInput, aeVar, a2);
        }
        byte readByte = dataInput.readByte();
        float readByte2 = ((float) dataInput.readByte()) / 4.0f;
        int readInt = dataInput.readInt();
        C1480a c1480a = null;
        if (C1436d.m1887a(1, readInt)) {
            c1480a = C1480a.m2293a(dataInput);
        } else if (C1436d.m1887a(2, readInt)) {
            c1480a = C1480a.m2296b(dataInput);
        }
        i = am.m1577a(dataInput);
        int[] iArr = new int[i];
        while (i2 < i) {
            iArr[i2] = am.m1577a(dataInput);
            i2++;
        }
        return z ? new bn(c1449o.m2056a(), c1480a, a, bkVarArr, a2.m2112a(), a2.m2114c(), a2.m2113b(), readByte, readByte2, readInt, iArr) : new bm(c1449o.m2056a(), c1480a, a, bkVarArr, a2.m2112a(), a2.m2114c(), a2.m2113b(), readByte, readByte2, readInt, iArr);
    }

    public final C1480a m1854d() {
        return this.f1223a;
    }

    public final C1446k m1851a() {
        return this.f1224b;
    }

    public final bk m1850a(int i) {
        return this.f1225c[i];
    }

    public final int m1853c() {
        return this.f1225c.length;
    }

    public final C1455t m1855e() {
        return this.f1226d;
    }

    public int m1852b() {
        return 8;
    }

    public final int m1856f() {
        return this.f1228f;
    }

    public final float m1857g() {
        return this.f1229g;
    }

    public final boolean m1858h() {
        return this.f1230h;
    }

    public final int[] m1859k() {
        return this.f1231i;
    }

    public final int m1860q() {
        int i = 0;
        int i2 = this.f1224b.m2032i();
        if (this.f1225c != null) {
            bk[] bkVarArr = this.f1225c;
            int i3 = 0;
            while (i3 < bkVarArr.length) {
                int d = bkVarArr[i3].m1843d() + i;
                i3++;
                i = d;
            }
        }
        return (i + (((C1436d.m1884a(this.f1223a) + 60) + C1436d.m1885a(this.f1227e)) + C1436d.m1883a(this.f1226d))) + i2;
    }
}
