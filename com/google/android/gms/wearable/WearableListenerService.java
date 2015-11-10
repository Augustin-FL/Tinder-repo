package com.google.android.gms.wearable;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.internal.AmsEntityUpdateParcelable;
import com.google.android.gms.wearable.internal.AncsNotificationParcelable;
import com.google.android.gms.wearable.internal.CapabilityInfoParcelable;
import com.google.android.gms.wearable.internal.ChannelEventParcelable;
import com.google.android.gms.wearable.internal.MessageEventParcelable;
import com.google.android.gms.wearable.internal.NodeParcelable;
import java.util.List;

public abstract class WearableListenerService extends Service implements CapabilityListener, ChannelListener, DataListener, MessageListener, NodeListener, com.google.android.gms.wearable.NodeApi.zza {
    public static final String BIND_LISTENER_INTENT_ACTION = "com.google.android.gms.wearable.BIND_LISTENER";
    private boolean zzLA;
    private String zzOZ;
    private Handler zzaZc;
    private Object zzaZd;
    private volatile int zzacB;
    private IBinder zzacE;

    private class zza extends com.google.android.gms.wearable.internal.zzav.zza {
        boolean zzaZe;
        final /* synthetic */ WearableListenerService zzaZf;

        /* renamed from: com.google.android.gms.wearable.WearableListenerService.zza.1 */
        class C12751 implements Runnable {
            final /* synthetic */ DataHolder zzaZg;
            final /* synthetic */ zza zzaZh;

            C12751(zza com_google_android_gms_wearable_WearableListenerService_zza, DataHolder dataHolder) {
                this.zzaZh = com_google_android_gms_wearable_WearableListenerService_zza;
                this.zzaZg = dataHolder;
            }

            public void run() {
                DataEventBuffer dataEventBuffer = new DataEventBuffer(this.zzaZg);
                try {
                    this.zzaZh.zzaZf.onDataChanged(dataEventBuffer);
                } finally {
                    dataEventBuffer.release();
                }
            }
        }

        /* renamed from: com.google.android.gms.wearable.WearableListenerService.zza.2 */
        class C12762 implements Runnable {
            final /* synthetic */ zza zzaZh;
            final /* synthetic */ MessageEventParcelable zzaZi;

            C12762(zza com_google_android_gms_wearable_WearableListenerService_zza, MessageEventParcelable messageEventParcelable) {
                this.zzaZh = com_google_android_gms_wearable_WearableListenerService_zza;
                this.zzaZi = messageEventParcelable;
            }

            public void run() {
                this.zzaZh.zzaZf.onMessageReceived(this.zzaZi);
            }
        }

        /* renamed from: com.google.android.gms.wearable.WearableListenerService.zza.3 */
        class C12773 implements Runnable {
            final /* synthetic */ zza zzaZh;
            final /* synthetic */ NodeParcelable zzaZj;

            C12773(zza com_google_android_gms_wearable_WearableListenerService_zza, NodeParcelable nodeParcelable) {
                this.zzaZh = com_google_android_gms_wearable_WearableListenerService_zza;
                this.zzaZj = nodeParcelable;
            }

            public void run() {
                this.zzaZh.zzaZf.onPeerConnected(this.zzaZj);
            }
        }

        /* renamed from: com.google.android.gms.wearable.WearableListenerService.zza.4 */
        class C12784 implements Runnable {
            final /* synthetic */ zza zzaZh;
            final /* synthetic */ NodeParcelable zzaZj;

            C12784(zza com_google_android_gms_wearable_WearableListenerService_zza, NodeParcelable nodeParcelable) {
                this.zzaZh = com_google_android_gms_wearable_WearableListenerService_zza;
                this.zzaZj = nodeParcelable;
            }

            public void run() {
                this.zzaZh.zzaZf.onPeerDisconnected(this.zzaZj);
            }
        }

        /* renamed from: com.google.android.gms.wearable.WearableListenerService.zza.5 */
        class C12795 implements Runnable {
            final /* synthetic */ zza zzaZh;
            final /* synthetic */ List zzaZk;

            C12795(zza com_google_android_gms_wearable_WearableListenerService_zza, List list) {
                this.zzaZh = com_google_android_gms_wearable_WearableListenerService_zza;
                this.zzaZk = list;
            }

            public void run() {
                this.zzaZh.zzaZf.onConnectedNodes(this.zzaZk);
            }
        }

