package p000a;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* renamed from: a.g */
public class C0019g<TResult> {
    public static final ExecutorService f43a;
    public static final Executor f44b;
    private static final Executor f45c;
    private final Object f46d;
    private boolean f47e;
    private boolean f48f;
    private TResult f49g;
    private Exception f50h;
    private List<C0010f<TResult, Void>> f51i;

    /* renamed from: a.g.1 */
    static class C00111 implements Runnable {
        final /* synthetic */ C0018a f19a;

        public void run() {
            this.f19a.m19b(null);
        }
    }

    /* renamed from: a.g.2 */
    class C00122 implements C0010f<TResult, Void> {
        final /* synthetic */ C0018a f20a;
        final /* synthetic */ C0010f f21b;
        final /* synthetic */ Executor f22c;
        final /* synthetic */ C0009e f23d;
        final /* synthetic */ C0019g f24e;

        C00122(C0019g c0019g, C0018a c0018a, C0010f c0010f, Executor executor, C0009e c0009e) {
            this.f24e = c0019g;
            this.f20a = c0018a;
            this.f21b = c0010f;
            this.f22c = executor;
            this.f23d = c0009e;
        }

        public /* synthetic */ Object then(C0019g c0019g) throws Exception {
            return m11a(c0019g);
        }

        public Void m11a(C0019g<TResult> c0019g) {
            C0019g.m35d(this.f20a, this.f21b, c0019g, this.f22c, this.f23d);
            return null;
        }
    }

    /* renamed from: a.g.3 */
    class C00133 implements C0010f<TResult, C0019g<TContinuationResult>> {
        final /* synthetic */ C0009e f25a;
        final /* synthetic */ C0010f f26b;
        final /* synthetic */ C0019g f27c;

        C00133(C0019g c0019g, C0009e c0009e, C0010f c0010f) {
            this.f27c = c0019g;
            this.f25a = c0009e;
            this.f26b = c0010f;
        }

        public /* synthetic */ Object then(C0019g c0019g) throws Exception {
            return m12a(c0019g);
        }

        public C0019g<TContinuationResult> m12a(C0019g<TResult> c0019g) {
            if (this.f25a != null && this.f25a.m10a()) {
                return C0019g.m36g();
            }
            if (c0019g.m46d()) {
                return C0019g.m23a(c0019g.m48f());
            }
            if (c0019g.m45c()) {
                return C0019g.m36g();
            }
            return c0019g.m38a(this.f26b);
        }
    }

    /* renamed from: a.g.4 */
    static class C00144 implements Runnable {
        final /* synthetic */ C0009e f28a;
        final /* synthetic */ C0018a f29b;
        final /* synthetic */ C0010f f30c;
        final /* synthetic */ C0019g f31d;

        C00144(C0009e c0009e, C0018a c0018a, C0010f c0010f, C0019g c0019g) {
            this.f28a = c0009e;
            this.f29b = c0018a;
            this.f30c = c0010f;
            this.f31d = c0019g;
        }

        public void run() {
            if (this.f28a == null || !this.f28a.m10a()) {
                try {
                    this.f29b.m19b(this.f30c.then(this.f31d));
                    return;
                } catch (CancellationException e) {
                    this.f29b.m21c();
                    return;
                } catch (Exception e2) {
                    this.f29b.m18b(e2);
                    return;
                }
            }
            this.f29b.m21c();
        }
    }

    /* renamed from: a.g.5 */
    static class C00165 implements Runnable {
        final /* synthetic */ C0009e f33a;
        final /* synthetic */ C0018a f34b;
        final /* synthetic */ C0010f f35c;
        final /* synthetic */ C0019g f36d;

        /* renamed from: a.g.5.1 */
        class C00151 implements C0010f<TContinuationResult, Void> {
            final /* synthetic */ C00165 f32a;

            C00151(C00165 c00165) {
                this.f32a = c00165;
            }

            public /* synthetic */ Object then(C0019g c0019g) throws Exception {
                return m13a(c0019g);
            }

