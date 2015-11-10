package com.tinder.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.support.annotation.NonNull;
import com.tinder.R;
import com.tinder.picassowebp.picasso.C3036z;

public class DarkenTransformation implements C3036z {
    @NonNull
    private final Paint mPaint;

    public DarkenTransformation(@NonNull Context context) {
        this.mPaint = new Paint();
        this.mPaint.setColorFilter(new PorterDuffColorFilter(context.getResources().getColor(R.color.very_translucent_black), Mode.SRC_OVER));
    }

    @NonNull
    public Bitmap transform(@NonNull Bitmap bitmap) {
        new Canvas(bitmap).drawBitmap(bitmap, 0.0f, 0.0f, this.mPaint);
        return bitmap;
    }

    @NonNull
    public String key() {
        return "darken-transformation";
    }
}
