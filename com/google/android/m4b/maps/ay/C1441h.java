package com.google.android.m4b.maps.ay;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.m4b.maps.ay.ab.C1392a;
import com.google.android.m4b.maps.p009m.C1480a;
import com.google.android.m4b.maps.p014r.C1567f;
import java.io.DataInput;

/* renamed from: com.google.android.m4b.maps.ay.h */
public final class C1441h implements bb {
    private final ac f1267a;
    private final String f1268b;
    private final String f1269c;
    private final C1480a f1270d;
    private final C1455t f1271e;
    private final int f1272f;
    private final int[] f1273g;
    private final int f1274h;
    private final int f1275i;
    private final int f1276j;
    private float f1277k;
    private float f1278l;
    private final C1391a[] f1279m;
    private final bk f1280n;
    private final bk f1281o;
    private final C1392a[] f1282p;
    private final String f1283q;
    private final String f1284r;

    public C1441h(int i, ac acVar, C1440g c1440g, C1480a c1480a, C1391a[] c1391aArr, bk bkVar, bk bkVar2, C1392a[] c1392aArr, String str, C1455t c1455t, int i2, String str2, int i3, int i4, int i5, int i6, String str3, String str4, C1392a c1392a, int[] iArr) {
        this.f1277k = GroundOverlayOptions.NO_DIMENSION;
        this.f1278l = GroundOverlayOptions.NO_DIMENSION;
        this.f1270d = c1480a;
        this.f1279m = c1391aArr;
        this.f1280n = bkVar;
        this.f1281o = bkVar2;
        this.f1282p = c1392aArr;
        this.f1269c = str;
        this.f1271e = c1455t;
        this.f1283q = str2;
        this.f1272f = i3;
        this.f1274h = i4;
        if (i5 == -1) {
            i5 = 30;
        }
        this.f1275i = i5;
        this.f1276j = i6;
        this.f1284r = str3;
        this.f1268b = str4;
        this.f1273g = iArr;
        this.f1267a = acVar;
    }

    public static C1441h m1967a(DataInput dataInput, ae aeVar, C1449o c1449o) {
        int i;
        String readUTF;
        C1392a c1392a;
        int a = am.m1577a(dataInput);
        C1391a[] c1391aArr = new C1391a[a];
        ac b = aeVar.m1461b();
        aeVar.m1459a();
        for (i = 0; i < a; i++) {
            c1391aArr[i] = C1391a.m1422a(dataInput, b);
        }
        C1440g b2 = c1391aArr[0].m1424b();
        C1458w a2 = C1458w.m2111a(dataInput, aeVar);
        bk a3 = bk.m1837a(dataInput, aeVar, a2);
        bk a4 = bk.m1837a(dataInput, aeVar, a2);
        a = am.m1577a(dataInput);
        C1392a[] c1392aArr = new C1392a[a];
        for (i = 0; i < a; i++) {
            c1392aArr[i] = C1392a.m1431b(dataInput);
        }
        byte readByte = dataInput.readByte();
        byte readByte2 = dataInput.readByte();
        byte readByte3 = dataInput.readByte();
        int readInt = dataInput.readInt();
        C1480a c1480a = null;
        if (C1436d.m1887a(1, readInt)) {
            c1480a = C1480a.m2293a(dataInput);
        } else if (C1436d.m1887a(2, readInt)) {
            c1480a = C1480a.m2296b(dataInput);
        }
        String str = null;
        if (C1436d.m1887a(32, readInt)) {
            str = C1567f.m2782a(dataInput.readUTF()).intern();
        }
        String str2 = null;
        if (C1436d.m1887a(64, readInt)) {
            str2 = dataInput.readUTF();
        }
        if (C1436d.m1887a(AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS, readInt)) {
            readUTF = dataInput.readUTF();
        } else {
            String a5 = a3.m1840a();
            String a6 = a4.m1840a();
            if (a5.length() > 0 && a6.length() > 0) {
                a5 = a5 + '\n';
            }
            readUTF = a5 + a6;
        }
        if (aeVar.m1459a() != 11) {
            c1392a = C1392a.f998c;
        } else if (C1436d.m1887a(AdRequest.MAX_CONTENT_URL_LENGTH, readInt)) {
            c1392a = C1392a.m1431b(dataInput);
        } else {
            c1392a = C1392a.f998c;
        }
        a = am.m1577a(dataInput);
        int[] iArr = new int[a];
        for (i = 0; i < a; i++) {
            iArr[i] = am.m1577a(dataInput);
        }
        return new C1441h(c1449o.m2056a(), b, b2, c1480a, c1391aArr, a3, a4, c1392aArr, str, a2.m2112a(), a2.m2114c(), a2.m2113b(), readByte, readByte2, readByte3, readInt, str2, readUTF, c1392a, iArr);
    }

    public final ac m1968a() {
        return this.f1267a;
    }

    public final int m1970b() {
        return 7;
    }

    public final String m1972c() {
        return this.f1268b;
    }

    public final C1480a m1973d() {
        return this.f1270d;
    }

    public final C1455t m1974e() {
        return this.f1271e;
    }

    public final int m1975f() {
        return this.f1272f;
    }

    public final int m1976g() {
        return this.f1274h;
    }

    public final int m1977h() {
        return this.f1275i;
    }

    public final float m1978i() {
        return this.f1277k;
    }

    public final float m1979j() {
        return this.f1278l;
    }

    public final void m1969a(float f) {
        this.f1277k = f;
    }

    public final void m1971b(float f) {
        this.f1278l = f;
    }

    public final int[] m1980k() {
        return this.f1273g;
    }

    public final C1391a[] m1981l() {
        return this.f1279m;
    }

    public final bk m1982m() {
        return this.f1280n;
    }

    public final bk m1983n() {
        return this.f1281o;
    }

    public final C1392a[] m1984o() {
        return this.f1282p;
    }

    public final boolean m1985p() {
        return C1436d.m1887a(16, this.f1276j);
    }

    public final int m1986q() {
        int i;
        int i2;
        int i3 = 0;
        int i4 = 120;
        if (this.f1268b != null) {
            i4 = C1436d.m1885a(this.f1268b) + 120;
        }
        if (this.f1269c != null) {
            i4 += C1436d.m1885a(this.f1269c);
        }
        if (this.f1279m != null) {
            C1391a[] c1391aArr = this.f1279m;
            i = 0;
            i2 = 0;
            while (i < c1391aArr.length) {
                int d = c1391aArr[i].m1426d() + i2;
                i++;
                i2 = d;
            }
        } else {
            i2 = 0;
        }
        if (this.f1282p != null) {
            i = 0;
            while (i < this.f1282p.length) {
                i++;
                i3 = ab.m1428c() + i3;
            }
        }
        return i4 + (((((((i2 + i3) + C1436d.m1881a(this.f1280n)) + C1436d.m1881a(this.f1281o)) + C1436d.m1884a(this.f1270d)) + C1436d.m1883a(this.f1271e)) + C1436d.m1885a(this.f1283q)) + C1436d.m1885a(this.f1284r));
    }
}
