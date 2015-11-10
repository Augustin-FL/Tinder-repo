package com.mixpanel.android.mpmetrics;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.Log;
import com.mixpanel.android.C1993a.C1986a;
import com.mixpanel.android.mpmetrics.C2015a.C2012a;
import com.mixpanel.android.mpmetrics.C2019b.C2018b;
import com.mixpanel.android.mpmetrics.C2024e.C2023a;
import com.mixpanel.android.mpmetrics.C2049m.C2032b;
import com.mixpanel.android.mpmetrics.InAppNotification.Type;
import com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState;
import com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.InAppNotificationState;
import com.mixpanel.android.mpmetrics.UpdateDisplayState.DisplayState.SurveyState;
import com.mixpanel.android.p025a.C1990a;
import com.mixpanel.android.surveys.SurveyActivity;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.mixpanel.android.mpmetrics.h */
public class C2042h {
    private static final Map<String, Map<Context, C2042h>> f2885i;
    private static final C2049m f2886j;
    private static Future<SharedPreferences> f2887k;
    private final Context f2888a;
    private final C2015a f2889b;
    private final C2031g f2890c;
    private final String f2891d;
    private final C2037c f2892e;
    private final C2046k f2893f;
    private final C2041d f2894g;
    private C2024e f2895h;

    /* renamed from: com.mixpanel.android.mpmetrics.h.a */
    interface C1994a {
        void m4590a(C2042h c2042h);
    }

    /* renamed from: com.mixpanel.android.mpmetrics.h.1 */
    class C20331 implements C2032b {
        final /* synthetic */ C2042h f2869a;

        C20331(C2042h c2042h) {
            this.f2869a = c2042h;
        }

        public void m4743a(SharedPreferences sharedPreferences) {
            JSONArray a = C2046k.m4794a(sharedPreferences);
            if (a != null) {
                this.f2869a.m4776a(a);
            }
        }
    }

    /* renamed from: com.mixpanel.android.mpmetrics.h.2 */
    static class C20342 extends BroadcastReceiver {
        final /* synthetic */ C2042h f2870a;

        C20342(C2042h c2042h) {
            this.f2870a = c2042h;
        }

        public void onReceive(Context context, Intent intent) {
            JSONObject jSONObject = new JSONObject();
            Bundle bundleExtra = intent.getBundleExtra("event_args");
            if (bundleExtra != null) {
                for (String str : bundleExtra.keySet()) {
                    try {
                        jSONObject.put(str, bundleExtra.get(str));
                    } catch (Throwable e) {
                        Log.e("MixpanelAPI - App Links (OPTIONAL)", "failed to add key \"" + str + "\" to properties for tracking bolts event", e);
                    }
                }
            }
            this.f2870a.m4786a("$" + intent.getStringExtra("event_name"), jSONObject);
        }
    }

