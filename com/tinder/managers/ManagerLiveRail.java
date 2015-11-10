package com.tinder.managers;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.telephony.TelephonyManager;
import com.android.volley.C0307i.C0305a;
import com.android.volley.C0307i.C0306b;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.C0339m;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.tinder.R;
import com.tinder.model.UserMeta;
import com.tinder.utils.C3064c;
import com.tinder.utils.C3064c.C2669b;
import com.tinder.utils.C3069h;
import com.tinder.utils.C3095y;
import com.tinder.utils.af;
import com.tinder.utils.al;
import java.io.StringReader;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import org.xml.sax.InputSource;

public class ManagerLiveRail {
    @NonNull
    private static String f5628A;
    @NonNull
    private static String f5629B;
    @NonNull
    private static String f5630C;
    @NonNull
    private static String f5631D;
    @NonNull
    private static String f5632E;
    @NonNull
    private static String f5633F;
    @NonNull
    private static String f5634G;
    @NonNull
    private static String f5635H;
    @NonNull
    private static String f5636s;
    @NonNull
    private static String f5637t;
    @NonNull
    private static String f5638u;
    @NonNull
    private static String f5639v;
    @NonNull
    private static String f5640w;
    @NonNull
    private static String f5641x;
    @NonNull
    private static String f5642y;
    @NonNull
    private static String f5643z;
    private boolean f5644I;
    private String f5645J;
    private boolean f5646K;
    Context f5647a;
    @Nullable
    String f5648b;
    @Nullable
    String f5649c;
    @Nullable
    String f5650d;
    @Nullable
    String f5651e;
    @Nullable
    String f5652f;
    @Nullable
    String f5653g;
    @Nullable
    String f5654h;
    @Nullable
    String f5655i;
    @Nullable
    String f5656j;
    @Nullable
    String f5657k;
    @Nullable
    String f5658l;
    @NonNull
    String f5659m;
    int f5660n;
    XPath f5661o;
    String f5662p;
    @NonNull
    C3069h f5663q;
    @NonNull
    C3069h f5664r;

    /* renamed from: com.tinder.managers.ManagerLiveRail.1 */
    class C27761 implements C2669b {
        final /* synthetic */ ManagerLiveRail f5605a;

        /* renamed from: com.tinder.managers.ManagerLiveRail.1.1 */
        class C27751 extends HashMap<String, String> {
            final /* synthetic */ C27761 f5604a;

            C27751(C27761 c27761) throws RuntimeException, Error {
                int i = 0;
                this.f5604a = c27761;
                put("LR_WIDTH", String.valueOf(al.m9262a(this.f5604a.f5605a.f5647a)));
                put("LR_HEIGHT", String.valueOf(al.m9285b(this.f5604a.f5605a.f5647a)));
                put("LR_FORMAT", "video/webm");
                put("LR_SCHEMA", "vast2");
                put("LR_ADTYPE", "3");
                try {
                    Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.f5604a.f5605a.f5647a);
                    put("LR_IDFA", advertisingIdInfo.getId());
                    String str = "LR_IDFA_FLAG";
                    if (!advertisingIdInfo.isLimitAdTrackingEnabled()) {
                        i = 1;
                    }
                    put(str, String.valueOf(i));
                } catch (Throwable e) {
                    C3095y.m9474a("Failed to connect to Google Play Services", e);
                } catch (Throwable e2) {
                    C3095y.m9474a("A recoverable Google Play Services issue occured", e2);
                } catch (Throwable e22) {
                    C3095y.m9474a("Google Play Services are not available", e22);
                }
                put("LR_OS", "Android");
                put("LR_OS_VERSION", VERSION.RELEASE);
                put("LR_BUNDLE", "com.cardify.tinder");
                put("LR_APPNAME", this.f5604a.f5605a.f5647a.getResources().getString(R.string.app_name));
                try {
                    put("LR_APPVERS", this.f5604a.f5605a.f5647a.getPackageManager().getPackageInfo(this.f5604a.f5605a.f5647a.getPackageName(), 0).versionName);
                } catch (NameNotFoundException e3) {
                    put("LR_APPVERS", String.valueOf(833));
                }
                put("LR_CARRIER", ((TelephonyManager) this.f5604a.f5605a.f5647a.getSystemService("phone")).getNetworkOperatorName());
                put("LR_MAKE", Build.MANUFACTURER);
                put("LR_MODEL", Build.MODEL);
                put("LR_PUBLISHER_ID", String.valueOf(94567));
            }
        }

