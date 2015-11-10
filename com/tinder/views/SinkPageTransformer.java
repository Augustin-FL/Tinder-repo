package com.tinder.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.tinder.R;
import com.tinder.utils.C3077n;
import com.tinder.utils.C3095y;

public class SinkPageTransformer implements PageTransformer {
    private static final float END_BOUNDARY = 0.0f;
    private static final float MIN_ALPHA = 0.85f;
    private static final float MIN_SCALE = 1.0f;
    private static final float NO_OFFSET = 0.0f;
    private static final float PAGE_HIDE_THRESHOLD = 1.2f;
    private static final float SLOW_DOWN_UNTIL_BOUNDARY = 0.2f;
    private static final float SPEED_UP_UNTIL_BOUNDARY = 0.35f;
    private static final float START_BOUNDARY = 1.0f;
    private float mOvershootMargin;
    private boolean mShouldBounce;

    public SinkPageTransformer(@NonNull Context context) {
        this.mShouldBounce = true;
        this.mOvershootMargin = (float) context.getResources().getDimensionPixelSize(R.dimen.page_overshoot_margin);
    }

    public void setShouldBounce(boolean z) {
        C3095y.m9471a("should bounce: " + z);
        this.mShouldBounce = false;
    }

    public void transformPage(@NonNull View view, float f) {
        int width = view.getWidth();
        if (f < GroundOverlayOptions.NO_DIMENSION) {
            view.setVisibility(8);
        } else if (f <= NO_OFFSET) {
            if (view.getVisibility() == 8) {
                view.setVisibility(0);
            }
            float a = C3077n.m9399a(START_BOUNDARY + f, NO_OFFSET, NO_OFFSET, START_BOUNDARY, START_BOUNDARY);
            float a2 = C3077n.m9399a(START_BOUNDARY + f, NO_OFFSET, MIN_ALPHA, START_BOUNDARY, START_BOUNDARY);
            if (view instanceof FadingLayout) {
                ((FadingLayout) view).setTransitionPercent(START_BOUNDARY - a);
            }
            view.setAlpha(a2);
            view.setTranslationX((((float) width) / PAGE_HIDE_THRESHOLD) * (-f));
            r0 = ((START_BOUNDARY - Math.abs(f)) * NO_OFFSET) + START_BOUNDARY;
            view.setScaleX(r0);
            view.setScaleY(r0);
            if (view.getAlpha() == MIN_ALPHA) {
                view.setVisibility(8);
            }
        } else if (f <= START_BOUNDARY) {
            view.setVisibility(0);
            if (this.mShouldBounce) {
                if (f > SPEED_UP_UNTIL_BOUNDARY) {
                    r0 = C3077n.m9399a(f, START_BOUNDARY, NO_OFFSET, SPEED_UP_UNTIL_BOUNDARY, (float) (-width));
                } else if (f > SLOW_DOWN_UNTIL_BOUNDARY) {
                    r0 = C3077n.m9399a(f, SLOW_DOWN_UNTIL_BOUNDARY, ((float) (-width)) - this.mOvershootMargin, SPEED_UP_UNTIL_BOUNDARY, (float) (-width));
                } else {
                    r0 = C3077n.m9399a(f, NO_OFFSET, (float) (-width), SLOW_DOWN_UNTIL_BOUNDARY, ((float) (-width)) - this.mOvershootMargin);
                }
                r0 += ((float) width) * (START_BOUNDARY - f);
            } else {
                r0 = NO_OFFSET;
            }
            view.setTranslationX(r0);
            view.setScaleX(START_BOUNDARY);
            view.setScaleY(START_BOUNDARY);
        } else {
            view.setVisibility(8);
        }
    }
}
