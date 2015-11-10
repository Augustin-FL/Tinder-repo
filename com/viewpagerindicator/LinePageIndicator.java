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
import android.support.v7.widget.RecyclerView.SmoothScroller.Action;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.tinder.views.RangeSeekBar;
import com.viewpagerindicator.C3169d.C3163a;
import com.viewpagerindicator.C3169d.C3164b;
import com.viewpagerindicator.C3169d.C3165c;
import com.viewpagerindicator.C3169d.C3166d;
import com.viewpagerindicator.C3169d.C3168f;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class LinePageIndicator extends View implements C3147c {
    private final Paint f6694a;
    private final Paint f6695b;
    private ViewPager f6696c;
    private OnPageChangeListener f6697d;
    private int f6698e;
    private boolean f6699f;
    private float f6700g;
    private float f6701h;
    private int f6702i;
    private float f6703j;
    private int f6704k;
    private boolean f6705l;

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        int f6693a;

        /* renamed from: com.viewpagerindicator.LinePageIndicator.SavedState.1 */
        static class C31501 implements Creator<SavedState> {
            C31501() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m9498a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m9499a(i);
            }

            public SavedState m9498a(Parcel parcel) {
                return new SavedState(null);
            }

            public SavedState[] m9499a(int i) {
                return new SavedState[i];
            }
        }

        static {
            CREATOR = new C31501();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f6693a = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f6693a);
        }
    }

    public LinePageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C3163a.vpiLinePageIndicatorStyle);
    }

    public LinePageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6694a = new Paint(1);
        this.f6695b = new Paint(1);
        this.f6703j = GroundOverlayOptions.NO_DIMENSION;
        this.f6704k = -1;
        if (!isInEditMode()) {
            Resources resources = getResources();
            int color = resources.getColor(C3165c.default_line_indicator_selected_color);
            int color2 = resources.getColor(C3165c.default_line_indicator_unselected_color);
            float dimension = resources.getDimension(C3166d.default_line_indicator_line_width);
            float dimension2 = resources.getDimension(C3166d.default_line_indicator_gap_width);
            float dimension3 = resources.getDimension(C3166d.default_line_indicator_stroke_width);
            boolean z = resources.getBoolean(C3164b.default_line_indicator_centered);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3168f.LinePageIndicator, i, 0);
            this.f6699f = obtainStyledAttributes.getBoolean(C3168f.LinePageIndicator_centered, z);
            this.f6700g = obtainStyledAttributes.getDimension(C3168f.LinePageIndicator_lineWidth, dimension);
            this.f6701h = obtainStyledAttributes.getDimension(C3168f.LinePageIndicator_gapWidth, dimension2);
            setStrokeWidth(obtainStyledAttributes.getDimension(C3168f.LinePageIndicator_strokeWidth, dimension3));
            this.f6694a.setColor(obtainStyledAttributes.getColor(C3168f.LinePageIndicator_unselectedColor, color2));
            this.f6695b.setColor(obtainStyledAttributes.getColor(C3168f.LinePageIndicator_selectedColor, color));
            Drawable drawable = obtainStyledAttributes.getDrawable(C3168f.LinePageIndicator_android_background);
            if (drawable != null) {
                setBackgroundDrawable(drawable);
            }
            obtainStyledAttributes.recycle();
            this.f6702i = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(context));
        }
    }

    public void setCentered(boolean z) {
        this.f6699f = z;
        invalidate();
    }

    public int getUnselectedColor() {
        return this.f6694a.getColor();
    }

    public void setUnselectedColor(int i) {
        this.f6694a.setColor(i);
        invalidate();
    }

    public int getSelectedColor() {
        return this.f6695b.getColor();
    }

    public void setSelectedColor(int i) {
        this.f6695b.setColor(i);
        invalidate();
    }

    public float getLineWidth() {
        return this.f6700g;
    }

    public void setLineWidth(float f) {
        this.f6700g = f;
        invalidate();
    }

    public float getStrokeWidth() {
        return this.f6695b.getStrokeWidth();
    }

    public void setStrokeWidth(float f) {
        this.f6695b.setStrokeWidth(f);
        this.f6694a.setStrokeWidth(f);
        invalidate();
    }

    public float getGapWidth() {
        return this.f6701h;
    }

    public void setGapWidth(float f) {
        this.f6701h = f;
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f6696c != null) {
            int count = this.f6696c.getAdapter().getCount();
            if (count == 0) {
                return;
            }
            if (this.f6698e >= count) {
                setCurrentItem(count - 1);
                return;
            }
            float width;
            float f = this.f6700g + this.f6701h;
            float f2 = (((float) count) * f) - this.f6701h;
            float paddingTop = (float) getPaddingTop();
            float paddingLeft = (float) getPaddingLeft();
            float paddingRight = (float) getPaddingRight();
            paddingTop += ((((float) getHeight()) - paddingTop) - ((float) getPaddingBottom())) / 2.0f;
            if (this.f6699f) {
                width = paddingLeft + ((((((float) getWidth()) - paddingLeft) - paddingRight) / 2.0f) - (f2 / 2.0f));
            } else {
                width = paddingLeft;
            }
            int i = 0;
            while (i < count) {
                f2 = width + (((float) i) * f);
                canvas.drawLine(f2, paddingTop, f2 + this.f6700g, paddingTop, i == this.f6698e ? this.f6695b : this.f6694a);
                i++;
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.f6696c == null || this.f6696c.getAdapter().getCount() == 0) {
            return false;
        }
        int action = motionEvent.getAction() & RangeSeekBar.INVALID_POINTER_ID;
        switch (action) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                this.f6704k = MotionEventCompat.getPointerId(motionEvent, 0);
                this.f6703j = motionEvent.getX();
                return true;
            case C3374b.SmoothProgressBar_spb_color /*1*/:
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                if (!this.f6705l) {
                    int count = this.f6696c.getAdapter().getCount();
                    int width = getWidth();
                    float f = ((float) width) / 2.0f;
                    float f2 = ((float) width) / 6.0f;
                    if (this.f6698e <= 0 || motionEvent.getX() >= f - f2) {
                        if (this.f6698e < count - 1 && motionEvent.getX() > f2 + f) {
                            if (action == 3) {
                                return true;
                            }
                            this.f6696c.setCurrentItem(this.f6698e + 1);
                            return true;
                        }
                    } else if (action == 3) {
                        return true;
                    } else {
                        this.f6696c.setCurrentItem(this.f6698e - 1);
                        return true;
                    }
                }
                this.f6705l = false;
                this.f6704k = -1;
                if (!this.f6696c.isFakeDragging()) {
                    return true;
                }
                this.f6696c.endFakeDrag();
                return true;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                float x = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f6704k));
                float f3 = x - this.f6703j;
                if (!this.f6705l && Math.abs(f3) > ((float) this.f6702i)) {
                    this.f6705l = true;
                }
                if (!this.f6705l) {
                    return true;
                }
                this.f6703j = x;
                if (!this.f6696c.isFakeDragging() && !this.f6696c.beginFakeDrag()) {
                    return true;
                }
                this.f6696c.fakeDragBy(f3);
                return true;
            case C3374b.SmoothProgressBar_spb_speed /*5*/:
                i = MotionEventCompat.getActionIndex(motionEvent);
                this.f6703j = MotionEventCompat.getX(motionEvent, i);
                this.f6704k = MotionEventCompat.getPointerId(motionEvent, i);
                return true;
            case C3374b.SmoothProgressBar_spb_progressiveStart_speed /*6*/:
                action = MotionEventCompat.getActionIndex(motionEvent);
                if (MotionEventCompat.getPointerId(motionEvent, action) == this.f6704k) {
                    if (action == 0) {
                        i = 1;
                    }
                    this.f6704k = MotionEventCompat.getPointerId(motionEvent, i);
                }
                this.f6703j = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f6704k));
                return true;
            default:
                return true;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.f6696c != viewPager) {
            if (this.f6696c != null) {
                this.f6696c.setOnPageChangeListener(null);
            }
            if (viewPager.getAdapter() == null) {
                throw new IllegalStateException("ViewPager does not have adapter instance.");
            }
            this.f6696c = viewPager;
            this.f6696c.setOnPageChangeListener(this);
            invalidate();
        }
    }

    public void setCurrentItem(int i) {
        if (this.f6696c == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        this.f6696c.setCurrentItem(i);
        this.f6698e = i;
        invalidate();
    }

    public void onPageScrollStateChanged(int i) {
        if (this.f6697d != null) {
            this.f6697d.onPageScrollStateChanged(i);
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.f6697d != null) {
            this.f6697d.onPageScrolled(i, f, i2);
        }
    }

    public void onPageSelected(int i) {
        this.f6698e = i;
        invalidate();
        if (this.f6697d != null) {
            this.f6697d.onPageSelected(i);
        }
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.f6697d = onPageChangeListener;
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(m9500a(i), m9501b(i2));
    }

    private int m9500a(int i) {
        float f;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824 || this.f6696c == null) {
            f = (float) size;
        } else {
            int count = this.f6696c.getAdapter().getCount();
            f = (((float) (count - 1)) * this.f6701h) + (((float) (getPaddingLeft() + getPaddingRight())) + (((float) count) * this.f6700g));
            if (mode == Action.UNDEFINED_DURATION) {
                f = Math.min(f, (float) size);
            }
        }
        return (int) FloatMath.ceil(f);
    }

    private int m9501b(int i) {
        float f;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            f = (float) size;
        } else {
            f = (this.f6695b.getStrokeWidth() + ((float) getPaddingTop())) + ((float) getPaddingBottom());
            if (mode == Action.UNDEFINED_DURATION) {
                f = Math.min(f, (float) size);
            }
        }
        return (int) FloatMath.ceil(f);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f6698e = savedState.f6693a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f6693a = this.f6698e;
        return savedState;
    }
}