        C27761(ManagerLiveRail managerLiveRail) {
            this.f5605a = managerLiveRail;
        }

        public void m7940a() {
            HashMap c27751 = new C27751(this);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(ManagerLiveRail.f5636s);
            for (Entry entry : c27751.entrySet()) {
                stringBuilder.append((String) entry.getKey());
                stringBuilder.append('=');
                stringBuilder.append(URLEncoder.encode((String) entry.getValue()).replace("+", "%20"));
                stringBuilder.append('&');
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            this.f5605a.f5645J = stringBuilder.toString();
            this.f5605a.m7955K();
        }
    }

    /* renamed from: com.tinder.managers.ManagerLiveRail.2 */
    class C27782 implements C0306b<String> {
        final /* synthetic */ ManagerLiveRail f5607a;

        /* renamed from: com.tinder.managers.ManagerLiveRail.2.1 */
        class C27771 extends ArrayList<Object> {
            final /* synthetic */ C27782 f5606a;

            C27771(C27782 c27782) {
                this.f5606a = c27782;
                add(Integer.valueOf(this.f5606a.f5607a.f5660n));
                add(this.f5606a.f5607a.f5654h);
                add(this.f5606a.f5607a.f5655i);
                add(this.f5606a.f5607a.f5659m);
            }
        }

