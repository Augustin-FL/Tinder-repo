package com.crashlytics.android.answers;

import java.util.Set;

/* renamed from: com.crashlytics.android.answers.m */
class C0388m implements C0383i {
    static final Set<Type> f456b;
    final int f457a;

    static {
        f456b = new SamplingEventFilter$1();
    }

    public C0388m(int i) {
        this.f457a = i;
    }

    public boolean m536a(SessionEvent sessionEvent) {
        boolean z;
        if (f456b.contains(sessionEvent.f403c) && sessionEvent.f401a.f474g == null) {
            z = true;
        } else {
            z = false;
        }
        boolean z2;
        if (Math.abs(sessionEvent.f401a.f470c.hashCode() % this.f457a) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && r3) {
            return true;
        }
        return false;
    }
}
