package com.tinder.picassowebp.picasso;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.facebook.stetho.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.tinder.picassowebp.picasso.i */
class C3014i {
    final C3012b f6376a;
    final Context f6377b;
    final ExecutorService f6378c;
    final Downloader f6379d;
    final Map<String, C2983c> f6380e;
    final Map<Object, C2993a> f6381f;
    final Handler f6382g;
    final Handler f6383h;
    final C3005d f6384i;
    final C3033v f6385j;
    final List<C2983c> f6386k;
    final C3013c f6387l;
    final boolean f6388m;
    boolean f6389n;

    /* renamed from: com.tinder.picassowebp.picasso.i.a */
    private static class C3011a extends Handler {
        private final C3014i f6374a;

        /* renamed from: com.tinder.picassowebp.picasso.i.a.1 */
        class C30101 implements Runnable {
            final /* synthetic */ Message f6372a;
            final /* synthetic */ C3011a f6373b;

            C30101(C3011a c3011a, Message message) {
                this.f6373b = c3011a;
                this.f6372a = message;
            }

            public void run() {
                throw new AssertionError("Unknown handler message received: " + this.f6372a.what);
            }
        }

        public C3011a(Looper looper, C3014i c3014i) {
            super(looper);
            this.f6374a = c3014i;
        }

        public void handleMessage(Message message) {
            boolean z = true;
            switch (message.what) {
                case C3374b.SmoothProgressBar_spb_color /*1*/:
                    this.f6374a.m9070c((C2993a) message.obj);
                case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                    this.f6374a.m9072d((C2993a) message.obj);
                case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                    this.f6374a.m9074e((C2983c) message.obj);
                case C3374b.SmoothProgressBar_spb_speed /*5*/:
                    this.f6374a.m9073d((C2983c) message.obj);
                case C3374b.SmoothProgressBar_spb_progressiveStart_speed /*6*/:
                    this.f6374a.m9064a((C2983c) message.obj, false);
                case C3374b.SmoothProgressBar_spb_progressiveStop_speed /*7*/:
                    this.f6374a.m9060a();
                case C3374b.SmoothProgressBar_spb_reversed /*9*/:
                    this.f6374a.m9066b((NetworkInfo) message.obj);
                case C3374b.SmoothProgressBar_spb_mirror_mode /*10*/:
                    C3014i c3014i = this.f6374a;
                    if (message.arg1 != 1) {
                        z = false;
                    }
                    c3014i.m9069b(z);
                default:
                    Picasso.f6331a.post(new C30101(this, message));
            }
        }
    }

    /* renamed from: com.tinder.picassowebp.picasso.i.b */
    static class C3012b extends HandlerThread {
        C3012b() {
            super("Picasso-Dispatcher", 10);
        }
    }

    /* renamed from: com.tinder.picassowebp.picasso.i.c */
    static class C3013c extends BroadcastReceiver {
        private final C3014i f6375a;

        C3013c(C3014i c3014i) {
            this.f6375a = c3014i;
        }

