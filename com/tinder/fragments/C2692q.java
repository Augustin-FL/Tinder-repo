package com.tinder.fragments;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;
import com.tinder.R;
import com.tinder.activities.ActivityMain;
import com.tinder.adapters.C2354k;
import com.tinder.dialogs.C2490l;
import com.tinder.dialogs.C2515r;
import com.tinder.dialogs.C2549z;
import com.tinder.managers.C2807a;
import com.tinder.managers.ManagerApp;
import com.tinder.model.Match;
import com.tinder.model.Moment;
import com.tinder.model.SparksEvent;
import com.tinder.p030d.an;
import com.tinder.p030d.aq;
import com.tinder.p030d.ar;
import com.tinder.p030d.as;
import com.tinder.utils.C3095y;
import com.tinder.utils.al;
import com.tinder.views.DirectionOnScrollListener;
import com.tinder.views.DirectionOnScrollListener.ListenerScrollDirection;
import java.util.List;
import uk.co.senab.actionbarpulltorefresh.library.PullToRefreshLayout;
import uk.co.senab.actionbarpulltorefresh.library.p034a.C2667b;

/* renamed from: com.tinder.fragments.q */
public class C2692q extends Fragment implements aq, ar, as, ListenerScrollDirection, C2667b {
    private GridView f5216a;
    private View f5217b;
    private PullToRefreshLayout f5218c;
    private C2354k f5219d;
    private C2490l f5220e;
    private C2515r f5221f;
    private C2549z f5222g;

    /* renamed from: com.tinder.fragments.q.1 */
    class C26891 implements OnDismissListener {
        final /* synthetic */ C2692q f5212a;

        C26891(C2692q c2692q) {
            this.f5212a = c2692q;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            this.f5212a.m7539d();
        }
    }

    /* renamed from: com.tinder.fragments.q.2 */
    class C26902 implements an {
        final /* synthetic */ Moment f5213a;
        final /* synthetic */ C2692q f5214b;

        C26902(C2692q c2692q, Moment moment) {
            this.f5214b = c2692q;
            this.f5213a = moment;
        }

        public void m7530a(String str) {
            C3095y.m9469a();
            this.f5214b.m7539d();
            this.f5213a.clearBitmap();
            al.m9297c(this.f5214b.f5221f);
        }

        public void m7529a() {
            C3095y.m9469a();
            al.m9297c(this.f5214b.f5221f);
            Toast.makeText(this.f5214b.getActivity(), R.string.error_moment_send, 1).show();
        }
    }

    /* renamed from: com.tinder.fragments.q.3 */
    class C26913 implements AnimatorListener {
        final /* synthetic */ C2692q f5215a;

        C26913(C2692q c2692q) {
            this.f5215a = c2692q;
        }

        public void onAnimationStart(Animator animator) {
            C3095y.m9469a();
        }

        public void onAnimationEnd(Animator animator) {
            C3095y.m9469a();
            this.f5215a.f5218c.m10407a();
        }

        public void onAnimationCancel(Animator animator) {
            C3095y.m9469a();
            this.f5215a.f5218c.m10407a();
        }

        public void onAnimationRepeat(Animator animator) {
            C3095y.m9469a();
        }
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.view_fragment_my_moments_captured, null);
        this.f5216a = (GridView) inflate.findViewById(R.id.gridView_moments);
        this.f5217b = inflate.findViewById(R.id.linear_my_moments_no_moments);
        this.f5218c = (PullToRefreshLayout) inflate.findViewById(R.id.pullToRefreshLayout_my_moments);
        return inflate;
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        m7538c();
    }

    public void onResume() {
        super.onResume();
        ManagerApp.m7926q().m8457a((aq) this);
        C3095y.m9469a();
        m7539d();
    }

    public void onPause() {
        ManagerApp.m7926q().m8469b((aq) this);
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        al.m9297c(this.f5220e);
        al.m9297c(this.f5222g);
        al.m9297c(this.f5221f);
    }

    public void m7538c() {
        C3095y.m9469a();
        this.f5219d = new C2354k(getActivity(), this);
        this.f5221f = new C2515r(getActivity());
        this.f5216a.setVerticalScrollBarEnabled(false);
        this.f5219d.m6410a(12);
        this.f5216a.setOnScrollListener(new DirectionOnScrollListener(this.f5216a, this));
        this.f5216a.setAdapter(this.f5219d);
    }

    public void m7539d() {
        List m = ManagerApp.m7926q().m8488m();
        C3095y.m9471a("size my moments=" + m.size());
        C3095y.m9471a("are more my moments " + ManagerApp.m7926q().m8489n());
        if (m.isEmpty()) {
            if (ManagerApp.m7926q().m8489n()) {
                ManagerApp.m7926q().m8458a((as) this, false);
            }
            this.f5217b.setVisibility(0);
        } else {
            this.f5217b.setVisibility(8);
        }
        this.f5219d.m6411a(m);
        this.f5219d.notifyDataSetChanged();
    }

    public void m7534a(Match match) {
        C3095y.m9469a();
    }

    public void m7535a(@NonNull Moment moment) {
        C3095y.m9469a();
        this.f5222g = new C2549z(getActivity(), moment, true, 1);
        this.f5222g.show();
        this.f5222g.setOnDismissListener(new C26891(this));
        SparksEvent sparksEvent = new SparksEvent("Moments.View");
        sparksEvent.put("otherId", moment.getUserId());
        sparksEvent.put("momentId", moment.getId());
        sparksEvent.put("viewedFrom", Integer.valueOf(1));
        C2807a.m8056a(sparksEvent);
    }

    public void m7537b(@NonNull Moment moment) {
        C3095y.m9469a();
        this.f5221f.show();
        ManagerApp.m7926q().m8461a(moment, new C26902(this, moment));
    }

    public void m7540e() {
        C3095y.m9469a();
        m7539d();
    }

    public void m7541f() {
        C3095y.m9469a();
        m7539d();
    }

    public void m7542g() {
        C3095y.m9469a();
        m7539d();
    }

    public void onTopItemScrolled(float f) {
    }

    public void onScrollUp() {
        ((ActivityMain) getActivity()).m6217y();
    }

    public void onScrollDown() {
        ((ActivityMain) getActivity()).m6218z();
    }

    public void onLastItemShown() {
    }

    public void m7533a() {
        C3095y.m9469a();
    }

    public void m7536b() {
    }

    public void onRefreshStarted(View view) {
        C3095y.m9469a();
        ManagerApp.m7926q().m8458a((as) this, false);
        ((ActivityMain) getActivity()).m6181a(new C26913(this));
    }
}
