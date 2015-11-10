package com.squareup.okhttp.internal;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.stetho.BuildConfig;
import com.squareup.okhttp.internal.p027b.C2108a;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import okio.C2071q;
import okio.C2076r;
import okio.C2201s;
import okio.C3332d;
import okio.C3334c;
import okio.C3342l;

/* renamed from: com.squareup.okhttp.internal.b */
public final class C2110b implements Closeable {
    static final Pattern f3184a;
    static final /* synthetic */ boolean f3185b;
    private static final C2071q f3186u;
    private final C2108a f3187c;
    private final File f3188d;
    private final File f3189e;
    private final File f3190f;
    private final File f3191g;
    private final int f3192h;
    private long f3193i;
    private final int f3194j;
    private long f3195k;
    private C3332d f3196l;
    private final LinkedHashMap<String, C2106b> f3197m;
    private int f3198n;
    private boolean f3199o;
    private boolean f3200p;
    private boolean f3201q;
    private long f3202r;
    private final Executor f3203s;
    private final Runnable f3204t;

    /* renamed from: com.squareup.okhttp.internal.b.1 */
    class C21001 implements Runnable {
        final /* synthetic */ C2110b f3160a;

        C21001(C2110b c2110b) {
            this.f3160a = c2110b;
        }

        public void run() {
            int i = 0;
            synchronized (this.f3160a) {
                if (!this.f3160a.f3200p) {
                    i = 1;
                }
                if ((i | this.f3160a.f3201q) != 0) {
                    return;
                }
                try {
                    this.f3160a.m5088k();
                    if (this.f3160a.m5086i()) {
                        this.f3160a.m5085h();
                        this.f3160a.f3198n = 0;
                    }
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /* renamed from: com.squareup.okhttp.internal.b.2 */
    class C21022 extends C2101c {
        static final /* synthetic */ boolean f3162a;
        final /* synthetic */ C2110b f3163b;

        static {
            f3162a = !C2110b.class.desiredAssertionStatus();
        }

        C21022(C2110b c2110b, C2071q c2071q) {
            this.f3163b = c2110b;
            super(c2071q);
        }

        protected void m5020a(IOException iOException) {
            if (f3162a || Thread.holdsLock(this.f3163b)) {
                this.f3163b.f3199o = true;
                return;
            }
            throw new AssertionError();
        }
    }

    /* renamed from: com.squareup.okhttp.internal.b.3 */
    static class C21033 implements C2071q {
        C21033() {
        }

        public void a_(C3334c c3334c, long j) throws IOException {
            c3334c.m10231g(j);
        }

        public void flush() throws IOException {
        }

        public C2201s m5021a() {
            return C2201s.f3530b;
        }

        public void close() throws IOException {
        }
    }

    /* renamed from: com.squareup.okhttp.internal.b.a */
    public final class C2105a {
        final /* synthetic */ C2110b f3165a;
        private final C2106b f3166b;
        private final boolean[] f3167c;
        private boolean f3168d;
        private boolean f3169e;

        /* renamed from: com.squareup.okhttp.internal.b.a.1 */
        class C21041 extends C2101c {
            final /* synthetic */ C2105a f3164a;

            C21041(C2105a c2105a, C2071q c2071q) {
                this.f3164a = c2105a;
                super(c2071q);
            }

            protected void m5022a(IOException iOException) {
                synchronized (this.f3164a.f3165a) {
                    this.f3164a.f3168d = true;
                }
            }
        }

        private C2105a(C2110b c2110b, C2106b c2106b) {
            this.f3165a = c2110b;
            this.f3166b = c2106b;
            this.f3167c = c2106b.f3175f ? null : new boolean[c2110b.f3194j];
        }

        public C2071q m5026a(int i) throws IOException {
            C2071q c21041;
            synchronized (this.f3165a) {
                if (this.f3166b.f3176g != this) {
                    throw new IllegalStateException();
                }
                if (!this.f3166b.f3175f) {
                    this.f3167c[i] = true;
                }
                try {
                    c21041 = new C21041(this, this.f3165a.f3187c.m5048b(this.f3166b.f3174e[i]));
                } catch (FileNotFoundException e) {
                    c21041 = C2110b.f3186u;
                }
            }
            return c21041;
        }

        public void m5027a() throws IOException {
            synchronized (this.f3165a) {
                if (this.f3168d) {
                    this.f3165a.m5066a(this, false);
                    this.f3165a.m5068a(this.f3166b);
                } else {
                    this.f3165a.m5066a(this, true);
                }
                this.f3169e = true;
            }
        }

        public void m5028b() throws IOException {
            synchronized (this.f3165a) {
                this.f3165a.m5066a(this, false);
            }
        }
    }

    /* renamed from: com.squareup.okhttp.internal.b.b */
    private final class C2106b {
        final /* synthetic */ C2110b f3170a;
        private final String f3171b;
        private final long[] f3172c;
        private final File[] f3173d;
        private final File[] f3174e;
        private boolean f3175f;
        private C2105a f3176g;
        private long f3177h;

        private C2106b(C2110b c2110b, String str) {
            this.f3170a = c2110b;
            this.f3171b = str;
            this.f3172c = new long[c2110b.f3194j];
            this.f3173d = new File[c2110b.f3194j];
            this.f3174e = new File[c2110b.f3194j];
            StringBuilder append = new StringBuilder(str).append('.');
            int length = append.length();
            for (int i = 0; i < c2110b.f3194j; i++) {
                append.append(i);
                this.f3173d[i] = new File(c2110b.f3188d, append.toString());
                append.append(".tmp");
                this.f3174e[i] = new File(c2110b.f3188d, append.toString());
                append.setLength(length);
            }
        }

        private void m5033a(String[] strArr) throws IOException {
            if (strArr.length != this.f3170a.f3194j) {
                throw m5035b(strArr);
            }
            int i = 0;
            while (i < strArr.length) {
                try {
                    this.f3172c[i] = Long.parseLong(strArr[i]);
                    i++;
                } catch (NumberFormatException e) {
                    throw m5035b(strArr);
                }
            }
        }

        void m5043a(C3332d c3332d) throws IOException {
            for (long k : this.f3172c) {
                c3332d.m10175h(32).m10177k(k);
            }
        }

        private IOException m5035b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        C2107c m5042a() {
            int i = 0;
            if (Thread.holdsLock(this.f3170a)) {
                C2076r[] c2076rArr = new C2076r[this.f3170a.f3194j];
                long[] jArr = (long[]) this.f3172c.clone();
                int i2 = 0;
                while (i2 < this.f3170a.f3194j) {
                    try {
                        c2076rArr[i2] = this.f3170a.f3187c.m5046a(this.f3173d[i2]);
                        i2++;
                    } catch (FileNotFoundException e) {
                        while (i < this.f3170a.f3194j && c2076rArr[i] != null) {
                            C2157k.m5355a(c2076rArr[i]);
                            i++;
                        }
                        return null;
                    }
                }
                return new C2107c(this.f3171b, this.f3177h, c2076rArr, jArr, null);
            }
            throw new AssertionError();
        }
    }

    /* renamed from: com.squareup.okhttp.internal.b.c */
    public final class C2107c implements Closeable {
        final /* synthetic */ C2110b f3178a;
        private final String f3179b;
        private final long f3180c;
        private final C2076r[] f3181d;
        private final long[] f3182e;

        private C2107c(C2110b c2110b, String str, long j, C2076r[] c2076rArr, long[] jArr) {
            this.f3178a = c2110b;
            this.f3179b = str;
            this.f3180c = j;
            this.f3181d = c2076rArr;
            this.f3182e = jArr;
        }

        public C2105a m5044a() throws IOException {
            return this.f3178a.m5064a(this.f3179b, this.f3180c);
        }

        public C2076r m5045a(int i) {
            return this.f3181d[i];
        }

        public void close() {
            for (Closeable a : this.f3181d) {
                C2157k.m5355a(a);
            }
        }
    }

    static {
        f3185b = !C2110b.class.desiredAssertionStatus();
        f3184a = Pattern.compile("[a-z0-9_-]{1,120}");
        f3186u = new C21033();
    }

    C2110b(C2108a c2108a, File file, int i, int i2, long j, Executor executor) {
        this.f3195k = 0;
        this.f3197m = new LinkedHashMap(0, 0.75f, true);
        this.f3202r = 0;
        this.f3204t = new C21001(this);
        this.f3187c = c2108a;
        this.f3188d = file;
        this.f3192h = i;
        this.f3189e = new File(file, "journal");
        this.f3190f = new File(file, "journal.tmp");
        this.f3191g = new File(file, "journal.bkp");
        this.f3194j = i2;
        this.f3193i = j;
        this.f3203s = executor;
    }

    void m5090a() throws IOException {
        if (!f3185b && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (!this.f3200p) {
            if (this.f3187c.m5051e(this.f3191g)) {
                if (this.f3187c.m5051e(this.f3189e)) {
                    this.f3187c.m5050d(this.f3191g);
                } else {
                    this.f3187c.m5047a(this.f3191g, this.f3189e);
                }
            }
            if (this.f3187c.m5051e(this.f3189e)) {
                try {
                    m5077e();
                    m5083g();
                    this.f3200p = true;
                    return;
                } catch (IOException e) {
                    C2151i.m5320a().m5323a("DiskLruCache " + this.f3188d + " is corrupt: " + e.getMessage() + ", removing");
                    m5093c();
                    this.f3201q = false;
                }
            }
            m5085h();
            this.f3200p = true;
        }
    }

    public static C2110b m5065a(C2108a c2108a, File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        } else {
            return new C2110b(c2108a, file, i, i2, j, new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), C2157k.m5352a("OkHttp DiskLruCache", true)));
        }
    }

    private void m5077e() throws IOException {
        Closeable a = C3342l.m10280a(this.f3187c.m5046a(this.f3189e));
        int i;
        try {
            String s = a.m10194s();
            String s2 = a.m10194s();
            String s3 = a.m10194s();
            String s4 = a.m10194s();
            String s5 = a.m10194s();
            if ("libcore.io.DiskLruCache".equals(s) && AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(s2) && Integer.toString(this.f3192h).equals(s3) && Integer.toString(this.f3194j).equals(s4) && BuildConfig.FLAVOR.equals(s5)) {
                i = 0;
                while (true) {
                    m5075d(a.m10194s());
                    i++;
                }
            } else {
                throw new IOException("unexpected journal header: [" + s + ", " + s2 + ", " + s4 + ", " + s5 + "]");
            }
        } catch (EOFException e) {
            this.f3198n = i - this.f3197m.size();
            if (a.m10185g()) {
                this.f3196l = m5081f();
            } else {
                m5085h();
            }
            C2157k.m5355a(a);
        } catch (Throwable th) {
            C2157k.m5355a(a);
        }
    }

    private C3332d m5081f() throws FileNotFoundException {
        return C3342l.m10279a(new C21022(this, this.f3187c.m5049c(this.f3189e)));
    }

    private void m5075d(String str) throws IOException {
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        String str2;
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            String substring = str.substring(i);
            if (indexOf == "REMOVE".length() && str.startsWith("REMOVE")) {
                this.f3197m.remove(substring);
                return;
            }
            str2 = substring;
        } else {
            str2 = str.substring(i, indexOf2);
        }
        C2106b c2106b = (C2106b) this.f3197m.get(str2);
        if (c2106b == null) {
            c2106b = new C2106b(str2, null);
            this.f3197m.put(str2, c2106b);
        }
        if (indexOf2 != -1 && indexOf == "CLEAN".length() && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            c2106b.f3175f = true;
            c2106b.f3176g = null;
            c2106b.m5033a(split);
        } else if (indexOf2 == -1 && indexOf == "DIRTY".length() && str.startsWith("DIRTY")) {
            c2106b.f3176g = new C2105a(c2106b, null);
        } else if (indexOf2 != -1 || indexOf != "READ".length() || !str.startsWith("READ")) {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private void m5083g() throws IOException {
        this.f3187c.m5050d(this.f3190f);
        Iterator it = this.f3197m.values().iterator();
        while (it.hasNext()) {
            C2106b c2106b = (C2106b) it.next();
            int i;
            if (c2106b.f3176g == null) {
                for (i = 0; i < this.f3194j; i++) {
                    this.f3195k += c2106b.f3172c[i];
                }
            } else {
                c2106b.f3176g = null;
                for (i = 0; i < this.f3194j; i++) {
                    this.f3187c.m5050d(c2106b.f3173d[i]);
                    this.f3187c.m5050d(c2106b.f3174e[i]);
                }
                it.remove();
            }
        }
    }

    private synchronized void m5085h() throws IOException {
        if (this.f3196l != null) {
            this.f3196l.close();
        }
        C3332d a = C3342l.m10279a(this.f3187c.m5048b(this.f3190f));
        try {
            a.m10166b("libcore.io.DiskLruCache").m10175h(10);
            a.m10166b(AppEventsConstants.EVENT_PARAM_VALUE_YES).m10175h(10);
            a.m10177k((long) this.f3192h).m10175h(10);
            a.m10177k((long) this.f3194j).m10175h(10);
            a.m10175h(10);
            for (C2106b c2106b : this.f3197m.values()) {
                if (c2106b.f3176g != null) {
                    a.m10166b("DIRTY").m10175h(32);
                    a.m10166b(c2106b.f3171b);
                    a.m10175h(10);
                } else {
                    a.m10166b("CLEAN").m10175h(32);
                    a.m10166b(c2106b.f3171b);
                    c2106b.m5043a(a);
                    a.m10175h(10);
                }
            }
            a.close();
            if (this.f3187c.m5051e(this.f3189e)) {
                this.f3187c.m5047a(this.f3189e, this.f3191g);
            }
            this.f3187c.m5047a(this.f3190f, this.f3189e);
            this.f3187c.m5050d(this.f3191g);
            this.f3196l = m5081f();
            this.f3199o = false;
        } catch (Throwable th) {
            a.close();
        }
    }

    public synchronized C2107c m5089a(String str) throws IOException {
        C2107c c2107c;
        m5090a();
        m5087j();
        m5079e(str);
        C2106b c2106b = (C2106b) this.f3197m.get(str);
        if (c2106b == null || !c2106b.f3175f) {
            c2107c = null;
        } else {
            c2107c = c2106b.m5042a();
            if (c2107c == null) {
                c2107c = null;
            } else {
                this.f3198n++;
                this.f3196l.m10166b("READ").m10175h(32).m10166b(str).m10175h(10);
                if (m5086i()) {
                    this.f3203s.execute(this.f3204t);
                }
            }
        }
        return c2107c;
    }

    public C2105a m5091b(String str) throws IOException {
        return m5064a(str, -1);
    }

    private synchronized C2105a m5064a(String str, long j) throws IOException {
        C2105a c2105a;
        m5090a();
        m5087j();
        m5079e(str);
        C2106b c2106b = (C2106b) this.f3197m.get(str);
        if (j == -1 || (c2106b != null && c2106b.f3177h == j)) {
            if (c2106b != null) {
                if (c2106b.f3176g != null) {
                    c2105a = null;
                }
            }
            this.f3196l.m10166b("DIRTY").m10175h(32).m10166b(str).m10175h(10);
            this.f3196l.flush();
            if (this.f3199o) {
                c2105a = null;
            } else {
                C2106b c2106b2;
                if (c2106b == null) {
                    c2106b = new C2106b(str, null);
                    this.f3197m.put(str, c2106b);
                    c2106b2 = c2106b;
                } else {
                    c2106b2 = c2106b;
                }
                c2105a = new C2105a(c2106b2, null);
                c2106b2.f3176g = c2105a;
            }
        } else {
            c2105a = null;
        }
        return c2105a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m5066a(com.squareup.okhttp.internal.C2110b.C2105a r11, boolean r12) throws java.io.IOException {
        /*
        r10 = this;
        r0 = 0;
        monitor-enter(r10);
        r2 = r11.f3166b;	 Catch:{ all -> 0x0012 }
        r1 = r2.f3176g;	 Catch:{ all -> 0x0012 }
        if (r1 == r11) goto L_0x0015;
    L_0x000c:
        r0 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0012 }
        r0.<init>();	 Catch:{ all -> 0x0012 }
        throw r0;	 Catch:{ all -> 0x0012 }
    L_0x0012:
        r0 = move-exception;
        monitor-exit(r10);
        throw r0;
    L_0x0015:
        if (r12 == 0) goto L_0x005c;
    L_0x0017:
        r1 = r2.f3175f;	 Catch:{ all -> 0x0012 }
        if (r1 != 0) goto L_0x005c;
    L_0x001d:
        r1 = r0;
    L_0x001e:
        r3 = r10.f3194j;	 Catch:{ all -> 0x0012 }
        if (r1 >= r3) goto L_0x005c;
    L_0x0022:
        r3 = r11.f3167c;	 Catch:{ all -> 0x0012 }
        r3 = r3[r1];	 Catch:{ all -> 0x0012 }
        if (r3 != 0) goto L_0x0046;
    L_0x002a:
        r11.m5028b();	 Catch:{ all -> 0x0012 }
        r0 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0012 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0012 }
        r2.<init>();	 Catch:{ all -> 0x0012 }
        r3 = "Newly created entry didn't create value for index ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0012 }
        r1 = r2.append(r1);	 Catch:{ all -> 0x0012 }
        r1 = r1.toString();	 Catch:{ all -> 0x0012 }
        r0.<init>(r1);	 Catch:{ all -> 0x0012 }
        throw r0;	 Catch:{ all -> 0x0012 }
    L_0x0046:
        r3 = r10.f3187c;	 Catch:{ all -> 0x0012 }
        r4 = r2.f3174e;	 Catch:{ all -> 0x0012 }
        r4 = r4[r1];	 Catch:{ all -> 0x0012 }
        r3 = r3.m5051e(r4);	 Catch:{ all -> 0x0012 }
        if (r3 != 0) goto L_0x0059;
    L_0x0054:
        r11.m5028b();	 Catch:{ all -> 0x0012 }
    L_0x0057:
        monitor-exit(r10);
        return;
    L_0x0059:
        r1 = r1 + 1;
        goto L_0x001e;
    L_0x005c:
        r1 = r10.f3194j;	 Catch:{ all -> 0x0012 }
        if (r0 >= r1) goto L_0x009d;
    L_0x0060:
        r1 = r2.f3174e;	 Catch:{ all -> 0x0012 }
        r1 = r1[r0];	 Catch:{ all -> 0x0012 }
        if (r12 == 0) goto L_0x0097;
    L_0x0068:
        r3 = r10.f3187c;	 Catch:{ all -> 0x0012 }
        r3 = r3.m5051e(r1);	 Catch:{ all -> 0x0012 }
        if (r3 == 0) goto L_0x0094;
    L_0x0070:
        r3 = r2.f3173d;	 Catch:{ all -> 0x0012 }
        r3 = r3[r0];	 Catch:{ all -> 0x0012 }
        r4 = r10.f3187c;	 Catch:{ all -> 0x0012 }
        r4.m5047a(r1, r3);	 Catch:{ all -> 0x0012 }
        r1 = r2.f3172c;	 Catch:{ all -> 0x0012 }
        r4 = r1[r0];	 Catch:{ all -> 0x0012 }
        r1 = r10.f3187c;	 Catch:{ all -> 0x0012 }
        r6 = r1.m5052f(r3);	 Catch:{ all -> 0x0012 }
        r1 = r2.f3172c;	 Catch:{ all -> 0x0012 }
        r1[r0] = r6;	 Catch:{ all -> 0x0012 }
        r8 = r10.f3195k;	 Catch:{ all -> 0x0012 }
        r4 = r8 - r4;
        r4 = r4 + r6;
        r10.f3195k = r4;	 Catch:{ all -> 0x0012 }
    L_0x0094:
        r0 = r0 + 1;
        goto L_0x005c;
    L_0x0097:
        r3 = r10.f3187c;	 Catch:{ all -> 0x0012 }
        r3.m5050d(r1);	 Catch:{ all -> 0x0012 }
        goto L_0x0094;
    L_0x009d:
        r0 = r10.f3198n;	 Catch:{ all -> 0x0012 }
        r0 = r0 + 1;
        r10.f3198n = r0;	 Catch:{ all -> 0x0012 }
        r0 = 0;
        r2.f3176g = r0;	 Catch:{ all -> 0x0012 }
        r0 = r2.f3175f;	 Catch:{ all -> 0x0012 }
        r0 = r0 | r12;
        if (r0 == 0) goto L_0x00fc;
    L_0x00ae:
        r0 = 1;
        r2.f3175f = r0;	 Catch:{ all -> 0x0012 }
        r0 = r10.f3196l;	 Catch:{ all -> 0x0012 }
        r1 = "CLEAN";
        r0 = r0.m10166b(r1);	 Catch:{ all -> 0x0012 }
        r1 = 32;
        r0.m10175h(r1);	 Catch:{ all -> 0x0012 }
        r0 = r10.f3196l;	 Catch:{ all -> 0x0012 }
        r1 = r2.f3171b;	 Catch:{ all -> 0x0012 }
        r0.m10166b(r1);	 Catch:{ all -> 0x0012 }
        r0 = r10.f3196l;	 Catch:{ all -> 0x0012 }
        r2.m5043a(r0);	 Catch:{ all -> 0x0012 }
        r0 = r10.f3196l;	 Catch:{ all -> 0x0012 }
        r1 = 10;
        r0.m10175h(r1);	 Catch:{ all -> 0x0012 }
        if (r12 == 0) goto L_0x00e0;
    L_0x00d6:
        r0 = r10.f3202r;	 Catch:{ all -> 0x0012 }
        r4 = 1;
        r4 = r4 + r0;
        r10.f3202r = r4;	 Catch:{ all -> 0x0012 }
        r2.f3177h = r0;	 Catch:{ all -> 0x0012 }
    L_0x00e0:
        r0 = r10.f3196l;	 Catch:{ all -> 0x0012 }
        r0.flush();	 Catch:{ all -> 0x0012 }
        r0 = r10.f3195k;	 Catch:{ all -> 0x0012 }
        r2 = r10.f3193i;	 Catch:{ all -> 0x0012 }
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 > 0) goto L_0x00f3;
    L_0x00ed:
        r0 = r10.m5086i();	 Catch:{ all -> 0x0012 }
        if (r0 == 0) goto L_0x0057;
    L_0x00f3:
        r0 = r10.f3203s;	 Catch:{ all -> 0x0012 }
        r1 = r10.f3204t;	 Catch:{ all -> 0x0012 }
        r0.execute(r1);	 Catch:{ all -> 0x0012 }
        goto L_0x0057;
    L_0x00fc:
        r0 = r10.f3197m;	 Catch:{ all -> 0x0012 }
        r1 = r2.f3171b;	 Catch:{ all -> 0x0012 }
        r0.remove(r1);	 Catch:{ all -> 0x0012 }
        r0 = r10.f3196l;	 Catch:{ all -> 0x0012 }
        r1 = "REMOVE";
        r0 = r0.m10166b(r1);	 Catch:{ all -> 0x0012 }
        r1 = 32;
        r0.m10175h(r1);	 Catch:{ all -> 0x0012 }
        r0 = r10.f3196l;	 Catch:{ all -> 0x0012 }
        r1 = r2.f3171b;	 Catch:{ all -> 0x0012 }
        r0.m10166b(r1);	 Catch:{ all -> 0x0012 }
        r0 = r10.f3196l;	 Catch:{ all -> 0x0012 }
        r1 = 10;
        r0.m10175h(r1);	 Catch:{ all -> 0x0012 }
        goto L_0x00e0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.b.a(com.squareup.okhttp.internal.b$a, boolean):void");
    }

    private boolean m5086i() {
        return this.f3198n >= 2000 && this.f3198n >= this.f3197m.size();
    }

    public synchronized boolean m5094c(String str) throws IOException {
        boolean z;
        m5090a();
        m5087j();
        m5079e(str);
        C2106b c2106b = (C2106b) this.f3197m.get(str);
        if (c2106b == null) {
            z = false;
        } else {
            z = m5068a(c2106b);
        }
        return z;
    }

    private boolean m5068a(C2106b c2106b) throws IOException {
        if (c2106b.f3176g != null) {
            c2106b.f3176g.f3168d = true;
        }
        for (int i = 0; i < this.f3194j; i++) {
            this.f3187c.m5050d(c2106b.f3173d[i]);
            this.f3195k -= c2106b.f3172c[i];
            c2106b.f3172c[i] = 0;
        }
        this.f3198n++;
        this.f3196l.m10166b("REMOVE").m10175h(32).m10166b(c2106b.f3171b).m10175h(10);
        this.f3197m.remove(c2106b.f3171b);
        if (m5086i()) {
            this.f3203s.execute(this.f3204t);
        }
        return true;
    }

    public synchronized boolean m5092b() {
        return this.f3201q;
    }

    private synchronized void m5087j() {
        if (m5092b()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void close() throws IOException {
        if (!this.f3200p || this.f3201q) {
            this.f3201q = true;
        } else {
            for (C2106b c2106b : (C2106b[]) this.f3197m.values().toArray(new C2106b[this.f3197m.size()])) {
                if (c2106b.f3176g != null) {
                    c2106b.f3176g.m5028b();
                }
            }
            m5088k();
            this.f3196l.close();
            this.f3196l = null;
            this.f3201q = true;
        }
    }

    private void m5088k() throws IOException {
        while (this.f3195k > this.f3193i) {
            m5068a((C2106b) this.f3197m.values().iterator().next());
        }
    }

    public void m5093c() throws IOException {
        close();
        this.f3187c.m5053g(this.f3188d);
    }

    private void m5079e(String str) {
        if (!f3184a.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }
}
