package io.fabric.sdk.android.services.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: io.fabric.sdk.android.services.concurrency.h */
public class C3286h extends ThreadPoolExecutor {
    private static final int f7141a;
    private static final int f7142b;
    private static final int f7143c;

    /* renamed from: io.fabric.sdk.android.services.concurrency.h.a */
    protected static final class C3285a implements ThreadFactory {
        private final int f7140a;

        public C3285a(int i) {
            this.f7140a = i;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setPriority(this.f7140a);
            thread.setName("Queue");
            return thread;
        }
    }

    public /* synthetic */ BlockingQueue getQueue() {
        return m10010b();
    }

    static {
        f7141a = Runtime.getRuntime().availableProcessors();
        f7142b = f7141a + 1;
        f7143c = (f7141a * 2) + 1;
    }

    <T extends Runnable & C0410a & C0412i & C0411f> C3286h(int i, int i2, long j, TimeUnit timeUnit, DependencyPriorityBlockingQueue<T> dependencyPriorityBlockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, dependencyPriorityBlockingQueue, threadFactory);
        prestartAllCoreThreads();
    }

    public static <T extends Runnable & C0410a & C0412i & C0411f> C3286h m10009a(int i, int i2) {
        return new C3286h(i, i2, 1, TimeUnit.SECONDS, new DependencyPriorityBlockingQueue(), new C3285a(10));
    }

    public static C3286h m10008a() {
        return C3286h.m10009a(f7142b, f7143c);
    }

    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new C3282e(runnable, t);
    }

    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new C3282e(callable);
    }

    public void execute(Runnable runnable) {
        if (C0413g.m638a((Object) runnable)) {
            super.execute(runnable);
        } else {
            super.execute(newTaskFor(runnable, null));
        }
    }

    protected void afterExecute(Runnable runnable, Throwable th) {
        C0412i c0412i = (C0412i) runnable;
        c0412i.m636b(true);
        c0412i.m635a(th);
        m10010b().m9989d();
        super.afterExecute(runnable, th);
    }

    public DependencyPriorityBlockingQueue m10010b() {
        return (DependencyPriorityBlockingQueue) super.getQueue();
    }
}
