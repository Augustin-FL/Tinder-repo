package io.fabric.sdk.android.services.concurrency.p004a;

/* renamed from: io.fabric.sdk.android.services.concurrency.a.e */
public class C3280e {
    private final int f7133a;
    private final C0385a f7134b;
    private final C3277d f7135c;

    public C3280e(C0385a c0385a, C3277d c3277d) {
        this(0, c0385a, c3277d);
    }

    public C3280e(int i, C0385a c0385a, C3277d c3277d) {
        this.f7133a = i;
        this.f7134b = c0385a;
        this.f7135c = c3277d;
    }

    public long m9992a() {
        return this.f7134b.m530a(this.f7133a);
    }

    public C3280e m9993b() {
        return new C3280e(this.f7133a + 1, this.f7134b, this.f7135c);
    }

    public C3280e m9994c() {
        return new C3280e(this.f7134b, this.f7135c);
    }
}
