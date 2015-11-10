package com.google.android.m4b.maps.av;

import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.google.android.m4b.maps.av.l */
public abstract class C1371l {
    private final int f910a;

    public abstract float m1311a();

    public abstract float m1312b();

    public abstract float m1313c();

    public C1371l(int i) {
        this.f910a = i;
    }

    public final boolean m1314d() {
        return this.f910a == 0;
    }

    public final boolean m1315e() {
        return this.f910a == 3;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ScaleEvent{eventType=");
        switch (this.f910a) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                stringBuilder.append("EVENT_TYPE_ON_SCALING");
                break;
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                stringBuilder.append("EVENT_TYPE_ON_SCALE_BEGIN");
                break;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                stringBuilder.append("EVENT_TYPE_ON_SCALE_END");
                break;
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                stringBuilder.append("EVENT_TYPE_ON_TWO_FINGER_TAP");
                break;
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
