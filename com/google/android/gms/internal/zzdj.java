package com.google.android.gms.internal;

import com.facebook.appevents.AppEventsConstants;
import java.util.Map;

@zzgk
public class zzdj implements zzdg {
    private final zzdk zzxh;

    public zzdj(zzdk com_google_android_gms_internal_zzdk) {
        this.zzxh = com_google_android_gms_internal_zzdk;
    }

    public void zza(zzip com_google_android_gms_internal_zzip, Map<String, String> map) {
        this.zzxh.zzd(AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("transparentBackground")));
    }
}
