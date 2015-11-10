package io.fabric.sdk.android.services.common;

import android.os.Process;

/* renamed from: io.fabric.sdk.android.services.common.h */
public abstract class C0478h implements Runnable {
    protected abstract void m875a();

    public final void run() {
        Process.setThreadPriority(10);
        m875a();
    }
}
