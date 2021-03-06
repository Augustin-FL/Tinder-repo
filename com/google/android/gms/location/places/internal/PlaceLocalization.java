package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.List;

@Deprecated
public final class PlaceLocalization implements SafeParcelable {
    public static final zzn CREATOR;
    public final String address;
    public final String name;
    public final int versionCode;
    public final String zzaEK;
    public final String zzaEL;
    public final List<String> zzaEM;

    static {
        CREATOR = new zzn();
    }

    public PlaceLocalization(int i, String str, String str2, String str3, String str4, List<String> list) {
        this.versionCode = i;
        this.name = str;
        this.address = str2;
        this.zzaEK = str3;
        this.zzaEL = str4;
        this.zzaEM = list;
    }

    public static PlaceLocalization zza(String str, String str2, String str3, String str4, List<String> list) {
        return new PlaceLocalization(0, str, str2, str3, str4, list);
    }

    public int describeContents() {
        zzn com_google_android_gms_location_places_internal_zzn = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceLocalization)) {
            return false;
        }
        PlaceLocalization placeLocalization = (PlaceLocalization) obj;
        return zzw.equal(this.name, placeLocalization.name) && zzw.equal(this.address, placeLocalization.address) && zzw.equal(this.zzaEK, placeLocalization.zzaEK) && zzw.equal(this.zzaEL, placeLocalization.zzaEL) && zzw.equal(this.zzaEM, placeLocalization.zzaEM);
    }

    public int hashCode() {
        return zzw.hashCode(this.name, this.address, this.zzaEK, this.zzaEL);
    }

    public String toString() {
        return zzw.zzu(this).zzg(ShareConstants.WEB_DIALOG_PARAM_NAME, this.name).zzg("address", this.address).zzg("internationalPhoneNumber", this.zzaEK).zzg("regularOpenHours", this.zzaEL).zzg("attributions", this.zzaEM).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzn com_google_android_gms_location_places_internal_zzn = CREATOR;
        zzn.zza(this, parcel, i);
    }
}
