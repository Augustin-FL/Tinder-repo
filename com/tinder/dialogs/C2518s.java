package com.tinder.dialogs;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.CycleInterpolator;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tinder.R;
import com.tinder.managers.C2807a;
import com.tinder.managers.C2958p;
import com.tinder.managers.C2960q;
import com.tinder.model.SparksEvent;
import com.tinder.p030d.bv;
import com.tinder.utils.C3045a;
import com.tinder.utils.C3072k;
import com.tinder.utils.al;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.tinder.dialogs.s */
public class C2518s extends Dialog implements OnClickListener {
    private final int f4575a;
    private final String f4576b;
    private final String f4577c;
    private int f4578d;
    private int f4579e;
    private int f4580f;
    private int f4581g;
    private String f4582h;
    private TextView f4583i;
    private TextView f4584j;
    private TextView f4585k;
    private TextView f4586l;
    private TextView f4587m;
    private TextView f4588n;
    private EditText f4589o;
    private ViewGroup f4590p;
    private ViewGroup f4591q;
    private ViewGroup f4592r;

    /* renamed from: com.tinder.dialogs.s.1 */
    class C25161 extends bv {
        final /* synthetic */ ImageView f4572a;
        final /* synthetic */ C2518s f4573b;

        C25161(C2518s c2518s, ImageView imageView) {
            this.f4573b = c2518s;
            this.f4572a = imageView;
        }

        public void onAnimationStart(Animator animator) {
            this.f4572a.setColorFilter(this.f4573b.f4578d);
        }
    }

    /* renamed from: com.tinder.dialogs.s.2 */
    class C25172 implements Runnable {
        final /* synthetic */ C2518s f4574a;

        C25172(C2518s c2518s) {
            this.f4574a = c2518s;
        }

        public void run() {
            al.m9267a(this.f4574a.getContext(), this.f4574a.f4589o);
        }
    }

    public C2518s(Context context, int i, String str) {
        super(context, R.style.Theme.FloatingDialog);
        this.f4575a = 4;
        this.f4576b = "#ffce66";
        this.f4577c = "#cecece";
        this.f4580f = -1;
        this.f4581g = 0;
        getWindow().setWindowAnimations(R.style.dialog_up_down_animation);
        setContentView(R.layout.dialog_rating);
        this.f4583i = (TextView) findViewById(R.id.rate_title);
        this.f4584j = (TextView) findViewById(R.id.rate_title_thanks);
        this.f4585k = (TextView) findViewById(R.id.rate_title_below);
        this.f4586l = (TextView) findViewById(R.id.rate_detail);
        this.f4589o = (EditText) findViewById(R.id.rate_me_feedback_edittext);
        this.f4590p = (ViewGroup) findViewById(R.id.rate_layout_stars);
        this.f4591q = (ViewGroup) findViewById(R.id.rate_layout_actions);
        this.f4587m = (TextView) findViewById(R.id.rate_action_pos);
        this.f4588n = (TextView) findViewById(R.id.rate_action_neg);
        this.f4592r = (ViewGroup) findViewById(R.id.rate_me_content);
        this.f4587m.setOnClickListener(this);
        al.m9287b(this.f4587m);
        this.f4588n.setOnClickListener(this);
        al.m9287b(this.f4588n);
        this.f4589o.setFilters(new InputFilter[]{new C3072k()});
        this.f4578d = Color.parseColor("#ffce66");
        this.f4579e = Color.parseColor("#cecece");
        this.f4582h = str;
        this.f4580f = i;
        if (this.f4580f == 0) {
            m6954h();
        } else if (1 == i) {
            m6950d();
        } else {
            throw new IllegalArgumentException("Invalid mode argument");
        }
    }

    public void show() {
        super.show();
        m6945a();
    }

    private void m6945a() {
        Object obj = this.f4580f == 0 ? "stars" : "askFeedback";
        SparksEvent sparksEvent = new SparksEvent("Rate.Show");
        sparksEvent.put("cause", this.f4582h);
        sparksEvent.put("mode", obj);
        C2807a.m8056a(sparksEvent);
    }

