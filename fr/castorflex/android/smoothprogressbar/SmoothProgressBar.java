package fr.castorflex.android.smoothprogressbar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;
import fr.castorflex.android.smoothprogressbar.C3203b.C3196a;
import fr.castorflex.android.smoothprogressbar.C3203b.C3197b;
import fr.castorflex.android.smoothprogressbar.C3203b.C3198c;
import fr.castorflex.android.smoothprogressbar.C3203b.C3199d;
import fr.castorflex.android.smoothprogressbar.C3203b.C3200e;
import fr.castorflex.android.smoothprogressbar.C3203b.C3201f;
import fr.castorflex.android.smoothprogressbar.C3203b.C3202g;
import fr.castorflex.android.smoothprogressbar.C3208d.C3206a;
import fr.castorflex.android.smoothprogressbar.C3208d.C3207b;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class SmoothProgressBar extends ProgressBar {
    public SmoothProgressBar(Context context) {
        this(context, null);
    }

    public SmoothProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C3196a.spbStyle);
    }

    public SmoothProgressBar(Context context, AttributeSet attributeSet, int i) {
        Interpolator accelerateInterpolator;
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3202g.SmoothProgressBar, i, 0);
        int color = obtainStyledAttributes.getColor(1, resources.getColor(C3198c.spb_default_color));
        int integer = obtainStyledAttributes.getInteger(4, resources.getInteger(C3200e.spb_default_sections_count));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(3, resources.getDimensionPixelSize(C3199d.spb_default_stroke_separator_length));
        float dimension = obtainStyledAttributes.getDimension(2, resources.getDimension(C3199d.spb_default_stroke_width));
        float f = obtainStyledAttributes.getFloat(5, Float.parseFloat(resources.getString(C3201f.spb_default_speed)));
        float f2 = obtainStyledAttributes.getFloat(6, f);
        float f3 = obtainStyledAttributes.getFloat(7, f);
        int integer2 = obtainStyledAttributes.getInteger(8, -1);
        boolean z = obtainStyledAttributes.getBoolean(9, resources.getBoolean(C3197b.spb_default_reversed));
        boolean z2 = obtainStyledAttributes.getBoolean(10, resources.getBoolean(C3197b.spb_default_mirror_mode));
        int resourceId = obtainStyledAttributes.getResourceId(11, 0);
        boolean z3 = obtainStyledAttributes.getBoolean(12, resources.getBoolean(C3197b.spb_default_progressiveStart_activated));
        Drawable drawable = obtainStyledAttributes.getDrawable(13);
        boolean z4 = obtainStyledAttributes.getBoolean(14, false);
        obtainStyledAttributes.recycle();
        Interpolator interpolator = null;
        if (integer2 == -1) {
            interpolator = getInterpolator();
        }
        if (interpolator == null) {
            Object linearInterpolator;
            switch (integer2) {
                case C3374b.SmoothProgressBar_spb_color /*1*/:
                    linearInterpolator = new LinearInterpolator();
                    break;
                case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                    linearInterpolator = new AccelerateDecelerateInterpolator();
                    break;
                case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                    linearInterpolator = new DecelerateInterpolator();
                    break;
                default:
                    accelerateInterpolator = new AccelerateInterpolator();
                    break;
            }
        }
        accelerateInterpolator = interpolator;
        int[] iArr = null;
        if (resourceId != 0) {
            iArr = resources.getIntArray(resourceId);
        }
        C3206a c = new C3206a(context).m9637b(f).m9640c(f2).m9643d(f3).m9632a(accelerateInterpolator).m9630a(integer).m9638b(dimensionPixelSize).m9629a(dimension).m9633a(z).m9639b(z2).m9642c(z3);
        if (drawable != null) {
            c.m9631a(drawable);
        }
        if (z4) {
            c.m9636b();
        }
        if (iArr == null || iArr.length <= 0) {
            c.m9641c(color);
        } else {
            c.m9634a(iArr);
        }
        setIndeterminateDrawable(c.m9635a());
    }

    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isIndeterminate() && (getIndeterminateDrawable() instanceof C3208d) && !((C3208d) getIndeterminateDrawable()).isRunning()) {
            getIndeterminateDrawable().draw(canvas);
        }
    }

    private C3208d m9621a() {
        Drawable indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null && (indeterminateDrawable instanceof C3208d)) {
            return (C3208d) indeterminateDrawable;
        }
        throw new RuntimeException("The drawable is not a SmoothProgressDrawable");
    }

    public void setInterpolator(Interpolator interpolator) {
        super.setInterpolator(interpolator);
        Drawable indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null && (indeterminateDrawable instanceof C3208d)) {
            ((C3208d) indeterminateDrawable).m9666a(interpolator);
        }
    }

    public void setSmoothProgressDrawableInterpolator(Interpolator interpolator) {
        m9621a().m9666a(interpolator);
    }

    public void setSmoothProgressDrawableColors(int[] iArr) {
        m9621a().m9669a(iArr);
    }

    public void setSmoothProgressDrawableColor(int i) {
        m9621a().m9664a(i);
    }

    public void setSmoothProgressDrawableSpeed(float f) {
        m9621a().m9663a(f);
    }

    public void setSmoothProgressDrawableProgressiveStartSpeed(float f) {
        m9621a().m9671b(f);
    }

    public void setSmoothProgressDrawableProgressiveStopSpeed(float f) {
        m9621a().m9675c(f);
    }

    public void setSmoothProgressDrawableSectionsCount(int i) {
        m9621a().m9672b(i);
    }

    public void setSmoothProgressDrawableSeparatorLength(int i) {
        m9621a().m9676c(i);
    }

    public void setSmoothProgressDrawableStrokeWidth(float f) {
        m9621a().m9678d(f);
    }

    public void setSmoothProgressDrawableReversed(boolean z) {
        m9621a().m9668a(z);
    }

    public void setSmoothProgressDrawableMirrorMode(boolean z) {
        m9621a().m9673b(z);
    }

    public void setProgressiveStartActivated(boolean z) {
        m9621a().m9677c(z);
    }

    public void setSmoothProgressDrawableCallbacks(C3207b c3207b) {
        m9621a().m9667a(c3207b);
    }

    public void setSmoothProgressDrawableBackgroundDrawable(Drawable drawable) {
        m9621a().m9665a(drawable);
    }
}
