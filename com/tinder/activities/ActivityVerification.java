package com.tinder.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import com.facebook.stetho.BuildConfig;
import com.tinder.base.ActivitySignedInBase;
import com.tinder.dialogs.C2515r;
import com.tinder.fragments.C2603b;
import com.tinder.fragments.C2726u;
import com.tinder.fragments.C2728v;
import com.tinder.fragments.C2731w;
import com.tinder.managers.C2807a;
import com.tinder.managers.C2833d.C2296a;
import com.tinder.managers.ManagerApp;
import com.tinder.model.SparksEvent;
import com.tinder.p030d.C2243y;
import com.tinder.utils.C3095y;
import com.tinder.utils.al;

public class ActivityVerification extends ActivitySignedInBase implements C2296a {
    private C2731w f3976a;
    private C2728v f3977b;
    private C2726u f3978c;
    private boolean f3979e;
    private boolean f3980f;
    private boolean f3981g;
    private C2515r f3982h;
    private String f3983i;

    /* renamed from: com.tinder.activities.ActivityVerification.1 */
    class C23071 implements C2243y {
        final /* synthetic */ ActivityVerification f3975a;

        C23071(ActivityVerification activityVerification) {
            this.f3975a = activityVerification;
        }

        public void m6272a() {
            C2807a.m8064b(new SparksEvent("Account.FbLogout"));
            if (this.f3975a != null) {
                Intent intent = new Intent(this.f3975a, ActivityLogin.class);
                intent.setFlags(AccessibilityNodeInfoCompat.ACTION_PASTE);
                intent.putExtra("extra_show_intro", BuildConfig.FLAVOR);
                this.f3975a.startActivity(intent);
            }
            this.f3975a.finish();
            this.f3975a.m6284f();
        }
    }

    protected void onCreate(Bundle bundle) {
        C3095y.m9471a("savedInstanceState=" + bundle);
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f3979e = extras.getBoolean("is_banned", false);
            this.f3980f = extras.getBoolean("is_age_verification_needed", false);
            this.f3981g = extras.getBoolean("is_gender_verification_needed", false);
        }
        this.f3976a = new C2731w();
        this.f3978c = new C2726u();
        this.f3977b = new C2728v();
        m6285g();
    }

    public boolean q_() {
        return false;
    }

    public void onPause() {
        super.onPause();
        ManagerApp.m7913d().m8197a((C2296a) this);
    }

    public void onResume() {
        super.onResume();
        ManagerApp.m7913d().m8195a((Activity) this, (C2296a) this);
    }

    public void m6283e() {
        if (this.f3982h == null) {
            this.f3982h = new C2515r(this);
        }
        this.f3982h.show();
    }

    public void m6284f() {
        al.m9297c(this.f3982h);
    }

    public void showCountrySelection(View view) {
        C3095y.m9469a();
        al.m9268a(getWindow().getDecorView().getWindowToken(), (Activity) this);
        m5917a(this.f3977b);
    }

    public void m6278a(String str, String str2) {
        C3095y.m9471a("countryName=" + str + ", countryCode=" + str2);
        this.f3976a = new C2731w();
        Bundle bundle = new Bundle();
        bundle.putString("country_name", str);
        bundle.putString("country_code", str2);
        this.f3976a.setArguments(bundle);
        m5928c(this.f3976a);
    }

    public void m6277a(String str) {
        C3095y.m9469a();
        Bundle bundle = new Bundle();
        bundle.putString("phone_number", str);
        this.f3978c.setArguments(bundle);
        m5917a(this.f3978c);
    }

    public void m6285g() {
        C3095y.m9469a();
        Fragment c2603b = new C2603b();
        if (this.f3979e) {
            C3095y.m9471a("Banned");
            m5917a(this.f3976a);
        } else if (this.f3980f && this.f3981g) {
            C3095y.m9471a("Both Age & Gender verification needed");
            r1 = new Bundle();
            r1.putBoolean("is_age_verification_needed", true);
            r1.putBoolean("is_gender_verification_needed", true);
            c2603b.setArguments(r1);
            m5917a(c2603b);
        } else if (this.f3980f) {
            C3095y.m9471a("Age verification needed");
            r1 = new Bundle();
            r1.putBoolean("is_age_verification_needed", true);
            r1.putBoolean("is_gender_verification_needed", false);
            c2603b.setArguments(r1);
            m5917a(c2603b);
        } else if (this.f3981g) {
            C3095y.m9471a("Gender verification needed");
            r1 = new Bundle();
            r1.putBoolean("is_age_verification_needed", false);
            r1.putBoolean("is_gender_verification_needed", true);
            c2603b.setArguments(r1);
            m5917a(c2603b);
        } else {
            C3095y.m9471a("Moving forward");
            ManagerApp.m7911b().m8139a(true);
            ManagerApp.m7925p().m8278a(true);
            ManagerApp.m7926q().m8472c();
            Bundle bundle = new Bundle();
            bundle.putString("extra_show_loading", BuildConfig.FLAVOR);
            m6276a(ActivityMain.class, bundle);
        }
    }

    public void m6279a(boolean z) {
        this.f3979e = z;
    }

    public void m6281b(boolean z) {
        this.f3980f = z;
    }

    public void m6282c(boolean z) {
        this.f3981g = z;
    }

    public void m6276a(Class cls, @Nullable Bundle bundle) {
        C3095y.m9469a();
        ManagerApp.m7914e().m8875u(true);
        Intent intent = new Intent(getApplicationContext(), cls);
        intent.addFlags(268435456);
        intent.addFlags(67108864);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        finish();
    }

    public void onBackPressed() {
        C3095y.m9469a();
        m5909U();
        if (getSupportFragmentManager().getBackStackEntryCount() < 2) {
            C3095y.m9471a("Logging out");
            m6274j();
            return;
        }
        C3095y.m9471a("Popping back stack");
        super.onBackPressed();
        m6273i();
    }

    private void m6273i() {
    }

    private void m6274j() {
        m6283e();
        ManagerApp.m7911b().m8135a(new C23071(this));
    }

    public String m6286h() {
        return this.f3983i;
    }

    public void m6280b(String str) {
        this.f3983i = str;
    }

    public void m6275R() {
    }
}
