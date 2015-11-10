package com.google.android.m4b.maps.ay;

/* renamed from: com.google.android.m4b.maps.ay.i */
public final class C1442i {
    public static int m1988a(C1440g c1440g, C1440g c1440g2, C1440g c1440g3) {
        long j = (((long) (c1440g3.f1264a - c1440g.f1264a)) * ((long) (c1440g3.f1265b - c1440g2.f1265b))) - (((long) (c1440g3.f1265b - c1440g.f1265b)) * ((long) (c1440g3.f1264a - c1440g2.f1264a)));
        return (int) (((long) (j != 0 ? 1 : 0)) | (j >> 63));
    }

    public static boolean m1991a(C1440g c1440g, C1440g c1440g2, C1440g c1440g3, C1440g c1440g4) {
        int i = c1440g2.f1264a - c1440g.f1264a;
        int i2 = c1440g2.f1265b - c1440g.f1265b;
        int i3 = c1440g4.f1264a - c1440g3.f1264a;
        int i4 = c1440g4.f1265b - c1440g3.f1265b;
        int i5 = c1440g3.f1264a - c1440g.f1264a;
        int i6 = c1440g3.f1265b - c1440g.f1265b;
        long j = (((long) i3) * ((long) i2)) - (((long) i4) * ((long) i));
        if (j != 0) {
            double d = ((double) ((((long) i) * ((long) i6)) + (((long) (-i5)) * ((long) i2)))) / ((double) j);
            if (d < 0.0d || d > 1.0d) {
                return false;
            }
            d = ((double) ((((long) i5) * ((long) i4)) - (((long) i3) * ((long) i6)))) / ((double) (-j));
            return d >= 0.0d && d <= 1.0d;
        } else if (i5 == 0 && i6 == 0) {
            return true;
        } else {
            if ((((long) i5) * ((long) i2)) - (((long) i6) * ((long) i)) != 0) {
                return false;
            }
            if (i == 0 && i2 == 0) {
                return C1442i.m1999f(c1440g3, c1440g4, c1440g);
            }
            if (i3 == 0 && i4 == 0) {
                return C1442i.m1999f(c1440g, c1440g2, c1440g3);
            }
            return C1442i.m1999f(c1440g, c1440g2, c1440g3) || C1442i.m1999f(c1440g, c1440g2, c1440g4) || C1442i.m1999f(c1440g3, c1440g4, c1440g) || C1442i.m1999f(c1440g3, c1440g4, c1440g2);
        }
    }

    public static boolean m1992a(C1440g c1440g, C1440g c1440g2, C1440g c1440g3, C1440g c1440g4, C1440g c1440g5) {
        int i = c1440g.f1265b - c1440g2.f1265b;
        int i2 = c1440g2.f1264a - c1440g.f1264a;
        long j = (((long) (c1440g4.f1264a - c1440g3.f1264a)) * ((long) i)) + (((long) (c1440g4.f1265b - c1440g3.f1265b)) * ((long) i2));
        if (j != 0) {
            double d = ((double) ((((long) i2) * ((long) (c1440g.f1265b - c1440g3.f1265b))) + (((long) (c1440g.f1264a - c1440g3.f1264a)) * ((long) i)))) / ((double) j);
            if (d < 0.0d || d > 1.0d) {
                return false;
            }
            c1440g5.f1264a = (int) (((double) c1440g3.f1264a) + (((double) (c1440g4.f1264a - c1440g3.f1264a)) * d));
            c1440g5.f1265b = (int) ((d * ((double) (c1440g4.f1265b - c1440g3.f1265b))) + ((double) c1440g3.f1265b));
            return true;
        } else if (C1442i.m1988a(c1440g, c1440g2, c1440g3) == 0) {
            c1440g5.m1950b(c1440g3);
            return true;
        } else if (C1442i.m1988a(c1440g, c1440g2, c1440g4) != 0) {
            return false;
        } else {
            c1440g5.m1950b(c1440g4);
            return true;
        }
    }

