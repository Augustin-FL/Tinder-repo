package com.google.common.util.concurrent;

import com.google.common.base.C1650g;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public abstract class AbstractFuture<V> implements C1908e<V> {
    private final Sync<V> f2571a;
    private final C1913c f2572b;

    static final class Sync<V> extends AbstractQueuedSynchronizer {
        private static final long serialVersionUID = 0;
        private V f2569a;
        private Throwable f2570b;

        Sync() {
        }

        protected int tryAcquireShared(int i) {
            if (m4455b()) {
                return 1;
            }
            return -1;
        }

        protected boolean tryReleaseShared(int i) {
            setState(i);
            return true;
        }

        V m4451a(long j) throws TimeoutException, CancellationException, ExecutionException, InterruptedException {
            if (tryAcquireSharedNanos(-1, j)) {
                return m4449d();
            }
            throw new TimeoutException("Timeout waiting for task.");
        }

        V m4450a() throws CancellationException, ExecutionException, InterruptedException {
            acquireSharedInterruptibly(-1);
            return m4449d();
        }

        private V m4449d() throws CancellationException, ExecutionException {
            int state = getState();
            switch (state) {
                case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                    if (this.f2570b == null) {
                        return this.f2569a;
                    }
                    throw new ExecutionException(this.f2570b);
                case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                case C3374b.SmoothProgressBar_spb_interpolator /*8*/:
                    throw AbstractFuture.m4458a("Task was cancelled.", this.f2570b);
                default:
                    throw new IllegalStateException("Error, synchronizer in invalid state: " + state);
            }
        }

        boolean m4455b() {
            return (getState() & 14) != 0;
        }

        boolean m4456c() {
            return (getState() & 12) != 0;
        }

        boolean m4452a(V v) {
            return m4448a(v, null, 2);
        }

        boolean m4453a(Throwable th) {
            return m4448a(null, th, 2);
        }

        boolean m4454a(boolean z) {
            return m4448a(null, null, z ? 8 : 4);
        }

        private boolean m4448a(V v, Throwable th, int i) {
            boolean compareAndSetState = compareAndSetState(0, 1);
            if (compareAndSetState) {
                this.f2569a = v;
                if ((i & 12) != 0) {
                    th = new CancellationException("Future.cancel() was called.");
                }
                this.f2570b = th;
                releaseShared(i);
            } else if (getState() == 1) {
                acquireShared(-1);
            }
            return compareAndSetState;
        }
    }

    protected AbstractFuture() {
        this.f2571a = new Sync();
        this.f2572b = new C1913c();
    }

    public V get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        return this.f2571a.m4451a(timeUnit.toNanos(j));
    }

    public V get() throws InterruptedException, ExecutionException {
        return this.f2571a.m4450a();
    }

    public boolean isDone() {
        return this.f2571a.m4455b();
    }

    public boolean isCancelled() {
        return this.f2571a.m4456c();
    }

    public boolean cancel(boolean z) {
        if (!this.f2571a.m4454a(z)) {
            return false;
        }
        this.f2572b.m4468a();
        if (z) {
            m4459a();
        }
        return true;
    }

    protected void m4459a() {
    }

    public void m4460a(Runnable runnable, Executor executor) {
        this.f2572b.m4469a(runnable, executor);
    }

    protected boolean m4461a(V v) {
        boolean a = this.f2571a.m4452a((Object) v);
        if (a) {
            this.f2572b.m4468a();
        }
        return a;
    }

    protected boolean m4462a(Throwable th) {
        boolean a = this.f2571a.m4453a((Throwable) C1650g.m3080a((Object) th));
        if (a) {
            this.f2572b.m4468a();
        }
        if (!(th instanceof Error)) {
            return a;
        }
        throw ((Error) th);
    }

    static final CancellationException m4458a(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }
}
