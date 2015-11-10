package com.crashlytics.android.answers;

import android.content.Context;
import com.crashlytics.android.answers.SessionEvent.C0361a;
import io.fabric.sdk.android.C0347h;
import io.fabric.sdk.android.C3218c;
import io.fabric.sdk.android.services.common.C3258l;
import io.fabric.sdk.android.services.network.C3295c;
import io.fabric.sdk.android.services.p003b.C0368g;
import io.fabric.sdk.android.services.settings.C3301b;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: com.crashlytics.android.answers.b */
class C0369b implements C0368g {
    final ScheduledExecutorService f425a;
    C0379q f426b;
    private final C0347h f427c;
    private final Context f428d;
    private final C0370c f429e;
    private final C0396t f430f;
    private final C3295c f431g;

    /* renamed from: com.crashlytics.android.answers.b.1 */
    class C03631 implements Runnable {
        final /* synthetic */ C3301b f416a;
        final /* synthetic */ String f417b;
        final /* synthetic */ C0369b f418c;

        C03631(C0369b c0369b, C3301b c3301b, String str) {
            this.f418c = c0369b;
            this.f416a = c3301b;
            this.f417b = str;
        }

        public void run() {
            try {
                this.f418c.f426b.m513a(this.f416a, this.f417b);
            } catch (Throwable e) {
                C3218c.m9728h().m9695e("Answers", "Failed to set analytics settings data", e);
            }
        }
    }

    /* renamed from: com.crashlytics.android.answers.b.2 */
    class C03642 implements Runnable {
        final /* synthetic */ C0369b f419a;

        C03642(C0369b c0369b) {
            this.f419a = c0369b;
        }

        public void run() {
            try {
                C0379q c0379q = this.f419a.f426b;
                this.f419a.f426b = new C0380g();
                c0379q.m503c();
            } catch (Throwable e) {
                C3218c.m9728h().m9695e("Answers", "Failed to disable events", e);
            }
        }
    }

    /* renamed from: com.crashlytics.android.answers.b.3 */
    class C03653 implements Runnable {
        final /* synthetic */ C0369b f420a;

        C03653(C0369b c0369b) {
            this.f420a = c0369b;
        }

        public void run() {
            try {
                this.f420a.f426b.m502b();
            } catch (Throwable e) {
                C3218c.m9728h().m9695e("Answers", "Failed to send events files", e);
            }
        }
    }

    /* renamed from: com.crashlytics.android.answers.b.4 */
    class C03664 implements Runnable {
        final /* synthetic */ C0369b f421a;

        C03664(C0369b c0369b) {
            this.f421a = c0369b;
        }

        public void run() {
            try {
                C0393r a = this.f421a.f430f.m565a();
                C0390n a2 = this.f421a.f429e.m489a();
                a2.m541a(this.f421a);
                this.f421a.f426b = new C0382h(this.f421a.f427c, this.f421a.f428d, this.f421a.f425a, a2, this.f421a.f431g, a);
            } catch (Throwable e) {
                C3218c.m9728h().m9695e("Answers", "Failed to enable events", e);
            }
        }
    }

    /* renamed from: com.crashlytics.android.answers.b.5 */
    class C03675 implements Runnable {
        final /* synthetic */ C0361a f422a;
        final /* synthetic */ boolean f423b;
        final /* synthetic */ C0369b f424c;

        C03675(C0369b c0369b, C0361a c0361a, boolean z) {
            this.f424c = c0369b;
            this.f422a = c0361a;
            this.f423b = z;
        }

        public void run() {
            try {
                this.f424c.f426b.m512a(this.f422a);
                if (this.f423b) {
                    this.f424c.f426b.m505e();
                }
            } catch (Throwable e) {
                C3218c.m9728h().m9695e("Answers", "Failed to process event", e);
            }
        }
    }

    public C0369b(C0347h c0347h, Context context, C0370c c0370c, C0396t c0396t, C3295c c3295c) {
        this(c0347h, context, c0370c, c0396t, c3295c, C3258l.m9941b("Answers Events Handler"));
    }

    C0369b(C0347h c0347h, Context context, C0370c c0370c, C0396t c0396t, C3295c c3295c, ScheduledExecutorService scheduledExecutorService) {
        this.f426b = new C0380g();
        this.f427c = c0347h;
        this.f428d = context;
        this.f429e = c0370c;
        this.f430f = c0396t;
        this.f431g = c3295c;
        this.f425a = scheduledExecutorService;
    }

    public void m482a(C0361a c0361a) {
        m483a(c0361a, false, false);
    }

    public void m487b(C0361a c0361a) {
        m483a(c0361a, false, true);
    }

    public void m488c(C0361a c0361a) {
        m483a(c0361a, true, false);
    }

    public void m484a(C3301b c3301b, String str) {
        m477b(new C03631(this, c3301b, str));
    }

    public void m481a() {
        m477b(new C03642(this));
    }

    public void m485a(String str) {
        m477b(new C03653(this));
    }

    public void m486b() {
        m477b(new C03664(this));
    }

    void m483a(C0361a c0361a, boolean z, boolean z2) {
        Runnable c03675 = new C03675(this, c0361a, z2);
        if (z) {
            m475a(c03675);
        } else {
            m477b(c03675);
        }
    }

    private void m475a(Runnable runnable) {
        try {
            this.f425a.submit(runnable).get();
        } catch (Throwable e) {
            C3218c.m9728h().m9695e("Answers", "Failed to run events task", e);
        }
    }

    private void m477b(Runnable runnable) {
        try {
            this.f425a.submit(runnable);
        } catch (Throwable e) {
            C3218c.m9728h().m9695e("Answers", "Failed to submit events task", e);
        }
    }
}
