package com.tinder.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.facebook.AccessToken;
import com.tinder.base.ActivitySignedInBase;
import com.tinder.dialogs.C2504p;
import com.tinder.dialogs.C2504p.C2242a;
import com.tinder.fragments.C2626g;
import com.tinder.managers.ManagerApp;
import com.tinder.utils.C3095y;

public class ActivityEditProfile extends ActivitySignedInBase implements C2242a {
    private C2504p f3861a;
    private C2626g f3862b;
    private int f3863c;

    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        C3095y.m9469a();
        if (bundle == null) {
            if (!(getIntent().getExtras() == null || getIntent().getExtras().get("instagramConnectValue") == null)) {
                this.f3863c = getIntent().getExtras().getInt("instagramConnectValue");
            }
            this.f3862b = new C2626g();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("instagramConnectValue", this.f3863c);
            this.f3862b.setArguments(bundle2);
            m5918a(this.f3862b, "fragment edit profile");
        } else {
            this.f3862b = (C2626g) getSupportFragmentManager().findFragmentByTag("fragment edit profile");
        }
        if (ManagerApp.m7912c().m8168d("user_photos")) {
            C3095y.m9471a("user already has user_photos permission");
            return;
        }
        C3095y.m9471a("user_photo permission not available");
        m6062e();
    }

    private void m6062e() {
        if (this.f3861a == null || !this.f3861a.isShowing()) {
            this.f3861a = new C2504p(this, this);
            this.f3861a.show();
        }
    }

    public boolean q_() {
        return false;
    }

    public void onBackPressed() {
        C3095y.m9469a();
        this.f3862b.m7250a(true);
    }

    public void m6063b() {
        C3095y.m9469a();
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        C3095y.m9471a("facebook token=" + currentAccessToken);
        if (currentAccessToken.getToken() == null || currentAccessToken.isExpired()) {
            C3095y.m9471a("Session not opened");
        } else {
            ManagerApp.m7912c().m8165a((Activity) this, 4, new String[0]);
        }
    }

    public void r_() {
        ManagerApp.m7914e().m8885z(true);
    }
}
