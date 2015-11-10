package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class PlaceFilter extends zza implements SafeParcelable {
    public static final zzg CREATOR;
    final int mVersionCode;
    final List<Integer> zzaDm;
    private final Set<Integer> zzaDn;
    final List<String> zzaDo;
    final List<UserDataType> zzaDp;
    private final Set<String> zzaDq;
    private final Set<UserDataType> zzaDr;
    final boolean zzaDz;

    @Deprecated
    public static final class zza {
        private Collection<Integer> zzaDA;
        private Collection<UserDataType> zzaDB;
        private String[] zzaDC;
        private boolean zzaDz;

        private zza() {
            this.zzaDA = null;
            this.zzaDz = false;
            this.zzaDB = null;
            this.zzaDC = null;
        }

        public PlaceFilter zzwf() {
            Collection collection = null;
            Collection arrayList = this.zzaDA != null ? new ArrayList(this.zzaDA) : null;
            Collection arrayList2 = this.zzaDB != null ? new ArrayList(this.zzaDB) : null;
            if (this.zzaDC != null) {
                collection = Arrays.asList(this.zzaDC);
            }
            return new PlaceFilter(arrayList, this.zzaDz, collection, arrayList2);
        }
    }

    static {
        CREATOR = new zzg();
    }

    public PlaceFilter() {
        this(false, null);
    }

    PlaceFilter(int i, List<Integer> list, boolean z, List<String> list2, List<UserDataType> list3) {
        this.mVersionCode = i;
        this.zzaDm = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.zzaDz = z;
        this.zzaDp = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        this.zzaDo = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.zzaDn = zza.zzl(this.zzaDm);
        this.zzaDr = zza.zzl(this.zzaDp);
        this.zzaDq = zza.zzl(this.zzaDo);
    }

    public PlaceFilter(Collection<Integer> collection, boolean z, Collection<String> collection2, Collection<UserDataType> collection3) {
        this(0, zza.zzf(collection), z, zza.zzf(collection2), zza.zzf(collection3));
    }

    public PlaceFilter(boolean z, Collection<String> collection) {
        this(null, z, collection, null);
    }

    @Deprecated
    public static PlaceFilter zzwe() {
        return new zza().zzwf();
    }

    public int describeContents() {
        zzg com_google_android_gms_location_places_zzg = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceFilter)) {
            return false;
        }
        PlaceFilter placeFilter = (PlaceFilter) obj;
        return this.zzaDn.equals(placeFilter.zzaDn) && this.zzaDz == placeFilter.zzaDz && this.zzaDr.equals(placeFilter.zzaDr) && this.zzaDq.equals(placeFilter.zzaDq);
    }

    public Set<String> getPlaceIds() {
        return this.zzaDq;
    }

    public Set<Integer> getPlaceTypes() {
        return this.zzaDn;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaDn, Boolean.valueOf(this.zzaDz), this.zzaDr, this.zzaDq);
    }

    public boolean isRestrictedToPlacesOpenNow() {
        return this.zzaDz;
    }

    public String toString() {
        com.google.android.gms.common.internal.zzw.zza zzu = zzw.zzu(this);
        if (!this.zzaDn.isEmpty()) {
            zzu.zzg("types", this.zzaDn);
        }
        zzu.zzg("requireOpenNow", Boolean.valueOf(this.zzaDz));
        if (!this.zzaDq.isEmpty()) {
            zzu.zzg("placeIds", this.zzaDq);
        }
        if (!this.zzaDr.isEmpty()) {
            zzu.zzg("requestedUserDataTypes", this.zzaDr);
        }
        return zzu.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzg com_google_android_gms_location_places_zzg = CREATOR;
        zzg.zza(this, parcel, i);
    }

    public Set<UserDataType> zzwd() {
        return this.zzaDr;
    }
}
