package com.tinder.fragments;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Outline;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.stetho.BuildConfig;
import com.tinder.R;
import com.tinder.activities.ActivityCredits;
import com.tinder.activities.ActivityLogin;
import com.tinder.activities.ActivityMain;
import com.tinder.activities.CameraActivity;
import com.tinder.adapters.C2357m;
import com.tinder.fragments.k.AnonymousClass16;
import com.tinder.fragments.k.AnonymousClass17;
import com.tinder.fragments.k.AnonymousClass18;
import com.tinder.fragments.k.AnonymousClass24;
import com.tinder.managers.C2807a;
import com.tinder.managers.C2833d;
import com.tinder.managers.C2833d.C2633b;
import com.tinder.managers.ManagerApp;
import com.tinder.model.Match;
import com.tinder.model.User;
import com.tinder.p030d.ae;
import com.tinder.p030d.aq;
import com.tinder.p030d.bd;
import com.tinder.p030d.bu;
import com.tinder.p031b.C2392e;
import com.tinder.utils.C3045a;
import com.tinder.utils.C3077n;
import com.tinder.utils.C3095y;
import com.tinder.utils.al;
import com.tinder.utils.al.C3054a;
import com.tinder.views.PeekStack;
import com.tinder.views.ScalableLine;
import com.tinder.views.SkippableViewPager;
import java.util.Hashtable;
import java.util.List;
import org.apache.http.HttpStatus;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.tinder.fragments.k */
public class C2646k extends Fragment implements OnPageChangeListener, OnClickListener, ae, aq, bd {
    private static float f5048z;
    private View f5049A;
    private View f5050B;
    private View f5051C;
    private boolean f5052D;
    private Spring f5053E;
    @NonNull
    private Hashtable<View, Float> f5054F;
    private int f5055G;
    private int f5056H;
    private int f5057I;
    private int f5058J;
    private float f5059K;
    private float f5060L;
    private float f5061M;
    private boolean f5062N;
    private C2357m f5063O;
    private float f5064P;
    private boolean f5065Q;
    private boolean f5066R;
    private ObjectAnimator f5067S;
    private ObjectAnimator f5068T;
    private ActivityMain f5069U;
    private int f5070V;
    @Nullable
    private ValueAnimator f5071W;
    private int f5072X;
    private ObjectAnimator f5073Y;
    private DecelerateInterpolator f5074Z;
    ScalableLine f5075a;
    private int aa;
    private boolean ab;
    private boolean ac;
    private C2295a ad;
    SkippableViewPager f5076b;
    View f5077c;
    ImageButton f5078d;
    ImageButton f5079e;
    View f5080f;
    FrameLayout f5081g;
    ImageButton f5082h;
    ImageButton f5083i;
    View f5084j;
    ImageButton f5085k;
    RelativeLayout f5086l;
    RelativeLayout f5087m;
    ImageButton f5088n;
    ImageButton f5089o;
    View f5090p;
    ImageButton f5091q;
    ImageButton f5092r;
    EditText f5093s;
    View f5094t;
    View f5095u;
    View f5096v;
    View f5097w;
    View f5098x;
    @Nullable
    C2633b f5099y;

    /* renamed from: com.tinder.fragments.k.a */
    public interface C2295a {
        void m6139S();
    }

    /* renamed from: com.tinder.fragments.k.16 */
    class AnonymousClass16 implements Runnable {
        final /* synthetic */ int f5015a;
        final /* synthetic */ float f5016b;
        final /* synthetic */ C2646k f5017c;

        AnonymousClass16(C2646k c2646k, int i, float f) {
            this.f5017c = c2646k;
            this.f5015a = i;
            this.f5016b = f;
        }

        public void run() {
            this.f5017c.m7327e((float) this.f5015a);
            this.f5017c.m7333g((float) this.f5015a);
            this.f5017c.m7330f((float) this.f5015a);
            this.f5017c.m7342j((float) this.f5015a);
            this.f5017c.m7297a(0.0f, this.f5017c.f5064P);
            this.f5017c.m7345k(1.0f - this.f5016b);
            this.f5017c.m7323d(this.f5016b);
            this.f5017c.m7336h(this.f5016b);
        }
    }

    /* renamed from: com.tinder.fragments.k.17 */
    class AnonymousClass17 extends bu {
        final /* synthetic */ View f5018a;
        final /* synthetic */ C2646k f5019b;

        AnonymousClass17(C2646k c2646k, View view) {
            this.f5019b = c2646k;
            this.f5018a = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.f5018a.setVisibility(0);
        }
    }

    /* renamed from: com.tinder.fragments.k.18 */
    class AnonymousClass18 extends bu {
        final /* synthetic */ View f5020a;
        final /* synthetic */ C2646k f5021b;

        AnonymousClass18(C2646k c2646k, View view) {
            this.f5021b = c2646k;
            this.f5020a = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.f5020a.setVisibility(4);
        }
    }

    /* renamed from: com.tinder.fragments.k.1 */
    class C26341 implements C2633b {
        final /* synthetic */ C2646k f5023a;

        C26341(C2646k c2646k) {
            this.f5023a = c2646k;
        }

        public void m7275a() {
            C3095y.m9471a("Ping completed sucessfully, flipping flag to allow recs call.");
            this.f5023a.ab = true;
            this.f5023a.m7382r();
            ManagerApp.m7913d().m8201b((C2633b) this);
            this.f5023a.f5099y = null;
        }

        public void m7276b() {
            C3095y.m9479c("Ping failed, not allowing recs call.");
            ManagerApp.m7913d().m8201b((C2633b) this);
            this.f5023a.f5099y = null;
        }

        public void m7277c() {
            C3095y.m9471a("Ping was skipped due to displacement, good to load recs.");
            this.f5023a.ab = true;
            this.f5023a.m7382r();
            ManagerApp.m7913d().m8201b((C2633b) this);
            this.f5023a.f5099y = null;
        }
    }

    /* renamed from: com.tinder.fragments.k.24 */
    class AnonymousClass24 implements AnimatorListener {
        final /* synthetic */ AnimatorListener f5028a;
        final /* synthetic */ C2646k f5029b;

        AnonymousClass24(C2646k c2646k, AnimatorListener animatorListener) {
            this.f5029b = c2646k;
            this.f5028a = animatorListener;
        }

