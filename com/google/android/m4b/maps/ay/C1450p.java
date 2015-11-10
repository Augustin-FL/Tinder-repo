package com.google.android.m4b.maps.ay;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.m4b.maps.p009m.C1480a;

/* renamed from: com.google.android.m4b.maps.ay.p */
public final class C1450p implements bb {
    private final C1480a f1302a;
    private final C1446k f1303b;
    private final bk[] f1304c;
    private final C1455t f1305d;
    private final String f1306e;
    private final int f1307f;
    private final int f1308g;
    private final int f1309h;
    private final int[] f1310i;

    public C1450p(int i, C1480a c1480a, C1446k c1446k, bk[] bkVarArr, C1455t c1455t, int i2, String str, int i3, int i4, int i5, int[] iArr) {
        this.f1302a = c1480a;
        this.f1303b = c1446k;
        this.f1304c = bkVarArr;
        this.f1305d = c1455t;
        this.f1306e = str;
        this.f1307f = i3;
        this.f1308g = i4;
        this.f1309h = i5;
        this.f1310i = iArr;
    }

    public final C1480a m2061d() {
        return this.f1302a;
    }

    public final C1446k m2058a() {
        return this.f1303b;
    }

    public final bk m2057a(int i) {
        return this.f1304c[i];
    }

    public final int m2060c() {
        return this.f1304c == null ? 0 : this.f1304c.length;
    }

    public final C1455t m2062e() {
        return this.f1305d;
    }

    public final int m2063f() {
        return this.f1308g;
    }

    public final int m2059b() {
        return 2;
    }

    public final boolean m2064g() {
        return C1436d.m1887a(this.f1309h, 1);
    }

    public final boolean m2065h() {
        return (this.f1305d.m2100g() || m2066i()) && ((m2064g() || C1436d.m1887a(this.f1309h, 2)) && this.f1307f < AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS && !C1436d.m1887a(this.f1309h, 8));
    }

    public final boolean m2066i() {
        return C1436d.m1887a(this.f1309h, 32) && !C1436d.m1887a(this.f1309h, 8);
    }

    public final boolean m2067j() {
        return C1436d.m1887a(this.f1309h, 64);
    }

    public final boolean m2069l() {
        return C1436d.m1887a(this.f1309h, AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
    }

    public final int[] m2068k() {
        return this.f1310i;
    }

    public final int m2070q() {
        int i = 0;
        int i2 = this.f1303b.m2032i() + 60;
        if (this.f1304c != null) {
            bk[] bkVarArr = this.f1304c;
            int i3 = 0;
            while (i3 < bkVarArr.length) {
                int d = bkVarArr[i3].m1843d() + i;
                i3++;
                i = d;
            }
        }
        return (((i + C1436d.m1884a(this.f1302a)) + C1436d.m1883a(this.f1305d)) + C1436d.m1885a(this.f1306e)) + i2;
    }
}
