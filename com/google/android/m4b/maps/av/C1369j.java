package com.google.android.m4b.maps.av;

import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.google.android.m4b.maps.av.j */
public abstract class C1369j {
    private final int f908a;

    public abstract float m1303a();

    public abstract void m1304a(float f, float f2);

    public abstract float m1305b();

    public abstract float m1306c();

    public C1369j(int i) {
        this.f908a = i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RotateEvent{eventType=");
        switch (this.f908a) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                stringBuilder.append("EVENT_TYPE_ON_ROTATE");
                break;
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                stringBuilder.append("EVENT_TYPE_ON_ROTATE_BEGIN");
                break;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                stringBuilder.append("EVENT_TYPE_ON_ROTATE_END");
                break;
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
