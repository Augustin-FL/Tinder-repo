package com.tinder.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import com.crashlytics.android.C0359a;
import com.google.android.gcm.C0707a;
import com.tinder.GCMIntentService;
import com.tinder.managers.ManagerApp;
import com.tinder.model.User;
import com.tinder.utils.C3095y;
import com.tinder.views.CustomActionBar;

public class ActivitySignedInBase extends ActivityBase {
    private CustomActionBar f3720a;

    public ActivitySignedInBase() {
        super(false);
    }

    public ActivitySignedInBase(boolean z) {
        super(z);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aa();
    }

    public void onPause() {
        ManagerApp.m7926q().m8468b();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        ManagerApp.m7926q().m8453a();
        m5929e();
        User d = ManagerApp.m7922m().m8599d();
        if (d != null && C0359a.m450e() != null) {
            C0359a.m449c(d.getName());
            C0359a.m448b(d.getId());
        }
    }

    public void aa() {
        ActionBar supportActionBar = getSupportActionBar();
        if (q_()) {
            if (supportActionBar != null && supportActionBar.getCustomView() == null) {
                this.f3720a = new CustomActionBar(this);
                supportActionBar.setCustomView(this.f3720a);
                supportActionBar.setDisplayShowCustomEnabled(true);
                supportActionBar.show();
            }
        } else if (supportActionBar != null) {
            supportActionBar.hide();
        }
    }

    public boolean q_() {
        return false;
    }

    private void m5929e() {
        try {
            C0707a.m984a((Context) this);
            C0707a.m989b(this);
            Object f = C0707a.m994f(this);
            if (TextUtils.isEmpty(f)) {
                C3095y.m9483d("Registering PUSH");
                ManagerApp.m7914e().m8867q(false);
                C0707a.m987a((Context) this, "465293127427");
                return;
            }
            C3095y.m9483d("Already registered, regid: " + f);
            if (ManagerApp.m7914e().m8804H()) {
                C3095y.m9483d("Already registered with Tinder push backend.");
                return;
            }
            C3095y.m9483d("Haven't registered with Tinder push backend.");
            GCMIntentService.m5884e(this, C0707a.m994f(this));
        } catch (UnsupportedOperationException e) {
            C3095y.m9479c("issue is: " + e.getMessage());
        }
    }

    public CustomActionBar ab() {
        if (this.f3720a == null) {
            this.f3720a = new CustomActionBar(this);
        }
        return this.f3720a;
    }
}
