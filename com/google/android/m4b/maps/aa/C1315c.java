package com.google.android.m4b.maps.aa;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;

/* renamed from: com.google.android.m4b.maps.aa.c */
public final class C1315c {
    private static int f765b;
    private static int f766c;
    private static final C1315c[] f767d;
    private final int f768a;

    static {
        int i = 1;
        f765b = 1;
        f766c = 22;
        f767d = new C1315c[22];
        int i2 = AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
        while (i <= 22) {
            f767d[i - 1] = new C1315c(i, i2);
            i2 *= 2;
            i++;
        }
    }

    private C1315c(int i, int i2) {
        this.f768a = i2;
    }

    public static C1315c m1023a(int i) {
        if (22 < f765b) {
            return null;
        }
        if (22 > f766c) {
            i = f766c;
        }
        return f767d[i - 1];
    }

    public final int m1024a() {
        return this.f768a;
    }

    public final String toString() {
        return super.toString();
    }
}
