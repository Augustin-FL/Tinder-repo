package com.tinder.managers;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.Toast;
import com.android.volley.C0294c;
import com.android.volley.C0307i.C0305a;
import com.android.volley.C0307i.C0306b;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.stetho.BuildConfig;
import com.tinder.R;
import com.tinder.enums.PurchaseType;
import com.tinder.enums.StatusCode;
import com.tinder.iap.util.C2767d;
import com.tinder.iap.util.C2768e;
import com.tinder.model.Group;
import com.tinder.model.TinderPurchase;
import com.tinder.model.UserMeta;
import com.tinder.p029a.C2237d;
import com.tinder.p029a.C2239e;
import com.tinder.p030d.C2291r;
import com.tinder.p030d.C2435q;
import com.tinder.p030d.bk;
import com.tinder.p030d.bm;
import com.tinder.p030d.bn;
import com.tinder.parse.C2978e;
import com.tinder.parse.C2978e.C2977a;
import com.tinder.utils.C3095y;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.tinder.managers.l */
public class C2925l {
    private C2836e f6152a;
    private Context f6153b;

    /* renamed from: com.tinder.managers.l.1 */
    class C29151 implements C2435q {
        final /* synthetic */ bm f6135a;
        final /* synthetic */ C2925l f6136b;

        /* renamed from: com.tinder.managers.l.1.1 */
        class C29141 implements bm {
            final /* synthetic */ C29151 f6134a;

            C29141(C29151 c29151) {
                this.f6134a = c29151;
            }

            public void m8601a(TinderPurchase tinderPurchase) {
                this.f6134a.f6135a.m6105a(tinderPurchase);
            }

            public void m8602a(String str, String str2) {
                this.f6134a.f6135a.m6106a(str, str2);
            }
        }

        C29151(C2925l c2925l, bm bmVar) {
            this.f6136b = c2925l;
            this.f6135a = bmVar;
        }

        public void m8603a(@NonNull C2768e c2768e) {
            C3095y.m9471a("ManagerPurchase > startPurchaseFlow > onPurchaseSuccess > calling Tinder API");
            this.f6136b.m8628a(c2768e, new C29141(this));
        }

        public void m8604a(@Nullable C2768e c2768e, String str) {
            this.f6135a.m6106a(c2768e != null ? c2768e.m7879b() : BuildConfig.FLAVOR, str);
        }
    }

    /* renamed from: com.tinder.managers.l.2 */
    class C29162 implements C0306b<JSONObject> {
        final /* synthetic */ C2768e f6137a;
        final /* synthetic */ bm f6138b;
        final /* synthetic */ C2925l f6139c;

        C29162(C2925l c2925l, C2768e c2768e, bm bmVar) {
            this.f6139c = c2925l;
            this.f6137a = c2768e;
            this.f6138b = bmVar;
        }

        public void m8606a(@NonNull JSONObject jSONObject) {
            try {
                this.f6139c.m8616a(this.f6137a, jSONObject, this.f6138b);
            } catch (Throwable e) {
                C3095y.m9474a("Failed to deliver purchase details from Tinder API", e);
                this.f6138b.m6106a(this.f6137a.m7879b(), "Exception");
            }
        }
    }

    /* renamed from: com.tinder.managers.l.3 */
    class C29173 implements C0305a {
        final /* synthetic */ bm f6140a;
        final /* synthetic */ C2768e f6141b;
        final /* synthetic */ C2925l f6142c;

        C29173(C2925l c2925l, bm bmVar, C2768e c2768e) {
            this.f6142c = c2925l;
            this.f6140a = bmVar;
            this.f6141b = c2768e;
        }

        public void onErrorResponse(@NonNull VolleyError volleyError) {
            this.f6140a.m6106a(this.f6141b.m7879b(), volleyError.getMessage());
        }
    }

    /* renamed from: com.tinder.managers.l.4 */
    class C29184 implements C0306b<JSONObject> {
        final /* synthetic */ bn f6143a;
        final /* synthetic */ C2925l f6144b;

        C29184(C2925l c2925l, bn bnVar) {
            this.f6144b = c2925l;
            this.f6143a = bnVar;
        }

        public void m8608a(@NonNull JSONObject jSONObject) {
            this.f6144b.m8619a(jSONObject, this.f6143a);
        }
    }

    /* renamed from: com.tinder.managers.l.5 */
    class C29195 implements C0305a {
        final /* synthetic */ bn f6145a;
        final /* synthetic */ C2925l f6146b;

