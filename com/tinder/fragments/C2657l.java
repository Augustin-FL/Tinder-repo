package com.tinder.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.stetho.BuildConfig;
import com.tinder.R;
import com.tinder.activities.ActivityLogin;
import com.tinder.adapters.C2361o;
import com.tinder.base.C2418c;
import com.tinder.dialogs.C2494n;
import com.tinder.enums.PhotoSizeUser;
import com.tinder.enums.ReportCause;
import com.tinder.fragments.C2657l.11.C26471;
import com.tinder.fragments.l.AnonymousClass10;
import com.tinder.fragments.l.AnonymousClass11;
import com.tinder.managers.C2807a;
import com.tinder.managers.C2913k;
import com.tinder.managers.C2956n;
import com.tinder.managers.ManagerApp;
import com.tinder.model.Match;
import com.tinder.model.SparksEvent;
import com.tinder.model.User;
import com.tinder.p030d.C2427c;
import com.tinder.p030d.ab;
import com.tinder.p030d.ac;
import com.tinder.p030d.ba;
import com.tinder.p030d.bg;
import com.tinder.p030d.bp;
import com.tinder.picassowebp.picasso.C2281x;
import com.tinder.picassowebp.picasso.Picasso;
import com.tinder.utils.C2508e;
import com.tinder.utils.C3077n;
import com.tinder.utils.C3095y;
import com.tinder.utils.aj;
import com.tinder.utils.al;
import com.tinder.views.VerifiedBadgeView;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.tinder.fragments.l */
public class C2657l extends C2418c implements OnPageChangeListener, ac, ba, C2427c {
    private int f5115a;
    private int f5116b;
    private int f5117c;
    private ViewPager f5118d;
    private ImageView f5119e;
    private TextView f5120f;
    private TextView f5121g;
    private TextView f5122h;
    private View f5123i;
    private View f5124j;
    private View f5125k;
    private View f5126l;
    private VerifiedBadgeView f5127m;
    private boolean f5128n;
    private boolean f5129o;
    private C2361o f5130p;
    @Nullable
    private Match f5131q;
    @Nullable
    private C2494n f5132r;
    private int f5133s;
    private int f5134t;
    private com.tinder.dialogs.ac f5135u;
    private User f5136v;

    /* renamed from: com.tinder.fragments.l.10 */
    class AnonymousClass10 implements Runnable {
        final /* synthetic */ Runnable f5100a;
        final /* synthetic */ boolean f5101b;
        final /* synthetic */ C2657l f5102c;

        AnonymousClass10(C2657l c2657l, Runnable runnable, boolean z) {
            this.f5102c = c2657l;
            this.f5100a = runnable;
            this.f5101b = z;
        }

        public void run() {
            this.f5102c.f5126l.setVisibility(8);
            this.f5102c.f5130p.m6438a(1);
            this.f5102c.f5130p.notifyDataSetChanged();
            this.f5102c.f5118d.postDelayed(this.f5100a, this.f5101b ? 300 : 600);
        }
    }

    /* renamed from: com.tinder.fragments.l.1 */
    class C26481 implements OnClickListener {
        final /* synthetic */ C2657l f5105a;

        C26481(C2657l c2657l) {
            this.f5105a = c2657l;
        }

        public void onClick(View view) {
            this.f5105a.f5118d.setCurrentItem(0);
        }
    }

    /* renamed from: com.tinder.fragments.l.2 */
    class C26492 implements bg {
        final /* synthetic */ C2657l f5106a;

        C26492(C2657l c2657l) {
            this.f5106a = c2657l;
        }

        public void m7391a(@NonNull ReportCause reportCause, String str) {
            if (!this.f5106a.f5129o) {
                this.f5106a.f5129o = true;
                this.f5106a.m7403a(reportCause, str, false);
            }
        }
    }

    /* renamed from: com.tinder.fragments.l.3 */
    class C26503 implements bp {
        final /* synthetic */ C2657l f5107a;

        C26503(C2657l c2657l) {
            this.f5107a = c2657l;
        }

        public void m7392a(@Nullable ReportCause reportCause, String str) {
            if (!this.f5107a.f5128n && !this.f5107a.f5129o) {
                this.f5107a.f5128n = true;
                if (reportCause != null) {
                    this.f5107a.m7403a(reportCause, str, true);
                }
                this.f5107a.m7402a(reportCause, str);
            }
        }
    }

    /* renamed from: com.tinder.fragments.l.4 */
    class C26514 implements OnClickListener {
        final /* synthetic */ C2657l f5108a;

