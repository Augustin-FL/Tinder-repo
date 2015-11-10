package com.tinder.fragments;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import com.tinder.R;
import com.tinder.activities.ActivityMain;
import com.tinder.activities.ActivityMomentGame;
import com.tinder.adapters.C2341g;
import com.tinder.adapters.C2386y;
import com.tinder.dialogs.C2472h;
import com.tinder.managers.C2807a;
import com.tinder.managers.C2855f;
import com.tinder.managers.C2913k;
import com.tinder.managers.ManagerApp;
import com.tinder.model.Match;
import com.tinder.model.SparksEvent;
import com.tinder.p030d.ab;
import com.tinder.p030d.ae;
import com.tinder.p030d.aq;
import com.tinder.p030d.bu;
import com.tinder.utils.C3095y;
import com.tinder.utils.al;
import com.tinder.views.DirectionOnScrollListener;
import com.tinder.views.DirectionOnScrollListener.ListenerScrollDirection;
import com.tinder.views.MomentsStack;
import java.util.List;
import uk.co.senab.actionbarpulltorefresh.library.PullToRefreshLayout;
import uk.co.senab.actionbarpulltorefresh.library.p034a.C2667b;

/* renamed from: com.tinder.fragments.m */
public class C2668m extends Fragment implements OnDismissListener, ae, aq, ListenerScrollDirection, C2667b {
    private MomentsStack f5149a;
    private LinearLayout f5150b;
    private PullToRefreshLayout f5151c;
    private PullToRefreshLayout f5152d;
    private C2386y f5153e;
    private C2341g f5154f;
    private ListView f5155g;
    private ListView f5156h;
    private FrameLayout f5157i;
    private View f5158j;
    private View f5159k;
    private boolean f5160l;
    private C2472h f5161m;
    private boolean f5162n;
    private LinearLayout f5163o;
    private int f5164p;

    /* renamed from: com.tinder.fragments.m.1 */
    class C26581 implements OnClickListener {
        final /* synthetic */ C2668m f5137a;

        C26581(C2668m c2668m) {
            this.f5137a = c2668m;
        }

        public void onClick(View view) {
            ((ActivityMain) this.f5137a.getActivity()).m6201i();
        }
    }

    /* renamed from: com.tinder.fragments.m.2 */
    class C26592 implements OnClickListener {
        final /* synthetic */ C2668m f5138a;

        C26592(C2668m c2668m) {
            this.f5138a = c2668m;
        }

        public void onClick(View view) {
            al.m9297c(this.f5138a.f5161m);
        }
    }

    /* renamed from: com.tinder.fragments.m.3 */
    class C26603 implements OnClickListener {
        final /* synthetic */ Match f5139a;
        final /* synthetic */ C2668m f5140b;

        C26603(C2668m c2668m, Match match) {
            this.f5140b = c2668m;
            this.f5139a = match;
        }

        public void onClick(View view) {
            al.m9297c(this.f5140b.f5161m);
            this.f5140b.m7447c(this.f5139a);
        }
    }

    /* renamed from: com.tinder.fragments.m.4 */
    class C26614 extends AnimatorListenerAdapter {
        final /* synthetic */ View f5141a;
        final /* synthetic */ C2668m f5142b;

        C26614(C2668m c2668m, View view) {
            this.f5142b = c2668m;
            this.f5141a = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.f5141a.setVisibility(8);
        }
    }

    /* renamed from: com.tinder.fragments.m.5 */
    class C26625 extends AnimatorListenerAdapter {
        final /* synthetic */ View f5143a;
        final /* synthetic */ C2668m f5144b;

        C26625(C2668m c2668m, View view) {
            this.f5144b = c2668m;
            this.f5143a = view;
        }

        public void onAnimationStart(Animator animator) {
            this.f5143a.setVisibility(0);
        }
    }

    /* renamed from: com.tinder.fragments.m.6 */
    class C26636 implements Runnable {
        final /* synthetic */ C2668m f5145a;

        C26636(C2668m c2668m) {
            this.f5145a = c2668m;
        }

        public void run() {
            this.f5145a.m7446a(false);
        }
    }