        C29195(C2925l c2925l, bn bnVar) {
            this.f6146b = c2925l;
            this.f6145a = bnVar;
        }

        public void onErrorResponse(@NonNull VolleyError volleyError) {
            ManagerApp.m7914e().m8792B(false);
            this.f6145a.m6730a(volleyError.getMessage());
        }
    }

    /* renamed from: com.tinder.managers.l.6 */
    class C29216 implements C2291r {
        final /* synthetic */ bm f6148a;
        final /* synthetic */ C2925l f6149b;

        /* renamed from: com.tinder.managers.l.6.1 */
        class C29201 implements bm {
            final /* synthetic */ C29216 f6147a;

            C29201(C29216 c29216) {
                this.f6147a = c29216;
            }

            public void m8609a(TinderPurchase tinderPurchase) {
                this.f6147a.f6148a.m6105a(tinderPurchase);
            }

            public void m8610a(String str, String str2) {
                C3095y.m9479c("reclaim failed makeTinderPurchase, sku: " + str);
                ManagerApp.m7914e();
                if (!C2958p.aj()) {
                    this.f6147a.f6148a.m6106a(str, str2);
                }
            }
        }

        C29216(C2925l c2925l, bm bmVar) {
            this.f6149b = c2925l;
            this.f6148a = bmVar;
        }

        public void m8611a(@NonNull C2767d c2767d) {
            C3095y.m9483d("purchase restore: sucess callback from inventory call.");
            List<C2768e> b = c2767d.m7876b();
            if (b.isEmpty()) {
                this.f6148a.m6106a("none", "No purchases exist in inventory");
                return;
            }
            for (C2768e c2768e : b) {
                C3095y.m9471a("purchase restore: checking tinder for: " + c2768e);
                this.f6149b.m8628a(c2768e, new C29201(this));
            }
        }

        public void m8612a(@NonNull String str) {
            C3095y.m9471a("restore purchase failed on inventory check");
            C3095y.m9471a(str);
            Toast.makeText(ManagerApp.m7917h(), R.string.error_reclaim_purchase, 0).show();
        }
    }

    /* renamed from: com.tinder.managers.l.7 */
    class C29227 implements bn {
        final /* synthetic */ bk f6150a;
        final /* synthetic */ C2925l f6151b;

        C29227(C2925l c2925l, bk bkVar) {
            this.f6151b = c2925l;
            this.f6150a = bkVar;
        }

        public void m8614a(List<TinderPurchase> list) {
            ManagerApp.m7914e();
            if (C2958p.aj()) {
                this.f6150a.m6721a();
            } else {
                this.f6150a.m6722b();
            }
        }

        public void m8613a(String str) {
            this.f6150a.m6723c();
        }
    }

    /* renamed from: com.tinder.managers.l.a */
    public static class C2924a {

