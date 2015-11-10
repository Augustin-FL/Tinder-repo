package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.Locale;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class ParcelableGeofence implements SafeParcelable, Geofence {
    public static final zzm CREATOR;
    private final int mVersionCode;
    private final String zzBm;
    private final int zzaBA;
    private final short zzaBC;
    private final double zzaBD;
    private final double zzaBE;
    private final float zzaBF;
    private final int zzaBG;
    private final int zzaBH;
    private final long zzaDd;

    static {
        CREATOR = new zzm();
    }

    public ParcelableGeofence(int i, String str, int i2, short s, double d, double d2, float f, long j, int i3, int i4) {
        zzdy(str);
        zze(f);
        zza(d, d2);
        int zzgT = zzgT(i2);
        this.mVersionCode = i;
        this.zzaBC = s;
        this.zzBm = str;
        this.zzaBD = d;
        this.zzaBE = d2;
        this.zzaBF = f;
        this.zzaDd = j;
        this.zzaBA = zzgT;
        this.zzaBG = i3;
        this.zzaBH = i4;
    }

    public ParcelableGeofence(String str, int i, short s, double d, double d2, float f, long j, int i2, int i3) {
        this(1, str, i, s, d, d2, f, j, i2, i3);
    }

    private static void zza(double d, double d2) {
        if (d > 90.0d || d < -90.0d) {
            throw new IllegalArgumentException("invalid latitude: " + d);
        } else if (d2 > 180.0d || d2 < -180.0d) {
            throw new IllegalArgumentException("invalid longitude: " + d2);
        }
    }

    private static void zzdy(String str) {
        if (str == null || str.length() > 100) {
            throw new IllegalArgumentException("requestId is null or too long: " + str);
        }
    }

    private static void zze(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("invalid radius: " + f);
        }
    }

    private static int zzgT(int i) {
        int i2 = i & 7;
        if (i2 != 0) {
            return i2;
        }
        throw new IllegalArgumentException("No supported transition specified: " + i);
    }

    private static String zzgU(int i) {
        switch (i) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                return "CIRCLE";
            default:
                return null;
        }
    }

    public static ParcelableGeofence zzn(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        ParcelableGeofence zzey = CREATOR.zzey(obtain);
        obtain.recycle();
        return zzey;
    }

    public int describeContents() {
        zzm com_google_android_gms_location_internal_zzm = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ParcelableGeofence)) {
            return false;
        }
        ParcelableGeofence parcelableGeofence = (ParcelableGeofence) obj;
        return this.zzaBF != parcelableGeofence.zzaBF ? false : this.zzaBD != parcelableGeofence.zzaBD ? false : this.zzaBE != parcelableGeofence.zzaBE ? false : this.zzaBC == parcelableGeofence.zzaBC;
    }

    public long getExpirationTime() {
        return this.zzaDd;
    }

    public double getLatitude() {
        return this.zzaBD;
    }

    public double getLongitude() {
        return this.zzaBE;
    }

    public int getNotificationResponsiveness() {
        return this.zzaBG;
    }

    public String getRequestId() {
        return this.zzBm;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.zzaBD);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.zzaBE);
        return (((((((i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + Float.floatToIntBits(this.zzaBF)) * 31) + this.zzaBC) * 31) + this.zzaBA;
    }

    public String toString() {
        return String.format(Locale.US, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", new Object[]{zzgU(this.zzaBC), this.zzBm, Integer.valueOf(this.zzaBA), Double.valueOf(this.zzaBD), Double.valueOf(this.zzaBE), Float.valueOf(this.zzaBF), Integer.valueOf(this.zzaBG / LocationStatusCodes.GEOFENCE_NOT_AVAILABLE), Integer.valueOf(this.zzaBH), Long.valueOf(this.zzaDd)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzm com_google_android_gms_location_internal_zzm = CREATOR;
        zzm.zza(this, parcel, i);
    }

    public short zzvU() {
        return this.zzaBC;
    }

    public float zzvV() {
        return this.zzaBF;
    }

    public int zzvW() {
        return this.zzaBA;
    }

    public int zzvX() {
        return this.zzaBH;
    }
}
