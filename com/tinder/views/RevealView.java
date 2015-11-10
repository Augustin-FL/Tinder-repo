package com.tinder.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.tinder.utils.al;

public class RevealView extends View {
    @Nullable
    private View mAnchorView;
    private Point mPoint;
    private int mRadius;
    @NonNull
    private PorterDuffXfermode mXferMode;

    public RevealView(Context context) {
        super(context);
        this.mXferMode = new PorterDuffXfermode(Mode.CLEAR);
    }

    public RevealView(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mXferMode = new PorterDuffXfermode(Mode.CLEAR);
        init();
    }

    public RevealView(@NonNull Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mXferMode = new PorterDuffXfermode(Mode.CLEAR);
        init();
    }

    public RevealView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mXferMode = new PorterDuffXfermode(Mode.CLEAR);
        init();
    }

    public void init() {
        al.m9273a(((Activity) getContext()).getWindow(), getContext(), (View) this);
    }

    protected void onDraw(@NonNull Canvas canvas) {
        if (this.mAnchorView != null) {
            this.mPoint = al.m9263a(this.mAnchorView);
            this.mRadius = (this.mAnchorView.getRight() - this.mAnchorView.getLeft()) / 2;
            int i = this.mPoint.x + this.mRadius;
            int i2 = this.mPoint.y;
            canvas.drawColor(Color.argb(150, 0, 0, 0));
            Paint paint = new Paint(1);
            paint.setXfermode(this.mXferMode);
            canvas.drawCircle((float) i, (float) i2, (float) this.mRadius, paint);
            Path path = new Path();
            path.addCircle((float) i, (float) (i2 * 2), (float) (this.mRadius / 2), Direction.CCW);
            canvas.drawPath(path, paint);
        }
    }

    public void setAnchorView(@Nullable View view) {
        if (view == null) {
            throw new IllegalArgumentException("Anchor view must not be null!");
        }
        this.mAnchorView = view;
    }
}
