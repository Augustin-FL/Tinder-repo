package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.tagmanager.DataLayer;
import com.mixpanel.android.mpmetrics.MPDbAdapter.Table;
import com.mixpanel.android.p025a.C1991b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.mixpanel.android.mpmetrics.a */
class C2015a {
    private static int f2808d;
    private static int f2809e;
    private static int f2810f;
    private static int f2811g;
    private static int f2812h;
    private static int f2813i;
    private static int f2814j;
    private static final Map<Context, C2015a> f2815k;
    private final C2014b f2816a;
    private final Context f2817b;
    private final C2031g f2818c;

    /* renamed from: com.mixpanel.android.mpmetrics.a.a */
    static class C2012a {
        private final String f2793a;
        private final JSONObject f2794b;
        private final String f2795c;

        public C2012a(String str, JSONObject jSONObject, String str2) {
            this.f2793a = str;
            this.f2794b = jSONObject;
            this.f2795c = str2;
        }

        public String m4665a() {
            return this.f2793a;
        }

        public JSONObject m4666b() {
            return this.f2794b;
        }

        public String m4667c() {
            return this.f2795c;
        }
    }

    /* renamed from: com.mixpanel.android.mpmetrics.a.b */
    private class C2014b {
        final /* synthetic */ C2015a f2801a;
        private final Object f2802b;
        private Handler f2803c;
        private long f2804d;
        private long f2805e;
        private long f2806f;
        private C2050n f2807g;

        /* renamed from: com.mixpanel.android.mpmetrics.a.b.a */
        private class C2013a extends Handler {
            final /* synthetic */ C2014b f2796a;
            private MPDbAdapter f2797b;
            private long f2798c;
            private boolean f2799d;
            private final C2022d f2800e;

            public C2013a(C2014b c2014b, Looper looper) {
                this.f2796a = c2014b;
                super(looper);
                this.f2797b = null;
                this.f2800e = new C2022d(c2014b.f2801a.f2817b, c2014b.f2801a.f2818c);
                this.f2799d = c2014b.f2801a.f2818c.m4733d();
                this.f2798c = (long) c2014b.f2801a.f2818c.m4731b();
                c2014b.f2807g = new C2050n(c2014b.f2801a.f2817b);
            }

