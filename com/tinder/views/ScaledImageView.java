package com.tinder.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;

public class ScaledImageView extends ImageView {
    private int height;
    private int width;

    public ScaledImageView(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.width = 0;
        this.height = 0;
    }

    public ScaledImageView(Context context) {
        super(context);
        this.width = 0;
        this.height = 0;
    }

    public void setMaxHeight(int i) {
        this.height = i;
        super.setMaxHeight(i);
    }

    protected void onMeasure(int i, int i2) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            super.onMeasure(i, i2);
        } else if (MeasureSpec.getSize(i2) > MeasureSpec.getSize(i)) {
            r1 = MeasureSpec.getSize(i);
            r0 = (int) Math.ceil((double) ((((float) r1) * ((float) drawable.getIntrinsicHeight())) / ((float) drawable.getIntrinsicWidth())));
            if (r1 > this.width) {
                this.width = r1;
            }
            if (r0 > this.height) {
                this.height = r0;
            }
            setMeasuredDimension(this.width, this.height);
        } else {
            r1 = MeasureSpec.getSize(i2);
            r0 = (int) Math.ceil((double) ((((float) r1) * ((float) drawable.getIntrinsicWidth())) / ((float) drawable.getIntrinsicHeight())));
            if (r0 > this.width) {
                this.width = r0;
            }
            if (r1 > this.height) {
                this.height = r1;
            }
            setMeasuredDimension(this.width, this.height);
        }
    }
}
