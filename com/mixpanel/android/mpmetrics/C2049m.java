package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/* renamed from: com.mixpanel.android.mpmetrics.m */
class C2049m {
    private final Executor f2912a;

    /* renamed from: com.mixpanel.android.mpmetrics.m.b */
    interface C2032b {
        void m4742a(SharedPreferences sharedPreferences);
    }

    /* renamed from: com.mixpanel.android.mpmetrics.m.a */
    private static class C2048a implements Callable<SharedPreferences> {
        private final Context f2909a;
        private final String f2910b;
        private final C2032b f2911c;

        public /* synthetic */ Object call() throws Exception {
            return m4817a();
        }

        public C2048a(Context context, String str, C2032b c2032b) {
            this.f2909a = context;
            this.f2910b = str;
            this.f2911c = c2032b;
        }

        public SharedPreferences m4817a() {
            SharedPreferences sharedPreferences = this.f2909a.getSharedPreferences(this.f2910b, 0);
            if (this.f2911c != null) {
                this.f2911c.m4742a(sharedPreferences);
            }
            return sharedPreferences;
        }
    }

    public C2049m() {
        this.f2912a = Executors.newSingleThreadExecutor();
    }

    public Future<SharedPreferences> m4818a(Context context, String str, C2032b c2032b) {
        Object futureTask = new FutureTask(new C2048a(context, str, c2032b));
        this.f2912a.execute(futureTask);
        return futureTask;
    }
}
