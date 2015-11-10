package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzgk;
import java.util.Collections;
import java.util.List;

@zzgk
public final class AdResponseParcel implements SafeParcelable {
    public static final zzh CREATOR;
    public String body;
    public final int errorCode;
    public final int orientation;
    public final int versionCode;
    public final String zzAT;
    public final boolean zzDG;
    public final long zzDW;
    public final boolean zzDX;
    public final long zzDY;
    public final List<String> zzDZ;
    public final String zzEa;
    public final long zzEb;
    public final String zzEc;
    public final boolean zzEd;
    public final String zzEe;
    public final String zzEf;
    public final boolean zzEg;
    public final boolean zzEh;
    public final boolean zzEi;
    public final int zzEj;
    public LargeParcelTeleporter zzEk;
    public String zzEl;
    public final boolean zzsJ;
    public final long zzyA;
    private AdRequestInfoParcel zzyd;
    public final List<String> zzyw;
    public final List<String> zzyx;

    static {
        CREATOR = new zzh();
    }

    public AdResponseParcel(int i) {
        this(13, null, null, null, i, null, -1, false, -1, null, -1, -1, null, -1, null, false, null, null, false, false, false, true, false, 0, null, null);
    }

    public AdResponseParcel(int i, long j) {
        this(13, null, null, null, i, null, -1, false, -1, null, j, -1, null, -1, null, false, null, null, false, false, false, true, false, 0, null, null);
    }

    AdResponseParcel(int i, String str, String str2, List<String> list, int i2, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i3, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i4, LargeParcelTeleporter largeParcelTeleporter, String str7) {
        this.versionCode = i;
        this.zzAT = str;
        this.body = str2;
        this.zzyw = list != null ? Collections.unmodifiableList(list) : null;
        this.errorCode = i2;
        this.zzyx = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.zzDW = j;
        this.zzDX = z;
        this.zzDY = j2;
        this.zzDZ = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.zzyA = j3;
        this.orientation = i3;
        this.zzEa = str3;
        this.zzEb = j4;
        this.zzEc = str4;
        this.zzEd = z2;
        this.zzEe = str5;
        this.zzEf = str6;
        this.zzEg = z3;
        this.zzsJ = z4;
        this.zzDG = z5;
        this.zzEh = z6;
        this.zzEi = z7;
        this.zzEj = i4;
        this.zzEk = largeParcelTeleporter;
        this.zzEl = str7;
        if (this.body == null && this.zzEk != null) {
            StringParcel stringParcel = (StringParcel) this.zzEk.zza(StringParcel.CREATOR);
            if (stringParcel != null && !TextUtils.isEmpty(stringParcel.zzfF())) {
                this.body = stringParcel.zzfF();
            }
        }
    }

    public AdResponseParcel(AdRequestInfoParcel adRequestInfoParcel, String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, String str5, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i2) {
        this(13, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4, str4, false, null, str5, z2, z3, z4, z5, z6, i2, null, null);
        this.zzyd = adRequestInfoParcel;
    }

    public AdResponseParcel(AdRequestInfoParcel adRequestInfoParcel, String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i2) {
        this(13, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6, z7, i2, null, null);
        this.zzyd = adRequestInfoParcel;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (!(this.zzyd == null || this.zzyd.versionCode < 9 || TextUtils.isEmpty(this.body))) {
            this.zzEk = new LargeParcelTeleporter(new StringParcel(this.body));
            this.body = null;
        }
        zzh.zza(this, parcel, i);
    }
}
