package com.google.android.m4b.maps.ay;

import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.m4b.maps.au.C1363i;
import java.io.DataInput;
import java.util.Arrays;

/* renamed from: com.google.android.m4b.maps.ay.k */
public final class C1446k {
    private final int[] f1290a;
    private volatile C1448m f1291b;
    private volatile float f1292c;

    /* renamed from: com.google.android.m4b.maps.ay.k.1 */
    static class C14441 extends ThreadLocal<C1440g[]> {
        C14441() {
        }

        protected final /* synthetic */ Object initialValue() {
            return new C1440g[]{new C1440g(), new C1440g()};
        }
    }

    /* renamed from: com.google.android.m4b.maps.ay.k.a */
    public static class C1445a {
        private static /* synthetic */ boolean f1287c;
        private int[] f1288a;
        private int f1289b;

        static {
            f1287c = !C1446k.class.desiredAssertionStatus();
        }

        public C1445a() {
            this(16);
        }

        public C1445a(int i) {
            if (f1287c || i > 0) {
                this.f1288a = new int[(i * 3)];
                this.f1289b = 0;
                return;
            }
            throw new AssertionError();
        }

        public final boolean m2006a(C1440g c1440g) {
            int i = c1440g.f1264a;
            int i2 = c1440g.f1265b;
            int i3 = c1440g.f1266c;
            if (this.f1289b * 3 == this.f1288a.length) {
                Object obj = new int[(this.f1288a.length * 2)];
                System.arraycopy(this.f1288a, 0, obj, 0, this.f1289b * 3);
                this.f1288a = obj;
            }
            int i4 = this.f1289b * 3;
            if (this.f1289b > 0 && i == this.f1288a[i4 - 3] && i2 == this.f1288a[i4 - 2] && i3 == this.f1288a[i4 - 1]) {
                return false;
            }
            this.f1288a[i4] = i;
            this.f1288a[i4 + 1] = i2;
            this.f1288a[i4 + 2] = i3;
            this.f1289b++;
            return true;
        }

        public final int m2004a() {
            return this.f1289b;
        }

        public final C1440g m2005a(int i) {
            return new C1440g(this.f1288a[0], this.f1288a[1], this.f1288a[2]);
        }

        public final void m2007b() {
            this.f1289b = 0;
        }

        public final C1446k m2008c() {
            Object obj = new int[(this.f1289b * 3)];
            System.arraycopy(this.f1288a, 0, obj, 0, this.f1289b * 3);
            return new C1446k((byte) 0);
        }
    }

    static {
        C14441 c14441 = new C14441();
    }

    private C1446k(int[] iArr) {
        this.f1290a = iArr;
        this.f1292c = GroundOverlayOptions.NO_DIMENSION;
    }

    public final C1448m m2015a() {
        if (this.f1291b == null) {
            if (this.f1290a.length / 3 > 0) {
                C1440g a = m2014a(0);
                int i = a.f1264a;
                int i2 = a.f1265b;
                int i3 = i;
                int i4 = i;
                i = i2;
                for (int i5 = 1; i5 < this.f1290a.length / 3; i5++) {
                    m2016a(i5, a);
                    if (a.f1264a < i4) {
                        i4 = a.f1264a;
                    }
                    if (a.f1264a > i3) {
                        i3 = a.f1264a;
                    }
                    if (a.f1265b < i) {
                        i = a.f1265b;
                    }
                    if (a.f1265b > i2) {
                        i2 = a.f1265b;
                    }
                }
                a.m1955d(i4, i);
                this.f1291b = new C1448m(a, new C1440g(i3, i2));
            } else {
                this.f1291b = new C1448m(new C1440g(), new C1440g());
            }
        }
        return this.f1291b;
    }

    public static C1446k m2012a(int[] iArr) {
        return new C1446k(iArr);
    }

    public static C1446k m2010a(C1440g c1440g, C1440g c1440g2) {
        int[] iArr = new int[6];
        c1440g.m1948a(iArr, 0);
        c1440g2.m1948a(iArr, 1);
        return new C1446k(iArr);
    }

    public static C1446k m2011a(DataInput dataInput, ac acVar) {
        int a = am.m1577a(dataInput);
        int[] iArr = new int[(a * 3)];
        for (int i = 0; i < a; i++) {
            C1440g.m1932a(dataInput, acVar, iArr, i);
        }
        return new C1446k(iArr);
    }

