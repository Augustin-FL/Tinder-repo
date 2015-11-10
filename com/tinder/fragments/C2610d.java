package com.tinder.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.stetho.BuildConfig;
import com.tinder.R;
import com.tinder.activities.ActivityLogin;
import com.tinder.activities.ActivityMain;
import com.tinder.base.C2418c;
import com.tinder.dialogs.C2473c;
import com.tinder.dialogs.C2473c.C2471a;
import com.tinder.dialogs.C2476d;
import com.tinder.dialogs.C2476d.C2475a;
import com.tinder.dialogs.C2515r;
import com.tinder.dialogs.ag;
import com.tinder.enums.Gender;
import com.tinder.managers.C2807a;
import com.tinder.managers.C2913k;
import com.tinder.managers.C2957o;
import com.tinder.managers.C2958p;
import com.tinder.managers.ManagerApp;
import com.tinder.model.SparksEvent;
import com.tinder.p030d.C2243y;
import com.tinder.p030d.C2429h;
import com.tinder.p030d.af;
import com.tinder.p030d.bq;
import com.tinder.utils.C3095y;
import com.tinder.utils.al;
import java.util.HashMap;

/* renamed from: com.tinder.fragments.d */
public class C2610d extends C2418c implements OnClickListener, OnTouchListener, OnCheckedChangeListener, af, bq, C2429h, C2471a, C2475a {
    private TextView f4878a;
    private EditText f4879b;
    private RadioButton f4880c;
    private RadioButton f4881d;
    private SwitchCompat f4882e;
    private SwitchCompat f4883f;
    private SwitchCompat f4884g;
    private SwitchCompat f4885h;
    private C2957o f4886i;
    private C2515r f4887j;
    private ag f4888k;
    private View f4889l;
    private Gender f4890m;
    private boolean f4891n;
    private boolean f4892o;
    private boolean f4893p;
    private boolean f4894q;
    private boolean f4895r;
    private boolean f4896s;
    private boolean f4897t;
    private boolean f4898u;
    private boolean f4899v;
    private C2473c f4900w;

    /* renamed from: com.tinder.fragments.d.1 */
    class C26081 implements Runnable {
        final /* synthetic */ View f4875a;
        final /* synthetic */ C2610d f4876b;

        C26081(C2610d c2610d, View view) {
            this.f4876b = c2610d;
            this.f4875a = view;
        }