        C26514(C2657l c2657l) {
            this.f5108a = c2657l;
        }

        public void onClick(View view) {
            this.f5108a.f5118d.setCurrentItem(1);
        }
    }

    /* renamed from: com.tinder.fragments.l.5 */
    class C26525 implements OnClickListener {
        final /* synthetic */ C2657l f5109a;

        C26525(C2657l c2657l) {
            this.f5109a = c2657l;
        }

        public void onClick(View view) {
            if (!al.m9297c(this.f5109a.f5132r)) {
                Match a = ManagerApp.m7925p().m8266a(this.f5109a.f5131q.getId());
                if (a == null) {
                    a = this.f5109a.f5131q;
                }
                this.f5109a.f5132r = new C2494n(this.f5109a.getActivity(), this.f5109a, a, null);
                this.f5109a.f5132r.show();
            }
        }
    }

    /* renamed from: com.tinder.fragments.l.6 */
    class C26536 implements OnClickListener {
        final /* synthetic */ C2657l f5110a;

        C26536(C2657l c2657l) {
            this.f5110a = c2657l;
        }

        public void onClick(View view) {
            this.f5110a.m7433b();
        }
    }

    /* renamed from: com.tinder.fragments.l.7 */
    class C26547 implements OnClickListener {
        final /* synthetic */ C2657l f5111a;

        C26547(C2657l c2657l) {
            this.f5111a = c2657l;
        }

        public void onClick(View view) {
            this.f5111a.m7433b();
        }
    }

    /* renamed from: com.tinder.fragments.l.8 */
    class C26558 implements Runnable {
        final /* synthetic */ C2657l f5112a;

        C26558(C2657l c2657l) {
            this.f5112a = c2657l;
        }

        public void run() {
            this.f5112a.f5116b = this.f5112a.f5122h.getWidth();
            this.f5112a.f5115a = this.f5112a.f5121g.getWidth();
            this.f5112a.f5125k.getLayoutParams().width = this.f5112a.f5115a;
            this.f5112a.f5125k.setLayoutParams(this.f5112a.f5125k.getLayoutParams());
            this.f5112a.m7400a(0);
        }
    }

    /* renamed from: com.tinder.fragments.l.9 */
    class C26569 implements Runnable {
        final /* synthetic */ Activity f5113a;
        final /* synthetic */ C2657l f5114b;

        C26569(C2657l c2657l, Activity activity) {
            this.f5114b = c2657l;
            this.f5113a = activity;
        }

        public void run() {
            this.f5114b.f5130p.m6438a(2);
            this.f5114b.f5130p.notifyDataSetChanged();
            C2657l.m7417e(this.f5114b.f5131q);
            this.f5114b.m7401a((ab) this.f5113a);
            C2745x b = this.f5114b.f5130p.m6439b();
            if (b != null) {
                b.m7810a(this.f5114b.f5131q);
            }
        }
    }

    public C2657l() {
        this.f5128n = false;
        this.f5129o = false;
    }

    @NonNull
    public static C2657l m7396a(@NonNull Match match) {
        return C2657l.m7397a(match, false);
    }

    @NonNull
    public static C2657l m7397a(@NonNull Match match, boolean z) {
        return C2657l.m7398a(match, z, null);
    }

