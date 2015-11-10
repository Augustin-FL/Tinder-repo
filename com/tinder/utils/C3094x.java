package com.tinder.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.telephony.TelephonyManager;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.stetho.BuildConfig;
import com.tinder.R;

/* renamed from: com.tinder.utils.x */
public class C3094x {
    public static float m9463a(float f) {
        return 1.60934f * f;
    }

    public static String m9464a(@NonNull Context context) {
        String str = BuildConfig.FLAVOR;
        String str2 = AppEventsConstants.EVENT_PARAM_VALUE_YES;
        String toUpperCase = ((TelephonyManager) context.getSystemService("phone")).getSimCountryIso().toUpperCase();
        String[] stringArray = context.getResources().getStringArray(R.array.country_codes_combined);
        for (String split : stringArray) {
            String[] split2 = split.split(",");
            if (split2[1].trim().equals(toUpperCase.trim())) {
                return split2[0];
            }
        }
        return str2;
    }

    public static String m9466b(@NonNull Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return "0000000000";
        }
        if (telephonyManager.getLine1Number() == null) {
            return "0000000000";
        }
        return telephonyManager.getLine1Number();
    }

    @NonNull
    public static String m9467c(@NonNull Context context) {
        String b = C3094x.m9466b(context);
        if (b == null) {
            return "0000000000";
        }
        return b.substring(Math.max(0, b.length() - 10));
    }

    public static boolean m9465a(@Nullable String str) {
        if (str == null || str.length() <= 0 || str.length() > 11) {
            return false;
        }
        return true;
    }
}
