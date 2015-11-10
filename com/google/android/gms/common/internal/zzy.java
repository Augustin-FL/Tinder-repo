package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class zzy implements Creator<ResolveAccountRequest> {
    static void zza(ResolveAccountRequest resolveAccountRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, resolveAccountRequest.mVersionCode);
        zzb.zza(parcel, 2, resolveAccountRequest.getAccount(), i, false);
        zzb.zzc(parcel, 3, resolveAccountRequest.getSessionId());
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzaf(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzbE(i);
    }

    public ResolveAccountRequest zzaf(Parcel parcel) {
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        Account account = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            Account account2;
            int zzg;
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case C3374b.SmoothProgressBar_spb_color /*1*/:
                    int i3 = i;
                    account2 = account;
                    zzg = zza.zzg(parcel, zzai);
                    zzai = i3;
                    break;
                case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                    zzg = i2;
                    Account account3 = (Account) zza.zza(parcel, zzai, Account.CREATOR);
                    zzai = i;
                    account2 = account3;
                    break;
                case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                    zzai = zza.zzg(parcel, zzai);
                    account2 = account;
                    zzg = i2;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    zzai = i;
                    account2 = account;
                    zzg = i2;
                    break;
            }
            i2 = zzg;
            account = account2;
            i = zzai;
        }
        if (parcel.dataPosition() == zzaj) {
            return new ResolveAccountRequest(i2, account, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public ResolveAccountRequest[] zzbE(int i) {
        return new ResolveAccountRequest[i];
    }
}
