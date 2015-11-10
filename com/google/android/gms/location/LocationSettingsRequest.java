package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class LocationSettingsRequest implements SafeParcelable {
    public static final Creator<LocationSettingsRequest> CREATOR;
    private final int mVersionCode;
    private final boolean zzaCd;
    private final boolean zzaCe;
    private final boolean zzaCf;
    private final List<LocationRequest> zzaqn;

    public static final class Builder {
        private boolean zzaCd;
        private boolean zzaCe;
        private boolean zzaCf;
        private final ArrayList<LocationRequest> zzaCg;

        public Builder() {
            this.zzaCg = new ArrayList();
            this.zzaCd = false;
            this.zzaCe = false;
            this.zzaCf = false;
        }

        public Builder addAllLocationRequests(Collection<LocationRequest> collection) {
            this.zzaCg.addAll(collection);
            return this;
        }

        public Builder addLocationRequest(LocationRequest locationRequest) {
            this.zzaCg.add(locationRequest);
            return this;
        }

        public LocationSettingsRequest build() {
            return new LocationSettingsRequest(this.zzaCd, this.zzaCe, this.zzaCf, null);
        }

        public Builder setAlwaysShow(boolean z) {
            this.zzaCd = z;
            return this;
        }

        public Builder setNeedBle(boolean z) {
            this.zzaCe = z;
            return this;
        }
    }

    static {
        CREATOR = new zzf();
    }

    LocationSettingsRequest(int i, List<LocationRequest> list, boolean z, boolean z2, boolean z3) {
        this.mVersionCode = i;
        this.zzaqn = list;
        this.zzaCd = z;
        this.zzaCe = z2;
        this.zzaCf = z3;
    }

    private LocationSettingsRequest(List<LocationRequest> list, boolean z, boolean z2, boolean z3) {
        this(2, (List) list, z, z2, z3);
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    public List<LocationRequest> zzsr() {
        return Collections.unmodifiableList(this.zzaqn);
    }

    public boolean zzvJ() {
        return this.zzaCd;
    }

    public boolean zzvK() {
        return this.zzaCe;
    }

    public boolean zzvL() {
        return this.zzaCf;
    }
}
