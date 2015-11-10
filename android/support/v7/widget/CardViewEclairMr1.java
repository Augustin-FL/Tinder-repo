package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

class CardViewEclairMr1 implements CardViewImpl {
    final RectF sCornerRect;

    /* renamed from: android.support.v7.widget.CardViewEclairMr1.1 */
    class C02261 implements RoundRectHelper {
        C02261() {
        }

        public void drawRoundRect(Canvas canvas, RectF rectF, float f, Paint paint) {
            float f2 = 2.0f * f;
            float width = (rectF.width() - f2) - 1.0f;
            float height = (rectF.height() - f2) - 1.0f;
            if (f >= 1.0f) {
                f += 0.5f;
                CardViewEclairMr1.this.sCornerRect.set(-f, -f, f, f);
                int save = canvas.save();
                canvas.translate(rectF.left + f, rectF.top + f);
                canvas.drawArc(CardViewEclairMr1.this.sCornerRect, BitmapDescriptorFactory.HUE_CYAN, 90.0f, true, paint);
                canvas.translate(width, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(CardViewEclairMr1.this.sCornerRect, BitmapDescriptorFactory.HUE_CYAN, 90.0f, true, paint);
                canvas.translate(height, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(CardViewEclairMr1.this.sCornerRect, BitmapDescriptorFactory.HUE_CYAN, 90.0f, true, paint);
                canvas.translate(width, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(CardViewEclairMr1.this.sCornerRect, BitmapDescriptorFactory.HUE_CYAN, 90.0f, true, paint);
                canvas.restoreToCount(save);
                canvas.drawRect((rectF.left + f) - 1.0f, rectF.top, (rectF.right - f) + 1.0f, rectF.top + f, paint);
                canvas.drawRect((rectF.left + f) - 1.0f, (rectF.bottom - f) + 1.0f, (rectF.right - f) + 1.0f, rectF.bottom, paint);
            }
            canvas.drawRect(rectF.left, Math.max(0.0f, f - 1.0f) + rectF.top, rectF.right, (rectF.bottom - f) + 1.0f, paint);
        }
    }

    CardViewEclairMr1() {
        this.sCornerRect = new RectF();
    }

    public void initStatic() {
        RoundRectDrawableWithShadow.sRoundRectHelper = new C02261();
    }

    public void initialize(CardViewDelegate cardViewDelegate, Context context, int i, float f, float f2, float f3) {
        Drawable createBackground = createBackground(context, i, f, f2, f3);
        createBackground.setAddPaddingForCorners(cardViewDelegate.getPreventCornerOverlap());
        cardViewDelegate.setBackgroundDrawable(createBackground);
        updatePadding(cardViewDelegate);
    }

    RoundRectDrawableWithShadow createBackground(Context context, int i, float f, float f2, float f3) {
        return new RoundRectDrawableWithShadow(context.getResources(), i, f, f2, f3);
    }

    public void updatePadding(CardViewDelegate cardViewDelegate) {
        Rect rect = new Rect();
        getShadowBackground(cardViewDelegate).getMaxShadowAndCornerPadding(rect);
        ((View) cardViewDelegate).setMinimumHeight((int) Math.ceil((double) getMinHeight(cardViewDelegate)));
        ((View) cardViewDelegate).setMinimumWidth((int) Math.ceil((double) getMinWidth(cardViewDelegate)));
        cardViewDelegate.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void onCompatPaddingChanged(CardViewDelegate cardViewDelegate) {
    }

    public void onPreventCornerOverlapChanged(CardViewDelegate cardViewDelegate) {
        getShadowBackground(cardViewDelegate).setAddPaddingForCorners(cardViewDelegate.getPreventCornerOverlap());
        updatePadding(cardViewDelegate);
    }

    public void setBackgroundColor(CardViewDelegate cardViewDelegate, int i) {
        getShadowBackground(cardViewDelegate).setColor(i);
    }

    public void setRadius(CardViewDelegate cardViewDelegate, float f) {
        getShadowBackground(cardViewDelegate).setCornerRadius(f);
        updatePadding(cardViewDelegate);
    }

    public float getRadius(CardViewDelegate cardViewDelegate) {
        return getShadowBackground(cardViewDelegate).getCornerRadius();
    }

    public void setElevation(CardViewDelegate cardViewDelegate, float f) {
        getShadowBackground(cardViewDelegate).setShadowSize(f);
    }

    public float getElevation(CardViewDelegate cardViewDelegate) {
        return getShadowBackground(cardViewDelegate).getShadowSize();
    }

    public void setMaxElevation(CardViewDelegate cardViewDelegate, float f) {
        getShadowBackground(cardViewDelegate).setMaxShadowSize(f);
        updatePadding(cardViewDelegate);
    }

    public float getMaxElevation(CardViewDelegate cardViewDelegate) {
        return getShadowBackground(cardViewDelegate).getMaxShadowSize();
    }

    public float getMinWidth(CardViewDelegate cardViewDelegate) {
        return getShadowBackground(cardViewDelegate).getMinWidth();
    }

    public float getMinHeight(CardViewDelegate cardViewDelegate) {
        return getShadowBackground(cardViewDelegate).getMinHeight();
    }

    private RoundRectDrawableWithShadow getShadowBackground(CardViewDelegate cardViewDelegate) {
        return (RoundRectDrawableWithShadow) cardViewDelegate.getBackground();
    }
}
