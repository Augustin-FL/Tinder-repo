package com.tinder.drawing;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.annotation.NonNull;

/* renamed from: com.tinder.drawing.a */
public class C2551a implements C2550c {
    private Paint f4683a;
    private float f4684b;
    private float f4685c;
    private float f4686d;
    private float f4687e;

    public C2551a(Paint paint, float f) {
        this.f4683a = new Paint(paint);
        this.f4683a.setStyle(Style.FILL);
        this.f4687e = f;
    }

    public void m7024a(float f) {
        this.f4684b = this.f4687e * f;
    }

    public void m7025a(float f, float f2) {
        this.f4685c = f;
        this.f4686d = f2;
    }

    public void m7026a(@NonNull Canvas canvas, Paint paint) {
        canvas.drawCircle(this.f4685c, this.f4686d, this.f4684b, this.f4683a);
    }

    public Paint m7023a() {
        return this.f4683a;
    }
}
