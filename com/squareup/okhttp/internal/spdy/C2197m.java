package com.squareup.okhttp.internal.spdy;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.facebook.internal.NativeProtocol;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.C2113d;
import com.squareup.okhttp.internal.C2114f;
import com.squareup.okhttp.internal.C2157k;
import com.squareup.okhttp.internal.spdy.C2160a.C2159a;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import okio.ByteString;
import okio.C3333e;
import okio.C3334c;
import okio.C3342l;

/* renamed from: com.squareup.okhttp.internal.spdy.m */
public final class C2197m implements Closeable {
    static final /* synthetic */ boolean f3493k;
    private static final ExecutorService f3494l;
    final Protocol f3495a;
    final boolean f3496b;
    long f3497c;
    long f3498d;
    final C2182k f3499e;
    final C2182k f3500f;
    final C2170o f3501g;
    final Socket f3502h;
    final C2161b f3503i;
    final C2196b f3504j;
    private final C2174g f3505m;
    private final Map<Integer, C2204n> f3506n;
    private final String f3507o;
    private int f3508p;
    private int f3509q;
    private boolean f3510r;
    private long f3511s;
    private final ExecutorService f3512t;
    private Map<Integer, C2179i> f3513u;
    private final C2180j f3514v;
    private int f3515w;
    private boolean f3516x;
    private final Set<Integer> f3517y;

    /* renamed from: com.squareup.okhttp.internal.spdy.m.1 */
    class C21861 extends C2114f {
        final /* synthetic */ int f3455b;
        final /* synthetic */ ErrorCode f3456c;
        final /* synthetic */ C2197m f3457d;

        C21861(C2197m c2197m, String str, Object[] objArr, int i, ErrorCode errorCode) {
            this.f3457d = c2197m;
            this.f3455b = i;
            this.f3456c = errorCode;
            super(str, objArr);
        }

        public void m5537a() {
            try {
                this.f3457d.m5608b(this.f3455b, this.f3456c);
            } catch (IOException e) {
            }
        }
    }

    /* renamed from: com.squareup.okhttp.internal.spdy.m.2 */
    class C21872 extends C2114f {
        final /* synthetic */ int f3458b;
        final /* synthetic */ long f3459c;
        final /* synthetic */ C2197m f3460d;

        C21872(C2197m c2197m, String str, Object[] objArr, int i, long j) {
            this.f3460d = c2197m;
            this.f3458b = i;
            this.f3459c = j;
            super(str, objArr);
        }

        public void m5538a() {
            try {
                this.f3460d.f3503i.m5385a(this.f3458b, this.f3459c);
            } catch (IOException e) {
            }
        }
    }

    /* renamed from: com.squareup.okhttp.internal.spdy.m.3 */
    class C21883 extends C2114f {
        final /* synthetic */ boolean f3461b;
        final /* synthetic */ int f3462c;
        final /* synthetic */ int f3463d;
        final /* synthetic */ C2179i f3464e;
        final /* synthetic */ C2197m f3465f;

        C21883(C2197m c2197m, String str, Object[] objArr, boolean z, int i, int i2, C2179i c2179i) {
            this.f3465f = c2197m;
            this.f3461b = z;
            this.f3462c = i;
            this.f3463d = i2;
            this.f3464e = c2179i;
            super(str, objArr);
        }

        public void m5539a() {
            try {
                this.f3465f.m5584b(this.f3461b, this.f3462c, this.f3463d, this.f3464e);
            } catch (IOException e) {
            }
        }
    }

    /* renamed from: com.squareup.okhttp.internal.spdy.m.4 */
    class C21894 extends C2114f {
        final /* synthetic */ int f3466b;
        final /* synthetic */ List f3467c;
        final /* synthetic */ C2197m f3468d;

        C21894(C2197m c2197m, String str, Object[] objArr, int i, List list) {
            this.f3468d = c2197m;
            this.f3466b = i;
            this.f3467c = list;
            super(str, objArr);
        }

