package eu.janmuller.android.simplecropimage;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.view.View;
import eu.janmuller.android.simplecropimage.C3188a.C3184a;

class HighlightView {
    View f6847a;
    boolean f6848b;
    boolean f6849c;
    Rect f6850d;
    RectF f6851e;
    Matrix f6852f;
    private ModifyMode f6853g;
    private RectF f6854h;
    private boolean f6855i;
    private float f6856j;
    private boolean f6857k;
    private Drawable f6858l;
    private Drawable f6859m;
    private Drawable f6860n;
    private final Paint f6861o;
    private final Paint f6862p;
    private final Paint f6863q;

    enum ModifyMode {
        None,
        Move,
        Grow
    }

    public HighlightView(View view) {
        this.f6853g = ModifyMode.None;
        this.f6855i = false;
        this.f6857k = false;
        this.f6861o = new Paint();
        this.f6862p = new Paint();
        this.f6863q = new Paint();
        this.f6847a = view;
    }

    private void m9583e() {
        Resources resources = this.f6847a.getResources();
        this.f6858l = resources.getDrawable(C3184a.camera_crop_width);
        this.f6859m = resources.getDrawable(C3184a.camera_crop_height);
        this.f6860n = resources.getDrawable(C3184a.indicator_autocrop);
    }

    public boolean m9591a() {
        return this.f6848b;
    }

    public void m9590a(boolean z) {
        this.f6848b = z;
    }

    public void m9594b(boolean z) {
        this.f6849c = z;
    }

    protected void m9587a(Canvas canvas) {
        if (!this.f6849c) {
            Path path = new Path();
            if (m9591a()) {
                Rect rect = new Rect();
                this.f6847a.getDrawingRect(rect);
                if (this.f6857k) {
                    canvas.save();
                    float width = (float) this.f6850d.width();
                    path.addCircle(((float) this.f6850d.left) + (width / 2.0f), (((float) this.f6850d.height()) / 2.0f) + ((float) this.f6850d.top), width / 2.0f, Direction.CW);
                    this.f6863q.setColor(-1112874);
                    canvas.clipPath(path, Op.DIFFERENCE);
                    canvas.drawRect(rect, m9591a() ? this.f6861o : this.f6862p);
                    canvas.restore();
                } else {
                    Rect rect2 = new Rect(rect.left, rect.top, rect.right, this.f6850d.top);
                    if (rect2.width() > 0 && rect2.height() > 0) {
                        canvas.drawRect(rect2, m9591a() ? this.f6861o : this.f6862p);
                    }
                    Rect rect3 = new Rect(rect.left, this.f6850d.bottom, rect.right, rect.bottom);
                    if (rect3.width() > 0 && rect3.height() > 0) {
                        canvas.drawRect(rect3, m9591a() ? this.f6861o : this.f6862p);
                    }
                    Rect rect4 = new Rect(rect.left, rect2.bottom, this.f6850d.left, rect3.top);
                    if (rect4.width() > 0 && rect4.height() > 0) {
                        canvas.drawRect(rect4, m9591a() ? this.f6861o : this.f6862p);
                    }
                    rect4 = new Rect(this.f6850d.right, rect2.bottom, rect.right, rect3.top);
                    if (rect4.width() > 0 && rect4.height() > 0) {
                        canvas.drawRect(rect4, m9591a() ? this.f6861o : this.f6862p);
                    }
                    path.addRect(new RectF(this.f6850d), Direction.CW);
                    this.f6863q.setColor(Color.rgb(51, 181, 229));
                }
                canvas.drawPath(path, this.f6863q);
                if (this.f6853g != ModifyMode.Grow) {
                    return;
                }
                int round;
                int width2;
                int height;
                if (this.f6857k) {
                    round = (int) Math.round(Math.cos(0.7853981633974483d) * (((double) this.f6850d.width()) / 2.0d));
                    width2 = ((this.f6850d.left + (this.f6850d.width() / 2)) + round) - (this.f6860n.getIntrinsicWidth() / 2);
                    height = ((this.f6850d.top + (this.f6850d.height() / 2)) - round) - (this.f6860n.getIntrinsicHeight() / 2);
                    this.f6860n.setBounds(width2, height, this.f6860n.getIntrinsicWidth() + width2, this.f6860n.getIntrinsicHeight() + height);
                    this.f6860n.draw(canvas);
                    return;
                }
                width2 = this.f6850d.left + 1;
                height = this.f6850d.right + 1;
                round = this.f6850d.top + 4;
                int i = this.f6850d.bottom + 3;
                int intrinsicWidth = this.f6858l.getIntrinsicWidth() / 2;
                int intrinsicHeight = this.f6858l.getIntrinsicHeight() / 2;
                int intrinsicHeight2 = this.f6859m.getIntrinsicHeight() / 2;
                int intrinsicWidth2 = this.f6859m.getIntrinsicWidth() / 2;
                int i2 = this.f6850d.left + ((this.f6850d.right - this.f6850d.left) / 2);
                int i3 = this.f6850d.top + ((this.f6850d.bottom - this.f6850d.top) / 2);
                this.f6858l.setBounds(width2 - intrinsicWidth, i3 - intrinsicHeight, width2 + intrinsicWidth, i3 + intrinsicHeight);
                this.f6858l.draw(canvas);
                this.f6858l.setBounds(height - intrinsicWidth, i3 - intrinsicHeight, height + intrinsicWidth, i3 + intrinsicHeight);
                this.f6858l.draw(canvas);
                this.f6859m.setBounds(i2 - intrinsicWidth2, round - intrinsicHeight2, i2 + intrinsicWidth2, round + intrinsicHeight2);
                this.f6859m.draw(canvas);
                this.f6859m.setBounds(i2 - intrinsicWidth2, i - intrinsicHeight2, i2 + intrinsicWidth2, i + intrinsicHeight2);
                this.f6859m.draw(canvas);
                return;
            }
            this.f6863q.setColor(ViewCompat.MEASURED_STATE_MASK);
            canvas.drawRect(this.f6850d, this.f6863q);
        }
    }

