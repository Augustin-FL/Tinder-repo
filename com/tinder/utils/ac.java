package com.tinder.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.widget.EdgeEffect;

public class ac extends EdgeEffect {
    private C3046a f6523a;
    private boolean f6524b;

    /* renamed from: com.tinder.utils.ac.a */
    public interface C3046a {
        void onPull(float f, float f2);

        void onRelease();
    }

    public ac(@NonNull Context context) {
        super(context);
    }

    public void m9211a(boolean z) {
        this.f6524b = z;
    }

    public void onPull(float f) {
        super.onPull(f);
        if (this.f6523a != null) {
            this.f6523a.onPull(f, 0.0f);
        }
    }

    public void onPull(float f, float f2) {
        super.onPull(f, f2);
        if (this.f6523a != null) {
            this.f6523a.onPull(f, f2);
        }
    }

    public void onRelease() {
        super.onRelease();
        if (this.f6523a != null && !isFinished()) {
            this.f6523a.onRelease();
        }
    }

    public void setColor(int i) {
        super.setColor(i);
    }

    public boolean draw(Canvas canvas) {
        if (this.f6524b) {
            return true;
        }
        return super.draw(canvas);
    }

    public void m9210a(C3046a c3046a) {
        this.f6523a = c3046a;
    }
}
