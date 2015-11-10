package com.google.android.gcm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class GCMBroadcastReceiver extends BroadcastReceiver {
    private static boolean f750a;

    static {
        f750a = false;
    }

    public final void onReceive(Context context, Intent intent) {
        String name;
        Log.v("GCMBroadcastReceiver", "onReceive: " + intent.getAction());
        if (!f750a) {
            f750a = true;
            name = getClass().getName();
            if (!name.equals(GCMBroadcastReceiver.class.getName())) {
                C0707a.m988a(name);
            }
        }
        name = m981a(context);
        Log.v("GCMBroadcastReceiver", "GCM IntentService class: " + name);
        GCMBaseIntentService.m971a(context, intent, name);
        setResult(-1, null, null);
    }

    protected String m981a(Context context) {
        return m980b(context);
    }

    static final String m980b(Context context) {
        return context.getPackageName() + ".GCMIntentService";
    }
}
