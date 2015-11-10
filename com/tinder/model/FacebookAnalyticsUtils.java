package com.tinder.model;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.share.internal.ShareConstants;
import com.facebook.stetho.BuildConfig;
import com.tinder.iap.util.C2770g;
import com.tinder.utils.C3095y;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

public class FacebookAnalyticsUtils {
    private static final Pattern CHARACTERS;
    @Nullable
    private static Set<String> sDebugCounter;
    @Nullable
    private static AppEventsLogger sEventLogger;
    private static String[] sEventsToFilter;
    private static String[] sParamsToFilter;

    static {
        CHARACTERS = Pattern.compile("[^0-9a-z \\-_]", 2);
        sDebugCounter = null;
        sEventsToFilter = new String[]{"Device"};
        sParamsToFilter = new String[]{"uid", "lat", "lon", "ts", "deviceId", "matchId", "otherId", "location", ShareConstants.WEB_DIALOG_PARAM_NAME, "bio", "createTs", ShareConstants.WEB_DIALOG_PARAM_MESSAGE};
        Arrays.sort(sParamsToFilter);
        Arrays.sort(sEventsToFilter);
    }

    private static boolean isParamIgnored(@NonNull String str) {
        return Arrays.binarySearch(sParamsToFilter, str) >= 0;
    }

    private static boolean isEventIgnored(@NonNull String str) {
        return Arrays.binarySearch(sEventsToFilter, str) >= 0;
    }

    public static void trackEvent(@NonNull String str) {
        if (!isEventIgnored(str) && sEventLogger != null) {
            sEventLogger.logEvent(getStringName(str));
        }
    }

    public static void trackFromSparksEvent(@NonNull SparksEvent sparksEvent) {
        if (!isEventIgnored(sparksEvent.getName())) {
            Bundle convertParameters = convertParameters(sparksEvent.getParams());
            if (sEventLogger != null) {
                sEventLogger.logEvent(getStringName(sparksEvent.getName()), convertParameters);
            }
        }
    }

    private static String getStringName(@NonNull String str) {
        String replaceAll = CHARACTERS.matcher(str).replaceAll(BuildConfig.FLAVOR);
        if (replaceAll.length() > 40) {
            return replaceAll.substring(0, 39);
        }
        return replaceAll;
    }

    public static void setup(@NonNull Context context) {
        sEventLogger = AppEventsLogger.newLogger(context);
    }

    public static void flush() {
        if (sEventLogger != null) {
            sEventLogger.flush();
        }
    }

    public static void activate(@NonNull Activity activity) {
        AppEventsLogger.activateApp(activity);
    }

    public static void deactivate(@NonNull Activity activity) {
        AppEventsLogger.deactivateApp(activity);
        flush();
    }

    public static void logPurchase(@NonNull C2770g c2770g, @NonNull Bundle bundle) {
        if (sEventLogger != null) {
            sEventLogger.logPurchase(BigDecimal.valueOf((double) c2770g.m7890d()), Currency.getInstance(c2770g.m7886a()), bundle);
        }
    }

    @NonNull
    private static Bundle convertParameters(@NonNull HashMap<String, Object> hashMap) {
        Bundle bundle = new Bundle();
        for (Entry entry : hashMap.entrySet()) {
            Object value = entry.getValue();
            String str = (String) entry.getKey();
            if (!(isParamIgnored(str) || value == null)) {
                String stringName = getStringName(str);
                if (value instanceof String) {
                    bundle.putString(stringName, (String) value);
                } else if (value instanceof Integer) {
                    bundle.putString(stringName, Integer.toString(((Integer) value).intValue()));
                } else if (value instanceof Double) {
                    bundle.putString(stringName, Double.toString(((Double) value).doubleValue()));
                } else if (value instanceof Long) {
                    bundle.putString(stringName, Long.toString(((Long) value).longValue()));
                } else if (value instanceof Short) {
                    bundle.putString(stringName, Short.toString(((Short) value).shortValue()));
                } else if (value instanceof Byte) {
                    bundle.putString(stringName, Byte.toString(((Byte) value).byteValue()));
                } else if (value instanceof Float) {
                    bundle.putString(stringName, Float.toString(((Float) value).floatValue()));
                } else if (value instanceof Boolean) {
                    bundle.putString(stringName, Boolean.toString(((Boolean) value).booleanValue()));
                } else {
                    C3095y.m9476b("Not including parameter because it's not a simple type: '" + str + "' ('" + stringName + "') , with value: '" + value.toString() + '\'');
                }
            }
        }
        return bundle;
    }
}
