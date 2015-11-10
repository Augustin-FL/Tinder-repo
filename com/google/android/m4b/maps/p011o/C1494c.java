package com.google.android.m4b.maps.p011o;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.google.android.m4b.maps.o.c */
public final class C1494c {
    private static final String[] f1478a;
    private static final String f1479b;

    static {
        String[] strArr = new String[]{"com.google.android.geo.API_KEY", "com.google.android.maps.v2.API_KEY"};
        f1478a = strArr;
        f1479b = strArr[1];
    }

    public static String m2365a(PackageManager packageManager, String str) {
        String str2 = null;
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 64);
            if (!(packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length == 0 || packageInfo.signatures[0] == null)) {
                byte[] toByteArray = packageInfo.signatures[0].toByteArray();
                MessageDigest instance = MessageDigest.getInstance("SHA-1");
                if (instance != null) {
                    toByteArray = instance.digest(toByteArray);
                    if (toByteArray != null) {
                        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
                        StringBuffer stringBuffer = new StringBuffer(toByteArray.length * 2);
                        for (byte b : toByteArray) {
                            stringBuffer.append(cArr[(b >> 4) & 15]);
                            stringBuffer.append(cArr[(b >> 0) & 15]);
                        }
                        str2 = stringBuffer.toString();
                    }
                }
            }
        } catch (NameNotFoundException e) {
        } catch (NoSuchAlgorithmException e2) {
        }
        return str2;
    }

    public static String m2364a(Context context) {
        int i = 0;
        String str = null;
        ApplicationInfo c = C1494c.m2367c(context);
        if (c.metaData != null) {
            String[] strArr = f1478a;
            for (int i2 = 0; i2 < 2; i2++) {
                String str2 = strArr[i2];
                if (c.metaData.containsKey(str2)) {
                    str = c.metaData.getString(str2);
                    i++;
                }
            }
            if (i > 1) {
                throw new RuntimeException("The API key can only be specified once. It is recommended that you use the meta-data tag with the name: " + f1479b + " in the <application> element of AndroidManifest.xml");
            }
        }
        if (str != null) {
            return str;
        }
        throw new RuntimeException("API key not found.  Check that <meta-data android:name=\"" + f1479b + "\" android:value=\"your API key\"/> is in the <application> element of AndroidManifest.xml");
    }

    private static ApplicationInfo m2367c(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        } catch (NameNotFoundException e) {
            throw new AssertionError(e);
        }
    }

    public static PackageInfo m2366b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            throw new AssertionError(e);
        }
    }
}
