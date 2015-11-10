package com.tinder.views;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tinder.utils.C3095y;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class SwipeDetector implements OnTouchListener {
    private static final float DEGREES_180 = 180.0f;
    private static final float DEGREES_270 = 270.0f;
    private static final float DEGREES_360 = 360.0f;
    private static final float DEGREES_90 = 90.0f;
    private static final float THRESHOLD_ADJUSTMENT_STARTING_COORDINATE = 46.0f;
    float VELOCITY_PERCENT_OF_NORMAL_SWIPE;
    private boolean mAlwaysInTapRegion;
    private float mClickThreshold;
    private float mClickThresholdSquared;
    private float mDeltaX;
    private float mDeltaY;
    private float mDragOffsetX;
    private float mDragOffsetY;
    private float mEndX;
    private float mEndY;
    private float mLeftBounds;
    private float mRightBounds;
    private float mStartX;
    private float mStartY;
    private SwipeDetectorListener mSwipeDetectorListener;
    private float mSwipeDownAngle;
    private float mSwipeRightAngle;
    private float mSwipeThreshold;
    private float mSwipeUpAngle;
    private boolean mSwipeUpEnabled;
    private float mTopSwipeThreshold;
    private float mUpSwipeVelocitySlop;
    private int mVelocityDistanceMin;
    private int mVelocityDistanceMinSwipeUp;
    private float mVelocitySlop;
    @Nullable
    private VelocityTracker mVelocityTracker;
    private float mVelocityX;
    private float mVelocityY;

    public interface SwipeDetectorListener {
        void onTouchMove(MotionEvent motionEvent, float f, float f2, float f3, float f4, float f5, float f6);

        void onTouchUp(MotionEvent motionEvent, float f, float f2, float f3, float f4, boolean z, boolean z2, boolean z3, boolean z4, boolean z5);
    }

    public SwipeDetector(SwipeDetectorListener swipeDetectorListener) {
        this.VELOCITY_PERCENT_OF_NORMAL_SWIPE = 0.4f;
        this.mSwipeRightAngle = 70.0f;
        this.mSwipeUpAngle = 15.0f;
        this.mSwipeDownAngle = 70.0f;
        this.mSwipeDetectorListener = swipeDetectorListener;
    }

    public void setMinimumSwipeVelocity(float f) {
        this.mVelocitySlop = f;
    }

    public void setMinimumUpSwipeVelocity(float f) {
        this.mUpSwipeVelocitySlop = f;
    }

    public void setClickThreshold(float f) {
        this.mClickThreshold = f;
        this.mClickThresholdSquared = this.mClickThreshold * this.mClickThreshold;
    }

    public float getSwipeThreshold() {
        return this.mSwipeThreshold;
    }

    public void setSwipeThreshold(float f) {
        this.mSwipeThreshold = f;
        this.mVelocityDistanceMin = (int) (this.VELOCITY_PERCENT_OF_NORMAL_SWIPE * f);
    }

    public void setTopSwipeThreshold(float f) {
        this.mTopSwipeThreshold = f;
        this.mVelocityDistanceMinSwipeUp = (int) (this.VELOCITY_PERCENT_OF_NORMAL_SWIPE * f);
    }

    public void setSwipeUpEnabled(boolean z) {
        this.mSwipeUpEnabled = z;
    }

    public float getStartX() {
        return this.mStartX;
    }

    public float getEndX() {
        return this.mEndX;
    }

    public float getStartY() {
        return this.mStartY;
    }

    public float getEndY() {
        return this.mEndY;
    }

    public float getDeltaX() {
        return this.mDeltaX;
    }

    public float getDeltaY() {
        return this.mDeltaY;
    }

    public float getDragOffsetX() {
        return this.mDragOffsetX;
    }

    public float getDragOffsetY() {
        return this.mDragOffsetY;
    }

    public float getVelocityX() {
        return this.mVelocityX;
    }

    public float getVelocityY() {
        return this.mVelocityY;
    }

    private boolean withinLeftRightBounds() {
        C3095y.m9471a("mEndx:" + this.mEndX + ", getLeftBounds:" + getLeftBounds() + ", getRightBounds" + getRightBounds());
        return this.mEndX > getLeftBounds() && this.mEndX < getRightBounds();
    }

    public void setSwipeBoundaries(float f, float f2) {
        setSwipeBoundaries(f, f2, f2);
    }

    public void setSwipeBoundaries(float f, float f2, float f3) {
        this.mSwipeRightAngle = f;
        this.mSwipeUpAngle = f2;
        this.mSwipeDownAngle = f3;
    }

    private void calculateSwipeBounds(MotionEvent motionEvent, float f, float f2) {
        boolean z;
        double atan2 = Math.atan2((double) (-f2), (double) f);
        float toDegrees = (float) Math.toDegrees(atan2);
        C3095y.m9471a("angle radians:" + atan2);
        C3095y.m9471a("angle degrees:" + toDegrees);
        if (toDegrees < 0.0f) {
            toDegrees += DEGREES_360;
        }
        C3095y.m9471a("angle degrees adjusted:" + toDegrees);
        float f3 = DEGREES_360 - this.mSwipeRightAngle;
        float f4 = this.mSwipeRightAngle;
        C3095y.m9471a(String.format("Swipe boundaries --\nswipeRightStart[%s] swipeRightEnd[%s]\nswipeUpStart[%s] swipeUpEnd[%s]\nswipeLeftStart[%s] swipeLeftEnd[%s]\n +swipeDownStart[%s]swipeDownEnd[%s]\n", new Object[]{Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(DEGREES_90 - this.mSwipeUpAngle), Float.valueOf(DEGREES_90 + this.mSwipeUpAngle), Float.valueOf(DEGREES_180 - this.mSwipeRightAngle), Float.valueOf(DEGREES_180 + this.mSwipeRightAngle), Float.valueOf(DEGREES_270 - this.mSwipeDownAngle), Float.valueOf(DEGREES_270 + this.mSwipeDownAngle)}));
        boolean z2 = toDegrees >= f3 || toDegrees <= f4;
        boolean z3 = toDegrees >= r7 && toDegrees <= r8;
        boolean z4 = toDegrees >= r4 && toDegrees <= r6;
        boolean z5 = toDegrees >= r10 && toDegrees <= r13;
        C3095y.m9471a(String.format("swipe detection:\nswipeRight[%s]\nswipeUp[%s]\nswipeLeft[%s]\nswipeDown[%s]\n ", new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z4), Boolean.valueOf(z3), Boolean.valueOf(z5)}));
        z5 = Math.abs(this.mVelocityY) >= this.mUpSwipeVelocitySlop && Math.abs(this.mDeltaY) > ((float) this.mVelocityDistanceMin);
        boolean z6 = Math.abs(this.mVelocityY) < this.mUpSwipeVelocitySlop && this.mEndY < this.mTopSwipeThreshold + ((float) 70) && withinLeftRightBounds();
        boolean z7 = toDegrees >= THRESHOLD_ADJUSTMENT_STARTING_COORDINATE && toDegrees <= f4;
        C3095y.m9471a("degrees: " + toDegrees + "<= swipeRightBoundaryEnds: (" + f4 + ") " + (toDegrees <= f4) + ", degrees >= THRESHOLD_ADJUSTMENT_STARTING_COORDINATE):" + (toDegrees >= THRESHOLD_ADJUSTMENT_STARTING_COORDINATE));
        if (((double) Math.abs(this.mVelocityX)) >= (z7 ? ((double) this.mVelocitySlop) - 0.6d : (double) this.mVelocitySlop)) {
            if (Math.abs(this.mDeltaX) > ((float) (z7 ? this.mVelocityDistanceMin - 180 : this.mVelocityDistanceMin))) {
                z = true;
                C3095y.m9471a("velocityDistanceMin:" + this.mVelocityDistanceMin + "adjustFlingRequirements:" + z7);
                z7 = Math.abs(this.mDeltaX) <= this.mSwipeThreshold && !z && this.mEndY > this.mTopSwipeThreshold + ((float) 70);
                if (!this.mSwipeUpEnabled && z4 && (z5 || z6)) {
                    C3095y.m9471a(String.format("swipe interaction: within coordinate bounds of upSwipe, satisifies isFling[%s] isDrag[%s]", new Object[]{Boolean.valueOf(z5), Boolean.valueOf(z6)}));
                    this.mSwipeDetectorListener.onTouchUp(motionEvent, this.mDeltaX, this.mDeltaY, this.mVelocityX, this.mVelocityY, false, false, true, false, false);
                    return;
                } else if ((!z3 || z2) && (z || z7)) {
                    C3095y.m9471a(String.format("swipe interaction: within bounds of leftSwipe[%s] rightSwipe[%s], satisfies isFling[%s] isDrag[%s]", new Object[]{Boolean.valueOf(z3), Boolean.valueOf(z2), Boolean.valueOf(z), Boolean.valueOf(z7)}));
                    this.mSwipeDetectorListener.onTouchUp(motionEvent, this.mDeltaX, this.mDeltaY, this.mVelocityX, this.mVelocityY, false, false, false, z2, z3);
                } else {
                    C3095y.m9471a(String.format("swipe interaction: within bounds of leftSwipe[%s] rightSwipe[%s], satisfies isFling[%s] isDrag[%s]", new Object[]{Boolean.valueOf(z3), Boolean.valueOf(z2), Boolean.valueOf(z), Boolean.valueOf(z7)}));
                    C3095y.m9471a("swipe interaction: non-swipe or dead zone. mDeltaX:" + this.mDeltaX + ", swipeThreshold:" + this.mSwipeThreshold);
                    this.mSwipeDetectorListener.onTouchUp(motionEvent, this.mDeltaX, this.mDeltaY, this.mVelocityX, this.mVelocityY, true, this.mAlwaysInTapRegion, false, false, false);
                    return;
                }
            }
        }
        z = false;
        C3095y.m9471a("velocityDistanceMin:" + this.mVelocityDistanceMin + "adjustFlingRequirements:" + z7);
        if (Math.abs(this.mDeltaX) <= this.mSwipeThreshold) {
        }
        if (!this.mSwipeUpEnabled) {
        }
        if (z3) {
        }
        C3095y.m9471a(String.format("swipe interaction: within bounds of leftSwipe[%s] rightSwipe[%s], satisfies isFling[%s] isDrag[%s]", new Object[]{Boolean.valueOf(z3), Boolean.valueOf(z2), Boolean.valueOf(z), Boolean.valueOf(z7)}));
        this.mSwipeDetectorListener.onTouchUp(motionEvent, this.mDeltaX, this.mDeltaY, this.mVelocityX, this.mVelocityY, false, false, false, z2, z3);
    }

    public boolean onTouch(View view, @NonNull MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                this.mStartX = motionEvent.getRawX();
                this.mStartY = motionEvent.getRawY();
                this.mVelocityTracker = VelocityTracker.obtain();
                this.mAlwaysInTapRegion = true;
                break;
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                if (this.mVelocityTracker == null) {
                    this.mVelocityTracker = VelocityTracker.obtain();
                }
                this.mVelocityTracker.computeCurrentVelocity(1);
                this.mVelocityX = this.mVelocityTracker.getXVelocity();
                this.mVelocityY = this.mVelocityTracker.getYVelocity();
                this.mEndX = motionEvent.getRawX();
                this.mEndY = motionEvent.getRawY();
                this.mDeltaX = motionEvent.getRawX() - this.mStartX;
                this.mDeltaY = motionEvent.getRawY() - this.mStartY;
                C3095y.m9471a(String.format("swipe values: deltaX[%s], deltaY[%s], velocityX[%s], velocityY[%s], upSwipeVelocitySlop[%s], velocityDistanceMinSwipeup[%s], topSwipeThreshold[%s]", new Object[]{Float.valueOf(this.mDeltaX), Float.valueOf(this.mDeltaY), Float.valueOf(this.mVelocityX), Float.valueOf(this.mVelocityY), Float.valueOf(this.mUpSwipeVelocitySlop), Integer.valueOf(this.mVelocityDistanceMinSwipeUp), Float.valueOf(this.mTopSwipeThreshold)}));
                calculateSwipeBounds(motionEvent, this.mDeltaX, this.mDeltaY);
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                break;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                if (this.mVelocityTracker == null) {
                    this.mVelocityTracker = VelocityTracker.obtain();
                }
                this.mVelocityTracker.addMovement(motionEvent);
                this.mDeltaX = motionEvent.getRawX() - this.mStartX;
                this.mDeltaY = motionEvent.getRawY() - this.mStartY;
                if (this.mAlwaysInTapRegion && (this.mDeltaX * this.mDeltaX) + (this.mDeltaY * this.mDeltaY) > this.mClickThresholdSquared) {
                    this.mAlwaysInTapRegion = false;
                }
                this.mDragOffsetX = Math.min(1.0f, Math.abs(this.mDeltaX) / this.mSwipeThreshold);
                this.mDragOffsetY = Math.min(1.0f, Math.abs(this.mDeltaY) / this.mTopSwipeThreshold);
                this.mSwipeDetectorListener.onTouchMove(motionEvent, this.mDragOffsetX, this.mDragOffsetY, this.mDeltaX, this.mDeltaY, this.mVelocityX, this.mVelocityY);
                break;
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.recycle();
                    this.mVelocityTracker = null;
                    break;
                }
                break;
        }
        return true;
    }

    public float getLeftBounds() {
        return this.mLeftBounds;
    }

    public void setLeftBounds(float f) {
        this.mLeftBounds = f;
    }

    public float getRightBounds() {
        return this.mRightBounds;
    }

    public void setRightBounds(float f) {
        this.mRightBounds = f;
    }
}
