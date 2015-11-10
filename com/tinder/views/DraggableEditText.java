package com.tinder.views;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.tinder.utils.C3095y;
import com.tinder.utils.CustomFont;
import com.tinder.utils.al;

public class DraggableEditText extends PermissiveEditText {
    private RectF mBoundsRect;
    private GestureDetector mGestureDetector;
    private boolean mIsDraggable;
    private float mLastY;
    private int mPositionAboveKeyboard;

    /* renamed from: com.tinder.views.DraggableEditText.1 */
    class C31151 implements OnGestureListener {
        C31151() {
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public void onShowPress(MotionEvent motionEvent) {
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            DraggableEditText.this.callOnClick();
            return true;
        }

        public boolean onScroll(MotionEvent motionEvent, @NonNull MotionEvent motionEvent2, float f, float f2) {
            DraggableEditText.this.scrollVertical(Math.round(motionEvent2.getRawY() + f) - (DraggableEditText.this.getHeight() / 2));
            return true;
        }

        public void onLongPress(MotionEvent motionEvent) {
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }
    }

    public DraggableEditText(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        al.m9280a((View) this, context, CustomFont.m9193a(context, attributeSet));
        init(context);
    }

    public void init(Context context) {
        this.mGestureDetector = new GestureDetector(getContext(), new C31151());
    }

    public boolean onAllowedTouchEvent(@NonNull MotionEvent motionEvent) {
        if (this.mIsDraggable) {
            return this.mGestureDetector.onTouchEvent(motionEvent);
        }
        if (this.mIsEditable) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    private void scrollVertical(int i) {
        if (((float) (getMeasuredHeight() + i)) <= this.mBoundsRect.bottom && ((float) i) >= this.mBoundsRect.top) {
            setY((float) i);
            this.mLastY = (float) i;
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        moveAboveKeyboard(false);
    }

    public void animateTo(float f, float f2) {
        ObjectAnimator.ofFloat(this, "translationY", new float[]{f, f2}).start();
    }

    public void moveAboveKeyboard(boolean z) {
        int i = 0;
        measure(0, 0);
        if (!knowsKeyboardLocation()) {
            Rect rect = new Rect();
            getRootView().getWindowVisibleDisplayFrame(rect);
            if (rect.bottom != al.m9285b(getContext())) {
                i = rect.bottom;
            }
            this.mPositionAboveKeyboard = i;
        }
        if (knowsKeyboardLocation()) {
            float measuredHeight = (float) (this.mPositionAboveKeyboard - getMeasuredHeight());
            if (z) {
                animate().y(measuredHeight).setInterpolator(new DecelerateInterpolator()).setDuration(300).start();
            } else {
                setY(measuredHeight);
            }
        }
        C3095y.m9471a("pok " + this.mPositionAboveKeyboard);
    }

    public void resetToLastPosition() {
        if (this.mLastY != 0.0f) {
            measure(0, 0);
            animate().y(this.mLastY).setInterpolator(new DecelerateInterpolator()).setDuration(400).start();
        }
    }

    public boolean isDraggable() {
        return this.mIsDraggable;
    }

    public void setDraggable(boolean z) {
        this.mIsDraggable = z;
    }

    public void setDragBounds(RectF rectF) {
        this.mBoundsRect = rectF;
    }

    public boolean knowsKeyboardLocation() {
        return this.mPositionAboveKeyboard != 0;
    }

    public boolean onKeyPreIme(int i, @NonNull KeyEvent keyEvent) {
        onEditorAction(i);
        return super.onKeyPreIme(i, keyEvent);
    }

    public InputConnection onCreateInputConnection(@NonNull EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        editorInfo.imeOptions &= -1073741825;
        return onCreateInputConnection;
    }
}
