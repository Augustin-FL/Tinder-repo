package com.crashlytics.android.core;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.PackageInfo;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import com.crashlytics.android.answers.C0362a;
import com.crashlytics.android.core.p005a.C0404a;
import com.crashlytics.android.core.p005a.p006a.C0400d;
import com.facebook.stetho.BuildConfig;
import com.google.android.gms.location.places.Place;
import io.fabric.sdk.android.C0347h;
import io.fabric.sdk.android.C3218c;
import io.fabric.sdk.android.services.common.C3251i.C3252a;
import io.fabric.sdk.android.services.common.C3251i.C3253b;
import io.fabric.sdk.android.services.common.C3258l;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.concurrency.C0412i;
import io.fabric.sdk.android.services.concurrency.C0414d;
import io.fabric.sdk.android.services.concurrency.C3281b;
import io.fabric.sdk.android.services.concurrency.Priority;
import io.fabric.sdk.android.services.network.C0432e;
import io.fabric.sdk.android.services.network.C3295c;
import io.fabric.sdk.android.services.network.C3296b;
import io.fabric.sdk.android.services.p035c.C3237b;
import io.fabric.sdk.android.services.p035c.C3238c;
import io.fabric.sdk.android.services.p035c.C3239d;
import io.fabric.sdk.android.services.settings.C3317o;
import io.fabric.sdk.android.services.settings.C3318p;
import io.fabric.sdk.android.services.settings.C3321q;
import io.fabric.sdk.android.services.settings.C3321q.C0419b;
import io.fabric.sdk.android.services.settings.C3322s;
import java.io.File;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@C3281b(a = {C0404a.class})
/* renamed from: com.crashlytics.android.core.e */
public class C0427e extends C0347h<Void> {
    private final long f556a;
    private final ConcurrentHashMap<String, String> f557b;
    private File f558c;
    private File f559d;
    private C0431g f560j;
    private C0446i f561k;
    private String f562l;
    private String f563m;
    private String f564n;
    private String f565o;
    private String f566p;
    private String f567q;
    private String f568r;
    private String f569s;
    private float f570t;
    private boolean f571u;
    private final C0472s f572v;
    private C3295c f573w;
    private C0430f f574x;
    private C0404a f575y;

    /* renamed from: com.crashlytics.android.core.e.1 */
    class C04151 extends C0414d<Void> {
        final /* synthetic */ C0427e f539a;

        C04151(C0427e c0427e) {
            this.f539a = c0427e;
        }

        public /* synthetic */ Object call() throws Exception {
            return m647a();
        }

        public Void m647a() throws Exception {
            return this.f539a.m686d();
        }

        public Priority m648b() {
            return Priority.IMMEDIATE;
        }
    }

    /* renamed from: com.crashlytics.android.core.e.2 */
    class C04162 implements Callable<Void> {
        final /* synthetic */ C0427e f540a;

        C04162(C0427e c0427e) {
            this.f540a = c0427e;
        }

        public /* synthetic */ Object call() throws Exception {
            return m649a();
        }

        public Void m649a() throws Exception {
            this.f540a.f559d.createNewFile();
            C3218c.m9728h().m9687a("CrashlyticsCore", "Initialization marker file created.");
            return null;
        }
    }

    /* renamed from: com.crashlytics.android.core.e.3 */
    class C04173 implements Callable<Boolean> {
        final /* synthetic */ C0427e f541a;

        C04173(C0427e c0427e) {
            this.f541a = c0427e;
        }

        public /* synthetic */ Object call() throws Exception {
            return m650a();
        }

        public Boolean m650a() throws Exception {
            try {
                boolean delete = this.f541a.f559d.delete();
                C3218c.m9728h().m9687a("CrashlyticsCore", "Initialization marker file removed: " + delete);
                return Boolean.valueOf(delete);
            } catch (Throwable e) {
                C3218c.m9728h().m9695e("CrashlyticsCore", "Problem encountered deleting Crashlytics initialization marker.", e);
                return Boolean.valueOf(false);
            }
        }
    }

    /* renamed from: com.crashlytics.android.core.e.4 */
    class C04184 implements Callable<Boolean> {
        final /* synthetic */ C0427e f542a;

