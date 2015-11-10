package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.util.Log;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.zzx;
import java.util.HashMap;
import java.util.Map;

public final class zzot implements ActivityLifecycleCallbacks {
    private final zzoj zzaIR;
    private final Map<Activity, zzoq> zzaIS;

    public zzot(zzoj com_google_android_gms_internal_zzoj) {
        zzx.zzv(com_google_android_gms_internal_zzoj);
        this.zzaIR = com_google_android_gms_internal_zzoj;
        this.zzaIS = new HashMap();
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (bundle != null) {
            Bundle bundle2 = bundle.getBundle("com.google.android.gms.measurement.screen_view");
            if (bundle2 != null) {
                int i = bundle2.getInt(ShareConstants.WEB_DIALOG_PARAM_ID);
                if (i <= 0) {
                    Log.w("com.google.android.gms.measurement.internal.ActivityLifecycleTracker", "Invalid screenId in saved activity state");
                    return;
                }
                zzoq zza = zza(activity, i);
                zza.setScreenName(bundle2.getString(ShareConstants.WEB_DIALOG_PARAM_NAME));
                zza.zzhT(bundle2.getInt("referrer_id"));
                zza.zzdU(bundle2.getString("referrer_name"));
                zza.zzam(bundle2.getBoolean("interstitial"));
                zza.zzxX();
            }
        }
    }

    public void onActivityDestroyed(Activity activity) {
        this.zzaIS.remove(activity);
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        if (bundle != null) {
            zzoq com_google_android_gms_internal_zzoq = (zzoq) this.zzaIS.get(activity);
            if (com_google_android_gms_internal_zzoq != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putInt(ShareConstants.WEB_DIALOG_PARAM_ID, com_google_android_gms_internal_zzoq.zzbp());
                bundle2.putString(ShareConstants.WEB_DIALOG_PARAM_NAME, com_google_android_gms_internal_zzoq.zzxT());
                bundle2.putInt("referrer_id", com_google_android_gms_internal_zzoq.zzxU());
                bundle2.putString("referrer_name", com_google_android_gms_internal_zzoq.zzxV());
                bundle2.putBoolean("interstitial", com_google_android_gms_internal_zzoq.zzxY());
                bundle.putBundle("com.google.android.gms.measurement.screen_view", bundle2);
            }
        }
    }

    public void onActivityStarted(Activity activity) {
        this.zzaIR.zzb(zza(activity, 0), activity);
    }

    public void onActivityStopped(Activity activity) {
    }

    zzoq zza(Activity activity, int i) {
        zzx.zzv(activity);
        zzoq com_google_android_gms_internal_zzoq = (zzoq) this.zzaIS.get(activity);
        if (com_google_android_gms_internal_zzoq == null) {
            com_google_android_gms_internal_zzoq = i == 0 ? new zzoq(true) : new zzoq(true, i);
            com_google_android_gms_internal_zzoq.setScreenName(activity.getClass().getCanonicalName());
            this.zzaIS.put(activity, com_google_android_gms_internal_zzoq);
        }
        return com_google_android_gms_internal_zzoq;
    }
}
