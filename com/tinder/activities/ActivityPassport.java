package com.tinder.activities;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.facebook.stetho.BuildConfig;
import com.tinder.R;
import com.tinder.adapters.C2335e;
import com.tinder.base.ActivityBase;
import com.tinder.fragments.FragmentMap;
import com.tinder.managers.C2807a;
import com.tinder.managers.C2898j;
import com.tinder.managers.ManagerApp;
import com.tinder.model.SparksEvent;
import com.tinder.model.TinderLocation;
import com.tinder.p030d.aa;
import com.tinder.p030d.bv;
import com.tinder.utils.al;
import com.tinder.views.PeekStack;
import java.util.ArrayList;
import java.util.List;

public class ActivityPassport extends ActivityBase implements OnClickListener, OnItemClickListener, OnEditorActionListener, aa {
    private FragmentMap f3958a;
    private ListView f3959b;
    private ProgressBar f3960c;
    private View f3961e;
    private View f3962f;
    private View f3963g;
    private ImageView f3964h;
    private ImageView f3965i;
    private EditText f3966j;
    private C2335e f3967k;
    private TransitionDrawable f3968l;
    private boolean f3969m;
    private List<TinderLocation> f3970n;
    private boolean f3971o;

    /* renamed from: com.tinder.activities.ActivityPassport.1 */
    class C23001 implements Runnable {
        final /* synthetic */ int f3947a;
        final /* synthetic */ ActivityPassport f3948b;

        C23001(ActivityPassport activityPassport, int i) {
            this.f3948b = activityPassport;
            this.f3947a = i;
        }

        public void run() {
            TinderLocation tinderLocation = (TinderLocation) this.f3948b.f3967k.getItem(this.f3947a);
            SparksEvent sparksEvent = new SparksEvent("Passport.MapSearchSelect");
            sparksEvent.put("searched", tinderLocation.getLabels().first);
            sparksEvent.put("method", "TAP");
            sparksEvent.put("popular", Boolean.valueOf(this.f3948b.f3971o));
            C2807a.m8056a(sparksEvent);
        }
    }

    /* renamed from: com.tinder.activities.ActivityPassport.2 */
    class C23012 implements Runnable {
        final /* synthetic */ int f3949a;
        final /* synthetic */ ActivityPassport f3950b;

        C23012(ActivityPassport activityPassport, int i) {
            this.f3950b = activityPassport;
            this.f3949a = i;
        }

        public void run() {
            this.f3950b.f3958a.m7085a((TinderLocation) this.f3950b.f3967k.getItem(this.f3949a));
        }
    }

    /* renamed from: com.tinder.activities.ActivityPassport.3 */
    class C23033 extends bv {
        final /* synthetic */ Context f3952a;
        final /* synthetic */ ActivityPassport f3953b;

        /* renamed from: com.tinder.activities.ActivityPassport.3.1 */
        class C23021 implements Runnable {
            final /* synthetic */ C23033 f3951a;

            C23021(C23033 c23033) {
                this.f3951a = c23033;
            }

            public void run() {
                al.m9267a(this.f3951a.f3952a, this.f3951a.f3953b.f3966j);
            }
        }

        C23033(ActivityPassport activityPassport, Context context) {
            this.f3953b = activityPassport;
            this.f3952a = context;
        }

        public void onAnimationStart(Animator animator) {
            this.f3953b.f3962f.setVisibility(0);
            this.f3953b.f3968l.startTransition(150);
        }

        public void onAnimationEnd(Animator animator) {
            this.f3953b.f3966j.setFocusableInTouchMode(true);
            this.f3953b.f3966j.requestFocus();
            this.f3953b.f3966j.setCursorVisible(true);
            this.f3953b.f3966j.postDelayed(new C23021(this), 200);
        }
    }

    /* renamed from: com.tinder.activities.ActivityPassport.4 */
    class C23044 extends bv {
        final /* synthetic */ Activity f3954a;
        final /* synthetic */ ActivityPassport f3955b;

        C23044(ActivityPassport activityPassport, Activity activity) {
            this.f3955b = activityPassport;
            this.f3954a = activity;
        }

