package com.tinder.fragments;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.share.internal.ShareConstants;
import com.tinder.R;
import com.tinder.activities.ActivityMomentGame;
import com.tinder.dialogs.C2515r;
import com.tinder.dialogs.C2543y;
import com.tinder.dialogs.ac;
import com.tinder.dialogs.af;
import com.tinder.enums.RateType;
import com.tinder.enums.ReportCause;
import com.tinder.managers.C2807a;
import com.tinder.managers.C2913k;
import com.tinder.managers.C2956n;
import com.tinder.managers.ManagerApp;
import com.tinder.model.Match;
import com.tinder.model.Moment;
import com.tinder.model.SparksEvent;
import com.tinder.p030d.C2427c;
import com.tinder.p030d.ab;
import com.tinder.p030d.ai;
import com.tinder.p030d.aj;
import com.tinder.p030d.am;
import com.tinder.p030d.bg;
import com.tinder.p030d.bp;
import com.tinder.p030d.bt;
import com.tinder.utils.C3064c;
import com.tinder.utils.C3064c.C2669b;
import com.tinder.utils.C3095y;
import com.tinder.utils.al;
import com.tinder.views.MomentCard;
import com.tinder.views.StackLayout;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.tinder.fragments.n */
public class C2678n extends Fragment implements ai, aj, am, bt, C2427c {
    private StackLayout f5181a;
    private View f5182b;
    private MomentCard f5183c;
    private C2543y f5184d;
    private C2515r f5185e;
    private Match f5186f;
    private ac f5187g;
    private af f5188h;
    private boolean f5189i;
    private boolean f5190j;
    private int f5191k;

    /* renamed from: com.tinder.fragments.n.1 */
    class C26701 implements C2669b {
        String f5165a;
        String f5166b;
        String f5167c;
        final /* synthetic */ C2678n f5168d;

        C26701(C2678n c2678n) {
            this.f5168d = c2678n;
            this.f5165a = this.f5168d.f5183c.getUserId();
            this.f5166b = this.f5168d.f5183c.getUserId();
            this.f5167c = this.f5168d.f5186f.getId();
        }

        public void m7472a() {
            SparksEvent sparksEvent = new SparksEvent("Moments.Pass");
            sparksEvent.put("momentId", this.f5165a);
            sparksEvent.put("otherId", this.f5166b);
            sparksEvent.put("matchId", this.f5167c);
            C2807a.m8056a(sparksEvent);
        }
    }

    /* renamed from: com.tinder.fragments.n.2 */
    class C26712 implements C2669b {
        String f5169a;
        String f5170b;
        String f5171c;
        final /* synthetic */ boolean f5172d;
        final /* synthetic */ C2678n f5173e;

        C26712(C2678n c2678n, boolean z) {
            this.f5173e = c2678n;
            this.f5172d = z;
            this.f5169a = this.f5173e.f5183c.getUserId();
            this.f5170b = this.f5173e.f5183c.getUserId();
            this.f5171c = this.f5173e.f5186f.getId();
        }