        public void onAnimationStart(Animator animator) {
            this.f5028a.onAnimationStart(null);
            if (!al.m9276a()) {
                this.f5029b.f5082h.setAlpha(1.0f);
                this.f5029b.f5078d.setAlpha(1.0f);
                this.f5029b.f5080f.setAlpha(1.0f);
                if (this.f5029b.f5092r.getVisibility() == 0) {
                    this.f5029b.f5092r.setAlpha(1.0f);
                }
                if (this.f5029b.f5088n.getAlpha() >= 0.2f) {
                    this.f5029b.f5088n.setAlpha(1.0f);
                    this.f5029b.f5085k.setAlpha(0);
                } else {
                    this.f5029b.f5085k.setAlpha(1.0f);
                    this.f5029b.f5088n.setAlpha(0);
                }
                if (this.f5029b.f5091q.getAlpha() >= 0.2f) {
                    this.f5029b.f5091q.setAlpha(1.0f);
                    this.f5029b.f5089o.setAlpha(0);
                    return;
                }
                this.f5029b.f5089o.setAlpha(1.0f);
                this.f5029b.f5091q.setAlpha(0);
            }
        }

        public void onAnimationEnd(Animator animator) {
            C3095y.m9469a();
            this.f5029b.m7305a(false, this.f5028a);
        }

        public void onAnimationCancel(Animator animator) {
            C3095y.m9469a();
            this.f5028a.onAnimationCancel(null);
        }

        public void onAnimationRepeat(Animator animator) {
            C3095y.m9469a();
            this.f5028a.onAnimationRepeat(null);
        }
    }

    /* renamed from: com.tinder.fragments.k.2 */
    class C26352 implements Runnable {
        final /* synthetic */ C2646k f5035a;

        C26352(C2646k c2646k) {
            this.f5035a = c2646k;
        }

        public void run() {
            this.f5035a.m7282I();
        }
    }

    /* renamed from: com.tinder.fragments.k.3 */
    class C26363 implements Runnable {
        final /* synthetic */ C2646k f5037a;

        C26363(C2646k c2646k) {
            this.f5037a = c2646k;
        }

        public void run() {
            C3054a c3054a = new C3054a(this.f5037a.f5077c);
            al.m9275a(c3054a, this.f5037a.f5078d, 0, this.f5037a.aa, 0, 0);
            al.m9275a(c3054a, this.f5037a.f5081g, this.f5037a.aa, this.f5037a.aa, 0, 0);
            al.m9275a(c3054a, this.f5037a.f5086l, this.f5037a.aa, this.f5037a.aa, 0, 0);
            this.f5037a.f5077c.setTouchDelegate(c3054a);
        }
    }

    /* renamed from: com.tinder.fragments.k.4 */
    class C26374 extends AsyncTask<Void, Void, List<Match>> {
        final /* synthetic */ String f5038a;
        final /* synthetic */ C2646k f5039b;

        C26374(C2646k c2646k, String str) {
            this.f5039b = c2646k;
            this.f5038a = str;
        }

        @NonNull
        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m7278a((Void[]) objArr);
        }

        public /* synthetic */ void onPostExecute(@NonNull Object obj) {
            m7279a((List) obj);
        }

        @NonNull
        protected List<Match> m7278a(Void... voidArr) {
            return new C2392e().m6512b(this.f5038a);
        }

