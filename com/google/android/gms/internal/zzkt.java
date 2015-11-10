package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.Path;
import android.net.Uri;
import android.widget.ImageView;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public final class zzkt extends ImageView {
    private Uri zzact;
    private int zzacu;
    private int zzacv;
    private zza zzacw;
    private int zzacx;
    private float zzacy;

    public interface zza {
        Path zzl(int i, int i2);
    }

    protected void onDraw(Canvas canvas) {
        if (this.zzacw != null) {
            canvas.clipPath(this.zzacw.zzl(getWidth(), getHeight()));
        }
        super.onDraw(canvas);
        if (this.zzacv != 0) {
            canvas.drawColor(this.zzacv);
        }
    }

    protected void onMeasure(int i, int i2) {
        int measuredHeight;
        int i3;
        super.onMeasure(i, i2);
        switch (this.zzacx) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                measuredHeight = getMeasuredHeight();
                i3 = (int) (((float) measuredHeight) * this.zzacy);
                break;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                i3 = getMeasuredWidth();
                measuredHeight = (int) (((float) i3) / this.zzacy);
                break;
            default:
                return;
        }
        setMeasuredDimension(i3, measuredHeight);
    }

    public void zzbv(int i) {
        this.zzacu = i;
    }

    public void zzj(Uri uri) {
        this.zzact = uri;
    }

    public int zzof() {
        return this.zzacu;
    }
}