            public void handleMessage(Message message) {
                if (this.f2797b == null) {
                    this.f2797b = this.f2796a.f2801a.m4696b(this.f2796a.f2801a.f2817b);
                    this.f2797b.m4622a(System.currentTimeMillis() - ((long) this.f2796a.f2801a.f2818c.m4732c()), Table.EVENTS);
                    this.f2797b.m4622a(System.currentTimeMillis() - ((long) this.f2796a.f2801a.f2818c.m4732c()), Table.PEOPLE);
                }
                int i = -1;
                try {
                    if (message.what == C2015a.f2813i) {
                        Long l = (Long) message.obj;
                        this.f2796a.f2801a.m4683a("Changing flush interval to " + l);
                        this.f2798c = l.longValue();
                        removeMessages(C2015a.f2810f);
                    } else if (message.what == C2015a.f2814j) {
                        Boolean bool = (Boolean) message.obj;
                        this.f2796a.f2801a.m4683a("Setting fallback to " + bool);
                        this.f2799d = bool.booleanValue();
                    } else if (message.what == C2015a.f2808d) {
                        JSONObject jSONObject = (JSONObject) message.obj;
                        this.f2796a.f2801a.m4683a("Queuing people record for sending later");
                        this.f2796a.f2801a.m4683a("    " + jSONObject.toString());
                        i = this.f2797b.m4620a(jSONObject, Table.PEOPLE);
                    } else if (message.what == C2015a.f2809e) {
                        int a;
                        try {
                            JSONObject a2 = m4669a((C2012a) message.obj);
                            this.f2796a.f2801a.m4683a("Queuing event for sending later");
                            this.f2796a.f2801a.m4683a("    " + a2.toString());
                            a = this.f2797b.m4620a(a2, Table.EVENTS);
                        } catch (Throwable e) {
                            Log.e("MixpanelAPI", "Exception tracking event " + r0.m4665a(), e);
                            a = -1;
                        }
                        i = a;
                    } else if (message.what == C2015a.f2810f) {
                        this.f2796a.f2801a.m4683a("Flushing queue due to scheduled or forced flush");
                        this.f2796a.m4677b();
                        this.f2800e.m4711a(this.f2796a.f2801a.m4697b());
                        m4670a(this.f2797b);
                    } else if (message.what == C2015a.f2812h) {
                        this.f2796a.f2801a.m4683a("Installing a check for surveys and in app notifications");
                        this.f2800e.m4710a((C2024e) message.obj);
                        this.f2800e.m4711a(this.f2796a.f2801a.m4697b());
                    } else if (message.what == C2015a.f2811g) {
                        Log.w("MixpanelAPI", "Worker received a hard kill. Dumping all events and force-killing. Thread id " + Thread.currentThread().getId());
                        synchronized (this.f2796a.f2802b) {
                            this.f2797b.m4621a();
                            this.f2796a.f2803c = null;
                            Looper.myLooper().quit();
                        }
                    } else {
                        Log.e("MixpanelAPI", "Unexpected message received by Mixpanel worker: " + message);
                    }
                    if (i >= this.f2796a.f2801a.f2818c.m4730a()) {
                        this.f2796a.f2801a.m4683a("Flushing queue due to bulk upload limit");
                        this.f2796a.m4677b();
                        m4670a(this.f2797b);
                    } else if (i > 0 && !hasMessages(C2015a.f2810f)) {
                        this.f2796a.f2801a.m4683a("Queue depth " + i + " - Adding flush in " + this.f2798c);
                        if (this.f2798c >= 0) {
                            sendEmptyMessageDelayed(C2015a.f2810f, this.f2798c);
                        }
                    }
                } catch (Throwable e2) {
                    Log.e("MixpanelAPI", "Worker threw an unhandled exception", e2);
                    synchronized (this.f2796a.f2802b) {
                    }
                    this.f2796a.f2803c = null;
                    try {
                        Looper.myLooper().quit();
                        Log.e("MixpanelAPI", "Mixpanel will not process any more analytics messages", e2);
                    } catch (Throwable e22) {
                        Log.e("MixpanelAPI", "Could not halt looper", e22);
                    }
                }
            }

            private void m4670a(MPDbAdapter mPDbAdapter) {
                if (this.f2796a.f2801a.m4697b().m4814a(this.f2796a.f2801a.f2817b)) {
                    this.f2796a.f2801a.m4683a("Sending records to Mixpanel");
                    if (this.f2799d) {
                        m4671a(mPDbAdapter, Table.EVENTS, new String[]{this.f2796a.f2801a.f2818c.m4735f()});
                        m4671a(mPDbAdapter, Table.PEOPLE, new String[]{this.f2796a.f2801a.f2818c.m4736g()});
                        return;
                    }
                    m4671a(mPDbAdapter, Table.EVENTS, new String[]{this.f2796a.f2801a.f2818c.m4735f(), this.f2796a.f2801a.f2818c.m4738i()});
                    m4671a(mPDbAdapter, Table.PEOPLE, new String[]{this.f2796a.f2801a.f2818c.m4736g(), this.f2796a.f2801a.f2818c.m4739j()});
                    return;
                }
                this.f2796a.f2801a.m4683a("Not flushing data to Mixpanel because the device is not connected to the internet.");
            }

