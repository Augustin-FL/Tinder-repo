package io.fabric.sdk.android.services.common;

import android.os.SystemClock;
import android.util.Log;

/* renamed from: io.fabric.sdk.android.services.common.q */
public class C3267q {
    private final String f7103a;
    private final String f7104b;
    private final boolean f7105c;
    private long f7106d;
    private long f7107e;

    public C3267q(String str, String str2) {
        this.f7103a = str;
        this.f7104b = str2;
        this.f7105c = !Log.isLoggable(str2, 2);
    }

    public synchronized void m9977a() {
        if (!this.f7105c) {
            this.f7106d = SystemClock.elapsedRealtime();
            this.f7107e = 0;
        }
    }

    public synchronized void m9978b() {
        if (!this.f7105c) {
            if (this.f7107e == 0) {
                this.f7107e = SystemClock.elapsedRealtime() - this.f7106d;
                m9976c();
            }
        }
    }

    private void m9976c() {
        Log.v(this.f7104b, this.f7103a + ": " + this.f7107e + "ms");
    }
}
