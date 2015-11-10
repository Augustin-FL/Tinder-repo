package com.tinder.views;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tinder.C2241a.C2233a;
import com.tinder.R;

public class FadingLayout extends FrameLayout {
    private int mColorPrimary;
    private int mColorSecondary;
    private ArgbEvaluator mEvaluator;
    private View mOverlay;

    public FadingLayout(Context context) {
        super(context);
        init(context);
    }

    public FadingLayout(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet, 0, 0);
    }

    public FadingLayout(@NonNull Context context, @NonNull AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet, 0, 0);
    }

    public FadingLayout(@NonNull Context context, @NonNull AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context, attributeSet, i, i2);
    }

    private void init(Context context) {
        this.mEvaluator = new ArgbEvaluator();
        this.mOverlay = new View(context);
        this.mOverlay.setVisibility(8);
    }

    private void init(@NonNull Context context, @NonNull AttributeSet attributeSet, int i, int i2) {
        init(context);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C2233a.FadingLayout, i, i2);
        try {
            this.mColorPrimary = obtainStyledAttributes.getColor(0, context.getResources().getColor(R.color.white));
            this.mColorSecondary = obtainStyledAttributes.getColor(1, context.getResources().getColor(R.color.black));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    protected void onFinishInflate() {
        addView(this.mOverlay, new LayoutParams(-1, -1));
        super.onFinishInflate();
    }

    public void setColorPrimary(int i) {
        this.mColorPrimary = i;
    }

    public void setColorSecondary(int i) {
        this.mColorSecondary = i;
    }

    public void setTransitionPercent(float f) {
        this.mOverlay.setAlpha(f);
        this.mOverlay.setBackgroundColor(((Integer) this.mEvaluator.evaluate(f, Integer.valueOf(this.mColorPrimary), Integer.valueOf(this.mColorSecondary))).intValue());
        int i = (f <= 0.0f || f >= 1.0f) ? 1 : 0;
        if (i != 0 && this.mOverlay.getVisibility() == 0) {
            this.mOverlay.setVisibility(8);
        } else if (i == 0 && this.mOverlay.getVisibility() == 8) {
            this.mOverlay.setVisibility(0);
        }
    }
}
