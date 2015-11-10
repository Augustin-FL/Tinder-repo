package com.tinder.managers;

import android.graphics.Bitmap;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.Toast;
import com.android.volley.C0294c;
import com.android.volley.C0307i.C0305a;
import com.android.volley.C0307i.C0306b;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.crashlytics.android.C0359a;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import com.facebook.stetho.BuildConfig;
import com.tinder.R;
import com.tinder.enums.Gender;
import com.tinder.enums.PhotoSizeUser;
import com.tinder.managers.C2913k.12.C28991;
import com.tinder.managers.C2913k.19.C29001;
import com.tinder.managers.C2913k.21.C29021;
import com.tinder.managers.k.AnonymousClass10;
import com.tinder.managers.k.AnonymousClass11;
import com.tinder.managers.k.AnonymousClass12;
import com.tinder.managers.k.AnonymousClass13;
import com.tinder.managers.k.AnonymousClass14;
import com.tinder.managers.k.AnonymousClass16;
import com.tinder.managers.k.AnonymousClass17;
import com.tinder.managers.k.AnonymousClass18;
import com.tinder.managers.k.AnonymousClass19;
import com.tinder.managers.k.AnonymousClass20;
import com.tinder.managers.k.AnonymousClass21;
import com.tinder.managers.k.AnonymousClass22;
import com.tinder.managers.k.AnonymousClass23;
import com.tinder.managers.k.AnonymousClass24;
import com.tinder.model.ConnectionsGroup;
import com.tinder.model.PhotoUser;
import com.tinder.model.SparksEvent;
import com.tinder.model.User;
import com.tinder.p029a.C2235b;
import com.tinder.p029a.C2236c;
import com.tinder.p029a.C2237d;
import com.tinder.p029a.C2239e;
import com.tinder.p030d.C2431l;
import com.tinder.p030d.C2432m;
import com.tinder.p030d.C2438x;
import com.tinder.p030d.ax;
import com.tinder.p030d.ba;
import com.tinder.p030d.bq;
import com.tinder.p031b.C2398k;
import com.tinder.p031b.C2403o;
import com.tinder.parse.UserParse;
import com.tinder.picassowebp.picasso.C2281x;
import com.tinder.picassowebp.picasso.Picasso;
import com.tinder.utils.C3064c;
import com.tinder.utils.C3064c.C2316c;
import com.tinder.utils.C3064c.C2318a;
import com.tinder.utils.C3070i;
import com.tinder.utils.C3093w;
import com.tinder.utils.C3095y;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tinder.managers.k */
public class C2913k {
    @NonNull
    private final C2403o f6125a;
    @NonNull
    private final C2398k f6126b;
    private final C2958p f6127c;
    @Nullable
    private User f6128d;
    private C2912a f6129e;
    private int f6130f;
    @NonNull
    private Map<String, C2281x> f6131g;
    private Locale f6132h;
    @Nullable
    private Bitmap f6133i;

    /* renamed from: com.tinder.managers.k.10 */
    class AnonymousClass10 implements C0305a {
        final /* synthetic */ ax f6049a;
        final /* synthetic */ int f6050b;
        final /* synthetic */ C2913k f6051c;

        AnonymousClass10(C2913k c2913k, ax axVar, int i) {
            this.f6051c = c2913k;
            this.f6049a = axVar;
            this.f6050b = i;
        }

        public void onErrorResponse(VolleyError volleyError) {
            C3095y.m9470a(volleyError, C2239e.f3689f);
            this.f6049a.m6688b(this.f6050b);
        }
    }

    /* renamed from: com.tinder.managers.k.11 */
    class AnonymousClass11 extends AsyncTask<Void, Void, Boolean> {
        final /* synthetic */ JSONObject f6052a;
        final /* synthetic */ boolean f6053b;
        final /* synthetic */ boolean f6054c;
        final /* synthetic */ int f6055d;
        final /* synthetic */ int f6056e;
        final /* synthetic */ String f6057f;
        final /* synthetic */ ax f6058g;
        final /* synthetic */ PhotoUser f6059h;
        final /* synthetic */ C2913k f6060i;

        AnonymousClass11(C2913k c2913k, JSONObject jSONObject, boolean z, boolean z2, int i, int i2, String str, ax axVar, PhotoUser photoUser) {
            this.f6060i = c2913k;
            this.f6052a = jSONObject;
            this.f6053b = z;
            this.f6054c = z2;
            this.f6055d = i;
            this.f6056e = i2;
            this.f6057f = str;
            this.f6058g = axVar;
            this.f6059h = photoUser;
        }

        @NonNull
        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m8518a((Void[]) objArr);
        }

        public /* synthetic */ void onPostExecute(Object obj) {
            m8519a((Boolean) obj);
        }

        @NonNull
        protected Boolean m8518a(Void... voidArr) {
            HttpUriRequest c2235b = new C2235b(C2239e.f3689f);
            int i = -1;
            AndroidHttpClient newInstance = AndroidHttpClient.newInstance(BuildConfig.FLAVOR);
            Boolean valueOf;
            try {
                c2235b.setHeader(HTTP.CONTENT_TYPE, "application/json");
                c2235b.setHeader(HTTP.USER_AGENT, C2239e.f3684a);
                ManagerApp.m7911b();
                c2235b.setHeader("X-Auth-Token", C2821b.m8123b());
                c2235b.setHeader("os-version", C2239e.ad);
                c2235b.setHeader("app-version", C2239e.ae);
                c2235b.setHeader("platform", "android");
                c2235b.setEntity(new ByteArrayEntity(this.f6052a.toString().getBytes()));
                HttpResponse execute = newInstance.execute(c2235b);
                i = execute.getStatusLine().getStatusCode();
                if (i != HttpStatus.SC_OK) {
                    valueOf = Boolean.valueOf(false);
                    return valueOf;
                }
                String entityUtils = EntityUtils.toString(execute.getEntity());
                C3095y.m9471a("DELETE RESPONSE: " + entityUtils);
                ArrayList arrayList = new ArrayList();
                UserParse.m8902a(new JSONArray(entityUtils), arrayList, ManagerApp.m7922m().m8599d().getId());
                this.f6060i.m8577a(arrayList);
                newInstance.close();
                return Boolean.valueOf(true);
            } catch (Exception e) {
                C3095y.m9479c(e.getMessage() + ", status code=" + i);
                C0359a.m446a(e.toString());
                valueOf = Boolean.valueOf(false);
            } finally {
                newInstance.close();
            }
        }

