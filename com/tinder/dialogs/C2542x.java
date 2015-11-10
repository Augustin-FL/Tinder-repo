package com.tinder.dialogs;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.internal.WebDialog;
import com.tinder.R;
import com.tinder.managers.C2807a;
import com.tinder.managers.ManagerApp;
import com.tinder.model.Match;
import com.tinder.model.SparksEvent;
import com.tinder.model.User;
import com.tinder.p030d.ad;
import com.tinder.p032c.C2423e;
import com.tinder.picassowebp.picasso.C2311e;
import com.tinder.picassowebp.picasso.Picasso;
import com.tinder.utils.C3095y;
import com.tinder.utils.aj;
import com.tinder.utils.al;
import com.tinder.views.RoundImageView;
import com.tinder.views.VerifiedBadgeView;
import java.util.List;
import java.util.Locale;
import org.apache.http.protocol.HTTP;

/* renamed from: com.tinder.dialogs.x */
public class C2542x extends Dialog {
    private final Match f4624a;
    private final String f4625b;
    private final ad f4626c;
    @NonNull
    private final Context f4627d;
    private RelativeLayout f4628e;
    private RelativeLayout f4629f;
    private TextView f4630g;
    private View f4631h;
    private View f4632i;
    private ProgressBar f4633j;
    private View f4634k;
    private int f4635l;

    /* renamed from: com.tinder.dialogs.x.1 */
    class C25341 implements OnClickListener {
        final /* synthetic */ C2542x f4614a;

        C25341(C2542x c2542x) {
            this.f4614a = c2542x;
        }

        public void onClick(View view) {
            User d = ManagerApp.m7922m().m8599d();
            SparksEvent sparksEvent = new SparksEvent("Match.OpenChat");
            sparksEvent.put("matchId", this.f4614a.f4624a.getId());
            sparksEvent.put("superLike", Boolean.valueOf(this.f4614a.f4624a.isTheSuperLiker(d)));
            sparksEvent.put("didSuperLike", Boolean.valueOf(this.f4614a.f4624a.superLikerIsThem()));
            C2807a.m8056a(sparksEvent);
            this.f4614a.f4626c.m6640b(this.f4614a.f4624a);
            this.f4614a.f4633j.setVisibility(0);
        }
    }

    /* renamed from: com.tinder.dialogs.x.2 */
    class C25352 implements OnClickListener {
        final /* synthetic */ C2542x f4615a;

        C25352(C2542x c2542x) {
            this.f4615a = c2542x;
        }

        public void onClick(View view) {
            User d = ManagerApp.m7922m().m8599d();
            SparksEvent sparksEvent = new SparksEvent("Match.KeepPlaying");
            sparksEvent.put("matchId", this.f4615a.f4624a.getId());
            sparksEvent.put("superLike", Boolean.valueOf(this.f4615a.f4624a.isTheSuperLiker(d)));
            sparksEvent.put("didSuperLike", Boolean.valueOf(this.f4615a.f4624a.superLikerIsThem()));
            C2807a.m8056a(sparksEvent);
            this.f4615a.f4626c.m6642o();
            this.f4615a.m6981a();
        }
    }

    /* renamed from: com.tinder.dialogs.x.3 */
    class C25363 implements OnClickListener {
        final /* synthetic */ C2542x f4616a;

        C25363(C2542x c2542x) {
            this.f4616a = c2542x;
        }

        public void onClick(View view) {
            User d = ManagerApp.m7922m().m8599d();
            SparksEvent sparksEvent = new SparksEvent("Match.InviteFriends");
            sparksEvent.put("matchId", this.f4616a.f4624a.getId());
            sparksEvent.put("superLike", Boolean.valueOf(this.f4616a.f4624a.isTheSuperLiker(d)));
            sparksEvent.put("didSuperLike", Boolean.valueOf(this.f4616a.f4624a.superLikerIsThem()));
            C2807a.m8056a(sparksEvent);
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType(HTTP.PLAIN_TEXT_TYPE);
            intent.putExtra("android.intent.extra.TEXT", String.format(this.f4616a.f4627d.getString(R.string.share_matched_intent_num_matches), new Object[]{Integer.valueOf(ManagerApp.m7925p().m8289d())}));
            this.f4616a.f4627d.startActivity(Intent.createChooser(intent, this.f4616a.f4627d.getString(R.string.share_matched)));
        }
    }

    /* renamed from: com.tinder.dialogs.x.4 */
    class C25374 implements OnClickListener {
        final /* synthetic */ C2542x f4617a;

        C25374(C2542x c2542x) {
            this.f4617a = c2542x;
        }

        public void onClick(View view) {
            this.f4617a.f4626c.m6643p();
        }
    }

    /* renamed from: com.tinder.dialogs.x.5 */
    class C25385 implements OnClickListener {
        final /* synthetic */ C2542x f4618a;

