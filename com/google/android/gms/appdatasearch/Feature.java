package com.google.android.gms.appdatasearch;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Feature implements SafeParcelable {
    public static final zze CREATOR;
    public final int id;
    final int mVersionCode;
    final Bundle zzPi;

    static {
        CREATOR = new zze();
    }

    Feature(int i, int i2, Bundle bundle) {
        this.mVersionCode = i;
        this.id = i2;
        this.zzPi = bundle;
    }

    public int describeContents() {
        zze com_google_android_gms_appdatasearch_zze = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze com_google_android_gms_appdatasearch_zze = CREATOR;
        zze.zza(this, parcel, i);
    }
}