            private void m4671a(MPDbAdapter mPDbAdapter, Table table, String[] strArr) {
                C2047l b = this.f2796a.f2801a.m4697b();
                String[] a = mPDbAdapter.m4624a(table);
                if (a != null) {
                    String str = a[0];
                    String str2 = a[1];
                    String a2 = C1991b.m4586a(str2);
                    List arrayList = new ArrayList(1);
                    arrayList.add(new BasicNameValuePair(ShareConstants.WEB_DIALOG_PARAM_DATA, a2));
                    if (C2031g.f2854a) {
                        arrayList.add(new BasicNameValuePair("verbose", AppEventsConstants.EVENT_PARAM_VALUE_YES));
                    }
                    Object obj = 1;
                    int length = strArr.length;
                    int i = 0;
                    while (i < length) {
                        String str3 = strArr[i];
                        try {
                            byte[] a3 = b.m4816a(str3, arrayList);
                            obj = 1;
                            if (a3 != null) {
                                String str4 = new String(a3, HTTP.UTF_8);
                                this.f2796a.f2801a.m4683a("Successfully posted to " + str3 + ": \n" + str2);
                                this.f2796a.f2801a.m4683a("Response was " + str4);
                                break;
                            } else if (C2031g.f2854a) {
                                Log.d("MixpanelAPI", "Response was null, unexpected failure posting to " + str3 + ".");
                            }
                        } catch (Throwable e) {
                            throw new RuntimeException("UTF not supported on this platform?", e);
                        } catch (Throwable e2) {
                            Log.e("MixpanelAPI", "Out of memory when posting to " + str3 + ".", e2);
                        } catch (Throwable e22) {
                            Log.e("MixpanelAPI", "Cannot interpret " + str3 + " as a URL.", e22);
                        } catch (Throwable e222) {
                            if (C2031g.f2854a) {
                                Log.d("MixpanelAPI", "Cannot post message to " + str3 + ".", e222);
                            }
                            obj = null;
                            i++;
                        }
                    }
                    if (obj != null) {
                        this.f2796a.f2801a.m4683a("Not retrying this batch of events, deleting them from DB.");
                        mPDbAdapter.m4623a(str, table);
                        return;
                    }
                    this.f2796a.f2801a.m4683a("Retrying this batch of events.");
                    if (!hasMessages(C2015a.f2810f)) {
                        sendEmptyMessageDelayed(C2015a.f2810f, this.f2798c);
                    }
                }
            }

            private JSONObject m4668a() throws JSONException {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("mp_lib", "android");
                jSONObject.put("$lib_version", "4.3.1");
                jSONObject.put("$os", "Android");
                jSONObject.put("$os_version", VERSION.RELEASE == null ? "UNKNOWN" : VERSION.RELEASE);
                jSONObject.put("$manufacturer", Build.MANUFACTURER == null ? "UNKNOWN" : Build.MANUFACTURER);
                jSONObject.put("$brand", Build.BRAND == null ? "UNKNOWN" : Build.BRAND);
                jSONObject.put("$model", Build.MODEL == null ? "UNKNOWN" : Build.MODEL);
                DisplayMetrics d = this.f2796a.f2807g.m4822d();
                jSONObject.put("$screen_dpi", d.densityDpi);
                jSONObject.put("$screen_height", d.heightPixels);
                jSONObject.put("$screen_width", d.widthPixels);
                String a = this.f2796a.f2807g.m4819a();
                if (a != null) {
                    jSONObject.put("$app_version", a);
                }
                Boolean valueOf = Boolean.valueOf(this.f2796a.f2807g.m4820b());
                if (valueOf != null) {
                    jSONObject.put("$has_nfc", valueOf.booleanValue());
                }
                valueOf = Boolean.valueOf(this.f2796a.f2807g.m4821c());
                if (valueOf != null) {
                    jSONObject.put("$has_telephone", valueOf.booleanValue());
                }
                a = this.f2796a.f2807g.m4823e();
                if (a != null) {
                    jSONObject.put("$carrier", a);
                }
                valueOf = this.f2796a.f2807g.m4824f();
                if (valueOf != null) {
                    jSONObject.put("$wifi", valueOf.booleanValue());
                }
                valueOf = this.f2796a.f2807g.m4825g();
                if (valueOf != null) {
                    jSONObject.put("$bluetooth_enabled", valueOf);
                }
                a = this.f2796a.f2807g.m4826h();
                if (a != null) {
                    jSONObject.put("$bluetooth_version", a);
                }
                return jSONObject;
            }

