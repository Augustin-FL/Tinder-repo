package com.squareup.okhttp.internal.spdy;

import java.util.concurrent.CountDownLatch;

/* renamed from: com.squareup.okhttp.internal.spdy.i */
public final class C2179i {
    private final CountDownLatch f3438a;
    private long f3439b;
    private long f3440c;

    C2179i() {
        this.f3438a = new CountDownLatch(1);
        this.f3439b = -1;
        this.f3440c = -1;
    }

    void m5487a() {
        if (this.f3439b != -1) {
            throw new IllegalStateException();
        }
        this.f3439b = System.nanoTime();
    }

    void m5488b() {
        if (this.f3440c != -1 || this.f3439b == -1) {
            throw new IllegalStateException();
        }
        this.f3440c = System.nanoTime();
        this.f3438a.countDown();
    }

    void m5489c() {
        if (this.f3440c != -1 || this.f3439b == -1) {
            throw new IllegalStateException();
        }
        this.f3440c = this.f3439b - 1;
        this.f3438a.countDown();
    }
}
