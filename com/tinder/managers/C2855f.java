package com.tinder.managers;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import com.android.volley.C0307i.C0305a;
import com.android.volley.C0307i.C0306b;
import com.android.volley.VolleyError;
import com.facebook.stetho.BuildConfig;
import com.tinder.enums.ReportCause;
import com.tinder.fragments.FragmentMessages;
import com.tinder.managers.C2855f.11.C28391;
import com.tinder.managers.C2855f.C2852a;
import com.tinder.managers.C2855f.C2854d;
import com.tinder.managers.f.AnonymousClass11;
import com.tinder.model.Match;
import com.tinder.model.Message;
import com.tinder.model.User;
import com.tinder.p029a.C2237d;
import com.tinder.p029a.C2239e;
import com.tinder.p030d.C2427c;
import com.tinder.p030d.C2433n;
import com.tinder.p030d.C2438x;
import com.tinder.p030d.ae;
import com.tinder.p031b.C2392e;
import com.tinder.parse.C2974c;
import com.tinder.utils.C3095y;
import com.tinder.utils.ak;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpStatus;
import org.json.JSONException;
import org.json.JSONObject;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.tinder.managers.f */
public class C2855f implements Runnable {
    private static final Boolean f5856b;
    @Nullable
    private static Date f5857c;
    private static long f5858d;
    private static C2855f f5859e;
    public final ManagerNotifications f5860a;
    @NonNull
    private final C2392e f5861f;
    @NonNull
    private final HashSet<ae> f5862g;
    @NonNull
    private final ArrayList<Match> f5863h;
    @NonNull
    private final Map<String, Match> f5864i;
    @NonNull
    private final Map<String, Match> f5865j;
    @NonNull
    private final Set<String> f5866k;
    private boolean f5867l;
    private boolean f5868m;
    private String f5869n;
    private Handler f5870o;
    private Set<Runnable> f5871p;

    /* renamed from: com.tinder.managers.f.c */
    public interface C2837c {
        void m8219a();
    }

    /* renamed from: com.tinder.managers.f.1 */
    class C28401 extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ C2855f f5827a;
        private List<Match> f5828b;

        /* renamed from: com.tinder.managers.f.1.1 */
        class C28381 implements C2837c {
            final /* synthetic */ C28401 f5818a;

            C28381(C28401 c28401) {
                this.f5818a = c28401;
            }

            public void m8220a() {
                this.f5818a.f5827a.f5868m = false;
                this.f5818a.f5827a.m8292g();
                this.f5818a.f5827a.m8284b(false);
            }
        }

        C28401(C2855f c2855f) {
            this.f5827a = c2855f;
        }

