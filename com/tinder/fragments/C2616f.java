package com.tinder.fragments;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.stetho.BuildConfig;
import com.google.android.gms.location.LocationStatusCodes;
import com.tinder.R;
import com.tinder.activities.ActivityMain;
import com.tinder.activities.ActivityPassport;
import com.tinder.adapters.C2356l;
import com.tinder.adapters.C2356l.C2355a;
import com.tinder.base.C2418c;
import com.tinder.managers.C2807a;
import com.tinder.managers.C2957o;
import com.tinder.managers.C2958p;
import com.tinder.managers.ManagerApp;
import com.tinder.model.Paywall;
import com.tinder.model.SparksEvent;
import com.tinder.model.TinderLocation;
import com.tinder.p030d.bk;
import com.tinder.utils.C3094x;
import com.tinder.utils.C3095y;
import com.tinder.views.LinearAdapterLayout;
import com.tinder.views.RangeSeekBar;
import com.tinder.views.RangeSeekBar.OnRangeSeekBarChangeListener;

/* renamed from: com.tinder.fragments.f */
public class C2616f extends C2418c implements OnClickListener, OnCheckedChangeListener, OnSeekBarChangeListener, OnRangeSeekBarChangeListener<Integer> {
    private C2957o f4907A;
    private RangeSeekBar<Integer> f4908B;
    C2356l f4909a;
    SwitchCompat f4910b;
    SeekBar f4911c;
    TextView f4912d;
    TextView f4913e;
    TextView f4914f;
    TextView f4915g;
    SwitchCompat f4916h;
    SwitchCompat f4917i;
    View f4918j;
    View f4919k;
    View f4920l;
    LinearAdapterLayout f4921m;
    C2355a f4922n;
    private final int f4923o;
    private int f4924p;
    private int f4925q;
    private int f4926r;
    private int f4927s;
    private boolean f4928t;
    private boolean f4929u;
    private boolean f4930v;
    private boolean f4931w;
    private boolean f4932x;
    private boolean f4933y;
    private int f4934z;

    /* renamed from: com.tinder.fragments.f.1 */
    class C26121 implements OnClickListener {
        final /* synthetic */ C2616f f4902a;

        C26121(C2616f c2616f) {
            this.f4902a = c2616f;
        }

        public void onClick(View view) {
            ((ActivityMain) this.f4902a.getActivity()).m6215w();
        }
    }

    /* renamed from: com.tinder.fragments.f.2 */
    class C26142 implements OnClickListener {
        final /* synthetic */ C2616f f4905a;

        /* renamed from: com.tinder.fragments.f.2.1 */
        class C26131 implements Runnable {
            final /* synthetic */ TinderLocation f4903a;
            final /* synthetic */ C26142 f4904b;

            C26131(C26142 c26142, TinderLocation tinderLocation) {
                this.f4904b = c26142;
                this.f4903a = tinderLocation;
            }

            public void run() {
                SparksEvent sparksEvent = new SparksEvent("Passport.MenuChooseLocation");
                sparksEvent.put("newLat", Double.valueOf(this.f4903a.getLatitude()));
                sparksEvent.put("newLon", Double.valueOf(this.f4903a.getLongitude()));
                C2807a.m8056a(sparksEvent);
            }
        }

        C26142(C2616f c2616f) {
            this.f4905a = c2616f;
        }

        public void onClick(View view) {
            int indexOfChild = this.f4905a.f4921m.indexOfChild(view);
            int i = (view.getTag() == null || !view.getTag().equals("footer")) ? 0 : 1;
            String str = BuildConfig.FLAVOR;
            C3095y.m9469a();
            if (i != 0) {
                this.f4905a.m7202f();
            } else if (indexOfChild == 0) {
                this.f4905a.f4909a.m6413a(null);
                this.f4905a.f4922n.f4166c.setVisibility(0);
                this.f4905a.f4922n.f4165b.setColorFilter(C2356l.f4167b);
                r1 = this.f4905a.getString(R.string.my_current_location);
                SparksEvent sparksEvent = new SparksEvent("Passport.MenuMyLocation");
                sparksEvent.put("from", Integer.valueOf(2));
                C2807a.m8056a(sparksEvent);
                ((ActivityMain) this.f4905a.getActivity()).m6170K();
                this.f4905a.f4915g.setText(r1);
            } else {
                TinderLocation tinderLocation = (TinderLocation) this.f4905a.f4909a.getItem(indexOfChild - 1);
                ((ActivityMain) this.f4905a.getActivity()).m6189a(tinderLocation);
                r1 = tinderLocation.getDisplayLabel();
                if (C2958p.aj()) {
                    this.f4905a.f4922n.f4166c.setVisibility(4);
                    this.f4905a.f4922n.f4165b.setColorFilter(C2356l.f4168c);
                    this.f4905a.f4915g.setText(r1);
                    this.f4905a.f4909a.m6413a(tinderLocation);
                    this.f4905a.f4915g.setText(r1);
                }
                AsyncTask.execute(new C26131(this, tinderLocation));
            }
        }
    }

