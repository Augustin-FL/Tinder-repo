package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class zzbb implements Creator<NodeParcelable> {
    static void zza(NodeParcelable nodeParcelable, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, nodeParcelable.mVersionCode);
        zzb.zza(parcel, 2, nodeParcelable.getId(), false);
        zzb.zza(parcel, 3, nodeParcelable.getDisplayName(), false);
        zzb.zzc(parcel, 4, nodeParcelable.getHopCount());
        zzb.zza(parcel, 5, nodeParcelable.isNearby());
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhP(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzla(i);
    }

    public NodeParcelable zzhP(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case C3374b.SmoothProgressBar_spb_color /*1*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case C3374b.SmoothProgressBar_spb_speed /*5*/:
                    z = zza.zzc(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new NodeParcelable(i2, str2, str, i, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public NodeParcelable[] zzla(int i) {
        return new NodeParcelable[i];
    }
}
