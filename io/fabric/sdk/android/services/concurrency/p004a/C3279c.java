package io.fabric.sdk.android.services.concurrency.p004a;

/* renamed from: io.fabric.sdk.android.services.concurrency.a.c */
public class C3279c implements C0385a {
    private final long f7131a;
    private final int f7132b;

    public C3279c(long j, int i) {
        this.f7131a = j;
        this.f7132b = i;
    }

    public long m9991a(int i) {
        return (long) (((double) this.f7131a) * Math.pow((double) this.f7132b, (double) i));
    }
}
