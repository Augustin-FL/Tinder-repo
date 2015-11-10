package com.tinder.managers;

import android.database.sqlite.SQLiteDiskIOException;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.android.volley.C0307i.C0305a;
import com.android.volley.C0307i.C0306b;
import com.android.volley.VolleyError;
import com.facebook.stetho.BuildConfig;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.gson.Gson;
import com.tinder.model.FacebookAnalyticsUtils;
import com.tinder.model.MixpanelUtils;
import com.tinder.model.SparksEvent;
import com.tinder.model.User;
import com.tinder.p029a.C2234a;
import com.tinder.p031b.C2389b;
import com.tinder.utils.C3071j;
import com.tinder.utils.C3095y;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tinder.managers.a */
public class C2807a {
    private static final Gson f5728a;
    private static final C2389b f5729b;
    @NonNull
    private static final ThreadPoolExecutor f5730c;
    @NonNull
    private static final BlockingQueue<Runnable> f5731d;
    private static int f5732e;
    private static long f5733f;
    private static int f5734g;
    private static Boolean f5735h;
    private static Boolean f5736i;
    private static Boolean f5737j;
    private static Boolean f5738k;
    private static TimerTask f5739l;
    @Nullable
    private static Timer f5740m;
    private static final Set<String> f5741n;

    /* renamed from: com.tinder.managers.a.1 */
    static class C28021 extends TimerTask {
        C28021() {
        }

        public void run() {
            synchronized (C2807a.f5735h) {
                if (!C2807a.f5735h.booleanValue()) {
                    C2807a.m8085n();
                }
            }
        }
    }

    /* renamed from: com.tinder.managers.a.2 */
    static class C28032 implements Runnable {
        final /* synthetic */ SparksEvent f5723a;
        final /* synthetic */ boolean f5724b;

        C28032(SparksEvent sparksEvent, boolean z) {
            this.f5723a = sparksEvent;
            this.f5724b = z;
        }

        public void run() {
            Process.setThreadPriority(10);
            C2807a.f5729b.m6500a(this.f5723a);
            synchronized (C2807a.f5735h) {
                if (C2807a.f5735h.booleanValue()) {
                    return;
                }
                C2807a.f5735h = Boolean.valueOf(true);
                if (this.f5724b || (C2807a.m8079h() >= 6 && C2807a.m8084m())) {
                    C2807a.m8085n();
                    C2807a.f5732e = 0;
                    return;
                }
                synchronized (C2807a.f5735h) {
                    C2807a.f5735h = Boolean.valueOf(false);
                }
                C3095y.m9471a("Event queue not full or not enough time passed. Event queue size=" + C2807a.f5732e);
            }
        }
    }

    /* renamed from: com.tinder.managers.a.3 */
    static class C28043 implements Runnable {
        final /* synthetic */ SparksEvent f5725a;

        C28043(SparksEvent sparksEvent) {
            this.f5725a = sparksEvent;
        }

        public void run() {
            List a = C2807a.f5729b.m6499a(99);
            a.add(this.f5725a);
            C2807a.f5729b.m6500a(this.f5725a);
            C2807a.m8071d(a);
        }
    }

    /* renamed from: com.tinder.managers.a.4 */
    static class C28054 implements C0306b<String> {
        final /* synthetic */ List f5726a;

        C28054(List list) {
            this.f5726a = list;
        }

        public void m8051a(String str) {
            C3095y.m9471a("Success: " + str);
            try {
                C2807a.m8076e(this.f5726a);
            } catch (SQLiteDiskIOException e) {
                C3095y.m9479c(BuildConfig.FLAVOR + e);
            }
        }
    }

    /* renamed from: com.tinder.managers.a.5 */
    static class C28065 implements C0305a {
        final /* synthetic */ List f5727a;

        C28065(List list) {
            this.f5727a = list;
        }

        public void onErrorResponse(VolleyError volleyError) {
            try {
                C2807a.m8063b(volleyError, this.f5727a);
            } catch (SQLiteDiskIOException e) {
                C3095y.m9479c(BuildConfig.FLAVOR + e);
            }
        }
    }

    static /* synthetic */ int m8079h() {
        int i = f5732e + 1;
        f5732e = i;
        return i;
    }

    static {
        f5728a = new Gson();
        f5729b = new C2389b();
        f5735h = Boolean.valueOf(false);
        f5731d = new LinkedBlockingQueue();
        f5730c = new ThreadPoolExecutor(1, 1, 5, TimeUnit.SECONDS, f5731d);
        f5741n = new HashSet(6);
        f5741n.add("App.Open");
        f5741n.add("App.Close");
        f5741n.add("Match.New");
        f5741n.add("TinderPlus.Purchase");
        f5741n.add("Chat.SendMessage");
    }

    public static void m8054a() {
        if (f5740m != null) {
            f5740m.cancel();
            f5740m = null;
        }
        synchronized (f5735h) {
            f5735h = Boolean.valueOf(false);
        }
    }

    public static void m8062b() {
        if (f5740m != null) {
            f5740m.cancel();
        }
        f5740m = new Timer();
        f5739l = new C28021();
        f5740m.scheduleAtFixedRate(f5739l, 0, 10000);
    }

