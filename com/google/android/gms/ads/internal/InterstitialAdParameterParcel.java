package com.google.android.gms.ads.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzgk;

@zzgk
public final class InterstitialAdParameterParcel implements SafeParcelable {
    public static final zzl CREATOR;
    public final int versionCode;
    public final boolean zzpk;
    public final boolean zzpl;

    static {
        CREATOR = new zzl();
    }

    InterstitialAdParameterParcel(int i, boolean z, boolean z2) {
        this.versionCode = i;
        this.zzpk = z;
        this.zzpl = z2;
    }

    public InterstitialAdParameterParcel(boolean z, boolean z2) {
        this.versionCode = 1;
        this.zzpk = z;
        this.zzpl = z2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzl.zza(this, parcel, i);
    }
}
