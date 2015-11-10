package fr.castorflex.android.smoothprogressbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import fr.castorflex.android.smoothprogressbar.C3203b.C3197b;
import fr.castorflex.android.smoothprogressbar.C3203b.C3198c;
import fr.castorflex.android.smoothprogressbar.C3203b.C3199d;
import fr.castorflex.android.smoothprogressbar.C3203b.C3200e;
import fr.castorflex.android.smoothprogressbar.C3203b.C3201f;

/* renamed from: fr.castorflex.android.smoothprogressbar.d */
public class C3208d extends Drawable implements Animatable {
    private final Rect f6907a;
    private C3207b f6908b;
    private Interpolator f6909c;
    private Rect f6910d;
    private Paint f6911e;
    private int[] f6912f;
    private int f6913g;
    private boolean f6914h;
    private float f6915i;
    private int f6916j;
    private int f6917k;
    private float f6918l;
    private float f6919m;
    private float f6920n;
    private boolean f6921o;
    private boolean f6922p;
    private boolean f6923q;
    private float f6924r;
    private boolean f6925s;
    private boolean f6926t;
    private int f6927u;
    private int f6928v;
    private float f6929w;
    private Drawable f6930x;
    private final Runnable f6931y;

    /* renamed from: fr.castorflex.android.smoothprogressbar.d.1 */
    class C32051 implements Runnable {
        final /* synthetic */ C3208d f6892a;

        C32051(C3208d c3208d) {
            this.f6892a = c3208d;
        }

        public void run() {
            if (this.f6892a.m9674b()) {
                C3208d.m9647a(this.f6892a, this.f6892a.f6920n * 0.01f);
            } else if (this.f6892a.m9670a()) {
                C3208d.m9647a(this.f6892a, this.f6892a.f6919m * 0.01f);
            } else {
                C3208d.m9647a(this.f6892a, this.f6892a.f6918l * 0.01f);
            }
            if (this.f6892a.f6915i >= this.f6892a.f6924r) {
                this.f6892a.f6922p = true;
                C3208d.m9653b(this.f6892a, this.f6892a.f6924r);
            }
            this.f6892a.scheduleSelf(this.f6892a.f6931y, SystemClock.uptimeMillis() + 16);
            this.f6892a.invalidateSelf();
        }
    }

    /* renamed from: fr.castorflex.android.smoothprogressbar.d.a */
    public static class C3206a {
        private Interpolator f6893a;
        private int f6894b;
        private int[] f6895c;
        private float f6896d;
        private float f6897e;
        private float f6898f;
        private boolean f6899g;
        private boolean f6900h;
        private float f6901i;
        private int f6902j;
        private boolean f6903k;
        private boolean f6904l;
        private Drawable f6905m;
        private C3207b f6906n;

        public C3206a(Context context) {
            m9628a(context);
        }

        public C3208d m9635a() {
            if (this.f6904l) {
                this.f6905m = C3204c.m9627a(this.f6895c, this.f6901i);
            }
            return new C3208d(this.f6894b, this.f6902j, this.f6895c, this.f6901i, this.f6896d, this.f6897e, this.f6898f, this.f6899g, this.f6900h, this.f6906n, this.f6903k, this.f6905m, null);
        }

        private void m9628a(Context context) {
            Resources resources = context.getResources();
            this.f6893a = new AccelerateInterpolator();
            this.f6894b = resources.getInteger(C3200e.spb_default_sections_count);
            this.f6895c = new int[]{resources.getColor(C3198c.spb_default_color)};
            this.f6896d = Float.parseFloat(resources.getString(C3201f.spb_default_speed));
            this.f6897e = this.f6896d;
            this.f6898f = this.f6896d;
            this.f6899g = resources.getBoolean(C3197b.spb_default_reversed);
            this.f6902j = resources.getDimensionPixelSize(C3199d.spb_default_stroke_separator_length);
            this.f6901i = (float) resources.getDimensionPixelOffset(C3199d.spb_default_stroke_width);
            this.f6903k = resources.getBoolean(C3197b.spb_default_progressiveStart_activated);
        }

        public C3206a m9632a(Interpolator interpolator) {
            if (interpolator == null) {
                throw new IllegalArgumentException("Interpolator can't be null");
            }
            this.f6893a = interpolator;
            return this;
        }

        public C3206a m9630a(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("SectionsCount must be > 0");
            }
            this.f6894b = i;
            return this;
        }

