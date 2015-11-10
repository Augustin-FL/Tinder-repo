package com.tinder.adapters;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.res.Configuration;
import android.view.View;
import com.tinder.p030d.bb;
import com.tinder.utils.C3095y;
import com.tinder.utils.al;
import uk.co.senab.actionbarpulltorefresh.library.C2359b;

/* renamed from: com.tinder.adapters.n */
public class C2360n extends C2359b {
    private bb f4176a;
    private View f4177b;

    /* renamed from: com.tinder.adapters.n.a */
    class C2358a extends AnimatorListenerAdapter {
        final /* synthetic */ C2360n f4175a;

        C2358a(C2360n c2360n) {
            this.f4175a = c2360n;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f4175a.f4177b != null) {
                this.f4175a.f4177b.setVisibility(8);
            }
            this.f4175a.m6430a();
        }
    }

    public C2360n(bb bbVar) {
        C3095y.m9469a();
        this.f4176a = bbVar;
    }

    public void m6430a() {
        C3095y.m9469a();
    }

    public void m6431a(float f) {
        this.f4176a.m6135a(f);
    }

    public void m6433b() {
        C3095y.m9469a();
        m6429f();
    }

    public void m6434c() {
        C3095y.m9469a();
    }

    public boolean m6435d() {
        C3095y.m9469a();
        boolean z = this.f4177b.getVisibility() != 0;
        if (z) {
            this.f4177b.setVisibility(0);
            if (!al.m9276a()) {
                AnimatorSet animatorSet = new AnimatorSet();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f4177b, "translationY", new float[]{(float) (-this.f4177b.getHeight()), 0.0f});
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f4177b, "alpha", new float[]{0.0f, 1.0f});
                animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
                animatorSet.setDuration(300);
                animatorSet.start();
            }
        }
        return z;
    }

    public boolean m6436e() {
        C3095y.m9469a();
        boolean z = this.f4177b.getVisibility() != 8;
        if (z) {
            m6429f();
        }
        this.f4176a.m6134G();
        return z;
    }

    public void m6432a(Activity activity, Configuration configuration) {
        C3095y.m9469a();
    }

    private void m6429f() {
        if (al.m9276a()) {
            this.f4177b.setVisibility(8);
            this.f4177b.invalidate();
            return;
        }
        Animator animatorSet;
        if (this.f4177b.getAlpha() >= 0.5f) {
            animatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f4177b, "translationY", new float[]{0.0f, (float) (-this.f4177b.getHeight())});
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f4177b, "alpha", new float[]{1.0f, 0.0f});
            ((AnimatorSet) animatorSet).playTogether(new Animator[]{ofFloat, ofFloat2});
        } else {
            animatorSet = ObjectAnimator.ofFloat(this.f4177b, "alpha", new float[]{1.0f, 0.0f});
        }
        animatorSet.setDuration(300);
        animatorSet.addListener(new C2358a(this));
        animatorSet.start();
    }
}
