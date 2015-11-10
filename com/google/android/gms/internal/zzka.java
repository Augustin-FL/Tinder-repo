package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzx;

public class zzka implements ProxyApi {

    /* renamed from: com.google.android.gms.internal.zzka.1 */
    class C11511 extends zzjz {
        final /* synthetic */ ProxyRequest zzRK;
        final /* synthetic */ zzka zzRL;

        /* renamed from: com.google.android.gms.internal.zzka.1.1 */
        class C11501 extends zzjv {
            final /* synthetic */ C11511 zzRM;

            C11501(C11511 c11511) {
                this.zzRM = c11511;
            }

            public void zza(ProxyResponse proxyResponse) {
                this.zzRM.zza(new zzkb(proxyResponse));
            }
        }

        C11511(zzka com_google_android_gms_internal_zzka, GoogleApiClient googleApiClient, ProxyRequest proxyRequest) {
            this.zzRL = com_google_android_gms_internal_zzka;
            this.zzRK = proxyRequest;
            super(googleApiClient);
        }

        protected void zza(Context context, zzjy com_google_android_gms_internal_zzjy) throws RemoteException {
            com_google_android_gms_internal_zzjy.zza(new C11501(this), this.zzRK);
        }
    }

    public PendingResult<ProxyResult> performProxyRequest(GoogleApiClient googleApiClient, ProxyRequest proxyRequest) {
        zzx.zzv(googleApiClient);
        zzx.zzv(proxyRequest);
        return googleApiClient.zzb(new C11511(this, googleApiClient, proxyRequest));
    }
}
