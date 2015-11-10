package com.google.android.gms.location.places.personalized.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.places.personalized.zzf;

public class TestDataImpl extends zzf implements SafeParcelable {
    public static final zza CREATOR;
    final int mVersionCode;
    private final String zzaFm;

    static {
        CREATOR = new zza();
    }

    TestDataImpl(int i, String str) {
        this.mVersionCode = i;
        this.zzaFm = str;
    }

    public int describeContents() {
        zza com_google_android_gms_location_places_personalized_internal_zza = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TestDataImpl)) {
            return false;
        }
        return this.zzaFm.equals(((TestDataImpl) obj).zzaFm);
    }

    public int hashCode() {
        return this.zzaFm.hashCode();
    }

    public String toString() {
        return zzw.zzu(this).zzg("testName", this.zzaFm).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza com_google_android_gms_location_places_personalized_internal_zza = CREATOR;
        zza.zza(this, parcel, i);
    }

    public String zzwA() {
        return this.zzaFm;
    }
}
