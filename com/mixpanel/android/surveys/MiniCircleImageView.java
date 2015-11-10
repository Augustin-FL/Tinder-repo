package com.mixpanel.android.surveys;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;
import com.tinder.views.PeekStack;

public class MiniCircleImageView extends ImageView {
    private Paint f2955a;
    private int f2956b;
    private int f2957c;

    public MiniCircleImageView(Context context) {
        super(context);
        m4841a();
    }

    public MiniCircleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4841a();
    }

    public MiniCircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4841a();
    }

    private void m4841a() {
        this.f2955a = new Paint(1);
        this.f2955a.setColor(getResources().getColor(17170443));
        this.f2955a.setStyle(Style.STROKE);
        this.f2955a.setStrokeWidth(TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics()));
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = (float) (this.f2956b / 2);
        float f2 = (float) (this.f2957c / 2);
        canvas.drawCircle(f, f2, PeekStack.HEIGHT_PERCENT_OF_SCREEN * Math.min(f, f2), this.f2955a);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f2956b = i;
        this.f2957c = i2;
    }
}
