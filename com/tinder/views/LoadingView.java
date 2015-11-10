package com.tinder.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tinder.R;
import com.tinder.enums.PhotoSizeUser;
import com.tinder.managers.ManagerApp;
import com.tinder.model.User;
import com.tinder.p030d.bu;
import com.tinder.picassowebp.picasso.Picasso;
import com.tinder.utils.al;
import java.util.ArrayList;
import java.util.List;

public class LoadingView extends FrameLayout {
    private static final float ALPHA_BEG = 0.095f;
    private static final float ALPHA_END = 0.0f;
    private static final long ANIM_DURATION = 4000;
    private static final long RING_STAGGER = 600;
    private static final float SCALE_BEG = 1.0f;
    private static final float SCALE_END = 5.0f;
    private List<AnimatorSet> mAnimatorSets;
    private FrameLayout mFrameLayoutAvatar;
    private View mInviteLayout;
    private AccelerateDecelerateInterpolator mPingInterpolator;
    private TextView mPromptText;
    private RelativeLayout mRelativeLayout;
    private ImageView mRing1;
    private ImageView mRing2;
    private RoundImageView mRoundImageAvatar;

    public LoadingView(Context context) {
        super(context);
        init(context);
    }

    public LoadingView(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public LoadingView(@NonNull Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        View inflate = inflate(context, R.layout.view_loading, this);
        setClipChildren(false);
        setClipToPadding(false);
        this.mPingInterpolator = new AccelerateDecelerateInterpolator();
        this.mRelativeLayout = (RelativeLayout) inflate.findViewById(R.id.loading_relative_avatar_and_pings);
        this.mFrameLayoutAvatar = (FrameLayout) inflate.findViewById(R.id.framelayout_avatar);
        this.mPromptText = (TextView) inflate.findViewById(R.id.txt_prompt);
        this.mRoundImageAvatar = (RoundImageView) inflate.findViewById(R.id.roundimg_thumb);
        this.mRing1 = (ImageView) inflate.findViewById(R.id.img_circle_one);
        this.mRing2 = (ImageView) inflate.findViewById(R.id.img_circle_two);
        this.mAnimatorSets = new ArrayList();
    }

    @NonNull
    public String getLoadingText() {
        return this.mPromptText.getText().toString();
    }

    public void setLoadingText(int i) {
        String resourceName = getResources().getResourceName(i);
        if (resourceName == null || !resourceName.startsWith("com.tinder")) {
            throw new IllegalArgumentException("A Tinder resource id must be provided");
        }
        this.mPromptText.setText(i);
    }

    public void refreshProfileAvatarImage() {
        User d = ManagerApp.m7922m().m8599d();
        if (this.mRoundImageAvatar != null && d.hasPhotos()) {
            Picasso.m8982a(getContext()).m8990a((String) d.getAvatarUrlsForSize(PhotoSizeUser.MED).get(0)).m9121a((int) R.dimen.loading_img_length, (int) R.dimen.loading_img_length).m9127b().m9126a(this.mRoundImageAvatar);
        }
    }

    public void startPingAnimation(ImageView imageView, long j) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setTarget(imageView);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleX", new float[]{SCALE_BEG, SCALE_END});
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setDuration(ANIM_DURATION);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleY", new float[]{SCALE_BEG, SCALE_END});
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(1);
        ofFloat2.setDuration(ANIM_DURATION);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView, "alpha", new float[]{ALPHA_BEG, ALPHA_END});
        ofFloat3.setRepeatCount(-1);
        ofFloat3.setRepeatMode(1);
        ofFloat3.setDuration(ANIM_DURATION);
        animatorSet.setInterpolator(this.mPingInterpolator);
        animatorSet.setStartDelay(j);
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
        animatorSet.start();
        this.mAnimatorSets.add(animatorSet);
    }

    public void startSinglePingAnimation(ImageView imageView) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setTarget(imageView);
        ObjectAnimator.ofFloat(imageView, "scaleX", new float[]{SCALE_BEG, SCALE_END}).setDuration(ANIM_DURATION);
        ObjectAnimator.ofFloat(imageView, "scaleY", new float[]{SCALE_BEG, SCALE_END}).setDuration(ANIM_DURATION);
        ObjectAnimator.ofFloat(imageView, "alpha", new float[]{ALPHA_BEG, ALPHA_END}).setDuration(ANIM_DURATION);
        animatorSet.setInterpolator(this.mPingInterpolator);
        animatorSet.playTogether(new Animator[]{r1, r2, r3});
        animatorSet.start();
    }

    public void startAllPingAnimations() {
        if (this.mAnimatorSets.isEmpty()) {
            this.mRing1.setVisibility(0);
            this.mRing2.setVisibility(0);
            startPingAnimation(this.mRing1, 0);
            startPingAnimation(this.mRing2, RING_STAGGER);
            return;
        }
        restartAllAnimations();
    }

    public void animateAvatarIn(bu buVar) {
        al.m9296c(this.mFrameLayoutAvatar, ALPHA_END);
        this.mRing1.setVisibility(4);
        this.mRing2.setVisibility(4);
        this.mFrameLayoutAvatar.animate().scaleX(SCALE_BEG).scaleY(SCALE_BEG).setStartDelay(0).setDuration(280).setInterpolator(new OvershootInterpolator()).setListener(buVar);
    }

    public void cancelAllAnimations() {
        for (AnimatorSet cancel : this.mAnimatorSets) {
            cancel.cancel();
        }
    }

    public void restartAllAnimations() {
        for (AnimatorSet animatorSet : this.mAnimatorSets) {
            if (!animatorSet.isStarted()) {
                animatorSet.start();
            }
        }
    }
}
