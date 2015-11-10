package com.crashlytics.android.answers;

import android.app.Activity;
import android.os.Bundle;
import io.fabric.sdk.android.C3211a.C0344b;

/* renamed from: com.crashlytics.android.answers.d */
class C0371d extends C0344b {
    private final C0392p f434a;

    public C0371d(C0392p c0392p) {
        this.f434a = c0392p;
    }

    public void m491a(Activity activity, Bundle bundle) {
        this.f434a.m556a(activity, Type.CREATE);
    }

    public void m490a(Activity activity) {
        this.f434a.m556a(activity, Type.START);
    }

    public void m492b(Activity activity) {
        this.f434a.m556a(activity, Type.RESUME);
    }

    public void m494c(Activity activity) {
        this.f434a.m556a(activity, Type.PAUSE);
    }

    public void m495d(Activity activity) {
        this.f434a.m556a(activity, Type.STOP);
    }

    public void m493b(Activity activity, Bundle bundle) {
        this.f434a.m556a(activity, Type.SAVE_INSTANCE_STATE);
    }

    public void m496e(Activity activity) {
        this.f434a.m556a(activity, Type.DESTROY);
    }
}
