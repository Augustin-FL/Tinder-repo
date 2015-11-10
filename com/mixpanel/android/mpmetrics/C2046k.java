package com.mixpanel.android.mpmetrics;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Build.VERSION;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"CommitPrefEdits"})
/* renamed from: com.mixpanel.android.mpmetrics.k */
class C2046k {
    private static boolean f2898j;
    private static final Object f2899k;
    private final Future<SharedPreferences> f2900a;
    private final Future<SharedPreferences> f2901b;
    private final OnSharedPreferenceChangeListener f2902c;
    private JSONObject f2903d;
    private Map<String, String> f2904e;
    private boolean f2905f;
    private String f2906g;
    private String f2907h;
    private JSONArray f2908i;

    /* renamed from: com.mixpanel.android.mpmetrics.k.1 */
    class C20451 implements OnSharedPreferenceChangeListener {
        final /* synthetic */ C2046k f2897a;

        C20451(C2046k c2046k) {
            this.f2897a = c2046k;
        }

        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            synchronized (C2046k.f2899k) {
                this.f2897a.m4801h();
                C2046k.f2898j = false;
            }
        }
    }

    public static JSONArray m4794a(SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString("people_distinct_id", null);
        String string2 = sharedPreferences.getString("waiting_array", null);
        if (string2 == null || string == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(string2);
            JSONArray jSONArray2 = new JSONArray();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    jSONObject.put("$distinct_id", string);
                    jSONArray2.put(jSONObject);
                } catch (Throwable e) {
                    Log.e("MixpanelAPI PersistentIdentity", "Unparsable object found in waiting people records", e);
                }
            }
            Editor edit = sharedPreferences.edit();
            edit.remove("waiting_array");
            C2046k.m4796a(edit);
            return jSONArray2;
        } catch (JSONException e2) {
            Log.e("MixpanelAPI PersistentIdentity", "Waiting people records were unreadable.");
            return null;
        }
    }

    public static void m4795a(Context context, String str, Map<String, String> map) {
        synchronized (f2899k) {
            Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.clear();
            for (Entry entry : map.entrySet()) {
                edit.putString((String) entry.getKey(), (String) entry.getValue());
            }
            C2046k.m4796a(edit);
            f2898j = true;
        }
    }

    public C2046k(Future<SharedPreferences> future, Future<SharedPreferences> future2) {
        this.f2901b = future;
        this.f2900a = future2;
        this.f2903d = null;
        this.f2904e = null;
        this.f2905f = false;
        this.f2902c = new C20451(this);
    }

    public synchronized JSONObject m4805a() {
        if (this.f2903d == null) {
            m4800g();
        }
        return this.f2903d;
    }

    public Map<String, String> m4808b() {
        synchronized (f2899k) {
            if (f2898j || this.f2904e == null) {
                m4801h();
                f2898j = false;
            }
        }
        return this.f2904e;
    }

    public synchronized String m4810c() {
        if (!this.f2905f) {
            m4803j();
        }
        return this.f2906g;
    }

    public synchronized void m4806a(String str) {
        if (!this.f2905f) {
            m4803j();
        }
        this.f2906g = str;
        m4804k();
    }

    public synchronized String m4811d() {
        if (!this.f2905f) {
            m4803j();
        }
        return this.f2907h;
    }

    public synchronized void m4807a(JSONObject jSONObject) {
        if (!this.f2905f) {
            m4803j();
        }
        if (this.f2908i == null) {
            this.f2908i = new JSONArray();
        }
        this.f2908i.put(jSONObject);
        m4804k();
    }

    public synchronized void m4809b(String str) {
        try {
            Editor edit = ((SharedPreferences) this.f2900a.get()).edit();
            edit.putString("push_id", str);
            C2046k.m4796a(edit);
        } catch (ExecutionException e) {
            Log.e("MixpanelAPI PersistentIdentity", "Can't write push id to shared preferences", e.getCause());
        } catch (Throwable e2) {
            Log.e("MixpanelAPI PersistentIdentity", "Can't write push id to shared preferences", e2);
        }
    }

    public synchronized void m4812e() {
        try {
            Editor edit = ((SharedPreferences) this.f2900a.get()).edit();
            edit.remove("push_id");
            C2046k.m4796a(edit);
        } catch (ExecutionException e) {
            Log.e("MixpanelAPI PersistentIdentity", "Can't write push id to shared preferences", e.getCause());
        } catch (Throwable e2) {
            Log.e("MixpanelAPI PersistentIdentity", "Can't write push id to shared preferences", e2);
        }
    }

    private void m4800g() {
        try {
            String string = ((SharedPreferences) this.f2900a.get()).getString("super_properties", "{}");
            if (C2031g.f2854a) {
                Log.d("MixpanelAPI PersistentIdentity", "Loading Super Properties " + string);
            }
            this.f2903d = new JSONObject(string);
            if (this.f2903d == null) {
                this.f2903d = new JSONObject();
            }
        } catch (ExecutionException e) {
            Log.e("MixpanelAPI PersistentIdentity", "Cannot load superProperties from SharedPreferences.", e.getCause());
            if (this.f2903d == null) {
                this.f2903d = new JSONObject();
            }
        } catch (Throwable e2) {
            Log.e("MixpanelAPI PersistentIdentity", "Cannot load superProperties from SharedPreferences.", e2);
            if (this.f2903d == null) {
                this.f2903d = new JSONObject();
            }
        } catch (JSONException e3) {
            Log.e("MixpanelAPI PersistentIdentity", "Cannot parse stored superProperties");
            m4802i();
            if (this.f2903d == null) {
                this.f2903d = new JSONObject();
            }
        } catch (Throwable th) {
            if (this.f2903d == null) {
                this.f2903d = new JSONObject();
            }
        }
    }

    private void m4801h() {
        this.f2904e = new HashMap();
        try {
            SharedPreferences sharedPreferences = (SharedPreferences) this.f2901b.get();
            sharedPreferences.unregisterOnSharedPreferenceChangeListener(this.f2902c);
            sharedPreferences.registerOnSharedPreferenceChangeListener(this.f2902c);
            for (Entry entry : sharedPreferences.getAll().entrySet()) {
                this.f2904e.put((String) entry.getKey(), entry.getValue().toString());
            }
        } catch (ExecutionException e) {
            Log.e("MixpanelAPI PersistentIdentity", "Cannot load referrer properties from shared preferences.", e.getCause());
        } catch (Throwable e2) {
            Log.e("MixpanelAPI PersistentIdentity", "Cannot load referrer properties from shared preferences.", e2);
        }
    }

    private void m4802i() {
        if (this.f2903d == null) {
            Log.e("MixpanelAPI PersistentIdentity", "storeSuperProperties should not be called with uninitialized superPropertiesCache.");
            return;
        }
        String jSONObject = this.f2903d.toString();
        if (C2031g.f2854a) {
            Log.d("MixpanelAPI PersistentIdentity", "Storing Super Properties " + jSONObject);
        }
        try {
            Editor edit = ((SharedPreferences) this.f2900a.get()).edit();
            edit.putString("super_properties", jSONObject);
            C2046k.m4796a(edit);
        } catch (ExecutionException e) {
            Log.e("MixpanelAPI PersistentIdentity", "Cannot store superProperties in shared preferences.", e.getCause());
        } catch (Throwable e2) {
            Log.e("MixpanelAPI PersistentIdentity", "Cannot store superProperties in shared preferences.", e2);
        }
    }

    private void m4803j() {
        SharedPreferences sharedPreferences;
        try {
            sharedPreferences = (SharedPreferences) this.f2900a.get();
        } catch (ExecutionException e) {
            Log.e("MixpanelAPI PersistentIdentity", "Cannot read distinct ids from sharedPreferences.", e.getCause());
            sharedPreferences = null;
        } catch (Throwable e2) {
            Log.e("MixpanelAPI PersistentIdentity", "Cannot read distinct ids from sharedPreferences.", e2);
            sharedPreferences = null;
        }
        if (sharedPreferences != null) {
            this.f2906g = sharedPreferences.getString("events_distinct_id", null);
            this.f2907h = sharedPreferences.getString("people_distinct_id", null);
            this.f2908i = null;
            String string = sharedPreferences.getString("waiting_array", null);
            if (string != null) {
                try {
                    this.f2908i = new JSONArray(string);
                } catch (JSONException e3) {
                    Log.e("MixpanelAPI PersistentIdentity", "Could not interpret waiting people JSON record " + string);
                }
            }
            if (this.f2906g == null) {
                this.f2906g = UUID.randomUUID().toString();
                m4804k();
            }
            this.f2905f = true;
        }
    }

    private void m4804k() {
        try {
            Editor edit = ((SharedPreferences) this.f2900a.get()).edit();
            edit.putString("events_distinct_id", this.f2906g);
            edit.putString("people_distinct_id", this.f2907h);
            if (this.f2908i == null) {
                edit.remove("waiting_array");
            } else {
                edit.putString("waiting_array", this.f2908i.toString());
            }
            C2046k.m4796a(edit);
        } catch (ExecutionException e) {
            Log.e("MixpanelAPI PersistentIdentity", "Can't write distinct ids to shared preferences.", e.getCause());
        } catch (Throwable e2) {
            Log.e("MixpanelAPI PersistentIdentity", "Can't write distinct ids to shared preferences.", e2);
        }
    }

    @TargetApi(9)
    private static void m4796a(Editor editor) {
        if (VERSION.SDK_INT >= 9) {
            editor.apply();
        } else {
            editor.commit();
        }
    }

    static {
        f2898j = true;
        f2899k = new Object();
    }
}
