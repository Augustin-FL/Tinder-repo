package io.fabric.sdk.android.services.concurrency;

import io.fabric.sdk.android.services.concurrency.AsyncTask.Status;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* renamed from: io.fabric.sdk.android.services.concurrency.c */
public abstract class C3223c<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> implements C0410a<C0412i>, C0411f, C0412i {
    private final C0413g f6984a;

    /* renamed from: io.fabric.sdk.android.services.concurrency.c.a */
    private static class C3284a<Result> implements Executor {
        private final Executor f7138a;
        private final C3223c f7139b;

        /* renamed from: io.fabric.sdk.android.services.concurrency.c.a.1 */
        class C32831 extends C3282e<Result> {
            final /* synthetic */ C3284a f7137a;

            C32831(C3284a c3284a, Runnable runnable, Object obj) {
                this.f7137a = c3284a;
                super(runnable, obj);
            }

            public <T extends C0410a<C0412i> & C0411f & C0412i> T m10006a() {
                return this.f7137a.f7139b;
            }
        }

        public C3284a(Executor executor, C3223c c3223c) {
            this.f7138a = executor;
            this.f7139b = c3223c;
        }

        public void execute(Runnable runnable) {
            this.f7138a.execute(new C32831(this, runnable, null));
        }
    }

    public /* synthetic */ void m9768c(Object obj) {
        m9762a((C0412i) obj);
    }

    public C3223c() {
        this.f6984a = new C0413g();
    }

    public final void m9764a(ExecutorService executorService, Params... paramsArr) {
        super.m9754a(new C3284a(executorService, this), (Object[]) paramsArr);
    }

    public int compareTo(Object obj) {
        return Priority.m9990a(this, obj);
    }

    public void m9762a(C0412i c0412i) {
        if (x_() != Status.PENDING) {
            throw new IllegalStateException("Must not add Dependency after task is running");
        }
        ((C0410a) ((C0411f) m9771g())).m632c(c0412i);
    }

    public Collection<C0412i> m9767c() {
        return ((C0410a) ((C0411f) m9771g())).m631c();
    }

    public boolean m9769d() {
        return ((C0410a) ((C0411f) m9771g())).m633d();
    }

    public Priority m9765b() {
        return ((C0411f) m9771g()).m634b();
    }

    public void m9766b(boolean z) {
        ((C0412i) ((C0411f) m9771g())).m636b(z);
    }

    public boolean m9770f() {
        return ((C0412i) ((C0411f) m9771g())).m637f();
    }

    public void m9763a(Throwable th) {
        ((C0412i) ((C0411f) m9771g())).m635a(th);
    }

    public <T extends C0410a<C0412i> & C0411f & C0412i> T m9771g() {
        return this.f6984a;
    }
}