        @Nullable
        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m8234a((Void[]) objArr);
        }

        public /* synthetic */ void onPostExecute(Object obj) {
            m8235a((Void) obj);
        }

        protected void onPreExecute() {
            this.f5827a.m8284b(true);
        }

        @Nullable
        protected Void m8234a(Void... voidArr) {
            this.f5828b = this.f5827a.f5861f.m6511b();
            Collections.sort(this.f5828b);
            return null;
        }

        public void m8235a(Void voidR) {
            this.f5827a.m8275a(this.f5828b, new C28381(this));
        }
    }

    /* renamed from: com.tinder.managers.f.2 */
    class C28412 implements Runnable {
        final /* synthetic */ boolean f5829a;
        final /* synthetic */ C2855f f5830b;

        C28412(C2855f c2855f, boolean z) {
            this.f5830b = c2855f;
            this.f5829a = z;
        }

        public void run() {
            Iterator it = this.f5830b.f5862g.iterator();
            while (it.hasNext()) {
                ((ae) it.next()).m6646b(this.f5829a);
            }
        }
    }

    /* renamed from: com.tinder.managers.f.3 */
    class C28423 implements Runnable {
        final /* synthetic */ C2855f f5831a;

        C28423(C2855f c2855f) {
            this.f5831a = c2855f;
        }

        public void run() {
            Iterator it = this.f5831a.f5862g.iterator();
            while (it.hasNext()) {
                ((ae) it.next()).m6645E();
            }
        }
    }

    /* renamed from: com.tinder.managers.f.4 */
    class C28434 implements C0306b<JSONObject> {
        final /* synthetic */ C2427c f5832a;
        final /* synthetic */ Match f5833b;
        final /* synthetic */ String f5834c;
        final /* synthetic */ ReportCause f5835d;
        final /* synthetic */ String f5836e;
        final /* synthetic */ C2855f f5837f;

        C28434(C2855f c2855f, C2427c c2427c, Match match, String str, ReportCause reportCause, String str2) {
            this.f5837f = c2855f;
            this.f5832a = c2427c;
            this.f5833b = match;
            this.f5834c = str;
            this.f5835d = reportCause;
            this.f5836e = str2;
        }

        public void m8237a(JSONObject jSONObject) {
            C3095y.m9471a("response=" + jSONObject);
            this.f5832a.m6742a(this.f5833b, this.f5834c, this.f5835d);
            this.f5837f.m8262d(this.f5836e);
        }
    }

    /* renamed from: com.tinder.managers.f.5 */
    class C28445 implements C0305a {
        final /* synthetic */ String f5838a;
        final /* synthetic */ C2427c f5839b;
        final /* synthetic */ Match f5840c;
        final /* synthetic */ C2855f f5841d;

        C28445(C2855f c2855f, String str, C2427c c2427c, Match match) {
            this.f5841d = c2855f;
            this.f5838a = str;
            this.f5839b = c2427c;
            this.f5840c = match;
        }

        public void onErrorResponse(VolleyError volleyError) {
            C3095y.m9470a(volleyError, this.f5838a);
            this.f5839b.m6744b(this.f5840c);
        }
    }

    /* renamed from: com.tinder.managers.f.6 */
    class C28466 implements C0306b<JSONObject> {
        final /* synthetic */ C2433n f5843a;
        final /* synthetic */ C2855f f5844b;

        /* renamed from: com.tinder.managers.f.6.1 */
        class C28451 extends AsyncTask<Match, Void, Boolean> {
            final /* synthetic */ C28466 f5842a;

            C28451(C28466 c28466) {
                this.f5842a = c28466;
            }

            @Nullable
            protected /* synthetic */ Object doInBackground(Object[] objArr) {
                return m8238a((Match[]) objArr);
            }

            @Nullable
            protected Boolean m8238a(Match... matchArr) {
                return Boolean.valueOf(C2392e.m6507a(matchArr[0]));
            }
        }

        C28466(C2855f c2855f, C2433n c2433n) {
            this.f5844b = c2855f;
            this.f5843a = c2433n;
        }

        public void m8240a(@NonNull JSONObject jSONObject) {
            C3095y.m9471a("response=" + jSONObject);
            try {
                Match a = C2974c.m8915a(jSONObject.getJSONObject("results"), this.f5844b.m8295j());
                if (a == null) {
                    throw new JSONException("Unknown error parsing match");
                }
                this.f5844b.m8253a(a, true, false);
                new C28451(this).execute(new Match[]{a});
                this.f5843a.m6758a(a);
            } catch (Throwable e) {
                C3095y.m9474a("Failed to parse match", e);
                this.f5843a.m6757a();
            } finally {
                this.f5844b.f5867l = false;
            }
        }
    }

    /* renamed from: com.tinder.managers.f.7 */
    class C28487 implements C0305a {
        final /* synthetic */ C2855f f5846a;

        /* renamed from: com.tinder.managers.f.7.1 */
        class C28471 implements C2438x {
            final /* synthetic */ C28487 f5845a;

            C28471(C28487 c28487) {
                this.f5845a = c28487;
            }

            public void m8241a() {
                C3095y.m9469a();
            }

            public void m8242b() {
                C3095y.m9469a();
            }

            public void m8243c() {
                C3095y.m9469a();
            }
        }

        C28487(C2855f c2855f) {
            this.f5846a = c2855f;
        }

        public void onErrorResponse(@NonNull VolleyError volleyError) {
            C3095y.m9471a("error=" + volleyError);
            try {
                ManagerApp.m7911b().m8138a(volleyError.getMessage(), new C28471(this));
                C3095y.m9479c("error loading matches: " + volleyError + ", " + volleyError.getMessage());
            } finally {
                this.f5846a.f5867l = false;
            }
        }
    }

    /* renamed from: com.tinder.managers.f.8 */
    static /* synthetic */ class C28498 {
        static final /* synthetic */ int[] f5847a;

        static {
            f5847a = new int[ReportCause.values().length];
            try {
                f5847a[ReportCause.ABUSIVE_CONTENT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5847a[ReportCause.SPAM.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5847a[ReportCause.INAPPROPRIATE_PHOTOS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f5847a[ReportCause.OTHER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f5847a[ReportCause.OFFLINE_BEHAVIOR.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* renamed from: com.tinder.managers.f.9 */
    class C28509 implements Runnable {
        final /* synthetic */ C2855f f5848a;

        C28509(C2855f c2855f) {
            this.f5848a = c2855f;
        }

        public void run() {
            this.f5848a.m8290e();
        }
    }

    /* renamed from: com.tinder.managers.f.a */
    class C2852a extends AsyncTask<Void, Void, Boolean> {
        final /* synthetic */ C2855f f5850a;
        private final List<Match> f5851b;
        @Nullable
        private final Date f5852c;

        /* renamed from: com.tinder.managers.f.a.1 */
        class C28511 implements C2837c {
            final /* synthetic */ C2852a f5849a;

            C28511(C2852a c2852a) {
                this.f5849a = c2852a;
            }

            public void m8244a() {
                this.f5849a.f5850a.f5867l = false;
                if (this.f5849a.f5850a.m8295j()) {
                    ManagerApp.m7926q().m8486k();
                    this.f5849a.f5850a.m8288c(false);
                    this.f5849a.f5850a.m8284b(false);
                }
                this.f5849a.f5850a.m8292g();
            }
        }

        @NonNull
        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m8245a((Void[]) objArr);
        }

        public /* synthetic */ void onPostExecute(Object obj) {
            m8246a((Boolean) obj);
        }

        public C2852a(C2855f c2855f, List<Match> list, @Nullable Date date) {
            this.f5850a = c2855f;
            this.f5851b = list;
            this.f5852c = date;
        }

        @NonNull
        protected Boolean m8245a(Void... voidArr) {
            C3095y.m9469a();
            boolean a = new C2392e().m6510a(this.f5851b);
            Collections.sort(this.f5851b);
            if (!a || this.f5852c == null) {
                C3095y.m9485e("INSERTION FAILED");
                return Boolean.FALSE;
            }
            C3095y.m9485e("INSERTION SUCCESSFUL, last activity date: " + this.f5852c);
            ManagerApp.m7914e().m8832b(this.f5852c.getTime());
            return Boolean.TRUE;
        }

        public void m8246a(Boolean bool) {
            if (bool.booleanValue()) {
                this.f5850a.m8275a(this.f5851b, new C28511(this));
            }
        }
    }

    /* renamed from: com.tinder.managers.f.b */
    static class C2853b extends Thread {
        private final Match f5853a;

        public C2853b(Match match) {
            this.f5853a = match;
        }

        public void run() {
            C2392e c2392e = new C2392e();
            C2392e.m6507a(this.f5853a);
        }
    }

    /* renamed from: com.tinder.managers.f.d */
    public static final class C2854d {
        @NonNull
        public List<Match> f5854a;
        @NonNull
        public List<String> f5855b;

        public C2854d() {
            this.f5854a = new ArrayList();
            this.f5855b = new ArrayList();
        }
    }

    static {
        f5856b = Boolean.FALSE;
        f5858d = (long) ManagerApp.m7923n().m8895a();
    }

    private C2855f() {
        this.f5869n = BuildConfig.FLAVOR;
        this.f5861f = new C2392e();
        this.f5863h = new ArrayList();
        this.f5864i = new ArrayMap();
        this.f5865j = new ArrayMap();
        this.f5866k = new HashSet();
        this.f5862g = new HashSet();
        this.f5860a = ManagerApp.m7928s();
        this.f5870o = new Handler();
        C3095y.m9471a("first load is: " + m8295j());
        C3095y.m9471a("Update interval is set to " + f5858d + " microseconds");
        m8264m();
    }

    public static C2855f m8248a() {
        if (f5859e == null) {
            f5859e = new C2855f();
        }
        return f5859e;
    }

    public boolean m8277a(Runnable runnable) {
        if (this.f5871p == null) {
            this.f5871p = new HashSet(1);
        }
        C3095y.m9483d("Adding post run action to run.");
        return this.f5871p.add(runnable);
    }

    public static void m8255a(@NonNull Date date) {
        f5857c = date;
        ManagerApp.m7914e().m8832b(date.getTime());
    }

    private void m8264m() {
        this.f5868m = true;
        new C28401(this).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }

    public boolean m8285b() {
        return !this.f5863h.isEmpty();
    }

    @NonNull
    public List<Match> m8287c() {
        return Collections.unmodifiableList((List) this.f5863h.clone());
    }

    public int m8289d() {
        return this.f5863h.size();
    }

    public Match m8266a(String str) {
        return (Match) this.f5864i.get(str);
    }

    public Match m8279b(String str) {
        return (Match) this.f5865j.get(str);
    }

    public void m8268a(ae aeVar) {
        this.f5862g.add(aeVar);
    }

    public void m8280b(ae aeVar) {
        this.f5862g.remove(aeVar);
    }

    public synchronized boolean m8290e() {
        return m8278a(false);
    }

    public synchronized boolean m8278a(boolean z) {
        boolean z2 = true;
        synchronized (this) {
            if (f5856b.booleanValue()) {
                C3095y.m9469a();
            }
            if (this.f5870o == null) {
                this.f5870o = new Handler();
            }
            if (this.f5867l) {
                if (f5856b.booleanValue()) {
                    C3095y.m9471a("Running, posting? " + z);
                }
                if (z) {
                    this.f5870o.postAtFrontOfQueue(this);
                } else {
                    if (f5856b.booleanValue()) {
                        C3095y.m9471a("Restarting polling since we were still running when we came back to run again.");
                    }
                    this.f5870o.postDelayed(new C28509(this), f5858d);
                    z2 = false;
                }
            } else {
                this.f5870o.removeCallbacks(this);
                if (z) {
                    if (f5856b.booleanValue()) {
                        C3095y.m9471a("Not running, posting immedately.");
                    }
                    this.f5870o.postAtFrontOfQueue(this);
                } else {
                    if (f5856b.booleanValue()) {
                        C3095y.m9471a("Not running, posting delayed.");
                    }
                    this.f5870o.postDelayed(this, f5858d);
                }
            }
        }
        return z2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r7 = this;
        r1 = 0;
        r2 = 1;
        r0 = f5856b;
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x000d;
    L_0x000a:
        com.tinder.utils.C3095y.m9469a();
    L_0x000d:
        r0 = com.tinder.managers.ManagerApp.m7922m();	 Catch:{ OutOfMemoryError -> 0x007d, Exception -> 0x008a, all -> 0x0094 }
        r0 = r0.m8599d();	 Catch:{ OutOfMemoryError -> 0x007d, Exception -> 0x008a, all -> 0x0094 }
        if (r0 == 0) goto L_0x001d;
    L_0x0017:
        r0 = r0.getId();	 Catch:{ OutOfMemoryError -> 0x007d, Exception -> 0x008a, all -> 0x0094 }
        r7.f5869n = r0;	 Catch:{ OutOfMemoryError -> 0x007d, Exception -> 0x008a, all -> 0x0094 }
    L_0x001d:
        r0 = com.tinder.managers.ManagerApp.m7911b();	 Catch:{ OutOfMemoryError -> 0x007d, Exception -> 0x008a, all -> 0x0094 }
        r0 = r0.m8144e();	 Catch:{ OutOfMemoryError -> 0x007d, Exception -> 0x008a, all -> 0x0094 }
        if (r0 == 0) goto L_0x0063;
    L_0x0027:
        r0 = r7.f5867l;	 Catch:{ OutOfMemoryError -> 0x007d, Exception -> 0x008a, all -> 0x0094 }
        if (r0 != 0) goto L_0x0063;
    L_0x002b:
        r0 = r7.f5868m;	 Catch:{ OutOfMemoryError -> 0x007d, Exception -> 0x008a, all -> 0x0094 }
        if (r0 != 0) goto L_0x0063;
    L_0x002f:
        r0 = com.tinder.managers.ManagerApp.m7935z();	 Catch:{ OutOfMemoryError -> 0x007d, Exception -> 0x008a, all -> 0x0094 }
        if (r0 == 0) goto L_0x0063;
    L_0x0035:
        r0 = 1;
        r7.f5867l = r0;	 Catch:{ OutOfMemoryError -> 0x007d, Exception -> 0x008a, all -> 0x0094 }
        r0 = r7.m8295j();	 Catch:{ OutOfMemoryError -> 0x007d, Exception -> 0x008a, all -> 0x0094 }
        if (r0 == 0) goto L_0x0046;
    L_0x003e:
        r0 = 1;
        r7.m8288c(r0);	 Catch:{ OutOfMemoryError -> 0x007d, Exception -> 0x008a, all -> 0x0094 }
        r0 = 1;
        r7.m8284b(r0);	 Catch:{ OutOfMemoryError -> 0x007d, Exception -> 0x008a, all -> 0x0094 }
    L_0x0046:
        r0 = r7.m8265n();	 Catch:{ OutOfMemoryError -> 0x007d, Exception -> 0x008a, all -> 0x0094 }
        r3 = new com.android.volley.c;	 Catch:{ OutOfMemoryError -> 0x007d, Exception -> 0x008a, all -> 0x0094 }
        r4 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
        r5 = 0;
        r6 = 0;
        r3.<init>(r4, r5, r6);	 Catch:{ OutOfMemoryError -> 0x007d, Exception -> 0x008a, all -> 0x0094 }
        r0.m219a(r3);	 Catch:{ OutOfMemoryError -> 0x007d, Exception -> 0x008a, all -> 0x0094 }
        r3 = com.tinder.managers.ManagerApp.m7915f();	 Catch:{ OutOfMemoryError -> 0x007d, Exception -> 0x008a, all -> 0x0094 }
        r3.m5900a(r0);	 Catch:{ OutOfMemoryError -> 0x007d, Exception -> 0x008a, all -> 0x0094 }
    L_0x005d:
        if (r1 == 0) goto L_0x0062;
    L_0x005f:
        r7.m8290e();
    L_0x0062:
        return;
    L_0x0063:
        r0 = new java.lang.StringBuilder;	 Catch:{ OutOfMemoryError -> 0x007d, Exception -> 0x008a }
        r0.<init>();	 Catch:{ OutOfMemoryError -> 0x007d, Exception -> 0x008a }
        r1 = "Not logged in, already running, loadingMatchesFromDB, or app backgrounded -- running=";
        r0 = r0.append(r1);	 Catch:{ OutOfMemoryError -> 0x007d, Exception -> 0x008a }
        r1 = r7.f5867l;	 Catch:{ OutOfMemoryError -> 0x007d, Exception -> 0x008a }
        r0 = r0.append(r1);	 Catch:{ OutOfMemoryError -> 0x007d, Exception -> 0x008a }
        r0 = r0.toString();	 Catch:{ OutOfMemoryError -> 0x007d, Exception -> 0x008a }
        com.tinder.utils.C3095y.m9471a(r0);	 Catch:{ OutOfMemoryError -> 0x007d, Exception -> 0x008a }
        r1 = r2;
        goto L_0x005d;
    L_0x007d:
        r0 = move-exception;
        java.lang.System.gc();	 Catch:{ all -> 0x009b }
        r1 = "Failed to run matches task due to limited memory. Dumped caches, trying again.";
        com.tinder.utils.C3095y.m9474a(r1, r0);	 Catch:{ all -> 0x009b }
        r7.m8290e();
        goto L_0x0062;
    L_0x008a:
        r0 = move-exception;
        r1 = "Failed to run matches task to do random exception being thrown. Trying again.";
        com.tinder.utils.C3095y.m9474a(r1, r0);	 Catch:{ all -> 0x009b }
        r7.m8290e();
        goto L_0x0062;
    L_0x0094:
        r0 = move-exception;
    L_0x0095:
        if (r1 == 0) goto L_0x009a;
    L_0x0097:
        r7.m8290e();
    L_0x009a:
        throw r0;
    L_0x009b:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0095;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tinder.managers.f.run():void");
    }

    @Nullable
    private synchronized ak m8265n() {
        String str;
        str = C2239e.f3702s;
        ManagerApp.m7911b();
        return new ak(1, str, C2821b.m8123b(), new C0306b<C2854d>() {
            final /* synthetic */ C2855f f5819a;

            {
                this.f5819a = r1;
            }

            public void m8221a(@Nullable C2854d c2854d) {
                try {
                    Set set;
                    if (this.f5819a.f5871p != null) {
                        Set hashSet = new HashSet(this.f5819a.f5871p.size());
                        hashSet.addAll(this.f5819a.f5871p);
                        this.f5819a.f5871p = null;
                        set = hashSet;
                    } else {
                        set = null;
                    }
                    String str = BuildConfig.FLAVOR;
                    User d = ManagerApp.m7922m().m8599d();
                    if (d != null) {
                        str = d.getId();
                    }
                    if (c2854d != null && r0.equals(this.f5819a.f5869n) && ManagerApp.m7911b().m8144e()) {
                        for (String str2 : c2854d.f5855b) {
                            this.f5819a.m8262d(str2);
                        }
                        if (c2854d.f5854a.size() > 0) {
                            new C2852a(this.f5819a, c2854d.f5854a, C2855f.f5857c).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
                        } else if (c2854d.f5855b.size() <= 0) {
                            this.f5819a.f5867l = false;
                            if (this.f5819a.m8295j()) {
                                this.f5819a.m8288c(false);
                                this.f5819a.m8284b(false);
                            }
                        } else if (C2855f.f5857c != null) {
                            C2855f.m8255a(C2855f.f5857c);
                            this.f5819a.f5867l = false;
                            if (this.f5819a.m8295j()) {
                                this.f5819a.m8288c(false);
                                this.f5819a.m8284b(false);
                            }
                        }
                    } else {
                        this.f5819a.f5867l = false;
                        C3095y.m9471a("user id for updates was not the same or not logged in stopping run");
                    }
                    if (set != null) {
                        Iterator it = set.iterator();
                        while (it.hasNext()) {
                            Runnable runnable = (Runnable) it.next();
                            it.remove();
                            runnable.run();
                        }
                    }
                    this.f5819a.m8290e();
                } catch (Throwable th) {
                    this.f5819a.m8290e();
                }
            }
        }, new C0305a() {
            final /* synthetic */ C2855f f5821a;

            /* renamed from: com.tinder.managers.f.11.1 */
            class C28391 implements C2438x {
                final /* synthetic */ AnonymousClass11 f5820a;

                C28391(AnonymousClass11 anonymousClass11) {
                    this.f5820a = anonymousClass11;
                }

                public void m8223a() {
                    C3095y.m9469a();
                    this.f5820a.f5821a.f5867l = false;
                }

                public void m8224b() {
                    C3095y.m9469a();
                    this.f5820a.f5821a.f5867l = false;
                }

                public void m8225c() {
                    C3095y.m9469a();
                    this.f5820a.f5821a.f5867l = false;
                }
            }

            {
                this.f5821a = r1;
            }

            public void onErrorResponse(@Nullable VolleyError volleyError) {
                BufferedReader bufferedReader;
                Throwable th;
                try {
                    C3095y.m9474a("Volley request to /updates failed! ", (Throwable) volleyError);
                    this.f5821a.f5867l = false;
                    if (volleyError == null || volleyError.f189a == null) {
                        m8226a(HttpStatus.SC_INTERNAL_SERVER_ERROR);
                        return;
                    }
                    int i = volleyError.f189a.f243a;
                    switch (i) {
                        case HttpStatus.SC_BAD_REQUEST /*400*/:
                            m8226a(i);
                            break;
                        case HttpStatus.SC_UNAUTHORIZED /*401*/:
                            C3095y.m9471a("reason=" + volleyError.getMessage());
                            m8226a(i);
                            break;
                        case HttpStatus.SC_NOT_FOUND /*404*/:
                            C3095y.m9471a("reason=" + volleyError.getMessage());
                            m8226a(i);
                            break;
                        case HttpStatus.SC_INTERNAL_SERVER_ERROR /*500*/:
                            C3095y.m9471a("reason=" + volleyError.getMessage());
                            try {
                                bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(volleyError.f189a.f244b)));
                                try {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    while (true) {
                                        String readLine = bufferedReader.readLine();
                                        if (readLine == null) {
                                            C3095y.m9471a("total response =" + stringBuilder);
                                            if (bufferedReader != null) {
                                                bufferedReader.close();
                                            }
                                            m8226a(i);
                                            break;
                                        }
                                        stringBuilder.append(readLine);
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                bufferedReader = null;
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                throw th;
                            }
                        default:
                            C3095y.m9479c("Failed to run /updates call, unexpected response code: " + i);
                            m8226a(i);
                            break;
                    }
                    this.f5821a.m8290e();
                } catch (Throwable th4) {
                    C3095y.m9474a("Failed to parse /update response", th4);
                } finally {
                    this.f5821a.m8290e();
                }
            }

            private void m8226a(int i) {
                C3095y.m9471a("statusCode=" + i);
                if (i == HttpStatus.SC_UNAUTHORIZED) {
                    ManagerApp.m7911b().m8138a(String.valueOf(i), new C28391(this));
                }
            }
        });
    }

    public void m8273a(String str, String str2) {
        Match match = (Match) this.f5864i.get(str);
        if (match != null) {
            match.setDraftMsg(str2);
            new AsyncTask<String, Void, Void>() {
                final /* synthetic */ C2855f f5822a;

                {
                    this.f5822a = r1;
                }

                @Nullable
                protected /* synthetic */ Object doInBackground(Object[] objArr) {
                    return m8227a((String[]) objArr);
                }

                @Nullable
                protected Void m8227a(String... strArr) {
                    C2392e.m6504a(strArr[0], strArr[1]);
                    return null;
                }
            }.execute(new String[]{str, str2});
        }
    }

    private void m8262d(@Nullable String str) {
        if (str != null) {
            C3095y.m9471a("matchId=" + str);
            ManagerApp.m7928s().m8049d(str);
            Match match = (Match) this.f5864i.remove(str);
            if (match != null) {
                this.f5865j.remove(match.getPerson().getId());
                ManagerApp.m7926q().m8482g(match.getPerson().getId());
                ManagerApp.m7926q().m8473c(match.getPerson().getId());
            }
            this.f5866k.remove(str);
            for (int i = 0; i < this.f5863h.size(); i++) {
                if (((Match) this.f5863h.get(i)).getId().equals(str)) {
                    this.f5863h.remove(i);
                    this.f5863h.trimToSize();
                    break;
                }
            }
            new AsyncTask<String, Void, Void>() {
                final /* synthetic */ C2855f f5823a;

                {
                    this.f5823a = r1;
                }

                @Nullable
                protected /* synthetic */ Object doInBackground(Object[] objArr) {
                    return m8228a((String[]) objArr);
                }

                protected /* synthetic */ void onPostExecute(Object obj) {
                    m8229a((Void) obj);
                }

                @Nullable
                protected Void m8228a(String... strArr) {
                    C2392e.m6503a(strArr[0]);
                    return null;
                }

                protected void m8229a(Void voidR) {
                    this.f5823a.m8292g();
                }
            }.execute(new String[]{str});
        }
    }

    public void m8283b(@NonNull Date date) {
        if (f5857c == null) {
            C2855f.m8255a(date);
        } else if (f5857c.compareTo(date) < 0) {
            C3095y.m9471a(date + " is before the saved activity date (" + f5857c + "), resetting saved date");
            C2855f.m8255a(date);
        }
    }

    @NonNull
    public Set<String> m8291f() {
        return Collections.unmodifiableSet(this.f5866k);
    }

    public void m8270a(@NonNull Match match) {
        if (match != null && !match.isTouched()) {
            match.setTouched(true);
            this.f5866k.remove(match.getId());
            Match match2 = (Match) this.f5864i.get(match.getId());
            if (match2 != null) {
                match2.setTouched(true);
            }
            new AsyncTask<String, Void, Void>() {
                final /* synthetic */ C2855f f5824a;

                {
                    this.f5824a = r1;
                }

                @Nullable
                protected /* synthetic */ Object doInBackground(Object[] objArr) {
                    return m8230a((String[]) objArr);
                }

                protected /* synthetic */ void onPostExecute(Object obj) {
                    m8231a((Void) obj);
                }

                @Nullable
                protected Void m8230a(String... strArr) {
                    C2392e.m6505a(strArr[0], true);
                    return null;
                }

                protected void m8231a(Void voidR) {
                    this.f5824a.m8292g();
                }
            }.execute(new String[]{match.getId()});
        }
    }

    public void m8271a(@NonNull Message message) {
        String matchId = message.getMatchId();
        if (this.f5864i.containsKey(matchId)) {
            ((Match) this.f5864i.get(matchId)).addMessage(message);
        }
    }

    private void m8260c(@NonNull Match match) {
        for (int i = 0; i < this.f5863h.size(); i++) {
            if (((Match) this.f5863h.get(i)).getId().equals(match.getId())) {
                this.f5863h.remove(i);
                this.f5863h.trimToSize();
            }
        }
        this.f5863h.add(0, match);
    }

    private void m8253a(@NonNull Match match, boolean z, boolean z2) {
        String id = match.getId();
        if (id.equals(FragmentMessages.m7097b())) {
            match.setTouched(true);
        } else if (!(match.wasTouched() || match.isLastMsgFromMe())) {
            Match match2 = (Match) this.f5864i.get(id);
            if (match2 == null || match2.getLatestTimestamp() == null || !match2.getLatestTimestamp().equals(match.getLatestTimestamp())) {
                this.f5866k.add(match.getId());
            }
        }
        if (this.f5864i.containsKey(id)) {
            m8281b(match);
        } else if (match.getPerson() == null || match.getPerson().getId() == null) {
            C3095y.m9476b("New match, but no person, so not doing anything with it");
        } else {
            if (z) {
                C3095y.m9471a("following " + match.getName());
                ManagerApp.m7926q().m8465a(match.getPerson().getId(), z2);
            } else {
                C3095y.m9471a("Not following " + match.getName());
            }
            this.f5864i.put(id, match);
            this.f5865j.put(match.getPerson().getId(), match);
            m8260c(match);
        }
    }

    public void m8281b(@NonNull Match match) {
        Match match2 = (Match) this.f5864i.get(match.getId());
        if (!match2.getLastActivityDate().equals(match.getLastActivityDate())) {
            match.addPreviousMessages(match2.getMessages());
            match.setPerson(match2.getPerson());
            this.f5864i.put(match.getId(), match);
            m8260c(match);
        }
    }

    public void m8274a(String str, boolean z) {
        Match match = (Match) this.f5864i.get(str);
        if (match != null) {
            match.setIsFollowed(z);
            new AsyncTask<Match, Void, Void>() {
                final /* synthetic */ C2855f f5825a;

                {
                    this.f5825a = r1;
                }

                @Nullable
                protected /* synthetic */ Object doInBackground(Object[] objArr) {
                    return m8232a((Match[]) objArr);
                }

                @Nullable
                protected Void m8232a(Match... matchArr) {
                    Match match = matchArr[0];
                    C2392e c2392e = new C2392e();
                    C2392e.m6507a(match);
                    return null;
                }
            }.execute(new Match[]{match});
        }
    }

    public void m8282b(String str, boolean z) {
        Match match = (Match) this.f5865j.get(str);
        if (match != null) {
            match.setIsFollowed(z);
            new AsyncTask<Match, Void, Void>() {
                final /* synthetic */ C2855f f5826a;

                {
                    this.f5826a = r1;
                }

                @Nullable
                protected /* synthetic */ Object doInBackground(Object[] objArr) {
                    return m8233a((Match[]) objArr);
                }

                @Nullable
                protected Void m8233a(Match... matchArr) {
                    Match match = matchArr[0];
                    C2392e c2392e = new C2392e();
                    C2392e.m6507a(match);
                    return null;
                }
            }.execute(new Match[]{match});
        }
    }

    public String m8286c(String str) {
        Match match = (Match) this.f5865j.get(str);
        if (match != null) {
            return match.getPerson().getName();
        }
        return BuildConfig.FLAVOR;
    }

    public void m8275a(@Nullable List<Match> list, @Nullable C2837c c2837c) {
        boolean z = true;
        if (list != null && list.size() != 0) {
            try {
                if (this.f5863h.size() > 0 && ((Match) this.f5863h.get(0)).compareTo((Match) list.get(0)) == -1) {
                    list.addAll(0, this.f5863h);
                    this.f5863h.clear();
                    this.f5864i.clear();
                    this.f5865j.clear();
                }
                if (list.size() != 1) {
                    z = false;
                }
                for (int size = list.size() - 1; size >= 0; size--) {
                    Match match = (Match) list.get(size);
                    m8253a(match, match.isFollowed(), z);
                }
                if (!z) {
                    ManagerApp.m7926q().m8485j();
                }
                if (c2837c != null) {
                    c2837c.m8219a();
                }
            } catch (Throwable th) {
                if (c2837c != null) {
                    c2837c.m8219a();
                }
            }
        } else if (c2837c != null) {
            c2837c.m8219a();
        }
    }

    public void m8284b(boolean z) {
        new Handler(Looper.getMainLooper()).post(new C28412(this, z));
    }

    public void m8292g() {
        new Handler(Looper.getMainLooper()).post(new C28423(this));
    }

    public void m8276a(boolean z, String str, @NonNull C2433n c2433n) {
        C3095y.m9471a("matchId = " + str);
        Match match = (Match) this.f5864i.get(str);
        if (match == null || !z) {
            m8254a(str, c2433n);
        } else {
            c2433n.m6758a(match);
        }
    }

    public boolean m8293h() {
        return this.f5868m;
    }

    public void m8272a(String str, ReportCause reportCause, String str2, @NonNull C2427c c2427c) {
        C3095y.m9471a("matchId=" + str);
        String str3 = C2239e.f3698o + str;
        Match a = m8266a(str);
        C28434 c28434 = new C28434(this, c2427c, a, str2, reportCause, str);
        C0305a c28445 = new C28445(this, str3, c2427c, a);
        ManagerApp.m7911b();
        ManagerApp.m7915f().m5900a(new C2237d(3, str3, null, c28434, c28445, C2821b.m8123b()));
    }

    private void m8254a(String str, @NonNull C2433n c2433n) {
        C3095y.m9471a("matchId=" + str);
        this.f5867l = true;
        String str2 = C2239e.f3698o + str;
        C0306b c28466 = new C28466(this, c2433n);
        C0305a c28487 = new C28487(this);
        ManagerApp.m7911b();
        ManagerApp.m7915f().m5900a(new C2237d(0, str2, null, c28466, c28487, C2821b.m8123b()));
    }

    @Nullable
    public Match m8267a(@NonNull JSONObject jSONObject) throws JSONException {
        C3095y.m9471a("jsonObjectMatch=" + jSONObject);
        return C2974c.m8915a(jSONObject, m8295j());
    }

    public Boolean m8294i() {
        return Boolean.valueOf(this.f5867l);
    }

    public boolean m8295j() {
        return ManagerApp.m7914e().af();
    }

    public void m8288c(boolean z) {
        ManagerApp.m7914e().m8881x(z);
    }

    private void m8250a(int i, @NonNull Match match) {
        match.addReportedMask(i);
        Match a = m8266a(match.getId());
        if (a != null) {
            a.addReportedMask(i);
        }
        new C2392e().m6513b(match);
    }

    public void m8269a(@NonNull ReportCause reportCause, @NonNull Match match) {
        int i = 0;
        switch (C28498.f5847a[reportCause.ordinal()]) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                i = 2;
                break;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                i = 1;
                break;
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                i = 5;
                break;
            case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                i = 7;
                break;
            case C3374b.SmoothProgressBar_spb_speed /*5*/:
                i = 9;
                break;
        }
        m8250a(i, match);
    }

    public void m8296k() {
        this.f5870o.removeCallbacks(this);
        this.f5863h.clear();
        this.f5864i.clear();
        this.f5865j.clear();
        this.f5866k.clear();
        ManagerApp.m7914e().m8816T();
        m8288c(true);
    }
}
