package com.tinder.views;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tinder.R;
import com.tinder.enums.RateType;
import com.tinder.managers.ManagerApp;
import com.tinder.p030d.C2425e;
import com.tinder.p030d.bt;
import com.tinder.utils.C3045a;
import com.tinder.utils.C3077n;
import com.tinder.utils.C3095y;
import com.tinder.utils.al;
import com.tinder.views.SwipeDetector.SwipeDetectorListener;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public abstract class CardBase extends FrameLayout implements AnimatorListener, SwipeDetectorListener {
    private static final float RESET_DISPLACE_THRESHOLD = 0.005f;
    private static final float RESET_FRICTION = 9.0f;
    private static final int RESET_TENSION = 60;
    private static final int SWIPE_ANIM_DURATION = 300;
    private static final float SWIPE_VELOCITY_ANIM_MIN = 1.3f;
    private static final float SWIPE_VELOCITY_DIRECTION_SLOP = 0.05f;
    private static final int THROW_AWAY_ANIM_TIME = 180;
    private static final int THROW_AWAY_DELAY = 200;
    private static final int TOUCHLESS_SWIPE_ANIM_TIME = 180;
    private static final int TOUCHLESS_SWIPE_DELAY_LIKE_PASS = 225;
    private static final int TOUCHLESS_SWIPE_DELAY_SUPERLIKE = 425;
    private static final int TOUCHLESS_SWIPE_ROTATION = 28;
    private static final int TOUCHLESS_SWIPE_SCALE_SUPERLIKE_DURATION = 200;
    private static final String VIEW_TAG_OVERLAY = "cardbase_overlay";
    private float mCardMidpointWidth;
    private float mClickThreshold;
    private ViewGroup mDimLayout;
    private float mDragOffsetX;
    private float mDragOffsetY;
    private boolean mInSuperLikeCoordinates;
    private boolean mIsAnimating;
    protected boolean mIsLiking;
    protected boolean mIsMoving;
    protected boolean mIsPassing;
    protected boolean mIsSuperLiking;
    protected boolean mIsSwipedFromClick;
    private LinearInterpolator mLinearInterp;
    private C2425e mListenerCard;
    private bt mMotionEventOnClickListener;
    private View mOverlay;
    private Spring mResetSpring;
    private float mRotationOnDrag;
    protected int mScreenHeight;
    protected int mScreenWidth;
    private int mStampAlpha;
    private GameStamp mStampLike;
    private ImageView mStampLikeCompat;
    private GameStamp mStampNope;
    private ImageView mStampNopeCompat;
    private ImageView mStampSuperLikeCompat;
    private float mStampVerticalPosition;
    private float mStampYTarget;
    private SwipeDetector mSwipeDetector;
    private float mSwipeEndX;
    private float mSwipeEndY;
    private float mSwipeUpBoundaryBegins;
    private float mSwipeUpBoundaryEnds;
    private float mTiltSlop;
    private float mUpSwipeLeftBounds;
    private float mUpSwipeRightBounds;
    private boolean mUpswipeEnabled;

    /* renamed from: com.tinder.views.CardBase.1 */
    class C31001 extends SimpleSpringListener {
        final /* synthetic */ GameStamp val$finalGameStamp;
        final /* synthetic */ ImageView val$finalStamp;
        final /* synthetic */ boolean val$isRewinding;
        final /* synthetic */ SimpleSpringListener val$optListener;
        final /* synthetic */ float val$startRotation;
        final /* synthetic */ float val$startX;
        final /* synthetic */ float val$startY;

        C31001(float f, float f2, float f3, boolean z, ImageView imageView, GameStamp gameStamp, SimpleSpringListener simpleSpringListener) {
            this.val$startY = f;
            this.val$startX = f2;
            this.val$startRotation = f3;
            this.val$isRewinding = z;
            this.val$finalStamp = imageView;
            this.val$finalGameStamp = gameStamp;
            this.val$optListener = simpleSpringListener;
        }

        public void onSpringUpdate(@NonNull Spring spring) {
            float currentValue = (float) spring.getCurrentValue();
            CardBase.this.setTranslationY(C3077n.m9399a(currentValue, 0.0f, this.val$startY, 1.0f, 0.0f));
            CardBase.this.setTranslationX(C3077n.m9399a(currentValue, 0.0f, this.val$startX, 1.0f, 0.0f));
            CardBase.this.setRotation(C3077n.m9399a(currentValue, 0.0f, this.val$startRotation, 1.0f, 0.0f));
            if (!this.val$isRewinding) {
                if (this.val$finalStamp != null) {
                    CardBase.this.setStampCompatAlpha(this.val$finalStamp, (float) ((int) C3077n.m9399a(currentValue, 0.0f, CardBase.this.getStampCompatAlpha(this.val$finalStamp), 1.0f, 0.0f)));
                } else if (this.val$finalGameStamp != null) {
                    this.val$finalGameStamp.setAlpha((int) C3077n.m9399a(currentValue, 0.0f, (float) this.val$finalGameStamp.getAlphaInt(), 1.0f, 0.0f));
                }
            }
            if (this.val$optListener != null) {
                this.val$optListener.onSpringUpdate(spring);
            }
        }

        public void onSpringAtRest(Spring spring) {
            if (this.val$optListener != null) {
                this.val$optListener.onSpringAtRest(spring);
            }
            if (!this.val$isRewinding) {
                CardBase.this.onAnimationEnd(null);
            }
        }

        public void onSpringActivate(Spring spring) {
            if (this.val$optListener != null) {
                this.val$optListener.onSpringActivate(spring);
            }
            if (!this.val$isRewinding) {
                CardBase.this.onAnimationStart(null);
            }
        }
    }

    /* renamed from: com.tinder.views.CardBase.2 */
    class C31012 implements Runnable {
        C31012() {
        }

        public void run() {
            CardBase.this.cleanUpCardState();
        }
    }

    /* renamed from: com.tinder.views.CardBase.3 */
    static /* synthetic */ class C31023 {
        static final /* synthetic */ int[] $SwitchMap$com$tinder$enums$RateType;

        static {
            $SwitchMap$com$tinder$enums$RateType = new int[RateType.values().length];
            try {
                $SwitchMap$com$tinder$enums$RateType[RateType.LIKE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$tinder$enums$RateType[RateType.PASS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$tinder$enums$RateType[RateType.SUPERLIKE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public abstract float getDimFull();

    public abstract float getDimMedium();

    public CardBase(@NonNull Context context) {
        super(context);
        this.mScreenHeight = al.m9285b(getContext());
        this.mScreenWidth = al.m9262a(getContext());
        this.mUpSwipeLeftBounds = (float) (this.mScreenWidth / 4);
        this.mUpSwipeRightBounds = ((float) this.mScreenWidth) - this.mUpSwipeLeftBounds;
        this.mStampYTarget = getResources().getDimension(R.dimen.actionbar_size) + ((float) al.m9294c(getContext()));
        init();
    }

    public CardBase(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mScreenHeight = al.m9285b(getContext());
        this.mScreenWidth = al.m9262a(getContext());
        this.mUpSwipeLeftBounds = (float) (this.mScreenWidth / 4);
        this.mUpSwipeRightBounds = ((float) this.mScreenWidth) - this.mUpSwipeLeftBounds;
        this.mStampYTarget = getResources().getDimension(R.dimen.actionbar_size) + ((float) al.m9294c(getContext()));
        init();
    }

    public CardBase(@NonNull Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mScreenHeight = al.m9285b(getContext());
        this.mScreenWidth = al.m9262a(getContext());
        this.mUpSwipeLeftBounds = (float) (this.mScreenWidth / 4);
        this.mUpSwipeRightBounds = ((float) this.mScreenWidth) - this.mUpSwipeLeftBounds;
        this.mStampYTarget = getResources().getDimension(R.dimen.actionbar_size) + ((float) al.m9294c(getContext()));
        init();
    }

    @TargetApi(21)
    public CardBase(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mScreenHeight = al.m9285b(getContext());
        this.mScreenWidth = al.m9262a(getContext());
        this.mUpSwipeLeftBounds = (float) (this.mScreenWidth / 4);
        this.mUpSwipeRightBounds = ((float) this.mScreenWidth) - this.mUpSwipeLeftBounds;
        this.mStampYTarget = getResources().getDimension(R.dimen.actionbar_size) + ((float) al.m9294c(getContext()));
        init();
    }

    protected static float calculateYIntercept(float f, float f2, float f3, float f4, float f5) {
        return ((f5 - f4) / (f3 - f2)) * f;
    }

    private void init() {
        this.mSwipeDetector = new SwipeDetector(this);
        this.mLinearInterp = new LinearInterpolator();
        setLayerType(2, null);
    }

    public float getDimNone() {
        return 0.0f;
    }

    public void enableDimming(ViewGroup viewGroup, Drawable drawable) {
        if (!al.m9276a()) {
            this.mDimLayout = viewGroup;
            this.mOverlay = new View(getContext());
            al.m9271a(this.mOverlay, drawable);
            this.mOverlay.setAlpha(0.0f);
            this.mOverlay.setTag(VIEW_TAG_OVERLAY);
            this.mDimLayout.addView(this.mOverlay);
        }
    }

    public void setDimAlpha(float f) {
        if (isUsingDim()) {
            this.mOverlay.setAlpha(f);
        }
    }

    public void disableDim() {
        if (isUsingDim()) {
            this.mDimLayout.removeView(this.mOverlay);
        }
    }

    public View getDimView() {
        return this.mOverlay;
    }

    public boolean isUsingDim() {
        return this.mOverlay != null;
    }

    public boolean isDraggingLeft() {
        return this.mSwipeDetector.getDeltaX() < 0.0f && !isDraggingUp();
    }

    public boolean isDraggingRight() {
        return this.mSwipeDetector.getDeltaX() > 0.0f && !isDraggingUp();
    }

    public boolean isDraggingUp() {
        return this.mSwipeDetector.getDeltaY() < 0.0f && this.mUpswipeEnabled && withinUpSwipeBounds();
    }

    public void setSwipeUpEnabled(boolean z) {
        this.mUpswipeEnabled = z;
        this.mSwipeDetector.setSwipeUpEnabled(this.mUpswipeEnabled);
    }

    public View getStampNope() {
        if (this.mStampNopeCompat != null) {
            return this.mStampNopeCompat;
        }
        return this.mStampNope;
    }

    protected void setStampNope(GameStamp gameStamp) {
        this.mStampNope = gameStamp;
        this.mStampNope.setVisibility(0);
        this.mStampNope.setAlpha(0);
    }

    public View getStampLike() {
        if (this.mStampLikeCompat != null) {
            return this.mStampLikeCompat;
        }
        return this.mStampLike;
    }

    protected void setStampLike(GameStamp gameStamp) {
        this.mStampLike = gameStamp;
        this.mStampLike.setVisibility(0);
        this.mStampLike.setAlpha(0);
    }

    public View getStampSuperLike() {
        return this.mStampSuperLikeCompat;
    }

    protected void setStampLikeCompat(ImageView imageView) {
        this.mStampLikeCompat = imageView;
    }

    protected void setStampNopeCompat(ImageView imageView) {
        this.mStampNopeCompat = imageView;
    }

    protected void setStampSuperLikeCompat(ImageView imageView) {
        this.mStampSuperLikeCompat = imageView;
    }

    public float getSwipeThreshold() {
        return this.mSwipeDetector.getSwipeThreshold();
    }

    public void setSwipeThreshold(float f) {
        this.mSwipeDetector.setSwipeThreshold(f);
    }

    public void setTopThreshhold(float f) {
        this.mSwipeDetector.setTopSwipeThreshold(f);
    }

    public void setClickThreshold(float f) {
        this.mClickThreshold = f;
        this.mSwipeDetector.setClickThreshold(f);
    }

    public void setMinimumSwipeVelocity(float f) {
        this.mSwipeDetector.setMinimumSwipeVelocity(f);
    }

    public void setMinimumSwipeUpVelocity(float f) {
        this.mSwipeDetector.setMinimumUpSwipeVelocity(f);
    }

    public void setTiltSlop(float f) {
        this.mTiltSlop = f;
    }

    public void setSwipeBoundaries(float f, float f2, float f3) {
        this.mSwipeUpBoundaryBegins = 90.0f - f2;
        this.mSwipeUpBoundaryEnds = 90.0f + f2;
        this.mSwipeDetector.setSwipeBoundaries(f, f2, f3);
    }

    public void setSwipeBoundaries(float f, float f2) {
        this.mSwipeUpBoundaryBegins = 90.0f - f2;
        this.mSwipeUpBoundaryEnds = 90.0f + f2;
        this.mSwipeDetector.setSwipeBoundaries(f, f2);
    }

    public void setSwipeEndX(float f) {
        this.mSwipeEndX = f;
    }

    public void setSwipeEndY(float f) {
        this.mSwipeEndY = f;
    }

    public void setRotationOnDrag(float f) {
        this.mRotationOnDrag = f;
    }

    public SwipeDetector getSwipeDetector() {
        return this.mSwipeDetector;
    }

    public void removeListener() {
        this.mListenerCard = null;
    }

    @Nullable
    protected C2425e getCardListener() {
        return this.mListenerCard;
    }

    public void setCardListener(C2425e c2425e) {
        this.mListenerCard = c2425e;
    }

    public boolean isMoving() {
        return this.mIsMoving;
    }

    public float getStartX() {
        return this.mSwipeDetector.getStartX();
    }

    public float getEndX() {
        return this.mSwipeDetector.getStartX();
    }

    public float getStartY() {
        return this.mSwipeDetector.getStartY();
    }

    public float getEndY() {
        return this.mSwipeDetector.getEndY();
    }

    public float getDeltaX() {
        return this.mSwipeDetector.getDeltaX();
    }

    public float getDeltaY() {
        return this.mSwipeDetector.getDeltaY();
    }

    public float getDragOffset() {
        return this.mDragOffsetX;
    }

    public float getVelocityX() {
        return this.mSwipeDetector.getVelocityX();
    }

    public float getVelocityY() {
        return this.mSwipeDetector.getVelocityY();
    }

    public boolean isUsingStamps() {
        return (this.mStampLike == null || this.mStampNope == null) ? false : true;
    }

    public boolean isUsingCompatStamps() {
        return (this.mStampLikeCompat == null || this.mStampNopeCompat == null || this.mStampSuperLikeCompat == null) ? false : true;
    }

    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (this.mListenerCard == null || this.mIsAnimating) {
            return false;
        }
        if (this.mIsMoving && motionEvent.getActionMasked() == 0) {
            return this.mSwipeDetector.onTouch(this, motionEvent);
        }
        requestDisallowInterceptTouchEvent(true);
        return this.mSwipeDetector.onTouch(this, motionEvent);
    }

    private void rotate(float f) {
        float f2 = (((float) (this.mSwipeDetector.getStartY() < this.mTiltSlop ? 1 : -1)) * f) * this.mRotationOnDrag;
        if (getRotation() != f2) {
            setRotation(f2);
        }
    }

    private void translate(float f, float f2) {
        setTranslationX(f);
        setTranslationY(f2);
    }

    public void resetStamps() {
        if (isUsingCompatStamps()) {
            setStampCompatAlpha(this.mStampNopeCompat, 0.0f);
            setStampCompatAlpha(this.mStampLikeCompat, 0.0f);
            setStampCompatAlpha(this.mStampSuperLikeCompat, 0.0f);
            this.mStampNopeCompat.setVisibility(4);
            this.mStampLikeCompat.setVisibility(4);
            this.mStampSuperLikeCompat.setVisibility(4);
        } else if (isUsingStamps()) {
            this.mStampNope.setAlpha(0);
            this.mStampLike.setAlpha(0);
            this.mStampNope.setVisibility(4);
            this.mStampLike.setVisibility(4);
        }
    }

    private void fadeStamps() {
        this.mStampAlpha = (int) C3077n.m9399a(this.mDragOffsetX, 0.0f, 0.0f, 1.0f, 255.0f);
        if (isDraggingLeft()) {
            this.mStampNope.setAlpha(this.mStampAlpha);
            this.mStampLike.setAlpha(0);
            return;
        }
        this.mStampLike.setAlpha(this.mStampAlpha);
        this.mStampNope.setAlpha(0);
    }

    private void fadeStampsCompat() {
        this.mStampAlpha = (int) C3077n.m9399a(this.mDragOffsetX, 0.0f, 0.0f, 1.0f, 255.0f);
        if (isDraggingLeft()) {
            C3095y.m9471a("dragging left");
            if (this.mStampSuperLikeCompat.getVisibility() == 0) {
                fadeSuperLikeStamp(false);
            }
            setStampCompatAlpha(this.mStampNopeCompat, (float) this.mStampAlpha);
            this.mStampNopeCompat.setVisibility(0);
            this.mStampLikeCompat.setVisibility(4);
            this.mStampSuperLikeCompat.setVisibility(4);
        } else if (isDraggingRight()) {
            C3095y.m9471a("dragging right");
            if (this.mStampSuperLikeCompat.getVisibility() == 0) {
                fadeSuperLikeStamp(false);
            }
            setStampCompatAlpha(this.mStampLikeCompat, (float) this.mStampAlpha);
            this.mStampLikeCompat.setVisibility(0);
            this.mStampNopeCompat.setVisibility(4);
            this.mStampSuperLikeCompat.setVisibility(4);
        } else if (isDraggingUp() && meetsRequirementsForSwipeUp() && this.mUpswipeEnabled) {
            C3095y.m9471a("dragging up");
            if (this.mStampSuperLikeCompat.getVisibility() != 0) {
                fadeSuperLikeStamp(true);
            }
            setStampCompatAlpha(this.mStampSuperLikeCompat, 255.0f);
            this.mStampSuperLikeCompat.setVisibility(0);
            this.mStampLikeCompat.setVisibility(4);
            this.mStampNopeCompat.setVisibility(4);
        } else {
            C3095y.m9471a("dragging dead zone");
            this.mStampSuperLikeCompat.setVisibility(4);
            this.mStampLikeCompat.setVisibility(4);
            this.mStampNopeCompat.setVisibility(4);
        }
    }

    private void fadeSuperLikeStamp(boolean z) {
        float f;
        float f2 = 1.0f;
        if (z) {
            f = 0.0f;
        } else {
            f = 1.0f;
        }
        if (!z) {
            f2 = 0.0f;
        }
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setDuration(200);
        this.mStampSuperLikeCompat.setAnimation(alphaAnimation);
        alphaAnimation.start();
    }

    @TargetApi(16)
    private float getStampCompatAlpha(@NonNull View view) {
        if (al.f6563a) {
            return (float) ((ImageView) view).getImageAlpha();
        }
        return view.getAlpha();
    }

    @TargetApi(16)
    private void setStampCompatAlpha(@NonNull View view, float f) {
        if (al.f6563a) {
            ((ImageView) view).setImageAlpha((int) f);
        } else {
            view.setAlpha(f);
        }
    }

    @TargetApi(19)
    public void animateSwipe() {
        float f;
        long round;
        float f2 = 0.0f;
        if (this.mIsSuperLiking && this.mUpswipeEnabled) {
            C3095y.m9471a("animateSwipe for Super Like");
            f = -this.mSwipeEndY;
            round = (long) Math.round(BitmapDescriptorFactory.HUE_MAGENTA / Math.max(Math.abs(getVelocityY()), SWIPE_VELOCITY_ANIM_MIN));
        } else {
            float calculateYIntercept;
            C3095y.m9471a("animateSwipe for Like/Pass");
            float f3 = this.mIsPassing ? -this.mSwipeEndX : this.mSwipeEndX;
            if (Math.abs(getVelocityX()) > SWIPE_VELOCITY_DIRECTION_SLOP) {
                calculateYIntercept = calculateYIntercept(f3, 0.0f, getDeltaX(), 0.0f, getDeltaY());
            } else {
                calculateYIntercept = getDeltaY();
            }
            f = calculateYIntercept;
            f2 = f3;
            round = (long) Math.round(BitmapDescriptorFactory.HUE_MAGENTA / Math.max(Math.abs(getVelocityX()), SWIPE_VELOCITY_ANIM_MIN));
        }
        this.mIsAnimating = true;
        ViewPropertyAnimator listener = animate().translationXBy(f2).translationYBy(f).setDuration(round).setStartDelay(0).setInterpolator(this.mLinearInterp).setListener(this);
        if (C3077n.m9409b()) {
            listener.setUpdateListener(null);
        }
        listener.start();
    }

    @TargetApi(19)
    public void animateTouchlessSwipe(RateType rateType, @Nullable AnimatorUpdateListener animatorUpdateListener) {
        float f;
        float f2 = 0.0f;
        float f3 = -28.0f;
        int i = TOUCHLESS_SWIPE_DELAY_LIKE_PASS;
        switch (C31023.$SwitchMap$com$tinder$enums$RateType[rateType.ordinal()]) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                this.mIsLiking = true;
                C3095y.m9471a("liking");
                break;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                this.mIsPassing = true;
                C3095y.m9471a("passing");
                break;
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                this.mIsSuperLiking = ManagerApp.m7914e().as();
                C3095y.m9471a("superliking");
                break;
        }
        this.mIsSwipedFromClick = true;
        if (isUsingStamps()) {
            if (this.mIsLiking) {
                this.mStampLike.setAlpha(RangeSeekBar.INVALID_POINTER_ID);
                this.mStampLike.setVisibility(0);
            } else if (this.mIsPassing) {
                this.mStampNope.setAlpha(RangeSeekBar.INVALID_POINTER_ID);
                this.mStampNope.setVisibility(0);
            }
        } else if (isUsingCompatStamps()) {
            if (this.mIsLiking) {
                setStampCompatAlpha(this.mStampLikeCompat, 255.0f);
                this.mStampLikeCompat.setVisibility(0);
            } else if (this.mIsPassing) {
                setStampCompatAlpha(this.mStampNopeCompat, 255.0f);
                this.mStampNopeCompat.setVisibility(0);
            } else if (this.mIsSuperLiking) {
                setStampCompatAlpha(this.mStampSuperLikeCompat, 255.0f);
                this.mStampSuperLikeCompat.setVisibility(0);
                al.m9296c(this.mStampSuperLikeCompat, 1.8f);
                this.mStampSuperLikeCompat.animate().scaleX(1.0f).scaleY(1.0f).setDuration(200).setInterpolator(new DecelerateInterpolator()).start();
                i = TOUCHLESS_SWIPE_DELAY_SUPERLIKE;
            }
        }
        this.mIsAnimating = true;
        if (this.mIsSuperLiking) {
            f = -this.mSwipeEndY;
        } else if (this.mIsLiking) {
            f2 = this.mSwipeEndX;
            f = 0.0f;
        } else if (this.mIsPassing) {
            f2 = -this.mSwipeEndX;
            f = 0.0f;
        } else {
            f = 0.0f;
        }
        if (C3077n.m9409b()) {
            ViewPropertyAnimator translationY = animate().translationXBy(f2).translationY(f);
            if (this.mIsLiking) {
                f = 28.0f;
            } else {
                f = -28.0f;
            }
            translationY.rotation(f).setDuration(180).setStartDelay((long) i).setInterpolator(this.mLinearInterp).setListener(this).setUpdateListener(animatorUpdateListener).start();
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, View.TRANSLATION_X, new float[]{f2});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, View.TRANSLATION_Y, new float[]{f});
        Property property = View.ROTATION;
        float[] fArr = new float[1];
        if (this.mIsAnimating) {
            f3 = 28.0f;
        }
        fArr[0] = f3;
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, property, fArr);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(180);
        animatorSet.setStartDelay((long) i);
        animatorSet.setInterpolator(this.mLinearInterp);
        animatorSet.addListener(this);
        ofFloat.addUpdateListener(animatorUpdateListener);
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
        animatorSet.start();
    }

    public void resetPosition() {
        resetPosition(false, null);
    }

    public void resetPosition(boolean z, @Nullable SimpleSpringListener simpleSpringListener) {
        ImageView imageView;
        GameStamp gameStamp = null;
        float translationX = getTranslationX();
        float translationY = getTranslationY();
        float rotation = getRotation();
        boolean isUsingStamps = isUsingStamps();
        if (isUsingCompatStamps()) {
            ImageView imageView2;
            if (translationX < 0.0f) {
                imageView2 = this.mStampNopeCompat;
            } else {
                imageView2 = this.mStampLikeCompat;
            }
            imageView = imageView2;
        } else if (isUsingStamps) {
            imageView = null;
            gameStamp = translationX < 0.0f ? this.mStampNope : this.mStampLike;
        } else {
            imageView = null;
        }
        this.mResetSpring = C3045a.m9201a();
        SpringConfig fromOrigamiTensionAndFriction = SpringConfig.fromOrigamiTensionAndFriction(60.0d, 9.0d);
        this.mResetSpring.setRestDisplacementThreshold(0.004999999888241291d);
        this.mResetSpring.setSpringConfig(fromOrigamiTensionAndFriction);
        this.mResetSpring.setOvershootClampingEnabled(true);
        this.mResetSpring.addListener(new C31001(translationY, translationX, rotation, z, imageView, gameStamp, simpleSpringListener));
        this.mResetSpring.setCurrentValue(0.0d);
        this.mResetSpring.setEndValue(1.0d);
    }

    private void cleanUpCardState() {
        if (this.mListenerCard != null) {
            if (this.mIsPassing) {
                C3095y.m9471a("swipe was pass in cleanUp");
                this.mListenerCard.m6651a(this.mIsSwipedFromClick);
            } else if (this.mIsLiking) {
                C3095y.m9471a("swipe was like in cleanUp");
                this.mListenerCard.m6652b(this.mIsSwipedFromClick);
            } else if (this.mIsSuperLiking) {
                C3095y.m9471a("swipe was super like in cleanUp");
                this.mListenerCard.m6653c(this.mIsSwipedFromClick);
            } else {
                C3095y.m9471a("swipe was neither like/pass or swipeup in cleanUp");
            }
        }
        if (isUsingStamps()) {
            this.mStampLike.setAlpha(0);
            this.mStampNope.setAlpha(0);
        } else if (isUsingCompatStamps()) {
            this.mStampNopeCompat.setVisibility(4);
            this.mStampLikeCompat.setVisibility(4);
            this.mStampSuperLikeCompat.setVisibility(4);
        }
        this.mStampAlpha = 0;
        this.mIsPassing = false;
        this.mIsLiking = false;
        this.mIsSuperLiking = false;
        this.mIsMoving = false;
        this.mIsSwipedFromClick = false;
    }

    public void setOnClickWithEventListener(bt btVar) {
        this.mMotionEventOnClickListener = btVar;
    }

    public void onClickWithEvent(MotionEvent motionEvent) {
        if (this.mMotionEventOnClickListener != null) {
            this.mMotionEventOnClickListener.onClick(motionEvent, this);
        }
    }

    public boolean meetsRequirementsForSwipeUp() {
        return true;
    }

    public void setStampLeftBounds() {
        this.mSwipeDetector.setLeftBounds(this.mUpSwipeLeftBounds);
    }

    public void setStampRightBounds() {
        this.mSwipeDetector.setRightBounds(this.mUpSwipeRightBounds);
    }

    public boolean withinUpSwipeBounds() {
        if (this.mStampNopeCompat != null) {
            this.mStampVerticalPosition = (float) (al.m9263a(this.mStampNopeCompat).y + this.mStampNopeCompat.getHeight());
        }
        boolean z = this.mStampVerticalPosition < this.mStampYTarget;
        C3095y.m9471a("meetsVerticalBounds: " + z + ", mStampVerticalPosition:" + this.mStampVerticalPosition + ", mStampYTarget:" + this.mStampYTarget);
        if (this.mCardMidpointWidth == 0.0f) {
            this.mCardMidpointWidth = (float) (getWidth() / 2);
        }
        float f = ((float) al.m9263a((View) this).x) + this.mCardMidpointWidth;
        C3095y.m9471a("marker:" + f + ", leftBounds:" + this.mUpSwipeLeftBounds + ",rightBounds:" + this.mUpSwipeRightBounds);
        boolean z2 = f > this.mUpSwipeLeftBounds && f < this.mUpSwipeRightBounds;
        if (z && z2 && this.mInSuperLikeCoordinates) {
            return true;
        }
        return false;
    }

    public void onTouchUp(MotionEvent motionEvent, float f, float f2, float f3, float f4, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.mIsSuperLiking = z3;
        this.mIsLiking = z4;
        this.mIsPassing = z5;
        C3095y.m9471a("onTouchUp: up:" + z3 + ", right:" + z4 + ", left:" + z5);
        if (z4 || z5 || (z3 && this.mUpswipeEnabled && meetsRequirementsForSwipeUp())) {
            animateSwipe();
        } else {
            resetPosition();
            this.mListenerCard.m6650a(0.0f, 0.0f, f, f2, z);
        }
        if (z2) {
            onClickWithEvent(motionEvent);
        }
    }

    public void onTouchMove(MotionEvent motionEvent, float f, float f2, float f3, float f4, float f5, float f6) {
        float toDegrees = (float) Math.toDegrees(Math.atan2((double) (-f4), (double) f3));
        if (toDegrees < 0.0f) {
            toDegrees += 360.0f;
        }
        boolean z = toDegrees >= this.mSwipeUpBoundaryBegins && toDegrees <= this.mSwipeUpBoundaryEnds;
        this.mInSuperLikeCoordinates = z;
        this.mDragOffsetX = f;
        this.mDragOffsetY = f2;
        translate(f3, f4);
        rotate(f3);
        if (isUsingCompatStamps()) {
            fadeStampsCompat();
        } else if (isUsingStamps()) {
            fadeStamps();
        }
        this.mListenerCard.m6650a(this.mDragOffsetX, this.mDragOffsetY, f3, f4, false);
    }

    public void onAnimationStart(Animator animator) {
        this.mIsMoving = true;
    }

    public void onAnimationEnd(Animator animator) {
        this.mIsAnimating = false;
        cleanUpCardState();
    }

    public void onAnimationCancel(Animator animator) {
        this.mIsMoving = false;
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void throwAwayCard() {
        this.mIsLiking = false;
        this.mIsPassing = true;
        this.mIsSwipedFromClick = true;
        postDelayed(new C31012(), 380);
    }
}
