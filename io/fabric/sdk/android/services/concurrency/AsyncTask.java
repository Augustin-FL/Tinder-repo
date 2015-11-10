package io.fabric.sdk.android.services.concurrency;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.Log;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public abstract class AsyncTask<Params, Progress, Result> {
    private static final int f6970a;
    public static final Executor f6971b;
    public static final Executor f6972c;
    private static final int f6973d;
    private static final int f6974e;
    private static final ThreadFactory f6975f;
    private static final BlockingQueue<Runnable> f6976g;
    private static final C3274b f6977h;
    private static volatile Executor f6978i;
    private final C3269d<Params, Result> f6979j;
    private final FutureTask<Result> f6980k;
    private volatile Status f6981l;
    private final AtomicBoolean f6982m;
    private final AtomicBoolean f6983n;

    /* renamed from: io.fabric.sdk.android.services.concurrency.AsyncTask.1 */
    static class C32681 implements ThreadFactory {
        private final AtomicInteger f7108a;

        C32681() {
            this.f7108a = new AtomicInteger(1);
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "AsyncTask #" + this.f7108a.getAndIncrement());
        }
    }

    /* renamed from: io.fabric.sdk.android.services.concurrency.AsyncTask.d */
    private static abstract class C3269d<Params, Result> implements Callable<Result> {
        Params[] f7109b;

        private C3269d() {
        }
    }

    /* renamed from: io.fabric.sdk.android.services.concurrency.AsyncTask.2 */
    class C32702 extends C3269d<Params, Result> {
        final /* synthetic */ AsyncTask f7110a;

        C32702(AsyncTask asyncTask) {
            this.f7110a = asyncTask;
            super();
        }

        public Result call() throws Exception {
            this.f7110a.f6983n.set(true);
            Process.setThreadPriority(10);
            return this.f7110a.m9752e(this.f7110a.m9755a(this.b));
        }
    }

    /* renamed from: io.fabric.sdk.android.services.concurrency.AsyncTask.3 */
    class C32713 extends FutureTask<Result> {
        final /* synthetic */ AsyncTask f7111a;

        C32713(AsyncTask asyncTask, Callable callable) {
            this.f7111a = asyncTask;
            super(callable);
        }

        protected void done() {
            try {
                this.f7111a.m9751d(get());
            } catch (Throwable e) {
                Log.w("AsyncTask", e);
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
            } catch (CancellationException e3) {
                this.f7111a.m9751d(null);
            }
        }
    }

    /* renamed from: io.fabric.sdk.android.services.concurrency.AsyncTask.4 */
    static /* synthetic */ class C32724 {
        static final /* synthetic */ int[] f7112a;

        static {
            f7112a = new int[Status.values().length];
            try {
                f7112a[Status.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f7112a[Status.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* renamed from: io.fabric.sdk.android.services.concurrency.AsyncTask.a */
    private static class C3273a<Data> {
        final AsyncTask f7117a;
        final Data[] f7118b;

        C3273a(AsyncTask asyncTask, Data... dataArr) {
            this.f7117a = asyncTask;
            this.f7118b = dataArr;
        }
    }

    /* renamed from: io.fabric.sdk.android.services.concurrency.AsyncTask.b */
    private static class C3274b extends Handler {
        public C3274b() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            C3273a c3273a = (C3273a) message.obj;
            switch (message.what) {
                case C3374b.SmoothProgressBar_spb_color /*1*/:
                    c3273a.f7117a.m9753f(c3273a.f7118b[0]);
                case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                    c3273a.f7117a.m9760b(c3273a.f7118b);
                default:
            }
        }
    }

    /* renamed from: io.fabric.sdk.android.services.concurrency.AsyncTask.c */
    private static class C3276c implements Executor {
        final LinkedList<Runnable> f7121a;
        Runnable f7122b;

        /* renamed from: io.fabric.sdk.android.services.concurrency.AsyncTask.c.1 */
        class C32751 implements Runnable {
            final /* synthetic */ Runnable f7119a;
            final /* synthetic */ C3276c f7120b;

            C32751(C3276c c3276c, Runnable runnable) {
                this.f7120b = c3276c;
                this.f7119a = runnable;
            }

            public void run() {
                try {
                    this.f7119a.run();
                } finally {
                    this.f7120b.m9979a();
                }
            }
        }

        private C3276c() {
            this.f7121a = new LinkedList();
        }

        public synchronized void execute(Runnable runnable) {
            this.f7121a.offer(new C32751(this, runnable));
            if (this.f7122b == null) {
                m9979a();
            }
        }

        protected synchronized void m9979a() {
            Runnable runnable = (Runnable) this.f7121a.poll();
            this.f7122b = runnable;
            if (runnable != null) {
                AsyncTask.f6971b.execute(this.f7122b);
            }
        }
    }

    protected abstract Result m9755a(Params... paramsArr);

    static {
        f6970a = Runtime.getRuntime().availableProcessors();
        f6973d = f6970a + 1;
        f6974e = (f6970a * 2) + 1;
        f6975f = new C32681();
        f6976g = new LinkedBlockingQueue(AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        f6971b = new ThreadPoolExecutor(f6973d, f6974e, 1, TimeUnit.SECONDS, f6976g, f6975f);
        f6972c = new C3276c();
        f6977h = new C3274b();
        f6978i = f6972c;
    }

    public AsyncTask() {
        this.f6981l = Status.PENDING;
        this.f6982m = new AtomicBoolean();
        this.f6983n = new AtomicBoolean();
        this.f6979j = new C32702(this);
        this.f6980k = new C32713(this, this.f6979j);
    }

    private void m9751d(Result result) {
        if (!this.f6983n.get()) {
            m9752e(result);
        }
    }

    private Result m9752e(Result result) {
        f6977h.obtainMessage(1, new C3273a(this, result)).sendToTarget();
        return result;
    }

    public final Status x_() {
        return this.f6981l;
    }

    protected void m9756a() {
    }

    protected void m9757a(Result result) {
    }

    protected void m9760b(Progress... progressArr) {
    }

    protected void m9759b(Result result) {
        y_();
    }

    protected void y_() {
    }

    public final boolean m9761e() {
        return this.f6982m.get();
    }

    public final boolean m9758a(boolean z) {
        this.f6982m.set(true);
        return this.f6980k.cancel(z);
    }

    public final AsyncTask<Params, Progress, Result> m9754a(Executor executor, Params... paramsArr) {
        if (this.f6981l != Status.PENDING) {
            switch (C32724.f7112a[this.f6981l.ordinal()]) {
                case C3374b.SmoothProgressBar_spb_color /*1*/:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.f6981l = Status.RUNNING;
        m9756a();
        this.f6979j.f7109b = paramsArr;
        executor.execute(this.f6980k);
        return this;
    }

    private void m9753f(Result result) {
        if (m9761e()) {
            m9759b((Object) result);
        } else {
            m9757a((Object) result);
        }
        this.f6981l = Status.FINISHED;
    }
}
