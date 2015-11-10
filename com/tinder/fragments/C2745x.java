package com.tinder.fragments;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.graphics.Outline;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewOutlineProvider;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.NativeProtocol;
import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.stetho.BuildConfig;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tinder.R;
import com.tinder.activities.ActivityEditProfile;
import com.tinder.activities.ActivityMain;
import com.tinder.activities.ActivityMatch;
import com.tinder.activities.ActivityProfile;
import com.tinder.adapters.C2330c;
import com.tinder.adapters.C2370t;
import com.tinder.adapters.C2370t.C2369a;
import com.tinder.adapters.C2372u;
import com.tinder.dialogs.C2478e;
import com.tinder.dialogs.C2481f;
import com.tinder.dialogs.C2494n;
import com.tinder.dialogs.C2514q;
import com.tinder.dialogs.C2514q.C2512a;
import com.tinder.dialogs.C2514q.C2513b;
import com.tinder.dialogs.ac;
import com.tinder.dialogs.ae.C2460a;
import com.tinder.enums.Gender;
import com.tinder.enums.RateType;
import com.tinder.enums.ReportCause;
import com.tinder.enums.UserType;
import com.tinder.fragments.C2745x.11.C27321;
import com.tinder.fragments.C2745x.15.C27331;
import com.tinder.fragments.x.AnonymousClass11;
import com.tinder.fragments.x.AnonymousClass14;
import com.tinder.fragments.x.AnonymousClass15;
import com.tinder.managers.C2807a;
import com.tinder.managers.C2828c;
import com.tinder.managers.C2913k;
import com.tinder.managers.C2956n;
import com.tinder.managers.ManagerApp;
import com.tinder.model.ConnectionsGroup;
import com.tinder.model.InstagramDataSet;
import com.tinder.model.Match;
import com.tinder.model.PhotoUser;
import com.tinder.model.SparksEvent;
import com.tinder.model.User;
import com.tinder.model.UserMeta;
import com.tinder.p030d.C2430i;
import com.tinder.p030d.C2432m;
import com.tinder.p030d.bc;
import com.tinder.p030d.be;
import com.tinder.p030d.bf;
import com.tinder.p030d.bg;
import com.tinder.p030d.bq;
import com.tinder.p030d.bv;
import com.tinder.p032c.C2420b;
import com.tinder.p032c.C2421c;
import com.tinder.p032c.C2422d;
import com.tinder.p033e.C2557a;
import com.tinder.picassowebp.picasso.Picasso;
import com.tinder.utils.C3045a;
import com.tinder.utils.C3070i;
import com.tinder.utils.C3077n;
import com.tinder.utils.C3095y;
import com.tinder.utils.ah;
import com.tinder.utils.al;
import com.tinder.views.CustomButton;
import com.tinder.views.CustomTextView;
import com.tinder.views.InterestsView;
import com.tinder.views.OverScrollView;
import com.tinder.views.OverScrollView.OverScrollListener;
import com.tinder.views.PeekStack;
import com.tinder.views.SkippableViewPager;
import com.tinder.views.VerifiedBadgeView;
import com.viewpagerindicator.CirclePageIndicator;
import java.text.ParseException;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.http.HttpStatus;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.tinder.fragments.x */
public class C2745x extends DialogFragment implements OnPageChangeListener, OnClickListener, C2369a, be, bf, bq, C2432m, OverScrollListener {
    static final boolean f5433a;
    @Nullable
    private static ah f5434d;
    private CustomTextView f5435A;
    private ViewPager f5436B;
    private CustomTextView f5437C;
    private CustomButton f5438D;
    private C2370t f5439E;
    private C2330c f5440F;
    private CirclePageIndicator f5441G;
    private LinearLayout f5442H;
    private ProgressBar f5443I;
    private Handler f5444J;
    private int f5445K;
    private int f5446L;
    private boolean f5447M;
    private boolean f5448N;
    private boolean f5449O;
    private boolean f5450P;
    private boolean f5451Q;
    private boolean f5452R;
    private int f5453S;
    private int f5454T;
    private boolean f5455U;
    private View f5456V;
    private View f5457W;
    private View f5458X;
    private ImageView f5459Y;
    private ImageView f5460Z;
    @NonNull
    private String aa;
    private C2420b ab;
    private C2421c ac;
    private LinearLayout ad;
    private int ae;
    boolean f5461b;
    int f5462c;
    private TextView f5463e;
    private TextView f5464f;
    private TextView f5465g;
    private TextView f5466h;
    private TextView f5467i;
    private RelativeLayout f5468j;
    private InterestsView f5469k;
    private OverScrollView f5470l;
    private View f5471m;
    private View f5472n;
    private ImageView f5473o;
    private SkippableViewPager f5474p;
    private CirclePageIndicator f5475q;
    private View f5476r;
    private ac f5477s;
    @Nullable
    private C2494n f5478t;
    private bc f5479u;
    private C2372u f5480v;
    @Nullable
    private UserType f5481w;
    @Nullable
    private User f5482x;
    @Nullable
    private Match f5483y;
    private RelativeLayout f5484z;