    private void m6948b() {
        Object obj = "?";
        if (this.f4580f != 5) {
            switch (this.f4580f) {
                case C3374b.SmoothProgressBar_spbStyle /*0*/:
                    obj = "stars";
                    break;
                case C3374b.SmoothProgressBar_spb_color /*1*/:
                    obj = "enterFeedback";
                    break;
                case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                    obj = "askFeedback";
                    break;
                case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                    obj = "askReview";
                    break;
            }
            SparksEvent sparksEvent = new SparksEvent("Rate.Cancel");
            sparksEvent.put("mode", obj);
            sparksEvent.put("cause", this.f4582h);
            if (this.f4581g > 0) {
                sparksEvent.put("stars", Integer.valueOf(this.f4581g));
            }
            C2807a.m8056a(sparksEvent);
        }
        if (1 == this.f4580f || 2 == this.f4580f) {
            C2958p.m8781b(true);
            m6952f();
        } else if (3 == this.f4580f) {
            C2958p.m8783c(true);
            m6953g();
        }
        this.f4580f = 5;
    }

    private void m6946a(int i) {
        this.f4581g = i + 1;
        boolean z = this.f4581g >= 4;
        C2958p.m8785d(true);
        SparksEvent sparksEvent = new SparksEvent("Rate.SelectStar");
        sparksEvent.put("stars", Integer.valueOf(this.f4581g));
        C2807a.m8056a(sparksEvent);
        TimeInterpolator cycleInterpolator = new CycleInterpolator(0.5f);
        if (z) {
            for (int i2 = 0; i2 < this.f4590p.getChildCount(); i2++) {
                ImageView imageView = (ImageView) this.f4590p.getChildAt(i2);
                if (i2 <= i) {
                    imageView.animate().setStartDelay((long) (i2 * 60)).scaleX(1.225f).scaleY(1.225f).setInterpolator(cycleInterpolator).setListener(new C25161(this, imageView)).start();
                } else {
                    imageView.setColorFilter(this.f4579e);
                }
                imageView.setClickable(false);
            }
            m6955i();
            return;
        }
        m6949c();
    }

    private void m6949c() {
        if (C3045a.m9206b()) {
            this.f4592r.getLayoutTransition().disableTransitionType(4);
            this.f4592r.getLayoutTransition().disableTransitionType(1);
            this.f4592r.getLayoutTransition().disableTransitionType(0);
        }
        this.f4580f = 2;
        this.f4583i.setVisibility(4);
        this.f4586l.setVisibility(4);
        this.f4583i.setText(R.string.can_tell_us_how);
        this.f4586l.setText(R.string.your_feedback_is_important);
        this.f4586l.setVisibility(4);
        this.f4583i.setVisibility(0);
        this.f4586l.setVisibility(0);
        this.f4591q.setVisibility(0);
        this.f4588n.setText(R.string.not_now);
        this.f4587m.setText(R.string.yes);
        this.f4590p.setVisibility(8);
        this.f4586l.setPadding(0, 0, 0, 0);
    }

    private void m6950d() {
        this.f4580f = 1;
        this.f4583i.setVisibility(8);
        this.f4586l.setVisibility(8);
        this.f4590p.setVisibility(8);
        this.f4588n.setText(R.string.cancel);
        this.f4587m.setText(R.string.send);
        this.f4589o.setVisibility(0);
        this.f4591q.setVisibility(0);
        this.f4589o.setMovementMethod(new ScrollingMovementMethod());
        this.f4589o.postDelayed(new C25172(this), 100);
    }

    private void m6951e() {
        this.f4580f = 4;
        this.f4589o.setVisibility(8);
        this.f4586l.setPadding(0, 0, 0, 0);
        this.f4586l.setVisibility(4);
        this.f4586l.setText(R.string.your_input_helps_us);
        this.f4586l.setVisibility(0);
        this.f4584j.setVisibility(0);
        this.f4587m.setText(R.string.okay);
        this.f4588n.setVisibility(4);
    }

