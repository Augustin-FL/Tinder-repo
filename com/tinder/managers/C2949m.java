package com.tinder.managers;

import android.os.AsyncTask;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import com.android.volley.C0293k;
import com.android.volley.C0294c;
import com.android.volley.C0307i.C0305a;
import com.android.volley.C0307i.C0306b;
import com.android.volley.Request;
import com.android.volley.Request.Priority;
import com.android.volley.VolleyError;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.search.SearchAuth.StatusCodes;
import com.tinder.enums.RateType;
import com.tinder.managers.C2855f.C2853b;
import com.tinder.managers.C2949m.11.C29321;
import com.tinder.managers.C2949m.12.C29331;
import com.tinder.managers.C2949m.12.C29342;
import com.tinder.managers.C2949m.13.C29351;
import com.tinder.managers.C2949m.13.C29362;
import com.tinder.managers.C2949m.17.C29371;
import com.tinder.managers.m.AnonymousClass10;
import com.tinder.managers.m.AnonymousClass11;
import com.tinder.managers.m.AnonymousClass12;
import com.tinder.managers.m.AnonymousClass13;
import com.tinder.managers.m.AnonymousClass14;
import com.tinder.managers.m.AnonymousClass15;
import com.tinder.managers.m.AnonymousClass16;
import com.tinder.managers.m.AnonymousClass17;
import com.tinder.model.ConnectionsGroup;
import com.tinder.model.Match;
import com.tinder.model.Person;
import com.tinder.model.SparksEvent;
import com.tinder.model.SuperlikeStatus;
import com.tinder.model.User;
import com.tinder.p029a.C2237d;
import com.tinder.p029a.C2239e;
import com.tinder.p030d.C2437v;
import com.tinder.p030d.C2438x;
import com.tinder.p030d.at;
import com.tinder.p030d.ay;
import com.tinder.p030d.bd;
import com.tinder.p030d.bl;
import com.tinder.p030d.bo;
import com.tinder.p030d.bs;
import com.tinder.p031b.C2400l;
import com.tinder.p031b.C2401m;
import com.tinder.parse.C2979f;
import com.tinder.parse.UserParse;
import com.tinder.parse.UserParse.RecsResponse;
import com.tinder.utils.C3064c;
import com.tinder.utils.C3064c.C2316c;
import com.tinder.utils.C3064c.C2318a;
import com.tinder.utils.C3064c.C2669b;
import com.tinder.utils.C3077n;
import com.tinder.utils.C3093w;
import com.tinder.utils.C3095y;
import com.tinder.utils.ag;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpStatus;
import org.json.JSONException;
import org.json.JSONObject;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.tinder.managers.m */
public class C2949m {
    private final int f6215a;
    private C2958p f6216b;
    @NonNull
    private LinkedList<User> f6217c;
    @NonNull
    private ArrayList<WeakReference<bd>> f6218d;
    private Map<String, Boolean> f6219e;
    @NonNull
    private List<User> f6220f;
    private C0293k f6221g;
    private C2400l f6222h;
    private Handler f6223i;
    private int f6224j;
    private boolean f6225k;
    private boolean f6226l;
    private boolean f6227m;
    private int f6228n;
    private long f6229o;
    private SuperlikeStatus f6230p;
    private boolean f6231q;

    /* renamed from: com.tinder.managers.m.10 */
    class AnonymousClass10 implements C0306b<JSONObject> {
        final /* synthetic */ bs f6163a;
        final /* synthetic */ C2949m f6164b;

