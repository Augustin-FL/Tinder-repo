package eu.janmuller.android.simplecropimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

abstract class ImageViewTouchBase extends ImageView {
    private final Matrix f6822a;
    private final float[] f6823b;
    private C3181a f6824c;
    private Runnable f6825d;
    protected Matrix f6826f;
    protected Matrix f6827g;
    protected final C3189b f6828h;
    int f6829i;
    int f6830j;
    float f6831k;
    int f6832l;
    int f6833m;
    int f6834n;
    int f6835o;
    protected Handler f6836p;

    /* renamed from: eu.janmuller.android.simplecropimage.ImageViewTouchBase.1 */
    class C31791 implements Runnable {
        final /* synthetic */ C3189b f6864a;
        final /* synthetic */ boolean f6865b;
        final /* synthetic */ ImageViewTouchBase f6866c;

        C31791(ImageViewTouchBase imageViewTouchBase, C3189b c3189b, boolean z) {
            this.f6866c = imageViewTouchBase;
            this.f6864a = c3189b;
            this.f6865b = z;
        }

        public void run() {
            this.f6866c.m9572a(this.f6864a, this.f6865b);
        }
    }

    /* renamed from: eu.janmuller.android.simplecropimage.ImageViewTouchBase.2 */
    class C31802 implements Runnable {
        final /* synthetic */ float f6867a;
        final /* synthetic */ long f6868b;
        final /* synthetic */ float f6869c;
        final /* synthetic */ float f6870d;
        final /* synthetic */ float f6871e;
        final /* synthetic */ float f6872f;
        final /* synthetic */ ImageViewTouchBase f6873g;

        C31802(ImageViewTouchBase imageViewTouchBase, float f, long j, float f2, float f3, float f4, float f5) {
            this.f6873g = imageViewTouchBase;
            this.f6867a = f;
            this.f6868b = j;
            this.f6869c = f2;
            this.f6870d = f3;
            this.f6871e = f4;
            this.f6872f = f5;
        }

        public void run() {
            float min = Math.min(this.f6867a, (float) (System.currentTimeMillis() - this.f6868b));
            this.f6873g.m9569a(this.f6869c + (this.f6870d * min), this.f6871e, this.f6872f);
            if (min < this.f6867a) {
                this.f6873g.f6836p.post(this);
            }
        }
    }

    /* renamed from: eu.janmuller.android.simplecropimage.ImageViewTouchBase.a */
    public interface C3181a {
        void m9598a(Bitmap bitmap);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f6832l = i;
        this.f6833m = i3;
        this.f6834n = i2;
        this.f6835o = i4;
        this.f6829i = i3 - i;
        this.f6830j = i4 - i2;
        Runnable runnable = this.f6825d;
        if (runnable != null) {
            this.f6825d = null;
            runnable.run();
        }
        if (this.f6828h.m9610b() != null) {
            m9562a(this.f6828h, this.f6826f);
            setImageMatrix(m9574b());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || m9564a() <= 1.0f) {
            return super.onKeyDown(i, keyEvent);
        }
        m9567a(1.0f);
        return true;
    }

    public void setImageBitmap(Bitmap bitmap) {
        m9561a(bitmap, 0);
    }

