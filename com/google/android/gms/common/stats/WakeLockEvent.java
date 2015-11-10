package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public final class WakeLockEvent implements SafeParcelable {
    public static final Creator<WakeLockEvent> CREATOR;
    final int mVersionCode;
    private final String zzafS;
    private final int zzafT;
    private final List<String> zzafU;
    private final String zzafV;
    private int zzafW;
    private final String zzafX;
    private final String zzafY;
    private final float zzafZ;
    private final long zzafj;
    private int zzafk;
    private final long zzafr;
    private long zzaft;

    static {
        CREATOR = new zzg();
    }

    WakeLockEvent(int i, long j, int i2, String str, int i3, List<String> list, String str2, long j2, int i4, String str3, String str4, float f) {
        this.mVersionCode = i;
        this.zzafj = j;
        this.zzafk = i2;
        this.zzafS = str;
        this.zzafX = str3;
        this.zzafT = i3;
        this.zzaft = -1;
        this.zzafU = list;
        this.zzafV = str2;
        this.zzafr = j2;
        this.zzafW = i4;
        this.zzafY = str4;
        this.zzafZ = f;
    }

    public WakeLockEvent(long j, int i, String str, int i2, List<String> list, String str2, long j2, int i3, String str3, String str4, float f) {
        this(1, j, i, str, i2, list, str2, j2, i3, str3, str4, f);
    }

    public int describeContents() {
        return 0;
    }

    public int getEventType() {
        return this.zzafk;
    }

    public long getTimeMillis() {
        return this.zzafj;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }

    public String zzpA() {
        return this.zzafV;
    }

    public long zzpC() {
        return this.zzafr;
    }

    public String zzpE() {
        return this.zzafS;
    }

    public String zzpF() {
        return this.zzafX;
    }

    public int zzpG() {
        return this.zzafT;
    }

    public List<String> zzpH() {
        return this.zzafU;
    }

    public int zzpI() {
        return this.zzafW;
    }

    public String zzpJ() {
        return this.zzafY;
    }

    public float zzpK() {
        return this.zzafZ;
    }
}