        AnonymousClass10(C2949m c2949m, bs bsVar) {
            this.f6164b = c2949m;
            this.f6163a = bsVar;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void m8647a(@android.support.annotation.NonNull org.json.JSONObject r5) {
            /*
            r4 = this;
            r3 = 0;
            r0 = new java.lang.StringBuilder;
            r0.<init>();
            r1 = "jsonObjectResponse=";
            r0 = r0.append(r1);
            r0 = r0.append(r5);
            r0 = r0.toString();
            com.tinder.utils.C3095y.m9471a(r0);
            r0 = r4.f6164b;	 Catch:{ Exception -> 0x005b }
            r0 = r0.f6219e;	 Catch:{ Exception -> 0x005b }
            r0 = com.tinder.parse.UserParse.m8898a(r5, r0);	 Catch:{ Exception -> 0x005b }
            r0 = (android.util.Pair) r0;	 Catch:{ Exception -> 0x005b }
            r2 = com.tinder.managers.C2949m.C29479.f6213a;	 Catch:{ Exception -> 0x005b }
            r1 = r0.first;	 Catch:{ Exception -> 0x005b }
            r1 = (com.tinder.parse.UserParse.RecsResponse) r1;	 Catch:{ Exception -> 0x005b }
            r1 = r1.ordinal();	 Catch:{ Exception -> 0x005b }
            r1 = r2[r1];	 Catch:{ Exception -> 0x005b }
            switch(r1) {
                case 1: goto L_0x0038;
                case 2: goto L_0x006e;
                default: goto L_0x0032;
            };
        L_0x0032:
            r0 = r4.f6164b;
            r0.m8689d(r3);
        L_0x0037:
            return;
        L_0x0038:
            r1 = r4.f6164b;	 Catch:{ Exception -> 0x005b }
            r2 = 0;
            r1.m8705a(r2);	 Catch:{ Exception -> 0x005b }
            r2 = r4.f6164b;	 Catch:{ Exception -> 0x005b }
            r1 = r0.second;	 Catch:{ Exception -> 0x005b }
            r1 = (java.util.ArrayList) r1;	 Catch:{ Exception -> 0x005b }
            r2.m8704a(r1);	 Catch:{ Exception -> 0x005b }
            r1 = r4.f6164b;	 Catch:{ Exception -> 0x005b }
            r1.m8733t();	 Catch:{ Exception -> 0x005b }
            r1 = r4.f6163a;	 Catch:{ Exception -> 0x005b }
            r1.m6708s();	 Catch:{ Exception -> 0x005b }
            r1 = r4.f6163a;	 Catch:{ Exception -> 0x005b }
            r0 = r0.second;	 Catch:{ Exception -> 0x005b }
            r0 = (java.util.List) r0;	 Catch:{ Exception -> 0x005b }
            r1.m6707a(r0);	 Catch:{ Exception -> 0x005b }
            goto L_0x0032;
        L_0x005b:
            r0 = move-exception;
            r0 = r0.getMessage();	 Catch:{ all -> 0x0074 }
            com.tinder.utils.C3095y.m9479c(r0);	 Catch:{ all -> 0x0074 }
            r0 = r4.f6163a;	 Catch:{ all -> 0x0074 }
            r0.m6709t();	 Catch:{ all -> 0x0074 }
            r0 = r4.f6164b;
            r0.m8689d(r3);
            goto L_0x0037;
        L_0x006e:
            r0 = r4.f6163a;	 Catch:{ Exception -> 0x005b }
            r0.m6710u();	 Catch:{ Exception -> 0x005b }
            goto L_0x0032;
        L_0x0074:
            r0 = move-exception;
            r1 = r4.f6164b;
            r1.m8689d(r3);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tinder.managers.m.10.a(org.json.JSONObject):void");
        }
    }

    /* renamed from: com.tinder.managers.m.11 */
    class AnonymousClass11 implements C0305a {
        final /* synthetic */ bs f6166a;
        final /* synthetic */ C2949m f6167b;

        /* renamed from: com.tinder.managers.m.11.1 */
        class C29321 implements C2438x {
            final /* synthetic */ AnonymousClass11 f6165a;

            C29321(AnonymousClass11 anonymousClass11) {
                this.f6165a = anonymousClass11;
            }

            public void m8649b() {
                C3095y.m9471a("Login retry unsuccessful");
                this.f6165a.f6166a.m6709t();
            }

            public void m8650c() {
                C3095y.m9471a("Not authentication problem");
                this.f6165a.f6166a.m6709t();
                this.f6165a.f6167b.m8689d(false);
            }

            public void m8648a() {
                C3095y.m9471a("Login retry successful, get recs again");
                this.f6165a.f6167b.m8689d(false);
                this.f6165a.f6167b.m8697a(this.f6165a.f6166a);
            }
        }

        AnonymousClass11(C2949m c2949m, bs bsVar) {
            this.f6167b = c2949m;
            this.f6166a = bsVar;
        }

        public void onErrorResponse(@NonNull VolleyError volleyError) {
            C3095y.m9483d(volleyError.getMessage() + ' ' + volleyError);
            ManagerApp.m7911b().m8138a(volleyError.getMessage(), new C29321(this));
        }
    }

    /* renamed from: com.tinder.managers.m.12 */
    class AnonymousClass12 implements C0306b<JSONObject> {
        final /* synthetic */ String f6171a;
        final /* synthetic */ C2949m f6172b;

        /* renamed from: com.tinder.managers.m.12.1 */
        class C29331 implements C2316c {
            final /* synthetic */ AnonymousClass12 f6168a;

            C29331(AnonymousClass12 anonymousClass12) {
                this.f6168a = anonymousClass12;
            }

            public void m8651a(@Nullable Object obj) {
                if (obj == null) {
                    this.f6168a.f6172b.m8712b(false);
                    this.f6168a.f6172b.m8689d(false);
                    return;
                }
                Pair pair = (Pair) obj;
                C3095y.m9471a("valid status: " + pair.first);
                switch (C29479.f6213a[((RecsResponse) pair.first).ordinal()]) {
                    case C3374b.SmoothProgressBar_spb_color /*1*/:
                        this.f6168a.f6172b.m8705a(false);
                        this.f6168a.f6172b.m8704a((ArrayList) pair.second);
                        this.f6168a.f6172b.m8733t();
                        break;
                    case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                        this.f6168a.f6172b.m8705a(false);
                        this.f6168a.f6172b.m8732s();
                        this.f6168a.f6172b.m8712b(false);
                        break;
                    case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                        this.f6168a.f6172b.m8712b(false);
                        break;
                    case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                    case C3374b.SmoothProgressBar_spb_speed /*5*/:
                        this.f6168a.f6172b.m8705a(true);
                        this.f6168a.f6172b.m8712b(false);
                        break;
                }
                this.f6168a.f6172b.m8689d(false);
            }
        }

        /* renamed from: com.tinder.managers.m.12.2 */
        class C29342 implements C2318a {
            final /* synthetic */ JSONObject f6169a;
            final /* synthetic */ AnonymousClass12 f6170b;

            C29342(AnonymousClass12 anonymousClass12, JSONObject jSONObject) {
                this.f6170b = anonymousClass12;
                this.f6169a = jSONObject;
            }

            @Nullable
            public Object m8652a() {
                Object obj = null;
                try {
                    C3095y.m9471a("RECS URL " + this.f6170b.f6171a);
                    obj = UserParse.m8898a(this.f6169a, this.f6170b.f6172b.f6219e);
                } catch (Throwable e) {
                    C3095y.m9474a("Failed to parse recs", e);
                } catch (Throwable e2) {
                    System.gc();
                    C3095y.m9474a("Out of memory parsing recs", e2);
                }
                return obj;
            }
        }

        AnonymousClass12(C2949m c2949m, String str) {
            this.f6172b = c2949m;
            this.f6171a = str;
        }

        public void m8654a(@NonNull JSONObject jSONObject) {
            C3064c.m9336a(new C29342(this, jSONObject)).m9340a(new C29331(this)).m9341a();
        }
    }

    /* renamed from: com.tinder.managers.m.14 */
    class AnonymousClass14 implements C2669b {
        final /* synthetic */ String f6176a;
        final /* synthetic */ boolean f6177b;
        final /* synthetic */ C2949m f6178c;

        AnonymousClass14(C2949m c2949m, String str, boolean z) {
            this.f6178c = c2949m;
            this.f6176a = str;
            this.f6177b = z;
        }

        public void m8662a() {
            C3095y.m9471a("past rec insertion op success: " + C2401m.m6561a(this.f6176a, this.f6177b));
        }
    }

    /* renamed from: com.tinder.managers.m.15 */
    class AnonymousClass15 implements C2669b {
        final /* synthetic */ String f6179a;
        final /* synthetic */ C2949m f6180b;

        AnonymousClass15(C2949m c2949m, String str) {
            this.f6180b = c2949m;
            this.f6179a = str;
        }

        public void m8663a() {
            C2401m.m6560a(this.f6179a);
        }
    }

    /* renamed from: com.tinder.managers.m.16 */
    class AnonymousClass16 implements C0306b<JSONObject> {
        final /* synthetic */ String f6181a;
        final /* synthetic */ at f6182b;
        final /* synthetic */ C2949m f6183c;

        AnonymousClass16(C2949m c2949m, String str, at atVar) {
            this.f6183c = c2949m;
            this.f6181a = str;
            this.f6182b = atVar;
        }

        public void m8665a(@NonNull JSONObject jSONObject) {
            try {
                if (jSONObject.getInt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS) == HttpStatus.SC_OK) {
                    C3095y.m9483d("Pass on " + this.f6181a + " SUCCESS");
                    if (this.f6182b != null) {
                        this.f6182b.m6682h();
                    }
                }
            } catch (JSONException e) {
                C3095y.m9483d(e.getMessage());
            }
        }
    }

    /* renamed from: com.tinder.managers.m.17 */
    class AnonymousClass17 implements C0305a {
        final /* synthetic */ String f6185a;
        final /* synthetic */ at f6186b;
        final /* synthetic */ C2949m f6187c;

        /* renamed from: com.tinder.managers.m.17.1 */
        class C29371 implements C2669b {
            final /* synthetic */ AnonymousClass17 f6184a;

            C29371(AnonymousClass17 anonymousClass17) {
                this.f6184a = anonymousClass17;
            }

            public void m8666a() {
                this.f6184a.f6187c.f6222h;
                C2400l.m6557a(this.f6184a.f6185a, RateType.PASS);
            }
        }

        AnonymousClass17(C2949m c2949m, String str, at atVar) {
            this.f6187c = c2949m;
            this.f6185a = str;
            this.f6186b = atVar;
        }

        public void onErrorResponse(@NonNull VolleyError volleyError) {
            C3095y.m9483d("Pass on " + this.f6185a + " FAILED " + volleyError.getMessage());
            if (this.f6186b != null) {
                if (volleyError != null && volleyError.f189a != null) {
                    switch (volleyError.f189a.f243a) {
                        case HttpStatus.SC_UNAUTHORIZED /*401*/:
                            this.f6186b.m6681g();
                            break;
                        case HttpStatus.SC_FORBIDDEN /*403*/:
                            this.f6186b.m6680f();
                            break;
                        default:
                            this.f6186b.m6683i();
                            break;
                    }
                }
                this.f6186b.m6683i();
            }
            C3064c.m9337a(new C29371(this)).m9341a();
        }
    }

    /* renamed from: com.tinder.managers.m.1 */
    class C29381 implements C2669b {
        final /* synthetic */ C2949m f6188a;

        /* renamed from: com.tinder.managers.m.1.1 */
        class C29271 implements C2437v {
            final /* synthetic */ String f6155a;
            final /* synthetic */ C29381 f6156b;

            /* renamed from: com.tinder.managers.m.1.1.1 */
            class C29261 implements C2669b {
                final /* synthetic */ C29271 f6154a;

                C29261(C29271 c29271) {
                    this.f6154a = c29271;
                }

                public void m8629a() {
                    this.f6154a.f6156b.f6188a.f6222h.m6558a(this.f6154a.f6155a);
                }
            }

            C29271(C29381 c29381, String str) {
                this.f6156b = c29381;
                this.f6155a = str;
            }

            public void m8630a(int i) {
                C3095y.m9469a();
                this.f6156b.f6188a.f6228n = i;
                C3064c.m9337a(new C29261(this)).m9341a();
            }

            public void m8632e() {
                C3095y.m9469a();
            }

            public void m8631a(Match match) {
                C3095y.m9469a();
            }

            public void m8633f() {
                ManagerApp.m7911b().m8143d();
            }

            public void m8634g() {
                ManagerApp.m7911b().m8134a(null);
            }
        }

        /* renamed from: com.tinder.managers.m.1.2 */
        class C29292 implements C2437v {
            final /* synthetic */ String f6158a;
            final /* synthetic */ C29381 f6159b;

            /* renamed from: com.tinder.managers.m.1.2.1 */
            class C29281 implements C2669b {
                final /* synthetic */ C29292 f6157a;

                C29281(C29292 c29292) {
                    this.f6157a = c29292;
                }

                public void m8635a() {
                    this.f6157a.f6159b.f6188a.f6222h.m6558a(this.f6157a.f6158a);
                }
            }

            C29292(C29381 c29381, String str) {
                this.f6159b = c29381;
                this.f6158a = str;
            }

            public void m8636a(int i) {
                C3095y.m9469a();
                C3064c.m9337a(new C29281(this)).m9341a();
            }

            public void m8638e() {
                C3095y.m9469a();
            }

            public void m8637a(Match match) {
                C3095y.m9469a();
            }

            public void m8639f() {
                ManagerApp.m7911b().m8143d();
            }

            public void m8640g() {
                ManagerApp.m7911b().m8134a(null);
            }
        }

        /* renamed from: com.tinder.managers.m.1.3 */
        class C29313 implements at {
            final /* synthetic */ String f6161a;
            final /* synthetic */ C29381 f6162b;

            /* renamed from: com.tinder.managers.m.1.3.1 */
            class C29301 implements C2669b {
                final /* synthetic */ C29313 f6160a;

                C29301(C29313 c29313) {
                    this.f6160a = c29313;
                }

                public void m8641a() {
                    this.f6160a.f6162b.f6188a.f6222h.m6558a(this.f6160a.f6161a);
                }
            }

            C29313(C29381 c29381, String str) {
                this.f6162b = c29381;
                this.f6161a = str;
            }

            public void m8644h() {
                C3095y.m9469a();
                C3064c.m9337a(new C29301(this)).m9341a();
            }

            public void m8645i() {
                C3095y.m9469a();
            }

            public void m8642f() {
                ManagerApp.m7911b().m8143d();
            }

            public void m8643g() {
                ManagerApp.m7911b().m8134a(null);
            }
        }

        C29381(C2949m c2949m) {
            this.f6188a = c2949m;
        }

        public void m8667a() {
            HashMap b = this.f6188a.f6222h.m6559b();
            for (String str : b.keySet()) {
                Pair pair = (Pair) b.get(str);
                if (((Boolean) pair.first).booleanValue()) {
                    this.f6188a.m8703a(str, false, new C29271(this, str));
                } else if (((Boolean) pair.second).booleanValue()) {
                    this.f6188a.m8703a(str, true, new C29292(this, str));
                } else {
                    this.f6188a.m8702a(str, false, new C29313(this, str));
                }
            }
        }
    }

    /* renamed from: com.tinder.managers.m.2 */
    class C29392 implements C0306b<JSONObject> {
        final /* synthetic */ bo f6189a;
        final /* synthetic */ User f6190b;
        final /* synthetic */ String f6191c;
        final /* synthetic */ C2949m f6192d;

        C29392(C2949m c2949m, bo boVar, User user, String str) {
            this.f6192d = c2949m;
            this.f6189a = boVar;
            this.f6190b = user;
            this.f6191c = str;
        }

        public void m8669a(JSONObject jSONObject) {
            C3095y.m9471a("undo superlike: " + jSONObject);
            if (jSONObject.optInt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS) == HttpStatus.SC_OK) {
                SuperlikeStatus a = C2979f.m8934a(jSONObject);
                ManagerApp.m7924o().m8698a(a);
                this.f6189a.m6734a(this.f6190b, a);
                return;
            }
            this.f6189a.m6735a(this.f6191c);
        }
    }

