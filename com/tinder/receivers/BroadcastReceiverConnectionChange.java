package com.tinder.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import com.tinder.managers.C2807a;
import com.tinder.managers.ManagerApp;
import com.tinder.model.SparksEvent;
import com.tinder.utils.C3071j;
import com.tinder.utils.C3095y;

public class BroadcastReceiverConnectionChange extends BroadcastReceiver {
    private static int f6486a;

    static {
        f6486a = -1;
    }

    public void onReceive(@NonNull Context context, Intent intent) {
        C3095y.m9471a("Network change");
        if (ManagerApp.m7935z()) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                int type = activeNetworkInfo.getType();
                if (type != f6486a) {
                    SparksEvent sparksEvent = new SparksEvent("Device.ChangeNetwork");
                    if (activeNetworkInfo.getType() == 0) {
                        C3095y.m9471a("Mobile");
                        String h = C3071j.m9378h();
                        C3095y.m9471a("networkTechnology=" + h);
                        sparksEvent.put("networkType", h);
                        C2807a.m8056a(sparksEvent);
                    } else if (activeNetworkInfo.getType() == 1) {
                        C3095y.m9471a("Wifi");
                        sparksEvent.put("networkType", activeNetworkInfo.getTypeName() + ' ' + C3071j.m9379i() + " Mbps");
                        C2807a.m8056a(sparksEvent);
                    }
                    f6486a = type;
                    return;
                }
                C3095y.m9471a("Network type didn't actually change");
            }
        }
    }
}
