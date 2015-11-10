package com.tinder.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import com.tinder.R;
import com.tinder.utils.C3095y;

public class ScalableLine extends View {
    private Bitmap mBitmapLeft;
    private Bitmap mBitmapRight;
    private boolean mIsScalingFromCenter;
    private float mLengthOriginal;
    private float mLengthRequested;
    private Paint mPaint;
    private float mPosX;
    private float mPosXAtScaleStart;
    private float mScaleFactor;
    private float mScaleFromWidth;
    private float mWidthMiddle;
    private float mWidthSide;

    public ScalableLine(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ScalableLine(@NonNull Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public ScalableLine(@NonNull Context context) {
        super(context);
        init(context);
    }

    private void init(@NonNull Context context) {
        this.mPaint = new Paint();
        this.mPaint.setColor(context.getResources().getColor(R.color.orange));
        this.mBitmapLeft = BitmapFactory.decodeResource(getResources(), R.drawable.tabindicator_leftside);
        this.mBitmapRight = BitmapFactory.decodeResource(getResources(), R.drawable.tabindicator_rightside);
        this.mWidthSide = (float) this.mBitmapLeft.getWidth();
    }

    public void scaleFromCenter(float f) {
        this.mScaleFactor = f;
        float f2 = this.mLengthOriginal * f;
        C3095y.m9471a("scaleFactor=" + f + ", mLengthOriginal=" + this.mLengthOriginal + ", newLength=" + f2);
        if (!this.mIsScalingFromCenter) {
            this.mScaleFromWidth = this.mLengthRequested;
            this.mPosXAtScaleStart = this.mPosX;
            C3095y.m9471a("mScaleFromWidth=" + this.mScaleFromWidth);
        }
        setLength(f2, true);
    }

    public void setLength(float f, boolean z) {
        C3095y.m9471a("newLength=" + f + ", isScalingFromCenter=" + z);
        this.mLengthRequested = f;
        this.mIsScalingFromCenter = z;
        if (this.mLengthOriginal == 0.0f) {
            this.mLengthOriginal = f;
        }
        this.mWidthMiddle = f - (this.mWidthSide * 2.0f);
        C3095y.m9471a("mWidthMiddle=" + this.mWidthMiddle);
        if (this.mIsScalingFromCenter) {
            float f2 = (this.mScaleFromWidth - this.mLengthRequested) / 2.0f;
            C3095y.m9471a("mPosX=" + this.mPosX + ", offset=" + f2);
            setX(f2 + this.mPosXAtScaleStart);
        }
        invalidate();
    }

    public float getLength() {
        return (2.0f * this.mWidthSide) + this.mWidthMiddle;
    }

    public void setX(float f) {
        C3095y.m9471a("x=" + f);
        this.mPosX = f;
    }

    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        C3095y.m9471a("mPosX=" + this.mPosX + ", mIsScalingFromCenter=" + this.mIsScalingFromCenter + ", mScaleFromWidth=" + this.mScaleFromWidth + ", mLengthRequested=" + this.mLengthRequested);
        canvas.drawBitmap(this.mBitmapLeft, this.mPosX, 0.0f, this.mPaint);
        Canvas canvas2 = canvas;
        canvas2.drawRect(this.mPosX + this.mWidthSide, 0.0f, this.mPosX + (this.mWidthMiddle + this.mWidthSide), (float) getHeight(), this.mPaint);
        canvas.drawBitmap(this.mBitmapRight, (this.mWidthMiddle + this.mWidthSide) + this.mPosX, 0.0f, this.mPaint);
    }

    public float getScaleFactor() {
        return this.mScaleFactor;
    }
}