    /* renamed from: com.tinder.fragments.f.3 */
    class C26153 implements bk {
        final /* synthetic */ C2616f f4906a;

        C26153(C2616f c2616f) {
            this.f4906a = c2616f;
        }

        public void m7193a() {
            C3095y.m9471a("onSubscriptionStatusActive");
            SparksEvent sparksEvent = new SparksEvent("Passport.MapOpen");
            sparksEvent.put("from", Integer.valueOf(2));
            C2807a.m8056a(sparksEvent);
            this.f4906a.startActivityForResult(new Intent(this.f4906a.getActivity(), ActivityPassport.class), 8800);
        }

        public void m7194b() {
            C3095y.m9471a("onSubscriptionStatusInactive");
            SparksEvent sparksEvent = new SparksEvent("Passport.MapOpen");
            sparksEvent.put("from", Integer.valueOf(2));
            C2807a.m8056a(sparksEvent);
            ((Paywall) this.f4906a.getActivity()).launchPlusSubscriptionPaywall(1);
        }

        public void m7195c() {
            C3095y.m9471a("onSubscriptionStatusUnknown");
            Toast.makeText(ManagerApp.m7917h(), R.string.error_getting_plus_subscription_status, 1).show();
        }
    }

    public C2616f() {
        this.f4923o = 4;
    }