        C25385(C2542x c2542x) {
            this.f4618a = c2542x;
        }

        public void onClick(View view) {
            this.f4618a.f4626c.m6641c(this.f4618a.f4624a);
        }
    }

    /* renamed from: com.tinder.dialogs.x.6 */
    class C25396 implements AnimatorListener {
        final /* synthetic */ C2542x f4619a;

        C25396(C2542x c2542x) {
            this.f4619a = c2542x;
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            this.f4619a.f4631h.setEnabled(true);
            this.f4619a.f4632i.setEnabled(true);
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    /* renamed from: com.tinder.dialogs.x.7 */
    class C25407 extends AnimatorListenerAdapter {
        final /* synthetic */ C2542x f4620a;

        C25407(C2542x c2542x) {
            this.f4620a = c2542x;
        }

        public void onAnimationEnd(Animator animator) {
            this.f4620a.dismiss();
        }
    }

    /* renamed from: com.tinder.dialogs.x.a */
    private class C2541a implements C2311e {
        final /* synthetic */ C2542x f4621a;
        private int f4622b;
        private ImageView f4623c;

        public C2541a(C2542x c2542x, int i, ImageView imageView) {
            this.f4621a = c2542x;
            this.f4622b = i;
            this.f4623c = imageView;
        }

        public void m6968a() {
            this.f4621a.f4635l = this.f4621a.f4635l + 1;
            if (this.f4621a.f4635l == 2) {
                C3095y.m9471a("Loaded 2 avatar photos, calling through to show dialog");
                this.f4621a.f4626c.m6644q();
            }
        }

        public void m6969b() {
            this.f4621a.f4621a.f4635l = this.f4621a.f4635l + 1;
            Picasso.m8982a(this.f4621a.f4627d).m8987a((int) R.drawable.addaphoto_loader_icon).m9129b(this.f4622b, this.f4622b).m9127b().m9124a(this.f4623c);
            if (this.f4621a.f4635l == 2) {
                C3095y.m9479c("Failed to load match avatar images for match screen!");
                this.f4621a.f4626c.m6644q();
            }
        }
    }

    public C2542x(@NonNull Activity activity, ad adVar, String str, Match match) {
        super(activity, WebDialog.DEFAULT_THEME);
        this.f4635l = 0;
        this.f4627d = activity;
        this.f4625b = str;
        this.f4624a = match;
        this.f4626c = adVar;
        m6971a(activity);
        m6973b();
    }

    public void show() {
        super.show();
        m6975c();
        aj.m9235a().m9239d();
    }

    private void m6971a(@NonNull Activity activity) {
        requestWindowFeature(1);
        getWindow().setWindowAnimations(R.style.dialog_animation_matched);
        getWindow().setLayout(-1, -1);
        setContentView(R.layout.view_matched);
        TextView textView = (TextView) findViewById(R.id.matched_text);
        TextView textView2 = (TextView) findViewById(R.id.customTextView_its_a_match);
        this.f4630g = (TextView) findViewById(R.id.text_matched_share);
        ImageView imageView = (ImageView) findViewById(R.id.imageView_its_a_match);
        View view = (RoundImageView) findViewById(R.id.img_match_one);
        View view2 = (RoundImageView) findViewById(R.id.img_match_two);
        this.f4633j = (ProgressBar) findViewById(R.id.progressBar);
        this.f4631h = findViewById(R.id.linear_start_chatting);
        this.f4632i = findViewById(R.id.linear_find_more_matches);
        this.f4634k = findViewById(R.id.superlike_star);
        if (this.f4624a.isSuperlike() && ManagerApp.m7914e().at()) {
            this.f4634k.setVisibility(0);
            textView.setText(String.format(getContext().getString(this.f4624a.isTheSuperLiker(ManagerApp.m7922m().m8599d()) ? R.string.superlike_like_statement : R.string.superlike_liked_statement), new Object[]{this.f4624a.getName()}));
        } else {
            this.f4634k.setVisibility(8);
            textView.setText(String.format(getContext().getString(R.string.liked_statement), new Object[]{this.f4624a.getName()}));
        }
        this.f4628e = (RelativeLayout) findViewById(R.id.linear_match_one);
        this.f4629f = (RelativeLayout) findViewById(R.id.linear_match_two);
        int dimension = (int) this.f4627d.getResources().getDimension(R.dimen.matched_avatar_length);
        Picasso.m8982a(this.f4627d).m8990a(this.f4625b).m9120a((int) R.drawable.addaphoto_loader_icon).m9129b(dimension, dimension).m9127b().m9125a((ImageView) view, new C2541a(this, dimension, view));
        List avatarUrlsForSize = this.f4624a.getPerson().getAvatarUrlsForSize(al.m9265a(activity));
        if (avatarUrlsForSize.size() > 0) {
            Picasso.m8982a(this.f4627d).m8990a((String) avatarUrlsForSize.get(0)).m9120a((int) R.drawable.addaphoto_loader_icon).m9129b(dimension, dimension).m9127b().m9125a((ImageView) view2, new C2541a(this, dimension, view2));
        }
        if (Locale.US.equals(Locale.getDefault()) || Locale.UK.equals(Locale.getDefault())) {
            imageView.setVisibility(0);
            textView2.setVisibility(4);
        } else {
            imageView.setVisibility(4);
            textView2.setVisibility(0);
        }
        this.f4631h.setOnClickListener(new C25341(this));
        this.f4632i.setOnClickListener(new C25352(this));
        this.f4630g.setOnClickListener(new C25363(this));
        view.setOnClickListener(new C25374(this));
        view2.setOnClickListener(new C25385(this));
        al.m9287b(this.f4630g);
        al.m9287b(view);
        al.m9287b(view2);
        VerifiedBadgeView verifiedBadgeView = (VerifiedBadgeView) findViewById(R.id.verified_badge1);
        VerifiedBadgeView verifiedBadgeView2 = (VerifiedBadgeView) findViewById(R.id.verified_badge2);
        verifiedBadgeView.setBordered(true);
        verifiedBadgeView2.setBordered(true);
        C2423e d = ManagerApp.m7922m().m8599d();
        if (d != null) {
            verifiedBadgeView.displayBadge(d);
        }
        verifiedBadgeView2.displayBadge(this.f4624a);
    }

    private void m6973b() {
        float a = (float) al.m9262a(getContext());
        float b = (float) al.m9285b(getContext());
        float dimensionPixelSize = (float) this.f4627d.getResources().getDimensionPixelSize(R.dimen.matched_avatar_frame_length);
        this.f4631h.measure(0, 0);
        this.f4632i.measure(0, 0);
        this.f4630g.measure(0, 0);
        int measuredWidth = this.f4631h.getMeasuredWidth();
        float f = ((float) ((-this.f4632i.getMeasuredWidth()) - 100)) - a;
        float f2 = (((float) measuredWidth) + a) + 100.0f;
        b += (float) this.f4630g.getMeasuredHeight();
        this.f4629f.setTranslationX((-dimensionPixelSize) * 2.0f);
        this.f4628e.setTranslationX(a);
        this.f4628e.setRotation(-23.0f);
        this.f4629f.setRotation(23.0f);
        this.f4631h.setTranslationX(f2);
        this.f4632i.setTranslationX(f);
        this.f4630g.setTranslationY(b);
    }

    private void m6975c() {
        AnimatorListener c25396 = new C25396(this);
        TimeInterpolator overshootInterpolator = new OvershootInterpolator(1.6f);
        TimeInterpolator overshootInterpolator2 = new OvershootInterpolator(0.6f);
        this.f4629f.animate().translationX(0.0f).setStartDelay(100).setDuration(550).setInterpolator(overshootInterpolator).start();
        this.f4629f.animate().rotation(0.0f).setStartDelay(100).setInterpolator(new LinearInterpolator()).start();
        this.f4628e.animate().translationX(0.0f).setStartDelay(100).setDuration(550).setInterpolator(overshootInterpolator).start();
        this.f4628e.animate().rotation(0.0f).setStartDelay(100).setInterpolator(new LinearInterpolator()).start();
        this.f4632i.animate().translationX(0.0f).setStartDelay(320).setDuration(425).setInterpolator(overshootInterpolator2).setListener(c25396).start();
        this.f4631h.animate().translationX(0.0f).setStartDelay(320).setDuration(425).setInterpolator(overshootInterpolator2).start();
        this.f4630g.animate().translationY(0.0f).alpha(1.0f).setInterpolator(new DecelerateInterpolator()).setStartDelay(650).setDuration(500).start();
    }

    public void cancel() {
        m6981a();
    }

    public void m6981a() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.matched_relative_layout);
        if (!al.m9276a()) {
            relativeLayout.setPivotX((float) (relativeLayout.getMeasuredWidth() / 2));
            relativeLayout.setPivotY((float) (relativeLayout.getMeasuredHeight() / 2));
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.matched_frame_layout);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(relativeLayout, "scaleX", new float[]{0.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(relativeLayout, "scaleY", new float[]{0.0f});
        TimeInterpolator anticipateInterpolator = new AnticipateInterpolator(2.0f);
        ofFloat.setInterpolator(anticipateInterpolator);
        ofFloat2.setInterpolator(anticipateInterpolator);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(frameLayout, "alpha", new float[]{0.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(300);
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
        animatorSet.addListener(new C25407(this));
        animatorSet.start();
    }
}
