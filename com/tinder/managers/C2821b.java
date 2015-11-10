package com.tinder.managers;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.android.volley.C0294c;
import com.android.volley.C0307i.C0305a;
import com.android.volley.C0307i.C0306b;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.crashlytics.android.C0359a;
import com.facebook.AccessToken;
import com.facebook.internal.NativeProtocol;
import com.facebook.stetho.BuildConfig;
import com.google.android.gms.search.SearchAuth.StatusCodes;
import com.tinder.activities.ActivityLogin;
import com.tinder.managers.C2821b.14.C28081;
import com.tinder.managers.C2821b.14.C28092;
import com.tinder.managers.C2821b.17.C28101;
import com.tinder.managers.C2913k.C2912a;
import com.tinder.managers.b.AnonymousClass10;
import com.tinder.managers.b.AnonymousClass11;
import com.tinder.managers.b.AnonymousClass12;
import com.tinder.managers.b.AnonymousClass13;
import com.tinder.managers.b.AnonymousClass14;
import com.tinder.managers.b.AnonymousClass15;
import com.tinder.managers.b.AnonymousClass17;
import com.tinder.model.ClientConfig;
import com.tinder.model.GlobalConfig;
import com.tinder.model.Group;
import com.tinder.model.InstagramAuthError;
import com.tinder.model.InstagramDataSet;
import com.tinder.model.RateCardConfig;
import com.tinder.model.SparksEvent;
import com.tinder.model.SuperlikeStatus;
import com.tinder.model.User;
import com.tinder.model.UserMeta;
import com.tinder.p029a.C2237d;
import com.tinder.p029a.C2239e;
import com.tinder.p030d.C2243y;
import com.tinder.p030d.C2268w;
import com.tinder.p030d.C2409u;
import com.tinder.p030d.C2429h;
import com.tinder.p030d.C2436s;
import com.tinder.p030d.C2438x;
import com.tinder.p030d.ah;
import com.tinder.p030d.br;
import com.tinder.p030d.bw;
import com.tinder.p032c.C2419a;
import com.tinder.parse.C2973b;
import com.tinder.parse.C2978e;
import com.tinder.parse.C2979f;
import com.tinder.parse.C2981h;
import com.tinder.parse.UserParse;
import com.tinder.utils.C3064c;
import com.tinder.utils.C3064c.C2316c;
import com.tinder.utils.C3064c.C2318a;
import com.tinder.utils.C3093w;
import com.tinder.utils.C3095y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tinder.managers.b */
public class C2821b implements C2419a {
    public static final Object f5777a;
    private static boolean f5778b;
    private static UserMeta f5779c;
    private static Set<ah> f5780d;
    private static String f5781e;
    private boolean f5782f;

    /* renamed from: com.tinder.managers.b.10 */
    static class AnonymousClass10 implements C0305a {
        final /* synthetic */ br f5742a;

        AnonymousClass10(br brVar) {
            this.f5742a = brVar;
        }

        public void onErrorResponse(VolleyError volleyError) {
            C3095y.m9470a(volleyError, C2239e.f3709z);
            this.f5742a.m6739b();
        }
    }

    /* renamed from: com.tinder.managers.b.11 */
    static class AnonymousClass11 implements C0306b<JSONObject> {
        final /* synthetic */ br f5743a;

        AnonymousClass11(br brVar) {
            this.f5743a = brVar;
        }

        public void m8087a(JSONObject jSONObject) {
            C3095y.m9471a("response=" + jSONObject);
            try {
                this.f5743a.m6738a();
            } catch (Exception e) {
                C3095y.m9479c(e.toString());
                this.f5743a.m6739b();
            }
        }
    }

    /* renamed from: com.tinder.managers.b.12 */
    static class AnonymousClass12 implements C0305a {
        final /* synthetic */ br f5744a;

        AnonymousClass12(br brVar) {
            this.f5744a = brVar;
        }

        public void onErrorResponse(VolleyError volleyError) {
            C3095y.m9479c(volleyError.getMessage() + ", " + volleyError);
            this.f5744a.m6739b();
        }
    }

    /* renamed from: com.tinder.managers.b.13 */
    class AnonymousClass13 extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ C2243y f5745a;
        final /* synthetic */ C2821b f5746b;

