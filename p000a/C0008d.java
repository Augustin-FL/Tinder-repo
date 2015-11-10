package p000a;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: a.d */
final class C0008d {
    private static final C0008d f13a;
    private final ExecutorService f14b;
    private final ScheduledExecutorService f15c;
    private final Executor f16d;

    /* renamed from: a.d.a */
    private static class C0007a implements Executor {
        private ThreadLocal<Integer> f12a;

        private C0007a() {
            this.f12a = new ThreadLocal();
        }

        private int m5a() {
            Integer num = (Integer) this.f12a.get();
            if (num == null) {
                num = Integer.valueOf(0);
            }
            int intValue = num.intValue() + 1;
            this.f12a.set(Integer.valueOf(intValue));
            return intValue;
        }

        private int m6b() {
            Integer num = (Integer) this.f12a.get();
            if (num == null) {
                num = Integer.valueOf(0);
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.f12a.remove();
            } else {
                this.f12a.set(Integer.valueOf(intValue));
            }
            return intValue;
        }

        public void execute(Runnable runnable) {
            if (m5a() <= 15) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    m6b();
                }
            } else {
                C0008d.m7a().execute(runnable);
            }
            m6b();
        }
    }

    static {
        f13a = new C0008d();
    }

    private static boolean m9c() {
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            return false;
        }
        return property.toLowerCase(Locale.US).contains("android");
    }

    private C0008d() {
        this.f14b = !C0008d.m9c() ? Executors.newCachedThreadPool() : C0002a.m0a();
        this.f15c = Executors.newSingleThreadScheduledExecutor();
        this.f16d = new C0007a();
    }

    public static ExecutorService m7a() {
        return f13a.f14b;
    }

    static Executor m8b() {
        return f13a.f16d;
    }
}
