package com.mixpanel.android.mpmetrics;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.os.AsyncTask;
import android.support.v4.view.ViewCompat;
import com.mixpanel.android.p025a.C1990a;
import com.mixpanel.android.p025a.C1992c;

/* renamed from: com.mixpanel.android.mpmetrics.b */
class C2019b {
    private static final int f2825a;

    /* renamed from: com.mixpanel.android.mpmetrics.b.1 */
    static class C20161 implements Runnable {
        final /* synthetic */ Activity f2819a;
        final /* synthetic */ C2018b f2820b;

        C20161(Activity activity, C2018b c2018b) {
            this.f2819a = activity;
            this.f2820b = c2018b;
        }

        public void run() {
            new C2017a(this.f2819a, this.f2820b).execute(new Void[0]);
        }
    }

    /* renamed from: com.mixpanel.android.mpmetrics.b.a */
    private static class C2017a extends AsyncTask<Void, Void, Void> {
        private final C2018b f2821a;
        private final Activity f2822b;
        private Bitmap f2823c;
        private int f2824d;

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m4699a((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m4700a((Void) obj);
        }

        public C2017a(Activity activity, C2018b c2018b) {
            this.f2822b = activity;
            this.f2821a = c2018b;
            this.f2824d = ViewCompat.MEASURED_STATE_MASK;
        }

        protected void onPreExecute() {
            this.f2823c = C1990a.m4585a(this.f2822b, 2, 2, true);
            this.f2824d = C1990a.m4584a(this.f2823c);
        }

        protected Void m4699a(Void... voidArr) {
            if (this.f2823c != null) {
                try {
                    C1992c.m4589a(this.f2823c, 20);
                    new Canvas(this.f2823c).drawColor(C2019b.f2825a, Mode.SRC_ATOP);
                } catch (ArrayIndexOutOfBoundsException e) {
                    this.f2823c = null;
                } catch (OutOfMemoryError e2) {
                    this.f2823c = null;
                }
            }
            return null;
        }

        protected void m4700a(Void voidR) {
            this.f2821a.m4701a(this.f2823c, this.f2824d);
        }
    }

    /* renamed from: com.mixpanel.android.mpmetrics.b.b */
    public interface C2018b {
        void m4701a(Bitmap bitmap, int i);
    }

    public static void m4703a(Activity activity, C2018b c2018b) {
        activity.runOnUiThread(new C20161(activity, c2018b));
    }

    static {
        f2825a = Color.argb(186, 28, 28, 28);
    }
}
