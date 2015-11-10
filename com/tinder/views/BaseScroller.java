package com.tinder.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class BaseScroller extends Scroller {
    private int mDuration;

    public BaseScroller(@NonNull Context context) {
        super(context);
        this.mDuration = Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
    }

    public BaseScroller(@NonNull Context context, Interpolator interpolator) {
        super(context, interpolator);
        this.mDuration = Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
    }

    public BaseScroller(@NonNull Context context, Interpolator interpolator, boolean z) {
        super(context, interpolator, z);
        this.mDuration = Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
    }

    public void setDuration(int i) {
        this.mDuration = i;
    }

    public void startScroll(int i, int i2, int i3, int i4) {
        super.startScroll(i, i2, i3, i4, this.mDuration);
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        super.startScroll(i, i2, i3, i4, this.mDuration);
    }
}
