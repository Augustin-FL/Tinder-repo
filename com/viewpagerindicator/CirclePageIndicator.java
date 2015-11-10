package com.viewpagerindicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
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
import com.viewpagerindicator.C3169d.C3167e;
import com.viewpagerindicator.C3169d.C3168f;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class CirclePageIndicator extends View implements C3147c {
    private final Paint f6668a;
    private final Paint f6669b;
    private final Paint f6670c;
    private int f6671d;
    private float f6672e;
    private ViewPager f6673f;
    private OnPageChangeListener f6674g;
    private int f6675h;
    private int f6676i;
    private float f6677j;
    private int f6678k;
    private int f6679l;
    private boolean f6680m;
    private boolean f6681n;
    private int f6682o;
    private float f6683p;
    private boolean f6684q;
    private float f6685r;

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        int f6667a;

        /* renamed from: com.viewpagerindicator.CirclePageIndicator.SavedState.1 */
        static class C31461 implements Creator<SavedState> {
            C31461() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m9490a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m9491a(i);
            }

            public SavedState m9490a(Parcel parcel) {
                return new SavedState(null);
            }

            public SavedState[] m9491a(int i) {
                return new SavedState[i];
            }
        }

        static {
            CREATOR = new C31461();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f6667a = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f6667a);
        }
    }

    public CirclePageIndicator(Context context) {
        this(context, null);
    }

    public CirclePageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C3163a.vpiCirclePageIndicatorStyle);
    }

    public CirclePageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6668a = new Paint(1);
        this.f6669b = new Paint(1);
        this.f6670c = new Paint(1);
        this.f6671d = -1;
        this.f6683p = GroundOverlayOptions.NO_DIMENSION;
        if (!isInEditMode()) {
            Resources resources = getResources();
            int color = resources.getColor(C3165c.default_circle_indicator_page_color);
            int color2 = resources.getColor(C3165c.default_circle_indicator_fill_color);
            int integer = resources.getInteger(C3167e.default_circle_indicator_orientation);
            int color3 = resources.getColor(C3165c.default_circle_indicator_stroke_color);
            float dimension = resources.getDimension(C3166d.default_circle_indicator_stroke_width);
            float dimension2 = resources.getDimension(C3166d.default_circle_indicator_radius);
            boolean z = resources.getBoolean(C3164b.default_circle_indicator_centered);
            boolean z2 = resources.getBoolean(C3164b.default_circle_indicator_snap);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3168f.CirclePageIndicator, i, 0);
            this.f6680m = obtainStyledAttributes.getBoolean(C3168f.CirclePageIndicator_centered, z);
            this.f6679l = obtainStyledAttributes.getInt(C3168f.CirclePageIndicator_android_orientation, integer);
            this.f6668a.setStyle(Style.FILL);
            this.f6668a.setColor(obtainStyledAttributes.getColor(C3168f.CirclePageIndicator_pageColor, color));
            this.f6669b.setStyle(Style.STROKE);
            this.f6669b.setColor(obtainStyledAttributes.getColor(C3168f.CirclePageIndicator_strokeColor, color3));
            this.f6669b.setStrokeWidth(obtainStyledAttributes.getDimension(C3168f.CirclePageIndicator_strokeWidth, dimension));
            this.f6670c.setStyle(Style.FILL);
            this.f6670c.setColor(obtainStyledAttributes.getColor(C3168f.CirclePageIndicator_fillColor, color2));
            this.f6672e = obtainStyledAttributes.getDimension(C3168f.CirclePageIndicator_radius, dimension2);
            this.f6681n = obtainStyledAttributes.getBoolean(C3168f.CirclePageIndicator_snap, z2);
            this.f6685r = obtainStyledAttributes.getDimension(C3168f.CirclePageIndicator_extraSpacing, 0.0f);
            Drawable drawable = obtainStyledAttributes.getDrawable(C3168f.CirclePageIndicator_android_background);
            if (drawable != null) {
                setBackgroundDrawable(drawable);
            }
            obtainStyledAttributes.recycle();
            this.f6682o = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(context));
        }
    }

    public void setCentered(boolean z) {
        this.f6680m = z;
        invalidate();
    }

    public int getPageColor() {
        return this.f6668a.getColor();
    }

    public void setPageColor(int i) {
        this.f6668a.setColor(i);
        invalidate();
    }

    public int getFillColor() {
        return this.f6670c.getColor();
    }

    public void setFillColor(int i) {
        this.f6670c.setColor(i);
        invalidate();
    }

    public int getOrientation() {
        return this.f6679l;
    }

    public void setOrientation(int i) {
        switch (i) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                this.f6679l = i;
                requestLayout();
            default:
                throw new IllegalArgumentException("Orientation must be either HORIZONTAL or VERTICAL.");
        }
    }

    public int getStrokeColor() {
        return this.f6669b.getColor();
    }

    public void setStrokeColor(int i) {
        this.f6669b.setColor(i);
        invalidate();
    }

    public float getStrokeWidth() {
        return this.f6669b.getStrokeWidth();
    }

    public void setStrokeWidth(float f) {
        this.f6669b.setStrokeWidth(f);
        invalidate();
    }

    public float getRadius() {
        return this.f6672e;
    }

    public void setRadius(float f) {
        this.f6672e = f;
        invalidate();
    }

    public void setSnap(boolean z) {
        this.f6681n = z;
        invalidate();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.f6673f == null || this.f6673f.getAdapter().getCount() == 0) {
            return false;
        }
        int action = motionEvent.getAction() & RangeSeekBar.INVALID_POINTER_ID;
        switch (action) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                this.f6671d = MotionEventCompat.getPointerId(motionEvent, 0);
                this.f6683p = motionEvent.getX();
                return true;
            case C3374b.SmoothProgressBar_spb_color /*1*/:
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                if (!this.f6684q) {
                    int count = this.f6673f.getAdapter().getCount();
                    int width = getWidth();
                    float f = ((float) width) / 2.0f;
                    float f2 = ((float) width) / 6.0f;
                    if (this.f6675h <= 0 || motionEvent.getX() >= f - f2) {
                        if (this.f6675h < count - 1 && motionEvent.getX() > f2 + f) {
                            if (action == 3) {
                                return true;
                            }
                            this.f6673f.setCurrentItem(this.f6675h + 1);
                            return true;
                        }
                    } else if (action == 3) {
                        return true;
                    } else {
                        this.f6673f.setCurrentItem(this.f6675h - 1);
                        return true;
                    }
                }
                this.f6684q = false;
                this.f6671d = -1;
                if (!this.f6673f.isFakeDragging()) {
                    return true;
                }
                this.f6673f.endFakeDrag();
                return true;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                float x = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f6671d));
                float f3 = x - this.f6683p;
                if (!this.f6684q && Math.abs(f3) > ((float) this.f6682o)) {
                    this.f6684q = true;
                }
                if (!this.f6684q) {
                    return true;
                }
                this.f6683p = x;
                if (!this.f6673f.isFakeDragging() && !this.f6673f.beginFakeDrag()) {
                    return true;
                }
                this.f6673f.fakeDragBy(f3);
                return true;
            case C3374b.SmoothProgressBar_spb_speed /*5*/:
                i = MotionEventCompat.getActionIndex(motionEvent);
                this.f6683p = MotionEventCompat.getX(motionEvent, i);
                this.f6671d = MotionEventCompat.getPointerId(motionEvent, i);
                return true;
            case C3374b.SmoothProgressBar_spb_progressiveStart_speed /*6*/:
                action = MotionEventCompat.getActionIndex(motionEvent);
                if (MotionEventCompat.getPointerId(motionEvent, action) == this.f6671d) {
                    if (action == 0) {
                        i = 1;
                    }
                    this.f6671d = MotionEventCompat.getPointerId(motionEvent, i);
                }
                this.f6683p = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f6671d));
                return true;
            default:
                return true;
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f6673f != null) {
            int count = this.f6673f.getAdapter().getCount();
            if (count == 0) {
                return;
            }
            if (this.f6675h >= count) {
                setCurrentItem(count - 1);
                return;
            }
            int width;
            int paddingLeft;
            int paddingRight;
            int paddingTop;
            float height;
            if (this.f6679l == 0) {
                width = getWidth();
                paddingLeft = getPaddingLeft();
                paddingRight = getPaddingRight();
                paddingTop = getPaddingTop();
            } else {
                width = getHeight();
                paddingLeft = getPaddingTop();
                paddingRight = getPaddingBottom();
                paddingTop = getPaddingLeft();
            }
            float f = (this.f6672e * 3.0f) + this.f6685r;
            float f2 = this.f6672e + ((float) paddingTop);
            float f3 = ((float) paddingLeft) + this.f6672e;
            if (this.f6680m) {
                f3 += (((float) ((width - paddingLeft) - paddingRight)) / 2.0f) - ((((this.f6672e * 2.0f) * ((float) count)) + (this.f6672e * ((float) (count - 1)))) / 2.0f);
                height = ((((float) ((getHeight() - getPaddingTop()) - getPaddingBottom())) / 2.0f) - this.f6672e) + f2;
            } else {
                height = f2;
            }
            float f4 = this.f6672e;
            if (this.f6669b.getStrokeWidth() > 0.0f) {
                f4 -= this.f6669b.getStrokeWidth() / 2.0f;
            }
            for (int i = 0; i < count; i++) {
                float f5 = (((float) i) * f) + f3;
                if (this.f6679l == 0) {
                    f2 = f5;
                    f5 = height;
                } else {
                    f2 = height;
                }
                if (this.f6668a.getAlpha() > 0) {
                    canvas.drawCircle(f2, f5, f4, this.f6668a);
                }
                if (f4 != this.f6672e) {
                    canvas.drawCircle(f2, f5, this.f6672e, this.f6669b);
                }
            }
            f4 = ((float) (this.f6681n ? this.f6676i : this.f6675h)) * f;
            if (!this.f6681n) {
                f4 += this.f6677j * f;
            }
            if (this.f6679l == 0) {
                f3 += f4;
            } else {
                float f6 = f3 + f4;
                f3 = height;
                height = f6;
            }
            canvas.drawCircle(f3, height, this.f6672e, this.f6670c);
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f6667a = this.f6675h;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f6675h = savedState.f6667a;
        this.f6676i = savedState.f6667a;
        requestLayout();
    }

    protected void onMeasure(int i, int i2) {
        if (this.f6679l == 0) {
            setMeasuredDimension(m9492a(i), m9493b(i2));
        } else {
            setMeasuredDimension(m9493b(i), m9492a(i2));
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.f6673f != viewPager) {
            if (this.f6673f != null) {
                this.f6673f.setOnPageChangeListener(null);
            }
            if (viewPager.getAdapter() == null) {
                throw new IllegalStateException("ViewPager does not have adapter instance.");
            }
            this.f6673f = viewPager;
            this.f6673f.setOnPageChangeListener(this);
            invalidate();
        }
    }

    public void m9494a(ViewPager viewPager, int i) {
        setViewPager(viewPager);
        setCurrentItem(i);
    }

    public void setCurrentItem(int i) {
        if (this.f6673f == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        this.f6673f.setCurrentItem(i);
        this.f6675h = i;
        invalidate();
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.f6674g = onPageChangeListener;
    }

    public void onPageScrolled(int i, float f, int i2) {
        this.f6675h = i;
        this.f6677j = f;
        invalidate();
        if (this.f6674g != null) {
            this.f6674g.onPageScrolled(i, f, i2);
        }
    }

    public void onPageSelected(int i) {
        if (this.f6681n || this.f6678k == 0) {
            this.f6675h = i;
            this.f6676i = i;
            invalidate();
        }
        if (this.f6674g != null) {
            this.f6674g.onPageSelected(i);
        }
    }

    public void onPageScrollStateChanged(int i) {
        this.f6678k = i;
        if (this.f6674g != null) {
            this.f6674g.onPageScrollStateChanged(i);
        }
    }

    private int m9492a(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824 || this.f6673f == null) {
            return size;
        }
        int count = this.f6673f.getAdapter().getCount();
        count = (int) (((((float) (count - 1)) * (this.f6672e + this.f6685r)) + (((float) (getPaddingLeft() + getPaddingRight())) + (((float) (count * 2)) * this.f6672e))) + 1.0f);
        if (mode == Action.UNDEFINED_DURATION) {
            return Math.min(count, size);
        }
        return count;
    }

    private int m9493b(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int paddingTop = (int) ((((2.0f * this.f6672e) + ((float) getPaddingTop())) + ((float) getPaddingBottom())) + 1.0f);
        return mode == Action.UNDEFINED_DURATION ? Math.min(paddingTop, size) : paddingTop;
    }
}
