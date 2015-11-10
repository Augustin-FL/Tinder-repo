package com.tinder.fragments;

import android.animation.Animator;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tinder.R;
import com.tinder.activities.ActivityMain;
import com.tinder.adapters.C2349j;
import com.tinder.dialogs.C2549z;
import com.tinder.managers.C2807a;
import com.tinder.managers.ManagerApp;
import com.tinder.model.Match;
import com.tinder.model.Moment;
import com.tinder.model.MomentLike;
import com.tinder.model.SparksEvent;
import com.tinder.p030d.al;
import com.tinder.p030d.aq;
import com.tinder.p030d.bu;
import com.tinder.utils.C3095y;
import com.tinder.views.DirectionOnScrollListener;
import com.tinder.views.DirectionOnScrollListener.ListenerScrollDirection;
import java.util.ArrayList;
import uk.co.senab.actionbarpulltorefresh.library.PullToRefreshLayout;
import uk.co.senab.actionbarpulltorefresh.library.p034a.C2667b;

/* renamed from: com.tinder.fragments.p */
public class C2688p extends Fragment implements al, aq, ListenerScrollDirection, C2667b {
    private C2349j f5206a;
    private ListView f5207b;
    private LinearLayout f5208c;
    private ArrayList<MomentLike> f5209d;
    private C2549z f5210e;
    private PullToRefreshLayout f5211f;

    /* renamed from: com.tinder.fragments.p.1 */
    class C26851 implements Runnable {
        final /* synthetic */ C2688p f5203a;

        C26851(C2688p c2688p) {
            this.f5203a = c2688p;
        }

        public void run() {
            this.f5203a.f5207b.setOnScrollListener(new DirectionOnScrollListener(this.f5203a.f5207b, this.f5203a));
        }
    }

    /* renamed from: com.tinder.fragments.p.2 */
    class C26862 implements OnDismissListener {
        final /* synthetic */ C2688p f5204a;

        C26862(C2688p c2688p) {
            this.f5204a = c2688p;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            this.f5204a.m7524b();
        }
    }

    /* renamed from: com.tinder.fragments.p.3 */
    class C26873 extends bu {
        final /* synthetic */ C2688p f5205a;

        C26873(C2688p c2688p) {
            this.f5205a = c2688p;
        }

        public void onAnimationEnd(Animator animator) {
            C3095y.m9469a();
            this.f5205a.f5211f.m10407a();
        }

        public void onAnimationCancel(Animator animator) {
            C3095y.m9469a();
            this.f5205a.f5211f.m10407a();
        }
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C3095y.m9469a();
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f5209d = (ArrayList) ManagerApp.m7926q().m8484i();
        this.f5209d = new ArrayList();
        View inflate = layoutInflater.inflate(R.layout.view_fragment_my_moments_activity, null);
        this.f5208c = (LinearLayout) inflate.findViewById(R.id.linearLayout_no_activity_message);
        this.f5211f = (PullToRefreshLayout) inflate.findViewById(R.id.pullToRefreshLayout_my_moments);
        this.f5207b = (ListView) inflate.findViewById(R.id.listView_activity);
        this.f5207b.post(new C26851(this));
        this.f5206a = new C2349j(getActivity(), this, 0, true);
        this.f5207b.setAdapter(this.f5206a);
        m7521a();
        return inflate;
    }

    public void onResume() {
        C3095y.m9469a();
        super.onResume();
        ManagerApp.m7926q().m8457a((aq) this);
        this.f5209d = (ArrayList) ManagerApp.m7926q().m8484i();
        m7520d();
    }

    public void onPause() {
        ManagerApp.m7926q().m8469b((aq) this);
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        com.tinder.utils.al.m9297c(this.f5210e);
    }

    public void m7521a() {
        if (!this.f5209d.isEmpty()) {
            ManagerApp.m7926q().m8456a(((MomentLike) this.f5209d.get(0)).getTime());
        }
    }

    private void m7520d() {
        C3095y.m9469a();
        if (this.f5209d.isEmpty()) {
            this.f5206a.m6398a(8);
            this.f5208c.setVisibility(0);
        } else {
            this.f5208c.setVisibility(8);
        }
        this.f5207b.setAdapter(this.f5206a);
        this.f5206a.m6399a(this.f5209d);
        this.f5206a.notifyDataSetChanged();
    }

    public void m7524b() {
        this.f5209d = (ArrayList) ManagerApp.m7926q().m8484i();
        this.f5206a.m6399a(this.f5209d);
        if (!this.f5209d.isEmpty()) {
            this.f5208c.setVisibility(8);
        }
        this.f5206a.notifyDataSetChanged();
    }

    public void m7525c() {
        m7521a();
    }

    public void m7522a(@NonNull Match match) {
        C3095y.m9469a();
        ((ActivityMain) getActivity()).m6188a(match, false);
    }

    public void m7523a(@NonNull Moment moment) {
        C3095y.m9469a();
        this.f5210e = new C2549z(getActivity(), moment, true, 2);
        this.f5210e.setOnDismissListener(new C26862(this));
        this.f5210e.show();
        SparksEvent sparksEvent = new SparksEvent("Moments.View");
        sparksEvent.put("momentId", moment.getId());
        sparksEvent.put("otherId", moment.getUserId());
        sparksEvent.put("viewedFrom", Integer.valueOf(2));
        C2807a.m8056a(sparksEvent);
    }

    public void m7526e() {
        m7524b();
    }

    public void m7527f() {
        m7524b();
    }

    public void m7528g() {
        C3095y.m9469a();
        m7524b();
    }

    public void onTopItemScrolled(float f) {
    }

    public void onScrollUp() {
        if (getActivity() != null) {
            ((ActivityMain) getActivity()).m6217y();
        }
    }

    public void onScrollDown() {
        if (getActivity() != null) {
            ((ActivityMain) getActivity()).m6218z();
        }
    }

    public void onLastItemShown() {
    }

    public void onRefreshStarted(View view) {
        C3095y.m9469a();
        ManagerApp.m7926q().m8486k();
        ((ActivityMain) getActivity()).m6181a(new C26873(this));
    }
}
