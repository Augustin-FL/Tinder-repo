package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.places.personalized.internal.TestDataImpl;
import java.util.List;

public class PlaceUserData implements SafeParcelable {
    public static final zze CREATOR;
    final int mVersionCode;
    private final String zzQE;
    private final String zzaDH;
    private final List<TestDataImpl> zzaFj;
    private final List<PlaceAlias> zzaFk;
    private final List<HereContent> zzaFl;

    static {
        CREATOR = new zze();
    }

    PlaceUserData(int i, String str, String str2, List<TestDataImpl> list, List<PlaceAlias> list2, List<HereContent> list3) {
        this.mVersionCode = i;
        this.zzQE = str;
        this.zzaDH = str2;
        this.zzaFj = list;
        this.zzaFk = list2;
        this.zzaFl = list3;
    }

    public int describeContents() {
        zze com_google_android_gms_location_places_personalized_zze = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceUserData)) {
            return false;
        }
        PlaceUserData placeUserData = (PlaceUserData) obj;
        return this.zzQE.equals(placeUserData.zzQE) && this.zzaDH.equals(placeUserData.zzaDH) && this.zzaFj.equals(placeUserData.zzaFj) && this.zzaFk.equals(placeUserData.zzaFk) && this.zzaFl.equals(placeUserData.zzaFl);
    }

    public String getPlaceId() {
        return this.zzaDH;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzQE, this.zzaDH, this.zzaFj, this.zzaFk, this.zzaFl);
    }

    public String toString() {
        return zzw.zzu(this).zzg("accountName", this.zzQE).zzg("placeId", this.zzaDH).zzg("testDataImpls", this.zzaFj).zzg("placeAliases", this.zzaFk).zzg("hereContents", this.zzaFl).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze com_google_android_gms_location_places_personalized_zze = CREATOR;
        zze.zza(this, parcel, i);
    }

    public String zzww() {
        return this.zzQE;
    }

    public List<PlaceAlias> zzwx() {
        return this.zzaFk;
    }

    public List<HereContent> zzwy() {
        return this.zzaFl;
    }

    public List<TestDataImpl> zzwz() {
        return this.zzaFj;
    }
}