        /* renamed from: com.tinder.managers.l.a.a */
        public static class C2923a {
            @NonNull
            public static JSONObject m8615a(@NonNull C2768e c2768e) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("receipt", c2768e.m7881d());
                    jSONObject.put("signature", c2768e.m7882e());
                    C3095y.m9471a(String.format("Translated subscription purchase to JSON: [%s]", new Object[]{jSONObject.toString()}));
                } catch (Exception e) {
                    C3095y.m9471a(e.getMessage());
                }
                return jSONObject;
            }
        }
    }

    public C2925l(Context context) {
        this.f6153b = context;
        this.f6152a = ManagerApp.m7920k();
    }

    public static boolean m8620a(@NonNull TinderPurchase tinderPurchase) {
        return TextUtils.equals("plus", tinderPurchase.getProductType()) && TextUtils.equals("subscription", tinderPurchase.getPurchaseType());
    }

    public static boolean m8621a(@NonNull String str) {
        String[] split = str.split("_");
        if (TextUtils.equals("plus", split[0]) && TextUtils.equals("subscription", split[1])) {
            return true;
        }
        return false;
    }

    public void m8624a(@NonNull Activity activity, String str, @NonNull PurchaseType purchaseType, @NonNull bm bmVar) {
        this.f6152a.m8211a(activity, str, purchaseType, BuildConfig.FLAVOR, new C29151(this, bmVar));
    }

    public void m8628a(@NonNull C2768e c2768e, @NonNull bm bmVar) {
        C3095y.m9469a();
        JSONObject a = C2923a.m8615a(c2768e);
        String str = C2239e.f3668K;
        C0306b c29162 = new C29162(this, c2768e, bmVar);
        C0305a c29173 = new C29173(this, bmVar, c2768e);
        ManagerApp.m7911b();
        Request c2237d = new C2237d(1, str, a, c29162, c29173, C2821b.m8123b());
        c2237d.m219a(new C0294c(5000, 3, 1.0f));
        ManagerApp.m7915f().m5900a(c2237d);
    }

    public void m8627a(@NonNull bn bnVar) {
        String str = C2239e.f3667J;
        C0306b c29184 = new C29184(this, bnVar);
        C0305a c29195 = new C29195(this, bnVar);
        ManagerApp.m7911b();
        Request c2237d = new C2237d(0, str, null, c29184, c29195, C2821b.m8123b());
        c2237d.m219a(new C0294c(5000, 3, 1.0f));
        ManagerApp.m7915f().m5900a(c2237d);
    }

    public void m8626a(@NonNull bm bmVar) {
        this.f6152a.m8215a(null, null, new C29216(this, bmVar));
    }

    public String m8623a() {
        UserMeta c = ManagerApp.m7911b().m8142c();
        if (c != null) {
            for (Group group : c.getGroups()) {
                if (C2925l.m8621a(group.getKey())) {
                    return group.getKey();
                }
            }
        }
        return BuildConfig.FLAVOR;
    }

    private void m8616a(@NonNull C2768e c2768e, @NonNull JSONObject jSONObject, @NonNull bm bmVar) {
        C3095y.m9471a("purchase onResponse: " + jSONObject);
        int i = 0;
        try {
            i = jSONObject.getInt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
        } catch (Throwable e) {
            C3095y.m9474a("Failed to parse status code from purchase response.", e);
        }
        if (i == StatusCode.OK.getCode()) {
            C3095y.m9471a("ManagerPurchases handlePurchaseResponse response status: OK");
            C2977a a = C2978e.m8930a(jSONObject);
            if (!TextUtils.isEmpty(a.m8926a()) || (a.m8929b() != null && a.m8929b().isEmpty())) {
                C3095y.m9479c("ManagerPurchases handlePurchaseResponse : either has error or empty TinderPurchases list");
                bmVar.m6106a(c2768e.m7879b(), "status: " + i);
                return;
            }
            C3095y.m9471a("ManagerPurchases handlePurchaseResponse : no errors and has at least one TinderPurchase");
            for (TinderPurchase tinderPurchase : a.m8929b()) {
                if (C2925l.m8620a(tinderPurchase)) {
                    C3095y.m9471a("ManagerPurchases handlePurchaseResponse : tinderPurchase type is plus subscription");
                    ManagerApp.m7914e().m8792B(true);
                    C3095y.m9471a("ManagerPurchases handlePurchaseResponse : about to sent tinderPurchase to listener onPurchaseSuccess");
                    bmVar.m6105a(tinderPurchase);
                } else {
                    C3095y.m9479c("Restored a purchase, but not a tinder plus subscription? " + tinderPurchase);
                }
            }
            return;
        }
        C3095y.m9471a("restore purchase failed on status code " + i);
        bmVar.m6106a(c2768e.m7879b(), "status: " + i);
    }

    private void m8619a(@NonNull JSONObject jSONObject, @NonNull bn bnVar) {
        try {
            C3095y.m9471a("response: " + jSONObject);
            int i = jSONObject.getInt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
            if (i == StatusCode.OK.getCode()) {
                List c = C2978e.m8933c(jSONObject);
                C3095y.m9471a("status OK; purchases: " + c.toString());
                boolean a = m8622a(c);
                C3095y.m9471a("hasTinderPlus:" + a);
                ManagerApp.m7914e().m8792B(a);
                bnVar.m6731a(c);
                return;
            }
            C3095y.m9479c("Tinder purchase status not OK: " + i);
            ManagerApp.m7914e().m8792B(false);
            bnVar.m6730a(jSONObject.toString());
        } catch (Throwable e) {
            ManagerApp.m7914e().m8792B(false);
            C3095y.m9474a("Failed to retrieve purchase data from shared prefs", e);
            bnVar.m6730a(e.getMessage());
        }
    }

    private boolean m8622a(@NonNull List<TinderPurchase> list) {
        for (TinderPurchase tinderPurchase : list) {
            if (C2925l.m8620a(tinderPurchase)) {
                C3095y.m9471a("found plus subscription: " + tinderPurchase.toString());
                return true;
            }
        }
        return false;
    }

    public void m8625a(@NonNull bk bkVar) {
        ManagerApp.m7914e();
        if (C2958p.aj()) {
            bkVar.m6721a();
        } else {
            m8627a(new C29227(this, bkVar));
        }
    }
}
