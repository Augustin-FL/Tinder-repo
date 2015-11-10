package com.google.android.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.widget.RecyclerView.SmoothScroller.Action;
import android.util.Log;
import com.facebook.stetho.BuildConfig;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.http.protocol.HttpRequestExecutor;

/* renamed from: com.google.android.gcm.a */
public final class C0707a {
    private static GCMBroadcastReceiver f751a;
    private static String f752b;

    public static void m984a(Context context) {
        int i = VERSION.SDK_INT;
        if (i < 8) {
            throw new UnsupportedOperationException("Device must be at least API Level 8 (instead of " + i + ")");
        }
        try {
            context.getPackageManager().getPackageInfo("com.google.android.gsf", 0);
        } catch (NameNotFoundException e) {
            throw new UnsupportedOperationException("Device does not have package com.google.android.gsf");
        }
    }

    public static void m989b(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        String str = packageName + ".permission.C2D_MESSAGE";
        try {
            packageManager.getPermissionInfo(str, AccessibilityNodeInfoCompat.ACTION_SCROLL_FORWARD);
            try {
                ActivityInfo[] activityInfoArr = packageManager.getPackageInfo(packageName, 2).receivers;
                if (activityInfoArr == null || activityInfoArr.length == 0) {
                    throw new IllegalStateException("No receiver for package " + packageName);
                }
                if (Log.isLoggable("GCMRegistrar", 2)) {
                    Log.v("GCMRegistrar", "number of receivers for " + packageName + ": " + activityInfoArr.length);
                }
                Set hashSet = new HashSet();
                for (ActivityInfo activityInfo : activityInfoArr) {
                    if ("com.google.android.c2dm.permission.SEND".equals(activityInfo.permission)) {
                        hashSet.add(activityInfo.name);
                    }
                }
                if (hashSet.isEmpty()) {
                    throw new IllegalStateException("No receiver allowed to receive com.google.android.c2dm.permission.SEND");
                }
                C0707a.m986a(context, hashSet, "com.google.android.c2dm.intent.REGISTRATION");
                C0707a.m986a(context, hashSet, "com.google.android.c2dm.intent.RECEIVE");
            } catch (NameNotFoundException e) {
                throw new IllegalStateException("Could not get receivers for package " + packageName);
            }
        } catch (NameNotFoundException e2) {
            throw new IllegalStateException("Application does not define permission " + str);
        }
    }

    private static void m986a(Context context, Set<String> set, String str) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        Intent intent = new Intent(str);
        intent.setPackage(packageName);
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 32);
        if (queryBroadcastReceivers.isEmpty()) {
            throw new IllegalStateException("No receivers for action " + str);
        }
        if (Log.isLoggable("GCMRegistrar", 2)) {
            Log.v("GCMRegistrar", "Found " + queryBroadcastReceivers.size() + " receivers for action " + str);
        }
        for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
            String str2 = resolveInfo.activityInfo.name;
            if (!set.contains(str2)) {
                throw new IllegalStateException("Receiver " + str2 + " is not set with permission " + "com.google.android.c2dm.permission.SEND");
            }
        }
    }

    public static void m987a(Context context, String... strArr) {
        C0707a.m997i(context);
        C0707a.m990b(context, strArr);
    }

    static void m990b(Context context, String... strArr) {
        String a = C0707a.m983a(strArr);
        Log.v("GCMRegistrar", "Registering app " + context.getPackageName() + " of senders " + a);
        Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
        intent.setPackage("com.google.android.gsf");
        intent.putExtra("app", PendingIntent.getBroadcast(context, 0, new Intent(), 0));
        intent.putExtra("sender", a);
        context.startService(intent);
    }

    static String m983a(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("No senderIds");
        }
        StringBuilder stringBuilder = new StringBuilder(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            stringBuilder.append(',').append(strArr[i]);
        }
        return stringBuilder.toString();
    }

    public static void m991c(Context context) {
        C0707a.m997i(context);
        C0707a.m992d(context);
    }

    static void m992d(Context context) {
        Log.v("GCMRegistrar", "Unregistering app " + context.getPackageName());
        Intent intent = new Intent("com.google.android.c2dm.intent.UNREGISTER");
        intent.setPackage("com.google.android.gsf");
        intent.putExtra("app", PendingIntent.getBroadcast(context, 0, new Intent(), 0));
        context.startService(intent);
    }

    static synchronized void m993e(Context context) {
        synchronized (C0707a.class) {
            if (f751a == null) {
                if (f752b == null) {
                    Log.e("GCMRegistrar", "internal error: retry receiver class not set yet");
                    f751a = new GCMBroadcastReceiver();
                } else {
                    try {
                        f751a = (GCMBroadcastReceiver) Class.forName(f752b).newInstance();
                    } catch (Exception e) {
                        Log.e("GCMRegistrar", "Could not create instance of " + f752b + ". Using " + GCMBroadcastReceiver.class.getName() + " directly.");
                        f751a = new GCMBroadcastReceiver();
                    }
                }
                String packageName = context.getPackageName();
                IntentFilter intentFilter = new IntentFilter("com.google.android.gcm.intent.RETRY");
                intentFilter.addCategory(packageName);
                packageName = packageName + ".permission.C2D_MESSAGE";
                Log.v("GCMRegistrar", "Registering receiver");
                context.registerReceiver(f751a, intentFilter, packageName, null);
            }
        }
    }

    static void m988a(String str) {
        Log.v("GCMRegistrar", "Setting the name of retry receiver class to " + str);
        f752b = str;
    }

    public static String m994f(Context context) {
        SharedPreferences l = C0707a.m1000l(context);
        String string = l.getString("regId", BuildConfig.FLAVOR);
        int i = l.getInt("appVersion", Action.UNDEFINED_DURATION);
        int k = C0707a.m999k(context);
        if (i == Action.UNDEFINED_DURATION || i == k) {
            return string;
        }
        Log.v("GCMRegistrar", "App version changed from " + i + " to " + k + "; resetting registration id");
        C0707a.m996h(context);
        return BuildConfig.FLAVOR;
    }

    public static boolean m995g(Context context) {
        return C0707a.m994f(context).length() > 0;
    }

    static String m996h(Context context) {
        return C0707a.m982a(context, BuildConfig.FLAVOR);
    }

    static String m982a(Context context, String str) {
        SharedPreferences l = C0707a.m1000l(context);
        String string = l.getString("regId", BuildConfig.FLAVOR);
        int k = C0707a.m999k(context);
        Log.v("GCMRegistrar", "Saving regId on app version " + k);
        Editor edit = l.edit();
        edit.putString("regId", str);
        edit.putInt("appVersion", k);
        edit.commit();
        return string;
    }

    private static int m999k(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            throw new RuntimeException("Coult not get package name: " + e);
        }
    }

    static void m997i(Context context) {
        Log.d("GCMRegistrar", "resetting backoff for " + context.getPackageName());
        C0707a.m985a(context, (int) HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE);
    }

    static int m998j(Context context) {
        return C0707a.m1000l(context).getInt("backoff_ms", HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE);
    }

    static void m985a(Context context, int i) {
        Editor edit = C0707a.m1000l(context).edit();
        edit.putInt("backoff_ms", i);
        edit.commit();
    }

    private static SharedPreferences m1000l(Context context) {
        return context.getSharedPreferences("com.google.android.gcm", 0);
    }
}
