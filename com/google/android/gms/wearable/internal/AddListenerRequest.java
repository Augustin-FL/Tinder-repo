package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.zzav.zza;

public class AddListenerRequest implements SafeParcelable {
    public static final Creator<AddListenerRequest> CREATOR;
    final int mVersionCode;
    public final zzav zzaZq;
    public final IntentFilter[] zzaZr;
    public final String zzaZs;
    public final String zzaZt;

    static {
        CREATOR = new zzb();
    }

    AddListenerRequest(int i, IBinder iBinder, IntentFilter[] intentFilterArr, String str, String str2) {
        this.mVersionCode = i;
        if (iBinder != null) {
            this.zzaZq = zza.zzdZ(iBinder);
        } else {
            this.zzaZq = null;
        }
        this.zzaZr = intentFilterArr;
        this.zzaZs = str;
        this.zzaZt = str2;
    }

    public AddListenerRequest(zzbo com_google_android_gms_wearable_internal_zzbo) {
        this.mVersionCode = 1;
        this.zzaZq = com_google_android_gms_wearable_internal_zzbo;
        this.zzaZr = com_google_android_gms_wearable_internal_zzbo.zzCJ();
        this.zzaZs = com_google_android_gms_wearable_internal_zzbo.zzCK();
        this.zzaZt = com_google_android_gms_wearable_internal_zzbo.zzCL();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    IBinder zzCt() {
        return this.zzaZq == null ? null : this.zzaZq.asBinder();
    }
}
