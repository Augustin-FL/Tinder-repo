package com.tinder.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.share.internal.ShareConstants;
import com.tinder.base.ActivitySignedInBase;
import com.tinder.dialogs.C2504p;
import com.tinder.dialogs.C2504p.C2242a;
import com.tinder.fragments.C2599a;
import com.tinder.fragments.C2607c;
import com.tinder.managers.ManagerApp;
import com.tinder.utils.C3095y;
import com.tinder.utils.al;

public class ActivityAddPhoto extends ActivitySignedInBase implements C2242a {
    private C2599a f3721a;
    private C2607c f3722b;
    private boolean f3723c;
    private C2504p f3724e;

    protected void onCreate(Bundle bundle) {
        C3095y.m9471a("savedInstanceState=" + bundle);
        super.onCreate(bundle);
        m5908T();
        this.f3721a = new C2599a();
        this.f3722b = new C2607c();
        m5931e();
        if (ManagerApp.m7912c().m8168d("user_photos")) {
            C3095y.m9471a("user already has user_photos permission");
            return;
        }
        C3095y.m9471a("user_photo permission not available");
        m5932f();
    }

    public boolean q_() {
        return true;
    }

    public void m5933a(String str, String str2) {
        C3095y.m9471a("albumId=" + str + ", albumName=" + str2);
        Bundle bundle = new Bundle();
        bundle.putString(ShareConstants.WEB_DIALOG_PARAM_ID, str);
        bundle.putString(ShareConstants.WEB_DIALOG_PARAM_NAME, str2);
        this.f3721a.setArguments(bundle);
        m5928c(this.f3721a);
        ab().setMenu(this.f3722b);
        this.f3723c = false;
    }

    private void m5931e() {
        C3095y.m9469a();
        m5928c(this.f3722b);
        ab().setMenu(this.f3722b);
        this.f3723c = true;
    }

    public void onBackPressed() {
        C3095y.m9469a();
        if (this.f3723c) {
            super.onBackPressed();
        } else {
            m5931e();
        }
    }

    private void m5932f() {
        if (this.f3724e == null || !this.f3724e.isShowing()) {
            this.f3724e = new C2504p(this, this);
            this.f3724e.show();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.f3723c) {
            this.f3722b.m7169a();
        }
    }

    public void onDestroy() {
        C3095y.m9469a();
        al.m9297c(this.f3724e);
        super.onDestroy();
    }

    public void m5934b() {
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
