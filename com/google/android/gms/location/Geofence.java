package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.location.internal.ParcelableGeofence;

public interface Geofence {
    public static final int GEOFENCE_TRANSITION_DWELL = 4;
    public static final int GEOFENCE_TRANSITION_ENTER = 1;
    public static final int GEOFENCE_TRANSITION_EXIT = 2;
    public static final long NEVER_EXPIRE = -1;

    public static final class Builder {
        private String zzBm;
        private int zzaBA;
        private long zzaBB;
        private short zzaBC;
        private double zzaBD;
        private double zzaBE;
        private float zzaBF;
        private int zzaBG;
        private int zzaBH;

        public Builder() {
            this.zzBm = null;
            this.zzaBA = 0;
            this.zzaBB = Long.MIN_VALUE;
            this.zzaBC = (short) -1;
            this.zzaBG = 0;
            this.zzaBH = -1;
        }

        public Geofence build() {
            if (this.zzBm == null) {
                throw new IllegalArgumentException("Request ID not set.");
            } else if (this.zzaBA == 0) {
                throw new IllegalArgumentException("Transitions types not set.");
            } else if ((this.zzaBA & Geofence.GEOFENCE_TRANSITION_DWELL) != 0 && this.zzaBH < 0) {
                throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
            } else if (this.zzaBB == Long.MIN_VALUE) {
                throw new IllegalArgumentException("Expiration not set.");
            } else if (this.zzaBC == (short) -1) {
                throw new IllegalArgumentException("Geofence region not set.");
            } else if (this.zzaBG >= 0) {
                return new ParcelableGeofence(this.zzBm, this.zzaBA, (short) 1, this.zzaBD, this.zzaBE, this.zzaBF, this.zzaBB, this.zzaBG, this.zzaBH);
            } else {
                throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
            }
        }

        public Builder setCircularRegion(double d, double d2, float f) {
            this.zzaBC = (short) 1;
            this.zzaBD = d;
            this.zzaBE = d2;
            this.zzaBF = f;
            return this;
        }

        public Builder setExpirationDuration(long j) {
            if (j < 0) {
                this.zzaBB = Geofence.NEVER_EXPIRE;
            } else {
                this.zzaBB = SystemClock.elapsedRealtime() + j;
            }
            return this;
        }

        public Builder setLoiteringDelay(int i) {
            this.zzaBH = i;
            return this;
        }

        public Builder setNotificationResponsiveness(int i) {
            this.zzaBG = i;
            return this;
        }

        public Builder setRequestId(String str) {
            this.zzBm = str;
            return this;
        }

        public Builder setTransitionTypes(int i) {
            this.zzaBA = i;
            return this;
        }
    }

    String getRequestId();
}
