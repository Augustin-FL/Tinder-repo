package com.tinder.managers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import com.google.android.gms.search.SearchAuth.StatusCodes;
import com.tinder.R;
import com.tinder.enums.PurchaseType;
import com.tinder.iap.util.C2765b;
import com.tinder.iap.util.C2765b.C2761a;
import com.tinder.iap.util.C2765b.C2762b;
import com.tinder.iap.util.C2765b.C2763c;
import com.tinder.iap.util.C2766c;
import com.tinder.iap.util.C2767d;
import com.tinder.iap.util.C2768e;
import com.tinder.p030d.C2279p;
import com.tinder.p030d.C2291r;
import com.tinder.p030d.C2435q;
import com.tinder.utils.C3095y;
import java.util.List;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.tinder.managers.e */
public class C2836e implements C2761a, C2763c {
    private Context f5814a;
    @Nullable
    private C2765b f5815b;
    private C2435q f5816c;
    private C2291r f5817d;

    /* renamed from: com.tinder.managers.e.1 */
    class C28341 implements C2762b {
        final /* synthetic */ C2279p f5811a;
        final /* synthetic */ C2836e f5812b;

        C28341(C2836e c2836e, C2279p c2279p) {
            this.f5812b = c2836e;
            this.f5811a = c2279p;
        }

        public void m8208a(@NonNull C2766c c2766c) {
            C3095y.m9471a("Setup finished.");
            if (this.f5812b.f5815b == null) {
                this.f5811a.m6102a(this.f5812b.f5814a.getResources().getString(R.string.error_inapp_billing_setup));
                C3095y.m9479c("IabHelper is null");
            } else if (c2766c.m7870b()) {
                C3095y.m9471a("Setup successful.");
                this.f5811a.m6101a();
            } else {
                C3095y.m9479c("Problem setting up in-app billing: " + c2766c);
                this.f5811a.m6102a(this.f5812b.f5814a.getResources().getString(R.string.error_inapp_billing_setup) + ' ' + c2766c);
            }
        }
    }

    /* renamed from: com.tinder.managers.e.2 */
    static /* synthetic */ class C28352 {
        static final /* synthetic */ int[] f5813a;

        static {
            f5813a = new int[PurchaseType.values().length];
            try {
                f5813a[PurchaseType.SUBSCRIPTION.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5813a[PurchaseType.CONSUMABLE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    C2836e(Context context) {
        this.f5814a = context;
    }

    public void m8212a(@NonNull C2279p c2279p) {
        C3095y.m9469a();
        if (this.f5815b == null) {
            try {
                this.f5815b = new C2765b(this.f5814a, this.f5814a.getPackageManager().getApplicationInfo(this.f5814a.getPackageName(), AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS).metaData.getString("iabApiKey"));
            } catch (Throwable e) {
                C3095y.m9474a("Failed to load meta-data, NameNotFound", e);
            } catch (Throwable e2) {
                C3095y.m9474a("Failed to load meta-data, NullPointer,", e2);
            }
            this.f5815b.m7859a(false);
            this.f5815b.m7855a(new C28341(this, c2279p));
        }
    }

    public boolean m8216a() {
        return this.f5815b != null && this.f5815b.m7866c();
    }

    public void m8218b() {
        C3095y.m9469a();
        C3095y.m9471a("Destroying helper.");
        if (this.f5815b != null) {
            this.f5815b.m7852a();
            this.f5815b = null;
        }
    }

    public void m8211a(@NonNull Activity activity, String str, @NonNull PurchaseType purchaseType, String str2, C2435q c2435q) {
        C3095y.m9469a();
        this.f5816c = c2435q;
        if (this.f5815b == null || TextUtils.isEmpty(str)) {
            C3095y.m9471a("IAB helper is null or sku is empty");
            return;
        }
        C3095y.m9471a("launch helper purchase flow for productId: " + str);
        switch (C28352.f5813a[purchaseType.ordinal()]) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                C3095y.m9471a("launch purchase flow for subscription");
                this.f5815b.m7863b(activity, str, StatusCodes.AUTH_THROTTLED, this, str2);
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                C3095y.m9471a("launch purchase flow for inapp");
                this.f5815b.m7853a(activity, str, StatusCodes.AUTH_THROTTLED, this, str2);
            default:
        }
    }

    public synchronized void m8215a(@Nullable List<String> list, @Nullable List<String> list2, C2291r c2291r) {
        C3095y.m9483d("purchase|restore loading inventory.");
        this.f5817d = c2291r;
        if (this.f5815b == null) {
            C3095y.m9479c("mIabHelper is null, unable to load inventory");
        } else if ((list == null || list.isEmpty()) && (list2 == null || list2.isEmpty())) {
            this.f5815b.m7856a((C2763c) this);
        } else {
            this.f5815b.m7860a(true, list, list2, this);
        }
    }

    public boolean m8217a(int i, int i2, Intent intent) {
        C3095y.m9471a("onActivityResult(" + i + "," + i2 + "," + intent + ")");
        return this.f5815b != null && this.f5815b.m7861a(i, i2, intent);
    }

    public void m8214a(@NonNull C2766c c2766c, @Nullable C2768e c2768e) {
        C3095y.m9471a("Purchase finished: " + c2766c + ", purchase: " + c2768e);
        if (this.f5815b == null) {
            C3095y.m9471a("mIabHelper null");
        } else if (c2766c.m7871c()) {
            C3095y.m9471a("onPurchaseResult failure");
            this.f5816c.m6762a(c2768e, c2766c.m7869a());
        } else if (c2768e != null) {
            C3095y.m9471a("Purchase successful.");
            C3095y.m9471a(String.format("original json: [%s] signature: [%s]", new Object[]{c2768e.m7881d(), c2768e.m7882e()}));
            if (PurchaseType.isConsumable(c2768e.m7878a())) {
                this.f5816c.m6761a(c2768e);
            } else if (PurchaseType.isSubscription(c2768e.m7878a())) {
                C3095y.m9471a("Purchase was a subscription");
                this.f5816c.m6761a(c2768e);
            }
        } else {
            this.f5816c.m6762a(null, "Purchase object is null");
        }
    }

    public void m8213a(@Nullable C2766c c2766c, @Nullable C2767d c2767d) {
        C3095y.m9471a("Query inventory finished");
        if (!(c2766c == null || c2767d == null)) {
            C3095y.m9471a(String.format("result: [%s], purchases: [%s] ", new Object[]{c2766c.toString(), c2767d.m7876b()}));
        }
        if (this.f5815b != null) {
            if (c2766c == null || c2766c.m7871c()) {
                String str = "Failed to query inventory: " + c2766c;
                C3095y.m9479c(str);
                this.f5817d.m6115a(str);
                return;
            }
            C3095y.m9471a("Query inventory was successful.");
            this.f5817d.m6114a(c2767d);
        }
        C3095y.m9471a("Initial inventory query finished");
    }
}
