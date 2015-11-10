package eu.janmuller.android.simplecropimage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.Iterator;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

class CropImageView extends ImageViewTouchBase {
    ArrayList<HighlightView> f6837a;
    HighlightView f6838b;
    float f6839c;
    float f6840d;
    int f6841e;
    private Context f6842q;

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.h.m9610b() != null) {
            Iterator it = this.f6837a.iterator();
            while (it.hasNext()) {
                HighlightView highlightView = (HighlightView) it.next();
                highlightView.f6852f.set(getImageMatrix());
                highlightView.m9595c();
                if (highlightView.f6848b) {
                    m9579c(highlightView);
                }
            }
        }
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6837a = new ArrayList();
        this.f6838b = null;
        this.f6842q = context;
    }

    protected void m9581a(float f, float f2, float f3) {
        super.m9569a(f, f2, f3);
        Iterator it = this.f6837a.iterator();
        while (it.hasNext()) {
            HighlightView highlightView = (HighlightView) it.next();
            highlightView.f6852f.set(getImageMatrix());
            highlightView.m9595c();
        }
    }

    protected void m9580a(float f, float f2) {
        super.m9568a(f, f2);
        for (int i = 0; i < this.f6837a.size(); i++) {
            HighlightView highlightView = (HighlightView) this.f6837a.get(i);
            highlightView.f6852f.postTranslate(f, f2);
            highlightView.m9595c();
        }
    }

    private void m9577a(MotionEvent motionEvent) {
        int i = 0;
        for (int i2 = 0; i2 < this.f6837a.size(); i2++) {
            HighlightView highlightView = (HighlightView) this.f6837a.get(i2);
            highlightView.m9590a(false);
            highlightView.m9595c();
        }
        while (i < this.f6837a.size()) {
            highlightView = (HighlightView) this.f6837a.get(i);
            if (highlightView.m9585a(motionEvent.getX(), motionEvent.getY()) != 1) {
                if (!highlightView.m9591a()) {
                    highlightView.m9590a(true);
                    highlightView.m9595c();
                }
                invalidate();
            }
            i++;
        }
        invalidate();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        CropImage cropImage = (CropImage) this.f6842q;
        if (cropImage.f6805c) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                if (!cropImage.f6804b) {
                    for (int i = 0; i < this.f6837a.size(); i++) {
                        HighlightView highlightView = (HighlightView) this.f6837a.get(i);
                        int a = highlightView.m9585a(motionEvent.getX(), motionEvent.getY());
                        if (a != 1) {
                            this.f6841e = a;
                            this.f6838b = highlightView;
                            this.f6839c = motionEvent.getX();
                            this.f6840d = motionEvent.getY();
                            this.f6838b.m9589a(a == 32 ? ModifyMode.Move : ModifyMode.Grow);
                            break;
                        }
                    }
                    break;
                }
                m9577a(motionEvent);
                break;
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                if (cropImage.f6804b) {
                    for (int i2 = 0; i2 < this.f6837a.size(); i2++) {
                        HighlightView highlightView2 = (HighlightView) this.f6837a.get(i2);
                        if (highlightView2.m9591a()) {
                            cropImage.f6806d = highlightView2;
                            for (int i3 = 0; i3 < this.f6837a.size(); i3++) {
                                if (i3 != i2) {
                                    ((HighlightView) this.f6837a.get(i3)).m9594b(true);
                                }
                            }
                            m9579c(highlightView2);
                            ((CropImage) this.f6842q).f6804b = false;
                            return true;
                        }
                    }
                } else if (this.f6838b != null) {
                    m9579c(this.f6838b);
                    this.f6838b.m9589a(ModifyMode.None);
                }
                this.f6838b = null;
                break;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                if (!cropImage.f6804b) {
                    if (this.f6838b != null) {
                        this.f6838b.m9586a(this.f6841e, motionEvent.getX() - this.f6839c, motionEvent.getY() - this.f6840d);
                        this.f6839c = motionEvent.getX();
                        this.f6840d = motionEvent.getY();
                        m9578b(this.f6838b);
                        break;
                    }
                }
                m9577a(motionEvent);
                break;
                break;
        }
        switch (motionEvent.getAction()) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                m9573a(true, true);
                break;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                if (m9564a() == 1.0f) {
                    m9573a(true, true);
                    break;
                }
                break;
        }
        return true;
    }

    private void m9578b(HighlightView highlightView) {
        Rect rect = highlightView.f6850d;
        int max = Math.max(0, this.l - rect.left);
        int min = Math.min(0, this.m - rect.right);
        int max2 = Math.max(0, this.n - rect.top);
        int min2 = Math.min(0, this.o - rect.bottom);
        if (max == 0) {
            max = min;
        }
        if (max2 == 0) {
            max2 = min2;
        }
        if (max != 0 || max2 != 0) {
            m9575b((float) max, (float) max2);
        }
    }

    private void m9579c(HighlightView highlightView) {
        Rect rect = highlightView.f6850d;
        float width = (float) getWidth();
        float max = Math.max(1.0f, Math.min((width / ((float) rect.width())) * 0.6f, (((float) getHeight()) / ((float) rect.height())) * 0.6f) * m9564a());
        if (((double) (Math.abs(max - m9564a()) / max)) > 0.1d) {
            float[] fArr = new float[]{highlightView.f6851e.centerX(), highlightView.f6851e.centerY()};
            getImageMatrix().mapPoints(fArr);
            m9570a(max, fArr[0], fArr[1], BitmapDescriptorFactory.HUE_MAGENTA);
        }
        m9578b(highlightView);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < this.f6837a.size(); i++) {
            ((HighlightView) this.f6837a.get(i)).m9587a(canvas);
        }
    }

    public void m9582a(HighlightView highlightView) {
        this.f6837a.add(highlightView);
        invalidate();
    }
}