        C04184(C0427e c0427e) {
            this.f542a = c0427e;
        }

        public /* synthetic */ Object call() throws Exception {
            return m651a();
        }

        public Boolean m651a() throws Exception {
            return Boolean.valueOf(this.f542a.f559d.exists());
        }
    }

    /* renamed from: com.crashlytics.android.core.e.5 */
    class C04205 implements C0419b<Boolean> {
        final /* synthetic */ C0427e f543a;

        C04205(C0427e c0427e) {
            this.f543a = c0427e;
        }

        public /* synthetic */ Object m654b(C3322s c3322s) {
            return m653a(c3322s);
        }

        public Boolean m653a(C3322s c3322s) {
            boolean z = false;
            if (!c3322s.f7251d.f7222a) {
                return Boolean.valueOf(false);
            }
            if (!this.f543a.m704w()) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
    }

    /* renamed from: com.crashlytics.android.core.e.6 */
    class C04216 implements C0419b<Boolean> {
        final /* synthetic */ C0427e f544a;

        C04216(C0427e c0427e) {
            this.f544a = c0427e;
        }

        public /* synthetic */ Object m656b(C3322s c3322s) {
            return m655a(c3322s);
        }

        public Boolean m655a(C3322s c3322s) {
            boolean z = true;
            Activity b = this.f544a.m403C().m9735b();
            if (!(b == null || b.isFinishing() || !this.f544a.m703v())) {
                z = this.f544a.m665a(b, c3322s.f7250c);
            }
            return Boolean.valueOf(z);
        }
    }

    /* renamed from: com.crashlytics.android.core.e.7 */
    class C04257 implements Runnable {
        final /* synthetic */ Activity f548a;
        final /* synthetic */ C0426a f549b;
        final /* synthetic */ C0450m f550c;
        final /* synthetic */ C3317o f551d;
        final /* synthetic */ C0427e f552e;

        /* renamed from: com.crashlytics.android.core.e.7.1 */
        class C04221 implements OnClickListener {
            final /* synthetic */ C04257 f545a;

            C04221(C04257 c04257) {
                this.f545a = c04257;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f545a.f549b.m657a(true);
                dialogInterface.dismiss();
            }
        }

        /* renamed from: com.crashlytics.android.core.e.7.2 */
        class C04232 implements OnClickListener {
            final /* synthetic */ C04257 f546a;

            C04232(C04257 c04257) {
                this.f546a = c04257;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f546a.f549b.m657a(false);
                dialogInterface.dismiss();
            }
        }

        /* renamed from: com.crashlytics.android.core.e.7.3 */
        class C04243 implements OnClickListener {
            final /* synthetic */ C04257 f547a;

            C04243(C04257 c04257) {
                this.f547a = c04257;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f547a.f552e.m681a(true);
                this.f547a.f549b.m657a(true);
                dialogInterface.dismiss();
            }
        }

        C04257(C0427e c0427e, Activity activity, C0426a c0426a, C0450m c0450m, C3317o c3317o) {
            this.f552e = c0427e;
            this.f548a = activity;
            this.f549b = c0426a;
            this.f550c = c0450m;
            this.f551d = c3317o;
        }

        public void run() {
            Builder builder = new Builder(this.f548a);
            OnClickListener c04221 = new C04221(this);
            float f = this.f548a.getResources().getDisplayMetrics().density;
            int a = this.f552e.m661a(f, 5);
            View textView = new TextView(this.f548a);
            textView.setAutoLinkMask(15);
            textView.setText(this.f550c.m790b());
            textView.setTextAppearance(this.f548a, 16973892);
            textView.setPadding(a, a, a, a);
            textView.setFocusable(false);
            View scrollView = new ScrollView(this.f548a);
            scrollView.setPadding(this.f552e.m661a(f, 14), this.f552e.m661a(f, 2), this.f552e.m661a(f, 10), this.f552e.m661a(f, 12));
            scrollView.addView(textView);
            builder.setView(scrollView).setTitle(this.f550c.m789a()).setCancelable(false).setNeutralButton(this.f550c.m791c(), c04221);
            if (this.f551d.f7233d) {
                builder.setNegativeButton(this.f550c.m793e(), new C04232(this));
            }
            if (this.f551d.f7235f) {
                builder.setPositiveButton(this.f550c.m792d(), new C04243(this));
            }
            builder.show();
        }
    }

