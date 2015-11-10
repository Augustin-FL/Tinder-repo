package com.mixpanel.android.mpmetrics;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.util.Log;
import com.facebook.internal.NativeProtocol;
import com.facebook.stetho.BuildConfig;
import com.mixpanel.android.mpmetrics.C2042h.C1994a;

public class GCMReceiver extends BroadcastReceiver {
    String f2731a;

    /* renamed from: com.mixpanel.android.mpmetrics.GCMReceiver.1 */
    class C19951 implements C1994a {
        final /* synthetic */ String f2728a;
        final /* synthetic */ GCMReceiver f2729b;

        C19951(GCMReceiver gCMReceiver, String str) {
            this.f2729b = gCMReceiver;
            this.f2728a = str;
        }

        public void m4591a(C2042h c2042h) {
            c2042h.m4788c().m4746a(this.f2728a);
        }
    }

    /* renamed from: com.mixpanel.android.mpmetrics.GCMReceiver.2 */
    class C19962 implements C1994a {
        final /* synthetic */ GCMReceiver f2730a;

        C19962(GCMReceiver gCMReceiver) {
            this.f2730a = gCMReceiver;
        }

        public void m4592a(C2042h c2042h) {
            c2042h.m4788c().m4744a();
        }
    }

    public GCMReceiver() {
        this.f2731a = "MPGCMReceiver";
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
            m4596a(intent);
        } else if ("com.google.android.c2dm.intent.RECEIVE".equals(action)) {
            m4595a(context, intent);
        }
    }

    private void m4596a(Intent intent) {
        String stringExtra = intent.getStringExtra("registration_id");
        if (intent.getStringExtra(NativeProtocol.BRIDGE_ARG_ERROR_BUNDLE) != null) {
            Log.e(this.f2731a, "Error when registering for GCM: " + intent.getStringExtra(NativeProtocol.BRIDGE_ARG_ERROR_BUNDLE));
        } else if (stringExtra != null) {
            if (C2031g.f2854a) {
                Log.d(this.f2731a, "Registering GCM ID: " + stringExtra);
            }
            C2042h.m4773a(new C19951(this, stringExtra));
        } else if (intent.getStringExtra("unregistered") != null) {
            if (C2031g.f2854a) {
                Log.d(this.f2731a, "Unregistering from GCM");
            }
            C2042h.m4773a(new C19962(this));
        }
    }

    private void m4595a(Context context, Intent intent) {
        CharSequence string = intent.getExtras().getString("mp_message");
        if (string != null) {
            if (C2031g.f2854a) {
                Log.d(this.f2731a, "MP GCM notification received: " + string);
            }
            PackageManager packageManager = context.getPackageManager();
            Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(context.getPackageName());
            CharSequence charSequence = BuildConfig.FLAVOR;
            int i = 17301651;
            try {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
                charSequence = packageManager.getApplicationLabel(applicationInfo);
                i = applicationInfo.icon;
            } catch (NameNotFoundException e) {
            }
            PendingIntent activity = PendingIntent.getActivity(context.getApplicationContext(), 0, launchIntentForPackage, 134217728);
            if (VERSION.SDK_INT < 11) {
                m4594a(context, activity, i, charSequence, string);
            } else {
                m4597b(context, activity, i, charSequence, string);
            }
        }
    }

    @TargetApi(8)
    private void m4594a(Context context, PendingIntent pendingIntent, int i, CharSequence charSequence, CharSequence charSequence2) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        Notification notification = new Notification(i, charSequence2, System.currentTimeMillis());
        notification.flags |= 16;
        notification.setLatestEventInfo(context, charSequence, charSequence2, pendingIntent);
        notificationManager.notify(0, notification);
    }

    @TargetApi(11)
    private void m4597b(Context context, PendingIntent pendingIntent, int i, CharSequence charSequence, CharSequence charSequence2) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        Notification a = m4593a(new Builder(context).setSmallIcon(i).setTicker(charSequence2).setWhen(System.currentTimeMillis()).setContentTitle(charSequence).setContentText(charSequence2).setContentIntent(pendingIntent));
        a.flags |= 16;
        notificationManager.notify(0, a);
    }

    @SuppressLint({"NewApi"})
    private Notification m4593a(Builder builder) {
        if (VERSION.SDK_INT < 16) {
            return builder.getNotification();
        }
        return builder.build();
    }
}
