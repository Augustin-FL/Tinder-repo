package com.google.android.gms.internal;

import android.app.Activity;
import android.os.RemoteException;
import com.google.ads.mediation.C0701c;
import com.google.ads.mediation.C0702d;
import com.google.ads.mediation.C0704f;
import com.google.ads.mediation.C0706h;
import com.google.ads.mediation.MediationServerParameters;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzei.zza;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@zzgk
public final class zzes<NETWORK_EXTRAS extends C0706h, SERVER_PARAMETERS extends MediationServerParameters> extends zza {
    private final C0701c<NETWORK_EXTRAS, SERVER_PARAMETERS> zzzc;
    private final NETWORK_EXTRAS zzzd;

    public zzes(C0701c<NETWORK_EXTRAS, SERVER_PARAMETERS> c0701c, NETWORK_EXTRAS network_extras) {
        this.zzzc = c0701c;
        this.zzzd = network_extras;
    }

    private SERVER_PARAMETERS zzb(String str, int i, String str2) throws RemoteException {
        Map hashMap;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    hashMap.put(str3, jSONObject.getString(str3));
                }
            } catch (Throwable th) {
                zzb.zzd("Could not get MediationServerParameters.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class c = this.zzzc.m964c();
        if (c == null) {
            return null;
        }
        MediationServerParameters mediationServerParameters = (MediationServerParameters) c.newInstance();
        mediationServerParameters.m956a(hashMap);
        return mediationServerParameters;
    }

    public void destroy() throws RemoteException {
        try {
            this.zzzc.m962a();
        } catch (Throwable th) {
            zzb.zzd("Could not destroy adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public zzd getView() throws RemoteException {
        if (this.zzzc instanceof C0702d) {
            try {
                return zze.zzx(((C0702d) this.zzzc).m966d());
            } catch (Throwable th) {
                zzb.zzd("Could not get banner view from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzb.zzaE("MediationAdapter is not a MediationBannerAdapter: " + this.zzzc.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public boolean isInitialized() {
        return true;
    }

    public void pause() throws RemoteException {
        throw new RemoteException();
    }

    public void resume() throws RemoteException {
        throw new RemoteException();
    }

    public void showInterstitial() throws RemoteException {
        if (this.zzzc instanceof C0704f) {
            zzb.zzaC("Showing interstitial from adapter.");
            try {
                ((C0704f) this.zzzc).m968d();
            } catch (Throwable th) {
                zzb.zzd("Could not show interstitial from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzb.zzaE("MediationAdapter is not a MediationInterstitialAdapter: " + this.zzzc.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void showVideo() {
    }

    public void zza(AdRequestParcel adRequestParcel, String str) {
    }

    public void zza(zzd com_google_android_gms_dynamic_zzd, AdRequestParcel adRequestParcel, String str, com.google.android.gms.ads.internal.reward.mediation.client.zza com_google_android_gms_ads_internal_reward_mediation_client_zza, String str2) throws RemoteException {
    }

    public void zza(zzd com_google_android_gms_dynamic_zzd, AdRequestParcel adRequestParcel, String str, zzej com_google_android_gms_internal_zzej) throws RemoteException {
        zza(com_google_android_gms_dynamic_zzd, adRequestParcel, str, null, com_google_android_gms_internal_zzej);
    }

    public void zza(zzd com_google_android_gms_dynamic_zzd, AdRequestParcel adRequestParcel, String str, String str2, zzej com_google_android_gms_internal_zzej) throws RemoteException {
        if (this.zzzc instanceof C0704f) {
            zzb.zzaC("Requesting interstitial ad from adapter.");
            try {
                ((C0704f) this.zzzc).m967a(new zzet(com_google_android_gms_internal_zzej), (Activity) zze.zzp(com_google_android_gms_dynamic_zzd), zzb(str, adRequestParcel.zzsu, str2), zzeu.zzg(adRequestParcel), this.zzzd);
            } catch (Throwable th) {
                zzb.zzd("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzb.zzaE("MediationAdapter is not a MediationInterstitialAdapter: " + this.zzzc.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void zza(zzd com_google_android_gms_dynamic_zzd, AdRequestParcel adRequestParcel, String str, String str2, zzej com_google_android_gms_internal_zzej, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list) {
    }

    public void zza(zzd com_google_android_gms_dynamic_zzd, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, zzej com_google_android_gms_internal_zzej) throws RemoteException {
        zza(com_google_android_gms_dynamic_zzd, adSizeParcel, adRequestParcel, str, null, com_google_android_gms_internal_zzej);
    }

    public void zza(zzd com_google_android_gms_dynamic_zzd, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, String str2, zzej com_google_android_gms_internal_zzej) throws RemoteException {
        if (this.zzzc instanceof C0702d) {
            zzb.zzaC("Requesting banner ad from adapter.");
            try {
                ((C0702d) this.zzzc).m965a(new zzet(com_google_android_gms_internal_zzej), (Activity) zze.zzp(com_google_android_gms_dynamic_zzd), zzb(str, adRequestParcel.zzsu, str2), zzeu.zzb(adSizeParcel), zzeu.zzg(adRequestParcel), this.zzzd);
            } catch (Throwable th) {
                zzb.zzd("Could not request banner ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            zzb.zzaE("MediationAdapter is not a MediationBannerAdapter: " + this.zzzc.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public zzek zzdS() {
        return null;
    }

    public zzel zzdT() {
        return null;
    }
}
