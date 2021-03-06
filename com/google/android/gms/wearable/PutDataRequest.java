package com.google.android.gms.wearable;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class PutDataRequest implements SafeParcelable {
    public static final Creator<PutDataRequest> CREATOR;
    public static final String WEAR_URI_SCHEME = "wear";
    private static final Random zzaYV;
    private final Uri mUri;
    final int mVersionCode;
    private final Bundle zzaYW;
    private byte[] zzayG;

    static {
        CREATOR = new zzh();
        zzaYV = new SecureRandom();
    }

    private PutDataRequest(int i, Uri uri) {
        this(i, uri, new Bundle(), null);
    }

    PutDataRequest(int i, Uri uri, Bundle bundle, byte[] bArr) {
        this.mVersionCode = i;
        this.mUri = uri;
        this.zzaYW = bundle;
        this.zzaYW.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        this.zzayG = bArr;
    }

    public static PutDataRequest create(String str) {
        return zzo(zzfv(str));
    }

    public static PutDataRequest createFromDataItem(DataItem dataItem) {
        PutDataRequest zzo = zzo(dataItem.getUri());
        for (Entry entry : dataItem.getAssets().entrySet()) {
            if (((DataItemAsset) entry.getValue()).getId() == null) {
                throw new IllegalStateException("Cannot create an asset for a put request without a digest: " + ((String) entry.getKey()));
            }
            zzo.putAsset((String) entry.getKey(), Asset.createFromRef(((DataItemAsset) entry.getValue()).getId()));
        }
        zzo.setData(dataItem.getData());
        return zzo;
    }

    public static PutDataRequest createWithAutoAppendedId(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        if (!str.endsWith("/")) {
            stringBuilder.append("/");
        }
        stringBuilder.append("PN").append(zzaYV.nextLong());
        return new PutDataRequest(1, zzfv(stringBuilder.toString()));
    }

    private static Uri zzfv(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("An empty path was supplied.");
        } else if (!str.startsWith("/")) {
            throw new IllegalArgumentException("A path must start with a single / .");
        } else if (!str.startsWith("//")) {
            return new Builder().scheme(WEAR_URI_SCHEME).path(str).build();
        } else {
            throw new IllegalArgumentException("A path must start with a single / .");
        }
    }

    public static PutDataRequest zzo(Uri uri) {
        return new PutDataRequest(1, uri);
    }

    public int describeContents() {
        return 0;
    }

    public Asset getAsset(String str) {
        return (Asset) this.zzaYW.getParcelable(str);
    }

    public Map<String, Asset> getAssets() {
        Map hashMap = new HashMap();
        for (String str : this.zzaYW.keySet()) {
            hashMap.put(str, (Asset) this.zzaYW.getParcelable(str));
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public byte[] getData() {
        return this.zzayG;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public boolean hasAsset(String str) {
        return this.zzaYW.containsKey(str);
    }

    public PutDataRequest putAsset(String str, Asset asset) {
        zzx.zzv(str);
        zzx.zzv(asset);
        this.zzaYW.putParcelable(str, asset);
        return this;
    }

    public PutDataRequest removeAsset(String str) {
        this.zzaYW.remove(str);
        return this;
    }

    public PutDataRequest setData(byte[] bArr) {
        this.zzayG = bArr;
        return this;
    }

    public String toString() {
        return toString(Log.isLoggable(DataMap.TAG, 3));
    }

    public String toString(boolean z) {
        StringBuilder stringBuilder = new StringBuilder("PutDataRequest[");
        stringBuilder.append("dataSz=" + (this.zzayG == null ? "null" : Integer.valueOf(this.zzayG.length)));
        stringBuilder.append(", numAssets=" + this.zzaYW.size());
        stringBuilder.append(", uri=" + this.mUri);
        if (z) {
            stringBuilder.append("]\n  assets: ");
            for (String str : this.zzaYW.keySet()) {
                stringBuilder.append("\n    " + str + ": " + this.zzaYW.getParcelable(str));
            }
            stringBuilder.append("\n  ]");
            return stringBuilder.toString();
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }

    public Bundle zzCr() {
        return this.zzaYW;
    }
}
