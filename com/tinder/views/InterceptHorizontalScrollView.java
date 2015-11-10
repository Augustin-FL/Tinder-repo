package com.tinder.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

public class InterceptHorizontalScrollView extends HorizontalScrollView {
    @NonNull
    private final GestureDetector mGestureDetector;

    static class YScrollDetector extends SimpleOnGestureListener {
        YScrollDetector() {
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (Math.abs(f2) > Math.abs(f)) {
                return true;
            }
            return false;
        }
    }

    public InterceptHorizontalScrollView(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mGestureDetector = new GestureDetector(context, new YScrollDetector());
        setFadingEdgeLength(0);
    }

    public boolean onInterceptTouchEvent(@NonNull MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent) && this.mGestureDetector.onTouchEvent(motionEvent);
    }
}
