package com.crashlytics.android.answers;

import io.fabric.sdk.android.services.concurrency.p004a.C0385a;
import java.util.Random;

/* renamed from: com.crashlytics.android.answers.k */
class C0386k implements C0385a {
    final C0385a f451a;
    final Random f452b;
    final double f453c;

    public C0386k(C0385a c0385a, double d) {
        this(c0385a, d, new Random());
    }

    public C0386k(C0385a c0385a, double d, Random random) {
        if (d < 0.0d || d > 1.0d) {
            throw new IllegalArgumentException("jitterPercent must be between 0.0 and 1.0");
        } else if (c0385a == null) {
            throw new NullPointerException("backoff must not be null");
        } else if (random == null) {
            throw new NullPointerException("random must not be null");
        } else {
            this.f451a = c0385a;
            this.f453c = d;
            this.f452b = random;
        }
    }

    public long m532a(int i) {
        return (long) (m531a() * ((double) this.f451a.m530a(i)));
    }

    double m531a() {
        double d = 1.0d - this.f453c;
        return d + (((this.f453c + 1.0d) - d) * this.f452b.nextDouble());
    }
}
