package uk.co.senab.actionbarpulltorefresh.library;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import java.util.WeakHashMap;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;
import uk.co.senab.actionbarpulltorefresh.library.p034a.C2667b;
import uk.co.senab.actionbarpulltorefresh.library.p034a.C3366a;
import uk.co.senab.actionbarpulltorefresh.library.p036b.C3368a;

@TargetApi(14)
/* renamed from: uk.co.senab.actionbarpulltorefresh.library.d */
public class C3372d {
    private C3367a f7367a;
    private C2359b f7368b;
    private C2667b f7369c;
    private Activity f7370d;
    private View f7371e;
    private C3366a f7372f;
    private final int f7373g;
    private final float f7374h;
    private float f7375i;
    private float f7376j;
    private float f7377k;
    private float f7378l;
    private boolean f7379m;
    private boolean f7380n;
    private boolean f7381o;
    private View f7382p;
    private final WeakHashMap<View, C3368a> f7383q;
    private final boolean f7384r;
    private final int f7385s;
    private final boolean f7386t;
    private boolean f7387u;
    private final int[] f7388v;
    private final Rect f7389w;
    private final C3371a f7390x;
    private final Runnable f7391y;

    /* renamed from: uk.co.senab.actionbarpulltorefresh.library.d.a */
    private class C3371a implements Runnable {
        final /* synthetic */ C3372d f7366a;

        public void run() {
            if (!this.f7366a.m10426l()) {
                if (m10415c().getWindowToken() != null) {
                    this.f7366a.m10430a(this.f7366a.f7371e);
                } else {
                    m10416a();
                }
            }
        }

        public void m10416a() {
            m10415c().post(this);
        }

        public void m10417b() {
            m10415c().removeCallbacks(this);
        }

        private View m10415c() {
            return this.f7366a.m10448k().getWindow().getDecorView();
        }
    }

    void m10427a() {
        this.f7383q.clear();
    }

    public void m10429a(Configuration configuration) {
        this.f7368b.m6423a(this.f7370d, configuration);
    }

    final void m10433a(boolean z) {
        m10419a(null, z, false);
    }

    final boolean m10437b() {
        return this.f7380n;
    }

    final void m10439c() {
        m10419a(null, false, false);
    }

    void m10441d() {
        if (!this.f7387u) {
            m10440c(this.f7371e);
            m10427a();
            this.f7370d = null;
            this.f7371e = null;
            this.f7372f = null;
            this.f7367a = null;
            this.f7368b = null;
            this.f7387u = true;
        }
    }

    final void m10432a(C3366a c3366a) {
        this.f7372f = c3366a;
    }

    final View m10442e() {
        return this.f7371e;
    }

    C2359b m10443f() {
        return this.f7368b;
    }