        public void onAnimationStart(Animator animator) {
            this.f3955b.f3968l.reverseTransition(150);
            this.f3955b.f3966j.setText(BuildConfig.FLAVOR);
            this.f3955b.f3966j.clearFocus();
            this.f3955b.f3966j.setCursorVisible(false);
            this.f3955b.f3958a.getView().requestFocus();
        }

        public void onAnimationEnd(Animator animator) {
            this.f3955b.f3962f.setVisibility(4);
            al.m9268a(this.f3955b.f3966j.getWindowToken(), this.f3954a);
        }
    }

    /* renamed from: com.tinder.activities.ActivityPassport.5 */
    class C23055 implements Runnable {
        final /* synthetic */ ActivityPassport f3956a;

        C23055(ActivityPassport activityPassport) {
            this.f3956a = activityPassport;
        }

        public void run() {
            this.f3956a.m6266h();
        }
    }

    /* renamed from: com.tinder.activities.ActivityPassport.6 */
    class C23066 implements Runnable {
        final /* synthetic */ ActivityPassport f3957a;

        C23066(ActivityPassport activityPassport) {
            this.f3957a = activityPassport;
        }

        public void run() {
            this.f3957a.f3958a.m7087b();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setWindowAnimations(R.style.dialog_up_down_animation);
        setContentView(R.layout.view_activity_passport);
        m5908T();
        this.f3961e = findViewById(R.id.view_back_icon);
        this.f3963g = findViewById(R.id.imageView_icon);
        this.f3964h = (ImageView) findViewById(R.id.actionbar_mylocation);
        this.f3962f = findViewById(R.id.passport_search_layout);
        this.f3960c = (ProgressBar) findViewById(R.id.passport_search_progress);
        this.f3962f = findViewById(R.id.passport_search_layout);
        this.f3966j = (EditText) findViewById(R.id.passport_edittext_search);
        this.f3965i = (ImageView) findViewById(R.id.maps_search_icon);
        View findViewById = findViewById(R.id.maps_search_underline);
        this.f3958a = (FragmentMap) getSupportFragmentManager().findFragmentById(R.id.fragment_map);
        this.f3959b = (ListView) findViewById(R.id.passport_search_list);
        this.f3959b.setOnItemClickListener(this);
        this.f3967k = new C2335e();
        this.f3959b.setAdapter(this.f3967k);
        this.f3965i.setOnClickListener(this);
        this.f3961e.setOnClickListener(this);
        this.f3963g.setOnClickListener(this);
        this.f3964h.setOnClickListener(this);
        this.f3962f.setOnClickListener(this);
        this.f3960c.setOnClickListener(this);
        this.f3966j.setOnEditorActionListener(this);
        this.f3966j.setOnClickListener(this);
        findViewById.setOnClickListener(this);
        this.f3968l = new TransitionDrawable(new Drawable[]{getResources().getDrawable(R.drawable.passport_search_underline_inactive), getResources().getDrawable(R.drawable.passport_search_underline_active)});
        this.f3968l.setCrossFadeEnabled(true);
        al.m9271a(findViewById, this.f3968l);
        ManagerApp.m7916g();
        this.f3970n = C2898j.m8504a();
    }

    protected void m6267a() {
        super.m5915a();
        overridePendingTransition(R.anim.activity_passport_in, 0);
    }

    protected void s_() {
        super.s_();
        overridePendingTransition(R.anim.activity_passport_out, 0);
    }

    public void onPause() {
        al.m9268a(this.f3966j.getWindowToken(), (Activity) this);
        super.onPause();
    }

    public void onItemClick(@NonNull AdapterView<?> adapterView, View view, int i, long j) {
        AsyncTask.execute(new C23001(this, i));
        m6266h();
        adapterView.postDelayed(new C23012(this, i), 350);
    }

