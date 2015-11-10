package com.tinder.managers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.android.volley.C0307i.C0305a;
import com.android.volley.C0307i.C0306b;
import com.android.volley.VolleyError;
import com.facebook.internal.AnalyticsEvents;
import com.tinder.R;
import com.tinder.activities.ActivityBanned;
import com.tinder.dialogs.ac;
import com.tinder.dialogs.ad;
import com.tinder.dialogs.af;
import com.tinder.enums.ReportCause;
import com.tinder.enums.StatusCode;
import com.tinder.model.Match;
import com.tinder.model.TinderReportNotification;
import com.tinder.p029a.C2237d;
import com.tinder.p029a.C2239e;
import com.tinder.p030d.C2426b;
import com.tinder.p030d.C2427c;
import com.tinder.p030d.bf;
import com.tinder.p030d.bg;
import com.tinder.p030d.bp;
import com.tinder.utils.C3095y;
import org.json.JSONException;
import org.json.JSONObject;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.tinder.managers.n */
public class C2956n {

    /* renamed from: com.tinder.managers.n.1 */
    class C29501 implements C0306b<JSONObject> {
        final /* synthetic */ bf f6232a;
        final /* synthetic */ String f6233b;
        final /* synthetic */ ReportCause f6234c;
        final /* synthetic */ String f6235d;
        final /* synthetic */ C2956n f6236e;

        C29501(C2956n c2956n, bf bfVar, String str, ReportCause reportCause, String str2) {
            this.f6236e = c2956n;
            this.f6232a = bfVar;
            this.f6233b = str;
            this.f6234c = reportCause;
            this.f6235d = str2;
        }