    private static boolean m8082k() {
        if (f5736i == null) {
            f5736i = Boolean.valueOf(ManagerApp.m7914e().m8866p());
        }
        return f5736i.booleanValue();
    }

    public static void m8061a(boolean z) {
        f5736i = Boolean.valueOf(z);
        ManagerApp.m7914e().m8851i(z);
    }

    public static boolean m8069c() {
        if (f5738k == null) {
            f5738k = Boolean.valueOf(ManagerApp.m7914e().ak());
        }
        return f5738k.booleanValue();
    }

    public static boolean m8072d() {
        if (f5737j == null) {
            f5737j = Boolean.valueOf(ManagerApp.m7914e().al());
        }
        return f5737j.booleanValue();
    }

    public static void m8067b(boolean z) {
        f5737j = Boolean.valueOf(z);
        ManagerApp.m7914e().m8795C(z);
    }

    public static void m8056a(@NonNull SparksEvent sparksEvent) {
        C2807a.m8057a(sparksEvent, false);
    }

    private static boolean m8070c(@NonNull SparksEvent sparksEvent) {
        String name = sparksEvent.getName();
        return name.equals("Account.Delete") || name.equals("Account.FbLogout");
    }

    public static void m8057a(@NonNull SparksEvent sparksEvent, boolean z) {
        C3095y.m9471a("testAdded " + sparksEvent.getName() + " ts: " + sparksEvent.getTimestamp());
        if (C2807a.m8070c(sparksEvent)) {
            C2807a.m8064b(sparksEvent);
            return;
        }
        C2807a.m8074e(sparksEvent);
        if (C2807a.m8069c() && C2807a.m8073d(sparksEvent)) {
            FacebookAnalyticsUtils.trackFromSparksEvent(sparksEvent);
        }
        if (C2807a.m8072d()) {
            MixpanelUtils.trackFromSparksEvent(sparksEvent);
        } else {
            C3095y.m9471a("Mixpanel is disabled. Not sending event " + sparksEvent.getName());
        }
        if (C2807a.m8082k()) {
            try {
                C2807a.m8065b(sparksEvent, z);
                return;
            } catch (Throwable e) {
                C3095y.m9474a("Failed to add event to internal cache", e);
                return;
            }
        }
        C3095y.m9471a("Sparks is disabled. Not sending event " + sparksEvent.getName());
    }

    private static boolean m8073d(@NonNull SparksEvent sparksEvent) {
        return f5741n.contains(sparksEvent.getName());
    }

    private static void m8065b(@NonNull SparksEvent sparksEvent, boolean z) {
        f5730c.execute(new C28032(sparksEvent, z));
    }

    @NonNull
    private static SparksEvent m8074e(@NonNull SparksEvent sparksEvent) {
        C3095y.m9471a("configuring event: " + sparksEvent.getName());
        User d = ManagerApp.m7922m().m8599d();
        if (d != null) {
            sparksEvent.put("uid", d.getId());
            sparksEvent.put("age", d.getAge());
            sparksEvent.put("gender", Integer.valueOf(d.getGender().getBackendId()));
            sparksEvent.put("targetGender", Integer.valueOf(C2807a.m8083l()));
            Date birthDate = d.getBirthDate();
            if (birthDate != null) {
                sparksEvent.put("birthday", Long.toString(birthDate.getTime() / 1000));
            }
        }
        sparksEvent.put("platform", Integer.valueOf(2));
        sparksEvent.put("tinderPlus", Boolean.valueOf(C2958p.aj()));
        Info a = ManagerApp.m7905a();
        if (a != null) {
            sparksEvent.put("advertisingId", a.getId());
        }
        sparksEvent.put("ts", Long.valueOf(sparksEvent.getTimestamp()));
        double c = ManagerApp.m7913d().m8203c();
        double d2 = ManagerApp.m7913d().m8204d();
        if (!(c == 0.0d || d2 == 0.0d || c == -100000.0d || d2 == -100000.0d)) {
            sparksEvent.put("lat", Double.valueOf(c));
            sparksEvent.put("lon", Double.valueOf(d2));
        }
        if (!TextUtils.isEmpty(C3071j.m9372b())) {
            sparksEvent.put("deviceId", C3071j.m9372b());
        }
        sparksEvent.put("manu", C3071j.m9373c());
        sparksEvent.put("model", C3071j.m9374d());
        sparksEvent.put("osVersion", C3071j.m9376f());
        sparksEvent.put("dataProvider", C3071j.m9375e());
        sparksEvent.put("appVersion", ManagerApp.f5583f);
        return sparksEvent;
    }

    private static int m8083l() {
        C2957o i = ManagerApp.m7918i();
        if (i.m8774k() && i.m8773j()) {
            return -1;
        }
        if (i.m8774k() || !i.m8773j()) {
            return 0;
        }
        return 1;
    }

    private static boolean m8084m() {
        long currentTimeMillis = System.currentTimeMillis() - f5733f;
        long pow = 30000 * ((long) Math.pow(2.0d, (double) f5734g));
        C3095y.m9471a("failureCount=" + f5734g + ", threshold=" + pow);
        if (currentTimeMillis > pow) {
            return true;
        }
        return false;
    }

