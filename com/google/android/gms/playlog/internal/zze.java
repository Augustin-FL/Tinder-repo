package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class zze implements Creator<PlayLoggerContext> {
    static void zza(PlayLoggerContext playLoggerContext, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, playLoggerContext.versionCode);
        zzb.zza(parcel, 2, playLoggerContext.packageName, false);
        zzb.zzc(parcel, 3, playLoggerContext.zzaKR);
        zzb.zzc(parcel, 4, playLoggerContext.zzaKS);
        zzb.zza(parcel, 5, playLoggerContext.zzaKT, false);
        zzb.zza(parcel, 6, playLoggerContext.zzaKU, false);
        zzb.zza(parcel, 7, playLoggerContext.zzaKV);
        zzb.zza(parcel, 8, playLoggerContext.zzaKW, false);
        zzb.zza(parcel, 9, playLoggerContext.zzaKX);
        zzb.zzc(parcel, 10, playLoggerContext.zzaKY);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfQ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zziE(i);
    }

    public PlayLoggerContext zzfQ(Parcel parcel) {
        String str = null;
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        boolean z = true;
        boolean z2 = false;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        int i3 = 0;
        String str4 = null;
        int i4 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case C3374b.SmoothProgressBar_spb_color /*1*/:
                    i4 = zza.zzg(parcel, zzai);
                    break;
                case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                    str4 = zza.zzo(parcel, zzai);
                    break;
                case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case C3374b.SmoothProgressBar_spb_speed /*5*/:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case C3374b.SmoothProgressBar_spb_progressiveStart_speed /*6*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case C3374b.SmoothProgressBar_spb_progressiveStop_speed /*7*/:
                    z = zza.zzc(parcel, zzai);
                    break;
                case C3374b.SmoothProgressBar_spb_interpolator /*8*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case C3374b.SmoothProgressBar_spb_reversed /*9*/:
                    z2 = zza.zzc(parcel, zzai);
                    break;
                case C3374b.SmoothProgressBar_spb_mirror_mode /*10*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new PlayLoggerContext(i4, str4, i3, i2, str3, str2, z, str, z2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public PlayLoggerContext[] zziE(int i) {
        return new PlayLoggerContext[i];
    }
}
