package com.tinder.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.support.annotation.NonNull;
import com.tinder.R;
import com.tinder.picassowebp.picasso.C3036z;

public class LinearGradientTransformation implements C3036z {
    private Paint mBottomPaint;
    private int mColorOne;
    private int mColorTwo;
    private double mPercentGradientBottom;
    private double mPercentGradientTop;
    private Paint mTopPaint;

    public LinearGradientTransformation(@NonNull Context context, double d, double d2) {
        this.mColorOne = context.getResources().getColor(R.color.very_translucent_black);
        this.mColorTwo = context.getResources().getColor(R.color.transparent);
        this.mPercentGradientTop = d;
        this.mPercentGradientBottom = d2;
    }

    @NonNull
    public Bitmap transform(@NonNull Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        canvas.drawRect(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight(), getTopPaint(bitmap));
        canvas.drawRect(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight(), getBottomPaint(bitmap));
        return bitmap;
    }

    @NonNull
    public String key() {
        return "LinearGradientTransformation";
    }

    private Paint getBottomPaint(@NonNull Bitmap bitmap) {
        if (this.mBottomPaint == null) {
            Shader linearGradient = new LinearGradient((float) (bitmap.getWidth() / 2), (float) (bitmap.getHeight() - ((int) (((double) bitmap.getHeight()) * this.mPercentGradientBottom))), (float) (bitmap.getWidth() / 2), (float) bitmap.getHeight(), this.mColorTwo, this.mColorOne, TileMode.CLAMP);
            this.mBottomPaint = new Paint();
            this.mBottomPaint.setDither(true);
            this.mBottomPaint.setShader(linearGradient);
        }
        return this.mBottomPaint;
    }

    private Paint getTopPaint(@NonNull Bitmap bitmap) {
        if (this.mTopPaint == null) {
            Shader linearGradient = new LinearGradient((float) (bitmap.getWidth() / 2), 0.0f, (float) (bitmap.getWidth() / 2), (float) ((int) (((double) bitmap.getHeight()) * this.mPercentGradientTop)), this.mColorOne, this.mColorTwo, TileMode.CLAMP);
            this.mTopPaint = new Paint();
            this.mTopPaint.setDither(true);
            this.mTopPaint.setShader(linearGradient);
        }
        return this.mTopPaint;
    }
}
