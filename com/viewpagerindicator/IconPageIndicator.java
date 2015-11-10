package com.viewpagerindicator;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import com.viewpagerindicator.C3169d.C3163a;

public class IconPageIndicator extends HorizontalScrollView implements C3147c {
    private final C3162b f6688a;
    private ViewPager f6689b;
    private OnPageChangeListener f6690c;
    private Runnable f6691d;
    private int f6692e;

    /* renamed from: com.viewpagerindicator.IconPageIndicator.1 */
    class C31481 implements Runnable {
        final /* synthetic */ View f6686a;
        final /* synthetic */ IconPageIndicator f6687b;

        C31481(IconPageIndicator iconPageIndicator, View view) {
            this.f6687b = iconPageIndicator;
            this.f6686a = view;
        }

        public void run() {
            this.f6687b.smoothScrollTo(this.f6686a.getLeft() - ((this.f6687b.getWidth() - this.f6686a.getWidth()) / 2), 0);
            this.f6687b.f6691d = null;
        }
    }

    public IconPageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setHorizontalScrollBarEnabled(false);
        this.f6688a = new C3162b(context, C3163a.vpiIconPageIndicatorStyle);
        addView(this.f6688a, new LayoutParams(-2, -1, 17));
    }

    private void m9496a(int i) {
        View childAt = this.f6688a.getChildAt(i);
        if (this.f6691d != null) {
            removeCallbacks(this.f6691d);
        }
        this.f6691d = new C31481(this, childAt);
        post(this.f6691d);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f6691d != null) {
            post(this.f6691d);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f6691d != null) {
            removeCallbacks(this.f6691d);
        }
    }

    public void onPageScrollStateChanged(int i) {
        if (this.f6690c != null) {
            this.f6690c.onPageScrollStateChanged(i);
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.f6690c != null) {
            this.f6690c.onPageScrolled(i, f, i2);
        }
    }

    public void onPageSelected(int i) {
        setCurrentItem(i);
        if (this.f6690c != null) {
            this.f6690c.onPageSelected(i);
        }
    }

    public void setViewPager(ViewPager viewPager) {
        if (this.f6689b != viewPager) {
            if (this.f6689b != null) {
                this.f6689b.setOnPageChangeListener(null);
            }
            if (viewPager.getAdapter() == null) {
                throw new IllegalStateException("ViewPager does not have adapter instance.");
            }
            this.f6689b = viewPager;
            viewPager.setOnPageChangeListener(this);
            m9497a();
        }
    }

    public void m9497a() {
        this.f6688a.removeAllViews();
        C3161a c3161a = (C3161a) this.f6689b.getAdapter();
        int a = c3161a.m9528a();
        for (int i = 0; i < a; i++) {
            View imageView = new ImageView(getContext(), null, C3163a.vpiIconPageIndicatorStyle);
            imageView.setImageResource(c3161a.m9529a(i));
            this.f6688a.addView(imageView);
        }
        if (this.f6692e > a) {
            this.f6692e = a - 1;
        }
        setCurrentItem(this.f6692e);
        requestLayout();
    }

    public void setCurrentItem(int i) {
        if (this.f6689b == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        this.f6692e = i;
        this.f6689b.setCurrentItem(i);
        int childCount = this.f6688a.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            boolean z;
            View childAt = this.f6688a.getChildAt(i2);
            if (i2 == i) {
                z = true;
            } else {
                z = false;
            }
            childAt.setSelected(z);
            if (z) {
                m9496a(i);
            }
        }
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.f6690c = onPageChangeListener;
    }
}
