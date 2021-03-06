package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.zzd.zza;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzfl;
import com.google.android.gms.internal.zzgk;

@zzgk
public final class GInAppPurchaseManagerInfoParcel implements SafeParcelable {
    public static final zza CREATOR;
    public final int versionCode;
    public final zzfl zzBJ;
    public final Context zzBK;
    public final zzj zzBL;
    public final zzk zzqw;

    static {
        CREATOR = new zza();
    }

    GInAppPurchaseManagerInfoParcel(int i, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4) {
        this.versionCode = i;
        this.zzqw = (zzk) zze.zzp(zza.zzbk(iBinder));
        this.zzBJ = (zzfl) zze.zzp(zza.zzbk(iBinder2));
        this.zzBK = (Context) zze.zzp(zza.zzbk(iBinder3));
        this.zzBL = (zzj) zze.zzp(zza.zzbk(iBinder4));
    }

    public GInAppPurchaseManagerInfoParcel(Context context, zzk com_google_android_gms_ads_internal_purchase_zzk, zzfl com_google_android_gms_internal_zzfl, zzj com_google_android_gms_ads_internal_purchase_zzj) {
        this.versionCode = 2;
        this.zzBK = context;
        this.zzqw = com_google_android_gms_ads_internal_purchase_zzk;
        this.zzBJ = com_google_android_gms_internal_zzfl;
        this.zzBL = com_google_android_gms_ads_internal_purchase_zzj;
    }

    public static void zza(Intent intent, GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", gInAppPurchaseManagerInfoParcel);
        intent.putExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", bundle);
    }

    public static GInAppPurchaseManagerInfoParcel zzc(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
            bundleExtra.setClassLoader(GInAppPurchaseManagerInfoParcel.class.getClassLoader());
            return (GInAppPurchaseManagerInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
        } catch (Exception e) {
            return null;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    IBinder zzfc() {
        return zze.zzx(this.zzBL).asBinder();
    }

    IBinder zzfd() {
        return zze.zzx(this.zzqw).asBinder();
    }

    IBinder zzfe() {
        return zze.zzx(this.zzBJ).asBinder();
    }

    IBinder zzff() {
        return zze.zzx(this.zzBK).asBinder();
    }
}
