package io.fabric.sdk.android.services.concurrency;

public enum Priority {
    LOW,
    NORMAL,
    HIGH,
    IMMEDIATE;

    static <Y> int m9990a(C0411f c0411f, Y y) {
        Priority b;
        if (y instanceof C0411f) {
            b = ((C0411f) y).m634b();
        } else {
            b = NORMAL;
        }
        return b.ordinal() - c0411f.m634b().ordinal();
    }
}