        /* renamed from: com.google.android.gms.wearable.WearableListenerService.zza.6 */
        class C12806 implements Runnable {
            final /* synthetic */ zza zzaZh;
            final /* synthetic */ CapabilityInfoParcelable zzaZl;

            C12806(zza com_google_android_gms_wearable_WearableListenerService_zza, CapabilityInfoParcelable capabilityInfoParcelable) {
                this.zzaZh = com_google_android_gms_wearable_WearableListenerService_zza;
                this.zzaZl = capabilityInfoParcelable;
            }

            public void run() {
                this.zzaZh.zzaZf.onCapabilityChanged(this.zzaZl);
            }
        }

        /* renamed from: com.google.android.gms.wearable.WearableListenerService.zza.7 */
        class C12817 implements Runnable {
            final /* synthetic */ zza zzaZh;
            final /* synthetic */ zzj zzaZm;
            final /* synthetic */ AncsNotificationParcelable zzaZn;

            C12817(zza com_google_android_gms_wearable_WearableListenerService_zza, zzj com_google_android_gms_wearable_zzj, AncsNotificationParcelable ancsNotificationParcelable) {
                this.zzaZh = com_google_android_gms_wearable_WearableListenerService_zza;
                this.zzaZm = com_google_android_gms_wearable_zzj;
                this.zzaZn = ancsNotificationParcelable;
            }

            public void run() {
                this.zzaZm.zza(this.zzaZn);
            }
        }

        /* renamed from: com.google.android.gms.wearable.WearableListenerService.zza.8 */
        class C12828 implements Runnable {
            final /* synthetic */ zza zzaZh;
            final /* synthetic */ zzj zzaZm;
            final /* synthetic */ AmsEntityUpdateParcelable zzaZo;

            C12828(zza com_google_android_gms_wearable_WearableListenerService_zza, zzj com_google_android_gms_wearable_zzj, AmsEntityUpdateParcelable amsEntityUpdateParcelable) {
                this.zzaZh = com_google_android_gms_wearable_WearableListenerService_zza;
                this.zzaZm = com_google_android_gms_wearable_zzj;
                this.zzaZo = amsEntityUpdateParcelable;
            }

            public void run() {
                this.zzaZm.zza(this.zzaZo);
            }
        }

        /* renamed from: com.google.android.gms.wearable.WearableListenerService.zza.9 */
        class C12839 implements Runnable {
            final /* synthetic */ zza zzaZh;
            final /* synthetic */ ChannelEventParcelable zzaZp;

            C12839(zza com_google_android_gms_wearable_WearableListenerService_zza, ChannelEventParcelable channelEventParcelable) {
                this.zzaZh = com_google_android_gms_wearable_WearableListenerService_zza;
                this.zzaZp = channelEventParcelable;
            }

            public void run() {
                this.zzaZp.zza(this.zzaZh.zzaZf);
            }
        }

        zza(WearableListenerService wearableListenerService) {
            this.zzaZf = wearableListenerService;
            this.zzaZe = false;
            this.zzaZe = wearableListenerService instanceof zzj;
        }

