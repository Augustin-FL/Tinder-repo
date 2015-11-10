package com.viewpagerindicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewConfiguration;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.tinder.views.RangeSeekBar;
import com.viewpagerindicator.C3169d.C3163a;
import com.viewpagerindicator.C3169d.C3164b;
import com.viewpagerindicator.C3169d.C3165c;
import com.viewpagerindicator.C3169d.C3167e;
import com.viewpagerindicator.C3169d.C3168f;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class UnderlinePageIndicator extends View implements C3147c {
    private final Paint f6761a;
    private boolean f6762b;
    private int f6763c;
    private int f6764d;
    private int f6765e;
    private final Runnable f6766f;
    private ViewPager f6767g;
    private OnPageChangeListener f6768h;
    private int f6769i;
    private int f6770j;
    private float f6771k;
    private int f6772l;
    private float f6773m;
    private int f6774n;
    private boolean f6775o;

    /* renamed from: com.viewpagerindicator.UnderlinePageIndicator.1 */
    class C31581 implements Runnable {
        final /* synthetic */ UnderlinePageIndicator f6758a;

        C31581(UnderlinePageIndicator underlinePageIndicator) {
            this.f6758a = underlinePageIndicator;
        }

        public void run() {
            if (this.f6758a.f6762b) {
                int max = Math.max(this.f6758a.f6761a.getAlpha() - this.f6758a.f6765e, 0);
                this.f6758a.f6761a.setAlpha(max);
                this.f6758a.invalidate();
                if (max > 0) {
                    this.f6758a.postDelayed(this, 30);
                }
            }
        }
    }

    /* renamed from: com.viewpagerindicator.UnderlinePageIndicator.2 */
    class C31592 implements Runnable {
        final /* synthetic */ UnderlinePageIndicator f6759a;

        C31592(UnderlinePageIndicator underlinePageIndicator) {
            this.f6759a = underlinePageIndicator;
        }

        public void run() {
            if (this.f6759a.f6762b) {
                this.f6759a.post(this.f6759a.f6766f);
            }
        }
    }

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        int f6760a;

        /* renamed from: com.viewpagerindicator.UnderlinePageIndicator.SavedState.1 */
        static class C31601 implements Creator<SavedState> {
            C31601() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m9522a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m9523a(i);
            }

            public SavedState m9522a(Parcel parcel) {
                return new SavedState(null);
            }

            public SavedState[] m9523a(int i) {
                return new SavedState[i];
            }
        }

        static {
            CREATOR = new C31601();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f6760a = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f6760a);
        }
    }

    public UnderlinePageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C3163a.vpiUnderlinePageIndicatorStyle);
    }

    public UnderlinePageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6761a = new Paint(1);
        this.f6766f = new C31581(this);
        this.f6773m = GroundOverlayOptions.NO_DIMENSION;
        this.f6774n = -1;
        if (!isInEditMode()) {
            Resources resources = getResources();
            boolean z = resources.getBoolean(C3164b.default_underline_indicator_fades);
            int integer = resources.getInteger(C3167e.default_underline_indicator_fade_delay);
            int integer2 = resources.getInteger(C3167e.default_underline_indicator_fade_length);
            int color = resources.getColor(C3165c.default_underline_indicator_selected_color);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3168f.UnderlinePageIndicator, i, 0);
            setFades(obtainStyledAttributes.getBoolean(C3168f.UnderlinePageIndicator_fades, z));
            setSelectedColor(obtainStyledAttributes.getColor(C3168f.UnderlinePageIndicator_selectedColor, color));
            setFadeDelay(obtainStyledAttributes.getInteger(C3168f.UnderlinePageIndicator_fadeDelay, integer));
            setFadeLength(obtainStyledAttributes.getInteger(C3168f.UnderlinePageIndicator_fadeLength, integer2));
            Drawable drawable = obtainStyledAttributes.getDrawable(C3168f.UnderlinePageIndicator_android_background);
            if (drawable != null) {
                setBackgroundDrawable(drawable);
            }
            obtainStyledAttributes.recycle();
            this.f6772l = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(context));
        }
    }

    public boolean getFades() {
        return this.f6762b;
    }

    public void setFades(boolean z) {
        if (z != this.f6762b) {
            this.f6762b = z;
            if (z) {
                post(this.f6766f);
                return;
            }
            removeCallbacks(this.f6766f);
            this.f6761a.setAlpha(RangeSeekBar.INVALID_POINTER_ID);
            invalidate();
        }
    }

    public int getFadeDelay() {
        return this.f6763c;
    }

    public void setFadeDelay(int i) {
        this.f6763c = i;
    }

    public int getFadeLength() {
        return this.f6764d;
    }

    public void setFadeLength(int i) {
        this.f6764d = i;
        this.f6765e = RangeSeekBar.INVALID_POINTER_ID / (this.f6764d / 30);
    }

    public int getSelectedColor() {
        return this.f6761a.getColor();
    }

    public void setSelectedColor(int i) {
        this.f6761a.setColor(i);
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f6767g != null) {
            int count = this.f6767g.getAdapter().getCount();
            if (count == 0) {
                return;
            }
            if (this.f6770j >= count) {
                setCurrentItem(count - 1);
                return;
            }
            int paddingLeft = getPaddingLeft();
            float width = ((float) ((getWidth() - paddingLeft) - getPaddingRight())) / (((float) count) * 1.0f);
            float f = ((float) paddingLeft) + ((((float) this.f6770j) + this.f6771k) * width);
            float f2 = f + width;
            canvas.drawRect(f, (float) getPaddingTop(), f2, (float) (getHeight() - getPaddingBottom()), this.f6761a);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.f6767g == null || this.f6767g.getAdapter().getCount() == 0) {
            return false;
        }
        int action = motionEvent.getAction() & RangeSeekBar.INVALID_POINTER_ID;
        switch (action) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                this.f6774n = MotionEventCompat.getPointerId(motionEvent, 0);
                this.f6773m = motionEvent.getX();
                return true;
            case C3374b.SmoothProgressBar_spb_color /*1*/:
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                if (!this.f6775o) {
                    int count = this.f6767g.getAdapter().getCount();
                    int width = getWidth();
                    float f = ((float) width) / 2.0f;
                    float f2 = ((float) width) / 6.0f;
                    if (this.f6770j <= 0 || motionEvent.getX() >= f - f2) {
                        if (this.f6770j < count - 1 && motionEvent.getX() > f2 + f) {
                            if (action == 3) {
                                return true;
                            }
                            this.f6767g.setCurrentItem(this.f6770j + 1);
                            return true;
                        }
                    } else if (action == 3) {
                        return true;
                    } else {
                        this.f6767g.setCurrentItem(this.f6770j - 1);
                        return true;
                    }
                }
                this.f6775o = false;
                this.f6774n = -1;
                if (!this.f6767g.isFakeDragging()) {
                    return true;
                }
                this.f6767g.endFakeDrag();
                return true;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                float x = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f6774n));
                float f3 = x - this.f6773m;
                if (!this.f6775o && Math.abs(f3) > ((float) this.f6772l)) {
                    this.f6775o = true;
                }
                if (!this.f6775o) {
                    return true;
                }
                this.f6773m = x;
                if (!this.f6767g.isFakeDragging() && !this.f6767g.beginFakeDrag()) {
                    return true;
                }
                this.f6767g.fakeDragBy(f3);
                return true;
            case C3374b.SmoothProgressBar_spb_speed /*5*/:
                i = MotionEventCompat.getActionIndex(motionEvent);
                this.f6773m = MotionEventCompat.getX(motionEvent, i);
                this.f6774n = MotionEventCompat.getPointerId(motionEvent, i);
                return true;
            case C3374b.SmoothProgressBar_spb_progressiveStart_speed /*6*/:
                action = MotionEventCompat.getActionIndex(motionEvent);
                if (MotionEventCompat.getPointerId(motionEvent, action) == this.f6774n) {
                    if (action == 0) {
                        i = 1;
                    }
                    this.f6774n = MotionEventCompat.getPointerId(motionEvent, i);
                }
                this.f6773m = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f6774n));
                return true;
            default:
                return true;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.f6767g != viewPager) {
            if (this.f6767g != null) {
                this.f6767g.setOnPageChangeListener(null);
            }
            if (viewPager.getAdapter() == null) {
                throw new IllegalStateException("ViewPager does not have adapter instance.");
            }
            this.f6767g = viewPager;
            this.f6767g.setOnPageChangeListener(this);
            invalidate();
            post(new C31592(this));
        }
    }

    public void setCurrentItem(int i) {
        if (this.f6767g == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        this.f6767g.setCurrentItem(i);
        this.f6770j = i;
        invalidate();
    }

    public void onPageScrollStateChanged(int i) {
        this.f6769i = i;
        if (this.f6768h != null) {
            this.f6768h.onPageScrollStateChanged(i);
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        this.f6770j = i;
        this.f6771k = f;
        if (this.f6762b) {
            if (i2 > 0) {
                removeCallbacks(this.f6766f);
                this.f6761a.setAlpha(RangeSeekBar.INVALID_POINTER_ID);
            } else if (this.f6769i != 1) {
                postDelayed(this.f6766f, (long) this.f6763c);
            }
        }
        invalidate();
        if (this.f6768h != null) {
            this.f6768h.onPageScrolled(i, f, i2);
        }
    }

    public void onPageSelected(int i) {
        if (this.f6769i == 0) {
            this.f6770j = i;
            this.f6771k = 0.0f;
            invalidate();
            this.f6766f.run();
        }
        if (this.f6768h != null) {
            this.f6768h.onPageSelected(i);
        }
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.f6768h = onPageChangeListener;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f6770j = savedState.f6760a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f6760a = this.f6770j;
        return savedState;
    }
}
