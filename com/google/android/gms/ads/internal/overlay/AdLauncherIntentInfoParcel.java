package com.google.android.gms.ads.internal.overlay;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzgk;

@zzgk
public final class AdLauncherIntentInfoParcel implements SafeParcelable {
    public static final zzb CREATOR;
    public final String intentAction;
    public final String mimeType;
    public final String packageName;
    public final String url;
    public final int versionCode;
    public final String zzAa;
    public final String zzzY;
    public final String zzzZ;

    static {
        CREATOR = new zzb();
    }

    public AdLauncherIntentInfoParcel(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.versionCode = i;
        this.intentAction = str;
        this.url = str2;
        this.mimeType = str3;
        this.packageName = str4;
        this.zzzY = str5;
        this.zzzZ = str6;
        this.zzAa = str7;
    }

    public AdLauncherIntentInfoParcel(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this(1, str, str2, str3, str4, str5, str6, str7);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