        public void m7279a(@NonNull List<Match> list) {
            C3095y.m9471a("ENTER num matches: " + list);
            if (this.f5039b.f5093s != null) {
                if (this.f5038a.equals(this.f5039b.f5093s.getText().toString()) && this.f5039b.f5062N) {
                    C2668m b = this.f5039b.f5063O.m6418b();
                    if (b != null) {
                        b.m7460a((List) list);
                    }
                }
            }
        }
    }

    /* renamed from: com.tinder.fragments.k.5 */
    class C26395 extends AnimatorListenerAdapter {
        final /* synthetic */ C2646k f5041a;

        /* renamed from: com.tinder.fragments.k.5.1 */
        class C26381 implements OnClickListener {
            final /* synthetic */ C26395 f5040a;

            C26381(C26395 c26395) {
                this.f5040a = c26395;
            }

            public void onClick(View view) {
                this.f5040a.f5041a.m7362a(true);
            }
        }

        C26395(C2646k c2646k) {
            this.f5041a = c2646k;
        }

        public void onAnimationEnd(Animator animator) {
            this.f5041a.f5093s.setHint(String.format(this.f5041a.getString(R.string.search_n_matches), new Object[]{Integer.valueOf(ManagerApp.m7925p().m8289d())}));
            this.f5041a.f5093s.setVisibility(0);
            this.f5041a.f5095u.setVisibility(0);
            this.f5041a.f5092r.setOnClickListener(new C26381(this));
            al.m9267a(this.f5041a.getActivity(), this.f5041a.f5093s);
            C2668m b = this.f5041a.f5063O.m6418b();
            if (b != null) {
                b.m7464c();
            }
        }
    }

    /* renamed from: com.tinder.fragments.k.6 */
    class C26416 extends AnimatorListenerAdapter {
        final /* synthetic */ C2646k f5043a;

        /* renamed from: com.tinder.fragments.k.6.1 */
        class C26401 implements OnClickListener {
            final /* synthetic */ C26416 f5042a;

            C26401(C26416 c26416) {
                this.f5042a = c26416;
            }

            public void onClick(View view) {
                this.f5042a.f5043a.m7375k();
            }
        }

        C26416(C2646k c2646k) {
            this.f5043a = c2646k;
        }

        public void onAnimationStart(Animator animator) {
            if (this.f5043a.getActivity() != null && this.f5043a.getView() != null) {
                ((InputMethodManager) this.f5043a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f5043a.getView().getWindowToken(), 1);
            }
        }

        public void onAnimationEnd(Animator animator) {
            this.f5043a.f5054F.clear();
            this.f5043a.f5094t.setVisibility(8);
            this.f5043a.f5075a.setVisibility(0);
            this.f5043a.f5092r.setOnClickListener(new C26401(this));
            C2668m b = this.f5043a.f5063O.m6418b();
            if (b != null) {
                b.m7465d();
            }
            this.f5043a.m7353C();
        }
    }

    /* renamed from: com.tinder.fragments.k.7 */
    class C26427 extends bu {
        final /* synthetic */ C2646k f5044a;

        C26427(C2646k c2646k) {
            this.f5044a = c2646k;
        }

        public void onAnimationStart(Animator animator) {
            this.f5044a.f5051C.setVisibility(0);
        }
    }

    /* renamed from: com.tinder.fragments.k.8 */
    class C26448 extends SimpleSpringListener {
        final /* synthetic */ C2646k f5046a;

        /* renamed from: com.tinder.fragments.k.8.1 */
        class C26431 extends bu {
            final /* synthetic */ C26448 f5045a;

            C26431(C26448 c26448) {
                this.f5045a = c26448;
            }

            public void onAnimationEnd(Animator animator) {
                this.f5045a.f5046a.f5049A.setVisibility(4);
            }
        }

        C26448(C2646k c2646k) {
            this.f5046a = c2646k;
        }

        public void onSpringActivate(Spring spring) {
            this.f5046a.f5049A.setAlpha(1.0f);
            this.f5046a.f5049A.setVisibility(0);
            this.f5046a.f5050B.setVisibility(0);
            this.f5046a.f5050B.setRotation(20.0f);
        }

        public void onSpringUpdate(@NonNull Spring spring) {
            float currentValue = (float) spring.getCurrentValue();
            al.m9296c(this.f5046a.f5050B, currentValue);
            this.f5046a.f5050B.setRotation(20.0f - (currentValue * 20.0f));
        }

        public void onSpringAtRest(Spring spring) {
            this.f5046a.f5049A.animate().alpha(0.0f).setDuration(200).setStartDelay(300).setListener(new C26431(this)).start();
            this.f5046a.f5052D = false;
        }
    }

    /* renamed from: com.tinder.fragments.k.9 */
    class C26459 implements Runnable {
        final /* synthetic */ C2646k f5047a;

        C26459(C2646k c2646k) {
            this.f5047a = c2646k;
        }

        public void run() {
            C2720t c2720t = (C2720t) this.f5047a.f5063O.m6419c();
            if (c2720t != null) {
                c2720t.m7696t();
            }
        }
    }

    public C2646k() {
        this.f5054F = new Hashtable(5);
        this.ab = false;
        this.ac = false;
        this.f5099y = new C26341(this);
    }

    private static boolean m7313b(@Nullable String str) {
        return str != null && "fragment recommendations".equals(str);
    }

    private static boolean m7319c(@NonNull String str) {
        if (str.toLowerCase().contains("don't swipe and drive") || str.toLowerCase().contains("don't swipe & drive")) {
            return true;
        }
        return false;
    }

    public void onAttach(Activity activity) {
        if (activity instanceof ActivityMain) {
            ((ActivityMain) activity).m6183a(this);
        } else {
            C3095y.m9479c("FragmentMain is designed to be attached to ActivityMain, however we attached to " + activity.getClass() + " instead");
        }
        super.onAttach(activity);
        if (activity instanceof C2295a) {
            this.ad = (C2295a) activity;
            if (this.ac) {
                this.ad.m6139S();
            }
        }
        super.onAttach(activity);
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.view_fragment_main, viewGroup, false);
        this.f5075a = (ScalableLine) inflate.findViewById(R.id.scalable);
        this.f5076b = (SkippableViewPager) inflate.findViewById(R.id.viewpager_fragment_main);
        this.f5077c = inflate.findViewById(R.id.ab_container);
        this.f5078d = (ImageButton) inflate.findViewById(R.id.btn_main_menu);
        this.f5079e = (ImageButton) inflate.findViewById(R.id.btn_main_logo);
        this.f5080f = inflate.findViewById(R.id.main_menu_divider);
        this.f5081g = (FrameLayout) inflate.findViewById(R.id.btn_flame_layout);
        this.f5082h = (ImageButton) inflate.findViewById(R.id.btn_main_flame);
        this.f5083i = (ImageButton) inflate.findViewById(R.id.btn_bg_main_flame);
        this.f5084j = inflate.findViewById(R.id.img_matches_unread_indicator);
        this.f5085k = (ImageButton) inflate.findViewById(R.id.btn_main_matches);
        this.f5086l = (RelativeLayout) inflate.findViewById(R.id.btn_matches_layout);
        this.f5087m = (RelativeLayout) inflate.findViewById(R.id.btn_moments_layout);
        this.f5088n = (ImageButton) inflate.findViewById(R.id.btn_bg_main_matches);
        this.f5089o = (ImageButton) inflate.findViewById(R.id.btn_main_moments);
        this.f5090p = inflate.findViewById(R.id.img_moments_activity_unread_indicator);
        this.f5091q = (ImageButton) inflate.findViewById(R.id.btn_bg_moments);
        this.f5092r = (ImageButton) inflate.findViewById(R.id.btn_search_matches);
        this.f5093s = (EditText) inflate.findViewById(R.id.edit_search_input);
        this.f5094t = inflate.findViewById(R.id.search_bg);
        this.f5095u = inflate.findViewById(R.id.search_back);
        this.f5096v = inflate.findViewById(R.id.view_menu_bg);
        this.f5097w = inflate.findViewById(R.id.view_moments_bar);
        this.f5098x = inflate.findViewById(R.id.view_camera);
        this.f5049A = inflate.findViewById(R.id.superlike_star_container);
        this.f5050B = inflate.findViewById(R.id.superlike_star);
        this.f5051C = inflate.findViewById(R.id.superlike_star_legs);
        return inflate;
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        m7357a();
    }

    public void onResume() {
        m7280G();
        super.onResume();
        m7284K();
        m7293T();
        m7292S();
        getView().post(new Runnable() {
            final /* synthetic */ C2646k f5011a;

            {
                this.f5011a = r1;
            }

            public void run() {
                this.f5011a.m7291R();
                this.f5011a.m7382r();
            }
        });
    }

    public void setUserVisibleHint(boolean z) {
        if (z && this.ad != null) {
            this.ad.m6139S();
        }
        this.ac = z;
        super.setUserVisibleHint(z);
    }

    public void onPause() {
        m7281H();
        m7285L();
        super.onPause();
    }

    private void m7280G() {
        switch (this.f5076b.getCurrentItem()) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                Fragment c = this.f5063O.m6419c();
                if (c != null && (c instanceof C2720t)) {
                    C2720t c2720t = (C2720t) c;
                    if (!C2720t.f5332a) {
                        C2807a.m8058a("Recs.Start");
                    }
                }
            default:
        }
    }

    private void m7281H() {
        switch (this.f5076b.getCurrentItem()) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                Fragment c = this.f5063O.m6419c();
                if (c instanceof C2720t) {
                    C2720t c2720t = (C2720t) c;
                    if (!C2720t.f5332a) {
                        C2807a.m8058a("Recs.End");
                    }
                }
            default:
        }
    }

    public void m7357a() {
        C3095y.m9469a();
        this.f5069U = (ActivityMain) getActivity();
        this.f5070V = (int) getResources().getDimension(R.dimen.margin_med);
        this.aa = getResources().getDimensionPixelOffset(R.dimen.increased_ab_touch_target_side);
        this.f5075a.setX(this.f5079e.getX());
        this.f5063O = new C2357m(getChildFragmentManager());
        al.m9269a(this.f5076b, (int) HttpStatus.SC_BAD_REQUEST);
        this.f5076b.setOnPageChangeListener(this);
        this.f5076b.setAdapter(this.f5063O);
        this.f5076b.setOffscreenPageLimit(3);
        this.f5078d.setOnClickListener(this);
        this.f5096v.setOnClickListener(this);
        this.f5085k.setOnClickListener(this);
        this.f5082h.setOnClickListener(this);
        this.f5089o.setOnClickListener(this);
        this.f5092r.setOnClickListener(new OnClickListener() {
            final /* synthetic */ C2646k f5027a;

            {
                this.f5027a = r1;
            }

            public void onClick(View view) {
                C3095y.m9469a();
                this.f5027a.m7375k();
            }
        });
        this.f5095u.setOnClickListener(new OnClickListener() {
            final /* synthetic */ C2646k f5030a;

            {
                this.f5030a = r1;
            }

            public void onClick(View view) {
                this.f5030a.m7362a(true);
            }
        });
        this.f5093s.addTextChangedListener(new TextWatcher() {
            final /* synthetic */ C2646k f5031a;

            {
                this.f5031a = r1;
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(@NonNull Editable editable) {
                if (this.f5031a.f5062N) {
                    String obj = editable.toString();
                    C3095y.m9471a("search query is: " + obj);
                    if (TextUtils.isEmpty(obj)) {
                        C2668m b = this.f5031a.f5063O.m6418b();
                        if (b != null) {
                            b.m7469h();
                            return;
                        }
                        return;
                    }
                    this.f5031a.m7324d(obj);
                }
            }
        });
        al.m9287b(this.f5098x);
        m7286M();
        this.f5098x.setOnClickListener(new OnClickListener() {
            final /* synthetic */ C2646k f5032a;

            {
                this.f5032a = r1;
            }

            public void onClick(View view) {
                this.f5032a.startActivity(new Intent(this.f5032a.f5069U, CameraActivity.class));
            }
        });
        this.f5076b.post(new Runnable() {
            final /* synthetic */ C2646k f5033a;

            {
                this.f5033a = r1;
            }

            public void run() {
                this.f5033a.f5055G = this.f5033a.f5079e.getWidth();
                this.f5033a.f5056H = this.f5033a.f5081g.getWidth();
                this.f5033a.f5057I = this.f5033a.f5087m.getWidth();
                this.f5033a.f5058J = this.f5033a.f5069U.getResources().getDimensionPixelSize(R.dimen.flame_bubble_spacing);
                this.f5033a.f5075a.setX(this.f5033a.f5079e.getX());
                this.f5033a.f5059K = this.f5033a.f5086l.getX() - ((this.f5033a.f5081g.getX() + ((float) this.f5033a.f5056H)) + ((float) this.f5033a.f5058J));
                this.f5033a.f5060L = ((float) this.f5033a.f5087m.getWidth()) / ((float) this.f5033a.f5055G);
                C2646k.f5048z = ((float) this.f5033a.f5055G) * PeekStack.HEIGHT_PERCENT_OF_SCREEN;
                this.f5033a.f5061M = ((float) this.f5033a.f5057I) / ((float) this.f5033a.f5055G);
                this.f5033a.f5064P = (float) al.m9262a(this.f5033a.f5069U);
                this.f5033a.m7298a(0, 0.0f);
                this.f5033a.m7374j();
                this.f5033a.m7373i();
            }
        });
        this.f5074Z = new DecelerateInterpolator();
        if (C3077n.m9412e()) {
            this.f5098x.setOutlineProvider(new ViewOutlineProvider() {
                final /* synthetic */ C2646k f5034a;

                {
                    this.f5034a = r1;
                }

                @TargetApi(21)
                public void getOutline(@NonNull View view, @NonNull Outline outline) {
                    outline.setOval(0, 0, view.getWidth(), view.getHeight());
                }
            });
        }
    }

    public int m7363b() {
        C2684o d = this.f5063O.m6420d();
        if (d == null) {
            return -1;
        }
        return d.m7517a();
    }

    public int m7365c() {
        return this.f5076b.getCurrentItem();
    }

    public void m7367d() {
        m7362a(true);
        Fragment c = this.f5063O.m6419c();
        if (this.f5076b.getCurrentItem() == 0 && (c instanceof C2720t)) {
            C2807a.m8058a("Recs.End");
        }
    }

    public void m7372h() {
        Fragment c = this.f5063O.m6419c();
        if (this.f5076b == null || getActivity() == null) {
            C3095y.m9479c("Couldn't get page or activity on drawer closed");
        } else if (this.f5076b.getCurrentItem() == 0 && (c instanceof C2720t) && ((ActivityMain) getActivity()).m6216x() == 0) {
            C2807a.m8058a("Recs.Start");
        }
    }

    public void m7373i() {
    }

    private void m7305a(boolean z, @Nullable AnimatorListener animatorListener) {
        C3095y.m9469a();
        if (this.f5071W == null) {
            C3095y.m9471a("throbUntilCancelled=" + z);
            float f = 1.0f;
            if (this.f5076b.getCurrentItem() == 1) {
                f = this.f5060L;
            } else if (this.f5076b.getCurrentItem() == 2) {
                f = this.f5061M;
            }
            float f2 = 0.2f + f;
            this.f5071W = new ValueAnimator();
            this.f5071W.setDuration(500).setRepeatMode(2);
            this.f5071W.setRepeatCount(-1);
            this.f5071W.setFloatValues(new float[]{f, f2});
            this.f5071W.addUpdateListener(new AnimatorUpdateListener() {
                final /* synthetic */ C2646k f5036a;

                {
                    this.f5036a = r1;
                }

                public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                    this.f5036a.f5075a.scaleFromCenter(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            this.f5071W.start();
            if (animatorListener != null) {
                this.f5071W.addListener(animatorListener);
            }
            if (!z) {
                new Handler().postDelayed(new C26352(this), 4000);
            }
        }
    }

    private void m7282I() {
        C3095y.m9469a();
        if (m7283J()) {
            this.f5071W.cancel();
            this.f5071W = null;
            return;
        }
        C3095y.m9471a("Not throbbing");
    }

    private boolean m7283J() {
        return this.f5071W != null;
    }

    public void m7374j() {
        getView().post(new C26363(this));
    }

    private void m7324d(@Nullable String str) {
        if (str != null && str.trim().length() != 0) {
            if (C2646k.m7319c(str)) {
                m7290Q();
            } else {
                new C26374(this, str).execute((Void[]) null);
            }
        }
    }

    public void m7375k() {
        C3095y.m9469a();
        this.f5062N = true;
        this.f5076b.setPagingEnabled(false);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f5054F.put(this.f5078d, Float.valueOf(this.f5078d.getTranslationX()));
        this.f5054F.put(this.f5080f, Float.valueOf(this.f5080f.getTranslationX()));
        this.f5054F.put(this.f5081g, Float.valueOf(this.f5081g.getTranslationX()));
        this.f5054F.put(this.f5086l, Float.valueOf(this.f5086l.getTranslationX()));
        this.f5054F.put(this.f5087m, Float.valueOf(this.f5087m.getTranslationX()));
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f5078d, "translationX", new float[]{0.0f, (float) (-this.f5078d.getRight())});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f5080f, "translationX", new float[]{0.0f, (float) (-this.f5080f.getRight())});
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f5081g, "translationX", new float[]{0.0f, (float) (-this.f5081g.getRight())});
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f5086l, "translationX", new float[]{0.0f, (float) (-this.f5086l.getRight())});
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.f5087m, "translationX", new float[]{0.0f, (float) (-this.f5087m.getRight())});
        m7352B();
        this.f5075a.setVisibility(8);
        this.f5094t.setVisibility(0);
        float dimensionPixelOffset = (float) (al.m9263a(this.f5092r).x - getResources().getDimensionPixelOffset(R.dimen.margin_large));
        this.f5073Y = ObjectAnimator.ofFloat(this.f5092r, "translationX", new float[]{0.0f, -dimensionPixelOffset});
        animatorSet.addListener(new C26395(this));
        animatorSet.setDuration(160);
        animatorSet.setInterpolator(this.f5074Z);
        animatorSet.playTogether(new Animator[]{this.f5073Y, ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5});
        animatorSet.start();
    }

    public void m7362a(boolean z) {
        if (this.f5062N) {
            if (this.f5073Y != null) {
                this.f5073Y.cancel();
            }
            this.f5076b.setPagingEnabled(true);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f5078d, "translationX", new float[]{((Float) this.f5054F.get(this.f5078d)).floatValue()});
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f5080f, "translationX", new float[]{((Float) this.f5054F.get(this.f5080f)).floatValue()});
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f5081g, "translationX", new float[]{((Float) this.f5054F.get(this.f5081g)).floatValue()});
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f5086l, "translationX", new float[]{((Float) this.f5054F.get(this.f5086l)).floatValue()});
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.f5087m, "translationX", new float[]{((Float) this.f5054F.get(this.f5087m)).floatValue()});
            AnimatorSet animatorSet = new AnimatorSet();
            this.f5062N = false;
            this.f5093s.setText(BuildConfig.FLAVOR);
            this.f5093s.setVisibility(8);
            al.m9268a(this.f5093s.getWindowToken(), getActivity());
            this.f5095u.setVisibility(8);
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.f5092r, "translationX", new float[]{this.f5092r.getTranslationX(), 0.0f});
            if (z) {
                animatorSet.setDuration(160);
            } else {
                animatorSet.setDuration(0);
            }
            animatorSet.addListener(new C26416(this));
            animatorSet.setInterpolator(this.f5074Z);
            animatorSet.playTogether(new Animator[]{ofFloat6, ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5});
            animatorSet.start();
        }
    }

    public void m7376l() {
        C2357m c2357m = this.f5063O;
        if (C2357m.m6415a().equals("fragment recommendations")) {
            C2720t c2720t = (C2720t) this.f5063O.m6419c();
            if (c2720t != null) {
                c2720t.m7678d(false);
            }
        }
    }

    public boolean m7377m() {
        return this.f5052D;
    }

    public void m7378n() {
        if (!this.f5052D) {
            this.f5052D = true;
            this.f5051C.setAlpha(0.0f);
            this.f5051C.animate().alpha(1.0f).setDuration(200).setStartDelay(300).setListener(new C26427(this)).start();
            this.f5053E = C3045a.m9201a();
            this.f5053E.setVelocity(100.0d);
            this.f5053E.setSpringConfig(SpringConfig.fromBouncinessAndSpeed(13.0d, 17.0d));
            this.f5053E.addListener(new C26448(this));
            this.f5050B.setPivotX((float) this.f5050B.getWidth());
            this.f5050B.setPivotY(0.0f);
            this.f5053E.setCurrentValue(0.0d);
            this.f5053E.setEndValue(1.0d);
        }
    }

    public boolean m7379o() {
        return this.f5062N;
    }

    private void m7284K() {
        ManagerApp.m7925p().m8268a((ae) this);
        ManagerApp.m7926q().m8457a((aq) this);
        ManagerApp.m7924o().m8696a((bd) this);
        if (!(ManagerApp.m7913d() instanceof C2833d)) {
            return;
        }
        if (ManagerApp.m7913d().m8202b()) {
            C3095y.m9471a("Manager Location beat us to valid location, already set up for ping, setting flag for recs call.");
            this.ab = true;
            this.f5099y = null;
            return;
        }
        C3095y.m9471a("Setting ping callback to be notified when location is valid.");
        ManagerApp.m7913d().m8198a(this.f5099y);
    }

    private void m7285L() {
        ManagerApp.m7925p().m8280b((ae) this);
        ManagerApp.m7926q().m8469b((aq) this);
        ManagerApp.m7924o().m8709b((bd) this);
        if (this.f5099y != null) {
            ManagerApp.m7913d().m8201b(this.f5099y);
        }
    }

    public void m7380p() {
        this.f5076b.setCurrentItem(1);
    }

    public void m7381q() {
        Fragment c = this.f5063O.m6419c();
        if (c instanceof C2720t) {
            ((C2720t) c).m7690n();
        }
    }

    public void m7382r() {
        C3095y.m9469a();
        Fragment c = this.f5063O.m6419c();
        if (c == null && getActivity() != null) {
            Intent intent = new Intent(getActivity(), ActivityLogin.class);
            intent.setFlags(335544320);
            startActivity(intent);
        } else if (!ManagerApp.m7918i().m8775l()) {
            m7360a("discover off");
        } else if (ManagerApp.m7918i().m8776m()) {
            C3095y.m9471a("Settings have changed");
            ManagerApp.m7918i().m8771i(false);
            ManagerApp.m7924o().m8723j();
            if (this.ab) {
                C3095y.m9483d("Ping complete, making recs call");
                ManagerApp.m7924o().m8721h();
            }
            m7360a("fragment recommendations");
            if (((C2720t) c) != null) {
                ((C2720t) c).m7694r();
            }
        } else if (ManagerApp.m7918i().m8777n()) {
            ManagerApp.m7918i().m8772j(false);
            m7360a("fragment recommendations");
            if (((C2720t) c) != null) {
                ((C2720t) c).m7694r();
            }
            ManagerApp.m7924o().m8723j();
            ManagerApp.m7924o().m8712b(true);
        } else if (ManagerApp.m7924o().m8727n()) {
            C3095y.m9471a("Refresh: getting");
            m7360a("fragment recommendations");
            if (c != null) {
                ((C2720t) c).m7694r();
            }
        } else if (!ManagerApp.m7924o().m8726m()) {
            C3095y.m9471a("Refresh: available");
            m7360a("fragment recommendations");
            this.f5076b.post(new C26459(this));
        } else if (ManagerApp.m7924o().m8728o()) {
            C3095y.m9471a("Refresh: exhausted");
            m7360a("fragment recommendations");
            if (c != null) {
                ((C2720t) c).m7694r();
            }
        } else {
            C3095y.m9471a("Refresh: empty");
            m7360a("fragment recommendations");
            if (this.ab) {
                C3095y.m9483d("Ping complete, making recs call");
                ManagerApp.m7924o().m8721h();
            }
            if (c != null) {
                ((C2720t) c).m7694r();
            }
        }
    }

    public void m7383s() {
        C3095y.m9469a();
    }

    public void m7384t() {
        C3095y.m9469a();
        if (C2646k.m7313b(C2357m.m6415a())) {
            m7382r();
        }
    }

    public void m7385u() {
        C3095y.m9469a();
        if (C2646k.m7313b(C2357m.m6415a()) && ManagerApp.m7924o().m8722i() == 0 && ((C2720t) this.f5063O.m6419c()) != null) {
            ((C2720t) this.f5063O.m6419c()).m7695s();
        }
    }

    public void m7386v() {
    }

    public void m7361a(List<User> list) {
        C3095y.m9469a();
        if (getActivity() != null && !getActivity().isFinishing()) {
            C2357m c2357m = this.f5063O;
            if (C2646k.m7313b(C2357m.m6415a())) {
                m7360a("fragment recommendations");
                C2720t c2720t = (C2720t) this.f5063O.m6419c();
                if (c2720t != null) {
                    c2720t.m7696t();
                }
            }
        }
    }

    public void m7387w() {
        m7376l();
    }

    public void m7388x() {
        ManagerApp.m7911b().m8143d();
    }

    public void m7389y() {
        this.f5076b.post(new Runnable() {
            final /* synthetic */ C2646k f5009a;

            {
                this.f5009a = r1;
            }

            public void run() {
                this.f5009a.f5076b.setCurrentItem(2, true);
            }
        });
    }

    public void onPageScrolled(int i, float f, int i2) {
        m7298a(i, f);
    }

    public void onPageSelected(int i) {
        C3095y.m9471a("page=" + i);
        if (this.f5072X == 0) {
            C2807a.m8058a("Recs.End");
        }
        this.f5072X = i;
        if (i > 0) {
            Fragment c = this.f5063O.m6419c();
            if (c instanceof C2720t) {
                ((C2720t) c).m7702z();
            }
        }
        if (i == 0) {
            m7362a(false);
            new Handler().postDelayed(new Runnable() {
                final /* synthetic */ C2646k f5010a;

                {
                    this.f5010a = r1;
                }

                public void run() {
                    this.f5010a.m7298a(0, 0.0f);
                }
            }, 200);
            m7362a(false);
            m7310b(this.f5092r);
            C2807a.m8058a("Recs.Start");
            m7286M();
        } else if (i == 1) {
            C2807a.m8058a("Match.List");
            new Handler().postDelayed(new Runnable() {
                final /* synthetic */ C2646k f5012a;

                {
                    this.f5012a = r1;
                }

                public void run() {
                    this.f5012a.m7298a(0, 1.0f);
                }
            }, 200);
            if (this.f5063O.m6418b() != null) {
                this.f5063O.m6418b().m7470i();
            }
            m7287N();
            if (ManagerApp.m7925p().m8285b()) {
                m7299a(this.f5092r);
            }
        } else if (i == 2) {
            new Handler().postDelayed(new Runnable() {
                final /* synthetic */ C2646k f5013a;

                {
                    this.f5013a = r1;
                }

                public void run() {
                    this.f5013a.m7298a(1, 1.0f);
                }
            }, 200);
            m7362a(false);
            m7310b(this.f5092r);
            m7287N();
            this.f5076b.postDelayed(new Runnable() {
                final /* synthetic */ C2646k f5014a;

                {
                    this.f5014a = r1;
                }

                public void run() {
                    ManagerApp.m7926q().m8466a(true);
                }
            }, 300);
            C2807a.m8058a("Moments.Activity");
        }
        m7292S();
    }

    public void onPageScrollStateChanged(int i) {
        C3095y.m9471a("i=" + i);
        if (i == 1 || i == 2) {
            m7282I();
            m7288O();
            return;
        }
        m7289P();
    }

    private void m7298a(int i, float f) {
        if (i == 0) {
            m7297a(1.0f - f, this.f5064P);
            m7317c(f);
            m7327e(f);
            m7330f(f);
            m7338i(f);
            m7333g(f);
            m7336h(0.0f);
        } else if (i == 1) {
            getView().post(new AnonymousClass16(this, i, f));
        }
    }

    private void m7297a(float f, float f2) {
        this.f5097w.setTranslationX(f * f2);
    }

    private void m7317c(float f) {
        C3095y.m9471a("positionOffset=" + f);
        this.f5075a.setLength(C3077n.m9399a(f, 0.0f, (float) this.f5055G, 1.0f, (float) this.f5086l.getWidth()), false);
        float width = (float) (this.f5081g.getWidth() + this.f5058J);
        float a = C3077n.m9399a(f, 0.0f, 0.0f, 1.0f, width);
        C3095y.m9471a("diffBtweenIcons=" + width + ", offset=" + a);
        this.f5075a.setX(a + this.f5081g.getX());
    }

    private void m7323d(float f) {
        C3095y.m9471a("positionOffset=" + f);
        this.f5075a.setLength(C3077n.m9399a(f, 0.0f, (float) this.f5086l.getWidth(), 1.0f, (float) this.f5087m.getWidth()), false);
        float width = (float) (this.f5086l.getWidth() + this.f5058J);
        float a = C3077n.m9399a(f, 0.0f, 0.0f, 1.0f, width);
        C3095y.m9471a("diffBtweenIcons=" + width + ", offset=" + a);
        this.f5075a.setX(a + this.f5086l.getX());
    }

    private void m7327e(float f) {
        this.f5079e.setTranslationX(-C3077n.m9399a(f, 0.0f, 0.0f, 1.0f, f5048z));
        this.f5079e.setAlpha(Math.max(0.0f, C3077n.m9399a(f, 0.0f, 1.0f, 1.0f, 0.0f)));
    }

    private void m7330f(float f) {
        float a = C3077n.m9399a(f, 0.0f, 0.0f, 1.0f, 1.0f);
        if (a < 0.0f) {
            a = 0.0f;
        }
        this.f5082h.setAlpha(a);
        this.f5083i.setAlpha(1.0f - a);
        a = C3077n.m9399a(f, 0.1f, 0.02f * ((float) this.f5056H), 1.0f, 0.0f);
        float a2 = C3077n.m9399a(f, 0.1f, -(0.43f * ((float) this.f5056H)), 1.0f, 0.0f);
        this.f5081g.setTranslationX(a);
        this.f5081g.setTranslationY(a2);
        al.m9296c(this.f5081g, C3077n.m9399a(f, 0.0f, 0.27f, 1.0f, 1.0f));
    }

    private void m7333g(float f) {
        if (!al.m9276a()) {
            this.f5087m.setTranslationX(-C3077n.m9399a(f, 0.0f, 0.0f, 1.0f, this.f5059K));
        }
    }

    private void m7336h(float f) {
        float max = Math.max(0.0f, C3077n.m9399a(f, 0.0f, 1.0f, 1.0f, 0.0f));
        this.f5089o.setAlpha(max);
        this.f5091q.setAlpha(1.0f - max);
    }

    private void m7338i(float f) {
        m7342j(f);
        m7345k(f);
    }

    private void m7342j(float f) {
        float f2 = -C3077n.m9399a(f, 0.0f, 0.0f, 1.0f, this.f5059K);
        if (al.m9276a()) {
            LayoutParams layoutParams = (LayoutParams) this.f5086l.getLayoutParams();
            layoutParams.leftMargin = (int) (f2 + ((float) this.f5070V));
            this.f5086l.setLayoutParams(layoutParams);
            return;
        }
        this.f5086l.setTranslationX(f2);
    }

    private void m7345k(float f) {
        float max = Math.max(0.0f, C3077n.m9399a(f, 0.0f, 1.0f, 1.0f, 0.0f));
        this.f5085k.setAlpha(max);
        this.f5088n.setAlpha(1.0f - max);
    }

    public void m7390z() {
        this.f5076b.setCurrentItem(0, true);
    }

    private void m7299a(@NonNull View view) {
        view.setVisibility(0);
        view.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setInterpolator(new OvershootInterpolator()).setListener(new AnonymousClass17(this, view)).setDuration(250).start();
    }

    private void m7310b(@NonNull View view) {
        view.setVisibility(0);
        view.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setInterpolator(new AnticipateInterpolator()).setListener(new AnonymousClass18(this, view)).setDuration(250).start();
    }

    public void m7351A() {
        if (this.f5092r.getVisibility() != 0 && this.f5072X == 1) {
            m7299a(this.f5092r);
        }
    }

    private void m7286M() {
        if (al.m9276a()) {
            this.f5098x.setClickable(false);
            this.f5098x.setVisibility(8);
        }
    }

    private void m7287N() {
        if (al.m9276a()) {
            this.f5098x.setClickable(true);
            this.f5098x.setVisibility(0);
        }
    }

    private void m7288O() {
        try {
            al.m9272a(this.f5076b, true);
        } catch (NullPointerException e) {
            C3095y.m9479c(BuildConfig.FLAVOR + e);
        }
    }

    private void m7289P() {
        try {
            al.m9272a(this.f5076b, false);
        } catch (Throwable e) {
            C3095y.m9474a("Null pointer attempting to set disallow intercept touch event on pager", e);
        }
    }

    public void m7352B() {
        if (!this.f5065Q) {
            if (this.f5066R && this.f5068T != null) {
                this.f5068T.cancel();
            }
            this.f5065Q = true;
            this.f5067S = m7296a(this.f5097w, 250, this.f5097w.getTranslationY(), (float) this.f5097w.getHeight(), new bu() {
                final /* synthetic */ C2646k f5022a;

                {
                    this.f5022a = r1;
                }

                public void onAnimationEnd(Animator animator) {
                    this.f5022a.f5065Q = false;
                }
            });
        }
    }

    public void m7353C() {
        boolean b = ManagerApp.m7925p().m8285b();
        if (!this.f5066R && b) {
            if (this.f5065Q && this.f5067S != null) {
                this.f5067S.cancel();
            }
            this.f5066R = true;
            this.f5068T = m7296a(this.f5097w, 250, this.f5097w.getTranslationY(), 0.0f, new bu() {
                final /* synthetic */ C2646k f5024a;

                {
                    this.f5024a = r1;
                }

                public void onAnimationEnd(Animator animator) {
                    this.f5024a.f5066R = false;
                }
            });
        }
    }

    @NonNull
    private ObjectAnimator m7296a(View view, long j, float f, float f2, AnimatorListener animatorListener) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", new float[]{f, f2});
        ofFloat.setDuration(j);
        ofFloat.addListener(animatorListener);
        ofFloat.start();
        return ofFloat;
    }

    private void m7290Q() {
        al.m9268a(getView().getWindowToken(), getActivity());
        startActivity(new Intent(getActivity(), ActivityCredits.class));
    }

    public void m7358a(float f) {
        C3095y.m9471a("percentage pulled: " + f);
        if (m7283J()) {
            m7282I();
        }
        this.f5075a.scaleFromCenter((1.0f + (18.0f * f)) * this.f5060L);
        if (!al.m9276a()) {
            this.f5082h.setAlpha(0.2f);
            this.f5078d.setAlpha(0.2f);
            this.f5080f.setAlpha(0.2f);
            if (this.f5092r.getVisibility() == 0) {
                this.f5092r.setAlpha(0.2f);
            }
            if (this.f5088n.getAlpha() > 0.2f) {
                this.f5088n.setAlpha(0.2f);
            } else {
                this.f5085k.setAlpha(0.2f);
            }
            if (this.f5091q.getAlpha() > 0.2f) {
                this.f5091q.setAlpha(0.2f);
            } else {
                this.f5089o.setAlpha(0.2f);
            }
        }
    }

    public void m7354D() {
        C3095y.m9469a();
        if (m7283J()) {
            C3095y.m9471a("Already throbbing, so not animating refresh cancel");
            return;
        }
        float scaleFactor = this.f5075a.getScaleFactor();
        float f = this.f5072X == 0 ? 1.0f : this.f5060L;
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(400).setFloatValues(new float[]{scaleFactor, f});
        valueAnimator.addUpdateListener(new AnimatorUpdateListener() {
            final /* synthetic */ C2646k f5025a;

            {
                this.f5025a = r1;
            }

            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                this.f5025a.f5075a.scaleFromCenter(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        valueAnimator.start();
        if (!al.m9276a()) {
            this.f5082h.setAlpha(1.0f);
            this.f5078d.setAlpha(1.0f);
            this.f5080f.setAlpha(1.0f);
            if (this.f5092r.getVisibility() == 0) {
                this.f5092r.setAlpha(1.0f);
            }
            if (this.f5088n.getAlpha() >= 0.2f) {
                this.f5088n.setAlpha(1.0f);
            } else {
                this.f5085k.setAlpha(1.0f);
            }
            if (this.f5091q.getAlpha() >= 0.2f) {
                this.f5091q.setAlpha(1.0f);
            } else {
                this.f5089o.setAlpha(1.0f);
            }
        }
    }

    public void m7359a(@NonNull AnimatorListener animatorListener) {
        C3095y.m9469a();
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(400).setFloatValues(new float[]{this.f5060L});
        valueAnimator.addUpdateListener(new AnimatorUpdateListener() {
            final /* synthetic */ C2646k f5026a;

            {
                this.f5026a = r1;
            }

            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                C3095y.m9471a("Scaling from animateUnderline()");
                this.f5026a.f5075a.scaleFromCenter(floatValue);
            }
        });
        valueAnimator.setInterpolator(new OvershootInterpolator(1.0f));
        valueAnimator.addListener(new AnonymousClass24(this, animatorListener));
        valueAnimator.start();
    }

    public void m7355E() {
        m7291R();
        m7292S();
    }

    public void onClick(@NonNull View view) {
        switch (view.getId()) {
            case R.id.btn_main_logo:
                this.f5076b.setCurrentItem(0);
            case R.id.btn_main_flame:
                this.f5076b.setCurrentItem(0, true);
            case R.id.btn_main_matches:
                this.f5076b.setCurrentItem(1, true);
            case R.id.btn_main_moments:
                this.f5076b.setCurrentItem(2, true);
            case R.id.view_menu_bg:
            case R.id.btn_main_menu:
                if (!this.f5062N) {
                    ((ActivityMain) getActivity()).m6204l();
                }
            default:
        }
    }

    public void m7364b(boolean z) {
        if (!z) {
            if (ManagerApp.m7925p().m8285b()) {
                this.f5097w.setVisibility(0);
            } else {
                this.f5097w.setVisibility(8);
            }
        }
    }

    private void m7291R() {
        if (ManagerApp.m7925p().m8285b()) {
            this.f5097w.setVisibility(0);
        }
    }

    public void m7369e() {
    }

    public void m7370f() {
        m7293T();
    }

    public void m7371g() {
        m7293T();
    }

    private void m7292S() {
        if ((ManagerApp.m7925p().m8291f().size() > 0 ? 1 : 0) == 0 || this.f5072X == 1) {
            this.f5084j.setVisibility(4);
        } else {
            this.f5084j.setVisibility(0);
        }
    }

    private void m7293T() {
        int i = this.f5072X != 2 ? 1 : 0;
        int d = ManagerApp.m7926q().m8475d();
        C3095y.m9471a("num likes unseen: " + d);
        if (d <= 0 || i == 0) {
            this.f5090p.setVisibility(4);
        } else {
            this.f5090p.setVisibility(0);
        }
    }

    public void m7366c(boolean z) {
        C2720t c2720t = (C2720t) this.f5063O.m6419c();
        if (c2720t != null) {
            c2720t.m7680e(z);
        }
    }

    public void m7368d(boolean z) {
        C2720t c2720t = (C2720t) this.f5063O.m6419c();
        if (c2720t != null) {
            c2720t.m7682f(z);
        }
    }

    @Nullable
    public C2720t m7356F() {
        Fragment c = this.f5063O.m6419c();
        if (c instanceof C2720t) {
            return (C2720t) c;
        }
        return null;
    }

    public void m7360a(String str) {
        if (isVisible()) {
            this.f5063O.m6417a(str);
        } else {
            C3095y.m9479c("Attempted to change the main fragment when !isVisbile(). " + str);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        C3077n.m9404a(this, i, i2, intent);
    }
}