    /* renamed from: com.tinder.managers.m.3 */
    class C29403 implements C0305a {
        final /* synthetic */ bo f6193a;
        final /* synthetic */ String f6194b;
        final /* synthetic */ User f6195c;
        final /* synthetic */ C2949m f6196d;

        C29403(C2949m c2949m, bo boVar, String str, User user) {
            this.f6196d = c2949m;
            this.f6193a = boVar;
            this.f6194b = str;
            this.f6195c = user;
        }

        public void onErrorResponse(VolleyError volleyError) {
            if (volleyError == null) {
                this.f6193a.m6735a(this.f6194b);
                return;
            }
            C3095y.m9483d("undo superlike on " + this.f6194b + " FAILED " + volleyError.getMessage());
            if (volleyError.f189a != null) {
                switch (volleyError.f189a.f243a) {
                    case HttpStatus.SC_BAD_REQUEST /*400*/:
                        this.f6193a.m6732a();
                        return;
                    case HttpStatus.SC_UNAUTHORIZED /*401*/:
                        this.f6193a.m6733a(this.f6195c);
                        return;
                    case HttpStatus.SC_FORBIDDEN /*403*/:
                        this.f6193a.m6736b();
                        return;
                    default:
                        this.f6193a.m6735a(this.f6194b);
                        return;
                }
            }
            this.f6193a.m6735a(this.f6194b);
        }
    }

