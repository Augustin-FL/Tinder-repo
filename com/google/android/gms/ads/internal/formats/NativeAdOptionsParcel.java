package com.google.android.gms.ads.internal.formats;

import android.os.Parcel;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzgk;

@zzgk
public class NativeAdOptionsParcel implements SafeParcelable {
    public static final zzi CREATOR;
    public final int versionCode;
    public final boolean zzwn;
    public final int zzwo;
    public final boolean zzwp;

    static {
        CREATOR = new zzi();
    }

    public NativeAdOptionsParcel(int i, boolean z, int i2, boolean z2) {
        this.versionCode = i;
        this.zzwn = z;
        this.zzwo = i2;
        this.zzwp = z2;
    }

    public NativeAdOptionsParcel(NativeAdOptions nativeAdOptions) {
        this(1, nativeAdOptions.shouldReturnUrlsForImageAssets(), nativeAdOptions.getImageOrientation(), nativeAdOptions.shouldRequestMultipleImages());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }
}
