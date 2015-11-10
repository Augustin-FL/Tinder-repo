package com.google.android.m4b.maps.ba;

import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import com.google.android.m4b.maps.ad.d;
import com.google.android.m4b.maps.ay.ad;
import com.google.android.m4b.maps.ba.C1464a.C1463b;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

class b$3 extends Handler {
    private /* synthetic */ b f1368a;

    b$3(b bVar) {
        this.a = bVar;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                b.a(this.a, (b$d) message.obj);
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                b.a(this.a);
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                b.a(this.a, (b$a) message.obj);
            case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                b.b(this.a);
            case C3374b.SmoothProgressBar_spb_speed /*5*/:
                synchronized (message.obj) {
                    message.obj.notify();
                    break;
                }
                b.c(this.a);
            case C3374b.SmoothProgressBar_spb_progressiveStart_speed /*6*/:
                Pair pair = (Pair) message.obj;
                b.a(this.a, (ad) ((Pair) pair.first).first, (C1463b) ((Pair) pair.first).second, (d) pair.second);
            default:
        }
    }
}
