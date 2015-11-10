package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Locale;

public class PlacesParams implements SafeParcelable {
    public static final zzs CREATOR;
    public static final PlacesParams zzaEY;
    public final int versionCode;
    public final String zzaDU;
    public final String zzaEZ;
    public final String zzaFa;
    public final String zzaFb;
    public final String zzaFc;
    public final int zzaFd;

    static {
        zzaEY = new PlacesParams(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, Locale.getDefault(), null);
        CREATOR = new zzs();
    }

    public PlacesParams(int i, String str, String str2, String str3, String str4, String str5, int i2) {
        this.versionCode = i;
        this.zzaEZ = str;
        this.zzaFa = str2;
        this.zzaFb = str3;
        this.zzaDU = str4;
        this.zzaFc = str5;
        this.zzaFd = i2;
    }

    public PlacesParams(String str, Locale locale, String str2) {
        this(1, str, locale.toString(), str2, null, null, GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    public PlacesParams(String str, Locale locale, String str2, String str3, String str4) {
        this(1, str, locale.toString(), str2, str3, str4, GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    public int describeContents() {
        zzs com_google_android_gms_location_places_internal_zzs = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PlacesParams)) {
            return false;
        }
        PlacesParams placesParams = (PlacesParams) obj;
        return this.zzaFa.equals(placesParams.zzaFa) && this.zzaEZ.equals(placesParams.zzaEZ) && zzw.equal(this.zzaFb, placesParams.zzaFb) && zzw.equal(this.zzaDU, placesParams.zzaDU) && zzw.equal(this.zzaFc, placesParams.zzaFc);
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaEZ, this.zzaFa, this.zzaFb, this.zzaDU, this.zzaFc);
    }

    public String toString() {
        return zzw.zzu(this).zzg("clientPackageName", this.zzaEZ).zzg("locale", this.zzaFa).zzg("accountName", this.zzaFb).zzg("gCoreClientName", this.zzaDU).zzg("chargedPackageName", this.zzaFc).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzs com_google_android_gms_location_places_internal_zzs = CREATOR;
        zzs.zza(this, parcel, i);
    }
}
