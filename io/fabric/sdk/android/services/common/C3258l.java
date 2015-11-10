package io.fabric.sdk.android.services.common;

import io.fabric.sdk.android.C3218c;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: io.fabric.sdk.android.services.common.l */
public final class C3258l {

    /* renamed from: io.fabric.sdk.android.services.common.l.1 */
    static class C32561 implements ThreadFactory {
        final /* synthetic */ String f7078a;
        final /* synthetic */ AtomicLong f7079b;

        /* renamed from: io.fabric.sdk.android.services.common.l.1.1 */
        class C32551 extends C0478h {
            final /* synthetic */ Runnable f7076a;
            final /* synthetic */ C32561 f7077b;

            C32551(C32561 c32561, Runnable runnable) {
                this.f7077b = c32561;
                this.f7076a = runnable;
            }

            public void m9936a() {
                this.f7076a.run();
            }
        }

        C32561(String str, AtomicLong atomicLong) {
            this.f7078a = str;
            this.f7079b = atomicLong;
        }

        public Thread newThread(Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(new C32551(this, runnable));
            newThread.setName(this.f7078a + this.f7079b.getAndIncrement());
            return newThread;
        }
    }

    /* renamed from: io.fabric.sdk.android.services.common.l.2 */
    static class C32572 extends C0478h {
        final /* synthetic */ String f7080a;
        final /* synthetic */ ExecutorService f7081b;
        final /* synthetic */ long f7082c;
        final /* synthetic */ TimeUnit f7083d;

        C32572(String str, ExecutorService executorService, long j, TimeUnit timeUnit) {
            this.f7080a = str;
            this.f7081b = executorService;
            this.f7082c = j;
            this.f7083d = timeUnit;
        }

        public void m9937a() {
            try {
                C3218c.m9728h().m9687a("Fabric", "Executing shutdown hook for " + this.f7080a);
                this.f7081b.shutdown();
                if (!this.f7081b.awaitTermination(this.f7082c, this.f7083d)) {
                    C3218c.m9728h().m9687a("Fabric", this.f7080a + " did not shut down in the" + " allocated time. Requesting immediate shutdown.");
                    this.f7081b.shutdownNow();
                }
            } catch (InterruptedException e) {
                C3218c.m9728h().m9687a("Fabric", String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", new Object[]{this.f7080a}));
                this.f7081b.shutdownNow();
            }
        }
    }

    public static ExecutorService m9938a(String str) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(C3258l.m9942c(str));
        C3258l.m9939a(str, newSingleThreadExecutor);
        return newSingleThreadExecutor;
    }

    public static ScheduledExecutorService m9941b(String str) {
        Object newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(C3258l.m9942c(str));
        C3258l.m9939a(str, newSingleThreadScheduledExecutor);
        return newSingleThreadScheduledExecutor;
    }

    public static final ThreadFactory m9942c(String str) {
        return new C32561(str, new AtomicLong(1));
    }

    private static final void m9939a(String str, ExecutorService executorService) {
        C3258l.m9940a(str, executorService, 2, TimeUnit.SECONDS);
    }

    public static final void m9940a(String str, ExecutorService executorService, long j, TimeUnit timeUnit) {
        Runtime.getRuntime().addShutdownHook(new Thread(new C32572(str, executorService, j, timeUnit), "Crashlytics Shutdown Hook for " + str));
    }
}