        AnonymousClass13(C2821b c2821b, C2243y c2243y) {
            this.f5746b = c2821b;
            this.f5745a = c2243y;
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m8088a((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m8089a((Void) obj);
        }

        protected void onPreExecute() {
            C3095y.m9471a("Setting mIsLoggingOut to true");
            C2821b.f5778b = true;
        }

        protected Void m8088a(Void... voidArr) {
            C3095y.m9471a("going to clear application data");
            ManagerApp.m7919j().m7936B();
            C3095y.m9471a("cleared application data");
            C2828c.m8161b();
            return null;
        }

        protected void m8089a(Void voidR) {
            this.f5746b.m8139a(false);
            ManagerApp.m7933x();
            if (this.f5745a != null) {
                this.f5745a.m5935a();
            }
            C2821b.f5778b = false;
        }
    }

    /* renamed from: com.tinder.managers.b.14 */
    class AnonymousClass14 implements C0306b<JSONObject> {
        final /* synthetic */ C2429h f5749a;
        final /* synthetic */ C2821b f5750b;

        /* renamed from: com.tinder.managers.b.14.1 */
        class C28081 implements C2316c {
            final /* synthetic */ AnonymousClass14 f5747a;

            C28081(AnonymousClass14 anonymousClass14) {
                this.f5747a = anonymousClass14;
            }

            public void m8090a(Object obj) {
                ManagerApp.m7933x();
                ManagerApp.m7919j().m7936B();
                if (this.f5747a.f5749a != null) {
                    this.f5747a.f5749a.m6747c();
                }
                C2821b.f5778b = false;
            }
        }

        /* renamed from: com.tinder.managers.b.14.2 */
        class C28092 implements C2318a {
            final /* synthetic */ AnonymousClass14 f5748a;

            C28092(AnonymousClass14 anonymousClass14) {
                this.f5748a = anonymousClass14;
            }

            public Object m8091a() {
                C3095y.m9471a("Setting mIsLoggingOut to true");
                C2821b.f5778b = true;
                C3095y.m9471a("going to clear application data");
                C3095y.m9471a("cleared application data");
                C2828c.m8161b();
                this.f5748a.f5750b.m8139a(false);
                return null;
            }
        }

        AnonymousClass14(C2821b c2821b, C2429h c2429h) {
            this.f5750b = c2821b;
            this.f5749a = c2429h;
        }

        public void m8093a(JSONObject jSONObject) {
            C3095y.m9483d("delete account profile ok");
            C3064c.m9336a(new C28092(this)).m9340a(new C28081(this)).m9341a();
        }
    }

    /* renamed from: com.tinder.managers.b.15 */
    class AnonymousClass15 implements C0305a {
        final /* synthetic */ int f5751a;
        final /* synthetic */ C2429h f5752b;
        final /* synthetic */ C2821b f5753c;

        AnonymousClass15(C2821b c2821b, int i, C2429h c2429h) {
            this.f5753c = c2821b;
            this.f5751a = i;
            this.f5752b = c2429h;
        }

        public void onErrorResponse(VolleyError volleyError) {
            if (volleyError != null) {
                C0359a.m446a(volleyError.toString());
                C3095y.m9479c(volleyError.toString());
            }
            if (this.f5751a > 0) {
                this.f5753c.m8115a(this.f5752b, this.f5751a - 1);
            } else {
                this.f5752b.m6748d();
            }
        }
    }

    /* renamed from: com.tinder.managers.b.1 */
    static class C28111 implements C0306b<JSONObject> {
        final /* synthetic */ br f5757a;

        C28111(br brVar) {
            this.f5757a = brVar;
        }

        public void m8100a(JSONObject jSONObject) {
            C3095y.m9471a("response=" + jSONObject);
            try {
                this.f5757a.m6738a();
            } catch (Exception e) {
                C3095y.m9479c(e.toString());
                this.f5757a.m6739b();
            }
        }
    }

    /* renamed from: com.tinder.managers.b.2 */
    class C28122 implements C0306b<JSONObject> {
        final /* synthetic */ C2268w f5758a;
        final /* synthetic */ C2821b f5759b;

        C28122(C2821b c2821b, C2268w c2268w) {
            this.f5759b = c2821b;
            this.f5758a = c2268w;
        }

        public void m8102a(JSONObject jSONObject) {
            C3095y.m9471a("response=" + jSONObject);
            try {
                if (jSONObject.isNull("user")) {
                    C3095y.m9479c("user not found in response");
                    this.f5758a.m6066m();
                    return;
                }
                JSONObject jSONObject2 = jSONObject.getJSONObject("user");
                String l = ManagerApp.m7914e().m8857l();
                String optString = jSONObject2.optString("create_date", BuildConfig.FLAVOR);
                if (l == null || l.isEmpty() || l.equals(optString)) {
                    ManagerApp.m7914e().m8828a(optString);
                    C2912a a = ManagerApp.m7922m().m8584a(jSONObject2);
                    UserParse.m8904c(jSONObject2);
                    boolean a2 = a.m8564a();
                    boolean b = a.m8565b();
                    boolean c = a.m8566c();
                    if (jSONObject.getString("token") != null) {
                        C2821b.f5781e = jSONObject.getString("token");
                        C3095y.m9471a("Tinder token found! = " + C2821b.f5781e);
                        this.f5759b.m8136a(C2821b.f5781e);
                        ManagerApp.m7918i().m8762e(true);
                        if (a2 || b || c) {
                            this.f5759b.m8139a(false);
                            this.f5758a.m6064a(a2, b, c);
                            C2913k.m8569a();
                            return;
                        }
                        this.f5759b.m8139a(true);
                        C2898j.m8509b();
                        ManagerApp.m7926q().m8472c();
                        C2855f.m8248a().m8278a(true);
                        this.f5758a.m6065l();
                        C2913k.m8569a();
                        return;
                    }
                    C3095y.m9479c("Tinder token not found in response");
                    this.f5758a.m6066m();
                    return;
                }
                C3095y.m9471a("the create date is off, ACCOUNT MUST HAVE BEEN DELETED, logging out now...");
                this.f5759b.m8135a(null);
                Intent intent = new Intent(ManagerApp.m7917h(), ActivityLogin.class);
                intent.setFlags(268468224);
                Bundle bundle = new Bundle();
                bundle.putString("extra_show_intro", BuildConfig.FLAVOR);
                intent.putExtras(bundle);
                ManagerApp.m7917h().startActivity(intent);
            } catch (Throwable e) {
                C3095y.m9474a("Failed to parse and setup user object for login", e);
                this.f5758a.m6066m();
            }
        }
    }

    /* renamed from: com.tinder.managers.b.3 */
    class C28133 implements C0305a {
        final /* synthetic */ C2268w f5760a;
        final /* synthetic */ C2821b f5761b;

        C28133(C2821b c2821b, C2268w c2268w) {
            this.f5761b = c2821b;
            this.f5760a = c2268w;
        }

        public void onErrorResponse(VolleyError volleyError) {
            C3095y.m9470a(volleyError, C2239e.f3697n);
            try {
                if (volleyError.f189a != null) {
                    String string = new JSONObject(new String(volleyError.f189a.f244b, "utf-8")).getString(NativeProtocol.BRIDGE_ARG_ERROR_BUNDLE);
                    if (string == null || !string.equalsIgnoreCase("Access Denied")) {
                        this.f5760a.m6066m();
                        return;
                    } else {
                        this.f5760a.m6067n();
                        return;
                    }
                }
                this.f5760a.m6066m();
            } catch (Throwable e) {
                C3095y.m9474a("Failed to login to Tinder", e);
                this.f5760a.m6066m();
            }
        }
    }

    /* renamed from: com.tinder.managers.b.4 */
    class C28144 implements C2268w {
        final /* synthetic */ C2438x f5762a;
        final /* synthetic */ int f5763b;
        final /* synthetic */ C2821b f5764c;

        C28144(C2821b c2821b, C2438x c2438x, int i) {
            this.f5764c = c2821b;
            this.f5762a = c2438x;
            this.f5763b = i;
        }

        public void m8104l() {
            C3095y.m9471a("Successfully logged back in!");
            if (this.f5762a != null) {
                this.f5762a.m6770a();
            }
        }

        public void m8105m() {
            C3095y.m9471a("Login failure, retrying ...");
            this.f5764c.m8114a(this.f5763b - 1, this.f5762a);
        }

        public void m8106n() {
        }

        public void m8103a(boolean z, boolean z2, boolean z3) {
            C3095y.m9471a("isBanned=" + z + ", isAgeVerificationNeeded=" + z2 + ", isGenderVerificationNeeded=" + z3);
        }
    }

    /* renamed from: com.tinder.managers.b.5 */
    class C28155 implements C0306b<JSONObject> {
        final /* synthetic */ C2436s f5765a;
        final /* synthetic */ JSONObject f5766b;
        final /* synthetic */ C2821b f5767c;

        C28155(C2821b c2821b, C2436s c2436s, JSONObject jSONObject) {
            this.f5767c = c2821b;
            this.f5765a = c2436s;
            this.f5766b = jSONObject;
        }

        public void m8108a(JSONObject jSONObject) {
            C3095y.m9471a("response=" + jSONObject);
            InstagramDataSet a = C2973b.m8912a(jSONObject);
            String userName = a.getUserName();
            if (TextUtils.isEmpty(userName)) {
                C3095y.m9479c("authInstagram failure: no username");
                this.f5765a.m6763a(C2973b.m8913b(this.f5766b));
                return;
            }
            SparksEvent sparksEvent = new SparksEvent("Account.InstagramLoginSuccess");
            sparksEvent.put("instagramName", userName);
            C2807a.m8056a(sparksEvent);
            if (TextUtils.isEmpty(a.getLastFetchTime())) {
                C3095y.m9471a("InstagramAuth last fetch time empty");
                this.f5767c.m8113a(0);
            }
            C3095y.m9471a("authInstagram success: has username:" + userName);
            ManagerApp.m7914e().m8852j(userName);
            ManagerApp.m7914e().m8800F(true);
            if (C2821b.f5779c != null) {
                C2821b.f5779c.setInstagramDataSet(a);
            }
            this.f5765a.m6764a(a);
        }
    }

    /* renamed from: com.tinder.managers.b.6 */
    class C28166 implements C0305a {
        final /* synthetic */ C2436s f5768a;
        final /* synthetic */ C2821b f5769b;

        C28166(C2821b c2821b, C2436s c2436s) {
            this.f5769b = c2821b;
            this.f5768a = c2436s;
        }

        public void onErrorResponse(VolleyError volleyError) {
            C3095y.m9471a("failure: " + volleyError.getMessage());
            int i = -1;
            if (volleyError.f189a != null) {
                i = volleyError.f189a.f243a;
            }
            this.f5768a.m6763a(new InstagramAuthError(i, volleyError.getMessage()));
        }
    }

    /* renamed from: com.tinder.managers.b.7 */
    class C28177 implements C0306b<JSONObject> {
        final /* synthetic */ C2409u f5770a;
        final /* synthetic */ C2821b f5771b;

        C28177(C2821b c2821b, C2409u c2409u) {
            this.f5771b = c2821b;
            this.f5770a = c2409u;
        }

        public void m8110a(JSONObject jSONObject) {
            C3095y.m9471a("LogoutInstagram onResponse logout success");
            SparksEvent sparksEvent = new SparksEvent("Account.InstagramLogoutSuccess");
            sparksEvent.put("instagramName", ManagerApp.m7914e().ap());
            C2807a.m8056a(sparksEvent);
            this.f5770a.m6595a();
            ManagerApp.m7914e().m8852j(BuildConfig.FLAVOR);
            C2821b.f5779c.setInstagramDataSet(new InstagramDataSet());
            ManagerApp.m7914e().m8800F(true);
        }
    }

    /* renamed from: com.tinder.managers.b.8 */
    class C28188 implements C0305a {
        final /* synthetic */ C2409u f5772a;
        final /* synthetic */ C2821b f5773b;

        C28188(C2821b c2821b, C2409u c2409u) {
            this.f5773b = c2821b;
            this.f5772a = c2409u;
        }

        public void onErrorResponse(VolleyError volleyError) {
            SparksEvent sparksEvent = new SparksEvent("Account.InstagramLogoutFail");
            sparksEvent.put("instagramName", ManagerApp.m7914e().ap());
            C2807a.m8056a(sparksEvent);
            C3095y.m9479c("LogoutInstagram onErrorResponse: " + volleyError);
            this.f5772a.m6596b();
        }
    }

    /* renamed from: com.tinder.managers.b.9 */
    class C28209 implements Runnable {
        final /* synthetic */ int f5775a;
        final /* synthetic */ C2821b f5776b;

        /* renamed from: com.tinder.managers.b.9.1 */
        class C28191 extends bw {
            final /* synthetic */ C28209 f5774a;

            C28191(C28209 c28209) {
                this.f5774a = c28209;
            }

            public void m8111a(User user) {
                C3095y.m9471a("retryInstagramPhotos onProfileLoaded");
                if (user.getInstagramDataSet() == null || TextUtils.isEmpty(user.getInstagramDataSet().getLastFetchTime())) {
                    C3095y.m9471a("retryInstagramPhotos last fetch time null");
                    this.f5774a.f5776b.m8113a(this.f5774a.f5775a + 1);
                    return;
                }
                C3095y.m9471a(String.format("retryInstagramPhotos lastfetchTime[%s]", new Object[]{user.getInstagramDataSet().getLastFetchTime()}));
                if (C2821b.f5779c != null) {
                    C3095y.m9471a("retryInstagramPhotos set instagramData to usermeta");
                    C2821b.f5779c.setInstagramDataSet(user.getInstagramDataSet());
                }
            }
        }

        C28209(C2821b c2821b, int i) {
            this.f5776b = c2821b;
            this.f5775a = i;
        }

        public void run() {
            ManagerApp.m7922m().m8590a(new C28191(this));
        }
    }

    static {
        f5777a = new Object();
    }

    public C2821b() {
        C3095y.m9469a();
        C2958p e = ManagerApp.m7914e();
        f5781e = e.aa();
        this.f5782f = e.ag();
        f5780d = new HashSet();
        C3095y.m9471a("token=" + f5781e);
    }

    public static boolean m8122a() {
        return f5778b;
    }

    public static void m8121a(String str, br brVar) {
        C3095y.m9471a("phoneNumber=" + str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("phone_number", str);
        } catch (JSONException e) {
            C3095y.m9479c(e.toString());
        }
        String str2 = C2239e.f3709z;
        C0306b c28111 = new C28111(brVar);
        C0305a anonymousClass10 = new AnonymousClass10(brVar);
        ManagerApp.m7911b();
        ManagerApp.m7915f().m5900a(new C2237d(1, str2, jSONObject, c28111, anonymousClass10, C2821b.m8123b()));
    }

    public static void m8126b(String str, br brVar) {
        C3095y.m9469a();
        C3095y.m9471a("code=" + str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("token", str);
        } catch (JSONException e) {
            C3095y.m9479c(e.toString());
        }
        ManagerApp.m7915f().m5900a(new C2237d(1, C2239e.f3658A, jSONObject, new AnonymousClass11(brVar), new AnonymousClass12(brVar), f5781e));
    }

    @Nullable
    private static GlobalConfig m8112a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setUpdatesInterval(jSONObject.optInt("updates_interval", ManagerApp.m7914e().ad()));
        globalConfig.setRecsInterval(jSONObject.optInt("recs_interval", ManagerApp.m7914e().ac()));
        globalConfig.setSparksEnabled(jSONObject.optBoolean("tinder_sparks", ManagerApp.m7914e().m8866p()));
        globalConfig.setMixpanelEnabled(jSONObject.optBoolean("mixpanel_enabled", ManagerApp.m7914e().al()));
        globalConfig.setPlusEnabled(jSONObject.optBoolean("plus", true));
        globalConfig.setShouldFetchConnections(jSONObject.optBoolean("fetch_connections", ManagerApp.m7914e().ar()));
        ManagerApp.m7914e();
        globalConfig.setIsVersionRateable(jSONObject.optBoolean("rate_app", C2958p.m8789f()));
        globalConfig.setAdSwipeLimit(jSONObject.optInt("ad_swipe_interval", 0));
        globalConfig.setSuperlikeEnabled(jSONObject.optBoolean("super_like", false));
        C2821b.m8120a(globalConfig);
        return globalConfig;
    }

