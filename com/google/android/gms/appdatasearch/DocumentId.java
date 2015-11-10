package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DocumentId implements SafeParcelable {
    public static final zzc CREATOR;
    final int mVersionCode;
    final String zzOZ;
    final String zzPa;
    final String zzPb;

    static {
        CREATOR = new zzc();
    }

    DocumentId(int i, String str, String str2, String str3) {
        this.mVersionCode = i;
        this.zzOZ = str;
        this.zzPa = str2;
        this.zzPb = str3;
    }

    public DocumentId(String str, String str2, String str3) {
        this(1, str, str2, str3);
    }

    public int describeContents() {
        zzc com_google_android_gms_appdatasearch_zzc = CREATOR;
        return 0;
    }

    public String toString() {
        return String.format("DocumentId[packageName=%s, corpusName=%s, uri=%s]", new Object[]{this.zzOZ, this.zzPa, this.zzPb});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc com_google_android_gms_appdatasearch_zzc = CREATOR;
        zzc.zza(this, parcel, i);
    }
}
