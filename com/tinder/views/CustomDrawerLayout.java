package com.tinder.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.facebook.stetho.BuildConfig;
import com.tinder.utils.C3095y;

public class CustomDrawerLayout extends DrawerLayout {
    private int mGravity;

    public CustomDrawerLayout(Context context) {
        super(context);
    }

    public CustomDrawerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomDrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public int getGravity() {
        return this.mGravity;
    }

    public void setGravity(int i) {
        this.mGravity = i;
    }

    public void setDrawerShadow(int i) {
        setDrawerShadow(i, this.mGravity);
    }

    public void closeDrawer() {
        if (isDrawerOpen()) {
            closeDrawer(this.mGravity);
        }
    }

    public void openDrawer() {
        if (!isDrawerOpen()) {
            openDrawer(this.mGravity);
        }
    }

    public boolean isDrawerOpen() {
        return isDrawerOpen(this.mGravity);
    }

    public boolean onInterceptTouchEvent(@NonNull MotionEvent motionEvent) {
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e) {
            C3095y.m9479c(BuildConfig.FLAVOR + e);
            return false;
        }
    }
}
