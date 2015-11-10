package com.tinder.utils;

import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.stetho.BuildConfig;
import com.tinder.managers.ManagerApp;
import com.viewpagerindicator.C3169d.C3168f;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.tinder.utils.j */
public class C3071j {
    private static String f6613a;

    public static int m9371a() {
        try {
            return Integer.parseInt(VERSION.SDK);
        } catch (Throwable th) {
            return 1;
        }
    }

    public static String m9372b() {
        if (!TextUtils.isEmpty(f6613a)) {
            return f6613a;
        }
        String deviceId = ((TelephonyManager) ManagerApp.m7917h().getSystemService("phone")).getDeviceId();
        if (deviceId == null) {
            deviceId = BuildConfig.FLAVOR;
        }
        f6613a = deviceId;
        return deviceId;
    }

    public static String m9373c() {
        return Build.MANUFACTURER;
    }

    public static String m9374d() {
        return Build.MODEL;
    }

    public static String m9375e() {
        if (C3071j.m9377g()) {
            return "wifi";
        }
        return ((TelephonyManager) ManagerApp.m7917h().getSystemService("phone")).getNetworkOperatorName();
    }

    @NonNull
    public static String m9376f() {
        return "Android " + VERSION.RELEASE;
    }

    public static boolean m9377g() {
        return ((ConnectivityManager) ManagerApp.m7917h().getSystemService("connectivity")).getNetworkInfo(1).isConnected();
    }

    public static String m9378h() {
        switch (((TelephonyManager) ManagerApp.m7917h().getSystemService("phone")).getNetworkType()) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                return "GPRS";
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                return "EDGE";
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                return "UMTS";
            case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                return "CDMA";
            case C3374b.SmoothProgressBar_spb_speed /*5*/:
                return "EVDO rev. 0";
            case C3374b.SmoothProgressBar_spb_progressiveStart_speed /*6*/:
                return "EVDO rev. A";
            case C3374b.SmoothProgressBar_spb_progressiveStop_speed /*7*/:
                return "1xRTT";
            case C3374b.SmoothProgressBar_spb_interpolator /*8*/:
                return "HSDPA";
            case C3374b.SmoothProgressBar_spb_reversed /*9*/:
                return "HSUPA";
            case C3374b.SmoothProgressBar_spb_mirror_mode /*10*/:
                return "HSPA";
            case C3374b.SmoothProgressBar_spb_colors /*11*/:
                return "iDen";
            case C3374b.SmoothProgressBar_spb_progressiveStart_activated /*12*/:
                return "EVDO rev. B";
            case C3374b.SmoothProgressBar_spb_background /*13*/:
                return "LTE";
            case C3374b.SmoothProgressBar_spb_generate_background_with_colors /*14*/:
                return "eHRPD";
            case C3168f.Toolbar_titleMarginBottom /*15*/:
                return "HSPA+";
            default:
                return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
    }

    public static int m9379i() {
        WifiInfo connectionInfo = ((WifiManager) ManagerApp.m7917h().getSystemService("wifi")).getConnectionInfo();
        if (connectionInfo != null) {
            return connectionInfo.getLinkSpeed();
        }
        return -1;
    }
}
