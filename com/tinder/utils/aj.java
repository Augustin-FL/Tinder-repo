package com.tinder.utils;

import android.os.Looper;
import com.tinder.managers.C2958p;
import com.tinder.p031b.C2406r;
import com.tinder.p031b.C2407s;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Date;

public class aj {
    private static aj f6550a;
    private final int f6551b;
    private final int f6552c;
    private final int f6553d;
    private boolean f6554e;
    private boolean f6555f;
    private boolean f6556g;
    private UncaughtExceptionHandler f6557h;

    /* renamed from: com.tinder.utils.aj.a */
    private static class C3051a implements UncaughtExceptionHandler {
        private UncaughtExceptionHandler f6549a;

        private C3051a(UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f6549a = uncaughtExceptionHandler;
        }

        public void uncaughtException(Thread thread, Throwable th) {
            UncaughtExceptionHandler uncaughtExceptionHandler;
            new C2406r().m6592a(System.currentTimeMillis());
            if (this.f6549a != null) {
                uncaughtExceptionHandler = this.f6549a;
            } else {
                uncaughtExceptionHandler = thread.getUncaughtExceptionHandler();
            }
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    static {
        f6550a = new aj();
    }

    private aj() {
        this.f6551b = 2;
        this.f6552c = 10;
        this.f6553d = 3;
    }

    public static aj m9235a() {
        return f6550a;
    }

    public void m9237b() {
        Thread thread = Looper.getMainLooper().getThread();
        UncaughtExceptionHandler uncaughtExceptionHandler = thread.getUncaughtExceptionHandler();
        if (this.f6557h == null || !this.f6557h.equals(uncaughtExceptionHandler)) {
            this.f6557h = new C3051a(null);
            thread.setUncaughtExceptionHandler(this.f6557h);
        }
    }

    public void m9238c() {
        this.f6556g = true;
    }

    public void m9239d() {
        this.f6554e = true;
    }

    public void m9240e() {
        this.f6555f = true;
    }

    public void m9241f() {
        Looper.getMainLooper().getThread().setUncaughtExceptionHandler(null);
    }

    public boolean m9242g() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - 600000;
        int a = new C2406r().m6591a(j, currentTimeMillis);
        C3095y.m9471a("check crashes between " + new Date(j) + " and " + new Date(currentTimeMillis) + " : " + a);
        return a >= 2;
    }

    public boolean m9243h() {
        return C2958p.m8786d();
    }

    public boolean m9244i() {
        return C2958p.m8788e();
    }

    public boolean m9245j() {
        return C2958p.m8789f();
    }

    public boolean m9246k() {
        if (!m9245j()) {
            return false;
        }
        boolean z = new C2407s().m6593b() >= 3;
        boolean h = m9243h();
        boolean i = m9244i();
        boolean g = m9242g();
        boolean z2 = this.f6556g;
        if (!m9245j() || h || i) {
            C3095y.m9471a("No op versionRateable?" + m9245j() + " hasRatedBefore? " + h);
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('\n').append("********\n").append("RATING CHECK \n").append("********\n").append("hasRated " + h + '\n').append("backFromMatch " + this.f6554e + '\n').append("backFromMessage " + this.f6555f + '\n').append("hasSentFeedback " + i + '\n').append("hasEnoughDays " + z + '\n').append("hasCrashes " + g + '\n').append("hasBounced " + z2 + '\n');
        C3095y.m9471a(stringBuilder.toString());
        if (g) {
            C3095y.m9471a("true because version is rateable & not rated before & has met crash criteria");
            m9236n();
            return true;
        }
        if (z) {
            if (this.f6554e || this.f6555f) {
                C3095y.m9471a("true because version is rateable & not rated before & has met session count, & new match " + this.f6554e + ", hasReadNewMessage " + this.f6555f);
                m9236n();
                return true;
            } else if (this.f6556g) {
                C3095y.m9471a("true because version is rateable & not rated before & has met session count & has just been bounced");
                m9236n();
                return true;
            }
        }
        m9236n();
        return false;
    }

    private void m9236n() {
        this.f6556g = false;
        this.f6555f = false;
        this.f6554e = false;
    }

    public void m9247l() {
        m9237b();
        new C2407s().m6594c();
    }

    public void m9248m() {
        m9241f();
    }
}
