package com.viewpagerindicator;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.widget.RecyclerView.SmoothScroller.Action;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.stetho.BuildConfig;
import com.viewpagerindicator.C3169d.C3163a;

public class TabPageIndicator extends HorizontalScrollView implements C3147c {
    private static final CharSequence f6711a;
    private final C3162b f6712b;
    private Runnable f6713c;
    private ViewPager f6714d;
    private OnPageChangeListener f6715e;
    private int f6716f;
    private int f6717g;
    private C3153a f6718h;
    private final OnClickListener f6719i;

    /* renamed from: com.viewpagerindicator.TabPageIndicator.1 */
    class C31511 implements OnClickListener {
        final /* synthetic */ TabPageIndicator f6706a;

        C31511(TabPageIndicator tabPageIndicator) {
            this.f6706a = tabPageIndicator;
        }

        public void onClick(View view) {
            C3154b c3154b = (C3154b) view;
            int currentItem = this.f6706a.f6714d.getCurrentItem();
            int a = c3154b.m9504a();
            this.f6706a.f6714d.setCurrentItem(a);
            if (currentItem == a && this.f6706a.f6718h != null) {
                this.f6706a.f6718h.m9502a(a);
            }
        }
    }

    /* renamed from: com.viewpagerindicator.TabPageIndicator.2 */
    class C31522 implements Runnable {
        final /* synthetic */ View f6707a;
        final /* synthetic */ TabPageIndicator f6708b;

        C31522(TabPageIndicator tabPageIndicator, View view) {
            this.f6708b = tabPageIndicator;
            this.f6707a = view;
        }

        public void run() {
            this.f6708b.smoothScrollTo(this.f6707a.getLeft() - ((this.f6708b.getWidth() - this.f6707a.getWidth()) / 2), 0);
            this.f6708b.f6713c = null;
        }
    }

    /* renamed from: com.viewpagerindicator.TabPageIndicator.a */
    public interface C3153a {
        void m9502a(int i);
    }

    /* renamed from: com.viewpagerindicator.TabPageIndicator.b */
    private class C3154b extends TextView {
        final /* synthetic */ TabPageIndicator f6709a;
        private int f6710b;

        public C3154b(TabPageIndicator tabPageIndicator, Context context) {
            this.f6709a = tabPageIndicator;
            super(context, null, C3163a.vpiTabPageIndicatorStyle);
        }

        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (this.f6709a.f6716f > 0 && getMeasuredWidth() > this.f6709a.f6716f) {
                super.onMeasure(MeasureSpec.makeMeasureSpec(this.f6709a.f6716f, 1073741824), i2);
            }
        }

        public int m9504a() {
            return this.f6710b;
        }
    }

    static {
        f6711a = BuildConfig.FLAVOR;
    }

    public TabPageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6719i = new C31511(this);
        setHorizontalScrollBarEnabled(false);
        this.f6712b = new C3162b(context, C3163a.vpiTabPageIndicatorStyle);
        addView(this.f6712b, new LayoutParams(-2, -1));
    }

    public void setOnTabReselectedListener(C3153a c3153a) {
        this.f6718h = c3153a;
    }

    public void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.f6712b.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Action.UNDEFINED_DURATION)) {
            this.f6716f = -1;
        } else if (childCount > 2) {
            this.f6716f = (int) (((float) MeasureSpec.getSize(i)) * 0.4f);
        } else {
            this.f6716f = MeasureSpec.getSize(i) / 2;
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, i2);
        mode = getMeasuredWidth();
        if (z && measuredWidth != mode) {
            setCurrentItem(this.f6717g);
        }
    }

    private void m9507a(int i) {
        View childAt = this.f6712b.getChildAt(i);
        if (this.f6713c != null) {
            removeCallbacks(this.f6713c);
        }
        this.f6713c = new C31522(this, childAt);
        post(this.f6713c);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f6713c != null) {
            post(this.f6713c);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f6713c != null) {
            removeCallbacks(this.f6713c);
        }
    }

    private void m9508a(int i, CharSequence charSequence, int i2) {
        View c3154b = new C3154b(this, getContext());
        c3154b.f6710b = i;
        c3154b.setFocusable(true);
        c3154b.setOnClickListener(this.f6719i);
        c3154b.setText(charSequence);
        if (i2 != 0) {
            c3154b.setCompoundDrawablesWithIntrinsicBounds(i2, 0, 0, 0);
        }
        this.f6712b.addView(c3154b, new LinearLayout.LayoutParams(0, -1, 1.0f));
    }

    public void onPageScrollStateChanged(int i) {
        if (this.f6715e != null) {
            this.f6715e.onPageScrollStateChanged(i);
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.f6715e != null) {
            this.f6715e.onPageScrolled(i, f, i2);
        }
    }

    public void onPageSelected(int i) {
        setCurrentItem(i);
        if (this.f6715e != null) {
            this.f6715e.onPageSelected(i);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.f6714d != viewPager) {
            if (this.f6714d != null) {
                this.f6714d.setOnPageChangeListener(null);
            }
            if (viewPager.getAdapter() == null) {
                throw new IllegalStateException("ViewPager does not have adapter instance.");
            }
            this.f6714d = viewPager;
            viewPager.setOnPageChangeListener(this);
            m9511a();
        }
    }

    public void m9511a() {
        this.f6712b.removeAllViews();
        PagerAdapter adapter = this.f6714d.getAdapter();
        C3161a c3161a = null;
        if (adapter instanceof C3161a) {
            c3161a = (C3161a) adapter;
        }
        int count = adapter.getCount();
        for (int i = 0; i < count; i++) {
            CharSequence charSequence;
            int a;
            CharSequence pageTitle = adapter.getPageTitle(i);
            if (pageTitle == null) {
                charSequence = f6711a;
            } else {
                charSequence = pageTitle;
            }
            if (c3161a != null) {
                a = c3161a.m9529a(i);
            } else {
                a = 0;
            }
            m9508a(i, charSequence, a);
        }
        if (this.f6717g > count) {
            this.f6717g = count - 1;
        }
        setCurrentItem(this.f6717g);
        requestLayout();
    }

    public void setCurrentItem(int i) {
        if (this.f6714d == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        this.f6717g = i;
        this.f6714d.setCurrentItem(i);
        int childCount = this.f6712b.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            boolean z;
            View childAt = this.f6712b.getChildAt(i2);
            if (i2 == i) {
                z = true;
            } else {
                z = false;
            }
            childAt.setSelected(z);
            if (z) {
                m9507a(i);
            }
        }
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.f6715e = onPageChangeListener;
    }
}
