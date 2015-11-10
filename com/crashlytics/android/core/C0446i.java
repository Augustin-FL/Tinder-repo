package com.crashlytics.android.core;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.crashlytics.android.core.i.AnonymousClass13;
import com.crashlytics.android.core.i.AnonymousClass14;
import com.crashlytics.android.core.i.AnonymousClass15;
import com.crashlytics.android.core.p005a.p006a.C0400d;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import io.fabric.sdk.android.C3218c;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.DeliveryMechanism;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.settings.C3318p;
import io.fabric.sdk.android.services.settings.C3321q;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.Flushable;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.crashlytics.android.core.i */
class C0446i implements UncaughtExceptionHandler {
    static final FilenameFilter f608a;
    static final Comparator<File> f609b;
    static final Comparator<File> f610c;
    static final FilenameFilter f611d;
    private static final Pattern f612e;
    private static final Map<String, String> f613f;
    private final AtomicInteger f614g;
    private final AtomicBoolean f615h;
    private final UncaughtExceptionHandler f616i;
    private final File f617j;
    private final AtomicBoolean f618k;
    private final BroadcastReceiver f619l;
    private final BroadcastReceiver f620m;
    private final C0430f f621n;
    private final IdManager f622o;
    private boolean f623p;
    private final C0427e f624q;
    private final C0455p f625r;
    private final C0481w f626s;

    /* renamed from: com.crashlytics.android.core.i.13 */
    class AnonymousClass13 implements Callable<Void> {
        final /* synthetic */ Date f584a;
        final /* synthetic */ Thread f585b;
        final /* synthetic */ Throwable f586c;
        final /* synthetic */ C0446i f587d;

        AnonymousClass13(C0446i c0446i, Date date, Thread thread, Throwable th) {
            this.f587d = c0446i;
            this.f584a = date;
            this.f585b = thread;
            this.f586c = th;
        }

        public /* synthetic */ Object call() throws Exception {
            return m719a();
        }

        public Void m719a() throws Exception {
            this.f587d.m742a(this.f584a, this.f585b, this.f586c);
            return null;
        }
    }

    /* renamed from: com.crashlytics.android.core.i.14 */
    class AnonymousClass14 implements Callable<Void> {
        final /* synthetic */ long f588a;
        final /* synthetic */ String f589b;
        final /* synthetic */ C0446i f590c;

        AnonymousClass14(C0446i c0446i, long j, String str) {
            this.f590c = c0446i;
            this.f588a = j;
            this.f589b = str;
        }

        public /* synthetic */ Object call() throws Exception {
            return m720a();
        }

        public Void m720a() throws Exception {
            if (!this.f590c.f618k.get()) {
                this.f590c.f625r.m811a(this.f588a, this.f589b);
            }
            return null;
        }
    }

    /* renamed from: com.crashlytics.android.core.i.15 */
    class AnonymousClass15 implements Runnable {
        final /* synthetic */ Date f591a;
        final /* synthetic */ Thread f592b;
        final /* synthetic */ Throwable f593c;
        final /* synthetic */ C0446i f594d;

        AnonymousClass15(C0446i c0446i, Date date, Thread thread, Throwable th) {
            this.f594d = c0446i;
            this.f591a = date;
            this.f592b = thread;
            this.f593c = th;
        }

        public void run() {
            if (!this.f594d.f618k.get()) {
                this.f594d.m755c(this.f591a, this.f592b, this.f593c);
            }
        }
    }

    /* renamed from: com.crashlytics.android.core.i.1 */
    static class C04341 implements FilenameFilter {
        C04341() {
        }

        public boolean accept(File file, String str) {
            return str.length() == ".cls".length() + 35 && str.endsWith(".cls");
        }
    }

    /* renamed from: com.crashlytics.android.core.i.2 */
    class C04352 implements Callable<Void> {
        final /* synthetic */ String f595a;
        final /* synthetic */ String f596b;
        final /* synthetic */ String f597c;
        final /* synthetic */ C0446i f598d;

        C04352(C0446i c0446i, String str, String str2, String str3) {
            this.f598d = c0446i;
            this.f595a = str;
            this.f596b = str2;
            this.f597c = str3;
        }

        public /* synthetic */ Object call() throws Exception {
            return m721a();
        }

        public Void m721a() throws Exception {
            new C0457q(this.f598d.f617j).m823a(this.f598d.m765j(), new C0483y(this.f595a, this.f596b, this.f597c));
            return null;
        }
    }

    /* renamed from: com.crashlytics.android.core.i.3 */
    class C04363 implements Callable<Void> {
        final /* synthetic */ C0446i f599a;

        C04363(C0446i c0446i) {
            this.f599a = c0446i;
        }

        public /* synthetic */ Object call() throws Exception {
            return m722a();
        }

        public Void m722a() throws Exception {
            this.f599a.m767l();
            return null;
        }
    }

    /* renamed from: com.crashlytics.android.core.i.4 */
    class C04374 implements Callable<Boolean> {
        final /* synthetic */ C0446i f600a;

        C04374(C0446i c0446i) {
            this.f600a = c0446i;
        }

        public /* synthetic */ Object call() throws Exception {
            return m723a();
        }

        public Boolean m723a() throws Exception {
            if (this.f600a.f618k.get()) {
                C3218c.m9728h().m9687a("CrashlyticsCore", "Skipping session finalization because a crash has already occurred.");
                return Boolean.valueOf(false);
            }
            C3218c.m9728h().m9687a("CrashlyticsCore", "Finalizing previously open sessions.");
            C0400d t = this.f600a.f624q.m701t();
            if (t != null) {
                this.f600a.m733a(t);
            }
            this.f600a.m743a(true);
            C3218c.m9728h().m9687a("CrashlyticsCore", "Closed all previously open sessions");
            return Boolean.valueOf(true);
        }
    }

