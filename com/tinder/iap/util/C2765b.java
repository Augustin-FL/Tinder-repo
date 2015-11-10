package com.tinder.iap.util;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.android.vending.billing.IInAppBillingService;
import com.android.vending.billing.IInAppBillingService.Stub;
import com.facebook.stetho.BuildConfig;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.tinder.utils.C3095y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

/* renamed from: com.tinder.iap.util.b */
public class C2765b {
    boolean f5530a;
    String f5531b;
    boolean f5532c;
    boolean f5533d;
    boolean f5534e;
    volatile boolean f5535f;
    volatile boolean f5536g;
    String f5537h;
    @Nullable
    Context f5538i;
    @Nullable
    IInAppBillingService f5539j;
    @Nullable
    C2764d f5540k;
    int f5541l;
    String f5542m;
    @Nullable
    String f5543n;
    @Nullable
    C2761a f5544o;
    private String f5545p;

    /* renamed from: com.tinder.iap.util.b.1 */
    class C27601 implements Runnable {
        final /* synthetic */ boolean f5521a;
        final /* synthetic */ List f5522b;
        final /* synthetic */ List f5523c;
        final /* synthetic */ Handler f5524d;
        final /* synthetic */ C2763c f5525e;
        final /* synthetic */ C2765b f5526f;

        /* renamed from: com.tinder.iap.util.b.1.1 */
        class C27591 implements Runnable {
            final /* synthetic */ C2766c f5518a;
            final /* synthetic */ C2767d f5519b;
            final /* synthetic */ C27601 f5520c;

            C27591(C27601 c27601, C2766c c2766c, C2767d c2767d) {
                this.f5520c = c27601;
                this.f5518a = c2766c;
                this.f5519b = c2767d;
            }

            public void run() {
                this.f5520c.f5525e.m7843a(this.f5518a, this.f5519b);
            }
        }

        C27601(C2765b c2765b, boolean z, List list, List list2, Handler handler, C2763c c2763c) {
            this.f5526f = c2765b;
            this.f5521a = z;
            this.f5522b = list;
            this.f5523c = list2;
            this.f5524d = handler;
            this.f5525e = c2763c;
        }

        public void run() {
            C2766c c2766c = new C2766c(0, "Inventory refresh successful.");
            C2767d c2767d = null;
            try {
                c2767d = this.f5526f.m7851a(this.f5521a, this.f5522b, this.f5523c);
            } catch (Throwable e) {
                C3095y.m9474a("Failed to query inventory", e);
                c2766c = e.m7836a();
            }
            this.f5526f.m7862b();
            if (!this.f5526f.f5533d) {
                this.f5524d.post(new C27591(this, c2766c, c2767d));
            }
        }
    }

    /* renamed from: com.tinder.iap.util.b.a */
    public interface C2761a {
        void m7841a(C2766c c2766c, @Nullable C2768e c2768e);
    }

    /* renamed from: com.tinder.iap.util.b.b */
    public interface C2762b {
        void m7842a(C2766c c2766c);
    }

    /* renamed from: com.tinder.iap.util.b.c */
    public interface C2763c {
        void m7843a(C2766c c2766c, C2767d c2767d);
    }

    /* renamed from: com.tinder.iap.util.b.d */
    private class C2764d implements ServiceConnection {
        final /* synthetic */ C2765b f5527a;
        private boolean f5528b;
        private final C2762b f5529c;

        public C2764d(C2765b c2765b, @NonNull C2762b c2762b) {
            this.f5527a = c2765b;
            this.f5529c = c2762b;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (!this.f5527a.f5533d) {
                this.f5528b = true;
                this.f5527a.m7865c("Billing service connected.");
                this.f5527a.f5539j = Stub.m209a(iBinder);
                try {
                    this.f5527a.m7865c("Checking for in-app billing 3 support.");
                    if (this.f5527a.f5539j == null) {
                        this.f5527a.m7865c("service is null.");
                        return;
                    }
                    int a = this.f5527a.f5539j.m199a(3, this.f5527a.f5545p, "inapp");
                    if (a != 0) {
                        this.f5529c.m7842a(new C2766c(a, "Error checking for billing v3 support."));
                        this.f5527a.f5534e = false;
                        return;
                    }
                    this.f5527a.m7865c("In-app billing version 3 supported for " + this.f5527a.f5545p);
                    a = this.f5527a.f5539j.m199a(3, this.f5527a.f5545p, "subs");
                    if (a == 0) {
                        this.f5527a.m7865c("Subscriptions AVAILABLE.");
                        this.f5527a.f5534e = true;
                    } else {
                        this.f5527a.m7865c("Subscriptions NOT AVAILABLE. Response: " + a);
                    }
                    this.f5527a.f5532c = true;
                    this.f5529c.m7842a(new C2766c(0, "Setup successful."));
                } catch (Throwable e) {
                    this.f5529c.m7842a(new C2766c(-1001, "RemoteException while setting up in-app billing."));
                    C3095y.m9474a("Failed to set up in app billing", e);
                    this.f5527a.f5532c = false;
                }
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            this.f5527a.m7865c("Billing service disconnected.");
            this.f5527a.m7852a();
            this.f5528b = false;
        }

        public boolean m7844a() {
            return this.f5528b;
        }
    }

