package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.DataItemAsset;

public class DataItemAssetParcelable implements SafeParcelable, DataItemAsset {
    public static final Creator<DataItemAssetParcelable> CREATOR;
    final int mVersionCode;
    private final String zztP;
    private final String zzwj;

    static {
        CREATOR = new zzaa();
    }

    DataItemAssetParcelable(int i, String str, String str2) {
        this.mVersionCode = i;
        this.zzwj = str;
        this.zztP = str2;
    }

    public DataItemAssetParcelable(DataItemAsset dataItemAsset) {
        this.mVersionCode = 1;
        this.zzwj = (String) zzx.zzv(dataItemAsset.getId());
        this.zztP = (String) zzx.zzv(dataItemAsset.getDataItemKey());
    }

    public int describeContents() {
        return 0;
    }

    public /* synthetic */ Object freeze() {
        return zzCF();
    }

    public String getDataItemKey() {
        return this.zztP;
    }

    public String getId() {
        return this.zzwj;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataItemAssetParcelable[");
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        if (this.zzwj == null) {
            stringBuilder.append(",noid");
        } else {
            stringBuilder.append(",");
            stringBuilder.append(this.zzwj);
        }
        stringBuilder.append(", key=");
        stringBuilder.append(this.zztP);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaa.zza(this, parcel, i);
    }

    public DataItemAsset zzCF() {
        return this;
    }
}