        C27782(ManagerLiveRail managerLiveRail) {
            this.f5607a = managerLiveRail;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void m7942a(java.lang.String r8) {
            /*
            r7 = this;
            r1 = 0;
            r0 = "Successfully retrieved LiveRail manifest";
            com.tinder.utils.C3095y.m9485e(r0);
            r0 = r7.f5607a;
            r0.f5662p = r8;
            r0 = r7.f5607a;
            r2 = javax.xml.xpath.XPathFactory.newInstance();
            r2 = r2.newXPath();
            r0.f5661o = r2;
            r0 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r0.m7953I();	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r2 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r3 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r3 = r3.f5661o;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r4 = com.tinder.managers.ManagerLiveRail.f5634G;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r5 = javax.xml.xpath.XPathConstants.STRING;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r3.evaluate(r4, r0, r5);	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = (java.lang.String) r0;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r2.f5659m = r0;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r0.m7953I();	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r2 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r3 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r3 = r3.f5661o;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r4 = com.tinder.managers.ManagerLiveRail.f5637t;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r5 = javax.xml.xpath.XPathConstants.STRING;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r3.evaluate(r4, r0, r5);	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = (java.lang.String) r0;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r2.f5648b = r0;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r0.m7953I();	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r2 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r3 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r3 = r3.f5661o;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r4 = com.tinder.managers.ManagerLiveRail.f5638u;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r5 = javax.xml.xpath.XPathConstants.STRING;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r3.evaluate(r4, r0, r5);	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = (java.lang.String) r0;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r2.f5649c = r0;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r0.m7953I();	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r2 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r3 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r3 = r3.f5661o;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r4 = com.tinder.managers.ManagerLiveRail.f5639v;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r5 = javax.xml.xpath.XPathConstants.STRING;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r3.evaluate(r4, r0, r5);	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = (java.lang.String) r0;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r2.f5650d = r0;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r0.m7953I();	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r2 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r3 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r3 = r3.f5661o;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r4 = com.tinder.managers.ManagerLiveRail.f5640w;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r5 = javax.xml.xpath.XPathConstants.STRING;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r3.evaluate(r4, r0, r5);	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = (java.lang.String) r0;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r2.f5651e = r0;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r0.m7953I();	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r2 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r3 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r3 = r3.f5661o;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r4 = com.tinder.managers.ManagerLiveRail.f5641x;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r5 = javax.xml.xpath.XPathConstants.STRING;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r3.evaluate(r4, r0, r5);	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = (java.lang.String) r0;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r2.f5653g = r0;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r0.m7953I();	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r2 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r3 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r3 = r3.f5661o;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r4 = com.tinder.managers.ManagerLiveRail.f5642y;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r5 = javax.xml.xpath.XPathConstants.STRING;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r3.evaluate(r4, r0, r5);	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = (java.lang.String) r0;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r2.f5654h = r0;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r2 = r0.m7953I();	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r3 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x014c, NullPointerException -> 0x0177 }
            r0 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x014c, NullPointerException -> 0x0177 }
            r0 = r0.f5661o;	 Catch:{ XPathExpressionException -> 0x014c, NullPointerException -> 0x0177 }
            r4 = com.tinder.managers.ManagerLiveRail.f5629B;	 Catch:{ XPathExpressionException -> 0x014c, NullPointerException -> 0x0177 }
            r5 = javax.xml.xpath.XPathConstants.STRING;	 Catch:{ XPathExpressionException -> 0x014c, NullPointerException -> 0x0177 }
            r0 = r0.evaluate(r4, r2, r5);	 Catch:{ XPathExpressionException -> 0x014c, NullPointerException -> 0x0177 }
            r0 = (java.lang.String) r0;	 Catch:{ XPathExpressionException -> 0x014c, NullPointerException -> 0x0177 }
            r3.f5658l = r0;	 Catch:{ XPathExpressionException -> 0x014c, NullPointerException -> 0x0177 }
        L_0x00e6:
            r0 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r0.f5658l;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            if (r0 != 0) goto L_0x0100;
        L_0x00ec:
            r3 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0170, NullPointerException -> 0x0177 }
            r0 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0170, NullPointerException -> 0x0177 }
            r0 = r0.f5661o;	 Catch:{ XPathExpressionException -> 0x0170, NullPointerException -> 0x0177 }
            r4 = com.tinder.managers.ManagerLiveRail.f5630C;	 Catch:{ XPathExpressionException -> 0x0170, NullPointerException -> 0x0177 }
            r5 = javax.xml.xpath.XPathConstants.STRING;	 Catch:{ XPathExpressionException -> 0x0170, NullPointerException -> 0x0177 }
            r0 = r0.evaluate(r4, r2, r5);	 Catch:{ XPathExpressionException -> 0x0170, NullPointerException -> 0x0177 }
            r0 = (java.lang.String) r0;	 Catch:{ XPathExpressionException -> 0x0170, NullPointerException -> 0x0177 }
            r3.f5658l = r0;	 Catch:{ XPathExpressionException -> 0x0170, NullPointerException -> 0x0177 }
        L_0x0100:
            r0 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r0.f5658l;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = com.tinder.utils.C3067g.m9353a(r0);	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            if (r0 == 0) goto L_0x010f;
        L_0x010a:
            r0 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r2 = 0;
            r0.f5658l = r2;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
        L_0x010f:
            r0 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r0.m7953I();	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r2 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r2 = r2.f5661o;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r3 = com.tinder.managers.ManagerLiveRail.f5643z;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r4 = javax.xml.xpath.XPathConstants.NODESET;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r2.evaluate(r3, r0, r4);	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = (org.w3c.dom.NodeList) r0;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r2 = r0.getLength();	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r2 = (float) r2;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
        L_0x012a:
            r3 = (float) r1;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r3 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1));
            if (r3 >= 0) goto L_0x01af;
        L_0x012f:
            r3 = r0.item(r1);	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r4 = r3.getAttributes();	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r5 = "type";
            r5 = r4.getNamedItem(r5);	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r5 = r5.getNodeValue();	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r6 = "video/webm";
            r5 = r5.equals(r6);	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            if (r5 != 0) goto L_0x0185;
        L_0x0149:
            r1 = r1 + 1;
            goto L_0x012a;
        L_0x014c:
            r0 = move-exception;
            r3 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r0.f5661o;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r4 = com.tinder.managers.ManagerLiveRail.f5630C;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r5 = javax.xml.xpath.XPathConstants.STRING;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r0.evaluate(r4, r2, r5);	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = (java.lang.String) r0;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r3.f5658l = r0;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            goto L_0x00e6;
        L_0x0162:
            r0 = move-exception;
            r0 = "Failed to process xpath";
            com.tinder.utils.C3095y.m9471a(r0);
            r0 = r7.f5607a;
            r0 = r0.f5664r;
            r0.m9356a();
        L_0x016f:
            return;
        L_0x0170:
            r0 = move-exception;
            r0 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r2 = 0;
            r0.f5658l = r2;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            goto L_0x0100;
        L_0x0177:
            r0 = move-exception;
            r0 = "Failed to process xpath";
            com.tinder.utils.C3095y.m9471a(r0);
            r0 = r7.f5607a;
            r0 = r0.f5664r;
            r0.m9356a();
            goto L_0x016f;
        L_0x0185:
            r5 = "width";
            r4 = r4.getNamedItem(r5);	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r4 = r4.getNodeValue();	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r4 = java.lang.Integer.parseInt(r4);	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r5 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r5 = r5.f5647a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r5 = com.tinder.utils.al.m9262a(r5);	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            if (r4 >= r5) goto L_0x01a6;
        L_0x019d:
            r4 = (float) r1;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r5 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
            r5 = r2 - r5;
            r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1));
            if (r4 != 0) goto L_0x0149;
        L_0x01a6:
            r4 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r3 = r3.getTextContent();	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r4.f5655i = r3;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            goto L_0x0149;
        L_0x01af:
            r0 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r0.m7953I();	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r1 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r2 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r2 = r2.f5661o;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r3 = com.tinder.managers.ManagerLiveRail.f5628A;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r4 = javax.xml.xpath.XPathConstants.STRING;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r2.evaluate(r3, r0, r4);	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = (java.lang.String) r0;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r1.f5652f = r0;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r0.m7953I();	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r1 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r2 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r2 = r2.f5661o;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r3 = com.tinder.managers.ManagerLiveRail.f5631D;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r4 = javax.xml.xpath.XPathConstants.STRING;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r2.evaluate(r3, r0, r4);	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = (java.lang.String) r0;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r1.f5656j = r0;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r0.m7953I();	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r1 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r2 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r2 = r2.f5661o;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r3 = com.tinder.managers.ManagerLiveRail.f5632E;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r4 = javax.xml.xpath.XPathConstants.STRING;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r2.evaluate(r3, r0, r4);	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = (java.lang.String) r0;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r1.f5657k = r0;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r0.m7953I();	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r1 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r1 = r1.f5661o;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r2 = com.tinder.managers.ManagerLiveRail.f5633F;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r3 = javax.xml.xpath.XPathConstants.STRING;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r1.evaluate(r2, r0, r3);	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = (java.lang.String) r0;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r1 = ":";
            r0 = r0.split(r1);	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r1 = r0.length;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r2 = 3;
            if (r1 == r2) goto L_0x0226;
        L_0x021d:
            r0 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r0.f5664r;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0.m9356a();	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            goto L_0x016f;
        L_0x0226:
            r1 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r2 = 0;
            r2 = r0[r2];	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r2 = java.lang.Integer.parseInt(r2);	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r2 = r2 * 60;
            r2 = r2 * 60;
            r1.f5660n = r2;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r1 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r2 = r1.f5660n;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r3 = 1;
            r3 = r0[r3];	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r3 = java.lang.Integer.parseInt(r3);	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r3 = r3 * 60;
            r2 = r2 + r3;
            r1.f5660n = r2;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r1 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r2 = r1.f5660n;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r3 = 2;
            r0 = r0[r3];	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = java.lang.Integer.parseInt(r0);	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r0 + r2;
            r1.f5660n = r0;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = new com.tinder.managers.ManagerLiveRail$2$1;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0.<init>(r7);	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r0.iterator();	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
        L_0x025c:
            r1 = r0.hasNext();	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            if (r1 == 0) goto L_0x0279;
        L_0x0262:
            r1 = r0.next();	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r1 = r1.toString();	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r1 = com.tinder.utils.C3067g.m9353a(r1);	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            if (r1 == 0) goto L_0x025c;
        L_0x0270:
            r0 = r7.f5607a;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0 = r0.f5664r;	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            r0.m9356a();	 Catch:{ XPathExpressionException -> 0x0162, NullPointerException -> 0x0177 }
            goto L_0x016f;
        L_0x0279:
            r0 = r7.toString();
            com.tinder.utils.C3095y.m9471a(r0);
            r0 = r7.f5607a;
            r0 = r0.f5663q;
            r0.m9356a();
            goto L_0x016f;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tinder.managers.ManagerLiveRail.2.a(java.lang.String):void");
        }
    }

    /* renamed from: com.tinder.managers.ManagerLiveRail.3 */
    class C27793 implements C0305a {
        final /* synthetic */ ManagerLiveRail f5608a;

        C27793(ManagerLiveRail managerLiveRail) {
            this.f5608a = managerLiveRail;
        }

        public void onErrorResponse(VolleyError volleyError) {
            C3095y.m9479c("Failed to get LiveRail manifest");
            this.f5608a.f5664r.m9356a();
        }
    }

    /* renamed from: com.tinder.managers.ManagerLiveRail.4 */
    class C27804 implements Runnable {
        final /* synthetic */ LiveRailEvent f5609a;
        final /* synthetic */ ManagerLiveRail f5610b;

        C27804(ManagerLiveRail managerLiveRail, LiveRailEvent liveRailEvent) {
            this.f5610b = managerLiveRail;
            this.f5609a = liveRailEvent;
        }

        public void run() {
            this.f5610b.m7967a(this.f5609a);
        }
    }

    /* renamed from: com.tinder.managers.ManagerLiveRail.5 */
    class C27815 implements C0306b<String> {
        final /* synthetic */ LiveRailEvent f5611a;
        final /* synthetic */ ManagerLiveRail f5612b;

        C27815(ManagerLiveRail managerLiveRail, LiveRailEvent liveRailEvent) {
            this.f5612b = managerLiveRail;
            this.f5611a = liveRailEvent;
        }

        public void m7944a(String str) {
            C3095y.m9471a(String.format("Got response to event %s from LiveRail", new Object[]{this.f5611a}));
        }
    }

    /* renamed from: com.tinder.managers.ManagerLiveRail.6 */
    class C27826 implements C0305a {
        final /* synthetic */ LiveRailEvent f5613a;
        final /* synthetic */ ManagerLiveRail f5614b;

        C27826(ManagerLiveRail managerLiveRail, LiveRailEvent liveRailEvent) {
            this.f5614b = managerLiveRail;
            this.f5613a = liveRailEvent;
        }

        public void onErrorResponse(VolleyError volleyError) {
            C3095y.m9471a(String.format("Got error for event %s", new Object[]{this.f5613a}));
        }
    }

    /* renamed from: com.tinder.managers.ManagerLiveRail.7 */
    class C27837 extends HashMap<String, String> {
        final /* synthetic */ ManagerLiveRail f5615a;

        C27837(ManagerLiveRail managerLiveRail) {
            this.f5615a = managerLiveRail;
            put("Magic Pixel URL", this.f5615a.f5659m);
            put("Campaign ID", this.f5615a.f5648b);
            put("Creative ID", this.f5615a.f5649c);
            put("Provider ID", this.f5615a.f5650d);
            put("Title", this.f5615a.f5651e);
            put("Subtitle", this.f5615a.f5653g);
            put("Clickthrough URL", this.f5615a.f5652f);
            put("Action button title", this.f5615a.f5654h);
            put("Video URL", this.f5615a.f5655i);
            put("Share text", this.f5615a.f5656j);
            put("Share URL", this.f5615a.f5657k);
            put("Partner logo URL", this.f5615a.f5658l);
            put("Callbacks for initialization", String.valueOf(this.f5615a.f5663q.m9358b()));
            put("Callbacks for failure", String.valueOf(this.f5615a.f5664r.m9358b()));
        }
    }

    public enum LiveRailEvent {
        impression,
        firstQuartile,
        midpoint,
        thirdQuartile,
        complete,
        mute,
        unmute,
        pause,
        resume,
        close,
        acceptInvitation
    }

    static {
        f5636s = "http://ad5.liverail.com/?";
        f5637t = "//Ad/@id";
        f5638u = "//Creative/@id";
        f5639v = "//Ad/InLine/AdSystem";
        f5640w = "//Companion[@width=1001]//HTMLResource";
        f5641x = "//Companion[@width=1002]//HTMLResource";
        f5642y = "//Companion[@width=1003]//HTMLResource";
        f5643z = "//Creative//MediaFiles/MediaFile";
        f5628A = "//VideoClicks/ClickThrough";
        f5629B = "//Companion//StaticResource[@creativeType='image/jpeg']";
        f5630C = "//Companion//StaticResource[@creativeType='image/png']";
        f5631D = "//Companion[@width=1004]//HTMLResource";
        f5632E = "//Companion[@width=1005]//HTMLResource";
        f5633F = "//Creative//Duration";
        f5634G = "//Ad//Impression[@id='LR']";
        f5635H = "//Linear/TrackingEvents/Tracking[@event='%s']";
    }

    public ManagerLiveRail(Context context) {
        this.f5663q = new C3069h();
        this.f5664r = new C3069h();
        this.f5646K = false;
        this.f5647a = context;
    }

    public void m7968a(Runnable runnable, boolean z) {
        this.f5664r.m9357a(runnable, z);
    }

    public void m7971b(Runnable runnable, boolean z) {
        this.f5663q.m9357a(runnable, z);
    }

    @NonNull
    private InputSource m7953I() {
        return new InputSource(new StringReader(this.f5662p));
    }

    private void m7954J() {
        if (!this.f5644I) {
            this.f5644I = true;
            C3064c.m9337a(new C27761(this)).m9341a();
        }
    }

    private void m7955K() {
        if (this.f5644I) {
            ManagerApp.m7915f().m5900a(new C0339m(0, this.f5645J, new C27782(this), new C27793(this)));
            return;
        }
        m7954J();
    }

    public void m7966a() {
        m7954J();
    }

    public void m7970b() {
        this.f5660n = 0;
        this.f5644I = false;
        this.f5659m = null;
        this.f5648b = null;
        this.f5649c = null;
        this.f5650d = null;
        this.f5651e = null;
        this.f5652f = null;
        this.f5653g = null;
        this.f5654h = null;
        this.f5655i = null;
        this.f5656j = null;
        this.f5657k = null;
        this.f5658l = null;
        this.f5663q.m9359c();
        this.f5664r.m9359c();
    }

    public void m7972c() {
        af.m9231b(this.f5655i);
    }

    public void m7967a(LiveRailEvent liveRailEvent) {
        if (this.f5644I) {
            Request c0339m;
            m7966a();
            try {
                C0306b c27815 = new C27815(this, liveRailEvent);
                C0305a c27826 = new C27826(this, liveRailEvent);
                if (liveRailEvent == LiveRailEvent.impression) {
                    c0339m = new C0339m(0, this.f5659m, c27815, c27826);
                } else {
                    c0339m = new C0339m(0, (String) this.f5661o.evaluate(String.format(f5635H, new Object[]{liveRailEvent}), m7953I(), XPathConstants.STRING), c27815, c27826);
                }
            } catch (Exception e) {
                C3095y.m9473a("Tinder", String.format("Failed to fire event %s", new Object[]{liveRailEvent}), e);
                this.f5664r.m9356a();
                c0339m = null;
            }
            if (c0339m != null) {
                ManagerApp.m7915f().m5900a(c0339m);
                return;
            } else {
                this.f5664r.m9356a();
                return;
            }
        }
        this.f5663q.m9357a(new C27804(this, liveRailEvent), true);
    }

    public double m7973d() {
        return (double) this.f5660n;
    }

    @Nullable
    public String m7974e() {
        return this.f5648b;
    }

    @Nullable
    public String m7975f() {
        return this.f5649c;
    }

    @Nullable
    public String m7976g() {
        return this.f5650d;
    }

    @Nullable
    public String m7977h() {
        return this.f5651e;
    }

    @Nullable
    public String m7978i() {
        return this.f5653g;
    }

    @Nullable
    public String m7979j() {
        return this.f5654h;
    }

    @Nullable
    public String m7980k() {
        return this.f5655i;
    }

    @Nullable
    public String m7981l() {
        return this.f5656j;
    }

    @Nullable
    public String m7982m() {
        return this.f5657k;
    }

    @Nullable
    public String m7983n() {
        return this.f5652f;
    }

    @Nullable
    public String m7984o() {
        return this.f5658l;
    }

    @NonNull
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Entry entry : new C27837(this).entrySet()) {
            stringBuffer.append(String.format("%s: %s\n", new Object[]{entry.getKey(), entry.getValue()}));
        }
        return stringBuffer.toString();
    }

