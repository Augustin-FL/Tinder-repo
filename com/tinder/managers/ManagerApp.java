package com.tinder.managers;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.multidex.MultiDex;
import com.crashlytics.android.C0359a;
import com.facebook.FacebookSdk;
import com.facebook.stetho.BuildConfig;
import com.google.android.gcm.C0707a;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.tinder.GCMIntentService;
import com.tinder.activities.ActivityAddPhoto;
import com.tinder.activities.ActivityCredits;
import com.tinder.activities.ActivityEditMoment;
import com.tinder.activities.ActivityLogin;
import com.tinder.activities.ActivityMomentGame;
import com.tinder.activities.ActivityVerification;
import com.tinder.activities.CameraActivity;
import com.tinder.enums.Environment;
import com.tinder.model.FacebookAnalyticsUtils;
import com.tinder.model.MixpanelUtils;
import com.tinder.p029a.C2239e;
import com.tinder.p030d.C2243y;
import com.tinder.p031b.C2404p;
import com.tinder.p031b.C2405q;
import com.tinder.utils.C3061b;
import com.tinder.utils.C3061b.C2774c;
import com.tinder.utils.C3075l;
import com.tinder.utils.C3095y;
import com.tinder.utils.aj;
import io.fabric.sdk.android.C3218c;
import java.io.File;
import java.util.List;

public class ManagerApp extends Application implements C2774c {
    private static C2888i f5572A;
    private static ManagerLiveRail f5573B;
    private static C2963r f5574C;
    private static C3061b f5575D;
    private static Info f5576E;
    @NonNull
    private static Handler f5577F;
    public static boolean f5578a;
    public static boolean f5579b;
    public static boolean f5580c;
    public static boolean f5581d;
    public static String f5582e;
    public static String f5583f;
    private static final String[] f5584g;
    private static ManagerApp f5585h;
    private static Context f5586i;
    private static C2828c f5587j;
    private static C2855f f5588k;
    private static C2859g f5589l;
    private static C2887h f5590m;
    private static ManagerNotifications f5591n;
    private static C2913k f5592o;
    private static C2958p f5593p;
    private static C2239e f5594q;
    private static C2821b f5595r;
    private static C2949m f5596s;
    private static C2957o f5597t;
    private static C2964s f5598u;
    private static C2898j f5599v;
    private static C2833d f5600w;
    private static C2836e f5601x;
    private static C2925l f5602y;
    private static C2956n f5603z;

    /* renamed from: com.tinder.managers.ManagerApp.1 */
    static class C27711 implements C2243y {
        C27711() {
        }

        public void m7892a() {
            Intent intent = new Intent(ManagerApp.f5586i, ActivityLogin.class);
            intent.setFlags(268468224);
            intent.putExtra("extra_show_intro", BuildConfig.FLAVOR);
            ManagerApp.f5586i.startActivity(intent);
        }
    }

    /* renamed from: com.tinder.managers.ManagerApp.2 */
    class C27722 extends AsyncTask<Void, Void, Info> {
        final /* synthetic */ ManagerApp f5570a;

        C27722(ManagerApp managerApp) {
            this.f5570a = managerApp;
        }

        @Nullable
        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m7893a((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m7894a((Info) obj);
        }

        @Nullable
        protected Info m7893a(Void... voidArr) {
            try {
                return AdvertisingIdClient.getAdvertisingIdInfo(this.f5570a);
            } catch (Throwable e) {
                C3095y.m9474a("Failed to load Advertising ID", e);
                return null;
            } catch (Throwable e2) {
                C3095y.m9474a("Failed to load Advertising ID, Google Play Services missing!", e2);
                return null;
            } catch (Throwable e22) {
                C3095y.m9474a("Failed to load Advertising ID, Google Play Services not setup properly!", e22);
                return null;
            }
        }

        protected void m7894a(Info info) {
            ManagerApp.f5576E = info;
        }
    }