    public C2765b(@NonNull Context context, @Nullable String str) {
        this.f5530a = false;
        this.f5531b = "IabHelper";
        this.f5532c = false;
        this.f5533d = false;
        this.f5534e = false;
        this.f5535f = false;
        this.f5536g = false;
        this.f5537h = BuildConfig.FLAVOR;
        this.f5543n = null;
        this.f5538i = context.getApplicationContext();
        this.f5543n = str;
        this.f5545p = this.f5538i.getPackageName();
        m7865c("IAB helper created.");
    }

    public static String m7845a(int i) {
        String[] split = "0:OK/1:User Canceled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned".split("/");
        String[] split2 = "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error/-1009:Subscriptions not available/-1010:Invalid consumption attempt".split("/");
        if (i <= -1000) {
            int i2 = -1000 - i;
            if (i2 < 0 || i2 >= split2.length) {
                return String.valueOf(i) + ":Unknown IAB Helper Error";
            }
            return split2[i2];
        } else if (i < 0 || i >= split.length) {
            return String.valueOf(i) + ":Unknown";
        } else {
            return split[i];
        }
    }

    public void m7859a(boolean z) {
        this.f5530a = z;
    }

    public void m7855a(@NonNull C2762b c2762b) {
        if (this.f5533d || this.f5532c) {
            C3095y.m9479c("IAB helper is already set up.");
            c2762b.m7842a(new C2766c(-1000, "IabHelper disposed or IS already setup"));
        } else if (this.f5538i == null) {
            C3095y.m9479c("Cannot setup IABHelper with a null context.");
            c2762b.m7842a(new C2766c(-1000, "IabHelper has a nul context set"));
        } else {
            m7865c("Starting in-app billing setup.");
            this.f5540k = new C2764d(this, c2762b);
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE);
            if (this.f5538i == null || this.f5538i.getPackageManager().queryIntentServices(intent, 0) == null || this.f5538i.getPackageManager().queryIntentServices(intent, 0).isEmpty()) {
                c2762b.m7842a(new C2766c(3, "Billing service unavailable on device."));
            } else {
                this.f5538i.bindService(intent, this.f5540k, 1);
            }
        }
    }

    public void m7852a() {
        if (this.f5535f) {
            this.f5536g = true;
        }
        m7865c("Disposing.");
        if (this.f5532c) {
            this.f5532c = false;
            if (this.f5540k != null) {
                m7865c("Unbinding from service.");
                if (this.f5538i != null && this.f5540k.m7844a()) {
                    this.f5538i.unbindService(this.f5540k);
                }
            }
        }
        this.f5533d = true;
        this.f5538i = null;
        this.f5540k = null;
        this.f5539j = null;
        this.f5544o = null;
    }

    public void m7853a(@NonNull Activity activity, String str, int i, C2761a c2761a, String str2) {
        m7854a(activity, str, "inapp", i, c2761a, str2);
    }

    public void m7863b(@NonNull Activity activity, String str, int i, C2761a c2761a, String str2) {
        m7854a(activity, str, "subs", i, c2761a, str2);
    }