    private void m9561a(Bitmap bitmap, int i) {
        super.setImageBitmap(bitmap);
        Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.setDither(true);
        }
        Bitmap b = this.f6828h.m9610b();
        this.f6828h.m9609a(bitmap);
        this.f6828h.m9608a(i);
        if (b != null && b != bitmap && this.f6824c != null) {
            this.f6824c.m9598a(b);
        }
    }

    public void m9571a(Bitmap bitmap, boolean z) {
        m9572a(new C3189b(bitmap), z);
    }

    public void m9572a(C3189b c3189b, boolean z) {
        if (getWidth() <= 0) {
            this.f6825d = new C31791(this, c3189b, z);
            return;
        }
        if (c3189b.m9610b() != null) {
            m9562a(c3189b, this.f6826f);
            m9561a(c3189b.m9610b(), c3189b.m9607a());
        } else {
            this.f6826f.reset();
            setImageBitmap(null);
        }
        if (z) {
            this.f6827g.reset();
        }
        setImageMatrix(m9574b());
        this.f6831k = m9576c();
    }

    protected void m9573a(boolean z, boolean z2) {
        float f = 0.0f;
        if (this.f6828h.m9610b() != null) {
            int height;
            Matrix b = m9574b();
            RectF rectF = new RectF(0.0f, 0.0f, (float) this.f6828h.m9610b().getWidth(), (float) this.f6828h.m9610b().getHeight());
            b.mapRect(rectF);
            float height2 = rectF.height();
            float width = rectF.width();
            if (z2) {
                height = getHeight();
                if (height2 < ((float) height)) {
                    height2 = ((((float) height) - height2) / 2.0f) - rectF.top;
                } else if (rectF.top > 0.0f) {
                    height2 = -rectF.top;
                } else if (rectF.bottom < ((float) height)) {
                    height2 = ((float) getHeight()) - rectF.bottom;
                }
                if (z) {
                    height = getWidth();
                    if (width < ((float) height)) {
                        f = ((((float) height) - width) / 2.0f) - rectF.left;
                    } else if (rectF.left > 0.0f) {
                        f = -rectF.left;
                    } else if (rectF.right < ((float) height)) {
                        f = ((float) height) - rectF.right;
                    }
                }
                m9568a(f, height2);
                setImageMatrix(m9574b());
            }
            height2 = 0.0f;
            if (z) {
                height = getWidth();
                if (width < ((float) height)) {
                    f = ((((float) height) - width) / 2.0f) - rectF.left;
                } else if (rectF.left > 0.0f) {
                    f = -rectF.left;
                } else if (rectF.right < ((float) height)) {
                    f = ((float) height) - rectF.right;
                }
            }
            m9568a(f, height2);
            setImageMatrix(m9574b());
        }
    }

    public ImageViewTouchBase(Context context) {
        super(context);
        this.f6826f = new Matrix();
        this.f6827g = new Matrix();
        this.f6822a = new Matrix();
        this.f6823b = new float[9];
        this.f6828h = new C3189b(null);
        this.f6829i = -1;
        this.f6830j = -1;
        this.f6836p = new Handler();
        this.f6825d = null;
        m9563d();
    }

    public ImageViewTouchBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6826f = new Matrix();
        this.f6827g = new Matrix();
        this.f6822a = new Matrix();
        this.f6823b = new float[9];
        this.f6828h = new C3189b(null);
        this.f6829i = -1;
        this.f6830j = -1;
        this.f6836p = new Handler();
        this.f6825d = null;
        m9563d();
    }

    private void m9563d() {
        setScaleType(ScaleType.MATRIX);
    }

    protected float m9566a(Matrix matrix, int i) {
        matrix.getValues(this.f6823b);
        return this.f6823b[i];
    }

    protected float m9565a(Matrix matrix) {
        return m9566a(matrix, 0);
    }

    protected float m9564a() {
        return m9565a(this.f6827g);
    }

    private void m9562a(C3189b c3189b, Matrix matrix) {
        float width = (float) getWidth();
        float height = (float) getHeight();
        float f = (float) c3189b.m9614f();
        float e = (float) c3189b.m9613e();
        c3189b.m9607a();
        matrix.reset();
        float min = Math.min(Math.min(width / f, 2.0f), Math.min(height / e, 2.0f));
        matrix.postConcat(c3189b.m9611c());
        matrix.postScale(min, min);
        matrix.postTranslate((width - (f * min)) / 2.0f, (height - (e * min)) / 2.0f);
    }

    protected Matrix m9574b() {
        this.f6822a.set(this.f6826f);
        this.f6822a.postConcat(this.f6827g);
        return this.f6822a;
    }

    protected float m9576c() {
        if (this.f6828h.m9610b() == null) {
            return 1.0f;
        }
        return Math.max(((float) this.f6828h.m9614f()) / ((float) this.f6829i), ((float) this.f6828h.m9613e()) / ((float) this.f6830j)) * 4.0f;
    }

    protected void m9569a(float f, float f2, float f3) {
        if (f > this.f6831k) {
            f = this.f6831k;
        }
        float a = f / m9564a();
        this.f6827g.postScale(a, a, f2, f3);
        setImageMatrix(m9574b());
        m9573a(true, true);
    }

    protected void m9570a(float f, float f2, float f3, float f4) {
        float a = (f - m9564a()) / f4;
        float a2 = m9564a();
        this.f6836p.post(new C31802(this, f4, System.currentTimeMillis(), a2, a, f2, f3));
    }

    protected void m9567a(float f) {
        m9569a(f, ((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f);
    }

    protected void m9568a(float f, float f2) {
        this.f6827g.postTranslate(f, f2);
    }

    protected void m9575b(float f, float f2) {
        m9568a(f, f2);
        setImageMatrix(m9574b());
    }
}
