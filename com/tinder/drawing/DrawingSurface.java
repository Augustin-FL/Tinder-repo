package com.tinder.drawing;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PathMeasure;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import com.tinder.R;
import com.tinder.p030d.C2264j;
import com.tinder.utils.C3095y;
import com.tinder.utils.al;
import java.util.Iterator;
import java.util.LinkedList;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class DrawingSurface extends View {
    private Point f4665a;
    private C2552b f4666b;
    private C2554e f4667c;
    private PathMeasure f4668d;
    private VelocityTracker f4669e;
    @NonNull
    private LinkedList<DrawRecord> f4670f;
    private DrawRecord f4671g;
    private C2264j f4672h;
    private RectF f4673i;
    @Nullable
    private Canvas f4674j;
    @Nullable
    private Bitmap f4675k;
    private View f4676l;
    private float f4677m;
    private float f4678n;
    private PointF f4679o;
    private PointF f4680p;
    private PointF f4681q;
    private float f4682r;

    public DrawingSurface(@NonNull Context context) {
        super(context);
        this.f4670f = new LinkedList();
        m7012a(context);
    }

    public DrawingSurface(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4670f = new LinkedList();
        m7012a(context);
    }

    public DrawingSurface(@NonNull Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4670f = new LinkedList();
        m7012a(context);
    }

    @NonNull
    private static PointF m7011a(@NonNull PointF pointF, @NonNull PointF pointF2) {
        return new PointF((pointF.x + pointF2.x) / 2.0f, (pointF.y + pointF2.y) / 2.0f);
    }

    private static boolean m7015a(float f, float f2) {
        return Math.abs(f2 - f) > 0.001f;
    }

    private void m7012a(@NonNull Context context) {
        C3095y.m9469a();
        this.f4673i = new RectF();
        this.f4665a = al.m9286b((Activity) context);
        this.f4668d = new PathMeasure();
        this.f4675k = Bitmap.createBitmap(this.f4665a.x, this.f4665a.y, Config.ARGB_8888);
        this.f4674j = new Canvas(this.f4675k);
        this.f4682r = (float) context.getResources().getDimensionPixelSize(R.dimen.moment_editor_dot_radius);
    }

    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        boolean z = false;
        if (!isEnabled()) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (motionEvent.getActionMasked()) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                if (this.f4669e == null) {
                    this.f4669e = VelocityTracker.obtain();
                }
                this.f4681q = new PointF(x, y);
                this.f4680p = this.f4681q;
                this.f4679o = this.f4680p;
                this.f4671g = new DrawRecord();
                this.f4667c = new C2554e(this.f4666b.m7028a());
                this.f4667c.m7036a(this.f4666b.m7029b());
                this.f4678n = x;
                this.f4677m = 0.0f;
                break;
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                if (this.f4677m == 0.0f) {
                    z = true;
                }
                if (z) {
                    C2550c c2551a = new C2551a(this.f4666b.m7028a(), this.f4682r);
                    c2551a.m7025a(x, y);
                    c2551a.m7024a(motionEvent.getPressure());
                    c2551a.m7026a(this.f4674j, null);
                    this.f4671g.m7009a(c2551a);
                    this.f4670f.add(this.f4671g);
                    m7014a(motionEvent);
                } else {
                    if (!this.f4671g.contains(this.f4667c)) {
                        this.f4671g.m7009a(this.f4667c);
                    }
                    this.f4670f.add(this.f4671g);
                    this.f4673i.setEmpty();
                    this.f4669e.clear();
                }
                this.f4672h.m5976g();
                break;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                float abs = Math.abs(this.f4680p.x - x);
                float abs2 = Math.abs(this.f4680p.y - y);
                if (abs > 20.0f || abs2 > 20.0f) {
                    this.f4669e.addMovement(motionEvent);
                    this.f4669e.computeCurrentVelocity(1);
                    abs = this.f4666b.m7027a(this.f4667c.m7038b(), this.f4669e.getXVelocity(), this.f4669e.getYVelocity());
                    if (m7015a(this.f4667c.m7038b(), abs)) {
                        this.f4671g.m7009a(this.f4667c);
                        this.f4667c = new C2554e(this.f4666b.m7028a());
                        this.f4667c.m7036a(abs);
                    }
                    this.f4679o = this.f4680p;
                    this.f4680p = this.f4681q;
                    this.f4681q = new PointF(x, y);
                    this.f4677m = this.f4678n - x;
                    PointF a = m7011a(this.f4680p, this.f4679o);
                    PointF a2 = m7011a(this.f4681q, this.f4680p);
                    this.f4667c.moveTo(a.x, a.y);
                    this.f4667c.quadTo(this.f4680p.x, this.f4680p.y, a2.x, a2.y);
                    this.f4667c.m7037a(this.f4674j, this.f4666b.m7028a());
                    m7014a(motionEvent);
                    this.f4672h.m5975f();
                    break;
                }
        }
        return true;
    }

    protected void onDraw(@NonNull Canvas canvas) {
        C3095y.m9469a();
        if (this.f4675k != null) {
            Rect clipBounds = canvas.getClipBounds();
            canvas.drawBitmap(this.f4675k, (float) clipBounds.left, (float) clipBounds.top, this.f4666b.m7028a());
        }
    }

    public void m7017a() {
        setBackgroundResource(0);
    }

    @Nullable
    public Bitmap getPicture() {
        C3095y.m9469a();
        Rect rect = new Rect(0, 0, this.f4674j.getWidth(), this.f4674j.getHeight());
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getBackground();
        try {
            Bitmap createBitmap = Bitmap.createBitmap(this.f4665a.x, this.f4665a.y, Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawBitmap(bitmapDrawable.getBitmap(), null, rect, null);
            canvas.drawBitmap(this.f4675k, null, rect, null);
            m7013a(canvas);
            if (!al.m9276a()) {
                canvas.setBitmap(null);
            }
            return createBitmap;
        } catch (OutOfMemoryError e) {
            C3095y.m9479c(e.getMessage());
            return bitmapDrawable.getBitmap();
        } catch (Exception e2) {
            C3095y.m9479c(e2.getMessage());
            return bitmapDrawable.getBitmap();
        }
    }

    @SuppressLint({"NewApi"})
    public void setPicture(BitmapDrawable bitmapDrawable) {
        if (al.m9289b()) {
            setBackground(bitmapDrawable);
        } else {
            setBackgroundDrawable(bitmapDrawable);
        }
    }

    public void setListener(C2264j c2264j) {
        this.f4672h = c2264j;
    }

    public void m7018a(boolean z) {
        if (this.f4670f.size() > 0) {
            boolean z2;
            this.f4674j.drawColor(0, Mode.CLEAR);
            if (z) {
                this.f4670f.clear();
            } else {
                this.f4670f.removeLast();
                Iterator it = this.f4670f.iterator();
                while (it.hasNext()) {
                    Iterator it2 = ((DrawRecord) it.next()).iterator();
                    while (it2.hasNext()) {
                        C2550c c2550c = (C2550c) it2.next();
                        c2550c.m7022a(this.f4674j, c2550c.m7021a());
                    }
                }
            }
            invalidate();
            C2264j c2264j = this.f4672h;
            if (m7019b()) {
                z2 = false;
            } else {
                z2 = true;
            }
            c2264j.m5974a(z2);
        }
    }

    private void m7013a(@NonNull Canvas canvas) {
        if (this.f4676l != null) {
            int[] iArr = new int[2];
            this.f4676l.getLocationInWindow(iArr);
            this.f4676l.destroyDrawingCache();
            this.f4676l.buildDrawingCache();
            canvas.drawBitmap(this.f4676l.getDrawingCache(), (float) iArr[0], (float) iArr[1], null);
        }
    }

    public void setViewToComposite(View view) {
        this.f4676l = view;
    }

    public boolean m7019b() {
        return this.f4670f.size() > 0;
    }

    public float getCurrentPathLength() {
        this.f4668d.setPath(this.f4667c, false);
        return this.f4668d.getLength();
    }

    public int getLastColor() {
        if (this.f4670f.isEmpty() || ((DrawRecord) this.f4670f.getLast()).isEmpty()) {
            return 0;
        }
        return ((DrawRecord) this.f4670f.getLast()).m7010b().m7021a().getColor();
    }

    public void setDrawingTool(C2552b c2552b) {
        this.f4666b = c2552b;
    }

    private void m7016b(float f, float f2) {
        if (f < this.f4673i.left) {
            this.f4673i.left = f;
        } else if (f > this.f4673i.right) {
            this.f4673i.right = f;
        }
        if (f2 < this.f4673i.top) {
            this.f4673i.top = f2;
        } else if (f2 > this.f4673i.bottom) {
            this.f4673i.bottom = f2;
        }
    }

    private void m7014a(@NonNull MotionEvent motionEvent) {
        if (al.m9276a()) {
            invalidate();
            return;
        }
        for (int i = 0; i < motionEvent.getHistorySize(); i++) {
            m7016b(motionEvent.getX(), motionEvent.getY());
        }
        if (this.f4673i.width() == 0.0f && this.f4673i.height() == 0.0f) {
            this.f4673i.offsetTo(motionEvent.getX(), motionEvent.getY());
        }
        invalidate(((int) this.f4673i.left) - 60, ((int) this.f4673i.top) - 60, ((int) this.f4673i.right) + 60, ((int) this.f4673i.bottom) + 60);
    }

    public void m7020c() {
        C3095y.m9469a();
        if (!(this.f4675k == null || this.f4675k.isRecycled())) {
            this.f4675k.recycle();
        }
        this.f4675k = null;
        if (!al.m9276a()) {
            this.f4674j.setBitmap(null);
        }
    }
}
