package com.tinder.drawing;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.NonNull;

/* renamed from: com.tinder.drawing.e */
public class C2554e extends Path implements C2550c {
    private Paint f4690a;

    public C2554e(Paint paint) {
        this.f4690a = new Paint(paint);
    }

    public float m7038b() {
        return this.f4690a.getStrokeWidth();
    }

    public void m7036a(float f) {
        this.f4690a.setStrokeWidth(f);
    }

    public void m7037a(@NonNull Canvas canvas, Paint paint) {
        canvas.drawPath(this, this.f4690a);
    }

    public Paint m7035a() {
        return this.f4690a;
    }
}