    /* renamed from: com.tinder.fragments.m.7 */
    class C26647 implements Runnable {
        final /* synthetic */ C2668m f5146a;

        C26647(C2668m c2668m) {
            this.f5146a = c2668m;
        }

        public void run() {
            if (this.f5146a.getActivity() instanceof ActivityMain) {
                ((ActivityMain) this.f5146a.getActivity()).m6193a(false);
            }
        }
    }

    /* renamed from: com.tinder.fragments.m.8 */
    class C26658 implements OnClickListener {
        final /* synthetic */ C2668m f5147a;

        C26658(C2668m c2668m) {
            this.f5147a = c2668m;
        }

        public void onClick(View view) {
            this.f5147a.m7461b();
        }
    }

    /* renamed from: com.tinder.fragments.m.9 */
    class C26669 extends bu {
        final /* synthetic */ C2668m f5148a;

        C26669(C2668m c2668m) {
            this.f5148a = c2668m;
        }

        public void onAnimationEnd(Animator animator) {
            this.f5148a.m7446a(C2855f.m8248a().m8293h());
        }

        public void onAnimationCancel(Animator animator) {
            this.f5148a.m7446a(C2855f.m8248a().m8293h());
        }
    }

    public C2668m() {
        this.f5160l = false;
        this.f5162n = true;
    }

    public void m7458a() {
        this.f5154f.notifyDataSetChanged();
        this.f5153e.notifyDataSetChanged();
    }

    private void m7448j() {
        al.m9270a(this.f5150b, 0.85f);
        this.f5150b.setOnClickListener(new C26581(this));
    }

    @NonNull
    private View m7449k() {
        View view = new View(getActivity());
        view.setMinimumHeight(getActivity().getResources().getDimensionPixelSize(R.dimen.moments_controls_footer_height));
        return view;
    }

    @NonNull
    private FrameLayout m7450l() {
        FrameLayout frameLayout = new FrameLayout(getActivity());
        frameLayout.setLayoutParams(new LayoutParams(-1, -2));
        View view = new View(getActivity());
        view.setMinimumHeight(getResources().getDimensionPixelSize(R.dimen.moment_stack_height));
        frameLayout.addView(view);
        return frameLayout;
    }

    public void m7461b() {
        startActivity(new Intent(getActivity(), ActivityMomentGame.class));
    }

    private void m7447c(@NonNull Match match) {
        String id = match.getId();
        String id2 = match.getPerson().getId();
        match.setIsFollowed(true);
        ManagerApp.m7925p().m8274a(id, true);
        C2913k.m8574a(id2);
        Toast.makeText(getActivity(), String.format(getString(R.string.you_are_now_following), new Object[]{match.getName()}), 1).show();
        m7458a();
        SparksEvent sparksEvent = new SparksEvent("Moments.Unhide");
        sparksEvent.put("otherId", id2);
        sparksEvent.put("matchId", id);
        sparksEvent.put("from", Integer.valueOf(1));
        C2807a.m8056a(sparksEvent);
    }

    public void m7459a(@NonNull Match match) {
        this.f5161m = new C2472h(getActivity(), 0, (int) R.string.follow, getString(R.string.are_you_sure_follow, match.getName()));
        this.f5161m.m6872a(R.string.cancel, new C26592(this));
        this.f5161m.m6876b(R.string.follow, new C26603(this, match));
        this.f5161m.show();
    }

    private void m7451m() {
        this.f5157i.setVisibility(0);
        this.f5158j.setVisibility(0);
    }

    private void m7452n() {
        this.f5157i.setVisibility(8);
        this.f5158j.setVisibility(8);
    }

    public void m7466e() {
        m7453o();
    }

    public void m7467f() {
    }

    public void m7468g() {
    }

    public void m7464c() {
        if (!this.f5160l) {
            if (getActivity() instanceof ActivityMain) {
                ((ActivityMain) getActivity()).m6194b(1);
                ((ActivityMain) getActivity()).m6218z();
                ((ActivityMain) getActivity()).m6180a(0);
            }
            this.f5160l = true;
            m7453o();
        }
    }