    public /* synthetic */ void onRangeSeekBarValuesChanged(RangeSeekBar rangeSeekBar, Object obj, Object obj2) {
        m7208a(rangeSeekBar, (Integer) obj, (Integer) obj2);
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.view_discovery_settings, null);
        this.f4910b = (SwitchCompat) inflate.findViewById(R.id.checkBox_discover);
        this.f4911c = (SeekBar) inflate.findViewById(R.id.seekBar_distance);
        this.f4912d = (TextView) inflate.findViewById(R.id.textView_distance);
        this.f4913e = (TextView) inflate.findViewById(R.id.textView_years);
        this.f4914f = (TextView) inflate.findViewById(R.id.textView_show_me);
        this.f4916h = (SwitchCompat) inflate.findViewById(R.id.checkBox_males);
        this.f4917i = (SwitchCompat) inflate.findViewById(R.id.checkBox_females);
        this.f4918j = inflate.findViewById(R.id.view_back_icon);
        this.f4919k = inflate.findViewById(R.id.discover_prefs_txt_title);
        this.f4920l = inflate.findViewById(R.id.view_ab_icon);
        return inflate;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        m7207a();
    }

    public void onResume() {
        super.onResume();
        this.f4933y = this.f4907A.m8775l();
        this.f4910b.setChecked(this.f4933y);
    }

    public void onPause() {
        C3095y.m9471a("ON STOP");
        if (m7205i()) {
            this.f4907A.m8771i(true);
            m7209b();
        }
        super.onPause();
    }

    public void m7207a() {
        this.f4907A = ManagerApp.m7918i();
        m7200d();
        this.f4908B = new RangeSeekBar(BitmapFactory.decodeResource(getResources(), R.drawable.seekbar_thumb), BitmapFactory.decodeResource(getResources(), R.drawable.seekbar_thumb_selected), Integer.valueOf(this.f4926r), Integer.valueOf(this.f4927s), getActivity());
        this.f4908B.setLineHeight((float) getActivity().getResources().getDimensionPixelSize(R.dimen.slider_line_width));
        this.f4908B.setSliderSecondaryColor(getResources().getColor(R.color.gray_background_light));
        this.f4908B.setSliderPrimaryColor(getResources().getColor(R.color.orange));
        this.f4908B.setPadding(getResources().getDimensionPixelOffset(R.dimen.padding_small), 0, 0, 0);
        ((FrameLayout) getView().findViewById(R.id.layout_age)).addView(this.f4908B, new LayoutParams(-1, -1, 17));
        this.f4908B.setNotifyWhileDragging(true);
        this.f4908B.setContentDescription("age_range_bar");
        this.f4908B.setOnRangeSeekBarChangeListener(this);
        this.f4911c.setOnSeekBarChangeListener(this);
        this.f4910b.setOnCheckedChangeListener(this);
        this.f4916h.setOnCheckedChangeListener(this);
        this.f4917i.setOnCheckedChangeListener(this);
        this.f4931w = this.f4907A.m8773j();
        this.f4932x = this.f4907A.m8774k();
        this.f4928t = this.f4907A.m8763e();
        this.f4934z = (int) this.f4907A.m8766g();
        this.f4917i.setChecked(this.f4931w);
        this.f4916h.setChecked(this.f4932x);
        OnClickListener c26121 = new C26121(this);
        this.f4920l.setOnClickListener(c26121);
        this.f4918j.setOnClickListener(c26121);
        this.f4919k.setOnClickListener(c26121);
        m7204h();
        m7196a(this.f4934z);
        m7199c();
    }

    private void m7199c() {
        ViewGroup viewGroup = (ViewGroup) getView().findViewById(R.id.layout_settings_passport);
        if (ManagerApp.m7914e().am()) {
            viewGroup.setOnClickListener(this);
            viewGroup.getLayoutTransition().setInterpolator(0, new OvershootInterpolator());
            TinderLocation c = ManagerApp.m7916g().m8516c();
            this.f4921m = (LinearAdapterLayout) getView().findViewById(R.id.settings_passport_list_recents);
            this.f4909a = new C2356l(ManagerApp.m7916g().m8510a(4));
            this.f4909a.m6413a(c);
            this.f4922n = new C2355a();
            View inflate = View.inflate(getActivity(), R.layout.cell_recent_passport, null);
            this.f4922n.f4165b = (ImageView) inflate.findViewById(R.id.purchased_location_img);
            this.f4922n.f4165b.setImageResource(R.drawable.settings_passport_current_location);
            this.f4922n.f4165b.setColorFilter(C2356l.f4167b);
            this.f4921m.setHeader(inflate);
            this.f4922n.f4164a = (TextView) inflate.findViewById(R.id.purchased_location_name);
            this.f4922n.f4164a.setText(R.string.my_current_location);
            this.f4922n.f4166c = (ImageView) inflate.findViewById(R.id.purchased_location_check);
            inflate = View.inflate(this.f4921m.getContext(), R.layout.cell_recent_passport, null);
            String str = "footer";
            inflate.setTag("footer");
            inflate.setBackgroundResource(R.drawable.rounded_rectangle_white);
            ((ImageView) inflate.findViewById(R.id.purchased_location_img)).setVisibility(4);
            TextView textView = (TextView) inflate.findViewById(R.id.purchased_location_name);
            textView.setText(R.string.add_a_new_location);
            textView.setTextColor(getResources().getColorStateList(R.color.selector_premium_blue_text));
            this.f4921m.setFooter(inflate);
            this.f4921m.setOnClickListenerForItems(new C26142(this));
            this.f4921m.setAdapter(this.f4909a);
            this.f4915g = (TextView) getView().findViewById(R.id.settings_passport_location_txt);
            if (c == null) {
                this.f4915g.setText(R.string.my_current_location);
                this.f4922n.f4166c.setVisibility(0);
                this.f4922n.f4165b.setColorFilter(C2356l.f4167b);
                return;
            }
            this.f4915g.setText(c.getDisplayLabel());
            this.f4922n.f4165b.setColorFilter(C2356l.f4168c);
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void m7200d() {
        int i;
        boolean z = Integer.parseInt(ManagerApp.m7922m().m8599d().getAge()) < 18;
        if (z) {
            i = 13;
        } else {
            i = 18;
        }
        this.f4926r = i;
        this.f4927s = z ? 17 : 55;
        if (!z || this.f4907A.m8768h() < 18) {
            this.f4924p = Math.max(this.f4907A.m8768h(), this.f4926r);
            this.f4925q = Math.min(this.f4907A.m8770i(), this.f4927s);
            return;
        }
        this.f4924p = this.f4926r;
        this.f4925q = this.f4927s;
        this.f4930v = true;
    }

    private void m7201e() {
        this.f4915g.setVisibility(4);
        this.f4921m.setVisibility(0);
        SparksEvent sparksEvent = new SparksEvent("Passport.MenuOpen");
        sparksEvent.put("recsExhausted", Boolean.valueOf(ManagerApp.m7924o().m8728o()));
        sparksEvent.put("from", Integer.valueOf(2));
        C2807a.m8056a(sparksEvent);
    }

    private void m7202f() {
        ManagerApp.m7921l().m8625a(new C26153(this));
    }

    private void m7203g() {
        this.f4914f.setText(BuildConfig.FLAVOR);
        if (this.f4932x) {
            this.f4914f.append(getString(R.string.males));
        }
        if (this.f4931w) {
            if (this.f4932x) {
                this.f4914f.append(", ");
            }
            this.f4914f.append(getString(R.string.females));
        }
    }

    private void m7196a(int i) {
        C3095y.m9471a("distance change " + i);
        int max = Math.max(1, i);
        this.f4911c.setProgress(max);
        m7198b(max);
    }

    private void m7198b(int i) {
        String string;
        if (this.f4928t) {
            string = getString(R.string.short_distance_unit_mi);
        } else {
            string = getString(R.string.short_distance_unit_km);
        }
        if (!this.f4928t) {
            i = Math.round(C3094x.m9463a((float) i));
        }
        this.f4912d.setText(i + string);
    }

    private void m7204h() {
        this.f4908B.setSelectedMinValue(Integer.valueOf(this.f4924p));
        this.f4908B.setSelectedMaxValue(Integer.valueOf(this.f4925q));
        this.f4913e.setText(this.f4924p + " - " + this.f4925q);
        if (this.f4925q == 55) {
            this.f4913e.setText(this.f4913e.getText() + "+");
        }
    }

    private boolean m7205i() {
        return (this.f4931w == this.f4907A.m8773j() && this.f4932x == this.f4907A.m8774k() && this.f4924p == this.f4907A.m8768h() && m7206j() == this.f4907A.m8770i() && this.f4933y == this.f4907A.m8775l() && !this.f4929u) ? false : true;
    }

    private int m7206j() {
        return this.f4925q == 55 ? LocationStatusCodes.GEOFENCE_NOT_AVAILABLE : this.f4925q;
    }

    public void m7209b() {
        ManagerApp.m7922m().m8596a(this.f4933y, this.f4932x, this.f4931w, (float) this.f4934z, this.f4924p, m7206j(), (ActivityMain) getActivity());
    }

    public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean z) {
        switch (compoundButton.getId()) {
            case R.id.checkBox_discover:
                this.f4933y = z;
            case R.id.checkBox_males:
                this.f4932x = z;
                if (!z) {
                    this.f4917i.setChecked(true);
                }
                m7203g();
            case R.id.checkBox_females:
                this.f4931w = z;
                if (!z) {
                    this.f4916h.setChecked(true);
                }
                m7203g();
            default:
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 8800 && i2 == -1) {
            TinderLocation tinderLocation = (TinderLocation) intent.getSerializableExtra("tinderlocation");
            if (tinderLocation != null) {
                ((ActivityMain) getActivity()).m6189a(tinderLocation);
                this.f4909a.m6414a(ManagerApp.m7916g().m8510a(4));
                this.f4909a.m6413a(tinderLocation);
                this.f4922n.f4165b.setColorFilter(C2356l.f4168c);
                this.f4922n.f4166c.setVisibility(4);
                return;
            }
            C3095y.m9479c("No location in data passed back by ActivityPassport");
        }
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        this.f4934z = Math.max(1, i);
        m7198b(this.f4934z);
        if (z) {
            this.f4929u = true;
        }
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    public void m7208a(RangeSeekBar<?> rangeSeekBar, Integer num, Integer num2) {
        this.f4930v = true;
        this.f4924p = num.intValue();
        this.f4925q = num2.intValue();
        m7204h();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layout_settings_passport:
                m7201e();
            default:
                if (m7205i()) {
                    m7209b();
                }
                ((ActivityMain) getActivity()).m6215w();
        }
    }
}