    public static boolean m1994b(C1440g c1440g, C1440g c1440g2, C1440g c1440g3) {
        int i = c1440g.f1264a;
        int i2 = c1440g.f1265b;
        int i3 = c1440g2.f1264a;
        int i4 = c1440g2.f1265b;
        int i5 = c1440g3.f1264a;
        int i6 = c1440g3.f1265b;
        if (i2 <= i6 && i4 <= i6) {
            return false;
        }
        if (i5 >= i && i5 >= i3) {
            return false;
        }
        if (i5 < i && i5 < i3) {
            return false;
        }
        if (i3 >= i) {
            if (((long) (i5 - i)) * ((long) (i4 - i2)) > ((long) (i3 - i)) * ((long) (i6 - i2))) {
                return true;
            }
            return false;
        }
        if (((long) (i5 - i)) * ((long) (i4 - i2)) < ((long) (i3 - i)) * ((long) (i6 - i2))) {
            return true;
        }
        return false;
    }

    public static void m1996c(C1440g c1440g, C1440g c1440g2, C1440g c1440g3) {
        c1440g3.f1264a = c1440g.f1264a + c1440g2.f1264a;
        c1440g3.f1265b = c1440g.f1265b + c1440g2.f1265b;
    }

    public static void m1997d(C1440g c1440g, C1440g c1440g2, C1440g c1440g3) {
        c1440g3.f1264a = c1440g.f1264a - c1440g2.f1264a;
        c1440g3.f1265b = c1440g.f1265b - c1440g2.f1265b;
    }

    public static void m1998e(C1440g c1440g, C1440g c1440g2, C1440g c1440g3) {
        c1440g3.f1264a = (c1440g.f1264a / 2) + (c1440g2.f1264a / 2);
        c1440g3.f1265b = (c1440g.f1265b / 2) + (c1440g2.f1265b / 2);
    }

    public static void m1989a(C1440g c1440g, float f, C1440g c1440g2) {
        float hypot = (float) Math.hypot((double) c1440g.f1264a, (double) c1440g.f1265b);
        if (hypot == 0.0f) {
            c1440g2.f1264a = (int) f;
            c1440g2.f1265b = 0;
            return;
        }
        hypot = f / hypot;
        c1440g2.f1264a = (int) (((float) (-c1440g.f1265b)) * hypot);
        c1440g2.f1265b = (int) (hypot * ((float) c1440g.f1264a));
    }

    public static void m1990a(C1440g c1440g, C1440g c1440g2) {
        c1440g2.f1264a = -c1440g.f1265b;
        c1440g2.f1265b = c1440g.f1264a;
    }

    public static float m1993b(C1440g c1440g, C1440g c1440g2) {
        return C1442i.m1987a(c1440g2.f1264a - c1440g.f1264a, c1440g2.f1265b - c1440g.f1265b);
    }

    public static float m1987a(int i, int i2) {
        float atan2 = 90.0f - ((float) ((Math.atan2((double) i2, (double) i) * 180.0d) / 3.141592653589793d));
        if (atan2 < 0.0f) {
            return atan2 + 360.0f;
        }
        return atan2;
    }

    public static long m1995c(C1440g c1440g, C1440g c1440g2) {
        return (((long) c1440g.f1264a) * ((long) c1440g2.f1265b)) - (((long) c1440g.f1265b) * ((long) c1440g2.f1264a));
    }

    private static boolean m1999f(C1440g c1440g, C1440g c1440g2, C1440g c1440g3) {
        long j = (long) (c1440g2.f1264a - c1440g.f1264a);
        long j2 = (long) (c1440g2.f1265b - c1440g.f1265b);
        long j3 = (((long) (c1440g3.f1264a - c1440g.f1264a)) * j) + (((long) (c1440g3.f1265b - c1440g.f1265b)) * j2);
        return j3 >= 0 && j3 <= (j * j) + (j2 * j2);
    }
}