    /* renamed from: com.tinder.managers.ManagerApp.3 */
    class C27733 implements Runnable {
        final /* synthetic */ ManagerApp f5571a;

        C27733(ManagerApp managerApp) {
            this.f5571a = managerApp;
        }

        public void run() {
            File file = new File(this.f5571a.getCacheDir().getParent());
            if (file.exists()) {
                for (String str : file.list()) {
                    if (!str.equals("lib")) {
                        C3075l.m9390a(new File(file, str));
                        C3095y.m9485e("**************** File /data/data/APP_PACKAGE/" + str + " DELETED *******************");
                    }
                }
            }
            GCMIntentService.m5883a(C0707a.m994f(ManagerApp.f5586i));
            C0707a.m991c(ManagerApp.f5586i);
            ManagerApp.f5597t.m8762e(false);
            ManagerApp.f5591n.m8047c();
            ManagerApp.f5595r.m8136a(null);
            C2958p.m8779a();
            C2404p.m6571a(ManagerApp.f5586i);
            C2405q.m6574a().m6589c();
            C2405q.m6574a().m6590d();
            C3095y.m9471a("location after clear, lat: " + ManagerApp.f5593p.m8805I() + " lon:" + ManagerApp.f5593p.m8806J());
            ManagerApp.f5600w.m8206f();
            this.f5571a.m7904L();
        }
    }

    static {
        boolean z = false;
        f5584g = new String[]{CameraActivity.class.getSimpleName(), ActivityCredits.class.getSimpleName(), ActivityEditMoment.class.getSimpleName(), ActivityMomentGame.class.getSimpleName(), ActivityLogin.class.getSimpleName(), ActivityVerification.class.getSimpleName(), ActivityAddPhoto.class.getSimpleName()};
        f5578a = false;
        f5579b = true;
        if (VERSION.SDK_INT >= 19) {
            z = true;
        }
        f5580c = z;
        f5581d = true;
        f5577F = new Handler(Looper.getMainLooper());
    }

    @Nullable
    public static Info m7905a() {
        if (f5576E == null || f5576E.isLimitAdTrackingEnabled()) {
            return null;
        }
        return f5576E;
    }

    public static C2821b m7911b() {
        return f5595r;
    }

    public static C2828c m7912c() {
        return f5587j;
    }

    public static C2833d m7913d() {
        return f5600w;
    }

    public static C2958p m7914e() {
        return f5593p;
    }

    public static C2239e m7915f() {
        return f5594q;
    }

    public static C2898j m7916g() {
        return f5599v;
    }

    public static Context m7917h() {
        return f5586i;
    }

    public static C2957o m7918i() {
        return f5597t;
    }

    public static ManagerApp m7919j() {
        return f5585h;
    }

    public static C2836e m7920k() {
        return f5601x;
    }

    public static C2925l m7921l() {
        return f5602y;
    }

    public static C2913k m7922m() {
        return f5592o;
    }

    public static C2964s m7923n() {
        return f5598u;
    }

    public static C2949m m7924o() {
        return f5596s;
    }

    public static C2855f m7925p() {
        return f5588k;
    }

    public static C2887h m7926q() {
        return f5590m;
    }

    public static C2859g m7927r() {
        return f5589l;
    }

    public static ManagerNotifications m7928s() {
        return f5591n;
    }

    public static C2956n m7929t() {
        return f5603z;
    }

    public static C2888i m7930u() {
        return f5572A;
    }

    public static ManagerLiveRail m7931v() {
        return f5573B;
    }

    public static C2963r m7932w() {
        return f5574C;
    }

    public static void m7933x() {
        MixpanelUtils.flushMixpanel();
        f5587j.m8170f();
        f5588k.m8296k();
        f5590m.m8487l();
        f5592o.m8600e();
        f5592o = new C2913k();
        f5596s = new C2949m();
        f5573B.m7970b();
        f5574C.m8892a();
    }

    public static String m7934y() {
        return f5582e;
    }