    public boolean m7985p() {
        return this.f5646K;
    }

    public void m7969a(boolean z) {
        this.f5646K = z;
    }

    public boolean m7986q() {
        UserMeta c = ManagerApp.m7911b().m8142c();
        if (c == null || ManagerApp.m7914e().m8849i() < c.getGlobalConfig().getAdSwipeLimit() || c.getGlobalConfig().getAdSwipeLimit() == 0) {
            return false;
        }
        ManagerApp.m7914e();
        if ((!C2958p.aj() || this.f5646K) && this.f5655i != null) {
            return true;
        }
        return false;
    }

    public boolean m7987r() {
        UserMeta c = ManagerApp.m7911b().m8142c();
        if (c == null) {
            return false;
        }
        int adSwipeLimit = c.getGlobalConfig().getAdSwipeLimit();
        if (!ManagerApp.f5580c || ManagerApp.m7914e().m8849i() < adSwipeLimit / 2 || adSwipeLimit == 0) {
            return false;
        }
        ManagerApp.m7914e();
        if (!C2958p.aj() || this.f5646K) {
            return true;
        }
        return false;
    }

    public void m7988s() {
        UserMeta c = ManagerApp.m7911b().m8142c();
        if (c != null && ManagerApp.m7914e().m8849i() > c.getGlobalConfig().getAdSwipeLimit()) {
            ManagerApp.m7914e().m8846h();
        }
    }
}
