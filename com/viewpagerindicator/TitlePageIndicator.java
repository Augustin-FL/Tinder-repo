package com.viewpagerindicator;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
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
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import com.facebook.stetho.BuildConfig;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.tinder.views.RangeSeekBar;
import com.viewpagerindicator.C3169d.C3163a;
import com.viewpagerindicator.C3169d.C3164b;
import com.viewpagerindicator.C3169d.C3165c;
import com.viewpagerindicator.C3169d.C3166d;
import com.viewpagerindicator.C3169d.C3167e;
import com.viewpagerindicator.C3169d.C3168f;
import java.util.ArrayList;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class TitlePageIndicator extends View implements C3147c {
    private C3157a f6731A;
    private final Paint f6732a;
    private final Rect f6733b;
    private final Paint f6734c;
    private final Paint f6735d;
    private ViewPager f6736e;
    private OnPageChangeListener f6737f;
    private int f6738g;
    private float f6739h;
    private int f6740i;
    private boolean f6741j;
    private int f6742k;
    private int f6743l;
    private Path f6744m;
    private IndicatorStyle f6745n;
    private LinePosition f6746o;
    private float f6747p;
    private float f6748q;
    private float f6749r;
    private float f6750s;
    private float f6751t;
    private float f6752u;
    private float f6753v;
    private int f6754w;
    private float f6755x;
    private int f6756y;
    private boolean f6757z;

    /* renamed from: com.viewpagerindicator.TitlePageIndicator.1 */
    static /* synthetic */ class C31551 {
        static final /* synthetic */ int[] f6720a;

        static {
            f6720a = new int[IndicatorStyle.values().length];
            try {
                f6720a[IndicatorStyle.Triangle.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6720a[IndicatorStyle.Underline.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public enum IndicatorStyle {
        None(0),
        Triangle(1),
        Underline(2);
        
        public final int f6725d;

        private IndicatorStyle(int i) {
            this.f6725d = i;
        }

        public static IndicatorStyle m9512a(int i) {
            for (IndicatorStyle indicatorStyle : values()) {
                if (indicatorStyle.f6725d == i) {
                    return indicatorStyle;
                }
            }
            return null;
        }
    }

    public enum LinePosition {
        Bottom(0),
        Top(1);
        
        public final int f6729c;

        private LinePosition(int i) {
            this.f6729c = i;
        }

        public static LinePosition m9513a(int i) {
            for (LinePosition linePosition : values()) {
                if (linePosition.f6729c == i) {
                    return linePosition;
                }
            }
            return null;
        }
    }

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        int f6730a;

        /* renamed from: com.viewpagerindicator.TitlePageIndicator.SavedState.1 */
        static class C31561 implements Creator<SavedState> {
            C31561() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m9514a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m9515a(i);
            }

            public SavedState m9514a(Parcel parcel) {
                return new SavedState(null);
            }

            public SavedState[] m9515a(int i) {
                return new SavedState[i];
            }
        }

        static {
            CREATOR = new C31561();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f6730a = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f6730a);
        }
    }

    /* renamed from: com.viewpagerindicator.TitlePageIndicator.a */
    public interface C3157a {
        void m9516a(int i);
    }

    public TitlePageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C3163a.vpiTitlePageIndicatorStyle);
    }

    public TitlePageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6732a = new Paint();
        this.f6733b = new Rect();
        this.f6734c = new Paint();
        this.f6735d = new Paint();
        this.f6738g = -1;
        this.f6744m = new Path();
        this.f6755x = GroundOverlayOptions.NO_DIMENSION;
        this.f6756y = -1;
        if (!isInEditMode()) {
            Resources resources = getResources();
            int color = resources.getColor(C3165c.default_title_indicator_footer_color);
            float dimension = resources.getDimension(C3166d.default_title_indicator_footer_line_height);
            int integer = resources.getInteger(C3167e.default_title_indicator_footer_indicator_style);
            float dimension2 = resources.getDimension(C3166d.default_title_indicator_footer_indicator_height);
            float dimension3 = resources.getDimension(C3166d.default_title_indicator_footer_indicator_underline_padding);
            float dimension4 = resources.getDimension(C3166d.default_title_indicator_footer_padding);
            int integer2 = resources.getInteger(C3167e.default_title_indicator_line_position);
            int color2 = resources.getColor(C3165c.default_title_indicator_selected_color);
            boolean z = resources.getBoolean(C3164b.default_title_indicator_selected_bold);
            int color3 = resources.getColor(C3165c.default_title_indicator_text_color);
            float dimension5 = resources.getDimension(C3166d.default_title_indicator_text_size);
            float dimension6 = resources.getDimension(C3166d.default_title_indicator_title_padding);
            float dimension7 = resources.getDimension(C3166d.default_title_indicator_clip_padding);
            float dimension8 = resources.getDimension(C3166d.default_title_indicator_top_padding);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3168f.TitlePageIndicator, i, 0);
            this.f6753v = obtainStyledAttributes.getDimension(C3168f.TitlePageIndicator_footerLineHeight, dimension);
            this.f6745n = IndicatorStyle.m9512a(obtainStyledAttributes.getInteger(C3168f.TitlePageIndicator_footerIndicatorStyle, integer));
            this.f6747p = obtainStyledAttributes.getDimension(C3168f.TitlePageIndicator_footerIndicatorHeight, dimension2);
            this.f6748q = obtainStyledAttributes.getDimension(C3168f.TitlePageIndicator_footerIndicatorUnderlinePadding, dimension3);
            this.f6749r = obtainStyledAttributes.getDimension(C3168f.TitlePageIndicator_footerPadding, dimension4);
            this.f6746o = LinePosition.m9513a(obtainStyledAttributes.getInteger(C3168f.TitlePageIndicator_linePosition, integer2));
            this.f6751t = obtainStyledAttributes.getDimension(C3168f.TitlePageIndicator_topPadding, dimension8);
            this.f6750s = obtainStyledAttributes.getDimension(C3168f.TitlePageIndicator_titlePadding, dimension6);
            this.f6752u = obtainStyledAttributes.getDimension(C3168f.TitlePageIndicator_clipPadding, dimension7);
            this.f6743l = obtainStyledAttributes.getColor(C3168f.TitlePageIndicator_selectedColor, color2);
            this.f6742k = obtainStyledAttributes.getColor(C3168f.TitlePageIndicator_android_textColor, color3);
            this.f6741j = obtainStyledAttributes.getBoolean(C3168f.TitlePageIndicator_selectedBold, z);
            dimension8 = obtainStyledAttributes.getDimension(C3168f.TitlePageIndicator_android_textSize, dimension5);
            color = obtainStyledAttributes.getColor(C3168f.TitlePageIndicator_footerColor, color);
            this.f6732a.setTextSize(dimension8);
            this.f6732a.setAntiAlias(true);
            this.f6734c.setStyle(Style.FILL_AND_STROKE);
            this.f6734c.setStrokeWidth(this.f6753v);
            this.f6734c.setColor(color);
            this.f6735d.setStyle(Style.FILL_AND_STROKE);
            this.f6735d.setColor(color);
            Drawable drawable = obtainStyledAttributes.getDrawable(C3168f.TitlePageIndicator_android_background);
            if (drawable != null) {
                setBackgroundDrawable(drawable);
            }
            obtainStyledAttributes.recycle();
            this.f6754w = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(context));
        }
    }

    public int getFooterColor() {
        return this.f6734c.getColor();
    }

    public void setFooterColor(int i) {
        this.f6734c.setColor(i);
        this.f6735d.setColor(i);
        invalidate();
    }

    public float getFooterLineHeight() {
        return this.f6753v;
    }

    public void setFooterLineHeight(float f) {
        this.f6753v = f;
        this.f6734c.setStrokeWidth(this.f6753v);
        invalidate();
    }

    public float getFooterIndicatorHeight() {
        return this.f6747p;
    }

    public void setFooterIndicatorHeight(float f) {
        this.f6747p = f;
        invalidate();
    }

    public float getFooterIndicatorPadding() {
        return this.f6749r;
    }

    public void setFooterIndicatorPadding(float f) {
        this.f6749r = f;
        invalidate();
    }

    public IndicatorStyle getFooterIndicatorStyle() {
        return this.f6745n;
    }

    public void setFooterIndicatorStyle(IndicatorStyle indicatorStyle) {
        this.f6745n = indicatorStyle;
        invalidate();
    }

    public LinePosition getLinePosition() {
        return this.f6746o;
    }

    public void setLinePosition(LinePosition linePosition) {
        this.f6746o = linePosition;
        invalidate();
    }

    public int getSelectedColor() {
        return this.f6743l;
    }

    public void setSelectedColor(int i) {
        this.f6743l = i;
        invalidate();
    }

    public void setSelectedBold(boolean z) {
        this.f6741j = z;
        invalidate();
    }

    public int getTextColor() {
        return this.f6742k;
    }

    public void setTextColor(int i) {
        this.f6732a.setColor(i);
        this.f6742k = i;
        invalidate();
    }

    public float getTextSize() {
        return this.f6732a.getTextSize();
    }

    public void setTextSize(float f) {
        this.f6732a.setTextSize(f);
        invalidate();
    }

    public float getTitlePadding() {
        return this.f6750s;
    }

    public void setTitlePadding(float f) {
        this.f6750s = f;
        invalidate();
    }

    public float getTopPadding() {
        return this.f6751t;
    }

    public void setTopPadding(float f) {
        this.f6751t = f;
        invalidate();
    }

    public float getClipPadding() {
        return this.f6752u;
    }

    public void setClipPadding(float f) {
        this.f6752u = f;
        invalidate();
    }

    public Typeface getTypeface() {
        return this.f6732a.getTypeface();
    }

    public void setTypeface(Typeface typeface) {
        this.f6732a.setTypeface(typeface);
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f6736e != null) {
            int count = this.f6736e.getAdapter().getCount();
            if (count != 0) {
                if (this.f6738g == -1 && this.f6736e != null) {
                    this.f6738g = this.f6736e.getCurrentItem();
                }
                ArrayList a = m9519a(this.f6732a);
                int size = a.size();
                if (this.f6738g >= size) {
                    setCurrentItem(size - 1);
                    return;
                }
                int i;
                float f;
                Object obj;
                int i2;
                Rect rect;
                int i3 = count - 1;
                float width = ((float) getWidth()) / 2.0f;
                int left = getLeft();
                float f2 = ((float) left) + this.f6752u;
                int width2 = getWidth();
                int height = getHeight();
                int i4 = left + width2;
                float f3 = ((float) i4) - this.f6752u;
                int i5 = this.f6738g;
                if (((double) this.f6739h) <= 0.5d) {
                    i = i5;
                    f = this.f6739h;
                } else {
                    i = i5 + 1;
                    f = 1.0f - this.f6739h;
                }
                Object obj2 = f <= 0.25f ? 1 : null;
                if (f <= 0.05f) {
                    obj = 1;
                } else {
                    obj = null;
                }
                float f4 = (0.25f - f) / 0.25f;
                Rect rect2 = (Rect) a.get(this.f6738g);
                f = (float) (rect2.right - rect2.left);
                if (((float) rect2.left) < f2) {
                    m9521b(rect2, f, left);
                }
                if (((float) rect2.right) > f3) {
                    m9520a(rect2, f, i4);
                }
                if (this.f6738g > 0) {
                    for (i2 = this.f6738g - 1; i2 >= 0; i2--) {
                        rect2 = (Rect) a.get(i2);
                        if (((float) rect2.left) < f2) {
                            int i6 = rect2.right - rect2.left;
                            m9521b(rect2, (float) i6, left);
                            rect = (Rect) a.get(i2 + 1);
                            if (((float) rect2.right) + this.f6750s > ((float) rect.left)) {
                                rect2.left = (int) (((float) (rect.left - i6)) - this.f6750s);
                                rect2.right = rect2.left + i6;
                            }
                        }
                    }
                }
                if (this.f6738g < i3) {
                    for (i2 = this.f6738g + 1; i2 < count; i2++) {
                        rect2 = (Rect) a.get(i2);
                        if (((float) rect2.right) > f3) {
                            i3 = rect2.right - rect2.left;
                            m9520a(rect2, (float) i3, i4);
                            rect = (Rect) a.get(i2 - 1);
                            if (((float) rect2.left) - this.f6750s < ((float) rect.right)) {
                                rect2.left = (int) (((float) rect.right) + this.f6750s);
                                rect2.right = rect2.left + i3;
                            }
                        }
                    }
                }
                int i7 = this.f6742k >>> 24;
                int i8 = 0;
                while (i8 < count) {
                    Rect rect3 = (Rect) a.get(i8);
                    if ((rect3.left > left && rect3.left < i4) || (rect3.right > left && rect3.right < i4)) {
                        Object obj3 = i8 == i ? 1 : null;
                        CharSequence a2 = m9518a(i8);
                        Paint paint = this.f6732a;
                        boolean z = (obj3 == null || obj == null || !this.f6741j) ? false : true;
                        paint.setFakeBoldText(z);
                        this.f6732a.setColor(this.f6742k);
                        if (!(obj3 == null || obj2 == null)) {
                            this.f6732a.setAlpha(i7 - ((int) (((float) i7) * f4)));
                        }
                        if (i8 < size - 1) {
                            rect2 = (Rect) a.get(i8 + 1);
                            if (((float) rect3.right) + this.f6750s > ((float) rect2.left)) {
                                i2 = rect3.right - rect3.left;
                                rect3.left = (int) (((float) (rect2.left - i2)) - this.f6750s);
                                rect3.right = rect3.left + i2;
                            }
                        }
                        canvas.drawText(a2, 0, a2.length(), (float) rect3.left, this.f6751t + ((float) rect3.bottom), this.f6732a);
                        if (!(obj3 == null || obj2 == null)) {
                            this.f6732a.setColor(this.f6743l);
                            this.f6732a.setAlpha((int) (((float) (this.f6743l >>> 24)) * f4));
                            canvas.drawText(a2, 0, a2.length(), (float) rect3.left, this.f6751t + ((float) rect3.bottom), this.f6732a);
                        }
                    }
                    i8++;
                }
                f = this.f6753v;
                float f5 = this.f6747p;
                float f6;
                if (this.f6746o == LinePosition.Top) {
                    i2 = 0;
                    f6 = -f5;
                    f5 = -f;
                    f = f6;
                } else {
                    i2 = height;
                    f6 = f;
                    f = f5;
                    f5 = f6;
                }
                this.f6744m.reset();
                this.f6744m.moveTo(0.0f, ((float) i2) - (f5 / 2.0f));
                this.f6744m.lineTo((float) width2, ((float) i2) - (f5 / 2.0f));
                this.f6744m.close();
                canvas.drawPath(this.f6744m, this.f6734c);
                float f7 = ((float) i2) - f5;
                switch (C31551.f6720a[this.f6745n.ordinal()]) {
                    case C3374b.SmoothProgressBar_spb_color /*1*/:
                        this.f6744m.reset();
                        this.f6744m.moveTo(width, f7 - f);
                        this.f6744m.lineTo(width + f, f7);
                        this.f6744m.lineTo(width - f, f7);
                        this.f6744m.close();
                        canvas.drawPath(this.f6744m, this.f6735d);
                    case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                        if (obj2 != null && i < size) {
                            rect2 = (Rect) a.get(i);
                            float f8 = ((float) rect2.right) + this.f6748q;
                            f5 = ((float) rect2.left) - this.f6748q;
                            f = f7 - f;
                            this.f6744m.reset();
                            this.f6744m.moveTo(f5, f7);
                            this.f6744m.lineTo(f8, f7);
                            this.f6744m.lineTo(f8, f);
                            this.f6744m.lineTo(f5, f);
                            this.f6744m.close();
                            this.f6735d.setAlpha((int) (255.0f * f4));
                            canvas.drawPath(this.f6744m, this.f6735d);
                            this.f6735d.setAlpha(RangeSeekBar.INVALID_POINTER_ID);
                        }
                    default:
                }
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        if (super.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.f6736e == null || this.f6736e.getAdapter().getCount() == 0) {
            return false;
        }
        int action = motionEvent.getAction() & RangeSeekBar.INVALID_POINTER_ID;
        switch (action) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                this.f6756y = MotionEventCompat.getPointerId(motionEvent, 0);
                this.f6755x = motionEvent.getX();
                return true;
            case C3374b.SmoothProgressBar_spb_color /*1*/:
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                if (!this.f6757z) {
                    int count = this.f6736e.getAdapter().getCount();
                    int width = getWidth();
                    float f = ((float) width) / 2.0f;
                    float f2 = ((float) width) / 6.0f;
                    float f3 = f - f2;
                    f2 += f;
                    f = motionEvent.getX();
                    if (f < f3) {
                        if (this.f6738g > 0) {
                            if (action == 3) {
                                return true;
                            }
                            this.f6736e.setCurrentItem(this.f6738g - 1);
                            return true;
                        }
                    } else if (f > f2) {
                        if (this.f6738g < count - 1) {
                            if (action == 3) {
                                return true;
                            }
                            this.f6736e.setCurrentItem(this.f6738g + 1);
                            return true;
                        }
                    } else if (!(this.f6731A == null || action == 3)) {
                        this.f6731A.m9516a(this.f6738g);
                    }
                }
                this.f6757z = false;
                this.f6756y = -1;
                if (!this.f6736e.isFakeDragging()) {
                    return true;
                }
                this.f6736e.endFakeDrag();
                return true;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                float x = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f6756y));
                float f4 = x - this.f6755x;
                if (!this.f6757z && Math.abs(f4) > ((float) this.f6754w)) {
                    this.f6757z = true;
                }
                if (!this.f6757z) {
                    return true;
                }
                this.f6755x = x;
                if (!this.f6736e.isFakeDragging() && !this.f6736e.beginFakeDrag()) {
                    return true;
                }
                this.f6736e.fakeDragBy(f4);
                return true;
            case C3374b.SmoothProgressBar_spb_speed /*5*/:
                i = MotionEventCompat.getActionIndex(motionEvent);
                this.f6755x = MotionEventCompat.getX(motionEvent, i);
                this.f6756y = MotionEventCompat.getPointerId(motionEvent, i);
                return true;
            case C3374b.SmoothProgressBar_spb_progressiveStart_speed /*6*/:
                action = MotionEventCompat.getActionIndex(motionEvent);
                if (MotionEventCompat.getPointerId(motionEvent, action) == this.f6756y) {
                    if (action == 0) {
                        i = 1;
                    }
                    this.f6756y = MotionEventCompat.getPointerId(motionEvent, i);
                }
                this.f6755x = MotionEventCompat.getX(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.f6756y));
                return true;
            default:
                return true;
        }
    }

    private void m9520a(Rect rect, float f, int i) {
        rect.right = (int) (((float) i) - this.f6752u);
        rect.left = (int) (((float) rect.right) - f);
    }

    private void m9521b(Rect rect, float f, int i) {
        rect.left = (int) (((float) i) + this.f6752u);
        rect.right = (int) (this.f6752u + f);
    }

    private ArrayList<Rect> m9519a(Paint paint) {
        ArrayList<Rect> arrayList = new ArrayList();
        int count = this.f6736e.getAdapter().getCount();
        int width = getWidth();
        int i = width / 2;
        for (int i2 = 0; i2 < count; i2++) {
            Rect a = m9517a(i2, paint);
            int i3 = a.right - a.left;
            int i4 = a.bottom - a.top;
            a.left = (int) ((((float) i) - (((float) i3) / 2.0f)) + ((((float) (i2 - this.f6738g)) - this.f6739h) * ((float) width)));
            a.right = i3 + a.left;
            a.top = 0;
            a.bottom = i4;
            arrayList.add(a);
        }
        return arrayList;
    }

    private Rect m9517a(int i, Paint paint) {
        Rect rect = new Rect();
        CharSequence a = m9518a(i);
        rect.right = (int) paint.measureText(a, 0, a.length());
        rect.bottom = (int) (paint.descent() - paint.ascent());
        return rect;
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.f6736e != viewPager) {
            if (this.f6736e != null) {
                this.f6736e.setOnPageChangeListener(null);
            }
            if (viewPager.getAdapter() == null) {
                throw new IllegalStateException("ViewPager does not have adapter instance.");
            }
            this.f6736e = viewPager;
            this.f6736e.setOnPageChangeListener(this);
            invalidate();
        }
    }

    public void setOnCenterItemClickListener(C3157a c3157a) {
        this.f6731A = c3157a;
    }

    public void setCurrentItem(int i) {
        if (this.f6736e == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        this.f6736e.setCurrentItem(i);
        this.f6738g = i;
        invalidate();
    }

    public void onPageScrollStateChanged(int i) {
        this.f6740i = i;
        if (this.f6737f != null) {
            this.f6737f.onPageScrollStateChanged(i);
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        this.f6738g = i;
        this.f6739h = f;
        invalidate();
        if (this.f6737f != null) {
            this.f6737f.onPageScrolled(i, f, i2);
        }
    }

    public void onPageSelected(int i) {
        if (this.f6740i == 0) {
            this.f6738g = i;
            invalidate();
        }
        if (this.f6737f != null) {
            this.f6737f.onPageSelected(i);
        }
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.f6737f = onPageChangeListener;
    }

    protected void onMeasure(int i, int i2) {
        float size;
        int size2 = MeasureSpec.getSize(i);
        if (MeasureSpec.getMode(i2) == 1073741824) {
            size = (float) MeasureSpec.getSize(i2);
        } else {
            this.f6733b.setEmpty();
            this.f6733b.bottom = (int) (this.f6732a.descent() - this.f6732a.ascent());
            size = ((((float) (this.f6733b.bottom - this.f6733b.top)) + this.f6753v) + this.f6749r) + this.f6751t;
            if (this.f6745n != IndicatorStyle.None) {
                size += this.f6747p;
            }
        }
        setMeasuredDimension(size2, (int) size);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f6738g = savedState.f6730a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f6730a = this.f6738g;
        return savedState;
    }

    private CharSequence m9518a(int i) {
        CharSequence pageTitle = this.f6736e.getAdapter().getPageTitle(i);
        if (pageTitle == null) {
            return BuildConfig.FLAVOR;
        }
        return pageTitle;
    }
}
