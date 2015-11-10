package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzdd;
import com.google.android.gms.internal.zzdi;
import com.google.android.gms.internal.zzgk;
import com.google.android.gms.internal.zzip;

@zzgk
public final class AdOverlayInfoParcel implements SafeParcelable {
    public static final zzf CREATOR;
    public final int orientation;
    public final String url;
    public final int versionCode;
    public final AdLauncherIntentInfoParcel zzAO;
    public final zza zzAP;
    public final zzg zzAQ;
    public final zzip zzAR;
    public final zzdd zzAS;
    public final String zzAT;
    public final boolean zzAU;
    public final String zzAV;
    public final zzn zzAW;
    public final int zzAX;
    public final zzdi zzAY;
    public final String zzAZ;
    public final InterstitialAdParameterParcel zzBa;
    public final VersionInfoParcel zzqb;

    static {
        CREATOR = new zzf();
    }

    AdOverlayInfoParcel(int i, AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z, String str2, IBinder iBinder5, int i2, int i3, String str3, VersionInfoParcel versionInfoParcel, IBinder iBinder6, String str4, InterstitialAdParameterParcel interstitialAdParameterParcel) {
        this.versionCode = i;
        this.zzAO = adLauncherIntentInfoParcel;
        this.zzAP = (zza) zze.zzp(zzd.zza.zzbk(iBinder));
        this.zzAQ = (zzg) zze.zzp(zzd.zza.zzbk(iBinder2));
        this.zzAR = (zzip) zze.zzp(zzd.zza.zzbk(iBinder3));
        this.zzAS = (zzdd) zze.zzp(zzd.zza.zzbk(iBinder4));
        this.zzAT = str;
        this.zzAU = z;
        this.zzAV = str2;
        this.zzAW = (zzn) zze.zzp(zzd.zza.zzbk(iBinder5));
        this.orientation = i2;
        this.zzAX = i3;
        this.url = str3;
        this.zzqb = versionInfoParcel;
        this.zzAY = (zzdi) zze.zzp(zzd.zza.zzbk(iBinder6));
        this.zzAZ = str4;
        this.zzBa = interstitialAdParameterParcel;
    }

    public AdOverlayInfoParcel(zza com_google_android_gms_ads_internal_client_zza, zzg com_google_android_gms_ads_internal_overlay_zzg, zzn com_google_android_gms_ads_internal_overlay_zzn, zzip com_google_android_gms_internal_zzip, int i, VersionInfoParcel versionInfoParcel, String str, InterstitialAdParameterParcel interstitialAdParameterParcel) {
        this.versionCode = 4;
        this.zzAO = null;
        this.zzAP = com_google_android_gms_ads_internal_client_zza;
        this.zzAQ = com_google_android_gms_ads_internal_overlay_zzg;
        this.zzAR = com_google_android_gms_internal_zzip;
        this.zzAS = null;
        this.zzAT = null;
        this.zzAU = false;
        this.zzAV = null;
        this.zzAW = com_google_android_gms_ads_internal_overlay_zzn;
        this.orientation = i;
        this.zzAX = 1;
        this.url = null;
        this.zzqb = versionInfoParcel;
        this.zzAY = null;
        this.zzAZ = str;
        this.zzBa = interstitialAdParameterParcel;
    }

    public AdOverlayInfoParcel(zza com_google_android_gms_ads_internal_client_zza, zzg com_google_android_gms_ads_internal_overlay_zzg, zzn com_google_android_gms_ads_internal_overlay_zzn, zzip com_google_android_gms_internal_zzip, boolean z, int i, VersionInfoParcel versionInfoParcel) {
        this.versionCode = 4;
        this.zzAO = null;
        this.zzAP = com_google_android_gms_ads_internal_client_zza;
        this.zzAQ = com_google_android_gms_ads_internal_overlay_zzg;
        this.zzAR = com_google_android_gms_internal_zzip;
        this.zzAS = null;
        this.zzAT = null;
        this.zzAU = z;
        this.zzAV = null;
        this.zzAW = com_google_android_gms_ads_internal_overlay_zzn;
        this.orientation = i;
        this.zzAX = 2;
        this.url = null;
        this.zzqb = versionInfoParcel;
        this.zzAY = null;
        this.zzAZ = null;
        this.zzBa = null;
    }