            public Void m13a(C0019g<TContinuationResult> c0019g) {
                if (this.f32a.f33a != null && this.f32a.f33a.m10a()) {
                    this.f32a.f34b.m21c();
                } else if (c0019g.m45c()) {
                    this.f32a.f34b.m21c();
                } else if (c0019g.m46d()) {
                    this.f32a.f34b.m18b(c0019g.m48f());
                } else {
                    this.f32a.f34b.m19b(c0019g.m47e());
                }
                return null;
            }
        }

        C00165(C0009e c0009e, C0018a c0018a, C0010f c0010f, C0019g c0019g) {
            this.f33a = c0009e;
            this.f34b = c0018a;
            this.f35c = c0010f;
            this.f36d = c0019g;
        }

        public void run() {
            if (this.f33a == null || !this.f33a.m10a()) {
                try {
                    C0019g c0019g = (C0019g) this.f35c.then(this.f36d);
                    if (c0019g == null) {
                        this.f34b.m19b(null);
                        return;
                    } else {
                        c0019g.m38a(new C00151(this));
                        return;
                    }
                } catch (CancellationException e) {
                    this.f34b.m21c();
                    return;
                } catch (Exception e2) {
                    this.f34b.m18b(e2);
                    return;
                }
            }
            this.f34b.m21c();
        }
    }

    /* renamed from: a.g.6 */
    class C00176 implements C0010f<TResult, Void> {
        final /* synthetic */ C0018a f37a;
        final /* synthetic */ C0010f f38b;
        final /* synthetic */ Executor f39c;
        final /* synthetic */ C0009e f40d;
        final /* synthetic */ C0019g f41e;

        C00176(C0019g c0019g, C0018a c0018a, C0010f c0010f, Executor executor, C0009e c0009e) {
            this.f41e = c0019g;
            this.f37a = c0018a;
            this.f38b = c0010f;
            this.f39c = executor;
            this.f40d = c0009e;
        }

        public /* synthetic */ Object then(C0019g c0019g) throws Exception {
            return m14a(c0019g);
        }

        public Void m14a(C0019g<TResult> c0019g) {
            C0019g.m33c(this.f37a, this.f38b, c0019g, this.f39c, this.f40d);
            return null;
        }
    }

    /* renamed from: a.g.a */
    public class C0018a {
        final /* synthetic */ C0019g f42a;

        private C0018a(C0019g c0019g) {
            this.f42a = c0019g;
        }

        public C0019g<TResult> m15a() {
            return this.f42a;
        }

        public boolean m20b() {
            boolean z = true;
            synchronized (this.f42a.f46d) {
                if (this.f42a.f47e) {
                    z = false;
                } else {
                    this.f42a.f47e = true;
                    this.f42a.f48f = true;
                    this.f42a.f46d.notifyAll();
                    this.f42a.m37h();
                }
            }
            return z;
        }

        public boolean m17a(TResult tResult) {
            boolean z = true;
            synchronized (this.f42a.f46d) {
                if (this.f42a.f47e) {
                    z = false;
                } else {
                    this.f42a.f47e = true;
                    this.f42a.f49g = tResult;
                    this.f42a.f46d.notifyAll();
                    this.f42a.m37h();
                }
            }
            return z;
        }

        public boolean m16a(Exception exception) {
            boolean z = true;
            synchronized (this.f42a.f46d) {
                if (this.f42a.f47e) {
                    z = false;
                } else {
                    this.f42a.f47e = true;
                    this.f42a.f50h = exception;
                    this.f42a.f46d.notifyAll();
                    this.f42a.m37h();
                }
            }
            return z;
        }

        public void m21c() {
            if (!m20b()) {
                throw new IllegalStateException("Cannot cancel a completed task.");
            }
        }

        public void m19b(TResult tResult) {
            if (!m17a((Object) tResult)) {
                throw new IllegalStateException("Cannot set the result of a completed task.");
            }
        }

        public void m18b(Exception exception) {
            if (!m16a(exception)) {
                throw new IllegalStateException("Cannot set the error on a completed task.");
            }
        }
    }

    static {
        f43a = C0008d.m7a();
        f45c = C0008d.m8b();
        f44b = C0002a.m2b();
    }