    /* renamed from: com.crashlytics.android.core.e.a */
    private class C0426a {
        final /* synthetic */ C0427e f553a;
        private boolean f554b;
        private final CountDownLatch f555c;

        private C0426a(C0427e c0427e) {
            this.f553a = c0427e;
            this.f554b = false;
            this.f555c = new CountDownLatch(1);
        }

        void m657a(boolean z) {
            this.f554b = z;
            this.f555c.countDown();
        }

        boolean m658a() {
            return this.f554b;
        }

        void m659b() {
            try {
                this.f555c.await();
            } catch (InterruptedException e) {
            }
        }
    }

    protected /* synthetic */ Object m687f() {
        return m686d();
    }

    public C0427e() {
        this(1.0f, null, null, false);
    }

    C0427e(float f, C0431g c0431g, C0472s c0472s, boolean z) {
        this(f, c0431g, c0472s, z, C3258l.m9938a("Crashlytics Exception Handler"));
    }

    C0427e(float f, C0431g c0431g, C0472s c0472s, boolean z, ExecutorService executorService) {
        this.f562l = null;
        this.f563m = null;
        this.f564n = null;
        this.f557b = new ConcurrentHashMap();
        this.f556a = System.currentTimeMillis();
        this.f570t = f;
        this.f560j = c0431g;
        this.f572v = c0472s;
        this.f571u = z;
        this.f574x = new C0430f(executorService);
    }

