package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Comparator;

public class DetectedActivity implements SafeParcelable {
    public static final DetectedActivityCreator CREATOR;
    public static final int IN_VEHICLE = 0;
    public static final int ON_BICYCLE = 1;
    public static final int ON_FOOT = 2;
    public static final int RUNNING = 8;
    public static final int STILL = 3;
    public static final int TILTING = 5;
    public static final int UNKNOWN = 4;
    public static final int WALKING = 7;
    public static final Comparator<DetectedActivity> zzaBx;
    private final int mVersionCode;
    int zzaBy;
    int zzaBz;

    /* renamed from: com.google.android.gms.location.DetectedActivity.1 */
    static class C11761 implements Comparator<DetectedActivity> {
        C11761() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return zza((DetectedActivity) obj, (DetectedActivity) obj2);
        }

        public int zza(DetectedActivity detectedActivity, DetectedActivity detectedActivity2) {
            int compareTo = Integer.valueOf(detectedActivity2.getConfidence()).compareTo(Integer.valueOf(detectedActivity.getConfidence()));
            return compareTo == 0 ? Integer.valueOf(detectedActivity.getType()).compareTo(Integer.valueOf(detectedActivity2.getType())) : compareTo;
        }
    }

    static {
        zzaBx = new C11761();
        CREATOR = new DetectedActivityCreator();
    }

    public DetectedActivity(int i, int i2) {
        this.mVersionCode = ON_BICYCLE;
        this.zzaBy = i;
        this.zzaBz = i2;
    }

    public DetectedActivity(int i, int i2, int i3) {
        this.mVersionCode = i;
        this.zzaBy = i2;
        this.zzaBz = i3;
    }

    private int zzgB(int i) {
        return i > 15 ? UNKNOWN : i;
    }

    public static String zzgC(int i) {
        switch (i) {
            case IN_VEHICLE /*0*/:
                return "IN_VEHICLE";
            case ON_BICYCLE /*1*/:
                return "ON_BICYCLE";
            case ON_FOOT /*2*/:
                return "ON_FOOT";
            case STILL /*3*/:
                return "STILL";
            case UNKNOWN /*4*/:
                return "UNKNOWN";
            case TILTING /*5*/:
                return "TILTING";
            case WALKING /*7*/:
                return "WALKING";
            case RUNNING /*8*/:
                return "RUNNING";
            default:
                return Integer.toString(i);
        }
    }

    public int describeContents() {
        return IN_VEHICLE;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DetectedActivity detectedActivity = (DetectedActivity) obj;
        return this.zzaBy == detectedActivity.zzaBy && this.zzaBz == detectedActivity.zzaBz;
    }

    public int getConfidence() {
        return this.zzaBz;
    }

    public int getType() {
        return zzgB(this.zzaBy);
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        Object[] objArr = new Object[ON_FOOT];
        objArr[IN_VEHICLE] = Integer.valueOf(this.zzaBy);
        objArr[ON_BICYCLE] = Integer.valueOf(this.zzaBz);
        return zzw.hashCode(objArr);
    }

    public String toString() {
        return "DetectedActivity [type=" + zzgC(getType()) + ", confidence=" + this.zzaBz + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        DetectedActivityCreator.zza(this, parcel, i);
    }
}
