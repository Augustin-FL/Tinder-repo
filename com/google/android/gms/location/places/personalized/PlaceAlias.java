package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class PlaceAlias implements SafeParcelable {
    public static final zzc CREATOR;
    public static final PlaceAlias zzaFg;
    public static final PlaceAlias zzaFh;
    final int mVersionCode;
    private final String zzaFi;

    static {
        CREATOR = new zzc();
        zzaFg = new PlaceAlias(0, "Home");
        zzaFh = new PlaceAlias(0, "Work");
    }

    PlaceAlias(int i, String str) {
        this.mVersionCode = i;
        this.zzaFi = str;
    }

    public int describeContents() {
        zzc com_google_android_gms_location_places_personalized_zzc = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceAlias)) {
            return false;
        }
        return zzw.equal(this.zzaFi, ((PlaceAlias) obj).zzaFi);
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaFi);
    }

    public String toString() {
        return zzw.zzu(this).zzg("alias", this.zzaFi).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc com_google_android_gms_location_places_personalized_zzc = CREATOR;
        zzc.zza(this, parcel, i);
    }

    public String zzwv() {
        return this.zzaFi;
    }
}
