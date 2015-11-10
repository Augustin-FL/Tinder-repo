package com.tinder.managers;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.android.volley.C0294c;
import com.android.volley.C0307i.C0305a;
import com.android.volley.C0307i.C0306b;
import com.android.volley.Request;
import com.android.volley.Request.Priority;
import com.android.volley.VolleyError;
import com.google.android.m4b.maps.model.o;
import com.tinder.model.TinderLocation;
import com.tinder.p029a.C2237d;
import com.tinder.p029a.C2239e;
import com.tinder.p030d.C2439z;
import com.tinder.p030d.aa;
import com.tinder.p030d.au;
import com.tinder.p030d.av;
import com.tinder.p031b.C2402n;
import com.tinder.parse.C2980g;
import com.tinder.utils.C3077n;
import com.tinder.utils.C3093w;
import com.tinder.utils.C3095y;
import com.tinder.utils.ag;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tinder.managers.j */
public class C2898j {
    private static final Pattern f6043a;
    private static List<TinderLocation> f6044b;
    private List<TinderLocation> f6045c;
    @Nullable
    private TinderLocation f6046d;
    private C2402n f6047e;
    @Nullable
    private WeakReference<av> f6048f;

    /* renamed from: com.tinder.managers.j.1 */
    static class C28891 implements C0306b<JSONObject> {
        C28891() {
        }

        public void m8495a(@NonNull JSONObject jSONObject) {
            try {
                C2898j.f6044b = C2980g.m8935a(jSONObject);
            } catch (JSONException e) {
                C3095y.m9479c(e.toString());
            }
        }
    }

    /* renamed from: com.tinder.managers.j.2 */
    static class C28902 implements C0306b<JSONObject> {
        final /* synthetic */ aa f6029a;

        C28902(aa aaVar) {
            this.f6029a = aaVar;
        }

        public void m8497a(@NonNull JSONObject jSONObject) {
            try {
                C3095y.m9471a(jSONObject.toString());
                this.f6029a.m6255a(C2980g.m8935a(jSONObject));
            } catch (Exception e) {
                C3095y.m9479c(e.toString());
                this.f6029a.m6256f();
            }
        }
    }

    /* renamed from: com.tinder.managers.j.3 */
    static class C28913 implements C0305a {
        C28913() {
        }

        public void onErrorResponse(VolleyError volleyError) {
            C3095y.m9469a();
        }
    }

    /* renamed from: com.tinder.managers.j.4 */
    static class C28924 implements C0306b<JSONObject> {
        final /* synthetic */ C2439z f6030a;
        final /* synthetic */ o f6031b;

        C28924(C2439z c2439z, o oVar) {
            this.f6030a = c2439z;
            this.f6031b = oVar;
        }

        public void m8499a(@NonNull JSONObject jSONObject) {
            C3095y.m9471a("ENTER ");
            C3095y.m9471a(jSONObject.toString());
            try {
                this.f6030a.m6773a(C2980g.m8937b(jSONObject), this.f6031b);
            } catch (Exception e) {
                C3095y.m9479c(e.toString());
                this.f6030a.m6774e(this.f6031b);
            }
        }
    }

    /* renamed from: com.tinder.managers.j.5 */
    static class C28935 implements C0305a {
        final /* synthetic */ C2439z f6032a;
        final /* synthetic */ o f6033b;

        C28935(C2439z c2439z, o oVar) {
            this.f6032a = c2439z;
            this.f6033b = oVar;
        }

        public void onErrorResponse(VolleyError volleyError) {
            C3095y.m9469a();
            this.f6032a.m6774e(this.f6033b);
        }
    }

    /* renamed from: com.tinder.managers.j.6 */
    class C28946 implements C0306b<JSONObject> {
        final /* synthetic */ au f6034a;
        final /* synthetic */ TinderLocation f6035b;
        final /* synthetic */ C2898j f6036c;

        C28946(C2898j c2898j, au auVar, TinderLocation tinderLocation) {
            this.f6036c = c2898j;
            this.f6034a = auVar;
            this.f6035b = tinderLocation;
        }

        public void m8501a(JSONObject jSONObject) {
            this.f6034a.m6128M();
            this.f6036c.m8513a(this.f6035b);
            if (!this.f6036c.f6045c.contains(this.f6035b)) {
                this.f6036c.f6045c.add(this.f6035b);
            }
        }
    }

    /* renamed from: com.tinder.managers.j.7 */
    class C28957 implements C0305a {
        final /* synthetic */ au f6037a;
        final /* synthetic */ C2898j f6038b;

        C28957(C2898j c2898j, au auVar) {
            this.f6038b = c2898j;
            this.f6037a = auVar;
        }

        public void onErrorResponse(VolleyError volleyError) {
            this.f6037a.m6129N();
        }
    }

    /* renamed from: com.tinder.managers.j.8 */
    class C28968 implements C0306b<JSONObject> {
        final /* synthetic */ au f6039a;
        final /* synthetic */ C2898j f6040b;

        C28968(C2898j c2898j, au auVar) {
            this.f6040b = c2898j;
            this.f6039a = auVar;
        }

        public void m8503a(JSONObject jSONObject) {
            this.f6040b.m8513a(null);
            this.f6039a.m6130O();
        }
    }

    /* renamed from: com.tinder.managers.j.9 */
    class C28979 implements C0305a {
        final /* synthetic */ au f6041a;
        final /* synthetic */ C2898j f6042b;

        C28979(C2898j c2898j, au auVar) {
            this.f6042b = c2898j;
            this.f6041a = auVar;
        }

