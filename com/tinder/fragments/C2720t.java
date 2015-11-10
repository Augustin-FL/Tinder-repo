package com.tinder.fragments;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.graphics.Point;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.facebook.internal.NativeProtocol;
import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.stetho.BuildConfig;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tinder.R;
import com.tinder.activities.ActivityMain;
import com.tinder.dialogs.C2493m;
import com.tinder.dialogs.C2542x;
import com.tinder.dialogs.ae.C2460a;
import com.tinder.enums.ConfirmationType;
import com.tinder.enums.PhotoSizeUser;
import com.tinder.enums.RateType;
import com.tinder.enums.SwipeType;
import com.tinder.fragments.C2720t.12.C27041;
import com.tinder.fragments.C2720t.13.C27061;
import com.tinder.fragments.C2720t.14.C27081;
import com.tinder.fragments.C2720t.18.C27091;
import com.tinder.fragments.C2720t.33.C27121;
import com.tinder.fragments.t.AnonymousClass10;
import com.tinder.fragments.t.AnonymousClass11;
import com.tinder.fragments.t.AnonymousClass12;
import com.tinder.fragments.t.AnonymousClass13;
import com.tinder.fragments.t.AnonymousClass14;
import com.tinder.fragments.t.AnonymousClass16;
import com.tinder.fragments.t.AnonymousClass17;
import com.tinder.fragments.t.AnonymousClass18;
import com.tinder.fragments.t.AnonymousClass19;
import com.tinder.fragments.t.AnonymousClass25;
import com.tinder.fragments.t.AnonymousClass30;
import com.tinder.fragments.t.AnonymousClass31;
import com.tinder.fragments.t.AnonymousClass33;
import com.tinder.fragments.t.AnonymousClass34;
import com.tinder.fragments.t.AnonymousClass35;
import com.tinder.fragments.t.AnonymousClass36;
import com.tinder.fragments.t.AnonymousClass37;
import com.tinder.fragments.t.AnonymousClass39;
import com.tinder.managers.C2807a;
import com.tinder.managers.C2958p;
import com.tinder.managers.ManagerApp;
import com.tinder.model.ConnectionsGroup;
import com.tinder.model.GlobalConfig;
import com.tinder.model.Match;
import com.tinder.model.Paywall;
import com.tinder.model.PhotoUser;
import com.tinder.model.ProcessedPhoto;
import com.tinder.model.SparksEvent;
import com.tinder.model.SuperlikeStatus;
import com.tinder.model.User;
import com.tinder.model.UserMeta;
import com.tinder.p030d.C2424a;
import com.tinder.p030d.C2425e;
import com.tinder.p030d.C2430i;
import com.tinder.p030d.C2437v;
import com.tinder.p030d.C2438x;
import com.tinder.p030d.ab;
import com.tinder.p030d.ad;
import com.tinder.p030d.ah;
import com.tinder.p030d.at;
import com.tinder.p030d.bc;
import com.tinder.p030d.bj;
import com.tinder.p030d.bk;
import com.tinder.p030d.bl;
import com.tinder.p030d.bo;
import com.tinder.p030d.bu;
import com.tinder.p030d.bv;
import com.tinder.utils.C3045a;
import com.tinder.utils.C3077n;
import com.tinder.utils.C3095y;
import com.tinder.utils.af;
import com.tinder.utils.al;
import com.tinder.views.CustomTextView;
import com.tinder.views.LikeMeter;
import com.tinder.views.LikeMeter.AssetMode;
import com.tinder.views.LoadingView;
import com.tinder.views.PeekStack;
import com.tinder.views.RangeSeekBar;
import com.tinder.views.RecCard;
import com.tinder.views.RecCard.CardMode;
import com.tinder.views.StackLayout;
import java.util.ArrayList;

/* renamed from: com.tinder.fragments.t */
public class C2720t extends Fragment implements OnClickListener, C2424a, ad, ah, at, C2425e, C2437v {
    public static boolean f5332a;
    private static boolean f5333c;
    private boolean f5334A;
    private boolean f5335B;
    private boolean f5336C;
    private boolean f5337D;
    @Nullable
    private bc f5338E;
    private CardMode f5339F;
    private C2757z f5340G;
    private FragmentAnchoredPopup f5341H;
    private FragmentAnchoredPopup f5342I;
    private int f5343J;
    private CustomTextView f5344K;
    private boolean f5345L;
    private boolean f5346M;
    private boolean f5347N;
    private boolean f5348O;
    private boolean f5349P;
    private Handler f5350Q;
    private ViewGroup f5351R;
    private Runnable f5352S;
    int f5353b;
    private StackLayout f5354d;
    private View f5355e;
    private View f5356f;
    private ImageButton f5357g;
    private ImageButton f5358h;
    private ImageButton f5359i;
    private ImageButton f5360j;
    private LikeMeter f5361k;
    private RelativeLayout f5362l;
    private RelativeLayout f5363m;
    private C2542x f5364n;
    @Nullable
    private RecCard f5365o;
    private Context f5366p;
    private C2493m f5367q;
    private C2493m f5368r;
    private int f5369s;
    private int f5370t;
    private float f5371u;
    private float f5372v;
    private boolean f5373w;
    private boolean f5374x;
    @Nullable
    private RecCard f5375y;
    private LoadingView f5376z;

    /* renamed from: com.tinder.fragments.t.10 */
    class AnonymousClass10 implements Runnable {
        final /* synthetic */ User f5245a;
        final /* synthetic */ boolean f5246b;
        final /* synthetic */ C2437v f5247c;
        final /* synthetic */ C2720t f5248d;

        AnonymousClass10(C2720t c2720t, User user, boolean z, C2437v c2437v) {
            this.f5248d = c2720t;
            this.f5245a = user;
            this.f5246b = z;
            this.f5247c = c2437v;
        }

        public void run() {
            String recId = this.f5248d.f5365o.getRecId();
            boolean isSuperLike = this.f5248d.f5365o.getRec().isSuperLike();
            if (!(this.f5248d.f5373w || this.f5245a == null)) {
                Object obj = this.f5246b ? "BUTTON" : "SWIPE";
                SparksEvent sparksEvent = new SparksEvent("Recs.Rate");
                sparksEvent.put("didSuperLike", Boolean.valueOf(isSuperLike));
                sparksEvent.put("superLike", Boolean.valueOf(this.f5248d.f5345L));
                sparksEvent.put("otherId", recId);
                sparksEvent.put("method", obj);
                sparksEvent.put("fromMore", Boolean.valueOf(this.f5248d.f5373w));
                sparksEvent.put("like", Boolean.valueOf(true));
                sparksEvent.put("userTraveling", Boolean.valueOf(ManagerApp.m7916g().m8517d()));
                sparksEvent.put("recTraveling", Boolean.valueOf(this.f5245a.isRecAndPassporting()));
                if (this.f5245a.getConnections() != null) {
                    ConnectionsGroup connections = this.f5245a.getConnections();
                    sparksEvent.put("firstDegrees", Integer.valueOf(connections.getDegreeCount(1)));
                    sparksEvent.put("secondDegrees", Integer.valueOf(connections.getDegreeCount(2)));
                }
                C2807a.m8056a(sparksEvent);
            }
            ManagerApp.m7924o().m8703a(recId, isSuperLike, this.f5247c);
        }
    }

    /* renamed from: com.tinder.fragments.t.11 */
    class AnonymousClass11 implements Runnable {
        final /* synthetic */ boolean f5249a;
        final /* synthetic */ boolean f5250b;
        final /* synthetic */ C2720t f5251c;

        AnonymousClass11(C2720t c2720t, boolean z, boolean z2) {
            this.f5251c = c2720t;
            this.f5249a = z;
            this.f5250b = z2;
        }

        public void run() {
            if (this.f5249a && this.f5251c.f5334A) {
                this.f5251c.m7600M();
            }
            this.f5251c.m7613a(this.f5250b ? SwipeType.LIKE_BUTTON : SwipeType.LIKE_SWIPE);
        }
    }

    /* renamed from: com.tinder.fragments.t.13 */
    class AnonymousClass13 implements Runnable {
        final /* synthetic */ boolean f5257a;
        final /* synthetic */ User f5258b;
        final /* synthetic */ C2720t f5259c;

        /* renamed from: com.tinder.fragments.t.13.1 */
        class C27061 implements bl {
            final /* synthetic */ AnonymousClass13 f5256a;

            /* renamed from: com.tinder.fragments.t.13.1.1 */
            class C27051 implements Runnable {
                final /* synthetic */ C27061 f5255a;

                C27051(C27061 c27061) {
                    this.f5255a = c27061;
                }

                public void run() {
                    if (this.f5255a.f5256a.f5259c.f5334A) {
                        this.f5255a.f5256a.f5259c.m7600M();
                    }
                    this.f5255a.f5256a.f5259c.m7613a(this.f5255a.f5256a.f5257a ? SwipeType.SUPER_LIKE_BUTTON : SwipeType.SUPER_LIKE_SWIPE);
                }
            }

            C27061(AnonymousClass13 anonymousClass13) {
                this.f5256a = anonymousClass13;
            }

            public void m7561a(SuperlikeStatus superlikeStatus) {
                if (this.f5256a.f5259c.m7596I()) {
                    this.f5256a.f5259c.f5365o.post(new C27051(this));
                    this.f5256a.f5259c.f5343J = superlikeStatus.getRemaining();
                    this.f5256a.f5259c.m7601N();
                }
            }

            public void m7562a(User user) {
                this.f5256a.f5259c.f5345L = this.f5256a.f5259c.f5348O;
                C3095y.m9471a("lastRecWasSuperlike? " + this.f5256a.f5259c.f5345L);
                if (this.f5256a.f5259c.m7596I()) {
                    ManagerApp.m7924o().m8711b(user.getId());
                    Toast.makeText(this.f5256a.f5259c.getActivity(), this.f5256a.f5259c.getString(R.string.superlike_error, user.getName()), 0).show();
                    if (this.f5256a.f5259c.f5365o != null) {
                        if (this.f5256a.f5259c.f5365o.getRecId().equals(user.getId())) {
                            ManagerApp.m7924o().m8710b(this.f5256a.f5258b);
                            this.f5256a.f5259c.f5365o.resetPosition();
                        } else {
                            ManagerApp.m7924o().m8714c(this.f5256a.f5258b);
                        }
                    }
                    this.f5256a.f5259c.m7601N();
                    this.f5256a.f5259c.m7696t();
                }
            }

