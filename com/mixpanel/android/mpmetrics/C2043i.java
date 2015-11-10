package com.mixpanel.android.mpmetrics;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

@TargetApi(14)
/* renamed from: com.mixpanel.android.mpmetrics.i */
class C2043i implements ActivityLifecycleCallbacks {
    private final C2042h f2896a;

    public C2043i(C2042h c2042h) {
        this.f2896a = c2042h;
    }

    public void onActivityStarted(Activity activity) {
        if (activity.isTaskRoot()) {
            this.f2896a.m4788c().m4749b(activity);
            this.f2896a.m4788c().m4745a(activity);
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }
}
