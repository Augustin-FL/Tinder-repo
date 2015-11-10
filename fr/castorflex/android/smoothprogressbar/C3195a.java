package fr.castorflex.android.smoothprogressbar;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.shapes.Shape;

/* renamed from: fr.castorflex.android.smoothprogressbar.a */
public class C3195a extends Shape {
    private float f6890a;
    private int[] f6891b;

    public C3195a(float f, int[] iArr) {
        this.f6890a = f;
        this.f6891b = iArr;
    }

    public void draw(Canvas canvas, Paint paint) {
        int i = 0;
        float length = 1.0f / ((float) this.f6891b.length);
        paint.setStrokeWidth(this.f6890a);
        int[] iArr = this.f6891b;
        int length2 = iArr.length;
        int i2 = 0;
        while (i2 < length2) {
            paint.setColor(iArr[i2]);
            int i3 = i + 1;
            canvas.drawLine((((float) i) * length) * getWidth(), getHeight() / 2.0f, getWidth() * (((float) i3) * length), getHeight() / 2.0f, paint);
            i2++;
            i = i3;
        }
    }
}
