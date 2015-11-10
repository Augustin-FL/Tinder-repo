package com.squareup.okhttp.internal.spdy;

import com.facebook.internal.NativeProtocol;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;
import okio.C2071q;
import okio.C2076r;
import okio.C2201s;
import okio.C2202a;
import okio.C3333e;
import okio.C3334c;

/* renamed from: com.squareup.okhttp.internal.spdy.n */
public final class C2204n {
    static final /* synthetic */ boolean f3539d;
    long f3540a;
    long f3541b;
    final C2199a f3542c;
    private final int f3543e;
    private final C2197m f3544f;
    private final List<C2162c> f3545g;
    private List<C2162c> f3546h;
    private final C2200b f3547i;
    private final C2203c f3548j;
    private final C2203c f3549k;
    private ErrorCode f3550l;

    /* renamed from: com.squareup.okhttp.internal.spdy.n.a */
    final class C2199a implements C2071q {
        static final /* synthetic */ boolean f3518a;
        final /* synthetic */ C2204n f3519b;
        private final C3334c f3520c;
        private boolean f3521d;
        private boolean f3522e;

        static {
            f3518a = !C2204n.class.desiredAssertionStatus();
        }

        C2199a(C2204n c2204n) {
            this.f3519b = c2204n;
            this.f3520c = new C3334c();
        }

        public void a_(C3334c c3334c, long j) throws IOException {
            if (f3518a || !Thread.holdsLock(this.f3519b)) {
                this.f3520c.a_(c3334c, j);
                while (this.f3520c.m10210b() >= 16384) {
                    m5613a(false);
                }
                return;
            }
            throw new AssertionError();
        }

        private void m5613a(boolean z) throws IOException {
            synchronized (this.f3519b) {
                this.f3519b.f3549k.m5641c();
                while (this.f3519b.f3541b <= 0 && !this.f3522e && !this.f3521d && this.f3519b.f3550l == null) {
                    try {
                        this.f3519b.m5655k();
                    } catch (Throwable th) {
                        this.f3519b.f3549k.m5643b();
                    }
                }
                this.f3519b.f3549k.m5643b();
                this.f3519b.m5654j();
                long min = Math.min(this.f3519b.f3541b, this.f3520c.m10210b());
                C2204n c2204n = this.f3519b;
                c2204n.f3541b -= min;
            }
            this.f3519b.f3549k.m5641c();
            try {
                C2197m a = this.f3519b.f3544f;
                int b = this.f3519b.f3543e;
                boolean z2 = z && min == this.f3520c.m10210b();
                a.m5604a(b, z2, this.f3520c, min);
            } finally {
                this.f3519b.f3549k.m5643b();
            }
        }

        public void flush() throws IOException {
            if (f3518a || !Thread.holdsLock(this.f3519b)) {
                synchronized (this.f3519b) {
                    this.f3519b.m5654j();
                }
                while (this.f3520c.m10210b() > 0) {
                    m5613a(false);
                    this.f3519b.f3544f.m5611d();
                }
                return;
            }
            throw new AssertionError();
        }

        public C2201s m5617a() {
            return this.f3519b.f3549k;
        }

        public void close() throws IOException {
            if (f3518a || !Thread.holdsLock(this.f3519b)) {
                synchronized (this.f3519b) {
                    if (this.f3521d) {
                        return;
                    }
                    if (!this.f3519b.f3542c.f3522e) {
                        if (this.f3520c.m10210b() > 0) {
                            while (this.f3520c.m10210b() > 0) {
                                m5613a(true);
                            }
                        } else {
                            this.f3519b.f3544f.m5604a(this.f3519b.f3543e, true, null, 0);
                        }
                    }
                    synchronized (this.f3519b) {
                        this.f3521d = true;
                    }
                    this.f3519b.f3544f.m5611d();
                    this.f3519b.m5653i();
                    return;
                }
            }
            throw new AssertionError();
        }
    }

    /* renamed from: com.squareup.okhttp.internal.spdy.n.b */
    private final class C2200b implements C2076r {
        static final /* synthetic */ boolean f3523a;
        final /* synthetic */ C2204n f3524b;
        private final C3334c f3525c;
        private final C3334c f3526d;
        private final long f3527e;
        private boolean f3528f;
        private boolean f3529g;

        static {
            f3523a = !C2204n.class.desiredAssertionStatus();
        }

        private C2200b(C2204n c2204n, long j) {
            this.f3524b = c2204n;
            this.f3525c = new C3334c();
            this.f3526d = new C3334c();
            this.f3527e = j;
        }