        public void m5540a() {
            if (this.f3468d.f3514v.m5491a(this.f3466b, this.f3467c)) {
                try {
                    this.f3468d.f3503i.m5386a(this.f3466b, ErrorCode.CANCEL);
                    synchronized (this.f3468d) {
                        this.f3468d.f3517y.remove(Integer.valueOf(this.f3466b));
                    }
                } catch (IOException e) {
                }
            }
        }
    }

    /* renamed from: com.squareup.okhttp.internal.spdy.m.5 */
    class C21905 extends C2114f {
        final /* synthetic */ int f3469b;
        final /* synthetic */ List f3470c;
        final /* synthetic */ boolean f3471d;
        final /* synthetic */ C2197m f3472e;

        C21905(C2197m c2197m, String str, Object[] objArr, int i, List list, boolean z) {
            this.f3472e = c2197m;
            this.f3469b = i;
            this.f3470c = list;
            this.f3471d = z;
            super(str, objArr);
        }

        public void m5541a() {
            boolean a = this.f3472e.f3514v.m5492a(this.f3469b, this.f3470c, this.f3471d);
            if (a) {
                try {
                    this.f3472e.f3503i.m5386a(this.f3469b, ErrorCode.CANCEL);
                } catch (IOException e) {
                    return;
                }
            }
            if (a || this.f3471d) {
                synchronized (this.f3472e) {
                    this.f3472e.f3517y.remove(Integer.valueOf(this.f3469b));
                }
            }
        }
    }

    /* renamed from: com.squareup.okhttp.internal.spdy.m.6 */
    class C21916 extends C2114f {
        final /* synthetic */ int f3473b;
        final /* synthetic */ C3334c f3474c;
        final /* synthetic */ int f3475d;
        final /* synthetic */ boolean f3476e;
        final /* synthetic */ C2197m f3477f;

        C21916(C2197m c2197m, String str, Object[] objArr, int i, C3334c c3334c, int i2, boolean z) {
            this.f3477f = c2197m;
            this.f3473b = i;
            this.f3474c = c3334c;
            this.f3475d = i2;
            this.f3476e = z;
            super(str, objArr);
        }

        public void m5542a() {
            try {
                boolean a = this.f3477f.f3514v.m5493a(this.f3473b, this.f3474c, this.f3475d, this.f3476e);
                if (a) {
                    this.f3477f.f3503i.m5386a(this.f3473b, ErrorCode.CANCEL);
                }
                if (a || this.f3476e) {
                    synchronized (this.f3477f) {
                        this.f3477f.f3517y.remove(Integer.valueOf(this.f3473b));
                    }
                }
            } catch (IOException e) {
            }
        }
    }

    /* renamed from: com.squareup.okhttp.internal.spdy.m.7 */
    class C21927 extends C2114f {
        final /* synthetic */ int f3478b;
        final /* synthetic */ ErrorCode f3479c;
        final /* synthetic */ C2197m f3480d;

        C21927(C2197m c2197m, String str, Object[] objArr, int i, ErrorCode errorCode) {
            this.f3480d = c2197m;
            this.f3478b = i;
            this.f3479c = errorCode;
            super(str, objArr);
        }

        public void m5543a() {
            this.f3480d.f3514v.m5490a(this.f3478b, this.f3479c);
            synchronized (this.f3480d) {
                this.f3480d.f3517y.remove(Integer.valueOf(this.f3478b));
            }
        }
    }

    /* renamed from: com.squareup.okhttp.internal.spdy.m.a */
    public static class C2193a {
        private String f3481a;
        private Socket f3482b;
        private C2174g f3483c;
        private Protocol f3484d;
        private C2180j f3485e;
        private boolean f3486f;

        public C2193a(String str, boolean z, Socket socket) throws IOException {
            this.f3483c = C2174g.f3432a;
            this.f3484d = Protocol.SPDY_3;
            this.f3485e = C2180j.f3441a;
            this.f3481a = str;
            this.f3486f = z;
            this.f3482b = socket;
        }

        public C2193a m5550a(Protocol protocol) {
            this.f3484d = protocol;
            return this;
        }