    public void m7465d() {
        if (this.f5160l) {
            if (getActivity() instanceof ActivityMain) {
                ((ActivityMain) getActivity()).m6194b(0);
                ((ActivityMain) getActivity()).m6217y();
                ((ActivityMain) getActivity()).m6180a(1);
            }
            this.f5160l = false;
            m7453o();
        }
    }

    public void m7469h() {
        if (this.f5160l) {
            this.f5153e.m6493a(ManagerApp.m7925p().m8287c());
            this.f5153e.notifyDataSetChanged();
        }
    }

    public void m7460a(@NonNull List<Match> list) {
        m7442a(this.f5163o);
        m7443a(this.f5151c, this.f5156h);
        this.f5153e.m6493a(list);
        this.f5156h.setAdapter(this.f5153e);
        this.f5153e.notifyDataSetChanged();
    }

    private void m7453o() {
        C3095y.m9471a("mIsSearching " + this.f5160l);
        if (this.f5160l) {
            m7456r();
            m7442a(this.f5163o);
            m7443a(this.f5151c, this.f5156h);
            this.f5156h.setAdapter(this.f5153e);
            this.f5153e.m6493a(ManagerApp.m7925p().m8287c());
            this.f5153e.notifyDataSetChanged();
        } else if (this.f5156h.getVisibility() == 0) {
            m7442a(this.f5163o);
            m7443a(this.f5156h, this.f5151c);
            m7454p();
        }
    }

    private void m7454p() {
        List g = ManagerApp.m7926q().m8481g();
        C3095y.m9471a("newMoments " + (!g.isEmpty()));
        this.f5149a.setMoments(g, true);
        if (g.isEmpty() || this.f5154f.isEmpty()) {
            m7456r();
        } else {
            m7455q();
        }
    }

    private void m7455q() {
        if (!this.f5149a.getMoments().isEmpty()) {
            this.f5149a.setVisibility(0);
            m7451m();
        }
    }

    private void m7456r() {
        this.f5149a.setVisibility(8);
        m7452n();
        if (al.m9276a()) {
            this.f5149a.setClickable(false);
            View view = getView();
            if (view != null) {
                view.invalidate();
            }
        }
    }

    public void m7457E() {
        if (getActivity() != null) {
            this.f5154f.m6385a(ManagerApp.m7925p().m8287c());
            this.f5154f.notifyDataSetChanged();
            this.f5162n = ManagerApp.m7925p().m8293h();
            if (this.f5154f.isEmpty()) {
                this.f5155g.removeFooterView(this.f5159k);
            }
            m7446a(this.f5162n);
            getActivity().supportInvalidateOptionsMenu();
        }
    }

    public void m7463b(boolean z) {
        this.f5162n = z;
        if (!this.f5160l) {
            if (!z) {
                this.f5154f.m6385a(ManagerApp.m7925p().m8287c());
                this.f5154f.notifyDataSetChanged();
                ((ActivityMain) getActivity()).m6167H();
            }
            m7446a(z);
        }
    }

