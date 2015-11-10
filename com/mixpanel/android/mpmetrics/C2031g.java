package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.Log;

/* renamed from: com.mixpanel.android.mpmetrics.g */
public class C2031g {
    public static boolean f2854a;
    private static C2031g f2855n;
    private static final Object f2856o;
    private final int f2857b;
    private final int f2858c;
    private final int f2859d;
    private final boolean f2860e;
    private final boolean f2861f;
    private final String f2862g;
    private final String f2863h;
    private final String f2864i;
    private final String f2865j;
    private final String f2866k;
    private final String f2867l;
    private final boolean f2868m;

    static {
        f2854a = false;
        f2856o = new Object();
    }

    public static C2031g m4728a(Context context) {
        synchronized (f2856o) {
            if (f2855n == null) {
                f2855n = C2031g.m4729b(context.getApplicationContext());
            }
        }
        return f2855n;
    }

    C2031g(Bundle bundle) {
        boolean z = true;
        f2854a = bundle.getBoolean("com.mixpanel.android.MPConfig.EnableDebugLogging", false);
        if (bundle.containsKey("com.mixpanel.android.MPConfig.AutoCheckForSurveys")) {
            Log.w("MixpanelAPI.MPConfig", "com.mixpanel.android.MPConfig.AutoCheckForSurveys has been deprecated in favor of com.mixpanel.android.MPConfig.AutoShowMixpanelUpdates. Please update this key as soon as possible.");
        }
        this.f2857b = bundle.getInt("com.mixpanel.android.MPConfig.BulkUploadLimit", 40);
        this.f2858c = bundle.getInt("com.mixpanel.android.MPConfig.FlushInterval", 60000);
        this.f2859d = bundle.getInt("com.mixpanel.android.MPConfig.DataExpiration", 432000000);
        this.f2860e = bundle.getBoolean("com.mixpanel.android.MPConfig.DisableFallback", true);
        boolean z2 = bundle.getBoolean("com.mixpanel.android.MPConfig.AutoCheckForSurveys", true);
        boolean z3 = bundle.getBoolean("com.mixpanel.android.MPConfig.AutoShowMixpanelUpdates", true);
        if (!(z2 && z3)) {
            z = false;
        }
        this.f2868m = z;
        this.f2861f = bundle.getBoolean("com.mixpanel.android.MPConfig.TestMode", false);
        String string = bundle.getString("com.mixpanel.android.MPConfig.EventsEndpoint");
        if (string == null) {
            string = "https://api.mixpanel.com/track?ip=1";
        }
        this.f2862g = string;
        string = bundle.getString("com.mixpanel.android.MPConfig.EventsFallbackEndpoint");
        if (string == null) {
            string = "http://api.mixpanel.com/track?ip=1";
        }
        this.f2863h = string;
        string = bundle.getString("com.mixpanel.android.MPConfig.PeopleEndpoint");
        if (string == null) {
            string = "https://api.mixpanel.com/engage";
        }
        this.f2864i = string;
        string = bundle.getString("com.mixpanel.android.MPConfig.PeopleFallbackEndpoint");
        if (string == null) {
            string = "http://api.mixpanel.com/engage";
        }
        this.f2865j = string;
        string = bundle.getString("com.mixpanel.android.MPConfig.DecideEndpoint");
        if (string == null) {
            string = "https://decide.mixpanel.com/decide";
        }
        this.f2866k = string;
        string = bundle.getString("com.mixpanel.android.MPConfig.DecideFallbackEndpoint");
        if (string == null) {
            string = "http://decide.mixpanel.com/decide";
        }
        this.f2867l = string;
        if (f2854a) {
            Log.d("MixpanelAPI.MPConfig", "Mixpanel configured with:\n    AutoShowMixpanelUpdates " + m4741l() + "\n" + "    BulkUploadLimit " + m4730a() + "\n" + "    FlushInterval " + m4731b() + "\n" + "    DataExpiration " + m4732c() + "\n" + "    DisableFallback " + m4733d() + "\n" + "    EnableDebugLogging " + f2854a + "\n" + "    TestMode " + m4734e() + "\n" + "    EventsEndpoint " + m4735f() + "\n" + "    PeopleEndpoint " + m4736g() + "\n" + "    DecideEndpoint " + m4737h() + "\n" + "    EventsFallbackEndpoint " + m4738i() + "\n" + "    PeopleFallbackEndpoint " + m4739j() + "\n" + "    DecideFallbackEndpoint " + m4740k() + "\n");
        }
    }

    public int m4730a() {
        return this.f2857b;
    }

    public int m4731b() {
        return this.f2858c;
    }

    public int m4732c() {
        return this.f2859d;
    }

    public boolean m4733d() {
        return this.f2860e;
    }

    public boolean m4734e() {
        return this.f2861f;
    }

    public String m4735f() {
        return this.f2862g;
    }

    public String m4736g() {
        return this.f2864i;
    }

    public String m4737h() {
        return this.f2866k;
    }

    public String m4738i() {
        return this.f2863h;
    }

    public String m4739j() {
        return this.f2865j;
    }

    public String m4740k() {
        return this.f2867l;
    }

    public boolean m4741l() {
        return this.f2868m;
    }

    static C2031g m4729b(Context context) {
        String packageName = context.getPackageName();
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(packageName, AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS).metaData;
            if (bundle == null) {
                bundle = new Bundle();
            }
            return new C2031g(bundle);
        } catch (Throwable e) {
            throw new RuntimeException("Can't configure Mixpanel with package name " + packageName, e);
        }
    }
}
