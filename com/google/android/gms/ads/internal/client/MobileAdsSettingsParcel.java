package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzgk;

@zzgk
public final class MobileAdsSettingsParcel implements SafeParcelable {
    public static final zzad CREATOR;
    public final int versionCode;
    public final boolean zzty;
    public final String zztz;

    static {
        CREATOR = new zzad();
    }

    public MobileAdsSettingsParcel(int i, boolean z, String str) {
        this.versionCode = i;
        this.zzty = z;
        this.zztz = str;
    }

    public MobileAdsSettingsParcel(zzab com_google_android_gms_ads_internal_client_zzab) {
        this(1, com_google_android_gms_ads_internal_client_zzab.isGoogleAnalyticsEnabled(), com_google_android_gms_ads_internal_client_zzab.getTrackingId());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzad.zza(this, parcel, i);
    }
}