    public void m7854a(@NonNull Activity activity, String str, @NonNull String str2, int i, @Nullable C2761a c2761a, String str3) {
        C2766c c2766c;
        if (this.f5533d) {
            c2766c = new C2766c(-1000, "IabHelper disposed");
            if (c2761a != null) {
                c2761a.m7841a(c2766c, null);
                return;
            }
            return;
        }
        m7857a("launchPurchaseFlow");
        m7864b("launchPurchaseFlow");
        if (!str2.equals("subs") || this.f5534e) {
            try {
                m7865c("Constructing buy intent for " + str + ", item type: " + str2);
                if (this.f5539j == null || this.f5538i == null) {
                    m7867d("Service connection and or context was null, unable to construct intents.");
                    if (c2761a != null) {
                        c2761a.m7841a(new C2766c(-1008, "Connection or context was null"), null);
                        return;
                    }
                    return;
                }
                Bundle a = this.f5539j.m202a(3, this.f5538i.getPackageName(), str, str2, str3);
                int a2 = m7848a(a);
                if (a2 != 0) {
                    m7867d("Unable to buy item, Error response: " + C2765b.m7845a(a2));
                    m7862b();
                    c2766c = new C2766c(a2, "Unable to buy item");
                    if (c2761a != null) {
                        c2761a.m7841a(c2766c, null);
                        return;
                    }
                    return;
                }
                PendingIntent pendingIntent = (PendingIntent) a.getParcelable("BUY_INTENT");
                m7865c("Launching buy intent for " + str + ". Request code: " + i);
                this.f5541l = i;
                this.f5544o = c2761a;
                this.f5542m = str2;
                if (pendingIntent != null) {
                    activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
                    return;
                }
                m7867d("Failed to get pending intent for the purchase.");
                return;
            } catch (Throwable e) {
                m7858a("SendIntentException while launching purchase flow for sku " + str, e);
                m7862b();
                c2766c = new C2766c(-1004, "Failed to send intent.");
                if (c2761a != null) {
                    c2761a.m7841a(c2766c, null);
                    return;
                }
                return;
            } catch (Throwable e2) {
                m7858a("RemoteException while launching purchase flow for sku " + str, e2);
                m7862b();
                c2766c = new C2766c(-1001, "Remote exception while starting purchase flow");
                if (c2761a != null) {
                    c2761a.m7841a(c2766c, null);
                    return;
                }
                return;
            }
        }
        c2766c = new C2766c(-1009, "Subscriptions are not available.");
        m7862b();
        if (c2761a != null) {
            c2761a.m7841a(c2766c, null);
        }
    }

    public boolean m7861a(int i, int i2, @Nullable Intent intent) {
        if (i != this.f5541l) {
            return false;
        }
        if (this.f5533d) {
            if (this.f5544o != null) {
                this.f5544o.m7841a(new C2766c(-1000, "IabHelper disposed"), null);
            }
            return true;
        }
        m7857a("handleActivityResult");
        m7862b();
        C2766c c2766c;
        if (intent == null) {
            m7867d("Null data in IAB activity result.");
            c2766c = new C2766c(-1002, "Null data in IAB result");
            if (this.f5544o != null) {
                this.f5544o.m7841a(c2766c, null);
            }
            return true;
        }
        int a = m7847a(intent);
        String stringExtra = intent.getStringExtra("INAPP_PURCHASE_DATA");
        String stringExtra2 = intent.getStringExtra("INAPP_DATA_SIGNATURE");
        if (i2 == -1 && a == 0) {
            m7865c("Successful resultcode from purchase activity.");
            m7865c("Purchase data: " + stringExtra);
            m7865c("Data signature: " + stringExtra2);
            m7865c("Extras: " + intent.getExtras());
            m7865c("Expected item type: " + this.f5542m);
            if (stringExtra == null || stringExtra2 == null) {
                m7867d("BUG: either purchaseData or dataSignature is null.");
                m7865c("Extras: " + intent.getExtras().toString());
                c2766c = new C2766c(-1008, "IAB returned null purchaseData or dataSignature");
                if (this.f5544o != null) {
                    this.f5544o.m7841a(c2766c, null);
                }
                return true;
            }
            try {
                C2768e c2768e = new C2768e(this.f5542m, stringExtra, stringExtra2);
                String b = c2768e.m7879b();
                if (this.f5543n == null || !C2769f.m7884a(this.f5543n, stringExtra, stringExtra2)) {
                    m7867d("Purchase signature verification FAILED for sku " + b);
                    c2766c = new C2766c(-1003, "Signature verification failed for sku " + b);
                    if (this.f5544o != null) {
                        this.f5544o.m7841a(c2766c, c2768e);
                    }
                    return true;
                }
                m7865c("Purchase signature successfully verified.");
                if (this.f5544o != null) {
                    this.f5544o.m7841a(new C2766c(0, "Success"), c2768e);
                }
            } catch (Throwable e) {
                m7858a("Failed to parse purchase data.", e);
                c2766c = new C2766c(-1002, "Failed to parse purchase data.");
                if (this.f5544o != null) {
                    this.f5544o.m7841a(c2766c, null);
                }
                return true;
            }
        } else if (i2 == -1) {
            m7865c("Result code was OK but in-app billing response was not OK: " + C2765b.m7845a(a));
            if (this.f5544o != null) {
                this.f5544o.m7841a(new C2766c(a, "Problem purchashing item."), null);
            }
        } else if (i2 == 0) {
            m7865c("Purchase canceled - Response: " + C2765b.m7845a(a));
            c2766c = new C2766c(-1005, "User canceled.");
            if (this.f5544o != null) {
                this.f5544o.m7841a(c2766c, null);
            }
        } else {
            m7867d("Purchase failed. Result code: " + Integer.toString(i2) + ". Response: " + C2765b.m7845a(a));
            c2766c = new C2766c(-1006, "Unknown purchase response.");
            if (this.f5544o != null) {
                this.f5544o.m7841a(c2766c, null);
            }
        }
        return true;
    }

