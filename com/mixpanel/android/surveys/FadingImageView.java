package com.mixpanel.android.surveys;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import com.mixpanel.android.C1993a.C1988c;
import com.tinder.views.PeekStack;

public class FadingImageView extends ImageView {
    private Matrix f2948a;
    private Paint f2949b;
    private Shader f2950c;
    private Paint f2951d;
    private Shader f2952e;
    private int f2953f;
    private int f2954g;

    public FadingImageView(Context context) {
        super(context);
        m4840a();
    }

    public FadingImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4840a();
    }

    public FadingImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4840a();
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f2953f = getHeight();
        this.f2954g = getWidth();
        int size = MeasureSpec.getSize(i2);
        if (getResources().getConfiguration().orientation == 1) {
            View findViewById = getRootView().findViewById(C1988c.com_mixpanel_android_notification_bottom_wrapper);
            int i3 = 0;
            if (!(findViewById == null || findViewById.getHeight() == 0)) {
                i3 = findViewById.getHeight();
            }
            this.f2948a.setScale(1.0f, ((float) (size - i3)) + TypedValue.applyDimension(1, 15.0f, getResources().getDisplayMetrics()));
        } else {
            this.f2948a.setScale(1.0f, (float) size);
        }
        this.f2950c.setLocalMatrix(this.f2948a);
        this.f2952e.setLocalMatrix(this.f2948a);
    }

    public void draw(Canvas canvas) {
        Rect clipBounds = canvas.getClipBounds();
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, (float) clipBounds.width(), (float) clipBounds.height(), null, 31);
        super.draw(canvas);
        if (getResources().getConfiguration().orientation == 1) {
            canvas.drawRect(0.0f, 0.0f, (float) this.f2954g, (float) this.f2953f, this.f2949b);
        } else {
            canvas.drawRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (this.f2954g - getPaddingRight()), (float) (this.f2953f - getPaddingBottom()), this.f2951d);
        }
        canvas.restoreToCount(saveLayer);
    }

    private void m4840a() {
        this.f2948a = new Matrix();
        this.f2949b = new Paint();
        this.f2950c = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, new int[]{ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, -452984832, 0}, new float[]{0.0f, PeekStack.HEIGHT_PERCENT_OF_SCREEN, 0.8f, 1.0f}, TileMode.CLAMP);
        this.f2949b.setShader(this.f2950c);
        this.f2949b.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        this.f2951d = new Paint();
        this.f2952e = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, new int[]{0, 0, ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK}, new float[]{0.0f, 0.85f, 0.98f, 1.0f}, TileMode.CLAMP);
        this.f2951d.setShader(this.f2952e);
        this.f2949b.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
    }
}
