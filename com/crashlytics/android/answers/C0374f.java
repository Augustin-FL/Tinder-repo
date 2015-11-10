package com.crashlytics.android.answers;

import io.fabric.sdk.android.services.concurrency.p004a.C3278b;
import io.fabric.sdk.android.services.concurrency.p004a.C3279c;
import io.fabric.sdk.android.services.concurrency.p004a.C3280e;
import io.fabric.sdk.android.services.p003b.C0373j;
import java.io.File;
import java.util.List;

/* renamed from: com.crashlytics.android.answers.f */
class C0374f implements C0373j {
    private final C0391o f436a;
    private final C0387l f437b;

    public static C0374f m500a(C0391o c0391o) {
        return new C0374f(c0391o, new C0387l(new C3280e(new C0386k(new C3279c(1000, 8), 0.1d), new C3278b(5))));
    }

    C0374f(C0391o c0391o, C0387l c0387l) {
        this.f436a = c0391o;
        this.f437b = c0387l;
    }

    public boolean m501a(List<File> list) {
        long nanoTime = System.nanoTime();
        if (!this.f437b.m534a(nanoTime)) {
            return false;
        }
        if (this.f436a.m554a(list)) {
            this.f437b.m533a();
            return true;
        }
        this.f437b.m535b(nanoTime);
        return false;
    }
}
