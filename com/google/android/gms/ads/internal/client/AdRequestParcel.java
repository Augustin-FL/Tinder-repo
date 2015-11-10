package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzgk;
import java.util.List;

@zzgk
public final class AdRequestParcel implements SafeParcelable {
    public static final zzf CREATOR;
    public final Bundle extras;
    public final int versionCode;
    public final Bundle zzsA;
    public final Bundle zzsB;
    public final List<String> zzsC;
    public final String zzsD;
    public final String zzsE;
    public final long zzsq;
    public final int zzsr;
    public final List<String> zzss;
    public final boolean zzst;
    public final int zzsu;
    public final boolean zzsv;
    public final String zzsw;
    public final SearchAdRequestParcel zzsx;
    public final Location zzsy;
    public final String zzsz;

    static {
        CREATOR = new zzf();
    }

    public AdRequestParcel(int i, long j, Bundle bundle, int i2, List<String> list, boolean z, int i3, boolean z2, String str, SearchAdRequestParcel searchAdRequestParcel, Location location, String str2, Bundle bundle2, Bundle bundle3, List<String> list2, String str3, String str4) {
        this.versionCode = i;
        this.zzsq = j;
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.extras = bundle;
        this.zzsr = i2;
        this.zzss = list;
        this.zzst = z;
        this.zzsu = i3;
        this.zzsv = z2;
        this.zzsw = str;
        this.zzsx = searchAdRequestParcel;
        this.zzsy = location;
        this.zzsz = str2;
        this.zzsA = bundle2;
        this.zzsB = bundle3;
        this.zzsC = list2;
        this.zzsD = str3;
        this.zzsE = str4;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AdRequestParcel)) {
            return false;
        }
        AdRequestParcel adRequestParcel = (AdRequestParcel) obj;
        return this.versionCode == adRequestParcel.versionCode && this.zzsq == adRequestParcel.zzsq && zzw.equal(this.extras, adRequestParcel.extras) && this.zzsr == adRequestParcel.zzsr && zzw.equal(this.zzss, adRequestParcel.zzss) && this.zzst == adRequestParcel.zzst && this.zzsu == adRequestParcel.zzsu && this.zzsv == adRequestParcel.zzsv && zzw.equal(this.zzsw, adRequestParcel.zzsw) && zzw.equal(this.zzsx, adRequestParcel.zzsx) && zzw.equal(this.zzsy, adRequestParcel.zzsy) && zzw.equal(this.zzsz, adRequestParcel.zzsz) && zzw.equal(this.zzsA, adRequestParcel.zzsA) && zzw.equal(this.zzsB, adRequestParcel.zzsB) && zzw.equal(this.zzsC, adRequestParcel.zzsC) && zzw.equal(this.zzsD, adRequestParcel.zzsD) && zzw.equal(this.zzsE, adRequestParcel.zzsE);
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.versionCode), Long.valueOf(this.zzsq), this.extras, Integer.valueOf(this.zzsr), this.zzss, Boolean.valueOf(this.zzst), Integer.valueOf(this.zzsu), Boolean.valueOf(this.zzsv), this.zzsw, this.zzsx, this.zzsy, this.zzsz, this.zzsA, this.zzsB, this.zzsC, this.zzsD, this.zzsE);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }
}