        public long m5623a(C3334c c3334c, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            long j2;
            synchronized (this.f3524b) {
                m5620b();
                m5622c();
                if (this.f3526d.m10210b() == 0) {
                    j2 = -1;
                } else {
                    j2 = this.f3526d.m10198a(c3334c, Math.min(j, this.f3526d.m10210b()));
                    C2204n c2204n = this.f3524b;
                    c2204n.f3540a += j2;
                    if (this.f3524b.f3540a >= ((long) (this.f3524b.f3544f.f3499e.m5507e(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) / 2))) {
                        this.f3524b.f3544f.m5602a(this.f3524b.f3543e, this.f3524b.f3540a);
                        this.f3524b.f3540a = 0;
                    }
                    synchronized (this.f3524b.f3544f) {
                        C2197m a = this.f3524b.f3544f;
                        a.f3497c += j2;
                        if (this.f3524b.f3544f.f3497c >= ((long) (this.f3524b.f3544f.f3499e.m5507e(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) / 2))) {
                            this.f3524b.f3544f.m5602a(0, this.f3524b.f3544f.f3497c);
                            this.f3524b.f3544f.f3497c = 0;
                        }
                    }
                }
            }
            return j2;
        }

        private void m5620b() throws IOException {
            this.f3524b.f3548j.m5641c();
            while (this.f3526d.m10210b() == 0 && !this.f3529g && !this.f3528f && this.f3524b.f3550l == null) {
                try {
                    this.f3524b.m5655k();
                } catch (Throwable th) {
                    this.f3524b.f3548j.m5643b();
                }
            }
            this.f3524b.f3548j.m5643b();
        }

        void m5625a(C3333e c3333e, long j) throws IOException {
            if (f3523a || !Thread.holdsLock(this.f3524b)) {
                while (j > 0) {
                    boolean z;
                    Object obj;
                    synchronized (this.f3524b) {
                        z = this.f3529g;
                        obj = this.f3526d.m10210b() + j > this.f3527e ? 1 : null;
                    }
                    if (obj != null) {
                        c3333e.m10184g(j);
                        this.f3524b.m5661b(ErrorCode.FLOW_CONTROL_ERROR);
                        return;
                    } else if (z) {
                        c3333e.m10184g(j);
                        return;
                    } else {
                        long a = c3333e.m4901a(this.f3525c, j);
                        if (a == -1) {
                            throw new EOFException();
                        }
                        j -= a;
                        synchronized (this.f3524b) {
                            if (this.f3526d.m10210b() == 0) {
                                obj = 1;
                            } else {
                                obj = null;
                            }
                            this.f3526d.m10199a(this.f3525c);
                            if (obj != null) {
                                this.f3524b.notifyAll();
                            }
                        }
                    }
                }
                return;
            }
            throw new AssertionError();
        }

        public C2201s m5624a() {
            return this.f3524b.f3548j;
        }

        public void close() throws IOException {
            synchronized (this.f3524b) {
                this.f3528f = true;
                this.f3526d.m10251u();
                this.f3524b.notifyAll();
            }
            this.f3524b.m5653i();
        }

        private void m5622c() throws IOException {
            if (this.f3528f) {
                throw new IOException("stream closed");
            } else if (this.f3524b.f3550l != null) {
                throw new IOException("stream was reset: " + this.f3524b.f3550l);
            }
        }
    }

    /* renamed from: com.squareup.okhttp.internal.spdy.n.c */
    class C2203c extends C2202a {
        final /* synthetic */ C2204n f3538a;

        C2203c(C2204n c2204n) {
            this.f3538a = c2204n;
        }

        protected void m5642a() {
            this.f3538a.m5661b(ErrorCode.CANCEL);
        }

        public void m5643b() throws InterruptedIOException {
            if (m_()) {
                throw new InterruptedIOException("timeout");
            }
        }
    }

    static {
        f3539d = !C2204n.class.desiredAssertionStatus();
    }

    C2204n(int i, C2197m c2197m, boolean z, boolean z2, List<C2162c> list) {
        this.f3540a = 0;
        this.f3548j = new C2203c(this);
        this.f3549k = new C2203c(this);
        this.f3550l = null;
        if (c2197m == null) {
            throw new NullPointerException("connection == null");
        } else if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        } else {
            this.f3543e = i;
            this.f3544f = c2197m;
            this.f3541b = (long) c2197m.f3500f.m5507e(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
            this.f3547i = new C2200b((long) c2197m.f3499e.m5507e(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST), null);
            this.f3542c = new C2199a(this);
            this.f3547i.f3529g = z2;
            this.f3542c.f3522e = z;
            this.f3545g = list;
        }
    }

    public int m5656a() {
        return this.f3543e;
    }