        public C3206a m9638b(int i) {
            if (i < 0) {
                throw new IllegalArgumentException("SeparatorLength must be >= 0");
            }
            this.f6902j = i;
            return this;
        }

        public C3206a m9641c(int i) {
            this.f6895c = new int[]{i};
            return this;
        }

        public C3206a m9634a(int[] iArr) {
            if (iArr == null || iArr.length == 0) {
                throw new IllegalArgumentException("Your color array must not be empty");
            }
            this.f6895c = iArr;
            return this;
        }

        public C3206a m9629a(float f) {
            if (f < 0.0f) {
                throw new IllegalArgumentException("The width must be >= 0");
            }
            this.f6901i = f;
            return this;
        }

        public C3206a m9637b(float f) {
            if (f < 0.0f) {
                throw new IllegalArgumentException("Speed must be >= 0");
            }
            this.f6896d = f;
            return this;
        }

        public C3206a m9640c(float f) {
            if (f < 0.0f) {
                throw new IllegalArgumentException("progressiveStartSpeed must be >= 0");
            }
            this.f6897e = f;
            return this;
        }

        public C3206a m9643d(float f) {
            if (f < 0.0f) {
                throw new IllegalArgumentException("progressiveStopSpeed must be >= 0");
            }
            this.f6898f = f;
            return this;
        }

        public C3206a m9633a(boolean z) {
            this.f6899g = z;
            return this;
        }

        public C3206a m9639b(boolean z) {
            this.f6900h = z;
            return this;
        }

        public C3206a m9642c(boolean z) {
            this.f6903k = z;
            return this;
        }

        public C3206a m9631a(Drawable drawable) {
            this.f6905m = drawable;
            return this;
        }

