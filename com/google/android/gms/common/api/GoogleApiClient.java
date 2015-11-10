package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NotRequiredOptions;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.signin.zzb;
import com.google.android.gms.signin.zzd;
import com.google.android.gms.signin.zze;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface GoogleApiClient {

    public interface ConnectionCallbacks {
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i);
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    public static final class Builder {
        private final Context mContext;
        private Account zzOY;
        private String zzQl;
        private Looper zzYV;
        private final Set<Scope> zzYY;
        private int zzYZ;
        private View zzZa;
        private String zzZb;
        private final Map<Api<?>, com.google.android.gms.common.internal.zzf.zza> zzZc;
        private final Map<Api<?>, ApiOptions> zzZd;
        private FragmentActivity zzZe;
        private int zzZf;
        private int zzZg;
        private OnConnectionFailedListener zzZh;
        private GoogleApiAvailability zzZi;
        private com.google.android.gms.common.api.Api.zza<? extends zzd, zze> zzZj;
        private final ArrayList<ConnectionCallbacks> zzZk;
        private final ArrayList<OnConnectionFailedListener> zzZl;
        private com.google.android.gms.signin.zze.zza zzZm;

        /* renamed from: com.google.android.gms.common.api.GoogleApiClient.Builder.1 */
        class C07961 implements Runnable {
            final /* synthetic */ GoogleApiClient zzVc;
            final /* synthetic */ Builder zzZn;

            C07961(Builder builder, GoogleApiClient googleApiClient) {
                this.zzZn = builder;
                this.zzVc = googleApiClient;
            }

            public void run() {
                if (!this.zzZn.zzZe.isFinishing() && !this.zzZn.zzZe.getSupportFragmentManager().isDestroyed()) {
                    this.zzZn.zza(zzp.zzb(this.zzZn.zzZe), this.zzVc);
                }
            }
        }

        public Builder(Context context) {
            this.zzYY = new HashSet();
            this.zzZc = new zzld();
            this.zzZd = new zzld();
            this.zzZf = -1;
            this.zzZg = -1;
            this.zzZi = GoogleApiAvailability.getInstance();
            this.zzZj = zzb.zzQg;
            this.zzZk = new ArrayList();
            this.zzZl = new ArrayList();
            this.zzZm = new com.google.android.gms.signin.zze.zza();
            this.mContext = context;
            this.zzYV = context.getMainLooper();
            this.zzQl = context.getPackageName();
            this.zzZb = context.getClass().getName();
        }

        public Builder(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            this(context);
            zzx.zzb((Object) connectionCallbacks, (Object) "Must provide a connected listener");
            this.zzZk.add(connectionCallbacks);
            zzx.zzb((Object) onConnectionFailedListener, (Object) "Must provide a connection failed listener");
            this.zzZl.add(onConnectionFailedListener);
        }

        private <O extends ApiOptions> void zza(Api<O> api, O o, int i, Scope... scopeArr) {
            boolean z = true;
            int i2 = 0;
            if (i != 1) {
                if (i == 2) {
                    z = false;
                } else {
                    throw new IllegalArgumentException("Invalid resolution mode: '" + i + "', use a constant from GoogleApiClient.ResolutionMode");
                }
            }
            Set hashSet = new HashSet(api.zznb().zzl(o));
            int length = scopeArr.length;
            while (i2 < length) {
                hashSet.add(scopeArr[i2]);
                i2++;
            }
            this.zzZc.put(api, new com.google.android.gms.common.internal.zzf.zza(hashSet, z));
        }

        private void zza(zzp com_google_android_gms_common_api_zzp, GoogleApiClient googleApiClient) {
            com_google_android_gms_common_api_zzp.zza(this.zzZf, googleApiClient, this.zzZh);
        }

        private GoogleApiClient zznj() {
            GoogleApiClient com_google_android_gms_common_api_zzi = new zzi(this.mContext.getApplicationContext(), this.zzYV, zzni(), this.zzZi, this.zzZj, this.zzZd, this.zzZk, this.zzZl, this.zzZf, -1);
            zzp zza = zzp.zza(this.zzZe);
            if (zza == null) {
                new Handler(this.mContext.getMainLooper()).post(new C07961(this, com_google_android_gms_common_api_zzi));
            } else {
                zza(zza, com_google_android_gms_common_api_zzi);
            }
            return com_google_android_gms_common_api_zzi;
        }

        private GoogleApiClient zznk() {
            zzq zzc = zzq.zzc(this.zzZe);
            GoogleApiClient zzbj = zzc.zzbj(this.zzZg);
            if (zzbj == null) {
                zzbj = new zzi(this.mContext.getApplicationContext(), this.zzYV, zzni(), this.zzZi, this.zzZj, this.zzZd, this.zzZk, this.zzZl, -1, this.zzZg);
            }
            zzc.zza(this.zzZg, zzbj, this.zzZh);
            return zzbj;
        }

        public Builder addApi(Api<? extends NotRequiredOptions> api) {
            this.zzZd.put(api, null);
            this.zzYY.addAll(api.zznb().zzl(null));
            return this;
        }

        public <O extends HasOptions> Builder addApi(Api<O> api, O o) {
            zzx.zzb((Object) o, (Object) "Null options are not permitted for this Api");
            this.zzZd.put(api, o);
            this.zzYY.addAll(api.zznb().zzl(o));
            return this;
        }

        public <O extends HasOptions> Builder addApiIfAvailable(Api<O> api, O o, Scope... scopeArr) {
            zzx.zzb((Object) o, (Object) "Null options are not permitted for this Api");
            this.zzZd.put(api, o);
            zza(api, o, 1, scopeArr);
            return this;
        }

        public Builder addApiIfAvailable(Api<? extends NotRequiredOptions> api, Scope... scopeArr) {
            this.zzZd.put(api, null);
            zza(api, null, 1, scopeArr);
            return this;
        }

        public Builder addConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
            this.zzZk.add(connectionCallbacks);
            return this;
        }

        public Builder addOnConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
            this.zzZl.add(onConnectionFailedListener);
            return this;
        }

        public Builder addScope(Scope scope) {
            this.zzYY.add(scope);
            return this;
        }

        public GoogleApiClient build() {
            zzx.zzb(!this.zzZd.isEmpty(), (Object) "must call addApi() to add at least one API");
            return this.zzZf >= 0 ? zznj() : this.zzZg >= 0 ? zznk() : new zzi(this.mContext, this.zzYV, zzni(), this.zzZi, this.zzZj, this.zzZd, this.zzZk, this.zzZl, -1, -1);
        }

        public Builder enableAutoManage(FragmentActivity fragmentActivity, int i, OnConnectionFailedListener onConnectionFailedListener) {
            zzx.zzb(i >= 0, (Object) "clientId must be non-negative");
            this.zzZf = i;
            this.zzZe = (FragmentActivity) zzx.zzb((Object) fragmentActivity, (Object) "Null activity is not permitted.");
            this.zzZh = onConnectionFailedListener;
            return this;
        }

        public Builder requestServerAuthCode(String str, ServerAuthCodeCallbacks serverAuthCodeCallbacks) {
            this.zzZm.zza(str, serverAuthCodeCallbacks);
            return this;
        }

        public Builder setAccountName(String str) {
            this.zzOY = str == null ? null : new Account(str, GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);
            return this;
        }

        public Builder setGravityForPopups(int i) {
            this.zzYZ = i;
            return this;
        }

        public Builder setHandler(Handler handler) {
            zzx.zzb((Object) handler, (Object) "Handler must not be null");
            this.zzYV = handler.getLooper();
            return this;
        }

        public Builder setViewForPopups(View view) {
            this.zzZa = view;
            return this;
        }

        public Builder useDefaultAccount() {
            return setAccountName("<<default account>>");
        }

        public zzf zzni() {
            return new zzf(this.zzOY, this.zzYY, this.zzZc, this.zzYZ, this.zzZa, this.zzQl, this.zzZb, this.zzZm.zzzr());
        }
    }

    public interface ServerAuthCodeCallbacks {

        public static class CheckResult {
            private boolean zzZo;
            private Set<Scope> zzZp;

            private CheckResult(boolean z, Set<Scope> set) {
                this.zzZo = z;
                this.zzZp = set;
            }

            public static CheckResult newAuthNotRequiredResult() {
                return new CheckResult(false, null);
            }

            public static CheckResult newAuthRequiredResult(Set<Scope> set) {
                boolean z = (set == null || set.isEmpty()) ? false : true;
                zzx.zzb(z, (Object) "A non-empty scope set is required if further auth is needed.");
                return new CheckResult(true, set);
            }

            public boolean zznl() {
                return this.zzZo;
            }

            public Set<Scope> zznm() {
                return this.zzZp;
            }
        }

        CheckResult onCheckServerAuthorization(String str, Set<Scope> set);

        boolean onUploadServerAuthCode(String str, String str2);
    }

    public interface zza {
        void zza(ConnectionResult connectionResult);

        void zzb(ConnectionResult connectionResult);
    }

    ConnectionResult blockingConnect();

    ConnectionResult blockingConnect(long j, TimeUnit timeUnit);

    PendingResult<Status> clearDefaultAccountAndReconnect();

    void connect();

    void disconnect();

    void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    ConnectionResult getConnectionResult(Api<?> api);

    Context getContext();

    Looper getLooper();

    @Deprecated
    int getSessionId();

    boolean hasConnectedApi(Api<?> api);

    boolean isConnected();

    boolean isConnecting();

    boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectionCallbacks);

    boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onConnectionFailedListener);

    void reconnect();

    void registerConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    void registerConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    void stopAutoManage(FragmentActivity fragmentActivity);

    void unregisterConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    <C extends Api.zzb> C zza(zzc<C> com_google_android_gms_common_api_Api_zzc_C);

    <A extends Api.zzb, R extends Result, T extends com.google.android.gms.common.api.zzc.zza<R, A>> T zza(T t);

    boolean zza(Api<?> api);

    boolean zza(Scope scope);

    <A extends Api.zzb, T extends com.google.android.gms.common.api.zzc.zza<? extends Result, A>> T zzb(T t);

    <L> zzl<L> zzp(L l);
}
