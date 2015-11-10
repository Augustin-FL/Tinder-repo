package com.tinder.views;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.PageTransformer;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringSystem;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.tinder.R;
import com.tinder.utils.C3077n;
import com.tinder.utils.al;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class PeekStack extends FrameLayout implements PageTransformer, OnLayoutChangeListener {
    private static final float CHILD_OFFSET_SCALE = 0.03f;
    private static final float CHILD_OFFSET_Y = 40.0f;
    private static final float FULL_SIZE_SCALE = 1.15f;
    public static final float HEIGHT_PERCENT_OF_SCREEN = 0.7f;
    private static final int PAGE_LIMIT = 3;
    private boolean mIsInLayout;
    private float mPageDistance;
    private PagerAdapter mPagerAdapter;
    private int mPagerHeight;
    private int mSelectedPage;
    private SpringSystem mSpringSystem;
    private TextView mTitleTextView;
    @NonNull
    private TouchMode mTouchMode;
    private ViewPager mViewPager;

    /* renamed from: com.tinder.views.PeekStack.1 */
    class C31271 implements Runnable {
        final /* synthetic */ int val$childCount;
        final /* synthetic */ float val$collapsedPagerY;
        final /* synthetic */ float val$startingPagerY;

        /* renamed from: com.tinder.views.PeekStack.1.1 */
        class C31261 extends SimpleSpringListener {
            C31261() {
            }

            public void onSpringUpdate(@NonNull Spring spring) {
                for (int i = 0; i < C31271.this.val$childCount; i++) {
                    View childAt = PeekStack.this.mViewPager.getChildAt(i);
                    float currentValue = (float) spring.getCurrentValue();
                    childAt.setTranslationY(C3077n.m9399a(currentValue, 0.0f, PeekStack.this.getPeekingChildY(i), 1.0f, PeekStack.this.getCollapsedChildY(i)));
                    al.m9296c(childAt, C3077n.m9399a(currentValue, 0.0f, childAt.getScaleY(), 1.0f, PeekStack.this.getCollapsedChildScale(i)));
                    PeekStack.this.mViewPager.setTranslationY(C3077n.m9399a(currentValue, 0.0f, C31271.this.val$startingPagerY, 1.0f, C31271.this.val$collapsedPagerY));
                }
            }

            public void onSpringAtRest(Spring spring) {
                PeekStack.this.mTouchMode = TouchMode.COLLAPSED;
            }
        }

        C31271(int i, float f, float f2) {
            this.val$childCount = i;
            this.val$startingPagerY = f;
            this.val$collapsedPagerY = f2;
        }

        public void run() {
            Spring createSpring = PeekStack.this.mSpringSystem.createSpring();
            createSpring.addListener(new C31261());
            createSpring.setCurrentValue(0.0d);
            createSpring.setEndValue(1.0d);
        }
    }

    /* renamed from: com.tinder.views.PeekStack.2 */
    class C31282 implements AnimatorUpdateListener {
        final /* synthetic */ float val$newPagerY;

        C31282(float f) {
            this.val$newPagerY = f;
        }

        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            PeekStack.this.getBackground().setAlpha((int) C3077n.m9399a(animatedFraction, 0.0f, 1.0f, 1.0f, 0.0f));
            PeekStack.this.mTitleTextView.setAlpha(C3077n.m9399a(animatedFraction, 0.0f, PeekStack.this.mTitleTextView.getAlpha(), 1.0f, 0.0f));
            PeekStack.this.mViewPager.setTranslationY(C3077n.m9399a(animatedFraction, 0.0f, 0.0f, 1.0f, this.val$newPagerY));
        }
    }

    /* renamed from: com.tinder.views.PeekStack.3 */
    class C31293 extends SimpleSpringListener {
        final /* synthetic */ int val$CHILD_COUNT;
        final /* synthetic */ float val$unifiedX;

        C31293(int i, float f) {
            this.val$CHILD_COUNT = i;
            this.val$unifiedX = f;
        }

        public void onSpringUpdate(@NonNull Spring spring) {
            for (int i = 0; i < this.val$CHILD_COUNT; i++) {
                View childAt = PeekStack.this.mViewPager.getChildAt(i);
                float currentValue = (float) spring.getCurrentValue();
                if (childAt.getTag() == null) {
                    childAt.setTag(new Float(childAt.getTranslationY()));
                }
                al.m9296c(childAt, C3077n.m9399a(currentValue, 0.0f, childAt.getScaleX(), 1.0f, PeekStack.this.getCollapsedChildScale(i)));
                childAt.setTranslationY(C3077n.m9399a(currentValue, 0.0f, ((Float) childAt.getTag()).floatValue(), 1.0f, PeekStack.this.getCollapsedChildY(i)));
                if (i != PeekStack.this.mSelectedPage) {
                    childAt.setX(C3077n.m9399a(currentValue, 0.0f, childAt.getX(), 1.0f, this.val$unifiedX));
                }
            }
        }

        public void onSpringActivate(Spring spring) {
            PeekStack.this.mTouchMode = TouchMode.ANIMATING;
        }

        public void onSpringAtRest(Spring spring) {
            PeekStack.this.mTouchMode = TouchMode.COLLAPSED;
        }
    }

    /* renamed from: com.tinder.views.PeekStack.4 */
    class C31304 implements AnimatorUpdateListener {
        C31304() {
        }

        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            PeekStack.this.mTitleTextView.setAlpha(valueAnimator.getAnimatedFraction());
            PeekStack.this.getBackground().setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* renamed from: com.tinder.views.PeekStack.5 */
    class C31315 extends SimpleSpringListener {
        final /* synthetic */ float val$pagerY;

        C31315(float f) {
            this.val$pagerY = f;
        }

        public void onSpringUpdate(@NonNull Spring spring) {
            float currentValue = (float) spring.getCurrentValue();
            PeekStack.this.mViewPager.setTranslationY(C3077n.m9399a(currentValue, 0.0f, this.val$pagerY, 1.0f, 0.0f));
            for (int i = 0; i < PeekStack.this.mViewPager.getChildCount(); i++) {
                View childAt = PeekStack.this.mViewPager.getChildAt(i);
                al.m9296c(childAt, C3077n.m9399a(currentValue, 0.0f, childAt.getScaleX(), 1.0f, 1.0f));
                childAt.setTranslationY(C3077n.m9399a(currentValue, 0.0f, childAt.getTranslationY(), 1.0f, 0.0f));
                if (i != PeekStack.this.mSelectedPage) {
                    childAt.setX(C3077n.m9399a(currentValue, 0.0f, ((float) PeekStack.this.mSelectedPage) * PeekStack.this.mPageDistance, 1.0f, ((float) i) * PeekStack.this.mPageDistance));
                }
            }
        }

        public void onSpringAtRest(Spring spring) {
            PeekStack.this.mTouchMode = TouchMode.EXPANDED;
        }

        public void onSpringActivate(Spring spring) {
            PeekStack.this.mViewPager.setCurrentItem(PeekStack.this.mSelectedPage, false);
            PeekStack.this.mTouchMode = TouchMode.ANIMATING;
        }
    }

    enum TouchMode {
        COLLAPSED,
        EXPANDED,
        DRAGGING,
        ANIMATING
    }

    public PeekStack(Context context) {
        super(context);
        this.mTouchMode = TouchMode.ANIMATING;
        this.mPageDistance = GroundOverlayOptions.NO_DIMENSION;
        this.mIsInLayout = true;
        init();
    }

    public PeekStack(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTouchMode = TouchMode.ANIMATING;
        this.mPageDistance = GroundOverlayOptions.NO_DIMENSION;
        this.mIsInLayout = true;
        init();
    }

    public PeekStack(@NonNull Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTouchMode = TouchMode.ANIMATING;
        this.mPageDistance = GroundOverlayOptions.NO_DIMENSION;
        this.mIsInLayout = true;
        init();
    }

    public boolean dispatchTouchEvent(@NonNull MotionEvent motionEvent) {
        if (al.m9291b(motionEvent)) {
            return false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private void init() {
        this.mPagerHeight = (int) al.m9283b((float) HEIGHT_PERCENT_OF_SCREEN);
        inflate(getContext(), R.layout.view_peek_stack, this);
        setBackgroundResource(R.color.peekstack_bg);
        getBackground().setAlpha(0);
        this.mTitleTextView = (TextView) findViewById(R.id.peek_stack_title_txt);
        this.mViewPager = (ViewPager) findViewById(R.id.peek_stack_viewpager);
        this.mViewPager.setOffscreenPageLimit(PAGE_LIMIT);
        this.mViewPager.setPageMargin(getResources().getDimensionPixelSize(R.dimen.suggested_locations_page_margin));
        this.mViewPager.setPageTransformer(true, this);
        this.mViewPager.addOnLayoutChangeListener(this);
        LayoutParams layoutParams = (LayoutParams) this.mViewPager.getLayoutParams();
        layoutParams.height = this.mPagerHeight;
        this.mViewPager.setLayoutParams(layoutParams);
        this.mSpringSystem = SpringSystem.create();
    }

    public void setPagerAdapter(PagerAdapter pagerAdapter) {
        this.mPagerAdapter = pagerAdapter;
        this.mViewPager.setAdapter(pagerAdapter);
    }

    private void calculatePageDistance() {
        if (this.mViewPager.getChildCount() > 1 && this.mPageDistance == GroundOverlayOptions.NO_DIMENSION) {
            this.mPageDistance = this.mViewPager.getChildAt(1).getX();
        }
    }

    public void toggleViewMode() {
        if (this.mTouchMode == TouchMode.EXPANDED) {
            collapse(true);
        } else if (this.mTouchMode == TouchMode.COLLAPSED) {
            expand();
        }
    }

    public void peek() {
        int childCount = this.mViewPager.getChildCount();
        float peekingPagerY = getPeekingPagerY();
        float collapsedPagerY = getCollapsedPagerY();
        this.mTouchMode = TouchMode.ANIMATING;
        this.mViewPager.setTranslationY(peekingPagerY);
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mViewPager.getChildAt(i);
            childAt.setX(0.0f);
            childAt.setTranslationY(getPeekingChildY(i));
            al.m9296c(childAt, 1.155f);
        }
        postDelayed(new C31271(childCount, peekingPagerY, collapsedPagerY), 2000);
    }

    public void collapse(boolean z) {
        int childCount = this.mViewPager.getChildCount();
        float collapsedPagerY = getCollapsedPagerY();
        this.mSelectedPage = this.mViewPager.getCurrentItem();
        float f = this.mPageDistance * ((float) this.mSelectedPage);
        if (z) {
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
            valueAnimator.setDuration(210);
            valueAnimator.addUpdateListener(new C31282(collapsedPagerY));
            valueAnimator.start();
            Spring createSpring = this.mSpringSystem.createSpring();
            createSpring.setVelocity(1.0d);
            createSpring.setSpringConfig(SpringConfig.fromOrigamiTensionAndFriction(5.0d, 3.0d));
            createSpring.addListener(new C31293(childCount, f));
            createSpring.setCurrentValue(0.0d);
            createSpring.setEndValue(1.0d);
        } else {
            for (int i = 0; i < childCount; i++) {
                float collapsedChildScale = getCollapsedChildScale(i);
                float collapsedChildY = getCollapsedChildY(i);
                View childAt = this.mViewPager.getChildAt(i);
                al.m9296c(childAt, collapsedChildScale);
                childAt.setTranslationY(collapsedChildY);
                if (i != this.mSelectedPage) {
                    childAt.setX(f);
                }
            }
            this.mViewPager.setTranslationY(collapsedPagerY);
            this.mTitleTextView.setAlpha(0.0f);
            getBackground().setAlpha(0);
            this.mTouchMode = TouchMode.COLLAPSED;
        }
        setClickable(false);
    }

    public void expand() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(new int[]{0, RangeSeekBar.INVALID_POINTER_ID});
        valueAnimator.setDuration(210);
        valueAnimator.addUpdateListener(new C31304());
        valueAnimator.start();
        float translationY = this.mViewPager.getTranslationY();
        Spring createSpring = this.mSpringSystem.createSpring();
        createSpring.setVelocity(2.0d);
        createSpring.setSpringConfig(SpringConfig.fromOrigamiTensionAndFriction(6.0d, 5.0d));
        createSpring.addListener(new C31315(translationY));
        createSpring.setCurrentValue(0.0d);
        createSpring.setEndValue(1.0d);
        setClickable(true);
    }

    public boolean isExpanded() {
        return this.mTouchMode == TouchMode.EXPANDED;
    }

    private float getCollapsedChildY(int i) {
        return CHILD_OFFSET_Y * ((float) (this.mViewPager.getChildCount() - i));
    }

    private float getCollapsedChildScale(int i) {
        return i == 0 ? FULL_SIZE_SCALE : FULL_SIZE_SCALE - (((float) i) * CHILD_OFFSET_SCALE);
    }

    private float getCollapsedPagerY() {
        return (float) this.mViewPager.getHeight();
    }

    private float getPeekingPagerY() {
        return al.m9283b(0.3f) / 2.0f;
    }

    private float getPeekingChildY(int i) {
        float collapsedPagerY = getCollapsedPagerY();
        switch (i) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                return collapsedPagerY - 100.0f;
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                return collapsedPagerY - 200.0f;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                return collapsedPagerY - BitmapDescriptorFactory.HUE_MAGENTA;
            default:
                return collapsedPagerY - BitmapDescriptorFactory.HUE_MAGENTA;
        }
    }

    public void transformPage(View view, float f) {
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (this.mViewPager.getChildCount() > 0 && this.mIsInLayout) {
            this.mIsInLayout = false;
            calculatePageDistance();
            peek();
        }
    }
}
