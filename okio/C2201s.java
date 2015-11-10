package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* renamed from: okio.s */
public class C2201s {
    public static final C2201s f3530b;
    private boolean f3531a;
    private long f3532c;
    private long f3533d;

    /* renamed from: okio.s.1 */
    static class C33491 extends C2201s {
        C33491() {
        }

        public C2201s m10336a(long j, TimeUnit timeUnit) {
            return this;
        }

        public C2201s m10335a(long j) {
            return this;
        }

        public void m10337g() throws IOException {
        }
    }

    static {
        f3530b = new C33491();
    }

    public C2201s m5627a(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0: " + j);
        } else if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        } else {
            this.f3533d = timeUnit.toNanos(j);
            return this;
        }
    }

    public long n_() {
        return this.f3533d;
    }

    public boolean o_() {
        return this.f3531a;
    }

    public long m5628d() {
        if (this.f3531a) {
            return this.f3532c;
        }
        throw new IllegalStateException("No deadline");
    }

    public C2201s m5626a(long j) {
        this.f3531a = true;
        this.f3532c = j;
        return this;
    }

    public C2201s p_() {
        this.f3533d = 0;
        return this;
    }

    public C2201s m5629f() {
        this.f3531a = false;
        return this;
    }

    public void m5630g() throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        } else if (this.f3531a && this.f3532c - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