        public C3206a m9636b() {
            this.f6904l = true;
            return this;
        }
    }

    /* renamed from: fr.castorflex.android.smoothprogressbar.d.b */
    public interface C3207b {
        void m9644a();

        void m9645b();
    }

    static /* synthetic */ float m9647a(C3208d c3208d, float f) {
        float f2 = c3208d.f6915i + f;
        c3208d.f6915i = f2;
        return f2;
    }

    static /* synthetic */ float m9653b(C3208d c3208d, float f) {
        float f2 = c3208d.f6915i - f;
        c3208d.f6915i = f2;
        return f2;
    }

    private C3208d(Interpolator interpolator, int i, int i2, int[] iArr, float f, float f2, float f3, float f4, boolean z, boolean z2, C3207b c3207b, boolean z3, Drawable drawable) {
        this.f6907a = new Rect();
        this.f6931y = new C32051(this);
        this.f6914h = false;
        this.f6909c = interpolator;
        this.f6917k = i;
        this.f6927u = 0;
        this.f6928v = this.f6917k;
        this.f6916j = i2;
        this.f6918l = f2;
        this.f6919m = f3;
        this.f6920n = f4;
        this.f6921o = z;
        this.f6912f = iArr;
        this.f6913g = 0;
        this.f6923q = z2;
        this.f6925s = false;
        this.f6930x = drawable;
        this.f6929w = f;
        this.f6924r = 1.0f / ((float) this.f6917k);
        this.f6911e = new Paint();
        this.f6911e.setStrokeWidth(f);
        this.f6911e.setStyle(Style.STROKE);
        this.f6911e.setDither(false);
        this.f6911e.setAntiAlias(false);
        this.f6926t = z3;
        this.f6908b = c3207b;
    }

    public void m9666a(Interpolator interpolator) {
        if (interpolator == null) {
            throw new IllegalArgumentException("Interpolator cannot be null");
        }
        this.f6909c = interpolator;
        invalidateSelf();
    }

    public void m9669a(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("Colors cannot be null or empty");
        }
        this.f6913g = 0;
        this.f6912f = iArr;
        invalidateSelf();
    }

    public void m9664a(int i) {
        m9669a(new int[]{i});
    }

    public void m9663a(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Speed must be >= 0");
        }
        this.f6918l = f;
        invalidateSelf();
    }

    public void m9671b(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("SpeedProgressiveStart must be >= 0");
        }
        this.f6919m = f;
        invalidateSelf();
    }

    public void m9675c(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("SpeedProgressiveStop must be >= 0");
        }
        this.f6920n = f;
        invalidateSelf();
    }

    public void m9672b(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("SectionsCount must be > 0");
        }
        this.f6917k = i;
        this.f6924r = 1.0f / ((float) this.f6917k);
        this.f6915i %= this.f6924r;
        invalidateSelf();
    }

    public void m9676c(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("SeparatorLength must be >= 0");
        }
        this.f6916j = i;
        invalidateSelf();
    }

    public void m9678d(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("The strokeWidth must be >= 0");
        }
        this.f6911e.setStrokeWidth(f);
        invalidateSelf();
    }

    public void m9668a(boolean z) {
        if (this.f6921o != z) {
            this.f6921o = z;
            invalidateSelf();
        }
    }

    public void m9673b(boolean z) {
        if (this.f6923q != z) {
            this.f6923q = z;
            invalidateSelf();
        }
    }

    public void m9665a(Drawable drawable) {
        if (this.f6930x != drawable) {
            this.f6930x = drawable;
            invalidateSelf();
        }
    }

    public void m9677c(boolean z) {
        this.f6926t = z;
    }

    public void draw(Canvas canvas) {
        this.f6910d = getBounds();
        canvas.clipRect(this.f6910d);
        int width = this.f6910d.width();
        if (this.f6921o) {
            canvas.translate((float) width, 0.0f);
            canvas.scale(GroundOverlayOptions.NO_DIMENSION, 1.0f);
        }
        m9648a(canvas);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m9648a(android.graphics.Canvas r21) {
        /*
        r20 = this;
        r6 = 0;
        r0 = r20;
        r2 = r0.f6910d;
        r4 = r2.width();
        r0 = r20;
        r2 = r0.f6923q;
        if (r2 == 0) goto L_0x0011;
    L_0x000f:
        r4 = r4 / 2;
    L_0x0011:
        r0 = r20;
        r2 = r0.f6916j;
        r2 = r2 + r4;
        r0 = r20;
        r3 = r0.f6917k;
        r15 = r2 + r3;
        r0 = r20;
        r2 = r0.f6910d;
        r16 = r2.centerY();
        r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r0 = r20;
        r3 = r0.f6917k;
        r3 = (float) r3;
        r17 = r2 / r3;
        r0 = r20;
        r2 = r0.f6922p;
        if (r2 == 0) goto L_0x0078;
    L_0x0033:
        r0 = r20;
        r2 = r0.f6913g;
        r0 = r20;
        r2 = r0.m9659e(r2);
        r0 = r20;
        r0.f6913g = r2;
        r2 = 0;
        r0 = r20;
        r0.f6922p = r2;
        r2 = r20.m9674b();
        if (r2 == 0) goto L_0x0064;
    L_0x004c:
        r0 = r20;
        r2 = r0.f6927u;
        r2 = r2 + 1;
        r0 = r20;
        r0.f6927u = r2;
        r0 = r20;
        r2 = r0.f6927u;
        r0 = r20;
        r3 = r0.f6917k;
        if (r2 <= r3) goto L_0x0064;
    L_0x0060:
        r20.stop();
    L_0x0063:
        return;
    L_0x0064:
        r0 = r20;
        r2 = r0.f6928v;
        r0 = r20;
        r3 = r0.f6917k;
        if (r2 >= r3) goto L_0x0078;
    L_0x006e:
        r0 = r20;
        r2 = r0.f6928v;
        r2 = r2 + 1;
        r0 = r20;
        r0.f6928v = r2;
    L_0x0078:
        r2 = 0;
        r5 = 0;
        r0 = r20;
        r9 = r0.f6913g;
        r0 = r20;
        r3 = r0.f6927u;
        r0 = r20;
        r7 = r0.f6928v;
        if (r3 != r7) goto L_0x0097;
    L_0x0088:
        r0 = r20;
        r3 = r0.f6928v;
        r0 = r20;
        r7 = r0.f6917k;
        if (r3 != r7) goto L_0x0097;
    L_0x0092:
        r2 = r21.getWidth();
        r2 = (float) r2;
    L_0x0097:
        r3 = 0;
        r10 = r3;
        r11 = r5;
        r12 = r2;
        r13 = r6;
    L_0x009c:
        r0 = r20;
        r2 = r0.f6928v;
        if (r10 > r2) goto L_0x0134;
    L_0x00a2:
        r2 = (float) r10;
        r2 = r2 * r17;
        r0 = r20;
        r3 = r0.f6915i;
        r2 = r2 + r3;
        r3 = 0;
        r5 = r2 - r17;
        r3 = java.lang.Math.max(r3, r5);
        r0 = r20;
        r5 = r0.f6909c;
        r5 = r5.getInterpolation(r3);
        r0 = r20;
        r6 = r0.f6909c;
        r7 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r2 = java.lang.Math.min(r2, r7);
        r2 = r6.getInterpolation(r2);
        r2 = r5 - r2;
        r2 = java.lang.Math.abs(r2);
        r5 = (float) r15;
        r2 = r2 * r5;
        r2 = (int) r2;
        r0 = (float) r2;
        r18 = r0;
        r2 = r18 + r3;
        r3 = (float) r15;
        r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
        if (r2 >= 0) goto L_0x012f;
    L_0x00da:
        r0 = r20;
        r2 = r0.f6916j;
        r2 = (float) r2;
        r0 = r18;
        r2 = java.lang.Math.min(r0, r2);
        r14 = r2;
    L_0x00e6:
        r2 = (r18 > r14 ? 1 : (r18 == r14 ? 0 : -1));
        if (r2 <= 0) goto L_0x0132;
    L_0x00ea:
        r2 = r18 - r14;
    L_0x00ec:
        r19 = r13 + r2;
        r2 = (r19 > r13 ? 1 : (r19 == r13 ? 0 : -1));
        if (r2 <= 0) goto L_0x013f;
    L_0x00f2:
        r0 = r20;
        r2 = r0.f6927u;
        if (r10 < r2) goto L_0x013f;
    L_0x00f8:
        r2 = (float) r4;
        r5 = java.lang.Math.min(r2, r13);
        r2 = (float) r4;
        r0 = r19;
        r7 = java.lang.Math.min(r2, r0);
        r0 = r16;
        r6 = (float) r0;
        r0 = r16;
        r8 = (float) r0;
        r2 = r20;
        r3 = r21;
        r2.m9650a(r3, r4, r5, r6, r7, r8, r9);
        r0 = r20;
        r2 = r0.f6927u;
        if (r10 != r2) goto L_0x013f;
    L_0x0117:
        r0 = r20;
        r2 = r0.f6928v;
        if (r10 != r2) goto L_0x013d;
    L_0x011d:
        r3 = r13 + r18;
    L_0x011f:
        r6 = r19 + r14;
        r0 = r20;
        r9 = r0.m9657d(r9);
        r2 = r10 + 1;
        r10 = r2;
        r11 = r3;
        r12 = r5;
        r13 = r6;
        goto L_0x009c;
    L_0x012f:
        r2 = 0;
        r14 = r2;
        goto L_0x00e6;
    L_0x0132:
        r2 = 0;
        goto L_0x00ec;
    L_0x0134:
        r0 = r20;
        r1 = r21;
        r0.m9649a(r1, r12, r11);
        goto L_0x0063;
    L_0x013d:
        r3 = r11;
        goto L_0x011f;
    L_0x013f:
        r5 = r12;
        goto L_0x0117;
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.castorflex.android.smoothprogressbar.d.a(android.graphics.Canvas):void");
    }

    private void m9650a(Canvas canvas, int i, float f, float f2, float f3, float f4, int i2) {
        this.f6911e.setColor(this.f6912f[i2]);
        if (!this.f6923q) {
            canvas.drawLine(f, f2, f3, f4, this.f6911e);
        } else if (this.f6921o) {
            canvas.drawLine(((float) i) + f, f2, ((float) i) + f3, f4, this.f6911e);
            canvas.drawLine(((float) i) - f, f2, ((float) i) - f3, f4, this.f6911e);
        } else {
            canvas.drawLine(f, f2, f3, f4, this.f6911e);
            canvas.drawLine(((float) (i * 2)) - f, f2, ((float) (i * 2)) - f3, f4, this.f6911e);
        }
    }

    private void m9649a(Canvas canvas, float f, float f2) {
        if (this.f6930x != null) {
            this.f6907a.top = (int) ((((float) canvas.getHeight()) - this.f6929w) / 2.0f);
            this.f6907a.bottom = (int) ((((float) canvas.getHeight()) + this.f6929w) / 2.0f);
            this.f6907a.left = 0;
            this.f6907a.right = this.f6923q ? canvas.getWidth() / 2 : canvas.getWidth();
            this.f6930x.setBounds(this.f6907a);
            if (isRunning()) {
                if (m9674b() || m9670a()) {
                    if (f <= f2) {
                        float f3 = f2;
                        f2 = f;
                        f = f3;
                    }
                    if (f2 > 0.0f) {
                        if (this.f6923q) {
                            canvas.save();
                            canvas.translate((float) (canvas.getWidth() / 2), 0.0f);
                            if (this.f6921o) {
                                m9654b(canvas, 0.0f, f2);
                                canvas.scale(GroundOverlayOptions.NO_DIMENSION, 1.0f);
                                m9654b(canvas, 0.0f, f2);
                            } else {
                                m9654b(canvas, ((float) (canvas.getWidth() / 2)) - f2, (float) (canvas.getWidth() / 2));
                                canvas.scale(GroundOverlayOptions.NO_DIMENSION, 1.0f);
                                m9654b(canvas, ((float) (canvas.getWidth() / 2)) - f2, (float) (canvas.getWidth() / 2));
                            }
                            canvas.restore();
                        } else {
                            m9654b(canvas, 0.0f, f2);
                        }
                    }
                    if (f > ((float) canvas.getWidth())) {
                        return;
                    }
                    if (this.f6923q) {
                        canvas.save();
                        canvas.translate((float) (canvas.getWidth() / 2), 0.0f);
                        if (this.f6921o) {
                            m9654b(canvas, f, (float) (canvas.getWidth() / 2));
                            canvas.scale(GroundOverlayOptions.NO_DIMENSION, 1.0f);
                            m9654b(canvas, f, (float) (canvas.getWidth() / 2));
                        } else {
                            m9654b(canvas, 0.0f, ((float) (canvas.getWidth() / 2)) - f);
                            canvas.scale(GroundOverlayOptions.NO_DIMENSION, 1.0f);
                            m9654b(canvas, 0.0f, ((float) (canvas.getWidth() / 2)) - f);
                        }
                        canvas.restore();
                        return;
                    }
                    m9654b(canvas, f, (float) canvas.getWidth());
                }
            } else if (this.f6923q) {
                canvas.save();
                canvas.translate((float) (canvas.getWidth() / 2), 0.0f);
                m9654b(canvas, 0.0f, (float) this.f6907a.width());
                canvas.scale(GroundOverlayOptions.NO_DIMENSION, 1.0f);
                m9654b(canvas, 0.0f, (float) this.f6907a.width());
                canvas.restore();
            } else {
                m9654b(canvas, 0.0f, (float) this.f6907a.width());
            }
        }
    }

    private void m9654b(Canvas canvas, float f, float f2) {
        int save = canvas.save();
        canvas.clipRect(f, (float) ((int) ((((float) canvas.getHeight()) - this.f6929w) / 2.0f)), f2, (float) ((int) ((((float) canvas.getHeight()) + this.f6929w) / 2.0f)));
        this.f6930x.draw(canvas);
        canvas.restoreToCount(save);
    }

    private int m9657d(int i) {
        int i2 = i + 1;
        if (i2 >= this.f6912f.length) {
            return 0;
        }
        return i2;
    }

    private int m9659e(int i) {
        int i2 = i - 1;
        if (i2 < 0) {
            return this.f6912f.length - 1;
        }
        return i2;
    }

    private void m9661f(int i) {
        m9662g(i);
        this.f6915i = 0.0f;
        this.f6925s = false;
        this.f6927u = 0;
        this.f6928v = 0;
        this.f6913g = i;
    }

    public void setAlpha(int i) {
        this.f6911e.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f6911e.setColorFilter(colorFilter);
    }

    public int getOpacity() {
        return -2;
    }

    public void start() {
        if (this.f6926t) {
            m9661f(0);
        }
        if (!isRunning()) {
            if (this.f6908b != null) {
                this.f6908b.m9645b();
            }
            scheduleSelf(this.f6931y, SystemClock.uptimeMillis() + 16);
            invalidateSelf();
        }
    }

    public void stop() {
        if (isRunning()) {
            if (this.f6908b != null) {
                this.f6908b.m9644a();
            }
            this.f6914h = false;
            unscheduleSelf(this.f6931y);
        }
    }

    public void scheduleSelf(Runnable runnable, long j) {
        this.f6914h = true;
        super.scheduleSelf(runnable, j);
    }

    public boolean isRunning() {
        return this.f6914h;
    }

    public boolean m9670a() {
        return this.f6928v < this.f6917k;
    }

    public boolean m9674b() {
        return this.f6925s;
    }

    public void m9667a(C3207b c3207b) {
        this.f6908b = c3207b;
    }

    private void m9662g(int i) {
        if (i < 0 || i >= this.f6912f.length) {
            throw new IllegalArgumentException(String.format("Index %d not valid", new Object[]{Integer.valueOf(i)}));
        }
    }
}