    public void m9589a(ModifyMode modifyMode) {
        if (modifyMode != this.f6853g) {
            this.f6853g = modifyMode;
            this.f6847a.invalidate();
        }
    }

    public int m9585a(float f, float f2) {
        Object obj = null;
        Rect f3 = m9584f();
        int sqrt;
        if (this.f6857k) {
            float centerX = f - ((float) f3.centerX());
            float centerY = f2 - ((float) f3.centerY());
            sqrt = (int) Math.sqrt((double) ((centerX * centerX) + (centerY * centerY)));
            int width = this.f6850d.width() / 2;
            if (((float) Math.abs(sqrt - width)) <= 20.0f) {
                if (Math.abs(centerY) > Math.abs(centerX)) {
                    if (centerY < 0.0f) {
                        return 8;
                    }
                    return 16;
                } else if (centerX < 0.0f) {
                    return 2;
                } else {
                    return 4;
                }
            } else if (sqrt >= width) {
                return 1;
            } else {
                return 32;
            }
        }
        int i;
        Object obj2 = (f2 < ((float) f3.top) - 20.0f || f2 >= ((float) f3.bottom) + 20.0f) ? null : 1;
        if (f >= ((float) f3.left) - 20.0f && f < ((float) f3.right) + 20.0f) {
            obj = 1;
        }
        if (Math.abs(((float) f3.left) - f) >= 20.0f || obj2 == null) {
            sqrt = 1;
        } else {
            sqrt = 3;
        }
        if (Math.abs(((float) f3.right) - f) < 20.0f && obj2 != null) {
            sqrt |= 4;
        }
        if (Math.abs(((float) f3.top) - f2) < 20.0f && r3 != null) {
            sqrt |= 8;
        }
        if (Math.abs(((float) f3.bottom) - f2) >= 20.0f || r3 == null) {
            i = sqrt;
        } else {
            i = sqrt | 16;
        }
        if (i == 1 && f3.contains((int) f, (int) f2)) {
            return 32;
        }
        return i;
    }

    void m9586a(int i, float f, float f2) {
        Rect f3 = m9584f();
        if (i != 1) {
            if (i == 32) {
                m9593b((this.f6851e.width() / ((float) f3.width())) * f, (this.f6851e.height() / ((float) f3.height())) * f2);
                return;
            }
            if ((i & 6) == 0) {
                f = 0.0f;
            }
            if ((i & 24) == 0) {
                f2 = 0.0f;
            }
            m9596c((f * (this.f6851e.width() / ((float) f3.width()))) * ((float) ((i & 2) != 0 ? -1 : 1)), ((float) ((i & 8) != 0 ? -1 : 1)) * (f2 * (this.f6851e.height() / ((float) f3.height()))));
        }
    }

    void m9593b(float f, float f2) {
        Rect rect = new Rect(this.f6850d);
        this.f6851e.offset(f, f2);
        this.f6851e.offset(Math.max(0.0f, this.f6854h.left - this.f6851e.left), Math.max(0.0f, this.f6854h.top - this.f6851e.top));
        this.f6851e.offset(Math.min(0.0f, this.f6854h.right - this.f6851e.right), Math.min(0.0f, this.f6854h.bottom - this.f6851e.bottom));
        this.f6850d = m9584f();
        rect.union(this.f6850d);
        rect.inset(-10, -10);
        this.f6847a.invalidate(rect);
    }

