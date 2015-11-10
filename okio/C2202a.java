package okio;

import java.io.IOException;
import java.io.InterruptedIOException;

/* renamed from: okio.a */
public class C2202a extends C2201s {
    private static C2202a f3534a;
    private boolean f3535c;
    private C2202a f3536d;
    private long f3537e;

    /* renamed from: okio.a.1 */
    class C33261 implements C2071q {
        final /* synthetic */ C2071q f7270a;
        final /* synthetic */ C2202a f7271b;

        C33261(C2202a c2202a, C2071q c2071q) {
            this.f7271b = c2202a;
            this.f7270a = c2071q;
        }

        public void a_(C3334c c3334c, long j) throws IOException {
            this.f7271b.m5641c();
            try {
                this.f7270a.a_(c3334c, j);
                this.f7271b.m5640a(true);
            } catch (IOException e) {
                throw this.f7271b.m5636a(e);
            } catch (Throwable th) {
                this.f7271b.m5640a(false);
            }
        }

        public void flush() throws IOException {
            this.f7271b.m5641c();
            try {
                this.f7270a.flush();
                this.f7271b.m5640a(true);
            } catch (IOException e) {
                throw this.f7271b.m5636a(e);
            } catch (Throwable th) {
                this.f7271b.m5640a(false);
            }
        }

        public void close() throws IOException {
            this.f7271b.m5641c();
            try {
                this.f7270a.close();
                this.f7271b.m5640a(true);
            } catch (IOException e) {
                throw this.f7271b.m5636a(e);
            } catch (Throwable th) {
                this.f7271b.m5640a(false);
            }
        }

        public C2201s m10159a() {
            return this.f7271b;
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f7270a + ")";
        }
    }

    /* renamed from: okio.a.2 */
    class C33272 implements C2076r {
        final /* synthetic */ C2076r f7272a;
        final /* synthetic */ C2202a f7273b;

        C33272(C2202a c2202a, C2076r c2076r) {
            this.f7273b = c2202a;
            this.f7272a = c2076r;
        }

        public long m10160a(C3334c c3334c, long j) throws IOException {
            this.f7273b.m5641c();
            try {
                long a = this.f7272a.m4901a(c3334c, j);
                this.f7273b.m5640a(true);
                return a;
            } catch (IOException e) {
                throw this.f7273b.m5636a(e);
            } catch (Throwable th) {
                this.f7273b.m5640a(false);
            }
        }

        public void close() throws IOException {
            try {
                this.f7272a.close();
                this.f7273b.m5640a(true);
            } catch (IOException e) {
                throw this.f7273b.m5636a(e);
            } catch (Throwable th) {
                this.f7273b.m5640a(false);
            }
        }

        public C2201s m10161a() {
            return this.f7273b;
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f7272a + ")";
        }
    }

    /* renamed from: okio.a.a */
    private static final class C3328a extends Thread {
        public C3328a() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        public void run() {
            while (true) {
                try {
                    C2202a e = C2202a.m5635h();
                    if (e != null) {
                        e.m5639a();
                    }
                } catch (InterruptedException e2) {
                }
            }
        }
    }

    public final void m5641c() {
        if (this.f3535c) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long n_ = n_();
        boolean o_ = o_();
        if (n_ != 0 || o_) {
            this.f3535c = true;
            C2202a.m5631a(this, n_, o_);
        }
    }

    private static synchronized void m5631a(C2202a c2202a, long j, boolean z) {
        synchronized (C2202a.class) {
            if (f3534a == null) {
                f3534a = new C2202a();
                new C3328a().start();
            }
            long nanoTime = System.nanoTime();
            if (j != 0 && z) {
                c2202a.f3537e = Math.min(j, c2202a.m5628d() - nanoTime) + nanoTime;
            } else if (j != 0) {
                c2202a.f3537e = nanoTime + j;
            } else if (z) {
                c2202a.f3537e = c2202a.m5628d();
            } else {
                throw new AssertionError();
            }
            long b = c2202a.m5633b(nanoTime);
            C2202a c2202a2 = f3534a;
            while (c2202a2.f3536d != null && b >= c2202a2.f3536d.m5633b(nanoTime)) {
                c2202a2 = c2202a2.f3536d;
            }
            c2202a.f3536d = c2202a2.f3536d;
            c2202a2.f3536d = c2202a;
            if (c2202a2 == f3534a) {
                C2202a.class.notify();
            }
        }
    }

    public final boolean m_() {
        if (!this.f3535c) {
            return false;
        }
        this.f3535c = false;
        return C2202a.m5632a(this);
    }

    private static synchronized boolean m5632a(C2202a c2202a) {
        boolean z;
        synchronized (C2202a.class) {
            for (C2202a c2202a2 = f3534a; c2202a2 != null; c2202a2 = c2202a2.f3536d) {
                if (c2202a2.f3536d == c2202a) {
                    c2202a2.f3536d = c2202a.f3536d;
                    c2202a.f3536d = null;
                    z = false;
                    break;
                }
            }
            z = true;
        }
        return z;
    }

    private long m5633b(long j) {
        return this.f3537e - j;
    }

    protected void m5639a() {
    }

    public final C2071q m5637a(C2071q c2071q) {
        return new C33261(this, c2071q);
    }

    public final C2076r m5638a(C2076r c2076r) {
        return new C33272(this, c2076r);
    }

    final void m5640a(boolean z) throws IOException {
        if (m_() && z) {
            throw new InterruptedIOException("timeout");
        }
    }

    final IOException m5636a(IOException iOException) throws IOException {
        if (!m_()) {
            return iOException;
        }
        IOException interruptedIOException = new InterruptedIOException("timeout");
        interruptedIOException.initCause(iOException);
        return interruptedIOException;
    }

    private static synchronized C2202a m5635h() throws InterruptedException {
        C2202a c2202a = null;
        synchronized (C2202a.class) {
            C2202a c2202a2 = f3534a.f3536d;
            if (c2202a2 == null) {
                C2202a.class.wait();
            } else {
                long b = c2202a2.m5633b(System.nanoTime());
                if (b > 0) {
                    long j = b / 1000000;
                    C2202a.class.wait(j, (int) (b - (1000000 * j)));
                } else {
                    f3534a.f3536d = c2202a2.f3536d;
                    c2202a2.f3536d = null;
                    c2202a = c2202a2;
                }
            }
        }
        return c2202a;
    }
}