    @NonNull
    public static C2657l m7398a(@NonNull Match match, boolean z, @Nullable String str) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("match", match);
        bundle.putBoolean("background", z);
        if (str != null) {
            bundle.putString("moment-dialog-like-id", str);
        }
        C2657l c2657l = new C2657l();
        c2657l.setArguments(bundle);
        return c2657l;
    }

    private static void m7417e(Match match) {
        ManagerApp.m7925p().m8270a(match);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (ManagerApp.m7911b().m8144e()) {
            this.f5131q = (Match) getArguments().getSerializable("match");
            if (!m7421h()) {
                ab abVar = (ab) getActivity();
                m7410b(abVar.m6123r());
                abVar.m6124s();
            }
        } else {
            Intent intent = new Intent(getActivity(), ActivityLogin.class);
            Bundle bundle2 = new Bundle();
            bundle2.putString("extra_show_intro", BuildConfig.FLAVOR);
            intent.putExtras(bundle2);
            startActivity(intent);
            getActivity().finish();
        }
        this.f5133s = getResources().getColor(R.color.orange);
        this.f5134t = getResources().getColor(R.color.ab_text_color);
        ((ab) getActivity()).m6119a(this.f5131q);
        String str = null;
        if (getArguments() != null) {
            str = getArguments().getString("moment-dialog-like-id");
        }
        this.f5130p = new C2361o(getChildFragmentManager(), str);
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        C3095y.m9485e("ENTER");
        View inflate = layoutInflater.inflate(R.layout.view_fragment_match, viewGroup, false);
        this.f5123i = inflate.findViewById(R.id.img_overflow);
        this.f5124j = inflate.findViewById(R.id.img_back);
        this.f5126l = inflate.findViewById(R.id.progress);
        this.f5125k = inflate.findViewById(R.id.underline);
        this.f5122h = (TextView) inflate.findViewById(R.id.txt_about);
        this.f5121g = (TextView) inflate.findViewById(R.id.txt_messages);
        this.f5120f = (TextView) inflate.findViewById(R.id.txt_name);
        this.f5119e = (ImageView) inflate.findViewById(R.id.img_avatar);
        this.f5118d = (ViewPager) inflate.findViewById(R.id.pager_match);
        this.f5118d.setOffscreenPageLimit(2);
        this.f5127m = (VerifiedBadgeView) inflate.findViewById(R.id.verified_badge);
        if (getArguments().getBoolean("background")) {
            inflate.setBackgroundColor(getResources().getColor(R.color.white));
        }
        return inflate;
    }

    public void onResume() {
        super.onResume();
        ((ab) getActivity()).m6118a(this);
    }

    public void onPause() {
        super.onPause();
        ((ab) getActivity()).m6118a(null);
        C2657l.m7417e(this.f5131q);
    }

    public void onDestroy() {
        al.m9297c(this.f5132r);
        al.m9297c(this.f5135u);
        super.onDestroy();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        m7428a();
        super.onViewCreated(view, bundle);
    }

    private boolean m7421h() {
        if (this.f5131q != null) {
            return false;
        }
        FragmentActivity activity = getActivity();
        if (activity != null && (activity instanceof ab)) {
            ((ab) activity).m6127w();
        }
        return true;
    }

    public void m7428a() {
        if (m7421h()) {
            C3095y.m9479c("Attempted to init the match fragment without a match set!");
            return;
        }
        boolean z = !this.f5131q.getMessages().isEmpty();
        if (this.f5131q.hasNewMessage()) {
            aj.m9235a().m9240e();
        }
        PhotoSizeUser a = al.m9265a(getActivity());
        C2281x c2508e = new C2508e(this.f5119e);
        this.f5119e.setTag(c2508e);
        String avatarUrl = this.f5131q.getPerson().getAvatarUrl(0, a);
        if (TextUtils.isEmpty(avatarUrl)) {
            Picasso.m8982a(getActivity()).m8987a((int) R.drawable.addaphoto_loader_icon).m9121a((int) R.dimen.match_frag_avatar_length, (int) R.dimen.match_frag_avatar_length).m9127b().m9126a(c2508e);
        } else {
            Picasso.m8982a(getActivity()).m8990a(avatarUrl).m9121a((int) R.dimen.match_frag_avatar_length, (int) R.dimen.match_frag_avatar_length).m9127b().m9128b(R.drawable.addaphoto_loader_icon).m9126a(c2508e);
        }
        this.f5120f.setText(this.f5131q.getPerson().getName());
        this.f5118d.setAdapter(this.f5130p);
        this.f5118d.addOnPageChangeListener(this);
        this.f5130p.notifyDataSetChanged();
        this.f5121g.setOnClickListener(new C26481(this));
        this.f5122h.setOnClickListener(new C26514(this));
        this.f5123i.setOnClickListener(new C26525(this));
        al.m9287b(this.f5119e);
        this.f5119e.setOnClickListener(new C26536(this));
        this.f5124j.setOnClickListener(new C26547(this));
        Activity activity = getActivity();
        this.f5117c = activity.getResources().getDimensionPixelSize(R.dimen.frag_match_icons_spacing);
        this.f5118d.post(new C26558(this));
        this.f5118d.postDelayed(new AnonymousClass10(this, new C26569(this, activity), z), z ? 450 : 0);
        this.f5127m.displayBadge(this.f5131q);
    }

    private void m7401a(@Nullable ab abVar) {
        if (abVar == null || abVar.m6122q()) {
            m7400a(1);
            this.f5118d.setCurrentItem(1, true);
            return;
        }
        m7400a(0);
        this.f5118d.setCurrentItem(0, true);
    }

    public void m7433b() {
        ((ab) getActivity()).m6125t();
    }

    private void m7400a(int i) {
        if (i == 0) {
            this.f5121g.setTextColor(this.f5133s);
            this.f5122h.setTextColor(this.f5134t);
            m7399a(0.0f);
            return;
        }
        this.f5121g.setTextColor(this.f5134t);
        this.f5122h.setTextColor(this.f5133s);
        m7399a(1.0f);
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (i == 0) {
            m7399a(f);
        } else {
            m7399a(1.0f);
        }
    }

    public void onPageSelected(int i) {
        m7400a(i);
        if (i == 0) {
            m7410b(false);
            m7399a(0.0f);
        } else if (this.f5131q != null) {
            C2913k.m8575a(this.f5131q.getPerson().getId(), (ba) this);
            m7423i();
            m7399a(1.0f);
        }
    }

    public void onPageScrollStateChanged(int i) {
        if (i == 1 || i == 2) {
            al.m9272a(this.f5118d, true);
        } else {
            al.m9272a(this.f5118d, false);
        }
    }

    private void m7399a(float f) {
        if (this.f5115a != 0 && this.f5116b != 0) {
            this.f5125k.setPivotX(0.0f);
            this.f5125k.setScaleX(((float) ((int) C3077n.m9399a(f, 0.0f, (float) this.f5115a, 1.0f, (float) this.f5116b))) / ((float) this.f5115a));
            this.f5125k.setTranslationX((float) ((int) C3077n.m9399a(f, 0.0f, 0.0f, 1.0f, ((float) this.f5115a) + (((float) this.f5117c) * 1.1f))));
        }
    }

    private void m7423i() {
        if (getActivity().getCurrentFocus() != null) {
            al.m9268a(getActivity().getCurrentFocus().getWindowToken(), getActivity());
        }
    }

    private void m7410b(boolean z) {
        User d = ManagerApp.m7922m().m8599d();
        SparksEvent sparksEvent = new SparksEvent("Chat.Open");
        sparksEvent.put("otherId", this.f5131q.getPerson().getId());
        sparksEvent.put("matchId", this.f5131q.getId());
        sparksEvent.put("fromPush", Boolean.valueOf(z));
        sparksEvent.put("superLike", Boolean.valueOf(this.f5131q.isTheSuperLiker(d)));
        sparksEvent.put("didSuperLike", Boolean.valueOf(this.f5131q.superLikerIsThem()));
        C2807a.m8056a(sparksEvent);
    }

    private void m7425j() {
        boolean z = true;
        if (!m7421h()) {
            SparksEvent sparksEvent = new SparksEvent("Chat.OpenProfile");
            sparksEvent.put("otherId", this.f5131q.getPerson().getId());
            sparksEvent.put("matchId", this.f5131q.getId());
            if (this.f5136v != null) {
                int i = !TextUtils.isEmpty(this.f5136v.getNearByLocationName()) ? 2 : 1;
                sparksEvent.put("location", Integer.valueOf(i));
                C3095y.m9471a("analytics location value: " + i);
                if (this.f5136v.getInstagramDataSet() != null) {
                    if (!TextUtils.isEmpty(this.f5136v.getInstagramDataSet().getUserName())) {
                        sparksEvent.put("instagramName", this.f5136v.getInstagramDataSet().getUserName());
                    }
                    if (this.f5136v.getInstagramDataSet().getMediaCount() != 0) {
                        sparksEvent.put("photoTotal", Integer.valueOf(this.f5136v.getInstagramDataSet().getMediaCount()));
                    }
                }
                User d = ManagerApp.m7922m().m8599d();
                if (!(this.f5131q.isSuperlike() && d != null && TextUtils.equals(d.getId(), this.f5131q.getSuperLiker()))) {
                    z = false;
                }
                sparksEvent.put("superLike", Boolean.valueOf(z));
                sparksEvent.put("didSuperLike", Boolean.valueOf(this.f5131q.superLikerIsThem()));
            }
            C2807a.m8056a(sparksEvent);
        }
    }

    private void m7402a(@Nullable ReportCause reportCause, String str) {
        if (reportCause != null) {
            m7403a(reportCause, str, true);
        }
        Match p = ((ab) getActivity()).m6121p();
        if (p != null) {
            ManagerApp.m7925p().m8272a(p.getId(), reportCause, str, (C2427c) this);
        }
    }

    public void m7429a(Match match, String str, @Nullable ReportCause reportCause) {
        if (!m7421h()) {
            SparksEvent sparksEvent = new SparksEvent("Chat.Block");
            sparksEvent.put("matchId", this.f5131q.getId());
            sparksEvent.put("otherId", this.f5131q.getPerson().getId());
            if (reportCause != null) {
                sparksEvent.put("reportReason", reportCause.getAnalyticsValue());
            }
            C2807a.m8056a(sparksEvent);
            if (getActivity() != null) {
                Toast.makeText(getActivity(), getString(R.string.blocked), 1).show();
                m7433b();
            }
            this.f5128n = false;
        }
    }

    public void m7434b(Match match) {
        if (getActivity() != null) {
            Toast.makeText(getActivity(), getString(R.string.block_failed), 1).show();
        }
        this.f5128n = false;
    }

    public void m7430a(@NonNull Match match, String str, String str2, @NonNull ReportCause reportCause, boolean z) {
        SparksEvent sparksEvent = new SparksEvent("Chat.Report");
        sparksEvent.put("reason", reportCause.getAnalyticsValue());
        sparksEvent.put("otherId", match.getPerson().getId());
        sparksEvent.put("matchId", str);
        if (!TextUtils.isEmpty(str2)) {
            sparksEvent.put(FacebookRequestErrorClassification.KEY_OTHER, str2);
        }
        if (z) {
            sparksEvent.put("blocked", Boolean.valueOf(true));
        }
        C2807a.m8056a(sparksEvent);
        if (!(z || getActivity() == null || this.f5135u == null)) {
            new Timer().schedule(new TimerTask() {
                final /* synthetic */ C2657l f5104a;

                /* renamed from: com.tinder.fragments.l.11.1 */
                class C26471 implements Runnable {
                    final /* synthetic */ AnonymousClass11 f5103a;

                    C26471(AnonymousClass11 anonymousClass11) {
                        this.f5103a = anonymousClass11;
                    }

                    public void run() {
                        this.f5103a.f5104a.f5135u.m6828n();
                    }
                }

                {
                    this.f5104a = r1;
                }

                public void run() {
                    this.f5104a.getActivity().runOnUiThread(new C26471(this));
                }
            }, 2500);
        }
        this.f5129o = false;
    }

    public void m7436c(Match match) {
        if (getActivity() != null) {
            Toast.makeText(getActivity(), getString(R.string.reported_warning_accept_agreement_error), 1).show();
        }
        this.f5129o = false;
        if (this.f5135u != null) {
            this.f5135u.m6829o();
        }
    }

    private void m7403a(@NonNull ReportCause reportCause, String str, boolean z) {
        if (!m7421h()) {
            ManagerApp.m7929t().m8750a(ManagerApp.m7925p(), this.f5131q, str, reportCause, z, this, null);
        }
    }

    public void m7435c() {
        this.f5118d.setCurrentItem(1);
    }

    public void m7437d() {
        this.f5130p.m6437a();
    }

    public void m7438e() {
        this.f5135u = C2956n.m8743a(getActivity(), new C26492(this), this.f5131q);
        this.f5135u.show();
    }

    public void m7439f() {
        C2956n.m8745a(getActivity(), new C26503(this)).show();
    }

    public void m7431a(User user) {
        if (this.f5136v == null || !this.f5136v.equals(user)) {
            this.f5136v = user;
            C2745x b = this.f5130p.m6439b();
            if (b != null) {
                b.m7811a(user);
            }
        }
        m7425j();
    }

    public void m7440g() {
        Toast.makeText(ManagerApp.m7917h(), R.string.error_profile, 1).show();
        m7425j();
    }

    public void m7432a(boolean z) {
        if (!m7421h()) {
            String id = this.f5131q.getId();
            String id2 = this.f5131q.getPerson().getId();
            ManagerApp.m7925p().m8274a(id, z);
            SparksEvent sparksEvent;
            if (z) {
                C2913k.m8574a(id2);
                sparksEvent = new SparksEvent("Moments.Unhide");
                sparksEvent.put("otherId", id2);
                sparksEvent.put("matchId", id);
                sparksEvent.put("from", Integer.valueOf(2));
                C2807a.m8056a(sparksEvent);
                return;
            }
            C2913k.m8582b(id2);
            sparksEvent = new SparksEvent("Moments.Hide");
            sparksEvent.put("otherId", id2);
            sparksEvent.put("matchId", id);
            sparksEvent.put("from", Integer.valueOf(2));
            C2807a.m8056a(sparksEvent);
        }
    }
}
