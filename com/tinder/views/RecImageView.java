package com.tinder.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tinder.C2241a.C2233a;
import com.tinder.picassowebp.picasso.C2281x;
import com.tinder.picassowebp.picasso.Picasso.LoadedFrom;
import com.tinder.utils.C3071j;
import com.tinder.utils.C3095y;

public class RecImageView extends ImageView implements C2281x {
    private boolean mHasRadiusBeenSet;
    private int mRadius;
    private Path mRoundingPath;

    public RecImageView(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public RecImageView(Context context) {
        super(context);
    }

    private void init(@NonNull AttributeSet attributeSet) {
        if (C3071j.m9371a() < 18 && C3071j.m9371a() > 10) {
            setLayerType(1, new Paint(1));
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C2233a.RecImageView, 0, 0);
        this.mRadius = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        setWillNotDraw(false);
    }

    private void configureRounding() {
        int width = getWidth();
        int height = getHeight();
        if (width > 0 && height > 0 && !this.mHasRadiusBeenSet) {
            this.mHasRadiusBeenSet = true;
            this.mRoundingPath = new Path();
            RectF rectF = new RectF(0.0f, 0.0f, (float) width, (float) height);
            this.mRadius = 18;
            this.mRoundingPath.addRoundRect(rectF, new float[]{(float) this.mRadius, (float) this.mRadius, (float) this.mRadius, (float) this.mRadius, 0.0f, 0.0f, 0.0f, 0.0f}, Direction.CCW);
        }
    }

    private void clipPath(@NonNull Canvas canvas) {
        configureRounding();
        canvas.clipPath(this.mRoundingPath);
    }

    public void draw(@NonNull Canvas canvas) {
        clipPath(canvas);
        super.draw(canvas);
    }

    protected void dispatchDraw(@NonNull Canvas canvas) {
        clipPath(canvas);
        super.dispatchDraw(canvas);
    }

    public void onBitmapLoaded(Bitmap bitmap, LoadedFrom loadedFrom) {
        setImageBitmap(bitmap);
    }

    public void onBitmapFailed(Drawable drawable) {
        C3095y.m9471a("Fail");
    }

    public void onPrepareLoad(Drawable drawable) {
        setImageDrawable(drawable);
    }
}
