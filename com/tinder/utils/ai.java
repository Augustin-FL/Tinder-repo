package com.tinder.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class ai implements OnItemTouchListener {
    private C2495a f6546a;
    private boolean f6547b;
    private GestureDetector f6548c;

    /* renamed from: com.tinder.utils.ai.a */
    public interface C2495a {
        void m6883a(View view, int i);
    }

    /* renamed from: com.tinder.utils.ai.1 */
    class C30491 extends SimpleOnGestureListener {
        final /* synthetic */ ai f6545a;

        C30491(ai aiVar) {
            this.f6545a = aiVar;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return true;
        }
    }

    public ai(Context context, C2495a c2495a) {
        this.f6547b = true;
        this.f6546a = c2495a;
        this.f6548c = new GestureDetector(context, new C30491(this));
    }

    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (!this.f6547b) {
            return false;
        }
        View findChildViewUnder = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
        if (findChildViewUnder == null || this.f6546a == null || !this.f6548c.onTouchEvent(motionEvent)) {
            return false;
        }
        this.f6546a.m6883a(findChildViewUnder, recyclerView.getChildAdapterPosition(findChildViewUnder));
        return true;
    }

    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                this.f6547b = true;
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                this.f6547b = false;
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                this.f6547b = false;
            default:
        }
    }

    public void onRequestDisallowInterceptTouchEvent(boolean z) {
        this.f6547b = !z;
    }
}