        public void onConnectedNodes(List<NodeParcelable> list) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onConnectedNodes: " + this.zzaZf.zzOZ + ": " + list);
            }
            this.zzaZf.zzCs();
            synchronized (this.zzaZf.zzaZd) {
                if (this.zzaZf.zzLA) {
                    return;
                }
                this.zzaZf.zzaZc.post(new C12795(this, list));
            }
        }

        public void zza(AmsEntityUpdateParcelable amsEntityUpdateParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onEntityUpdate: " + amsEntityUpdateParcelable);
            }
            if (this.zzaZe) {
                this.zzaZf.zzCs();
                zzj com_google_android_gms_wearable_zzj = (zzj) this.zzaZf;
                synchronized (this.zzaZf.zzaZd) {
                    if (this.zzaZf.zzLA) {
                        return;
                    }
                    this.zzaZf.zzaZc.post(new C12828(this, com_google_android_gms_wearable_zzj, amsEntityUpdateParcelable));
                }
            }
        }

        public void zza(AncsNotificationParcelable ancsNotificationParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onNotificationReceived: " + ancsNotificationParcelable);
            }
            if (this.zzaZe) {
                this.zzaZf.zzCs();
                zzj com_google_android_gms_wearable_zzj = (zzj) this.zzaZf;
                synchronized (this.zzaZf.zzaZd) {
                    if (this.zzaZf.zzLA) {
                        return;
                    }
                    this.zzaZf.zzaZc.post(new C12817(this, com_google_android_gms_wearable_zzj, ancsNotificationParcelable));
                }
            }
        }

        public void zza(CapabilityInfoParcelable capabilityInfoParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onConnectedCapabilityChanged: " + capabilityInfoParcelable);
            }
            this.zzaZf.zzCs();
            synchronized (this.zzaZf.zzaZd) {
                if (this.zzaZf.zzLA) {
                    return;
                }
                this.zzaZf.zzaZc.post(new C12806(this, capabilityInfoParcelable));
            }
        }

        public void zza(ChannelEventParcelable channelEventParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onChannelEvent: " + channelEventParcelable);
            }
            this.zzaZf.zzCs();
            synchronized (this.zzaZf.zzaZd) {
                if (this.zzaZf.zzLA) {
                    return;
                }
                this.zzaZf.zzaZc.post(new C12839(this, channelEventParcelable));
            }
        }

        public void zza(MessageEventParcelable messageEventParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onMessageReceived: " + messageEventParcelable);
            }
            this.zzaZf.zzCs();
            synchronized (this.zzaZf.zzaZd) {
                if (this.zzaZf.zzLA) {
                    return;
                }
                this.zzaZf.zzaZc.post(new C12762(this, messageEventParcelable));
            }
        }

        public void zza(NodeParcelable nodeParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onPeerConnected: " + this.zzaZf.zzOZ + ": " + nodeParcelable);
            }
            this.zzaZf.zzCs();
            synchronized (this.zzaZf.zzaZd) {
                if (this.zzaZf.zzLA) {
                    return;
                }
                this.zzaZf.zzaZc.post(new C12773(this, nodeParcelable));
            }
        }

        public void zzad(DataHolder dataHolder) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onDataItemChanged: " + this.zzaZf.zzOZ + ": " + dataHolder);
            }
            this.zzaZf.zzCs();
            synchronized (this.zzaZf.zzaZd) {
                if (this.zzaZf.zzLA) {
                    dataHolder.close();
                    return;
                }
                this.zzaZf.zzaZc.post(new C12751(this, dataHolder));
            }
        }

        public void zzb(NodeParcelable nodeParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onPeerDisconnected: " + this.zzaZf.zzOZ + ": " + nodeParcelable);
            }
            this.zzaZf.zzCs();
            synchronized (this.zzaZf.zzaZd) {
                if (this.zzaZf.zzLA) {
                    return;
                }
                this.zzaZf.zzaZc.post(new C12784(this, nodeParcelable));
            }
        }
    }

    public WearableListenerService() {
        this.zzacB = -1;
        this.zzaZd = new Object();
    }

    private void zzCs() throws SecurityException {
        int callingUid = Binder.getCallingUid();
        if (callingUid != this.zzacB) {
            if (GooglePlayServicesUtil.zze(this, callingUid)) {
                this.zzacB = callingUid;
                return;
            }
            throw new SecurityException("Caller is not GooglePlayServices");
        }
    }

    public final IBinder onBind(Intent intent) {
        return BIND_LISTENER_INTENT_ACTION.equals(intent.getAction()) ? this.zzacE : null;
    }

    public void onCapabilityChanged(CapabilityInfo capabilityInfo) {
    }

    public void onChannelClosed(Channel channel, int i, int i2) {
    }

    public void onChannelOpened(Channel channel) {
    }

    public void onConnectedNodes(List<Node> list) {
    }

    public void onCreate() {
        super.onCreate();
        if (Log.isLoggable("WearableLS", 3)) {
            Log.d("WearableLS", "onCreate: " + getPackageName());
        }
        this.zzOZ = getPackageName();
        HandlerThread handlerThread = new HandlerThread("WearableListenerService");
        handlerThread.start();
        this.zzaZc = new Handler(handlerThread.getLooper());
        this.zzacE = new zza(this);
    }

    public void onDataChanged(DataEventBuffer dataEventBuffer) {
    }

    public void onDestroy() {
        synchronized (this.zzaZd) {
            this.zzLA = true;
            if (this.zzaZc == null) {
                throw new IllegalStateException("onDestroy: mServiceHandler not set, did you override onCreate() but forget to call super.onCreate()?");
            }
            this.zzaZc.getLooper().quit();
        }
        super.onDestroy();
    }

    public void onInputClosed(Channel channel, int i, int i2) {
    }

    public void onMessageReceived(MessageEvent messageEvent) {
    }

    public void onOutputClosed(Channel channel, int i, int i2) {
    }

    public void onPeerConnected(Node node) {
    }

    public void onPeerDisconnected(Node node) {
    }
}
