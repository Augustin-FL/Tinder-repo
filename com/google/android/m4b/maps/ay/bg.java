package com.google.android.m4b.maps.ay;

import com.google.android.m4b.maps.aa.C1314b;
import com.google.android.m4b.maps.bh.p;
import com.google.android.m4b.maps.cf.b;
import com.google.android.m4b.maps.p015s.C1570c;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public final class bg implements aa {
    private final ac f1186a;
    private final ah f1187b;
    private final int f1188c;
    private final byte[] f1189d;
    private String[] f1190e;
    private String[] f1191f;
    private List<bp> f1192g;
    private int f1193h;

    public bg(ac acVar, int i, int i2, int i3, byte[] bArr, ah ahVar) {
        this.f1193h = -1;
        this.f1186a = acVar;
        this.f1187b = ahVar;
        this.f1188c = i;
        if (!(bArr == null || bArr.length == 0)) {
            C1314b c1314b = new C1314b();
            bArr = c1314b.m1018a(bArr);
            if (p.a()) {
                this.f1190e = c1314b.m1019a();
                this.f1191f = c1314b.m1020b();
                this.f1193h = c1314b.m1021c();
            }
            if (ahVar == ah.f1056x) {
                this.f1192g = c1314b.m1022d();
            }
            if (bArr[0] == 67) {
                try {
                    bArr = C1570c.m2792a(bArr);
                } catch (UnsupportedOperationException e) {
                    throw new IOException("Input image is not Compact JPEG");
                }
            }
        }
        if (this.f1190e == null) {
            this.f1190e = new String[0];
        }
        if (this.f1191f == null) {
            this.f1191f = new String[0];
        }
        if (this.f1192g == null) {
            this.f1192g = Collections.emptyList();
        }
        this.f1189d = bArr;
    }

    public final String[] m1788f() {
        return this.f1190e;
    }

    public final String[] m1789g() {
        return this.f1191f;
    }

    public final int m1790h() {
        return this.f1193h;
    }

    public final ac m1780a() {
        return this.f1186a;
    }

    public final int m1784c() {
        return this.f1188c;
    }

    public final List<bp> m1791i() {
        return this.f1192g;
    }

    public final byte[] m1792j() {
        return this.f1189d;
    }

    public final ah m1782b() {
        return this.f1187b;
    }

    public final boolean m1781a(b bVar) {
        return false;
    }

    public final int m1786d() {
        return -1;
    }

    public final boolean m1783b(b bVar) {
        return false;
    }

    public final void m1785c(b bVar) {
    }

    public final boolean m1787e() {
        return false;
    }
}
