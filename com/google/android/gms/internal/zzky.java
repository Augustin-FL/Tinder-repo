package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;

public final class zzky implements zzkx {

    /* renamed from: com.google.android.gms.internal.zzky.1 */
    class C11591 extends zza {
        final /* synthetic */ zzky zzaeu;

        C11591(zzky com_google_android_gms_internal_zzky, GoogleApiClient googleApiClient) {
            this.zzaeu = com_google_android_gms_internal_zzky;
            super(googleApiClient);
        }

        protected void zza(zzla com_google_android_gms_internal_zzla) throws RemoteException {
            ((zzlc) com_google_android_gms_internal_zzla.zzoA()).zza(new zza(this));
        }
    }

    private static class zza extends zzkv {
        private final zzb<Status> zzQz;

        public zza(zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status) {
            this.zzQz = com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status;
        }

        public void zzbI(int i) throws RemoteException {
            this.zzQz.zzn(new Status(i));
        }
    }

    public PendingResult<Status> zzc(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new C11591(this, googleApiClient));
    }
}