    /* renamed from: com.tinder.managers.m.4 */
    class C29414 implements C0306b<JSONObject> {
        final /* synthetic */ User f6197a;
        final /* synthetic */ bl f6198b;
        final /* synthetic */ C2949m f6199c;

        C29414(C2949m c2949m, User user, bl blVar) {
            this.f6199c = c2949m;
            this.f6197a = user;
            this.f6198b = blVar;
        }

        public void m8671a(JSONObject jSONObject) {
            C3095y.m9471a("superlikeOnRec: " + jSONObject);
            boolean optBoolean = jSONObject.optBoolean("limit_exceeded");
            SuperlikeStatus a = C2979f.m8934a(jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("match");
            ManagerApp.m7924o().m8698a(a);
            if (!(optJSONObject == null || this.f6197a == null)) {
                try {
                    this.f6198b.m6725a(C2949m.m8683b(optJSONObject, this.f6197a));
                } catch (Throwable e) {
                    this.f6198b.m6727a(this.f6197a);
                    C3095y.m9474a("Failed to parse match from like: ", e);
                }
            }
            if (optBoolean) {
                this.f6198b.m6729b(a);
            } else {
                this.f6198b.m6726a(a);
            }
        }
    }

    /* renamed from: com.tinder.managers.m.5 */
    class C29425 implements C0305a {
        final /* synthetic */ bl f6200a;
        final /* synthetic */ User f6201b;
        final /* synthetic */ String f6202c;
        final /* synthetic */ C2949m f6203d;

        C29425(C2949m c2949m, bl blVar, User user, String str) {
            this.f6203d = c2949m;
            this.f6200a = blVar;
            this.f6201b = user;
            this.f6202c = str;
        }

