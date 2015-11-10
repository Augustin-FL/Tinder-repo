package com.google.android.gms.ads.internal.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CapabilityParcel implements SafeParcelable {
    public static final Creator<CapabilityParcel> CREATOR;
    public final int versionCode;
    public final boolean zzEm;
    public final boolean zzEn;

    static {
        CREATOR = new zzi();
    }

    CapabilityParcel(int i, boolean z, boolean z2) {
        this.versionCode = i;
        this.zzEm = z;
        this.zzEn = z2;
    }

    public CapabilityParcel(boolean z, boolean z2) {
        this(1, z, z2);
    }

    public int describeContents() {
        return 0;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("iap_supported", this.zzEm);
        bundle.putBoolean("default_iap_supported", this.zzEn);
        return bundle;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }
}
