package com.google.android.m4b.maps.p010n;

import android.os.Build.VERSION;
import com.google.android.m4b.maps.a.a;

/* renamed from: com.google.android.m4b.maps.n.a */
public final class C1488a {
    public static boolean m2315a() {
        return VERSION.SDK_INT >= 14;
    }

    public static boolean m2316b() {
        try {
            return a.a();
        } catch (Exception e) {
            return false;
        }
    }
}