    private void m6952f() {
        if (C3045a.m9206b()) {
            this.f4592r.getLayoutTransition().disableTransitionType(1);
            this.f4592r.getLayoutTransition().disableTransitionType(0);
            this.f4592r.getLayoutTransition().disableTransitionType(4);
            this.f4592r.getLayoutTransition().disableTransitionType(2);
            this.f4592r.getLayoutTransition().disableTransitionType(3);
        }
        this.f4584j.setVisibility(0);
        this.f4586l.setPadding(0, 0, 0, 0);
        this.f4586l.setText(R.string.you_can_provide_feedback_anytime);
        this.f4585k.setVisibility(8);
        this.f4583i.setVisibility(8);
        this.f4586l.setVisibility(0);
        this.f4589o.setVisibility(8);
        this.f4587m.setText(R.string.okay);
        this.f4588n.setVisibility(4);
    }

    private void m6953g() {
        if (C3045a.m9206b()) {
            this.f4592r.getLayoutTransition().disableTransitionType(1);
            this.f4592r.getLayoutTransition().disableTransitionType(0);
            this.f4592r.getLayoutTransition().disableTransitionType(4);
            this.f4592r.getLayoutTransition().disableTransitionType(2);
            this.f4592r.getLayoutTransition().disableTransitionType(3);
        }
        findViewById(R.id.rate_detail_thanks).setVisibility(0);
        this.f4586l.setVisibility(4);
        this.f4586l.setVisibility(8);
        this.f4587m.setText(R.string.okay);
        this.f4588n.setVisibility(4);
        this.f4590p.setVisibility(4);
        this.f4590p.setVisibility(8);
        this.f4591q.setVisibility(0);
        this.f4584j.setVisibility(0);
        this.f4585k.setVisibility(4);
        this.f4585k.setVisibility(8);
    }

    private void m6954h() {
        this.f4580f = 0;
        this.f4583i.setText(R.string.how_would_you_rate);
        this.f4586l.setText(R.string.tap_the_stars);
        this.f4590p.setVisibility(0);
        this.f4591q.setVisibility(8);
        for (int i = 0; i < this.f4590p.getChildCount(); i++) {
            ImageView imageView = (ImageView) this.f4590p.getChildAt(i);
            imageView.setOnClickListener(this);
            imageView.setColorFilter(this.f4579e);
        }
    }

    private void m6955i() {
        this.f4580f = 3;
        if (C3045a.m9206b()) {
            this.f4592r.getLayoutTransition().disableTransitionType(4);
            this.f4592r.getLayoutTransition().setAnimateParentHierarchy(false);
            this.f4592r.getLayoutTransition().setDuration(300);
        }
        this.f4585k.setVisibility(0);
        this.f4591q.setVisibility(0);
        this.f4586l.setText(R.string.no_better_way);
        this.f4586l.setVisibility(0);
        this.f4583i.setVisibility(8);
        this.f4586l.setPadding(0, 0, 0, 0);
    }

    private void m6956j() {
        String str = "market://details?id=com.tinder";
        SparksEvent sparksEvent = new SparksEvent("Rate.Review");
        sparksEvent.put("stars", Integer.valueOf(this.f4581g));
        sparksEvent.put("cause", this.f4582h);
        C2807a.m8056a(sparksEvent);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.tinder"));
        intent.addFlags(268435456);
        getContext().startActivity(intent);
    }

    private boolean m6957k() {
        Object trim = this.f4589o.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            return false;
        }
        SparksEvent sparksEvent = new SparksEvent("Rate.Feedback");
        sparksEvent.put("text", trim);
        sparksEvent.put("cause", this.f4582h);
        if (this.f4581g > 0) {
            sparksEvent.put("stars", Integer.valueOf(this.f4581g));
        }
        C2807a.m8056a(sparksEvent);
        C2958p.m8787e(true);
        C2960q.m8889a(trim, this.f4581g);
        return true;
    }

    public void onBackPressed() {
        m6948b();
        super.onBackPressed();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_star_1:
            case R.id.img_star_2:
            case R.id.img_star_3:
            case R.id.img_star_4:
            case R.id.img_star_5:
                m6946a(this.f4590p.indexOfChild(view));
            case R.id.rate_action_neg:
                m6948b();
                al.m9295c(this.f4589o);
            case R.id.rate_action_pos:
                switch (this.f4580f) {
                    case C3374b.SmoothProgressBar_spb_color /*1*/:
                        if (m6957k()) {
                            al.m9295c(this.f4589o);
                            m6951e();
                        }
                    case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                        m6950d();
                    case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                        m6956j();
                        dismiss();
                    default:
                        dismiss();
                }
            default:
        }
    }
}