    private C0019g() {
        this.f46d = new Object();
        this.f51i = new ArrayList();
    }

    public static <TResult> C0018a m22a() {
        C0019g c0019g = new C0019g();
        c0019g.getClass();
        return new C0018a(null);
    }

    public boolean m43b() {
        boolean z;
        synchronized (this.f46d) {
            z = this.f47e;
        }
        return z;
    }

    public boolean m45c() {
        boolean z;
        synchronized (this.f46d) {
            z = this.f48f;
        }
        return z;
    }

    public boolean m46d() {
        boolean z;
        synchronized (this.f46d) {
            z = this.f50h != null;
        }
        return z;
    }

    public TResult m47e() {
        TResult tResult;
        synchronized (this.f46d) {
            tResult = this.f49g;
        }
        return tResult;
    }

    public Exception m48f() {
        Exception exception;
        synchronized (this.f46d) {
            exception = this.f50h;
        }
        return exception;
    }

    public static <TResult> C0019g<TResult> m24a(TResult tResult) {
        C0018a a = C0019g.m22a();
        a.m19b((Object) tResult);
        return a.m15a();
    }

    public static <TResult> C0019g<TResult> m23a(Exception exception) {
        C0018a a = C0019g.m22a();
        a.m18b(exception);
        return a.m15a();
    }

    public static <TResult> C0019g<TResult> m36g() {
        C0018a a = C0019g.m22a();
        a.m21c();
        return a.m15a();
    }

    public <TContinuationResult> C0019g<TContinuationResult> m40a(C0010f<TResult, TContinuationResult> c0010f, Executor executor, C0009e c0009e) {
        C0018a a = C0019g.m22a();
        synchronized (this.f46d) {
            boolean b = m43b();
            if (!b) {
                this.f51i.add(new C00176(this, a, c0010f, executor, c0009e));
            }
        }
        if (b) {
            C0019g.m33c(a, c0010f, this, executor, c0009e);
        }
        return a.m15a();
    }

    public <TContinuationResult> C0019g<TContinuationResult> m38a(C0010f<TResult, TContinuationResult> c0010f) {
        return m40a(c0010f, f45c, null);
    }

    public <TContinuationResult> C0019g<TContinuationResult> m39a(C0010f<TResult, C0019g<TContinuationResult>> c0010f, Executor executor) {
        return m42b(c0010f, executor, null);
    }

    public <TContinuationResult> C0019g<TContinuationResult> m42b(C0010f<TResult, C0019g<TContinuationResult>> c0010f, Executor executor, C0009e c0009e) {
        C0018a a = C0019g.m22a();
        synchronized (this.f46d) {
            boolean b = m43b();
            if (!b) {
                this.f51i.add(new C00122(this, a, c0010f, executor, c0009e));
            }
        }
        if (b) {
            C0019g.m35d(a, c0010f, this, executor, c0009e);
        }
        return a.m15a();
    }

    public <TContinuationResult> C0019g<TContinuationResult> m44c(C0010f<TResult, TContinuationResult> c0010f, Executor executor, C0009e c0009e) {
        return m39a(new C00133(this, c0009e, c0010f), executor);
    }

    public <TContinuationResult> C0019g<TContinuationResult> m41b(C0010f<TResult, TContinuationResult> c0010f) {
        return m44c(c0010f, f45c, null);
    }

    private static <TContinuationResult, TResult> void m33c(C0018a c0018a, C0010f<TResult, TContinuationResult> c0010f, C0019g<TResult> c0019g, Executor executor, C0009e c0009e) {
        executor.execute(new C00144(c0009e, c0018a, c0010f, c0019g));
    }

    private static <TContinuationResult, TResult> void m35d(C0018a c0018a, C0010f<TResult, C0019g<TContinuationResult>> c0010f, C0019g<TResult> c0019g, Executor executor, C0009e c0009e) {
        executor.execute(new C00165(c0009e, c0018a, c0010f, c0019g));
    }

    private void m37h() {
        synchronized (this.f46d) {
            for (C0010f then : this.f51i) {
                try {
                    then.then(this);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Throwable e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.f51i = null;
        }
    }
}