    public static void m8064b(@NonNull SparksEvent sparksEvent) {
        C2807a.m8074e(sparksEvent);
        f5730c.execute(new C28043(sparksEvent));
    }

    private static void m8068c(@NonNull List<SparksEvent> list) {
        if (ManagerApp.f5578a) {
            String str = "******************";
            str = " ... ";
            str = " : ";
            StringBuilder stringBuilder = new StringBuilder();
            for (SparksEvent sparksEvent : list) {
                stringBuilder.append("\n******************\n" + sparksEvent.getName());
                for (Object next : sparksEvent.getParams().keySet()) {
                    stringBuilder.append('\n');
                    stringBuilder.append(" ... ");
                    stringBuilder.append(next.toString());
                    stringBuilder.append(" : ");
                    stringBuilder.append(sparksEvent.getParams().get(next).toString());
                }
            }
            C3095y.m9471a("----------Sending events----------" + stringBuilder.toString());
        }
    }

    private static void m8085n() {
        C2807a.m8071d(f5729b.m6499a(100));
    }

    private static void m8071d(@Nullable List<SparksEvent> list) {
        C3095y.m9469a();
        if (list != null && list.size() >= 1) {
            String stringBuilder;
            synchronized (f5735h) {
                f5735h = Boolean.valueOf(true);
            }
            C2807a.m8068c((List) list);
            f5733f = System.currentTimeMillis();
            StringBuilder stringBuilder2 = new StringBuilder("events=[");
            C3095y.m9471a("sending " + list.size() + " events in batch");
            for (int i = 0; i < list.size(); i++) {
                SparksEvent sparksEvent = (SparksEvent) list.get(i);
                String name = sparksEvent.getName();
                Object hashMap = new HashMap();
                hashMap.put("schema", name);
                hashMap.put(DataLayer.EVENT_KEY, sparksEvent.getParams());
                name = f5728a.toJson(hashMap);
                if (name.length() > 10152) {
                    f5729b.m6502b(sparksEvent);
                    list.remove(i);
                } else if (name.length() + stringBuilder2.length() > 10152) {
                    for (int size = list.size() - 1; size >= i; size--) {
                        if (!C2807a.m8070c((SparksEvent) list.get(size))) {
                            list.remove(size);
                        }
                    }
                    stringBuilder2.delete(stringBuilder2.length() - 2, stringBuilder2.length() - 1);
                    stringBuilder2.append(']');
                    stringBuilder = stringBuilder2.toString();
                    C3095y.m9471a("length=" + stringBuilder.length());
                    ManagerApp.m7915f().m5900a(new C2234a(2, "https://etl.tindersparks.com:443/v2/batch/event", null, stringBuilder, new C28054(list), new C28065(list)));
                } else {
                    stringBuilder2.append(name);
                    if (i < list.size() - 1) {
                        stringBuilder2.append(", ");
                    }
                }
            }
            stringBuilder2.append(']');
            stringBuilder = stringBuilder2.toString();
            C3095y.m9471a("length=" + stringBuilder.length());
            ManagerApp.m7915f().m5900a(new C2234a(2, "https://etl.tindersparks.com:443/v2/batch/event", null, stringBuilder, new C28054(list), new C28065(list)));
        }
    }

    private static void m8076e(@NonNull List<SparksEvent> list) {
        C3095y.m9471a("Sent events! DELETING " + list.size() + " EVENTS!");
        StringBuilder stringBuilder = new StringBuilder();
        for (SparksEvent name : list) {
            stringBuilder.append('n' + name.getName());
        }
        C3095y.m9471a("sent events " + stringBuilder.toString());
        synchronized (C2821b.f5777a) {
            f5729b.m6501a((List) list);
        }
        f5734g = 0;
        synchronized (f5735h) {
            f5735h = Boolean.valueOf(false);
        }
    }

    private static void m8063b(@Nullable VolleyError volleyError, @NonNull List<SparksEvent> list) {
        C3095y.m9469a();
        f5734g++;
        if (volleyError != null) {
            try {
                C3095y.m9479c("error=" + volleyError + " : " + volleyError.getMessage());
                if (volleyError.f189a != null) {
                    String str = new String(volleyError.f189a.f244b, "utf-8");
                    C3095y.m9471a("body=" + str);
                    if (str.contains("bad-events")) {
                        synchronized (C2821b.f5777a) {
                            f5729b.m6501a((List) list);
                        }
                        f5734g = 0;
                    }
                } else {
                    C3095y.m9479c("No network response body");
                }
            } catch (UnsupportedEncodingException e) {
                C3095y.m9479c(e.toString());
            }
        } else {
            C3095y.m9479c("No error response");
        }
        synchronized (f5735h) {
            f5735h = Boolean.valueOf(false);
        }
    }

    public static void m8058a(String str) {
        C2807a.m8059a(str, false);
    }

    public static void m8059a(String str, boolean z) {
        C2807a.m8057a(new SparksEvent(str), z);
    }
}
