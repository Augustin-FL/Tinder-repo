package com.mixpanel.android.mpmetrics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.mixpanel.android.mpmetrics.InAppNotification.Type;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.protocol.HTTP;

/* renamed from: com.mixpanel.android.mpmetrics.d */
class C2022d {
    private final C2031g f2829a;
    private final Context f2830b;
    private final List<C2024e> f2831c;

    /* renamed from: com.mixpanel.android.mpmetrics.d.a */
    static class C2021a {
        public final List<Survey> f2827a;
        public final List<InAppNotification> f2828b;

        public C2021a() {
            this.f2827a = new ArrayList();
            this.f2828b = new ArrayList();
        }
    }

    public C2022d(Context context, C2031g c2031g) {
        this.f2830b = context;
        this.f2829a = c2031g;
        this.f2831c = new LinkedList();
    }

    public void m4710a(C2024e c2024e) {
        this.f2831c.add(c2024e);
    }

    public void m4711a(C2047l c2047l) {
        Iterator it = this.f2831c.iterator();
        while (it.hasNext()) {
            C2024e c2024e = (C2024e) it.next();
            if (c2024e.m4718c()) {
                it.remove();
            } else {
                C2021a a = m4708a(c2024e.m4714a(), c2024e.m4717b(), c2047l);
                c2024e.m4715a(a.f2827a, a.f2828b);
            }
        }
    }

