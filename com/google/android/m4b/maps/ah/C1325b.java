package com.google.android.m4b.maps.ah;

import android.content.res.Resources;
import android.os.Build.VERSION;
import com.google.android.m4b.maps.C1477h.C1469b;
import com.google.android.m4b.maps.ag.e;
import com.google.android.m4b.maps.bg.i;
import com.google.android.m4b.maps.p010n.C1488a;
import com.google.android.m4b.maps.p012p.C1546a;
import com.google.android.m4b.maps.p013q.C1555g;

/* renamed from: com.google.android.m4b.maps.ah.b */
public final class C1325b {
    private static final C1325b f804a;

    static {
        f804a = new C1325b();
    }

    private C1325b() {
    }

    public static C1325b m1061a() {
        return f804a;
    }

    public static boolean m1063b() {
        return false;
    }

    public static boolean m1062a(Resources resources) {
        return VERSION.SDK_INT >= 11 ? false : resources.getBoolean(C1469b.is_tablet);
    }

    public static String m1064c() {
        return "http://clients4.google.com/glm/mmap/api";
    }

    public final boolean m1070d() {
        if (C1488a.m2316b()) {
            return true;
        }
        return C1546a.m2719a(e.a().l());
    }

    public static boolean m1065e() {
        return false;
    }

    public static boolean m1066f() {
        return C1555g.m2736a().m2724a();
    }

    public static boolean m1067g() {
        return (i.a() == null || i.a().e()) ? false : true;
    }

    public static void m1068h() {
    }

    public static boolean m1069i() {
        return false;
    }
}
