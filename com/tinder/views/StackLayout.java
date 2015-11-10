package com.tinder.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.RelativeLayout;
import com.tinder.C2241a.C2233a;
import com.tinder.p030d.bv;
import com.tinder.utils.C3077n;
import com.tinder.utils.al;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class StackLayout extends RelativeLayout {
    private static final int MAX_CHILD_ATTRIBUTES = 3;
    private static final int SCALE_SET_DELAY = 155;
    private static final float SHADOW_BASE = 1.5f;
    private static final float SHADOW_LOWEST_VIEW = 0.5f;
    private final ChildAttribute[] mChildAttributes;
    private boolean mIsLegacyDevice;
    private boolean mIsUsingMockView;
    private OvershootInterpolator mResetInterpolator;
    private float mScaleDiff;
    private int mViewOffsetInPixels;

    /* renamed from: com.tinder.views.StackLayout.1 */
    class C31431 implements Runnable {
        final /* synthetic */ int val$childCount;
        final /* synthetic */ int val$finalIndex;
        final /* synthetic */ DecelerateInterpolator val$interpolator;
        final /* synthetic */ int val$reverseIndex;
        final /* synthetic */ int val$screenH;
        final /* synthetic */ bv val$simpleAnimListener;
        final /* synthetic */ View val$v;

        C31431(View view, int i, int i2, DecelerateInterpolator decelerateInterpolator, int i3, int i4, bv bvVar) {
            this.val$v = view;
            this.val$screenH = i;
            this.val$reverseIndex = i2;
            this.val$interpolator = decelerateInterpolator;
            this.val$finalIndex = i3;
            this.val$childCount = i4;
            this.val$simpleAnimListener = bvVar;
        }

        public void run() {
            this.val$v.animate().translationY((float) (-this.val$screenH)).setStartDelay((long) (this.val$reverseIndex * 35)).setDuration(400).setInterpolator(this.val$interpolator).setListener(this.val$finalIndex == this.val$childCount + -1 ? this.val$simpleAnimListener : null).start();
        }
    }

    /* renamed from: com.tinder.views.StackLayout.2 */
    class C31442 implements Runnable {
        final /* synthetic */ DecelerateInterpolator val$decelerator;
        final /* synthetic */ int val$finalI;
        final /* synthetic */ float val$newYPosition;
        final /* synthetic */ View val$v;

        C31442(View view, float f, int i, DecelerateInterpolator decelerateInterpolator) {
            this.val$v = view;
            this.val$newYPosition = f;
            this.val$finalI = i;
            this.val$decelerator = decelerateInterpolator;
        }

        public void run() {
            this.val$v.animate().translationY(this.val$newYPosition).setStartDelay((long) (this.val$finalI * 56)).setDuration(325).setInterpolator(this.val$decelerator).start();
        }
    }

    private static class ChildAttribute {
        float endingAlpha;
        float endingShadow;
        float maxScale;
        float minOffsetY;
        float startingAlpha;
        float startingOffsetY;
        float startingScale;
        float startingShadow;

        private ChildAttribute() {
        }

        @NonNull
        public String toString() {
            return "{startingOffsetY " + this.startingOffsetY + " minOffsetY " + this.minOffsetY + " startingScale " + this.startingScale + " maxScale " + this.maxScale + "}";
        }
    }

    public StackLayout(@NonNull Context context) {
        super(context);
        this.mChildAttributes = new ChildAttribute[MAX_CHILD_ATTRIBUTES];
        this.mViewOffsetInPixels = -1;
        init();
    }

    public StackLayout(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mChildAttributes = new ChildAttribute[MAX_CHILD_ATTRIBUTES];
        this.mViewOffsetInPixels = -1;
        parseAttributes(context, attributeSet);
        init();
    }

    private void init() {
        this.mIsLegacyDevice = al.m9276a();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    private void parseAttributes(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2233a.com_tinder_views_StackLayout, 0, 0);
        float dimension = obtainStyledAttributes.getDimension(1, 1.0f);
        float dimension2 = obtainStyledAttributes.getDimension(0, 1.0f);
        obtainStyledAttributes.recycle();
        setViewOffsetDp(dimension, dimension2);
        this.mResetInterpolator = new OvershootInterpolator();
    }

    public void setViewOffsetDp(float f, float f2) {
        if (getContext().getResources().getDisplayMetrics().densityDpi == 213 || f2 > 500.0f) {
            this.mViewOffsetInPixels = Math.round(al.m9284b(SHADOW_BASE * f, getContext()));
        } else {
            this.mViewOffsetInPixels = Math.round(al.m9284b(f, getContext()));
        }
    }

    public void setUseMockView(boolean z) {
        this.mIsUsingMockView = z;
    }

    public void removeMockView() {
        if (this.mIsUsingMockView) {
            removeViewAt(0);
            this.mIsUsingMockView = false;
        }
    }

    public void addView(@NonNull View view) {
        if (this.mViewOffsetInPixels < 0) {
            throw new IllegalStateException("You must set the number of pixels to offset the views by, before adding any views.");
        }
        if (this.mScaleDiff <= 0.0f) {
            float f;
            if (view.getLayoutParams() != null) {
                f = (float) view.getLayoutParams().height;
            } else {
                f = (float) view.getHeight();
            }
            this.mScaleDiff = (((float) this.mViewOffsetInPixels) / f) * 100.0f;
        }
        if (this.mIsLegacyDevice) {
            super.addView(view);
        } else {
            super.addView(view);
            offsetChild(view);
        }
        resetChildrenAttributes();
    }

    public void addView(@NonNull View view, int i) {
        super.addView(view, i);
        offsetChild(view);
    }

    public void resetChildrenAttributes() {
        for (int i = 0; i < getChildCount(); i++) {
            if (i < MAX_CHILD_ATTRIBUTES) {
                this.mChildAttributes[i] = null;
            }
            offsetChild(getChildAt(i));
        }
    }

    private void offsetChild(View view) {
        int indexOfChild = indexOfChild(view);
        if (indexOfChild != -1 && indexOfChild < this.mChildAttributes.length) {
            int i;
            if (!this.mIsUsingMockView || indexOfChild == 0) {
                i = indexOfChild;
            } else {
                i = indexOfChild - 1;
            }
            if (this.mChildAttributes[i] == null) {
                indexOfChild = calculateYOffset(view);
                float calculateStartingScale = calculateStartingScale(view);
                float min = Math.min((this.mScaleDiff / 100.0f) + calculateStartingScale, 1.0f);
                ChildAttribute childAttribute = new ChildAttribute();
                childAttribute.startingOffsetY = (float) indexOfChild;
                childAttribute.minOffsetY = (float) (indexOfChild - this.mViewOffsetInPixels);
                childAttribute.startingScale = calculateStartingScale;
                childAttribute.maxScale = min;
                childAttribute.startingShadow = calculateZ(i);
                childAttribute.endingShadow = calculateZ(i + 1);
                if (view instanceof CardBase) {
                    CardBase cardBase = (CardBase) view;
                    if (cardBase.isUsingDim()) {
                        childAttribute.startingAlpha = calculateStartingAlpha(cardBase);
                        childAttribute.endingAlpha = calculateEndingAlpha(cardBase);
                    }
                }
                this.mChildAttributes[i] = childAttribute;
            }
            view.setTranslationY(this.mChildAttributes[i].startingOffsetY);
            al.m9296c(view, this.mChildAttributes[i].startingScale);
            if (C3077n.m9412e()) {
                view.setTranslationZ(this.mChildAttributes[i].startingShadow);
            }
            if (view instanceof CardBase) {
                CardBase cardBase2 = (CardBase) view;
                if (cardBase2.isUsingDim()) {
                    cardBase2.setDimAlpha(this.mChildAttributes[i].startingAlpha);
                }
            }
        } else if (C3077n.m9412e() && indexOfChild == getChildCount() - 1) {
            view.setTranslationZ(calculateZ(indexOfChild));
        }
    }

    public void resetPositions(boolean z) {
        for (int i = 0; i < getChildCount() - 1; i++) {
            int i2;
            View childAt;
            ChildAttribute childAttribute;
            float f;
            float f2;
            ObjectAnimator ofFloat;
            ObjectAnimator ofFloat2;
            ObjectAnimator ofFloat3;
            AnimatorSet animatorSet;
            ObjectAnimator ofFloat4;
            Animator[] animatorArr;
            if (!this.mIsUsingMockView) {
                i2 = i;
                childAt = getChildAt(i);
                childAttribute = this.mChildAttributes[i2];
                f = childAttribute.startingOffsetY;
                f2 = childAttribute.startingScale;
                if (z) {
                    ofFloat = ObjectAnimator.ofFloat(childAt, "scaleX", new float[]{childAt.getScaleX(), f2});
                    ofFloat2 = ObjectAnimator.ofFloat(childAt, "scaleY", new float[]{childAt.getScaleY(), f2});
                    ofFloat3 = ObjectAnimator.ofFloat(childAt, "translationY", new float[]{childAt.getTranslationY(), f});
                    animatorSet = new AnimatorSet();
                    if (C3077n.m9412e()) {
                        ofFloat4 = ObjectAnimator.ofFloat(childAt, "translationZ", new float[]{this.mChildAttributes[i2].startingShadow});
                        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3, ofFloat4});
                    } else {
                        animatorArr = new Animator[MAX_CHILD_ATTRIBUTES];
                        animatorArr[0] = ofFloat;
                        animatorArr[1] = ofFloat2;
                        animatorArr[2] = ofFloat3;
                        animatorSet.playTogether(animatorArr);
                    }
                    animatorSet.setDuration(200);
                    animatorSet.setStartDelay(90);
                    animatorSet.setInterpolator(this.mResetInterpolator);
                    animatorSet.start();
                    ((CardBase) childAt).getDimView().animate().alpha(childAttribute.startingAlpha).setStartDelay(90).setDuration(200).start();
                } else {
                    childAt.setTranslationY(f);
                    al.m9296c(childAt, f2);
                }
            } else if (i != 0) {
                i2 = i - 1;
                childAt = getChildAt(i);
                childAttribute = this.mChildAttributes[i2];
                f = childAttribute.startingOffsetY;
                f2 = childAttribute.startingScale;
                if (z) {
                    ofFloat = ObjectAnimator.ofFloat(childAt, "scaleX", new float[]{childAt.getScaleX(), f2});
                    ofFloat2 = ObjectAnimator.ofFloat(childAt, "scaleY", new float[]{childAt.getScaleY(), f2});
                    ofFloat3 = ObjectAnimator.ofFloat(childAt, "translationY", new float[]{childAt.getTranslationY(), f});
                    animatorSet = new AnimatorSet();
                    if (C3077n.m9412e()) {
                        ofFloat4 = ObjectAnimator.ofFloat(childAt, "translationZ", new float[]{this.mChildAttributes[i2].startingShadow});
                        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3, ofFloat4});
                    } else {
                        animatorArr = new Animator[MAX_CHILD_ATTRIBUTES];
                        animatorArr[0] = ofFloat;
                        animatorArr[1] = ofFloat2;
                        animatorArr[2] = ofFloat3;
                        animatorSet.playTogether(animatorArr);
                    }
                    animatorSet.setDuration(200);
                    animatorSet.setStartDelay(90);
                    animatorSet.setInterpolator(this.mResetInterpolator);
                    animatorSet.start();
                    if ((childAt instanceof CardBase) && ((CardBase) childAt).isUsingDim()) {
                        ((CardBase) childAt).getDimView().animate().alpha(childAttribute.startingAlpha).setStartDelay(90).setDuration(200).start();
                    }
                } else {
                    childAt.setTranslationY(f);
                    al.m9296c(childAt, f2);
                }
            }
        }
    }

    public void applyReverseShifting(float f) {
        if (!this.mIsLegacyDevice) {
            for (int i = 0; i < getChildCount() - 1; i++) {
                int i2;
                float a;
                float a2;
                if (!this.mIsUsingMockView) {
                    i2 = i;
                    a = C3077n.m9399a(f, 0.0f, this.mChildAttributes[i2].maxScale, 1.0f, this.mChildAttributes[i2].startingScale);
                    a2 = C3077n.m9399a(f, 0.0f, this.mChildAttributes[i2].minOffsetY, 1.0f, this.mChildAttributes[i2].startingOffsetY);
                    if (getChildAt(i).getTranslationY() != a2) {
                        getChildAt(i).setTranslationY(a2);
                    }
                    if (getChildAt(i).getScaleX() != a) {
                        al.m9296c(getChildAt(i), a);
                    }
                    if (getChildAt(i) instanceof CardBase) {
                        ((CardBase) getChildAt(i)).setDimAlpha(C3077n.m9399a(f, 0.0f, this.mChildAttributes[i2].endingAlpha, 1.0f, this.mChildAttributes[i2].startingAlpha));
                    }
                    if (C3077n.m9412e()) {
                        getChildAt(i).setTranslationZ(C3077n.m9399a(f, 0.0f, this.mChildAttributes[i2].endingShadow, 1.0f, this.mChildAttributes[i2].startingShadow));
                    }
                } else if (i != 0) {
                    i2 = Math.max(i - 2, 0);
                    if (i2 < this.mChildAttributes.length && this.mChildAttributes[i2] != null) {
                        a = C3077n.m9399a(f, 0.0f, this.mChildAttributes[i2].maxScale, 1.0f, this.mChildAttributes[i2].startingScale);
                        a2 = C3077n.m9399a(f, 0.0f, this.mChildAttributes[i2].minOffsetY, 1.0f, this.mChildAttributes[i2].startingOffsetY);
                        if (getChildAt(i).getTranslationY() != a2) {
                            getChildAt(i).setTranslationY(a2);
                        }
                        if (getChildAt(i).getScaleX() != a) {
                            al.m9296c(getChildAt(i), a);
                        }
                        if (getChildAt(i) instanceof CardBase) {
                            ((CardBase) getChildAt(i)).setDimAlpha(C3077n.m9399a(f, 0.0f, this.mChildAttributes[i2].endingAlpha, 1.0f, this.mChildAttributes[i2].startingAlpha));
                        }
                        if (C3077n.m9412e()) {
                            getChildAt(i).setTranslationZ(C3077n.m9399a(f, 0.0f, this.mChildAttributes[i2].endingShadow, 1.0f, this.mChildAttributes[i2].startingShadow));
                        }
                    }
                }
            }
        }
    }

    public void applyShifting(float f, float f2, float f3, float f4, boolean z) {
        if (Math.abs(f3) > Math.abs(f4)) {
            applyShifting(f, z);
        } else {
            applyShifting(f2, z);
        }
    }

    public void applyShifting(float f, boolean z) {
        boolean z2 = false;
        if (!this.mIsLegacyDevice) {
            if (z) {
                if (!this.mIsLegacyDevice) {
                    z2 = true;
                }
                resetPositions(z2);
                return;
            }
            for (int i = 0; i < getChildCount() - 1; i++) {
                int i2;
                CardBase cardBase;
                if (!this.mIsUsingMockView) {
                    i2 = i;
                    cardBase = (CardBase) getChildAt(i);
                    if (cardBase != null) {
                        cardBase.setTranslationY(C3077n.m9399a(f, 0.0f, this.mChildAttributes[i2].startingOffsetY, 1.0f, this.mChildAttributes[i2].minOffsetY));
                        al.m9296c(cardBase, C3077n.m9399a(f, 0.0f, this.mChildAttributes[i2].startingScale, 1.0f, this.mChildAttributes[i2].maxScale));
                        if (C3077n.m9412e()) {
                            cardBase.setTranslationZ(C3077n.m9399a(f, 0.0f, this.mChildAttributes[i2].startingShadow, 1.0f, this.mChildAttributes[i2].endingShadow));
                        }
                        if (cardBase.isUsingDim()) {
                            cardBase.setDimAlpha(C3077n.m9399a(f, 0.0f, this.mChildAttributes[i2].startingAlpha, 1.0f, this.mChildAttributes[i2].endingAlpha));
                        }
                    }
                } else if (i != 0) {
                    i2 = i - 1;
                    cardBase = (CardBase) getChildAt(i);
                    if (cardBase != null) {
                        cardBase.setTranslationY(C3077n.m9399a(f, 0.0f, this.mChildAttributes[i2].startingOffsetY, 1.0f, this.mChildAttributes[i2].minOffsetY));
                        al.m9296c(cardBase, C3077n.m9399a(f, 0.0f, this.mChildAttributes[i2].startingScale, 1.0f, this.mChildAttributes[i2].maxScale));
                        if (C3077n.m9412e()) {
                            cardBase.setTranslationZ(C3077n.m9399a(f, 0.0f, this.mChildAttributes[i2].startingShadow, 1.0f, this.mChildAttributes[i2].endingShadow));
                        }
                        if (cardBase.isUsingDim()) {
                            cardBase.setDimAlpha(C3077n.m9399a(f, 0.0f, this.mChildAttributes[i2].startingAlpha, 1.0f, this.mChildAttributes[i2].endingAlpha));
                        }
                    }
                }
            }
        }
    }

    private float calculateStartingAlpha(@NonNull CardBase cardBase) {
        int indexOfChild = indexOfChild(cardBase);
        if (this.mIsUsingMockView && indexOfChild > 0) {
            indexOfChild--;
        }
        switch (Math.min(MAX_CHILD_ATTRIBUTES, getChildCount())) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                return cardBase.getDimNone();
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                if (indexOfChild == 0) {
                    return cardBase.getDimMedium();
                }
                if (indexOfChild == 1) {
                    return cardBase.getDimNone();
                }
                break;
            case MAX_CHILD_ATTRIBUTES /*3*/:
                break;
            case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                if (indexOfChild == 0) {
                    return cardBase.getDimFull();
                }
                if (indexOfChild == 1) {
                    return cardBase.getDimMedium();
                }
                return cardBase.getDimNone();
            default:
                return cardBase.getDimNone();
        }
        if (indexOfChild == 0) {
            return cardBase.getDimFull();
        }
        if (indexOfChild == 1) {
            return cardBase.getDimMedium();
        }
        return cardBase.getDimNone();
    }

    private float calculateEndingAlpha(@NonNull CardBase cardBase) {
        int indexOfChild = indexOfChild(cardBase);
        if (this.mIsUsingMockView && indexOfChild > 0) {
            indexOfChild--;
        }
        switch (Math.min(MAX_CHILD_ATTRIBUTES, getChildCount())) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                return cardBase.getDimNone();
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                if (indexOfChild == 0) {
                    return cardBase.getDimNone();
                }
                if (indexOfChild == 1) {
                    return cardBase.getDimNone();
                }
                break;
            case MAX_CHILD_ATTRIBUTES /*3*/:
                break;
            case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                if (indexOfChild == 0) {
                    return cardBase.getDimMedium();
                }
                if (indexOfChild == 1) {
                    return cardBase.getDimNone();
                }
                return cardBase.getDimNone();
            default:
                return cardBase.getDimNone();
        }
        if (indexOfChild == 0) {
            return cardBase.getDimMedium();
        }
        if (indexOfChild == 1) {
            return cardBase.getDimNone();
        }
        return cardBase.getDimNone();
    }

    private float calculateZ(int i) {
        if (i == 0 && getChildCount() == 4) {
            return 0.0f;
        }
        return (float) (((i * i) / 2) + 4);
    }

    private int calculateYOffset(View view) {
        int indexOfChild = indexOfChild(view);
        if (this.mIsUsingMockView && indexOfChild > 0) {
            indexOfChild--;
        }
        return ((Math.min(MAX_CHILD_ATTRIBUTES, getChildCount()) - indexOfChild) - 1) * this.mViewOffsetInPixels;
    }

    private float calculateStartingScale(View view) {
        int indexOfChild = indexOfChild(view);
        if (this.mIsUsingMockView && indexOfChild > 0) {
            indexOfChild--;
        }
        return 1.0f - ((((((float) Math.min(MAX_CHILD_ATTRIBUTES, getChildCount())) - ((float) indexOfChild)) - 1.0f) * this.mScaleDiff) / 100.0f);
    }

    public int getYOffset() {
        return this.mViewOffsetInPixels;
    }

    public void animateRewind() {
        if (!this.mIsLegacyDevice) {
            for (int i = 0; i < getChildCount(); i++) {
                int i2;
                View childAt;
                CardBase cardBase;
                if (!this.mIsUsingMockView) {
                    i2 = i;
                    childAt = getChildAt(i);
                    childAt.animate().translationY(this.mChildAttributes[i2].startingOffsetY).scaleX(this.mChildAttributes[i2].startingScale).scaleY(this.mChildAttributes[i2].startingScale).setDuration(270).start();
                    if (childAt instanceof CardBase) {
                        cardBase = (CardBase) childAt;
                        if (cardBase.isUsingDim()) {
                            cardBase.setDimAlpha(this.mChildAttributes[i2].startingAlpha);
                        }
                    }
                } else if (i != 0) {
                    i2 = Math.max(i - 2, 0);
                    childAt = getChildAt(i);
                    childAt.animate().translationY(this.mChildAttributes[i2].startingOffsetY).scaleX(this.mChildAttributes[i2].startingScale).scaleY(this.mChildAttributes[i2].startingScale).setDuration(270).start();
                    if (childAt instanceof CardBase) {
                        cardBase = (CardBase) childAt;
                        if (cardBase.isUsingDim()) {
                            cardBase.setDimAlpha(this.mChildAttributes[i2].startingAlpha);
                        }
                    }
                }
            }
        }
    }

    public void animateToNextItem(boolean z) {
        if (!this.mIsLegacyDevice) {
            for (int i = 0; i < getChildCount() - 1; i++) {
                int i2;
                int i3;
                View childAt;
                ViewPropertyAnimator animate;
                CardBase cardBase;
                if (!this.mIsUsingMockView) {
                    i2 = i;
                    if (z) {
                    }
                    childAt = getChildAt(i);
                    animate = childAt.animate();
                    animate.translationY(this.mChildAttributes[i2].minOffsetY).scaleX(this.mChildAttributes[i2].maxScale).scaleY(this.mChildAttributes[i2].maxScale).setStartDelay((long) i3);
                    if (C3077n.m9412e()) {
                        animate.translationZ(this.mChildAttributes[i2].endingShadow);
                    }
                    animate.start();
                    if (childAt instanceof CardBase) {
                        cardBase = (CardBase) childAt;
                        if (cardBase.isUsingDim()) {
                            cardBase.setDimAlpha(this.mChildAttributes[i2].endingAlpha);
                        }
                    }
                } else if (i != 0) {
                    i2 = i - 1;
                    i3 = z ? SCALE_SET_DELAY : 0;
                    childAt = getChildAt(i);
                    animate = childAt.animate();
                    animate.translationY(this.mChildAttributes[i2].minOffsetY).scaleX(this.mChildAttributes[i2].maxScale).scaleY(this.mChildAttributes[i2].maxScale).setStartDelay((long) i3);
                    if (C3077n.m9412e()) {
                        animate.translationZ(this.mChildAttributes[i2].endingShadow);
                    }
                    animate.start();
                    if (childAt instanceof CardBase) {
                        cardBase = (CardBase) childAt;
                        if (cardBase.isUsingDim()) {
                            cardBase.setDimAlpha(this.mChildAttributes[i2].endingAlpha);
                        }
                    }
                }
            }
        }
    }

    public void goToNextItem() {
        if (!this.mIsLegacyDevice) {
            for (int i = 0; i < getChildCount() - 1; i++) {
                int i2;
                View childAt;
                CardBase cardBase;
                if (!this.mIsUsingMockView) {
                    i2 = i;
                    childAt = getChildAt(i);
                    al.m9296c(childAt, this.mChildAttributes[i2].maxScale);
                    childAt.setTranslationY(this.mChildAttributes[i2].minOffsetY);
                    if (C3077n.m9412e()) {
                        childAt.setTranslationZ(this.mChildAttributes[i2].endingShadow);
                    }
                    if (childAt instanceof CardBase) {
                        cardBase = (CardBase) childAt;
                        if (cardBase.isUsingDim()) {
                            cardBase.setDimAlpha(this.mChildAttributes[i2].startingAlpha);
                        }
                    }
                } else if (i != 0) {
                    i2 = i - 1;
                    childAt = getChildAt(i);
                    al.m9296c(childAt, this.mChildAttributes[i2].maxScale);
                    childAt.setTranslationY(this.mChildAttributes[i2].minOffsetY);
                    if (C3077n.m9412e()) {
                        childAt.setTranslationZ(this.mChildAttributes[i2].endingShadow);
                    }
                    if (childAt instanceof CardBase) {
                        cardBase = (CardBase) childAt;
                        if (cardBase.isUsingDim()) {
                            cardBase.setDimAlpha(this.mChildAttributes[i2].startingAlpha);
                        }
                    }
                }
            }
        }
    }

    public void animateRecsOut(bv bvVar) {
        int b = al.m9285b(getContext());
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            postDelayed(new C31431(getChildAt(i), b, (getChildCount() - i) + 1, decelerateInterpolator, i, childCount, bvVar), 50);
        }
    }

    public void animateRecsIn() {
        int b = al.m9285b(getContext());
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        int i = 0;
        while (i < getChildCount()) {
            int i2;
            float f;
            View childAt = getChildAt(i);
            if (!this.mIsUsingMockView || i == 0) {
                i2 = i;
            } else {
                i2 = i - 1;
            }
            if (i < getChildCount() - 1) {
                f = this.mChildAttributes[i2].startingOffsetY;
            } else {
                f = 0.0f;
            }
            childAt.setTranslationY((float) (-b));
            postDelayed(new C31442(childAt, f, i, decelerateInterpolator), 300);
            i++;
        }
    }

    public int reorder(@NonNull View view, boolean z) {
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
        view.setRotation(0.0f);
        int indexOfChild = indexOfChild(view);
        for (int i = 0; i < indexOfChild; i++) {
            bringChildToFront(getChildAt(0));
        }
        if (z) {
            removeView(view);
        } else {
            offsetChild(view);
        }
        resetChildrenAttributes();
        if (al.m9276a()) {
            invalidate();
        }
        return getChildCount() - 1;
    }
}