    /* renamed from: com.crashlytics.android.core.i.5 */
    class C04385 implements Runnable {
        final /* synthetic */ C0446i f601a;

        C04385(C0446i c0446i) {
            this.f601a = c0446i;
        }

        public void run() {
            this.f601a.m774a(this.f601a.m746a(C0409d.f531a));
        }
    }

    /* renamed from: com.crashlytics.android.core.i.6 */
    class C04396 implements FilenameFilter {
        final /* synthetic */ String f602a;
        final /* synthetic */ C0446i f603b;

        C04396(C0446i c0446i, String str) {
            this.f603b = c0446i;
            this.f602a = str;
        }

        public boolean accept(File file, String str) {
            return str.startsWith(this.f602a);
        }
    }

    /* renamed from: com.crashlytics.android.core.i.7 */
    class C04407 implements Runnable {
        final /* synthetic */ File f604a;
        final /* synthetic */ C0446i f605b;

        C04407(C0446i c0446i, File file) {
            this.f605b = c0446i;
            this.f604a = file;
        }

        public void run() {
            if (CommonUtils.m9879n(this.f605b.f624q.m402B())) {
                C3218c.m9728h().m9687a("CrashlyticsCore", "Attempting to send crash report at time of crash...");
                C0448k a = this.f605b.f624q.m676a(C3321q.m10135a().m10139b());
                if (a != null) {
                    new C0480v(a).m882a(new C0482x(this.f604a, C0446i.f613f));
                }
            }
        }
    }

    /* renamed from: com.crashlytics.android.core.i.8 */
    static class C04418 implements Comparator<File> {
        C04418() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m724a((File) obj, (File) obj2);
        }