    final boolean m10434a(MotionEvent motionEvent) {
        if (m10437b()) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (motionEvent.getAction()) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                if (m10422b(true)) {
                    for (View view : this.f7383q.keySet()) {
                        if (m10435a(view, motionEvent)) {
                            this.f7378l = x;
                            this.f7375i = y;
                            this.f7382p = view;
                        }
                    }
                    break;
                }
                break;
            case C3374b.SmoothProgressBar_spb_color /*1*/:
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                m10444g();
                break;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                if (!this.f7379m && this.f7375i > 0.0f) {
                    float f = y - this.f7375i;
                    if (Math.abs(f) <= Math.abs(x - this.f7378l) || f <= ((float) this.f7373g)) {
                        if (f < ((float) (-this.f7373g))) {
                            m10444g();
                            break;
                        }
                    }
                    this.f7379m = true;
                    m10428a(y);
                    break;
                }
                break;
        }
        return this.f7379m;
    }

    final boolean m10435a(View view, MotionEvent motionEvent) {
        if (view.isShown() && this.f7383q.containsKey(view)) {
            view.getLocationOnScreen(this.f7388v);
            int i = this.f7388v[0];
            int i2 = this.f7388v[1];
            this.f7389w.set(i, i2, view.getWidth() + i, view.getHeight() + i2);
            i2 = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            if (this.f7389w.contains(i2, rawY)) {
                C3368a c3368a = (C3368a) this.f7383q.get(view);
                if (c3368a != null) {
                    return c3368a.m10409a(view, (float) (i2 - this.f7389w.left), (float) (rawY - this.f7389w.top));
                }
            }
        }
        return false;
    }

    final boolean m10438b(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f7381o = true;
        }
        if (this.f7381o && !this.f7379m) {
            m10434a(motionEvent);
            return true;
        } else if (this.f7382p == null) {
            return false;
        } else {
            switch (motionEvent.getAction()) {
                case C3374b.SmoothProgressBar_spb_color /*1*/:
                case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                    m10424d(this.f7382p);
                    if (this.f7379m) {
                        m10445h();
                    }
                    m10444g();
                    return true;
                case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                    if (m10437b()) {
                        return false;
                    }
                    float y = motionEvent.getY();
                    if (!this.f7379m || y == this.f7376j) {
                        return true;
                    }
                    float f = y - this.f7376j;
                    if (f >= ((float) (-this.f7373g))) {
                        m10431a(this.f7382p, y);
                        if (f <= 0.0f) {
                            return true;
                        }
                        this.f7376j = y;
                        return true;
                    }
                    m10445h();
                    m10444g();
                    return true;
                default:
                    return true;
            }
        }
    }

    void m10444g() {
        this.f7379m = false;
        this.f7381o = false;
        this.f7377k = GroundOverlayOptions.NO_DIMENSION;
        this.f7376j = GroundOverlayOptions.NO_DIMENSION;
        this.f7375i = GroundOverlayOptions.NO_DIMENSION;
    }

    void m10428a(float f) {
        m10446i();
        this.f7377k = f;
    }

    void m10431a(View view, float f) {
        float e = m10425e(view);
        float f2 = f - this.f7377k;
        if (f2 < e) {
            this.f7368b.m6422a(f2 / e);
        } else if (this.f7384r) {
            this.f7368b.m6425c();
        } else {
            m10419a(view, true, true);
        }
    }

    void m10445h() {
        if (!this.f7380n) {
            m10423c(true);
        }
    }

    void m10446i() {
        m10436b(this.f7371e);
        if (this.f7368b.m6426d() && this.f7372f != null) {
            this.f7372f.m10408a(this.f7371e, 0);
        }
    }

    void m10447j() {
        if (this.f7368b.m6427e() && this.f7372f != null) {
            this.f7372f.m10408a(this.f7371e, 2);
        }
    }

    protected final Activity m10448k() {
        return this.f7370d;
    }

    private boolean m10424d(View view) {
        if (!this.f7379m || !this.f7384r || view == null || this.f7376j - this.f7377k < m10425e(view)) {
            return false;
        }
        m10419a(view, true, true);
        return true;
    }

    private void m10419a(View view, boolean z, boolean z2) {
        if (!m10426l() && this.f7380n != z) {
            m10444g();
            if (z && m10422b(z2)) {
                m10418a(view, z2);
            } else {
                m10423c(z2);
            }
        }
    }

    private boolean m10422b(boolean z) {
        return (this.f7380n || (z && this.f7369c == null)) ? false : true;
    }

    private float m10425e(View view) {
        return ((float) view.getHeight()) * this.f7374h;
    }

    private void m10423c(boolean z) {
        this.f7380n = false;
        if (this.f7386t) {
            m10442e().removeCallbacks(this.f7391y);
        }
        m10447j();
    }

    private void m10418a(View view, boolean z) {
        this.f7380n = true;
        if (z && this.f7369c != null) {
            this.f7369c.onRefreshStarted(view);
        }
        this.f7368b.m6424b();
        m10446i();
        if (!this.f7386t) {
            return;
        }
        if (this.f7385s > 0) {
            m10442e().postDelayed(this.f7391y, (long) this.f7385s);
        } else {
            m10442e().post(this.f7391y);
        }
    }

    private boolean m10426l() {
        if (this.f7387u) {
            Log.i("PullToRefreshAttacher", "PullToRefreshAttacher is destroyed.");
        }
        return this.f7387u;
    }

    protected void m10430a(View view) {
        this.f7370d.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.f7389w);
        int i = -1;
        int i2 = -2;
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            i = layoutParams.width;
            i2 = layoutParams.height;
        }
        layoutParams = new WindowManager.LayoutParams(i, i2, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, 280, -3);
        layoutParams.x = 0;
        layoutParams.y = this.f7389w.top;
        layoutParams.gravity = 48;
        view.setTag(layoutParams);
        this.f7370d.getWindowManager().addView(view, layoutParams);
    }

    protected void m10436b(View view) {
        this.f7370d.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.f7389w);
        LayoutParams layoutParams = null;
        if (view.getLayoutParams() instanceof WindowManager.LayoutParams) {
            layoutParams = (WindowManager.LayoutParams) view.getLayoutParams();
        } else if (view.getTag() instanceof WindowManager.LayoutParams) {
            WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) view.getTag();
        }
        if (layoutParams != null && layoutParams.y != this.f7389w.top) {
            layoutParams.y = this.f7389w.top;
            this.f7370d.getWindowManager().updateViewLayout(view, layoutParams);
        }
    }

    protected void m10440c(View view) {
        this.f7390x.m10417b();
        if (view.getWindowToken() != null) {
            this.f7370d.getWindowManager().removeViewImmediate(view);
        }
    }
}
