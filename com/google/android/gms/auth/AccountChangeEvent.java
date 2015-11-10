package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class AccountChangeEvent implements SafeParcelable {
    public static final Creator<AccountChangeEvent> CREATOR;
    final int mVersion;
    final long zzQD;
    final String zzQE;
    final int zzQF;
    final int zzQG;
    final String zzQH;

    static {
        CREATOR = new zza();
    }

    AccountChangeEvent(int i, long j, String str, int i2, int i3, String str2) {
        this.mVersion = i;
        this.zzQD = j;
        this.zzQE = (String) zzx.zzv(str);
        this.zzQF = i2;
        this.zzQG = i3;
        this.zzQH = str2;
    }

    public AccountChangeEvent(long j, String str, int i, int i2, String str2) {
        this.mVersion = 1;
        this.zzQD = j;
        this.zzQE = (String) zzx.zzv(str);
        this.zzQF = i;
        this.zzQG = i2;
        this.zzQH = str2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AccountChangeEvent)) {
            return false;
        }
        AccountChangeEvent accountChangeEvent = (AccountChangeEvent) obj;
        return this.mVersion == accountChangeEvent.mVersion && this.zzQD == accountChangeEvent.zzQD && zzw.equal(this.zzQE, accountChangeEvent.zzQE) && this.zzQF == accountChangeEvent.zzQF && this.zzQG == accountChangeEvent.zzQG && zzw.equal(this.zzQH, accountChangeEvent.zzQH);
    }

    public String getAccountName() {
        return this.zzQE;
    }

    public String getChangeData() {
        return this.zzQH;
    }

    public int getChangeType() {
        return this.zzQF;
    }

    public int getEventIndex() {
        return this.zzQG;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.mVersion), Long.valueOf(this.zzQD), this.zzQE, Integer.valueOf(this.zzQF), Integer.valueOf(this.zzQG), this.zzQH);
    }

    public String toString() {
        String str = "UNKNOWN";
        switch (this.zzQF) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                str = "ADDED";
                break;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                str = "REMOVED";
                break;
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                str = "RENAMED_FROM";
                break;
            case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                str = "RENAMED_TO";
                break;
        }
        return "AccountChangeEvent {accountName = " + this.zzQE + ", changeType = " + str + ", changeData = " + this.zzQH + ", eventIndex = " + this.zzQG + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
