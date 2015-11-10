package com.google.android.m4b.maps.aa;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.m4b.maps.ag.k;
import com.google.android.m4b.maps.ag.r;
import com.google.android.m4b.maps.ay.C1440g;
import com.google.android.m4b.maps.ay.C1448m;
import com.google.android.m4b.maps.ay.bp;
import com.google.android.m4b.maps.ay.bq;
import com.google.android.m4b.maps.bg.d;
import com.google.android.m4b.maps.bo.f;
import com.google.android.m4b.maps.ch.a;
import com.google.android.m4b.maps.ch.c;
import com.google.common.collect.C1872p;
import com.google.common.collect.C1876q;
import com.tinder.views.RangeSeekBar;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* renamed from: com.google.android.m4b.maps.aa.b */
public final class C1314b {
    private static final int f759a;
    private static byte[] f760b;
    private a f761c;
    private a f762d;
    private a f763e;
    private a f764f;

    static {
        f759a = 31 - Integer.numberOfLeadingZeros(AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY);
        f760b = new byte[]{(byte) 76, (byte) 84, (byte) 73, (byte) 80, (byte) 10};
    }

    public final byte[] m1018a(byte[] bArr) {
        int i;
        Throwable th;
        Object obj = null;
        byte[] bArr2 = f760b;
        if (bArr.length >= bArr2.length + 0) {
            for (i = 0; i < bArr2.length; i++) {
                if (bArr[i + 0] != bArr2[i]) {
                    break;
                }
            }
            int i2 = 1;
        }
        if (obj == null) {
            return bArr;
        }
        try {
            InputStream gZIPInputStream;
            byte[] bArr3 = f760b;
            Object obj2 = new byte[4];
            System.arraycopy(bArr, 5, obj2, 0, 4);
            i = (obj2[3] & RangeSeekBar.INVALID_POINTER_ID) | ((((obj2[0] & RangeSeekBar.INVALID_POINTER_ID) << 24) | ((obj2[1] & RangeSeekBar.INVALID_POINTER_ID) << 16)) | ((obj2[2] & RangeSeekBar.INVALID_POINTER_ID) << 8));
            int abs = Math.abs(i);
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr, 9, abs);
            if (i < 0) {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            } else {
                gZIPInputStream = byteArrayInputStream;
            }
            this.f761c = new a(f.a);
            this.f761c.a(gZIPInputStream);
            gZIPInputStream.close();
            this.f762d = null;
            bArr3 = f760b;
            i2 = abs + 9;
            obj2 = new byte[(bArr.length - i2)];
            try {
                System.arraycopy(bArr, i2, obj2, 0, obj2.length);
                return obj2;
            } catch (Throwable e) {
                Object obj3 = obj2;
                th = e;
                k.a("IOException reading map tile info", th);
                return bArr;
            }
        } catch (IOException e2) {
            th = e2;
            k.a("IOException reading map tile info", th);
            return bArr;
        }
    }

    private a m1017e() {
        if (this.f762d == null && this.f761c != null && this.f761c.i(4)) {
            this.f762d = this.f761c.f(4);
        }
        return this.f762d;
    }

    public final String[] m1019a() {
        int i = 0;
        a e = m1017e();
        if (e == null) {
            return new String[0];
        }
        int j = e.j(1);
        String[] strArr = new String[j];
        while (i < j) {
            strArr[i] = e.d(1, i);
            i++;
        }
        return strArr;
    }

    public final String[] m1020b() {
        int i = 0;
        a e = m1017e();
        if (e == null) {
            return new String[0];
        }
        int j = e.j(2);
        String[] strArr = new String[j];
        while (i < j) {
            strArr[i] = e.d(2, i);
            i++;
        }
        return strArr;
    }

    public final int m1021c() {
        a e = m1017e();
        if (e == null || !e.i(3)) {
            return -1;
        }
        int d = e.d(3);
        if (d != 0) {
            return d;
        }
        r.a("year=0", toString());
        return -1;
    }

    public final List<bp> m1022d() {
        if (this.f763e == null && this.f761c != null && this.f761c.i(5)) {
            this.f763e = this.f761c.f(5);
        }
        a aVar = this.f763e;
        if (aVar == null) {
            return C1872p.m4309a();
        }
        if (this.f764f == null && this.f761c != null && this.f761c.i(1)) {
            this.f764f = this.f761c.f(1);
        }
        int a = c.a(this.f764f, 4);
        List<a> a2 = C1872p.m4309a();
        int j = this.f761c.j(3);
        for (int i = 0; i < j; i++) {
            a2.add(this.f761c.c(3, i));
        }
        List<bp> a3 = C1872p.m4309a();
        int j2 = aVar.j(1);
        for (int i2 = 0; i2 < j2; i2++) {
            a c = aVar.c(1, i2);
            List a4 = C1872p.m4309a();
            Map a5 = C1876q.m4328a();
            for (a aVar2 : a2) {
                a aVar22;
                C1440g a6;
                C1448m a7;
                String g = aVar22.c(2, 0).g(2);
                if (aVar22.d(1) == 0) {
                    aVar22 = aVar22.f(3);
                    a6 = d.a(aVar22.f(31));
                    C1440g c1440g = new C1440g(C1314b.m1016a(c.a(aVar22, 32), a) / 2, C1314b.m1016a(c.a(aVar22, 33), a) / 2);
                    a7 = C1448m.m2041a(a6.m1957e(c1440g), a6.m1959f(c1440g));
                } else {
                    a7 = null;
                    a6 = null;
                }
                a5.put(g, new bq(g, a6, a7));
            }
            if (c != null) {
                int j3 = c.j(1);
                for (j = 0; j < j3; j++) {
                    String g2 = c.c(1, j).g(1);
                    Object obj = (bq) a5.get(g2);
                    if (obj == null) {
                        obj = new bq(g2, null, null);
                    }
                    a4.add(obj);
                }
            }
            byte[] bArr = null;
            if (c != null) {
                String g3 = c.g(2);
                bArr = g3 == null ? new byte[0] : g3.getBytes();
            }
            a3.add(new bp(a4, bArr));
        }
        return a3;
    }

    private static int m1016a(int i, int i2) {
        return i << ((30 - i2) - f759a);
    }
}
