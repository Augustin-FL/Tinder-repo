package com.crashlytics.android.answers;

import android.content.Context;
import com.crashlytics.android.answers.SessionEvent.C0361a;
import io.fabric.sdk.android.C0347h;
import io.fabric.sdk.android.C3218c;
import io.fabric.sdk.android.services.common.C3250g;
import io.fabric.sdk.android.services.network.C3295c;
import io.fabric.sdk.android.services.p003b.C0373j;
import io.fabric.sdk.android.services.p003b.C0381b;
import io.fabric.sdk.android.services.settings.C3301b;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: com.crashlytics.android.answers.h */
class C0382h extends C0381b<SessionEvent> implements C0379q<SessionEvent> {
    final C0393r f443a;
    C0383i f444b;
    C0373j f445c;
    C3250g f446d;
    boolean f447e;
    boolean f448f;
    private final C0347h f449l;
    private final C3295c f450m;

    public C0382h(C0347h c0347h, Context context, ScheduledExecutorService scheduledExecutorService, C0390n c0390n, C3295c c3295c, C0393r c0393r) {
        super(context, scheduledExecutorService, c0390n);
        this.f444b = new C0384j();
        this.f446d = new C3250g();
        this.f447e = true;
        this.f448f = true;
        this.f449l = c0347h;
        this.f450m = c3295c;
        this.f443a = c0393r;
    }

    public C0373j m525a() {
        return this.f445c;
    }

    public void m527a(C3301b c3301b, String str) {
        this.f445c = C0374f.m500a(new C0391o(this.f449l, str, c3301b.f7184a, this.f450m, this.f446d.m9930a(this.g)));
        ((C0390n) this.h).m551a(c3301b);
        this.f447e = c3301b.f7189f;
        C3218c.m9728h().m9687a("Answers", "Custom event tracking " + (this.f447e ? "enabled" : "disabled"));
        this.f448f = c3301b.f7190g;
        C3218c.m9728h().m9687a("Answers", "Predefined event tracking " + (this.f448f ? "enabled" : "disabled"));
        if (c3301b.f7191h > 1) {
            C3218c.m9728h().m9687a("Answers", "Event sampling enabled");
            this.f444b = new C0388m(c3301b.f7191h);
        }
        m516a(c3301b.f7185b);
    }

    public void m526a(C0361a c0361a) {
        SessionEvent a = c0361a.m458a(this.f443a);
        if (!this.f447e && Type.CUSTOM.equals(a.f403c)) {
            C3218c.m9728h().m9687a("Answers", "Custom events tracking disabled - skipping event: " + a);
        } else if (!this.f448f && Type.PREDEFINED.equals(a.f403c)) {
            C3218c.m9728h().m9687a("Answers", "Predefined events tracking disabled - skipping event: " + a);
        } else if (this.f444b.m528a(a)) {
            C3218c.m9728h().m9687a("Answers", "Skipping filtered event: " + a);
        } else {
            m518a((Object) a);
        }
    }
}
