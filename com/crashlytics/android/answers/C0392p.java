package com.crashlytics.android.answers;

import android.app.Activity;
import android.os.Looper;
import io.fabric.sdk.android.C3218c;
import io.fabric.sdk.android.services.settings.C3301b;

/* renamed from: com.crashlytics.android.answers.p */
class C0392p {
    final C0369b f467a;

    public C0392p(C0369b c0369b) {
        this.f467a = c0369b;
    }

    public void m558a(String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("onCrash called from main thread!!!");
        }
        C3218c.m9728h().m9687a("Answers", "Logged crash");
        this.f467a.m488c(SessionEvent.m462b(str));
    }

    public void m560b(String str) {
        C3218c.m9728h().m9687a("Answers", "Logged error");
        this.f467a.m482a(SessionEvent.m461a(str));
    }

    public void m555a() {
        C3218c.m9728h().m9687a("Answers", "Logged install");
        this.f467a.m487b(SessionEvent.m459a());
    }

    public void m556a(Activity activity, Type type) {
        C3218c.m9728h().m9687a("Answers", "Logged lifecycle event: " + type.name());
        this.f467a.m482a(SessionEvent.m460a(type, activity));
    }

    public void m557a(C3301b c3301b, String str) {
        this.f467a.m484a(c3301b, str);
    }

    public void m559b() {
        this.f467a.m481a();
    }
}
