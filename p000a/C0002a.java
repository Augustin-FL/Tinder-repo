package p000a;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: a.a */
final class C0002a {
    static final int f0a;
    static final int f1b;
    private static final C0002a f2c;
    private static final int f3e;
    private final Executor f4d;

    /* renamed from: a.a.a */
    private static class C0001a implements Executor {
        private C0001a() {
        }

        public void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    static {
        f2c = new C0002a();
        f3e = Runtime.getRuntime().availableProcessors();
        f0a = f3e + 1;
        f1b = (f3e * 2) + 1;
    }

    private C0002a() {
        this.f4d = new C0001a();
    }

    public static ExecutorService m0a() {
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(f0a, f1b, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
        C0002a.m1a(threadPoolExecutor, true);
        return threadPoolExecutor;
    }

    @SuppressLint({"NewApi"})
    public static void m1a(ThreadPoolExecutor threadPoolExecutor, boolean z) {
        if (VERSION.SDK_INT >= 9) {
            threadPoolExecutor.allowCoreThreadTimeOut(z);
        }
    }

    public static Executor m2b() {
        return f2c.f4d;
    }
}
