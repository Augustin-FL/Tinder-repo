package com.google.android.m4b.maps.p009m;

import android.support.v7.widget.RecyclerView.SmoothScroller.Action;

/* renamed from: com.google.android.m4b.maps.m.d */
public final class C1487d {
    public static long m2311a(String str) {
        if (C1487d.m2312a(str, 16)) {
            return Long.parseLong(C1487d.m2314c(str), 16) - Long.MIN_VALUE;
        }
        return Long.parseLong(str, 16);
    }

    public static int m2313b(String str) {
        if (C1487d.m2312a(str, 8)) {
            return Integer.parseInt(C1487d.m2314c(str), 16) + Action.UNDEFINED_DURATION;
        }
        return Integer.parseInt(str, 16);
    }

    private static boolean m2312a(String str, int i) {
        if (str.length() != i || Integer.parseInt(String.valueOf(str.charAt(0)), 16) <= 7) {
            return false;
        }
        return true;
    }

    private static String m2314c(String str) {
        return String.valueOf(Integer.parseInt(String.valueOf(str.charAt(0)), 16) - 8) + str.substring(1);
    }
}
