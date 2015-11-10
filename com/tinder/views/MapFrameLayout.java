package com.tinder.views;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v4.view.GestureDetectorCompat;
import android.util.AttributeSet;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tinder.managers.C2807a;

public class MapFrameLayout extends FrameLayout {
    private GestureDetectorCompat mGestureDetector;
    private SimpleOnGestureListener mSimpleOnGestureListener;

    /* renamed from: com.tinder.views.MapFrameLayout.1 */
    class C31191 extends SimpleOnGestureListener {

        /* renamed from: com.tinder.views.MapFrameLayout.1.1 */
        class C31181 implements Runnable {
            C31181() {
            }

            public void run() {
                C2807a.m8058a("Passport.MapMove");
            }
        }

        C31191() {
        }

        public boolean onFling(MotionEvent motionEvent, @NonNull MotionEvent motionEvent2, float f, float f2) {
            int actionMasked = motionEvent2.getActionMasked();
            if (actionMasked == 1 || actionMasked == 3) {
                AsyncTask.execute(new C31181());
            }
            return true;
        }
    }

    public MapFrameLayout(Context context) {
        super(context);
        init();
    }

    public MapFrameLayout(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MapFrameLayout(@NonNull Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.mSimpleOnGestureListener = new C31191();
        this.mGestureDetector = new GestureDetectorCompat(getContext(), this.mSimpleOnGestureListener);
    }

    public boolean dispatchTouchEvent(@NonNull MotionEvent motionEvent) {
        this.mGestureDetector.onTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }
}
