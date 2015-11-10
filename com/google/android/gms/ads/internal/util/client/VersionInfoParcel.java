package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzgk;

@zzgk
public final class VersionInfoParcel implements SafeParcelable {
    public static final zzc CREATOR;
    public final int versionCode;
    public int zzIA;
    public int zzIB;
    public boolean zzIC;
    public String zzIz;

    static {
        CREATOR = new zzc();
    }

    public VersionInfoParcel(int i, int i2, boolean z) {
        this(1, "afma-sdk-a-v" + i + "." + i2 + "." + (z ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES), i, i2, z);
    }

    VersionInfoParcel(int i, String str, int i2, int i3, boolean z) {
        this.versionCode = i;
        this.zzIz = str;
        this.zzIA = i2;
        this.zzIB = i3;
        this.zzIC = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