        public void m8738a(@NonNull JSONObject jSONObject) {
            C3095y.m9471a("response=" + jSONObject);
            if (jSONObject.optString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS).equals("not found")) {
                this.f6232a.m6714a(null);
            } else {
                this.f6232a.m6715a(this.f6233b, this.f6234c, this.f6235d);
            }
        }
    }

    /* renamed from: com.tinder.managers.n.2 */
    class C29512 implements C0305a {
        final /* synthetic */ bf f6237a;
        final /* synthetic */ C2956n f6238b;

        C29512(C2956n c2956n, bf bfVar) {
            this.f6238b = c2956n;
            this.f6237a = bfVar;
        }

        public void onErrorResponse(VolleyError volleyError) {
            C3095y.m9479c(String.valueOf(volleyError));
            this.f6237a.m6714a(null);
        }
    }

    /* renamed from: com.tinder.managers.n.3 */
    class C29523 implements C0306b<JSONObject> {
        final /* synthetic */ C2427c f6239a;
        final /* synthetic */ Match f6240b;
        final /* synthetic */ Match f6241c;
        final /* synthetic */ String f6242d;
        final /* synthetic */ ReportCause f6243e;
        final /* synthetic */ boolean f6244f;
        final /* synthetic */ C2956n f6245g;

        C29523(C2956n c2956n, C2427c c2427c, Match match, Match match2, String str, ReportCause reportCause, boolean z) {
            this.f6245g = c2956n;
            this.f6239a = c2427c;
            this.f6240b = match;
            this.f6241c = match2;
            this.f6242d = str;
            this.f6243e = reportCause;
            this.f6244f = z;
        }

        public void m8740a(JSONObject jSONObject) {
            C3095y.m9471a("response=" + jSONObject);
            this.f6239a.m6743a(this.f6240b, this.f6241c.getId(), this.f6242d, this.f6243e, this.f6244f);
        }
    }

    /* renamed from: com.tinder.managers.n.4 */
    class C29534 implements C0305a {
        final /* synthetic */ C2427c f6246a;
        final /* synthetic */ Match f6247b;
        final /* synthetic */ C2956n f6248c;

        C29534(C2956n c2956n, C2427c c2427c, Match match) {
            this.f6248c = c2956n;
            this.f6246a = c2427c;
            this.f6247b = match;
        }

        public void onErrorResponse(VolleyError volleyError) {
            C3095y.m9479c(String.valueOf(volleyError));
            this.f6246a.m6745c(this.f6247b);
        }
    }

    /* renamed from: com.tinder.managers.n.5 */
    class C29545 implements C0306b<JSONObject> {
        final /* synthetic */ C2426b f6249a;
        final /* synthetic */ C2956n f6250b;

        C29545(C2956n c2956n, C2426b c2426b) {
            this.f6250b = c2956n;
            this.f6249a = c2426b;
        }

        public void m8742a(@NonNull JSONObject jSONObject) {
            C3095y.m9471a("agreeToTerms onResponse");
            if (StatusCode.OK.getCode() == jSONObject.optInt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS)) {
                this.f6249a.m6701a();
            } else {
                this.f6249a.m6702b();
            }
        }
    }

    /* renamed from: com.tinder.managers.n.6 */
    class C29556 implements C0305a {
        final /* synthetic */ C2426b f6251a;
        final /* synthetic */ C2956n f6252b;

        C29556(C2956n c2956n, C2426b c2426b) {
            this.f6252b = c2956n;
            this.f6251a = c2426b;
        }

        public void onErrorResponse(@NonNull VolleyError volleyError) {
            C3095y.m9479c(volleyError.getMessage());
            this.f6251a.m6702b();
        }
    }

    @NonNull
    public static ac m8743a(@NonNull Context context, bg bgVar, Match match) {
        return new ac(context, bgVar, match);
    }

    @NonNull
    public static ad m8744a(@NonNull Context context, TinderReportNotification tinderReportNotification) {
        return new ad(context, tinderReportNotification);
    }

    @NonNull
    public static af m8745a(@NonNull Context context, bp bpVar) {
        return new af(context, bpVar);
    }

    public static void m8747a(@NonNull Activity activity) {
        Intent intent = new Intent(activity, ActivityBanned.class);
        intent.setFlags(1073741824);
        activity.startActivity(intent);
        activity.finish();
    }

    public static String m8746a(@NonNull Context context, int i) {
        switch (i) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                return context.getString(R.string.reported_reason_other);
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                return context.getString(R.string.report_type_spam);
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                return context.getString(R.string.report_type_offensive_messages);
            case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                return context.getString(R.string.report_type_inappropriate_photos);
            case C3374b.SmoothProgressBar_spb_speed /*5*/:
                return context.getString(R.string.report_type_bad_offline_behavior);
            default:
                return context.getString(R.string.reported_reason_other);
        }
    }

    public void m8749a(@NonNull ReportCause reportCause, String str, String str2, @NonNull bf bfVar) {
        C3095y.m9471a("reportCause: " + reportCause.ordinal() + " causeText: " + str);
        int ordinal = reportCause.ordinal();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cause", ordinal);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("text", str);
            }
        } catch (JSONException e) {
            C3095y.m9479c(String.valueOf(e));
        }
        String str3 = C2239e.f3707x + str2;
        C29501 c29501 = new C29501(this, bfVar, str2, reportCause, str);
        C0305a c29512 = new C29512(this, bfVar);
        ManagerApp.m7911b();
        ManagerApp.m7915f().m5900a(new C2237d(1, str3, jSONObject, c29501, c29512, C2821b.m8123b()));
    }

    public void m8750a(@NonNull C2855f c2855f, @NonNull Match match, String str, @NonNull ReportCause reportCause, boolean z, @NonNull C2427c c2427c, String str2) {
        c2855f.m8269a(reportCause, match);
        C3095y.m9471a("reportCause: " + reportCause.ordinal() + " other details text: " + str);
        int ordinal = reportCause.ordinal();
        Match a = c2855f.m8266a(match.getId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cause", ordinal);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("moment_id", str2);
            }
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("text", str);
            }
        } catch (JSONException e) {
            C3095y.m9479c(String.valueOf(e));
        }
        String str3 = C2239e.f3706w + match.getId();
        C29523 c29523 = new C29523(this, c2427c, a, match, str, reportCause, z);
        C0305a c29534 = new C29534(this, c2427c, a);
        ManagerApp.m7911b();
        ManagerApp.m7915f().m5900a(new C2237d(1, str3, jSONObject, c29523, c29534, C2821b.m8123b()));
    }

    public void m8748a(@NonNull C2426b c2426b) {
        String str = C2239e.f3675R;
        C0306b c29545 = new C29545(this, c2426b);
        C0305a c29556 = new C29556(this, c2426b);
        ManagerApp.m7911b();
        ManagerApp.m7915f().m5900a(new C2237d(1, str, null, c29545, c29556, C2821b.m8123b()));
    }
}