    /* renamed from: com.tinder.fragments.x.14 */
    static /* synthetic */ class AnonymousClass14 {
        static final /* synthetic */ int[] f5410a;

        static {
            f5410a = new int[UserType.values().length];
            try {
                f5410a[UserType.REC.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5410a[UserType.MATCH.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5410a[UserType.ME.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* renamed from: com.tinder.fragments.x.1 */
    class C27341 extends ViewOutlineProvider {
        final /* synthetic */ C2745x f5417a;

        C27341(C2745x c2745x) {
            this.f5417a = c2745x;
        }

        public void getOutline(@NonNull View view, @NonNull Outline outline) {
            outline.setRect(0, 0, view.getWidth(), view.getHeight());
        }
    }

    /* renamed from: com.tinder.fragments.x.2 */
    class C27352 implements Runnable {
        final /* synthetic */ C2745x f5420a;

        C27352(C2745x c2745x) {
            this.f5420a = c2745x;
        }

        public void run() {
            if (this.f5420a.isVisible()) {
                this.f5420a.m7822g();
            }
        }
    }

    /* renamed from: com.tinder.fragments.x.3 */
    class C27373 implements Runnable {
        final /* synthetic */ boolean f5422a;
        final /* synthetic */ C2745x f5423b;

        /* renamed from: com.tinder.fragments.x.3.1 */
        class C27361 extends SimpleSpringListener {
            final /* synthetic */ C27373 f5421a;

            C27361(C27373 c27373) {
                this.f5421a = c27373;
            }

            public void onSpringUpdate(@NonNull Spring spring) {
                float currentValue = (float) spring.getCurrentValue();
                if (spring.isOvershooting() && C2745x.f5433a) {
                    this.f5421a.f5423b.f5468j.animate().translationZ(0.0f).setDuration(90).start();
                    if (this.f5421a.f5423b.f5455U) {
                        this.f5421a.f5423b.f5476r.animate().translationZ(0.0f).setDuration(90).start();
                    }
                }
                this.f5421a.f5423b.f5473o.setTranslationY(C3077n.m9399a(currentValue, 0.0f, (float) C2745x.f5434d.f6536d, 1.0f, 0.0f));
                al.m9296c(this.f5421a.f5423b.f5473o, C3077n.m9399a(currentValue, 0.0f, C2745x.f5434d.f6540h, 1.0f, 1.0f));
                this.f5421a.f5423b.f5468j.setTranslationY(C3077n.m9399a(currentValue, 0.0f, C2745x.f5434d.f6541i, 1.0f, 0.0f));
                this.f5421a.f5423b.f5468j.setAlpha(currentValue);
                if (this.f5421a.f5423b.f5455U) {
                    this.f5421a.f5423b.f5476r.setTranslationY((1.0f - currentValue) * C2745x.f5434d.f6539g);
                }
                if (this.f5421a.f5423b.f5456V != null) {
                    this.f5421a.f5423b.f5456V.setTranslationX(((float) (-this.f5421a.f5423b.f5462c)) * (1.0f - currentValue));
                    this.f5421a.f5423b.f5456V.setRotation(BitmapDescriptorFactory.HUE_CYAN * currentValue);
                }
                if (this.f5421a.f5422a) {
                    this.f5421a.f5423b.f5457W.setTranslationY(100.0f * (1.0f - currentValue));
                } else if (this.f5421a.f5423b.f5482x.isSuperLike()) {
                    this.f5421a.f5423b.f5472n.setAlpha(1.0f - currentValue);
                }
                if (this.f5421a.f5423b.f5458X != null) {
                    this.f5421a.f5423b.f5458X.setTranslationX(((float) this.f5421a.f5423b.f5462c) * (1.0f - currentValue));
                    this.f5421a.f5423b.f5458X.setRotation((1.0f - currentValue) * BitmapDescriptorFactory.HUE_CYAN);
                }
            }

            public void onSpringAtRest(Spring spring) {
                this.f5421a.f5423b.f5475q.animate().alpha(1.0f).setDuration(90).setInterpolator(new DecelerateInterpolator()).start();
                this.f5421a.f5423b.m7768b(true);
                this.f5421a.f5423b.f5474p.setVisibility(0);
                this.f5421a.f5423b.f5470l.setBackgroundColor(-1);
                this.f5421a.f5423b.f5447M = false;
            }

            public void onSpringActivate(Spring spring) {
                if (this.f5421a.f5423b.f5479u != null) {
                    this.f5421a.f5423b.f5479u.m6703a();
                }
                this.f5421a.f5423b.m7768b(false);
                if (this.f5421a.f5423b.f5456V != null) {
                    this.f5421a.f5423b.f5456V.setVisibility(0);
                }
                if (this.f5421a.f5423b.f5458X != null) {
                    this.f5421a.f5423b.f5458X.setVisibility(0);
                }
                if (this.f5421a.f5423b.m7787l()) {
                    this.f5421a.f5423b.f5457W.setVisibility(0);
                }
            }
        }

        C27373(C2745x c2745x, boolean z) {
            this.f5423b = c2745x;
            this.f5422a = z;
        }

        public void run() {
            Spring a = C3045a.m9201a();
            a.setCurrentValue(0.0d);
            a.setVelocity(6.5d);
            a.setRestDisplacementThreshold(0.0010000000474974513d);
            a.setSpringConfig(SpringConfig.fromOrigamiTensionAndFriction(36.0d, 7.0d));
            a.addListener(new C27361(this));
            a.setEndValue(1.0d);
        }
    }

    /* renamed from: com.tinder.fragments.x.4 */
    class C27384 implements AnimatorUpdateListener {
        final /* synthetic */ boolean f5424a;
        final /* synthetic */ C2745x f5425b;

        C27384(C2745x c2745x, boolean z) {
            this.f5425b = c2745x;
            this.f5424a = z;
        }

        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            if (C2745x.f5434d != null) {
                this.f5425b.f5473o.setTranslationY(((float) C2745x.f5434d.f6536d) * animatedFraction);
                al.m9296c(this.f5425b.f5473o, C3077n.m9399a(animatedFraction, 0.0f, 1.0f, 1.0f, C2745x.f5434d.f6540h));
                this.f5425b.f5468j.setTranslationY(C2745x.f5434d.f6541i * animatedFraction);
                if (this.f5425b.f5455U) {
                    this.f5425b.f5476r.setTranslationY(C2745x.f5434d.f6539g * animatedFraction);
                }
            }
            this.f5425b.f5475q.setAlpha(1.0f - animatedFraction);
            if (this.f5425b.f5456V != null) {
                this.f5425b.f5456V.setTranslationX(((float) (-this.f5425b.f5462c)) * animatedFraction);
                this.f5425b.f5456V.setRotation(-180.0f * animatedFraction);
            }
            if (this.f5424a) {
                this.f5425b.f5457W.setTranslationY(100.0f * animatedFraction);
            } else if (this.f5425b.f5482x != null && this.f5425b.f5482x.isSuperLike()) {
                this.f5425b.f5472n.setAlpha(animatedFraction);
            }
            if (this.f5425b.f5458X != null) {
                this.f5425b.f5458X.setTranslationX(((float) this.f5425b.f5462c) * animatedFraction);
                this.f5425b.f5458X.setRotation(animatedFraction * BitmapDescriptorFactory.HUE_CYAN);
            }
        }
    }

    /* renamed from: com.tinder.fragments.x.5 */
    class C27395 extends bv {
        final /* synthetic */ Runnable f5426a;
        final /* synthetic */ C2745x f5427b;

        C27395(C2745x c2745x, Runnable runnable) {
            this.f5427b = c2745x;
            this.f5426a = runnable;
        }

        @SuppressLint({"NewApi"})
        public void onAnimationStart(Animator animator) {
            this.f5427b.f5479u.m6706b();
            this.f5427b.f5470l.setBackgroundColor(0);
            this.f5427b.m7768b(false);
            this.f5427b.f5474p.setVisibility(4);
            if (this.f5427b.f5480v.getCount() > 1) {
                this.f5427b.f5475q.setVisibility(0);
            }
            if (C2745x.f5433a && C2745x.f5434d != null) {
                this.f5427b.f5468j.setTranslationZ(C2745x.f5434d.f6542j);
                if (this.f5427b.f5455U) {
                    this.f5427b.f5476r.setTranslationZ(C2745x.f5434d.f6544l);
                }
            }
        }

        public void onAnimationEnd(Animator animator) {
            this.f5427b.f5447M = false;
            if (this.f5426a != null) {
                this.f5426a.run();
            }
        }
    }

    /* renamed from: com.tinder.fragments.x.6 */
    class C27406 implements C2430i {
        final /* synthetic */ C2745x f5428a;

        C27406(C2745x c2745x) {
            this.f5428a = c2745x;
        }

        public void m7741a(View view) {
            SparksEvent sparksEvent = new SparksEvent("SuperLikeTutorial.Select");
            sparksEvent.put("from", Integer.valueOf(2));
            sparksEvent.put(NativeProtocol.WEB_DIALOG_ACTION, Integer.valueOf(1));
            C2807a.m8056a(sparksEvent);
        }

        public void m7742b(View view) {
            this.f5428a.m7789m();
            SparksEvent sparksEvent = new SparksEvent("SuperLikeTutorial.Select");
            sparksEvent.put("from", Integer.valueOf(2));
            sparksEvent.put(NativeProtocol.WEB_DIALOG_ACTION, Integer.valueOf(2));
            C2807a.m8056a(sparksEvent);
        }
    }

    /* renamed from: com.tinder.fragments.x.7 */
    class C27417 implements C2460a {
        final /* synthetic */ C2745x f5429a;

        C27417(C2745x c2745x) {
            this.f5429a = c2745x;
        }

        public void m7743a(View view) {
        }

        public void m7744b(View view) {
            ((ActivityMain) this.f5429a.getActivity()).launchPlusSubscriptionPaywall(4);
        }

        public void m7745c(View view) {
        }
    }

    /* renamed from: com.tinder.fragments.x.8 */
    class C27428 implements Runnable {
        final /* synthetic */ C2745x f5430a;

        C27428(C2745x c2745x) {
            this.f5430a = c2745x;
        }

        public void run() {
            this.f5430a.dismiss();
        }
    }

    /* renamed from: com.tinder.fragments.x.9 */
    class C27449 implements OnKeyListener {
        final /* synthetic */ C2745x f5432a;

        /* renamed from: com.tinder.fragments.x.9.1 */
        class C27431 implements Runnable {
            final /* synthetic */ C27449 f5431a;

            C27431(C27449 c27449) {
                this.f5431a = c27449;
            }

            public void run() {
                this.f5431a.f5432a.dismiss();
            }
        }

        C27449(C2745x c2745x) {
            this.f5432a = c2745x;
        }

        public boolean onKey(DialogInterface dialogInterface, int i, @NonNull KeyEvent keyEvent) {
            if (i != 4 || keyEvent.getAction() != 1) {
                return false;
            }
            this.f5432a.m7812a(new C27431(this));
            return true;
        }
    }

    public C2745x() {
        this.f5452R = true;
        this.aa = "key_ig_photo_index";
        this.f5461b = ManagerApp.m7914e().at();
    }

    static {
        f5433a = C3077n.m9412e();
    }

    @NonNull
    public static C2745x m7751a(@Nullable User user, UserType userType) {
        C2745x c2745x = new C2745x();
        Bundle bundle = new Bundle();
        bundle.putSerializable("user", user);
        bundle.putSerializable("userType", userType);
        c2745x.setArguments(bundle);
        return c2745x;
    }

    @NonNull
    public static C2745x m7750a(@Nullable User user, bc bcVar, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        C2745x c2745x = new C2745x();
        Bundle bundle = new Bundle();
        bundle.putSerializable("user", user);
        bundle.putSerializable("userType", UserType.REC);
        bundle.putSerializable("imgW", Integer.valueOf(i4));
        c2745x.setArguments(bundle);
        int dimensionPixelSize = ManagerApp.m7917h().getResources().getDimensionPixelSize(R.dimen.actionbar_size);
        int a = (int) al.m9260a(1.0f);
        ah ahVar = new ah();
        ahVar.f6533a = i4;
        ahVar.f6534b = i5;
        ahVar.f6535c = i2;
        ahVar.f6536d = i3;
        ahVar.f6541i = al.m9283b(1.0f) - ((float) a);
        ahVar.f6540h = ((float) ahVar.f6533a) / ((float) a);
        ahVar.f6544l = 2.0f;
        ahVar.f6543k = 2.0f;
        ahVar.f6542j = 40.0f;
        ahVar.f6537e = i6;
        ahVar.f6538f = i7;
        ahVar.f6539g = ((float) (-dimensionPixelSize)) - ahVar.f6544l;
        c2745x.m7761a(ahVar);
        c2745x.m7766b(i);
        c2745x.m7754a(bcVar);
        return c2745x;
    }

    private void m7766b(int i) {
        this.f5445K = i;
        this.ae = i;
    }

    private void m7754a(bc bcVar) {
        this.f5479u = bcVar;
    }

    private void m7761a(@Nullable ah ahVar) {
        if (ahVar != null) {
            f5434d = ahVar;
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f5462c = al.m9262a((Context) activity) / 3;
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.f5444J = new Handler(Looper.getMainLooper());
        return layoutInflater.inflate(R.layout.view_fragment_profile, viewGroup, false);
    }

    @SuppressLint({"NewApi"})
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        if (UserType.ME == this.f5481w && C3077n.m9412e()) {
            view.setOutlineProvider(new C27341(this));
            view.setTranslationZ(26.0f);
            view.setClipToOutline(false);
        }
        this.f5446L = (int) al.m9260a(1.0f);
        this.f5480v = new C2372u(getActivity());
        this.f5480v.m6466a((OnClickListener) this);
        this.f5474p = (SkippableViewPager) view.findViewById(R.id.profile_image_pager);
        LayoutParams layoutParams = this.f5474p.getLayoutParams();
        layoutParams.width = this.f5446L;
        layoutParams.height = this.f5446L;
        this.f5474p.setLayoutParams(layoutParams);
        this.f5474p.setAdapter(this.f5480v);
        this.f5474p.setOnClickListener(this);
        this.f5475q = (CirclePageIndicator) view.findViewById(R.id.profile_images_indicator);
        this.f5475q.m9494a(this.f5474p, this.f5445K);
        this.f5475q.setOnPageChangeListener(this);
        this.f5471m = view.findViewById(R.id.mock_image_background);
        this.f5473o = (ImageView) view.findViewById(R.id.profile_mock_image);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f5473o.getLayoutParams();
        layoutParams2.width = this.f5446L;
        layoutParams2.height = this.f5446L;
        this.f5473o.setLayoutParams(layoutParams2);
        this.f5470l = (OverScrollView) view.findViewById(R.id.profile_scrollview);
        this.f5470l.setOverScrollListener(this);
        this.f5468j = (RelativeLayout) view.findViewById(R.id.profile_layout_content);
        this.f5466h = (TextView) view.findViewById(R.id.profile_text_name);
        this.f5467i = (TextView) view.findViewById(R.id.profile_text_age);
        this.f5463e = (TextView) view.findViewById(R.id.profile_text_bio);
        this.f5465g = (TextView) view.findViewById(R.id.profile_text_active);
        this.f5464f = (TextView) view.findViewById(R.id.profile_text_location);
        this.f5469k = (InterestsView) view.findViewById(R.id.profile_interests_view);
        this.f5440F = new C2330c(view.getContext());
        this.f5460Z = (ImageView) view.findViewById(R.id.img_profile_superlike);
        this.f5472n = view.findViewById(R.id.profile_mock_star);
        UserType userType = this.f5481w;
        UserType userType2 = this.f5481w;
        boolean z = (userType == UserType.REC && this.f5461b) ? false : true;
        this.f5455U = z;
        ViewStub viewStub;
        if (this.f5455U) {
            viewStub = (ViewStub) view.findViewById(R.id.profile_actionbar_stub);
            viewStub.setOnInflateListener(new OnInflateListener() {
                final /* synthetic */ C2745x f5408a;

                {
                    this.f5408a = r1;
                }

                public void onInflate(ViewStub viewStub, @NonNull View view) {
                    this.f5408a.m7753a(view);
                }
            });
            UserType userType3 = this.f5481w;
            UserType userType4 = this.f5481w;
            viewStub.setLayoutResource(userType3 == UserType.REC ? R.layout.profile_rec_actionbar : R.layout.profile_me_actionbar);
            if (UserType.MATCH == this.f5481w) {
                viewStub.setVisibility(8);
                this.f5470l.setPadding(0, 0, 0, 0);
            } else {
                viewStub.setVisibility(0);
            }
            this.f5459Y = (ImageView) view.findViewById(R.id.profile_btn_overflow);
            this.f5459Y.setVisibility(8);
        } else {
            viewStub = (ViewStub) view.findViewById(R.id.profile_gamepad_stub);
            viewStub.setOnInflateListener(new OnInflateListener() {
                final /* synthetic */ C2745x f5412a;

                /* renamed from: com.tinder.fragments.x.15.1 */
                class C27331 extends ViewOutlineProvider {
                    final /* synthetic */ AnonymousClass15 f5411a;

                    C27331(AnonymousClass15 anonymousClass15) {
                        this.f5411a = anonymousClass15;
                    }

                    public void getOutline(View view, Outline outline) {
                        outline.setOval(0, 0, view.getWidth(), view.getHeight());
                    }
                }

                {
                    this.f5412a = r1;
                }

                public void onInflate(ViewStub viewStub, View view) {
                    this.f5412a.ad = (LinearLayout) view.findViewById(R.id.profile_buttons_container);
                    this.f5412a.f5456V = this.f5412a.ad.findViewById(R.id.profile_btn_pass);
                    this.f5412a.f5458X = this.f5412a.ad.findViewById(R.id.profile_btn_like);
                    this.f5412a.f5457W = this.f5412a.ad.findViewById(R.id.profile_btn_superlike);
                    if (C3077n.m9412e()) {
                        ViewOutlineProvider c27331 = new C27331(this);
                        this.f5412a.f5456V.setOutlineProvider(c27331);
                        this.f5412a.f5458X.setOutlineProvider(c27331);
                        this.f5412a.f5457W.setOutlineProvider(c27331);
                    }
                    this.f5412a.f5456V.setOnClickListener(this.f5412a);
                    this.f5412a.f5458X.setOnClickListener(this.f5412a);
                    this.f5412a.f5457W.setOnClickListener(this.f5412a);
                    this.f5412a.f5456V.setVisibility(4);
                    this.f5412a.f5458X.setVisibility(4);
                    this.f5412a.f5457W.setVisibility(4);
                    this.f5412a.m7785k();
                }
            });
            viewStub.setLayoutResource(R.layout.profile_rec_gamepad_buttons);
            viewStub.setVisibility(0);
            this.f5470l.setPadding(0, 0, 0, 0);
            ((ViewStub) view.findViewById(R.id.profile_actionbar_stub)).setVisibility(8);
            this.f5459Y = (ImageView) view.findViewById(R.id.profile_btn_overflow);
            this.f5459Y.setColorFilter(getResources().getColor(R.color.orange));
            this.f5459Y.setOnClickListener(this);
            C3045a.m9203a(this.f5457W, 1.0f, (float) PeekStack.HEIGHT_PERCENT_OF_SCREEN, 200, 200);
            C3045a.m9203a(this.f5456V, 1.0f, (float) PeekStack.HEIGHT_PERCENT_OF_SCREEN, 200, 200);
            C3045a.m9203a(this.f5458X, 1.0f, (float) PeekStack.HEIGHT_PERCENT_OF_SCREEN, 200, 200);
        }
        this.f5484z = (RelativeLayout) view.findViewById(R.id.profile_layout_instagram);
        this.f5435A = (CustomTextView) view.findViewById(R.id.profile_instagram_photo_count);
        this.f5437C = (CustomTextView) view.findViewById(R.id.instagram_share_textview);
        this.f5438D = (CustomButton) view.findViewById(R.id.instagram_login_button);
        this.f5436B = (ViewPager) view.findViewById(R.id.instagram_viewpager);
        this.f5442H = (LinearLayout) view.findViewById(R.id.instagram_photo_placeholder);
        this.f5443I = (ProgressBar) view.findViewById(R.id.progress_fetch);
        this.f5441G = (CirclePageIndicator) view.findViewById(R.id.instagram_indicator);
        this.f5439E = new C2370t(getActivity(), this);
        this.f5438D.setOnClickListener(this);
        this.ac = new C2422d() {
            final /* synthetic */ C2745x f5413a;

            {
                this.f5413a = r1;
            }

            public void m7738f() {
                if (this.f5413a.f5481w == UserType.MATCH) {
                    C3095y.m9471a("launching instagram login with parentFragment");
                    ManagerApp.m7930u().m8493a(this.f5413a.getParentFragment());
                    return;
                }
                C3095y.m9471a("launching instagram login with FragmentRecommendations");
                ManagerApp.m7930u().m8493a(this.f5413a.getParentFragment().getParentFragment());
            }

            public void m7739h() {
                new C2481f(this.f5413a.getActivity(), this.f5413a.ab).show();
            }

            public void m7740j() {
                new C2478e(this.f5413a.getActivity()).show();
            }

            public void m7737a(String str) {
                C3095y.m9471a("showInstagramLoggedIn:" + str);
                this.f5413a.f5437C.setVisibility(8);
                this.f5413a.f5438D.setVisibility(8);
            }
        };
        this.ab = new C2557a(this.ac, ManagerApp.m7911b());
        m7811a(this.f5482x);
        this.f5438D.setWidth((al.m9262a(getActivity()) - ((int) al.m9284b((float) BitmapDescriptorFactory.HUE_YELLOW, getActivity()))) / 3);
    }

    public void onResume() {
        int i = 1;
        super.onResume();
        if (UserType.REC == this.f5481w && this.f5449O) {
            C2807a.m8058a("Recs.Start");
        } else if (UserType.REC == this.f5481w && this.f5482x != null) {
            SparksEvent sparksEvent = new SparksEvent("Recs.ProfileOpen");
            sparksEvent.put("otherId", this.f5482x.getId());
            if (!TextUtils.isEmpty(this.f5482x.getNearByLocationName())) {
                i = 2;
            }
            sparksEvent.put("location", Integer.valueOf(i));
            C3095y.m9471a("analytics location value: " + i);
            InstagramDataSet instagramDataSet = this.f5482x.getInstagramDataSet();
            if (instagramDataSet != null) {
                if (!TextUtils.isEmpty(this.f5482x.getInstagramDataSet().getUserName())) {
                    sparksEvent.put("instagramName", instagramDataSet.getUserName());
                }
                if (this.f5482x.getInstagramDataSet().getMediaCount() != 0) {
                    sparksEvent.put("photoTotal", Integer.valueOf(instagramDataSet.getMediaCount()));
                }
            }
            sparksEvent.put("didSuperLike", Boolean.valueOf(this.f5482x.isSuperLike()));
            C2807a.m8056a(sparksEvent);
        } else if (UserType.ME == this.f5481w) {
            UserMeta c = ManagerApp.m7911b().m8142c();
            if (!(c == null || this.f5482x == null)) {
                InstagramDataSet instagramDataSet2 = c.getInstagramDataSet();
                String str = "FragmentProfileView onResume photosize: %d";
                Object[] objArr = new Object[1];
                if (instagramDataSet2 != null) {
                    i = instagramDataSet2.getInstagramPhotos().size();
                } else {
                    i = 0;
                }
                objArr[0] = Integer.valueOf(i);
                C3095y.m9471a(String.format(str, objArr));
                this.f5482x.setInstagramDataSet(instagramDataSet2);
            }
            C2807a.m8058a("Profile.View");
        }
        if (!this.f5450P) {
            return;
        }
        if (this.f5451Q) {
            this.f5451Q = false;
        } else {
            new Handler().postDelayed(new Runnable() {
                final /* synthetic */ C2745x f5414a;

                {
                    this.f5414a = r1;
                }

                public void run() {
                    this.f5414a.m7822g();
                }
            }, 500);
        }
    }

    public void onPause() {
        C3095y.m9471a("onPause");
        if (UserType.REC == this.f5481w && this.f5482x != null) {
            if (this.f5448N) {
                SparksEvent sparksEvent = new SparksEvent("Recs.ProfileClose");
                sparksEvent.put("otherId", this.f5482x.getId());
                sparksEvent.put("didSuperLike", Boolean.valueOf(this.f5482x.isSuperLike()));
                C2807a.m8056a(sparksEvent);
            } else {
                this.f5449O = true;
                C2807a.m8058a("Recs.End");
            }
        }
        this.f5454T = this.f5436B.getCurrentItem();
        this.f5450P = true;
        super.onPause();
    }

    private void m7753a(@NonNull View view) {
        this.f5476r = view.findViewById(R.id.profile_actionbar);
        TextView textView = (TextView) this.f5476r.findViewById(R.id.profile_txt_title);
        ImageButton imageButton = (ImageButton) this.f5476r.findViewById(R.id.profile_img_icon);
        this.f5476r.findViewById(R.id.profile_btn_back).setOnClickListener(this);
        textView.setOnClickListener(this);
        if (imageButton != null) {
            imageButton.setOnClickListener(this);
        }
        if (this.f5482x != null) {
            textView.setText(this.f5482x.getName());
        } else if (this.f5483y != null) {
            textView.setText(this.f5483y.getName());
        }
        if (UserType.REC == this.f5481w) {
            View findViewById = this.f5476r.findViewById(R.id.profile_btn_pass);
            View findViewById2 = this.f5476r.findViewById(R.id.profile_btn_like);
            View findViewById3 = this.f5476r.findViewById(R.id.profile_btn_overflow);
            findViewById.setOnClickListener(this);
            findViewById2.setOnClickListener(this);
            findViewById3.setOnClickListener(this);
            C3045a.m9202a(1.0f, (float) PeekStack.HEIGHT_PERCENT_OF_SCREEN, 200, 200, findViewById, findViewById2);
            this.f5444J.post(new Runnable() {
                final /* synthetic */ C2745x f5415a;

                {
                    this.f5415a = r1;
                }

                public void run() {
                    this.f5415a.m7785k();
                }
            });
        } else if (UserType.ME == this.f5481w) {
            this.f5476r.findViewById(R.id.profile_btn_edit).setOnClickListener(this);
        }
    }

    public void m7816a(boolean z) {
        this.f5452R = z;
        if (getView() != null) {
            getView().findViewById(R.id.verified_badge).setVisibility(z ? 0 : 8);
        }
    }

    private void m7772c(int i) {
        if (this.f5482x != null && this.f5482x.getInstagramPhotos() != null && !this.f5482x.getInstagramPhotos().isEmpty()) {
            C3095y.m9471a("has instagram photos");
            this.f5436B.setCurrentItem(this.f5439E.m6459a(i));
        }
    }

    public void m7817b() {
        if (this.f5482x == null) {
            C3095y.m9479c("Cannot set user text because user object is null!");
            return;
        }
        this.f5466h.setText(String.format("%s, ", new Object[]{this.f5482x.getName()}));
        this.f5467i.setText(this.f5482x.getAge());
        CharSequence trim = this.f5482x.getBio().trim();
        if (TextUtils.isEmpty(trim)) {
            this.f5463e.setVisibility(8);
        } else {
            this.f5463e.setMaxEms(HttpStatus.SC_INTERNAL_SERVER_ERROR);
            this.f5463e.setText(trim);
            this.f5463e.setVisibility(0);
        }
        if (UserType.ME == this.f5481w) {
            this.f5464f.setVisibility(8);
            this.f5465g.setVisibility(8);
        } else if (TextUtils.isEmpty(this.f5482x.getNearByLocationName())) {
            int distance = this.f5482x.getDistance(ManagerApp.m7918i());
            if (distance > 0) {
                trim = new SpannableString(getResources().getQuantityString(ManagerApp.m7918i().m8763e() ? R.plurals.distance_units_away_mi : R.plurals.distance_units_away_km, distance, new Object[]{Integer.valueOf(distance)}));
            } else {
                trim = new SpannableString(getString(R.string.small_distance_away));
            }
            this.f5464f.setText(trim);
        } else {
            this.f5464f.setText(this.f5482x.getNearByLocation(getResources()));
        }
        String str = BuildConfig.FLAVOR;
        try {
            Date parse = C3070i.m9369b().parse(this.f5482x.getLastActivityDate());
            if (parse.getTime() > System.currentTimeMillis()) {
                parse = new Date(System.currentTimeMillis());
            }
            str = C3070i.getRelativeTimeSpanString(parse.getTime()).toString();
        } catch (ParseException e) {
            C3095y.m9479c(e.toString());
        }
        this.f5465g.setText(getString(this.f5482x.getGender() == Gender.MALE ? R.string.active_male : R.string.active_female) + ' ' + str);
        CharSequence travelLocationName = this.f5482x.getTravelLocationName();
        if (this.f5482x.isRecAndPassporting() && !TextUtils.isEmpty(travelLocationName) && getView() != null) {
            TextView textView = (TextView) getView().findViewById(R.id.profile_txt_swiping_in);
            textView.setVisibility(0);
            textView.setText(getString(R.string.swiping_in, travelLocationName));
        }
    }

    public void m7815a(@NonNull List<String> list) {
        int i;
        if (C3077n.m9408a((Collection) list)) {
            C3095y.m9472a("fragment view profile", "Profile is missing the image!");
        } else {
            Picasso.m8982a(getActivity()).m8990a((String) list.get(0)).m9124a(this.f5473o);
        }
        CirclePageIndicator circlePageIndicator = this.f5475q;
        if (list.size() < 2) {
            i = 8;
        } else {
            i = 0;
        }
        circlePageIndicator.setVisibility(i);
        this.f5480v.m6467a((List) list);
        this.f5474p.setCurrentItem(this.f5445K, false);
    }

    public void m7818c() {
        if (this.f5482x == null || getView() == null) {
            C3095y.m9479c("Attempted to set interests with either a null user or a null view");
            return;
        }
        int size = this.f5482x.getUncommonInterests().size() + this.f5482x.getCommonInterests().size();
        TextView textView = (TextView) getView().findViewById(R.id.profile_interests_title_txt);
        if (size == 0) {
            textView.setVisibility(8);
            this.f5469k.setVisibility(8);
            getView().findViewById(R.id.profile_interests_title_txt).setVisibility(8);
            getView().findViewById(R.id.profile_interests_view).setVisibility(8);
            getView().findViewById(R.id.profile_divider_instagram).setVisibility(8);
            return;
        }
        textView.setText(getResources().getQuantityString(R.plurals.interests_plural, size, new Object[]{Integer.valueOf(size)}));
        this.f5469k.setUser(this.f5482x);
        this.f5469k.setVisibility(0);
        textView.setVisibility(0);
        getView().findViewById(R.id.profile_interests_title_txt).setVisibility(0);
        getView().findViewById(R.id.profile_interests_view).setVisibility(0);
        getView().findViewById(R.id.profile_divider_instagram).setVisibility(0);
    }

    public void m7819d() {
        if (this.f5482x == null) {
            C3095y.m9479c("Attempted to set connections with a null user");
            return;
        }
        int numConnections = this.f5482x.getNumConnections();
        boolean ar = ManagerApp.m7914e().ar();
        ConnectionsGroup connections = this.f5482x.getConnections();
        View view = getView();
        if (view != null) {
            TextView textView = (TextView) view.findViewById(R.id.profile_connections_title);
            if (UserType.ME == this.f5481w) {
                textView.setText(getResources().getQuantityString(R.plurals.friends_for_common_connections_plural, numConnections, new Object[]{Integer.valueOf(numConnections)}));
                ((TextView) view.findViewById(R.id.profile_my_connections_detail_text)).setVisibility(0);
                view.findViewById(R.id.profile_divider_bio).setVisibility(0);
                view.findViewById(R.id.profile_layout_connections).setVisibility(0);
            } else if (numConnections <= 0) {
                C2913k.m8576a(this.f5482x.getId(), (C2432m) this);
            } else if (ar && connections == null) {
                C2913k.m8576a(this.f5482x.getId(), (C2432m) this);
            } else if (connections != null && connections.needsFill()) {
                C2828c.m8156a(connections, this.f5440F.m6370a(), (C2432m) this);
            } else if (connections != null) {
                int size = connections.getCompleteConnections().size();
                textView.setText(getResources().getQuantityString(R.plurals.common_connections_plural, numConnections, new Object[]{Integer.valueOf(numConnections)}));
                this.f5440F.m6372a(connections.getCompleteConnections());
                this.f5440F.m6371a(600);
                ViewPager viewPager = (ViewPager) view.findViewById(R.id.profile_connections_viewpager);
                viewPager.setVisibility(0);
                viewPager.setAdapter(this.f5440F);
                viewPager.setPageMargin(getResources().getDimensionPixelSize(R.dimen.padding_large));
                if (size > this.f5440F.m6373b()) {
                    CirclePageIndicator circlePageIndicator = (CirclePageIndicator) view.findViewById(R.id.profile_connections_indicator);
                    circlePageIndicator.setVisibility(0);
                    circlePageIndicator.setViewPager(viewPager);
                }
                view.findViewById(R.id.profile_divider_bio).setVisibility(0);
                view.findViewById(R.id.profile_layout_connections).setVisibility(0);
                viewPager.setCurrentItem(0, false);
            }
        }
    }

    protected void m7822g() {
        if (this.f5482x != null) {
            int i;
            int i2;
            C3095y.m9471a("setInstagram");
            int i3 = UserType.ME == this.f5481w ? 1 : 0;
            if (TextUtils.isEmpty(ManagerApp.m7914e().ap())) {
                i = 0;
            } else {
                i = 1;
            }
            this.f5436B.setVisibility(0);
            this.f5442H.setVisibility(8);
            m7783j();
            List instagramPhotos = this.f5482x.getInstagramPhotos();
            C3095y.m9471a("setInstagram photosize: " + instagramPhotos.size());
            this.f5441G.setVisibility(instagramPhotos.size() < this.f5439E.m6461b() * this.f5439E.m6462c() ? 8 : 0);
            if (i3 == 0 && instagramPhotos.size() != 0 && i == 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (i2 != 0) {
                this.f5437C.setVisibility(0);
                this.f5438D.setVisibility(0);
            } else {
                this.f5437C.setVisibility(8);
                this.f5438D.setVisibility(8);
            }
            if (!(i3 == 0 && C3077n.m9408a((Collection) instagramPhotos)) && (i3 == 0 || i != 0)) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            if (i3 != 0) {
                this.f5484z.setVisibility(8);
                return;
            }
            this.f5484z.setVisibility(0);
            i3 = this.f5482x.getInstagramDataSet() != null ? this.f5482x.getInstagramDataSet().getMediaCount() : 0;
            if (instagramPhotos.isEmpty()) {
                this.f5436B.setVisibility(8);
                this.f5442H.setVisibility(0);
                i = (this.f5482x == null || this.f5482x.getInstagramDataSet() == null || !TextUtils.isEmpty(this.f5482x.getInstagramDataSet().getLastFetchTime()) || i == 0) ? 0 : 1;
                if (i != 0) {
                    this.f5435A.setText(R.string.instagram_photos_title);
                    this.f5443I.setVisibility(0);
                    return;
                }
                this.f5435A.setText(String.format(getResources().getQuantityString(R.plurals.instagram_photos_plural, i3), new Object[]{Integer.valueOf(i3)}));
                this.f5443I.setVisibility(8);
                this.f5442H.setVisibility(0);
                if (getView() != null) {
                    getView().findViewById(R.id.profile_divider_connections).setVisibility(0);
                    return;
                }
                return;
            }
            this.f5443I.setVisibility(8);
            this.f5436B.setVisibility(0);
            this.f5436B.setAdapter(this.f5439E);
            this.f5436B.setCurrentItem(this.f5454T);
            m7783j();
            this.f5441G.setOnPageChangeListener(new SimpleOnPageChangeListener() {
                final /* synthetic */ C2745x f5416a;

                {
                    this.f5416a = r1;
                }

                public void onPageSelected(int i) {
                    boolean z = true;
                    if (this.f5416a.f5481w != UserType.ME && this.f5416a.f5454T != i) {
                        int i2 = this.f5416a.f5454T > i ? 2 : 1;
                        if (i + 1 != this.f5416a.f5439E.getCount()) {
                            z = false;
                        }
                        SparksEvent sparksEvent = null;
                        if (this.f5416a.f5481w == UserType.REC) {
                            sparksEvent = new SparksEvent("Recs.ProfileInstagramPage");
                        } else if (this.f5416a.f5481w == UserType.MATCH) {
                            sparksEvent = new SparksEvent("Chat.ProfileInstagramPage");
                        }
                        if (sparksEvent == null) {
                            C3095y.m9479c("Event not sent, user type was neither match nor rec");
                            return;
                        }
                        sparksEvent.put("direction", Integer.valueOf(i2));
                        sparksEvent.put("pageNumber", Integer.valueOf(i));
                        sparksEvent.put("endOfPhotos", Boolean.valueOf(z));
                        sparksEvent.put("otherId", this.f5416a.f5482x.getId());
                        sparksEvent.put("instagramName", this.f5416a.f5482x.getInstagramDataSet().getUserName());
                        C2807a.m8056a(sparksEvent);
                    }
                }
            });
            if (getActivity() != null) {
                this.f5435A.setText(String.format(getResources().getQuantityString(R.plurals.instagram_photos_plural, i3), new Object[]{Integer.valueOf(i3)}));
            }
            this.f5439E.m6460a(instagramPhotos);
            this.f5436B.setAdapter(this.f5439E);
            this.f5436B.setCurrentItem(this.f5454T);
            this.f5441G.m9494a(this.f5436B, 0);
            this.f5436B.setCurrentItem(this.f5454T);
            m7783j();
            this.f5443I.setVisibility(8);
            this.f5436B.setVisibility(0);
            if (getView() != null) {
                getView().findViewById(R.id.profile_divider_connections).setVisibility(0);
            }
        }
    }

    private void m7783j() {
        int a = this.f5439E.m6458a();
        if (a != 0) {
            LayoutParams layoutParams = this.f5436B.getLayoutParams();
            layoutParams.height = a;
            this.f5436B.setLayoutParams(layoutParams);
        }
    }

    public void m7811a(@Nullable User user) {
        int i = 0;
        int i2 = UserType.ME == this.f5481w ? 600 : 0;
        this.f5482x = user;
        if (user != null && getView() != null) {
            int i3;
            VerifiedBadgeView verifiedBadgeView = (VerifiedBadgeView) getView().findViewById(R.id.verified_badge);
            verifiedBadgeView.displayBadge(user);
            if (this.f5452R) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            verifiedBadgeView.setVisibility(i3);
            m7815a(this.f5482x.getAvatarUrlsForSize(al.m9265a(getActivity())));
            m7817b();
            if (this.f5461b && this.f5481w != UserType.ME) {
                boolean isSuperLike;
                if (this.f5481w == UserType.REC) {
                    isSuperLike = this.f5482x.isSuperLike();
                } else if (this.f5481w != UserType.MATCH || this.f5483y == null) {
                    isSuperLike = false;
                } else {
                    isSuperLike = this.f5483y.isSuperlike();
                }
                ImageView imageView = this.f5460Z;
                if (!isSuperLike) {
                    i = 8;
                }
                imageView.setVisibility(i);
            }
            this.f5444J.postDelayed(new Runnable() {
                final /* synthetic */ C2745x f5418a;

                {
                    this.f5418a = r1;
                }

                public void run() {
                    this.f5418a.m7819d();
                }
            }, (long) i2);
            this.f5444J.postDelayed(new Runnable() {
                final /* synthetic */ C2745x f5419a;

                {
                    this.f5419a = r1;
                }

                public void run() {
                    if (this.f5419a.isVisible()) {
                        this.f5419a.m7818c();
                    }
                }
            }, (long) i2);
            this.f5444J.postDelayed(new C27352(this), (long) i2);
        }
    }

    public void m7810a(@NonNull Match match) {
        this.f5483y = match;
        m7815a(match.getPerson().getAvatarUrlsForSize(al.m9265a(getActivity())));
        this.f5466h.setText(match.getName());
    }

    private void m7775d(int i) {
        C2807a.m8058a("Profile.Edit");
        Intent intent = new Intent(getActivity(), ActivityEditProfile.class);
        intent.addFlags(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        intent.putExtra("instagramConnectValue", i);
        startActivityForResult(intent, 1);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        C3095y.m9471a(String.format("onActivityResult: requestCode[%s] responseCode[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        if (i == 1) {
            this.f5451Q = true;
            this.f5482x = ManagerApp.m7922m().m8599d();
            UserMeta c = ManagerApp.m7911b().m8142c();
            if (!(c == null || this.f5482x == null)) {
                InstagramDataSet instagramDataSet = c.getInstagramDataSet();
                String str = "FragmentProfileView onResume photosize: %d";
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(instagramDataSet != null ? instagramDataSet.getInstagramPhotos().size() : 0);
                C3095y.m9471a(String.format(str, objArr));
                this.f5482x.setInstagramDataSet(instagramDataSet);
            }
            this.f5480v.m6468a(true);
            m7811a(this.f5482x);
        } else if (i != 7) {
        } else {
            if (i2 == -1) {
                String stringExtra = intent.getStringExtra("access_code");
                if (TextUtils.isEmpty(stringExtra)) {
                    C2807a.m8056a(new SparksEvent("Account.InstagramLoginFail"));
                    this.ac.m6622h();
                    return;
                }
                this.ab.m6616a(stringExtra);
                return;
            }
            C3095y.m9471a("Instagram Login error: code empty");
            C2807a.m8056a(new SparksEvent("Account.InstagramLoginFail"));
            this.ac.m6622h();
        }
    }

    private void m7755a(RateType rateType) {
        if (!this.f5447M) {
            m7790n();
            this.f5479u.m6705a(rateType);
        }
    }

    @SuppressLint({"NewApi"})
    private void m7785k() {
        boolean l = m7787l();
        if (!this.f5447M && f5434d != null) {
            this.f5447M = true;
            this.f5470l.setBackgroundColor(0);
            this.f5474p.setVisibility(4);
            m7768b(true);
            if (this.f5482x != null && this.f5482x.isSuperLike()) {
                this.f5472n.setVisibility(0);
            }
            al.m9296c(this.f5471m, f5434d.f6540h);
            this.f5475q.setAlpha(0.0f);
            int applyDimension = (int) TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics());
            this.f5473o.setTranslationY((float) f5434d.f6536d);
            this.f5471m.setTranslationY((float) (applyDimension + f5434d.f6536d));
            al.m9296c(this.f5473o, f5434d.f6540h);
            this.f5468j.setTranslationY(f5434d.f6541i);
            if (this.f5455U) {
                this.f5476r.setTranslationY(f5434d.f6539g);
            }
            if (f5433a) {
                this.f5473o.setTranslationZ(f5434d.f6543k);
                if (this.f5455U) {
                    this.f5476r.setTranslationZ(f5434d.f6544l);
                }
                this.f5468j.setTranslationZ(f5434d.f6542j);
            }
            this.f5472n.setY((float) f5434d.f6538f);
            this.f5472n.setX((float) f5434d.f6537e);
            if (getView() != null) {
                getView().postDelayed(new C27373(this, l), 50);
            }
        }
    }

    private boolean m7787l() {
        return (this.f5457W == null || this.f5482x == null || this.f5482x.isSuperLike() || !this.f5461b || this.f5482x.isBrand()) ? false : true;
    }

    private void m7768b(boolean z) {
        int i;
        int i2 = 4;
        ImageView imageView = this.f5473o;
        if (z) {
            i = 4;
        } else {
            i = 0;
        }
        imageView.setVisibility(i);
        View view = this.f5471m;
        if (!z) {
            i2 = 0;
        }
        view.setVisibility(i2);
    }

    public void m7812a(@Nullable Runnable runnable) {
        if (!this.f5447M) {
            boolean l = m7787l();
            if (getActivity() instanceof ActivityProfile) {
                getActivity().finish();
                return;
            }
            this.f5447M = true;
            this.f5470l.smoothScrollTo(0, 0);
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
            valueAnimator.setDuration(310);
            valueAnimator.setInterpolator(new AnticipateInterpolator(1.45f));
            valueAnimator.setStartDelay((long) (this.f5470l.getScrollY() / 230));
            valueAnimator.addUpdateListener(new C27384(this, l));
            valueAnimator.addListener(new C27395(this, runnable));
            valueAnimator.start();
            this.f5479u.m6704a(this.f5474p.getCurrentItem());
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageSelected(int i) {
        Object obj = 1;
        Picasso.m8982a(ManagerApp.m7917h()).m8990a((String) this.f5480v.m6465a().get(i)).m9124a(this.f5473o);
        SparksEvent sparksEvent;
        if (UserType.MATCH == this.f5481w && this.f5483y != null) {
            if (this.f5483y.getPerson() == null || this.f5483y.getPerson().getPhotos() == null || i >= this.f5483y.getPerson().getPhotos().size()) {
                obj = null;
            }
            if (obj != null) {
                sparksEvent = new SparksEvent("Chat.PhotoView");
                sparksEvent.put("otherId", this.f5483y.getPerson().getId());
                sparksEvent.put("photoId", ((PhotoUser) this.f5483y.getPerson().getPhotos().get(i)).getPhotoId());
                C2807a.m8056a(sparksEvent);
            }
        } else if (UserType.REC == this.f5481w) {
            Object obj2 = (this.f5482x == null || i >= this.f5482x.getPhotos().size()) ? null : 1;
            if (!(obj2 == null || this.f5482x == null || i >= this.f5482x.getPhotos().size())) {
                sparksEvent = new SparksEvent("Recs.PhotoView");
                sparksEvent.put("otherId", this.f5482x.getId());
                sparksEvent.put("photoId", ((PhotoUser) this.f5482x.getPhotos().get(i)).getPhotoId());
                sparksEvent.put("didSuperLike", Boolean.valueOf(this.f5482x.isSuperLike()));
                C2807a.m8056a(sparksEvent);
            }
            this.ae = i;
        }
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onClick(@NonNull View view) {
        switch (view.getId()) {
            case R.id.profile_btn_back:
            case R.id.profile_img_icon:
            case R.id.profile_txt_title:
                m7790n();
            case R.id.profile_btn_edit:
                m7775d(1);
            case R.id.profile_btn_pass:
                m7755a(RateType.PASS);
            case R.id.profile_btn_like:
                m7755a(RateType.LIKE);
            case R.id.profile_btn_overflow:
                if (!this.f5447M && !al.m9297c(this.f5478t)) {
                    View view2;
                    Context activity = getActivity();
                    if (this.f5461b) {
                        view2 = this.f5459Y;
                    } else {
                        view2 = null;
                    }
                    this.f5478t = new C2494n(activity, this, null, view2);
                    this.f5478t.show();
                }
            case R.id.profile_btn_superlike:
                if (ManagerApp.m7914e().m8803G()) {
                    m7789m();
                } else {
                    m7823h();
                }
            case R.id.instagram_login_button:
                if (this.f5481w != null) {
                    switch (AnonymousClass14.f5410a[this.f5481w.ordinal()]) {
                        case C3374b.SmoothProgressBar_spb_color /*1*/:
                            this.ab.m6615a(3);
                        case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                            this.ab.m6615a(2);
                        default:
                            this.ab.m6615a(1);
                    }
                }
            case R.id.profile_page_image:
                m7790n();
            default:
        }
    }

    public void m7823h() {
        C2700s c2700s = new C2700s();
        c2700s.m7552a(new C27406(this));
        c2700s.show(getChildFragmentManager(), "superlikeReminder");
        ManagerApp.m7914e().m8865p(true);
        SparksEvent sparksEvent = new SparksEvent("SuperLikeTutorial.View");
        sparksEvent.put("from", Integer.valueOf(2));
        C2807a.m8056a(sparksEvent);
    }

    private void m7789m() {
        if (ManagerApp.m7924o().m8720g().getRemaining() < 1) {
            ((ActivityMain) getActivity()).m6190a(this.f5482x, this.ae, new C27417(this), null);
        } else {
            m7755a(RateType.SUPERLIKE);
        }
    }

    private void m7790n() {
        FragmentActivity activity = getActivity();
        if (this.f5481w == null) {
            C3095y.m9479c("Not reporting any exit callbacks because we don't know what kind of user we had");
            return;
        }
        switch (AnonymousClass14.f5410a[this.f5481w.ordinal()]) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                onCancel(getDialog());
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                if (activity instanceof ActivityMatch) {
                    ((ActivityMatch) activity).m6228w();
                }
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                if (activity instanceof ActivityMain) {
                    ((ActivityMain) activity).m6215w();
                }
            default:
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f5481w = (UserType) arguments.getSerializable("userType");
        this.f5482x = (User) arguments.getSerializable("user");
        if (bundle != null) {
            this.f5453S = bundle.getInt(this.aa);
        }
    }

    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        return new Dialog(getActivity(), R.style.Theme.FloatingDialog.NoDim);
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.f5448N = true;
        if (UserType.REC == this.f5481w) {
            m7812a(new C27428(this));
        } else {
            super.onCancel(dialogInterface);
        }
    }

    public void onStart() {
        super.onStart();
        if (UserType.REC == this.f5481w) {
            Dialog dialog = getDialog();
            if (dialog != null) {
                dialog.getWindow().setLayout(-1, -1);
                dialog.setOnKeyListener(new C27449(this));
            }
        }
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        bundle.putInt(this.aa, this.f5453S);
        super.onSaveInstanceState(bundle);
    }

    public void m7820e() {
        this.f5477s = C2956n.m8743a(getActivity(), new bg() {
            final /* synthetic */ C2745x f5405a;

            {
                this.f5405a = r1;
            }

            public void m7734a(@NonNull ReportCause reportCause, String str) {
                this.f5405a.m7756a(reportCause, str);
            }
        }, null);
        this.f5477s.show();
    }

    public void m7821f() {
    }

    private void m7756a(@NonNull ReportCause reportCause, String str) {
        if (this.f5482x == null) {
            C3095y.m9479c("Not reporting user becauser user is null");
        } else {
            ManagerApp.m7929t().m8749a(reportCause, str, this.f5482x.getId(), this);
        }
    }

    public void m7814a(String str, @NonNull ReportCause reportCause, @Nullable String str2) {
        SparksEvent sparksEvent = new SparksEvent("Recs.Report");
        sparksEvent.put("otherId", str);
        sparksEvent.put("reason", reportCause.getAnalyticsValue());
        if (str2 != null) {
            sparksEvent.put(FacebookRequestErrorClassification.KEY_OTHER, str2);
        }
        C2807a.m8056a(sparksEvent);
        new Timer().schedule(new TimerTask() {
            final /* synthetic */ C2745x f5407a;

            /* renamed from: com.tinder.fragments.x.11.1 */
            class C27321 implements Runnable {
                final /* synthetic */ AnonymousClass11 f5406a;

                C27321(AnonymousClass11 anonymousClass11) {
                    this.f5406a = anonymousClass11;
                }

                public void run() {
                    this.f5406a.f5407a.f5477s.m6828n();
                }
            }

            {
                this.f5407a = r1;
            }

            public void run() {
                this.f5407a.f5444J.post(new C27321(this));
            }
        }, 2500);
    }

    public void m7813a(String str) {
        Toast.makeText(getActivity(), R.string.reported_warning_accept_agreement_error, 0).show();
        if (this.f5477s != null) {
            this.f5477s.m6829o();
        }
    }

    public void onOverScroll(double d) {
        C3095y.m9471a("overscroll " + d);
        if (d >= 0.0d) {
            this.f5474p.setPivotX((float) (this.f5446L / 2));
            this.f5474p.setPivotY((float) this.f5446L);
            al.m9296c(this.f5474p, C3077n.m9399a((float) d, 0.0f, 1.0f, 1.0f, (((float) this.f5470l.getOverScrollMax()) / ((float) this.f5446L)) + 1.0f));
            this.f5475q.setAlpha((float) (1.0d - d));
        }
    }

    public void m7808a(@NonNull View view, int i) {
        C3095y.m9471a("onPhotoClick FragmentViewProfile");
        SparksEvent sparksEvent;
        if (this.f5481w == UserType.REC && this.f5482x != null) {
            sparksEvent = new SparksEvent("Recs.ProfileInstagramSelect");
            sparksEvent.put("photoIndex", view.getTag());
            sparksEvent.put("otherId", this.f5482x.getId());
            sparksEvent.put("instagramName", this.f5482x.getInstagramDataSet().getUserName());
            C2807a.m8056a(sparksEvent);
        } else if (this.f5481w == UserType.MATCH && this.f5482x != null) {
            sparksEvent = new SparksEvent("Chat.ProfileInstagramSelect");
            sparksEvent.put("photoIndex", view.getTag());
            sparksEvent.put("otherId", this.f5482x.getId());
            sparksEvent.put("instagramName", this.f5482x.getInstagramDataSet().getUserName());
            C2807a.m8056a(sparksEvent);
        }
        C2513b b = m7765b(view);
        if (this.f5482x != null) {
            new C2514q(getActivity(), ((Integer) view.getTag()).intValue(), i, this.f5482x.getInstagramDataSet(), b, this.f5482x.getId(), this.f5481w, new C2512a() {
                final /* synthetic */ C2745x f5409a;

                {
                    this.f5409a = r1;
                }

                public void m7736a(int i) {
                    this.f5409a.f5453S = i;
                    this.f5409a.m7772c(this.f5409a.f5453S);
                }

                public void m7735a() {
                    if (this.f5409a.f5481w != UserType.ME) {
                        SparksEvent sparksEvent = null;
                        if (this.f5409a.f5481w == UserType.REC) {
                            sparksEvent = new SparksEvent("Recs.OpenInstagram");
                        } else if (this.f5409a.f5481w == UserType.MATCH) {
                            sparksEvent = new SparksEvent("Chat.OpenInstagram");
                        }
                        if (sparksEvent != null) {
                            sparksEvent.put("from", Integer.valueOf(2));
                            sparksEvent.put("otherId", this.f5409a.f5482x.getId());
                            sparksEvent.put("instagramName", this.f5409a.f5482x.getInstagramDataSet().getUserName());
                            C2807a.m8056a(sparksEvent);
                        } else {
                            return;
                        }
                    }
                    if (this.f5409a.f5482x.getInstagramDataSet() != null) {
                        this.f5409a.m7752a(this.f5409a.getActivity(), this.f5409a.f5482x.getInstagramDataSet().getUserName());
                    }
                }
            }).show();
        }
    }

    public void m7806a() {
        if (!(this.f5481w == UserType.ME || this.f5482x == null)) {
            SparksEvent sparksEvent = null;
            if (this.f5481w == UserType.REC) {
                sparksEvent = new SparksEvent("Recs.OpenInstagram");
            } else if (this.f5481w == UserType.MATCH) {
                sparksEvent = new SparksEvent("Chat.OpenInstagram");
            }
            if (sparksEvent != null) {
                sparksEvent.put("from", Integer.valueOf(1));
                sparksEvent.put("otherId", this.f5482x.getId());
                sparksEvent.put("instagramName", this.f5482x.getInstagramDataSet().getUserName());
                C2807a.m8056a(sparksEvent);
            } else {
                return;
            }
        }
        if (this.f5482x != null && this.f5482x.getInstagramDataSet() != null) {
            m7752a(getActivity(), this.f5482x.getInstagramDataSet().getUserName());
        }
    }

    private void m7752a(@NonNull Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://instagram.com/_u/" + str));
        intent.setFlags(268435456);
        intent.setPackage("com.instagram.android");
        if (m7762a(context, intent)) {
            context.startActivity(intent);
            return;
        }
        intent = new Intent("android.intent.action.VIEW", Uri.parse("http://instagram.com/" + str));
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private boolean m7762a(@NonNull Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST).size() > 0;
    }

    public void m7809a(ConnectionsGroup connectionsGroup, int i) {
        if (this.f5482x == null) {
            C3095y.m9479c("Connections load finished before user was set.");
        } else if (1 == i) {
            this.f5482x.setConnections(connectionsGroup);
            m7819d();
        } else if (i == 0) {
            ConnectionsGroup connections = this.f5482x.getConnections();
            if (connections != null && !connections.getUnbuiltConnections().isEmpty()) {
                C2828c.m8156a(connections, this.f5440F.m6370a(), (C2432m) this);
            }
        }
    }

    public void m7807a(int i) {
        if (1 == i) {
            if (this.f5482x != null) {
                ConnectionsGroup connections = this.f5482x.getConnections();
                if (connections != null) {
                    connections.setIgnoreUnresolvableIds(true);
                }
            }
            m7819d();
        }
    }

    @NonNull
    private C2513b m7765b(@NonNull View view) {
        C2513b c2513b = new C2513b();
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        int i = rect.left;
        int c = this.f5481w == UserType.REC ? rect.top + al.m9293c(getActivity()) : rect.top;
        int b = this.f5439E.m6461b();
        int c2 = this.f5439E.m6462c();
        int d = this.f5439E.m6463d();
        c2513b.m6906a((float) view.getWidth());
        c2513b.m6909b((float) view.getHeight());
        c2513b.m6912c((float) i);
        c2513b.m6914d((float) c);
        c2513b.m6916e((float) al.m9293c(getActivity()));
        c2513b.m6907a(b);
        c2513b.m6910b(c2);
        c2513b.m6918f((float) d);
        return c2513b;
    }

    public void m7804E() {
        C3095y.m9469a();
        onActivityResult(1, -1, null);
    }

    public void m7805F() {
    }
}
