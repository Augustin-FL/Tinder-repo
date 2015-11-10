package com.google.common.p024c;

import com.google.common.base.C1650g;
import java.math.BigInteger;

/* renamed from: com.google.common.c.c */
public final class C1664c {
    private static final long[] f1978a;
    private static final int[] f1979b;
    private static final int[] f1980c;

    private static long m3126a(long j) {
        return Long.MIN_VALUE ^ j;
    }

    public static int m3125a(long j, long j2) {
        return C1663b.m3124a(C1664c.m3126a(j), C1664c.m3126a(j2));
    }

    public static long m3130b(long j, long j2) {
        int i = 1;
        if (j2 < 0) {
            if (C1664c.m3125a(j, j2) < 0) {
                return 0;
            }
            return 1;
        } else if (j >= 0) {
            return j / j2;
        } else {
            long j3 = ((j >>> 1) / j2) << 1;
            if (C1664c.m3125a(j - (j3 * j2), j2) < 0) {
                i = 0;
            }
            return ((long) i) + j3;
        }
    }

    public static long m3131c(long j, long j2) {
        if (j2 < 0) {
            if (C1664c.m3125a(j, j2) < 0) {
                return j;
            }
            return j - j2;
        } else if (j >= 0) {
            return j % j2;
        } else {
            long j3 = j - ((((j >>> 1) / j2) << 1) * j2);
            if (C1664c.m3125a(j3, j2) < 0) {
                j2 = 0;
            }
            return j3 - j2;
        }
    }

    public static long m3127a(String str) {
        return C1664c.m3128a(str, 10);
    }

    public static long m3128a(String str, int i) {
        C1650g.m3080a((Object) str);
        if (str.length() == 0) {
            throw new NumberFormatException("empty string");
        } else if (i < 2 || i > 36) {
            throw new NumberFormatException("illegal radix: " + i);
        } else {
            int i2 = f1980c[i] - 1;
            long j = 0;
            int i3 = 0;
            while (i3 < str.length()) {
                int digit = Character.digit(str.charAt(i3), i);
                if (digit == -1) {
                    throw new NumberFormatException(str);
                } else if (i3 <= i2 || !C1664c.m3129a(j, digit, i)) {
                    j = (j * ((long) i)) + ((long) digit);
                    i3++;
                } else {
                    throw new NumberFormatException("Too large for unsigned long: " + str);
                }
            }
            return j;
        }
    }

    private static boolean m3129a(long j, int i, int i2) {
        if (j < 0) {
            return true;
        }
        if (j < f1978a[i2]) {
            return false;
        }
        if (j > f1978a[i2] || i > f1979b[i2]) {
            return true;
        }
        return false;
    }

    static {
        f1978a = new long[37];
        f1979b = new int[37];
        f1980c = new int[37];
        BigInteger bigInteger = new BigInteger("10000000000000000", 16);
        for (int i = 2; i <= 36; i++) {
            f1978a[i] = C1664c.m3130b(-1, (long) i);
            f1979b[i] = (int) C1664c.m3131c(-1, (long) i);
            f1980c[i] = bigInteger.toString(i).length() - 1;
        }
    }
}
