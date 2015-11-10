package com.google.android.gcm;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import android.util.Log;
import com.facebook.internal.NativeProtocol;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public abstract class GCMBaseIntentService extends IntentService {
    private static WakeLock f743a;
    private static final Object f744b;
    private static int f745d;
    private static final Random f746e;
    private static final int f747f;
    private static final String f748g;
    private final String[] f749c;

    protected abstract void m974a(Context context, Intent intent);

    protected abstract void m977b(Context context, String str);

    protected abstract void m978c(Context context, String str);

    protected abstract void m979d(Context context, String str);

    static {
        f744b = GCMBaseIntentService.class;
        f745d = 0;
        f746e = new Random();
        f747f = (int) TimeUnit.SECONDS.toMillis(3600);
        f748g = Long.toBinaryString(f746e.nextLong());
    }

    protected GCMBaseIntentService() {
        this(m969a("DynamicSenderIds"), null);
    }

    protected GCMBaseIntentService(String... strArr) {
        this(m970a(strArr), strArr);
    }

    private GCMBaseIntentService(String str, String[] strArr) {
        super(str);
        this.f749c = strArr;
    }

    private static String m969a(String str) {
        StringBuilder append = new StringBuilder().append("GCMIntentService-").append(str).append("-");
        int i = f745d + 1;
        f745d = i;
        String stringBuilder = append.append(i).toString();
        Log.v("GCMBaseIntentService", "Intent service name: " + stringBuilder);
        return stringBuilder;
    }

    private static String m970a(String[] strArr) {
        return m969a(C0707a.m983a(strArr));
    }

    protected String[] m976a(Context context) {
        if (this.f749c != null) {
            return this.f749c;
        }
        throw new IllegalStateException("sender id not set on constructor");
    }

    protected void m973a(Context context, int i) {
    }

    protected boolean m975a(Context context, String str) {
        return true;
    }

    public final void onHandleIntent(Intent intent) {
        String action;
        try {
            Context applicationContext = getApplicationContext();
            action = intent.getAction();
            if (action.equals("com.google.android.c2dm.intent.REGISTRATION")) {
                C0707a.m993e(applicationContext);
                m972b(applicationContext, intent);
            } else if (action.equals("com.google.android.c2dm.intent.RECEIVE")) {
                action = intent.getStringExtra("message_type");
                if (action == null) {
                    m974a(applicationContext, intent);
                } else if (action.equals("deleted_messages")) {
                    action = intent.getStringExtra("total_deleted");
                    if (action != null) {
                        int parseInt = Integer.parseInt(action);
                        Log.v("GCMBaseIntentService", "Received deleted messages notification: " + parseInt);
                        m973a(applicationContext, parseInt);
                    }
                } else {
                    Log.e("GCMBaseIntentService", "Received unknown special message: " + action);
                }
            } else if (action.equals("com.google.android.gcm.intent.RETRY")) {
                action = intent.getStringExtra("token");
                if (!f748g.equals(action)) {
                    Log.e("GCMBaseIntentService", "Received invalid token: " + action);
                    synchronized (f744b) {
                        if (f743a != null) {
                            Log.v("GCMBaseIntentService", "Releasing wakelock");
                            f743a.release();
                        } else {
                            Log.e("GCMBaseIntentService", "Wakelock reference is null");
                        }
                    }
                    return;
                } else if (C0707a.m995g(applicationContext)) {
                    C0707a.m992d(applicationContext);
                } else {
                    C0707a.m990b(applicationContext, m976a(applicationContext));
                }
            }
        } catch (NumberFormatException e) {
            Log.e("GCMBaseIntentService", "GCM returned invalid number of deleted messages: " + action);
        } catch (Throwable th) {
            synchronized (f744b) {
            }
            if (f743a != null) {
                Log.v("GCMBaseIntentService", "Releasing wakelock");
                f743a.release();
            } else {
                Log.e("GCMBaseIntentService", "Wakelock reference is null");
            }
        }
        synchronized (f744b) {
            if (f743a != null) {
                Log.v("GCMBaseIntentService", "Releasing wakelock");
                f743a.release();
            } else {
                Log.e("GCMBaseIntentService", "Wakelock reference is null");
            }
        }
    }

    static void m971a(Context context, Intent intent, String str) {
        synchronized (f744b) {
            if (f743a == null) {
                f743a = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "GCM_LIB");
            }
        }
        Log.v("GCMBaseIntentService", "Acquiring wakelock");
        f743a.acquire();
        intent.setClassName(context, str);
        context.startService(intent);
    }

    private void m972b(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("registration_id");
        String stringExtra2 = intent.getStringExtra(NativeProtocol.BRIDGE_ARG_ERROR_BUNDLE);
        String stringExtra3 = intent.getStringExtra("unregistered");
        Log.d("GCMBaseIntentService", "handleRegistration: registrationId = " + stringExtra + ", error = " + stringExtra2 + ", unregistered = " + stringExtra3);
        if (stringExtra != null) {
            C0707a.m997i(context);
            C0707a.m982a(context, stringExtra);
            m978c(context, stringExtra);
        } else if (stringExtra3 != null) {
            C0707a.m997i(context);
            m979d(context, C0707a.m996h(context));
        } else {
            Log.d("GCMBaseIntentService", "Registration error: " + stringExtra2);
            if (!"SERVICE_NOT_AVAILABLE".equals(stringExtra2)) {
                m977b(context, stringExtra2);
            } else if (m975a(context, stringExtra2)) {
                int j = C0707a.m998j(context);
                int nextInt = f746e.nextInt(j) + (j / 2);
                Log.d("GCMBaseIntentService", "Scheduling registration retry, backoff = " + nextInt + " (" + j + ")");
                Intent intent2 = new Intent("com.google.android.gcm.intent.RETRY");
                intent2.putExtra("token", f748g);
                ((AlarmManager) context.getSystemService(NotificationCompatApi21.CATEGORY_ALARM)).set(3, SystemClock.elapsedRealtime() + ((long) nextInt), PendingIntent.getBroadcast(context, 0, intent2, 0));
                if (j < f747f) {
                    C0707a.m985a(context, j * 2);
                }
            } else {
                Log.d("GCMBaseIntentService", "Not retrying failed operation");
            }
        }
    }
}
