package com.crashlytics.android.core;

import android.os.Looper;
import io.fabric.sdk.android.C3218c;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* renamed from: com.crashlytics.android.core.f */
class C0430f {
    private final ExecutorService f580a;

    /* renamed from: com.crashlytics.android.core.f.1 */
    class C04281 implements Runnable {
        final /* synthetic */ Runnable f576a;
        final /* synthetic */ C0430f f577b;

        C04281(C0430f c0430f, Runnable runnable) {
            this.f577b = c0430f;
            this.f576a = runnable;
        }

        public void run() {
            try {
                this.f576a.run();
            } catch (Throwable e) {
                C3218c.m9728h().m9695e("CrashlyticsCore", "Failed to execute task.", e);
            }
        }
    }

    /* renamed from: com.crashlytics.android.core.f.2 */
    class C04292 implements Callable<T> {
        final /* synthetic */ Callable f578a;
        final /* synthetic */ C0430f f579b;

        C04292(C0430f c0430f, Callable callable) {
            this.f579b = c0430f;
            this.f578a = callable;
        }

        public T call() throws Exception {
            try {
                return this.f578a.call();
            } catch (Throwable e) {
                C3218c.m9728h().m9695e("CrashlyticsCore", "Failed to execute task.", e);
                return null;
            }
        }
    }

    public C0430f(ExecutorService executorService) {
        this.f580a = executorService;
    }

    <T> T m707a(Callable<T> callable) {
        try {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                return this.f580a.submit(callable).get(4, TimeUnit.SECONDS);
            }
            return this.f580a.submit(callable).get();
        } catch (RejectedExecutionException e) {
            C3218c.m9728h().m9687a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        } catch (Throwable e2) {
            C3218c.m9728h().m9695e("CrashlyticsCore", "Failed to execute task.", e2);
            return null;
        }
    }

    Future<?> m708a(Runnable runnable) {
        try {
            return this.f580a.submit(new C04281(this, runnable));
        } catch (RejectedExecutionException e) {
            C3218c.m9728h().m9687a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }

    <T> Future<T> m709b(Callable<T> callable) {
        try {
            return this.f580a.submit(new C04292(this, callable));
        } catch (RejectedExecutionException e) {
            C3218c.m9728h().m9687a("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }
}
