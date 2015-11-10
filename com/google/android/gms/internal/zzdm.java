package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zze;
import java.util.HashMap;
import java.util.Map;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

@zzgk
public class zzdm implements zzdg {
    static final Map<String, Integer> zzxl;
    private final zze zzxj;
    private final zzew zzxk;

    static {
        zzxl = new HashMap();
        zzxl.put("resize", Integer.valueOf(1));
        zzxl.put("playVideo", Integer.valueOf(2));
        zzxl.put("storePicture", Integer.valueOf(3));
        zzxl.put("createCalendarEvent", Integer.valueOf(4));
        zzxl.put("setOrientationProperties", Integer.valueOf(5));
        zzxl.put("closeResizedAd", Integer.valueOf(6));
    }

    public zzdm(zze com_google_android_gms_ads_internal_zze, zzew com_google_android_gms_internal_zzew) {
        this.zzxj = com_google_android_gms_ads_internal_zze;
        this.zzxk = com_google_android_gms_internal_zzew;
    }

    public void zza(zzip com_google_android_gms_internal_zzip, Map<String, String> map) {
        int intValue = ((Integer) zzxl.get((String) map.get("a"))).intValue();
        if (intValue == 5 || this.zzxj == null || this.zzxj.zzbe()) {
            switch (intValue) {
                case C3374b.SmoothProgressBar_spb_color /*1*/:
                    this.zzxk.zzg(map);
                    return;
                case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                    new zzey(com_google_android_gms_internal_zzip, map).execute();
                    return;
                case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                    new zzev(com_google_android_gms_internal_zzip, map).execute();
                    return;
                case C3374b.SmoothProgressBar_spb_speed /*5*/:
                    new zzex(com_google_android_gms_internal_zzip, map).execute();
                    return;
                case C3374b.SmoothProgressBar_spb_progressiveStart_speed /*6*/:
                    this.zzxk.zzn(true);
                    return;
                default:
                    zzb.zzaD("Unknown MRAID command called.");
                    return;
            }
        }
        this.zzxj.zzp(null);
    }
}
