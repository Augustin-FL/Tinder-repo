package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* renamed from: okio.i */
public class C3336i extends C2201s {
    private C2201s f7284a;

    public C3336i(C2201s c2201s) {
        if (c2201s == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f7284a = c2201s;
    }

    public final C2201s m10258a() {
        return this.f7284a;
    }

    public final C3336i m10257a(C2201s c2201s) {
        if (c2201s == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f7284a = c2201s;
        return this;
    }

    public C2201s m10260a(long j, TimeUnit timeUnit) {
        return this.f7284a.m5627a(j, timeUnit);
    }

    public long n_() {
        return this.f7284a.n_();
    }

    public boolean o_() {
        return this.f7284a.o_();
    }

    public long m10261d() {
        return this.f7284a.m5628d();
    }

    public C2201s m10259a(long j) {
        return this.f7284a.m5626a(j);
    }

    public C2201s p_() {
        return this.f7284a.p_();
    }

    public C2201s m10262f() {
        return this.f7284a.m5629f();
    }

    public void m10263g() throws IOException {
        this.f7284a.m5630g();
    }
}
