package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;

public final class LocationSettingsStates implements SafeParcelable {
    public static final Creator<LocationSettingsStates> CREATOR;
    private final int mVersionCode;
    private final boolean zzaCi;
    private final boolean zzaCj;
    private final boolean zzaCk;
    private final boolean zzaCl;
    private final boolean zzaCm;
    private final boolean zzaCn;
    private final boolean zzaCo;

    static {
        CREATOR = new zzh();
    }

    LocationSettingsStates(int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.mVersionCode = i;
        this.zzaCi = z;
        this.zzaCj = z2;
        this.zzaCk = z3;
        this.zzaCl = z4;
        this.zzaCm = z5;
        this.zzaCn = z6;
        this.zzaCo = z7;
    }

    public static LocationSettingsStates fromIntent(Intent intent) {
        return (LocationSettingsStates) zzc.zza(intent, "com.google.android.gms.location.LOCATION_SETTINGS_STATES", CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean isBlePresent() {
        return this.zzaCn;
    }

    public boolean isBleUsable() {
        return this.zzaCk;
    }

    public boolean isGpsPresent() {
        return this.zzaCl;
    }

    public boolean isGpsUsable() {
        return this.zzaCi;
    }

    public boolean isLocationPresent() {
        return this.zzaCl || this.zzaCm;
    }

    public boolean isLocationUsable() {
        return this.zzaCi || this.zzaCj;
    }

    public boolean isNetworkLocationPresent() {
        return this.zzaCm;
    }

    public boolean isNetworkLocationUsable() {
        return this.zzaCj;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }

    public boolean zzvM() {
        return this.zzaCo;
    }
}
