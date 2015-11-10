package com.google.android.m4b.maps.p010n;

import android.os.Build;
import android.os.Build.VERSION;
import com.facebook.stetho.BuildConfig;
import java.util.Arrays;

/* renamed from: com.google.android.m4b.maps.n.b */
public final class C1489b {
    public static boolean f1447a;
    public static final boolean f1448b;
    public static final boolean f1449c;
    public static final boolean f1450d;
    private static final String[] f1451e;
    private static final String[] f1452f;
    private static final String[] f1453g;
    private static final String[] f1454h;
    private static final String[] f1455i;
    private static final String[] f1456j;
    private static final String[] f1457k;
    private static final String[] f1458l;
    private static final String[] f1459m;
    private static final String[] f1460n;
    private static volatile String f1461o;
    private static boolean f1462p;

    static {
        Object obj;
        boolean z = true;
        f1451e = new String[]{"SOJU", "SOJUA", "SOJUK", "SOJU_L10N", "GT-I9000", "GT-I9000B", "GT-I9000M", "GT-I9000T", "SC-02B", "SGH-T959", "SGH-T959D", "SGH-T959V", "VIBRANT T959", "SHW-M110S", "SCH-I400", "SGH-I897", "SGH-I896"};
        f1452f = new String[]{"RTGB", "SHADOW_VZW", "DAYTONA"};
        f1453g = new String[]{"SHADOW_VZW", "DAYTONA", "SPYDER_VZW"};
        f1454h = new String[]{"SHADOW", "DAYTONA", "SPYDER"};
        f1455i = new String[]{"HTC_VISION"};
        f1456j = new String[]{"HTC_MARVEL", "HTC_MARVELC", "MARVELC"};
        f1457k = new String[]{"PASSION", "PASSION_KT", "PASSION_VF"};
        f1458l = new String[]{"HTC_PYRAMID", "HTC_VIGOR"};
        f1459m = new String[]{"SONY ERICSSON"};
        f1460n = new String[]{"TG03", "F11EIF"};
        Object toUpperCase = Build.PRODUCT == null ? BuildConfig.FLAVOR : Build.PRODUCT.toUpperCase();
        Object toUpperCase2 = Build.BOARD == null ? BuildConfig.FLAVOR : Build.BOARD.toUpperCase();
        if (Build.MANUFACTURER == null) {
            obj = BuildConfig.FLAVOR;
        } else {
            obj = Build.MANUFACTURER.toUpperCase();
        }
        if (!Arrays.asList(f1451e).contains(toUpperCase) || C1488a.m2315a()) {
            z = false;
        }
        f1447a = z;
        Arrays.asList(f1455i).contains(toUpperCase);
        f1448b = Arrays.asList(f1452f).contains(toUpperCase);
        if (VERSION.SDK_INT == 10 && !Arrays.asList(f1453g).contains(toUpperCase)) {
            Arrays.asList(f1454h).contains(toUpperCase2);
        }
        Arrays.asList(f1459m).contains(obj);
        f1449c = Arrays.asList(f1456j).contains(toUpperCase);
        f1450d = Arrays.asList(f1457k).contains(toUpperCase);
        Arrays.asList(f1458l).contains(toUpperCase);
        Arrays.asList(f1460n).contains(toUpperCase);
    }

    public static void m2317a(String str) {
        f1461o = str;
    }

    public static void m2318a(boolean z) {
        f1462p = z;
    }

    public static boolean m2319a() {
        return f1462p;
    }
}
