package com.tinder.picassowebp.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.widget.ImageView;
import com.tinder.picassowebp.picasso.Picasso.LoadedFrom;
import com.tinder.views.RangeSeekBar;

/* renamed from: com.tinder.picassowebp.picasso.q */
final class C3022q extends BitmapDrawable {
    private static final Paint f6406e;
    Drawable f6407a;
    long f6408b;
    boolean f6409c;
    int f6410d;
    private final boolean f6411f;
    private final float f6412g;
    private final LoadedFrom f6413h;

    static {
        f6406e = new Paint();
    }

    C3022q(Context context, Bitmap bitmap, Drawable drawable, LoadedFrom loadedFrom, boolean z, boolean z2) {
        super(context.getResources(), bitmap);
        this.f6410d = RangeSeekBar.INVALID_POINTER_ID;
        this.f6411f = z2;
        this.f6412g = context.getResources().getDisplayMetrics().density;
        this.f6413h = loadedFrom;
        boolean z3 = (loadedFrom == LoadedFrom.MEMORY || z) ? false : true;
        if (z3) {
            this.f6407a = drawable;
            this.f6409c = true;
            this.f6408b = SystemClock.uptimeMillis();
        }
    }

    static void m9100a(ImageView imageView, Context context, Bitmap bitmap, LoadedFrom loadedFrom, boolean z, boolean z2) {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).stop();
        }
        imageView.setImageDrawable(new C3022q(context, bitmap, drawable, loadedFrom, z, z2));
    }

    static void m9099a(ImageView imageView, int i, Drawable drawable) {
        if (i != 0) {
            imageView.setImageResource(i);
        } else {
            imageView.setImageDrawable(drawable);
        }
        if (imageView.getDrawable() instanceof AnimationDrawable) {
            ((AnimationDrawable) imageView.getDrawable()).start();
        }
    }

    private static Path m9097a(Point point, int i) {
        Point point2 = new Point(point.x + i, point.y);
        Point point3 = new Point(point.x, point.y + i);
        Path path = new Path();
        path.moveTo((float) point.x, (float) point.y);
        path.lineTo((float) point2.x, (float) point2.y);
        path.lineTo((float) point3.x, (float) point3.y);
        return path;
    }

    public void draw(Canvas canvas) {
        if (this.f6409c) {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f6408b)) / 200.0f;
            if (uptimeMillis >= 1.0f) {
                this.f6409c = false;
                this.f6407a = null;
                super.draw(canvas);
            } else {
                if (this.f6407a != null) {
                    this.f6407a.draw(canvas);
                }
                super.setAlpha((int) (uptimeMillis * ((float) this.f6410d)));
                super.draw(canvas);
                super.setAlpha(this.f6410d);
                if (VERSION.SDK_INT <= 10) {
                    invalidateSelf();
                }
            }
        } else {
            super.draw(canvas);
        }
        if (this.f6411f) {
            m9098a(canvas);
        }
    }

    public void setAlpha(int i) {
        this.f6410d = i;
        if (this.f6407a != null) {
            this.f6407a.setAlpha(i);
        }
        super.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f6407a != null) {
            this.f6407a.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }

    protected void onBoundsChange(Rect rect) {
        if (this.f6407a != null) {
            this.f6407a.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    private void m9098a(Canvas canvas) {
        f6406e.setColor(-1);
        canvas.drawPath(C3022q.m9097a(new Point(0, 0), (int) (16.0f * this.f6412g)), f6406e);
        f6406e.setColor(this.f6413h.f6317d);
        canvas.drawPath(C3022q.m9097a(new Point(0, 0), (int) (15.0f * this.f6412g)), f6406e);
    }
}
