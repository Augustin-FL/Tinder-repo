package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class Asset implements SafeParcelable {
    public static final Creator<Asset> CREATOR;
    final int mVersionCode;
    public Uri uri;
    private String zzaYK;
    public ParcelFileDescriptor zzaYL;
    private byte[] zzayG;

    static {
        CREATOR = new zze();
    }

    Asset(int i, byte[] bArr, String str, ParcelFileDescriptor parcelFileDescriptor, Uri uri) {
        this.mVersionCode = i;
        this.zzayG = bArr;
        this.zzaYK = str;
        this.zzaYL = parcelFileDescriptor;
        this.uri = uri;
    }

    public static Asset createFromBytes(byte[] bArr) {
        if (bArr != null) {
            return new Asset(1, bArr, null, null, null);
        }
        throw new IllegalArgumentException("Asset data cannot be null");
    }

    public static Asset createFromFd(ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor != null) {
            return new Asset(1, null, null, parcelFileDescriptor, null);
        }
        throw new IllegalArgumentException("Asset fd cannot be null");
    }

    public static Asset createFromRef(String str) {
        if (str != null) {
            return new Asset(1, null, str, null, null);
        }
        throw new IllegalArgumentException("Asset digest cannot be null");
    }

    public static Asset createFromUri(Uri uri) {
        if (uri != null) {
            return new Asset(1, null, null, null, uri);
        }
        throw new IllegalArgumentException("Asset uri cannot be null");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Asset)) {
            return false;
        }
        Asset asset = (Asset) obj;
        return zzw.equal(this.zzayG, asset.zzayG) && zzw.equal(this.zzaYK, asset.zzaYK) && zzw.equal(this.zzaYL, asset.zzaYL) && zzw.equal(this.uri, asset.uri);
    }

    public byte[] getData() {
        return this.zzayG;
    }

    public String getDigest() {
        return this.zzaYK;
    }

    public ParcelFileDescriptor getFd() {
        return this.zzaYL;
    }

    public Uri getUri() {
        return this.uri;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzayG, this.zzaYK, this.zzaYL, this.uri);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Asset[@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        if (this.zzaYK == null) {
            stringBuilder.append(", nodigest");
        } else {
            stringBuilder.append(", ");
            stringBuilder.append(this.zzaYK);
        }
        if (this.zzayG != null) {
            stringBuilder.append(", size=");
            stringBuilder.append(this.zzayG.length);
        }
        if (this.zzaYL != null) {
            stringBuilder.append(", fd=");
            stringBuilder.append(this.zzaYL);
        }
        if (this.uri != null) {
            stringBuilder.append(", uri=");
            stringBuilder.append(this.uri);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i | 1);
    }
}