    public final int m2020b() {
        return this.f1290a.length / 3;
    }

    public final C1440g m2014a(int i) {
        int i2 = i * 3;
        return new C1440g(this.f1290a[i2], this.f1290a[i2 + 1], this.f1290a[i2 + 2]);
    }

    public final void m2016a(int i, C1440g c1440g) {
        int i2 = i * 3;
        c1440g.f1264a = this.f1290a[i2];
        c1440g.f1265b = this.f1290a[i2 + 1];
        c1440g.f1266c = this.f1290a[i2 + 2];
    }

    public final void m2018a(C1440g c1440g) {
        int length = this.f1290a.length - 3;
        c1440g.f1264a = this.f1290a[length];
        c1440g.f1265b = this.f1290a[length + 1];
        c1440g.f1266c = this.f1290a[length + 2];
    }

    public final C1440g m2023c() {
        int length = this.f1290a.length - 3;
        return new C1440g(this.f1290a[length], this.f1290a[length + 1], this.f1290a[length + 2]);
    }

    public final void m2017a(int i, C1440g c1440g, C1440g c1440g2) {
        int i2 = i * 3;
        c1440g2.f1264a = this.f1290a[i2] - c1440g.f1264a;
        c1440g2.f1265b = this.f1290a[i2 + 1] - c1440g.f1265b;
        c1440g2.f1266c = this.f1290a[i2 + 2] - c1440g.f1266c;
    }

    public final float m2026d() {
        float f = 0.0f;
        if (this.f1292c < 0.0f) {
            for (int i = 0; i < (this.f1290a.length / 3) - 1; i++) {
                f += m2019b(i);
            }
            this.f1292c = f;
        }
        return this.f1292c;
    }

    public final float m2019b(int i) {
        int i2 = i * 3;
        int i3 = i2 + 3;
        int i4 = i2 + 1;
        int i5 = i3 + 1;
        float f = (float) (this.f1290a[i2] - this.f1290a[i3]);
        float f2 = (float) (this.f1290a[i4] - this.f1290a[i5]);
        float f3 = (float) (this.f1290a[i4 + 1] - this.f1290a[i5 + 1]);
        return (float) Math.sqrt((double) (((f * f) + (f2 * f2)) + (f3 * f3)));
    }

    public final boolean m2028e() {
        if (this.f1290a.length <= 0) {
            return false;
        }
        int length = this.f1290a.length - 3;
        if (this.f1290a[0] == this.f1290a[length] && this.f1290a[1] == this.f1290a[length + 1] && this.f1290a[2] == this.f1290a[length + 2]) {
            return true;
        }
        return false;
    }

    public final boolean m2029f() {
        int length = this.f1290a.length / 3;
        long j = 0;
        for (int i = 0; i < length - 1; i++) {
            C1440g a = m2014a(i);
            C1440g a2 = m2014a(i + 1);
            j += (((long) a.f1264a) * ((long) a2.f1265b)) - (((long) a2.f1264a) * ((long) a.f1265b));
        }
        if (!m2028e()) {
            C1440g c = m2023c();
            C1440g a3 = m2014a(0);
            j += (((long) c.f1264a) * ((long) a3.f1265b)) - (((long) a3.f1264a) * ((long) c.f1265b));
        }
        if (j > 0) {
            return true;
        }
        return false;
    }

