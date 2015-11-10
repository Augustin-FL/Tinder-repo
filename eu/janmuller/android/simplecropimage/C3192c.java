package eu.janmuller.android.simplecropimage;

import android.app.ProgressDialog;
import android.os.Handler;
import eu.janmuller.android.simplecropimage.MonitoredActivity.C3183a;

/* renamed from: eu.janmuller.android.simplecropimage.c */
public class C3192c {

    /* renamed from: eu.janmuller.android.simplecropimage.c.a */
    private static class C3191a extends C3183a implements Runnable {
        private final MonitoredActivity f6877a;
        private final ProgressDialog f6878b;
        private final Runnable f6879c;
        private final Handler f6880d;
        private final Runnable f6881e;

        /* renamed from: eu.janmuller.android.simplecropimage.c.a.1 */
        class C31901 implements Runnable {
            final /* synthetic */ C3191a f6876a;

            C31901(C3191a c3191a) {
                this.f6876a = c3191a;
            }

            public void run() {
                this.f6876a.f6877a.m9545b(this.f6876a);
                if (this.f6876a.f6878b.getWindow() != null) {
                    this.f6876a.f6878b.dismiss();
                }
            }
        }

        public C3191a(MonitoredActivity monitoredActivity, Runnable runnable, ProgressDialog progressDialog, Handler handler) {
            this.f6881e = new C31901(this);
            this.f6877a = monitoredActivity;
            this.f6878b = progressDialog;
            this.f6879c = runnable;
            this.f6877a.m9544a(this);
            this.f6880d = handler;
        }

        public void run() {
            try {
                this.f6879c.run();
            } finally {
                this.f6880d.post(this.f6881e);
            }
        }

        public void m9617b(MonitoredActivity monitoredActivity) {
            this.f6881e.run();
            this.f6880d.removeCallbacks(this.f6881e);
        }

        public void m9619d(MonitoredActivity monitoredActivity) {
            this.f6878b.hide();
        }

        public void m9618c(MonitoredActivity monitoredActivity) {
            this.f6878b.show();
        }
    }

    public static void m9620a(MonitoredActivity monitoredActivity, String str, String str2, Runnable runnable, Handler handler) {
        new Thread(new C3191a(monitoredActivity, runnable, ProgressDialog.show(monitoredActivity, str, str2, true, false), handler)).start();
    }
}
