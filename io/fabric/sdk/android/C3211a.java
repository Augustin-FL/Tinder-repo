package io.fabric.sdk.android;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;

/* renamed from: io.fabric.sdk.android.a */
public class C3211a {
    private final Application f6936a;
    private C3210a f6937b;

    /* renamed from: io.fabric.sdk.android.a.b */
    public static abstract class C0344b {
        public void m393a(Activity activity, Bundle bundle) {
        }

        public void m392a(Activity activity) {
        }

        public void m394b(Activity activity) {
        }

        public void m396c(Activity activity) {
        }

        public void m397d(Activity activity) {
        }

        public void m395b(Activity activity, Bundle bundle) {
        }

        public void m398e(Activity activity) {
        }
    }

    /* renamed from: io.fabric.sdk.android.a.a */
    private static class C3210a {
        private final Set<ActivityLifecycleCallbacks> f6934a;
        private final Application f6935b;

        /* renamed from: io.fabric.sdk.android.a.a.1 */
        class C32091 implements ActivityLifecycleCallbacks {
            final /* synthetic */ C0344b f6932a;
            final /* synthetic */ C3210a f6933b;

            C32091(C3210a c3210a, C0344b c0344b) {
                this.f6933b = c3210a;
                this.f6932a = c0344b;
            }

            public void onActivityCreated(Activity activity, Bundle bundle) {
                this.f6932a.m393a(activity, bundle);
            }

            public void onActivityStarted(Activity activity) {
                this.f6932a.m392a(activity);
            }

            public void onActivityResumed(Activity activity) {
                this.f6932a.m394b(activity);
            }

            public void onActivityPaused(Activity activity) {
                this.f6932a.m396c(activity);
            }

            public void onActivityStopped(Activity activity) {
                this.f6932a.m397d(activity);
            }

            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                this.f6932a.m395b(activity, bundle);
            }

            public void onActivityDestroyed(Activity activity) {
                this.f6932a.m398e(activity);
            }
        }

        C3210a(Application application) {
            this.f6934a = new HashSet();
            this.f6935b = application;
        }

        @TargetApi(14)
        private void m9679a() {
            for (ActivityLifecycleCallbacks unregisterActivityLifecycleCallbacks : this.f6934a) {
                this.f6935b.unregisterActivityLifecycleCallbacks(unregisterActivityLifecycleCallbacks);
            }
        }

        @TargetApi(14)
        private boolean m9682a(C0344b c0344b) {
            if (this.f6935b == null) {
                return false;
            }
            ActivityLifecycleCallbacks c32091 = new C32091(this, c0344b);
            this.f6935b.registerActivityLifecycleCallbacks(c32091);
            this.f6934a.add(c32091);
            return true;
        }
    }

    public C3211a(Context context) {
        this.f6936a = (Application) context.getApplicationContext();
        if (VERSION.SDK_INT >= 14) {
            this.f6937b = new C3210a(this.f6936a);
        }
    }

    public boolean m9684a(C0344b c0344b) {
        return this.f6937b != null && this.f6937b.m9682a(c0344b);
    }

    public void m9683a() {
        if (this.f6937b != null) {
            this.f6937b.m9679a();
        }
    }
}
