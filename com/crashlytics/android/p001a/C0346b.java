package com.crashlytics.android.p001a;

import android.annotation.TargetApi;
import android.app.Activity;
import io.fabric.sdk.android.C3211a;
import io.fabric.sdk.android.C3211a.C0344b;
import java.util.concurrent.ExecutorService;

@TargetApi(14)
/* renamed from: com.crashlytics.android.a.b */
class C0346b extends C0342a {
    private final C0344b f350a;
    private final ExecutorService f351b;

    /* renamed from: com.crashlytics.android.a.b.1 */
    class C03451 extends C0344b {
        final /* synthetic */ C0346b f349a;

        /* renamed from: com.crashlytics.android.a.b.1.1 */
        class C03431 implements Runnable {
            final /* synthetic */ C03451 f348a;

            C03431(C03451 c03451) {
                this.f348a = c03451;
            }

            public void run() {
                this.f348a.f349a.m390c();
            }
        }

        C03451(C0346b c0346b) {
            this.f349a = c0346b;
        }

        public void m399a(Activity activity) {
            if (this.f349a.m388a()) {
                this.f349a.f351b.submit(new C03431(this));
            }
        }
    }

    public C0346b(C3211a c3211a, ExecutorService executorService) {
        this.f350a = new C03451(this);
        this.f351b = executorService;
        c3211a.m9684a(this.f350a);
    }
}
