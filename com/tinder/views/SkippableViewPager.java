package com.tinder.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class SkippableViewPager extends ViewPager {
    private boolean isPagingEnabled;
    private PagerAdapter mPagerAdapter;

    public SkippableViewPager(Context context) {
        super(context);
        this.isPagingEnabled = Boolean.TRUE.booleanValue();
    }

    public SkippableViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isPagingEnabled = Boolean.TRUE.booleanValue();
    }

    public void setPagingEnabled(boolean z) {
        this.isPagingEnabled = z;
    }

    public boolean onInterceptTouchEvent(@NonNull MotionEvent motionEvent) {
        return this.isPagingEnabled && super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.isPagingEnabled && super.onTouchEvent(motionEvent);
    }

    protected boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        if (view == this || !(view instanceof ViewPager)) {
            return super.canScroll(view, z, i, i2, i3);
        }
        this.mPagerAdapter = ((ViewPager) view).getAdapter();
        int currentItem = ((ViewPager) view).getCurrentItem();
        if ((currentItem != (this.mPagerAdapter == null ? 0 : this.mPagerAdapter.getCount()) - 1 || i >= 0) && (currentItem != 0 || i <= 0)) {
            return true;
        }
        return super.canScroll(view, z, i, i2, i3);
    }
}
