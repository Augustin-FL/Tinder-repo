package com.tinder.utils;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.tinder.managers.C2807a;
import com.tinder.managers.C2913k;
import com.tinder.managers.ManagerApp;
import com.tinder.model.SparksEvent;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.tinder.utils.b */
public class C3061b implements ActivityLifecycleCallbacks {
    public static boolean f6596a;
    private static boolean f6597b;
    private static boolean f6598c;
    private static C3060b f6599d;
    @Nullable
    private WeakReference<C2774c> f6600e;

    /* renamed from: com.tinder.utils.b.c */
    public interface C2774c {
        void m7895C();

        void m7896D();
    }

    /* renamed from: com.tinder.utils.b.a */
    public interface C3057a {
        void m9322a();
    }

    /* renamed from: com.tinder.utils.b.1 */
    class C30581 implements C3057a {
        final /* synthetic */ C3061b f6589a;

        C30581(C3061b c3061b) {
            this.f6589a = c3061b;
        }

        public void m9323a() {
            this.f6589a.m9333c();
            if (C3077n.m9407a(this.f6589a.f6600e)) {
                ((C2774c) this.f6589a.f6600e.get()).m7896D();
            }
        }
    }

    /* renamed from: com.tinder.utils.b.b */
    public class C3060b {
        final /* synthetic */ C3061b f6591a;
        private boolean f6592b;
        private C3057a f6593c;
        private Timer f6594d;
        private TimerTask f6595e;

        /* renamed from: com.tinder.utils.b.b.1 */
        class C30591 extends TimerTask {
            final /* synthetic */ C3060b f6590a;

            C30591(C3060b c3060b) {
                this.f6590a = c3060b;
            }

            public void run() {
                this.f6590a.f6593c.m9322a();
            }
        }

        public C3060b(C3061b c3061b, C3057a c3057a) {
            this.f6591a = c3061b;
            this.f6592b = false;
            this.f6593c = c3057a;
        }

        private void m9325c() {
            this.f6594d = new Timer();
            this.f6595e = new C30591(this);
            this.f6594d.schedule(this.f6595e, 600);
            this.f6592b = true;
        }

        public synchronized void m9327a() {
            if (!this.f6592b) {
                m9325c();
            }
        }

        public synchronized void m9328b() {
            this.f6592b = false;
            m9326d();
        }

        private void m9326d() {
            if (this.f6594d != null && this.f6595e != null) {
                this.f6595e.cancel();
                this.f6594d.cancel();
            }
        }
    }

    static {
        f6596a = false;
        f6598c = true;
    }

    public C3061b(@Nullable C2774c c2774c) {
        if (c2774c == null) {
            throw new IllegalArgumentException("LifeCycleHelperInterface cannot be null in constructor");
        }
        this.f6600e = new WeakReference(c2774c);
        f6599d = new C3060b(this, new C30581(this));
    }

    private void m9329a() {
        SparksEvent sparksEvent = new SparksEvent("App.Open");
        sparksEvent.put("resume", Boolean.valueOf(f6597b));
        sparksEvent.put("registered", Boolean.valueOf(ManagerApp.m7911b().m8144e()));
        C2807a.m8056a(sparksEvent);
        f6597b = true;
        f6598c = false;
    }

    private static void m9332b() {
        SparksEvent sparksEvent = new SparksEvent("Device");
        sparksEvent.put("manu", C3071j.m9373c());
        sparksEvent.put("model", C3071j.m9374d());
        sparksEvent.put("osVersion", C3071j.m9376f());
        sparksEvent.put("dataProvider", C3071j.m9375e());
        C2807a.m8056a(sparksEvent);
    }

    private void m9333c() {
        SparksEvent sparksEvent = new SparksEvent("App.Close");
        sparksEvent.put("registered", Boolean.valueOf(ManagerApp.m7911b().m8144e()));
        C2807a.m8056a(sparksEvent);
        f6598c = true;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        f6596a = true;
        f6599d.m9328b();
        if (f6598c) {
            m9329a();
            if (ManagerApp.m7911b().m8144e()) {
                C3061b.m9332b();
                C2913k.m8569a();
            }
            if (C3077n.m9407a(this.f6600e)) {
                ((C2774c) this.f6600e.get()).m7895C();
            }
        }
    }

    public void onActivityPaused(Activity activity) {
        f6596a = false;
        f6599d.m9327a();
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }
}
