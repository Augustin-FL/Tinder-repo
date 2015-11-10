package com.tinder.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;

public class DrawingDebugView extends View {
    private static DrawingDebugView mInstance;
    @NonNull
    private static ArrayList<ShapeBase> sShapes;
    @NonNull
    private Paint paint;

    public static abstract class ShapeBase {
        public abstract void draw(Canvas canvas, Paint paint);
    }

    public static class Point extends ShapeBase {
        private android.graphics.Point mPoint;

        public Point(android.graphics.Point point) {
            this.mPoint = point;
        }

        public void draw(@NonNull Canvas canvas, @NonNull Paint paint) {
            canvas.drawPoint((float) this.mPoint.x, (float) this.mPoint.y, paint);
        }
    }

    static {
        sShapes = new ArrayList();
    }

    public DrawingDebugView(Context context) {
        super(context);
        this.paint = new Paint();
        mInstance = this;
    }

    public DrawingDebugView(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.paint = new Paint();
        mInstance = this;
    }

    public DrawingDebugView(@NonNull Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.paint = new Paint();
        mInstance = this;
    }

    public DrawingDebugView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.paint = new Paint();
        mInstance = this;
    }

    public static void addPoint(android.graphics.Point point) {
        sShapes.add(new Point(point));
        if (mInstance != null) {
            mInstance.invalidate();
        }
    }

    public static void addShape(ShapeBase shapeBase) {
        sShapes.add(shapeBase);
        if (mInstance != null) {
            mInstance.invalidate();
        }
    }

    public static void clearShapes() {
        sShapes.clear();
        if (mInstance != null) {
            mInstance.invalidate();
        }
    }

    public void onDraw(@NonNull Canvas canvas) {
        setVisibility(8);
    }
}
