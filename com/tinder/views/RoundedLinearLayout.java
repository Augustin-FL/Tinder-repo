package com.tinder.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tinder.C2241a.C2233a;
import com.tinder.utils.C3071j;

public class RoundedLinearLayout extends LinearLayout {
    private boolean mHasRadiusBeenSet;
    private int mRadius;
    private Path mRoundingPath;

    public RoundedLinearLayout(Context context) {
        super(context);
    }

    public RoundedLinearLayout(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        if (C3071j.m9371a() < 18 && C3071j.m9371a() > 10) {
            setLayerType(1, null);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2233a.com_tinder_views_RoundedRelativeLayout, 0, 0);
        this.mRadius = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        configureRounding();
    }

    private void configureRounding() {
        int width = getWidth();
        int height = getHeight();
        if (width > 0 && height > 0 && !this.mHasRadiusBeenSet) {
            this.mHasRadiusBeenSet = true;
            this.mRoundingPath = new Path();
            this.mRoundingPath.addRoundRect(new RectF(0.0f, 0.0f, (float) width, (float) height), (float) this.mRadius, (float) this.mRadius, Direction.CCW);
        }
    }

    private void clipPath(@NonNull Canvas canvas) {
        if (VERSION.SDK_INT >= 16 || !isHardwareAccelerated()) {
            configureRounding();
            canvas.clipPath(this.mRoundingPath);
        }
    }

    protected void dispatchDraw(@NonNull Canvas canvas) {
        clipPath(canvas);
        super.dispatchDraw(canvas);
    }

    public void draw(@NonNull Canvas canvas) {
        clipPath(canvas);
        super.draw(canvas);
    }
}
