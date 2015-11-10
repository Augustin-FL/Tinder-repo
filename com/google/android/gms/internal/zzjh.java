package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.RemoteException;
import com.google.android.gms.appdatasearch.GetRecentContextCall.Request;
import com.google.android.gms.appdatasearch.GetRecentContextCall.Response;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.appdatasearch.zzk;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.appindexing.AppIndexApi.ActionResult;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.List;

public final class zzjh implements zzk, AppIndexApi {

    private static abstract class zzb<T extends Result> extends com.google.android.gms.common.api.zzc.zza<T, zzjf> {
        public zzb(GoogleApiClient googleApiClient) {
            super(com.google.android.gms.appdatasearch.zza.zzOO, googleApiClient);
        }

        protected abstract void zza(zzjc com_google_android_gms_internal_zzjc) throws RemoteException;

        protected final void zza(zzjf com_google_android_gms_internal_zzjf) throws RemoteException {
            zza(com_google_android_gms_internal_zzjf.zzlg());
        }
    }

    private static abstract class zzc<T extends Result> extends zzb<Status> {
        zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        protected Status zzd(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzjh.1 */
    class C11481 extends zzc<Status> {
        final /* synthetic */ String zzPX;
        final /* synthetic */ UsageInfo[] zzPY;
        final /* synthetic */ zzjh zzPZ;

        C11481(zzjh com_google_android_gms_internal_zzjh, GoogleApiClient googleApiClient, String str, UsageInfo[] usageInfoArr) {
            this.zzPZ = com_google_android_gms_internal_zzjh;
            this.zzPX = str;
            this.zzPY = usageInfoArr;
            super(googleApiClient);
        }

        protected void zza(zzjc com_google_android_gms_internal_zzjc) throws RemoteException {
            com_google_android_gms_internal_zzjc.zza(new zzd(this), this.zzPX, this.zzPY);
        }
    }

    @Deprecated
    private static final class zza implements ActionResult {
        private zzjh zzQa;
        private PendingResult<Status> zzQb;
        private Action zzQc;

        zza(zzjh com_google_android_gms_internal_zzjh, PendingResult<Status> pendingResult, Action action) {
            this.zzQa = com_google_android_gms_internal_zzjh;
            this.zzQb = pendingResult;
            this.zzQc = action;
        }

        public PendingResult<Status> end(GoogleApiClient googleApiClient) {
            String packageName = googleApiClient.getContext().getPackageName();
            UsageInfo zza = zzjg.zza(this.zzQc, System.currentTimeMillis(), packageName, 2);
            return this.zzQa.zza(googleApiClient, zza);
        }

        public PendingResult<Status> getPendingResult() {
            return this.zzQb;
        }
    }

    private static final class zzd extends zzje<Status> {
        public zzd(com.google.android.gms.common.api.zzc.zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status) {
            super(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status);
        }

        public void zzc(Status status) {
            this.zzPW.zzn(status);
        }
    }

    public static Intent zza(String str, Uri uri) {
        zzb(str, uri);
        List pathSegments = uri.getPathSegments();
        String str2 = (String) pathSegments.get(0);
        Builder builder = new Builder();
        builder.scheme(str2);
        if (pathSegments.size() > 1) {
            builder.authority((String) pathSegments.get(1));
            for (int i = 2; i < pathSegments.size(); i++) {
                builder.appendPath((String) pathSegments.get(i));
            }
        }
        builder.encodedQuery(uri.getEncodedQuery());
        builder.encodedFragment(uri.getEncodedFragment());
        return new Intent("android.intent.action.VIEW", builder.build());
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, Action action, int i) {
        String packageName = googleApiClient.getContext().getPackageName();
        return zza(googleApiClient, zzjg.zza(action, System.currentTimeMillis(), packageName, i));
    }

    private static void zzb(String str, Uri uri) {
        if ("android-app".equals(uri.getScheme())) {
            String host = uri.getHost();
            if (str == null || str.equals(host)) {
                List pathSegments = uri.getPathSegments();
                if (pathSegments.isEmpty() || ((String) pathSegments.get(0)).isEmpty()) {
                    throw new IllegalArgumentException("AppIndex: The app URI scheme must exist and follow the format android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + uri);
                }
                return;
            }
            throw new IllegalArgumentException("AppIndex: The URI host must match the package name and follow the format (android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + uri);
        }
        throw new IllegalArgumentException("AppIndex: The URI scheme must be 'android-app' and follow the format (android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + uri);
    }

    public static void zzi(List<AppIndexingLink> list) {
        if (list != null) {
            for (AppIndexingLink appIndexingLink : list) {
                zzb(null, appIndexingLink.appIndexingUrl);
            }
        }
    }

    public ActionResult action(GoogleApiClient googleApiClient, Action action) {
        return new zza(this, zza(googleApiClient, action, 1), action);
    }

    public PendingResult<Status> end(GoogleApiClient googleApiClient, Action action) {
        return zza(googleApiClient, action, 2);
    }

    public PendingResult<Status> start(GoogleApiClient googleApiClient, Action action) {
        return zza(googleApiClient, action, 1);
    }

    public PendingResult<Status> view(GoogleApiClient googleApiClient, Activity activity, Intent intent, String str, Uri uri, List<AppIndexingLink> list) {
        String packageName = googleApiClient.getContext().getPackageName();
        zzi(list);
        return zza(googleApiClient, new UsageInfo(packageName, intent, str, uri, null, list, 1));
    }

    public PendingResult<Status> view(GoogleApiClient googleApiClient, Activity activity, Uri uri, String str, Uri uri2, List<AppIndexingLink> list) {
        String packageName = googleApiClient.getContext().getPackageName();
        zzb(packageName, uri);
        return view(googleApiClient, activity, zza(packageName, uri), str, uri2, (List) list);
    }

    public PendingResult<Status> viewEnd(GoogleApiClient googleApiClient, Activity activity, Intent intent) {
        String packageName = googleApiClient.getContext().getPackageName();
        return zza(googleApiClient, new com.google.android.gms.appdatasearch.UsageInfo.zza().zza(UsageInfo.zza(packageName, intent)).zzw(System.currentTimeMillis()).zzam(0).zzan(2).zzlf());
    }

    public PendingResult<Status> viewEnd(GoogleApiClient googleApiClient, Activity activity, Uri uri) {
        return viewEnd(googleApiClient, activity, zza(googleApiClient.getContext().getPackageName(), uri));
    }

    public PendingResult<Response> zza(GoogleApiClient googleApiClient, Request request) {
        return googleApiClient.zza(new com.google.android.gms.appdatasearch.GetRecentContextCall.zza(request, googleApiClient));
    }

    public PendingResult<Status> zza(GoogleApiClient googleApiClient, UsageInfo... usageInfoArr) {
        return googleApiClient.zza(new C11481(this, googleApiClient, googleApiClient.getContext().getPackageName(), usageInfoArr));
    }
}
