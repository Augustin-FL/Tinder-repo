package com.tinder.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.tinder.R;
import com.tinder.adapters.C2362p;
import com.tinder.base.ActivitySignedInBase;
import com.tinder.fragments.C2657l;
import com.tinder.managers.C2807a;
import com.tinder.managers.ManagerApp;
import com.tinder.model.Match;
import com.tinder.model.Moment;
import com.tinder.model.SparksEvent;
import com.tinder.p030d.ab;
import com.tinder.utils.C3095y;
import com.tinder.utils.al;
import com.tinder.views.SinkPageTransformer;
import com.tinder.views.SkippableViewPager;
import java.util.ArrayList;
import java.util.List;

public class ActivityMomentGame extends ActivitySignedInBase implements OnPageChangeListener, ab {
    private View f3938a;
    private ViewPager f3939b;
    private C2362p f3940c;
    private SinkPageTransformer f3941e;
    private boolean f3942f;
    private boolean f3943g;
    private boolean f3944h;
    private ArrayList<Moment> f3945i;
    private Match f3946j;

    /* renamed from: com.tinder.activities.ActivityMomentGame.1 */
    class C22971 implements Runnable {
        final /* synthetic */ ActivityMomentGame f3935a;

        C22971(ActivityMomentGame activityMomentGame) {
            this.f3935a = activityMomentGame;
        }

        public void run() {
            this.f3935a.f3940c.m6441a(false);
            this.f3935a.f3940c.m6440a(null);
            this.f3935a.f3942f = false;
            this.f3935a.f3939b.setPageTransformer(false, this.f3935a.f3941e);
        }
    }

    /* renamed from: com.tinder.activities.ActivityMomentGame.2 */
    class C22982 implements Runnable {
        final /* synthetic */ ActivityMomentGame f3936a;

        C22982(ActivityMomentGame activityMomentGame) {
            this.f3936a = activityMomentGame;
        }

        public void run() {
            this.f3936a.f3939b.setCurrentItem(1);
        }
    }

    /* renamed from: com.tinder.activities.ActivityMomentGame.3 */
    class C22993 implements Runnable {
        final /* synthetic */ ActivityMomentGame f3937a;

        C22993(ActivityMomentGame activityMomentGame) {
            this.f3937a = activityMomentGame;
        }

