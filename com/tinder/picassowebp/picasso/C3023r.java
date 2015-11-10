package com.tinder.picassowebp.picasso;

import android.net.NetworkInfo;
import com.tinder.picassowebp.picasso.ab.C2999e;
import com.viewpagerindicator.C3169d.C3168f;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.tinder.picassowebp.picasso.r */
class C3023r extends ThreadPoolExecutor {
    C3023r() {
        super(3, 3, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new C2999e());
    }

    void m9102a(NetworkInfo networkInfo) {
        if (networkInfo == null || !networkInfo.isConnectedOrConnecting()) {
            m9101a(3);
            return;
        }
        switch (networkInfo.getType()) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                switch (networkInfo.getSubtype()) {
                    case C3374b.SmoothProgressBar_spb_color /*1*/:
                    case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                        m9101a(1);
                    case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                    case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                    case C3374b.SmoothProgressBar_spb_speed /*5*/:
                    case C3374b.SmoothProgressBar_spb_progressiveStart_speed /*6*/:
                    case C3374b.SmoothProgressBar_spb_progressiveStart_activated /*12*/:
                        m9101a(2);
                    case C3374b.SmoothProgressBar_spb_background /*13*/:
                    case C3374b.SmoothProgressBar_spb_generate_background_with_colors /*14*/:
                    case C3168f.Toolbar_titleMarginBottom /*15*/:
                        m9101a(3);
                    default:
                        m9101a(3);
                }
            case C3374b.SmoothProgressBar_spb_color /*1*/:
            case C3374b.SmoothProgressBar_spb_progressiveStart_speed /*6*/:
            case C3374b.SmoothProgressBar_spb_reversed /*9*/:
                m9101a(4);
            default:
                m9101a(3);
        }
    }

    private void m9101a(int i) {
        setCorePoolSize(i);
        setMaximumPoolSize(i);
    }
}