        public void onErrorResponse(VolleyError volleyError) {
            if (volleyError == null) {
                this.f6200a.m6727a(this.f6201b);
                return;
            }
            C3095y.m9483d("superlike on " + this.f6202c + " FAILED " + volleyError.getMessage());
            if (volleyError.f189a != null) {
                switch (volleyError.f189a.f243a) {
                    case HttpStatus.SC_UNAUTHORIZED /*401*/:
                        this.f6200a.m6728b();
                        return;
                    case HttpStatus.SC_FORBIDDEN /*403*/:
                        this.f6200a.m6724a();
                        return;
                    default:
                        this.f6200a.m6727a(this.f6201b);
                        return;
                }
            }
            this.f6200a.m6727a(this.f6201b);
        }
    }

    /* renamed from: com.tinder.managers.m.6 */
    class C29436 implements C0306b<JSONObject> {
        final /* synthetic */ String f6204a;
        final /* synthetic */ C2437v f6205b;
        final /* synthetic */ User f6206c;
        final /* synthetic */ C2949m f6207d;

        C29436(C2949m c2949m, String str, C2437v c2437v, User user) {
            this.f6207d = c2949m;
            this.f6204a = str;
            this.f6205b = c2437v;
            this.f6206c = user;
        }

        public void m8673a(@NonNull JSONObject jSONObject) {
            C3095y.m9471a("response= " + jSONObject);
            if (jSONObject.optInt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, HttpStatus.SC_OK) == HttpStatus.SC_OK) {
                C3095y.m9483d("Like on" + this.f6204a + " SUCCESS");
                this.f6207d.f6228n = jSONObject.optInt("likes_remaining", 100);
                this.f6207d.f6229o = jSONObject.optLong("rate_limited_until", 0);
                this.f6205b.m6765a(this.f6207d.f6228n);
                JSONObject optJSONObject = jSONObject.optJSONObject("match");
                if (optJSONObject != null && this.f6206c != null) {
                    try {
                        this.f6205b.m6766a(C2949m.m8683b(optJSONObject, this.f6206c));
                    } catch (JSONException e) {
                        this.f6205b.m6767e();
                        C3095y.m9479c("Failed to parse match from like: " + e.getMessage());
                    }
                }
            }
        }
    }

    /* renamed from: com.tinder.managers.m.7 */
    class C29457 implements C0305a {
        final /* synthetic */ C2437v f6209a;
        final /* synthetic */ String f6210b;
        final /* synthetic */ C2949m f6211c;

        /* renamed from: com.tinder.managers.m.7.1 */
        class C29441 implements C2669b {
            final /* synthetic */ C29457 f6208a;

            C29441(C29457 c29457) {
                this.f6208a = c29457;
            }

            public void m8674a() {
                this.f6208a.f6211c.f6222h;
                C2400l.m6557a(this.f6208a.f6210b, RateType.LIKE);
            }
        }

        C29457(C2949m c2949m, C2437v c2437v, String str) {
            this.f6211c = c2949m;
            this.f6209a = c2437v;
            this.f6210b = str;
        }

        public void onErrorResponse(@Nullable VolleyError volleyError) {
            if (volleyError == null) {
                this.f6209a.m6767e();
                return;
            }
            C3095y.m9483d("Like on " + this.f6210b + " FAILED " + volleyError.getMessage());
            if (volleyError.f189a != null) {
                switch (volleyError.f189a.f243a) {
                    case HttpStatus.SC_UNAUTHORIZED /*401*/:
                        this.f6209a.m6769g();
                        break;
                    case HttpStatus.SC_FORBIDDEN /*403*/:
                        this.f6209a.m6768f();
                        break;
                    default:
                        this.f6209a.m6767e();
                        break;
                }
            }
            this.f6209a.m6767e();
            C3064c.m9337a(new C29441(this)).m9341a();
        }
    }

    /* renamed from: com.tinder.managers.m.8 */
    class C29468 implements Runnable {
        final /* synthetic */ C2949m f6212a;

        C29468(C2949m c2949m) {
            this.f6212a = c2949m;
        }

        public void run() {
            this.f6212a.f6227m = false;
            if (ManagerApp.m7935z()) {
                this.f6212a.m8721h();
            } else {
                this.f6212a.m8712b(false);
            }
        }
    }

