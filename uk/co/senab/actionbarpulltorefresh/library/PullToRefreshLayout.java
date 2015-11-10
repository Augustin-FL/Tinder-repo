package uk.co.senab.actionbarpulltorefresh.library;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;
import uk.co.senab.actionbarpulltorefresh.library.p034a.C3366a;

public class PullToRefreshLayout extends FrameLayout {
    private C3372d f7356a;

    /* renamed from: uk.co.senab.actionbarpulltorefresh.library.PullToRefreshLayout.a */
    static class C3365a extends LayoutParams {
        private final String f7355a;

        C3365a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3374b.PullToRefreshView);
            this.f7355a = obtainStyledAttributes.getString(0);
            obtainStyledAttributes.recycle();
        }
    }

    public PullToRefreshLayout(Context context) {
        this(context, null);
    }

    public PullToRefreshLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PullToRefreshLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void setRefreshing(boolean z) {
        m10406b();
        this.f7356a.m10433a(z);
    }

    public final void m10407a() {
        m10406b();
        this.f7356a.m10439c();
    }

    public final void setHeaderViewListener(C3366a c3366a) {
        m10406b();
        this.f7356a.m10432a(c3366a);
    }

    public final View getHeaderView() {
        m10406b();
        return this.f7356a.m10442e();
    }

    public C2359b getHeaderTransformer() {
        m10406b();
        return this.f7356a.m10443f();
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || this.f7356a == null || getChildCount() <= 0) {
            return false;
        }
        return this.f7356a.m10434a(motionEvent);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || this.f7356a == null) {
            return super.onTouchEvent(motionEvent);
        }
        return this.f7356a.m10438b(motionEvent);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C3365a(getContext(), attributeSet);
    }

    protected void onDetachedFromWindow() {
        if (this.f7356a != null) {
            this.f7356a.m10441d();
        }
        super.onDetachedFromWindow();
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (this.f7356a != null) {
            this.f7356a.m10429a(configuration);
        }
        super.onConfigurationChanged(configuration);
    }

    void setPullToRefreshAttacher(C3372d c3372d) {
        if (this.f7356a != null) {
            this.f7356a.m10441d();
        }
        this.f7356a = c3372d;
    }

    private void m10406b() {
        if (this.f7356a == null) {
            throw new IllegalStateException("You need to setup the PullToRefreshLayout before using it");
        }
    }
}
