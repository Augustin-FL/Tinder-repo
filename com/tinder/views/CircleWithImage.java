package com.tinder.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tinder.C2241a.C2233a;
import com.tinder.R;
import com.tinder.utils.C3095y;

public class CircleWithImage extends ImageView {
    private int mBackgroundColor;
    private BitmapShader mBitmapShader;
    private Bitmap mCurBitmap;
    private Paint mPaint;
    private RectF mRectBackground;
    private float padding;
    private float radius;
    private float f6665x;
    private float f6666y;

    public CircleWithImage(Context context) {
        super(context);
        this.f6665x = 0.0f;
        this.f6666y = 0.0f;
        this.radius = BitmapDescriptorFactory.HUE_ORANGE;
        this.mBackgroundColor = getResources().getColor(R.color.white);
        this.mRectBackground = new RectF();
    }

    public CircleWithImage(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6665x = 0.0f;
        this.f6666y = 0.0f;
        this.radius = BitmapDescriptorFactory.HUE_ORANGE;
        this.mBackgroundColor = getResources().getColor(R.color.white);
        this.mRectBackground = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2233a.com_tinder_views_CircleWithImage, 0, 0);
        try {
            this.mBackgroundColor = obtainStyledAttributes.getColor(0, 0);
            this.padding = obtainStyledAttributes.getDimension(1, context.getResources().getDimension(R.dimen.dialog_padding_default));
        } catch (Exception e) {
            C3095y.m9479c(e.getMessage());
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    protected void onDraw(@Nullable Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            C3095y.m9479c("CircleWithImage drawable null - aborting onDraw...");
            return;
        }
        if (canvas == null) {
            canvas = new Canvas();
        }
        drawCircle(canvas);
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        Paint paint = getPaint(getShader(bitmap));
        if (bitmap == null || this.mRectBackground == null || paint == null) {
            C3095y.m9476b("Something important was null");
            return;
        }
        this.mRectBackground.top = 0.0f;
        this.mRectBackground.left = 0.0f;
        this.mRectBackground.bottom = (float) bitmap.getHeight();
        this.mRectBackground.right = (float) bitmap.getWidth();
        try {
            canvas.drawRoundRect(this.mRectBackground, (float) 20, (float) 20, paint);
        } catch (Exception e) {
            C3095y.m9471a(e.getMessage());
        }
        this.mCurBitmap = bitmap;
    }

    private void drawCircle(@NonNull Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Style.FILL);
        paint.setColor(this.mBackgroundColor);
        this.f6665x = (float) (getWidth() / 2);
        this.f6666y = (float) (getHeight() / 2);
        this.radius = this.f6665x > this.f6666y ? this.f6665x : this.f6666y;
        this.radius += this.padding;
        C3095y.m9471a(String.format("drawing circle at x[%s] y[%s] with padding: [%s]", new Object[]{Float.valueOf(this.f6665x), Float.valueOf(this.f6666y), Float.valueOf(this.padding)}));
        canvas.drawCircle(this.f6665x, this.f6666y, this.radius, paint);
    }

    private Paint getPaint(BitmapShader bitmapShader) {
        if (this.mPaint == null || this.mPaint.getShader() != bitmapShader) {
            this.mPaint = new Paint();
            this.mPaint.setAntiAlias(true);
            this.mPaint.setShader(bitmapShader);
            this.mPaint.setFilterBitmap(true);
        }
        return this.mPaint;
    }

    private BitmapShader getShader(Bitmap bitmap) {
        if (this.mBitmapShader == null || this.mCurBitmap != bitmap) {
            this.mBitmapShader = new BitmapShader(bitmap, TileMode.CLAMP, TileMode.CLAMP);
        }
        return this.mBitmapShader;
    }

    public void backgroundColor(int i) {
        C3095y.m9471a("background color set: " + i);
        this.mBackgroundColor = i;
        invalidate();
        requestLayout();
    }
}
