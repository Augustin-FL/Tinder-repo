package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.Log;
import com.mixpanel.android.surveys.SurveyActivity;

/* renamed from: com.mixpanel.android.mpmetrics.c */
class C2020c {
    public static String f2826a;

    static {
        f2826a = "MixpanelAPI.ConfigurationChecker";
    }

    public static boolean m4704a(Context context) {
        if (VERSION.SDK_INT < 14) {
            return false;
        }
        Intent intent = new Intent(context, SurveyActivity.class);
        intent.addFlags(268435456);
        intent.addFlags(AccessibilityNodeInfoCompat.ACTION_SET_SELECTION);
        if (context.getPackageManager().queryIntentActivities(intent, 0).size() != 0) {
            return true;
        }
        Log.w(f2826a, SurveyActivity.class.getName() + " is not registered as an activity in your application, so surveys can't be shown.");
        Log.i(f2826a, "Please add the child tag <activity android:name=\"com.mixpanel.android.surveys.SurveyActivity\" /> to your <application> tag.");
        return false;
    }
}