            public void m7564b(SuperlikeStatus superlikeStatus) {
                this.f5256a.f5259c.f5345L = this.f5256a.f5259c.f5348O;
                C3095y.m9471a("lastRecWasSuperlike? " + this.f5256a.f5259c.f5345L);
                if (this.f5256a.f5259c.m7596I()) {
                    this.f5256a.f5259c.m7595H();
                    this.f5256a.f5259c.f5343J = superlikeStatus.getRemaining();
                    if (this.f5256a.f5259c.f5365o != null) {
                        this.f5256a.f5259c.f5365o.resetPosition();
                    }
                }
            }

            public void m7560a(Match match) {
                this.f5256a.f5259c.m7667a(match);
            }

            public void m7559a() {
                this.f5256a.f5259c.f5345L = this.f5256a.f5259c.f5348O;
                C3095y.m9471a("lastRecWasSuperlike? " + this.f5256a.f5259c.f5345L);
                this.f5256a.f5259c.m7601N();
                this.f5256a.f5259c.m7681f();
            }

            public void m7563b() {
                this.f5256a.f5259c.f5345L = this.f5256a.f5259c.f5348O;
                C3095y.m9471a("lastRecWasSuperlike? " + this.f5256a.f5259c.f5345L);
                if (this.f5256a.f5259c.f5365o != null) {
                    this.f5256a.f5259c.f5365o.resetPosition();
                }
                this.f5256a.f5259c.m7601N();
                this.f5256a.f5259c.m7683g();
            }
        }

        AnonymousClass13(C2720t c2720t, boolean z, User user) {
            this.f5259c = c2720t;
            this.f5257a = z;
            this.f5258b = user;
        }

        public void run() {
            String recId = this.f5259c.f5365o.getRecId();
            if (!this.f5259c.f5373w) {
                Object obj = this.f5257a ? "BUTTON" : "SWIPE";
                boolean isSuperLike = this.f5259c.f5365o.getRec().isSuperLike();
                SparksEvent sparksEvent = new SparksEvent("Recs.Rate");
                sparksEvent.put("didSuperLike", Boolean.valueOf(isSuperLike));
                sparksEvent.put("superLike", Boolean.valueOf(this.f5259c.f5345L));
                sparksEvent.put("otherId", recId);
                sparksEvent.put("method", obj);
                sparksEvent.put("fromMore", Boolean.valueOf(this.f5259c.f5373w));
                sparksEvent.put("like", Boolean.valueOf(true));
                sparksEvent.put("userTraveling", Boolean.valueOf(ManagerApp.m7916g().m8517d()));
                if (this.f5258b != null) {
                    sparksEvent.put("recTraveling", Boolean.valueOf(this.f5258b.isRecAndPassporting()));
                    ConnectionsGroup connections = this.f5258b.getConnections();
                    if (connections != null) {
                        sparksEvent.put("firstDegrees", Integer.valueOf(connections.getDegreeCount(1)));
                        sparksEvent.put("secondDegrees", Integer.valueOf(connections.getDegreeCount(2)));
                    }
                }
                C2807a.m8056a(sparksEvent);
            }
            ManagerApp.m7924o().m8701a(recId, new C27061(this));
        }
    }

    /* renamed from: com.tinder.fragments.t.16 */
    class AnonymousClass16 implements Runnable {
        final /* synthetic */ boolean f5265a;
        final /* synthetic */ boolean f5266b;
        final /* synthetic */ String f5267c;
        final /* synthetic */ C2720t f5268d;

        AnonymousClass16(C2720t c2720t, boolean z, boolean z2, String str) {
            this.f5268d = c2720t;
            this.f5265a = z;
            this.f5266b = z2;
            this.f5267c = str;
        }

        public void run() {
            SparksEvent sparksEvent = new SparksEvent("Undo.Undo");
            sparksEvent.put("like", Boolean.valueOf(this.f5265a));
            sparksEvent.put("userTraveling", Boolean.valueOf(ManagerApp.m7916g().m8517d()));
            sparksEvent.put("recTraveling", Boolean.valueOf(this.f5266b));
            sparksEvent.put("otherId", this.f5267c);
            sparksEvent.put("didSuperLike", Boolean.valueOf(this.f5268d.f5375y.getRec().isSuperLike()));
            sparksEvent.put("superLike", Boolean.valueOf(this.f5268d.f5345L));
            C2807a.m8056a(sparksEvent);
        }
    }

    /* renamed from: com.tinder.fragments.t.17 */
    class AnonymousClass17 implements AnimatorUpdateListener {
        final /* synthetic */ ImageView f5269a;
        final /* synthetic */ C2720t f5270b;

        AnonymousClass17(C2720t c2720t, ImageView imageView) {
            this.f5270b = c2720t;
            this.f5269a = imageView;
        }

