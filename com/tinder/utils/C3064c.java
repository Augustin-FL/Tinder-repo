package com.tinder.utils;

import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.tinder.utils.c */
public class C3064c {
    @NonNull
    private static ExecutorService f6603a;
    private C2318a f6604b;
    private C2669b f6605c;
    private C2316c f6606d;

    /* renamed from: com.tinder.utils.c.c */
    public interface C2316c {
        void m6291a(Object obj);
    }

    /* renamed from: com.tinder.utils.c.a */
    public interface C2318a {
        @Nullable
        Object m6293a();
    }

    /* renamed from: com.tinder.utils.c.b */
    public interface C2669b {
        void m7471a();
    }

    /* renamed from: com.tinder.utils.c.1 */
    class C30621 extends AsyncTask<Void, Void, Object> {
        final /* synthetic */ C3064c f6601a;

        C30621(C3064c c3064c) {
            this.f6601a = c3064c;
        }

        @Nullable
        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m9334a((Void[]) objArr);
        }

        @Nullable
        protected Object m9334a(Void... voidArr) {
            return this.f6601a.f6604b.m6293a();
        }

        protected void onPostExecute(Object obj) {
            this.f6601a.f6606d.m6291a(obj);
        }
    }

    /* renamed from: com.tinder.utils.c.2 */
    class C30632 implements Runnable {
        final /* synthetic */ C3064c f6602a;

        C30632(C3064c c3064c) {
            this.f6602a = c3064c;
        }

        public void run() {
            Process.setThreadPriority(10);
            this.f6602a.f6605c.m7471a();
        }
    }

    static {
        f6603a = Executors.newSingleThreadExecutor();
    }

    private C3064c(C2318a c2318a) {
        this.f6604b = c2318a;
    }

    private C3064c(C2669b c2669b) {
        this.f6605c = c2669b;
    }

    @NonNull
    public static C3064c m9336a(C2318a c2318a) {
        return new C3064c(c2318a);
    }

    @NonNull
    public static C3064c m9337a(C2669b c2669b) {
        return new C3064c(c2669b);
    }

    @NonNull
    public C3064c m9340a(C2316c c2316c) {
        this.f6606d = c2316c;
        return this;
    }

    public void m9342a(boolean z) {
        if (this.f6605c == null && (this.f6604b == null || this.f6606d == null)) {
            throw new IllegalStateException("You must specify either AsyncBgOnly OR both AsyncBg AND AsyncUi.");
        } else if (this.f6605c == null) {
            AsyncTask c30621 = new C30621(this);
            if (!z || VERSION.SDK_INT < 11) {
                c30621.execute((Object[]) null);
            } else {
                c30621.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[]) null);
            }
        } else {
            f6603a.submit(new C30632(this));
        }
    }

    public void m9341a() {
        m9342a(false);
    }
}
