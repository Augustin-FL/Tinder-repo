package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class BinderWrapper implements Parcelable {
    public static final Creator<BinderWrapper> CREATOR;
    private IBinder zzacE;

    /* renamed from: com.google.android.gms.common.internal.BinderWrapper.1 */
    static class C08121 implements Creator<BinderWrapper> {
        C08121() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return zzad(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return zzbx(i);
        }

        public BinderWrapper zzad(Parcel parcel) {
            return new BinderWrapper(null);
        }

        public BinderWrapper[] zzbx(int i) {
            return new BinderWrapper[i];
        }
    }

    static {
        CREATOR = new C08121();
    }

    public BinderWrapper() {
        this.zzacE = null;
    }

    public BinderWrapper(IBinder iBinder) {
        this.zzacE = null;
        this.zzacE = iBinder;
    }

    private BinderWrapper(Parcel parcel) {
        this.zzacE = null;
        this.zzacE = parcel.readStrongBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.zzacE);
    }
}
