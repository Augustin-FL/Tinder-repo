package eu.janmuller.android.simplecropimage;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/* renamed from: eu.janmuller.android.simplecropimage.b */
public class C3189b {
    private Bitmap f6874a;
    private int f6875b;

    public C3189b(Bitmap bitmap) {
        this.f6874a = bitmap;
        this.f6875b = 0;
    }

    public void m9608a(int i) {
        this.f6875b = i;
    }

    public int m9607a() {
        return this.f6875b;
    }

    public Bitmap m9610b() {
        return this.f6874a;
    }

    public void m9609a(Bitmap bitmap) {
        this.f6874a = bitmap;
    }

    public Matrix m9611c() {
        Matrix matrix = new Matrix();
        if (this.f6875b != 0) {
            matrix.preTranslate((float) (-(this.f6874a.getWidth() / 2)), (float) (-(this.f6874a.getHeight() / 2)));
            matrix.postRotate((float) this.f6875b);
            matrix.postTranslate((float) (m9614f() / 2), (float) (m9613e() / 2));
        }
        return matrix;
    }

    public boolean m9612d() {
        return (this.f6875b / 90) % 2 != 0;
    }

    public int m9613e() {
        if (m9612d()) {
            return this.f6874a.getWidth();
        }
        return this.f6874a.getHeight();
    }

    public int m9614f() {
        if (m9612d()) {
            return this.f6874a.getHeight();
        }
        return this.f6874a.getWidth();
    }
}