    protected boolean a_() {
        return m682a(super.m402B());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    boolean m682a(android.content.Context r9) {
        /*
        r8 = this;
        r7 = 0;
        r0 = r8.f571u;
        if (r0 == 0) goto L_0x0007;
    L_0x0005:
        r0 = r7;
    L_0x0006:
        return r0;
    L_0x0007:
        r0 = new io.fabric.sdk.android.services.common.g;
        r0.<init>();
        r0 = r0.m9930a(r9);
        if (r0 != 0) goto L_0x0014;
    L_0x0012:
        r0 = r7;
        goto L_0x0006;
    L_0x0014:
        r1 = io.fabric.sdk.android.C3218c.m9728h();
        r2 = "CrashlyticsCore";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Initializing Crashlytics ";
        r3 = r3.append(r4);
        r4 = r8.m677a();
        r3 = r3.append(r4);
        r3 = r3.toString();
        r1.m9691c(r2, r3);
        r1 = new java.io.File;
        r2 = r8.m702u();
        r3 = "initialization_marker";
        r1.<init>(r2, r3);
        r8.f559d = r1;
        r8.m664a(r9, r0);	 Catch:{ CrashlyticsMissingDependencyException -> 0x00a7, Exception -> 0x00b1 }
        r5 = new com.crashlytics.android.core.w;	 Catch:{ Exception -> 0x0099, CrashlyticsMissingDependencyException -> 0x00a7 }
        r0 = r8.m402B();	 Catch:{ Exception -> 0x0099, CrashlyticsMissingDependencyException -> 0x00a7 }
        r1 = r8.f565o;	 Catch:{ Exception -> 0x0099, CrashlyticsMissingDependencyException -> 0x00a7 }
        r2 = r8.m689h();	 Catch:{ Exception -> 0x0099, CrashlyticsMissingDependencyException -> 0x00a7 }
        r5.<init>(r0, r1, r2);	 Catch:{ Exception -> 0x0099, CrashlyticsMissingDependencyException -> 0x00a7 }
        r0 = io.fabric.sdk.android.C3218c.m9728h();	 Catch:{ Exception -> 0x0099, CrashlyticsMissingDependencyException -> 0x00a7 }
        r1 = "CrashlyticsCore";
        r2 = "Installing exception handler...";
        r0.m9687a(r1, r2);	 Catch:{ Exception -> 0x0099, CrashlyticsMissingDependencyException -> 0x00a7 }
        r0 = new com.crashlytics.android.core.i;	 Catch:{ Exception -> 0x0099, CrashlyticsMissingDependencyException -> 0x00a7 }
        r1 = java.lang.Thread.getDefaultUncaughtExceptionHandler();	 Catch:{ Exception -> 0x0099, CrashlyticsMissingDependencyException -> 0x00a7 }
        r2 = r8.f560j;	 Catch:{ Exception -> 0x0099, CrashlyticsMissingDependencyException -> 0x00a7 }
        r3 = r8.f574x;	 Catch:{ Exception -> 0x0099, CrashlyticsMissingDependencyException -> 0x00a7 }
        r4 = r8.m401A();	 Catch:{ Exception -> 0x0099, CrashlyticsMissingDependencyException -> 0x00a7 }
        r6 = r8;
        r0.<init>(r1, r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x0099, CrashlyticsMissingDependencyException -> 0x00a7 }
        r8.f561k = r0;	 Catch:{ Exception -> 0x0099, CrashlyticsMissingDependencyException -> 0x00a7 }
        r1 = r8.m700s();	 Catch:{ Exception -> 0x0099, CrashlyticsMissingDependencyException -> 0x00a7 }
        r0 = r8.f561k;	 Catch:{ Exception -> 0x00c0, CrashlyticsMissingDependencyException -> 0x00a7 }
        r0.m776b();	 Catch:{ Exception -> 0x00c0, CrashlyticsMissingDependencyException -> 0x00a7 }
        r0 = r8.f561k;	 Catch:{ Exception -> 0x00c0, CrashlyticsMissingDependencyException -> 0x00a7 }
        java.lang.Thread.setDefaultUncaughtExceptionHandler(r0);	 Catch:{ Exception -> 0x00c0, CrashlyticsMissingDependencyException -> 0x00a7 }
        r0 = io.fabric.sdk.android.C3218c.m9728h();	 Catch:{ Exception -> 0x00c0, CrashlyticsMissingDependencyException -> 0x00a7 }
        r2 = "CrashlyticsCore";
        r3 = "Successfully installed exception handler.";
        r0.m9687a(r2, r3);	 Catch:{ Exception -> 0x00c0, CrashlyticsMissingDependencyException -> 0x00a7 }
    L_0x008b:
        if (r1 == 0) goto L_0x00ae;
    L_0x008d:
        r0 = io.fabric.sdk.android.services.common.CommonUtils.m9879n(r9);	 Catch:{ CrashlyticsMissingDependencyException -> 0x00a7, Exception -> 0x00b1 }
        if (r0 == 0) goto L_0x00ae;
    L_0x0093:
        r8.m660G();	 Catch:{ CrashlyticsMissingDependencyException -> 0x00a7, Exception -> 0x00b1 }
        r0 = r7;
        goto L_0x0006;
    L_0x0099:
        r0 = move-exception;
        r1 = r7;
    L_0x009b:
        r2 = io.fabric.sdk.android.C3218c.m9728h();	 Catch:{ CrashlyticsMissingDependencyException -> 0x00a7, Exception -> 0x00b1 }
        r3 = "CrashlyticsCore";
        r4 = "There was a problem installing the exception handler.";
        r2.m9695e(r3, r4, r0);	 Catch:{ CrashlyticsMissingDependencyException -> 0x00a7, Exception -> 0x00b1 }
        goto L_0x008b;
    L_0x00a7:
        r0 = move-exception;
        r1 = new io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
        r1.<init>(r0);
        throw r1;
    L_0x00ae:
        r0 = 1;
        goto L_0x0006;
    L_0x00b1:
        r0 = move-exception;
        r1 = io.fabric.sdk.android.C3218c.m9728h();
        r2 = "CrashlyticsCore";
        r3 = "Crashlytics was not started due to an exception during initialization";
        r1.m9695e(r2, r3, r0);
        r0 = r7;
        goto L_0x0006;
    L_0x00c0:
        r0 = move-exception;
        goto L_0x009b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crashlytics.android.core.e.a(android.content.Context):boolean");
    }

    private void m664a(Context context, String str) {
        C0432e c0433h = this.f572v != null ? new C0433h(this.f572v) : null;
        this.f573w = new C3296b(C3218c.m9728h());
        this.f573w.m10079a(c0433h);
        try {
            this.f566p = context.getPackageName();
            this.f567q = m401A().m9899h();
            C3218c.m9728h().m9687a("CrashlyticsCore", "Installer package name is: " + this.f567q);
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(this.f566p, 0);
            this.f568r = Integer.toString(packageInfo.versionCode);
            this.f569s = packageInfo.versionName == null ? "0.0" : packageInfo.versionName;
            this.f565o = CommonUtils.m9878m(context);
        } catch (Throwable e) {
            C3218c.m9728h().m9695e("CrashlyticsCore", "Error setting up app properties", e);
        }
        m401A().m9906o();
        m675a(this.f565o, m668b(context)).m617a(str, this.f566p);
    }

    protected Void m686d() {
        m698q();
        this.f561k.m781g();
        Object obj = 1;
        try {
            C3322s b = C3321q.m10135a().m10139b();
            if (b == null) {
                C3218c.m9728h().m9692d("CrashlyticsCore", "Received null settings, skipping initialization!");
                m699r();
                return null;
            }
            if (b.f7251d.f7224c) {
                obj = null;
                this.f561k.m777c();
                C0448k a = m676a(b);
                if (a != null) {
                    new C0480v(a).m881a(this.f570t);
                } else {
                    C3218c.m9728h().m9692d("CrashlyticsCore", "Unable to create a call to upload reports.");
                }
            }
            if (obj != null) {
                try {
                    C3218c.m9728h().m9687a("CrashlyticsCore", "Crash reporting disabled.");
                } catch (Throwable e) {
                    C3218c.m9728h().m9695e("CrashlyticsCore", "Problem encountered during Crashlytics initialization.", e);
                } finally {
                    m699r();
                }
            }
            m699r();
            return null;
        } catch (Throwable e2) {
            Throwable th = e2;
            Object obj2 = obj;
            C3218c.m9728h().m9695e("CrashlyticsCore", "Error dealing with settings", th);
            obj = obj2;
        }
    }

    public String m683b() {
        return "com.crashlytics.sdk.android.crashlytics-core";
    }

    public String m677a() {
        return "2.3.5.79";
    }

    public static C0427e m671e() {
        return (C0427e) C3218c.m9720a(C0427e.class);
    }

    public void m680a(Throwable th) {
        if (this.f571u || !C0427e.m673f("prior to logging exceptions.")) {
            return;
        }
        if (th == null) {
            C3218c.m9728h().m9685a(5, "CrashlyticsCore", "Crashlytics is ignoring a request to log a null exception.");
        } else {
            this.f561k.m773a(Thread.currentThread(), th);
        }
    }

    public void m679a(String str) {
        m667b(3, "CrashlyticsCore", str);
    }

    private void m667b(int i, String str, String str2) {
        if (!this.f571u && C0427e.m673f("prior to logging messages.")) {
            this.f561k.m771a(System.currentTimeMillis() - this.f556a, C0427e.m669c(i, str, str2));
        }
    }

    public void m678a(int i, String str, String str2) {
        m667b(i, str, str2);
        C3218c.m9728h().m9686a(i, BuildConfig.FLAVOR + str, BuildConfig.FLAVOR + str2, true);
    }

    public void m684b(String str) {
        if (!this.f571u) {
            this.f562l = C0427e.m674g(str);
            this.f561k.m772a(this.f562l, this.f564n, this.f563m);
        }
    }

    public void m685c(String str) {
        if (!this.f571u) {
            this.f564n = C0427e.m674g(str);
            this.f561k.m772a(this.f562l, this.f564n, this.f563m);
        }
    }

    private void m660G() {
        Callable c04151 = new C04151(this);
        for (C0412i a : m406F()) {
            c04151.m639a(a);
        }
        Future submit = m403C().m9740f().submit(c04151);
        C3218c.m9728h().m9687a("CrashlyticsCore", "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            submit.get(4, TimeUnit.SECONDS);
        } catch (Throwable e) {
            C3218c.m9728h().m9695e("CrashlyticsCore", "Crashlytics was interrupted during initialization.", e);
        } catch (Throwable e2) {
            C3218c.m9728h().m9695e("CrashlyticsCore", "Problem encountered during Crashlytics initialization.", e2);
        } catch (Throwable e22) {
            C3218c.m9728h().m9695e("CrashlyticsCore", "Crashlytics timed out during initialization.", e22);
        }
    }

    static void m670d(String str) {
        C0362a c0362a = (C0362a) C3218c.m9720a(C0362a.class);
        if (c0362a != null) {
            c0362a.m466a(new C3253b(str));
        }
    }

    static void m672e(String str) {
        C0362a c0362a = (C0362a) C3218c.m9720a(C0362a.class);
        if (c0362a != null) {
            c0362a.m465a(new C3252a(str));
        }
    }

    Map<String, String> m688g() {
        return Collections.unmodifiableMap(this.f557b);
    }

    C0405a m675a(String str, boolean z) {
        return new C0405a(str, z);
    }

    String m689h() {
        return this.f566p;
    }

    String m690i() {
        return this.f567q;
    }

    String m691j() {
        return this.f569s;
    }

    String m692k() {
        return this.f568r;
    }

    String m693l() {
        return CommonUtils.m9863b(m402B(), "com.crashlytics.ApiEndpoint");
    }

    C0446i m694m() {
        return this.f561k;
    }

    String m695n() {
        return m401A().m9892a() ? this.f562l : null;
    }

    String m696o() {
        return m401A().m9892a() ? this.f563m : null;
    }

    String m697p() {
        return m401A().m9892a() ? this.f564n : null;
    }

    void m698q() {
        this.f574x.m707a(new C04162(this));
    }

    void m699r() {
        this.f574x.m709b(new C04173(this));
    }

    boolean m700s() {
        return ((Boolean) this.f574x.m707a(new C04184(this))).booleanValue();
    }

    C0400d m701t() {
        if (this.f575y != null) {
            return this.f575y.m616a();
        }
        return null;
    }

    File m702u() {
        if (this.f558c == null) {
            this.f558c = new C3237b(this).m9825a();
        }
        return this.f558c;
    }

    boolean m703v() {
        return ((Boolean) C3321q.m10135a().m10138a(new C04205(this), Boolean.valueOf(false))).booleanValue();
    }

    boolean m704w() {
        return new C3239d(this).m9827a().getBoolean("always_send_reports_opt_in", false);
    }

    @SuppressLint({"CommitPrefEdits"})
    void m681a(boolean z) {
        C3238c c3239d = new C3239d(this);
        c3239d.m9828a(c3239d.m9829b().putBoolean("always_send_reports_opt_in", z));
    }

    boolean m705x() {
        return ((Boolean) C3321q.m10135a().m10138a(new C04216(this), Boolean.valueOf(true))).booleanValue();
    }

    C0448k m676a(C3322s c3322s) {
        if (c3322s != null) {
            return new C0449l(this, m693l(), c3322s.f7248a.f7209d, this.f573w);
        }
        return null;
    }

    private boolean m665a(Activity activity, C3317o c3317o) {
        C0450m c0450m = new C0450m(activity, c3317o);
        C0426a c0426a = new C0426a();
        activity.runOnUiThread(new C04257(this, activity, c0426a, c0450m, c3317o));
        C3218c.m9728h().m9687a("CrashlyticsCore", "Waiting for user opt-in.");
        c0426a.m659b();
        return c0426a.m658a();
    }

    C3318p m706y() {
        C3322s b = C3321q.m10135a().m10139b();
        return b == null ? null : b.f7249b;
    }

    private boolean m668b(Context context) {
        return CommonUtils.m9858a(context, "com.crashlytics.RequireBuildId", true);
    }

    private static String m669c(int i, String str, String str2) {
        return CommonUtils.m9862b(i) + "/" + str + " " + str2;
    }

    private static boolean m673f(String str) {
        C0427e e = C0427e.m671e();
        if (e != null && e.f561k != null) {
            return true;
        }
        C3218c.m9728h().m9695e("CrashlyticsCore", "Crashlytics must be initialized by calling Fabric.with(Context) " + str, null);
        return false;
    }

    private static String m674g(String str) {
        if (str == null) {
            return str;
        }
        str = str.trim();
        if (str.length() > Place.TYPE_SUBLOCALITY_LEVEL_2) {
            return str.substring(0, Place.TYPE_SUBLOCALITY_LEVEL_2);
        }
        return str;
    }

    private int m661a(float f, int i) {
        return (int) (((float) i) * f);
    }
}
