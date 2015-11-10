package com.tinder.views;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.support.annotation.NonNull;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.widget.RecyclerView.SmoothScroller.Action;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tinder.C2241a.C2233a;
import com.tinder.R;
import com.tinder.utils.al;
import java.util.Locale;

public class GameStamp extends View {
    private static final int MODE_LIKE = 1;
    private static final int MODE_PASS = 0;
    private int mActionMode;
    private int mAlpha;
    private int mAscent;
    private boolean mHasAlphaBeenSet;
    private float mMaxWidth;
    private String mText;
    private Paint mTextPaint;
    private float mTextSize;

    public GameStamp(Context context) {
        super(context);
        init();
    }

    public GameStamp(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        parseAttributes(context, attributeSet);
        init();
    }

    public GameStamp(@NonNull Context context, @NonNull AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        parseAttributes(context, attributeSet);
        init();
    }

    private void parseAttributes(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2233a.com_tinder_views_GameStamp, 0, 0);
        this.mActionMode = obtainStyledAttributes.getInt(0, 0);
        this.mTextSize = obtainStyledAttributes.getDimension(MODE_LIKE, getResources().getDimension(R.dimen.default_stamp_textSize));
        obtainStyledAttributes.recycle();
    }

    private void init() {
        int i;
        int i2 = 0;
        String str = "proximanovasoft-semibold.otf";
        Resources resources = getResources();
        int color = resources.getColor(R.color.stamp_text_shadow);
        this.mTextPaint = new Paint();
        this.mTextPaint.setTextAlign(Align.CENTER);
        this.mTextPaint.setTypeface(al.m9264a(getContext(), "proximanovasoft-semibold.otf"));
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mTextPaint.setFlags(AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        this.mTextPaint.setShadowLayer(3.0f, 2.0f, 2.0f, color);
        if (this.mActionMode == MODE_LIKE) {
            color = R.string.stamp_liked;
            i = R.color.stamp_like_green;
            i2 = R.drawable.stamp_like_bg;
        } else if (this.mActionMode == 0) {
            color = R.string.stamp_nope;
            i = R.color.stamp_pass_red;
            i2 = R.drawable.stamp_pass_bg;
        } else {
            color = 0;
            i = 0;
        }
        this.mText = resources.getString(color).toUpperCase(Locale.getDefault());
        this.mTextPaint.setColor(getResources().getColor(i));
        setBackgroundResource(i2);
    }

    public void setMaxWidth(float f) {
        this.mMaxWidth = f;
        calculateTextSize();
    }

    public int getAlphaInt() {
        return this.mAlpha;
    }

    public void setAlpha(int i) {
        if (!this.mHasAlphaBeenSet || this.mAlpha != i) {
            this.mHasAlphaBeenSet = true;
            this.mAlpha = i;
            getBackground().setAlpha(this.mAlpha);
        }
    }

    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        canvas.saveLayerAlpha(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.mAlpha, 31);
        canvas.drawText(this.mText, (float) (getWidth() / 2), (float) (getPaddingTop() - this.mAscent), this.mTextPaint);
        canvas.restore();
    }

    protected void onMeasure(int i, int i2) {
        if (getMeasuredWidth() == 0 || getMeasuredWidth() == 0) {
            setMeasuredDimension(measureWidth(i), measureHeight(i2));
        } else {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    private int measureWidth(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int textWidth = (int) getTextWidth();
        return mode == Action.UNDEFINED_DURATION ? Math.min(textWidth, size) : textWidth;
    }

    private int measureHeight(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        this.mAscent = (int) this.mTextPaint.ascent();
        if (mode == 1073741824) {
            return size;
        }
        int abs = (int) ((((float) Math.abs(this.mAscent)) + this.mTextPaint.descent()) + ((float) getVerticalPadding()));
        return mode == Action.UNDEFINED_DURATION ? Math.min(abs, size) : abs;
    }

    private void calculateTextSize() {
        float textWidth = getTextWidth();
        float textSize = this.mTextPaint.getTextSize();
        while (textWidth >= this.mMaxWidth) {
            textSize -= 1.0f;
            this.mTextPaint.setTextSize(textSize);
            textWidth = getTextWidth();
        }
        this.mAscent = (int) this.mTextPaint.ascent();
        invalidate();
    }

    private float getTextWidth() {
        return this.mTextPaint.measureText(this.mText) + ((float) getHorizontalPadding());
    }

    private int getHorizontalPadding() {
        return getPaddingLeft() + getPaddingRight();
    }

    private int getVerticalPadding() {
        return getPaddingTop() + getPaddingBottom();
    }
}