        public void m7473a() {
            SparksEvent sparksEvent = new SparksEvent("Moments.Like");
            sparksEvent.put("momentId", this.f5169a);
            sparksEvent.put("otherId", this.f5170b);
            sparksEvent.put("matchId", this.f5171c);
            sparksEvent.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, Boolean.valueOf(this.f5172d));
            C2807a.m8056a(sparksEvent);
        }
    }

    /* renamed from: com.tinder.fragments.n.3 */
    class C26723 implements Runnable {
        final /* synthetic */ Match f5174a;
        final /* synthetic */ C2678n f5175b;

        C26723(C2678n c2678n, Match match) {
            this.f5175b = c2678n;
            this.f5174a = match;
        }

        public void run() {
            ((ab) this.f5175b.getActivity()).m6120a(this.f5174a, false);
        }
    }

    /* renamed from: com.tinder.fragments.n.4 */
    class C26734 implements bg {
        final /* synthetic */ C2678n f5176a;

        C26734(C2678n c2678n) {
            this.f5176a = c2678n;
        }

        public void m7474a(@NonNull ReportCause reportCause, String str) {
            this.f5176a.m7479a(reportCause, str, false, this.f5176a.f5183c.getMomentId());
        }
    }

    /* renamed from: com.tinder.fragments.n.5 */
    class C26745 implements bp {
        final /* synthetic */ C2678n f5177a;

        C26745(C2678n c2678n) {
            this.f5177a = c2678n;
        }

        public void m7475a(ReportCause reportCause, String str) {
            ManagerApp.m7926q().m8473c(this.f5177a.f5183c.getUserId());
            this.f5177a.m7478a(reportCause, str);
        }
    }

    /* renamed from: com.tinder.fragments.n.6 */
    class C26766 extends TimerTask {
        final /* synthetic */ C2678n f5179a;

        /* renamed from: com.tinder.fragments.n.6.1 */
        class C26751 implements Runnable {
            final /* synthetic */ C26766 f5178a;

            C26751(C26766 c26766) {
                this.f5178a = c26766;
            }

            public void run() {
                this.f5178a.f5179a.f5187g.m6828n();
            }
        }

        C26766(C2678n c2678n) {
            this.f5179a = c2678n;
        }

        public void run() {
            this.f5179a.getActivity().runOnUiThread(new C26751(this));
        }
    }

    /* renamed from: com.tinder.fragments.n.7 */
    class C26777 implements OnDismissListener {
        final /* synthetic */ C2678n f5180a;

        C26777(C2678n c2678n) {
            this.f5180a = c2678n;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            this.f5180a.m7490r();
            this.f5180a.f5187g.setOnDismissListener(null);
        }
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.view_fragment_moment_game, viewGroup, false);
    }

    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f5182b = ((ActivityMomentGame) getActivity()).m6240e();
        this.f5181a = (StackLayout) view.findViewById(R.id.moment_game_stacklayout);
        this.f5191k = ((ActivityMomentGame) getActivity()).m6243h() ? 3 : 0;
        m7485m();
    }

    public void onDestroyView() {
        super.onDestroyView();
        al.m9297c(this.f5185e);
    }

    private void m7485m() {
        C3095y.m9469a();
        boolean z = this.f5183c == null;
        int f = ((ActivityMomentGame) getActivity()).m6241f();
        C3095y.m9471a("momentsCount " + f);
        Moment a = ((ActivityMomentGame) getActivity()).m6234a(f - 1);
        Moment a2 = ((ActivityMomentGame) getActivity()).m6234a(f - 2);
        ((ActivityMomentGame) getActivity()).m6234a(f - 3);
        Moment a3 = ((ActivityMomentGame) getActivity()).m6234a(f - 4);
        if (!this.f5190j && f != 0) {
            MomentCard momentCard;
            if (z) {
                this.f5183c = new MomentCard(getActivity());
                momentCard = new MomentCard(getActivity());
                View momentCard2 = new MomentCard(getActivity());
                View momentCard3 = new MomentCard(getActivity());
                m7495a(this.f5183c, a);
                m7495a(momentCard, a2);
                this.f5181a.setViewOffsetDp(13.0f, (float) this.f5183c.getCardHeight());
                if (f >= 3) {
                    if (f > 3) {
                        this.f5181a.setUseMockView(true);
                        this.f5181a.addView(momentCard3);
                    }
                    this.f5181a.addView(momentCard2);
                    this.f5181a.addView(momentCard);
                    this.f5181a.addView(this.f5183c);
                    this.f5181a.setTranslationY((float) ((-this.f5181a.getYOffset()) / 2));
                } else if (f == 2) {
                    this.f5181a.addView(momentCard);
                    this.f5181a.addView(this.f5183c);
                    this.f5181a.setTranslationY((float) ((-this.f5181a.getYOffset()) / 4));
                } else if (f == 1) {
                    this.f5181a.addView(this.f5183c);
                    this.f5190j = true;
                }
            } else if (f >= 3) {
                this.f5183c.removeListener();
                r1 = this.f5181a.reorder(this.f5183c, false);
                this.f5183c = (MomentCard) this.f5181a.getChildAt(r1);
                momentCard = (MomentCard) this.f5181a.getChildAt(r1 - 1);
                m7495a(this.f5183c, a);
                m7495a(momentCard, a2);
                if (f > 3) {
                    m7495a((MomentCard) this.f5181a.getChildAt(r1 - 3), a3);
                } else {
                    this.f5181a.removeMockView();
                }
            } else if (f == 2) {
                this.f5183c.removeListener();
                r1 = this.f5181a.reorder(this.f5183c, true);
                this.f5183c = (MomentCard) this.f5181a.getChildAt(r1);
                momentCard = (MomentCard) this.f5181a.getChildAt(r1 - 1);
                m7495a(this.f5183c, a);
                m7495a(momentCard, a2);
                this.f5181a.setUseMockView(false);
            } else if (f == 1) {
                this.f5183c.removeListener();
                this.f5183c = (MomentCard) this.f5181a.getChildAt(this.f5181a.reorder(this.f5183c, true));
                m7495a(this.f5183c, a);
                this.f5181a.setUseMockView(false);
                this.f5190j = true;
            }
            if (this.f5183c != null) {
                this.f5183c.setCardListener(this);
                this.f5183c.setOnClickWithEventListener(this);
                if (!(Moment.isMockMoment(this.f5183c.getMomentId()) || this.f5186f == null)) {
                    C2807a.m8056a(m7476a("Moments.View"));
                }
            }
            this.f5186f = ManagerApp.m7925p().m8279b(a.getUserId());
        } else if (!this.f5189i) {
            m7486n();
        }
    }

    public void m7495a(@Nullable MomentCard momentCard, @Nullable Moment moment) {
        Object obj = (momentCard == null || moment == null) ? null : 1;
        if (obj != null) {
            momentCard.setMoment(moment);
        }
    }

    private void m7486n() {
        ((ActivityMomentGame) getActivity()).m6247l();
    }

    private void m7487o() {
        String momentId = this.f5183c.getMomentId();
        Object obj = (Moment.isMockMoment(momentId) || ManagerApp.m7926q().m8476d(momentId)) ? 1 : null;
        if (obj != null) {
            ManagerApp.m7926q().m8463a(this.f5183c.getMomentId(), (am) this);
            ((ActivityMomentGame) getActivity()).m6239a(this.f5183c.getMomentId());
        }
        m7485m();
    }

    private void m7488p() {
        String momentId = this.f5183c.getMomentId();
        Object obj = (Moment.isMockMoment(momentId) || ManagerApp.m7926q().m8476d(momentId)) ? 1 : null;
        if (obj != null) {
            ManagerApp.m7926q().m8470b(this.f5183c.getMomentId(), (am) this);
            ((ActivityMomentGame) getActivity()).m6239a(this.f5183c.getMomentId());
        }
        m7485m();
    }

    public void m7496a(boolean z) {
        if (!Moment.isMockMoment(this.f5183c.getMomentId())) {
            C3064c.m9337a(new C26701(this)).m9341a();
        }
        m7488p();
    }

    public void m7499b(boolean z) {
        if (!Moment.isMockMoment(this.f5183c.getMomentId())) {
            C3064c.m9337a(new C26712(this, z)).m9341a();
        }
        m7487o();
    }

    public void m7502c(boolean z) {
    }

    public void m7491a() {
        m7486n();
    }

    public void m7492a(float f, float f2, float f3, float f4, boolean z) {
        this.f5181a.applyShifting(f, z);
        if (!this.f5190j) {
            return;
        }
        if (z) {
            this.f5182b.animate().alpha(1.0f).start();
        } else if (((double) f) != 0.0d) {
            this.f5182b.setAlpha(1.0f - f);
        }
    }

    public void m7497b() {
        if (this.f5186f != null) {
            ((ActivityMomentGame) getActivity()).m6238a(this.f5186f, false);
        }
    }

    public void m7500c() {
        this.f5184d = new C2543y(getActivity(), this, this.f5186f);
        this.f5184d.show();
    }

    public void m7503d() {
        m7508i();
    }

    public void m7504e() {
    }

    public void m7505f() {
    }

    public void m7506g() {
    }

    public void m7507h() {
    }

    private void m7478a(@Nullable ReportCause reportCause, String str) {
        C3095y.m9471a("blockMatch");
        this.f5185e = new C2515r(getActivity());
        this.f5185e.show();
        if (reportCause != null) {
            m7479a(reportCause, str, true, this.f5183c.getMomentId());
        }
        ManagerApp.m7925p().m8272a(this.f5186f.getId(), reportCause, str, (C2427c) this);
    }

    public void m7508i() {
        if (this.f5186f != null) {
            Match match = this.f5186f;
            if (this.f5181a.getChildCount() == 1) {
                this.f5189i = true;
                ((ActivityMomentGame) getActivity()).m6246k();
            }
            this.f5183c.animateTouchlessSwipe(RateType.LIKE, null);
            this.f5181a.animateToNextItem(true);
            this.f5181a.postDelayed(new C26723(this, match), 450);
        }
    }

    public void m7509j() {
        C3095y.m9469a();
        String userId = this.f5183c.getUserId();
        C2913k.m8582b(userId);
        ((ActivityMomentGame) getActivity()).m6242g();
        ManagerApp.m7926q().m8473c(userId);
        SparksEvent sparksEvent = new SparksEvent("Moments.Hide");
        sparksEvent.put("otherId", userId);
        sparksEvent.put("matchId", this.f5186f.getId());
        sparksEvent.put("from", Integer.valueOf(0));
        C2807a.m8056a(sparksEvent);
        this.f5183c.throwAwayCard();
        this.f5181a.animateToNextItem(true);
    }

    public void m7510k() {
        this.f5187g = C2956n.m8743a(getActivity(), new C26734(this), this.f5186f);
        this.f5187g.show();
    }

    public void m7511l() {
        this.f5188h = new af(getActivity(), new C26745(this));
        this.f5188h.show();
    }

    public void m7493a(Match match, String str, @Nullable ReportCause reportCause) {
        SparksEvent a = m7476a("Moments.Block");
        if (reportCause != null) {
            a.put("reportReason", reportCause.getAnalyticsValue());
        }
        C2807a.m8056a(a);
        al.m9297c(this.f5185e);
        ManagerApp.m7926q().m8473c(this.f5186f.getPerson().getId());
        ((ActivityMomentGame) getActivity()).m6242g();
        m7490r();
        Toast.makeText(getActivity(), R.string.blocked, 0).show();
    }

    public void m7498b(Match match) {
        al.m9297c(this.f5185e);
        Toast.makeText(getActivity(), R.string.block_failed, 0).show();
    }

    public void m7494a(Match match, String str, String str2, @NonNull ReportCause reportCause, boolean z) {
        SparksEvent a = m7476a("Moments.Report");
        a.put("reason", reportCause.getAnalyticsValue());
        if (!TextUtils.isEmpty(str2)) {
            a.put(FacebookRequestErrorClassification.KEY_OTHER, str2);
        }
        if (z) {
            a.put("blocked", Boolean.valueOf(true));
        } else {
            m7489q();
        }
        C2807a.m8056a(a);
        if (!z && getActivity() != null && this.f5187g != null) {
            new Timer().schedule(new C26766(this), 2500);
        }
    }

    public void m7501c(Match match) {
        Toast.makeText(getActivity(), R.string.reported_warning_accept_agreement_error, 0).show();
    }

    @NonNull
    private SparksEvent m7476a(@NonNull String str) {
        String str2 = str.equals("Moments.View") ? "viewedFrom" : "from";
        SparksEvent sparksEvent = new SparksEvent(str);
        sparksEvent.put("momentId", this.f5183c.getMomentId());
        sparksEvent.put("otherId", this.f5183c.getUserId());
        sparksEvent.put("matchId", this.f5186f.getId());
        sparksEvent.put(str2, Integer.valueOf(this.f5191k));
        return sparksEvent;
    }

    private void m7479a(@NonNull ReportCause reportCause, String str, boolean z, String str2) {
        ManagerApp.m7929t().m8750a(ManagerApp.m7925p(), this.f5186f, str, reportCause, z, this, str2);
    }

    private void m7489q() {
        if (this.f5187g != null) {
            this.f5187g.setOnDismissListener(new C26777(this));
        }
    }

    private void m7490r() {
        this.f5183c.throwAwayCard();
        this.f5181a.animateToNextItem(true);
    }

    public void onClick(MotionEvent motionEvent, View view) {
        m7491a();
    }
}
