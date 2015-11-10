package com.tinder.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.stetho.BuildConfig;
import com.tinder.R;
import com.tinder.activities.ActivityLogin;
import com.tinder.activities.ActivityMain;
import com.tinder.adapters.C2363q;
import com.tinder.managers.C2807a;
import com.tinder.managers.ManagerApp;
import com.tinder.utils.C3095y;

/* renamed from: com.tinder.fragments.o */
public class C2684o extends Fragment implements OnPageChangeListener {
    private ViewPager f5199a;
    private TextView f5200b;
    private TextView f5201c;
    private C2363q f5202d;

    /* renamed from: com.tinder.fragments.o.1 */
    class C26791 implements OnClickListener {
        final /* synthetic */ C2684o f5192a;

        C26791(C2684o c2684o) {
            this.f5192a = c2684o;
        }

        public void onClick(View view) {
            this.f5192a.f5199a.setCurrentItem(1);
        }
    }

    /* renamed from: com.tinder.fragments.o.2 */
    class C26802 implements OnClickListener {
        final /* synthetic */ C2684o f5193a;

        C26802(C2684o c2684o) {
            this.f5193a = c2684o;
        }

        public void onClick(View view) {
            this.f5193a.f5199a.setCurrentItem(0);
        }
    }

    /* renamed from: com.tinder.fragments.o.3 */
    class C26813 implements Runnable {
        final /* synthetic */ ActivityMain f5194a;
        final /* synthetic */ C2684o f5195b;

        C26813(C2684o c2684o, ActivityMain activityMain) {
            this.f5195b = c2684o;
            this.f5194a = activityMain;
        }

        public void run() {
            if (this.f5194a == null || !this.f5194a.m6209q()) {
                this.f5195b.f5199a.setCurrentItem(0);
            } else {
                this.f5195b.f5199a.setCurrentItem(1);
            }
        }
    }

    /* renamed from: com.tinder.fragments.o.4 */
    class C26834 implements Runnable {
        final /* synthetic */ C2684o f5198a;

        /* renamed from: com.tinder.fragments.o.4.1 */
        class C26821 implements Runnable {
            final /* synthetic */ C2692q f5196a;
            final /* synthetic */ C26834 f5197b;

            C26821(C26834 c26834, C2692q c2692q) {
                this.f5197b = c26834;
                this.f5196a = c2692q;
            }

            public void run() {
                this.f5196a.m7539d();
            }
        }

        C26834(C2684o c2684o) {
            this.f5198a = c2684o;
        }

        public void run() {
            int currentItem = this.f5198a.f5199a.getCurrentItem();
            if (currentItem == 0) {
                C2688p a = this.f5198a.f5202d.m6442a();
                if (a != null) {
                    a.m7525c();
                }
                C2807a.m8058a("Moments.Activity");
            } else if (currentItem == 1) {
                C2692q b = this.f5198a.f5202d.m6443b();
                if (b != null) {
                    this.f5198a.f5199a.post(new C26821(this, b));
                }
                C2807a.m8058a("Moments.List");
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!ManagerApp.m7911b().m8144e()) {
            Intent intent = new Intent(getActivity(), ActivityLogin.class);
            Bundle bundle2 = new Bundle();
            bundle2.putString("extra_show_intro", BuildConfig.FLAVOR);
            intent.putExtras(bundle2);
            startActivity(intent);
            getActivity().finish();
        }
        this.f5202d = new C2363q(getChildFragmentManager());
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.view_fragment_my_moments, null);
        this.f5199a = (ViewPager) inflate.findViewById(R.id.pager_my_moments);
        this.f5200b = (TextView) inflate.findViewById(R.id.text_tab_activity);
        this.f5201c = (TextView) inflate.findViewById(R.id.text_tab_my_moments);
        return inflate;
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        m7515b();
    }

    private void m7515b() {
        this.f5199a.setAdapter(this.f5202d);
        this.f5199a.setOnPageChangeListener(this);
        this.f5202d.notifyDataSetChanged();
        this.f5201c.setOnClickListener(new C26791(this));
        this.f5200b.setOnClickListener(new C26802(this));
        m7513a(0);
        this.f5199a.post(new C26813(this, (ActivityMain) getActivity()));
    }

    private void m7513a(int i) {
        C3095y.m9471a("chosenTab=" + i);
        int color = getResources().getColor(R.color.orange);
        int color2 = getResources().getColor(R.color.subtext_gray);
        if (i == 1) {
            this.f5201c.setTextColor(color);
            this.f5200b.setTextColor(color2);
            return;
        }
        this.f5201c.setTextColor(color2);
        this.f5200b.setTextColor(color);
    }

    public int m7517a() {
        return this.f5199a.getCurrentItem();
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageSelected(int i) {
        C3095y.m9471a("i=" + i);
        m7513a(i);
        m7516c();
    }

    public void onPageScrollStateChanged(int i) {
        C3095y.m9471a("i=" + i);
        if (i == 0) {
            this.f5199a.post(new C26834(this));
        }
    }

    private void m7516c() {
        ((ActivityMain) getActivity()).m6217y();
    }
}
