package com.tinder.services;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.facebook.AccessToken;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.data.FreezableUtils;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.DataMapItem;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.PutDataMapRequest;
import com.google.android.gms.wearable.Wearable;
import com.google.android.gms.wearable.WearableListenerService;
import com.tinder.activities.ActivityMain;
import com.tinder.activities.ActivityProfile;
import com.tinder.managers.C2913k;
import com.tinder.managers.C2949m;
import com.tinder.managers.ManagerApp;
import com.tinder.model.Match;
import com.tinder.model.User;
import com.tinder.model.WearUser;
import com.tinder.p030d.C2437v;
import com.tinder.p030d.at;
import com.tinder.p030d.az;
import com.tinder.p030d.bs;
import com.tinder.utils.C3095y;
import com.tinder.utils.am;
import com.tinder.utils.am.C3043a;
import com.tinder.utils.an;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WearClientService extends WearableListenerService implements ConnectionCallbacks, OnConnectionFailedListener, C3043a {
    public GoogleApiClient f6496a;
    private bs f6497b;
    private ArrayList<Long> f6498c;
    private am f6499d;
    private Handler f6500e;

    /* renamed from: com.tinder.services.WearClientService.1 */
    class C30371 implements bs {
        final /* synthetic */ WearClientService f6487a;

        C30371(WearClientService wearClientService) {
            this.f6487a = wearClientService;
        }

        public void m9152s() {
            C3095y.m9471a("ENTER");
        }

        public void m9153t() {
            C3095y.m9471a("ENTER");
            this.f6487a.m9178d();
        }

        public void m9154u() {
            C3095y.m9471a("ENTER");
            this.f6487a.m9178d();
        }

        public void m9151a(@NonNull List<User> list) {
            this.f6487a.m9175b(new ArrayList(list));
        }

        public void m9156w() {
        }

        public void m9157x() {
        }

        public void m9155v() {
            C3095y.m9471a("Logged out");
            this.f6487a.m9179e();
        }
    }

    /* renamed from: com.tinder.services.WearClientService.2 */
    class C30382 implements ResultCallback<DataItemResult> {
        final /* synthetic */ WearClientService f6488a;

        C30382(WearClientService wearClientService) {
            this.f6488a = wearClientService;
        }

        public /* synthetic */ void onResult(@NonNull Result result) {
            m9158a((DataItemResult) result);
        }

        public void m9158a(@NonNull DataItemResult dataItemResult) {
            C3095y.m9471a("recs result sent .. status " + dataItemResult.getStatus());
        }
    }

    /* renamed from: com.tinder.services.WearClientService.3 */
    class C30413 implements Runnable {
        final /* synthetic */ boolean f6491a;
        final /* synthetic */ String f6492b;
        final /* synthetic */ boolean f6493c;
        final /* synthetic */ WearClientService f6494d;

        /* renamed from: com.tinder.services.WearClientService.3.1 */
        class C30391 implements C2437v {
            final /* synthetic */ C30413 f6489a;

            C30391(C30413 c30413) {
                this.f6489a = c30413;
            }

            public void m9159a(int i) {
            }

            public void m9161e() {
            }

            public void m9160a(@NonNull Match match) {
                this.f6489a.f6494d.m9181a(match);
            }

            public void m9162f() {
            }

            public void m9163g() {
            }
        }

        /* renamed from: com.tinder.services.WearClientService.3.2 */
        class C30402 implements at {
            final /* synthetic */ C30413 f6490a;

            C30402(C30413 c30413) {
                this.f6490a = c30413;
            }

            public void m9164f() {
            }

            public void m9165g() {
            }

            public void m9166h() {
            }

            public void m9167i() {
            }
        }

        C30413(WearClientService wearClientService, boolean z, String str, boolean z2) {
            this.f6494d = wearClientService;
            this.f6491a = z;
            this.f6492b = str;
            this.f6493c = z2;
        }

        public void run() {
            if (this.f6491a) {
                ManagerApp.m7924o().m8703a(this.f6492b, this.f6493c, new C30391(this));
            } else {
                ManagerApp.m7924o().m8702a(this.f6492b, this.f6493c, new C30402(this));
            }
            ManagerApp.m7924o().m8706a(this.f6492b);
        }
    }

    /* renamed from: com.tinder.services.WearClientService.4 */
    class C30424 implements az {
        final /* synthetic */ WearClientService f6495a;

        C30424(WearClientService wearClientService) {
            this.f6495a = wearClientService;
        }

        public void m9168a(User user) {
            this.f6495a.m9182a(user);
        }

        public void m9169g() {
        }
    }

    public void onCreate() {
        C3095y.m9471a("ENTER");
        this.f6499d = new am(this);
        this.f6496a = new Builder(this).addApi(Wearable.API).addConnectionCallbacks(this).addOnConnectionFailedListener(this).build();
        this.f6498c = new ArrayList();
        this.f6500e = new Handler(Looper.getMainLooper());
        m9180a();
        super.onCreate();
    }

    public void onDestroy() {
        m9185b();
        super.onDestroy();
    }

    public void onDataChanged(@NonNull DataEventBuffer dataEventBuffer) {
        C3095y.m9471a("ENTER");
        Iterator it = FreezableUtils.freezeIterable(dataEventBuffer).iterator();
        while (it.hasNext()) {
            DataEvent dataEvent = (DataEvent) it.next();
            C3095y.m9471a("ENTER ");
            Uri uri = dataEvent.getDataItem().getUri();
            String path = uri.getPath();
            C3095y.m9471a("data uri " + uri);
            DataMap dataMap = PutDataMapRequest.createFromDataMapItem(DataMapItem.fromDataItem(dataEvent.getDataItem())).getDataMap();
            if (path.equals("/api/recs/get_recs/")) {
                long j = dataMap.getLong("time_millis");
                if (!this.f6498c.contains(Long.valueOf(j))) {
                    m9176c();
                    this.f6498c.add(Long.valueOf(j));
                }
            } else if (path.equals("/api/recs/like/")) {
                m9173a(dataMap.getString(AccessToken.USER_ID_KEY), false, true);
            } else if (path.equals("/api/recs/pass/")) {
                m9173a(dataMap.getString(AccessToken.USER_ID_KEY), false, false);
            }
        }
    }

    public void onMessageReceived(@NonNull MessageEvent messageEvent) {
        C3095y.m9471a("ENTER");
        String path = messageEvent.getPath();
        C3095y.m9471a("path = " + path);
        if (path.equals("/start/recs")) {
            m9176c();
        } else if (path.equals("/start/profile/match")) {
            m9183a(an.m9321a(messageEvent.getData()), true);
        } else if (path.equals("/start/profile/rec")) {
            m9183a(an.m9321a(messageEvent.getData()), false);
        } else if (path.equals("/api/recs/like/")) {
            m9173a(an.m9321a(messageEvent.getData()), false, true);
        } else if (path.equals("/api/recs/pass/")) {
            m9173a(an.m9321a(messageEvent.getData()), false, false);
        }
    }

    public void onPeerConnected(Node node) {
        C3095y.m9471a("ENTER");
        super.onPeerConnected(node);
    }

    public void onPeerDisconnected(Node node) {
        C3095y.m9471a("ENTER");
        super.onPeerDisconnected(node);
    }

    public void m9180a() {
        this.f6496a.connect();
        Wearable.NodeApi.addListener(this.f6496a, this);
        Wearable.MessageApi.addListener(this.f6496a, this);
        Wearable.DataApi.addListener(this.f6496a, this);
    }

    public void m9185b() {
        if (this.f6496a != null) {
            if (Wearable.DataApi != null) {
                Wearable.DataApi.removeListener(this.f6496a, this);
            }
            if (!(Wearable.MessageApi == null || this.f6496a == null)) {
                Wearable.MessageApi.removeListener(this.f6496a, this);
            }
            if (!(Wearable.NodeApi == null || this.f6496a == null)) {
                Wearable.NodeApi.removeListener(this.f6496a, this);
            }
            this.f6496a.disconnect();
        }
    }

    public void onConnected(Bundle bundle) {
        C3095y.m9471a("ENTER");
    }

    public void onConnectionSuspended(int i) {
        C3095y.m9471a("ENTER");
    }

    private void m9176c() {
        C3095y.m9471a("requesting recs");
        C2949m o = ManagerApp.m7924o();
        if (!ManagerApp.m7911b().m8144e()) {
            m9179e();
        }
        this.f6497b = new C30371(this);
        o.m8697a(this.f6497b);
    }

    private void m9175b(@NonNull List<User> list) {
        C3095y.m9471a("ENTER");
        this.f6499d.m9318a(list);
    }

    private void m9177c(@NonNull List<WearUser> list) {
        C3095y.m9471a("ENTER");
        ArrayList arrayList = new ArrayList();
        for (WearUser wearUser : list) {
            DataMap dataMap = new DataMap();
            dataMap.putString("rec string", an.m9320a(wearUser));
            dataMap.putAsset("rec asset", wearUser.getAsset());
            arrayList.add(dataMap);
        }
        PutDataMapRequest create = PutDataMapRequest.create("/api/recs/get_recs/success");
        create.getDataMap().putDataMapArrayList("rec users", arrayList);
        create.getDataMap().putLong("time_millis", System.currentTimeMillis());
        Wearable.DataApi.putDataItem(this.f6496a, create.asPutDataRequest()).setResultCallback(new C30382(this));
    }

    private void m9178d() {
        C3095y.m9471a("ENTER");
        Wearable.DataApi.putDataItem(this.f6496a, PutDataMapRequest.create("/api/recs/get_recs/failure").asPutDataRequest());
    }

    private void m9179e() {
        C3095y.m9471a("ENTER");
        Wearable.DataApi.putDataItem(this.f6496a, PutDataMapRequest.create("/api/logged_out").asPutDataRequest());
    }

    private void m9173a(String str, boolean z, boolean z2) {
        this.f6500e.post(new C30413(this, z2, str, z));
    }

    public void m9181a(@NonNull Match match) {
        PutDataMapRequest create = PutDataMapRequest.create("/event/matched");
        DataMap dataMap = create.getDataMap();
        dataMap.putString("match_id", match.getId());
        dataMap.putLong("time_millis", System.currentTimeMillis());
        dataMap.putString(AccessToken.USER_ID_KEY, match.getPerson().getId());
        Wearable.DataApi.putDataItem(this.f6496a, create.asPutDataRequest());
    }

    public void m9183a(String str, boolean z) {
        if (z) {
            m9186b(ManagerApp.m7925p().m8266a(str));
            return;
        }
        User a = ManagerApp.m7924o().m8693a(str);
        if (a == null) {
            C2913k.m8575a(str, new C30424(this));
        } else {
            m9182a(a);
        }
    }

    public void m9182a(User user) {
        Intent intent = new Intent(getApplicationContext(), ActivityProfile.class);
        intent.putExtra("user", user);
        intent.putExtra("from_wear", true);
        intent.addFlags(335544320);
        startActivity(intent);
    }

    public void m9186b(Match match) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("from_push", true);
        bundle.putSerializable("match", match);
        Intent intent = new Intent(getApplicationContext(), ActivityMain.class);
        intent.addFlags(335544320);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        C3095y.m9471a("ENTER");
    }

    public void m9184a(@NonNull List<WearUser> list) {
        m9177c(list);
    }
}