        public void m8519a(Boolean bool) {
            if (bool.booleanValue()) {
                C3095y.m9471a("DELETE photo success");
                if (!this.f6053b) {
                    this.f6058g.m6691c(this.f6056e);
                    return;
                } else if (this.f6054c) {
                    this.f6060i.m8588a(this.f6055d, this.f6056e, this.f6057f, this.f6060i.m8599d().getOtherPhotoIds(this.f6057f), this.f6058g, true, this.f6059h);
                    return;
                } else {
                    this.f6058g.m6685a(this.f6056e, this.f6059h);
                    return;
                }
            }
            C3095y.m9471a("DELETE photo BAD_REQUEST");
            if (this.f6053b) {
                this.f6058g.m6688b(this.f6056e);
            } else {
                this.f6058g.m6693d(this.f6056e);
            }
        }
    }

    /* renamed from: com.tinder.managers.k.12 */
    static class AnonymousClass12 implements C0305a {
        final /* synthetic */ C2431l f6062a;

        /* renamed from: com.tinder.managers.k.12.1 */
        class C28991 implements C2438x {
            final /* synthetic */ AnonymousClass12 f6061a;

            C28991(AnonymousClass12 anonymousClass12) {
                this.f6061a = anonymousClass12;
            }

            public void m8520a() {
                C3095y.m9469a();
            }

            public void m8521b() {
                C3095y.m9469a();
            }

            public void m8522c() {
                C3095y.m9469a();
            }
        }

        AnonymousClass12(C2431l c2431l) {
            this.f6062a = c2431l;
        }

        public void onErrorResponse(@NonNull VolleyError volleyError) {
            C3095y.m9471a("error=" + volleyError);
            if (this.f6062a != null) {
                this.f6062a.m6752b();
            }
            ManagerApp.m7911b().m8138a(volleyError.getMessage(), new C28991(this));
        }
    }

    /* renamed from: com.tinder.managers.k.13 */
    class AnonymousClass13 extends AsyncTask<Void, Void, Boolean> {
        final /* synthetic */ JSONObject f6063a;
        final /* synthetic */ ArrayList f6064b;
        final /* synthetic */ ax f6065c;
        final /* synthetic */ ArrayList f6066d;
        final /* synthetic */ C2913k f6067e;

        AnonymousClass13(C2913k c2913k, JSONObject jSONObject, ArrayList arrayList, ax axVar, ArrayList arrayList2) {
            this.f6067e = c2913k;
            this.f6063a = jSONObject;
            this.f6064b = arrayList;
            this.f6065c = axVar;
            this.f6066d = arrayList2;
        }

        @NonNull
        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m8523a((Void[]) objArr);
        }

        public /* synthetic */ void onPostExecute(Object obj) {
            m8524a((Boolean) obj);
        }

        @NonNull
        protected Boolean m8523a(Void... voidArr) {
            HttpUriRequest c2235b = new C2235b(C2239e.f3689f);
            int i = -1;
            AndroidHttpClient newInstance = AndroidHttpClient.newInstance(BuildConfig.FLAVOR);
            Boolean valueOf;
            try {
                c2235b.setHeader(HTTP.CONTENT_TYPE, "application/json");
                c2235b.setHeader(HTTP.USER_AGENT, C2239e.f3684a);
                ManagerApp.m7911b();
                c2235b.setHeader("X-Auth-Token", C2821b.m8123b());
                c2235b.setHeader("os-version", C2239e.ad);
                c2235b.setHeader("app-version", C2239e.ae);
                c2235b.setHeader("platform", "android");
                c2235b.setEntity(new ByteArrayEntity(this.f6063a.toString().getBytes()));
                HttpResponse execute = newInstance.execute(c2235b);
                i = execute.getStatusLine().getStatusCode();
                if (i != HttpStatus.SC_OK) {
                    valueOf = Boolean.valueOf(false);
                    return valueOf;
                }
                String entityUtils = EntityUtils.toString(execute.getEntity());
                C3095y.m9471a("DELETE RESPONSE: " + entityUtils);
                ArrayList arrayList = new ArrayList();
                UserParse.m8902a(new JSONArray(entityUtils), arrayList, ManagerApp.m7922m().m8599d().getId());
                this.f6067e.m8577a(arrayList);
                newInstance.close();
                return Boolean.valueOf(true);
            } catch (Throwable e) {
                C3095y.m9474a("Failed to delete photos, status code=" + i, e);
                valueOf = Boolean.valueOf(false);
            } finally {
                newInstance.close();
            }
        }

        public void m8524a(Boolean bool) {
            if (bool.booleanValue()) {
                C3095y.m9471a("DELETE photo success");
                if (this.f6064b.size() == 1) {
                    this.f6065c.m6691c(((Integer) this.f6066d.get(0)).intValue());
                    return;
                } else {
                    this.f6065c.m6686a(this.f6066d);
                    return;
                }
            }
            C3095y.m9471a("DELETE photo FAIL");
            for (int i = 0; i < this.f6064b.size(); i++) {
                this.f6065c.m6693d(((Integer) this.f6066d.get(i)).intValue());
            }
        }
    }

    /* renamed from: com.tinder.managers.k.14 */
    class AnonymousClass14 implements C0306b<JSONObject> {
        final /* synthetic */ bq f6068a;
        final /* synthetic */ C2913k f6069b;

        AnonymousClass14(C2913k c2913k, bq bqVar) {
            this.f6069b = c2913k;
            this.f6068a = bqVar;
        }

        public void m8526a(@NonNull JSONObject jSONObject) {
            C3095y.m9485e("Updated profile: " + jSONObject);
            Toast.makeText(ManagerApp.m7917h(), ManagerApp.m7917h().getString(R.string.updated_profile), 1).show();
            try {
                this.f6069b.m8584a(jSONObject);
                this.f6068a.m6136E();
                C2913k.m8569a();
            } catch (Exception e) {
                C3095y.m9479c("Error updating profile: " + e);
                this.f6068a.m6137F();
            }
        }
    }

    /* renamed from: com.tinder.managers.k.16 */
    class AnonymousClass16 implements C0306b<JSONObject> {
        final /* synthetic */ ba f6071a;
        final /* synthetic */ C2913k f6072b;

        AnonymousClass16(C2913k c2913k, ba baVar) {
            this.f6072b = c2913k;
            this.f6071a = baVar;
        }

        public void m8528a(@NonNull JSONObject jSONObject) {
            C3095y.m9485e("my profile: " + jSONObject);
            try {
                this.f6071a.m6699a(this.f6072b.m8584a(jSONObject).f6120e);
            } catch (Exception e) {
                C3095y.m9479c("Error getting my profile: " + e);
                this.f6071a.m6700g();
            }
        }
    }

    /* renamed from: com.tinder.managers.k.17 */
    class AnonymousClass17 implements C0305a {
        final /* synthetic */ ba f6073a;
        final /* synthetic */ C2913k f6074b;

        AnonymousClass17(C2913k c2913k, ba baVar) {
            this.f6074b = c2913k;
            this.f6073a = baVar;
        }

        public void onErrorResponse(VolleyError volleyError) {
            C3095y.m9479c("Failed to get my profile: " + C3095y.m9468a(volleyError));
            this.f6073a.m6700g();
        }
    }

    /* renamed from: com.tinder.managers.k.18 */
    static class AnonymousClass18 implements C0306b<JSONObject> {
        final /* synthetic */ String f6075a;
        final /* synthetic */ C2431l f6076b;

        AnonymousClass18(String str, C2431l c2431l) {
            this.f6075a = str;
            this.f6076b = c2431l;
        }

        public void m8530a(@NonNull JSONObject jSONObject) {
            C3095y.m9471a("response=" + jSONObject);
            try {
                if (jSONObject.optInt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS) == HttpStatus.SC_OK) {
                    ManagerApp.m7925p().m8282b(this.f6075a, false);
                    ManagerApp.m7926q().m8473c(this.f6075a);
                    ManagerApp.m7926q().m8483h();
                    if (this.f6076b != null) {
                        this.f6076b.m6753c();
                    }
                } else if (this.f6076b != null) {
                    this.f6076b.m6754d();
                }
            } catch (Exception e) {
                C3095y.m9479c(e.toString());
                if (this.f6076b != null) {
                    this.f6076b.m6754d();
                }
            }
        }
    }

    /* renamed from: com.tinder.managers.k.19 */
    static class AnonymousClass19 implements C0305a {
        final /* synthetic */ C2431l f6078a;

        /* renamed from: com.tinder.managers.k.19.1 */
        class C29001 implements C2438x {
            final /* synthetic */ AnonymousClass19 f6077a;

            C29001(AnonymousClass19 anonymousClass19) {
                this.f6077a = anonymousClass19;
            }

            public void m8531a() {
                C3095y.m9469a();
            }

            public void m8532b() {
                C3095y.m9469a();
            }

            public void m8533c() {
                C3095y.m9469a();
            }
        }

        AnonymousClass19(C2431l c2431l) {
            this.f6078a = c2431l;
        }

        public void onErrorResponse(@NonNull VolleyError volleyError) {
            C3095y.m9471a("error=" + volleyError);
            if (this.f6078a != null) {
                this.f6078a.m6754d();
            }
            ManagerApp.m7911b().m8138a(volleyError.getMessage(), new C29001(this));
        }
    }

    /* renamed from: com.tinder.managers.k.1 */
    static class C29011 implements C0306b<JSONObject> {
        final /* synthetic */ String f6079a;
        final /* synthetic */ C2431l f6080b;

        C29011(String str, C2431l c2431l) {
            this.f6079a = str;
            this.f6080b = c2431l;
        }

        public void m8535a(@NonNull JSONObject jSONObject) {
            C3095y.m9471a("response=" + jSONObject);
            try {
                if (jSONObject.optInt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS) == HttpStatus.SC_OK) {
                    ManagerApp.m7925p().m8282b(this.f6079a, true);
                    ManagerApp.m7926q().m8465a(this.f6079a, true);
                    ManagerApp.m7926q().m8483h();
                    if (this.f6080b != null) {
                        this.f6080b.m6751a();
                    }
                } else if (this.f6080b != null) {
                    this.f6080b.m6752b();
                }
            } catch (Exception e) {
                C3095y.m9479c(e.toString());
                if (this.f6080b != null) {
                    this.f6080b.m6752b();
                }
            }
        }
    }

    /* renamed from: com.tinder.managers.k.20 */
    static class AnonymousClass20 implements C0306b<JSONObject> {
        final /* synthetic */ String f6081a;
        final /* synthetic */ ba f6082b;

        AnonymousClass20(String str, ba baVar) {
            this.f6081a = str;
            this.f6082b = baVar;
        }

        public void m8537a(@NonNull JSONObject jSONObject) {
            C3095y.m9485e("LOADED EVENT_MENU_PROFILE FOR UID: " + this.f6081a);
            C3095y.m9471a("user response: " + jSONObject.toString());
            try {
                this.f6082b.m6699a(UserParse.m8900a(jSONObject.getJSONObject("results")));
            } catch (Exception e) {
                C3095y.m9479c(String.valueOf(e));
                C0359a.m446a(e.toString());
                this.f6082b.m6700g();
            }
        }
    }

    /* renamed from: com.tinder.managers.k.21 */
    static class AnonymousClass21 implements C0305a {
        final /* synthetic */ ba f6084a;

        /* renamed from: com.tinder.managers.k.21.1 */
        class C29021 implements C2438x {
            final /* synthetic */ AnonymousClass21 f6083a;

            C29021(AnonymousClass21 anonymousClass21) {
                this.f6083a = anonymousClass21;
            }

            public void m8538a() {
                C3095y.m9469a();
            }

            public void m8539b() {
                C3095y.m9469a();
            }

            public void m8540c() {
                C3095y.m9469a();
            }
        }

        AnonymousClass21(ba baVar) {
            this.f6084a = baVar;
        }

        public void onErrorResponse(@NonNull VolleyError volleyError) {
            ManagerApp.m7911b().m8138a(volleyError.getMessage(), new C29021(this));
            C3095y.m9479c("error loading user: " + volleyError + ", " + volleyError.getMessage());
            this.f6084a.m6700g();
        }
    }

    /* renamed from: com.tinder.managers.k.22 */
    static class AnonymousClass22 implements C0306b<JSONObject> {
        final /* synthetic */ C2432m f6085a;

        AnonymousClass22(C2432m c2432m) {
            this.f6085a = c2432m;
        }

        public void m8542a(@NonNull JSONObject jSONObject) {
            Pair a = UserParse.m8899a(jSONObject, false);
            if (a != null) {
                this.f6085a.m6756a((ConnectionsGroup) a.second, 0);
                return;
            }
            C3095y.m9479c("Parsed common connections resulted in a null object");
            this.f6085a.m6755a(0);
        }
    }

    /* renamed from: com.tinder.managers.k.23 */
    static class AnonymousClass23 implements C0305a {
        final /* synthetic */ C2432m f6086a;

        AnonymousClass23(C2432m c2432m) {
            this.f6086a = c2432m;
        }

        public void onErrorResponse(@NonNull VolleyError volleyError) {
            this.f6086a.m6755a(0);
            C3095y.m9474a("Failed to load common connections", (Throwable) volleyError);
        }
    }

    /* renamed from: com.tinder.managers.k.24 */
    static class AnonymousClass24 implements C0306b<JSONArray> {
        final /* synthetic */ ax f6087a;

        AnonymousClass24(ax axVar) {
            this.f6087a = axVar;
        }

        public void m8544a(@NonNull JSONArray jSONArray) {
            C3095y.m9471a("Set photo order success");
            C3095y.m9471a(jSONArray.toString());
            try {
                ArrayList arrayList = new ArrayList();
                UserParse.m8902a(jSONArray, arrayList, ManagerApp.m7922m().m8599d().getId());
                ManagerApp.m7922m().m8577a(arrayList);
                this.f6087a.m6692d();
            } catch (Exception e) {
                C3095y.m9471a(e.toString());
                C0359a.m446a(e.toString());
                this.f6087a.m6694e();
            }
        }
    }

    /* renamed from: com.tinder.managers.k.2 */
    static class C29032 implements C0305a {
        final /* synthetic */ ax f6088a;

        C29032(ax axVar) {
            this.f6088a = axVar;
        }

        public void onErrorResponse(@NonNull VolleyError volleyError) {
            C3095y.m9479c(volleyError + " : " + volleyError.getMessage());
            this.f6088a.m6694e();
        }
    }

    /* renamed from: com.tinder.managers.k.3 */
    static class C29043 implements C0306b<JSONArray> {
        final /* synthetic */ ax f6089a;

        C29043(ax axVar) {
            this.f6089a = axVar;
        }

        public void m8546a(@NonNull JSONArray jSONArray) {
            C3095y.m9471a("Update photo success");
            C3095y.m9471a(jSONArray.toString());
            try {
                ArrayList arrayList = new ArrayList();
                UserParse.m8902a(jSONArray, arrayList, ManagerApp.m7922m().m8599d().getId());
                ManagerApp.m7922m().m8577a(arrayList);
                this.f6089a.m6687b();
            } catch (Exception e) {
                C3095y.m9471a(String.valueOf(e));
                C0359a.m446a(e.toString());
                this.f6089a.m6690c();
            }
        }
    }

    /* renamed from: com.tinder.managers.k.4 */
    static class C29054 implements C0305a {
        final /* synthetic */ ax f6090a;

        C29054(ax axVar) {
            this.f6090a = axVar;
        }

        public void onErrorResponse(@NonNull VolleyError volleyError) {
            C3095y.m9479c(volleyError + " : " + volleyError.getMessage());
            this.f6090a.m6690c();
        }
    }

    /* renamed from: com.tinder.managers.k.5 */
    static class C29065 implements C2316c {
        C29065() {
        }

        public void m8547a(Object obj) {
            C2807a.m8056a((SparksEvent) obj);
        }
    }

    /* renamed from: com.tinder.managers.k.6 */
    static class C29076 implements C2318a {
        final /* synthetic */ C2957o f6091a;
        final /* synthetic */ C2958p f6092b;
        final /* synthetic */ User f6093c;

        C29076(C2957o c2957o, C2958p c2958p, User user) {
            this.f6091a = c2957o;
            this.f6092b = c2958p;
            this.f6093c = user;
        }

        @NonNull
        public Object m8548a() {
            int i = 0;
            SparksEvent sparksEvent = new SparksEvent("User");
            if (this.f6091a.m8774k() && this.f6091a.m8773j()) {
                i = -1;
            } else if (!this.f6091a.m8774k() && this.f6091a.m8773j()) {
                i = 1;
            }
            ArrayList arrayList = new ArrayList();
            Map hashMap = new HashMap();
            hashMap.put("new_match", Boolean.valueOf(this.f6092b.m8868q()));
            hashMap.put("new_message", Boolean.valueOf(this.f6092b.m8870r()));
            hashMap.put("moment_like", Boolean.valueOf(this.f6092b.m8872s()));
            C2958p c2958p = this.f6092b;
            hashMap.put("super_like", Boolean.valueOf(C2958p.au()));
            arrayList.add(hashMap);
            sparksEvent.put(ShareConstants.WEB_DIALOG_PARAM_NAME, this.f6093c.getName());
            sparksEvent.put("age", this.f6093c.getAge());
            sparksEvent.put("gender", Integer.valueOf(this.f6093c.getGender().getBackendId()));
            sparksEvent.put("bio", this.f6093c.getBio());
            sparksEvent.put("targetGender", Integer.valueOf(i));
            sparksEvent.put("minTargetAge", Integer.valueOf(this.f6091a.m8768h()));
            sparksEvent.put("maxTargetAge", Integer.valueOf(this.f6091a.m8770i()));
            sparksEvent.put("radius", Float.valueOf(this.f6091a.m8766g()));
            sparksEvent.put("pushOptions", arrayList);
            sparksEvent.put("discoveryOn", Boolean.valueOf(this.f6091a.m8775l()));
            sparksEvent.put("createTs", this.f6092b.m8857l());
            CharSequence a = ManagerApp.m7921l().m8623a();
            if (!TextUtils.isEmpty(a)) {
                sparksEvent.put("tinderPlusSku", a);
            }
            if (!TextUtils.isEmpty(this.f6092b.ah())) {
                sparksEvent.put("tinderId", this.f6092b.ah());
            }
            return sparksEvent;
        }
    }

    /* renamed from: com.tinder.managers.k.7 */
    class C29087 implements C0306b<JSONArray> {
        final /* synthetic */ boolean f6094a;
        final /* synthetic */ ax f6095b;
        final /* synthetic */ int f6096c;
        final /* synthetic */ PhotoUser f6097d;
        final /* synthetic */ int f6098e;
        final /* synthetic */ C2913k f6099f;

        C29087(C2913k c2913k, boolean z, ax axVar, int i, PhotoUser photoUser, int i2) {
            this.f6099f = c2913k;
            this.f6094a = z;
            this.f6095b = axVar;
            this.f6096c = i;
            this.f6097d = photoUser;
            this.f6098e = i2;
        }

        public void m8550a(@NonNull JSONArray jSONArray) {
            C3095y.m9471a("Update photo success");
            C3095y.m9471a(jSONArray.toString());
            try {
                ArrayList arrayList = new ArrayList();
                UserParse.m8902a(jSONArray, arrayList, ManagerApp.m7922m().m8599d().getId());
                ManagerApp.m7922m().m8577a(arrayList);
                if (this.f6094a) {
                    this.f6095b.m6685a(this.f6096c, this.f6097d);
                } else {
                    this.f6095b.m6684a(this.f6098e, this.f6096c);
                }
            } catch (Exception e) {
                C3095y.m9471a(e.toString());
                C0359a.m446a(e.toString());
                if (this.f6094a) {
                    C3095y.m9471a("Adding photo successful, but setting it as main not successful");
                    this.f6095b.m6685a(this.f6096c, this.f6097d);
                    return;
                }
                this.f6095b.m6689b(this.f6098e, this.f6096c);
            }
        }
    }

    /* renamed from: com.tinder.managers.k.8 */
    class C29108 implements C0305a {
        final /* synthetic */ boolean f6101a;
        final /* synthetic */ ax f6102b;
        final /* synthetic */ int f6103c;
        final /* synthetic */ int f6104d;
        final /* synthetic */ String f6105e;
        final /* synthetic */ PhotoUser f6106f;
        final /* synthetic */ C2913k f6107g;

        /* renamed from: com.tinder.managers.k.8.1 */
        class C29091 implements ax {
            final /* synthetic */ C29108 f6100a;

            C29091(C29108 c29108) {
                this.f6100a = c29108;
            }

            public void m8552a(int i, PhotoUser photoUser) {
            }

            public void m8555b(int i) {
            }

            public void m8553a(List<Integer> list) {
            }

            public void m8558c(int i) {
            }

            public void m8560d(int i) {
            }

            public void m8551a(int i, int i2) {
            }

            public void m8556b(int i, int i2) {
            }

            public void m8554b() {
            }

            public void m8557c() {
            }

            public void m8559d() {
            }

            public void m8561e() {
            }
        }

        C29108(C2913k c2913k, boolean z, ax axVar, int i, int i2, String str, PhotoUser photoUser) {
            this.f6107g = c2913k;
            this.f6101a = z;
            this.f6102b = axVar;
            this.f6103c = i;
            this.f6104d = i2;
            this.f6105e = str;
            this.f6106f = photoUser;
        }

        public void onErrorResponse(@NonNull VolleyError volleyError) {
            C3095y.m9479c(volleyError + " : " + volleyError.getMessage());
            if (this.f6101a) {
                this.f6102b.m6688b(this.f6103c);
                this.f6107g.m8587a(this.f6104d, this.f6103c, this.f6105e, null, new C29091(this), false, false, this.f6106f);
                return;
            }
            this.f6102b.m6689b(this.f6104d, this.f6103c);
        }
    }

    /* renamed from: com.tinder.managers.k.9 */
    class C29119 implements C0306b<JSONObject> {
        final /* synthetic */ PhotoUser f6108a;
        final /* synthetic */ PhotoUser f6109b;
        final /* synthetic */ String f6110c;
        final /* synthetic */ int f6111d;
        final /* synthetic */ int f6112e;
        final /* synthetic */ ax f6113f;
        final /* synthetic */ boolean f6114g;
        final /* synthetic */ C2913k f6115h;

        C29119(C2913k c2913k, PhotoUser photoUser, PhotoUser photoUser2, String str, int i, int i2, ax axVar, boolean z) {
            this.f6115h = c2913k;
            this.f6108a = photoUser;
            this.f6109b = photoUser2;
            this.f6110c = str;
            this.f6111d = i;
            this.f6112e = i2;
            this.f6113f = axVar;
            this.f6114g = z;
        }

        public void m8563a(@NonNull JSONObject jSONObject) {
            C3095y.m9471a("Add photo success");
            C3095y.m9471a(jSONObject.toString());
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("assets");
                ArrayList arrayList = new ArrayList();
                UserParse.m8902a(jSONArray, arrayList, ManagerApp.m7922m().m8599d().getId());
                PhotoUser a = C2913k.m8580b(this.f6108a, (List) arrayList);
                if (a == null) {
                    a = this.f6109b;
                }
                String photoId = ((PhotoUser) arrayList.get(arrayList.size() - 1)).getPhotoId();
                this.f6115h.m8583c(a.getProcessedPhoto(PhotoSizeUser.LARGE).getImageUrl());
                if (this.f6110c != null) {
                    this.f6115h.m8587a(this.f6111d, this.f6112e, this.f6110c, photoId, this.f6113f, true, this.f6114g, a);
                } else if (this.f6114g) {
                    this.f6115h.m8588a(this.f6111d, this.f6112e, photoId, this.f6115h.m8599d().getOtherPhotoIds(photoId), this.f6113f, true, a);
                } else {
                    ManagerApp.m7922m().m8577a(arrayList);
                    this.f6113f.m6685a(this.f6112e, a);
                }
            } catch (Exception e) {
                C3095y.m9479c(e.toString());
                C0359a.m446a(e.toString());
                this.f6113f.m6688b(this.f6112e);
            }
        }
    }

    /* renamed from: com.tinder.managers.k.a */
    public static class C2912a {
        public int f6116a;
        public int f6117b;
        public int f6118c;
        public int f6119d;
        @Nullable
        public User f6120e;
        public boolean f6121f;
        public boolean f6122g;
        public boolean f6123h;
        public boolean f6124i;

        public boolean m8564a() {
            return this.f6121f;
        }

        public boolean m8565b() {
            return this.f6122g;
        }

        public boolean m8566c() {
            return this.f6123h;
        }

        public boolean m8567d() {
            return this.f6124i;
        }
    }

    public C2913k() {
        this.f6131g = new HashMap();
        C3095y.m9469a();
        this.f6127c = ManagerApp.m7914e();
        String ae = this.f6127c.ae();
        this.f6130f = this.f6127c.m8877v();
        this.f6125a = new C2403o();
        this.f6128d = this.f6125a.m6569a(ae);
        this.f6126b = new C2398k();
        this.f6132h = Locale.getDefault();
    }

    public static void m8574a(String str) {
        C2913k.m8571a(null, str);
    }

    public static void m8571a(@Nullable C2431l c2431l, String str) {
        String str2 = C2239e.f3696m + str + "/follow";
        C0306b c29011 = new C29011(str, c2431l);
        C0305a anonymousClass12 = new AnonymousClass12(c2431l);
        ManagerApp.m7911b();
        ManagerApp.m7915f().m5900a(new C2237d(1, str2, null, c29011, anonymousClass12, C2821b.m8123b()));
    }

    public static void m8582b(@NonNull String str) {
        C2913k.m8581b(null, str);
    }

    public static void m8581b(@Nullable C2431l c2431l, @NonNull String str) {
        String str2 = C2239e.f3696m + str + "/unfollow";
        C0306b anonymousClass18 = new AnonymousClass18(str, c2431l);
        C0305a anonymousClass19 = new AnonymousClass19(c2431l);
        ManagerApp.m7911b();
        ManagerApp.m7915f().m5900a(new C2237d(1, str2, null, anonymousClass18, anonymousClass19, C2821b.m8123b()));
    }

    public static void m8575a(String str, @NonNull ba baVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            Date S = ManagerApp.m7914e().m8815S();
            if (S != null) {
                jSONObject.put("last_activity_date", C3070i.m9369b().format(S));
            }
            jSONObject.put("locale", C3093w.m9461a());
        } catch (JSONException e) {
            C3095y.m9479c(e.toString());
        }
        String str2 = C2239e.f3696m + str;
        C0306b anonymousClass20 = new AnonymousClass20(str, baVar);
        C0305a anonymousClass21 = new AnonymousClass21(baVar);
        ManagerApp.m7911b();
        Request c2237d = new C2237d(0, str2, jSONObject, anonymousClass20, anonymousClass21, C2821b.m8123b());
        c2237d.m219a(new C0294c(20000, 1, 1.0f));
        ManagerApp.m7915f().m5900a(c2237d);
    }

    public static void m8576a(String str, @NonNull C2432m c2432m) {
        C3095y.m9471a("fetch connections");
        String format = String.format(C2239e.f3681X, new Object[]{str});
        C0306b anonymousClass22 = new AnonymousClass22(c2432m);
        C0305a anonymousClass23 = new AnonymousClass23(c2432m);
        ManagerApp.m7911b();
        ManagerApp.m7915f().m5900a(new C2237d(0, format, null, anonymousClass22, anonymousClass23, C2821b.m8123b()));
    }

    public static void m8579a(@NonNull PhotoUser[] photoUserArr, @NonNull ax axVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            for (PhotoUser photoUser : photoUserArr) {
                if (photoUser != null) {
                    jSONArray.put(photoUser.getPhotoId());
                }
            }
            jSONObject.put("change_order", jSONArray);
            C3095y.m9471a(jSONObject.toString());
        } catch (JSONException e) {
            C3095y.m9479c(e.getMessage());
        }
        String str = C2239e.f3689f;
        C0306b anonymousClass24 = new AnonymousClass24(axVar);
        C0305a c29032 = new C29032(axVar);
        ManagerApp.m7911b();
        Request c2236c = new C2236c(2, str, jSONObject, anonymousClass24, c29032, C2821b.m8123b());
        c2236c.m219a(new C0294c(20000, 3, 1.0f));
        ManagerApp.m7915f().m5900a(c2236c);
    }

    public static void m8570a(int i, int i2, @NonNull PhotoUser[] photoUserArr, @NonNull ax axVar) {
        C3095y.m9469a();
        JSONObject jSONObject = new JSONObject();
        PhotoUser photoUser = photoUserArr[i];
        photoUserArr[i] = photoUserArr[i2];
        photoUserArr[i2] = photoUser;
        try {
            JSONArray jSONArray = new JSONArray();
            for (PhotoUser photoUser2 : photoUserArr) {
                if (photoUser2 != null) {
                    jSONArray.put(photoUser2.getPhotoId());
                }
            }
            jSONObject.put("change_order", jSONArray);
            C3095y.m9471a(jSONObject.toString());
        } catch (Throwable e) {
            C3095y.m9474a("Failed to create json to swap photos", e);
        }
        String str = C2239e.f3689f;
        C0306b c29043 = new C29043(axVar);
        C0305a c29054 = new C29054(axVar);
        ManagerApp.m7911b();
        Request c2236c = new C2236c(2, str, jSONObject, c29043, c29054, C2821b.m8123b());
        c2236c.m219a(new C0294c(20000, 3, 1.0f));
        ManagerApp.m7915f().m5900a(c2236c);
    }

    private static PhotoUser m8580b(@NonNull PhotoUser photoUser, @NonNull List<PhotoUser> list) {
        for (PhotoUser photoUser2 : list) {
            if (photoUser.getFacebookId().equals(photoUser2.getFacebookId())) {
                return photoUser2;
            }
        }
        return null;
    }

    public static void m8569a() {
        C2958p e = ManagerApp.m7914e();
        C2957o i = ManagerApp.m7918i();
        User d = ManagerApp.m7922m().m8599d();
        if (d != null) {
            C3064c.m9336a(new C29076(i, e, d)).m9340a(new C29065()).m9341a();
        }
    }

    public void m8597b() {
        C3095y.m9469a();
        Iterator it = this.f6128d.getAvatarUrlsForSize(PhotoSizeUser.LARGE).iterator();
        while (it.hasNext()) {
            m8583c((String) it.next());
        }
    }

    private void m8583c(String str) {
        C3095y.m9471a("url=" + str);
        Picasso.m8982a(ManagerApp.m7917h()).m8990a(str).m9131d();
    }

    public void m8585a(int i) {
        this.f6130f = i;
        this.f6127c.m8831b(i);
    }

    private synchronized void m8577a(@NonNull ArrayList<PhotoUser> arrayList) {
        this.f6128d.setPhotos(arrayList);
        this.f6126b.m6551a(this.f6128d.getId());
        this.f6126b.m6552a(arrayList, this.f6128d.getId());
    }

    public void m8588a(int i, int i2, String str, @NonNull ArrayList<String> arrayList, @NonNull ax axVar, boolean z, PhotoUser photoUser) {
        C3095y.m9469a();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(str);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                jSONArray.put((String) it.next());
            }
            jSONObject.put("change_order", jSONArray);
            C3095y.m9471a(jSONObject.toString());
        } catch (JSONException e) {
            C3095y.m9479c(e.getMessage());
        }
        String str2 = C2239e.f3689f;
        C29087 c29087 = new C29087(this, z, axVar, i2, photoUser, i);
        C29108 c29108 = new C29108(this, z, axVar, i2, i, str, photoUser);
        ManagerApp.m7911b();
        Request c2236c = new C2236c(2, str2, jSONObject, c29087, c29108, C2821b.m8123b());
        c2236c.m219a(new C0294c(20000, 3, 1.0f));
        ManagerApp.m7915f().m5900a(c2236c);
    }

    public void m8586a(int i, int i2, @NonNull PhotoUser photoUser, @Nullable String str, @NonNull ax axVar, boolean z, PhotoUser photoUser2) {
        C3095y.m9471a("isMain=" + z);
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(ShareConstants.WEB_DIALOG_PARAM_ID, photoUser.getFacebookId());
            jSONObject2.put("xdistance_percent", (double) photoUser.getXDistancePercent());
            jSONObject2.put("ydistance_percent", (double) photoUser.getYDistancePercent());
            jSONObject2.put("xoffset_percent", (double) photoUser.getXOffsetPercent());
            jSONObject2.put("yoffset_percent", (double) photoUser.getYOffsetPercent());
            jSONArray.put(jSONObject2);
            jSONObject.put("transmit", "fb");
            jSONObject.put("assets", jSONArray);
            C3095y.m9471a(jSONObject.toString());
        } catch (JSONException e) {
            C3095y.m9479c(e.getMessage());
        }
        C3095y.m9471a(jSONObject.toString());
        String str2 = C2239e.f3689f;
        C29119 c29119 = new C29119(this, photoUser, photoUser2, str, i, i2, axVar, z);
        C0305a anonymousClass10 = new AnonymousClass10(this, axVar, i2);
        ManagerApp.m7911b();
        Request c2237d = new C2237d(1, str2, jSONObject, c29119, anonymousClass10, C2821b.m8123b());
        c2237d.m219a(new C0294c(20000, 3, 1.0f));
        ManagerApp.m7915f().m5900a(c2237d);
    }

    public void m8587a(int i, int i2, String str, String str2, @NonNull ax axVar, boolean z, boolean z2, PhotoUser photoUser) {
        C3095y.m9471a("photoIdToDelete=" + str + ", photoIdAdded=" + str2 + ", isDeletingAfterAdd=" + z + ", isMain=" + z2);
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(str);
            jSONObject.put("assets", jSONArray);
            C3095y.m9471a(jSONObject.toString());
        } catch (JSONException e) {
            C3095y.m9479c(e.getMessage());
        }
        new AnonymousClass11(this, jSONObject, z, z2, i, i2, str2, axVar, photoUser).execute((Void[]) null);
    }

    public void m8593a(@NonNull ArrayList<String> arrayList, @NonNull ArrayList<Integer> arrayList2, @NonNull ax axVar) {
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("The number of photo ids should match the number of indices handed in.");
        }
        C3095y.m9471a("photoIdsToDelete=" + arrayList);
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                jSONArray.put((String) it.next());
            }
            jSONObject.put("assets", jSONArray);
            C3095y.m9471a(jSONObject.toString());
        } catch (Throwable e) {
            C3095y.m9474a("Failed to make json for photo delete", e);
        }
        new AnonymousClass13(this, jSONObject, arrayList, axVar, arrayList2).execute((Void[]) null);
    }

    public C2912a m8598c() {
        return this.f6129e;
    }

    @Nullable
    public User m8599d() {
        return this.f6128d;
    }

    public void m8589a(int i, @NonNull User user, float f, int i2, int i3, boolean z) {
        C3095y.m9469a();
        if (this.f6128d != null && user.getPhotoCount() == 0) {
            user.setPhotos(this.f6128d.getPhotos());
        }
        this.f6128d = user;
        this.f6125a.m6570a(user);
        this.f6127c.m8850i(user.getId());
        m8585a(i);
        m8597b();
        ManagerApp.m7918i().m8769h(z);
        ManagerApp.m7918i().m8767g(user.isInterestedInMales());
        ManagerApp.m7918i().m8764f(user.isInterestedInFemales());
        ManagerApp.m7918i().m8751a(f);
        ManagerApp.m7918i().m8752a(i2);
        ManagerApp.m7918i().m8755b(i3);
    }

    public void m8595a(boolean z, boolean z2, float f, int i, int i2, String str, @Nullable Gender gender, @NonNull bq bqVar) {
        int i3;
        C3095y.m9471a("interestedInMales=" + z + ", interestedInFemales=" + z2 + ", distanceFilter=" + f + ", ageMin=" + i + ", ageMax=" + i2);
        C3095y.m9471a("bio=" + str + ", gender=" + gender);
        JSONObject jSONObject = new JSONObject();
        if (z2 && z) {
            i3 = -1;
        } else if (z) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        if (gender != null) {
            try {
                jSONObject.put("gender", gender.ordinal());
            } catch (JSONException e) {
                C3095y.m9479c(e.toString());
                return;
            }
        }
        jSONObject.putOpt("bio", str);
        jSONObject.put("gender_filter", i3);
        jSONObject.put("age_filter_min", i);
        jSONObject.put("age_filter_max", i2);
        jSONObject.put("distance_filter", Math.round(f));
        m8578a(jSONObject, bqVar);
    }

    private void m8578a(JSONObject jSONObject, @NonNull bq bqVar) {
        String str = C2239e.f3700q;
        C0306b anonymousClass14 = new AnonymousClass14(this, bqVar);
        C0305a anonymousClass15 = new C0305a() {
            final /* synthetic */ C2913k f6070a;

            {
                this.f6070a = r1;
            }

            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(ManagerApp.m7917h(), ManagerApp.m7917h().getString(R.string.failed_update_profile), 1).show();
                C3095y.m9479c("Failed to update profile: " + C3095y.m9468a(volleyError));
            }
        };
        ManagerApp.m7911b();
        ManagerApp.m7915f().m5900a(new C2237d(1, str, jSONObject, anonymousClass14, anonymousClass15, C2821b.m8123b()));
    }

    public void m8590a(@NonNull ba baVar) {
        String str = C2239e.f3700q;
        C0306b anonymousClass16 = new AnonymousClass16(this, baVar);
        C0305a anonymousClass17 = new AnonymousClass17(this, baVar);
        ManagerApp.m7911b();
        ManagerApp.m7915f().m5900a(new C2237d(0, str, null, anonymousClass16, anonymousClass17, C2821b.m8123b()));
    }

    public void m8592a(String str, @NonNull bq bqVar) {
        C3095y.m9471a("bio=" + str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("bio", str);
            m8578a(jSONObject, bqVar);
        } catch (JSONException e) {
            C3095y.m9479c(e.toString());
        }
    }

    public void m8591a(@Nullable Gender gender, long j, @NonNull bq bqVar) {
        JSONObject jSONObject = new JSONObject();
        if (gender != null) {
            try {
                jSONObject.put("gender", gender.ordinal());
            } catch (JSONException e) {
                C3095y.m9479c(e.toString());
                return;
            }
        }
        if (j != 0) {
            jSONObject.put("birth_date", j);
        }
        C3095y.m9471a("jsonObject = " + jSONObject.toString());
        m8578a(jSONObject, bqVar);
    }

    public void m8596a(boolean z, boolean z2, boolean z3, float f, int i, int i2, @NonNull bq bqVar) {
        int i3;
        C3095y.m9471a(" isDiscoverable = " + z + " interestedInMales=" + z2 + ", interestedInFemales=" + z3 + ", distanceFilter=" + f + ", ageMin=" + i + ", ageMax=" + i2);
        JSONObject jSONObject = new JSONObject();
        if (z3 && z2) {
            i3 = -1;
        } else if (z2) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        try {
            jSONObject.put("discoverable", z);
            jSONObject.put("gender_filter", i3);
            jSONObject.put("age_filter_min", i);
            jSONObject.put("age_filter_max", i2);
            jSONObject.put("distance_filter", Math.round(f));
        } catch (JSONException e) {
            C3095y.m9479c(e.toString());
        }
        m8578a(jSONObject, bqVar);
    }

    public void m8594a(boolean z, @NonNull bq bqVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("discoverable", z);
            m8578a(jSONObject, bqVar);
        } catch (JSONException e) {
            C3095y.m9479c(e.toString());
            bqVar.m6137F();
        }
    }

    @NonNull
    public C2912a m8584a(@NonNull JSONObject jSONObject) throws Exception {
        C3095y.m9471a("jsonObjectUser=" + jSONObject);
        C2912a b = UserParse.m8903b(jSONObject);
        this.f6129e = b;
        m8589a(b.f6116a, b.f6120e, (float) b.f6117b, b.f6118c, b.f6119d, b.m8567d());
        return b;
    }

    public void m8600e() {
        if (this.f6133i != null) {
            this.f6133i.recycle();
            this.f6133i = null;
        }
    }
}
