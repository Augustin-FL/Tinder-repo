package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.appdatasearch.RegisterSectionInfo.zza;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class DocumentSection implements SafeParcelable {
    public static final zzd CREATOR;
    public static final int zzPc;
    private static final RegisterSectionInfo zzPd;
    final int mVersionCode;
    public final String zzPe;
    final RegisterSectionInfo zzPf;
    public final int zzPg;
    public final byte[] zzPh;

    static {
        zzPc = Integer.parseInt("-1");
        CREATOR = new zzd();
        zzPd = new zza("SsbContext").zzM(true).zzby("blob").zzld();
    }

    DocumentSection(int i, String str, RegisterSectionInfo registerSectionInfo, int i2, byte[] bArr) {
        boolean z = i2 == zzPc || zzh.zzaj(i2) != null;
        zzx.zzb(z, "Invalid section type " + i2);
        this.mVersionCode = i;
        this.zzPe = str;
        this.zzPf = registerSectionInfo;
        this.zzPg = i2;
        this.zzPh = bArr;
        String zzla = zzla();
        if (zzla != null) {
            throw new IllegalArgumentException(zzla);
        }
    }

    public DocumentSection(String str, RegisterSectionInfo registerSectionInfo) {
        this(1, str, registerSectionInfo, zzPc, null);
    }

    public DocumentSection(String str, RegisterSectionInfo registerSectionInfo, String str2) {
        this(1, str, registerSectionInfo, zzh.zzbx(str2), null);
    }

    public DocumentSection(byte[] bArr, RegisterSectionInfo registerSectionInfo) {
        this(1, null, registerSectionInfo, zzPc, bArr);
    }

    public static DocumentSection zzh(byte[] bArr) {
        return new DocumentSection(bArr, zzPd);
    }

    public int describeContents() {
        zzd com_google_android_gms_appdatasearch_zzd = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd com_google_android_gms_appdatasearch_zzd = CREATOR;
        zzd.zza(this, parcel, i);
    }

    public RegisterSectionInfo zzkZ() {
        return this.zzPf;
    }

    public String zzla() {
        return (this.zzPg == zzPc || zzh.zzaj(this.zzPg) != null) ? (this.zzPe == null || this.zzPh == null) ? null : "Both content and blobContent set" : "Invalid section type " + this.zzPg;
    }
}
