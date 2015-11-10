package com.tinder.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.CallbackManager;
import com.facebook.login.LoginBehavior;
import com.facebook.login.widget.LoginButton;
import com.tinder.R;
import com.tinder.fragments.FragmentIntro.C2275a;
import com.tinder.managers.ManagerApp;

/* renamed from: com.tinder.fragments.r */
public class C2694r extends Fragment {
    protected LoginButton f5224a;
    C2275a f5225b;

    /* renamed from: com.tinder.fragments.r.1 */
    class C26931 implements OnClickListener {
        final /* synthetic */ C2694r f5223a;

        C26931(C2694r c2694r) {
            this.f5223a = c2694r;
        }

        public void onClick(View view) {
            if (this.f5223a.f5225b != null) {
                this.f5223a.f5225b.m6074d();
            }
            this.f5223a.f5224a.setLoginBehavior(ManagerApp.f5579b ? LoginBehavior.NATIVE_WITH_FALLBACK : LoginBehavior.WEB_ONLY);
            this.f5223a.f5224a.performClick();
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof C2275a) {
            this.f5225b = (C2275a) activity;
        }
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(R.layout.view_privacy, viewGroup, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f5224a = (LoginButton) view.findViewById(R.id.button_facebook_login);
        this.f5224a.setReadPermissions(ManagerApp.m7912c().m8169e());
        view.findViewById(R.id.button_login_real).setOnClickListener(new C26931(this));
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        CallbackManager v_ = this.f5225b.v_();
        if (v_ != null) {
            v_.onActivityResult(i, i2, intent);
        }
    }
}