    private void m7443a(View view, View view2) {
        if (view.getVisibility() != 8 || view2.getVisibility() != 0) {
            ObjectAnimator.ofFloat(view, "alpha", new float[]{1.0f, 0.0f}).addListener(new C26614(this, view));
            ObjectAnimator.ofFloat(view2, "alpha", new float[]{0.0f, 1.0f}).addListener(new C26625(this, view2));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{r0, r1});
            animatorSet.setDuration((long) this.f5164p);
            animatorSet.start();
        }
    }

    private void m7442a(View view) {
        view.setVisibility(8);
    }

    public void m7470i() {
        Object obj = 1;
        boolean b = ManagerApp.m7925p().m8285b();
        boolean isEmpty = this.f5154f != null ? this.f5154f.isEmpty() : true;
        if (this.f5163o.getVisibility() != 0) {
            obj = null;
        }
        if (!b) {
            return;
        }
        if (isEmpty || r1 != null) {
            m7457E();
        }
    }

    @MainThread
    private void m7446a(boolean z) {
        if (ManagerApp.m7925p().m8294i().booleanValue()) {
            ManagerApp.m7925p().m8277a(new C26636(this));
        } else if (!z) {
            if (this.f5154f.isEmpty()) {
                m7456r();
                if (getActivity() != null && (getActivity() instanceof ActivityMain)) {
                    ((ActivityMain) getActivity()).m6218z();
                }
                m7442a(this.f5151c);
                m7443a(this.f5163o, this.f5152d);
                m7448j();
                return;
            }
            m7454p();
            if (getActivity() != null && (getActivity() instanceof ActivityMain)) {
                ((ActivityMain) getActivity()).m6167H();
                ((ActivityMain) getActivity()).m6217y();
            }
            m7442a(this.f5152d);
            m7443a(this.f5163o, this.f5151c);
        }
    }

    public void m7462b(@NonNull Match match) {
        ((ab) getActivity()).m6120a(match, false);
        ManagerApp.m7925p().m8270a(match);
        this.f5154f.notifyDataSetChanged();
        new Handler().postDelayed(new C26647(this), 800);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f5154f.notifyDataSetChanged();
        m7453o();
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.view_matches, viewGroup, false);
        this.f5149a = (MomentsStack) inflate.findViewById(R.id.moment_stack);
        this.f5155g = (ListView) inflate.findViewById(R.id.match_list);
        this.f5156h = (ListView) inflate.findViewById(R.id.search_match_list);
        this.f5163o = (LinearLayout) inflate.findViewById(R.id.matches_loading_progress_container);
        this.f5150b = (LinearLayout) inflate.findViewById(R.id.discover_new_people);
        this.f5151c = (PullToRefreshLayout) inflate.findViewById(R.id.ptr_layout);
        this.f5152d = (PullToRefreshLayout) inflate.findViewById(R.id.ptr_layout_no_matches);
        this.f5164p = getResources().getInteger(17694720);
        m7448j();
        return inflate;
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        C3095y.m9469a();
        this.f5149a.setOnClickListener(new C26658(this));
        this.f5153e = new C2386y(getActivity(), this);
        this.f5154f = new C2341g(getActivity(), this);
        this.f5155g.setOnScrollListener(new DirectionOnScrollListener(this.f5155g, this));
        this.f5157i = m7450l();
        this.f5158j = this.f5157i.getChildAt(0);
        this.f5158j.setClickable(false);
        this.f5157i.setClickable(false);
        this.f5155g.addHeaderView(this.f5157i);
        this.f5155g.setAdapter(this.f5154f);
        this.f5159k = m7449k();
        this.f5155g.addFooterView(this.f5159k);
        this.f5156h.addFooterView(m7449k());
    }

    public void onStart() {
        super.onStart();
        ManagerApp.m7925p().m8268a((ae) this);
        ManagerApp.m7926q().m8457a((aq) this);
    }

    public void onResume() {
        C3095y.m9469a();
        super.onResume();
        m7457E();
        m7466e();
    }

    public void onPause() {
        super.onPause();
        al.m9297c(this.f5161m);
    }

    public void onStop() {
        super.onStop();
        m7442a(this.f5151c);
        m7442a(this.f5152d);
        this.f5163o.setVisibility(0);
        ManagerApp.m7925p().m8280b((ae) this);
        ManagerApp.m7926q().m8469b((aq) this);
    }

    public void onRefreshStarted(View view) {
        C3095y.m9469a();
        ManagerApp.m7926q().m8485j();
        ((ActivityMain) getActivity()).m6181a(new C26669(this));
    }

    public void onTopItemScrolled(float f) {
        float f2 = -(((float) this.f5149a.getHeight()) * f);
        this.f5149a.setTranslationY(f2);
        if (!al.m9276a()) {
            return;
        }
        if (Math.abs(f2) > 10.0f) {
            m7456r();
        } else {
            m7455q();
        }
    }

    public void onScrollUp() {
        ((ActivityMain) getActivity()).m6217y();
    }

    public void onScrollDown() {
        ((ActivityMain) getActivity()).m6218z();
    }

    public void onLastItemShown() {
        ((ActivityMain) getActivity()).m6217y();
    }
}
