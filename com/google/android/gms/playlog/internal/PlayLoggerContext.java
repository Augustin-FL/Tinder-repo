package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public class PlayLoggerContext implements SafeParcelable {
    public static final zze CREATOR;
    public final String packageName;
    public final int versionCode;
    public final int zzaKR;
    public final int zzaKS;
    public final String zzaKT;
    public final String zzaKU;
    public final boolean zzaKV;
    public final String zzaKW;
    public final boolean zzaKX;
    public final int zzaKY;

    static {
        CREATOR = new zze();
    }

    public PlayLoggerContext(int i, String str, int i2, int i3, String str2, String str3, boolean z, String str4, boolean z2, int i4) {
        this.versionCode = i;
        this.packageName = str;
        this.zzaKR = i2;
        this.zzaKS = i3;
        this.zzaKT = str2;
        this.zzaKU = str3;
        this.zzaKV = z;
        this.zzaKW = str4;
        this.zzaKX = z2;
        this.zzaKY = i4;
    }

    @Deprecated
    public PlayLoggerContext(String str, int i, int i2, String str2, String str3, boolean z) {
        this.versionCode = 1;
        this.packageName = (String) zzx.zzv(str);
        this.zzaKR = i;
        this.zzaKS = i2;
        this.zzaKW = null;
        this.zzaKT = str2;
        this.zzaKU = str3;
        this.zzaKV = z;
        this.zzaKX = false;
        this.zzaKY = 0;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayLoggerContext)) {
            return false;
        }
        PlayLoggerContext playLoggerContext = (PlayLoggerContext) obj;
        return this.versionCode == playLoggerContext.versionCode && this.packageName.equals(playLoggerContext.packageName) && this.zzaKR == playLoggerContext.zzaKR && this.zzaKS == playLoggerContext.zzaKS && zzw.equal(this.zzaKW, playLoggerContext.zzaKW) && zzw.equal(this.zzaKT, playLoggerContext.zzaKT) && zzw.equal(this.zzaKU, playLoggerContext.zzaKU) && this.zzaKV == playLoggerContext.zzaKV && this.zzaKX == playLoggerContext.zzaKX && this.zzaKY == playLoggerContext.zzaKY;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.versionCode), this.packageName, Integer.valueOf(this.zzaKR), Integer.valueOf(this.zzaKS), this.zzaKW, this.zzaKT, this.zzaKU, Boolean.valueOf(this.zzaKV), Boolean.valueOf(this.zzaKX), Integer.valueOf(this.zzaKY));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PlayLoggerContext[");
        stringBuilder.append("versionCode=").append(this.versionCode).append(',');
        stringBuilder.append("package=").append(this.packageName).append(',');
        stringBuilder.append("packageVersionCode=").append(this.zzaKR).append(',');
        stringBuilder.append("logSource=").append(this.zzaKS).append(',');
        stringBuilder.append("logSourceName=").append(this.zzaKW).append(',');
        stringBuilder.append("uploadAccount=").append(this.zzaKT).append(',');
        stringBuilder.append("loggingId=").append(this.zzaKU).append(',');
        stringBuilder.append("logAndroidId=").append(this.zzaKV).append(',');
        stringBuilder.append("isAnonymous=").append(this.zzaKX).append(',');
        stringBuilder.append("qosTier=").append(this.zzaKY);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }
}
