package com.google.android.m4b.maps.ay;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.m4b.maps.ch.a;
import java.io.DataInput;
import java.util.Locale;

/* renamed from: com.google.android.m4b.maps.ay.g */
public final class C1440g implements Comparable<C1440g> {
    int f1264a;
    int f1265b;
    int f1266c;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        C1440g c1440g = (C1440g) obj;
        if (this.f1264a == c1440g.f1264a) {
            return this.f1265b == c1440g.f1265b ? this.f1266c - c1440g.f1266c : this.f1265b - c1440g.f1265b;
        } else {
            return this.f1264a - c1440g.f1264a;
        }
    }

    public C1440g(int i, int i2) {
        this.f1264a = i;
        this.f1265b = i2;
    }

    public C1440g(int i, int i2, int i3) {
        this.f1264a = i;
        this.f1265b = i2;
        this.f1266c = i3;
    }

    public C1440g(C1440g c1440g) {
        this.f1264a = c1440g.f1264a;
        this.f1265b = c1440g.f1265b;
        this.f1266c = c1440g.f1266c;
    }

    public static C1440g m1924a(int i, int i2) {
        return C1440g.m1923a(((double) i) * 1.0E-7d, ((double) i2) * 1.0E-7d);
    }

    public static C1440g m1934b(int i, int i2) {
        return C1440g.m1923a(((double) i) * 1.0E-6d, ((double) i2) * 1.0E-6d);
    }

    public static C1440g m1939c(int i, int i2) {
        return C1440g.m1923a(((double) i) * 1.0E-5d, ((double) i2) * 1.0E-5d);
    }

    public static C1440g m1923a(double d, double d2) {
        C1440g c1440g = new C1440g();
        c1440g.m1955d((int) Math.round((0.017453292519943295d * d2) * 1.708913188941079E8d), (int) Math.round(Math.log(Math.tan(((d * 0.017453292519943295d) * 0.5d) + 0.7853981633974483d)) * 1.708913188941079E8d));
        return c1440g;
    }

    public static C1440g m1927a(a aVar) {
        return C1440g.m1924a(aVar.d(1), aVar.d(2));
    }

    public final int m1941a() {
        return (int) Math.round(m1949b() * 1000000.0d);
    }

    public final double m1949b() {
        return ((Math.atan(Math.exp(((double) this.f1265b) * 5.8516723170686385E-9d)) - 0.7853981633974483d) * 2.0d) * 57.29577951308232d;
    }

    public final int m1952c() {
        return (int) Math.round(m1953d() * 1000000.0d);
    }

    public final double m1953d() {
        double d = (((double) this.f1264a) * 5.8516723170686385E-9d) * 57.29577951308232d;
        while (d > 180.0d) {
            d -= 360.0d;
        }
        while (d < -180.0d) {
            d += 360.0d;
        }
        return d;
    }

    public static double m1920a(double d) {
        return 5.36870912E8d / (2.0015115070354454E7d * Math.cos(0.017453292519943295d * d));
    }

    public final double m1956e() {
        return C1440g.m1920a(m1949b());
    }

    public static C1440g m1925a(C1440g c1440g) {
        return new C1440g(c1440g.f1264a, c1440g.f1265b, c1440g.f1266c);
    }

    public static C1440g m1928a(DataInput dataInput, ac acVar) {
        if (acVar.f1001c < 0) {
            int i = -acVar.f1001c;
            return new C1440g((dataInput.readShort() >> i) + acVar.f999a, acVar.f1000b + (dataInput.readShort() >> i));
        }
        i = acVar.f1001c;
        return new C1440g((dataInput.readShort() << i) + acVar.f999a, acVar.f1000b + (dataInput.readShort() << i));
    }

    static void m1932a(DataInput dataInput, ac acVar, int[] iArr, int i) {
        int i2 = i * 3;
        if (acVar.f1001c < 0) {
            int i3 = -acVar.f1001c;
            int i4 = i2 + 1;
            iArr[i2] = (dataInput.readShort() >> i3) + acVar.f999a;
            i2 = i4 + 1;
            iArr[i4] = (dataInput.readShort() >> i3) + acVar.f1000b;
            iArr[i2] = 0;
            return;
        }
        i3 = acVar.f1001c;
        i4 = i2 + 1;
        iArr[i2] = (dataInput.readShort() << i3) + acVar.f999a;
        i2 = i4 + 1;
        iArr[i4] = (dataInput.readShort() << i3) + acVar.f1000b;
        iArr[i2] = 0;
    }

    static void m1937b(DataInput dataInput, ac acVar, int[] iArr, int i) {
        int i2 = i * 3;
        if (acVar.f1001c < 0) {
            int i3 = -acVar.f1001c;
            int i4 = i2 + 1;
            iArr[i2] = (dataInput.readShort() >> i3) + acVar.f999a;
            i2 = i4 + 1;
            iArr[i4] = (dataInput.readShort() >> i3) + acVar.f1000b;
            iArr[i2] = dataInput.readInt() >> i3;
            return;
        }
        i3 = acVar.f1001c;
        i4 = i2 + 1;
        iArr[i2] = (dataInput.readShort() << i3) + acVar.f999a;
        i2 = i4 + 1;
        iArr[i4] = (dataInput.readShort() << i3) + acVar.f1000b;
        iArr[i2] = dataInput.readInt() << i3;
    }

    public final int m1958f() {
        return this.f1264a;
    }

    public final int m1960g() {
        return this.f1265b;
    }

    public final int m1962h() {
        return this.f1266c;
    }

    public final void m1948a(int[] iArr, int i) {
        int i2 = i * 3;
        iArr[i2] = this.f1264a;
        iArr[i2 + 1] = this.f1265b;
        iArr[i2 + 2] = this.f1266c;
    }

    public final void m1946a(int i, int[] iArr, int i2) {
        int i3 = (int) ((((long) this.f1265b) << 16) / ((long) i));
        int i4 = (int) ((((long) this.f1266c) << 16) / ((long) i));
        iArr[i2] = (int) ((((long) this.f1264a) << 16) / ((long) i));
        iArr[i2 + 1] = i3;
        iArr[i2 + 2] = i4;
    }

    public final void m1950b(C1440g c1440g) {
        this.f1264a = c1440g.f1264a;
        this.f1265b = c1440g.f1265b;
        this.f1266c = c1440g.f1266c;
    }

    public final void m1944a(int i) {
        this.f1266c = i;
    }

    public final void m1955d(int i, int i2) {
        this.f1264a = i;
        this.f1265b = i2;
        this.f1266c = 0;
    }

    public final void m1945a(int i, int i2, int i3) {
        this.f1264a = i;
        this.f1265b = i2;
        this.f1266c = i3;
    }

    public final void m1943a(float f, float f2) {
        float f3 = (3.1415927f * f) / BitmapDescriptorFactory.HUE_CYAN;
        m1955d((int) (((double) f2) * Math.sin((double) f3)), (int) (((double) f2) * Math.cos((double) f3)));
    }

    public final float m1964i() {
        return (float) Math.sqrt((double) (((((float) this.f1264a) * ((float) this.f1264a)) + (((float) this.f1265b) * ((float) this.f1265b))) + (((float) this.f1266c) * ((float) this.f1266c))));
    }

    public final float m1951c(C1440g c1440g) {
        float f = (float) (this.f1264a - c1440g.f1264a);
        float f2 = (float) (this.f1265b - c1440g.f1265b);
        float f3 = (float) (this.f1266c - c1440g.f1266c);
        return (float) Math.sqrt((double) (((f * f) + (f2 * f2)) + (f3 * f3)));
    }

    public final float m1954d(C1440g c1440g) {
        float f = (float) (this.f1264a - c1440g.f1264a);
        float f2 = (float) (this.f1265b - c1440g.f1265b);
        float f3 = (float) (this.f1266c - c1440g.f1266c);
        return ((f * f) + (f2 * f2)) + (f3 * f3);
    }

    public static C1440g m1926a(C1440g c1440g, C1440g c1440g2, float f) {
        int i;
        C1440g c1440g3 = new C1440g();
        float f2 = -f;
        if (Math.abs(c1440g2.f1264a) < 268435456 || ((c1440g.f1264a < 0 && c1440g2.f1264a < 0) || (c1440g.f1264a >= 0 && c1440g2.f1264a >= 0))) {
            i = c1440g2.f1264a - c1440g.f1264a;
        } else {
            i = 1073741824 - (Math.abs(c1440g.f1264a) + Math.abs(c1440g2.f1264a));
            if (c1440g.f1264a < 0) {
                i = -i;
            }
        }
        c1440g3.m1945a(((int) (((float) i) * f2)) + c1440g.f1264a, ((int) (((float) (c1440g2.f1265b - c1440g.f1265b)) * f2)) + c1440g.f1265b, ((int) (f2 * ((float) (c1440g2.f1266c - c1440g.f1266c)))) + c1440g.f1266c);
        return c1440g3;
    }

    public static void m1931a(C1440g c1440g, C1440g c1440g2, C1440g c1440g3) {
        c1440g3.f1264a = c1440g.f1264a + c1440g2.f1264a;
        c1440g3.f1265b = c1440g.f1265b + c1440g2.f1265b;
        c1440g3.f1266c = c1440g.f1266c + c1440g2.f1266c;
    }

    public final C1440g m1957e(C1440g c1440g) {
        return new C1440g(this.f1264a + c1440g.f1264a, this.f1265b + c1440g.f1265b, this.f1266c + c1440g.f1266c);
    }

    public static void m1936b(C1440g c1440g, C1440g c1440g2, C1440g c1440g3) {
        c1440g3.f1264a = c1440g.f1264a - c1440g2.f1264a;
        c1440g3.f1265b = c1440g.f1265b - c1440g2.f1265b;
        c1440g3.f1266c = c1440g.f1266c - c1440g2.f1266c;
    }

    public final C1440g m1959f(C1440g c1440g) {
        return new C1440g(this.f1264a - c1440g.f1264a, this.f1265b - c1440g.f1265b, this.f1266c - c1440g.f1266c);
    }

    public static void m1929a(C1440g c1440g, float f, C1440g c1440g2) {
        c1440g2.f1264a = (int) (((float) c1440g.f1264a) * f);
        c1440g2.f1265b = (int) (((float) c1440g.f1265b) * f);
        c1440g2.f1266c = (int) (((float) c1440g.f1266c) * f);
    }

    public static void m1935b(C1440g c1440g, float f, C1440g c1440g2) {
        float i = c1440g.m1964i();
        c1440g2.f1264a = (int) ((((float) c1440g.f1264a) * f) / i);
        c1440g2.f1265b = (int) ((((float) c1440g.f1265b) * f) / i);
        c1440g2.f1266c = (int) ((((float) c1440g.f1266c) * f) / i);
    }

    public static float m1921a(C1440g c1440g, C1440g c1440g2) {
        return ((((float) c1440g.f1264a) * ((float) c1440g2.f1264a)) + (((float) c1440g.f1265b) * ((float) c1440g2.f1265b))) + (((float) c1440g.f1266c) * ((float) c1440g2.f1266c));
    }

    public final C1440g m1961g(C1440g c1440g) {
        C1440g c1440g2 = new C1440g();
        long j = (long) this.f1264a;
        long j2 = (long) this.f1265b;
        long j3 = (long) this.f1266c;
        long j4 = (long) c1440g.f1264a;
        long j5 = (long) c1440g.f1265b;
        long j6 = (long) c1440g.f1266c;
        c1440g2.f1264a = (int) ((j2 * j6) - (j3 * j5));
        c1440g2.f1265b = (int) ((j3 * j4) - (j6 * j));
        c1440g2.f1266c = (int) ((j * j5) - (j2 * j4));
        return c1440g2;
    }

    public static void m1930a(C1440g c1440g, C1440g c1440g2, float f, C1440g c1440g3) {
        c1440g3.f1264a = ((int) (((float) (c1440g2.f1264a - c1440g.f1264a)) * f)) + c1440g.f1264a;
        c1440g3.f1265b = ((int) (((float) (c1440g2.f1265b - c1440g.f1265b)) * f)) + c1440g.f1265b;
        c1440g3.f1266c = ((int) (((float) (c1440g2.f1266c - c1440g.f1266c)) * f)) + c1440g.f1266c;
    }

    public final C1440g m1942a(C1440g c1440g, float f) {
        C1440g c1440g2 = new C1440g();
        C1440g.m1930a(this, c1440g, f, c1440g2);
        return c1440g2;
    }

    public static float m1938c(C1440g c1440g, C1440g c1440g2, C1440g c1440g3) {
        float f = (float) (c1440g2.f1264a - c1440g.f1264a);
        float f2 = (float) (c1440g2.f1265b - c1440g.f1265b);
        float f3 = (float) (c1440g2.f1266c - c1440g.f1266c);
        return (((((float) (c1440g3.f1264a - c1440g.f1264a)) * f) + (((float) (c1440g3.f1265b - c1440g.f1265b)) * f2)) + (f3 * ((float) (c1440g3.f1266c - c1440g.f1266c)))) / (((f * f) + (f2 * f2)) + (f3 * f3));
    }

    public static float m1922a(C1440g c1440g, C1440g c1440g2, C1440g c1440g3, C1440g c1440g4) {
        float c = C1440g.m1938c(c1440g, c1440g2, c1440g3);
        if (c <= 0.0f) {
            c1440g4.m1950b(c1440g);
        } else if (c >= 1.0f) {
            c1440g4.m1950b(c1440g2);
        } else {
            C1440g.m1930a(c1440g, c1440g2, c, c1440g4);
        }
        return c1440g3.m1954d(c1440g4);
    }

    public static boolean m1940e(int i, int i2) {
        return i < -536870912 || i >= 536870912 || i2 < -536870912 || i2 >= 536870912;
    }

    public static int m1933b(int i) {
        int i2 = i;
        while (i2 < -536870912) {
            i2 += 1073741824;
        }
        while (i2 >= 536870912) {
            i2 -= 1073741824;
        }
        return i2;
    }

    public final void m1963h(C1440g c1440g) {
        int i = -536870912;
        c1440g.f1264a = C1440g.m1933b(this.f1264a);
        int i2 = this.f1265b;
        if (i2 >= -536870912) {
            i = i2 >= 536870912 ? 536870911 : i2;
        }
        c1440g.f1265b = i;
        c1440g.f1266c = this.f1266c;
    }

    public final void m1947a(C1440g c1440g, float f, float f2) {
        c1440g.f1264a = C1440g.m1933b(this.f1264a);
        int ceil = 536870912 - ((int) Math.ceil((double) ((0.5f * f2) * C1435c.m1880a(f))));
        if (ceil < 0) {
            ceil = 0;
        }
        if (this.f1265b > ceil) {
            c1440g.f1265b = ceil;
        } else if (this.f1265b < (-ceil)) {
            c1440g.f1265b = -ceil;
        } else {
            c1440g.f1265b = this.f1265b;
        }
        c1440g.f1266c = this.f1266c;
    }

    public final void m1965i(C1440g c1440g) {
        c1440g.f1264a = C1440g.m1933b(this.f1264a);
        c1440g.f1265b = this.f1265b;
        c1440g.f1266c = this.f1266c;
    }

    public final String toString() {
        return "(" + this.f1264a + "," + this.f1265b + "," + this.f1266c + ")";
    }

    public final String m1966j() {
        return String.format(Locale.US, "%f,%f", new Object[]{Double.valueOf(m1949b()), Double.valueOf(m1953d())});
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C1440g)) {
            return false;
        }
        C1440g c1440g = (C1440g) obj;
        if (this.f1264a == c1440g.f1264a && this.f1265b == c1440g.f1265b && this.f1266c == c1440g.f1266c) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f1264a;
        int i2 = this.f1265b;
        int i3 = this.f1266c;
        i = ((i - i2) - i3) ^ (i3 >> 13);
        i2 = ((i2 - i3) - i) ^ (i << 8);
        i3 = ((i3 - i) - i2) ^ (i2 >> 13);
        i = ((i - i2) - i3) ^ (i3 >> 12);
        i2 = ((i2 - i3) - i) ^ (i << 16);
        i3 = ((i3 - i) - i2) ^ (i2 >> 5);
        i = ((i - i2) - i3) ^ (i3 >> 3);
        i2 = ((i2 - i3) - i) ^ (i << 10);
        return ((i3 - i) - i2) ^ (i2 >> 15);
    }
}
