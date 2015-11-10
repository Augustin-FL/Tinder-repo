package com.tinder;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.android.volley.C0294c;
import com.android.volley.C0307i.C0305a;
import com.android.volley.C0307i.C0306b;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.google.android.gcm.C0707a;
import com.google.android.gcm.GCMBaseIntentService;
import com.tinder.managers.C2821b;
import com.tinder.managers.ManagerApp;
import com.tinder.managers.ManagerNotifications.NotificationType;
import com.tinder.p029a.C2237d;
import com.tinder.p029a.C2239e;
import com.tinder.utils.C3095y;
import org.json.JSONException;
import org.json.JSONObject;

public class GCMIntentService extends GCMBaseIntentService {

    /* renamed from: com.tinder.GCMIntentService.1 */
    static class C22291 implements C0306b<JSONObject> {
        C22291() {
        }

        public void m5880a(JSONObject jSONObject) {
            C3095y.m9485e("****************** Registered push with Tinder backend! ********************");
            ManagerApp.m7914e().m8867q(true);
        }
    }

    /* renamed from: com.tinder.GCMIntentService.2 */
    static class C22302 implements C0305a {
        C22302() {
        }

        public void onErrorResponse(@NonNull VolleyError volleyError) {
            C3095y.m9479c("error registering push with Tinder backend: " + volleyError + ", " + volleyError.getMessage() + ", " + volleyError.f189a);
            ManagerApp.m7914e().m8867q(false);
        }
    }

    /* renamed from: com.tinder.GCMIntentService.3 */
    static class C22313 implements C0306b<JSONObject> {
        C22313() {
        }

        public void m5882a(JSONObject jSONObject) {
            C3095y.m9485e("****************** Unregistered push with Tinder backend! ********************");
            ManagerApp.m7914e().m8867q(false);
        }
    }

    /* renamed from: com.tinder.GCMIntentService.4 */
    static class C22324 implements C0305a {
        C22324() {
        }

        public void onErrorResponse(@NonNull VolleyError volleyError) {
            C3095y.m9479c("error unregistering push with Tinder backend: " + volleyError + ", " + volleyError.getMessage() + ", " + volleyError.f189a);
            ManagerApp.m7914e().m8867q(false);
        }
    }

    public GCMIntentService() {
        super("465293127427");
    }

    private static void m5885f(Context context, String str) {
        if (!"SERVICE_NOT_AVAILABLE".equals(str)) {
            if ("ACCOUNT_MISSING".equals(str)) {
                ManagerApp.m7928s().m8037a();
            } else if ("AUTHENTICATION_FAILED".equals(str)) {
                ManagerApp.m7928s().m8044b();
            } else if (!"INVALID_SENDER".equals(str) && !"PHONE_REGISTRATION_ERROR".equals(str) && "INVALID_PARAMETERS".equals(str)) {
            }
        }
    }

    public static void m5884e(Context context, String str) {
        Log.i("GCMBaseIntentService", "**********************************trying to register REG_ID with backend");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_token", str);
        } catch (JSONException e) {
            C3095y.m9479c(e.toString());
        }
        String str2 = C2239e.f3703t;
        C0306b c22291 = new C22291();
        C0305a c22302 = new C22302();
        ManagerApp.m7911b();
        Request c2237d = new C2237d(1, str2, jSONObject, c22291, c22302, C2821b.m8123b());
        c2237d.m219a(new C0294c(20000, 1, 1.0f));
        ManagerApp.m7915f().m5900a(c2237d);
    }

    public static void m5883a(String str) {
        C3095y.m9485e("regid=" + str);
        if (TextUtils.isEmpty(str)) {
            C3095y.m9471a("regid empty, not sending anything");
            return;
        }
        String str2 = C2239e.f3703t + "/" + str;
        C0306b c22313 = new C22313();
        C0305a c22324 = new C22324();
        ManagerApp.m7911b();
        ManagerApp.m7915f().m5900a(new C2237d(3, str2, null, c22313, c22324, C2821b.m8123b()));
    }

    protected void m5886a(@NonNull Context context, @NonNull Intent intent) {
        Log.i("GCMBaseIntentService", "********************************** received message: " + intent);
        Log.i("GCMBaseIntentService", "********************************** extras: " + intent.getExtras());
        ManagerApp.m7911b();
        if (C2821b.m8123b() == null) {
            C0707a.m991c(context);
            return;
        }
        String stringExtra = intent.getStringExtra("notification.message");
        String stringExtra2 = intent.getStringExtra("notification.campaignId");
        String stringExtra3 = intent.getStringExtra("notification.type");
        String stringExtra4 = intent.getStringExtra("notification.match_id");
        if ("message_notification".equals(stringExtra3)) {
            ManagerApp.m7928s().m8039a(stringExtra, NotificationType.MESSAGE_NEW, stringExtra4);
        } else if ("match".equals(stringExtra3)) {
            ManagerApp.m7928s().m8039a(stringExtra, NotificationType.MATCH_NEW, stringExtra4);
        } else if ("alert".equals(stringExtra3)) {
            ManagerApp.m7928s().m8041a(stringExtra, stringExtra2);
        } else if ("moment_like".equals(stringExtra3)) {
            ManagerApp.m7928s().m8043a(stringExtra, stringExtra4, intent.getStringExtra("notification.liked_by"), intent.getStringExtra("notification.moment"), intent.getStringExtra("notification.date"));
        } else if ("friend_request".equals(stringExtra3)) {
            stringExtra2 = intent.getStringExtra("notification.friend_type");
            ManagerApp.m7928s().m8042a(stringExtra, intent.getStringExtra("notification._id"), stringExtra2);
        } else if ("super_like".equals(stringExtra3)) {
            ManagerApp.m7928s().m8045b(stringExtra);
        }
    }

    protected boolean m5887a(Context context, String str) {
        Log.e("GCMBaseIntentService", "********************************** experienced recoverable error: " + str);
        m5885f(context, str);
        return true;
    }

    protected void m5888b(Context context, String str) {
        Log.e("GCMBaseIntentService", "********************************** experienced error: " + str);
        m5885f(context, str);
    }

    protected void m5889c(Context context, String str) {
        Log.i("GCMBaseIntentService", "********************************** registered with regId: " + str);
        m5884e(context, str);
    }

    protected void m5890d(Context context, String str) {
        Log.i("GCMBaseIntentService", "********************************** unregistered with regId: " + str);
        ManagerApp.m7914e().m8867q(false);
    }
}