        @TargetApi(16)
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            if (al.f6563a) {
                this.f5269a.setImageAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
            } else {
                this.f5269a.setAlpha(valueAnimator.getAnimatedFraction());
            }
        }
    }

    /* renamed from: com.tinder.fragments.t.19 */
    class AnonymousClass19 extends SimpleSpringListener {
        final /* synthetic */ ValueAnimator f5273a;
        final /* synthetic */ C2720t f5274b;

        AnonymousClass19(C2720t c2720t, ValueAnimator valueAnimator) {
            this.f5274b = c2720t;
            this.f5273a = valueAnimator;
        }

        public void onSpringUpdate(@NonNull Spring spring) {
            float currentValue = (float) spring.getCurrentValue();
            this.f5274b.f5354d.applyReverseShifting(currentValue);
            this.f5274b.f5360j.setRotation(-C3077n.m9399a(currentValue, 0.0f, 0.0f, 1.0f, 360.0f));
        }

        public void onSpringAtRest(Spring spring) {
            this.f5274b.m7599L();
            this.f5273a.start();
        }
    }

    /* renamed from: com.tinder.fragments.t.1 */
    class C27101 implements Runnable {
        final /* synthetic */ C2720t f5275a;

        /* renamed from: com.tinder.fragments.t.1.1 */
        class C27011 implements Runnable {
            final /* synthetic */ C27101 f5242a;

            C27011(C27101 c27101) {
                this.f5242a = c27101;
            }

            public void run() {
                C3095y.m9471a("Super Like Feature PreShow run");
                this.f5242a.f5275a.m7601N();
                this.f5242a.f5275a.f5346M = true;
            }
        }

        /* renamed from: com.tinder.fragments.t.1.2 */
        class C27022 implements Runnable {
            final /* synthetic */ C27101 f5243a;

            C27022(C27101 c27101) {
                this.f5243a = c27101;
            }

            public void run() {
                C3095y.m9471a("Super Like post dismiss");
                this.f5243a.f5275a.f5346M = false;
                this.f5243a.f5275a.m7624b(this.f5243a.f5275a.getView());
            }
        }

        /* renamed from: com.tinder.fragments.t.1.3 */
        class C27033 implements bj {
            final /* synthetic */ C27101 f5244a;

            C27033(C27101 c27101) {
                this.f5244a = c27101;
            }

            public void m7553a() {
                C3095y.m9471a("Feature tutorial read success");
                ManagerApp.m7914e().m8864o(true);
            }

            public void m7554b() {
                C3095y.m9471a("Feature tutorial read failure");
            }
        }

        C27101(C2720t c2720t) {
            this.f5275a = c2720t;
        }

        public void run() {
            C3095y.m9471a("Super Like Feature called");
            if (this.f5275a.getActivity() == null || (this.f5275a.f5341H != null && this.f5275a.f5341H.m7072e())) {
                C3095y.m9471a("Super Like is not null OR is showing");
                return;
            }
            C3095y.m9471a("Super Like Feature Tutorial");
            this.f5275a.f5341H = ((ActivityMain) this.f5275a.getActivity()).m6198f();
            new aa().m7148a(this.f5275a.f5341H, this.f5275a);
            this.f5275a.f5341H.m7068b(new C27011(this));
            this.f5275a.f5341H.m7065a(new C27022(this));
            this.f5275a.f5341H.m7069c();
            ManagerApp.m7932w().m8893a("super_like_init", new C27033(this));
            C2807a.m8056a(new SparksEvent("SuperLikeIntroduction.View"));
        }
    }

    /* renamed from: com.tinder.fragments.t.25 */
    class AnonymousClass25 implements OnClickListener {
        final /* synthetic */ RateType f5281a;
        final /* synthetic */ C2720t f5282b;

        AnonymousClass25(C2720t c2720t, RateType rateType) {
            this.f5282b = c2720t;
            this.f5281a = rateType;
        }

        public void onClick(View view) {
            this.f5282b.m7665a(this.f5281a);
        }
    }

    /* renamed from: com.tinder.fragments.t.2 */
    class C27112 implements OnClickListener {
        final /* synthetic */ C2720t f5287a;

        C27112(C2720t c2720t) {
            this.f5287a = c2720t;
        }

        public void onClick(View view) {
            this.f5287a.m7642i(false);
        }
    }

    /* renamed from: com.tinder.fragments.t.30 */
    class AnonymousClass30 implements AnimatorUpdateListener {
        final /* synthetic */ View f5288a;
        final /* synthetic */ float f5289b;
        final /* synthetic */ C2720t f5290c;

        AnonymousClass30(C2720t c2720t, View view, float f) {
            this.f5290c = c2720t;
            this.f5288a = view;
            this.f5289b = f;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            this.f5288a.setTranslationY(this.f5289b * animatedFraction);
            al.m9296c(this.f5288a, 1.0f + (0.4f * animatedFraction));
            this.f5290c.f5344K.setAlpha(animatedFraction);
        }
    }

    /* renamed from: com.tinder.fragments.t.31 */
    class AnonymousClass31 implements AnimatorUpdateListener {
        boolean f5291a;
        final /* synthetic */ View f5292b;
        final /* synthetic */ String f5293c;
        final /* synthetic */ C2720t f5294d;

        AnonymousClass31(C2720t c2720t, View view, String str) {
            this.f5294d = c2720t;
            this.f5292b = view;
            this.f5293c = str;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            this.f5292b.setRotationY(animatedFraction * BitmapDescriptorFactory.HUE_CYAN);
            if (!this.f5291a && animatedFraction >= 0.5f) {
                this.f5294d.f5344K.setRotationY(BitmapDescriptorFactory.HUE_CYAN);
                this.f5294d.f5344K.setText(this.f5293c);
                this.f5291a = true;
            }
        }
    }

    /* renamed from: com.tinder.fragments.t.34 */
    class AnonymousClass34 extends bv {
        final /* synthetic */ Spring f5298a;
        final /* synthetic */ C2720t f5299b;

        AnonymousClass34(C2720t c2720t, Spring spring) {
            this.f5299b = c2720t;
            this.f5298a = spring;
        }

        public void onAnimationStart(Animator animator) {
            this.f5298a.setEndValue(1.0d);
        }
    }

    /* renamed from: com.tinder.fragments.t.35 */
    class AnonymousClass35 implements AnimatorUpdateListener {
        final /* synthetic */ ValueAnimator f5300a;
        final /* synthetic */ C2720t f5301b;

        AnonymousClass35(C2720t c2720t, ValueAnimator valueAnimator) {
            this.f5301b = c2720t;
            this.f5300a = valueAnimator;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            al.m9296c(this.f5301b.f5355e, C3077n.m9399a(valueAnimator.getAnimatedFraction(), 0.0f, 1.0f, 1.0f, 0.75f));
            this.f5300a.start();
        }
    }

    /* renamed from: com.tinder.fragments.t.36 */
    class AnonymousClass36 implements AnimatorUpdateListener {
        boolean f5302a;
        final /* synthetic */ View f5303b;
        final /* synthetic */ float f5304c;
        final /* synthetic */ ValueAnimator f5305d;
        final /* synthetic */ C2720t f5306e;

        AnonymousClass36(C2720t c2720t, View view, float f, ValueAnimator valueAnimator) {
            this.f5306e = c2720t;
            this.f5303b = view;
            this.f5304c = f;
            this.f5305d = valueAnimator;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            this.f5303b.setTranslationY(this.f5304c - (this.f5304c * animatedFraction));
            this.f5306e.f5344K.setAlpha(1.0f - animatedFraction);
            al.m9296c(this.f5303b, ((1.0f - animatedFraction) * 0.4f) + 1.0f);
            if (!this.f5302a && animatedFraction >= 0.9f) {
                this.f5302a = true;
                this.f5305d.start();
            }
        }
    }

    /* renamed from: com.tinder.fragments.t.37 */
    class AnonymousClass37 extends bv {
        final /* synthetic */ View f5307a;
        final /* synthetic */ ViewGroup f5308b;
        final /* synthetic */ C2720t f5309c;

        AnonymousClass37(C2720t c2720t, View view, ViewGroup viewGroup) {
            this.f5309c = c2720t;
            this.f5307a = view;
            this.f5308b = viewGroup;
        }

        public void onAnimationEnd(Animator animator) {
            this.f5307a.setRotationY(0.0f);
            this.f5309c.f5344K.setRotationY(0.0f);
            this.f5308b.bringChildToFront(this.f5309c.f5354d);
        }
    }

    /* renamed from: com.tinder.fragments.t.39 */
    class AnonymousClass39 implements C2430i {
        final /* synthetic */ int f5311a;
        final /* synthetic */ boolean f5312b;
        final /* synthetic */ C2720t f5313c;

        AnonymousClass39(C2720t c2720t, int i, boolean z) {
            this.f5313c = c2720t;
            this.f5311a = i;
            this.f5312b = z;
        }

        public void m7581a(View view) {
            if (this.f5313c.f5365o != null) {
                this.f5313c.f5365o.resetPosition();
            }
            SparksEvent sparksEvent = new SparksEvent("SuperLikeTutorial.Select");
            sparksEvent.put("from", Integer.valueOf(this.f5311a));
            sparksEvent.put(NativeProtocol.WEB_DIALOG_ACTION, Integer.valueOf(1));
            C2807a.m8056a(sparksEvent);
        }

        public void m7582b(View view) {
            if (this.f5312b) {
                this.f5313c.m7649k(true);
                this.f5313c.m7665a(RateType.SUPERLIKE);
            } else {
                this.f5313c.m7649k(true);
                this.f5313c.m7647j(this.f5312b);
            }
            SparksEvent sparksEvent = new SparksEvent("SuperLikeTutorial.Select");
            sparksEvent.put("from", Integer.valueOf(this.f5311a));
            sparksEvent.put(NativeProtocol.WEB_DIALOG_ACTION, Integer.valueOf(2));
            C2807a.m8056a(sparksEvent);
        }
    }

    /* renamed from: com.tinder.fragments.t.3 */
    class C27133 implements OnClickListener {
        final /* synthetic */ C2720t f5314a;

        C27133(C2720t c2720t) {
            this.f5314a = c2720t;
        }

        public void onClick(View view) {
            C3095y.m9471a("Cancel");
            if (this.f5314a.f5365o != null) {
                this.f5314a.f5365o.resetPosition();
            }
        }
    }

    /* renamed from: com.tinder.fragments.t.4 */
    class C27144 implements OnKeyListener {
        final /* synthetic */ C2720t f5322a;

        C27144(C2720t c2720t) {
            this.f5322a = c2720t;
        }

        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i != 4 || this.f5322a.f5365o == null) {
                return true;
            }
            this.f5322a.f5365o.resetPosition();
            return false;
        }
    }

    /* renamed from: com.tinder.fragments.t.5 */
    class C27155 implements C2460a {
        final /* synthetic */ C2720t f5323a;

        C27155(C2720t c2720t) {
            this.f5323a = c2720t;
        }

        public void m7585a(View view) {
            if (this.f5323a.f5365o != null) {
                this.f5323a.f5365o.resetPosition();
            }
        }

        public void m7586b(View view) {
            if (this.f5323a.f5365o != null) {
                this.f5323a.f5365o.resetPosition();
            }
            if (this.f5323a.getActivity() != null) {
                ((ActivityMain) this.f5323a.getActivity()).launchPlusSubscriptionPaywall(4);
            }
        }

        public void m7587c(View view) {
            if (this.f5323a.f5365o != null) {
                this.f5323a.f5365o.resetPosition();
            }
        }
    }

    /* renamed from: com.tinder.fragments.t.6 */
    class C27166 implements OnDismissListener {
        final /* synthetic */ C2720t f5324a;

        C27166(C2720t c2720t) {
            this.f5324a = c2720t;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            if (this.f5324a.f5365o != null) {
                this.f5324a.f5365o.resetPosition();
            }
        }
    }

    /* renamed from: com.tinder.fragments.t.7 */
    class C27177 implements Runnable {
        final /* synthetic */ User f5325a;
        final /* synthetic */ boolean f5326b;
        final /* synthetic */ C2720t f5327c;

        C27177(C2720t c2720t, User user, boolean z) {
            this.f5327c = c2720t;
            this.f5325a = user;
            this.f5326b = z;
        }

        public void run() {
            if (this.f5327c.f5365o != null) {
                String recId = this.f5327c.f5365o.getRecId();
                if (!(this.f5327c.f5373w || this.f5325a == null)) {
                    Object obj = this.f5326b ? "BUTTON" : "SWIPE";
                    boolean isRecAndPassporting = this.f5325a.isRecAndPassporting();
                    boolean isSuperLike = this.f5327c.f5365o.getRec().isSuperLike();
                    SparksEvent sparksEvent = new SparksEvent("Recs.Rate");
                    sparksEvent.put("didSuperLike", Boolean.valueOf(isSuperLike));
                    sparksEvent.put("superLike", Boolean.valueOf(this.f5327c.f5345L));
                    sparksEvent.put("otherId", recId);
                    sparksEvent.put("method", obj);
                    sparksEvent.put("fromMore", Boolean.valueOf(this.f5327c.f5373w));
                    sparksEvent.put("like", Boolean.valueOf(false));
                    sparksEvent.put("userTraveling", Boolean.valueOf(ManagerApp.m7916g().m8517d()));
                    sparksEvent.put("recTraveling", Boolean.valueOf(isRecAndPassporting));
                    if (this.f5325a.getConnections() != null) {
                        ConnectionsGroup connections = this.f5325a.getConnections();
                        sparksEvent.put("firstDegrees", Integer.valueOf(connections.getDegreeCount(1)));
                        sparksEvent.put("secondDegrees", Integer.valueOf(connections.getDegreeCount(2)));
                    }
                    C2807a.m8056a(sparksEvent);
                }
                if (this.f5325a != null) {
                    ManagerApp.m7924o().m8702a(recId, this.f5325a.isSuperLike(), null);
                }
            }
            this.f5327c.f5373w = false;
        }
    }

    /* renamed from: com.tinder.fragments.t.8 */
    class C27188 implements Runnable {
        final /* synthetic */ boolean f5328a;
        final /* synthetic */ boolean f5329b;
        final /* synthetic */ C2720t f5330c;

        C27188(C2720t c2720t, boolean z, boolean z2) {
            this.f5330c = c2720t;
            this.f5328a = z;
            this.f5329b = z2;
        }

        public void run() {
            if (this.f5330c.f5334A && this.f5328a) {
                this.f5330c.m7600M();
            }
            this.f5330c.m7613a(this.f5329b ? SwipeType.PASS_BUTTON : SwipeType.PASS_SWIPE);
        }
    }

    /* renamed from: com.tinder.fragments.t.9 */
    class C27199 implements Runnable {
        final /* synthetic */ C2720t f5331a;

        C27199(C2720t c2720t) {
            this.f5331a = c2720t;
        }

        public void run() {
            C3095y.m9471a("Bouncer likes launch paywall");
            if (this.f5331a.getActivity() != null && (this.f5331a.getActivity() instanceof Paywall)) {
                ((Paywall) this.f5331a.getActivity()).launchSwipeLimitRoadblock(this.f5331a.f5365o.getRecId());
            }
        }
    }

    public C2720t() {
        this.f5369s = 0;
        this.f5371u = 1.0f;
        this.f5372v = 1.0f;
        this.f5375y = null;
        this.f5352S = new C27101(this);
    }

    public void m7670b() {
        C3095y.m9469a();
        this.f5338E = new bc() {
            final /* synthetic */ C2720t f5254a;

            /* renamed from: com.tinder.fragments.t.12.1 */
            class C27041 implements Runnable {
                final /* synthetic */ RateType f5252a;
                final /* synthetic */ AnonymousClass12 f5253b;

                C27041(AnonymousClass12 anonymousClass12, RateType rateType) {
                    this.f5253b = anonymousClass12;
                    this.f5252a = rateType;
                }

                public void run() {
                    this.f5253b.f5254a.m7665a(this.f5252a);
                }
            }

            {
                this.f5254a = r1;
            }

            public void m7556a(int i) {
                this.f5254a.f5369s = i;
                User k = ManagerApp.m7924o().m8724k();
                if (k != null && this.f5254a.f5365o != null) {
                    this.f5254a.m7617a(k, this.f5254a.f5365o, true);
                }
            }

            public void m7557a(RateType rateType) {
                this.f5254a.f5373w = true;
                if (this.f5254a.getView() != null) {
                    this.f5254a.f5350Q.postDelayed(new C27041(this, rateType), 375);
                }
            }

            public void m7555a() {
                User k = ManagerApp.m7924o().m8724k();
                if (this.f5254a.f5365o != null && k != null && k.isSuperLike()) {
                    this.f5254a.f5365o.getSuperLikeStar().setAlpha(0.0f);
                }
            }

            public void m7558b() {
                this.f5254a.f5349P = false;
                User k = ManagerApp.m7924o().m8724k();
                if (this.f5254a.f5365o != null && k != null && k.isSuperLike()) {
                    this.f5254a.f5365o.getSuperLikeStar().animate().alpha(1.0f).start();
                }
            }
        };
        this.f5366p = getActivity();
        this.f5350Q = new Handler();
        this.f5363m.setVisibility(4);
        this.f5376z.refreshProfileAvatarImage();
        m7590C();
        RecCard recCard = new RecCard(getActivity());
        recCard.measure(0, 0);
        LayoutParams layoutParams = (LayoutParams) this.f5354d.getLayoutParams();
        layoutParams.height = recCard.getCardHeight();
        this.f5354d.setLayoutParams(layoutParams);
        this.f5376z.bringToFront();
        this.f5363m.bringToFront();
        this.f5354d.bringToFront();
        C3095y.m9471a("passport enabled ? " + ManagerApp.m7916g().m8517d());
        if (ManagerApp.m7914e().an()) {
            m7636g(true);
        }
        m7678d(true);
        m7589B();
    }

    public StackLayout m7674c() {
        return this.f5354d;
    }

    private void m7588A() {
        this.f5340G = new C2757z();
        this.f5340G.m7834a(((ActivityMain) getActivity()).m6197e(), this);
        if (this.f5340G.m7835b() != null) {
            this.f5340G.m7835b().m6414a(ManagerApp.m7916g().m8510a(5));
            this.f5340G.m7835b().m6413a(ManagerApp.m7916g().m8516c());
            this.f5340G.m7833a();
            this.f5340G.m7835b().notifyDataSetChanged();
        }
    }

    private void m7636g(boolean z) {
        if ((this.f5334A && C2958p.aj()) || (this.f5334A && !C2958p.aj() && z)) {
            this.f5362l.setEnabled(z);
            this.f5360j.setEnabled(z);
        }
    }

    private void m7589B() {
        this.f5363m.setVisibility(0);
    }

    private void m7590C() {
        C3045a.m9203a(this.f5361k, 1.0f, (float) PeekStack.HEIGHT_PERCENT_OF_SCREEN, 200, 200);
        C3045a.m9203a(this.f5358h, 1.0f, (float) PeekStack.HEIGHT_PERCENT_OF_SCREEN, 200, 200);
        if (this.f5334A) {
            if (this.f5359i != null) {
                this.f5359i.clearAnimation();
            }
            if (f5333c) {
                if (this.f5356f != null) {
                    this.f5356f.clearAnimation();
                }
                C3045a.m9203a(this.f5355e, 1.0f, (float) PeekStack.HEIGHT_PERCENT_OF_SCREEN, 200, 200);
            } else {
                if (this.f5355e != null) {
                    this.f5355e.clearAnimation();
                }
                C3045a.m9203a(this.f5356f, 1.0f, (float) PeekStack.HEIGHT_PERCENT_OF_SCREEN, 200, 200);
            }
            C3045a.m9203a(this.f5360j, 1.0f, (float) PeekStack.HEIGHT_PERCENT_OF_SCREEN, 200, 200);
            return;
        }
        if (this.f5356f != null) {
            this.f5356f.clearAnimation();
        }
        if (this.f5355e != null) {
            this.f5355e.clearAnimation();
        }
        if (this.f5360j != null) {
            this.f5360j.clearAnimation();
        }
        C3045a.m9203a(this.f5359i, 1.0f, (float) PeekStack.HEIGHT_PERCENT_OF_SCREEN, 200, 200);
    }

    private void m7591D() {
        m7608a(this.f5358h, this.f5372v).start();
        this.f5372v = 1.0f;
        m7608a(this.f5361k, this.f5371u).start();
        this.f5371u = 1.0f;
    }

    @NonNull
    private AnimatorSet m7608a(View view, float f) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", new float[]{f, 1.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", new float[]{f, 1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.setInterpolator(new OvershootInterpolator(4.0f));
        animatorSet.setDuration(100);
        return animatorSet;
    }

    private void m7611a(float f) {
        this.f5371u = f;
        al.m9296c(this.f5361k, f);
    }

    private void m7622b(float f) {
        this.f5372v = f;
        al.m9296c(this.f5358h, f);
    }

    private void m7619a(RecCard... recCardArr) {
        int i = -1;
        for (int i2 = 0; i2 < recCardArr.length; i2++) {
            RecCard recCard = recCardArr[i2];
            if (recCard != null) {
                if (recCard.getCardMode() == CardMode.VIDEO_AD) {
                    C3095y.m9471a("build card " + i2 + " AD ");
                } else {
                    i++;
                    if (ManagerApp.m7924o().m8722i() > i) {
                        User c = ManagerApp.m7924o().m8713c(i);
                        if (c != null) {
                            recCard.setRec(c);
                            C3095y.m9471a("build card " + i2 + " with " + c.getName());
                        }
                    }
                }
            }
        }
    }

    private void m7617a(@NonNull User user, @NonNull RecCard recCard, boolean z) {
        String imageUrl;
        ArrayList photos = user.getPhotos();
        if (photos.size() > 0) {
            int i = 0;
            if (z && this.f5369s < photos.size()) {
                i = this.f5369s;
            }
            ProcessedPhoto processedPhoto = ((PhotoUser) photos.get(i)).getProcessedPhoto(al.m9265a(getActivity()));
            imageUrl = processedPhoto != null ? processedPhoto.getImageUrl() : null;
        } else {
            imageUrl = null;
        }
        if (imageUrl != null) {
            recCard.setImageUrl(imageUrl);
        }
    }

    private void m7592E() {
        C3095y.m9469a();
        this.f5361k.setAssetMode(this.f5334A ? AssetMode.PLUS : AssetMode.NORMAL);
        if (this.f5334A) {
            if (!f5333c) {
                if (ManagerApp.m7916g().m8517d()) {
                    m7680e(false);
                } else {
                    m7682f(false);
                }
            }
            if (this.f5375y == null || this.f5375y.getRec() == null) {
                this.f5375y = null;
                m7636g(false);
            } else {
                m7636g(true);
            }
        }
        if (this.f5365o == null) {
            m7678d(false);
        }
    }

    private void m7613a(SwipeType swipeType) {
        View recCard;
        RecCard recCard2;
        View view = null;
        C3095y.m9469a();
        this.f5371u = 1.0f;
        this.f5372v = 1.0f;
        this.f5369s = 0;
        this.f5374x = false;
        boolean z = this.f5365o == null;
        if (!z) {
            this.f5365o.onPoppedOffStack(swipeType);
            this.f5365o.setAdCacheListener(null);
            if (m7606S()) {
                m7599L();
            } else {
                m7600M();
            }
        }
        int i = ManagerApp.m7924o().m8722i();
        C3095y.m9471a("recsRemaining: " + i);
        User k = ManagerApp.m7924o().m8724k();
        ManagerApp.m7924o().m8725l();
        ManagerApp.m7924o().m8713c(2);
        ManagerApp.m7924o().m8713c(3);
        if (!(k == null || m7606S())) {
            SparksEvent sparksEvent = new SparksEvent("Recs.View");
            sparksEvent.put("otherId", k.getId());
            sparksEvent.put("didSuperLike", Boolean.valueOf(k.isSuperLike()));
            C2807a.m8056a(sparksEvent);
            PhotoUser mainPhoto = k.getMainPhoto();
            if (mainPhoto != null) {
                SparksEvent sparksEvent2 = new SparksEvent("Recs.PhotoView");
                sparksEvent2.put("otherId", k.getId());
                sparksEvent2.put("photoId", mainPhoto.getPhotoId());
                sparksEvent2.put("didSuperLike", Boolean.valueOf(k.isSuperLike()));
                C2807a.m8056a(sparksEvent2);
            }
        }
        if (z) {
            this.f5365o = new RecCard(this.f5366p);
            View recCard3 = new RecCard(this.f5366p);
            recCard = new RecCard(this.f5366p);
            view = new RecCard(this.f5366p);
            this.f5354d.setViewOffsetDp(al.m9261a(this.f5366p.getResources().getDimension(R.dimen.rec_card_offset), this.f5366p), (float) this.f5365o.getCardHeight());
            if (i >= 3) {
                if (i > 3) {
                    this.f5354d.setUseMockView(true);
                    this.f5354d.addView(view);
                }
                this.f5354d.addView(recCard);
                this.f5354d.addView(recCard3);
                this.f5354d.addView(this.f5365o);
            } else if (i == 2) {
                this.f5354d.addView(recCard3);
                this.f5354d.addView(this.f5365o);
            } else if (i == 1) {
                this.f5354d.addView(this.f5365o);
            }
            m7594G();
            recCard2 = recCard3;
        } else if (i >= 3) {
            this.f5365o.setCardListener(null);
            this.f5354d.setUseMockView(true);
            int reorder = this.f5354d.reorder(this.f5365o, false);
            this.f5365o = (RecCard) this.f5354d.getChildAt(reorder);
            r0 = (RecCard) this.f5354d.getChildAt(reorder - 1);
            RecCard recCard4 = (RecCard) this.f5354d.getChildAt(reorder - 2);
            if (this.f5365o == null) {
                this.f5365o = new RecCard(getActivity());
                this.f5354d.addView(this.f5365o);
            }
            if (i > 3) {
                view = (RecCard) this.f5354d.getChildAt(reorder - 3);
            } else {
                this.f5354d.removeMockView();
            }
            recCard2 = r0;
        } else if (i == 2) {
            this.f5365o.setCardListener(null);
            this.f5354d.setUseMockView(false);
            int reorder2 = this.f5354d.reorder(this.f5365o, true);
            this.f5365o = (RecCard) this.f5354d.getChildAt(reorder2);
            r0 = (RecCard) this.f5354d.getChildAt(reorder2 - 1);
            if (this.f5365o == null) {
                this.f5365o = new RecCard(getActivity());
                this.f5354d.addView(this.f5365o);
            }
            this.f5365o.setCardListener(this);
            recCard = null;
            recCard2 = r0;
        } else if (i == 1) {
            this.f5365o.setCardListener(null);
            this.f5354d.setUseMockView(false);
            this.f5365o = (RecCard) this.f5354d.getChildAt(this.f5354d.reorder(this.f5365o, true));
            if (this.f5365o == null) {
                this.f5365o = new RecCard(getActivity());
                this.f5354d.addView(this.f5365o);
            }
            recCard = null;
            View view2 = null;
        } else {
            C3095y.m9471a("popping back stack");
            ((ActivityMain) this.f5366p).m6206n();
            return;
        }
        m7619a(this.f5365o, recCard2, recCard, view);
        if (f5333c) {
            if (this.f5365o == null || this.f5365o.isMoving() || k == null || !(k.isSuperLike() || k.isBrand() || !this.f5365o.canBeSuperLiked())) {
                m7601N();
            } else {
                if (k.isSuperLike()) {
                    this.f5365o.animateSuperLike();
                }
                m7602O();
            }
        }
        this.f5365o.setCardListener(this);
        ManagerApp.m7931v().m7988s();
        if (this.f5335B && !this.f5337D && ManagerApp.m7931v().m7987r()) {
            this.f5337D = true;
            ManagerApp.m7931v().m7970b();
            ManagerApp.m7931v().m7971b(new Runnable() {
                final /* synthetic */ C2720t f5297a;

                /* renamed from: com.tinder.fragments.t.33.1 */
                class C27121 implements Runnable {
                    final /* synthetic */ AnonymousClass33 f5296a;

                    C27121(AnonymousClass33 anonymousClass33) {
                        this.f5296a = anonymousClass33;
                    }

                    public void run() {
                        this.f5296a.f5297a.m7700x();
                    }
                }

                {
                    this.f5297a = r1;
                }

                public void run() {
                    af.m9230a(ManagerApp.m7931v().m7980k(), new C27121(this));
                }
            }, true);
            ManagerApp.m7931v().m7968a(new Runnable() {
                final /* synthetic */ C2720t f5317a;

                {
                    this.f5317a = r1;
                }

                public void run() {
                    this.f5317a.m7701y();
                    if (this.f5317a.m7606S()) {
                        this.f5317a.m7686j();
                    }
                }
            }, false);
            ManagerApp.m7931v().m7966a();
        }
        if (this.f5336C) {
            if (this.f5335B && ManagerApp.m7931v().m7986q()) {
                ((RecCard) this.f5354d.getChildAt(0)).setCardMode(CardMode.VIDEO_AD);
                ManagerApp.m7914e().m8846h();
                this.f5365o.setAdCacheListener(this);
                m7619a(this.f5365o, recCard2, recCard, view);
            }
            this.f5339F = this.f5365o.getCardMode();
            m7702z();
            this.f5350Q.postDelayed(new Runnable() {
                final /* synthetic */ C2720t f5318a;

                {
                    this.f5318a = r1;
                }

                public void run() {
                    if (this.f5318a.f5354d.getVisibility() == 0) {
                        this.f5318a.f5365o.onPushedToTopOfStack();
                    }
                }
            }, 100);
        }
    }

    public void m7678d(boolean z) {
        C3095y.m9469a();
        m7593F();
        if (z) {
            this.f5354d.animateRecsIn();
        }
        if (!this.f5334A) {
            return;
        }
        if (this.f5375y != null) {
            m7636g(true);
        } else {
            m7599L();
        }
    }

    private void m7593F() {
        this.f5354d.removeAllViews();
        this.f5365o = null;
        m7613a(null);
        this.f5354d.setVisibility(0);
    }

    private void m7594G() {
        C3095y.m9469a();
        if (getActivity() != null) {
            this.f5354d.measure(0, 0);
            this.f5363m.measure(0, 0);
            int b = al.m9285b(this.f5366p);
            int a = al.m9262a(this.f5366p);
            int measuredHeight = this.f5354d.getMeasuredHeight();
            int measuredHeight2 = this.f5363m.getMeasuredHeight();
            int measuredWidth = this.f5363m.getMeasuredWidth();
            measuredHeight = ((b - (((measuredHeight + (getResources().getDimensionPixelSize(R.dimen.rec_card_offset) * 2)) + getResources().getDimensionPixelSize(R.dimen.actionbar_size)) + getResources().getDimensionPixelSize(R.dimen.rec_card_top_margin))) - (getResources().getDimensionPixelSize(R.dimen.margin_med) * 2)) - (getResources().getDimensionPixelSize(R.dimen.rec_buttons_vertical_margin) * 2);
            float f = 1.0f;
            if (measuredHeight2 < measuredHeight || measuredHeight2 > measuredHeight) {
                f = ((float) measuredHeight) / ((float) measuredHeight2);
            }
            a -= getResources().getDimensionPixelSize(R.dimen.margin_med) * 2;
            if (f * ((float) measuredWidth) > ((float) a)) {
                f = ((float) a) / ((float) measuredWidth);
            }
        }
    }

    public void m7668a(boolean z) {
        if (!this.f5349P) {
            m7591D();
            if (m7606S() || z || ManagerApp.m7914e().m8886z()) {
                m7640h(z);
            } else if (this.f5365o != null) {
                User rec = this.f5365o.getRec();
                if (rec != null) {
                    this.f5368r = new C2493m(getActivity(), ConfirmationType.DRAGGING_LEFT, rec.getName(), new OnClickListener() {
                        final /* synthetic */ C2720t f5319a;

                        {
                            this.f5319a = r1;
                        }

                        public void onClick(View view) {
                            this.f5319a.m7640h(false);
                        }
                    }, new OnClickListener() {
                        final /* synthetic */ C2720t f5320a;

                        {
                            this.f5320a = r1;
                        }

                        public void onClick(View view) {
                            C3095y.m9471a("Cancel");
                            if (this.f5320a.f5365o != null) {
                                this.f5320a.f5365o.resetPosition();
                            }
                        }
                    }, new OnKeyListener() {
                        final /* synthetic */ C2720t f5321a;

                        {
                            this.f5321a = r1;
                        }

                        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                            if (i != 4 || this.f5321a.f5365o == null) {
                                return true;
                            }
                            this.f5321a.f5365o.resetPosition();
                            return false;
                        }
                    });
                    this.f5368r.show();
                }
                ManagerApp.m7914e().m8790A();
            }
        }
    }

    public void m7673b(boolean z) {
        if (!this.f5349P) {
            m7591D();
            if (m7606S() || z || ManagerApp.m7914e().m8793B()) {
                m7642i(z);
                return;
            }
            User k = ManagerApp.m7924o().m8724k();
            if (k != null) {
                this.f5367q = new C2493m(getActivity(), ConfirmationType.DRAGGING_RIGHT, k.getName(), new C27112(this), new C27133(this), new C27144(this));
                this.f5367q.show();
            }
            ManagerApp.m7914e().m8794C();
        }
    }

    public void m7676c(boolean z) {
        if (!this.f5349P) {
            m7591D();
            if (ManagerApp.m7924o().m8717d()) {
                m7595H();
            } else if (z || ManagerApp.m7914e().m8803G() || !f5333c) {
                if (!z) {
                    m7649k(true);
                }
                m7647j(z);
            } else {
                m7669a(z, 3);
            }
        }
    }

    private void m7595H() {
        if (getActivity() != null && this.f5365o != null && this.f5365o.getRec() != null) {
            ((ActivityMain) getActivity()).m6190a(this.f5365o.getRec(), this.f5369s, new C27155(this), new C27166(this));
        }
    }

    public void m7662a() {
        if (this.f5365o != null) {
            this.f5365o.resetPosition();
            m7604Q();
        }
    }

    public void m7663a(float f, float f2, float f3, float f4, boolean z) {
        this.f5354d.applyShifting(f, f2, f3, f4, z);
        m7628c(f3);
    }

    private void m7640h(boolean z) {
        boolean z2 = !m7606S();
        this.f5373w = false;
        this.f5348O = this.f5345L;
        this.f5345L = false;
        C3095y.m9471a("lastRecWasSuperlike?" + this.f5345L);
        if (this.f5365o != null) {
            if (z2) {
                this.f5350Q.post(new C27177(this, this.f5365o.getRec(), z));
            }
            this.f5350Q.post(new C27188(this, z2, z));
        }
        this.f5373w = false;
    }

    private void m7642i(boolean z) {
        boolean z2 = !m7606S();
        this.f5348O = this.f5345L;
        this.f5345L = false;
        C3095y.m9471a("lastRecWasSuperlike? " + this.f5345L);
        this.f5373w = false;
        if (ManagerApp.m7924o().m8716c() && z2) {
            C3095y.m9471a("Bouncer likes exceeded");
            if (this.f5365o != null) {
                this.f5365o.resetPosition();
                this.f5374x = false;
                this.f5361k.setPercentFull(0.0f);
                this.f5361k.postDelayed(new C27199(this), 200);
                return;
            }
            C3095y.m9479c("Card current is null - can't show Roadblock");
            return;
        }
        if (this.f5365o != null) {
            if (z2) {
                this.f5350Q.post(new AnonymousClass10(this, this.f5365o.getRec(), z, this));
            }
            this.f5350Q.post(new AnonymousClass11(this, z2, z));
        }
        this.f5373w = false;
    }

    private void m7647j(boolean z) {
        if (ManagerApp.m7924o().m8717d()) {
            m7601N();
            m7595H();
            return;
        }
        this.f5348O = this.f5345L;
        this.f5345L = true;
        C3095y.m9471a("lastRecWasSuperlike? " + this.f5345L);
        this.f5374x = false;
        this.f5373w = false;
        if (this.f5365o != null) {
            this.f5365o.post(new AnonymousClass13(this, z, this.f5365o.getRec()));
        }
        this.f5374x = false;
        this.f5373w = false;
    }

    @UiThread
    public void m7677d() {
        if (this.f5375y == null || this.f5375y.getRec() == null || this.f5374x) {
            AsyncTask.execute(new Runnable() {
                final /* synthetic */ C2720t f5264a;

                {
                    this.f5264a = r1;
                }

                public void run() {
                    SparksEvent sparksEvent = new SparksEvent("Undo.Undo");
                    sparksEvent.put("userTraveling", Boolean.valueOf(ManagerApp.m7916g().m8517d()));
                    C2807a.m8056a(sparksEvent);
                }
            });
            return;
        }
        C3095y.m9471a("mLastSwipeWasSuperlike was " + this.f5345L);
        if (this.f5345L) {
            m7649k(false);
            m7636g(false);
            ManagerApp.m7924o().m8700a(this.f5375y.getRec(), new bo() {
                final /* synthetic */ C2720t f5263a;

                /* renamed from: com.tinder.fragments.t.14.1 */
                class C27081 implements C2438x {
                    final /* synthetic */ User f5261a;
                    final /* synthetic */ AnonymousClass14 f5262b;

                    /* renamed from: com.tinder.fragments.t.14.1.1 */
                    class C27071 implements bo {
                        final /* synthetic */ C27081 f5260a;

                        C27071(C27081 c27081) {
                            this.f5260a = c27081;
                        }

                        public void m7567a(User user, SuperlikeStatus superlikeStatus) {
                            this.f5260a.f5262b.f5263a.f5345L = this.f5260a.f5262b.f5263a.f5348O;
                            ManagerApp.m7924o().m8710b(user);
                            this.f5260a.f5262b.f5263a.f5343J = superlikeStatus.getRemaining();
                            this.f5260a.f5262b.f5263a.m7598K();
                        }

                        public void m7568a(String str) {
                            this.f5260a.f5262b.f5263a.f5374x = false;
                            C3095y.m9471a("lastRecWasSuperlike? " + this.f5260a.f5262b.f5263a.f5345L);
                            this.f5260a.f5262b.f5263a.m7597J();
                            boolean equals = TextUtils.equals(this.f5260a.f5262b.f5263a.f5375y.getRecId(), str);
                            C3095y.m9471a("same rec?:" + equals);
                            if (equals) {
                                this.f5260a.f5262b.f5263a.m7636g(true);
                            }
                        }

                        public void m7565a() {
                            this.f5260a.f5262b.f5263a.f5374x = false;
                            C3095y.m9471a("undo rec error: alreadyProcessed");
                            this.f5260a.f5262b.f5263a.m7597J();
                        }

                        public void m7569b() {
                            this.f5260a.f5262b.f5263a.f5374x = false;
                            this.f5260a.f5262b.f5263a.m7597J();
                        }

                        public void m7566a(User user) {
                            this.f5260a.f5262b.f5263a.f5374x = false;
                            this.f5260a.f5262b.f5263a.m7597J();
                        }
                    }

                    C27081(AnonymousClass14 anonymousClass14, User user) {
                        this.f5262b = anonymousClass14;
                        this.f5261a = user;
                    }

                    public void m7570a() {
                        ManagerApp.m7924o().m8700a(this.f5261a, new C27071(this));
                    }

                    public void m7571b() {
                        this.f5262b.f5263a.f5374x = false;
                        this.f5262b.f5263a.m7597J();
                    }

                    public void m7572c() {
                        this.f5262b.f5263a.f5374x = false;
                        this.f5262b.f5263a.m7597J();
                    }
                }

                {
                    this.f5263a = r1;
                }

                public void m7575a(User user, SuperlikeStatus superlikeStatus) {
                    this.f5263a.f5345L = this.f5263a.f5348O;
                    ManagerApp.m7924o().m8710b(user);
                    this.f5263a.f5343J = superlikeStatus.getRemaining();
                    this.f5263a.m7598K();
                }

                public void m7576a(String str) {
                    C3095y.m9471a("mLastSwipeWasSuperlike was " + this.f5263a.f5345L);
                    this.f5263a.f5374x = false;
                    this.f5263a.m7597J();
                    boolean equals = TextUtils.equals(this.f5263a.f5375y.getRecId(), str);
                    C3095y.m9471a("same rec?:" + equals);
                    if (equals) {
                        this.f5263a.m7636g(true);
                    }
                }

                public void m7573a() {
                    C3095y.m9471a("undo rec error: alreadyProcessed");
                    C3095y.m9471a("lastRecWasSuperlike? " + this.f5263a.f5345L);
                    this.f5263a.f5374x = false;
                    this.f5263a.m7597J();
                }

                public void m7577b() {
                    ManagerApp.m7911b().m8143d();
                }

                public void m7574a(User user) {
                    ManagerApp.m7911b().m8134a(new C27081(this, user));
                }
            });
            return;
        }
        this.f5345L = this.f5348O;
        C3095y.m9471a("lastRecWasSuperlike? " + this.f5345L);
        ManagerApp.m7924o().m8699a(this.f5375y.getRec());
        m7598K();
    }

    private boolean m7596I() {
        return (getActivity() == null || getActivity().isFinishing()) ? false : true;
    }

    private void m7597J() {
        if (m7596I()) {
            Toast.makeText(getActivity(), R.string.superlike_undo_error, 1).show();
        }
    }

    private void m7598K() {
        if (this.f5375y != null && m7596I()) {
            View stampLike;
            String recId = this.f5375y.getRecId();
            boolean isRecAndPassporting = this.f5375y.getRec().isRecAndPassporting();
            boolean z = this.f5375y.getTranslationX() > 0.0f;
            if (2 == this.f5370t) {
                m7696t();
            }
            AsyncTask.execute(new AnonymousClass16(this, z, isRecAndPassporting, recId));
            this.f5374x = true;
            if (this.f5365o != null) {
                this.f5365o.setCardListener(null);
            }
            if (z) {
                stampLike = this.f5375y.getStampLike();
            } else {
                stampLike = this.f5375y.getStampNope();
            }
            ImageView imageView = (ImageView) stampLike;
            imageView.setVisibility(0);
            imageView.setImageResource(z ? R.drawable.recs_like_oops_stamp : R.drawable.recs_nope_oops_stamp);
            imageView.getDrawable().setAlpha(RangeSeekBar.INVALID_POINTER_ID);
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setDuration(125);
            valueAnimator.setIntValues(new int[]{RangeSeekBar.INVALID_POINTER_ID, 0});
            valueAnimator.addUpdateListener(new AnonymousClass17(this, imageView));
            valueAnimator.addListener(new bu() {
                final /* synthetic */ C2720t f5272a;

                /* renamed from: com.tinder.fragments.t.18.1 */
                class C27091 implements Runnable {
                    final /* synthetic */ AnonymousClass18 f5271a;

                    C27091(AnonymousClass18 anonymousClass18) {
                        this.f5271a = anonymousClass18;
                    }

                    public void run() {
                        this.f5271a.f5272a.m7678d(false);
                    }
                }

                {
                    this.f5272a = r1;
                }

                public void onAnimationEnd(Animator animator) {
                    this.f5272a.f5350Q.post(new C27091(this));
                }
            });
            this.f5354d.addView(this.f5375y, this.f5354d.getChildCount());
            this.f5375y.resetPosition(true, new AnonymousClass19(this, valueAnimator));
        }
    }

    private void m7599L() {
        if (this.f5334A) {
            this.f5360j.setRotation(0.0f);
            m7636g(false);
        }
        this.f5375y = null;
    }

    private void m7600M() {
        if (this.f5365o != null) {
            this.f5375y = this.f5365o.clone();
            m7636g(true);
        }
    }

    private void m7601N() {
        C3095y.m9469a();
        if (!this.f5346M) {
            this.f5357g.setEnabled(true);
            this.f5355e.setEnabled(true);
        }
    }

    private void m7602O() {
        C3095y.m9469a();
        if (!this.f5346M) {
            this.f5357g.setEnabled(false);
            this.f5355e.setEnabled(false);
        }
    }

    private void m7628c(float f) {
        float abs = ((Math.abs(f) / (((float) (al.m9262a(getActivity()) / 2)) * 0.8f)) * 0.07f) + 1.0f;
        if (f < 0.0f) {
            m7622b(abs);
        } else {
            m7611a(abs);
        }
    }

    private void m7623b(int i) {
        C3095y.m9471a("ENTER like meter");
        float percentFull = this.f5361k.getPercentFull();
        float f = ((float) i) / 100.0f;
        Spring a = C3045a.m9201a();
        a.setSpringConfig(SpringConfig.fromOrigamiTensionAndFriction(68.0d, 4.0d));
        a.addListener(new SimpleSpringListener() {
            final /* synthetic */ C2720t f5276a;

            {
                this.f5276a = r1;
            }

            public void onSpringUpdate(@NonNull Spring spring) {
                this.f5276a.f5361k.setPercentFull((float) spring.getCurrentValue());
            }
        });
        a.setCurrentValue((double) percentFull);
        a.setEndValue((double) f);
    }

    public void m7664a(int i) {
        if (ManagerApp.m7914e().ao()) {
            m7623b(i);
        }
    }

    public void m7679e() {
    }

    public void m7667a(@NonNull Match match) {
        if (!(this.f5375y == null || this.f5375y.getRec() == null || !match.getPerson().getId().equals(this.f5375y.getRecId()))) {
            m7599L();
        }
        ManagerApp.m7925p().m8278a(true);
        al.m9297c(this.f5364n);
        String str = BuildConfig.FLAVOR;
        User d = ManagerApp.m7922m().m8599d();
        if (d != null) {
            String imageUrl;
            ArrayList photos = d.getPhotos();
            if (photos != null && photos.size() > 0) {
                ProcessedPhoto processedPhoto = ((PhotoUser) photos.get(0)).getProcessedPhoto(PhotoSizeUser.SMALL);
                if (processedPhoto != null) {
                    imageUrl = processedPhoto.getImageUrl();
                    if (getActivity() != null) {
                        this.f5364n = new C2542x(getActivity(), this, imageUrl, match);
                    }
                }
            }
            imageUrl = str;
            if (getActivity() != null) {
                this.f5364n = new C2542x(getActivity(), this, imageUrl, match);
            }
        }
    }

    public void onDetach() {
        super.onDetach();
        al.m9297c(this.f5364n);
        this.f5364n = null;
    }

    public void m7681f() {
        ManagerApp.m7911b().m8143d();
    }

    public void m7683g() {
        ManagerApp.m7911b().m8134a(null);
    }

    public void m7684h() {
    }

    public void m7685i() {
    }

    public void m7686j() {
        C3095y.m9469a();
        if (!this.f5374x) {
            User k = ManagerApp.m7924o().m8724k();
            if (k == null) {
                m7665a(RateType.PASS);
            } else if (ManagerApp.m7914e().m8797D() || this.f5365o == null) {
                m7665a(RateType.PASS);
            } else {
                this.f5368r = new C2493m(getActivity(), ConfirmationType.TAPPING_X, k.getName(), new OnClickListener() {
                    final /* synthetic */ C2720t f5277a;

                    {
                        this.f5277a = r1;
                    }

                    public void onClick(View view) {
                        this.f5277a.m7665a(RateType.PASS);
                    }
                }, new OnClickListener() {
                    final /* synthetic */ C2720t f5278a;

                    {
                        this.f5278a = r1;
                    }

                    public void onClick(View view) {
                        C3095y.m9471a("Cancel");
                        this.f5278a.f5365o.resetPosition();
                    }
                }, new OnKeyListener() {
                    final /* synthetic */ C2720t f5279a;

                    {
                        this.f5279a = r1;
                    }

                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i != 4) {
                            return true;
                        }
                        this.f5279a.f5365o.resetPosition();
                        return false;
                    }
                });
                this.f5368r.show();
                ManagerApp.m7914e().m8798E();
            }
        }
    }

    public void m7665a(RateType rateType) {
        if (this.f5365o != null && !this.f5365o.isMoving()) {
            this.f5374x = true;
            this.f5365o.animateTouchlessSwipe(rateType, new AnimatorUpdateListener() {
                final /* synthetic */ C2720t f5280a;

                {
                    this.f5280a = r1;
                }

                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f5280a.f5354d.applyShifting(valueAnimator.getAnimatedFraction(), false);
                }
            });
        }
    }

    public void m7671b(RateType rateType) {
        C3095y.m9469a();
        if (!this.f5374x) {
            User k = ManagerApp.m7924o().m8724k();
            if (k == null) {
                m7665a(rateType);
            } else if (ManagerApp.m7914e().m8882x() || this.f5365o == null) {
                m7665a(rateType);
            } else {
                this.f5367q = new C2493m(getActivity(), ConfirmationType.TAPPING_HEART, k.getName(), new AnonymousClass25(this, rateType), new OnClickListener() {
                    final /* synthetic */ C2720t f5283a;

                    {
                        this.f5283a = r1;
                    }

                    public void onClick(View view) {
                        C3095y.m9471a("Cancel");
                        this.f5283a.f5365o.resetPosition();
                    }
                }, new OnKeyListener() {
                    final /* synthetic */ C2720t f5284a;

                    {
                        this.f5284a = r1;
                    }

                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i != 4) {
                            return true;
                        }
                        this.f5284a.f5365o.resetPosition();
                        return false;
                    }
                });
                this.f5367q.show();
                ManagerApp.m7914e().m8883y();
            }
        }
    }

    public void m7687k() {
        C3095y.m9469a();
        if (!this.f5347N) {
            if (ManagerApp.m7924o().m8717d()) {
                m7595H();
                m7601N();
                return;
            }
            new Handler().postDelayed(new Runnable() {
                final /* synthetic */ C2720t f5285a;

                {
                    this.f5285a = r1;
                }

                public void run() {
                    if (this.f5285a.getActivity() != null) {
                        ((ActivityMain) this.f5285a.getActivity()).m6200h();
                    }
                }
            }, 700);
            boolean z = (this.f5365o == null || this.f5365o.getRec() == null || !this.f5365o.getRec().isSuperLike()) ? false : true;
            if (this.f5374x || z) {
                m7601N();
            } else if (ManagerApp.m7924o().m8724k() == null) {
                m7649k(true);
                m7665a(RateType.SUPERLIKE);
            } else if (ManagerApp.m7914e().m8803G()) {
                m7649k(true);
                m7665a(RateType.SUPERLIKE);
            } else {
                m7669a(true, 1);
            }
        }
    }

    public void m7688l() {
        if (getActivity() != null) {
            FragmentAnchoredPopup e = ((ActivityMain) getActivity()).m6197e();
            if (e != null && !e.m7072e()) {
                SparksEvent sparksEvent = new SparksEvent("Passport.MenuOpen");
                sparksEvent.put("recsExhausted", Boolean.valueOf(this.f5376z.getLoadingText().equals(getResources().getString(R.string.no_one_new))));
                sparksEvent.put("from", Integer.valueOf(1));
                C2807a.m8056a(sparksEvent);
                this.f5358h.measure(0, 0);
                this.f5356f.measure(0, 0);
                m7588A();
                e.m7069c();
            }
        }
    }

    public void m7689m() {
        if (this.f5365o != null && !this.f5365o.isMoving()) {
            m7604Q();
        }
    }

    private void m7649k(boolean z) {
        this.f5347N = true;
        if (z) {
            new Handler().postDelayed(new Runnable() {
                final /* synthetic */ C2720t f5286a;

                {
                    this.f5286a = r1;
                }

                public void run() {
                    if (this.f5286a.getActivity() != null) {
                        ((ActivityMain) this.f5286a.getActivity()).m6200h();
                    }
                }
            }, 200);
        }
        ViewGroup viewGroup = (ViewGroup) getView().findViewById(R.id.layout_frag_recs);
        viewGroup.bringChildToFront(this.f5363m);
        View view = this.f5351R;
        float f = (float) ((-al.m9292c()) / 4);
        TimeInterpolator fastOutSlowInInterpolator = new FastOutSlowInInterpolator();
        SuperlikeStatus g = ManagerApp.m7924o().m8720g();
        if (this.f5343J == 0 && z && !g.isOutOfSuperlikes()) {
            this.f5343J = g.getAllotment();
        }
        String valueOf = z ? String.valueOf(this.f5343J - 1) : String.valueOf(this.f5343J + 1);
        this.f5344K.setText(String.valueOf(this.f5343J));
        AnimatorSet animatorSet = new AnimatorSet();
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(380);
        valueAnimator.setIntValues(new int[]{0, 1});
        valueAnimator.setInterpolator(fastOutSlowInInterpolator);
        valueAnimator.addUpdateListener(new AnonymousClass30(this, view, f));
        ValueAnimator valueAnimator2 = new ValueAnimator();
        valueAnimator2.setDuration(320);
        valueAnimator2.setInterpolator(fastOutSlowInInterpolator);
        valueAnimator2.setIntValues(new int[]{0, 1});
        valueAnimator2.addUpdateListener(new AnonymousClass31(this, view, valueOf));
        Spring a = C3045a.m9201a();
        a.setVelocity(100.0d);
        a.setSpringConfig(SpringConfig.fromBouncinessAndSpeed(20.0d, 23.0d));
        a.setCurrentValue(0.75d);
        a.addListener(new SimpleSpringListener() {
            final /* synthetic */ C2720t f5295a;

            {
                this.f5295a = r1;
            }

            public void onSpringUpdate(Spring spring) {
                al.m9296c(this.f5295a.f5355e, (float) spring.getCurrentValue());
            }

            public void onSpringAtRest(Spring spring) {
                this.f5295a.f5347N = false;
            }
        });
        ValueAnimator valueAnimator3 = new ValueAnimator();
        valueAnimator3.setIntValues(new int[]{0, 1});
        valueAnimator3.setStartDelay(60);
        valueAnimator3.addListener(new AnonymousClass34(this, a));
        ValueAnimator valueAnimator4 = new ValueAnimator();
        valueAnimator4.setIntValues(new int[]{0, 1});
        valueAnimator4.setDuration(100);
        valueAnimator4.addUpdateListener(new AnonymousClass35(this, valueAnimator3));
        valueAnimator3 = new ValueAnimator();
        valueAnimator3.setInterpolator(fastOutSlowInInterpolator);
        valueAnimator3.setIntValues(new int[]{0, 1});
        valueAnimator3.setDuration(300);
        valueAnimator3.addUpdateListener(new AnonymousClass36(this, view, f, valueAnimator4));
        valueAnimator3.addListener(new AnonymousClass37(this, view, viewGroup));
        animatorSet.playSequentially(new Animator[]{valueAnimator, valueAnimator2, valueAnimator3});
        animatorSet.start();
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(R.layout.view_fragment_recs, viewGroup, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f5334A = ManagerApp.m7914e().an();
        f5333c = ManagerApp.m7914e().at();
        ((ViewStub) view.findViewById(this.f5334A ? R.id.stub_gamepad : R.id.stub_gamepad_old)).inflate();
        m7612a(view);
        m7670b();
    }

    public void onResume() {
        super.onResume();
        C3095y.m9471a("superlike mEnableSuperlike:" + f5333c);
        f5332a = false;
        ManagerApp.m7911b().m8141b((ah) this);
        m7592E();
        m7690n();
        if (!this.f5335B) {
            UserMeta c = ManagerApp.m7911b().m8142c();
            if (c != null) {
                m7618a(c);
            }
        }
    }

    public void onPause() {
        super.onPause();
        m7605R();
        ManagerApp.m7911b().m8140a((ah) this);
    }

    public void onDestroyView() {
        this.f5365o = null;
        al.m9297c(this.f5364n);
        al.m9297c(this.f5367q);
        al.m9297c(this.f5368r);
        C3095y.m9471a("DESTROY VIEW");
        super.onDestroyView();
    }

    private void m7612a(@NonNull View view) {
        if (this.f5334A) {
            this.f5362l = (RelativeLayout) view.findViewById(R.id.rewind);
            this.f5360j = (ImageButton) view.findViewById(R.id.rewind_icon);
            this.f5360j.setOnClickListener(this);
            this.f5360j.setClickable(true);
            this.f5357g = (ImageButton) view.findViewById(R.id.superlike_icon);
            this.f5355e = view.findViewById(R.id.superlike);
            this.f5351R = (ViewGroup) view.findViewById(R.id.superlike_icon_group);
            this.f5344K = (CustomTextView) getView().findViewById(R.id.superlike_counter);
            this.f5356f = view.findViewById(R.id.btn_passport);
            if (f5333c) {
                this.f5355e.setOnClickListener(this);
            } else {
                this.f5356f.setOnClickListener(this);
                this.f5356f.setVisibility(0);
            }
            m7624b(view);
        } else {
            this.f5359i = (ImageButton) view.findViewById(R.id.recs_btn_info);
            this.f5359i.setOnClickListener(this);
        }
        this.f5354d = (StackLayout) view.findViewById(R.id.view_card_stack);
        this.f5358h = (ImageButton) view.findViewById(R.id.pass_button);
        this.f5361k = (LikeMeter) view.findViewById(R.id.like_button);
        this.f5363m = (RelativeLayout) view.findViewById(R.id.recs_layout_gamepad);
        this.f5376z = (LoadingView) view.findViewById(R.id.recs_loadingview);
        this.f5358h.setOnClickListener(this);
        if (this.f5361k != null) {
            this.f5361k.setOnClickListener(this);
            this.f5361k.setAssetMode(this.f5334A ? AssetMode.PLUS : AssetMode.NORMAL);
        }
    }

    private void m7624b(View view) {
        C3095y.m9469a();
        if (view != null) {
            View findViewById = view.findViewById(R.id.passport);
            if (findViewById != null) {
                if (f5333c) {
                    findViewById.setVisibility(8);
                    this.f5355e.setVisibility(0);
                } else {
                    findViewById.setVisibility(0);
                }
            }
        }
        if (f5333c && !this.f5346M) {
            User k = ManagerApp.m7924o().m8724k();
            if (this.f5365o != null && k != null) {
                C3095y.m9471a("isBrand:" + k.isBrand());
                if (this.f5365o.canBeSuperLiked()) {
                    m7601N();
                } else {
                    m7602O();
                }
            } else if (this.f5341H == null || !this.f5341H.m7072e()) {
                m7602O();
            }
        }
    }

    public void m7690n() {
        boolean an = ManagerApp.m7914e().an();
        C3095y.m9471a("ENTER canUsePlus " + an);
        boolean at = ManagerApp.m7914e().at();
        View view;
        if (this.f5334A != an) {
            C3095y.m9471a("gamepad update layout from status change");
            this.f5334A = an;
            if (f5333c != at) {
                f5333c = at;
            }
            int i = this.f5334A ? R.layout.view_rec_gamepad : R.layout.view_rec_gamepad_old;
            this.f5363m.removeAllViewsInLayout();
            this.f5363m.requestLayout();
            RelativeLayout relativeLayout = this.f5363m;
            RelativeLayout.inflate(ManagerApp.m7917h(), i, this.f5363m);
            this.f5363m.requestLayout();
            view = getView();
            if (view != null) {
                m7612a(view);
                m7590C();
            }
        } else if (this.f5334A && f5333c != at) {
            C3095y.m9471a("gamepad update superlike/passport button");
            f5333c = at;
            view = getView();
            if (view != null) {
                m7612a(view);
                m7590C();
            }
        }
    }

    private int m7603P() {
        int b;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.actionbar_size);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.rec_card_top_margin);
        int c = getActivity() != null ? al.m9293c(getActivity()) : 0;
        if (getActivity() != null) {
            b = (int) al.m9284b(1.0f, getActivity());
        } else {
            b = 0;
        }
        if (f5333c) {
            b = 0;
            dimensionPixelOffset = 0;
            dimensionPixelSize = 0;
        }
        b += dimensionPixelOffset + (dimensionPixelSize + c);
        if (!al.m9299d()) {
            c = 0;
        }
        this.f5353b = c + b;
        return this.f5353b;
    }

    private void m7604Q() {
        if (!this.f5349P) {
            this.f5349P = true;
            if (ManagerApp.m7924o().m8724k() != null && this.f5365o != null) {
                f5332a = true;
                Point a = al.m9263a(this.f5365o.getImageView());
                int c = al.m9294c(ManagerApp.m7917h());
                int P = a.y - m7603P();
                int cardWidth = this.f5365o.getCardWidth() - ((int) al.m9284b(0.5f, getActivity()));
                int cardHeight = this.f5365o.getCardHeight();
                Point a2 = al.m9263a(this.f5365o.getSuperLikeStar());
                C2745x.m7750a(this.f5365o.getRec(), this.f5338E, this.f5369s, a.x, P, cardWidth, cardHeight, a2.x, a2.y - c).show(getChildFragmentManager(), "fvp");
            }
        }
    }

    public void m7672b(@NonNull Match match) {
        C3095y.m9471a("match=" + match);
        ((ab) getActivity()).m6120a(match, false);
        al.m9297c(this.f5364n);
    }

    public void m7691o() {
        if (getActivity() != null) {
            ((ActivityMain) getActivity()).m6192a("newMatch");
        }
    }

    public void m7675c(@NonNull Match match) {
        C3095y.m9471a("match=" + match);
        ((ab) getActivity()).m6120a(match, true);
        al.m9297c(this.f5364n);
    }

    public void m7692p() {
        C3095y.m9469a();
        if (getActivity() != null) {
            ((ActivityMain) getActivity()).m6214v();
        }
        al.m9297c(this.f5364n);
    }

    public void m7693q() {
        Activity activity = getActivity();
        if (this.f5364n != null && activity != null && !activity.isFinishing()) {
            this.f5364n.show();
        }
    }

    public void m7694r() {
        C3095y.m9469a();
        this.f5354d.setVisibility(4);
        this.f5354d.removeAllViews();
        this.f5376z.setLoadingText(R.string.finding_people);
        this.f5376z.setVisibility(0);
        this.f5376z.startAllPingAnimations();
        if (this.f5334A) {
            m7636g(false);
        } else {
            this.f5359i.setEnabled(false);
        }
        this.f5361k.setEnabled(false);
        this.f5358h.setEnabled(false);
        if (f5333c) {
            m7602O();
        }
        this.f5370t = 1;
    }

    public void m7695s() {
        C3095y.m9469a();
        this.f5354d.setVisibility(4);
        this.f5376z.setVisibility(0);
        this.f5376z.setLoadingText(R.string.no_one_new);
        this.f5376z.startAllPingAnimations();
        if (!this.f5334A) {
            this.f5359i.setEnabled(false);
        }
        this.f5361k.setEnabled(false);
        this.f5358h.setEnabled(false);
        this.f5370t = 2;
        if (f5333c) {
            m7602O();
        }
        boolean aj = C2958p.aj();
        if (!this.f5334A) {
            return;
        }
        if ((aj && this.f5375y != null) || !aj) {
            m7636g(true);
        }
    }

    public void m7696t() {
        if (this.f5354d.getVisibility() == 4 || this.f5354d.getChildCount() == 0) {
            m7678d(true);
            this.f5354d.setVisibility(0);
            this.f5376z.setVisibility(4);
            if (this.f5334A) {
                ManagerApp.m7914e();
                if (!C2958p.aj()) {
                    m7636g(true);
                    this.f5358h.setEnabled(true);
                    this.f5361k.setEnabled(true);
                }
            }
            if (!this.f5334A) {
                this.f5359i.setEnabled(true);
                this.f5359i.setOnClickListener(this);
            }
            this.f5358h.setEnabled(true);
            this.f5361k.setEnabled(true);
        }
        if (ManagerApp.m7914e().ao()) {
            this.f5361k.setPercentFullInt(ManagerApp.m7924o().m8692a());
        }
        m7624b(getView());
        this.f5370t = 0;
    }

    public void m7680e(boolean z) {
        al.m9271a(this.f5356f, ContextCompat.getDrawable(getActivity(), R.drawable.recs_passport_enabled));
        if (z) {
            m7599L();
        }
    }

    public void m7682f(boolean z) {
        al.m9271a(this.f5356f, ContextCompat.getDrawable(getActivity(), R.drawable.recs_passport_available));
        if (z) {
            m7599L();
        }
    }

    public void m7666a(GlobalConfig globalConfig, @Nullable UserMeta userMeta) {
        C3095y.m9469a();
        this.f5335B = true;
        m7690n();
        if (userMeta != null) {
            if (globalConfig != null && globalConfig.isSuperlikeEnabled()) {
                this.f5343J = userMeta.getSuperlikeStatus().getRemaining();
            }
            if (ManagerApp.m7914e().ao()) {
                this.f5361k.setPercentFullInt(userMeta.getLikesPercentRemaining());
            }
            m7618a(userMeta);
        }
    }

    private void m7618a(UserMeta userMeta) {
        if (!C3077n.m9408a(userMeta.getTutorials()) && getActivity() != null && (getActivity() instanceof ActivityMain)) {
            C3095y.m9471a("Tutorials available");
            boolean A = ((ActivityMain) getActivity()).m6160A();
            if (f5333c && !ManagerApp.m7914e().m8801F() && !m7697u() && A) {
                new Handler().post(this.f5352S);
            }
        }
    }

    public void onClick(@NonNull View view) {
        switch (view.getId()) {
            case R.id.superlike:
                if (f5333c) {
                    m7687k();
                }
            case R.id.btn_passport:
                m7688l();
            case R.id.rewind_icon:
                ManagerApp.m7921l().m8625a(new bk() {
                    final /* synthetic */ C2720t f5310a;

                    {
                        this.f5310a = r1;
                    }

                    public void m7578a() {
                        C3095y.m9471a("onSubscriptionStatusActive");
                        this.f5310a.m7677d();
                    }

                    public void m7579b() {
                        C3095y.m9471a("onSubscriptionStatusInactive");
                        SparksEvent sparksEvent = new SparksEvent("Undo.Undo");
                        if (this.f5310a.f5375y != null) {
                            User rec = this.f5310a.f5375y.getRec();
                            if (rec != null) {
                                sparksEvent.put("like", Boolean.valueOf(this.f5310a.f5375y.getTranslationX() > 0.0f));
                                sparksEvent.put("otherId", rec.getId());
                                sparksEvent.put("recTraveling", Boolean.valueOf(rec.isRecAndPassporting()));
                                sparksEvent.put("didSuperLike", Boolean.valueOf(rec.isSuperLike()));
                                sparksEvent.put("superLike", Boolean.valueOf(this.f5310a.f5345L));
                            }
                        }
                        sparksEvent.put("userTraveling", Boolean.valueOf(ManagerApp.m7916g().m8517d()));
                        C2807a.m8056a(sparksEvent);
                        if (this.f5310a.getActivity() != null && (this.f5310a.getActivity() instanceof Paywall)) {
                            ((Paywall) this.f5310a.getActivity()).launchPlusSubscriptionPaywall(0);
                        }
                    }

                    public void m7580c() {
                        C3095y.m9471a("onSubscriptionStatusUnknown");
                        Toast.makeText(this.f5310a.f5366p, this.f5310a.getResources().getString(R.string.error_getting_plus_subscription_status), 1).show();
                    }
                });
            case R.id.like_button:
                m7671b(RateType.LIKE);
            case R.id.pass_button:
                m7686j();
            case R.id.recs_btn_info:
                m7689m();
            default:
        }
    }

    boolean m7697u() {
        return (this.f5341H != null && this.f5341H.m7072e()) || (this.f5342I != null && this.f5342I.m7072e());
    }

    public void m7669a(boolean z, int i) {
        if (getActivity() != null) {
            m7601N();
            this.f5342I = ((ActivityMain) getActivity()).m6199g();
            ab abVar = new ab();
            abVar.m7152a(this.f5342I, this);
            abVar.m7151a(new AnonymousClass39(this, i, z));
            this.f5342I.m7065a(new Runnable() {
                final /* synthetic */ C2720t f5315a;

                {
                    this.f5315a = r1;
                }

                public void run() {
                    this.f5315a.m7624b(this.f5315a.getView());
                }
            });
            this.f5342I.m7069c();
            ManagerApp.m7932w().m8893a("super_like_action", new bj() {
                final /* synthetic */ C2720t f5316a;

                {
                    this.f5316a = r1;
                }

                public void m7583a() {
                    C3095y.m9471a("Super Like Reminder Read success");
                    ManagerApp.m7914e().m8865p(true);
                }

                public void m7584b() {
                    C3095y.m9471a("Super Like Reminder Read failure");
                }
            });
            SparksEvent sparksEvent = new SparksEvent("SuperLikeTutorial.View");
            sparksEvent.put("from", Integer.valueOf(i));
            C2807a.m8056a(sparksEvent);
        }
    }

    public RelativeLayout m7698v() {
        return this.f5363m;
    }

    public float m7699w() {
        return this.f5363m.getScaleX();
    }

    public void m7700x() {
        this.f5336C = true;
    }

    public void m7701y() {
        this.f5336C = false;
        this.f5337D = false;
    }

    public void m7702z() {
        m7605R();
    }

    private void m7605R() {
        if (this.f5365o != null && m7606S()) {
            this.f5365o.onPause();
        }
    }

    private boolean m7606S() {
        return this.f5365o != null && this.f5365o.getCardMode() == CardMode.VIDEO_AD;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        C3077n.m9404a(this, i, i2, intent);
    }
}
