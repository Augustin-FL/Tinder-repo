package com.crashlytics.android.answers;

import android.annotation.SuppressLint;
import io.fabric.sdk.android.services.p035c.C3238c;

/* renamed from: com.crashlytics.android.answers.e */
class C0372e {
    private final C3238c f435a;

    public C0372e(C3238c c3238c) {
        this.f435a = c3238c;
    }

    @SuppressLint({"CommitPrefEdits"})
    public void m497a() {
        this.f435a.m9828a(this.f435a.m9829b().putBoolean("analytics_launched", true));
    }

    @SuppressLint({"CommitPrefEdits"})
    public boolean m498b() {
        return this.f435a.m9827a().getBoolean("analytics_launched", false);
    }
}
