package com.google.android.gms.common.internal;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.GooglePlayServicesUtil;

public class zzn {
    private static final Uri zzaef;
    private static final Uri zzaeg;

    static {
        zzaef = Uri.parse("http://plus.google.com/");
        zzaeg = zzaef.buildUpon().appendPath("circles").appendPath("find").build();
    }

    public static Intent zzcn(String str) {
        Uri fromParts = Uri.fromParts("package", str, null);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(fromParts);
        return intent;
    }

    private static Uri zzco(String str) {
        return Uri.parse("market://details").buildUpon().appendQueryParameter(ShareConstants.WEB_DIALOG_PARAM_ID, str).build();
    }

    public static Intent zzcp(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(zzco(str));
        intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE);
        intent.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        return intent;
    }

    public static Intent zzoM() {
        Intent intent = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
        intent.setPackage("com.google.android.wearable.app");
        return intent;
    }
}