    private static void m8120a(GlobalConfig globalConfig) {
        C3095y.m9471a("setGlobals plus ? " + globalConfig.isPlusEnabled());
        C3095y.m9471a("setGlobals isSuperlikeEnabled:" + globalConfig.isSuperlikeEnabled());
        C2807a.m8061a(globalConfig.isSparksEnabled());
        C2807a.m8067b(globalConfig.isMixpanelEnabled());
        ManagerApp.m7924o().m8708b(globalConfig.getRecsInterval());
        ManagerApp.m7923n().m8896a(globalConfig.getUpdatesInterval());
        ManagerApp.m7914e().m8796D(globalConfig.isPlusEnabled());
        ManagerApp.m7914e();
        C2958p.m8780a(globalConfig.shouldFetchConnections());
        ManagerApp.m7914e().m8802G(globalConfig.isSuperlikeEnabled());
    }

    private static void m8125b(GlobalConfig globalConfig) {
        C3095y.m9471a("meta here's the callbackListener called");
        for (ah a : f5780d) {
            a.m5905a(globalConfig, f5779c);
        }
    }

    public static String m8123b() {
        return f5781e;
    }

    public void m8136a(String str) {
        C3095y.m9471a("tinder token=" + str);
        f5781e = str;
        ManagerApp.m7914e().m8847h(str);
    }

