package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class zzd<T extends SafeParcelable> extends AbstractDataBuffer<T> {
    private static final String[] zzabi;
    private final Creator<T> zzabj;

    static {
        zzabi = new String[]{ShareConstants.WEB_DIALOG_PARAM_DATA};
    }

    public zzd(DataHolder dataHolder, Creator<T> creator) {
        super(dataHolder);
        this.zzabj = creator;
    }

    public /* synthetic */ Object get(int i) {
        return zzbn(i);
    }

    public T zzbn(int i) {
        byte[] zzg = this.zzYX.zzg(ShareConstants.WEB_DIALOG_PARAM_DATA, i, this.zzYX.zzbo(i));
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(zzg, 0, zzg.length);
        obtain.setDataPosition(0);
        SafeParcelable safeParcelable = (SafeParcelable) this.zzabj.createFromParcel(obtain);
        obtain.recycle();
        return safeParcelable;
    }
}
