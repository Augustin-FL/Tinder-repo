package com.facebook.share.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.C0508R;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class LikeBoxCountView extends FrameLayout {
    private int additionalTextPadding;
    private Paint borderPaint;
    private float borderRadius;
    private float caretHeight;
    private LikeBoxCountViewCaretPosition caretPosition;
    private float caretWidth;
    private TextView likeCountLabel;
    private int textPadding;

    /* renamed from: com.facebook.share.internal.LikeBoxCountView.1 */
    static /* synthetic */ class C06091 {
        static final /* synthetic */ int[] f701x5851190f;

        static {
            f701x5851190f = new int[LikeBoxCountViewCaretPosition.values().length];
            try {
                f701x5851190f[LikeBoxCountViewCaretPosition.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f701x5851190f[LikeBoxCountViewCaretPosition.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f701x5851190f[LikeBoxCountViewCaretPosition.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f701x5851190f[LikeBoxCountViewCaretPosition.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public enum LikeBoxCountViewCaretPosition {
        LEFT,
        TOP,
        RIGHT,
        BOTTOM
    }

    public LikeBoxCountView(Context context) {
        super(context);
        this.caretPosition = LikeBoxCountViewCaretPosition.LEFT;
        initialize(context);
    }

    public void setText(String str) {
        this.likeCountLabel.setText(str);
    }

    public void setCaretPosition(LikeBoxCountViewCaretPosition likeBoxCountViewCaretPosition) {
        this.caretPosition = likeBoxCountViewCaretPosition;
        switch (C06091.f701x5851190f[likeBoxCountViewCaretPosition.ordinal()]) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                setAdditionalTextPadding(this.additionalTextPadding, 0, 0, 0);
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                setAdditionalTextPadding(0, this.additionalTextPadding, 0, 0);
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                setAdditionalTextPadding(0, 0, this.additionalTextPadding, 0);
            case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                setAdditionalTextPadding(0, 0, 0, this.additionalTextPadding);
            default:
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        switch (C06091.f701x5851190f[this.caretPosition.ordinal()]) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                paddingLeft = (int) (((float) paddingLeft) + this.caretHeight);
                break;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                paddingTop = (int) (((float) paddingTop) + this.caretHeight);
                break;
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                width = (int) (((float) width) - this.caretHeight);
                break;
            case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                height = (int) (((float) height) - this.caretHeight);
                break;
        }
        Canvas canvas2 = canvas;
        drawBorder(canvas2, (float) paddingLeft, (float) paddingTop, (float) width, (float) height);
    }

    private void initialize(Context context) {
        setWillNotDraw(false);
        this.caretHeight = getResources().getDimension(C0508R.dimen.com_facebook_likeboxcountview_caret_height);
        this.caretWidth = getResources().getDimension(C0508R.dimen.com_facebook_likeboxcountview_caret_width);
        this.borderRadius = getResources().getDimension(C0508R.dimen.com_facebook_likeboxcountview_border_radius);
        this.borderPaint = new Paint();
        this.borderPaint.setColor(getResources().getColor(C0508R.color.com_facebook_likeboxcountview_border_color));
        this.borderPaint.setStrokeWidth(getResources().getDimension(C0508R.dimen.com_facebook_likeboxcountview_border_width));
        this.borderPaint.setStyle(Style.STROKE);
        initializeLikeCountLabel(context);
        addView(this.likeCountLabel);
        setCaretPosition(this.caretPosition);
    }

    private void initializeLikeCountLabel(Context context) {
        this.likeCountLabel = new TextView(context);
        this.likeCountLabel.setLayoutParams(new LayoutParams(-1, -1));
        this.likeCountLabel.setGravity(17);
        this.likeCountLabel.setTextSize(0, getResources().getDimension(C0508R.dimen.com_facebook_likeboxcountview_text_size));
        this.likeCountLabel.setTextColor(getResources().getColor(C0508R.color.com_facebook_likeboxcountview_text_color));
        this.textPadding = getResources().getDimensionPixelSize(C0508R.dimen.com_facebook_likeboxcountview_text_padding);
        this.additionalTextPadding = getResources().getDimensionPixelSize(C0508R.dimen.com_facebook_likeboxcountview_caret_height);
    }

    private void setAdditionalTextPadding(int i, int i2, int i3, int i4) {
        this.likeCountLabel.setPadding(this.textPadding + i, this.textPadding + i2, this.textPadding + i3, this.textPadding + i4);
    }

    private void drawBorder(Canvas canvas, float f, float f2, float f3, float f4) {
        Path path = new Path();
        float f5 = this.borderRadius * 2.0f;
        path.addArc(new RectF(f, f2, f + f5, f2 + f5), -180.0f, 90.0f);
        if (this.caretPosition == LikeBoxCountViewCaretPosition.TOP) {
            path.lineTo((((f3 - f) - this.caretWidth) / 2.0f) + f, f2);
            path.lineTo(((f3 - f) / 2.0f) + f, f2 - this.caretHeight);
            path.lineTo((((f3 - f) + this.caretWidth) / 2.0f) + f, f2);
        }
        path.lineTo(f3 - this.borderRadius, f2);
        path.addArc(new RectF(f3 - f5, f2, f3, f2 + f5), -90.0f, 90.0f);
        if (this.caretPosition == LikeBoxCountViewCaretPosition.RIGHT) {
            path.lineTo(f3, (((f4 - f2) - this.caretWidth) / 2.0f) + f2);
            path.lineTo(this.caretHeight + f3, ((f4 - f2) / 2.0f) + f2);
            path.lineTo(f3, (((f4 - f2) + this.caretWidth) / 2.0f) + f2);
        }
        path.lineTo(f3, f4 - this.borderRadius);
        path.addArc(new RectF(f3 - f5, f4 - f5, f3, f4), 0.0f, 90.0f);
        if (this.caretPosition == LikeBoxCountViewCaretPosition.BOTTOM) {
            path.lineTo((((f3 - f) + this.caretWidth) / 2.0f) + f, f4);
            path.lineTo(((f3 - f) / 2.0f) + f, this.caretHeight + f4);
            path.lineTo((((f3 - f) - this.caretWidth) / 2.0f) + f, f4);
        }
        path.lineTo(this.borderRadius + f, f4);
        path.addArc(new RectF(f, f4 - f5, f5 + f, f4), 90.0f, 90.0f);
        if (this.caretPosition == LikeBoxCountViewCaretPosition.LEFT) {
            path.lineTo(f, (((f4 - f2) + this.caretWidth) / 2.0f) + f2);
            path.lineTo(f - this.caretHeight, ((f4 - f2) / 2.0f) + f2);
            path.lineTo(f, (((f4 - f2) - this.caretWidth) / 2.0f) + f2);
        }
        path.lineTo(f, this.borderRadius + f2);
        canvas.drawPath(path, this.borderPaint);
    }
}
