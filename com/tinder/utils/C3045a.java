package com.tinder.utils;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.OvershootInterpolator;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringSystem;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.tinder.utils.a */
public class C3045a {
    @NonNull
    private static SpringSystem f6517a;

    /* renamed from: com.tinder.utils.a.1 */
    static class C30441 implements OnTouchListener {
        final /* synthetic */ View f6511a;
        final /* synthetic */ float f6512b;
        final /* synthetic */ float f6513c;
        final /* synthetic */ long f6514d;
        final /* synthetic */ AnimatorListener f6515e;
        final /* synthetic */ long f6516f;

        C30441(View view, float f, float f2, long j, AnimatorListener animatorListener, long j2) {
            this.f6511a = view;
            this.f6512b = f;
            this.f6513c = f2;
            this.f6514d = j;
            this.f6515e = animatorListener;
            this.f6516f = j2;
        }

        public boolean onTouch(View view, @NonNull MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case C3374b.SmoothProgressBar_spbStyle /*0*/:
                    C3045a.m9207c(this.f6511a, this.f6512b, this.f6513c, this.f6514d, this.f6515e).start();
                    break;
                case C3374b.SmoothProgressBar_spb_color /*1*/:
                case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                    C3045a.m9208d(this.f6511a, this.f6512b, this.f6513c, this.f6516f, this.f6515e).start();
                    break;
                default:
                    C3095y.m9471a("motion event not recognized");
                    break;
            }
            return false;
        }
    }

    static {
        f6517a = SpringSystem.create();
    }

    public static Spring m9201a() {
        return f6517a.createSpring();
    }

    public static boolean m9206b() {
        return VERSION.SDK_INT >= 16;
    }

    public static void m9204a(@NonNull View view, float f, float f2, long j, long j2, AnimatorListener animatorListener) {
        view.setOnTouchListener(new C30441(view, f, f2, j, animatorListener, j2));
    }

    public static void m9203a(@NonNull View view, float f, float f2, long j, long j2) {
        C3045a.m9204a(view, f, f2, j, j2, null);
    }

    public static void m9202a(float f, float f2, long j, long j2, @NonNull View... viewArr) {
        for (View a : viewArr) {
            C3045a.m9204a(a, f, f2, j, j2, null);
        }
    }

    @NonNull
    private static AnimatorSet m9207c(View view, float f, float f2, long j, @Nullable AnimatorListener animatorListener) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", new float[]{f, f2});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", new float[]{f, f2});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.setDuration(j);
        if (animatorListener != null) {
            animatorSet.addListener(animatorListener);
        }
        return animatorSet;
    }

    @NonNull
    private static AnimatorSet m9208d(View view, float f, float f2, long j, @Nullable AnimatorListener animatorListener) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", new float[]{f2, f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", new float[]{f2, f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.setDuration(j);
        animatorSet.setInterpolator(new OvershootInterpolator(4.0f));
        if (animatorListener != null) {
            animatorSet.addListener(animatorListener);
        }
        return animatorSet;
    }
}
