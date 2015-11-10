package com.tinder.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.Pair;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import java.math.BigDecimal;
import org.apache.http.HttpStatus;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class RangeSeekBar<T extends Number> extends ImageView {
    public static final int ACTION_POINTER_INDEX_MASK = 65280;
    public static final int ACTION_POINTER_INDEX_SHIFT = 8;
    public static final int ACTION_POINTER_UP = 6;
    public static final int DEFAULT_COLOR;
    public static final int INVALID_POINTER_ID = 255;
    private float HALF_HEIGHT_THUMB;
    private float HALF_WIDTH_THUMB;
    private float PADDING;
    private float WIDTH_THUMB;
    @NonNull
    private T mAbsoluteMaxValue;
    private double mAbsoluteMaxValuePrim;
    @NonNull
    private T mAbsoluteMinValue;
    private double mAbsoluteMinValuePrim;
    private int mActivePointerId;
    private Bitmap mBitmapThumbImage;
    private Bitmap mBitmapThumbImagePressed;
    private float mDownMotionX;
    private boolean mIsDragging;
    private float mLineHeight;
    private double mNormalizedMaxValue;
    private double mNormalizedMinValue;
    @NonNull
    private NumberType mNumberType;
    private OnRangeSeekBarChangeListener<T> mOnRangeSeekBarChangeListener;
    private final Paint mPaint;
    private RectF mRect;
    private int mScaledTouchSlop;
    private boolean mShouldNotifyWhileDragging;
    private int mSliderPrimaryColor;
    private int mSliderSecondaryColor;
    @Nullable
    private Thumb mThumbPressed;

    public interface OnRangeSeekBarChangeListener<T> {
        void onRangeSeekBarValuesChanged(RangeSeekBar<?> rangeSeekBar, T t, T t2);
    }

    /* renamed from: com.tinder.views.RangeSeekBar.1 */
    static /* synthetic */ class C31321 {
        static final /* synthetic */ int[] $SwitchMap$com$tinder$views$RangeSeekBar$NumberType;

        static {
            $SwitchMap$com$tinder$views$RangeSeekBar$NumberType = new int[NumberType.values().length];
            try {
                $SwitchMap$com$tinder$views$RangeSeekBar$NumberType[NumberType.LONG.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$tinder$views$RangeSeekBar$NumberType[NumberType.DOUBLE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$tinder$views$RangeSeekBar$NumberType[NumberType.INTEGER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$tinder$views$RangeSeekBar$NumberType[NumberType.FLOAT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$tinder$views$RangeSeekBar$NumberType[NumberType.SHORT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$tinder$views$RangeSeekBar$NumberType[NumberType.BYTE.ordinal()] = RangeSeekBar.ACTION_POINTER_UP;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$tinder$views$RangeSeekBar$NumberType[NumberType.BIG_DECIMAL.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    private enum NumberType {
        LONG,
        DOUBLE,
        INTEGER,
        FLOAT,
        SHORT,
        BYTE,
        BIG_DECIMAL;

        @NonNull
        public static <E extends Number> NumberType fromNumber(E e) throws IllegalArgumentException {
            if (e instanceof Long) {
                return LONG;
            }
            if (e instanceof Double) {
                return DOUBLE;
            }
            if (e instanceof Integer) {
                return INTEGER;
            }
            if (e instanceof Float) {
                return FLOAT;
            }
            if (e instanceof Short) {
                return SHORT;
            }
            if (e instanceof Byte) {
                return BYTE;
            }
            if (e instanceof BigDecimal) {
                return BIG_DECIMAL;
            }
            throw new IllegalArgumentException("Number class '" + e.getClass().getName() + "' is not supported");
        }

        public Number toNumber(double d) {
            switch (C31321.$SwitchMap$com$tinder$views$RangeSeekBar$NumberType[ordinal()]) {
                case C3374b.SmoothProgressBar_spb_color /*1*/:
                    return new Long((long) d);
                case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                    return Double.valueOf(d);
                case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                    return new Integer((int) d);
                case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                    return new Float(d);
                case C3374b.SmoothProgressBar_spb_speed /*5*/:
                    return new Short((short) ((int) d));
                case RangeSeekBar.ACTION_POINTER_UP /*6*/:
                    return new Byte((byte) ((int) d));
                case C3374b.SmoothProgressBar_spb_progressiveStop_speed /*7*/:
                    return new BigDecimal(d);
                default:
                    throw new InstantiationError("can't convert " + this + " to a Number object");
            }
        }
    }

    private enum Thumb {
        MIN,
        MAX
    }

    static {
        DEFAULT_COLOR = Color.argb(INVALID_POINTER_ID, 51, 181, 229);
    }

    public RangeSeekBar(Bitmap bitmap, Bitmap bitmap2, @NonNull T t, @NonNull T t2, Context context) throws IllegalArgumentException {
        super(context);
        this.mPaint = new Paint(1);
        this.mActivePointerId = INVALID_POINTER_ID;
        this.mNormalizedMinValue = 0.0d;
        this.mNormalizedMaxValue = 1.0d;
        this.mThumbPressed = null;
        this.mShouldNotifyWhileDragging = false;
        this.mSliderSecondaryColor = -7829368;
        this.mSliderPrimaryColor = DEFAULT_COLOR;
        this.mBitmapThumbImage = bitmap;
        this.mBitmapThumbImagePressed = bitmap2;
        this.WIDTH_THUMB = (float) this.mBitmapThumbImage.getWidth();
        this.HALF_WIDTH_THUMB = this.WIDTH_THUMB * 0.5f;
        this.HALF_HEIGHT_THUMB = ((float) this.mBitmapThumbImage.getHeight()) * 0.5f;
        this.mLineHeight = 0.3f * this.HALF_HEIGHT_THUMB;
        this.mAbsoluteMinValue = t;
        this.mAbsoluteMaxValue = t2;
        this.mAbsoluteMinValuePrim = t.doubleValue();
        this.mAbsoluteMaxValuePrim = t2.doubleValue();
        this.mNumberType = NumberType.fromNumber(t);
        setFocusable(true);
        setFocusableInTouchMode(true);
        init();
        this.mRect = new RectF(this.PADDING, (((float) getHeight()) - this.mLineHeight) * 0.5f, ((float) getWidth()) - this.PADDING, (((float) getHeight()) + this.mLineHeight) * 0.5f);
    }

    public void setSliderPrimaryColor(int i) {
        this.mSliderPrimaryColor = i;
    }

    public void setSliderSecondaryColor(int i) {
        this.mSliderSecondaryColor = i;
    }

    public void setLineHeight(float f) {
        this.mLineHeight = f;
        this.mRect = new RectF(this.PADDING, (((float) getHeight()) - this.mLineHeight) * 0.5f, ((float) getWidth()) - this.PADDING, (((float) getHeight()) + this.mLineHeight) * 0.5f);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        this.PADDING = this.HALF_WIDTH_THUMB + ((float) i);
    }

    private void init() {
        this.mScaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public boolean isNotifyWhileDraggingOn() {
        return this.mShouldNotifyWhileDragging;
    }

    public void setNotifyWhileDragging(boolean z) {
        this.mShouldNotifyWhileDragging = z;
    }

    @NonNull
    public T getAbsoluteMinValue() {
        return this.mAbsoluteMinValue;
    }

    @NonNull
    public T getAbsoluteMaxValue() {
        return this.mAbsoluteMaxValue;
    }

    @NonNull
    public T getSelectedMinValue() {
        return normalizedToValue(this.mNormalizedMinValue);
    }

    public void setSelectedMinValue(@NonNull T t) {
        if (0.0d == this.mAbsoluteMaxValuePrim - this.mAbsoluteMinValuePrim) {
            setNormalizedMinValue(0.0d);
        } else {
            setNormalizedMinValue(valueToNormalized(t));
        }
    }

    @NonNull
    public T getSelectedMaxValue() {
        return normalizedToValue(this.mNormalizedMaxValue);
    }

    public void setSelectedMaxValue(@NonNull T t) {
        if (0.0d == this.mAbsoluteMaxValuePrim - this.mAbsoluteMinValuePrim) {
            setmNormalizedMaxValue(1.0d);
        } else {
            setmNormalizedMaxValue(valueToNormalized(t));
        }
    }

    public void setOnRangeSeekBarChangeListener(OnRangeSeekBarChangeListener<T> onRangeSeekBarChangeListener) {
        this.mOnRangeSeekBarChangeListener = onRangeSeekBarChangeListener;
    }

    public void setThumbImages(Pair<Bitmap, Bitmap> pair) {
        this.mBitmapThumbImage = (Bitmap) pair.first;
        this.mBitmapThumbImagePressed = (Bitmap) pair.second;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.PADDING = ((float) getPaddingLeft()) + this.HALF_WIDTH_THUMB;
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        switch (motionEvent.getAction() & INVALID_POINTER_ID) {
            case DEFAULT_COLOR:
                this.mActivePointerId = motionEvent.getPointerId(motionEvent.getPointerCount() - 1);
                this.mDownMotionX = motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
                this.mThumbPressed = evalPressedThumb(this.mDownMotionX);
                if (this.mThumbPressed != null) {
                    setPressed(true);
                    invalidate();
                    onStartTrackingTouch();
                    trackTouchEvent(motionEvent);
                    attemptClaimDrag();
                    break;
                }
                return super.onTouchEvent(motionEvent);
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                if (this.mIsDragging) {
                    trackTouchEvent(motionEvent);
                    onStopTrackingTouch();
                    setPressed(false);
                } else {
                    onStartTrackingTouch();
                    trackTouchEvent(motionEvent);
                    onStopTrackingTouch();
                }
                this.mThumbPressed = null;
                invalidate();
                if (this.mOnRangeSeekBarChangeListener != null) {
                    this.mOnRangeSeekBarChangeListener.onRangeSeekBarValuesChanged(this, getSelectedMinValue(), getSelectedMaxValue());
                    break;
                }
                break;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                if (this.mThumbPressed != null) {
                    if (this.mIsDragging) {
                        trackTouchEvent(motionEvent);
                    } else if (Math.abs(motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)) - this.mDownMotionX) > ((float) this.mScaledTouchSlop)) {
                        setPressed(true);
                        invalidate();
                        onStartTrackingTouch();
                        trackTouchEvent(motionEvent);
                        attemptClaimDrag();
                    }
                    if (this.mShouldNotifyWhileDragging && this.mOnRangeSeekBarChangeListener != null) {
                        this.mOnRangeSeekBarChangeListener.onRangeSeekBarValuesChanged(this, getSelectedMinValue(), getSelectedMaxValue());
                        break;
                    }
                }
                break;
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                if (this.mIsDragging) {
                    onStopTrackingTouch();
                    setPressed(false);
                }
                invalidate();
                break;
            case C3374b.SmoothProgressBar_spb_speed /*5*/:
                int pointerCount = motionEvent.getPointerCount() - 1;
                this.mDownMotionX = motionEvent.getX(pointerCount);
                this.mActivePointerId = motionEvent.getPointerId(pointerCount);
                invalidate();
                break;
            case ACTION_POINTER_UP /*6*/:
                onSecondaryPointerUp(motionEvent);
                invalidate();
                break;
        }
        return true;
    }

    @NonNull
    protected Parcelable onSaveInstanceState() {
        Parcelable bundle = new Bundle();
        bundle.putParcelable("SUPER", super.onSaveInstanceState());
        bundle.putDouble("MIN", this.mNormalizedMinValue);
        bundle.putDouble("MAX", this.mNormalizedMaxValue);
        return bundle;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("SUPER"));
        this.mNormalizedMinValue = bundle.getDouble("MIN");
        this.mNormalizedMaxValue = bundle.getDouble("MAX");
    }

    private void onSecondaryPointerUp(@NonNull MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & ACTION_POINTER_INDEX_MASK) >> ACTION_POINTER_INDEX_SHIFT;
        if (motionEvent.getPointerId(action) == this.mActivePointerId) {
            action = action == 0 ? 1 : DEFAULT_COLOR;
            this.mDownMotionX = motionEvent.getX(action);
            this.mActivePointerId = motionEvent.getPointerId(action);
        }
    }

    private void trackTouchEvent(@NonNull MotionEvent motionEvent) {
        float x = motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
        if (Thumb.MIN.equals(this.mThumbPressed)) {
            setNormalizedMinValue(screenToNormalized(x));
        } else if (Thumb.MAX.equals(this.mThumbPressed)) {
            setmNormalizedMaxValue(screenToNormalized(x));
        }
    }

    private void attemptClaimDrag() {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    void onStartTrackingTouch() {
        this.mIsDragging = true;
    }

    void onStopTrackingTouch() {
        this.mIsDragging = false;
    }

    protected synchronized void onMeasure(int i, int i2) {
        int size;
        if (MeasureSpec.getMode(i) != 0) {
            size = MeasureSpec.getSize(i);
        } else {
            size = HttpStatus.SC_OK;
        }
        int height = this.mBitmapThumbImage.getHeight();
        if (MeasureSpec.getMode(i2) != 0) {
            height = Math.min(height, MeasureSpec.getSize(i2));
        }
        setMeasuredDimension(size, height);
    }

    protected synchronized void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        this.mRect.left = this.PADDING;
        this.mRect.right = ((float) getWidth()) - this.PADDING;
        this.mRect.top = (((float) getHeight()) - this.mLineHeight) * 0.5f;
        this.mRect.bottom = (((float) getHeight()) + this.mLineHeight) * 0.5f;
        this.mPaint.setStyle(Style.FILL);
        this.mPaint.setColor(this.mSliderSecondaryColor);
        this.mPaint.setAntiAlias(true);
        canvas.drawRect(this.mRect, this.mPaint);
        this.mRect.left = normalizedToScreen(this.mNormalizedMinValue);
        this.mRect.right = normalizedToScreen(this.mNormalizedMaxValue);
        this.mPaint.setColor(this.mSliderPrimaryColor);
        canvas.drawRect(this.mRect, this.mPaint);
        drawThumb(normalizedToScreen(this.mNormalizedMinValue), Thumb.MIN.equals(this.mThumbPressed), canvas);
        drawThumb(normalizedToScreen(this.mNormalizedMaxValue), Thumb.MAX.equals(this.mThumbPressed), canvas);
    }

    private void drawThumb(float f, boolean z, @NonNull Canvas canvas) {
        canvas.drawBitmap(z ? this.mBitmapThumbImagePressed : this.mBitmapThumbImage, f - this.HALF_WIDTH_THUMB, (0.5f * ((float) getHeight())) - this.HALF_HEIGHT_THUMB, this.mPaint);
    }

    @Nullable
    private Thumb evalPressedThumb(float f) {
        boolean isInThumbRange = isInThumbRange(f, this.mNormalizedMinValue);
        boolean isInThumbRange2 = isInThumbRange(f, this.mNormalizedMaxValue);
        if (isInThumbRange && isInThumbRange2) {
            return f / ((float) getWidth()) > 0.5f ? Thumb.MIN : Thumb.MAX;
        } else {
            if (isInThumbRange) {
                return Thumb.MIN;
            }
            if (isInThumbRange2) {
                return Thumb.MAX;
            }
            return null;
        }
    }

    private boolean isInThumbRange(float f, double d) {
        return Math.abs(f - normalizedToScreen(d)) <= this.HALF_WIDTH_THUMB;
    }

    public void setNormalizedMinValue(double d) {
        this.mNormalizedMinValue = Math.max(0.0d, Math.min(1.0d, Math.min(d, this.mNormalizedMaxValue)));
        invalidate();
    }

    public void setmNormalizedMaxValue(double d) {
        this.mNormalizedMaxValue = Math.max(0.0d, Math.min(1.0d, Math.max(d, this.mNormalizedMinValue)));
        invalidate();
    }

    @NonNull
    private T normalizedToValue(double d) {
        return this.mNumberType.toNumber(this.mAbsoluteMinValuePrim + ((this.mAbsoluteMaxValuePrim - this.mAbsoluteMinValuePrim) * d));
    }

    private double valueToNormalized(@NonNull T t) {
        if (0.0d == this.mAbsoluteMaxValuePrim - this.mAbsoluteMinValuePrim) {
            return 0.0d;
        }
        return (t.doubleValue() - this.mAbsoluteMinValuePrim) / (this.mAbsoluteMaxValuePrim - this.mAbsoluteMinValuePrim);
    }

    private float normalizedToScreen(double d) {
        return (float) (((double) this.PADDING) + (((double) (((float) getWidth()) - (2.0f * this.PADDING))) * d));
    }

    private double screenToNormalized(float f) {
        int width = getWidth();
        if (((float) width) <= this.PADDING * 2.0f) {
            return 0.0d;
        }
        return Math.min(1.0d, Math.max(0.0d, (double) ((f - this.PADDING) / (((float) width) - (this.PADDING * 2.0f)))));
    }
}
