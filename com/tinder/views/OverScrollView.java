package com.tinder.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ScrollView;
import com.tinder.utils.C3065d;
import com.tinder.utils.C3095y;
import com.tinder.utils.ac;
import com.tinder.utils.ac.C3046a;
import com.tinder.utils.al;
import java.lang.reflect.Field;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class OverScrollView extends ScrollView implements C3046a {
    private static final int DEFAULT_OVERSCROLL = 480;
    private Context mContext;
    private boolean mDragging;
    private ac mEdgeEffect;
    private OverScrollListener mOverScrollListener;
    private int mOverScrollMax;
    private C3065d mScroller;
    private int mTouchSlop;

    public interface OverScrollListener {
        void onOverScroll(double d);
    }

    public OverScrollView(@NonNull Context context) {
        super(context);
        this.mOverScrollMax = DEFAULT_OVERSCROLL;
        this.mContext = context;
        init();
    }

    public OverScrollView(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOverScrollMax = DEFAULT_OVERSCROLL;
        this.mContext = context;
        init();
    }

    public OverScrollView(@NonNull Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOverScrollMax = DEFAULT_OVERSCROLL;
        this.mContext = context;
        init();
    }

    @TargetApi(21)
    public OverScrollView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mOverScrollMax = DEFAULT_OVERSCROLL;
        this.mContext = context;
        init();
    }

    public int getOverScrollMax() {
        return this.mOverScrollMax;
    }

    public void setOverScrollMax(int i) {
        this.mOverScrollMax = i;
    }

    private void init() {
        this.mTouchSlop = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
        try {
            this.mScroller = new C3065d(getContext());
            Field declaredField = getClass().getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            this.mScroller.m9343a(800);
            this.mScroller.setFriction(0.025f);
            declaredField.set(this, this.mScroller);
            if (!edgeEffectsCausesCrash()) {
                this.mEdgeEffect = new ac(getContext());
                this.mEdgeEffect.m9210a((C3046a) this);
                this.mEdgeEffect.m9211a(true);
                declaredField = ScrollView.class.getDeclaredField("mEdgeGlowTop");
                declaredField.setAccessible(true);
                declaredField.set(this, this.mEdgeEffect);
            }
        } catch (Throwable e) {
            C3095y.m9474a("OverScrollView parent ScrollView implementation did not contain a member variable called mScroller", e);
        } catch (Throwable e2) {
            C3095y.m9474a("Failed to set vale of mScroller field in OverScrollView parent ScrollView implementation", e2);
        }
    }

    private static boolean edgeEffectsCausesCrash() {
        return Build.MANUFACTURER.contains("HTC") && VERSION.SDK_INT == 16;
    }

    public boolean onInterceptTouchEvent(@NonNull MotionEvent motionEvent) {
        boolean a = al.m9277a(motionEvent, this.mTouchSlop, 125, 55, true, true);
        switch (motionEvent.getActionMasked()) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                super.onInterceptTouchEvent(motionEvent);
                break;
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                super.onInterceptTouchEvent(motionEvent);
                break;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                if (!a) {
                    return false;
                }
                requestDisallowInterceptTouchEvent(true);
                super.onInterceptTouchEvent(motionEvent);
                return true;
        }
        super.onInterceptTouchEvent(motionEvent);
        return false;
    }

    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        float f = ((float) (-i2)) / ((float) this.mOverScrollMax);
        if (this.mOverScrollListener != null) {
            this.mOverScrollListener.onOverScroll((double) f);
        }
    }

    public boolean isDragging() {
        return this.mDragging;
    }

    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        int i9;
        int i10 = i4 >= i6 ? this.mOverScrollMax : this.mOverScrollMax;
        if (i4 >= i6) {
            i10 = 0;
        }
        if (i2 >= 0 || i4 > 0 || z) {
            i9 = i2;
        } else {
            i10 /= 8;
            i9 = i2 / 14;
        }
        return super.overScrollBy(i, i9, i3, i4, i5, i6, i7, i10, z);
    }

    public void setOverScrollListener(OverScrollListener overScrollListener) {
        this.mOverScrollListener = overScrollListener;
    }

    public void onPull(float f, float f2) {
    }

    public void onRelease() {
        if (getScrollY() <= 0) {
            smoothScrollTo(0, 0);
        }
    }
}
