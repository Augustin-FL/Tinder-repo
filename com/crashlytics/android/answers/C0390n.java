package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.services.common.C3254j;
import io.fabric.sdk.android.services.p003b.C0389d;
import io.fabric.sdk.android.services.p003b.C3232f;
import io.fabric.sdk.android.services.settings.C3301b;
import java.io.IOException;
import java.util.UUID;

/* renamed from: com.crashlytics.android.answers.n */
class C0390n extends C0389d<SessionEvent> {
    private C3301b f465g;

    C0390n(Context context, C0395s c0395s, C3254j c3254j, C3232f c3232f) throws IOException {
        super(context, c0395s, c3254j, c3232f, 100);
    }

    protected String m550a() {
        return "sa" + "_" + UUID.randomUUID().toString() + "_" + this.c.m9935a() + ".tap";
    }

    protected int m552b() {
        return this.f465g == null ? super.m544b() : this.f465g.f7188e;
    }

    protected int m553c() {
        return this.f465g == null ? super.m545c() : this.f465g.f7186c;
    }

    void m551a(C3301b c3301b) {
        this.f465g = c3301b;
    }
}