        public void run() {
            this.f3937a.finish();
        }
    }

    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.view_activity_moment_game);
        LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        getWindow().setAttributes(attributes);
        this.f3938a = findViewById(R.id.moment_game_bg);
        this.f3939b = (SkippableViewPager) findViewById(R.id.moment_game_viewpager);
        this.f3940c = new C2362p(getSupportFragmentManager());
        this.f3939b.setAdapter(this.f3940c);
        this.f3939b.addOnPageChangeListener(this);
        this.f3941e = new SinkPageTransformer(this);
        this.f3941e.setShouldBounce(false);
        this.f3939b.setPageTransformer(false, this.f3941e);
        if (getIntent().getExtras() == null || !getIntent().getExtras().containsKey("moment ids to play")) {
            this.f3943g = false;
        } else {
            List stringArrayList = getIntent().getExtras().getStringArrayList("moment ids to play");
            if (stringArrayList != null) {
                this.f3945i = new ArrayList(stringArrayList.size());
                for (int i = 0; i < stringArrayList.size(); i++) {
                    this.f3945i.add(0, ManagerApp.m7926q().m8452a((String) stringArrayList.get(i)));
                }
            }
            this.f3943g = true;
        }
        if (bundle == null) {
            C2807a.m8056a(m6231b("Moments.OpenStack"));
        }
        this.f3938a.setAlpha(0.0f);
        this.f3938a.animate().alpha(1.0f).setInterpolator(new AccelerateInterpolator()).start();
        ManagerApp.m7926q().m8479f();
        m5908T();
    }

    protected void onDestroy() {
        this.f3939b.removeOnPageChangeListener(this);
        super.onDestroy();
    }

    public View m6240e() {
        return this.f3938a;
    }

    public int m6241f() {
        if (this.f3943g) {
            return this.f3945i.size();
        }
        return ManagerApp.m7926q().m8477e();
    }

    @Nullable
    public Moment m6234a(int i) {
        if (!this.f3943g) {
            return ManagerApp.m7926q().m8451a(i);
        }
        if (i < 0 || i >= this.f3945i.size()) {
            return null;
        }
        return (Moment) this.f3945i.get(i);
    }

    public void m6239a(String str) {
        if (this.f3943g) {
            for (int i = 0; i < this.f3945i.size(); i++) {
                if (((Moment) this.f3945i.get(i)).getId().equals(str)) {
                    this.f3945i.remove(i);
                    break;
                }
            }
            this.f3945i.trimToSize();
        }
    }

    public void m6242g() {
        if (this.f3943g) {
            this.f3945i.clear();
        }
    }

    public boolean m6243h() {
        return this.f3943g;
    }

    public void m6244i() {
        if (this.f3944h) {
            this.f3939b.setCurrentItem(0);
            m6247l();
            return;
        }
        m6245j();
    }

    public void m6237a(@NonNull Match match) {
        this.f3946j = match;
    }

    public Match m6248p() {
        return this.f3946j;
    }

    public boolean m6249q() {
        return this.f3942f;
    }

    public boolean m6250r() {
        return false;
    }

    public void m6251s() {
    }

    public void m6245j() {
        this.f3939b.setPageTransformer(true, this.f3941e);
        this.f3939b.setCurrentItem(0);
        this.f3939b.postDelayed(new C22971(this), 400);
    }

    public void m6238a(@NonNull Match match, boolean z) {
        C3095y.m9469a();
        this.f3946j = match;
        this.f3942f = z;
        this.f3940c.m6440a(match);
        this.f3940c.m6441a(true);
        this.f3939b.postDelayed(new C22982(this), 400);
    }

    public void m6252t() {
        m6244i();
    }

    public void m6253u() {
    }

    public void m6236a(C2657l c2657l) {
    }

    public void m6254w() {
    }

    public void m6246k() {
        this.f3944h = true;
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageSelected(int i) {
    }

    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.f3939b.getCurrentItem() == 0) {
            m6244i();
            al.m9268a(this.f3939b.getWindowToken(), (Activity) this);
        }
    }

    @NonNull
    private SparksEvent m6231b(String str) {
        int size;
        SparksEvent sparksEvent = new SparksEvent(str);
        if (this.f3943g) {
            size = this.f3945i.size();
        } else {
            size = ManagerApp.m7926q().m8477e();
        }
        sparksEvent.put("count", Integer.valueOf(size));
        return sparksEvent;
    }

    public void onBackPressed() {
        if (this.f3939b.getCurrentItem() != 0) {
            this.f3939b.setCurrentItem(0);
        } else {
            m6247l();
        }
    }

    public void m6247l() {
        C2807a.m8056a(m6231b("Moments.CloseStack"));
        s_();
        this.f3938a.animate().alpha(0.0f).setDuration(200).setInterpolator(new DecelerateInterpolator()).start();
        this.f3938a.postDelayed(new C22993(this), 100);
    }

    protected void m6235a() {
        if (!al.m9276a()) {
            overridePendingTransition(R.anim.scale_up_moment_game, 0);
        }
    }

    protected void s_() {
        if (!al.m9276a()) {
            int i = ((this.f3945i == null || !this.f3945i.isEmpty()) && ManagerApp.m7926q().m8477e() != 0) ? 0 : 1;
            if (i != 0) {
                overridePendingTransition(0, R.anim.anim_quick_fade_out);
            } else {
                overridePendingTransition(0, R.anim.scale_down_moment_game);
            }
        }
    }
}