    /* renamed from: com.tinder.managers.m.9 */
    static /* synthetic */ class C29479 {
        static final /* synthetic */ int[] f6213a;

        static {
            f6213a = new int[RecsResponse.values().length];
            try {
                f6213a[RecsResponse.RECS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6213a[RecsResponse.NO_NEW_RECS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6213a[RecsResponse.STATUS_NOT_OK.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f6213a[RecsResponse.EXHAUSTED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f6213a[RecsResponse.TIMEOUT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* renamed from: com.tinder.managers.m.a */
    class C2948a extends AsyncTask<Void, Void, Object> {
        final /* synthetic */ C2949m f6214a;

        C2948a(C2949m c2949m) {
            this.f6214a = c2949m;
        }

        @NonNull
        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m8675a((Void[]) objArr);
        }

        @NonNull
        protected Object m8675a(Void... voidArr) {
            return C2401m.m6562b();
        }

        public void onPostExecute(Object obj) {
            this.f6214a.f6219e.putAll((Map) obj);
        }
    }

    public C2949m() {
        this.f6219e = new HashMap();
        this.f6228n = 100;
        C3095y.m9469a();
        this.f6216b = ManagerApp.m7914e();
        this.f6217c = new LinkedList();
        this.f6223i = new Handler();
        this.f6218d = new ArrayList(3);
        this.f6215a = this.f6216b.ab();
        this.f6224j = this.f6216b.ac();
        this.f6222h = new C2400l();
        this.f6221g = new C0294c(20000, 4, 2.0f);
        new C2948a(this).execute(new Void[0]);
        m8690x();
        this.f6230p = new SuperlikeStatus();
    }

    @Nullable
    private static Match m8683b(@NonNull JSONObject jSONObject, @NonNull User user) throws JSONException {
        Match a = ManagerApp.m7925p().m8267a(jSONObject);
        if (a == null) {
            return null;
        }
        a.setPerson(new Person(user.getId(), user.getName(), user.getPhotos(), user.getGender(), user.isVerified()));
        List arrayList = new ArrayList(1);
        arrayList.add(a);
        ManagerApp.m7925p().m8275a(arrayList, null);
        new C2853b(a).start();
        SparksEvent sparksEvent = new SparksEvent("Match.New");
        sparksEvent.put("matchId", a.getId());
        sparksEvent.put("fromPush", Boolean.valueOf(false));
        ConnectionsGroup connections = user.getConnections();
        if (connections != null) {
            sparksEvent.put("firstDegrees", Integer.valueOf(connections.getDegreeCount(1)));
            sparksEvent.put("secondDegrees", Integer.valueOf(connections.getDegreeCount(2)));
        }
        User d = ManagerApp.m7922m().m8599d();
        if (d != null) {
            sparksEvent.put("superLike", Boolean.valueOf(TextUtils.equals(d.getId(), a.getSuperLiker())));
        }
        sparksEvent.put("didSuperLike", Boolean.valueOf(a.superLikerIsThem()));
        C2807a.m8056a(sparksEvent);
        return a;
    }

    public int m8692a() {
        return this.f6228n;
    }

    public void m8694a(int i) {
        this.f6228n = i;
    }

    public long m8707b() {
        return this.f6229o - System.currentTimeMillis();
    }

    public boolean m8716c() {
        return this.f6228n == 0 && m8707b() > 0;
    }

    public boolean m8717d() {
        return this.f6230p.isOutOfSuperlikes();
    }

    public void m8718e() {
        this.f6228n = 100;
        this.f6229o = 0;
    }

    public long m8719f() {
        return this.f6229o;
    }

    public void m8695a(long j) {
        this.f6229o = j;
    }

    public void m8698a(SuperlikeStatus superlikeStatus) {
        this.f6230p = superlikeStatus;
    }

    public SuperlikeStatus m8720g() {
        return this.f6230p;
    }

    private void m8690x() {
        C3095y.m9469a();
        C3064c.m9337a(new C29381(this)).m9341a();
    }

    public void m8708b(int i) {
        this.f6224j = i;
        this.f6216b.m8838e(i);
    }

    public void m8699a(User user) {
        this.f6217c.add(0, user);
    }

    public void m8696a(bd bdVar) {
        this.f6218d.add(new WeakReference(bdVar));
    }

    public void m8709b(bd bdVar) {
        for (int i = 0; i < this.f6218d.size(); i++) {
            if (((WeakReference) this.f6218d.get(i)).equals(bdVar)) {
                this.f6218d.remove(i);
                return;
            }
        }
    }

    public boolean m8706a(String... strArr) {
        return m8682a(true, this.f6217c, Arrays.asList(strArr));
    }

    private boolean m8682a(boolean z, @NonNull List<User> list, @NonNull Collection<String> collection) {
        boolean z2 = false;
        for (int i = 0; i < list.size(); i++) {
            String id = ((User) list.get(i)).getId();
            for (String equals : collection) {
                if (equals.equals(id)) {
                    try {
                        list.remove(i);
                        z2 = true;
                    } catch (IndexOutOfBoundsException e) {
                    }
                }
            }
        }
        if (z2 && z) {
            m8730q();
        }
        return z2;
    }

    @Nullable
    public User m8693a(String str) {
        Iterator it = this.f6217c.iterator();
        while (it.hasNext()) {
            User user = (User) it.next();
            if (user.getId().equals(str)) {
                return user;
            }
        }
        return null;
    }

    public void m8697a(@NonNull bs bsVar) {
        boolean z = ManagerApp.m7918i().m8775l() && ManagerApp.m7911b().m8144e() && !C2821b.m8122a();
        if (z) {
            m8689d(true);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("limit", 15);
            } catch (JSONException e) {
                C3095y.m9479c(e.toString());
            }
            String format = String.format(C2239e.f3701r, new Object[]{C3093w.m9461a()});
            Priority priority = Priority.IMMEDIATE;
            C0306b anonymousClass10 = new AnonymousClass10(this, bsVar);
            C0305a anonymousClass11 = new AnonymousClass11(this, bsVar);
            ManagerApp.m7911b();
            Request agVar = new ag(priority, 1, format, jSONObject, anonymousClass10, anonymousClass11, C2821b.m8123b());
            agVar.m219a(new C0294c(StatusCodes.AUTH_DISABLED, 0, 0.0f));
            ManagerApp.m7915f().m5900a(agVar);
        }
    }

    public void m8721h() {
        C3095y.m9469a();
        C3095y.m9471a("discoverEnabled=" + ManagerApp.m7918i().m8775l());
        C3095y.m9471a("isGetting=" + m8727n());
        C3095y.m9471a("mIsWaitingToRetry=" + this.f6227m);
        C3095y.m9471a("isLoggedIn=" + ManagerApp.m7911b().m8144e());
        C3095y.m9471a("isLoggingOut=" + C2821b.m8122a());
        boolean z = (!ManagerApp.m7918i().m8775l() || m8727n() || this.f6227m || !ManagerApp.m7911b().m8144e() || C2821b.m8122a()) ? false : true;
        if (z) {
            m8689d(true);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("limit", this.f6215a);
            } catch (Throwable e) {
                C3095y.m9474a("Failed to serialize rec size limit", e);
            }
            String format = String.format(C2239e.f3701r, new Object[]{C3093w.m9461a()});
            C0306b anonymousClass12 = new AnonymousClass12(this, format);
            C0305a anonymousClass13 = new C0305a() {
                final /* synthetic */ C2949m f6175a;

                /* renamed from: com.tinder.managers.m.13.1 */
                class C29351 implements ay {
                    final /* synthetic */ AnonymousClass13 f6173a;

                    C29351(AnonymousClass13 anonymousClass13) {
                        this.f6173a = anonymousClass13;
                    }

                    public void m8655a() {
                        C3095y.m9471a("Recs error : pinged!");
                        this.f6173a.f6175a.m8712b(false);
                    }

                    public void m8656b() {
                        C3095y.m9471a("Recs error : ping failure");
                    }

                    public void m8657c() {
                    }

                    public void m8658d() {
                        C3095y.m9471a("Recs error : bad ping location");
                    }
                }

                /* renamed from: com.tinder.managers.m.13.2 */
                class C29362 implements C2438x {
                    final /* synthetic */ AnonymousClass13 f6174a;

                    C29362(AnonymousClass13 anonymousClass13) {
                        this.f6174a = anonymousClass13;
                    }

                    public void m8660b() {
                        C3095y.m9471a("Login retry unsuccessful");
                        this.f6174a.f6175a.m8734u();
                    }

                    public void m8661c() {
                        C3095y.m9471a("Not authentication problem");
                        this.f6174a.f6175a.m8689d(false);
                        this.f6174a.f6175a.m8712b(false);
                    }

                    public void m8659a() {
                        C3095y.m9471a("Login retry successful, get recs again");
                        this.f6174a.f6175a.m8689d(false);
                        this.f6174a.f6175a.m8721h();
                    }
                }

                {
                    this.f6175a = r1;
                }

                public void onErrorResponse(@NonNull VolleyError volleyError) {
                    int i;
                    C3095y.m9483d(volleyError.getMessage() + ' ' + volleyError);
                    Object a = C3095y.m9468a(volleyError);
                    C3095y.m9471a("Recs error : " + a);
                    if (TextUtils.isEmpty(a)) {
                        i = 0;
                    } else {
                        C3095y.m9471a("Recs error : status code onErrorResponse: [" + volleyError.f189a.f243a + "]");
                        i = volleyError.f189a.f243a;
                    }
                    if (!TextUtils.isEmpty(a) && a.contains("you must have a registered position before getting recs")) {
                        C3095y.m9471a("Recs error : proceeding to ping");
                        this.f6175a.m8705a(false);
                        this.f6175a.m8689d(false);
                        ManagerApp.m7913d().m8196a(new C29351(this), true);
                    } else if (i == HttpStatus.SC_FORBIDDEN) {
                        C3095y.m9471a("error: 403");
                        this.f6175a.f6225k = false;
                        this.f6175a.m8735v();
                    } else {
                        C3095y.m9471a("retrying recs");
                        ManagerApp.m7911b().m8138a(volleyError.getMessage(), new C29362(this));
                    }
                }
            };
            ManagerApp.m7911b();
            Request c2237d = new C2237d(0, format, jSONObject, anonymousClass12, anonymousClass13, C2821b.m8123b());
            c2237d.m219a(new C0294c(20000, 0, 1.0f));
            c2237d.m220a((Object) "get_recs");
            ManagerApp.m7915f().m5900a(c2237d);
            return;
        }
        C3095y.m9471a("Not Discoverable, not logged in, logging out, already calling recs, or waiting to retry recs so not calling out recs");
    }

    private void m8681a(String str, boolean z) {
        this.f6219e.put(str, Boolean.valueOf(z));
        C3064c.m9337a(new AnonymousClass14(this, str, z)).m9341a();
    }

    public void m8711b(String str) {
        this.f6219e.remove(str);
        C3064c.m9337a(new AnonymousClass15(this, str)).m9341a();
    }

    public void m8704a(@NonNull ArrayList<User> arrayList) {
        C3095y.m9469a();
        Collection arrayList2 = new ArrayList(this.f6217c == null ? 0 : this.f6217c.size());
        Iterator it = this.f6217c.iterator();
        while (it.hasNext()) {
            arrayList2.add(((User) it.next()).getId());
        }
        m8682a(false, (List) arrayList, arrayList2);
        this.f6217c.addAll(arrayList);
        this.f6220f = arrayList;
        m8729p();
    }

    public void m8702a(String str, boolean z, @Nullable at atVar) {
        C3095y.m9471a("recIdPassedIn=" + str);
        ManagerApp.m7914e().m8843g();
        if (this.f6217c.size() > 0) {
            m8687c(str);
            m8691y();
        }
        m8681a(str, z);
        String format = String.format(C2239e.f3705v, new Object[]{str});
        C3095y.m9471a("RECS URL " + format);
        C0306b anonymousClass16 = new AnonymousClass16(this, str, atVar);
        C0305a anonymousClass17 = new AnonymousClass17(this, str, atVar);
        ManagerApp.m7911b();
        Request c2237d = new C2237d(0, format, null, anonymousClass16, anonymousClass17, C2821b.m8123b());
        c2237d.m219a(this.f6221g);
        ManagerApp.m7915f().m5900a(c2237d);
    }

    private User m8687c(String str) {
        if (this.f6217c == null) {
            return null;
        }
        for (int i = 0; i < this.f6217c.size(); i++) {
            User user = (User) this.f6217c.get(i);
            if (user.getId().equals(str)) {
                this.f6217c.remove(user);
                return user;
            }
        }
        return null;
    }

    public void m8710b(User user) {
        this.f6217c.add(0, user);
    }

    public void m8714c(User user) {
        if (this.f6217c.size() > 2) {
            this.f6217c.add(2, user);
        } else {
            this.f6217c.add(user);
        }
    }

    public void m8700a(User user, bo boVar) {
        String id = user.getId();
        String format = String.format(C2239e.f3683Z, new Object[]{id});
        C0306b c29392 = new C29392(this, boVar, user, id);
        C0305a c29403 = new C29403(this, boVar, id, user);
        ManagerApp.m7911b();
        Request c2237d = new C2237d(3, format, null, c29392, c29403, C2821b.m8123b());
        c2237d.m219a(new C0294c(20000, 0, 1.0f));
        ManagerApp.m7915f().m5900a(c2237d);
    }

    public void m8701a(String str, bl blVar) {
        User user;
        C3095y.m9471a("Attempting super like on " + str);
        this.f6219e.put(str, Boolean.valueOf(false));
        if (this.f6217c.size() > 0) {
            User user2 = (User) this.f6217c.getFirst();
            if (user2 == null || !user2.getId().equals(str)) {
                user2 = null;
            } else {
                user2 = m8687c(str);
                if (user2 != null) {
                    m8691y();
                }
            }
            user = user2;
        } else {
            user = null;
        }
        String format = String.format(C2239e.f3683Z, new Object[]{str});
        C0306b c29414 = new C29414(this, user, blVar);
        C0305a c29425 = new C29425(this, blVar, user, str);
        ManagerApp.m7911b();
        Request c2237d = new C2237d(1, format, null, c29414, c29425, C2821b.m8123b());
        c2237d.m219a(new C0294c(20000, 1, 1.0f));
        ManagerApp.m7915f().m5900a(c2237d);
    }

    public void m8703a(String str, boolean z, @NonNull C2437v c2437v) {
        User user;
        boolean z2;
        String str2;
        int i;
        C3095y.m9471a("Attempting like on " + str);
        ManagerApp.m7914e().m8843g();
        m8681a(str, z);
        boolean d = ManagerApp.m7916g().m8517d();
        if (this.f6217c.size() > 0) {
            boolean z3;
            User user2;
            User user3 = (User) this.f6217c.getFirst();
            if (user3 == null || !user3.getId().equals(str)) {
                z3 = false;
                user2 = null;
            } else {
                user2 = m8687c(str);
                if (user2 != null) {
                    m8691y();
                    z3 = user2.isRecAndPassporting();
                } else {
                    z3 = false;
                }
            }
            user = user2;
            z2 = z3;
        } else {
            z2 = false;
            user = null;
        }
        if (user != null && user.isSuperLike() && ManagerApp.m7914e().at()) {
            str2 = C2239e.ab;
            if (d) {
                str2 = str2 + "&user_traveling=true";
            }
            if (z2) {
                str2 = str2 + "&rec_traveling=true";
            }
            i = 1;
        } else {
            if (d && z2) {
                str2 = C2239e.f3673P;
            } else if (d) {
                str2 = C2239e.f3671N;
            } else if (z2) {
                str2 = C2239e.f3672O;
            } else {
                str2 = C2239e.f3704u;
            }
            i = 0;
        }
        String format = String.format(str2, new Object[]{str});
        C3095y.m9471a("RECS URL " + format);
        C0306b c29436 = new C29436(this, str, c2437v, user);
        C0305a c29457 = new C29457(this, c2437v, str);
        ManagerApp.m7911b();
        Request c2237d = new C2237d(i, format, null, c29436, c29457, C2821b.m8123b());
        c2237d.m219a(this.f6221g);
        ManagerApp.m7915f().m5900a(c2237d);
    }

    public int m8722i() {
        return this.f6217c.size();
    }

    public void m8723j() {
        this.f6217c.clear();
    }

    @Nullable
    public User m8713c(int i) {
        if (i < this.f6217c.size()) {
            return (User) this.f6217c.get(i);
        }
        return null;
    }

    @Nullable
    public User m8724k() {
        return m8713c(0);
    }

    @Nullable
    public User m8725l() {
        return m8713c(1);
    }

    public boolean m8726m() {
        return this.f6217c.isEmpty();
    }

    public boolean m8727n() {
        return this.f6225k && !this.f6226l;
    }

    private void m8689d(boolean z) {
        this.f6225k = z;
    }

    public void m8705a(boolean z) {
        C3095y.m9471a("mode=" + z);
        this.f6226l = z;
        if (this.f6226l) {
            m8731r();
        }
    }

    public boolean m8728o() {
        return this.f6226l;
    }

    private void m8691y() {
        C3095y.m9469a();
        if (m8722i() == 9) {
            C3095y.m9471a("Recs trigger met, getting more");
            m8721h();
        }
    }

    public void m8729p() {
        Iterator it = this.f6218d.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (C3077n.m9407a(weakReference)) {
                ((bd) weakReference.get()).m6707a(this.f6220f);
            }
        }
    }

    public void m8730q() {
        Iterator it = this.f6218d.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (C3077n.m9407a(weakReference)) {
                ((bd) weakReference.get()).m6712w();
            }
        }
    }

    public void m8731r() {
        Iterator it = this.f6218d.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (C3077n.m9407a(weakReference)) {
                ((bd) weakReference.get()).m6710u();
            }
        }
    }

    public void m8732s() {
        Iterator it = this.f6218d.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (C3077n.m9407a(weakReference)) {
                ((bd) weakReference.get()).m6709t();
            }
        }
    }

    public void m8733t() {
        Iterator it = this.f6218d.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (C3077n.m9407a(weakReference)) {
                ((bd) weakReference.get()).m6708s();
            }
        }
    }

    public void m8734u() {
        Iterator it = this.f6218d.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (C3077n.m9407a(weakReference)) {
                ((bd) weakReference.get()).m6711v();
            }
        }
    }

    public void m8735v() {
        Iterator it = this.f6218d.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (C3077n.m9407a(weakReference)) {
                ((bd) weakReference.get()).m6713x();
            }
        }
    }

    public void m8712b(boolean z) {
        if (z && ManagerApp.m7935z()) {
            this.f6227m = false;
            m8721h();
            return;
        }
        this.f6227m = true;
        if (this.f6223i == null) {
            this.f6223i = new Handler();
        }
        this.f6223i.postDelayed(new C29468(this), (long) this.f6224j);
    }

    public boolean m8736w() {
        return this.f6231q;
    }

    public void m8715c(boolean z) {
        this.f6231q = z;
    }
}
