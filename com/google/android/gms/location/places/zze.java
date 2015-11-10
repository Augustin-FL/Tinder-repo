package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.location.LocationStatusCodes;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class zze implements Creator<NearbyAlertRequest> {
    static void zza(NearbyAlertRequest nearbyAlertRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, nearbyAlertRequest.zzvW());
        zzb.zzc(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, nearbyAlertRequest.getVersionCode());
        zzb.zzc(parcel, 2, nearbyAlertRequest.zzvZ());
        zzb.zza(parcel, 3, nearbyAlertRequest.zzwa(), i, false);
        zzb.zza(parcel, 4, nearbyAlertRequest.zzwb(), i, false);
        zzb.zza(parcel, 5, nearbyAlertRequest.zzwc());
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeC(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgZ(i);
    }

    public NearbyAlertRequest zzeC(Parcel parcel) {
        NearbyAlertFilter nearbyAlertFilter = null;
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        int i = -1;
        PlaceFilter placeFilter = null;
        int i2 = 0;
        int i3 = 0;
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
                    placeFilter = (PlaceFilter) zza.zza(parcel, zzai, PlaceFilter.CREATOR);
                    break;
                case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                    nearbyAlertFilter = (NearbyAlertFilter) zza.zza(parcel, zzai, NearbyAlertFilter.CREATOR);
                    break;
                case C3374b.SmoothProgressBar_spb_speed /*5*/:
                    z = zza.zzc(parcel, zzai);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new NearbyAlertRequest(i3, i2, i, placeFilter, nearbyAlertFilter, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public NearbyAlertRequest[] zzgZ(int i) {
        return new NearbyAlertRequest[i];
    }
}
