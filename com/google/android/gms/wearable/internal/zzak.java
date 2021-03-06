package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class zzak implements Creator<GetCloudSyncOptInOutDoneResponse> {
    static void zza(GetCloudSyncOptInOutDoneResponse getCloudSyncOptInOutDoneResponse, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, getCloudSyncOptInOutDoneResponse.versionCode);
        zzb.zzc(parcel, 2, getCloudSyncOptInOutDoneResponse.statusCode);
        zzb.zza(parcel, 3, getCloudSyncOptInOutDoneResponse.zzbau);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhF(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzkQ(i);
    }

    public GetCloudSyncOptInOutDoneResponse zzhF(Parcel parcel) {
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case C3374b.SmoothProgressBar_spb_color /*1*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                    z = zza.zzc(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new GetCloudSyncOptInOutDoneResponse(i2, i, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public GetCloudSyncOptInOutDoneResponse[] zzkQ(int i) {
        return new GetCloudSyncOptInOutDoneResponse[i];
    }
}
