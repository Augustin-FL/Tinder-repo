package com.google.android.m4b.maps.ay;

import com.google.android.m4b.maps.p009m.C1480a;
import java.io.DataInput;

public final class ai implements bb {
    private final C1446k f1071a;
    private final C1455t f1072b;
    private final String f1073c;
    private final int f1074d;
    private final int f1075e;
    private final int[] f1076f;

    private ai(int i, C1446k c1446k, C1455t c1455t, int i2, String str, int i3, int i4, int[] iArr) {
        this.f1071a = c1446k;
        this.f1072b = c1455t;
        this.f1073c = str;
        this.f1075e = i3;
        this.f1074d = i4;
        this.f1076f = iArr;
    }

    public static bb m1547a(DataInput dataInput, ae aeVar, C1449o c1449o) {
        C1446k a = C1446k.m2011a(dataInput, aeVar.m1461b());
        C1458w a2 = C1458w.m2111a(dataInput, aeVar);
        int a3 = am.m1577a(dataInput);
        int readInt = dataInput.readInt();
        int a4 = am.m1577a(dataInput);
        int[] iArr = new int[a4];
        for (int i = 0; i < a4; i++) {
            iArr[i] = am.m1577a(dataInput);
        }
        return new ai(c1449o.m2056a(), a, a2.m2112a(), a2.m2114c(), a2.m2113b(), a3, readInt, iArr);
    }

    public final C1446k m1548a() {
        return this.f1071a;
    }

    public final boolean m1550c() {
        return C1436d.m1887a(this.f1074d, 1);
    }

    public final int m1554g() {
        return this.f1075e;
    }

    public final int m1553f() {
        return 0;
    }

    public final C1455t m1552e() {
        return this.f1072b;
    }

    public final int m1549b() {
        return 9;
    }

    public final int[] m1555k() {
        return this.f1076f;
    }

    public final C1480a m1551d() {
        return C1480a.f1436a;
    }

    public final int m1556q() {
        return ((this.f1071a.m2032i() + 44) + C1436d.m1885a(this.f1073c)) + C1436d.m1883a(this.f1072b);
    }
}
