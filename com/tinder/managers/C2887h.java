package com.tinder.managers;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import com.android.volley.C0294c;
import com.android.volley.C0307i.C0305a;
import com.android.volley.C0307i.C0306b;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import com.facebook.stetho.BuildConfig;
import com.tinder.enums.AddType;
import com.tinder.enums.PhotoSizeMoment;
import com.tinder.enums.StatusCode;
import com.tinder.managers.C2887h.17.C28601;
import com.tinder.managers.C2887h.20.C28621;
import com.tinder.managers.C2887h.28.C28631;
import com.tinder.managers.C2887h.30.C28671;
import com.tinder.managers.C2887h.32.C28691;
import com.tinder.managers.C2887h.32.C28702;
import com.tinder.managers.C2887h.33.C28711;
import com.tinder.managers.C2887h.34.C28721;
import com.tinder.managers.C2887h.34.C28732;
import com.tinder.managers.C2887h.35.C28741;
import com.tinder.managers.C2887h.39.C28761;
import com.tinder.managers.C2887h.39.C28772;
import com.tinder.managers.C2887h.40.C28791;
import com.tinder.managers.C2887h.41.C28801;
import com.tinder.managers.h.AnonymousClass11;
import com.tinder.managers.h.AnonymousClass12;
import com.tinder.managers.h.AnonymousClass13;
import com.tinder.managers.h.AnonymousClass14;
import com.tinder.managers.h.AnonymousClass15;
import com.tinder.managers.h.AnonymousClass16;
import com.tinder.managers.h.AnonymousClass17;
import com.tinder.managers.h.AnonymousClass18;
import com.tinder.managers.h.AnonymousClass19;
import com.tinder.managers.h.AnonymousClass20;
import com.tinder.managers.h.AnonymousClass22;
import com.tinder.managers.h.AnonymousClass23;
import com.tinder.managers.h.AnonymousClass24;
import com.tinder.managers.h.AnonymousClass25;
import com.tinder.managers.h.AnonymousClass26;
import com.tinder.managers.h.AnonymousClass27;
import com.tinder.managers.h.AnonymousClass28;
import com.tinder.managers.h.AnonymousClass29;
import com.tinder.managers.h.AnonymousClass30;
import com.tinder.managers.h.AnonymousClass31;
import com.tinder.managers.h.AnonymousClass32;
import com.tinder.managers.h.AnonymousClass33;
import com.tinder.managers.h.AnonymousClass34;
import com.tinder.managers.h.AnonymousClass35;
import com.tinder.managers.h.AnonymousClass36;
import com.tinder.managers.h.AnonymousClass37;
import com.tinder.managers.h.AnonymousClass38;
import com.tinder.managers.h.AnonymousClass39;
import com.tinder.managers.h.AnonymousClass40;
import com.tinder.managers.h.AnonymousClass41;
import com.tinder.model.Match;
import com.tinder.model.Moment;
import com.tinder.model.Moment.RatedType;
import com.tinder.model.MomentLike;
import com.tinder.model.Person;
import com.tinder.model.User;
import com.tinder.p029a.C2236c;
import com.tinder.p029a.C2237d;
import com.tinder.p029a.C2239e;
import com.tinder.p029a.C2240f;
import com.tinder.p030d.C2428g;
import com.tinder.p030d.C2434o;
import com.tinder.p030d.C2438x;
import com.tinder.p030d.ak;
import com.tinder.p030d.am;
import com.tinder.p030d.an;
import com.tinder.p030d.ao;
import com.tinder.p030d.ap;
import com.tinder.p030d.aq;
import com.tinder.p030d.as;
import com.tinder.p031b.C2394g;
import com.tinder.p031b.C2395h;
import com.tinder.parse.C2975d;
import com.tinder.utils.C3064c;
import com.tinder.utils.C3064c.C2316c;
import com.tinder.utils.C3064c.C2318a;
import com.tinder.utils.C3064c.C2669b;
import com.tinder.utils.C3070i;
import com.tinder.utils.C3075l;
import com.tinder.utils.C3095y;
import com.tinder.utils.ad;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tinder.managers.h */
public class C2887h {
    private static long f5997a;
    @Nullable
    private String f5998A;
    private boolean f5999B;
    private boolean f6000C;
    private boolean f6001D;
    private int f6002E;
    private long f6003F;
    private ad<Moment> f6004b;
    private ad<Moment> f6005c;
    private ad<Moment> f6006d;
    private ad<MomentLike> f6007e;
    private List<aq> f6008f;
    private List<ap> f6009g;
    private HashMap<String, Moment> f6010h;
    private HashMap<String, List<MomentLike>> f6011i;
    private Set<String> f6012j;
    private C2394g f6013k;
    private boolean f6014l;
    private boolean f6015m;
    private boolean f6016n;
    private long f6017o;
    private int f6018p;
    private long f6019q;
    @Nullable
    private String f6020r;
    private boolean f6021s;
    private List<String> f6022t;
    private boolean f6023u;
    @Nullable
    private String f6024v;
    @Nullable
    private String f6025w;
    @Nullable
    private String f6026x;
    @Nullable
    private String f6027y;
    @Nullable
    private String f6028z;

    /* renamed from: com.tinder.managers.h.11 */
    class AnonymousClass11 implements C2669b {
        final /* synthetic */ Moment f5879a;
        final /* synthetic */ C2887h f5880b;

        AnonymousClass11(C2887h c2887h, Moment moment) {
            this.f5880b = c2887h;
            this.f5879a = moment;
        }

        public void m8307a() {
            if (this.f5879a.getBitmap() != null) {
                C3075l.m9389a(this.f5879a.getBitmap(), String.valueOf(this.f5879a.getCreatedTime()), 90, false);
            }
            C2395h.m6533a(this.f5879a);
        }
    }

    /* renamed from: com.tinder.managers.h.12 */
    class AnonymousClass12 implements C2316c {
        final /* synthetic */ Moment f5881a;
        final /* synthetic */ an f5882b;
        final /* synthetic */ C2887h f5883c;

        AnonymousClass12(C2887h c2887h, Moment moment, an anVar) {
            this.f5883c = c2887h;
            this.f5881a = moment;
            this.f5882b = anVar;
        }

        public void m8308a(Object obj) {
            this.f5883c.m8391a(this.f5881a, this.f5882b, (Bitmap) obj);
        }
    }

    /* renamed from: com.tinder.managers.h.13 */
    class AnonymousClass13 implements C2318a {
        final /* synthetic */ Bitmap f5884a;
        final /* synthetic */ Moment f5885b;
        final /* synthetic */ C2887h f5886c;

        AnonymousClass13(C2887h c2887h, Bitmap bitmap, Moment moment) {
            this.f5886c = c2887h;
            this.f5884a = bitmap;
            this.f5885b = moment;
        }

        @Nullable
        public Object m8309a() {
            if (this.f5884a == null) {
                try {
                    return C3075l.m9382a(String.valueOf(this.f5885b.getCreatedTime()), null);
                } catch (Exception e) {
                    C3095y.m9479c(e.toString());
                }
            }
            return this.f5884a;
        }
    }

    /* renamed from: com.tinder.managers.h.14 */
    class AnonymousClass14 implements C2669b {
        final /* synthetic */ Moment f5887a;
        final /* synthetic */ C2887h f5888b;

        AnonymousClass14(C2887h c2887h, Moment moment) {
            this.f5888b = c2887h;
            this.f5887a = moment;
        }

        public void m8310a() {
            C2395h.m6533a(this.f5887a);
        }
    }

    /* renamed from: com.tinder.managers.h.15 */
    class AnonymousClass15 implements ao {
        final /* synthetic */ Moment f5889a;
        final /* synthetic */ an f5890b;
        final /* synthetic */ Bitmap f5891c;
        final /* synthetic */ C2887h f5892d;

        AnonymousClass15(C2887h c2887h, Moment moment, an anVar, Bitmap bitmap) {
            this.f5892d = c2887h;
            this.f5889a = moment;
            this.f5890b = anVar;
            this.f5891c = bitmap;
        }

        public void m8312a(String str) {
            C3095y.m9471a("photoId=" + str);
            this.f5892d.m8392a(this.f5889a, str, this.f5890b);
            this.f5891c.recycle();
        }

        public void m8311a() {
            C3095y.m9469a();
            this.f5892d.m8421d(this.f5889a);
            this.f5892d.m8447q();
            if (this.f5889a.getCreatedTime() == this.f5892d.f6017o) {
                this.f5892d.f6015m = true;
                this.f5892d.f6014l = false;
                this.f5892d.m8450s();
                this.f5890b.m5963a();
                this.f5892d.m8425e(this.f5889a);
            }
            this.f5891c.recycle();
        }
    }

    /* renamed from: com.tinder.managers.h.16 */
    class AnonymousClass16 implements C0306b<JSONObject> {
        final /* synthetic */ Moment f5893a;
        final /* synthetic */ an f5894b;
        final /* synthetic */ C2887h f5895c;

        AnonymousClass16(C2887h c2887h, Moment moment, an anVar) {
            this.f5895c = c2887h;
            this.f5893a = moment;
            this.f5894b = anVar;
        }

