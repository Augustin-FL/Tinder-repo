package com.facebook.stetho.common.android;

import android.os.Handler;
import android.os.Looper;

public final class HandlerUtil {

    private static final class WaitableRunnable implements Runnable {
        private boolean mIsDone;
        private final Runnable mRunnable;

        public WaitableRunnable(Runnable runnable) {
            this.mRunnable = runnable;
        }

        public void run() {
            try {
                this.mRunnable.run();
                synchronized (this) {
                    this.mIsDone = true;
                    notifyAll();
                }
            } catch (Throwable th) {
                synchronized (this) {
                }
                this.mIsDone = true;
                notifyAll();
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void join() {
            /*
            r1 = this;
            monitor-enter(r1);
        L_0x0001:
            r0 = r1.mIsDone;	 Catch:{ all -> 0x000d }
            if (r0 != 0) goto L_0x000b;
        L_0x0005:
            r1.wait();	 Catch:{ InterruptedException -> 0x0009 }
            goto L_0x0001;
        L_0x0009:
            r0 = move-exception;
            goto L_0x0001;
        L_0x000b:
            monitor-exit(r1);	 Catch:{ all -> 0x000d }
            return;
        L_0x000d:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x000d }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.common.android.HandlerUtil.WaitableRunnable.join():void");
        }
    }

    private HandlerUtil() {
    }

    public static boolean postAndWait(Handler handler, Runnable runnable) {
        if (Looper.myLooper() == handler.getLooper()) {
            runnable.run();
            return true;
        }
        Object waitableRunnable = new WaitableRunnable(runnable);
        if (!handler.post(waitableRunnable)) {
            return false;
        }
        waitableRunnable.join();
        return true;
    }
}
