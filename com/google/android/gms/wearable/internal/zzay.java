package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;

public final class zzay implements MessageApi {

    /* renamed from: com.google.android.gms.wearable.internal.zzay.1 */
    class C12901 extends zzh<SendMessageResult> {
        final /* synthetic */ byte[] zzQu;
        final /* synthetic */ String zzaZK;
        final /* synthetic */ String zzbaF;
        final /* synthetic */ zzay zzbaG;

        C12901(zzay com_google_android_gms_wearable_internal_zzay, GoogleApiClient googleApiClient, String str, String str2, byte[] bArr) {
            this.zzbaG = com_google_android_gms_wearable_internal_zzay;
            this.zzaZK = str;
            this.zzbaF = str2;
            this.zzQu = bArr;
            super(googleApiClient);
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zza((com.google.android.gms.common.api.zzc.zzb) this, this.zzaZK, this.zzbaF, this.zzQu);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzbt(status);
        }

        protected SendMessageResult zzbt(Status status) {
            return new zzb(status, -1);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzay.2 */
    class C12912 extends zzh<Status> {
        final /* synthetic */ zzay zzbaG;
        final /* synthetic */ MessageListener zzbaH;

        C12912(zzay com_google_android_gms_wearable_internal_zzay, GoogleApiClient googleApiClient, MessageListener messageListener) {
            this.zzbaG = com_google_android_gms_wearable_internal_zzay;
            this.zzbaH = messageListener;
            super(googleApiClient);
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zza((com.google.android.gms.common.api.zzc.zzb) this, this.zzbaH);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        public Status zzd(Status status) {
            return status;
        }
    }

    private static final class zza extends zzh<Status> {
        private MessageListener zzbaI;
        private IntentFilter[] zzbal;

        private zza(GoogleApiClient googleApiClient, MessageListener messageListener, IntentFilter[] intentFilterArr) {
            super(googleApiClient);
            this.zzbaI = messageListener;
            this.zzbal = intentFilterArr;
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zza((com.google.android.gms.common.api.zzc.zzb) this, this.zzbaI, this.zzbal);
            this.zzbaI = null;
            this.zzbal = null;
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        public Status zzd(Status status) {
            this.zzbaI = null;
            this.zzbal = null;
            return status;
        }
    }

    public static class zzb implements SendMessageResult {
        private final Status zzQA;
        private final int zzagq;

        public zzb(Status status, int i) {
            this.zzQA = status;
            this.zzagq = i;
        }

        public int getRequestId() {
            return this.zzagq;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, MessageListener messageListener, IntentFilter[] intentFilterArr) {
        return googleApiClient.zza(new zza(messageListener, intentFilterArr, null));
    }

    public PendingResult<Status> addListener(GoogleApiClient googleApiClient, MessageListener messageListener) {
        return zza(googleApiClient, messageListener, null);
    }

    public PendingResult<Status> removeListener(GoogleApiClient googleApiClient, MessageListener messageListener) {
        return googleApiClient.zza(new C12912(this, googleApiClient, messageListener));
    }

    public PendingResult<SendMessageResult> sendMessage(GoogleApiClient googleApiClient, String str, String str2, byte[] bArr) {
        return googleApiClient.zza(new C12901(this, googleApiClient, str, str2, bArr));
    }
}