    public synchronized boolean m5662b() {
        boolean z = false;
        synchronized (this) {
            if (this.f3550l == null) {
                if (!(this.f3547i.f3529g || this.f3547i.f3528f) || (!(this.f3542c.f3522e || this.f3542c.f3521d) || this.f3546h == null)) {
                    z = true;
                }
            }
        }
        return z;
    }

    public boolean m5664c() {
        boolean z;
        if ((this.f3543e & 1) == 1) {
            z = true;
        } else {
            z = false;
        }
        return this.f3544f.f3496b == z;
    }

    public synchronized List<C2162c> m5665d() throws IOException {
        this.f3548j.m5641c();
        while (this.f3546h == null && this.f3550l == null) {
            try {
                m5655k();
            } catch (Throwable th) {
                this.f3548j.m5643b();
            }
        }
        this.f3548j.m5643b();
        if (this.f3546h != null) {
        } else {
            throw new IOException("stream was reset: " + this.f3550l);
        }
        return this.f3546h;
    }

    public C2201s m5666e() {
        return this.f3548j;
    }

    public C2076r m5667f() {
        return this.f3547i;
    }

    public C2071q m5668g() {
        synchronized (this) {
            if (this.f3546h != null || m5664c()) {
            } else {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.f3542c;
    }

    public void m5658a(ErrorCode errorCode) throws IOException {
        if (m5648d(errorCode)) {
            this.f3544f.m5608b(this.f3543e, errorCode);
        }
    }

    public void m5661b(ErrorCode errorCode) {
        if (m5648d(errorCode)) {
            this.f3544f.m5603a(this.f3543e, errorCode);
        }
    }

    private boolean m5648d(ErrorCode errorCode) {
        if (f3539d || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.f3550l != null) {
                    return false;
                } else if (this.f3547i.f3529g && this.f3542c.f3522e) {
                    return false;
                } else {
                    this.f3550l = errorCode;
                    notifyAll();
                    this.f3544f.m5607b(this.f3543e);
                    return true;
                }
            }
        }
        throw new AssertionError();
    }

    void m5659a(List<C2162c> list, HeadersMode headersMode) {
        if (f3539d || !Thread.holdsLock(this)) {
            ErrorCode errorCode = null;
            boolean z = true;
            synchronized (this) {
                if (this.f3546h == null) {
                    if (headersMode.m5369c()) {
                        errorCode = ErrorCode.PROTOCOL_ERROR;
                    } else {
                        this.f3546h = list;
                        z = m5662b();
                        notifyAll();
                    }
                } else if (headersMode.m5370d()) {
                    errorCode = ErrorCode.STREAM_IN_USE;
                } else {
                    List arrayList = new ArrayList();
                    arrayList.addAll(this.f3546h);
                    arrayList.addAll(list);
                    this.f3546h = arrayList;
                }
            }
            if (errorCode != null) {
                m5661b(errorCode);
                return;
            } else if (!z) {
                this.f3544f.m5607b(this.f3543e);
                return;
            } else {
                return;
            }
        }
        throw new AssertionError();
    }

    void m5660a(C3333e c3333e, int i) throws IOException {
        if (f3539d || !Thread.holdsLock(this)) {
            this.f3547i.m5625a(c3333e, (long) i);
            return;
        }
        throw new AssertionError();
    }

    void m5669h() {
        if (f3539d || !Thread.holdsLock(this)) {
            boolean b;
            synchronized (this) {
                this.f3547i.f3529g = true;
                b = m5662b();
                notifyAll();
            }
            if (!b) {
                this.f3544f.m5607b(this.f3543e);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    synchronized void m5663c(ErrorCode errorCode) {
        if (this.f3550l == null) {
            this.f3550l = errorCode;
            notifyAll();
        }
    }

    private void m5653i() throws IOException {
        if (f3539d || !Thread.holdsLock(this)) {
            Object obj;
            boolean b;
            synchronized (this) {
                obj = (!this.f3547i.f3529g && this.f3547i.f3528f && (this.f3542c.f3522e || this.f3542c.f3521d)) ? 1 : null;
                b = m5662b();
            }
            if (obj != null) {
                m5658a(ErrorCode.CANCEL);
                return;
            } else if (!b) {
                this.f3544f.m5607b(this.f3543e);
                return;
            } else {
                return;
            }
        }
        throw new AssertionError();
    }

    void m5657a(long j) {
        this.f3541b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    private void m5654j() throws IOException {
        if (this.f3542c.f3521d) {
            throw new IOException("stream closed");
        } else if (this.f3542c.f3522e) {
            throw new IOException("stream finished");
        } else if (this.f3550l != null) {
            throw new IOException("stream was reset: " + this.f3550l);
        }
    }

    private void m5655k() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException e) {
            throw new InterruptedIOException();
        }
    }
}