        public int m724a(File file, File file2) {
            return file2.getName().compareTo(file.getName());
        }
    }

    /* renamed from: com.crashlytics.android.core.i.9 */
    static class C04429 implements Comparator<File> {
        C04429() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m725a((File) obj, (File) obj2);
        }

        public int m725a(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }
    }

    /* renamed from: com.crashlytics.android.core.i.a */
    private static class C0443a implements FilenameFilter {
        private C0443a() {
        }

        public boolean accept(File file, String str) {
            return !C0446i.f608a.accept(file, str) && C0446i.f612e.matcher(str).matches();
        }
    }

    /* renamed from: com.crashlytics.android.core.i.b */
    static class C0444b implements FilenameFilter {
        private final String f606a;

        public C0444b(String str) {
            this.f606a = str;
        }

        public boolean accept(File file, String str) {
            return str.contains(this.f606a) && !str.endsWith(".cls_temp");
        }
    }

    /* renamed from: com.crashlytics.android.core.i.c */
    static class C0445c implements FilenameFilter {
        private final String f607a;

        public C0445c(String str) {
            this.f607a = str;
        }

        public boolean accept(File file, String str) {
            if (str.equals(this.f607a + ".cls") || !str.contains(this.f607a) || str.endsWith(".cls_temp")) {
                return false;
            }
            return true;
        }
    }

    static {
        f608a = new C04341();
        f609b = new C04418();
        f610c = new C04429();
        f611d = new FilenameFilter() {
            public boolean accept(File file, String str) {
                return C0446i.f612e.matcher(str).matches();
            }
        };
        f612e = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");
        f613f = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", AppEventsConstants.EVENT_PARAM_VALUE_YES);
    }

    C0446i(UncaughtExceptionHandler uncaughtExceptionHandler, C0431g c0431g, C0430f c0430f, IdManager idManager, C0481w c0481w, C0427e c0427e) {
        this.f614g = new AtomicInteger(0);
        this.f615h = new AtomicBoolean(false);
        this.f616i = uncaughtExceptionHandler;
        this.f621n = c0430f;
        this.f622o = idManager;
        this.f624q = c0427e;
        this.f626s = c0481w;
        this.f618k = new AtomicBoolean(false);
        this.f617j = c0427e.m702u();
        this.f625r = new C0455p(c0427e.m402B(), this.f617j);
        m735a(c0431g);
        this.f620m = new BroadcastReceiver() {
            final /* synthetic */ C0446i f582a;

            {
                this.f582a = r1;
            }

            public void onReceive(Context context, Intent intent) {
                this.f582a.f623p = true;
            }
        };
        IntentFilter intentFilter = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");
        this.f619l = new BroadcastReceiver() {
            final /* synthetic */ C0446i f583a;

            {
                this.f583a = r1;
            }

            public void onReceive(Context context, Intent intent) {
                this.f583a.f623p = false;
            }
        };
        IntentFilter intentFilter2 = new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED");
        Context B = c0427e.m402B();
        B.registerReceiver(this.f620m, intentFilter);
        B.registerReceiver(this.f619l, intentFilter2);
        this.f615h.set(true);
    }

    public synchronized void uncaughtException(Thread thread, Throwable th) {
        this.f618k.set(true);
        try {
            C3218c.m9728h().m9687a("CrashlyticsCore", "Crashlytics is handling uncaught exception \"" + th + "\" from thread " + thread.getName());
            if (!this.f615h.getAndSet(true)) {
                C3218c.m9728h().m9687a("CrashlyticsCore", "Unregistering power receivers.");
                Context B = this.f624q.m402B();
                B.unregisterReceiver(this.f620m);
                B.unregisterReceiver(this.f619l);
            }
            this.f621n.m707a(new AnonymousClass13(this, new Date(), thread, th));
            C3218c.m9728h().m9687a("CrashlyticsCore", "Crashlytics completed exception processing. Invoking default exception handler.");
            this.f616i.uncaughtException(thread, th);
            this.f618k.set(false);
        } catch (Throwable e) {
            C3218c.m9728h().m9695e("CrashlyticsCore", "An error occurred in the uncaught exception handler", e);
            C3218c.m9728h().m9687a("CrashlyticsCore", "Crashlytics completed exception processing. Invoking default exception handler.");
            this.f616i.uncaughtException(thread, th);
            this.f618k.set(false);
        } catch (Throwable th2) {
            C3218c.m9728h().m9687a("CrashlyticsCore", "Crashlytics completed exception processing. Invoking default exception handler.");
            this.f616i.uncaughtException(thread, th);
            this.f618k.set(false);
        }
    }

    private void m742a(Date date, Thread thread, Throwable th) throws Exception {
        m750b(date, thread, th);
        m778d();
        m767l();
        m780f();
        if (!this.f624q.m703v()) {
            m770o();
        }
    }

    boolean m775a() {
        return this.f618k.get();
    }

    private void m735a(C0431g c0431g) {
        C3218c.m9728h().m9687a("CrashlyticsCore", "Checking for previous crash marker.");
        File file = new File(this.f624q.m702u(), "crash_marker");
        if (file.exists()) {
            file.delete();
            if (c0431g != null) {
                try {
                    c0431g.m710a();
                } catch (Throwable e) {
                    C3218c.m9728h().m9695e("CrashlyticsCore", "Exception thrown by CrashlyticsListener while notifying of previous crash.", e);
                }
            }
        }
    }

    void m771a(long j, String str) {
        this.f621n.m709b(new AnonymousClass14(this, j, str));
    }

    void m773a(Thread thread, Throwable th) {
        this.f621n.m708a(new AnonymousClass15(this, new Date(), thread, th));
    }

    private void m750b(Date date, Thread thread, Throwable th) {
        Closeable c0409d;
        Throwable e;
        Flushable flushable = null;
        try {
            Closeable closeable;
            new File(this.f617j, "crash_marker").createNewFile();
            String j = m765j();
            if (j != null) {
                C0427e.m672e(j);
                c0409d = new C0409d(this.f617j, j + "SessionCrash");
                try {
                    flushable = CodedOutputStream.m566a((OutputStream) c0409d);
                    m731a(flushable, date, thread, th, "crash", true);
                    closeable = c0409d;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C3218c.m9728h().m9695e("CrashlyticsCore", "An error occurred in the fatal exception logger", e);
                        C0451n.m795a(e, (OutputStream) c0409d);
                        CommonUtils.m9856a(flushable, "Failed to flush to session begin file.");
                        CommonUtils.m9855a(c0409d, "Failed to close fatal exception file output stream.");
                    } catch (Throwable th2) {
                        e = th2;
                        CommonUtils.m9856a(flushable, "Failed to flush to session begin file.");
                        CommonUtils.m9855a(c0409d, "Failed to close fatal exception file output stream.");
                        throw e;
                    }
                }
            }
            C3218c.m9728h().m9695e("CrashlyticsCore", "Tried to write a fatal exception while no session was open.", null);
            closeable = null;
            CommonUtils.m9856a(flushable, "Failed to flush to session begin file.");
            CommonUtils.m9855a(closeable, "Failed to close fatal exception file output stream.");
        } catch (Exception e3) {
            e = e3;
            c0409d = null;
            C3218c.m9728h().m9695e("CrashlyticsCore", "An error occurred in the fatal exception logger", e);
            C0451n.m795a(e, (OutputStream) c0409d);
            CommonUtils.m9856a(flushable, "Failed to flush to session begin file.");
            CommonUtils.m9855a(c0409d, "Failed to close fatal exception file output stream.");
        } catch (Throwable th3) {
            e = th3;
            c0409d = null;
            CommonUtils.m9856a(flushable, "Failed to flush to session begin file.");
            CommonUtils.m9855a(c0409d, "Failed to close fatal exception file output stream.");
            throw e;
        }
    }

    private void m733a(C0400d c0400d) throws IOException {
        Closeable c0409d;
        Throwable th;
        Closeable closeable;
        Flushable flushable;
        Throwable th2;
        Flushable flushable2;
        Flushable flushable3 = null;
        try {
            String k = m766k();
            if (k != null) {
                C0427e.m672e(k);
                c0409d = new C0409d(this.f617j, k + "SessionCrash");
                try {
                    flushable3 = CodedOutputStream.m566a((OutputStream) c0409d);
                } catch (Throwable e) {
                    th = e;
                    closeable = c0409d;
                    flushable = flushable3;
                    th2 = th;
                    try {
                        C3218c.m9728h().m9695e("CrashlyticsCore", "An error occurred in the native crash logger", th2);
                        C0451n.m795a(th2, (OutputStream) closeable);
                        CommonUtils.m9856a(flushable, "Failed to flush to session begin file.");
                        CommonUtils.m9855a(closeable, "Failed to close fatal exception file output stream.");
                    } catch (Throwable th3) {
                        th2 = th3;
                        CommonUtils.m9856a(flushable, "Failed to flush to session begin file.");
                        CommonUtils.m9855a(closeable, "Failed to close fatal exception file output stream.");
                        throw th2;
                    }
                } catch (Throwable e2) {
                    th = e2;
                    closeable = c0409d;
                    flushable = flushable3;
                    th2 = th;
                    CommonUtils.m9856a(flushable, "Failed to flush to session begin file.");
                    CommonUtils.m9855a(closeable, "Failed to close fatal exception file output stream.");
                    throw th2;
                }
                try {
                    C0471r.m856a(c0400d, new C0455p(this.f624q.m402B(), this.f617j, k), new C0457q(this.f617j).m824b(k), flushable3);
                } catch (Throwable e22) {
                    th = e22;
                    closeable = c0409d;
                    flushable = flushable3;
                    th2 = th;
                    C3218c.m9728h().m9695e("CrashlyticsCore", "An error occurred in the native crash logger", th2);
                    C0451n.m795a(th2, (OutputStream) closeable);
                    CommonUtils.m9856a(flushable, "Failed to flush to session begin file.");
                    CommonUtils.m9855a(closeable, "Failed to close fatal exception file output stream.");
                } catch (Throwable e222) {
                    th = e222;
                    closeable = c0409d;
                    flushable = flushable3;
                    th2 = th;
                    CommonUtils.m9856a(flushable, "Failed to flush to session begin file.");
                    CommonUtils.m9855a(closeable, "Failed to close fatal exception file output stream.");
                    throw th2;
                }
            }
            C3218c.m9728h().m9695e("CrashlyticsCore", "Tried to write a native crash while no session was open.", null);
            Object obj = flushable3;
            CommonUtils.m9856a(flushable3, "Failed to flush to session begin file.");
            CommonUtils.m9855a(c0409d, "Failed to close fatal exception file output stream.");
        } catch (Throwable e3) {
            closeable = flushable3;
            flushable2 = flushable3;
            th2 = e3;
            flushable = flushable2;
            C3218c.m9728h().m9695e("CrashlyticsCore", "An error occurred in the native crash logger", th2);
            C0451n.m795a(th2, (OutputStream) closeable);
            CommonUtils.m9856a(flushable, "Failed to flush to session begin file.");
            CommonUtils.m9855a(closeable, "Failed to close fatal exception file output stream.");
        } catch (Throwable e32) {
            closeable = flushable3;
            flushable2 = flushable3;
            th2 = e32;
            flushable = flushable2;
            CommonUtils.m9856a(flushable, "Failed to flush to session begin file.");
            CommonUtils.m9855a(closeable, "Failed to close fatal exception file output stream.");
            throw th2;
        }
    }

    void m772a(String str, String str2, String str3) {
        this.f621n.m709b(new C04352(this, str, str2, str3));
    }

    void m776b() {
        this.f621n.m709b(new C04363(this));
    }

    private String m765j() {
        File[] e = m779e();
        Arrays.sort(e, f609b);
        return e.length > 0 ? m726a(e[0]) : null;
    }

    private String m766k() {
        File[] e = m779e();
        Arrays.sort(e, f609b);
        return e.length > 1 ? m726a(e[1]) : null;
    }

    private String m726a(File file) {
        return file.getName().substring(0, 35);
    }

    boolean m777c() {
        return ((Boolean) this.f621n.m707a(new C04374(this))).booleanValue();
    }

    private void m767l() throws Exception {
        Date date = new Date();
        String c0407c = new C0407c(this.f622o).toString();
        C3218c.m9728h().m9687a("CrashlyticsCore", "Opening an new session with ID " + c0407c);
        m741a(c0407c, date);
        m754c(c0407c);
        m757d(c0407c);
        m759e(c0407c);
        this.f625r.m813a(c0407c);
    }

    void m778d() throws Exception {
        m743a(false);
    }

    private void m743a(boolean z) throws Exception {
        int i = z ? 1 : 0;
        m728a(i + 8);
        File[] e = m779e();
        Arrays.sort(e, f609b);
        if (e.length > i) {
            m761f(m726a(e[i]));
            C3318p y = this.f624q.m706y();
            if (y != null) {
                int i2 = y.f7239c;
                C3218c.m9728h().m9687a("CrashlyticsCore", "Closing open sessions.");
                while (i < e.length) {
                    File file = e[i];
                    String a = m726a(file);
                    C3218c.m9728h().m9687a("CrashlyticsCore", "Closing session: " + a);
                    m738a(file, a, i2);
                    i++;
                }
                return;
            }
            C3218c.m9728h().m9687a("CrashlyticsCore", "Unable to close session. Settings are not loaded.");
            return;
        }
        C3218c.m9728h().m9687a("CrashlyticsCore", "No open sessions to be closed.");
    }

    private void m734a(C0409d c0409d) {
        if (c0409d != null) {
            try {
                c0409d.m630a();
            } catch (Throwable e) {
                C3218c.m9728h().m9695e("CrashlyticsCore", "Error closing session file stream in the presence of an exception", e);
            }
        }
    }

    private void m739a(String str) {
        for (File delete : m751b(str)) {
            delete.delete();
        }
    }

    private File[] m751b(String str) {
        return m746a(new C0445c(str));
    }

    private File[] m768m() {
        return m746a(f608a);
    }

    File[] m779e() {
        return m746a(new C0444b("BeginSession"));
    }

    private File[] m746a(FilenameFilter filenameFilter) {
        return m752b(this.f617j.listFiles(filenameFilter));
    }

    private File[] m752b(File[] fileArr) {
        return fileArr == null ? new File[0] : fileArr;
    }

    private void m740a(String str, int i) {
        C0484z.m920a(this.f617j, new C0444b(str + "SessionEvent"), i, f610c);
    }

    void m780f() {
        C0484z.m920a(this.f617j, f608a, 4, f610c);
    }

    private void m728a(int i) {
        int i2 = 0;
        Set hashSet = new HashSet();
        File[] e = m779e();
        Arrays.sort(e, f609b);
        int min = Math.min(i, e.length);
        for (int i3 = 0; i3 < min; i3++) {
            hashSet.add(m726a(e[i3]));
        }
        this.f625r.m814a(hashSet);
        File[] a = m746a(new C0443a());
        int length = a.length;
        while (i2 < length) {
            File file = a[i2];
            Object name = file.getName();
            Matcher matcher = f612e.matcher(name);
            matcher.matches();
            if (!hashSet.contains(matcher.group(1))) {
                C3218c.m9728h().m9687a("CrashlyticsCore", "Trimming open session file: " + name);
                file.delete();
            }
            i2++;
        }
    }

    void m781g() {
        this.f621n.m708a(new C04385(this));
    }

    void m774a(File[] fileArr) {
        m769n();
        for (File file : fileArr) {
            C3218c.m9728h().m9687a("CrashlyticsCore", "Found invalid session part file: " + file);
            String a = m726a(file);
            FilenameFilter c04396 = new C04396(this, a);
            C3218c.m9728h().m9687a("CrashlyticsCore", "Deleting all part files for invalid session: " + a);
            for (File file2 : m746a(c04396)) {
                C3218c.m9728h().m9687a("CrashlyticsCore", "Deleting session file: " + file2);
                file2.delete();
            }
        }
    }

    private void m769n() {
        File file = new File(this.f624q.m702u(), "invalidClsFiles");
        if (file.exists()) {
            if (file.isDirectory()) {
                for (File delete : file.listFiles()) {
                    delete.delete();
                }
            }
            file.delete();
        }
    }

    private void m741a(String str, Date date) throws Exception {
        Closeable c0409d;
        Throwable e;
        OutputStream outputStream;
        Flushable flushable = null;
        try {
            c0409d = new C0409d(this.f617j, str + "BeginSession");
            try {
                flushable = CodedOutputStream.m566a((OutputStream) c0409d);
                this.f626s.m910a((CodedOutputStream) flushable, str, String.format(Locale.US, "Crashlytics Android SDK/%s", new Object[]{this.f624q.m677a()}), date.getTime() / 1000);
                CommonUtils.m9856a(flushable, "Failed to flush to session begin file.");
                CommonUtils.m9855a(c0409d, "Failed to close begin session file.");
            } catch (Exception e2) {
                e = e2;
                Closeable closeable = c0409d;
                try {
                    C0451n.m795a(e, outputStream);
                    throw e;
                } catch (Throwable th) {
                    e = th;
                    c0409d = outputStream;
                    CommonUtils.m9856a(flushable, "Failed to flush to session begin file.");
                    CommonUtils.m9855a(c0409d, "Failed to close begin session file.");
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                CommonUtils.m9856a(flushable, "Failed to flush to session begin file.");
                CommonUtils.m9855a(c0409d, "Failed to close begin session file.");
                throw e;
            }
        } catch (Exception e3) {
            e = e3;
            outputStream = null;
            C0451n.m795a(e, outputStream);
            throw e;
        } catch (Throwable th3) {
            e = th3;
            c0409d = null;
            CommonUtils.m9856a(flushable, "Failed to flush to session begin file.");
            CommonUtils.m9855a(c0409d, "Failed to close begin session file.");
            throw e;
        }
    }

    private void m754c(String str) throws Exception {
        Throwable e;
        OutputStream outputStream;
        Flushable flushable = null;
        Closeable c0409d;
        try {
            c0409d = new C0409d(this.f617j, str + "SessionApp");
            try {
                flushable = CodedOutputStream.m566a((OutputStream) c0409d);
                this.f626s.m912a((CodedOutputStream) flushable, this.f624q.m689h(), this.f624q.m692k(), this.f624q.m691j(), this.f622o.m9893b(), DeliveryMechanism.m9880a(this.f624q.m690i()).m9881a());
                CommonUtils.m9856a(flushable, "Failed to flush to session app file.");
                CommonUtils.m9855a(c0409d, "Failed to close session app file.");
            } catch (Exception e2) {
                e = e2;
                Closeable closeable = c0409d;
                try {
                    C0451n.m795a(e, outputStream);
                    throw e;
                } catch (Throwable th) {
                    e = th;
                    c0409d = outputStream;
                    CommonUtils.m9856a(flushable, "Failed to flush to session app file.");
                    CommonUtils.m9855a(c0409d, "Failed to close session app file.");
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                CommonUtils.m9856a(flushable, "Failed to flush to session app file.");
                CommonUtils.m9855a(c0409d, "Failed to close session app file.");
                throw e;
            }
        } catch (Exception e3) {
            e = e3;
            outputStream = null;
            C0451n.m795a(e, outputStream);
            throw e;
        } catch (Throwable th3) {
            e = th3;
            c0409d = null;
            CommonUtils.m9856a(flushable, "Failed to flush to session app file.");
            CommonUtils.m9855a(c0409d, "Failed to close session app file.");
            throw e;
        }
    }

    private void m757d(String str) throws Exception {
        Closeable c0409d;
        Throwable e;
        Flushable flushable = null;
        try {
            c0409d = new C0409d(this.f617j, str + "SessionOS");
            try {
                flushable = CodedOutputStream.m566a((OutputStream) c0409d);
                this.f626s.m913a((CodedOutputStream) flushable, CommonUtils.m9872g(this.f624q.m402B()));
                CommonUtils.m9856a(flushable, "Failed to flush to session OS file.");
                CommonUtils.m9855a(c0409d, "Failed to close session OS file.");
            } catch (Exception e2) {
                e = e2;
                try {
                    C0451n.m795a(e, (OutputStream) c0409d);
                    throw e;
                } catch (Throwable th) {
                    e = th;
                    CommonUtils.m9856a(flushable, "Failed to flush to session OS file.");
                    CommonUtils.m9855a(c0409d, "Failed to close session OS file.");
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            c0409d = null;
            C0451n.m795a(e, (OutputStream) c0409d);
            throw e;
        } catch (Throwable th2) {
            e = th2;
            c0409d = null;
            CommonUtils.m9856a(flushable, "Failed to flush to session OS file.");
            CommonUtils.m9855a(c0409d, "Failed to close session OS file.");
            throw e;
        }
    }

    private void m759e(String str) throws Exception {
        Throwable e;
        OutputStream outputStream;
        OutputStream outputStream2 = null;
        Flushable flushable = null;
        try {
            OutputStream c0409d = new C0409d(this.f617j, str + "SessionDevice");
            try {
                flushable = CodedOutputStream.m566a(c0409d);
                Context B = this.f624q.m402B();
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                this.f626s.m909a((CodedOutputStream) flushable, this.f622o.m9897f(), CommonUtils.m9835a(), Build.MODEL, Runtime.getRuntime().availableProcessors(), CommonUtils.m9859b(), ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize()), CommonUtils.m9871f(B), this.f622o.m9898g(), CommonUtils.m9873h(B), Build.MANUFACTURER, Build.PRODUCT);
                CommonUtils.m9856a(flushable, "Failed to flush session device info.");
                CommonUtils.m9855a((Closeable) c0409d, "Failed to close session device file.");
            } catch (Exception e2) {
                e = e2;
                outputStream2 = c0409d;
                try {
                    C0451n.m795a(e, outputStream2);
                    throw e;
                } catch (Throwable th) {
                    e = th;
                    outputStream = outputStream2;
                    CommonUtils.m9856a(flushable, "Failed to flush session device info.");
                    CommonUtils.m9855a((Closeable) outputStream, "Failed to close session device file.");
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                CommonUtils.m9856a(flushable, "Failed to flush session device info.");
                CommonUtils.m9855a((Closeable) outputStream, "Failed to close session device file.");
                throw e;
            }
        } catch (Exception e3) {
            e = e3;
            C0451n.m795a(e, outputStream2);
            throw e;
        } catch (Throwable th3) {
            e = th3;
            outputStream = null;
            CommonUtils.m9856a(flushable, "Failed to flush session device info.");
            CommonUtils.m9855a((Closeable) outputStream, "Failed to close session device file.");
            throw e;
        }
    }

    private void m761f(String str) throws Exception {
        Throwable e;
        Flushable flushable = null;
        Closeable c0409d;
        try {
            c0409d = new C0409d(this.f617j, str + "SessionUser");
            try {
                flushable = CodedOutputStream.m566a((OutputStream) c0409d);
                C0483y g = m762g(str);
                if (g.m919a()) {
                    CommonUtils.m9856a(flushable, "Failed to flush session user file.");
                    CommonUtils.m9855a(c0409d, "Failed to close session user file.");
                    return;
                }
                this.f626s.m911a((CodedOutputStream) flushable, g.f698b, g.f699c, g.f700d);
                CommonUtils.m9856a(flushable, "Failed to flush session user file.");
                CommonUtils.m9855a(c0409d, "Failed to close session user file.");
            } catch (Exception e2) {
                e = e2;
                try {
                    C0451n.m795a(e, (OutputStream) c0409d);
                    throw e;
                } catch (Throwable th) {
                    e = th;
                    CommonUtils.m9856a(flushable, "Failed to flush session user file.");
                    CommonUtils.m9855a(c0409d, "Failed to close session user file.");
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            c0409d = null;
            C0451n.m795a(e, (OutputStream) c0409d);
            throw e;
        } catch (Throwable th2) {
            e = th2;
            c0409d = null;
            CommonUtils.m9856a(flushable, "Failed to flush session user file.");
            CommonUtils.m9855a(c0409d, "Failed to close session user file.");
            throw e;
        }
    }

    private C0483y m762g(String str) {
        return m775a() ? new C0483y(this.f624q.m695n(), this.f624q.m697p(), this.f624q.m696o()) : new C0457q(this.f617j).m822a(str);
    }

    private void m731a(CodedOutputStream codedOutputStream, Date date, Thread thread, Throwable th, String str, boolean z) throws Exception {
        Thread[] threadArr;
        Map map;
        Context B = this.f624q.m402B();
        long time = date.getTime() / 1000;
        float c = CommonUtils.m9865c(B);
        int a = CommonUtils.m9837a(B, this.f623p);
        boolean d = CommonUtils.m9869d(B);
        int i = B.getResources().getConfiguration().orientation;
        long b = CommonUtils.m9859b() - CommonUtils.m9860b(B);
        long b2 = CommonUtils.m9861b(Environment.getDataDirectory().getPath());
        RunningAppProcessInfo a2 = CommonUtils.m9839a(B.getPackageName(), B);
        List linkedList = new LinkedList();
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (z) {
            Map allStackTraces = Thread.getAllStackTraces();
            threadArr = new Thread[allStackTraces.size()];
            int i2 = 0;
            for (Entry entry : allStackTraces.entrySet()) {
                threadArr[i2] = (Thread) entry.getKey();
                linkedList.add(entry.getValue());
                i2++;
            }
        } else {
            threadArr = new Thread[0];
        }
        if (CommonUtils.m9858a(B, "com.crashlytics.CollectCustomKeys", true)) {
            Map g = this.f624q.m688g();
            if (g == null || g.size() <= 1) {
                map = g;
            } else {
                Map treeMap = new TreeMap(g);
            }
        } else {
            map = new TreeMap();
        }
        CodedOutputStream codedOutputStream2 = codedOutputStream;
        Thread thread2 = thread;
        Throwable th2 = th;
        String str2 = str;
        this.f626s.m908a(codedOutputStream2, time, thread2, th2, str2, threadArr, c, a, d, i, b, b2, a2, linkedList, stackTrace, this.f625r, map);
    }

    private void m755c(Date date, Thread thread, Throwable th) {
        Throwable e;
        Closeable closeable;
        Flushable flushable = null;
        String j = m765j();
        if (j != null) {
            C0427e.m670d(j);
            try {
                C3218c.m9728h().m9687a("CrashlyticsCore", "Crashlytics is logging non-fatal exception \"" + th + "\" from thread " + thread.getName());
                Closeable c0409d = new C0409d(this.f617j, j + "SessionEvent" + CommonUtils.m9841a(this.f614g.getAndIncrement()));
                try {
                    flushable = CodedOutputStream.m566a((OutputStream) c0409d);
                    m731a(flushable, date, thread, th, NativeProtocol.BRIDGE_ARG_ERROR_BUNDLE, false);
                    CommonUtils.m9856a(flushable, "Failed to flush to non-fatal file.");
                    CommonUtils.m9855a(c0409d, "Failed to close non-fatal file output stream.");
                } catch (Exception e2) {
                    e = e2;
                    closeable = c0409d;
                    try {
                        C3218c.m9728h().m9695e("CrashlyticsCore", "An error occurred in the non-fatal exception logger", e);
                        C0451n.m795a(e, (OutputStream) closeable);
                        CommonUtils.m9856a(flushable, "Failed to flush to non-fatal file.");
                        CommonUtils.m9855a(closeable, "Failed to close non-fatal file output stream.");
                        m740a(j, 64);
                        return;
                    } catch (Throwable th2) {
                        e = th2;
                        CommonUtils.m9856a(flushable, "Failed to flush to non-fatal file.");
                        CommonUtils.m9855a(closeable, "Failed to close non-fatal file output stream.");
                        throw e;
                    }
                } catch (Throwable th3) {
                    e = th3;
                    closeable = c0409d;
                    CommonUtils.m9856a(flushable, "Failed to flush to non-fatal file.");
                    CommonUtils.m9855a(closeable, "Failed to close non-fatal file output stream.");
                    throw e;
                }
            } catch (Exception e3) {
                e = e3;
                closeable = null;
                C3218c.m9728h().m9695e("CrashlyticsCore", "An error occurred in the non-fatal exception logger", e);
                C0451n.m795a(e, (OutputStream) closeable);
                CommonUtils.m9856a(flushable, "Failed to flush to non-fatal file.");
                CommonUtils.m9855a(closeable, "Failed to close non-fatal file output stream.");
                m740a(j, 64);
                return;
            } catch (Throwable th4) {
                e = th4;
                closeable = null;
                CommonUtils.m9856a(flushable, "Failed to flush to non-fatal file.");
                CommonUtils.m9855a(closeable, "Failed to close non-fatal file output stream.");
                throw e;
            }
            try {
                m740a(j, 64);
                return;
            } catch (Throwable e4) {
                C3218c.m9728h().m9695e("CrashlyticsCore", "An error occurred when trimming non-fatal files.", e4);
                return;
            }
        }
        C3218c.m9728h().m9695e("CrashlyticsCore", "Tried to write a non-fatal exception while no session was open.", null);
    }

    private void m738a(File file, String str, int i) {
        boolean z;
        Closeable c0409d;
        Flushable a;
        Throwable e;
        Closeable closeable;
        C0409d c0409d2 = null;
        C3218c.m9728h().m9687a("CrashlyticsCore", "Collecting session parts for ID " + str);
        File[] a2 = m746a(new C0444b(str + "SessionCrash"));
        boolean z2 = a2 != null && a2.length > 0;
        C3218c.m9728h().m9687a("CrashlyticsCore", String.format(Locale.US, "Session %s has fatal exception: %s", new Object[]{str, Boolean.valueOf(z2)}));
        File[] a3 = m746a(new C0444b(str + "SessionEvent"));
        if (a3 == null || a3.length <= 0) {
            z = false;
        } else {
            z = true;
        }
        C3218c.m9728h().m9687a("CrashlyticsCore", String.format(Locale.US, "Session %s has non-fatal exceptions: %s", new Object[]{str, Boolean.valueOf(z)}));
        if (z2 || z) {
            try {
                c0409d = new C0409d(this.f617j, str);
                try {
                    a = CodedOutputStream.m566a((OutputStream) c0409d);
                } catch (Exception e2) {
                    e = e2;
                    a = null;
                    closeable = c0409d;
                    try {
                        C3218c.m9728h().m9695e("CrashlyticsCore", "Failed to write session file for session ID: " + str, e);
                        C0451n.m795a(e, (OutputStream) c0409d2);
                        CommonUtils.m9856a(a, "Error flushing session file stream");
                        m734a(c0409d2);
                        C3218c.m9728h().m9687a("CrashlyticsCore", "Removing session part files for ID " + str);
                        m739a(str);
                    } catch (Throwable th) {
                        e = th;
                        Object obj = c0409d2;
                        CommonUtils.m9856a(a, "Error flushing session file stream");
                        CommonUtils.m9855a(c0409d, "Failed to close CLS file");
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    a = null;
                    CommonUtils.m9856a(a, "Error flushing session file stream");
                    CommonUtils.m9855a(c0409d, "Failed to close CLS file");
                    throw e;
                }
                try {
                    C3218c.m9728h().m9687a("CrashlyticsCore", "Collecting SessionStart data for session ID " + str);
                    m729a((CodedOutputStream) a, file);
                    a.m593a(4, new Date().getTime() / 1000);
                    a.m596a(5, z2);
                    m730a((CodedOutputStream) a, str);
                    if (z) {
                        File[] a4;
                        if (a3.length > i) {
                            C3218c.m9728h().m9687a("CrashlyticsCore", String.format(Locale.US, "Trimming down to %d logged exceptions.", new Object[]{Integer.valueOf(i)}));
                            m740a(str, i);
                            a4 = m746a(new C0444b(str + "SessionEvent"));
                        } else {
                            a4 = a3;
                        }
                        m732a((CodedOutputStream) a, a4, str);
                    }
                    if (z2) {
                        m729a((CodedOutputStream) a, a2[0]);
                    }
                    a.m592a(11, 1);
                    a.m605b(12, 3);
                    CommonUtils.m9856a(a, "Error flushing session file stream");
                    CommonUtils.m9855a(c0409d, "Failed to close CLS file");
                } catch (Exception e3) {
                    e = e3;
                    closeable = c0409d;
                    C3218c.m9728h().m9695e("CrashlyticsCore", "Failed to write session file for session ID: " + str, e);
                    C0451n.m795a(e, (OutputStream) c0409d2);
                    CommonUtils.m9856a(a, "Error flushing session file stream");
                    m734a(c0409d2);
                    C3218c.m9728h().m9687a("CrashlyticsCore", "Removing session part files for ID " + str);
                    m739a(str);
                } catch (Throwable th3) {
                    e = th3;
                    CommonUtils.m9856a(a, "Error flushing session file stream");
                    CommonUtils.m9855a(c0409d, "Failed to close CLS file");
                    throw e;
                }
            } catch (Exception e4) {
                e = e4;
                a = null;
                C3218c.m9728h().m9695e("CrashlyticsCore", "Failed to write session file for session ID: " + str, e);
                C0451n.m795a(e, (OutputStream) c0409d2);
                CommonUtils.m9856a(a, "Error flushing session file stream");
                m734a(c0409d2);
                C3218c.m9728h().m9687a("CrashlyticsCore", "Removing session part files for ID " + str);
                m739a(str);
            } catch (Throwable th4) {
                e = th4;
                a = null;
                c0409d = null;
                CommonUtils.m9856a(a, "Error flushing session file stream");
                CommonUtils.m9855a(c0409d, "Failed to close CLS file");
                throw e;
            }
        }
        C3218c.m9728h().m9687a("CrashlyticsCore", "No events present for session ID " + str);
        C3218c.m9728h().m9687a("CrashlyticsCore", "Removing session part files for ID " + str);
        m739a(str);
    }

    private void m732a(CodedOutputStream codedOutputStream, File[] fileArr, String str) {
        Arrays.sort(fileArr, CommonUtils.f7031a);
        for (File name : fileArr) {
            try {
                C3218c.m9728h().m9687a("CrashlyticsCore", String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", new Object[]{str, name.getName()}));
                m729a(codedOutputStream, name);
            } catch (Throwable e) {
                C3218c.m9728h().m9695e("CrashlyticsCore", "Error writting non-fatal to session.", e);
            }
        }
    }

    private void m730a(CodedOutputStream codedOutputStream, String str) throws IOException {
        for (String str2 : new String[]{"SessionUser", "SessionApp", "SessionOS", "SessionDevice"}) {
            File[] a = m746a(new C0444b(str + str2));
            if (a.length == 0) {
                C3218c.m9728h().m9695e("CrashlyticsCore", "Can't find " + str2 + " data for session ID " + str, null);
            } else {
                C3218c.m9728h().m9687a("CrashlyticsCore", "Collecting " + str2 + " data for session ID " + str);
                m729a(codedOutputStream, a[0]);
            }
        }
    }

    private void m729a(CodedOutputStream codedOutputStream, File file) throws IOException {
        Closeable fileInputStream;
        Throwable th;
        if (file.exists()) {
            byte[] bArr = new byte[((int) file.length())];
            try {
                fileInputStream = new FileInputStream(file);
                int i = 0;
                while (i < bArr.length) {
                    try {
                        int read = fileInputStream.read(bArr, i, bArr.length - i);
                        if (read < 0) {
                            break;
                        }
                        i += read;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                CommonUtils.m9855a(fileInputStream, "Failed to close file input stream.");
                codedOutputStream.m602a(bArr);
                return;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                CommonUtils.m9855a(fileInputStream, "Failed to close file input stream.");
                throw th;
            }
        }
        C3218c.m9728h().m9695e("CrashlyticsCore", "Tried to include a file that doesn't exist: " + file.getName(), null);
    }

    private void m770o() {
        for (File c04407 : m768m()) {
            this.f621n.m708a(new C04407(this, c04407));
        }
    }
}
