package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.reward.client.zzb.zza;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

public class zzgw extends zza {
    private final Context mContext;
    private final zzgx zzGf;
    private final VersionInfoParcel zzpa;
    private final Object zzpc;

    public zzgw(Context context, zzeh com_google_android_gms_internal_zzeh, VersionInfoParcel versionInfoParcel) {
        this.mContext = context;
        this.zzpa = versionInfoParcel;
        this.zzGf = new zzgx(context, AdSizeParcel.zzcB(), com_google_android_gms_internal_zzeh, versionInfoParcel);
        this.zzpc = new Object();
    }

    public void destroy() {
        synchronized (this.zzpc) {
            this.zzGf.destroy();
        }
    }

    public boolean isLoaded() {
        boolean isLoaded;
        synchronized (this.zzpc) {
            isLoaded = this.zzGf.isLoaded();
        }
        return isLoaded;
    }

    public void pause() {
        synchronized (this.zzpc) {
            this.zzGf.pause();
        }
    }

    public void resume() {
        synchronized (this.zzpc) {
            this.zzGf.resume();
        }
    }

    public void setUserId(String str) {
        synchronized (this.zzpc) {
            this.zzGf.setUserId(str);
        }
    }

    public void show() {
        synchronized (this.zzpc) {
            this.zzGf.zzfO();
        }
    }

    public void zza(RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel) {
        synchronized (this.zzpc) {
            this.zzGf.zza(rewardedVideoAdRequestParcel);
        }
    }

    public void zza(zzd com_google_android_gms_ads_internal_reward_client_zzd) {
        synchronized (this.zzpc) {
            this.zzGf.zza(com_google_android_gms_ads_internal_reward_client_zzd);
        }
    }
}