    @NonNull
    public C2767d m7851a(boolean z, List<String> list, List<String> list2) throws IabException {
        if (this.f5533d) {
            C3095y.m9479c("IabHelper disposed");
            return new C2767d();
        }
        m7857a("queryInventory");
        try {
            C2767d c2767d = new C2767d();
            int a = m7849a(c2767d, "inapp");
            if (a != 0) {
                throw new IabException(a, "Error refreshing inventory (querying owned items).");
            }
            if (z) {
                a = m7850a("inapp", c2767d, (List) list);
                if (a != 0) {
                    throw new IabException(a, "Error refreshing inventory (querying prices of items).");
                }
            }
            if (!this.f5534e) {
                return c2767d;
            }
            a = m7849a(c2767d, "subs");
            if (a != 0) {
                throw new IabException(a, "Error refreshing inventory (querying owned subscriptions).");
            } else if (!z) {
                return c2767d;
            } else {
                a = m7850a("subs", c2767d, (List) list2);
                if (a == 0) {
                    return c2767d;
                }
                throw new IabException(a, "Error refreshing inventory (querying prices of subscriptions).");
            }
        } catch (Exception e) {
            throw new IabException(-1001, "Remote exception while refreshing inventory.", e);
        } catch (Exception e2) {
            throw new IabException(-1002, "Error parsing JSON response while refreshing inventory.", e2);
        }
    }

    public void m7860a(boolean z, List<String> list, List<String> list2, @NonNull C2763c c2763c) {
        if (this.f5533d) {
            c2763c.m7843a(new C2766c(-1000, "IabHelper disposed"), new C2767d());
            return;
        }
        Handler handler = new Handler();
        m7857a("queryInventory");
        m7864b("refresh inventory");
        new Thread(new C27601(this, z, list, list2, handler, c2763c)).start();
    }

    public void m7856a(@NonNull C2763c c2763c) {
        m7860a(true, null, null, c2763c);
    }

    void m7857a(String str) {
        if (!this.f5532c) {
            m7867d("Illegal state for operation (" + str + "): IAB helper is not set up.");
            throw new IllegalStateException("IAB helper is not set up. Can't perform operation: " + str);
        }
    }

    int m7848a(@NonNull Bundle bundle) {
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            m7865c("Bundle with null response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            m7867d("Unexpected type for bundle response code: " + obj.getClass().getName());
            throw new RuntimeException("Unexpected type for bundle response code: " + obj.getClass().getName());
        }
    }

