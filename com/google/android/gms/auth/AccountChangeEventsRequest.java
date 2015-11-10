package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountChangeEventsRequest implements SafeParcelable {
    public static final Creator<AccountChangeEventsRequest> CREATOR;
    final int mVersion;
    Account zzOY;
    @Deprecated
    String zzQE;
    int zzQG;

    static {
        CREATOR = new zzb();
    }

    public AccountChangeEventsRequest() {
        this.mVersion = 1;
    }

    AccountChangeEventsRequest(int i, int i2, String str, Account account) {
        this.mVersion = i;
        this.zzQG = i2;
        this.zzQE = str;
        if (account != null || TextUtils.isEmpty(str)) {
            this.zzOY = account;
        } else {
            this.zzOY = new Account(str, GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);
        }
    }

    public int describeContents() {
        return 0;
    }

    public Account getAccount() {
        return this.zzOY;
    }

    public String getAccountName() {
        return this.zzQE;
    }

    public int getEventIndex() {
        return this.zzQG;
    }

    public AccountChangeEventsRequest setAccount(Account account) {
        this.zzOY = account;
        return this;
    }

    public AccountChangeEventsRequest setAccountName(String str) {
        this.zzQE = str;
        return this;
    }

    public AccountChangeEventsRequest setEventIndex(int i) {
        this.zzQG = i;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
