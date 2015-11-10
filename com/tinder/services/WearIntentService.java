package com.tinder.services;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.RemoteInput;
import android.text.TextUtils;
import com.facebook.stetho.BuildConfig;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.Wearable;
import com.tinder.activities.ActivityMain;
import com.tinder.managers.C2859g;
import com.tinder.managers.ManagerApp;
import com.tinder.model.Match;
import com.tinder.model.Message;
import com.tinder.p030d.ag;
import com.tinder.utils.C3070i;
import com.tinder.utils.C3095y;
import java.text.DateFormat;
import java.util.Date;

public class WearIntentService extends IntentService implements ConnectionCallbacks, DataListener, MessageListener, NodeListener, ag {
    public GoogleApiClient f6501a;

    public WearIntentService() {
        this("WearIntentService");
    }

    public WearIntentService(String str) {
        super(str);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        this.f6501a = new Builder(this).addApi(Wearable.API).addConnectionCallbacks(this).build();
        m9187a();
        return super.onStartCommand(intent, i, i2);
    }

    protected void onHandleIntent(@NonNull Intent intent) {
        String str = null;
        String stringExtra = intent.getStringExtra("path");
        C3095y.m9471a("handling " + stringExtra);
        if (!TextUtils.isEmpty(stringExtra)) {
            if (stringExtra.contains("/api/matches/send_message/")) {
                C3095y.m9471a("Trying to send message");
                String substring = stringExtra.substring(stringExtra.lastIndexOf("/") + 1);
                Bundle resultsFromIntent = RemoteInput.getResultsFromIntent(intent);
                if (resultsFromIntent != null) {
                    str = resultsFromIntent.get("chat_msg").toString();
                } else {
                    C3095y.m9471a("remote input results NULL!!!");
                }
                DateFormat b = C3070i.m9369b();
                if (!TextUtils.isEmpty(str)) {
                    C3095y.m9471a("Trying to send contents: " + str);
                    Date date = new Date();
                    Message message = new Message(substring, b.format(date), ManagerApp.m7922m().m8599d().getId(), str, true, date.getTime());
                    ManagerApp.m7927r();
                    C2859g.m8304a((ag) this, message);
                }
            } else if (stringExtra.equals("/start/profile/match")) {
                C3095y.m9471a("Trying to open match profile");
                Match match = (Match) intent.getExtras().getSerializable("match");
                if (match != null) {
                    m9188a(match);
                }
            } else {
                C3095y.m9471a("Sending to wear");
                Wearable.MessageApi.sendMessage(this.f6501a, BuildConfig.FLAVOR, stringExtra, null);
            }
            m9190b();
        }
    }

    public void m9187a() {
        this.f6501a.connect();
        Wearable.MessageApi.addListener(this.f6501a, this);
        Wearable.NodeApi.addListener(this.f6501a, this);
        Wearable.DataApi.addListener(this.f6501a, this);
    }

    public void m9190b() {
        Wearable.MessageApi.removeListener(this.f6501a, this);
        Wearable.NodeApi.removeListener(this.f6501a, this);
        Wearable.DataApi.removeListener(this.f6501a, this);
        this.f6501a.disconnect();
    }

    public void m9188a(Match match) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("from_push", true);
        bundle.putSerializable("match", match);
        bundle.putSerializable("is_message", Boolean.valueOf(true));
        Intent intent = new Intent(getApplicationContext(), ActivityMain.class);
        intent.addFlags(335544320);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void onConnected(Bundle bundle) {
        C3095y.m9471a("Wear Messaging connection successful");
    }

    public void onConnectionSuspended(int i) {
        C3095y.m9471a("Wear Messaging connection suspended");
    }

    public void m9189a(Message message, Message message2) {
        C3095y.m9471a("match message success");
    }

    public void m9191b(Message message) {
        C3095y.m9471a("match message failure");
    }

    public void onMessageReceived(MessageEvent messageEvent) {
    }

    public void onPeerConnected(Node node) {
    }

    public void onPeerDisconnected(Node node) {
    }

    public void onDataChanged(DataEventBuffer dataEventBuffer) {
    }
}