    public final C1440g m2013a(float f) {
        if (f <= 0.0f) {
            return m2014a(0);
        }
        if (f >= 1.0f) {
            return m2023c();
        }
        int length = (this.f1290a.length / 3) - 1;
        float d = m2026d() * f;
        int i = 0;
        while (i < length) {
            float b = m2019b(i);
            if (b >= d) {
                b = d / b;
                C1440g c1440g = new C1440g();
                C1440g c1440g2 = new C1440g();
                m2016a(i, c1440g);
                m2016a(i + 1, c1440g2);
                C1440g.m1930a(c1440g, c1440g2, b, c1440g2);
                return c1440g2;
            }
            i++;
            d -= b;
        }
        return m2023c();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1446k)) {
            return false;
        }
        return Arrays.equals(this.f1290a, ((C1446k) obj).f1290a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f1290a);
    }

    public final C1446k m2021b(float f) {
        int i = 0;
        if (this.f1290a.length <= 6) {
            return this;
        }
        int length = this.f1290a.length / 3;
        boolean[] zArr = new boolean[length];
        zArr[0] = true;
        zArr[length - 1] = true;
        int a = m2009a(f * f, 1, 0, length - 1, new C1440g(), new C1440g(), new C1440g(), new C1440g(), zArr) + 2;
        if (a == length) {
            return this;
        }
        int[] iArr = new int[(a * 3)];
        a = 0;
        while (i < length) {
            if (zArr[i]) {
                int i2 = i * 3;
                int i3 = a + 1;
                int i4 = i2 + 1;
                iArr[a] = this.f1290a[i2];
                i2 = i3 + 1;
                int i5 = i4 + 1;
                iArr[i3] = this.f1290a[i4];
                a = i2 + 1;
                iArr[i2] = this.f1290a[i5];
            }
            i++;
        }
        this(iArr);
        return this;
    }

    private int m2009a(float f, int i, int i2, int i3, C1440g c1440g, C1440g c1440g2, C1440g c1440g3, C1440g c1440g4, boolean[] zArr) {
        m2016a(i2, c1440g);
        m2016a(i3, c1440g2);
        int i4 = -1;
        int i5 = i2 + i;
        float f2 = f;
        while (i5 <= i3 - 1) {
            m2016a(i5, c1440g4);
            float a = C1440g.m1922a(c1440g, c1440g2, c1440g4, c1440g3);
            if (a > f2) {
                i4 = i5;
            } else {
                a = f2;
            }
            i5 += i;
            f2 = a;
        }
        if (i4 < 0) {
            return 0;
        }
        int i6 = 1;
        zArr[i4] = true;
        if (i4 > i2 + 1) {
            i6 = m2009a(f, i, i2, i4, c1440g, c1440g2, c1440g3, c1440g4, zArr) + 1;
        }
        if (i4 < i3 - 1) {
            return i6 + m2009a(f, i, i4, i3, c1440g, c1440g2, c1440g3, c1440g4, zArr);
        }
        return i6;
    }

    public final C1446k m2024c(float f) {
        boolean e = m2028e();
        int length = this.f1290a.length / 3;
        int i = length - 1;
        if (length <= 2 || f <= 0.0f) {
            return this;
        }
        if (length <= 3 && e) {
            return this;
        }
        Object obj;
        C1445a c1445a = new C1445a(length);
        int i2 = e ? i - 1 : 1;
        int i3 = (i2 - 1) * 3;
        int i4 = i2 * 3;
        int i5 = ((i2 + 1) % length) * 3;
        i2 = ((i2 + 2) % length) * 3;
        C1440g c1440g = new C1440g(this.f1290a[i3], this.f1290a[i3 + 1], 0);
        C1440g c1440g2 = new C1440g(this.f1290a[i4], this.f1290a[i4 + 1], 0);
        C1440g c1440g3 = new C1440g(this.f1290a[i5], this.f1290a[i5 + 1], 0);
        C1440g c1440g4 = new C1440g(this.f1290a[i2], this.f1290a[i2 + 1], 0);
        C1440g c1440g5 = new C1440g();
        if (!e || c1440g2.m1951c(c1440g3) > f) {
            obj = null;
        } else {
            obj = 1;
        }
        if (!e) {
            c1445a.m2006a(c1440g);
            if (i2 == 0) {
                if (c1440g.m1951c(c1440g2) > f && c1440g2.m1951c(c1440g3) > f) {
                    c1445a.m2006a(c1440g2);
                }
                c1445a.m2006a(c1440g3);
                return c1445a.m2008c();
            }
            while (c1440g.m1951c(c1440g2) <= f) {
                i2 += 3;
                if (i2 == length * 3) {
                    if (c1440g.m1951c(c1440g3) > f && c1440g3.m1951c(c1440g4) > f) {
                        c1445a.m2006a(c1440g3);
                    }
                    c1445a.m2006a(c1440g4);
                    return c1445a.m2008c();
                }
                c1440g2.m1950b(c1440g3);
                c1440g3.m1950b(c1440g4);
                c1440g4.m1945a(this.f1290a[i2], this.f1290a[i2 + 1], 0);
            }
        }
        i3 = i2;
        while (i3 < length * 3) {
            c1440g4.m1955d(this.f1290a[i3], this.f1290a[i3 + 1]);
            if (obj != null) {
                if (i3 == (i - 1) * 3) {
                    c1440g4.m1950b(c1440g5);
                } else if (i3 == i * 3) {
                    i3 += 3;
                }
            }
            float c = c1440g2.m1951c(c1440g3);
            if (c > f) {
                if (e && i3 == i2) {
                    c1440g5.m1950b(c1440g2);
                } else {
                    c1445a.m2006a(c1440g2);
                }
                c1440g.m1950b(c1440g2);
                c1440g2.m1950b(c1440g3);
                c1440g3.m1950b(c1440g4);
            } else {
                double c2 = (double) (c1440g.m1951c(c1440g2) + c);
                double c3 = (double) (c + c1440g3.m1951c(c1440g4));
                c1440g2.m1955d((int) Math.round(((((double) c1440g2.f1264a) * c2) + (((double) c1440g3.f1264a) * c3)) / (c2 + c3)), (int) Math.round(((((double) c1440g2.f1265b) * c2) + (((double) c1440g3.f1265b) * c3)) / (c3 + c2)));
                c1440g3.m1950b(c1440g4);
            }
            i3 += 3;
        }
        if (e || c1440g2.m1951c(c1440g3) > f) {
            c1445a.m2006a(c1440g2);
        }
        if (e) {
            c1445a.m2006a(c1445a.m2005a(0));
        } else {
            c1445a.m2006a(c1440g3);
        }
        return c1445a.m2004a() != length ? c1445a.m2008c() : this;
    }

    public final int m2030g() {
        int length = this.f1290a.length / 3;
        if (length == 0) {
            return -536870912;
        }
        C1363i a = C1363i.m1258a();
        C1440g c1440g = new C1440g();
        m2014a(0).m1965i(c1440g);
        int i = 1;
        C1363i c1363i = a;
        while (i < length) {
            C1440g c1440g2 = new C1440g(c1440g);
            m2014a(i).m1965i(c1440g);
            i++;
            c1363i = c1363i.m1264a(C1363i.m1259a(C1363i.m1257a(C1440g.m1933b(c1440g2.f1264a)), C1363i.m1257a(C1440g.m1933b(c1440g.f1264a))));
        }
        if (c1363i.m1266b()) {
            return -536870912;
        }
        double a2 = C1363i.m1257a(-536870912);
        if (a2 == -3.141592653589793d) {
            a2 = 3.141592653589793d;
        }
        if (c1363i.m1265a(a2)) {
            return C1440g.m1933b((int) ((c1363i.m1268d().m1267c() / 3.141592653589793d) * 5.36870912E8d));
        }
        return -536870912;
    }

    public final C1446k m2025c(int i) {
        Object obj = null;
        if (i == -536870912) {
            return this;
        }
        Object obj2 = i < 0 ? 1 : null;
        int length = this.f1290a.length / 3;
        C1445a c1445a = new C1445a(length);
        C1440g c1440g = new C1440g();
        for (int i2 = 0; i2 < length; i2++) {
            m2016a(i2, c1440g);
            if (obj2 != null) {
                if (c1440g.f1264a < i) {
                    c1440g.f1264a += 1073741824;
                    obj = 1;
                }
            } else if (c1440g.f1264a > i) {
                c1440g.f1264a -= 1073741824;
                int i3 = 1;
            }
            c1445a.m2006a(c1440g);
        }
        return obj != null ? c1445a.m2008c() : this;
    }

    public final float m2027d(int i) {
        int i2 = i * 3;
        return C1442i.m1987a(this.f1290a[i2 + 3] - this.f1290a[i2], this.f1290a[(i2 + 3) + 1] - this.f1290a[i2 + 1]);
    }

    public final C1446k m2031h() {
        int length = this.f1290a.length;
        int[] iArr = new int[length];
        int[] iArr2 = this.f1290a;
        for (int i = 0; i < this.f1290a.length; i += 3) {
            iArr[i] = iArr2[(length - i) - 3];
            iArr[i + 1] = iArr2[(length - i) - 2];
            iArr[i + 2] = iArr2[(length - i) - 1];
        }
        return new C1446k(iArr);
    }

    public final C1446k m2022b(C1440g c1440g) {
        int[] iArr = new int[this.f1290a.length];
        for (int i = 0; i < this.f1290a.length; i += 3) {
            iArr[i] = this.f1290a[i] + c1440g.f1264a;
            iArr[i + 1] = this.f1290a[i + 1] + c1440g.f1265b;
            iArr[i + 2] = this.f1290a[i + 2] + c1440g.f1266c;
        }
        return new C1446k(iArr);
    }

    public final int m2032i() {
        return (this.f1290a.length * 4) + 160;
    }
}