            private JSONObject m4669a(C2012a c2012a) throws JSONException {
                JSONObject jSONObject = new JSONObject();
                JSONObject b = c2012a.m4666b();
                JSONObject a = m4668a();
                a.put("token", c2012a.m4667c());
                if (b != null) {
                    Iterator keys = b.keys();
                    while (keys.hasNext()) {
                        String str = (String) keys.next();
                        a.put(str, b.get(str));
                    }
                }
                jSONObject.put(DataLayer.EVENT_KEY, c2012a.m4665a());
                jSONObject.put("properties", a);
                return jSONObject;
            }
        }

        public C2014b(C2015a c2015a) {
            this.f2801a = c2015a;
            this.f2802b = new Object();
            this.f2804d = 0;
            this.f2805e = 0;
            this.f2806f = -1;
            this.f2803c = m4672a();
        }

        public void m4679a(Message message) {
            synchronized (this.f2802b) {
                if (this.f2803c == null) {
                    this.f2801a.m4683a("Dead mixpanel worker dropping a message: " + message.what);
                } else {
                    this.f2803c.sendMessage(message);
                }
            }
        }

        private Handler m4672a() {
            HandlerThread handlerThread = new HandlerThread("com.mixpanel.android.AnalyticsWorker", 1);
            handlerThread.start();
            return new C2013a(this, handlerThread.getLooper());
        }

        private void m4677b() {
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.f2804d + 1;
            if (this.f2806f > 0) {
                this.f2805e = ((currentTimeMillis - this.f2806f) + (this.f2805e * this.f2804d)) / j;
                this.f2801a.m4683a("Average send frequency approximately " + (this.f2805e / 1000) + " seconds.");
            }
            this.f2806f = currentTimeMillis;
            this.f2804d = j;
        }
    }

    C2015a(Context context) {
        this.f2817b = context;
        this.f2818c = m4698c(context);
        this.f2816a = new C2014b(this);
    }

    public static C2015a m4681a(Context context) {
        C2015a c2015a;
        synchronized (f2815k) {
            Context applicationContext = context.getApplicationContext();
            if (f2815k.containsKey(applicationContext)) {
                c2015a = (C2015a) f2815k.get(applicationContext);
            } else {
                c2015a = new C2015a(applicationContext);
                f2815k.put(applicationContext, c2015a);
            }
        }
        return c2015a;
    }

    public void m4693a(C2012a c2012a) {
        Message obtain = Message.obtain();
        obtain.what = f2809e;
        obtain.obj = c2012a;
        this.f2816a.m4679a(obtain);
    }

    public void m4695a(JSONObject jSONObject) {
        Message obtain = Message.obtain();
        obtain.what = f2808d;
        obtain.obj = jSONObject;
        this.f2816a.m4679a(obtain);
    }

    public void m4692a() {
        Message obtain = Message.obtain();
        obtain.what = f2810f;
        this.f2816a.m4679a(obtain);
    }

    public void m4694a(C2024e c2024e) {
        Message obtain = Message.obtain();
        obtain.what = f2812h;
        obtain.obj = c2024e;
        this.f2816a.m4679a(obtain);
    }

    protected MPDbAdapter m4696b(Context context) {
        return new MPDbAdapter(context);
    }

    protected C2031g m4698c(Context context) {
        return C2031g.m4728a(context);
    }

    protected C2047l m4697b() {
        return new C2047l();
    }

    private void m4683a(String str) {
        if (C2031g.f2854a) {
            Log.d("MixpanelAPI", str + " (Thread " + Thread.currentThread().getId() + ")");
        }
    }

    static {
        f2808d = 0;
        f2809e = 1;
        f2810f = 2;
        f2811g = 5;
        f2812h = 12;
        f2813i = 4;
        f2814j = 10;
        f2815k = new HashMap();
    }
}
