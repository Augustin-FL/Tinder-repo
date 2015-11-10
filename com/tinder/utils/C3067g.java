package com.tinder.utils;

import android.support.annotation.Nullable;

/* renamed from: com.tinder.utils.g */
public class C3067g {
    public static boolean m9353a(@Nullable String str) {
        if (str == null || str.equals("null")) {
            return true;
        }
        return str.trim().isEmpty();
    }

    public static boolean m9354b(String str) {
        return !C3067g.m9353a(str);
    }
}