    int m7847a(@NonNull Intent intent) {
        Object obj = intent.getExtras().get("RESPONSE_CODE");
        if (obj == null) {
            m7867d("Intent with no response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            m7867d("Unexpected type for intent response code:" + obj.getClass().getName());
            throw new RuntimeException("Unexpected type for intent response code: " + obj.getClass().getName());
        }
    }

    void m7864b(String str) {
        if (this.f5535f) {
            throw new IllegalStateException("Can't start async operation (" + str + ") because another async operation(" + this.f5537h + ") is in progress.");
        }
        this.f5537h = str;
        this.f5535f = true;
        m7865c("Starting async operation: " + str);
    }

    void m7862b() {
        m7865c("Ending async operation: " + this.f5537h);
        this.f5537h = BuildConfig.FLAVOR;
        this.f5535f = false;
        if (this.f5536g) {
            m7852a();
        }
    }

    int m7849a(@NonNull C2767d c2767d, String str) throws JSONException, RemoteException {
        if (this.f5533d || this.f5539j == null || this.f5538i == null) {
            return -1008;
        }
        m7865c("Querying owned items, item type: " + str);
        m7865c("Package name: " + this.f5545p);
        String str2 = null;
        while (this.f5539j != null) {
            m7865c("Calling getPurchases with continuation token: " + str2);
            Bundle a = this.f5539j.m201a(3, this.f5545p, str, str2);
            int a2 = m7848a(a);
            m7865c("Owned items response: " + String.valueOf(a2));
            if (a2 != 0) {
                m7865c("getPurchases() failed: " + C2765b.m7845a(a2));
                return a2;
            } else if (a.containsKey("INAPP_PURCHASE_ITEM_LIST") && a.containsKey("INAPP_PURCHASE_DATA_LIST") && a.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
                ArrayList stringArrayList = a.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList stringArrayList2 = a.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList stringArrayList3 = a.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                if (!(stringArrayList2 == null || stringArrayList3 == null || stringArrayList == null)) {
                    for (int i = 0; i < stringArrayList2.size(); i++) {
                        str2 = (String) stringArrayList2.get(i);
                        String str3 = (String) stringArrayList3.get(i);
                        String str4 = (String) stringArrayList.get(i);
                        if (this.f5543n == null || !C2769f.m7884a(this.f5543n, str2, str3)) {
                            m7868e("Purchase signature verification **FAILED**. Not adding item.");
                            m7865c("   Purchase data: " + str2);
                            m7865c("   Signature: " + str3);
                        } else {
                            m7865c("Sku is owned: " + str4);
                            C2768e c2768e = new C2768e(str, str2, str3);
                            if (TextUtils.isEmpty(c2768e.m7880c())) {
                                m7868e("BUG: empty/null token!");
                                m7865c("Purchase data: " + str2);
                            }
                            c2767d.m7874a(c2768e);
                        }
                    }
                }
                str2 = a.getString("INAPP_CONTINUATION_TOKEN");
                m7865c("Continuation token: " + str2);
                if (TextUtils.isEmpty(str2)) {
                    return 0;
                }
                if (this.f5539j == null) {
                    return 0;
                }
            } else {
                m7867d("Bundle returned from getPurchases() doesn't contain required fields.");
                return -1002;
            }
        }
        return -1008;
    }

    int m7850a(@NonNull String str, @NonNull C2767d c2767d, @Nullable List<String> list) throws RemoteException, JSONException {
        m7865c("Querying SKU details.");
        int size = c2767d.m7877b(str).size();
        if (list != null) {
            size += list.size();
        }
        ArrayList arrayList = new ArrayList(size);
        arrayList.addAll(c2767d.m7877b(str));
        if (list != null) {
            for (String str2 : list) {
                if (!arrayList.contains(str2)) {
                    arrayList.add(str2);
                }
            }
        }
        if (arrayList.size() == 0) {
            m7865c("queryPrices: nothing to do because there are no SKUs.");
            return 0;
        }
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("ITEM_ID_LIST", arrayList);
        if (this.f5539j == null) {
            m7865c("getSkuDetails() failed: service is null");
            return -1000;
        }
        Bundle bundle2 = null;
        if (this.f5538i != null) {
            bundle2 = this.f5539j.m200a(3, this.f5538i.getPackageName(), str, bundle);
        }
        if (bundle2 != null && !bundle2.containsKey("DETAILS_LIST")) {
            size = m7848a(bundle2);
            if (size != 0) {
                m7865c("getSkuDetails() failed: " + C2765b.m7845a(size));
                return size;
            }
            m7867d("getSkuDetails() returned a bundle with neither an error nor a detail list.");
            return -1002;
        } else if (bundle2 == null) {
            return 6;
        } else {
            ArrayList stringArrayList = bundle2.getStringArrayList("DETAILS_LIST");
            if (stringArrayList != null) {
                Iterator it = stringArrayList.iterator();
                while (it.hasNext()) {
                    C2770g c2770g = new C2770g(str, (String) it.next());
                    m7865c("Got sku details: " + c2770g);
                    c2767d.m7875a(c2770g);
                }
            }
            return 0;
        }
    }

    void m7865c(@NonNull String str) {
        if (this.f5530a) {
            C3095y.m9477b(this.f5531b, str);
        }
    }

    void m7867d(String str) {
        m7858a(str, null);
    }

    void m7858a(String str, @Nullable Throwable th) {
        C3095y.m9474a("In-app billing error: " + str, th);
    }

    void m7868e(String str) {
        C3095y.m9480c(this.f5531b, "In-app billing warning: " + str);
    }

    public boolean m7866c() {
        return this.f5532c;
    }
}