    void m9596c(float f, float f2) {
        float f3;
        float f4;
        if (this.f6855i) {
            if (f != 0.0f) {
                f2 = f / this.f6856j;
            } else if (f2 != 0.0f) {
                f = f2 * this.f6856j;
            }
        }
        RectF rectF = new RectF(this.f6851e);
        if (f > 0.0f && rectF.width() + (2.0f * f) > this.f6854h.width()) {
            f = (this.f6854h.width() - rectF.width()) / 2.0f;
            if (this.f6855i) {
                f3 = f / this.f6856j;
                f4 = f;
                if (f3 > 0.0f && rectF.height() + (2.0f * f3) > this.f6854h.height()) {
                    f3 = (this.f6854h.height() - rectF.height()) / 2.0f;
                    if (this.f6855i) {
                        f4 = this.f6856j * f3;
                    }
                }
                rectF.inset(-f4, -f3);
                if (rectF.width() < 25.0f) {
                    rectF.inset((-(25.0f - rectF.width())) / 2.0f, 0.0f);
                }
                f3 = this.f6855i ? 25.0f / this.f6856j : 25.0f;
                if (rectF.height() < f3) {
                    rectF.inset(0.0f, (-(f3 - rectF.height())) / 2.0f);
                }
                if (rectF.left < this.f6854h.left) {
                    rectF.offset(this.f6854h.left - rectF.left, 0.0f);
                } else if (rectF.right > this.f6854h.right) {
                    rectF.offset(-(rectF.right - this.f6854h.right), 0.0f);
                }
                if (rectF.top < this.f6854h.top) {
                    rectF.offset(0.0f, this.f6854h.top - rectF.top);
                } else if (rectF.bottom > this.f6854h.bottom) {
                    rectF.offset(0.0f, -(rectF.bottom - this.f6854h.bottom));
                }
                this.f6851e.set(rectF);
                this.f6850d = m9584f();
                this.f6847a.invalidate();
            }
        }
        f3 = f2;
        f4 = f;
        f3 = (this.f6854h.height() - rectF.height()) / 2.0f;
        if (this.f6855i) {
            f4 = this.f6856j * f3;
        }
        rectF.inset(-f4, -f3);
        if (rectF.width() < 25.0f) {
            rectF.inset((-(25.0f - rectF.width())) / 2.0f, 0.0f);
        }
        if (this.f6855i) {
        }
        if (rectF.height() < f3) {
            rectF.inset(0.0f, (-(f3 - rectF.height())) / 2.0f);
        }
        if (rectF.left < this.f6854h.left) {
            rectF.offset(this.f6854h.left - rectF.left, 0.0f);
        } else if (rectF.right > this.f6854h.right) {
            rectF.offset(-(rectF.right - this.f6854h.right), 0.0f);
        }
        if (rectF.top < this.f6854h.top) {
            rectF.offset(0.0f, this.f6854h.top - rectF.top);
        } else if (rectF.bottom > this.f6854h.bottom) {
            rectF.offset(0.0f, -(rectF.bottom - this.f6854h.bottom));
        }
        this.f6851e.set(rectF);
        this.f6850d = m9584f();
        this.f6847a.invalidate();
    }

    public Rect m9592b() {
        return new Rect((int) this.f6851e.left, (int) this.f6851e.top, (int) this.f6851e.right, (int) this.f6851e.bottom);
    }

    private Rect m9584f() {
        RectF rectF = new RectF(this.f6851e.left, this.f6851e.top, this.f6851e.right, this.f6851e.bottom);
        this.f6852f.mapRect(rectF);
        return new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public void m9595c() {
        this.f6850d = m9584f();
    }

    public void m9588a(Matrix matrix, Rect rect, RectF rectF, boolean z, boolean z2) {
        if (z) {
            z2 = true;
        }
        this.f6852f = new Matrix(matrix);
        this.f6851e = rectF;
        this.f6854h = new RectF(rect);
        this.f6855i = z2;
        this.f6857k = z;
        this.f6856j = this.f6851e.width() / this.f6851e.height();
        this.f6850d = m9584f();
        this.f6861o.setARGB(125, 50, 50, 50);
        this.f6862p.setARGB(125, 50, 50, 50);
        this.f6863q.setStrokeWidth(4.0f);
        this.f6863q.setStyle(Style.STROKE);
        this.f6863q.setAntiAlias(true);
        this.f6853g = ModifyMode.None;
        m9583e();
    }

    public RectF m9597d() {
        return this.f6854h;
    }
}
