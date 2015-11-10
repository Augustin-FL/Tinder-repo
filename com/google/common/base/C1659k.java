package com.google.common.base;

import com.facebook.stetho.BuildConfig;

/* renamed from: com.google.common.base.k */
public final class C1659k {
    public static String m3118a(String str) {
        return str == null ? BuildConfig.FLAVOR : str;
    }

    public static boolean m3119b(String str) {
        return str == null || str.length() == 0;
    }
}
