package com.tinder.views;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.internal.view.SupportMenu;

public class MessageMomentBackgroundDrawable extends Drawable {
    private final boolean hasImage;
    private final boolean isRight;
    @NonNull
    private final Paint mChatBgPaint;
    private final float mCornerRadius;
    private final int mImageHeight;
    private Paint mImagePaint;
    private final RectF mImageRect;
    private final RectF mOverallRect;
    @NonNull
    private final Paint mRoundPaint;
    private final RectF mSquareEdge;
    private int mTextAreaHeight;
    private Path mTriangle;
    private final RectF mTriangleGap;
    private final int mTriangleRadius;
    private final int mTriangleSize;

    public MessageMomentBackgroundDrawable(@Nullable Bitmap bitmap, int i, float f, int i2, boolean z) {
        this.mImageRect = new RectF();
        this.mOverallRect = new RectF();
        this.mSquareEdge = new RectF();
        this.mTriangleGap = new RectF();
        this.mImageHeight = i;
        this.hasImage = bitmap != null;
        this.mCornerRadius = f;
        this.mTriangleSize = (int) (((double) this.mCornerRadius) * 1.2d);
        this.mTriangleRadius = ((int) this.mCornerRadius) / 2;
        if (this.hasImage) {
            Shader bitmapShader = new BitmapShader(bitmap, TileMode.CLAMP, TileMode.CLAMP);
            this.mImagePaint = new Paint();
            this.mImagePaint.setAntiAlias(true);
            this.mImagePaint.setShader(bitmapShader);
        }
        this.mChatBgPaint = new Paint();
        this.mChatBgPaint.setColor(i2);
        this.mRoundPaint = new Paint();
        this.mRoundPaint.setColor(i2);
        this.mRoundPaint.setStrokeJoin(Join.ROUND);
        this.mRoundPaint.setStrokeCap(Cap.ROUND);
        this.mRoundPaint.setPathEffect(new CornerPathEffect((float) this.mTriangleRadius));
        this.isRight = z;
    }

    public void setTextAreaHeight(int i) {
        this.mTextAreaHeight = i;
    }

    protected void onBoundsChange(@NonNull Rect rect) {
        super.onBoundsChange(rect);
        if (this.isRight) {
            setupRightAttachedTriangle(rect);
        } else {
            setupLeftAttachedTriangle(rect);
        }
    }

    private void setupRightAttachedTriangle(@NonNull Rect rect) {
        if (this.hasImage) {
            this.mImageRect.set((float) rect.left, (float) rect.top, (float) (rect.right - this.mTriangleSize), (float) this.mImageHeight);
            this.mSquareEdge.set((float) rect.left, ((float) this.mImageHeight) - this.mCornerRadius, (float) (rect.right - this.mTriangleSize), ((float) this.mImageHeight) + this.mCornerRadius);
            this.mOverallRect.set((float) rect.left, ((float) this.mImageHeight) - this.mCornerRadius, (float) (rect.right - this.mTriangleSize), (float) rect.bottom);
        } else {
            this.mOverallRect.set((float) rect.left, (float) rect.top, (float) (rect.right - this.mTriangleSize), (float) rect.bottom);
        }
        int i = rect.right;
        int i2 = rect.bottom;
        int i3 = (int) (((double) this.mTriangleSize) * 1.5d);
        this.mTriangle = new Path();
        this.mTriangle.moveTo((float) i, (float) i2);
        this.mTriangle.lineTo((float) (i - i3), (float) i2);
        this.mTriangle.lineTo((float) (i - i3), (float) (((double) i2) - (((double) this.mTriangleSize) * 1.5d)));
        this.mTriangle.close();
        this.mTriangleGap.set((float) (i - i3), (float) (((double) i2) - (((double) this.mTriangleSize) * 1.5d)), (float) ((i - i3) + this.mTriangleRadius), (float) i2);
    }

    private void setupLeftAttachedTriangle(@NonNull Rect rect) {
        if (this.hasImage) {
            this.mImageRect.set((float) this.mTriangleSize, (float) rect.top, (float) rect.right, (float) this.mImageHeight);
            this.mSquareEdge.set((float) this.mTriangleSize, ((float) this.mImageHeight) - this.mCornerRadius, (float) rect.right, ((float) this.mImageHeight) + this.mCornerRadius);
            this.mOverallRect.set((float) this.mTriangleSize, ((float) this.mImageHeight) - this.mCornerRadius, (float) rect.right, (float) rect.bottom);
        } else {
            this.mOverallRect.set((float) this.mTriangleSize, (float) rect.top, (float) rect.right, (float) rect.bottom);
        }
        int i = (int) (((double) this.mTriangleSize) * 1.5d);
        this.mTriangle = new Path();
        this.mTriangle.moveTo(0.0f, (float) rect.bottom);
        this.mTriangle.lineTo((float) i, (float) (((double) rect.bottom) - (((double) this.mTriangleSize) * 1.5d)));
        this.mTriangle.lineTo((float) i, (float) rect.bottom);
        this.mTriangle.close();
        this.mTriangleGap.set((float) (i - this.mTriangleRadius), (float) (((double) rect.bottom) - (((double) this.mTriangleSize) * 1.5d)), (float) (i + this.mTriangleRadius), (float) rect.bottom);
    }

    public void draw(@NonNull Canvas canvas) {
        if (this.hasImage) {
            canvas.drawRoundRect(this.mImageRect, this.mCornerRadius, this.mCornerRadius, this.mImagePaint);
        }
        canvas.drawRoundRect(this.mOverallRect, this.mCornerRadius, this.mCornerRadius, this.mChatBgPaint);
        if (this.hasImage) {
            canvas.drawRect(this.mSquareEdge, this.mChatBgPaint);
        }
        canvas.drawPath(this.mTriangle, this.mRoundPaint);
        new Paint().setColor(SupportMenu.CATEGORY_MASK);
        canvas.drawRect(this.mTriangleGap, this.mChatBgPaint);
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i) {
        this.mImagePaint.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mImagePaint.setColorFilter(colorFilter);
    }
}