        public void m8314a(@NonNull JSONObject jSONObject) {
            C3095y.m9485e("jsonObjectReponse=" + jSONObject);
            try {
                Moment b = C2975d.m8924b(jSONObject);
                User d = ManagerApp.m7922m().m8599d();
                Person person = new Person(d.getId(), d.getName(), d.getPhotos(), d.getGender(), d.isVerified());
                b.setUserId(d.getId());
                b.setPerson(person);
                if (this.f5893a.isPending() || this.f5893a.hasFailed()) {
                    this.f5895c.m8429f(this.f5893a);
                }
                this.f5895c.m8393a(b, false, true);
                if (this.f5893a.getCreatedTime() == this.f5895c.f6017o) {
                    this.f5895c.f6014l = false;
                    this.f5895c.f6015m = false;
                    if (this.f5894b != null) {
                        this.f5894b.m5964a(b.getId());
                    }
                    this.f5895c.m8447q();
                    this.f5895c.m8450s();
                }
            } catch (Exception e) {
                C3095y.m9479c(e.toString());
                this.f5895c.m8421d(this.f5893a);
                this.f5895c.m8447q();
                if (this.f5893a.getCreatedTime() == this.f5895c.f6017o) {
                    this.f5895c.f6014l = false;
                    this.f5895c.f6015m = true;
                    this.f5895c.m8450s();
                }
            }
        }
    }

    /* renamed from: com.tinder.managers.h.17 */
    class AnonymousClass17 implements C0305a {
        final /* synthetic */ Moment f5897a;
        final /* synthetic */ an f5898b;
        final /* synthetic */ C2887h f5899c;

        /* renamed from: com.tinder.managers.h.17.1 */
        class C28601 implements C2438x {
            final /* synthetic */ AnonymousClass17 f5896a;

            C28601(AnonymousClass17 anonymousClass17) {
                this.f5896a = anonymousClass17;
            }

            public void m8315a() {
                C3095y.m9469a();
            }

            public void m8316b() {
                C3095y.m9469a();
            }

            public void m8317c() {
                C3095y.m9469a();
            }
        }

        AnonymousClass17(C2887h c2887h, Moment moment, an anVar) {
            this.f5899c = c2887h;
            this.f5897a = moment;
            this.f5898b = anVar;
        }

        public void onErrorResponse(@NonNull VolleyError volleyError) {
            C3095y.m9470a(volleyError, C2239e.f3690g);
            this.f5899c.m8421d(this.f5897a);
            this.f5899c.m8447q();
            if (this.f5897a.getCreatedTime() == this.f5899c.f6017o) {
                this.f5899c.f6014l = false;
                this.f5899c.f6015m = true;
                this.f5899c.m8450s();
            }
            ManagerApp.m7911b().m8138a(volleyError.getMessage(), new C28601(this));
            this.f5898b.m5963a();
        }
    }

    /* renamed from: com.tinder.managers.h.18 */
    class AnonymousClass18 implements C2669b {
        final /* synthetic */ ArrayList f5900a;
        final /* synthetic */ C2887h f5901b;

        AnonymousClass18(C2887h c2887h, ArrayList arrayList) {
            this.f5901b = c2887h;
            this.f5900a = arrayList;
        }

        public void m8318a() {
            try {
                C2395h.m6532a(this.f5900a);
            } catch (Exception e) {
                C3095y.m9479c(BuildConfig.FLAVOR + e);
            }
        }
    }

    /* renamed from: com.tinder.managers.h.19 */
    class AnonymousClass19 implements C0306b<JSONObject> {
        final /* synthetic */ Moment f5902a;
        final /* synthetic */ ak f5903b;
        final /* synthetic */ C2887h f5904c;

        AnonymousClass19(C2887h c2887h, Moment moment, ak akVar) {
            this.f5904c = c2887h;
            this.f5902a = moment;
            this.f5903b = akVar;
        }

