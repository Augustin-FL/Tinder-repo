package com.tinder.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.CallbackManager.Factory;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.facebook.TinderAccessTokenManager;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.share.internal.ShareConstants;
import com.tinder.R;
import com.tinder.base.ActivityBase;
import com.tinder.dialogs.C2472h;
import com.tinder.dialogs.C2483g;
import com.tinder.dialogs.C2488j;
import com.tinder.dialogs.C2515r;
import com.tinder.fragments.C2694r;
import com.tinder.fragments.C2748y;
import com.tinder.fragments.FragmentIntro;
import com.tinder.fragments.FragmentIntro.C2275a;
import com.tinder.fragments.FragmentIntro.C2276b;
import com.tinder.managers.C2807a;
import com.tinder.managers.C2828c;
import com.tinder.managers.ManagerApp;
import com.tinder.model.SparksEvent;
import com.tinder.p030d.C2268w;
import com.tinder.utils.C3071j;
import com.tinder.utils.C3095y;
import com.tinder.utils.al;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ActivityLogin extends ActivityBase implements C2268w, C2275a, C2276b {
    private static boolean f3872c;
    private static boolean f3873e;
    protected C2828c f3874a;
    protected C2515r f3875b;
    private CallbackManager f3876f;
    private C2472h f3877g;
    private FragmentIntro f3878h;
    private C2694r f3879i;
    private C2748y f3880j;
    private C2472h f3881k;
    private C2488j f3882l;
    private boolean f3883m;

    /* renamed from: com.tinder.activities.ActivityLogin.1 */
    class C22701 extends AsyncTask<AccessToken, Void, AccessToken> {
        final /* synthetic */ ActivityLogin f3865a;

        /* renamed from: com.tinder.activities.ActivityLogin.1.1 */
        class C22691 implements C2268w {
            final /* synthetic */ C22701 f3864a;

            C22691(C22701 c22701) {
                this.f3864a = c22701;
            }

            public void m6069l() {
                C3095y.m9471a("Attempting tinder token login: success!");
                this.f3864a.f3865a.m6095l();
                this.f3864a.f3865a.m6085a(false);
            }

            public void m6070m() {
                C3095y.m9471a("Attempting tinder token login: failure!");
                this.f3864a.f3865a.m6096m();
                this.f3864a.f3865a.m6085a(false);
            }

            public void m6071n() {
                C3095y.m9471a("Attempting tinder token login: deeeeeenied!");
                this.f3864a.f3865a.m6097n();
                this.f3864a.f3865a.m6085a(false);
            }

            public void m6068a(boolean z, boolean z2, boolean z3) {
                C3095y.m9471a("Attempting tinder token login: verification needed.");
                this.f3864a.f3865a.m6084a(z, z2, z3);
                this.f3864a.f3865a.m6085a(false);
            }
        }

        C22701(ActivityLogin activityLogin) {
            this.f3865a = activityLogin;
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m6072a((AccessToken[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m6073a((AccessToken) obj);
        }

        protected AccessToken m6072a(AccessToken... accessTokenArr) {
            AccessToken accessToken = accessTokenArr[0];
            C3095y.m9471a("Currently the access token is: " + accessToken);
            if (accessToken == null) {
                boolean loadAccessToken = new TinderAccessTokenManager().loadAccessToken();
                if (loadAccessToken) {
                    accessToken = AccessToken.getCurrentAccessToken();
                }
                C3095y.m9471a("Was able to load a facebook token somehow? " + loadAccessToken);
                C3095y.m9471a("Token loaded is: " + accessToken);
            }
            return accessToken;
        }

        protected void m6073a(AccessToken accessToken) {
            if (accessToken == null || ManagerApp.m7911b().m8144e()) {
                C3095y.m9471a("No token was returned, auth check will send to login screen.");
                this.f3865a.m6085a(true);
                return;
            }
            C3095y.m9471a("Attempting login because we have a facebook token.");
            ManagerApp.m7911b().m8133a(new C22691(this), accessToken.getToken());
        }
    }

    /* renamed from: com.tinder.activities.ActivityLogin.2 */
    class C22722 implements Callback {
        final /* synthetic */ ActivityLogin f3868a;

        /* renamed from: com.tinder.activities.ActivityLogin.2.1 */
        class C22711 implements OnDismissListener {
            final /* synthetic */ List f3866a;
            final /* synthetic */ C22722 f3867b;

            C22711(C22722 c22722, List list) {
                this.f3867b = c22722;
                this.f3866a = list;
            }

            public void onDismiss(DialogInterface dialogInterface) {
                ManagerApp.m7912c().m8165a(this.f3867b.f3868a, 0, (String[]) this.f3866a.toArray(new String[this.f3866a.size()]));
            }
        }

        C22722(ActivityLogin activityLogin) {
            this.f3868a = activityLogin;
        }

        public void onCompleted(GraphResponse graphResponse) {
            Throwable th;
            if (graphResponse == null) {
                try {
                    C3095y.m9479c("No facebook graph response, cannot check permissions.");
                    return;
                } catch (Throwable e) {
                    Throwable th2 = e;
                    r0 = null;
                    th = th2;
                    C3095y.m9474a("Failed facebook permissions check json", th);
                    ManagerApp.m7912c().m8166a(r0);
                    r0 = ManagerApp.m7912c().m8164a();
                    List a;
                    if (!a.isEmpty()) {
                        C3095y.m9479c("Missing some required(!) facebook permissions!");
                        this.f3868a.f3882l = new C2488j(this.f3868a);
                        this.f3868a.f3882l.setOnDismissListener(new C22711(this, a));
                        this.f3868a.f3882l.show();
                    }
                }
            }
            JSONObject jSONObject = graphResponse.getJSONObject();
            if (jSONObject == null) {
                C3095y.m9479c("No facebook graph data was returned, cannot check permissions.");
                return;
            }
            Set set;
            JSONArray jSONArray = jSONObject.getJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA);
            set = new HashSet(jSONArray.length());
            int i = 0;
            while (i < jSONArray.length()) {
                try {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    String string = jSONObject2.getString("permission");
                    if (jSONObject2.getString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS).equals("granted")) {
                        set.add(string);
                    } else {
                        C3095y.m9479c("Facebook Permission declined: " + string);
                    }
                    i++;
                } catch (JSONException e2) {
                    th = e2;
                }
            }
            ManagerApp.m7912c().m8166a(set);
            a = ManagerApp.m7912c().m8164a();
            if (!a.isEmpty()) {
                C3095y.m9479c("Missing some required(!) facebook permissions!");
                this.f3868a.f3882l = new C2488j(this.f3868a);
                this.f3868a.f3882l.setOnDismissListener(new C22711(this, a));
                this.f3868a.f3882l.show();
            }
        }
    }

    /* renamed from: com.tinder.activities.ActivityLogin.3 */
    class C22733 implements OnClickListener {
        final /* synthetic */ C2472h f3869a;
        final /* synthetic */ ActivityLogin f3870b;

        C22733(ActivityLogin activityLogin, C2472h c2472h) {
            this.f3870b = activityLogin;
            this.f3869a = c2472h;
        }

        public void onClick(View view) {
            al.m9297c(this.f3869a);
            this.f3870b.moveTaskToBack(true);
            this.f3870b.finish();
        }
    }

    /* renamed from: com.tinder.activities.ActivityLogin.4 */
    class C22744 implements OnClickListener {
        final /* synthetic */ ActivityLogin f3871a;

        C22744(ActivityLogin activityLogin) {
            this.f3871a = activityLogin;
        }

        public void onClick(View view) {
            al.m9297c(this.f3871a.f3877g);
        }
    }

    public ActivityLogin() {
        this.f3882l = null;
        this.f3883m = false;
    }

    public /* synthetic */ void onSuccess(@NonNull Object obj) {
        m6082a((LoginResult) obj);
    }

    @Nullable
    public CallbackManager v_() {
        return this.f3876f;
    }

    public void m6087d() {
        f3872c = true;
        m6092i();
    }

    public void m6082a(@NonNull LoginResult loginResult) {
        if (f3873e) {
            C3095y.m9471a("Already logging in to Tinder ...");
            return;
        }
        C3095y.m9471a("Logging in to Tinder ...");
        if (loginResult.getRecentlyDeniedPermissions().isEmpty()) {
            f3873e = true;
            m6083a(loginResult.getAccessToken().getToken());
            return;
        }
        m6080r();
    }

    public void onCancel() {
        if (f3872c) {
            m6091h();
            f3872c = false;
            SparksEvent sparksEvent = new SparksEvent("Account.FbLogin");
            sparksEvent.put(GraphResponse.SUCCESS_KEY, Boolean.valueOf(false));
            C2807a.m8056a(sparksEvent);
        }
        m6093j();
    }

    public void onError(FacebookException facebookException) {
        SparksEvent sparksEvent = new SparksEvent("Account.FbLogin");
        sparksEvent.put(GraphResponse.SUCCESS_KEY, Boolean.valueOf(false));
        C2807a.m8056a(sparksEvent);
        m6091h();
        m6094k();
    }

    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        C3095y.m9469a();
        this.f3876f = Factory.create();
        this.f3874a = ManagerApp.m7912c();
        this.f3878h = new FragmentIntro();
        this.f3879i = new C2694r();
        this.f3880j = new C2748y();
        Intent intent = getIntent();
        if (bundle == null) {
            if (intent.hasExtra("show delete account dialog")) {
                this.f3881k = new C2483g(this);
                this.f3881k.show();
            }
            this.f3883m = intent.hasExtra("extra_show_intro");
        }
        m5908T();
        if (this.f3883m) {
            m5923b(this.f3878h);
        } else if (ManagerApp.m7911b().m8144e()) {
            C3095y.m9471a("Already logged in, going forward.");
            m6085a(true);
        } else {
            m6089f();
            C3095y.m9471a("Not logged in, trying to fix that...");
            new C22701(this).execute(new AccessToken[]{AccessToken.getCurrentAccessToken()});
        }
    }

    public void onPause() {
        super.onPause();
        C3095y.m9469a();
        al.m9297c(this.f3877g);
    }

    protected void onResume() {
        super.onResume();
        f3872c = false;
        f3873e = false;
    }

    public boolean m6085a(boolean z) {
        C3095y.m9469a();
        m6090g();
        boolean e = ManagerApp.m7911b().m8144e();
        C3095y.m9471a("user is logged in = " + e);
        if (e) {
            ManagerApp.m7912c();
            String c = C2828c.m8162c();
            m6080r();
            if (z) {
                C3095y.m9471a("Logging in, using facebook token " + c + " to get a tinder token");
                m6086b(c);
            }
        } else {
            m5923b(this.f3878h);
        }
        return e;
    }

    private void m6080r() {
        GraphRequest.newGraphPathRequest(AccessToken.getCurrentAccessToken(), "me/permissions", new C22722(this)).executeAsync();
    }

    private void m6081s() {
        if (this.f3882l == null || !this.f3882l.isShowing()) {
            startActivity(new Intent(this, ActivityMain.class));
            overridePendingTransition(0, 0);
            finish();
            return;
        }
        C3095y.m9479c("Not launching main activity, missing permissions.");
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        C3095y.m9471a(String.format("onActivityResult: requestCode[%s] responseCode[%s]", new Object[]{Integer.valueOf(i % NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST), Integer.valueOf(i2)}));
        if (!this.f3876f.onActivityResult(i % NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        }
        if (this.f3882l != null && i2 == -1) {
            m6085a(true);
        }
    }

    public void onDestroy() {
        C3095y.m9469a();
        m6090g();
        al.m9297c(this.f3881k);
        this.f3882l = null;
        super.onDestroy();
    }

    protected boolean m6088e() {
        boolean isDefaultNetworkActive;
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
        if (VERSION.SDK_INT >= 21) {
            isDefaultNetworkActive = connectivityManager.isDefaultNetworkActive();
        } else {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            isDefaultNetworkActive = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        if (isDefaultNetworkActive) {
            LoginManager.getInstance().logOut();
            Intent intent = new Intent(this, ActivityLogin.class);
            intent.addFlags(8421376);
            startActivity(intent);
            return true;
        }
        C2472h c2472h = new C2472h((Context) this, 0, (int) R.string.login_failed, (int) R.string.error_network_missing);
        c2472h.m6874a(false);
        c2472h.setCancelable(false);
        c2472h.setCanceledOnTouchOutside(false);
        c2472h.m6877c(R.string.ok, new C22733(this, c2472h));
        c2472h.show();
        return false;
    }

    @MainThread
    public void m6089f() {
        if (this.f3875b == null) {
            this.f3875b = new C2515r(this);
        }
        this.f3875b.show();
    }

    public void m6090g() {
        al.m9297c(this.f3875b);
    }

    public void m6091h() {
        if (this.f3877g == null || !this.f3877g.isShowing()) {
            this.f3877g = new C2472h((Context) this, 0, (int) R.string.login_failed, (int) R.string.fb_auth_fixes);
            this.f3877g.m6874a(true);
            this.f3877g.m6877c(R.string.ok, new C22744(this));
            this.f3877g.show();
        }
    }

    public void m6083a(String str) {
        C3095y.m9469a();
        if (!ManagerApp.m7911b().m8144e()) {
            m6089f();
            m6086b(str);
        }
    }

    public void m6092i() {
        C3095y.m9469a();
    }

    public void m6093j() {
        C3095y.m9469a();
        ManagerApp.m7911b().m8139a(false);
    }

    public void m6094k() {
        C3095y.m9469a();
    }

    public void m6086b(String str) {
        ManagerApp.m7911b().m8133a((C2268w) this, str);
    }

    @MainThread
    public void m6095l() {
        C3095y.m9469a();
        m6090g();
        m6098o();
    }

    @MainThread
    public void m6096m() {
        C3095y.m9469a();
        m6090g();
        if (m6088e()) {
            Toast.makeText(this, R.string.error_login, 1).show();
        }
    }

    @MainThread
    public void m6097n() {
        C3095y.m9469a();
        m6090g();
        if (!m6088e()) {
            Toast.makeText(this, R.string.error_login, 1).show();
        }
    }

    @MainThread
    public void m6084a(boolean z, boolean z2, boolean z3) {
        C3095y.m9471a("isBanned=" + z + ", isAgeVerificationNeeded=" + z2 + ", isGenderVerificationNeeded=" + z3);
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_banned", z);
        bundle.putBoolean("is_age_verification_needed", z2);
        bundle.putBoolean("is_gender_verification_needed", z3);
        ManagerApp.m7914e().m8875u(true);
        Intent intent = new Intent(getApplicationContext(), ActivityVerification.class);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }

    public void m6098o() {
        C3095y.m9469a();
        C3095y.m9471a("meta here's the fetch : after login success");
        ManagerApp.m7911b().m8143d();
        C2807a.m8058a("Account.Intro");
        SparksEvent sparksEvent = new SparksEvent("Account.FbLogin");
        sparksEvent.put(GraphResponse.SUCCESS_KEY, Boolean.valueOf(true));
        C2807a.m8056a(sparksEvent);
        sparksEvent = new SparksEvent("Device");
        sparksEvent.put("manu", C3071j.m9373c());
        sparksEvent.put("model", C3071j.m9374d());
        sparksEvent.put("osVersion", C3071j.m9376f());
        sparksEvent.put("dataProvider", C3071j.m9375e());
        C2807a.m8056a(sparksEvent);
        if (!isFinishing()) {
            m6081s();
        }
    }

    public void m6099p() {
        this.f3880j = C2748y.m7825a(getString(R.string.webview_url_terms));
        m5919a(this.f3880j, C2748y.f5487a, R.anim.slide_in_up, R.anim.slide_out_up, R.anim.slide_in_down, R.anim.slide_out_down);
    }

    public void m6100q() {
        m5919a(this.f3879i, "FRAGMENT_PRIVACY", R.anim.slide_in_up, R.anim.slide_out_up, R.anim.slide_in_down, R.anim.slide_out_down);
    }
}