    public static boolean m7935z() {
        if (VERSION.SDK_INT > 21) {
            return C3061b.f6596a;
        }
        List runningTasks = ((ActivityManager) f5586i.getSystemService("activity")).getRunningTasks(1);
        if (runningTasks.isEmpty()) {
            C3095y.m9471a("Foreground = false");
            return false;
        }
        boolean equalsIgnoreCase = ((RunningTaskInfo) runningTasks.get(0)).topActivity.getPackageName().equalsIgnoreCase(f5586i.getPackageName());
        C3095y.m9471a("Foreground = " + equalsIgnoreCase);
        return equalsIgnoreCase;
    }

    public static boolean m7897A() {
        List runningTasks = ((ActivityManager) f5586i.getSystemService("activity")).getRunningTasks(1);
        if (runningTasks.isEmpty()) {
            return false;
        }
        String a = m7907a(((RunningTaskInfo) runningTasks.get(0)).topActivity.getClassName());
        for (String equals : f5584g) {
            if (equals.equals(a)) {
                return false;
            }
        }
        return true;
    }

    @NonNull
    public static String m7907a(@NonNull String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            return str.substring(lastIndexOf + 1);
        }
        return str;
    }

    public static void m7910a(boolean z) {
        f5578a = z;
    }

    public static void m7908a(@NonNull Environment environment) {
        f5593p.m8827a(environment);
        f5594q.m5901a(environment);
        if (f5595r.m8144e()) {
            f5595r.m8135a(new C27711());
        }
    }

    public void onCreate() {
        C3095y.m9471a("****************************************** APP START ******************************************");
        super.onCreate();
        f5585h = this;
        f5586i = getApplicationContext();
        C3218c.m9719a(getApplicationContext(), new C0359a());
        MixpanelUtils.start();
        try {
            f5582e = f5586i.getPackageManager().getPackageInfo(f5586i.getPackageName(), 0).versionName;
            f5583f = f5582e + " (" + "android" + ") [" + f5586i.getPackageManager().getPackageInfo(f5586i.getPackageName(), 0).versionCode + ']';
            C3095y.m9471a("app version (platform)=" + f5583f);
        } catch (Throwable e) {
            C3095y.m9474a("Failed to load app version", e);
        }
        FacebookSdk.setLegacyTokenUpgradeSupported(true);
        FacebookSdk.sdkInitialize(getApplicationContext());
        FacebookAnalyticsUtils.setup(this);
        FacebookAnalyticsUtils.trackEvent("App.Launch");
        C2405q.m6574a();
        m7904L();
        registerActivityLifecycleCallbacks(f5575D);
        new C27722(this).execute(new Void[0]);
    }

    public void m7936B() {
        new Handler(Looper.getMainLooper()).post(new C27733(this));
    }

    @UiThread
    private void m7904L() {
        f5593p = new C2958p(f5586i);
        f5587j = new C2828c();
        f5595r = new C2821b();
        f5592o = new C2913k();
        f5598u = new C2964s();
        f5594q = new C2239e(f5586i);
        f5597t = new C2957o();
        f5591n = new ManagerNotifications(f5586i);
        f5588k = C2855f.m8248a();
        f5590m = new C2887h();
        f5600w = new C2833d(f5586i);
        f5589l = new C2859g();
        f5596s = new C2949m();
        f5599v = new C2898j();
        f5601x = new C2836e(f5586i);
        f5602y = new C2925l(f5586i);
        f5603z = new C2956n();
        f5572A = new C2888i();
        f5573B = new ManagerLiveRail(f5586i);
        f5574C = new C2963r();
        f5575D = new C3061b(this);
    }

    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

    public void m7937C() {
        if (f5595r.m8144e()) {
            C3095y.m9471a("meta here's the fetch: on App open");
            f5595r.m8143d();
        }
        C2807a.m8062b();
        aj.m9235a().m9247l();
    }

    public void m7938D() {
        aj.m9235a().m9248m();
        C2807a.m8054a();
    }

    @NonNull
    public Handler m7939E() {
        return f5577F;
    }
}
