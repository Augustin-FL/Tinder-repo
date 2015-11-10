package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzgk;

@zzgk
public final class SearchAdRequestParcel implements SafeParcelable {
    public static final zzae CREATOR;
    public final int backgroundColor;
    public final int versionCode;
    public final int zztA;
    public final int zztB;
    public final int zztC;
    public final int zztD;
    public final int zztE;
    public final int zztF;
    public final int zztG;
    public final String zztH;
    public final int zztI;
    public final String zztJ;
    public final int zztK;
    public final int zztL;
    public final String zztM;

    static {
        CREATOR = new zzae();
    }

    SearchAdRequestParcel(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str, int i10, String str2, int i11, int i12, String str3) {
        this.versionCode = i;
        this.zztA = i2;
        this.backgroundColor = i3;
        this.zztB = i4;
        this.zztC = i5;
        this.zztD = i6;
        this.zztE = i7;
        this.zztF = i8;
        this.zztG = i9;
        this.zztH = str;
        this.zztI = i10;
        this.zztJ = str2;
        this.zztK = i11;
        this.zztL = i12;
        this.zztM = str3;
    }

    public SearchAdRequestParcel(SearchAdRequest searchAdRequest) {
        this.versionCode = 1;
        this.zztA = searchAdRequest.getAnchorTextColor();
        this.backgroundColor = searchAdRequest.getBackgroundColor();
        this.zztB = searchAdRequest.getBackgroundGradientBottom();
        this.zztC = searchAdRequest.getBackgroundGradientTop();
        this.zztD = searchAdRequest.getBorderColor();
        this.zztE = searchAdRequest.getBorderThickness();
        this.zztF = searchAdRequest.getBorderType();
        this.zztG = searchAdRequest.getCallButtonColor();
        this.zztH = searchAdRequest.getCustomChannels();
        this.zztI = searchAdRequest.getDescriptionTextColor();
        this.zztJ = searchAdRequest.getFontFace();
        this.zztK = searchAdRequest.getHeaderTextColor();
        this.zztL = searchAdRequest.getHeaderTextSize();
        this.zztM = searchAdRequest.getQuery();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzae.zza(this, parcel, i);
    }
}