    private C2021a m4708a(String str, String str2, C2047l c2047l) {
        C2021a a;
        String b = m4709b(str, str2, c2047l);
        if (C2031g.f2854a) {
            Log.d("MixpanelAPI DecideChecker", "Mixpanel decide server response was:\n" + b);
        }
        C2021a c2021a = new C2021a();
        if (b != null) {
            a = C2022d.m4707a(b);
        } else {
            a = c2021a;
        }
        Iterator it = a.f2828b.iterator();
        while (it.hasNext()) {
            InAppNotification inAppNotification = (InAppNotification) it.next();
            Bitmap a2 = C2022d.m4706a(inAppNotification, this.f2830b, c2047l);
            if (a2 == null) {
                Log.i("MixpanelAPI DecideChecker", "Could not retrieve image for notification " + inAppNotification.m4603b() + ", will not show the notification.");
                it.remove();
            } else {
                inAppNotification.m4602a(a2);
            }
        }
        return a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.mixpanel.android.mpmetrics.C2022d.C2021a m4707a(java.lang.String r9) {
        /*
        r3 = 0;
        r1 = 0;
        r2 = new com.mixpanel.android.mpmetrics.d$a;
        r2.<init>();
        r5 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0035 }
        r5.<init>(r9);	 Catch:{ JSONException -> 0x0035 }
        r0 = "surveys";
        r0 = r5.has(r0);
        if (r0 == 0) goto L_0x0069;
    L_0x0014:
        r0 = "surveys";
        r0 = r5.getJSONArray(r0);	 Catch:{ JSONException -> 0x0050 }
        r4 = r0;
    L_0x001b:
        if (r4 == 0) goto L_0x00a7;
    L_0x001d:
        r0 = r1;
    L_0x001e:
        r6 = r4.length();
        if (r0 >= r6) goto L_0x00a7;
    L_0x0024:
        r6 = r4.getJSONObject(r0);	 Catch:{ JSONException -> 0x006b, BadDecideObjectException -> 0x0089 }
        r7 = new com.mixpanel.android.mpmetrics.Survey;	 Catch:{ JSONException -> 0x006b, BadDecideObjectException -> 0x0089 }
        r7.<init>(r6);	 Catch:{ JSONException -> 0x006b, BadDecideObjectException -> 0x0089 }
        r6 = r2.f2827a;	 Catch:{ JSONException -> 0x006b, BadDecideObjectException -> 0x0089 }
        r6.add(r7);	 Catch:{ JSONException -> 0x006b, BadDecideObjectException -> 0x0089 }
    L_0x0032:
        r0 = r0 + 1;
        goto L_0x001e;
    L_0x0035:
        r0 = move-exception;
        r1 = "MixpanelAPI DecideChecker";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Mixpanel endpoint returned unparsable result:\n";
        r3 = r3.append(r4);
        r3 = r3.append(r9);
        r3 = r3.toString();
        android.util.Log.e(r1, r3, r0);
        r0 = r2;
    L_0x004f:
        return r0;
    L_0x0050:
        r0 = move-exception;
        r0 = "MixpanelAPI DecideChecker";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r6 = "Mixpanel endpoint returned non-array JSON for surveys: ";
        r4 = r4.append(r6);
        r4 = r4.append(r5);
        r4 = r4.toString();
        android.util.Log.e(r0, r4);
    L_0x0069:
        r4 = r3;
        goto L_0x001b;
    L_0x006b:
        r6 = move-exception;
        r6 = "MixpanelAPI DecideChecker";
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = "Received a strange response from surveys service: ";
        r7 = r7.append(r8);
        r8 = r4.toString();
        r7 = r7.append(r8);
        r7 = r7.toString();
        android.util.Log.e(r6, r7);
        goto L_0x0032;
    L_0x0089:
        r6 = move-exception;
        r6 = "MixpanelAPI DecideChecker";
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = "Received a strange response from surveys service: ";
        r7 = r7.append(r8);
        r8 = r4.toString();
        r7 = r7.append(r8);
        r7 = r7.toString();
        android.util.Log.e(r6, r7);
        goto L_0x0032;
    L_0x00a7:
        r0 = "notifications";
        r0 = r5.has(r0);
        if (r0 == 0) goto L_0x00b6;
    L_0x00af:
        r0 = "notifications";
        r0 = r5.getJSONArray(r0);	 Catch:{ JSONException -> 0x00d6 }
        r3 = r0;
    L_0x00b6:
        if (r3 == 0) goto L_0x014a;
    L_0x00b8:
        r0 = r3.length();
        r4 = 2;
        r4 = java.lang.Math.min(r0, r4);
    L_0x00c1:
        if (r3 == 0) goto L_0x014a;
    L_0x00c3:
        if (r1 >= r4) goto L_0x014a;
    L_0x00c5:
        r0 = r3.getJSONObject(r1);	 Catch:{ JSONException -> 0x00f0, BadDecideObjectException -> 0x010e, OutOfMemoryError -> 0x012c }
        r5 = new com.mixpanel.android.mpmetrics.InAppNotification;	 Catch:{ JSONException -> 0x00f0, BadDecideObjectException -> 0x010e, OutOfMemoryError -> 0x012c }
        r5.<init>(r0);	 Catch:{ JSONException -> 0x00f0, BadDecideObjectException -> 0x010e, OutOfMemoryError -> 0x012c }
        r0 = r2.f2828b;	 Catch:{ JSONException -> 0x00f0, BadDecideObjectException -> 0x010e, OutOfMemoryError -> 0x012c }
        r0.add(r5);	 Catch:{ JSONException -> 0x00f0, BadDecideObjectException -> 0x010e, OutOfMemoryError -> 0x012c }
    L_0x00d3:
        r1 = r1 + 1;
        goto L_0x00c1;
    L_0x00d6:
        r0 = move-exception;
        r0 = "MixpanelAPI DecideChecker";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r6 = "Mixpanel endpoint returned non-array JSON for notifications: ";
        r4 = r4.append(r6);
        r4 = r4.append(r5);
        r4 = r4.toString();
        android.util.Log.e(r0, r4);
        goto L_0x00b6;
    L_0x00f0:
        r0 = move-exception;
        r5 = "MixpanelAPI DecideChecker";
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "Received a strange response from notifications service: ";
        r6 = r6.append(r7);
        r7 = r3.toString();
        r6 = r6.append(r7);
        r6 = r6.toString();
        android.util.Log.e(r5, r6, r0);
        goto L_0x00d3;
    L_0x010e:
        r0 = move-exception;
        r5 = "MixpanelAPI DecideChecker";
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "Received a strange response from notifications service: ";
        r6 = r6.append(r7);
        r7 = r3.toString();
        r6 = r6.append(r7);
        r6 = r6.toString();
        android.util.Log.e(r5, r6, r0);
        goto L_0x00d3;
    L_0x012c:
        r0 = move-exception;
        r5 = "MixpanelAPI DecideChecker";
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "Not enough memory to show load notification from package: ";
        r6 = r6.append(r7);
        r7 = r3.toString();
        r6 = r6.append(r7);
        r6 = r6.toString();
        android.util.Log.e(r5, r6, r0);
        goto L_0x00d3;
    L_0x014a:
        r0 = r2;
        goto L_0x004f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.d.a(java.lang.String):com.mixpanel.android.mpmetrics.d$a");
    }

    private String m4709b(String str, String str2, C2047l c2047l) {
        try {
            String encode = URLEncoder.encode(str, "utf-8");
            encode = "?version=1&lib=android&token=" + encode + "&distinct_id=" + URLEncoder.encode(str2, "utf-8");
            String[] strArr = new String[]{this.f2829a.m4737h() + encode, this.f2829a.m4740k() + encode};
            if (C2031g.f2854a) {
                Log.d("MixpanelAPI DecideChecker", "Querying decide server at " + strArr[0]);
                Log.d("MixpanelAPI DecideChecker", "    (with fallback " + strArr[1] + ")");
            }
            byte[] a = c2047l.m4815a(this.f2830b, strArr);
            if (a == null) {
                return null;
            }
            try {
                return new String(a, HTTP.UTF_8);
            } catch (Throwable e) {
                throw new RuntimeException("UTF not supported on this platform?", e);
            }
        } catch (Throwable e2) {
            throw new RuntimeException("Mixpanel library requires utf-8 string encoding to be available", e2);
        }
    }

    private static Bitmap m4706a(InAppNotification inAppNotification, Context context, C2047l c2047l) {
        String[] strArr = (inAppNotification.m4605d() != Type.TAKEOVER || C2022d.m4705a(((WindowManager) context.getSystemService("window")).getDefaultDisplay()) < 720) ? new String[]{inAppNotification.m4608g()} : new String[]{inAppNotification.m4609h(), inAppNotification.m4608g()};
        byte[] a = c2047l.m4815a(context, strArr);
        if (a != null) {
            return BitmapFactory.decodeByteArray(a, 0, a.length);
        }
        Log.i("MixpanelAPI DecideChecker", "Failed to download images from " + Arrays.toString(strArr));
        return null;
    }

    @SuppressLint({"NewApi"})
    private static int m4705a(Display display) {
        if (VERSION.SDK_INT < 13) {
            return display.getWidth();
        }
        Point point = new Point();
        display.getSize(point);
        return point.x;
    }
}
