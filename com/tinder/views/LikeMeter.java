package com.tinder.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tinder.R;
import com.tinder.utils.C3066f;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class LikeMeter extends ImageView {
    private static final float PERCENT_FULL = 1.0f;
    private static final float TOP_MARGIN_PERCENTAGE = 0.024f;
    private AssetMode mAssetMode;
    private Canvas mCanvasMasked;
    private Bitmap mMaskHeart;
    private Bitmap mMaskShadow;
    private boolean mNeedsRedraw;
    private Paint mPaintGray;
    private Paint mPaintGreen;
    private Paint mPaintMask;
    private Path mPathGray;
    private Path mPathGreen;
    private float mPercentFull;
    private Bitmap mResultBmp;
    private Rect mShadowRectDst;

    /* renamed from: com.tinder.views.LikeMeter.1 */
    static /* synthetic */ class C31161 {
        static final /* synthetic */ int[] $SwitchMap$com$tinder$views$LikeMeter$AssetMode;

        static {
            $SwitchMap$com$tinder$views$LikeMeter$AssetMode = new int[AssetMode.values().length];
            try {
                $SwitchMap$com$tinder$views$LikeMeter$AssetMode[AssetMode.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$tinder$views$LikeMeter$AssetMode[AssetMode.PLUS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$tinder$views$LikeMeter$AssetMode[AssetMode.EXTRA_LARGE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public enum AssetMode {
        NORMAL,
        PLUS,
        EXTRA_LARGE
    }

    public LikeMeter(Context context) {
        super(context);
        this.mAssetMode = AssetMode.NORMAL;
        init();
    }

    public LikeMeter(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAssetMode = AssetMode.NORMAL;
        init();
    }

    public LikeMeter(@NonNull Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAssetMode = AssetMode.NORMAL;
        init();
    }

    public void init() {
        setWillNotDraw(false);
        this.mPathGreen = new Path();
        this.mPathGray = new Path();
        this.mPaintGreen = new Paint(1);
        this.mPaintGreen.setColor(getResources().getColor(R.color.btn_like_green));
        this.mPaintGray = new Paint(1);
        this.mPaintGray.setColor(getResources().getColor(R.color.like_meter_empty));
        this.mPaintMask = new Paint(1);
        this.mPaintMask.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        setPercentFull(PERCENT_FULL);
    }

    public void setAssetMode(AssetMode assetMode) {
        if (assetMode != this.mAssetMode) {
            this.mAssetMode = assetMode;
            buildMask();
            setPercentFull(this.mPercentFull);
        }
    }

    private void buildMask() {
        int i;
        int i2 = 0;
        switch (C31161.$SwitchMap$com$tinder$views$LikeMeter$AssetMode[this.mAssetMode.ordinal()]) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                i = R.drawable.recs_buttons_like_icon_black_old;
                i2 = R.drawable.recs_buttons_like_shadow_old;
                break;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                i = R.drawable.recs_buttons_like_black;
                i2 = R.drawable.recs_buttons_like_drain_shadow;
                break;
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                i = R.drawable.paywall_header_heart_black;
                i2 = R.drawable.paywall_header_heart_shadow;
                break;
            default:
                i = 0;
                break;
        }
        this.mMaskHeart = BitmapFactory.decodeResource(getResources(), i);
        this.mMaskShadow = BitmapFactory.decodeResource(getResources(), i2);
        this.mResultBmp = Bitmap.createBitmap(this.mMaskHeart.getWidth(), this.mMaskHeart.getHeight(), Config.ARGB_8888);
        i2 = this.mMaskHeart.getWidth() - this.mMaskShadow.getWidth();
        i = this.mMaskHeart.getHeight() - this.mMaskShadow.getHeight();
        this.mShadowRectDst = new Rect();
        this.mShadowRectDst.left = i2 / 2;
        this.mShadowRectDst.top = i / 2;
        this.mShadowRectDst.right = (i2 / 2) + this.mMaskShadow.getWidth();
        this.mShadowRectDst.bottom = (i / 2) + this.mMaskShadow.getHeight();
        this.mCanvasMasked = new Canvas(this.mResultBmp);
        setMinimumHeight(this.mMaskHeart.getHeight());
        setMinimumWidth(this.mMaskHeart.getWidth());
        redraw();
    }

    public float getPercentFull() {
        return this.mPercentFull;
    }

    public void setPercentFull(float f) {
        if (!C3066f.m9351a(this.mMaskHeart, this.mMaskShadow)) {
            buildMask();
        }
        this.mPercentFull = f;
        this.mPathGreen.reset();
        this.mPathGreen.addRect(0.0f, ((float) this.mMaskHeart.getHeight()) * (PERCENT_FULL - this.mPercentFull), (float) this.mMaskHeart.getWidth(), (float) this.mMaskHeart.getHeight(), Direction.CW);
        this.mPathGray.reset();
        this.mPathGray.addRect(0.0f, 0.0f, (float) this.mMaskHeart.getWidth(), (float) this.mMaskHeart.getHeight(), Direction.CW);
        redraw();
    }

    public void setPercentFullInt(int i) {
        setPercentFull(((float) i) / 100.0f);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        redraw();
    }

    private void redraw() {
        this.mNeedsRedraw = true;
        invalidate();
    }

    protected void onDraw(@NonNull Canvas canvas) {
        if (this.mNeedsRedraw) {
            this.mCanvasMasked.drawColor(0, Mode.CLEAR);
        }
        this.mCanvasMasked.drawPath(this.mPathGray, this.mPaintGray);
        if (isEnabled()) {
            this.mCanvasMasked.drawPath(this.mPathGreen, this.mPaintGreen);
        }
        this.mCanvasMasked.drawBitmap(this.mMaskHeart, 0.0f, 0.0f, this.mPaintMask);
        if (this.mPercentFull != PERCENT_FULL && isEnabled()) {
            this.mCanvasMasked.drawBitmap(this.mMaskShadow, null, this.mShadowRectDst, null);
        }
        canvas.drawBitmap(this.mResultBmp, (float) ((getWidth() - this.mMaskHeart.getWidth()) / 2), ((float) ((getHeight() - this.mMaskHeart.getHeight()) / 2)) + (TOP_MARGIN_PERCENTAGE * ((float) getHeight())), null);
    }
}
