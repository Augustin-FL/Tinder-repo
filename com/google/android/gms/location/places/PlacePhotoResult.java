package com.google.android.gms.location.places;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class PlacePhotoResult implements Result, SafeParcelable {
    public static final Creator<PlacePhotoResult> CREATOR;
    private final Bitmap mBitmap;
    final int mVersionCode;
    private final Status zzQA;
    final BitmapTeleporter zzaDG;

    static {
        CREATOR = new zzi();
    }

    PlacePhotoResult(int i, Status status, BitmapTeleporter bitmapTeleporter) {
        this.mVersionCode = i;
        this.zzQA = status;
        this.zzaDG = bitmapTeleporter;
        if (this.zzaDG != null) {
            this.mBitmap = bitmapTeleporter.zznQ();
        } else {
            this.mBitmap = null;
        }
    }

    public PlacePhotoResult(Status status, BitmapTeleporter bitmapTeleporter) {
        this.mVersionCode = 0;
        this.zzQA = status;
        this.zzaDG = bitmapTeleporter;
        if (this.zzaDG != null) {
            this.mBitmap = bitmapTeleporter.zznQ();
        } else {
            this.mBitmap = null;
        }
    }

    public int describeContents() {
        return 0;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Status getStatus() {
        return this.zzQA;
    }

    public String toString() {
        return zzw.zzu(this).zzg(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, this.zzQA).zzg("bitmap", this.mBitmap).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }
}
