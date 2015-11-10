package com.tinder.drawing;

import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;

/* renamed from: com.tinder.drawing.d */
public class C2553d implements C2552b {
    private Paint f4688a;
    private Xfermode f4689b;

    public C2553d(int i) {
        this.f4688a = new Paint();
        this.f4688a.setColor(i);
        this.f4688a.setDither(true);
        this.f4688a.setAntiAlias(true);
        this.f4688a.setStyle(Style.STROKE);
        this.f4688a.setStrokeCap(Cap.ROUND);
        this.f4688a.setStrokeJoin(Join.BEVEL);
        this.f4688a.setFilterBitmap(true);
        this.f4689b = new PorterDuffXfermode(Mode.SRC_ATOP);
    }

    public Paint m7031a() {
        return this.f4688a;
    }

    public int m7034c() {
        return this.f4688a.getColor();
    }

    public void m7032a(int i) {
        this.f4688a.setColor(i);
    }

    public float m7030a(float f, float f2, float f3) {
        if (f3 < 0.0f && Math.abs(f2) < 0.88f) {
            return Math.max(f - 0.7011f, 3.6f);
        }
        if ((Math.abs(f2) + Math.abs(f3)) * 0.4f >= 0.4f) {
            return Math.min(f + 0.8511f, 22.0f);
        }
        return Math.max(f - 0.8511f, 3.6f);
    }

    public float m7033b() {
        return 3.6f;
    }
}
