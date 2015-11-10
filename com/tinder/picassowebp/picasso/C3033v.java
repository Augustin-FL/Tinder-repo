package com.tinder.picassowebp.picasso;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.tinder.picassowebp.picasso.v */
class C3033v {
    final HandlerThread f6458a;
    final C3005d f6459b;
    final Handler f6460c;
    long f6461d;
    long f6462e;
    long f6463f;
    long f6464g;
    long f6465h;
    long f6466i;
    long f6467j;
    long f6468k;
    int f6469l;
    int f6470m;
    int f6471n;

    /* renamed from: com.tinder.picassowebp.picasso.v.a */
    private static class C3032a extends Handler {
        private final C3033v f6457a;

        /* renamed from: com.tinder.picassowebp.picasso.v.a.1 */
        class C30311 implements Runnable {
            final /* synthetic */ Message f6455a;
            final /* synthetic */ C3032a f6456b;

            C30311(C3032a c3032a, Message message) {
                this.f6456b = c3032a;
                this.f6455a = message;
            }

            public void run() {
                throw new AssertionError("Unhandled stats message." + this.f6455a.what);
            }
        }

        public C3032a(Looper looper, C3033v c3033v) {
            super(looper);
            this.f6457a = c3033v;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case C3374b.SmoothProgressBar_spbStyle /*0*/:
                    this.f6457a.m9144c();
                case C3374b.SmoothProgressBar_spb_color /*1*/:
                    this.f6457a.m9146d();
                case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                    this.f6457a.m9142b((long) message.arg1);
                case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                    this.f6457a.m9145c((long) message.arg1);
                case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                    this.f6457a.m9140a((Long) message.obj);
                default:
                    Picasso.f6331a.post(new C30311(this, message));
            }
        }
    }

    C3033v(C3005d c3005d) {
        this.f6459b = c3005d;
        this.f6458a = new HandlerThread("Picasso-Stats", 10);
        this.f6458a.start();
        this.f6460c = new C3032a(this.f6458a.getLooper(), this);
    }

    private static long m9135a(int i, long j) {
        return j / ((long) i);
    }

    void m9139a(Bitmap bitmap) {
        m9136a(bitmap, 2);
    }

    void m9143b(Bitmap bitmap) {
        m9136a(bitmap, 3);
    }

    void m9138a(long j) {
        this.f6460c.sendMessage(this.f6460c.obtainMessage(4, Long.valueOf(j)));
    }

    void m9137a() {
        this.f6460c.sendEmptyMessage(0);
    }

    void m9141b() {
        this.f6460c.sendEmptyMessage(1);
    }

    void m9144c() {
        this.f6461d++;
    }

    void m9146d() {
        this.f6462e++;
    }

    void m9140a(Long l) {
        this.f6469l++;
        this.f6463f += l.longValue();
        this.f6466i = C3033v.m9135a(this.f6469l, this.f6463f);
    }

    void m9142b(long j) {
        this.f6470m++;
        this.f6464g += j;
        this.f6467j = C3033v.m9135a(this.f6470m, this.f6464g);
    }

    void m9145c(long j) {
        this.f6471n++;
        this.f6465h += j;
        this.f6468k = C3033v.m9135a(this.f6470m, this.f6465h);
    }

    C3034w m9147e() {
        return new C3034w(this.f6459b.m9043b(), this.f6459b.m9040a(), this.f6461d, this.f6462e, this.f6463f, this.f6464g, this.f6465h, this.f6466i, this.f6467j, this.f6468k, this.f6469l, this.f6470m, this.f6471n, System.currentTimeMillis());
    }

    private void m9136a(Bitmap bitmap, int i) {
        this.f6460c.sendMessage(this.f6460c.obtainMessage(i, ab.m9015a(bitmap), 0));
    }
}