    private void m8127b(JSONObject jSONObject) {
        RateCardConfig rateCardConfig = null;
        UserParse.m8901a(jSONObject.optJSONArray("purchases"));
        UserMeta userMeta = new UserMeta();
        userMeta.setGlobalConfig(C2821b.m8112a(jSONObject.optJSONObject("globals")));
        JSONArray optJSONArray = jSONObject.optJSONArray("tutorials");
        if (optJSONArray != null) {
            List a = C2981h.m8939a(optJSONArray);
            if (a.contains("super_like_init")) {
                ManagerApp.m7914e().m8864o(false);
            }
            if (a.contains("super_like_action")) {
                ManagerApp.m7914e().m8865p(false);
            }
            if (a.contains("profile_verified")) {
                userMeta.setTutorials(a);
            } else {
                userMeta.setTutorials(a);
            }
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("rating");
        if (optJSONObject != null) {
            userMeta.setLikesPercentRemaining(optJSONObject.optInt("likes_remaining", 100));
            userMeta.setMillisRateLimitedUntil(optJSONObject.optLong("rate_limited_until"));
            ManagerApp.m7924o().m8695a(userMeta.getMillisRateLimitedUntil());
            ManagerApp.m7924o().m8694a(userMeta.getLikesPercentRemaining());
            C3095y.m9471a("meta rating " + optJSONObject);
            C3095y.m9471a("meta set likes " + userMeta.getLikesPercentRemaining());
            SuperlikeStatus a2 = C2979f.m8934a(optJSONObject);
            userMeta.setSuperlikeStatus(a2);
            ManagerApp.m7924o().m8698a(a2);
            C3095y.m9471a(a2.toString());
        }
        userMeta.setTinderReportNotifications(UserParse.m8905d(jSONObject));
        optJSONObject = jSONObject.optJSONObject("user");
        if (optJSONObject != null) {
            try {
                ManagerApp.m7922m().m8584a(optJSONObject);
                userMeta.setInstagramDataSet(C2973b.m8912a(optJSONObject));
            } catch (Exception e) {
                C3095y.m9479c(e.toString());
            }
        }
        optJSONObject = jSONObject.optJSONObject("travel");
        if (optJSONObject != null) {
            UserParse.m8904c(optJSONObject);
        }
        List<Group> a3 = C2978e.m8931a(jSONObject.optJSONArray("groups"));
        userMeta.setGroups(a3);
        if (!a3.isEmpty()) {
            List arrayList = new ArrayList(a3.size());
            for (Group key : a3) {
                arrayList.add(key.getKey());
            }
            SparksEvent sparksEvent = new SparksEvent("TinderPlus.SkuOffered");
            sparksEvent.put("skus", arrayList);
            sparksEvent.put("locale", C3093w.m9462b());
            C2807a.m8056a(sparksEvent);
        }
        optJSONObject = jSONObject.optJSONObject("client_resources");
        if (optJSONObject != null) {
            optJSONObject = optJSONObject.optJSONObject("rate_card");
            if (optJSONObject != null) {
                ClientConfig clientConfig = new ClientConfig();
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("carousel");
                if (optJSONArray2 != null) {
                    RateCardConfig rateCardConfig2 = new RateCardConfig();
                    List carousel = rateCardConfig2.getCarousel();
                    for (int i = 0; i < optJSONArray2.length(); i++) {
                        Object string;
                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i);
                        if (optJSONObject2 != null) {
                            try {
                                string = optJSONObject2.getString("slug");
                            } catch (Throwable e2) {
                                C3095y.m9474a("Failed to parse carousel order from meta response", e2);
                            }
                        } else {
                            if (optJSONArray2.optString(i) != null) {
                                string = optJSONArray2.getString(i);
                            }
                            string = null;
                        }
                        carousel.add(string);
                    }
                    rateCardConfig2.setCarousel(carousel);
                    rateCardConfig = rateCardConfig2;
                }
                clientConfig.setRateCard(rateCardConfig);
                userMeta.setClientConfig(clientConfig);
            }
        }
        f5779c = userMeta;
        C2821b.m8125b(f5779c.getGlobalConfig());
    }

