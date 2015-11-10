package com.google.android.m4b.maps.av;

import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.google.android.m4b.maps.av.p */
public abstract class C1373p {
    private final int f912a;

    public abstract float m1319a();

    public C1373p(int i) {
        this.f912a = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TiltEvent{eventType=");
        switch (this.f912a) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                stringBuilder.append("EVENT_TYPE_ON_TILTING");
                break;
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                stringBuilder.append("EVENT_TYPE_ON_TILT_BEGIN");
                break;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                stringBuilder.append("EVENT_TYPE_ON_TILT_END");
                break;
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