        public void onErrorResponse(VolleyError volleyError) {
            this.f6041a.m6131P();
        }
    }

    static {
        f6043a = Pattern.compile(" ", 16);
    }

    public C2898j() {
        this.f6045c = new ArrayList();
        this.f6047e = new C2402n();
        f6044b = new ArrayList();
    }

    @NonNull
    public static List<TinderLocation> m8504a() {
        return new ArrayList(f6044b);
    }

    public static void m8509b() {
        String format = String.format(C2239e.f3670M, new Object[]{C3093w.m9461a()});
        C0306b c28891 = new C28891();
        ManagerApp.m7911b();
        Request c2237d = new C2237d(0, format, null, c28891, null, C2821b.m8123b());
        c2237d.m219a(new C0294c(5000, 0, 1.0f));
        ManagerApp.m7915f().m5900a(c2237d);
    }

    public static void m8508a(@NonNull String str, @NonNull aa aaVar, Object obj) {
        String encode;
        if (TextUtils.isEmpty(str)) {
            aaVar.m6256f();
        }
        try {
            encode = URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            encode = f6043a.matcher(str).replaceAll("+");
        }
        String format = String.format(C2239e.f3663F, new Object[]{C3093w.m9461a(), encode});
        Priority priority = Priority.IMMEDIATE;
        C0306b c28902 = new C28902(aaVar);
        C0305a c28913 = new C28913();
        ManagerApp.m7911b();
        Request agVar = new ag(priority, 0, format, null, c28902, c28913, C2821b.m8123b());
        agVar.m220a(obj);
        agVar.m219a(new C0294c(5000, 0, 1.0f));
        ManagerApp.m7915f().m5900a(agVar);
    }

    public static void m8507a(double d, double d2, @NonNull C2439z c2439z, o oVar) {
        String format = String.format(Locale.ENGLISH, C2239e.f3664G, new Object[]{C3093w.m9461a(), Double.valueOf(d), Double.valueOf(d2)});
        C3095y.m9471a("url " + format + " with lat " + d + " , " + d2);
        Priority priority = Priority.IMMEDIATE;
        C0306b c28924 = new C28924(c2439z, oVar);
        C0305a c28935 = new C28935(c2439z, oVar);
        ManagerApp.m7911b();
        Request agVar = new ag(priority, 0, format, null, c28924, c28935, C2821b.m8123b());
        agVar.m220a((Object) oVar);
        agVar.m219a(new C0294c());
        ManagerApp.m7915f().m5900a(agVar);
    }

    @Nullable
    public TinderLocation m8516c() {
        return this.f6046d;
    }

    public void m8513a(@Nullable TinderLocation tinderLocation) {
        boolean z = true;
        C3095y.m9471a("set active " + (tinderLocation != null));
        StringBuilder append = new StringBuilder().append("passport icon should show ? ");
        if (tinderLocation == null) {
            z = false;
        }
        C3095y.m9471a(append.append(z).toString());
        this.f6046d = tinderLocation;
        m8515b(this.f6046d);
        if (this.f6046d != null && C3077n.m9407a(this.f6048f)) {
            ((av) this.f6048f.get()).m6132Q();
        }
    }

    public void m8515b(@Nullable TinderLocation tinderLocation) {
        if (tinderLocation != null) {
            long currentTimeMillis = System.currentTimeMillis();
            tinderLocation.setLastSeenDate(currentTimeMillis);
            if (!this.f6047e.m6566a(tinderLocation)) {
                this.f6047e.m6565a(tinderLocation, currentTimeMillis);
            }
        }
    }

    public void m8514a(@NonNull TinderLocation tinderLocation, @NonNull au auVar) {
        C3095y.m9471a("ENTER " + tinderLocation.getLatitude() + " , " + tinderLocation.getLongitude());
        m8515b(tinderLocation);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("lat", tinderLocation.getLatitude());
            jSONObject.put("lon", tinderLocation.getLongitude());
        } catch (JSONException e) {
            C3095y.m9479c(e.toString());
        }
        Priority priority = Priority.IMMEDIATE;
        String str = C2239e.f3665H;
        C0306b c28946 = new C28946(this, auVar, tinderLocation);
        C0305a c28957 = new C28957(this, auVar);
        ManagerApp.m7911b();
        Request agVar = new ag(priority, 1, str, jSONObject, c28946, c28957, C2821b.m8123b());
        agVar.m220a((Object) "travel_request");
        agVar.m219a(new C0294c(20000, 0, 1.0f));
        ManagerApp.m7915f().m5900a(agVar);
    }

    public void m8511a(@NonNull au auVar) {
        Priority priority = Priority.IMMEDIATE;
        String str = C2239e.f3666I;
        C0306b c28968 = new C28968(this, auVar);
        C0305a c28979 = new C28979(this, auVar);
        ManagerApp.m7911b();
        Request agVar = new ag(priority, 1, str, null, c28968, c28979, C2821b.m8123b());
        agVar.m220a((Object) "travel_request");
        agVar.m219a(new C0294c(20000, 0, 1.0f));
        ManagerApp.m7915f().m5900a(agVar);
    }

    public boolean m8517d() {
        return m8516c() != null;
    }

    @NonNull
    public List<TinderLocation> m8510a(int i) {
        if (i < 1) {
            return new ArrayList();
        }
        List<TinderLocation> b = this.f6047e.m6567b();
        return b.size() >= i ? b.subList(0, i) : b;
    }

    public void m8512a(@Nullable av avVar) {
        if (avVar == null) {
            this.f6048f = null;
        } else {
            this.f6048f = new WeakReference(avVar);
        }
    }
}
