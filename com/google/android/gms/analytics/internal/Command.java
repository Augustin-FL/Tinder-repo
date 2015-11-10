package com.google.android.gms.analytics.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Command implements Parcelable {
    @Deprecated
    public static final Creator<Command> CREATOR;
    private String mValue;
    private String zzMI;
    private String zzwj;

    /* renamed from: com.google.android.gms.analytics.internal.Command.1 */
    static class C07581 implements Creator<Command> {
        C07581() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return zzr(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return zzab(i);
        }

        @Deprecated
        public Command[] zzab(int i) {
            return new Command[i];
        }

        @Deprecated
        public Command zzr(Parcel parcel) {
            return new Command(parcel);
        }
    }

    static {
        CREATOR = new C07581();
    }

    @Deprecated
    Command(Parcel parcel) {
        readFromParcel(parcel);
    }

    @Deprecated
    private void readFromParcel(Parcel parcel) {
        this.zzwj = parcel.readString();
        this.zzMI = parcel.readString();
        this.mValue = parcel.readString();
    }

    @Deprecated
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.zzwj;
    }

    public String getValue() {
        return this.mValue;
    }

    @Deprecated
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzwj);
        parcel.writeString(this.zzMI);
        parcel.writeString(this.mValue);
    }
}