        public C2197m m5551a() throws IOException {
            return new C2197m();
        }
    }

    /* renamed from: com.squareup.okhttp.internal.spdy.m.b */
    class C2196b extends C2114f implements C2159a {
        C2160a f3491b;
        final /* synthetic */ C2197m f3492c;

        /* renamed from: com.squareup.okhttp.internal.spdy.m.b.1 */
        class C21941 extends C2114f {
            final /* synthetic */ C2204n f3487b;
            final /* synthetic */ C2196b f3488c;

            C21941(C2196b c2196b, String str, Object[] objArr, C2204n c2204n) {
                this.f3488c = c2196b;
                this.f3487b = c2204n;
                super(str, objArr);
            }

            public void m5552a() {
                try {
                    this.f3488c.f3492c.f3505m.m5478a(this.f3487b);
                } catch (Throwable e) {
                    C2113d.f3214a.log(Level.INFO, "StreamHandler failure for " + this.f3488c.f3492c.f3507o, e);
                    try {
                        this.f3487b.m5658a(ErrorCode.PROTOCOL_ERROR);
                    } catch (IOException e2) {
                    }
                }
            }
        }

        /* renamed from: com.squareup.okhttp.internal.spdy.m.b.2 */
        class C21952 extends C2114f {
            final /* synthetic */ C2182k f3489b;
            final /* synthetic */ C2196b f3490c;

            C21952(C2196b c2196b, String str, Object[] objArr, C2182k c2182k) {
                this.f3490c = c2196b;
                this.f3489b = c2182k;
                super(str, objArr);
            }

            public void m5553a() {
                try {
                    this.f3490c.f3492c.f3503i.m5388a(this.f3489b);
                } catch (IOException e) {
                }
            }
        }

        private C2196b(C2197m c2197m) {
            this.f3492c = c2197m;
            super("OkHttp %s", c2197m.f3507o);
        }