    private void m6264g() {
        this.f3969m = true;
        this.f3965i.animate().alpha(1.0f).setDuration(150).start();
        this.f3963g.animate().alpha(PeekStack.HEIGHT_PERCENT_OF_SCREEN).setDuration(150).start();
        this.f3964h.animate().alpha(PeekStack.HEIGHT_PERCENT_OF_SCREEN).setDuration(150).start();
        this.f3961e.animate().alpha(PeekStack.HEIGHT_PERCENT_OF_SCREEN).setDuration(150).start();
        this.f3967k.m6377a(this.f3970n);
        this.f3971o = true;
        this.f3962f.setAlpha(0.0f);
        this.f3962f.animate().setDuration(135).alpha(1.0f).setListener(new C23033(this, this)).start();
        this.f3967k.notifyDataSetChanged();
    }

    private void m6266h() {
        this.f3969m = false;
        m6270e();
        this.f3965i.animate().alpha(PeekStack.HEIGHT_PERCENT_OF_SCREEN).setDuration(150).start();
        this.f3963g.animate().alpha(1.0f).setDuration(150).start();
        this.f3964h.animate().alpha(1.0f).setDuration(150).start();
        this.f3961e.animate().alpha(1.0f).setDuration(150).start();
        this.f3962f.animate().alpha(0.0f).setDuration(150).setListener(new C23044(this, this)).start();
        this.f3960c.setVisibility(4);
    }

    public void m6270e() {
        ManagerApp.m7915f().m5902a((Object) "passport_search");
    }

    private void m6258a(@NonNull String str) {
        if (str.toLowerCase().contains("where is uncle jon")) {
            TinderLocation tinderLocation = new TinderLocation();
            tinderLocation.setStateProvinceLong("Disneyland");
            tinderLocation.setCountryLong("California");
            tinderLocation.setCountryShort("\"Indeed...\"");
            tinderLocation.setLatitude(33.811113d);
            tinderLocation.setLongitude(-117.921584d);
            List arrayList = new ArrayList();
            arrayList.add(tinderLocation);
            m6269a(arrayList);
            return;
        }
        Object trim = str.trim();
        if (!TextUtils.isEmpty(trim)) {
            this.f3971o = false;
            this.f3967k.m6376a();
            this.f3960c.setVisibility(0);
            m6270e();
            C2898j.m8508a(trim, this, "passport_search");
        }
    }

    public void m6268a(@Nullable TinderLocation tinderLocation) {
        if (tinderLocation != null && tinderLocation.hasGeoData()) {
            Intent intent = new Intent();
            intent.putExtra("tinderlocation", tinderLocation);
            setResult(-1, intent);
            finish();
        }
    }

    public void m6269a(@NonNull List<TinderLocation> list) {
        if (this.f3969m) {
            this.f3967k.m6377a(list);
            this.f3967k.notifyDataSetChanged();
        }
        this.f3960c.setVisibility(4);
        if (list.isEmpty()) {
            Toast.makeText(this, R.string.no_location_found, 0).show();
        }
    }

    public void m6271f() {
        this.f3960c.setVisibility(4);
        Toast.makeText(this, R.string.no_location_found, 0).show();
    }

    public void onBackPressed() {
        if (this.f3969m) {
            m6266h();
        } else {
            super.onBackPressed();
        }
    }

    public boolean onEditorAction(@NonNull TextView textView, int i, @NonNull KeyEvent keyEvent) {
        if (i == 3) {
            m6258a(textView.getText().toString());
            al.m9268a(this.f3966j.getWindowToken(), (Activity) this);
            return true;
        }
        if (keyEvent.getKeyCode() == 4) {
            onBackPressed();
        }
        return false;
    }

    public void onClick(@NonNull View view) {
        switch (view.getId()) {
            case R.id.view_back_icon:
            case R.id.view_back_title:
                onBackPressed();
            case R.id.imageView_icon:
                onBackPressed();
            case R.id.actionbar_mylocation:
                if (this.f3969m) {
                    this.f3964h.post(new C23055(this));
                }
                this.f3964h.post(new C23066(this));
            case R.id.maps_search_icon:
            case R.id.passport_edittext_search:
            case R.id.maps_search_underline:
                if (this.f3969m) {
                    al.m9267a((Context) this, this.f3966j);
                } else {
                    m6264g();
                }
            case R.id.passport_search_layout:
            case R.id.passport_search_progress:
                m6266h();
            default:
        }
    }
}