    public AdOverlayInfoParcel(zza com_google_android_gms_ads_internal_client_zza, zzg com_google_android_gms_ads_internal_overlay_zzg, zzdd com_google_android_gms_internal_zzdd, zzn com_google_android_gms_ads_internal_overlay_zzn, zzip com_google_android_gms_internal_zzip, boolean z, int i, String str, VersionInfoParcel versionInfoParcel, zzdi com_google_android_gms_internal_zzdi) {
        this.versionCode = 4;
        this.zzAO = null;
        this.zzAP = com_google_android_gms_ads_internal_client_zza;
        this.zzAQ = com_google_android_gms_ads_internal_overlay_zzg;
        this.zzAR = com_google_android_gms_internal_zzip;
        this.zzAS = com_google_android_gms_internal_zzdd;
        this.zzAT = null;
        this.zzAU = z;
        this.zzAV = null;
        this.zzAW = com_google_android_gms_ads_internal_overlay_zzn;
        this.orientation = i;
        this.zzAX = 3;
        this.url = str;
        this.zzqb = versionInfoParcel;
        this.zzAY = com_google_android_gms_internal_zzdi;
        this.zzAZ = null;
        this.zzBa = null;
    }

    public AdOverlayInfoParcel(zza com_google_android_gms_ads_internal_client_zza, zzg com_google_android_gms_ads_internal_overlay_zzg, zzdd com_google_android_gms_internal_zzdd, zzn com_google_android_gms_ads_internal_overlay_zzn, zzip com_google_android_gms_internal_zzip, boolean z, int i, String str, String str2, VersionInfoParcel versionInfoParcel, zzdi com_google_android_gms_internal_zzdi) {
        this.versionCode = 4;
        this.zzAO = null;
        this.zzAP = com_google_android_gms_ads_internal_client_zza;
        this.zzAQ = com_google_android_gms_ads_internal_overlay_zzg;
        this.zzAR = com_google_android_gms_internal_zzip;
        this.zzAS = com_google_android_gms_internal_zzdd;
        this.zzAT = str2;
        this.zzAU = z;
        this.zzAV = str;
        this.zzAW = com_google_android_gms_ads_internal_overlay_zzn;
        this.orientation = i;
        this.zzAX = 3;
        this.url = null;
        this.zzqb = versionInfoParcel;
        this.zzAY = com_google_android_gms_internal_zzdi;
        this.zzAZ = null;
        this.zzBa = null;
    }

    public AdOverlayInfoParcel(AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, zza com_google_android_gms_ads_internal_client_zza, zzg com_google_android_gms_ads_internal_overlay_zzg, zzn com_google_android_gms_ads_internal_overlay_zzn, VersionInfoParcel versionInfoParcel) {
        this.versionCode = 4;
        this.zzAO = adLauncherIntentInfoParcel;
        this.zzAP = com_google_android_gms_ads_internal_client_zza;
        this.zzAQ = com_google_android_gms_ads_internal_overlay_zzg;
        this.zzAR = null;
        this.zzAS = null;
        this.zzAT = null;
        this.zzAU = false;
        this.zzAV = null;
        this.zzAW = com_google_android_gms_ads_internal_overlay_zzn;
        this.orientation = -1;
        this.zzAX = 4;
        this.url = null;
        this.zzqb = versionInfoParcel;
        this.zzAY = null;
        this.zzAZ = null;
        this.zzBa = null;
    }

    public static void zza(Intent intent, AdOverlayInfoParcel adOverlayInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    public static AdOverlayInfoParcel zzb(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception e) {
            return null;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    IBinder zzeE() {
        return zze.zzx(this.zzAP).asBinder();
    }

    IBinder zzeF() {
        return zze.zzx(this.zzAQ).asBinder();
    }

    IBinder zzeG() {
        return zze.zzx(this.zzAR).asBinder();
    }

    IBinder zzeH() {
        return zze.zzx(this.zzAS).asBinder();
    }

    IBinder zzeI() {
        return zze.zzx(this.zzAY).asBinder();
    }

    IBinder zzeJ() {
        return zze.zzx(this.zzAW).asBinder();
    }
}
