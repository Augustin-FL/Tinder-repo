package com.google.android.m4b.maps.p012p;

import android.app.ActivityManager;
import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;

/* renamed from: com.google.android.m4b.maps.p.a */
public final class C1546a {
    public static boolean m2719a(Context context) {
        return ((ActivityManager) context.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion >= AccessibilityNodeInfoCompat.ACTION_SET_SELECTION;
    }
}