    public boolean m8140a(ah ahVar) {
        return f5780d.remove(ahVar);
    }

    public boolean m8141b(ah ahVar) {
        return f5780d.add(ahVar);
    }

    @Nullable
    public UserMeta m8142c() {
        return f5779c;
    }

    public void m8135a(C2243y c2243y) {
        synchronized (f5777a) {
            new AnonymousClass13(this, c2243y).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public void m8132a(C2429h c2429h) {
        m8115a(c2429h, 3);
    }

    private void m8115a(C2429h c2429h, int i) {
        C3095y.m9469a();
        String str = C2239e.f3700q;
        C0306b anonymousClass14 = new AnonymousClass14(this, c2429h);
        C0305a anonymousClass15 = new AnonymousClass15(this, i, c2429h);
        ManagerApp.m7911b();
        ManagerApp.m7915f().m5900a(new C2237d(3, str, null, anonymousClass14, anonymousClass15, C2821b.m8123b()));
    }

    public void m8143d() {
        Request c2237d = new C2237d(0, C2239e.f3674Q, null, new C0306b<JSONObject>() {
            final /* synthetic */ C2821b f5754a;

            {
                this.f5754a = r1;
            }

            public void m8095a(JSONObject jSONObject) {
                C3095y.m9471a("meta here's the response");
                this.f5754a.m8127b(jSONObject);
            }
        }, new C0305a() {
            final /* synthetic */ C2821b f5756a;

            /* renamed from: com.tinder.managers.b.17.1 */
            class C28101 implements C2438x {
                final /* synthetic */ AnonymousClass17 f5755a;

                C28101(AnonymousClass17 anonymousClass17) {
                    this.f5755a = anonymousClass17;
                }

                public void m8096a() {
                    C3095y.m9471a("Login retry successful, fetchMetaData");
                    this.f5755a.f5756a.m8143d();
                }

                public void m8097b() {
                    C3095y.m9471a("Login retry unsuccessful");
                }

                public void m8098c() {
                    C3095y.m9471a("Not authentication problem");
                }
            }

            {
                this.f5756a = r1;
            }

            public void onErrorResponse(VolleyError volleyError) {
                C3095y.m9479c(C3095y.m9468a(volleyError));
                if (volleyError != null && volleyError.f189a != null && volleyError.f189a.f243a == HttpStatus.SC_UNAUTHORIZED) {
                    C3095y.m9471a("meta retrying");
                    ManagerApp.m7911b().m8138a(volleyError.getMessage(), new C28101(this));
                }
            }
        }, f5781e);
        c2237d.m219a(new C0294c());
        ManagerApp.m7915f().m5900a(c2237d);
    }

    public synchronized void m8133a(C2268w c2268w, @Nullable String str) {
        C3095y.m9471a("tokenFacebook=" + str);
        if (str != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("facebook_token", str);
                jSONObject.put("locale", C3093w.m9461a());
            } catch (Throwable e) {
                C3095y.m9474a("Failed to build json for facebook token", e);
            }
            Request c2237d = new C2237d(1, C2239e.f3697n, jSONObject, new C28122(this, c2268w), new C28133(this, c2268w), f5781e);
            c2237d.m219a(new C0294c(60000, 0, 1.0f));
            ManagerApp.m7915f().m5900a(c2237d);
        } else {
            C3095y.m9479c("Facebook token null, not logging in");
            c2268w.m6066m();
        }
    }

    public void m8139a(boolean z) {
        this.f5782f = z;
        ManagerApp.m7914e().m8884y(this.f5782f);
    }

    public void m8134a(C2438x c2438x) {
        m8114a(1, c2438x);
    }

    private synchronized void m8114a(int i, C2438x c2438x) {
        C3095y.m9471a("retrying login with " + i + "left.");
        if (i == 0) {
            C3095y.m9471a("No more retries, quitting");
            if (c2438x != null) {
                c2438x.m6771b();
            }
        } else {
            String str;
            C2821b b = ManagerApp.m7911b();
            C2268w c28144 = new C28144(this, c2438x, i);
            if (AccessToken.getCurrentAccessToken() == null) {
                str = null;
            } else {
                str = AccessToken.getCurrentAccessToken().getToken();
            }
            b.m8133a(c28144, str);
        }
    }

    public void m8138a(String str, C2438x c2438x) {
        C3095y.m9471a("errorMsg=" + str);
        if (str == null) {
            c2438x.m6772c();
        } else if (str.contains("No authentication challenges found") || str.contains("Received authentication challenge is null") || str.contains("java.io.EOFException") || str.contains("401")) {
            m8134a(c2438x);
        } else if (str.contains("java.io.EOFException")) {
            c2438x.m6772c();
        } else {
            c2438x.m6772c();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m8144e() {
        /*
        r2 = this;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "tinder token = ";
        r0 = r0.append(r1);
        r1 = f5781e;
        r0 = r0.append(r1);
        r0 = r0.toString();
        com.tinder.utils.C3095y.m9471a(r0);
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "facebook token = ";
        r0 = r0.append(r1);
        com.tinder.managers.ManagerApp.m7912c();
        r1 = com.tinder.managers.C2828c.m8162c();
        r0 = r0.append(r1);
        r0 = r0.toString();
        com.tinder.utils.C3095y.m9471a(r0);
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "profile = ";
        r0 = r0.append(r1);
        r1 = com.tinder.managers.ManagerApp.m7922m();
        r1 = r1.m8599d();
        r0 = r0.append(r1);
        r0 = r0.toString();
        com.tinder.utils.C3095y.m9471a(r0);
        r0 = f5781e;
        if (r0 == 0) goto L_0x006a;
    L_0x0057:
        com.tinder.managers.ManagerApp.m7912c();
        r0 = com.tinder.managers.C2828c.m8162c();
        if (r0 == 0) goto L_0x006a;
    L_0x0060:
        r0 = com.tinder.managers.ManagerApp.m7922m();
        r0 = r0.m8599d();
        if (r0 != 0) goto L_0x006d;
    L_0x006a:
        r0 = 0;
        r2.f5782f = r0;
    L_0x006d:
        r0 = r2.f5782f;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tinder.managers.b.e():boolean");
    }

    public void m8137a(String str, C2436s c2436s) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", str);
        } catch (Exception e) {
            C3095y.m9479c(e.getMessage());
        }
        ManagerApp.m7915f().m5900a(new C2237d(1, C2239e.f3678U, jSONObject, new C28155(this, c2436s, jSONObject), new C28166(this, c2436s), f5781e));
    }

    public void m8131a(int i, C2409u c2409u) {
        SparksEvent sparksEvent = new SparksEvent("Account.InstagramDisconnect");
        sparksEvent.put("instagramName", ManagerApp.m7914e().ap());
        sparksEvent.put("from", Integer.valueOf(i));
        C2807a.m8056a(sparksEvent);
        ManagerApp.m7915f().m5900a(new C2237d(1, C2239e.f3679V, null, new C28177(this, c2409u), new C28188(this, c2409u), f5781e));
    }

    private void m8113a(int i) {
        Map hashMap = new HashMap(1);
        hashMap.put(Integer.valueOf(0), Integer.valueOf(StatusCodes.AUTH_DISABLED));
        C3095y.m9471a("retryInstagramPhotos attempt#:" + i);
        if (i < 1) {
            new Handler().postDelayed(new C28209(this, i), (long) ((Integer) hashMap.get(Integer.valueOf(i))).intValue());
        }
    }
}
