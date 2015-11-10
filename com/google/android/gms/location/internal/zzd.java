package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

public class zzd implements FusedLocationProviderApi {

    private static abstract class zza extends com.google.android.gms.location.LocationServices.zza<Status> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        public Status zzd(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.location.internal.zzd.1 */
    class C11841 extends zza {
        final /* synthetic */ LocationRequest zzaCA;
        final /* synthetic */ LocationListener zzaCB;
        final /* synthetic */ zzd zzaCC;

        C11841(zzd com_google_android_gms_location_internal_zzd, GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener) {
            this.zzaCC = com_google_android_gms_location_internal_zzd;
            this.zzaCA = locationRequest;
            this.zzaCB = locationListener;
            super(googleApiClient);
        }

        protected void zza(zzj com_google_android_gms_location_internal_zzj) throws RemoteException {
            com_google_android_gms_location_internal_zzj.zza(this.zzaCA, this.zzaCB, null);
            zza(Status.zzaaD);
        }
    }

    /* renamed from: com.google.android.gms.location.internal.zzd.2 */
    class C11852 extends zza {
        final /* synthetic */ zzd zzaCC;
        final /* synthetic */ boolean zzaCD;

        C11852(zzd com_google_android_gms_location_internal_zzd, GoogleApiClient googleApiClient, boolean z) {
            this.zzaCC = com_google_android_gms_location_internal_zzd;
            this.zzaCD = z;
            super(googleApiClient);
        }

        protected void zza(zzj com_google_android_gms_location_internal_zzj) throws RemoteException {
            com_google_android_gms_location_internal_zzj.zzag(this.zzaCD);
            zza(Status.zzaaD);
        }
    }

    /* renamed from: com.google.android.gms.location.internal.zzd.3 */
    class C11863 extends zza {
        final /* synthetic */ zzd zzaCC;
        final /* synthetic */ Location zzaCE;

        C11863(zzd com_google_android_gms_location_internal_zzd, GoogleApiClient googleApiClient, Location location) {
            this.zzaCC = com_google_android_gms_location_internal_zzd;
            this.zzaCE = location;
            super(googleApiClient);
        }

        protected void zza(zzj com_google_android_gms_location_internal_zzj) throws RemoteException {
            com_google_android_gms_location_internal_zzj.zzb(this.zzaCE);
            zza(Status.zzaaD);
        }
    }

    /* renamed from: com.google.android.gms.location.internal.zzd.4 */
    class C11874 extends zza {
        final /* synthetic */ LocationRequest zzaCA;
        final /* synthetic */ LocationListener zzaCB;
        final /* synthetic */ zzd zzaCC;
        final /* synthetic */ Looper zzaCF;

        C11874(zzd com_google_android_gms_location_internal_zzd, GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener, Looper looper) {
            this.zzaCC = com_google_android_gms_location_internal_zzd;
            this.zzaCA = locationRequest;
            this.zzaCB = locationListener;
            this.zzaCF = looper;
            super(googleApiClient);
        }

        protected void zza(zzj com_google_android_gms_location_internal_zzj) throws RemoteException {
            com_google_android_gms_location_internal_zzj.zza(this.zzaCA, this.zzaCB, this.zzaCF);
            zza(Status.zzaaD);
        }
    }

    /* renamed from: com.google.android.gms.location.internal.zzd.5 */
    class C11885 extends zza {
        final /* synthetic */ LocationRequest zzaCA;
        final /* synthetic */ zzd zzaCC;
        final /* synthetic */ Looper zzaCF;
        final /* synthetic */ LocationCallback zzaCG;

        C11885(zzd com_google_android_gms_location_internal_zzd, GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationCallback locationCallback, Looper looper) {
            this.zzaCC = com_google_android_gms_location_internal_zzd;
            this.zzaCA = locationRequest;
            this.zzaCG = locationCallback;
            this.zzaCF = looper;
            super(googleApiClient);
        }

        protected void zza(zzj com_google_android_gms_location_internal_zzj) throws RemoteException {
            com_google_android_gms_location_internal_zzj.zza(LocationRequestInternal.zzb(this.zzaCA), this.zzaCG, this.zzaCF);
            zza(Status.zzaaD);
        }
    }

    /* renamed from: com.google.android.gms.location.internal.zzd.6 */
    class C11896 extends zza {
        final /* synthetic */ LocationRequest zzaCA;
        final /* synthetic */ zzd zzaCC;
        final /* synthetic */ PendingIntent zzaCw;

        C11896(zzd com_google_android_gms_location_internal_zzd, GoogleApiClient googleApiClient, LocationRequest locationRequest, PendingIntent pendingIntent) {
            this.zzaCC = com_google_android_gms_location_internal_zzd;
            this.zzaCA = locationRequest;
            this.zzaCw = pendingIntent;
            super(googleApiClient);
        }

        protected void zza(zzj com_google_android_gms_location_internal_zzj) throws RemoteException {
            com_google_android_gms_location_internal_zzj.zzb(this.zzaCA, this.zzaCw);
            zza(Status.zzaaD);
        }
    }

    /* renamed from: com.google.android.gms.location.internal.zzd.7 */
    class C11907 extends zza {
        final /* synthetic */ LocationListener zzaCB;
        final /* synthetic */ zzd zzaCC;

        C11907(zzd com_google_android_gms_location_internal_zzd, GoogleApiClient googleApiClient, LocationListener locationListener) {
            this.zzaCC = com_google_android_gms_location_internal_zzd;
            this.zzaCB = locationListener;
            super(googleApiClient);
        }

        protected void zza(zzj com_google_android_gms_location_internal_zzj) throws RemoteException {
            com_google_android_gms_location_internal_zzj.zza(this.zzaCB);
            zza(Status.zzaaD);
        }
    }

    /* renamed from: com.google.android.gms.location.internal.zzd.8 */
    class C11918 extends zza {
        final /* synthetic */ zzd zzaCC;
        final /* synthetic */ PendingIntent zzaCw;

        C11918(zzd com_google_android_gms_location_internal_zzd, GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
            this.zzaCC = com_google_android_gms_location_internal_zzd;
            this.zzaCw = pendingIntent;
            super(googleApiClient);
        }

        protected void zza(zzj com_google_android_gms_location_internal_zzj) throws RemoteException {
            com_google_android_gms_location_internal_zzj.zzf(this.zzaCw);
            zza(Status.zzaaD);
        }
    }

    /* renamed from: com.google.android.gms.location.internal.zzd.9 */
    class C11929 extends zza {
        final /* synthetic */ zzd zzaCC;
        final /* synthetic */ LocationCallback zzaCG;

        C11929(zzd com_google_android_gms_location_internal_zzd, GoogleApiClient googleApiClient, LocationCallback locationCallback) {
            this.zzaCC = com_google_android_gms_location_internal_zzd;
            this.zzaCG = locationCallback;
            super(googleApiClient);
        }

        protected void zza(zzj com_google_android_gms_location_internal_zzj) throws RemoteException {
            com_google_android_gms_location_internal_zzj.zza(this.zzaCG);
            zza(Status.zzaaD);
        }
    }

    public Location getLastLocation(GoogleApiClient googleApiClient) {
        try {
            return LocationServices.zze(googleApiClient).getLastLocation();
        } catch (Exception e) {
            return null;
        }
    }

    public LocationAvailability getLocationAvailability(GoogleApiClient googleApiClient) {
        try {
            return LocationServices.zze(googleApiClient).zzvQ();
        } catch (Exception e) {
            return null;
        }
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return googleApiClient.zzb(new C11918(this, googleApiClient, pendingIntent));
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient googleApiClient, LocationCallback locationCallback) {
        return googleApiClient.zzb(new C11929(this, googleApiClient, locationCallback));
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient googleApiClient, LocationListener locationListener) {
        return googleApiClient.zzb(new C11907(this, googleApiClient, locationListener));
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, PendingIntent pendingIntent) {
        return googleApiClient.zzb(new C11896(this, googleApiClient, locationRequest, pendingIntent));
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationCallback locationCallback, Looper looper) {
        return googleApiClient.zzb(new C11885(this, googleApiClient, locationRequest, locationCallback, looper));
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener) {
        return googleApiClient.zzb(new C11841(this, googleApiClient, locationRequest, locationListener));
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener, Looper looper) {
        return googleApiClient.zzb(new C11874(this, googleApiClient, locationRequest, locationListener, looper));
    }

    public PendingResult<Status> setMockLocation(GoogleApiClient googleApiClient, Location location) {
        return googleApiClient.zzb(new C11863(this, googleApiClient, location));
    }

    public PendingResult<Status> setMockMode(GoogleApiClient googleApiClient, boolean z) {
        return googleApiClient.zzb(new C11852(this, googleApiClient, z));
    }
}
