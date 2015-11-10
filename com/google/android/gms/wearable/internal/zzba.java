package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import java.util.ArrayList;
import java.util.List;

public final class zzba implements NodeApi {

    /* renamed from: com.google.android.gms.wearable.internal.zzba.1 */
    class C12921 extends zzh<GetLocalNodeResult> {
        final /* synthetic */ zzba zzbaJ;

        C12921(zzba com_google_android_gms_wearable_internal_zzba, GoogleApiClient googleApiClient) {
            this.zzbaJ = com_google_android_gms_wearable_internal_zzba;
            super(googleApiClient);
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zzo(this);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzbu(status);
        }

        protected GetLocalNodeResult zzbu(Status status) {
            return new zzc(status, null);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzba.2 */
    class C12932 extends zzh<GetConnectedNodesResult> {
        final /* synthetic */ zzba zzbaJ;

        C12932(zzba com_google_android_gms_wearable_internal_zzba, GoogleApiClient googleApiClient) {
            this.zzbaJ = com_google_android_gms_wearable_internal_zzba;
            super(googleApiClient);
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zzp(this);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzbv(status);
        }

        protected GetConnectedNodesResult zzbv(Status status) {
            return new zzb(status, new ArrayList());
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzba.3 */
    class C12943 extends zzh<Status> {
        final /* synthetic */ zzba zzbaJ;
        final /* synthetic */ NodeListener zzbaK;

        C12943(zzba com_google_android_gms_wearable_internal_zzba, GoogleApiClient googleApiClient, NodeListener nodeListener) {
            this.zzbaJ = com_google_android_gms_wearable_internal_zzba;
            this.zzbaK = nodeListener;
            super(googleApiClient);
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zzb(this, this.zzbaK);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        public Status zzd(Status status) {
            return status;
        }
    }

    private static final class zza extends zzh<Status> {
        private NodeListener zzbaL;

        private zza(GoogleApiClient googleApiClient, NodeListener nodeListener) {
            super(googleApiClient);
            this.zzbaL = nodeListener;
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zza((com.google.android.gms.common.api.zzc.zzb) this, this.zzbaL);
            this.zzbaL = null;
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        public Status zzd(Status status) {
            this.zzbaL = null;
            return status;
        }
    }

    public static class zzb implements GetConnectedNodesResult {
        private final Status zzQA;
        private final List<Node> zzbaM;

        public zzb(Status status, List<Node> list) {
            this.zzQA = status;
            this.zzbaM = list;
        }

        public List<Node> getNodes() {
            return this.zzbaM;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    public static class zzc implements GetLocalNodeResult {
        private final Status zzQA;
        private final Node zzbaN;

        public zzc(Status status, Node node) {
            this.zzQA = status;
            this.zzbaN = node;
        }

        public Node getNode() {
            return this.zzbaN;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    public PendingResult<Status> addListener(GoogleApiClient googleApiClient, NodeListener nodeListener) {
        return googleApiClient.zza(new zza(nodeListener, null));
    }

    public PendingResult<GetConnectedNodesResult> getConnectedNodes(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new C12932(this, googleApiClient));
    }

    public PendingResult<GetLocalNodeResult> getLocalNode(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new C12921(this, googleApiClient));
    }

    public PendingResult<Status> removeListener(GoogleApiClient googleApiClient, NodeListener nodeListener) {
        return googleApiClient.zza(new C12943(this, googleApiClient, nodeListener));
    }
}
