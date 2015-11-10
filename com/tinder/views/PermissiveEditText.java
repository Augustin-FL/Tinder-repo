package com.tinder.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class PermissiveEditText extends CustomEditText {
    protected boolean mIsEditable;
    private boolean mShouldTouchesBePassedOn;

    public PermissiveEditText(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setShouldTouchesBePassedOn(boolean z) {
        this.mShouldTouchesBePassedOn = z;
    }

    public boolean shouldTouchesBePassedOn() {
        return this.mShouldTouchesBePassedOn;
    }

    public final boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (this.mShouldTouchesBePassedOn) {
            return false;
        }
        if (this.mIsEditable) {
            return super.onTouchEvent(motionEvent);
        }
        return onAllowedTouchEvent(motionEvent);
    }

    public boolean onAllowedTouchEvent(@NonNull MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public boolean isEditable() {
        return this.mIsEditable;
    }

    public void setIsEditable(boolean z) {
        this.mIsEditable = z;
    }
}
