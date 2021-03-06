package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class zzm implements Creator<Scope> {
    static void zza(Scope scope, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, scope.mVersionCode);
        zzb.zza(parcel, 2, scope.zznG(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzX(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzbg(i);
    }

    public Scope zzX(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case C3374b.SmoothProgressBar_spb_color /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new Scope(i, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public Scope[] zzbg(int i) {
        return new Scope[i];
    }
}
