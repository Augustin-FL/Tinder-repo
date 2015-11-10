package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class RecordConsentRequest implements SafeParcelable {
    public static final Creator<RecordConsentRequest> CREATOR;
    final int mVersionCode;
    private final Account zzOY;
    private final String zzRU;
    private final Scope[] zzaOm;

    static {
        CREATOR = new zzg();
    }

    RecordConsentRequest(int i, Account account, Scope[] scopeArr, String str) {
        this.mVersionCode = i;
        this.zzOY = account;
        this.zzaOm = scopeArr;
        this.zzRU = str;
    }

    public int describeContents() {
        return 0;
    }

    public Account getAccount() {
        return this.zzOY;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }

    public String zzlG() {
        return this.zzRU;
    }

    public Scope[] zzzs() {
        return this.zzaOm;
    }
}
