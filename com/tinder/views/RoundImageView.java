package com.tinder.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tinder.C2241a.C2233a;
import com.tinder.picassowebp.picasso.C2281x;
import com.tinder.picassowebp.picasso.Picasso.LoadedFrom;
import com.tinder.utils.C3095y;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class RoundImageView extends ImageView implements C2281x {
    private BitmapShader mBitmapShader;
    private int mCornerRadius;
    private Bitmap mCurBitmap;
    private Integer mDefaultStyle;
    private Paint mPaint;
    private RectF mRectDestination;

    public RoundImageView(Context context) {
        super(context);
        this.mRectDestination = new RectF();
    }

    public RoundImageView(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        parseAttributes(context, attributeSet);
    }

    public RoundImageView(@NonNull Context context, @NonNull AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        parseAttributes(context, attributeSet);
    }

    public void setStyle(@NonNull String str) {
        Object obj = -1;
        switch (str.hashCode()) {
            case -1360216880:
                if (str.equals("circle")) {
                    obj = 3;
                    break;
                }
                break;
            case 73087533:
                if (str.equals("barely_rounded")) {
                    obj = null;
                    break;
                }
                break;
            case 105762980:
                if (str.equals("very_rounded")) {
                    obj = 2;
                    break;
                }
                break;
            case 1913349822:
                if (str.equals("slightly_rounded")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                this.mDefaultStyle = Integer.valueOf(6);
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                this.mDefaultStyle = Integer.valueOf(10);
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                this.mDefaultStyle = Integer.valueOf(20);
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                this.mDefaultStyle = Integer.valueOf(50);
            default:
        }
    }

    private void parseAttributes(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        this.mRectDestination = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2233a.RoundImageView, 0, 0);
        try {
            this.mDefaultStyle = Integer.valueOf(obtainStyledAttributes.getInteger(0, 0));
            this.mCornerRadius = obtainStyledAttributes.getInt(1, 1);
        } catch (Exception e) {
            C3095y.m9479c(e.getMessage());
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    protected void onDraw(@Nullable Canvas canvas) {
        Drawable drawable = getDrawable();
        if (!isInEditMode()) {
            if (drawable == null) {
                C3095y.m9471a("RoundImageView drawable null - aborting onDraw...");
                return;
            }
            if (canvas == null) {
                canvas = new Canvas();
            }
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Paint paint = getPaint(getShader(bitmap));
            if (bitmap == null || this.mRectDestination == null || paint == null) {
                C3095y.m9476b("Something important was null");
                return;
            }
            calculateRadiusFromStyle(bitmap.getWidth());
            this.mRectDestination.top = 0.0f;
            this.mRectDestination.left = 0.0f;
            this.mRectDestination.bottom = (float) bitmap.getHeight();
            this.mRectDestination.right = (float) bitmap.getWidth();
            try {
                canvas.drawRoundRect(this.mRectDestination, (float) this.mCornerRadius, (float) this.mCornerRadius, paint);
            } catch (Exception e) {
                C3095y.m9471a(e.getMessage());
            }
            this.mCurBitmap = bitmap;
        }
    }

    public int getCornerRadius() {
        return this.mCornerRadius;
    }

    public void setCornerRadius(int i) {
        this.mCornerRadius = i;
        invalidate();
    }

    private void calculateRadiusFromStyle(int i) {
        if (this.mDefaultStyle.intValue() != 0) {
            this.mCornerRadius = Math.round((((float) this.mDefaultStyle.intValue()) / 100.0f) * ((float) i));
        }
    }

    private Paint getPaint(BitmapShader bitmapShader) {
        if (this.mPaint == null || this.mPaint.getShader() != bitmapShader) {
            this.mPaint = new Paint();
            this.mPaint.setAntiAlias(true);
            this.mPaint.setShader(bitmapShader);
            this.mPaint.setFilterBitmap(true);
        }
        return this.mPaint;
    }

    private BitmapShader getShader(Bitmap bitmap) {
        if (this.mBitmapShader == null || this.mCurBitmap != bitmap) {
            this.mBitmapShader = new BitmapShader(bitmap, TileMode.CLAMP, TileMode.CLAMP);
        }
        return this.mBitmapShader;
    }

    public void onBitmapLoaded(Bitmap bitmap, LoadedFrom loadedFrom) {
        setImageBitmap(bitmap);
    }

    public void onBitmapFailed(Drawable drawable) {
        C3095y.m9471a("Fail");
    }

    public void onPrepareLoad(Drawable drawable) {
        setImageDrawable(drawable);
    }
}
