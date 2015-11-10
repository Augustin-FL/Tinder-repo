package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class LocationRequest implements SafeParcelable {
    public static final LocationRequestCreator CREATOR;
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
    public static final int PRIORITY_HIGH_ACCURACY = 100;
    public static final int PRIORITY_LOW_POWER = 104;
    public static final int PRIORITY_NO_POWER = 105;
    int mPriority;
    private final int mVersionCode;
    long zzaBB;
    long zzaBW;
    long zzaBX;
    int zzaBY;
    float zzaBZ;
    long zzaCa;
    boolean zzaqs;

    static {
        CREATOR = new LocationRequestCreator();
    }

    public LocationRequest() {
        this.mVersionCode = 1;
        this.mPriority = PRIORITY_BALANCED_POWER_ACCURACY;
        this.zzaBW = 3600000;
        this.zzaBX = 600000;
        this.zzaqs = false;
        this.zzaBB = Long.MAX_VALUE;
        this.zzaBY = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.zzaBZ = 0.0f;
        this.zzaCa = 0;
    }

    LocationRequest(int i, int i2, long j, long j2, boolean z, long j3, int i3, float f, long j4) {
        this.mVersionCode = i;
        this.mPriority = i2;
        this.zzaBW = j;
        this.zzaBX = j2;
        this.zzaqs = z;
        this.zzaBB = j3;
        this.zzaBY = i3;
        this.zzaBZ = f;
        this.zzaCa = j4;
    }

    public static LocationRequest create() {
        return new LocationRequest();
    }

    private static void zzK(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("invalid interval: " + j);
        }
    }

    private static void zzd(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("invalid displacement: " + f);
        }
    }

    private static void zzgG(int i) {
        switch (i) {
            case PRIORITY_HIGH_ACCURACY /*100*/:
            case PRIORITY_BALANCED_POWER_ACCURACY /*102*/:
            case PRIORITY_LOW_POWER /*104*/:
            case PRIORITY_NO_POWER /*105*/:
            default:
                throw new IllegalArgumentException("invalid quality: " + i);
        }
    }

    public static String zzgH(int i) {
        switch (i) {
            case PRIORITY_HIGH_ACCURACY /*100*/:
                return "PRIORITY_HIGH_ACCURACY";
            case PRIORITY_BALANCED_POWER_ACCURACY /*102*/:
                return "PRIORITY_BALANCED_POWER_ACCURACY";
            case PRIORITY_LOW_POWER /*104*/:
                return "PRIORITY_LOW_POWER";
            case PRIORITY_NO_POWER /*105*/:
                return "PRIORITY_NO_POWER";
            default:
                return "???";
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationRequest)) {
            return false;
        }
        LocationRequest locationRequest = (LocationRequest) obj;
        return this.mPriority == locationRequest.mPriority && this.zzaBW == locationRequest.zzaBW && this.zzaBX == locationRequest.zzaBX && this.zzaqs == locationRequest.zzaqs && this.zzaBB == locationRequest.zzaBB && this.zzaBY == locationRequest.zzaBY && this.zzaBZ == locationRequest.zzaBZ;
    }

    public long getExpirationTime() {
        return this.zzaBB;
    }

    public long getFastestInterval() {
        return this.zzaBX;
    }

    public long getInterval() {
        return this.zzaBW;
    }

    public long getMaxWaitTime() {
        long j = this.zzaCa;
        return j < this.zzaBW ? this.zzaBW : j;
    }

    public int getNumUpdates() {
        return this.zzaBY;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public float getSmallestDisplacement() {
        return this.zzaBZ;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.mPriority), Long.valueOf(this.zzaBW), Long.valueOf(this.zzaBX), Boolean.valueOf(this.zzaqs), Long.valueOf(this.zzaBB), Integer.valueOf(this.zzaBY), Float.valueOf(this.zzaBZ));
    }

    public LocationRequest setExpirationDuration(long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (j > Long.MAX_VALUE - elapsedRealtime) {
            this.zzaBB = Long.MAX_VALUE;
        } else {
            this.zzaBB = elapsedRealtime + j;
        }
        if (this.zzaBB < 0) {
            this.zzaBB = 0;
        }
        return this;
    }

    public LocationRequest setExpirationTime(long j) {
        this.zzaBB = j;
        if (this.zzaBB < 0) {
            this.zzaBB = 0;
        }
        return this;
    }

    public LocationRequest setFastestInterval(long j) {
        zzK(j);
        this.zzaqs = true;
        this.zzaBX = j;
        return this;
    }

    public LocationRequest setInterval(long j) {
        zzK(j);
        this.zzaBW = j;
        if (!this.zzaqs) {
            this.zzaBX = (long) (((double) this.zzaBW) / 6.0d);
        }
        return this;
    }

    public LocationRequest setMaxWaitTime(long j) {
        zzK(j);
        this.zzaCa = j;
        return this;
    }

    public LocationRequest setNumUpdates(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("invalid numUpdates: " + i);
        }
        this.zzaBY = i;
        return this;
    }

    public LocationRequest setPriority(int i) {
        zzgG(i);
        this.mPriority = i;
        return this;
    }

    public LocationRequest setSmallestDisplacement(float f) {
        zzd(f);
        this.zzaBZ = f;
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Request[").append(zzgH(this.mPriority));
        if (this.mPriority != PRIORITY_NO_POWER) {
            stringBuilder.append(" requested=");
            stringBuilder.append(this.zzaBW + "ms");
        }
        stringBuilder.append(" fastest=");
        stringBuilder.append(this.zzaBX + "ms");
        if (this.zzaCa > this.zzaBW) {
            stringBuilder.append(" maxWait=");
            stringBuilder.append(this.zzaCa + "ms");
        }
        if (this.zzaBB != Long.MAX_VALUE) {
            long elapsedRealtime = this.zzaBB - SystemClock.elapsedRealtime();
            stringBuilder.append(" expireIn=");
            stringBuilder.append(elapsedRealtime + "ms");
        }
        if (this.zzaBY != ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
            stringBuilder.append(" num=").append(this.zzaBY);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        LocationRequestCreator.zza(this, parcel, i);
    }
}