    /* renamed from: com.mixpanel.android.mpmetrics.h.3 */
    static /* synthetic */ class C20353 {
        static final /* synthetic */ int[] f2871a;

        static {
            f2871a = new int[Type.values().length];
            try {
                f2871a[Type.MINI.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2871a[Type.TAKEOVER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* renamed from: com.mixpanel.android.mpmetrics.h.b */
    public interface C2036b {
        void m4744a();

        void m4745a(Activity activity);

        void m4746a(String str);

        void m4747a(String str, Object obj);

        C2036b m4748b(String str);

        void m4749b(Activity activity);
    }

    /* renamed from: com.mixpanel.android.mpmetrics.h.c */
    private class C2037c implements C2036b {
        final /* synthetic */ C2042h f2872a;

        /* renamed from: com.mixpanel.android.mpmetrics.h.c.1 */
        class C20381 extends C2037c {
            final /* synthetic */ String f2873b;
            final /* synthetic */ C2037c f2874c;

            C20381(C2037c c2037c, String str) {
                this.f2874c = c2037c;
                this.f2873b = str;
                super(null);
            }

            public String m4765d() {
                return this.f2873b;
            }
        }

        /* renamed from: com.mixpanel.android.mpmetrics.h.c.2 */
        class C20392 implements C2018b {
            final /* synthetic */ SurveyState f2875a;
            final /* synthetic */ Activity f2876b;
            final /* synthetic */ int f2877c;
            final /* synthetic */ C2037c f2878d;

            C20392(C2037c c2037c, SurveyState surveyState, Activity activity, int i) {
                this.f2878d = c2037c;
                this.f2875a = surveyState;
                this.f2876b = activity;
                this.f2877c = i;
            }

            public void m4766a(Bitmap bitmap, int i) {
                this.f2875a.m4653a(bitmap);
                this.f2875a.m4652a(i);
                Intent intent = new Intent(this.f2876b.getApplicationContext(), SurveyActivity.class);
                intent.addFlags(268435456);
                intent.addFlags(AccessibilityNodeInfoCompat.ACTION_SET_SELECTION);
                intent.putExtra("com.mixpanel.android.surveys.SurveyActivity.INTENT_ID_KEY", this.f2877c);
                this.f2876b.startActivity(intent);
            }
        }

        /* renamed from: com.mixpanel.android.mpmetrics.h.c.3 */
        class C20403 implements Runnable {
            final /* synthetic */ InAppNotification f2879a;
            final /* synthetic */ Activity f2880b;
            final /* synthetic */ C2037c f2881c;

            C20403(C2037c c2037c, InAppNotification inAppNotification, Activity activity) {
                this.f2881c = c2037c;
                this.f2879a = inAppNotification;
                this.f2880b = activity;
            }

            @TargetApi(14)
            public void run() {
                ReentrantLock a = UpdateDisplayState.m4658a();
                a.lock();
                try {
                    if (!UpdateDisplayState.m4661b()) {
                        InAppNotification b;
                        InAppNotification inAppNotification = this.f2879a;
                        if (inAppNotification == null) {
                            b = this.f2881c.m4758b();
                        } else {
                            b = inAppNotification;
                        }
                        if (b == null) {
                            a.unlock();
                            return;
                        }
                        Type d = b.m4605d();
                        if (d != Type.TAKEOVER || C2020c.m4704a(this.f2880b.getApplicationContext())) {
                            int a2 = UpdateDisplayState.m4657a(new InAppNotificationState(b, C1990a.m4583a(this.f2880b)), this.f2881c.m4764d(), this.f2881c.f2872a.f2891d);
                            if (a2 <= 0) {
                                Log.d("MixpanelAPI", "DisplayState Lock in inconsistent state! Please report this issue to Mixpanel");
                                a.unlock();
                                return;
                            }
                            switch (C20353.f2871a[d.ordinal()]) {
                                case C3374b.SmoothProgressBar_spb_color /*1*/:
                                    UpdateDisplayState b2 = UpdateDisplayState.m4660b(a2);
                                    Fragment c2030f = new C2030f();
                                    c2030f.m4727a(a2, (InAppNotificationState) b2.m4662c());
                                    c2030f.setRetainInstance(true);
                                    FragmentTransaction beginTransaction = this.f2880b.getFragmentManager().beginTransaction();
                                    beginTransaction.setCustomAnimations(0, C1986a.com_mixpanel_android_slide_down);
                                    beginTransaction.add(16908290, c2030f);
                                    beginTransaction.commit();
                                    break;
                                case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                                    Intent intent = new Intent(this.f2880b.getApplicationContext(), SurveyActivity.class);
                                    intent.addFlags(268435456);
                                    intent.addFlags(AccessibilityNodeInfoCompat.ACTION_SET_SELECTION);
                                    intent.putExtra("com.mixpanel.android.surveys.SurveyActivity.INTENT_ID_KEY", a2);
                                    this.f2880b.startActivity(intent);
                                    break;
                                default:
                                    Log.e("MixpanelAPI", "Unrecognized notification type " + d + " can't be shown");
                                    break;
                            }
                            if (!this.f2881c.f2872a.f2890c.m4734e()) {
                                m4767a(b);
                            }
                            a.unlock();
                            return;
                        }
                        a.unlock();
                    }
                } finally {
                    a.unlock();
                }
            }

            private void m4767a(InAppNotification inAppNotification) {
                this.f2881c.f2872a.m4786a("$campaign_delivery", inAppNotification.m4601a());
                C2036b b = this.f2881c.f2872a.m4788c().m4748b(this.f2881c.m4764d());
                DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
                JSONObject a = inAppNotification.m4601a();
                try {
                    a.put("$time", simpleDateFormat.format(new Date()));
                } catch (Throwable e) {
                    Log.e("MixpanelAPI", "Exception trying to track an in app notification seen", e);
                }
                b.m4747a("$campaigns", Integer.valueOf(inAppNotification.m4603b()));
                b.m4747a("$notifications", a);
            }
        }

        private C2037c(C2042h c2042h) {
            this.f2872a = c2042h;
        }

        public void m4757a(JSONObject jSONObject) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("$android_lib_version", "4.3.1");
                jSONObject2.put("$android_os", "Android");
                jSONObject2.put("$android_os_version", VERSION.RELEASE == null ? "UNKNOWN" : VERSION.RELEASE);
                try {
                    jSONObject2.put("$android_app_version", this.f2872a.f2888a.getPackageManager().getPackageInfo(this.f2872a.f2888a.getPackageName(), 0).versionName);
                } catch (Throwable e) {
                    Log.e("MixpanelAPI", "Exception getting app version name", e);
                }
                jSONObject2.put("$android_manufacturer", Build.MANUFACTURER == null ? "UNKNOWN" : Build.MANUFACTURER);
                jSONObject2.put("$android_brand", Build.BRAND == null ? "UNKNOWN" : Build.BRAND);
                jSONObject2.put("$android_model", Build.MODEL == null ? "UNKNOWN" : Build.MODEL);
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    jSONObject2.put(str, jSONObject.get(str));
                }
                this.f2872a.m4777a(m4763c("$set", jSONObject2));
            } catch (Throwable e2) {
                Log.e("MixpanelAPI", "Exception setting people properties", e2);
            }
        }

        public void m4761b(String str, Object obj) {
            try {
                m4757a(new JSONObject().put(str, obj));
            } catch (Throwable e) {
                Log.e("MixpanelAPI", "set", e);
            }
        }

        public void m4755a(String str, Object obj) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(str, obj);
                this.f2872a.m4777a(m4763c("$append", jSONObject));
            } catch (Throwable e) {
                Log.e("MixpanelAPI", "Exception appending a property", e);
            }
        }

        public void m4756a(String str, JSONArray jSONArray) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(str, jSONArray);
                this.f2872a.m4777a(m4763c("$union", jSONObject));
            } catch (JSONException e) {
                Log.e("MixpanelAPI", "Exception unioning a property");
            }
        }

        public InAppNotification m4758b() {
            if (this.f2872a.m4792g()) {
                return this.f2872a.f2895h.m4716b(this.f2872a.f2890c.m4734e());
            }
            return null;
        }

        public Survey m4762c() {
            if (this.f2872a.m4792g()) {
                return this.f2872a.f2895h.m4713a(this.f2872a.f2890c.m4734e());
            }
            return null;
        }

        public void m4753a(Activity activity) {
            if (VERSION.SDK_INT >= 14) {
                m4751a(null, activity);
            }
        }

        public void m4760b(Activity activity) {
            if (VERSION.SDK_INT >= 14) {
                m4750a(null, activity);
            }
        }

        public void m4754a(String str) {
            if (m4764d() != null) {
                this.f2872a.f2893f.m4809b(str);
                try {
                    m4756a("$android_devices", new JSONArray("[" + str + "]"));
                } catch (Throwable e) {
                    Log.e("MixpanelAPI", "set push registration id error", e);
                }
            }
        }

        public void m4752a() {
            this.f2872a.f2893f.m4812e();
            m4761b("$android_devices", new JSONArray());
        }

        public String m4764d() {
            return this.f2872a.f2893f.m4811d();
        }

        public C2036b m4759b(String str) {
            if (str == null) {
                return null;
            }
            return new C20381(this, str);
        }

        public JSONObject m4763c(String str, Object obj) throws JSONException {
            JSONObject jSONObject = new JSONObject();
            String d = m4764d();
            jSONObject.put(str, obj);
            jSONObject.put("$token", this.f2872a.f2891d);
            jSONObject.put("$time", System.currentTimeMillis());
            if (d != null) {
                jSONObject.put("$distinct_id", m4764d());
            }
            return jSONObject;
        }

        private void m4751a(Survey survey, Activity activity) {
            if (VERSION.SDK_INT >= 14 && C2020c.m4704a(activity.getApplicationContext())) {
                ReentrantLock a = UpdateDisplayState.m4658a();
                a.lock();
                try {
                    if (!UpdateDisplayState.m4661b()) {
                        if (survey == null) {
                            survey = m4762c();
                        }
                        if (survey == null) {
                            a.unlock();
                            return;
                        }
                        DisplayState surveyState = new SurveyState(survey);
                        int a2 = UpdateDisplayState.m4657a(surveyState, m4764d(), this.f2872a.f2891d);
                        if (a2 <= 0) {
                            Log.e("MixpanelAPI", "DisplayState Lock is in an inconsistent state! Please report this issue to Mixpanel");
                            a.unlock();
                            return;
                        }
                        C2018b c20392 = new C20392(this, surveyState, activity, a2);
                        a.unlock();
                        C2019b.m4703a(activity, c20392);
                    }
                } finally {
                    a.unlock();
                }
            }
        }

        private void m4750a(InAppNotification inAppNotification, Activity activity) {
            if (VERSION.SDK_INT >= 14) {
                activity.runOnUiThread(new C20403(this, inAppNotification, activity));
            }
        }
    }

    /* renamed from: com.mixpanel.android.mpmetrics.h.d */
    private class C2041d implements C2023a, Runnable {
        final /* synthetic */ C2042h f2882a;
        private final Set<C2044j> f2883b;
        private final Executor f2884c;

        private C2041d(C2042h c2042h) {
            this.f2882a = c2042h;
            this.f2883b = new HashSet();
            this.f2884c = Executors.newSingleThreadExecutor();
        }

        public void m4768a(String str) {
            this.f2884c.execute(this);
        }

        public synchronized void run() {
            for (C2044j a : this.f2883b) {
                a.m4793a();
            }
        }
    }

    C2042h(Context context, Future<SharedPreferences> future, String str) {
        this.f2888a = context;
        this.f2891d = str;
        this.f2892e = new C2037c();
        this.f2889b = m4790e();
        this.f2890c = m4791f();
        this.f2893f = m4783a(context, (Future) future, str);
        this.f2894g = new C2041d();
        this.f2895h = null;
        String d = this.f2893f.m4811d();
        if (d != null) {
            this.f2895h = m4782a(str, d, this.f2894g);
        }
        m4789d();
        if (this.f2895h != null) {
            this.f2889b.m4694a(this.f2895h);
        }
    }

    public static C2042h m4769a(Context context, String str) {
        C2042h c2042h = null;
        if (!(str == null || context == null)) {
            synchronized (f2885i) {
                Map map;
                Context applicationContext = context.getApplicationContext();
                if (f2887k == null) {
                    f2887k = f2886j.m4818a(context, "com.mixpanel.android.mpmetrics.ReferralInfo", null);
                }
                Map map2 = (Map) f2885i.get(str);
                if (map2 == null) {
                    HashMap hashMap = new HashMap();
                    f2885i.put(str, hashMap);
                    map = hashMap;
                } else {
                    map = map2;
                }
                c2042h = (C2042h) map.get(applicationContext);
                if (c2042h == null) {
                    c2042h = new C2042h(applicationContext, f2887k, str);
                    C2042h.m4772a(context, c2042h);
                    map.put(applicationContext, c2042h);
                }
                C2042h.m4771a(context);
            }
        }
        return c2042h;
    }

    public void m4785a(String str) {
        this.f2893f.m4806a(str);
    }

    public void m4786a(String str, JSONObject jSONObject) {
        try {
            String str2;
            JSONObject jSONObject2 = new JSONObject();
            for (Entry entry : this.f2893f.m4808b().entrySet()) {
                jSONObject2.put((String) entry.getKey(), (String) entry.getValue());
            }
            JSONObject a = this.f2893f.m4805a();
            Iterator keys = a.keys();
            while (keys.hasNext()) {
                str2 = (String) keys.next();
                jSONObject2.put(str2, a.get(str2));
            }
            jSONObject2.put("time", System.currentTimeMillis() / 1000);
            jSONObject2.put("distinct_id", m4787b());
            if (jSONObject != null) {
                Iterator keys2 = jSONObject.keys();
                while (keys2.hasNext()) {
                    str2 = (String) keys2.next();
                    jSONObject2.put(str2, jSONObject.get(str2));
                }
            }
            this.f2889b.m4693a(new C2012a(str, jSONObject2, this.f2891d));
        } catch (Throwable e) {
            Log.e("MixpanelAPI", "Exception tracking event " + str, e);
        }
    }

    public void m4784a() {
        this.f2889b.m4692a();
    }

    public String m4787b() {
        return this.f2893f.m4810c();
    }

    public C2036b m4788c() {
        return this.f2892e;
    }

    @TargetApi(14)
    void m4789d() {
        if (VERSION.SDK_INT >= 14 && this.f2890c.m4741l()) {
            if (this.f2888a.getApplicationContext() instanceof Application) {
                ((Application) this.f2888a.getApplicationContext()).registerActivityLifecycleCallbacks(new C2043i(this));
            } else if (C2031g.f2854a) {
                Log.d("MixpanelAPI", "Context is NOT instanceof Application, AutoShowMixpanelUpdates will be disabled.");
            }
        }
    }

    static void m4773a(C1994a c1994a) {
        synchronized (f2885i) {
            for (Map values : f2885i.values()) {
                for (C2042h a : values.values()) {
                    c1994a.m4590a(a);
                }
            }
        }
    }

    C2015a m4790e() {
        return C2015a.m4681a(this.f2888a);
    }

    C2031g m4791f() {
        return C2031g.m4728a(this.f2888a);
    }

    C2046k m4783a(Context context, Future<SharedPreferences> future, String str) {
        C2032b c20331 = new C20331(this);
        return new C2046k(future, f2886j.m4818a(context, "com.mixpanel.android.mpmetrics.MixpanelAPI_" + str, c20331));
    }

    C2024e m4782a(String str, String str2, C2023a c2023a) {
        return new C2024e(str, str2, c2023a);
    }

    boolean m4792g() {
        return this.f2895h != null;
    }

    private void m4777a(JSONObject jSONObject) {
        if (jSONObject.has("$distinct_id")) {
            this.f2889b.m4695a(jSONObject);
        } else {
            this.f2893f.m4807a(jSONObject);
        }
    }

    private void m4776a(JSONArray jSONArray) {
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                this.f2889b.m4695a(jSONArray.getJSONObject(i));
            } catch (Throwable e) {
                Log.e("MixpanelAPI", "Malformed people record stored pending identity, will not send it.", e);
            }
        }
    }

    private static void m4772a(Context context, C2042h c2042h) {
        try {
            Class cls = Class.forName("android.support.v4.content.LocalBroadcastManager");
            Method method = cls.getMethod("getInstance", new Class[]{Context.class});
            cls.getMethod("registerReceiver", new Class[]{BroadcastReceiver.class, IntentFilter.class}).invoke(method.invoke(null, new Object[]{context}), new Object[]{new C20342(c2042h), new IntentFilter("com.parse.bolts.measurement_event")});
        } catch (Throwable e) {
            Log.d("MixpanelAPI - App Links (OPTIONAL)", "Failed to invoke LocalBroadcastManager.registerReceiver() -- App Links tracking will not be enabled due to this exception", e);
        } catch (ClassNotFoundException e2) {
            Log.d("MixpanelAPI - App Links (OPTIONAL)", "To enable App Links tracking android.support.v4 must be installed: " + e2.getMessage());
        } catch (NoSuchMethodException e3) {
            Log.d("MixpanelAPI - App Links (OPTIONAL)", "To enable App Links tracking android.support.v4 must be installed: " + e3.getMessage());
        } catch (IllegalAccessException e4) {
            Log.d("MixpanelAPI - App Links (OPTIONAL)", "App Links tracking will not be enabled due to this exception: " + e4.getMessage());
        }
    }

    private static void m4771a(Context context) {
        if (context instanceof Activity) {
            try {
                Class cls = Class.forName("a.c");
                Intent intent = ((Activity) context).getIntent();
                cls.getMethod("getTargetUrlFromInboundIntent", new Class[]{Context.class, Intent.class}).invoke(null, new Object[]{context, intent});
                return;
            } catch (Throwable e) {
                Log.d("MixpanelAPI - App Links (OPTIONAL)", "Failed to invoke bolts.AppLinks.getTargetUrlFromInboundIntent() -- Unable to detect inbound App Links", e);
                return;
            } catch (ClassNotFoundException e2) {
                Log.d("MixpanelAPI - App Links (OPTIONAL)", "Please install the Bolts library >= 1.1.2 to track App Links: " + e2.getMessage());
                return;
            } catch (NoSuchMethodException e3) {
                Log.d("MixpanelAPI - App Links (OPTIONAL)", "Please install the Bolts library >= 1.1.2 to track App Links: " + e3.getMessage());
                return;
            } catch (IllegalAccessException e4) {
                Log.d("MixpanelAPI - App Links (OPTIONAL)", "Unable to detect inbound App Links: " + e4.getMessage());
                return;
            }
        }
        Log.d("MixpanelAPI - App Links (OPTIONAL)", "Context is not an instance of Activity. To detect inbound App Links, pass an instance of an Activity to getInstance.");
    }

    static {
        f2885i = new HashMap();
        f2886j = new C2049m();
    }
}
