package com.tinder.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tinder.utils.C3095y;
import com.tinder.utils.al;
import com.tinder.video.VideoEnabledWebView;

public class LiveRailWebView extends VideoEnabledWebView {

    public enum LiveRailCommand {
        load,
        setup,
        pause
    }

    public LiveRailWebView(Context context) {
        super(context);
        init();
    }

    public LiveRailWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void runCommand(LiveRailCommand liveRailCommand) {
        loadUrl(String.format("javascript:%s()", new Object[]{liveRailCommand}));
    }

    private void init() {
    }

    public void simulateMotionEvent(@NonNull MotionEvent motionEvent) {
        Point a = al.m9263a((View) this);
        float rawX = (motionEvent.getRawX() - ((float) a.x)) * (750.0f / ((float) getMeasuredWidth()));
        float rawY = (motionEvent.getRawY() - ((float) a.y)) * (750.0f / ((float) getMeasuredHeight()));
        C3095y.m9485e("Simulated motion event at (" + rawX + ", " + rawY + ")");
        loadUrl("javascript:click(" + rawX + ", " + rawY + ')');
    }

    protected void dispatchDraw(@NonNull Canvas canvas) {
        super.dispatchDraw(canvas);
        if (VERSION.SDK_INT <= 18) {
            postInvalidate();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }
}