        public void m8320a(@NonNull JSONObject jSONObject) {
            C3095y.m9485e("jsonObjectReponse=" + jSONObject);
            try {
                if (jSONObject.optInt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS) == StatusCode.OK.getCode()) {
                    this.f5904c.m8429f(this.f5902a);
                    this.f5903b.m6661c();
                    return;
                }
                this.f5903b.m6662d();
            } catch (Exception e) {
                C3095y.m9479c(e.toString());
                this.f5903b.m6662d();
            }
        }
    }

    /* renamed from: com.tinder.managers.h.1 */
    static class C28611 extends C2240f {
        final /* synthetic */ ao f5905a;

        C28611(Bitmap bitmap, String str, String str2, boolean z, ao aoVar) {
            this.f5905a = aoVar;
            super(bitmap, str, str2, z);
        }

        protected /* synthetic */ void onPostExecute(@Nullable Object obj) {
            m8321a((String) obj);
        }

        protected void m8321a(@Nullable String str) {
            C3095y.m9471a("SENDING IMAGE BYTES -- result returned=" + str);
            if (str == null) {
                C3095y.m9476b("result null");
                this.f5905a.m6669a();
            } else if (str.contains("Bad Request") || str.contains(String.valueOf(StatusCode.BAD_REQUEST)) || str.contains(String.valueOf(HttpStatus.SC_NOT_FOUND)) || str.contains(String.valueOf(HttpStatus.SC_BAD_GATEWAY))) {
                C3095y.m9479c("Bad Request or not found");
                this.f5905a.m6669a();
            } else {
                C3095y.m9471a("Image uploaded successfully");
                try {
                    String optString = new JSONObject(str).optString(ShareConstants.WEB_DIALOG_PARAM_ID);
                    C3095y.m9471a("photoId returned is " + optString);
                    this.f5905a.m6670a(optString);
                } catch (JSONException e) {
                    C3095y.m9479c(e.toString());
                    this.f5905a.m6669a();
                }
            }
            super.onPostExecute(str);
        }
    }

    /* renamed from: com.tinder.managers.h.20 */
    class AnonymousClass20 implements C0305a {
        final /* synthetic */ String f5907a;
        final /* synthetic */ ak f5908b;
        final /* synthetic */ C2887h f5909c;

        /* renamed from: com.tinder.managers.h.20.1 */
        class C28621 implements C2438x {
            final /* synthetic */ AnonymousClass20 f5906a;

            C28621(AnonymousClass20 anonymousClass20) {
                this.f5906a = anonymousClass20;
            }

            public void m8322a() {
                C3095y.m9469a();
            }

            public void m8323b() {
                C3095y.m9469a();
            }

            public void m8324c() {
                C3095y.m9469a();
            }
        }

        AnonymousClass20(C2887h c2887h, String str, ak akVar) {
            this.f5909c = c2887h;
            this.f5907a = str;
            this.f5908b = akVar;
        }

        public void onErrorResponse(@NonNull VolleyError volleyError) {
            C3095y.m9470a(volleyError, this.f5907a);
            ManagerApp.m7911b().m8138a(volleyError.getMessage(), new C28621(this));
            C3095y.m9479c("error deleting Moment: " + volleyError + ", " + volleyError.getMessage());
            this.f5908b.m6662d();
        }
    }

    /* renamed from: com.tinder.managers.h.22 */
    class AnonymousClass22 implements C2669b {
        final /* synthetic */ Moment f5911a;
        final /* synthetic */ List f5912b;
        final /* synthetic */ C2887h f5913c;

        AnonymousClass22(C2887h c2887h, Moment moment, List list) {
            this.f5913c = c2887h;
            this.f5911a = moment;
            this.f5912b = list;
        }

        public void m8325a() {
            C2395h.m6536b(this.f5911a.getId());
            for (MomentLike mixedId : this.f5912b) {
                C2394g.m6526b(mixedId.getMixedId());
            }
            C3075l.m9391a(String.valueOf(this.f5911a.getCreatedTime()));
        }
    }

    /* renamed from: com.tinder.managers.h.23 */
    class AnonymousClass23 implements C2669b {
        final /* synthetic */ Moment f5914a;
        final /* synthetic */ C2887h f5915b;

        AnonymousClass23(C2887h c2887h, Moment moment) {
            this.f5915b = c2887h;
            this.f5914a = moment;
        }

        public void m8326a() {
            C2395h.m6530a(this.f5914a.getCreatedTime(), ManagerApp.m7922m().m8599d().getId());
        }
    }

    /* renamed from: com.tinder.managers.h.24 */
    class AnonymousClass24 implements C2669b {
        final /* synthetic */ Moment f5916a;
        final /* synthetic */ C2887h f5917b;

        AnonymousClass24(C2887h c2887h, Moment moment) {
            this.f5917b = c2887h;
            this.f5916a = moment;
        }

        public void m8327a() {
            C2395h.m6533a(this.f5916a);
        }
    }

    /* renamed from: com.tinder.managers.h.25 */
    class AnonymousClass25 implements C2669b {
        final /* synthetic */ String f5918a;
        final /* synthetic */ C2887h f5919b;

        AnonymousClass25(C2887h c2887h, String str) {
            this.f5919b = c2887h;
            this.f5918a = str;
        }

        public void m8328a() {
            C2395h.m6536b(this.f5918a);
        }
    }

    /* renamed from: com.tinder.managers.h.26 */
    class AnonymousClass26 implements C2669b {
        final /* synthetic */ Moment f5920a;
        final /* synthetic */ C2887h f5921b;

        AnonymousClass26(C2887h c2887h, Moment moment) {
            this.f5921b = c2887h;
            this.f5920a = moment;
        }

        public void m8329a() {
            C2395h.m6533a(this.f5920a);
        }
    }

    /* renamed from: com.tinder.managers.h.27 */
    class AnonymousClass27 implements C0306b<JSONObject> {
        final /* synthetic */ am f5922a;
        final /* synthetic */ C2887h f5923b;

        AnonymousClass27(C2887h c2887h, am amVar) {
            this.f5923b = c2887h;
            this.f5922a = amVar;
        }

        public void m8331a(@NonNull JSONObject jSONObject) {
            C3095y.m9471a("response=" + jSONObject);
            try {
                if (C2887h.m8416c(jSONObject.optInt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS))) {
                    this.f5922a.m6665e();
                } else {
                    this.f5922a.m6666f();
                }
            } catch (Exception e) {
                C3095y.m9479c(e.toString());
                this.f5922a.m6666f();
            }
        }
    }

    /* renamed from: com.tinder.managers.h.29 */
    class AnonymousClass29 implements C0306b<JSONObject> {
        final /* synthetic */ am f5926a;
        final /* synthetic */ C2887h f5927b;

        AnonymousClass29(C2887h c2887h, am amVar) {
            this.f5927b = c2887h;
            this.f5926a = amVar;
        }

        public void m8336a(@NonNull JSONObject jSONObject) {
            C3095y.m9471a("response=" + jSONObject);
            try {
                if (C2887h.m8416c(jSONObject.optInt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS))) {
                    this.f5926a.m6667g();
                } else {
                    this.f5926a.m6668h();
                }
            } catch (Exception e) {
                C3095y.m9479c(e.toString());
                this.f5926a.m6668h();
            }
        }
    }

    /* renamed from: com.tinder.managers.h.2 */
    class C28642 implements C0305a {
        final /* synthetic */ C2434o f5928a;
        final /* synthetic */ C2887h f5929b;

        C28642(C2887h c2887h, C2434o c2434o) {
            this.f5929b = c2887h;
            this.f5928a = c2434o;
        }

        public void onErrorResponse(VolleyError volleyError) {
            C3095y.m9479c(BuildConfig.FLAVOR + volleyError);
            this.f5928a.m6759a();
        }
    }

    /* renamed from: com.tinder.managers.h.31 */
    class AnonymousClass31 implements C2316c {
        final /* synthetic */ List f5935a;
        final /* synthetic */ List f5936b;
        final /* synthetic */ List f5937c;
        final /* synthetic */ C2887h f5938d;

        AnonymousClass31(C2887h c2887h, List list, List list2, List list3) {
            this.f5938d = c2887h;
            this.f5935a = list;
            this.f5936b = list2;
            this.f5937c = list3;
        }

        public void m8342a(Object obj) {
            int i = 0;
            for (Comparable comparable : this.f5935a) {
                if (comparable.isPending()) {
                    comparable.setIsPending(false);
                    comparable.setHasFailed(true);
                }
                this.f5938d.f6006d.m9216a(comparable);
            }
            for (Comparable comparable2 : this.f5936b) {
                if (!this.f5938d.m8411b((Moment) comparable2)) {
                    this.f5938d.m8448q(comparable2.getId());
                } else if (comparable2.hasBeenRated()) {
                    C3095y.m9471a("found rated moment");
                    this.f5938d.f6005c.m9216a(comparable2);
                } else {
                    C3095y.m9471a("found unrated moment");
                    this.f5938d.f6004b.m9216a(comparable2);
                }
            }
            while (i < this.f5937c.size()) {
                MomentLike momentLike = (MomentLike) this.f5937c.get(i);
                if (!this.f5938d.f6012j.contains(momentLike.getMixedId())) {
                    this.f5938d.f6012j.add(momentLike.getMixedId());
                    this.f5938d.f6007e.m9216a((Comparable) momentLike);
                    this.f5938d.m8407b(momentLike);
                }
                i++;
            }
            C3095y.m9471a("user moments list db size: " + this.f5938d.f6006d.m9214a());
            C3095y.m9471a("matches moments list db size: " + this.f5938d.f6004b.m9214a());
            for (Moment moment : this.f5938d.f6004b.m9220c()) {
                this.f5938d.f6010h.put(moment.getId(), moment);
            }
            for (Moment moment2 : this.f5938d.f6005c.m9220c()) {
                this.f5938d.f6010h.put(moment2.getId(), moment2);
            }
            for (Moment moment22 : this.f5938d.f6006d.m9220c()) {
                this.f5938d.f6010h.put(moment22.getId(), moment22);
            }
            this.f5938d.m8449r();
            this.f5938d.m8447q();
            this.f5938d.m8483h();
        }
    }

    /* renamed from: com.tinder.managers.h.32 */
    class AnonymousClass32 implements C0306b<JSONArray> {
        final /* synthetic */ String f5943a;
        final /* synthetic */ C2887h f5944b;

        /* renamed from: com.tinder.managers.h.32.1 */
        class C28691 implements C2316c {
            final /* synthetic */ AnonymousClass32 f5940a;

            /* renamed from: com.tinder.managers.h.32.1.1 */
            class C28681 implements C2428g {
                final /* synthetic */ C28691 f5939a;

                C28681(C28691 c28691) {
                    this.f5939a = c28691;
                }

                public void m8343a(boolean z) {
                }
            }

            C28691(AnonymousClass32 anonymousClass32) {
                this.f5940a = anonymousClass32;
            }

            public void m8344a(@Nullable Object obj) {
                if (obj != null) {
                    this.f5940a.f5944b.m8397a((ArrayList) obj, new C28681(this));
                    this.f5940a.f5944b.m8447q();
                    this.f5940a.f5944b.m8449r();
                }
            }
        }

        /* renamed from: com.tinder.managers.h.32.2 */
        class C28702 implements C2318a {
            final /* synthetic */ JSONArray f5941a;
            final /* synthetic */ AnonymousClass32 f5942b;

            C28702(AnonymousClass32 anonymousClass32, JSONArray jSONArray) {
                this.f5942b = anonymousClass32;
                this.f5941a = jSONArray;
            }

            @Nullable
            public Object m8345a() {
                ArrayList arrayList = new ArrayList();
                try {
                    DateFormat b = C3070i.m9369b();
                    Moment moment = (Moment) this.f5942b.f5944b.f6010h.get(this.f5942b.f5943a);
                    for (int i = 0; i < this.f5941a.length(); i++) {
                        JSONObject jSONObject = this.f5941a.getJSONObject(i);
                        String string = jSONObject.getString("date");
                        String string2 = jSONObject.getString("user");
                        if (ManagerApp.m7925p().m8279b(string2) != null) {
                            arrayList.add(new MomentLike(string, this.f5942b.f5943a, string2, moment.getMomentPhoto().getProcessedFile(PhotoSizeMoment.THUMB), b.parse(string).getTime()));
                        } else {
                            C3095y.m9476b("Couldn't find associated match, not adding Moment Like");
                        }
                    }
                    return arrayList;
                } catch (Exception e) {
                    C3095y.m9479c(BuildConfig.FLAVOR + e);
                    return null;
                }
            }
        }

        AnonymousClass32(C2887h c2887h, String str) {
            this.f5944b = c2887h;
            this.f5943a = str;
        }

        public void m8347a(@NonNull JSONArray jSONArray) {
            C3064c.m9336a(new C28702(this, jSONArray)).m9340a(new C28691(this)).m9341a();
        }
    }

    /* renamed from: com.tinder.managers.h.34 */
    class AnonymousClass34 implements C0306b<JSONObject> {
        final /* synthetic */ boolean f5950a;
        final /* synthetic */ int f5951b;
        final /* synthetic */ as f5952c;
        final /* synthetic */ C2887h f5953d;

        /* renamed from: com.tinder.managers.h.34.1 */
        class C28721 implements C2316c {
            final /* synthetic */ AnonymousClass34 f5947a;

            C28721(AnonymousClass34 anonymousClass34) {
                this.f5947a = anonymousClass34;
            }

            public void m8351a(@Nullable Object obj) {
                if (obj != null) {
                    Pair pair = (Pair) obj;
                    this.f5947a.f5953d.m8400a(this.f5947a.f5950a, this.f5947a.f5951b, (String) pair.first, (ArrayList) pair.second, this.f5947a.f5952c);
                    return;
                }
                this.f5947a.f5952c.m6402b();
                this.f5947a.f5953d.f6016n = false;
            }
        }

        /* renamed from: com.tinder.managers.h.34.2 */
        class C28732 implements C2318a {
            final /* synthetic */ JSONObject f5948a;
            final /* synthetic */ AnonymousClass34 f5949b;

            C28732(AnonymousClass34 anonymousClass34, JSONObject jSONObject) {
                this.f5949b = anonymousClass34;
                this.f5948a = jSONObject;
            }

            @Nullable
            public Object m8352a() {
                return C2975d.m8921a(this.f5948a);
            }
        }

        AnonymousClass34(C2887h c2887h, boolean z, int i, as asVar) {
            this.f5953d = c2887h;
            this.f5950a = z;
            this.f5951b = i;
            this.f5952c = asVar;
        }

        public void m8354a(@NonNull JSONObject jSONObject) {
            C3095y.m9471a("response=" + jSONObject);
            C3064c.m9336a(new C28732(this, jSONObject)).m9340a(new C28721(this)).m9341a();
        }
    }

    /* renamed from: com.tinder.managers.h.35 */
    class AnonymousClass35 implements C0305a {
        final /* synthetic */ as f5955a;
        final /* synthetic */ C2887h f5956b;

        /* renamed from: com.tinder.managers.h.35.1 */
        class C28741 implements C2438x {
            final /* synthetic */ AnonymousClass35 f5954a;

            C28741(AnonymousClass35 anonymousClass35) {
                this.f5954a = anonymousClass35;
            }

            public void m8355a() {
                C3095y.m9469a();
            }

            public void m8356b() {
                C3095y.m9469a();
            }

            public void m8357c() {
                C3095y.m9469a();
            }
        }

        AnonymousClass35(C2887h c2887h, as asVar) {
            this.f5956b = c2887h;
            this.f5955a = asVar;
        }

        public void onErrorResponse(@NonNull VolleyError volleyError) {
            this.f5956b.f6016n = false;
            ManagerApp.m7911b().m8138a(volleyError.getMessage(), new C28741(this));
            this.f5955a.m6402b();
        }
    }

    /* renamed from: com.tinder.managers.h.36 */
    class AnonymousClass36 implements C2428g {
        final /* synthetic */ boolean f5957a;
        final /* synthetic */ String f5958b;
        final /* synthetic */ String f5959c;
        final /* synthetic */ String f5960d;
        final /* synthetic */ C2887h f5961e;

        AnonymousClass36(C2887h c2887h, boolean z, String str, String str2, String str3) {
            this.f5961e = c2887h;
            this.f5957a = z;
            this.f5958b = str;
            this.f5959c = str2;
            this.f5960d = str3;
        }

        public void m8358a(boolean z) {
            if (this.f5957a) {
                this.f5961e.m8480f(this.f5958b);
            } else {
                this.f5961e.m8442m(this.f5959c);
                this.f5961e.m8443n(this.f5960d);
            }
            this.f5961e.f6016n = false;
        }
    }

    /* renamed from: com.tinder.managers.h.37 */
    class AnonymousClass37 implements C2669b {
        final /* synthetic */ String f5962a;
        final /* synthetic */ C2887h f5963b;

        AnonymousClass37(C2887h c2887h, String str) {
            this.f5963b = c2887h;
            this.f5962a = str;
        }

        public void m8359a() {
            this.f5963b.f6013k.m6527c(this.f5962a);
        }
    }

    /* renamed from: com.tinder.managers.h.38 */
    class AnonymousClass38 implements C2318a {
        final /* synthetic */ User f5964a;
        final /* synthetic */ List f5965b;
        final /* synthetic */ List f5966c;
        final /* synthetic */ List f5967d;
        final /* synthetic */ C2887h f5968e;

        AnonymousClass38(C2887h c2887h, User user, List list, List list2, List list3) {
            this.f5968e = c2887h;
            this.f5964a = user;
            this.f5965b = list;
            this.f5966c = list2;
            this.f5967d = list3;
        }

        @Nullable
        public Object m8360a() {
            C2395h.m6531a(this.f5964a.getId());
            this.f5965b.addAll(C2395h.m6529a(this.f5964a, true));
            this.f5966c.addAll(C2395h.m6529a(this.f5964a, false));
            this.f5967d.addAll(C2394g.m6525b());
            return null;
        }
    }

    /* renamed from: com.tinder.managers.h.3 */
    class C28783 implements C0306b<JSONObject> {
        final /* synthetic */ C2887h f5976a;

        /* renamed from: com.tinder.managers.h.3.1 */
        class C28651 implements C2316c {
            final /* synthetic */ C28783 f5930a;

            C28651(C28783 c28783) {
                this.f5930a = c28783;
            }

            public void m8337a(@Nullable Object obj) {
                if (obj != null) {
                    Pair pair = (Pair) obj;
                    this.f5930a.f5976a.m8396a((String) pair.first, (ArrayList) pair.second);
                } else {
                    this.f5930a.f5976a.f6000C = false;
                }
                this.f5930a.f5976a.m8449r();
            }
        }

        /* renamed from: com.tinder.managers.h.3.2 */
        class C28662 implements C2318a {
            final /* synthetic */ JSONObject f5931a;
            final /* synthetic */ C28783 f5932b;

            C28662(C28783 c28783, JSONObject jSONObject) {
                this.f5932b = c28783;
                this.f5931a = jSONObject;
            }

            @Nullable
            public Object m8338a() {
                return C2975d.m8922a(this.f5931a, ManagerApp.m7926q().f6010h);
            }
        }

        C28783(C2887h c2887h) {
            this.f5976a = c2887h;
        }

        public void m8367a(@NonNull JSONObject jSONObject) {
            C3095y.m9471a("jsonObjectResponse=" + jSONObject);
            C3064c.m9336a(new C28662(this, jSONObject)).m9340a(new C28651(this)).m9341a();
        }
    }

    /* renamed from: com.tinder.managers.h.41 */
    class AnonymousClass41 implements C0306b<JSONObject> {
        final /* synthetic */ C2434o f5981a;
        final /* synthetic */ C2887h f5982b;

        /* renamed from: com.tinder.managers.h.41.1 */
        class C28801 implements C2669b {
            final /* synthetic */ Moment f5979a;
            final /* synthetic */ AnonymousClass41 f5980b;

            C28801(AnonymousClass41 anonymousClass41, Moment moment) {
                this.f5980b = anonymousClass41;
                this.f5979a = moment;
            }

            public void m8371a() {
                C2395h.m6533a(this.f5979a);
            }
        }

        AnonymousClass41(C2887h c2887h, C2434o c2434o) {
            this.f5982b = c2887h;
            this.f5981a = c2434o;
        }

        public void m8373a(@NonNull JSONObject jSONObject) {
            try {
                Moment b = C2975d.m8924b(jSONObject);
                C3064c.m9337a(new C28801(this, b)).m9341a();
                this.f5982b.m8393a(b, false, b.getUserId().equals(ManagerApp.m7922m().m8599d().getId()));
                this.f5981a.m6760a(b);
            } catch (Exception e) {
                C3095y.m9479c(BuildConfig.FLAVOR + e);
                this.f5981a.m6759a();
            }
        }
    }

    /* renamed from: com.tinder.managers.h.4 */
    class C28814 implements C0305a {
        final /* synthetic */ C2887h f5983a;

        C28814(C2887h c2887h) {
            this.f5983a = c2887h;
        }

        public void onErrorResponse(VolleyError volleyError) {
            C3095y.m9470a(volleyError, C2239e.f3693j);
            this.f5983a.f6000C = false;
        }
    }

    /* renamed from: com.tinder.managers.h.5 */
    class C28825 implements C2428g {
        final /* synthetic */ String f5984a;
        final /* synthetic */ String f5985b;
        final /* synthetic */ C2887h f5986c;

        C28825(C2887h c2887h, String str, String str2) {
            this.f5986c = c2887h;
            this.f5984a = str;
            this.f5985b = str2;
        }

        public void m8374a(boolean z) {
            if (!(this.f5984a == null || this.f5984a.equals("null"))) {
                this.f5986c.m8436i(this.f5984a);
            }
            if (!TextUtils.isEmpty(this.f5985b)) {
                this.f5986c.m8440k(this.f5985b);
            }
            this.f5986c.f6000C = false;
        }
    }

    /* renamed from: com.tinder.managers.h.6 */
    class C28836 implements C2669b {
        final /* synthetic */ ArrayList f5987a;
        final /* synthetic */ C2428g f5988b;
        final /* synthetic */ C2887h f5989c;

        C28836(C2887h c2887h, ArrayList arrayList, C2428g c2428g) {
            this.f5989c = c2887h;
            this.f5987a = arrayList;
            this.f5988b = c2428g;
        }

        public void m8375a() {
            this.f5988b.m6746a(C2395h.m6534a(this.f5987a));
        }
    }

    /* renamed from: com.tinder.managers.h.7 */
    class C28847 implements C2669b {
        final /* synthetic */ Moment f5990a;
        final /* synthetic */ C2887h f5991b;

        C28847(C2887h c2887h, Moment moment) {
            this.f5991b = c2887h;
            this.f5990a = moment;
        }

        public void m8376a() {
            C3095y.m9471a("INSERTED MOMENT INTO DB");
            C2395h.m6533a(this.f5990a);
        }
    }

    /* renamed from: com.tinder.managers.h.8 */
    class C28858 implements C2669b {
        final /* synthetic */ C2428g f5992a;
        final /* synthetic */ ArrayList f5993b;
        final /* synthetic */ C2887h f5994c;

        C28858(C2887h c2887h, C2428g c2428g, ArrayList arrayList) {
            this.f5994c = c2887h;
            this.f5992a = c2428g;
            this.f5993b = arrayList;
        }

        public void m8377a() {
            this.f5992a.m6746a(C2394g.m6523a(this.f5993b));
        }
    }

    /* renamed from: com.tinder.managers.h.9 */
    class C28869 implements Runnable {
        final /* synthetic */ MomentLike f5995a;
        final /* synthetic */ C2887h f5996b;

        C28869(C2887h c2887h, MomentLike momentLike) {
            this.f5996b = c2887h;
            this.f5995a = momentLike;
        }

        public void run() {
            C2394g.m6522a(this.f5995a);
        }
    }

    static {
        f5997a = 3000;
    }

    public C2887h() {
        this.f6021s = true;
        C3095y.m9469a();
        this.f6013k = new C2394g();
        this.f6004b = new ad(true);
        this.f6005c = new ad(true);
        this.f6006d = new ad(false);
        this.f6007e = new ad(false);
        this.f6008f = new ArrayList();
        this.f6009g = new ArrayList();
        this.f6010h = new HashMap();
        this.f6011i = new HashMap();
        this.f6012j = new HashSet();
        this.f6018p = ManagerApp.m7914e().m8861n();
        this.f6019q = ManagerApp.m7914e().m8863o();
        m8399a(ManagerApp.m7914e().m8859m());
        this.f6023u = ManagerApp.m7914e().m8845g(false);
        this.f6001D = ManagerApp.m7914e().ai();
        User d = ManagerApp.m7922m().m8599d();
        if (d != null) {
            C3095y.m9471a("Logged in, retrieving Moment info from DB");
            m8395a(d);
        } else {
            C3095y.m9471a("Not logged in, not retrieving Moment info from DB");
        }
        m8472c();
        m8445p();
        this.f6020r = ManagerApp.m7914e().m8822Z();
    }

    private static void m8379a(@Nullable Bitmap bitmap, @NonNull ao aoVar) {
        C3095y.m9469a();
        if (bitmap != null) {
            String str = C2239e.f3691h;
            ManagerApp.m7911b();
            C2240f c28611 = new C28611(bitmap, str, C2821b.m8123b(), true, aoVar);
            if (VERSION.SDK_INT >= 11) {
                c28611.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                return;
            } else {
                c28611.execute(new String[0]);
                return;
            }
        }
        C3095y.m9476b("bitmap null, not sending anything.");
        aoVar.m6669a();
    }

    private static boolean m8416c(int i) {
        return i == HttpStatus.SC_OK || (i >= HttpStatus.SC_BAD_REQUEST && i < HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }

    public void m8453a() {
        this.f6002E++;
        C3095y.m9471a("Added feed moment client, num clients now: " + this.f6002E);
        Object obj = System.currentTimeMillis() - this.f6003F > f5997a ? 1 : null;
        if (this.f6002E == 1 && obj != null && ManagerApp.m7911b().m8144e()) {
            C3095y.m9471a("We were foregrounded, getting FEED MOMENTS");
            m8485j();
        }
    }

    public void m8468b() {
        this.f6002E--;
        C3095y.m9471a("Removed feed moment client, num clients now: " + this.f6002E);
        this.f6003F = System.currentTimeMillis();
    }

    private void m8445p() {
        this.f6028z = ManagerApp.m7914e().m8855k();
        this.f5998A = ManagerApp.m7914e().m8819W();
        this.f6024v = ManagerApp.m7914e().m8817U();
        this.f6025w = ManagerApp.m7914e().m8820X();
        this.f6026x = ManagerApp.m7914e().m8818V();
        this.f6027y = ManagerApp.m7914e().m8821Y();
    }

    public void m8472c() {
        if (!this.f6023u) {
            String str = C2239e.af;
            C0306b anonymousClass10 = new C0306b<JSONObject>() {
                final /* synthetic */ C2887h f5878a;

                {
                    this.f5878a = r1;
                }

                public void m8306a(@NonNull JSONObject jSONObject) {
                    String str = "en";
                    C3095y.m9471a(BuildConfig.FLAVOR + jSONObject);
                    str = Locale.getDefault().getLanguage();
                    C3095y.m9471a("language code is " + str);
                    try {
                        JSONArray jSONArray;
                        JSONObject jSONObject2 = jSONObject.getJSONObject("intro_moments");
                        if (jSONObject2.has(str)) {
                            jSONArray = jSONObject2.getJSONArray(str);
                        } else {
                            jSONArray = jSONObject2.getJSONArray("en");
                        }
                        List arrayList = new ArrayList();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            arrayList.add(jSONArray.getString(i));
                        }
                        this.f5878a.m8399a(arrayList);
                    } catch (JSONException e) {
                        C3095y.m9479c(BuildConfig.FLAVOR + e);
                    }
                }
            };
            C0305a anonymousClass21 = new C0305a() {
                final /* synthetic */ C2887h f5910a;

                {
                    this.f5910a = r1;
                }

                public void onErrorResponse(VolleyError volleyError) {
                    C3095y.m9479c(BuildConfig.FLAVOR + volleyError);
                }
            };
            ManagerApp.m7911b();
            ManagerApp.m7915f().m5900a(new C2237d(0, str, null, anonymousClass10, anonymousClass21, C2821b.m8123b()));
        }
    }

    private void m8395a(@NonNull User user) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        List arrayList3 = new ArrayList();
        C3064c.m9336a(new AnonymousClass38(this, user, arrayList, arrayList2, arrayList3)).m9340a(new AnonymousClass31(this, arrayList, arrayList2, arrayList3)).m9341a();
    }

    private boolean m8411b(@Nullable Moment moment) {
        return (moment == null || moment.getMomentPhoto() == null || moment.getPerson() == null) ? false : true;
    }

    public void m8455a(int i, boolean z) {
        this.f6018p = i;
        ManagerApp.m7914e().m8825a(i);
        if (z) {
            m8449r();
        }
    }

    public void m8466a(boolean z) {
        m8404b(0);
        m8455a(0, z);
    }

    public int m8475d() {
        return this.f6018p;
    }

    public void m8457a(aq aqVar) {
        Object obj = null;
        for (aq aqVar2 : this.f6008f) {
            Object obj2;
            if (aqVar2 == aqVar) {
                obj2 = 1;
            } else {
                obj2 = obj;
            }
            obj = obj2;
        }
        if (obj == null) {
            this.f6008f.add(aqVar);
        }
    }

    public void m8469b(aq aqVar) {
        for (int i = 0; i < this.f6008f.size(); i++) {
            if (this.f6008f.get(i) == aqVar) {
                this.f6008f.remove(i);
                return;
            }
        }
    }

    public int m8477e() {
        return this.f6004b.m9214a();
    }

    public void m8479f() {
        long currentTimeMillis = System.currentTimeMillis() - 86400000;
        for (int a = this.f6004b.m9214a() - 1; a >= 0; a--) {
            if (((Moment) this.f6004b.m9215a(a)).getCreatedTime() < currentTimeMillis) {
                this.f6004b.m9217b(a);
            }
        }
        m8483h();
    }

    @NonNull
    public List<Moment> m8481g() {
        return this.f6004b.m9220c();
    }

    public Moment m8452a(String str) {
        return (Moment) this.f6010h.get(str);
    }

    public void m8464a(String str, @NonNull C2434o c2434o) {
        Moment moment = (Moment) this.f6010h.get(str);
        if (moment != null) {
            c2434o.m6760a(moment);
        } else {
            m8408b(str, c2434o);
        }
    }

    public void m8483h() {
        for (aq e : this.f6008f) {
            e.m6674e();
        }
    }

    private void m8447q() {
        for (aq g : this.f6008f) {
            g.m6676g();
        }
    }

    private void m8449r() {
        for (aq f : this.f6008f) {
            f.m6675f();
        }
    }

    private void m8450s() {
        for (ap apVar : this.f6009g) {
            if (this.f6015m) {
                apVar.m6673c();
            } else if (this.f6014l) {
                apVar.m6671a();
            } else {
                apVar.m6672b();
            }
        }
    }

    @NonNull
    public List<MomentLike> m8467b(String str) {
        ad adVar = new ad(true);
        if (this.f6011i.containsKey(str)) {
            for (Comparable comparable : (List) this.f6011i.get(str)) {
                if (m8452a(comparable.getMomentId()) != null) {
                    adVar.m9216a(comparable);
                }
            }
        }
        return adVar.m9220c();
    }

    @NonNull
    public List<MomentLike> m8484i() {
        User d = ManagerApp.m7922m().m8599d();
        List<MomentLike> arrayList = new ArrayList(this.f6007e.m9214a());
        if (d != null) {
            String id = d.getId();
            for (int i = 0; i < this.f6007e.m9214a(); i++) {
                MomentLike momentLike = (MomentLike) this.f6007e.m9215a(i);
                if (!momentLike.getLikedbyId().equals(id)) {
                    arrayList.add(momentLike);
                }
            }
        }
        return arrayList;
    }

    @Nullable
    public Moment m8451a(int i) {
        if (i >= this.f6004b.m9214a() || i < 0) {
            return null;
        }
        return (Moment) this.f6004b.m9215a(i);
    }

    public void m8485j() {
        C3095y.m9469a();
        if (this.f5999B) {
            C3095y.m9471a("Already getting feed moments");
        } else if (ManagerApp.m7911b().m8144e()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("last_activity_date", this.f6024v);
                jSONObject.put("last_moment_id", this.f6025w);
            } catch (JSONException e) {
                C3095y.m9479c(e.getMessage());
            }
            this.f5999B = true;
            String str = C2239e.f3694k;
            C0306b anonymousClass39 = new C0306b<JSONObject>() {
                final /* synthetic */ C2887h f5975a;

                /* renamed from: com.tinder.managers.h.39.1 */
                class C28761 implements C2316c {
                    final /* synthetic */ String f5970a;
                    final /* synthetic */ String f5971b;
                    final /* synthetic */ AnonymousClass39 f5972c;

                    /* renamed from: com.tinder.managers.h.39.1.1 */
                    class C28751 implements C2428g {
                        final /* synthetic */ C28761 f5969a;

                        C28751(C28761 c28761) {
                            this.f5969a = c28761;
                        }

                        public void m8361a(boolean z) {
                            if (z) {
                                if (!(this.f5969a.f5970a == null || this.f5969a.f5970a.equals("null"))) {
                                    this.f5969a.f5972c.f5975a.m8438j(this.f5969a.f5970a);
                                }
                                if (!TextUtils.isEmpty(this.f5969a.f5971b)) {
                                    this.f5969a.f5972c.f5975a.m8441l(this.f5969a.f5971b);
                                }
                            }
                            this.f5969a.f5972c.f5975a.f5999B = false;
                        }
                    }

                    C28761(AnonymousClass39 anonymousClass39, String str, String str2) {
                        this.f5972c = anonymousClass39;
                        this.f5970a = str;
                        this.f5971b = str2;
                    }

                    public void m8362a(Object obj) {
                        this.f5972c.f5975a.m8398a((ArrayList) obj, false, new C28751(this));
                        this.f5972c.f5975a.m8483h();
                    }
                }

                /* renamed from: com.tinder.managers.h.39.2 */
                class C28772 implements C2318a {
                    final /* synthetic */ ArrayList f5973a;
                    final /* synthetic */ AnonymousClass39 f5974b;

                    C28772(AnonymousClass39 anonymousClass39, ArrayList arrayList) {
                        this.f5974b = anonymousClass39;
                        this.f5973a = arrayList;
                    }

                    @NonNull
                    public Object m8363a() {
                        Map hashMap = new HashMap(this.f5973a.size());
                        Set hashSet = new HashSet(this.f5973a.size());
                        Iterator it = this.f5973a.iterator();
                        while (it.hasNext()) {
                            hashSet.add(((Moment) it.next()).getUserId());
                        }
                        List c = ManagerApp.m7925p().m8287c();
                        int size = c.size();
                        for (int i = 0; i < size; i++) {
                            Match match = (Match) c.get(i);
                            if (hashSet.contains(match.getPerson().getId())) {
                                hashMap.put(match.getPerson().getId(), match.getPerson());
                                if (hashSet.size() == hashMap.size()) {
                                    break;
                                }
                            }
                        }
                        ArrayList arrayList = new ArrayList(this.f5973a.size());
                        for (int i2 = 0; i2 < this.f5973a.size(); i2++) {
                            Moment moment = (Moment) this.f5973a.get(i2);
                            Person person = (Person) hashMap.get(moment.getUserId());
                            if (person != null) {
                                moment.setPerson(person);
                                arrayList.add(0, moment);
                            }
                        }
                        return arrayList;
                    }
                }

                {
                    this.f5975a = r1;
                }

                public void m8365a(@NonNull JSONObject jSONObject) {
                    C3095y.m9471a("jsonObjectResponse=" + jSONObject);
                    try {
                        String optString = jSONObject.optString("last_activity_date");
                        String str = null;
                        JSONArray jSONArray = jSONObject.getJSONArray("moments");
                        ArrayList arrayList = new ArrayList(jSONArray.length());
                        for (int i = 0; i < jSONArray.length(); i++) {
                            Moment b = C2975d.m8924b(jSONArray.getJSONObject(i));
                            arrayList.add(b);
                            if (i == 0) {
                                str = b.getId();
                            }
                        }
                        if (arrayList.isEmpty()) {
                            this.f5975a.f5999B = false;
                        } else {
                            C3064c.m9336a(new C28772(this, arrayList)).m9340a(new C28761(this, optString, str)).m9341a();
                        }
                    } catch (Exception e) {
                        C3095y.m9479c(e.toString());
                        this.f5975a.f5999B = false;
                    }
                }
            };
            C0305a anonymousClass40 = new C0305a() {
                final /* synthetic */ C2887h f5978a;

                /* renamed from: com.tinder.managers.h.40.1 */
                class C28791 implements C2438x {
                    final /* synthetic */ AnonymousClass40 f5977a;

                    C28791(AnonymousClass40 anonymousClass40) {
                        this.f5977a = anonymousClass40;
                    }

                    public void m8368a() {
                        C3095y.m9469a();
                        this.f5977a.f5978a.f5999B = false;
                    }

                    public void m8369b() {
                        C3095y.m9469a();
                        this.f5977a.f5978a.f5999B = false;
                    }

                    public void m8370c() {
                        C3095y.m9469a();
                        this.f5977a.f5978a.f5999B = false;
                    }
                }

                {
                    this.f5978a = r1;
                }

                public void onErrorResponse(@NonNull VolleyError volleyError) {
                    C3095y.m9470a(volleyError, C2239e.f3694k);
                    ManagerApp.m7911b().m8138a(volleyError.getMessage(), new C28791(this));
                }
            };
            ManagerApp.m7911b();
            ManagerApp.m7915f().m5900a(new C2237d(1, str, jSONObject, anonymousClass39, anonymousClass40, C2821b.m8123b()));
        } else {
            C3095y.m9471a("Not calling /feed/moments b/c not logged in");
        }
    }

    private void m8408b(String str, @NonNull C2434o c2434o) {
        String str2 = C2239e.f3690g + '/' + str;
        C0306b anonymousClass41 = new AnonymousClass41(this, c2434o);
        C0305a c28642 = new C28642(this, c2434o);
        ManagerApp.m7911b();
        ManagerApp.m7915f().m5900a(new C2237d(0, str2, null, anonymousClass41, c28642, C2821b.m8123b()));
    }

    public void m8486k() {
        C3095y.m9469a();
        if (this.f6000C) {
            C3095y.m9471a("Already calling getFeedLikes()");
        } else if (ManagerApp.m7911b().m8144e()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("last_activity_date", this.f6028z);
                jSONObject.put("last_moment_id", this.f5998A);
            } catch (JSONException e) {
                C3095y.m9479c(BuildConfig.FLAVOR + e);
            }
            this.f6000C = true;
            String str = C2239e.f3693j;
            C0306b c28783 = new C28783(this);
            C0305a c28814 = new C28814(this);
            ManagerApp.m7911b();
            ManagerApp.m7915f().m5900a(new C2237d(1, str, jSONObject, c28783, c28814, C2821b.m8123b()));
        } else {
            C3095y.m9476b("Not logged in, not calling getFeedLikes()");
        }
    }

    private void m8396a(@Nullable String str, @NonNull ArrayList<MomentLike> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        String str2 = null;
        int i = 0;
        while (i < arrayList.size()) {
            String momentId;
            MomentLike momentLike = (MomentLike) arrayList.get(i);
            String likedbyId = momentLike.getLikedbyId();
            Match b = ManagerApp.m7925p().m8279b(likedbyId);
            if (b != null) {
                C3095y.m9476b("Adding momentLike for " + b.getName());
                arrayList2.add(momentLike);
            } else {
                C3095y.m9476b("Couldn't find match, not adding moment like for " + likedbyId);
            }
            if (i == 0) {
                momentId = momentLike.getMomentId();
            } else {
                momentId = str2;
            }
            i++;
            str2 = momentId;
        }
        if (arrayList2.size() > 0) {
            m8397a(arrayList2, new C28825(this, str, str2));
        } else {
            this.f6000C = false;
        }
    }

    public void m8465a(String str, boolean z) {
    }

    private void m8399a(@NonNull List<String> list) {
        this.f6022t = list;
        if (list.size() > 0) {
            for (int i = 0; i < this.f6022t.size(); i++) {
                this.f6004b.m9216a(new Moment((String) this.f6022t.get(i), Long.MAX_VALUE, i));
            }
            ManagerApp.m7914e().m8829a((List) list);
            m8471b(true);
            m8483h();
        }
    }

    public void m8471b(boolean z) {
        this.f6023u = z;
        ManagerApp.m7914e().m8848h(z);
    }

    private void m8434h(String str) {
        for (int i = 0; i < this.f6004b.m9214a(); i++) {
            if (((Moment) this.f6004b.m9215a(i)).getId().equals(str)) {
                this.f6022t.remove(((Moment) this.f6004b.m9217b(i)).getMomentPhoto().getProcessedFile(PhotoSizeMoment.ORIG));
                break;
            }
        }
        ManagerApp.m7914e().m8829a(this.f6022t);
    }

    private void m8398a(@NonNull ArrayList<Moment> arrayList, boolean z, @NonNull C2428g c2428g) {
        C3095y.m9469a();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            m8393a((Moment) it.next(), true, z);
        }
        C3064c.m9337a(new C28836(this, arrayList, c2428g)).m9341a();
    }

    private void m8393a(@NonNull Moment moment, boolean z, boolean z2) {
        C3095y.m9471a("ADDING MOMENT");
        String id = moment.getId();
        if (this.f6010h.containsKey(id)) {
            C3095y.m9471a("Moment already downloaded");
            return;
        }
        if (z2) {
            m8415c(moment);
        } else if (moment.hasBeenRated()) {
            this.f6005c.m9216a((Comparable) moment);
        } else {
            this.f6004b.m9216a((Comparable) moment);
        }
        this.f6010h.put(id, moment);
        if (!z) {
            C3064c.m9337a(new C28847(this, moment)).m9341a();
        }
    }

    private void m8415c(Moment moment) {
        this.f6006d.m9216a((Comparable) moment);
    }

    private void m8397a(@NonNull ArrayList<MomentLike> arrayList, @NonNull C2428g c2428g) {
        C3095y.m9469a();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            m8462a((MomentLike) it.next(), false);
        }
        C3064c.m9337a(new C28858(this, c2428g, arrayList)).m9341a();
    }

    public void m8462a(@NonNull MomentLike momentLike, boolean z) {
        String momentId = momentLike.getMomentId();
        String mixedId = momentLike.getMixedId();
        long time = momentLike.getTime();
        if (this.f6010h.containsKey(momentId)) {
            AddType addLike = ((Moment) this.f6010h.get(momentId)).addLike(momentLike);
            if (addLike == AddType.OLD) {
                C3095y.m9471a("Moment like already noted");
                return;
            }
            if (!this.f6012j.contains(mixedId) && time > this.f6019q) {
                m8455a(this.f6018p + 1, true);
            }
            if (addLike == AddType.NEW) {
                this.f6007e.m9216a((Comparable) momentLike);
            } else {
                m8394a(momentLike);
            }
            this.f6012j.add(momentLike.getMixedId());
            m8407b(momentLike);
            if (z) {
                new Thread(new C28869(this, momentLike)).start();
                return;
            }
            return;
        }
        C3095y.m9476b("Couldn't find associated Moment");
    }

    private void m8394a(@NonNull MomentLike momentLike) {
        for (int i = 0; i < this.f6007e.m9214a(); i++) {
            if (momentLike.getMixedId().equals(((MomentLike) this.f6007e.m9215a(i)).getMixedId())) {
                this.f6007e.m9217b(i);
                this.f6007e.m9216a((Comparable) momentLike);
                return;
            }
        }
    }

    private void m8404b(long j) {
        this.f6019q = j;
        ManagerApp.m7914e().m8826a(j);
    }

    private void m8407b(@NonNull MomentLike momentLike) {
        Object momentByUserId;
        String id = ManagerApp.m7922m().m8599d().getId();
        String str = BuildConfig.FLAVOR;
        if (momentLike.getLikedbyId().equals(id)) {
            momentByUserId = momentLike.getMomentByUserId();
        } else {
            momentByUserId = momentLike.getLikedbyId();
        }
        if (!this.f6011i.containsKey(momentByUserId)) {
            this.f6011i.put(momentByUserId, new ArrayList());
        }
        ((List) this.f6011i.get(momentByUserId)).add(momentLike);
    }

    public void m8461a(@NonNull Moment moment, @NonNull an anVar) {
        C3095y.m9469a();
        this.f6017o = moment.getCreatedTime();
        this.f6014l = true;
        m8415c(moment);
        C3064c.m9337a(new AnonymousClass11(this, moment)).m9341a();
        m8447q();
        Bitmap bitmap = moment.getBitmap();
        if (bitmap != null) {
            m8391a(moment, anVar, bitmap);
        } else {
            C3064c.m9336a(new AnonymousClass13(this, bitmap, moment)).m9340a(new AnonymousClass12(this, moment, anVar)).m9341a();
        }
    }

    private void m8421d(@NonNull Moment moment) {
        moment.setHasFailed(true);
        C3064c.m9337a(new AnonymousClass14(this, moment)).m9341a();
    }

    private void m8391a(@NonNull Moment moment, @NonNull an anVar, @NonNull Bitmap bitmap) {
        C2887h.m8379a(bitmap, new AnonymousClass15(this, moment, anVar, bitmap));
    }

    private void m8425e(@NonNull Moment moment) {
        C3095y.m9469a();
        m8393a(moment, false, true);
    }

    private void m8436i(String str) {
        this.f6028z = str;
        ManagerApp.m7914e().m8835c(str);
    }

    private void m8438j(String str) {
        this.f6024v = str;
        ManagerApp.m7914e().m8835c(this.f6024v);
    }

    private void m8440k(String str) {
        this.f5998A = str;
        ManagerApp.m7914e().m8839e(str);
    }

    private void m8441l(String str) {
        this.f6025w = str;
        ManagerApp.m7914e().m8839e(this.f6025w);
    }

    private void m8442m(String str) {
        this.f6026x = str;
        ManagerApp.m7914e().m8837d(this.f6026x);
    }

    private void m8443n(String str) {
        this.f6027y = str;
        ManagerApp.m7914e().m8841f(str);
    }

    private void m8392a(@NonNull Moment moment, String str, @Nullable an anVar) {
        C3095y.m9471a("photoId=" + str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("media_id", str);
            jSONObject.put("text", moment.getText());
            jSONObject.put("filter", moment.getFilter());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("alignment", moment.getAlignment());
            jSONObject2.put("size", moment.getSize());
            jSONObject2.put("height", moment.getHeight());
            jSONObject.put("text_attributes", jSONObject2);
        } catch (JSONException e) {
            C3095y.m9479c(e.toString());
        }
        String str2 = C2239e.f3690g;
        C0306b anonymousClass16 = new AnonymousClass16(this, moment, anVar);
        C0305a anonymousClass17 = new AnonymousClass17(this, moment, anVar);
        ManagerApp.m7911b();
        Request c2237d = new C2237d(2, str2, jSONObject, anonymousClass16, anonymousClass17, C2821b.m8123b());
        c2237d.m222a(false);
        c2237d.m219a(new C0294c(20000, 0, 1.0f));
        ManagerApp.m7915f().m5900a(c2237d);
    }

    public void m8473c(@NonNull String str) {
        C3095y.m9471a("userId=" + str);
        ArrayList arrayList = new ArrayList();
        for (int a = this.f6004b.m9214a() - 1; a >= 0; a--) {
            if (((Moment) this.f6004b.m9215a(a)).getUserId().equals(str)) {
                String id = ((Moment) this.f6004b.m9215a(a)).getId();
                arrayList.add(id);
                this.f6004b.m9217b(a);
                this.f6010h.remove(id);
            }
        }
        C3064c.m9337a(new AnonymousClass18(this, arrayList)).m9341a();
        m8483h();
    }

    public void m8460a(@NonNull Moment moment, @NonNull ak akVar) {
        Object id = moment.getId();
        C3095y.m9471a("momentId=" + id);
        if (TextUtils.isEmpty(id)) {
            C3095y.m9476b("momentId null, most likely a pending moment");
            m8432g(moment);
            akVar.m6661c();
            return;
        }
        String str = C2239e.f3690g + '/' + id;
        C0306b anonymousClass19 = new AnonymousClass19(this, moment, akVar);
        C0305a anonymousClass20 = new AnonymousClass20(this, str, akVar);
        ManagerApp.m7911b();
        ManagerApp.m7915f().m5900a(new C2237d(3, str, null, anonymousClass19, anonymousClass20, C2821b.m8123b()));
    }

    public void m8459a(@NonNull Moment moment) {
        m8429f(moment);
    }

    private void m8429f(@NonNull Moment moment) {
        C3095y.m9469a();
        moment.clearBitmap();
        if (this.f6006d.m9221c(moment)) {
            C3095y.m9471a("Found Moment, deleting ...");
        } else {
            C3095y.m9471a("Couldn't find moment");
        }
        this.f6010h.remove(moment.getId());
        List<MomentLike> arrayList = new ArrayList();
        for (int a = this.f6007e.m9214a() - 1; a >= 0; a--) {
            MomentLike momentLike = (MomentLike) this.f6007e.m9215a(a);
            if (momentLike.getMomentId().equals(moment.getId())) {
                this.f6007e.m9217b(a);
                arrayList.add(momentLike);
            }
        }
        for (MomentLike momentLike2 : arrayList) {
            C3095y.m9471a("removed like yo: " + ((List) this.f6011i.get(momentLike2.getLikedbyId())).remove(momentLike2));
        }
        m8447q();
        C3064c.m9337a(new AnonymousClass22(this, moment, arrayList)).m9341a();
    }

    private void m8432g(@NonNull Moment moment) {
        C3095y.m9469a();
        this.f6006d.m9221c(moment);
        C3064c.m9337a(new AnonymousClass23(this, moment)).m9341a();
    }

    private void m8390a(RatedType ratedType, String str) {
        Comparable comparable = (Moment) this.f6010h.get(str);
        if (comparable != null) {
            comparable.setRatedType(ratedType);
            this.f6004b.m9221c(comparable);
            this.f6005c.m9216a(comparable);
            m8483h();
            C3064c.m9337a(new AnonymousClass24(this, comparable)).m9341a();
        }
    }

    private void m8444o(String str) {
        m8390a(RatedType.LIKED, str);
    }

    private void m8446p(String str) {
        m8390a(RatedType.PASSED, str);
    }

    private void m8448q(String str) {
        for (int a = this.f6004b.m9214a() - 1; a >= 0; a--) {
            if (((Moment) this.f6004b.m9215a(a)).getId().equals(str)) {
                this.f6004b.m9217b(a);
                break;
            }
        }
        this.f6010h.remove(str);
        C3064c.m9337a(new AnonymousClass25(this, str)).m9341a();
    }

    public boolean m8476d(String str) {
        return this.f6010h.containsKey(str);
    }

    public void m8463a(@Nullable String str, @NonNull am amVar) {
        C3095y.m9471a("momentId=" + str);
        if (Moment.isMockMoment(str)) {
            m8434h(str);
        } else if (str != null) {
            Moment moment = (Moment) this.f6010h.get(str);
            String id = ManagerApp.m7922m().m8599d().getId();
            long currentTimeMillis = System.currentTimeMillis();
            MomentLike momentLike = new MomentLike(C3070i.m9369b().format(Long.valueOf(currentTimeMillis)), str, id, moment.getMomentPhoto().getProcessedFile(PhotoSizeMoment.THUMB), currentTimeMillis);
            momentLike.setMomentByUserId(moment.getUserId());
            if (!this.f6012j.contains(momentLike.getMixedId())) {
                this.f6007e.m9216a((Comparable) momentLike);
                this.f6012j.add(momentLike.getMixedId());
                moment.addLike(momentLike);
                m8407b(momentLike);
            }
            C3064c.m9337a(new AnonymousClass26(this, moment)).m9341a();
            m8483h();
            String str2 = C2239e.f3690g + '/' + str + "/like";
            C0306b anonymousClass27 = new AnonymousClass27(this, amVar);
            C0305a anonymousClass28 = new C0305a() {
                final /* synthetic */ C2887h f5925a;

                /* renamed from: com.tinder.managers.h.28.1 */
                class C28631 implements C2438x {
                    final /* synthetic */ AnonymousClass28 f5924a;

                    C28631(AnonymousClass28 anonymousClass28) {
                        this.f5924a = anonymousClass28;
                    }

                    public void m8332a() {
                        C3095y.m9469a();
                    }

                    public void m8333b() {
                        C3095y.m9469a();
                    }

                    public void m8334c() {
                        C3095y.m9469a();
                    }
                }

                {
                    this.f5925a = r1;
                }

                public void onErrorResponse(@NonNull VolleyError volleyError) {
                    C3095y.m9471a("error=" + volleyError);
                    ManagerApp.m7911b().m8138a(volleyError.getMessage(), new C28631(this));
                }
            };
            ManagerApp.m7911b();
            ManagerApp.m7915f().m5900a(new C2237d(1, str2, null, anonymousClass27, anonymousClass28, C2821b.m8123b()));
            m8444o(str);
        } else {
            C3095y.m9476b("momentId null");
        }
    }

    public void m8470b(@Nullable String str, @NonNull am amVar) {
        C3095y.m9471a("momentId=" + str);
        if (Moment.isMockMoment(str)) {
            m8434h(str);
        } else if (str != null) {
            String str2 = C2239e.f3690g + '/' + str + "/pass";
            C0306b anonymousClass29 = new AnonymousClass29(this, amVar);
            C0305a anonymousClass30 = new C0305a() {
                final /* synthetic */ C2887h f5934a;

                /* renamed from: com.tinder.managers.h.30.1 */
                class C28671 implements C2438x {
                    final /* synthetic */ AnonymousClass30 f5933a;

                    C28671(AnonymousClass30 anonymousClass30) {
                        this.f5933a = anonymousClass30;
                    }

                    public void m8339a() {
                        C3095y.m9469a();
                    }

                    public void m8340b() {
                        C3095y.m9469a();
                    }

                    public void m8341c() {
                        C3095y.m9469a();
                    }
                }

                {
                    this.f5934a = r1;
                }

                public void onErrorResponse(@NonNull VolleyError volleyError) {
                    C3095y.m9471a("error=" + volleyError);
                    ManagerApp.m7911b().m8138a(volleyError.getMessage(), new C28671(this));
                }
            };
            ManagerApp.m7911b();
            ManagerApp.m7915f().m5900a(new C2237d(1, str2, null, anonymousClass29, anonymousClass30, C2821b.m8123b()));
            m8446p(str);
        } else {
            C3095y.m9476b("momentId null");
        }
    }

    public void m8478e(String str) {
        String str2 = C2239e.f3690g + "/" + str + "/likes";
        C0306b anonymousClass32 = new AnonymousClass32(this, str);
        C0305a anonymousClass33 = new C0305a() {
            final /* synthetic */ C2887h f5946a;

            /* renamed from: com.tinder.managers.h.33.1 */
            class C28711 implements C2438x {
                final /* synthetic */ AnonymousClass33 f5945a;

                C28711(AnonymousClass33 anonymousClass33) {
                    this.f5945a = anonymousClass33;
                }

                public void m8348a() {
                    C3095y.m9469a();
                }

                public void m8349b() {
                    C3095y.m9469a();
                }

                public void m8350c() {
                    C3095y.m9469a();
                }
            }

            {
                this.f5946a = r1;
            }

            public void onErrorResponse(@NonNull VolleyError volleyError) {
                ManagerApp.m7911b().m8138a(volleyError.getMessage(), new C28711(this));
            }
        };
        ManagerApp.m7911b();
        ManagerApp.m7915f().m5900a(new C2236c(str2, anonymousClass32, anonymousClass33, C2821b.m8123b()));
    }

    public void m8454a(int i, @NonNull as asVar, boolean z) {
        C3095y.m9471a("pageSize=" + i);
        if (this.f6016n) {
            C3095y.m9471a("not running my moment stack, as it is already running");
            return;
        }
        this.f6016n = true;
        String str = C2239e.f3695l;
        JSONObject jSONObject = new JSONObject();
        if (z) {
            try {
                str = str + "last_id=" + this.f6020r;
            } catch (JSONException e) {
                C3095y.m9479c(e.getMessage());
                asVar.m6402b();
                this.f6016n = false;
                return;
            }
        }
        jSONObject.put("last_activity_date", this.f6026x);
        jSONObject.put("last_moment_id", this.f6027y);
        C0306b anonymousClass34 = new AnonymousClass34(this, z, i, asVar);
        C0305a anonymousClass35 = new AnonymousClass35(this, asVar);
        ManagerApp.m7911b();
        ManagerApp.m7915f().m5900a(new C2237d(1, str, jSONObject, anonymousClass34, anonymousClass35, C2821b.m8123b()));
    }

    private void m8400a(boolean z, int i, String str, @NonNull ArrayList<Moment> arrayList, @NonNull as asVar) {
        Object obj;
        User d = ManagerApp.m7922m().m8599d();
        Person person = new Person(d.getId(), d.getName(), d.getPhotos(), d.getGender(), d.isVerified());
        long j = Long.MIN_VALUE;
        String str2 = BuildConfig.FLAVOR;
        long j2 = Long.MAX_VALUE;
        String str3 = BuildConfig.FLAVOR;
        int i2 = 0;
        while (i2 < arrayList.size()) {
            Comparable comparable = (Moment) arrayList.get(i2);
            comparable.setPerson(person);
            if (this.f6006d.m9219b(comparable)) {
                C3095y.m9471a("found stale my moment data in api response");
                obj = 1;
                break;
            }
            try {
                String id;
                long createdTime;
                if (comparable.getCreatedTime() > j) {
                    j = comparable.getCreatedTime();
                    id = comparable.getId();
                } else {
                    id = str2;
                }
                if (comparable.getCreatedTime() < j2) {
                    createdTime = comparable.getCreatedTime();
                    str3 = comparable.getId();
                } else {
                    createdTime = j2;
                }
                i2++;
                j2 = createdTime;
                str2 = id;
            } catch (Exception e) {
                C3095y.m9479c(e.toString());
                asVar.m6402b();
                this.f6016n = false;
                return;
            }
        }
        obj = null;
        C3095y.m9471a("my moments, received " + arrayList.size());
        m8398a((ArrayList) arrayList, true, new AnonymousClass36(this, z, str3, str, str2));
        if (arrayList.size() < i || r8 != null) {
            C3095y.m9471a("Got all of my Moments");
            this.f6021s = false;
        } else {
            C3095y.m9471a("Still more Moments ...");
            this.f6021s = true;
        }
        m8447q();
        asVar.m6401a();
    }

    public void m8480f(String str) {
        this.f6020r = str;
        ManagerApp.m7914e().m8844g(str);
    }

    public void m8487l() {
        m8466a(false);
        m8436i(BuildConfig.FLAVOR);
        m8438j(BuildConfig.FLAVOR);
        m8442m(BuildConfig.FLAVOR);
        m8440k(BuildConfig.FLAVOR);
        m8441l(BuildConfig.FLAVOR);
        m8443n(BuildConfig.FLAVOR);
        m8480f(BuildConfig.FLAVOR);
        m8474c(false);
        m8471b(false);
        this.f6021s = true;
        this.f6000C = false;
        this.f5999B = false;
        this.f6016n = false;
        this.f6011i.clear();
        this.f6010h.clear();
        this.f6012j.clear();
        this.f6007e.m9218b();
        this.f6004b.m9218b();
        this.f6006d.m9218b();
    }

    public void m8456a(long j) {
        m8455a(0, true);
        m8404b(j);
    }

    public void m8482g(String str) {
        C3095y.m9471a("userId=" + str);
        for (int i = 0; i < this.f6007e.m9214a(); i++) {
            MomentLike momentLike = (MomentLike) this.f6007e.m9215a(i);
            if (momentLike.getLikedbyId().equals(str)) {
                this.f6007e.m9221c(momentLike);
            }
        }
        this.f6011i.remove(str);
        C3064c.m9337a(new AnonymousClass37(this, str)).m9341a();
        m8449r();
    }

    @NonNull
    public List<Moment> m8488m() {
        return this.f6006d.m9220c();
    }

    public boolean m8489n() {
        return this.f6021s;
    }

    public void m8458a(@NonNull as asVar, boolean z) {
        m8454a(100, asVar, z);
    }

    public boolean m8490o() {
        return this.f6001D;
    }

    public void m8474c(boolean z) {
        this.f6001D = z;
        ManagerApp.m7914e().m8791A(z);
    }
}