        public void run() {
            LayoutParams layoutParams = (LayoutParams) this.f4875a.getLayoutParams();
            layoutParams.topMargin = this.f4876b.getResources().getDimensionPixelSize(R.dimen.margin_large);
            this.f4875a.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.tinder.fragments.d.2 */
    class C26092 implements C2243y {
        final /* synthetic */ C2610d f4877a;

        C26092(C2610d c2610d) {
            this.f4877a = c2610d;
        }

        public void m7170a() {
            Intent intent = new Intent(this.f4877a.getActivity(), ActivityLogin.class);
            intent.setFlags(AccessibilityNodeInfoCompat.ACTION_PASTE);
            intent.putExtra("extra_show_intro", BuildConfig.FLAVOR);
            this.f4877a.startActivity(intent);
            this.f4877a.getActivity().finish();
            al.m9297c(this.f4877a.f4887j);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C3095y.m9469a();
        View inflate = layoutInflater.inflate(R.layout.view_app_settings, viewGroup, false);
        inflate.findViewById(R.id.view_back_icon).setOnClickListener(this);
        inflate.findViewById(R.id.view_ab_icon).setOnClickListener(this);
        inflate.findViewById(R.id.view_back_title).setOnClickListener(this);
        View findViewById = inflate.findViewById(R.id.button_restore_purchase);
        findViewById.setOnClickListener(this);
        al.m9287b(findViewById);
        View findViewById2 = inflate.findViewById(R.id.button_logout);
        findViewById2.setOnClickListener(this);
        al.m9287b(findViewById2);
        findViewById = inflate.findViewById(R.id.button_privacy_policy);
        findViewById.setOnClickListener(this);
        al.m9287b(findViewById);
        findViewById = inflate.findViewById(R.id.button_tos);
        findViewById.setOnClickListener(this);
        al.m9287b(findViewById);
        inflate.findViewById(R.id.button_delete_account).setOnClickListener(this);
        TextView textView = (TextView) inflate.findViewById(R.id.txt_version_num);
        this.f4878a = (TextView) inflate.findViewById(R.id.textView_distances_in);
        this.f4880c = (RadioButton) inflate.findViewById(R.id.radioButton_miles);
        this.f4881d = (RadioButton) inflate.findViewById(R.id.radioButton_kilometers);
        this.f4879b = (EditText) inflate.findViewById(R.id.editText_ip_config);
        this.f4889l = inflate.findViewById(R.id.blocker);
        findViewById2.post(new C26081(this, findViewById2));
        this.f4882e = (SwitchCompat) inflate.findViewById(R.id.check_new_match_push);
        this.f4883f = (SwitchCompat) inflate.findViewById(R.id.check_new_message_push);
        this.f4884g = (SwitchCompat) inflate.findViewById(R.id.check_new_moment_like_push);
        this.f4885h = (SwitchCompat) inflate.findViewById(R.id.check_super_like_push);
        if (ManagerApp.m7914e().as()) {
            this.f4885h.setVisibility(0);
            inflate.findViewById(R.id.super_like_push_divider).setVisibility(0);
        }
        textView.setText(String.format(getString(R.string.version), new Object[]{ManagerApp.f5583f}));
        this.f4879b.setVisibility(8);
        this.f4880c.setOnCheckedChangeListener(this);
        this.f4881d.setOnCheckedChangeListener(this);
        this.f4882e.setOnCheckedChangeListener(this);
        this.f4883f.setOnCheckedChangeListener(this);
        this.f4884g.setOnCheckedChangeListener(this);
        this.f4885h.setOnCheckedChangeListener(this);
        C3095y.m9471a("Pulling up values from settings");
        this.f4886i = ManagerApp.m7918i();
        m7173e();
        m7174f();
        return inflate;
    }

    public void onPause() {
        C3095y.m9469a();
        super.onPause();
    }

    public void onDestroyView() {
        C3095y.m9469a();
        super.onDestroyView();
        al.m9297c(this.f4900w);
        al.m9297c(this.f4888k);
    }

    public void onDestroy() {
        super.onDestroy();
        al.m9297c(this.f4887j);
    }

    private void m7173e() {
        this.f4890m = ManagerApp.m7922m().m8599d().getGender();
        this.f4893p = this.f4886i.m8763e();
        this.f4896s = this.f4886i.m8757b();
        this.f4897t = this.f4886i.m8759c();
        this.f4898u = this.f4886i.m8761d();
        this.f4899v = C2958p.au();
    }

    private void m7174f() {
        m7172a(this.f4890m);
        this.f4880c.setChecked(this.f4893p);
        this.f4881d.setChecked(!this.f4893p);
        this.f4882e.setChecked(this.f4896s);
        this.f4883f.setChecked(this.f4897t);
        this.f4884g.setChecked(this.f4898u);
        this.f4885h.setChecked(this.f4899v);
    }

    private boolean m7175g() {
        if (m7176h()) {
            return true;
        }
        return false;
    }

    private boolean m7176h() {
        return this.f4890m != ManagerApp.m7922m().m8599d().getGender();
    }

    private void m7172a(Gender gender) {
        if (gender == Gender.MALE) {
            this.f4890m = Gender.MALE;
        } else {
            this.f4890m = Gender.FEMALE;
        }
    }

    private void m7177i() {
        this.f4878a.setText(BuildConfig.FLAVOR);
        if (this.f4893p) {
            C3095y.m9471a("Prefers miles");
            this.f4878a.setText(getString(R.string.miles));
            this.f4880c.setTextColor(getActivity().getResources().getColor(R.color.white));
            this.f4881d.setTextColor(getActivity().getResources().getColor(R.color.gray));
            return;
        }
        C3095y.m9471a("Prefers kms");
        this.f4878a.setText(getString(R.string.kilometers));
        this.f4880c.setTextColor(getActivity().getResources().getColor(R.color.gray));
        this.f4881d.setTextColor(getActivity().getResources().getColor(R.color.white));
    }

    public void onClick(@NonNull View view) {
        C3095y.m9471a("view=" + view);
        switch (view.getId()) {
            case R.id.item_text_centerLeft:
                getActivity().onBackPressed();
            case R.id.view_back_icon:
            case R.id.view_ab_icon:
            case R.id.view_back_title:
                ((ActivityMain) getActivity()).m6215w();
            case R.id.button_restore_purchase:
                ((ActivityMain) getActivity()).m6195b(true);
            case R.id.button_privacy_policy:
                this.f4888k = new ag(getActivity(), "http://www.gotinder.com/privacy/", getString(R.string.privacy_policy));
                this.f4888k.show();
            case R.id.button_tos:
                this.f4888k = new ag(getActivity(), "http://www.gotinder.com/terms/", getString(R.string.terms_of_service));
                this.f4888k.show();
            case R.id.button_logout:
                new C2476d(getActivity(), this).show();
            case R.id.button_delete_account:
                m7178j();
            default:
                C3095y.m9471a("view not recognized");
        }
    }

    private void m7178j() {
        if (this.f4900w == null || !this.f4900w.isShowing()) {
            this.f4900w = new C2473c(getActivity(), this);
            this.f4900w.show();
        }
    }

    private void m7179k() {
        if (this.f4887j == null) {
            this.f4887j = new C2515r(getActivity());
        }
        if (!this.f4887j.isShowing() && getActivity() != null) {
            this.f4887j.show();
        }
    }

    private void m7180l() {
        if (!this.f4892o) {
            C2807a.m8064b(new SparksEvent("Account.FbLogout"));
            m7179k();
            this.f4892o = true;
            ManagerApp.m7911b().m8135a(new C26092(this));
        }
    }

    private void m7181m() {
        C3095y.m9469a();
        C2807a.m8064b(new SparksEvent("Account.Delete"));
        m7179k();
        ManagerApp.m7911b().m8132a((C2429h) this);
    }

    public void m7188c() {
        C3095y.m9471a("ACCT DELETED");
        if (getActivity() != null) {
            al.m9297c(this.f4887j);
            Intent intent = new Intent(getActivity(), ActivityLogin.class);
            Bundle bundle = new Bundle();
            bundle.putString("extra_show_intro", BuildConfig.FLAVOR);
            intent.putExtras(bundle);
            intent.putExtra("show delete account dialog", true);
            startActivity(intent);
            getActivity().setResult(321);
            this.f4891n = true;
            getActivity().finish();
        }
    }

    public void m7189d() {
        C3095y.m9471a("ACCT NOT DELETED");
        if (getActivity() != null) {
            al.m9297c(this.f4887j);
            Toast.makeText(getActivity(), getActivity().getString(R.string.failed_delete), 1).show();
        }
    }

    public boolean onTouch(@NonNull View view, @NonNull MotionEvent motionEvent) {
        if (al.m9291b(motionEvent)) {
            al.m9272a(view, false);
        } else {
            al.m9272a(view, true);
        }
        return false;
    }

    public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean z) {
        C3095y.m9471a("checked=" + compoundButton);
        HashMap hashMap = new HashMap();
        switch (compoundButton.getId()) {
            case R.id.check_new_match_push:
                this.f4896s = z;
                ManagerApp.m7918i().m8753a(z);
                C2913k.m8569a();
            case R.id.check_new_message_push:
                this.f4897t = z;
                ManagerApp.m7918i().m8756b(z);
                C2913k.m8569a();
            case R.id.check_super_like_push:
                this.f4899v = z;
                C2958p.m8778H(z);
                C2913k.m8569a();
            case R.id.check_new_moment_like_push:
                this.f4898u = z;
                ManagerApp.m7918i().m8758c(z);
                C2913k.m8569a();
            case R.id.radioButton_kilometers:
                C3095y.m9471a("kms checked=" + z);
                if (z) {
                    this.f4893p = !z;
                    ManagerApp.m7918i().m8760d(this.f4893p);
                    m7177i();
                }
            case R.id.radioButton_miles:
                C3095y.m9471a("miles checked=" + z);
                if (z) {
                    this.f4893p = z;
                    ManagerApp.m7918i().m8760d(this.f4893p);
                    m7177i();
                }
            default:
                C3095y.m9476b("button not recognized");
        }
    }

    public void m7185a() {
        m7181m();
    }

    public void onMenuItemClick(int i) {
        C3095y.m9471a("resId=" + i);
        switch (i) {
            case R.drawable.selector_actionbar_menu:
                C3095y.m9471a("Menu opened");
                ((ActivityMain) getActivity()).m6202j();
                this.f4894q = true;
                m7186a(false);
            default:
        }
    }

    public void m7183E() {
        C3095y.m9469a();
        Toast.makeText(ManagerApp.m7917h(), ManagerApp.m7917h().getString(R.string.updated_profile), 1).show();
        m7182n();
    }

    public void m7184F() {
        C3095y.m9469a();
        Toast.makeText(ManagerApp.m7917h(), ManagerApp.m7917h().getString(R.string.failed_update_profile), 1).show();
        m7182n();
    }

    private void m7182n() {
        C3095y.m9469a();
        al.m9297c(this.f4887j);
        if (getActivity() == null) {
            C3095y.m9476b("ActivityMain null");
        } else if (this.f4894q) {
            this.f4894q = false;
        }
        if (!this.f4895r || getActivity().getSupportFragmentManager() == null) {
            C3095y.m9471a("Not going back: mWasBackPressed=" + this.f4895r);
            return;
        }
        C3095y.m9471a("Back was pressed ...");
        this.f4895r = false;
    }

    public void m7186a(boolean z) {
        C3095y.m9469a();
        this.f4895r = z;
        if (this.f4891n || this.f4892o || !m7175g()) {
            C3095y.m9471a("Account deleted/no change occurred, not calling updateProfile()");
            if (z && getFragmentManager() != null) {
                getFragmentManager().popBackStack();
            }
        } else {
            m7179k();
            C2957o i = ManagerApp.m7918i();
            ManagerApp.m7922m().m8595a(i.m8774k(), i.m8773j(), i.m8766g(), i.m8768h(), i.m8770i(), null, this.f4890m, (bq) this);
        }
        this.f4886i.m8771i(m7175g());
    }

    public void m7187b() {
        m7180l();
    }
}
