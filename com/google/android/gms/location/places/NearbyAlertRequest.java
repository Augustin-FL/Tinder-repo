package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class NearbyAlertRequest implements SafeParcelable {
    public static final zze CREATOR;
    private final int mVersionCode;
    private final int zzaBA;
    private final int zzaDs;
    @Deprecated
    private final PlaceFilter zzaDt;
    private final NearbyAlertFilter zzaDu;
    private final boolean zzaDv;

    static {
        CREATOR = new zze();
    }

    NearbyAlertRequest(int i, int i2, int i3, PlaceFilter placeFilter, NearbyAlertFilter nearbyAlertFilter, boolean z) {
        this.mVersionCode = i;
        this.zzaBA = i2;
        this.zzaDs = i3;
        this.zzaDv = z;
        if (nearbyAlertFilter != null) {
            this.zzaDu = nearbyAlertFilter;
        } else if (placeFilter == null) {
            this.zzaDu = null;
        } else if (zza(placeFilter)) {
            this.zzaDu = NearbyAlertFilter.zza(placeFilter.getPlaceIds(), placeFilter.getPlaceTypes(), placeFilter.zzwd());
        } else {
            this.zzaDu = null;
        }
        this.zzaDt = null;
    }

    @Deprecated
    public static boolean zza(PlaceFilter placeFilter) {
        return ((placeFilter.getPlaceTypes() == null || placeFilter.getPlaceTypes().isEmpty()) && ((placeFilter.getPlaceIds() == null || placeFilter.getPlaceIds().isEmpty()) && (placeFilter.zzwd() == null || placeFilter.zzwd().isEmpty()))) ? false : true;
    }

    public int describeContents() {
        zze com_google_android_gms_location_places_zze = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NearbyAlertRequest)) {
            return false;
        }
        NearbyAlertRequest nearbyAlertRequest = (NearbyAlertRequest) obj;
        return this.zzaBA == nearbyAlertRequest.zzaBA && this.zzaDs == nearbyAlertRequest.zzaDs && zzw.equal(this.zzaDt, nearbyAlertRequest.zzaDt) && zzw.equal(this.zzaDu, nearbyAlertRequest.zzaDu);
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzaBA), Integer.valueOf(this.zzaDs));
    }

    public String toString() {
        return zzw.zzu(this).zzg("transitionTypes", Integer.valueOf(this.zzaBA)).zzg("loiteringTimeMillis", Integer.valueOf(this.zzaDs)).zzg("nearbyAlertFilter", this.zzaDu).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze com_google_android_gms_location_places_zze = CREATOR;
        zze.zza(this, parcel, i);
    }

    public int zzvW() {
        return this.zzaBA;
    }

    public int zzvZ() {
        return this.zzaDs;
    }

    @Deprecated
    public PlaceFilter zzwa() {
        return this.zzaDt;
    }

    public NearbyAlertFilter zzwb() {
        return this.zzaDu;
    }

    public boolean zzwc() {
        return this.zzaDv;
    }
}
