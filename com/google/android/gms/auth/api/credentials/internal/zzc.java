package com.google.android.gms.auth.api.credentials.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;

public final class zzc implements CredentialsApi {

    /* renamed from: com.google.android.gms.auth.api.credentials.internal.zzc.1 */
    class C07911 extends zzd<CredentialRequestResult> {
        final /* synthetic */ CredentialRequest zzRy;
        final /* synthetic */ zzc zzRz;

        /* renamed from: com.google.android.gms.auth.api.credentials.internal.zzc.1.1 */
        class C07901 extends zza {
            final /* synthetic */ C07911 zzRA;

            C07901(C07911 c07911) {
                this.zzRA = c07911;
            }

            public void zza(Status status, Credential credential) {
                this.zzRA.zza(new zzb(status, credential));
            }
        }

        C07911(zzc com_google_android_gms_auth_api_credentials_internal_zzc, GoogleApiClient googleApiClient, CredentialRequest credentialRequest) {
            this.zzRz = com_google_android_gms_auth_api_credentials_internal_zzc;
            this.zzRy = credentialRequest;
            super(googleApiClient);
        }

        protected void zza(Context context, zzh com_google_android_gms_auth_api_credentials_internal_zzh) throws RemoteException {
            com_google_android_gms_auth_api_credentials_internal_zzh.zza(new C07901(this), this.zzRy);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzn(status);
        }

        protected CredentialRequestResult zzn(Status status) {
            return zzb.zzm(status);
        }
    }

    /* renamed from: com.google.android.gms.auth.api.credentials.internal.zzc.2 */
    class C07922 extends zzd<Status> {
        final /* synthetic */ Credential zzRB;
        final /* synthetic */ zzc zzRz;

        C07922(zzc com_google_android_gms_auth_api_credentials_internal_zzc, GoogleApiClient googleApiClient, Credential credential) {
            this.zzRz = com_google_android_gms_auth_api_credentials_internal_zzc;
            this.zzRB = credential;
            super(googleApiClient);
        }

        protected void zza(Context context, zzh com_google_android_gms_auth_api_credentials_internal_zzh) throws RemoteException {
            com_google_android_gms_auth_api_credentials_internal_zzh.zza(new zza(this), new SaveRequest(this.zzRB));
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        protected Status zzd(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.auth.api.credentials.internal.zzc.3 */
    class C07933 extends zzd<Status> {
        final /* synthetic */ Credential zzRB;
        final /* synthetic */ zzc zzRz;

        C07933(zzc com_google_android_gms_auth_api_credentials_internal_zzc, GoogleApiClient googleApiClient, Credential credential) {
            this.zzRz = com_google_android_gms_auth_api_credentials_internal_zzc;
            this.zzRB = credential;
            super(googleApiClient);
        }

        protected void zza(Context context, zzh com_google_android_gms_auth_api_credentials_internal_zzh) throws RemoteException {
            com_google_android_gms_auth_api_credentials_internal_zzh.zza(new zza(this), new DeleteRequest(this.zzRB));
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        protected Status zzd(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.auth.api.credentials.internal.zzc.4 */
    class C07944 extends zzd<Status> {
        final /* synthetic */ zzc zzRz;

        C07944(zzc com_google_android_gms_auth_api_credentials_internal_zzc, GoogleApiClient googleApiClient) {
            this.zzRz = com_google_android_gms_auth_api_credentials_internal_zzc;
            super(googleApiClient);
        }

        protected void zza(Context context, zzh com_google_android_gms_auth_api_credentials_internal_zzh) throws RemoteException {
            com_google_android_gms_auth_api_credentials_internal_zzh.zza(new zza(this));
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        protected Status zzd(Status status) {
            return status;
        }
    }

    private static class zza extends zza {
        private zzb<Status> zzRC;

        zza(zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status) {
            this.zzRC = com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status;
        }

        public void zzl(Status status) {
            this.zzRC.zzn(status);
        }
    }

    public PendingResult<Status> delete(GoogleApiClient googleApiClient, Credential credential) {
        return googleApiClient.zzb(new C07933(this, googleApiClient, credential));
    }

    public PendingResult<Status> disableAutoSignIn(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new C07944(this, googleApiClient));
    }

    public PendingResult<CredentialRequestResult> request(GoogleApiClient googleApiClient, CredentialRequest credentialRequest) {
        return googleApiClient.zza(new C07911(this, googleApiClient, credentialRequest));
    }

    public PendingResult<Status> save(GoogleApiClient googleApiClient, Credential credential) {
        return googleApiClient.zzb(new C07922(this, googleApiClient, credential));
    }
}
