package com.google.common.collect;

/* renamed from: com.google.common.collect.m */
final class C1856m {
    static int f2503a;

    static int m4276a(int i) {
        return 461845907 * Integer.rotateLeft(-862048943 * i, 15);
    }

    static {
        f2503a = 1073741824;
    }

    static int m4277a(int i, double d) {
        int max = Math.max(i, 2);
        int highestOneBit = Integer.highestOneBit(max);
        if (((double) max) / ((double) highestOneBit) <= d) {
            return highestOneBit;
        }
        highestOneBit <<= 1;
        if (highestOneBit > 0) {
            return highestOneBit;
        }
        return f2503a;
    }
}
