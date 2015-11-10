package com.tinder.gcm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.google.android.gcm.C0707a;
import com.tinder.GCMIntentService;

public class RegPushServerReceiver extends BroadcastReceiver {
    public void onReceive(@NonNull Context context, Intent intent) {
        GCMIntentService.m5884e(context, C0707a.m994f(context));
    }
}
