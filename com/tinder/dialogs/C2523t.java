package com.tinder.dialogs;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Dialog;
import android.content.Context;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import com.tinder.R;
import com.tinder.managers.C2807a;
import com.tinder.managers.ManagerApp;
import com.tinder.model.SparksEvent;
import com.tinder.p030d.bv;
import com.tinder.utils.C3045a;
import com.tinder.utils.C3070i;
import com.tinder.utils.C3093w;
import com.tinder.utils.C3095y;
import com.tinder.views.LikeMeter;
import com.tinder.views.LikeMeter.AssetMode;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

/* renamed from: com.tinder.dialogs.t */
public class C2523t extends Dialog implements OnClickListener {
    private static final Pattern f4597a;
    private static final SimpleDateFormat f4598f;
    private TextView f4599b;
    private LikeMeter f4600c;
    private long f4601d;
    private String f4602e;
    @NonNull
    private C2294a f4603g;

    /* renamed from: com.tinder.dialogs.t.a */
    public interface C2294a {
        void m6138I();
    }

    /* renamed from: com.tinder.dialogs.t.1 */
    class C25191 extends CountDownTimer {
        final /* synthetic */ C2523t f4593a;

        C25191(C2523t c2523t, long j, long j2) {
            this.f4593a = c2523t;
            super(j, j2);
        }

        public void onTick(long j) {
            this.f4593a.f4601d = j - 1000;
            this.f4593a.f4599b.setText(C3070i.m9368b(this.f4593a.f4601d));
        }

        public void onFinish() {
            this.f4593a.dismiss();
        }
    }

    /* renamed from: com.tinder.dialogs.t.2 */
    class C25202 implements AnimatorUpdateListener {
        final /* synthetic */ C2523t f4594a;

        C25202(C2523t c2523t) {
            this.f4594a = c2523t;
        }

        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            this.f4594a.f4600c.setPercentFull(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* renamed from: com.tinder.dialogs.t.3 */
    class C25223 extends bv {
        final /* synthetic */ C2523t f4596a;

        /* renamed from: com.tinder.dialogs.t.3.1 */
        class C25211 implements AnimatorUpdateListener {
            final /* synthetic */ C25223 f4595a;

            C25211(C25223 c25223) {
                this.f4595a = c25223;
            }

            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                this.f4595a.f4596a.f4600c.setPercentFull(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }

        C25223(C2523t c2523t) {
            this.f4596a = c2523t;
        }

        public void onAnimationEnd(Animator animator) {
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setRepeatMode(2);
            valueAnimator.setRepeatCount(-1);
            valueAnimator.setInterpolator(new DecelerateInterpolator());
            valueAnimator.setDuration(510);
            valueAnimator.addUpdateListener(new C25211(this));
            valueAnimator.setFloatValues(new float[]{0.15f, 0.2f});
            valueAnimator.start();
        }
    }

    static {
        f4597a = Pattern.compile("\n\n", 16);
        f4598f = new SimpleDateFormat("HH:mm:ss");
    }

    public C2523t(@NonNull Context context, @NonNull C2294a c2294a, String str) {
        super(context, R.style.Theme.FloatingDialog);
        setContentView(R.layout.dialog_swipe_roadblock);
        this.f4603g = c2294a;
        this.f4602e = str;
        m6960a();
    }

    private void m6960a() {
        f4598f.setLenient(false);
        setCanceledOnTouchOutside(true);
        this.f4600c = (LikeMeter) findViewById(R.id.like_meter);
        this.f4600c.setAssetMode(AssetMode.EXTRA_LARGE);
        View findViewById = findViewById(R.id.linear_get_plus);
        findViewById.setOnClickListener(this);
        C3045a.m9203a(findViewById, 1.0f, 0.95f, 275, 275);
        m6964c();
    }

    private void m6962b() {
        this.f4599b = (TextView) findViewById(R.id.swipe_limit_txt_countdown);
        this.f4601d = (ManagerApp.m7924o().m8719f() + 1000) - System.currentTimeMillis();
        if (this.f4601d <= 1000) {
            dismiss();
            return;
        }
        this.f4599b.setText(C3070i.m9368b(this.f4601d));
        new C25191(this, this.f4601d, 1000).start();
    }

    private void m6964c() {
        String replaceAll;
        CharSequence string = getContext().getString(R.string.unlimited_likes_get_plus);
        boolean matches = f4597a.matcher(string).matches();
        if (matches) {
            replaceAll = f4597a.matcher(string).replaceAll("\n");
        } else {
            CharSequence charSequence = string;
        }
        TextView textView = (TextView) findViewById(R.id.txt_get_plus);
        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(0.55f);
        CharSequence spannableString = new SpannableString(replaceAll);
        spannableString.setSpan(relativeSizeSpan, matches ? 0 : replaceAll.indexOf(10) + 1, matches ? replaceAll.indexOf(10) - 1 : replaceAll.length(), 18);
        textView.setText(spannableString);
    }

    private void m6965d() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(new AccelerateInterpolator());
        valueAnimator.setDuration(420);
        valueAnimator.setStartDelay(400);
        valueAnimator.setFloatValues(new float[]{1.0f, 0.15f});
        valueAnimator.addUpdateListener(new C25202(this));
        valueAnimator.addListener(new C25223(this));
        valueAnimator.start();
    }

    public void show() {
        super.show();
        C3095y.m9471a("Bouncer likes SHOW FOR REALS");
        m6965d();
        m6962b();
        ManagerApp.m7914e().m8799E(true);
        SparksEvent sparksEvent = new SparksEvent("Roadblock.View");
        sparksEvent.put("percentLikesLeft", Integer.valueOf(ManagerApp.m7924o().m8692a()));
        sparksEvent.put("otherId", this.f4602e);
        sparksEvent.put("locale", C3093w.m9462b());
        sparksEvent.put("roadblockVersion", Integer.valueOf(1));
        sparksEvent.put("timeRemaining", Long.valueOf(ManagerApp.m7924o().m8707b()));
        C2807a.m8056a(sparksEvent);
    }

    public void dismiss() {
        if ((this.f4601d <= 1000 ? 1 : 0) != 0) {
            ManagerApp.m7911b().m8143d();
        } else {
            SparksEvent sparksEvent = new SparksEvent("Roadblock.Cancel");
            sparksEvent.put("percentLikesLeft", Integer.valueOf(ManagerApp.m7924o().m8692a()));
            sparksEvent.put("otherId", this.f4602e);
            sparksEvent.put("locale", C3093w.m9462b());
            sparksEvent.put("roadblockVersion", Integer.valueOf(1));
            sparksEvent.put("timeRemaining", Long.valueOf(ManagerApp.m7924o().m8707b()));
            C2807a.m8056a(sparksEvent);
        }
        super.dismiss();
    }

    public void onClick(@NonNull View view) {
        switch (view.getId()) {
            case R.id.linear_get_plus:
                SparksEvent sparksEvent = new SparksEvent("Roadblock.Select");
                sparksEvent.put("percentLikesLeft", Integer.valueOf(ManagerApp.m7924o().m8692a()));
                sparksEvent.put("otherId", this.f4602e);
                sparksEvent.put("locale", C3093w.m9462b());
                sparksEvent.put("roadblockVersion", Integer.valueOf(1));
                sparksEvent.put("timeRemaining", Long.valueOf(ManagerApp.m7924o().m8707b()));
                C2807a.m8056a(sparksEvent);
                this.f4603g.m6138I();
                dismiss();
            default:
        }
    }
}
