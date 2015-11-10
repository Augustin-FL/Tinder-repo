package com.facebook.stetho.common;

import java.util.Locale;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class LogUtil {
    private static final String TAG = "stetho";

    public static void m936e(String str, Object... objArr) {
        m935e(format(str, objArr));
    }

    public static void m938e(Throwable th, String str, Object... objArr) {
        m937e(th, format(str, objArr));
    }

    public static void m935e(String str) {
        if (isLoggable(6)) {
            LogRedirector.m923e(TAG, str);
        }
    }

    public static void m937e(Throwable th, String str) {
        if (isLoggable(6)) {
            LogRedirector.m924e(TAG, str, th);
        }
    }

    public static void m948w(String str, Object... objArr) {
        m947w(format(str, objArr));
    }

    public static void m950w(Throwable th, String str, Object... objArr) {
        m949w(th, format(str, objArr));
    }

    public static void m947w(String str) {
        if (isLoggable(5)) {
            LogRedirector.m929w(TAG, str);
        }
    }

    public static void m949w(Throwable th, String str) {
        if (isLoggable(5)) {
            LogRedirector.m930w(TAG, str, th);
        }
    }

    public static void m940i(String str, Object... objArr) {
        m939i(format(str, objArr));
    }

    public static void m942i(Throwable th, String str, Object... objArr) {
        m941i(th, format(str, objArr));
    }

    public static void m939i(String str) {
        if (isLoggable(4)) {
            LogRedirector.m925i(TAG, str);
        }
    }

    public static void m941i(Throwable th, String str) {
        if (isLoggable(4)) {
            LogRedirector.m926i(TAG, str, th);
        }
    }

    public static void m932d(String str, Object... objArr) {
        m931d(format(str, objArr));
    }

    public static void m934d(Throwable th, String str, Object... objArr) {
        m933d(th, format(str, objArr));
    }

    public static void m931d(String str) {
        if (isLoggable(3)) {
            LogRedirector.m921d(TAG, str);
        }
    }

    public static void m933d(Throwable th, String str) {
        if (isLoggable(3)) {
            LogRedirector.m922d(TAG, str, th);
        }
    }

    public static void m944v(String str, Object... objArr) {
        m943v(format(str, objArr));
    }

    public static void m946v(Throwable th, String str, Object... objArr) {
        m945v(th, format(str, objArr));
    }

    public static void m943v(String str) {
        if (isLoggable(2)) {
            LogRedirector.m927v(TAG, str);
        }
    }

    public static void m945v(Throwable th, String str) {
        if (isLoggable(2)) {
            LogRedirector.m928v(TAG, str, th);
        }
    }

    private static String format(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static boolean isLoggable(int i) {
        switch (i) {
            case C3374b.SmoothProgressBar_spb_speed /*5*/:
            case C3374b.SmoothProgressBar_spb_progressiveStart_speed /*6*/:
                return true;
            default:
                return LogRedirector.isLoggable(TAG, i);
        }
    }
}