        void m9054a() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
            if (this.f6375a.f6388m) {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            this.f6375a.f6377b.registerReceiver(this, intentFilter);
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if ("android.intent.action.AIRPLANE_MODE".equals(action)) {
                    if (intent.hasExtra("state")) {
                        this.f6375a.m9065a(intent.getBooleanExtra("state", false));
                    }
                } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                    this.f6375a.m9061a(((ConnectivityManager) ab.m9019a(context, "connectivity")).getActiveNetworkInfo());
                }
            }
        }
    }

    C3014i(Context context, ExecutorService executorService, Handler handler, Downloader downloader, C3005d c3005d, C3033v c3033v) {
        this.f6376a = new C3012b();
        this.f6376a.start();
        this.f6377b = context;
        this.f6378c = executorService;
        this.f6380e = new LinkedHashMap();
        this.f6381f = new WeakHashMap();
        this.f6382g = new C3011a(this.f6376a.getLooper(), this);
        this.f6379d = downloader;
        this.f6383h = handler;
        this.f6384i = c3005d;
        this.f6385j = c3033v;
        this.f6386k = new ArrayList(4);
        this.f6389n = ab.m9035d(this.f6377b);
        this.f6388m = ab.m9031b(context, "android.permission.ACCESS_NETWORK_STATE");
        this.f6387l = new C3013c(this);
        this.f6387l.m9054a();
    }

    void m9062a(C2993a c2993a) {
        this.f6382g.sendMessage(this.f6382g.obtainMessage(1, c2993a));
    }

    void m9067b(C2993a c2993a) {
        this.f6382g.sendMessage(this.f6382g.obtainMessage(2, c2993a));
    }

    void m9063a(C2983c c2983c) {
        this.f6382g.sendMessage(this.f6382g.obtainMessage(4, c2983c));
    }

    void m9068b(C2983c c2983c) {
        this.f6382g.sendMessageDelayed(this.f6382g.obtainMessage(5, c2983c), 500);
    }

    void m9071c(C2983c c2983c) {
        this.f6382g.sendMessage(this.f6382g.obtainMessage(6, c2983c));
    }

    void m9061a(NetworkInfo networkInfo) {
        this.f6382g.sendMessage(this.f6382g.obtainMessage(9, networkInfo));
    }

    void m9065a(boolean z) {
        int i;
        Handler handler = this.f6382g;
        Handler handler2 = this.f6382g;
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        handler.sendMessage(handler2.obtainMessage(10, i, 0));
    }

    void m9070c(C2993a c2993a) {
        C2983c c2983c = (C2983c) this.f6380e.get(c2993a.m9003e());
        if (c2983c != null) {
            c2983c.m8955a(c2993a);
        } else if (!this.f6378c.isShutdown()) {
            Object a = C2983c.m8946a(this.f6377b, c2993a.m9006h(), this, this.f6384i, this.f6385j, c2993a, this.f6379d);
            a.f6307k = this.f6378c.submit(a);
            this.f6380e.put(c2993a.m9003e(), a);
            this.f6381f.remove(c2993a.m9002d());
            if (c2993a.m9006h().f6341k) {
                ab.m9026a("Dispatcher", "enqueued", c2993a.f6348b.m9109a());
            }
        } else if (c2993a.m9006h().f6341k) {
            ab.m9027a("Dispatcher", "ignored", c2993a.f6348b.m9109a(), "because shut down");
        }
    }

    void m9072d(C2993a c2993a) {
        String e = c2993a.m9003e();
        C2983c c2983c = (C2983c) this.f6380e.get(e);
        if (c2983c != null) {
            c2983c.m8958b(c2993a);
            if (c2983c.m8959c()) {
                this.f6380e.remove(e);
                if (c2993a.m9006h().f6341k) {
                    ab.m9026a("Dispatcher", "canceled", c2993a.m9001c().m9109a());
                }
            }
        }
        C2993a c2993a2 = (C2993a) this.f6381f.remove(c2993a.m9002d());
        if (c2993a2 != null && c2993a2.m9006h().f6341k) {
            ab.m9027a("Dispatcher", "canceled", c2993a2.m9001c().m9109a(), "from replaying");
        }
    }

    void m9073d(C2983c c2983c) {
        boolean z = true;
        if (!c2983c.m8960d()) {
            if (this.f6378c.isShutdown()) {
                m9064a(c2983c, false);
                return;
            }
            NetworkInfo activeNetworkInfo;
            if (this.f6388m) {
                activeNetworkInfo = ((ConnectivityManager) ab.m9019a(this.f6377b, "connectivity")).getActiveNetworkInfo();
            } else {
                activeNetworkInfo = null;
            }
            boolean z2 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
            boolean a = c2983c.m8956a(this.f6389n, activeNetworkInfo);
            boolean f = c2983c.m8962f();
            if (!a) {
                if (!(this.f6388m && f)) {
                    z = false;
                }
                m9064a(c2983c, z);
                if (z) {
                    m9058f(c2983c);
                }
            } else if (!this.f6388m || z2) {
                if (c2983c.m8967k().f6341k) {
                    ab.m9026a("Dispatcher", "retrying", ab.m9020a(c2983c));
                }
                c2983c.f6307k = this.f6378c.submit(c2983c);
            } else {
                m9064a(c2983c, f);
                if (f) {
                    m9058f(c2983c);
                }
            }
        }
    }

    void m9074e(C2983c c2983c) {
        if (!c2983c.m8961e()) {
            this.f6384i.m9042a(c2983c.m8964h(), c2983c.m8963g());
        }
        this.f6380e.remove(c2983c.m8964h());
        m9059g(c2983c);
        if (c2983c.m8967k().f6341k) {
            ab.m9027a("Dispatcher", "batched", ab.m9020a(c2983c), "for completion");
        }
    }

    void m9060a() {
        List arrayList = new ArrayList(this.f6386k);
        this.f6386k.clear();
        this.f6383h.sendMessage(this.f6383h.obtainMessage(8, arrayList));
        m9055a(arrayList);
    }

    void m9064a(C2983c c2983c, boolean z) {
        if (c2983c.m8967k().f6341k) {
            ab.m9027a("Dispatcher", "batched", ab.m9020a(c2983c), "for error" + (z ? " (will replay)" : BuildConfig.FLAVOR));
        }
        this.f6380e.remove(c2983c.m8964h());
        m9059g(c2983c);
    }

    void m9069b(boolean z) {
        this.f6389n = z;
    }

    void m9066b(NetworkInfo networkInfo) {
        if (this.f6378c instanceof C3023r) {
            ((C3023r) this.f6378c).m9102a(networkInfo);
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            m9056b();
        }
    }

    private void m9056b() {
        if (!this.f6381f.isEmpty()) {
            Iterator it = this.f6381f.values().iterator();
            while (it.hasNext()) {
                C2993a c2993a = (C2993a) it.next();
                it.remove();
                if (c2993a.m9006h().f6341k) {
                    ab.m9026a("Dispatcher", "replaying", c2993a.m9001c().m9109a());
                }
                m9070c(c2993a);
            }
        }
    }

    private void m9058f(C2983c c2983c) {
        C2993a j = c2983c.m8966j();
        if (j != null) {
            m9057e(j);
        }
        List l = c2983c.m8968l();
        if (l != null) {
            int size = l.size();
            for (int i = 0; i < size; i++) {
                m9057e((C2993a) l.get(i));
            }
        }
    }

    private void m9057e(C2993a c2993a) {
        Object d = c2993a.m9002d();
        if (d != null) {
            c2993a.f6355i = true;
            this.f6381f.put(d, c2993a);
        }
    }

    private void m9059g(C2983c c2983c) {
        if (!c2983c.m8960d()) {
            this.f6386k.add(c2983c);
            if (!this.f6382g.hasMessages(7)) {
                this.f6382g.sendEmptyMessageDelayed(7, 200);
            }
        }
    }

    private void m9055a(List<C2983c> list) {
        if (list != null && !list.isEmpty() && ((C2983c) list.get(0)).m8967k().f6341k) {
            StringBuilder stringBuilder = new StringBuilder();
            for (C2983c c2983c : list) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(ab.m9020a(c2983c));
            }
            ab.m9026a("Dispatcher", "delivered", stringBuilder.toString());
        }
    }
}
