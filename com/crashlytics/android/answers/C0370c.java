package com.crashlytics.android.answers;

import android.content.Context;
import android.os.Looper;
import io.fabric.sdk.android.services.common.C3266p;
import io.fabric.sdk.android.services.p003b.C3234k;
import io.fabric.sdk.android.services.p035c.C3236a;
import java.io.IOException;

/* renamed from: com.crashlytics.android.answers.c */
class C0370c {
    final Context f432a;
    final C3236a f433b;

    public C0370c(Context context, C3236a c3236a) {
        this.f432a = context;
        this.f433b = c3236a;
    }

    public C0390n m489a() throws IOException {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("AnswersFilesManagerProvider cannot be called on the main thread");
        }
        return new C0390n(this.f432a, new C0395s(), new C3266p(), new C3234k(this.f432a, this.f433b.m9824a(), "session_analytics.tap", "session_analytics_to_send"));
    }
}
