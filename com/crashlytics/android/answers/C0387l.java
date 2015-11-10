package com.crashlytics.android.answers;

import io.fabric.sdk.android.services.concurrency.p004a.C3280e;

/* renamed from: com.crashlytics.android.answers.l */
class C0387l {
    long f454a;
    private C3280e f455b;

    public C0387l(C3280e c3280e) {
        if (c3280e == null) {
            throw new NullPointerException("retryState must not be null");
        }
        this.f455b = c3280e;
    }

    public boolean m534a(long j) {
        return j - this.f454a >= 1000000 * this.f455b.m9992a();
    }

    public void m535b(long j) {
        this.f454a = j;
        this.f455b = this.f455b.m9993b();
    }

    public void m533a() {
        this.f454a = 0;
        this.f455b = this.f455b.m9994c();
    }
}