        protected void m5555a() {
            ErrorCode errorCode;
            Throwable th;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            ErrorCode errorCode3 = ErrorCode.INTERNAL_ERROR;
            try {
                this.f3491b = this.f3492c.f3501g.m5455a(C3342l.m10280a(C3342l.m10288b(this.f3492c.f3502h)), this.f3492c.f3496b);
                if (!this.f3492c.f3496b) {
                    this.f3491b.m5381a();
                }
                do {
                } while (this.f3491b.m5382a(this));
                try {
                    this.f3492c.m5571a(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
                } catch (IOException e) {
                }
                C2157k.m5355a(this.f3491b);
            } catch (IOException e2) {
                errorCode = ErrorCode.PROTOCOL_ERROR;
                try {
                    this.f3492c.m5571a(errorCode, ErrorCode.PROTOCOL_ERROR);
                } catch (IOException e3) {
                }
                C2157k.m5355a(this.f3491b);
            } catch (Throwable th2) {
                th = th2;
                this.f3492c.m5571a(errorCode, errorCode3);
                C2157k.m5355a(this.f3491b);
                throw th;
            }
        }

        public void m5562a(boolean z, int i, C3333e c3333e, int i2) throws IOException {
            if (this.f3492c.m5592d(i)) {
                this.f3492c.m5570a(i, c3333e, i2, z);
                return;
            }
            C2204n a = this.f3492c.m5600a(i);
            if (a == null) {
                this.f3492c.m5603a(i, ErrorCode.INVALID_STREAM);
                c3333e.m10184g((long) i2);
                return;
            }
            a.m5660a(c3333e, i2);
            if (z) {
                a.m5669h();
            }
        }

        public void m5564a(boolean z, boolean z2, int i, int i2, List<C2162c> list, HeadersMode headersMode) {
            if (this.f3492c.m5592d(i)) {
                this.f3492c.m5569a(i, (List) list, z2);
                return;
            }
            synchronized (this.f3492c) {
                if (this.f3492c.f3510r) {
                    return;
                }
                C2204n a = this.f3492c.m5600a(i);
                if (a != null) {
                    if (headersMode.m5368b()) {
                        a.m5661b(ErrorCode.PROTOCOL_ERROR);
                        this.f3492c.m5607b(i);
                        return;
                    }
                    a.m5659a((List) list, headersMode);
                    if (z2) {
                        a.m5669h();
                    }
                } else if (headersMode.m5367a()) {
                    this.f3492c.m5603a(i, ErrorCode.INVALID_STREAM);
                } else if (i <= this.f3492c.f3508p) {
                } else if (i % 2 == this.f3492c.f3509q % 2) {
                } else {
                    a = new C2204n(i, this.f3492c, z, z2, list);
                    this.f3492c.f3508p = i;
                    this.f3492c.f3506n.put(Integer.valueOf(i), a);
                    C2197m.f3494l.execute(new C21941(this, "OkHttp %s stream %d", new Object[]{this.f3492c.f3507o, Integer.valueOf(i)}, a));
                }
            }
        }

        public void m5559a(int i, ErrorCode errorCode) {
            if (this.f3492c.m5592d(i)) {
                this.f3492c.m5590c(i, errorCode);
                return;
            }
            C2204n b = this.f3492c.m5607b(i);
            if (b != null) {
                b.m5663c(errorCode);
            }
        }

        public void m5563a(boolean z, C2182k c2182k) {
            C2204n[] c2204nArr;
            long j;
            synchronized (this.f3492c) {
                int e = this.f3492c.f3500f.m5507e(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
                if (z) {
                    this.f3492c.f3500f.m5499a();
                }
                this.f3492c.f3500f.m5500a(c2182k);
                if (this.f3492c.m5599a() == Protocol.HTTP_2) {
                    m5554a(c2182k);
                }
                int e2 = this.f3492c.f3500f.m5507e(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
                if (e2 == -1 || e2 == e) {
                    c2204nArr = null;
                    j = 0;
                } else {
                    j = (long) (e2 - e);
                    if (!this.f3492c.f3516x) {
                        this.f3492c.m5605a(j);
                        this.f3492c.f3516x = true;
                    }
                    c2204nArr = !this.f3492c.f3506n.isEmpty() ? (C2204n[]) this.f3492c.f3506n.values().toArray(new C2204n[this.f3492c.f3506n.size()]) : null;
                }
            }
            if (c2204nArr != null && j != 0) {
                for (C2204n c2204n : c2204nArr) {
                    synchronized (c2204n) {
                        c2204n.m5657a(j);
                    }
                }
            }
        }

        private void m5554a(C2182k c2182k) {
            C2197m.f3494l.execute(new C21952(this, "OkHttp %s ACK Settings", new Object[]{this.f3492c.f3507o}, c2182k));
        }

        public void m5565b() {
        }

        public void m5561a(boolean z, int i, int i2) {
            if (z) {
                C2179i c = this.f3492c.m5588c(i);
                if (c != null) {
                    c.m5488b();
                    return;
                }
                return;
            }
            this.f3492c.m5579a(true, i, i2, null);
        }

        public void m5560a(int i, ErrorCode errorCode, ByteString byteString) {
            if (byteString.m10157f() > 0) {
            }
            synchronized (this.f3492c) {
                C2204n[] c2204nArr = (C2204n[]) this.f3492c.f3506n.values().toArray(new C2204n[this.f3492c.f3506n.size()]);
                this.f3492c.f3510r = true;
            }
            for (C2204n c2204n : c2204nArr) {
                if (c2204n.m5656a() > i && c2204n.m5664c()) {
                    c2204n.m5663c(ErrorCode.REFUSED_STREAM);
                    this.f3492c.m5607b(c2204n.m5656a());
                }
            }
        }

        public void m5558a(int i, long j) {
            if (i == 0) {
                synchronized (this.f3492c) {
                    C2197m c2197m = this.f3492c;
                    c2197m.f3498d += j;
                    this.f3492c.notifyAll();
                }
                return;
            }
            C2204n a = this.f3492c.m5600a(i);
            if (a != null) {
                synchronized (a) {
                    a.m5657a(j);
                }
            }
        }

        public void m5556a(int i, int i2, int i3, boolean z) {
        }

        public void m5557a(int i, int i2, List<C2162c> list) {
            this.f3492c.m5568a(i2, (List) list);
        }
    }

    static {
        boolean z;
        if (C2197m.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        f3493k = z;
        f3494l = new ThreadPoolExecutor(0, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60, TimeUnit.SECONDS, new SynchronousQueue(), C2157k.m5352a("OkHttp SpdyConnection", true));
    }

    private C2197m(C2193a c2193a) throws IOException {
        int i = 2;
        this.f3506n = new HashMap();
        this.f3511s = System.nanoTime();
        this.f3497c = 0;
        this.f3499e = new C2182k();
        this.f3500f = new C2182k();
        this.f3516x = false;
        this.f3517y = new LinkedHashSet();
        this.f3495a = c2193a.f3484d;
        this.f3514v = c2193a.f3485e;
        this.f3496b = c2193a.f3486f;
        this.f3505m = c2193a.f3483c;
        this.f3509q = c2193a.f3486f ? 1 : 2;
        if (c2193a.f3486f && this.f3495a == Protocol.HTTP_2) {
            this.f3509q += 2;
        }
        if (c2193a.f3486f) {
            i = 1;
        }
        this.f3515w = i;
        if (c2193a.f3486f) {
            this.f3499e.m5498a(7, 0, ViewCompat.MEASURED_STATE_TOO_SMALL);
        }
        this.f3507o = c2193a.f3481a;
        if (this.f3495a == Protocol.HTTP_2) {
            this.f3501g = new C2171e();
            this.f3512t = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), C2157k.m5352a(String.format("OkHttp %s Push Observer", new Object[]{this.f3507o}), true));
            this.f3500f.m5498a(7, 0, SupportMenu.USER_MASK);
            this.f3500f.m5498a(5, 0, AccessibilityNodeInfoCompat.ACTION_COPY);
        } else if (this.f3495a == Protocol.SPDY_3) {
            this.f3501g = new C2185l();
            this.f3512t = null;
        } else {
            throw new AssertionError(this.f3495a);
        }
        this.f3498d = (long) this.f3500f.m5507e(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        this.f3502h = c2193a.f3482b;
        this.f3503i = this.f3501g.m5456a(C3342l.m10279a(C3342l.m10283a(c2193a.f3482b)), this.f3496b);
        this.f3504j = new C2196b();
        new Thread(this.f3504j).start();
    }

    public Protocol m5599a() {
        return this.f3495a;
    }

    synchronized C2204n m5600a(int i) {
        return (C2204n) this.f3506n.get(Integer.valueOf(i));
    }

    synchronized C2204n m5607b(int i) {
        C2204n c2204n;
        c2204n = (C2204n) this.f3506n.remove(Integer.valueOf(i));
        if (c2204n != null && this.f3506n.isEmpty()) {
            m5578a(true);
        }
        notifyAll();
        return c2204n;
    }

    private synchronized void m5578a(boolean z) {
        this.f3511s = z ? System.nanoTime() : Long.MAX_VALUE;
    }

    public synchronized boolean m5609b() {
        return this.f3511s != Long.MAX_VALUE;
    }

    public synchronized long m5610c() {
        return this.f3511s;
    }

    public C2204n m5601a(List<C2162c> list, boolean z, boolean z2) throws IOException {
        return m5566a(0, (List) list, z, z2);
    }

    private C2204n m5566a(int i, List<C2162c> list, boolean z, boolean z2) throws IOException {
        C2204n c2204n;
        boolean z3 = true;
        boolean z4 = !z;
        if (z2) {
            z3 = false;
        }
        synchronized (this.f3503i) {
            synchronized (this) {
                if (this.f3510r) {
                    throw new IOException("shutdown");
                }
                int i2 = this.f3509q;
                this.f3509q += 2;
                c2204n = new C2204n(i2, this, z4, z3, list);
                if (c2204n.m5662b()) {
                    this.f3506n.put(Integer.valueOf(i2), c2204n);
                    m5578a(false);
                }
            }
            if (i == 0) {
                this.f3503i.m5391a(z4, z3, i2, i, list);
            } else if (this.f3496b) {
                throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
            } else {
                this.f3503i.m5384a(i, i2, (List) list);
            }
        }
        if (!z) {
            this.f3503i.m5392b();
        }
        return c2204n;
    }

    public void m5604a(int i, boolean z, C3334c c3334c, long j) throws IOException {
        if (j == 0) {
            this.f3503i.m5390a(z, i, c3334c, 0);
            return;
        }
        while (j > 0) {
            int min;
            boolean z2;
            synchronized (this) {
                while (this.f3498d <= 0) {
                    try {
                        if (this.f3506n.containsKey(Integer.valueOf(i))) {
                            wait();
                        } else {
                            throw new IOException("stream closed");
                        }
                    } catch (InterruptedException e) {
                        throw new InterruptedIOException();
                    }
                }
                min = Math.min((int) Math.min(j, this.f3498d), this.f3503i.m5394c());
                this.f3498d -= (long) min;
            }
            j -= (long) min;
            C2161b c2161b = this.f3503i;
            if (z && j == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            c2161b.m5390a(z2, i, c3334c, min);
        }
    }

    void m5605a(long j) {
        this.f3498d += j;
        if (j > 0) {
            notifyAll();
        }
    }

    void m5603a(int i, ErrorCode errorCode) {
        f3494l.submit(new C21861(this, "OkHttp %s stream %d", new Object[]{this.f3507o, Integer.valueOf(i)}, i, errorCode));
    }

    void m5608b(int i, ErrorCode errorCode) throws IOException {
        this.f3503i.m5386a(i, errorCode);
    }

    void m5602a(int i, long j) {
        f3494l.execute(new C21872(this, "OkHttp Window Update %s stream %d", new Object[]{this.f3507o, Integer.valueOf(i)}, i, j));
    }

    private void m5579a(boolean z, int i, int i2, C2179i c2179i) {
        f3494l.execute(new C21883(this, "OkHttp %s ping %08x%08x", new Object[]{this.f3507o, Integer.valueOf(i), Integer.valueOf(i2)}, z, i, i2, c2179i));
    }

    private void m5584b(boolean z, int i, int i2, C2179i c2179i) throws IOException {
        synchronized (this.f3503i) {
            if (c2179i != null) {
                c2179i.m5487a();
            }
            this.f3503i.m5389a(z, i, i2);
        }
    }

    private synchronized C2179i m5588c(int i) {
        return this.f3513u != null ? (C2179i) this.f3513u.remove(Integer.valueOf(i)) : null;
    }

    public void m5611d() throws IOException {
        this.f3503i.m5392b();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m5606a(com.squareup.okhttp.internal.spdy.ErrorCode r5) throws java.io.IOException {
        /*
        r4 = this;
        r1 = r4.f3503i;
        monitor-enter(r1);
        monitor-enter(r4);	 Catch:{ all -> 0x001a }
        r0 = r4.f3510r;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x000b;
    L_0x0008:
        monitor-exit(r4);	 Catch:{ all -> 0x001d }
        monitor-exit(r1);	 Catch:{ all -> 0x001a }
    L_0x000a:
        return;
    L_0x000b:
        r0 = 1;
        r4.f3510r = r0;	 Catch:{ all -> 0x001d }
        r0 = r4.f3508p;	 Catch:{ all -> 0x001d }
        monitor-exit(r4);	 Catch:{ all -> 0x001d }
        r2 = r4.f3503i;	 Catch:{ all -> 0x001a }
        r3 = com.squareup.okhttp.internal.C2157k.f3353a;	 Catch:{ all -> 0x001a }
        r2.m5387a(r0, r5, r3);	 Catch:{ all -> 0x001a }
        monitor-exit(r1);	 Catch:{ all -> 0x001a }
        goto L_0x000a;
    L_0x001a:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001a }
        throw r0;
    L_0x001d:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x001d }
        throw r0;	 Catch:{ all -> 0x001a }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.spdy.m.a(com.squareup.okhttp.internal.spdy.ErrorCode):void");
    }

    public void close() throws IOException {
        m5571a(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    private void m5571a(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        IOException e;
        if (f3493k || !Thread.holdsLock(this)) {
            IOException iOException;
            C2204n[] c2204nArr;
            C2179i[] c2179iArr;
            try {
                m5606a(errorCode);
                iOException = null;
            } catch (IOException e2) {
                iOException = e2;
            }
            synchronized (this) {
                if (this.f3506n.isEmpty()) {
                    c2204nArr = null;
                } else {
                    C2204n[] c2204nArr2 = (C2204n[]) this.f3506n.values().toArray(new C2204n[this.f3506n.size()]);
                    this.f3506n.clear();
                    m5578a(false);
                    c2204nArr = c2204nArr2;
                }
                if (this.f3513u != null) {
                    C2179i[] c2179iArr2 = (C2179i[]) this.f3513u.values().toArray(new C2179i[this.f3513u.size()]);
                    this.f3513u = null;
                    c2179iArr = c2179iArr2;
                } else {
                    c2179iArr = null;
                }
            }
            if (c2204nArr != null) {
                e2 = iOException;
                for (C2204n a : c2204nArr) {
                    try {
                        a.m5658a(errorCode2);
                    } catch (IOException iOException2) {
                        if (e2 != null) {
                            e2 = iOException2;
                        }
                    }
                }
                iOException2 = e2;
            }
            if (c2179iArr != null) {
                for (C2179i c : c2179iArr) {
                    c.m5489c();
                }
            }
            try {
                this.f3503i.close();
                e2 = iOException2;
            } catch (IOException e3) {
                e2 = e3;
                if (iOException2 != null) {
                    e2 = iOException2;
                }
            }
            try {
                this.f3502h.close();
            } catch (IOException e4) {
                e2 = e4;
            }
            if (e2 != null) {
                throw e2;
            }
            return;
        }
        throw new AssertionError();
    }

    public void m5612e() throws IOException {
        this.f3503i.m5383a();
        this.f3503i.m5393b(this.f3499e);
        int e = this.f3499e.m5507e(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        if (e != NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) {
            this.f3503i.m5385a(0, (long) (e - NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST));
        }
    }

    private boolean m5592d(int i) {
        return this.f3495a == Protocol.HTTP_2 && i != 0 && (i & 1) == 0;
    }

    private void m5568a(int i, List<C2162c> list) {
        synchronized (this) {
            if (this.f3517y.contains(Integer.valueOf(i))) {
                m5603a(i, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.f3517y.add(Integer.valueOf(i));
            this.f3512t.execute(new C21894(this, "OkHttp %s Push Request[%s]", new Object[]{this.f3507o, Integer.valueOf(i)}, i, list));
        }
    }

    private void m5569a(int i, List<C2162c> list, boolean z) {
        this.f3512t.execute(new C21905(this, "OkHttp %s Push Headers[%s]", new Object[]{this.f3507o, Integer.valueOf(i)}, i, list, z));
    }

    private void m5570a(int i, C3333e c3333e, int i2, boolean z) throws IOException {
        C3334c c3334c = new C3334c();
        c3333e.m10180a((long) i2);
        c3333e.m4901a(c3334c, (long) i2);
        if (c3334c.m10210b() != ((long) i2)) {
            throw new IOException(c3334c.m10210b() + " != " + i2);
        }
        this.f3512t.execute(new C21916(this, "OkHttp %s Push Data[%s]", new Object[]{this.f3507o, Integer.valueOf(i)}, i, c3334c, i2, z));
    }

    private void m5590c(int i, ErrorCode errorCode) {
        this.f3512t.execute(new C21927(this, "OkHttp %s Push Reset[%s]", new Object[]{this.f3507o, Integer.valueOf(i)}, i, errorCode));
    }
}
