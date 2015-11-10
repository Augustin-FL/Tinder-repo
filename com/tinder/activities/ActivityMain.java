package com.tinder.activities;

import android.animation.Animator.AnimatorListener;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.facebook.GraphResponse;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.tinder.R;
import com.tinder.adapters.ActivityMainPagerAdapter;
import com.tinder.adapters.C2360n;
import com.tinder.base.ActivitySignedInBase;
import com.tinder.dialogs.C2501o;
import com.tinder.dialogs.C2518s;
import com.tinder.dialogs.C2523t;
import com.tinder.dialogs.C2523t.C2294a;
import com.tinder.dialogs.ae;
import com.tinder.dialogs.ae.C2460a;
import com.tinder.enums.PurchaseType;
import com.tinder.fragments.C2646k;
import com.tinder.fragments.C2646k.C2295a;
import com.tinder.fragments.C2657l;
import com.tinder.fragments.C2720t;
import com.tinder.fragments.FragmentAnchoredPopup;
import com.tinder.fragments.FragmentSideMenu;
import com.tinder.iap.util.C2767d;
import com.tinder.iap.util.C2770g;
import com.tinder.managers.C2807a;
import com.tinder.managers.C2833d.C2296a;
import com.tinder.managers.C2836e;
import com.tinder.managers.C2913k.C2912a;
import com.tinder.managers.C2925l;
import com.tinder.managers.C2958p;
import com.tinder.managers.ManagerApp;
import com.tinder.model.FacebookAnalyticsUtils;
import com.tinder.model.GlobalConfig;
import com.tinder.model.Group;
import com.tinder.model.Match;
import com.tinder.model.MixpanelUtils;
import com.tinder.model.Paywall;
import com.tinder.model.PhotoUser;
import com.tinder.model.SparksEvent;
import com.tinder.model.TinderLocation;
import com.tinder.model.TinderPurchase;
import com.tinder.model.User;
import com.tinder.model.UserMeta;
import com.tinder.p030d.C2279p;
import com.tinder.p030d.C2291r;
import com.tinder.p030d.ab;
import com.tinder.p030d.ah;
import com.tinder.p030d.au;
import com.tinder.p030d.av;
import com.tinder.p030d.aw;
import com.tinder.p030d.bb;
import com.tinder.p030d.bm;
import com.tinder.p030d.bq;
import com.tinder.picassowebp.picasso.C2281x;
import com.tinder.picassowebp.picasso.Picasso;
import com.tinder.picassowebp.picasso.Picasso.LoadedFrom;
import com.tinder.utils.C3080q;
import com.tinder.utils.C3093w;
import com.tinder.utils.C3095y;
import com.tinder.utils.aj;
import com.tinder.utils.al;
import com.tinder.views.CircleTransformation;
import com.tinder.views.CustomDrawerLayout;
import com.tinder.views.SinkPageTransformer;
import com.tinder.views.SkippableViewPager;
import java.io.InvalidClassException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.http.entity.ContentLengthStrategy;
import uk.co.senab.actionbarpulltorefresh.library.C3370c;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class ActivityMain extends ActivitySignedInBase implements OnPageChangeListener, DrawerListener, OnQueryTextListener, ab, ah, au, av, aw, bb, bq, C2294a, C2295a, C2296a, Paywall {
    @NonNull
    private Handler f3905A;
    private ActivityMainPagerAdapter f3906a;
    @Nullable
    private FragmentAnchoredPopup f3907b;
    @Nullable
    private FragmentAnchoredPopup f3908c;
    private CustomDrawerLayout f3909e;
    private SkippableViewPager f3910f;
    private SinkPageTransformer f3911g;
    private boolean f3912h;
    private boolean f3913i;
    @Nullable
    private Match f3914j;
    private C3370c f3915k;
    private C2657l f3916l;
    private C2925l f3917m;
    private C2836e f3918n;
    private List<String> f3919o;
    private int f3920p;
    @Nullable
    private List<String> f3921q;
    @Nullable
    private C2501o f3922r;
    private List<C2770g> f3923s;
    private boolean f3924t;
    private boolean f3925u;
    private boolean f3926v;
    private Dialog f3927w;
    private Dialog f3928x;
    private ae f3929y;
    private boolean f3930z;

    /* renamed from: com.tinder.activities.ActivityMain.1 */
    class C22771 implements OnDismissListener {
        final /* synthetic */ ActivityMain f3884a;

        C22771(ActivityMain activityMain) {
            this.f3884a = activityMain;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            FragmentSideMenu fragmentSideMenu = (FragmentSideMenu) this.f3884a.getSupportFragmentManager().findFragmentById(R.id.fragment_menu);
            if (fragmentSideMenu != null) {
                fragmentSideMenu.m7125a();
            }
        }
    }

    /* renamed from: com.tinder.activities.ActivityMain.2 */
    class C22782 implements Runnable {
        final /* synthetic */ ActivityMain f3885a;

        C22782(ActivityMain activityMain) {
            this.f3885a = activityMain;
        }

        public void run() {
            if (!this.f3885a.m5922a(this.f3885a)) {
                this.f3885a.w_();
            }
        }
    }

    /* renamed from: com.tinder.activities.ActivityMain.3 */
    class C22803 implements C2279p {
        final /* synthetic */ Runnable f3886a;
        final /* synthetic */ ActivityMain f3887b;

        C22803(ActivityMain activityMain, Runnable runnable) {
            this.f3887b = activityMain;
            this.f3886a = runnable;
        }

        public void m6103a() {
            C3095y.m9471a("initialize managerInAppBilling (restore|purchase) onSuccess");
            if (this.f3886a != null) {
                C3095y.m9471a("initialize managerInAppBilling (restore|purchase) runnable: " + this.f3886a.getClass());
                this.f3886a.run();
                return;
            }
            C3095y.m9471a("initialize managerInAppBilling (restore|purchase): no runnable, done.");
            this.f3887b.f3924t = false;
            this.f3887b.f3925u = false;
        }

        public void m6104a(String str) {
            C3095y.m9471a("initialize managerInAppBilling (restore|purchase) failure");
            Builder builder = new Builder(this.f3887b);
            builder.setMessage(str);
            builder.setNeutralButton("OK", null);
            builder.create().show();
            this.f3887b.f3924t = false;
            this.f3887b.f3925u = false;
        }
    }

    /* renamed from: com.tinder.activities.ActivityMain.4 */
    class C22824 implements C2281x {
        final /* synthetic */ ActivityMain f3888a;

        C22824(ActivityMain activityMain) {
            this.f3888a = activityMain;
        }

        public void onBitmapLoaded(Bitmap bitmap, LoadedFrom loadedFrom) {
            C3095y.m9469a();
            if (this.f3888a.f3929y != null && !this.f3888a.isFinishing()) {
                this.f3888a.f3929y.show();
            }
        }

        public void onBitmapFailed(Drawable drawable) {
            C3095y.m9469a();
            if (this.f3888a.f3929y != null && !this.f3888a.isFinishing()) {
                this.f3888a.f3929y.show();
            }
        }

        public void onPrepareLoad(Drawable drawable) {
            C3095y.m9469a();
        }
    }

    /* renamed from: com.tinder.activities.ActivityMain.5 */
    class C22835 implements Runnable {
        final /* synthetic */ ActivityMain f3889a;

        C22835(ActivityMain activityMain) {
            this.f3889a = activityMain;
        }

        public void run() {
            this.f3889a.f3910f.setCurrentItem(this.f3889a.f3906a.getCount() - 1);
        }
    }

    /* renamed from: com.tinder.activities.ActivityMain.6 */
    class C22846 implements OnDismissListener {
        final /* synthetic */ ActivityMain f3890a;

        C22846(ActivityMain activityMain) {
            this.f3890a = activityMain;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            C3095y.m9483d("Paywall dismissed, forgetting reference.");
            this.f3890a.f3922r = null;
        }
    }

    /* renamed from: com.tinder.activities.ActivityMain.7 */
    class C22857 implements OnDismissListener {
        final /* synthetic */ ActivityMain f3891a;

        C22857(ActivityMain activityMain) {
            this.f3891a = activityMain;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            ManagerApp.m7914e();
            if (!C2958p.aj()) {
                this.f3891a.m6192a("swipeLimit");
            }
        }
    }

    /* renamed from: com.tinder.activities.ActivityMain.8 */
    class C22868 implements Runnable {
        final /* synthetic */ ActivityMain f3892a;

        C22868(ActivityMain activityMain) {
            this.f3892a = activityMain;
        }

        public void run() {
            ManagerApp.m7911b().m8143d();
        }
    }

    /* renamed from: com.tinder.activities.ActivityMain.a */
    private class C2288a implements Runnable {
        boolean f3894a;
        final /* synthetic */ ActivityMain f3895b;

        /* renamed from: com.tinder.activities.ActivityMain.a.1 */
        class C22871 implements bm {
            final /* synthetic */ C2288a f3893a;

            C22871(C2288a c2288a) {
                this.f3893a = c2288a;
            }

            public void m6107a(@NonNull TinderPurchase tinderPurchase) {
                C3095y.m9471a("restore purchase: onPurchaseSuccess");
                Toast.makeText(ManagerApp.m7917h(), R.string.success_reclaim_purchase, 0).show();
                C2770g a = this.f3893a.f3895b.m6149b(tinderPurchase.getProductId());
                C3095y.m9471a("restore purchase SUCCESS id: " + tinderPurchase.getProductId() + " skuDetails: " + a);
                if (a != null) {
                    C3095y.m9471a("restore purchase skuDetails " + a.toString());
                }
                C3095y.m9471a("restore purchase tinderpurchse: " + tinderPurchase);
                SparksEvent sparksEvent = new SparksEvent("TinderPlus.Restore");
                sparksEvent.put("term", Integer.valueOf(C3080q.m9421a(tinderPurchase.getProductId())));
                C2770g b = C3080q.m9424b(this.f3893a.f3895b.f3923s);
                if (b != null) {
                    sparksEvent.put("basePrice", Float.valueOf(b.m7890d()));
                }
                sparksEvent.put("features", this.f3893a.f3895b.f3921q);
                sparksEvent.put("sku", tinderPurchase.getProductId());
                if (a != null) {
                    sparksEvent.put("currency", a.m7886a());
                    sparksEvent.put("price", Float.valueOf(a.m7890d()));
                }
                sparksEvent.put(GraphResponse.SUCCESS_KEY, Boolean.valueOf(true));
                C2807a.m8056a(sparksEvent);
                ManagerApp.m7924o().m8718e();
                C2646k a2 = this.f3893a.f3895b.f3906a.m6350a();
                if (a2 != null) {
                    a2.m7382r();
                }
                if (this.f3893a.f3895b.f3922r != null) {
                    this.f3893a.f3895b.f3922r.dismiss();
                }
            }

            public void m6108a(String str, String str2) {
                C3095y.m9479c("restore purchase: onPurchaseFailure");
                if (this.f3893a.f3894a) {
                    Toast.makeText(this.f3893a.f3895b, R.string.error_reclaim_purchase, 0).show();
                }
                SparksEvent sparksEvent = new SparksEvent("TinderPlus.Restore");
                sparksEvent.put(GraphResponse.SUCCESS_KEY, Boolean.valueOf(false));
                C2807a.m8056a(sparksEvent);
            }
        }

        public C2288a(ActivityMain activityMain, boolean z) {
            this.f3895b = activityMain;
            this.f3894a = z;
        }

        public void run() {
            C3095y.m9471a("restore purchase: runnable called");
            this.f3895b.f3917m.m8626a(new C22871(this));
        }
    }

    /* renamed from: com.tinder.activities.ActivityMain.b */
    private class C2290b implements Runnable {
        final /* synthetic */ ActivityMain f3897a;
        private WeakReference<Activity> f3898b;
        private C2770g f3899c;
        private int f3900d;
        private List<C2770g> f3901e;

        /* renamed from: com.tinder.activities.ActivityMain.b.1 */
        class C22891 implements bm {
            final /* synthetic */ C2290b f3896a;

            C22891(C2290b c2290b) {
                this.f3896a = c2290b;
            }

            public void m6109a(@NonNull TinderPurchase tinderPurchase) {
                C3095y.m9471a("onPurchaseSuccess: " + tinderPurchase.toString());
                this.f3896a.f3897a.f3924t = false;
                SparksEvent sparksEvent = new SparksEvent("TinderPlus.Purchase");
                sparksEvent.put("term", Integer.valueOf(C3080q.m9421a(this.f3896a.f3899c.m7888b())));
                try {
                    sparksEvent.put("products", C2501o.m6888a(this.f3896a.f3897a.f3923s));
                } catch (Throwable e) {
                    C3095y.m9474a("Failed to create json for available products", e);
                }
                C2770g b = C3080q.m9424b(this.f3896a.f3901e);
                if (b != null) {
                    sparksEvent.put("basePrice", Float.valueOf(b.m7890d()));
                }
                sparksEvent.put("sku", this.f3896a.f3899c.m7888b());
                sparksEvent.put("price", Float.valueOf(this.f3896a.f3899c.m7890d()));
                sparksEvent.put("locale", C3093w.m9462b());
                sparksEvent.put("currency", this.f3896a.f3899c.m7886a());
                sparksEvent.put("from", Integer.valueOf(this.f3896a.f3900d));
                sparksEvent.put("unlimitedLikesOffered", Boolean.valueOf(ManagerApp.m7914e().ao()));
                sparksEvent.put("percentLikesLeft", Integer.valueOf(ManagerApp.m7924o().m8692a()));
                if (this.f3896a.f3899c.m7891e() != null) {
                    sparksEvent.put("features", this.f3896a.f3899c.m7891e());
                }
                sparksEvent.put("paywallVersion", Integer.valueOf(4));
                sparksEvent.put("roadblockVersion", Integer.valueOf(1));
                sparksEvent.put("superLikesRemaining", Integer.valueOf(this.f3896a.f3897a.f3920p));
                C2807a.m8056a(sparksEvent);
                Bundle bundle = new Bundle();
                bundle.putString("sku", this.f3896a.f3899c.m7888b());
                bundle.putString("locale", C3093w.m9462b());
                bundle.putInt("from", this.f3896a.f3900d);
                bundle.putBoolean("unlimitedLikesOffered", ManagerApp.m7914e().ao());
                bundle.putInt("percentLikesLeft", ManagerApp.m7924o().m8692a());
                FacebookAnalyticsUtils.logPurchase(this.f3896a.f3899c, bundle);
                Toast.makeText(ManagerApp.m7917h(), R.string.purchase_success, 0).show();
                if (this.f3896a.f3897a.f3922r != null) {
                    this.f3896a.f3897a.f3922r.dismiss();
                    this.f3896a.f3897a.f3922r = null;
                }
                ManagerApp.m7924o().m8718e();
                C2646k a = this.f3896a.f3897a.f3906a.m6350a();
                if (a != null) {
                    a.m7382r();
                }
            }

            public void m6110a(String str, String str2) {
                C3095y.m9479c("onPurchaseFailure: " + str2);
                this.f3896a.f3897a.f3924t = false;
                Toast.makeText(ManagerApp.m7917h(), R.string.purchase_failure, 0).show();
                if (this.f3896a.f3897a.f3922r != null) {
                    this.f3896a.f3897a.f3922r.cancel();
                    this.f3896a.f3897a.f3922r = null;
                }
            }
        }

        public C2290b(ActivityMain activityMain, Activity activity, @NonNull List<C2770g> list, C2770g c2770g) {
            this.f3897a = activityMain;
            this.f3898b = new WeakReference(activity);
            this.f3899c = c2770g;
            this.f3901e = list;
            if (activityMain.f3922r != null) {
                this.f3900d = activityMain.f3922r.m6902a();
            }
        }

        public void run() {
            if (this.f3898b.get() != null) {
                this.f3897a.f3917m.m8624a((Activity) this.f3898b.get(), this.f3899c.m7888b(), PurchaseType.getTypeFromSku(this.f3899c.m7888b()), new C22891(this));
                return;
            }
            this.f3897a.f3924t = false;
        }
    }

    /* renamed from: com.tinder.activities.ActivityMain.c */
    private class C2293c implements Runnable {
        final /* synthetic */ ActivityMain f3903a;
        private List<String> f3904b;

        /* renamed from: com.tinder.activities.ActivityMain.c.1 */
        class C22921 implements C2291r {
            final /* synthetic */ C2293c f3902a;

            C22921(C2293c c2293c) {
                this.f3902a = c2293c;
            }

            public void m6116a(@NonNull C2767d c2767d) {
                C3095y.m9471a("getSkuDetails onSuccess");
                if (this.f3902a.f3903a.f3919o.isEmpty()) {
                    for (String str : c2767d.m7873a()) {
                        C2770g a = c2767d.m7872a(str);
                        if (a != null) {
                            int indexOf = this.f3902a.f3903a.f3919o.indexOf(a.m7888b());
                            if (indexOf == -1) {
                                indexOf = 0;
                            }
                            if (!this.f3902a.f3903a.f3923s.contains(a) && indexOf >= 0 && indexOf <= this.f3902a.f3903a.f3923s.size()) {
                                C3095y.m9483d("Inserting SKU " + a.m7888b() + " at index " + indexOf);
                                this.f3902a.f3903a.f3923s.add(indexOf, a);
                            }
                            C3095y.m9471a("got sku details: " + a);
                        } else {
                            C3095y.m9479c("Tried to load a SKU for owned products, but product did not exist in inventory: " + str);
                        }
                    }
                } else {
                    for (String str2 : this.f3902a.f3903a.f3919o) {
                        C2770g a2 = c2767d.m7872a(str2);
                        if (a2 != null) {
                            if (!this.f3902a.f3903a.f3923s.contains(a2)) {
                                C3095y.m9483d("Inserting SKU " + a2.m7888b());
                                this.f3902a.f3903a.f3923s.add(a2);
                            }
                            C3095y.m9471a("got sku details: " + a2);
                        }
                    }
                }
                this.f3902a.f3903a.f3925u = false;
            }

            public void m6117a(String str) {
                this.f3902a.f3903a.f3925u = false;
                C3095y.m9479c("getSkuDetails error: " + str);
            }
        }

        C2293c(ActivityMain activityMain, List<String> list) {
            this.f3903a = activityMain;
            this.f3904b = list;
        }

        public void run() {
            C3095y.m9469a();
            try {
                this.f3903a.f3918n.m8215a(Collections.EMPTY_LIST, this.f3904b, new C22921(this));
            } catch (Throwable e) {
                this.f3903a.f3925u = false;
                C3095y.m9474a("Failed to retrieve sku details. Exception while loading.", e);
            }
        }
    }

    public ActivityMain() {
        super(true);
        this.f3925u = false;
        this.f3905A = new Handler();
    }

    protected int m6196c() {
        return R.layout.view_activity_main;
    }

    public void onCreate(Bundle bundle) {
        C3095y.m9471a("instance bundle=" + bundle);
        C3095y.m9471a("density=" + al.m9298d((Context) this));
        super.onCreate(bundle);
        m6182a(bundle);
        this.f3919o = new ArrayList(3);
        this.f3923s = new ArrayList(3);
        this.f3918n = ManagerApp.m7920k();
        this.f3917m = ManagerApp.m7921l();
    }

    public void m6186a(GlobalConfig globalConfig, @Nullable UserMeta userMeta) {
        super.m5921a(globalConfig, userMeta);
        if (userMeta != null) {
            m6144a(userMeta);
            this.f3920p = userMeta.getSuperlikeStatus().getRemaining();
        }
    }

    public void onResume() {
        super.onResume();
        ManagerApp.m7911b().m8141b((ah) this);
        UserMeta c = ManagerApp.m7911b().m8142c();
        if (!this.f3926v) {
            if (c != null) {
                C3095y.m9471a("getUserMeta");
                m5924b(c.getTinderReportNotifications());
                if (!(c.getClientConfig() == null || c.getClientConfig().getRateCard() == null)) {
                    this.f3921q = c.getClientConfig().getRateCard().getCarousel();
                }
            }
            this.f3926v = true;
        }
        MixpanelUtils.setMixpanelForUser(ManagerApp.m7922m().m8599d());
        if (m5913Y()) {
            C3095y.m9471a("location adding location listener");
            m5916a((Activity) this, (C2296a) this);
            m5910V();
            if (!m5912X()) {
                w_();
            }
        }
        try {
            FacebookAnalyticsUtils.activate(this);
        } catch (Throwable e) {
            C3095y.m9474a("Failed to activate facebook analytics due to runtime exception.", e);
        }
        if (aj.m9235a().m9242g()) {
            m6192a("crash");
        }
    }

    public void m6192a(String str) {
        if ((this.f3927w == null || !this.f3927w.isShowing()) && aj.m9235a().m9246k()) {
            this.f3927w = new C2518s(this, 0, str);
            this.f3927w.setOnDismissListener(new C22771(this));
            this.f3927w.show();
        }
    }

    public void onPause() {
        super.onPause();
        C3095y.m9469a();
        m5920a((C2296a) this);
        al.m9297c(this.f3928x);
        ManagerApp.m7911b().m8140a((ah) this);
        FacebookAnalyticsUtils.deactivate(this);
    }

    public void m6180a(int i) {
        if (i == 0) {
            this.f3910f.setPagingEnabled(false);
        } else if (i == 1) {
            this.f3910f.setPagingEnabled(true);
        }
    }

    public void m6194b(int i) {
        this.f3909e.setDrawerLockMode(i);
    }

    public void w_() {
        C3095y.m9471a("refreshLocation");
        this.f3905A.postDelayed(new C22782(this), 10000);
    }

    public synchronized void m6191a(@Nullable Runnable runnable) {
        C3095y.m9469a();
        if (!this.f3918n.m8216a()) {
            this.f3918n.m8212a(new C22803(this, runnable));
        } else if (runnable != null) {
            C3095y.m9479c("Already initilized, short cutting to runable: " + runnable.getClass());
            runnable.run();
        }
    }

    private void m6145a(List<String> list) {
        if (!this.f3925u) {
            this.f3925u = true;
            if (this.f3918n.m8216a()) {
                new C2293c(this, list).run();
            } else {
                m6191a(new C2293c(this, list));
            }
        }
    }

    @Nullable
    public FragmentAnchoredPopup m6197e() {
        this.f3907b = (FragmentAnchoredPopup) m5926c("passport");
        return this.f3907b;
    }

    @Nullable
    public FragmentAnchoredPopup m6198f() {
        return (FragmentAnchoredPopup) m5926c("superlike_feature");
    }

    public FragmentAnchoredPopup m6199g() {
        return (FragmentAnchoredPopup) m5926c("superlike_reminder");
    }

    public void m6190a(User user, int i, C2460a c2460a, OnDismissListener onDismissListener) {
        this.f3929y = new ae(this, user, i);
        this.f3929y.m6844a(c2460a);
        this.f3929y.setOnDismissListener(onDismissListener);
        int a = al.m9262a((Context) this) / 2;
        String imageUrl = ((PhotoUser) user.getPhotos().get(i)).getImageUrl();
        Picasso.m8982a((Context) this).m8990a(imageUrl).m9123a(new CircleTransformation()).m9127b().m9129b(a, a).m9126a(new C22824(this));
    }

    public void m6182a(Bundle bundle) {
        C3095y.m9469a();
        this.f3909e = (CustomDrawerLayout) findViewById(R.id.drawer_main);
        this.f3910f = (SkippableViewPager) findViewById(R.id.viewPager_activity_main);
        this.f3915k = C3370c.m10414a().m10411a((int) R.layout.pulltorefresh_header).m10412a(new C2360n(this)).m10410a(0.2f).m10413a();
        al.m9269a(this.f3910f, 650);
        this.f3909e.setDrawerListener(this);
        this.f3909e.setGravity(GravityCompat.START);
        this.f3906a = new ActivityMainPagerAdapter(getSupportFragmentManager());
        this.f3910f.setAdapter(this.f3906a);
        this.f3911g = new SinkPageTransformer(this);
        this.f3911g.setShouldBounce(true);
        this.f3910f.setPageTransformer(false, this.f3911g);
        ManagerApp.m7914e().m8833b(ManagerApp.f5583f);
        ManagerApp.m7916g().m8512a((av) this);
        try {
            m6150b(bundle);
        } catch (Exception e) {
            C3095y.m9479c(e.toString());
        }
    }

    private void m6150b(@Nullable Bundle bundle) throws InvalidClassException {
        Bundle extras = getIntent().getExtras();
        if (extras == null || bundle != null) {
            C3095y.m9471a("Bundle null OR returning to app after killed");
        } else if (!extras.getBoolean("from_push", false)) {
        } else {
            if (extras.containsKey("from_friend_request_push")) {
                m6205m();
            } else if (extras.getBoolean("is_message") || extras.getBoolean("is_match")) {
                Match match = (Match) extras.getSerializable("match");
                this.f3913i = true;
                if (match != null) {
                    m6188a(match, false);
                }
            } else if (extras.containsKey("moment_id")) {
                m6207o();
            } else {
                C3095y.m9471a("Couldn't recognize push notification");
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public void onBackPressed() {
        if (this.f3909e.isDrawerOpen()) {
            m6203k();
        } else if (this.f3910f.getCurrentItem() > 0) {
            this.f3910f.setCurrentItem(0, true);
        } else if (this.f3906a.m6350a() != null && this.f3906a.m6350a().m7379o()) {
            this.f3906a.m6350a().m7362a(true);
        } else if (this.f3906a.m6350a() != null && this.f3906a.m6350a().m7365c() != 0) {
            m6201i();
        } else if (!ac()) {
            super.onBackPressed();
        }
    }

    public void m6200h() {
        C2646k a = this.f3906a.m6350a();
        if (a != null && !a.m7377m()) {
            a.m7378n();
        }
    }

    private boolean ac() {
        boolean z;
        if (this.f3907b == null || !this.f3907b.m7072e()) {
            z = false;
        } else {
            this.f3907b.m7071d();
            z = true;
        }
        if (this.f3908c != null && this.f3908c.m7072e()) {
            this.f3908c.m7071d();
            z = true;
        }
        al.m9282a(this.f3927w);
        return z;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        C3095y.m9471a("item=" + menuItem);
        switch (menuItem.getItemId()) {
            case 16908332:
                m6202j();
                break;
        }
        return true;
    }

    public boolean onQueryTextSubmit(String str) {
        C3095y.m9471a("query text submit: " + str);
        return false;
    }

    public boolean onQueryTextChange(String str) {
        C3095y.m9471a("query text change: " + str);
        return false;
    }

    public void m6201i() {
        C2646k a = this.f3906a.m6350a();
        if (a != null) {
            a.m7390z();
        }
    }

    public void m6202j() {
        C3095y.m9469a();
        if (this.f3909e.isDrawerOpen()) {
            m6203k();
        } else {
            this.f3909e.openDrawer();
        }
    }

    public void m6203k() {
        this.f3909e.closeDrawer();
    }

    public void m6204l() {
        this.f3909e.openDrawer();
    }

    public void m6205m() {
        C3095y.m9471a("ENTER");
        C2646k a = this.f3906a.m6350a();
        if (a != null) {
            a.m7380p();
        }
    }

    public void m6206n() {
        C2646k a = this.f3906a.m6350a();
        if (a != null) {
            a.m7382r();
        }
    }

    public void m6207o() {
        C2646k a = this.f3906a.m6350a();
        if (a != null) {
            a.m7389y();
        }
    }

    public void m6183a(C2646k c2646k) {
        if (this.f3906a != null) {
            this.f3906a.m6353a(c2646k);
        }
    }

    public void m6187a(Match match) {
        this.f3914j = match;
        if (match != null) {
            this.f3930z = match.hasNewMessage();
        }
        C3095y.m9471a("Match has new message? " + this.f3930z);
    }

    @Nullable
    public Match m6208p() {
        return this.f3914j;
    }

    public boolean m6209q() {
        return this.f3912h;
    }

    public boolean m6210r() {
        return this.f3913i;
    }

    public void m6211s() {
        this.f3913i = false;
    }

    public void m6188a(Match match, boolean z) {
        if (match == null) {
            C3095y.m9479c("Attempted to enter match view with a null match, preventing");
            return;
        }
        C3095y.m9471a("showing " + match);
        this.f3914j = match;
        this.f3912h = z;
        this.f3906a.m6354a(match);
        ad();
    }

    public void m6212t() {
        this.f3910f.setCurrentItem(0, true);
    }

    public void m6213u() {
        if (this.f3916l != null) {
            this.f3916l.m7435c();
        }
    }

    public void m6184a(C2657l c2657l) {
        this.f3916l = c2657l;
    }

    public void m6214v() {
        C3095y.m9471a("ENTER");
        this.f3914j = null;
        this.f3909e.closeDrawer();
        this.f3906a.m6355b();
        ad();
    }

    public void m6215w() {
        int currentItem = this.f3910f.getCurrentItem() - 1;
        if (currentItem < 0) {
            currentItem = 0;
        }
        this.f3910f.setCurrentItem(currentItem, true);
    }

    public int m6216x() {
        if (this.f3910f == null) {
            return -1;
        }
        return this.f3910f.getCurrentItem();
    }

    public void m6217y() {
        C2646k a = this.f3906a.m6350a();
        if (a != null) {
            a.m7353C();
        }
    }

    public void m6218z() {
        C2646k a = this.f3906a.m6350a();
        if (a != null) {
            a.m7352B();
        }
    }

    public void onDrawerSlide(View view, float f) {
    }

    public void onDrawerOpened(View view) {
        C2646k a = this.f3906a.m6350a();
        if (a != null) {
            a.m7367d();
        }
        C2807a.m8058a("Menu.Open");
    }

    public void onDrawerClosed(View view) {
        C2807a.m8058a("Menu.Close");
        C2646k a = this.f3906a.m6350a();
        if (a != null) {
            a.m7372h();
        }
    }

    public void onDrawerStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageSelected(int i) {
        C2646k a;
        if (i > 0) {
            this.f3909e.setDrawerLockMode(1);
            a = this.f3906a.m6350a();
            if (a != null) {
                C2720t F = a.m7356F();
                if (F != null) {
                    F.m7702z();
                    return;
                }
                return;
            }
            return;
        }
        a = this.f3906a.m6350a();
        if (a != null) {
            switch (a.m7365c()) {
                case C3374b.SmoothProgressBar_spbStyle /*0*/:
                    a.m7381q();
                    break;
                case C3374b.SmoothProgressBar_spb_color /*1*/:
                    C2807a.m8058a("Match.List");
                    break;
                case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                    int b = a.m7363b();
                    if (b >= 0) {
                        if (b != 0) {
                            if (b == 1) {
                                C2807a.m8058a("Moments.List");
                                break;
                            }
                        }
                        C2807a.m8058a("Moments.Activity");
                        break;
                    }
                    break;
            }
        }
        this.f3909e.setDrawerLockMode(0);
        if (this.f3930z) {
            aj.m9235a().m9240e();
            m6192a("newMessage");
            this.f3930z = false;
        }
    }

    public boolean m6160A() {
        C2646k a = this.f3906a.m6350a();
        if (a == null || a.m7365c() != 0) {
            return false;
        }
        return true;
    }

    public void onPageScrollStateChanged(int i) {
        if (i != 0) {
            return;
        }
        if (this.f3910f.getCurrentItem() > 0) {
            this.f3911g.setShouldBounce(false);
            for (int count = this.f3906a.getCount(); count - 1 > this.f3910f.getCurrentItem(); count--) {
                this.f3906a.m6358e();
            }
            return;
        }
        this.f3906a.m6359f();
        this.f3911g.setShouldBounce(true);
        C2646k a = this.f3906a.m6350a();
        if (a != null && a.m7365c() == 0) {
            C2807a.m8058a("Recs.Start");
        }
    }

    public void m6161B() {
        ManagerApp.m7918i().m8772j(true);
        ManagerApp.m7918i().m8771i(false);
        C2646k a = this.f3906a.m6350a();
        if (a != null) {
            a.m7382r();
        }
    }

    public void m6162C() {
        this.f3909e.closeDrawer();
        this.f3906a.m6356c();
        ad();
    }

    public void m6163D() {
        this.f3909e.closeDrawer();
        this.f3906a.m6357d();
        ad();
    }

    public void m6193a(boolean z) {
        C2646k a = this.f3906a.m6350a();
        if (a != null) {
            a.m7362a(z);
        }
    }

    private void ad() {
        this.f3911g.setShouldBounce(true);
        this.f3910f.post(new C22835(this));
    }

    public void m6164E() {
        C2646k a = this.f3906a.m6350a();
        if (a != null) {
            if (ManagerApp.m7914e().m8880w()) {
                a.m7360a("fragment recommendations");
                a.m7382r();
                return;
            }
            a.m7360a("discover off");
        }
    }

    public void m6165F() {
    }

    protected void onActivityResult(int i, int i2, @NonNull Intent intent) {
        C3095y.m9471a(String.format("onActivityResult: requestCode[%s] responseCode[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        switch (i) {
            case 9455:
                switch (i2) {
                    case ContentLengthStrategy.IDENTITY /*-1*/:
                        TinderLocation tinderLocation = (TinderLocation) intent.getSerializableExtra("tinderlocation");
                        if (tinderLocation != null) {
                            m6189a(tinderLocation);
                        } else {
                            C3095y.m9479c("No location in data passed back by ActivityPassport");
                        }
                    case C3374b.SmoothProgressBar_spbStyle /*0*/:
                        C3095y.m9485e("User cancelled passport map request");
                    default:
                }
            default:
                if (!this.f3918n.m8217a(i, i2, intent)) {
                    super.onActivityResult(i, i2, intent);
                }
        }
    }

    public void onDestroy() {
        this.f3910f.removeOnPageChangeListener(this);
        al.m9297c(this.f3927w);
        this.f3918n.m8218b();
        MixpanelUtils.flushMixpanel();
        FacebookAnalyticsUtils.flush();
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 82) {
            return super.onKeyDown(i, keyEvent);
        }
        C3095y.m9471a("MENU pressed -- toggling flyout");
        if (this.f3910f.getCurrentItem() == 0) {
            m6202j();
        }
        return true;
    }

    public void m6181a(@NonNull AnimatorListener animatorListener) {
        this.f3906a.m6352a(animatorListener);
    }

    public void m6179a(float f) {
        this.f3906a.m6351a(f);
    }

    public void m6166G() {
        C3095y.m9471a("ENTER");
        this.f3906a.m6360g();
    }

    public void m6167H() {
        this.f3906a.m6361h();
    }

    public void launchPlusSubscriptionPaywall(int i) {
        if (this.f3922r != null) {
            C3095y.m9479c("Tried to launch duplicate paywalls. Preventing.");
            return;
        }
        C2912a c = ManagerApp.m7922m().m8598c();
        if (c == null || !c.m8564a()) {
            boolean aj = C2958p.aj();
            C3095y.m9471a("Restore purchases: " + (!aj));
            if (!aj) {
                m6195b(false);
            }
            if (this.f3921q == null || this.f3921q.isEmpty()) {
                UserMeta c2 = ManagerApp.m7911b().m8142c();
                if (!(c2 == null || c2.getClientConfig() == null || c2.getClientConfig().getRateCard() == null)) {
                    this.f3921q = c2.getClientConfig().getRateCard().getCarousel();
                }
                if (this.f3921q == null || this.f3921q.isEmpty()) {
                    C3095y.m9479c("Failed to load carousel order, cannot show paywall with no perks");
                    Toast.makeText(this, R.string.error_carousel_order_not_sent, 1).show();
                    return;
                }
            }
            if (this.f3923s.isEmpty()) {
                C3095y.m9479c("no sku details available");
                Toast.makeText(ManagerApp.m7917h(), R.string.error_getting_sku_details, 1).show();
                ManagerApp.m7911b().m8143d();
                return;
            }
            C3095y.m9471a("sku details available: " + this.f3923s.size() + " skus in");
            C3095y.m9483d("Paywall source is: " + i);
            this.f3922r = new C2501o(this, this.f3923s, this.f3921q, i, this.f3920p, this);
            this.f3922r.setOnDismissListener(new C22846(this));
            this.f3922r.show();
            return;
        }
        Toast.makeText(this, R.string.purchase_unauthorized, 0).show();
    }

    public void launchSwipeLimitRoadblock(String str) {
        if (ManagerApp.m7922m().m8598c().m8564a()) {
            C3095y.m9471a("Bouncer likes Banned");
            Toast.makeText(ManagerApp.m7917h(), R.string.purchase_unauthorized, 0).show();
            return;
        }
        String J = m6169J();
        C3095y.m9471a("Bouncer likes sku " + J);
        if (J == null || this.f3923s.isEmpty()) {
            C3095y.m9479c("no sku details available");
            Toast.makeText(ManagerApp.m7917h(), R.string.error_getting_sku_details, 1).show();
            return;
        }
        C3095y.m9471a("sku details available");
        C2770g b = m6149b(J);
        C3095y.m9471a("Bouncer likes sku details " + b);
        if (b != null) {
            C3095y.m9471a("sku details available");
            aj.m9235a().m9238c();
            this.f3928x = new C2523t(this, this, str);
            this.f3928x.setOnDismissListener(new C22857(this));
            this.f3928x.show();
        }
    }

    public void m6168I() {
        launchPlusSubscriptionPaywall(3);
    }

    public void m6185a(C2770g c2770g) {
        if (!this.f3924t && this.f3922r != null) {
            this.f3924t = true;
            if (C2958p.aj()) {
                C3095y.m9479c("User was shown paywall, opted to pay, but already had plus subscription");
                this.f3922r.dismiss();
                this.f3922r = null;
                Toast.makeText(this, R.string.purchase_already_existed, 1).show();
                m6195b(false);
                this.f3924t = false;
            } else if (this.f3918n.m8216a()) {
                new C2290b(this, this, this.f3923s, c2770g).run();
            } else {
                m6191a(new C2290b(this, this, this.f3923s, c2770g));
            }
        }
    }

    public void m6195b(boolean z) {
        C3095y.m9469a();
        ManagerApp.m7914e();
        if (C2958p.aj()) {
            C3095y.m9471a("restore purchase: has plus subscription, not restoring history");
            if (z) {
                Toast.makeText(this, R.string.success_reclaim_purchase, 0).show();
            }
        } else if (this.f3918n.m8216a()) {
            C3095y.m9471a("restore purchase: managerinappbilling is initialized");
            new C2288a(this, z).run();
        } else {
            C3095y.m9471a("restore purchase: inAppBilling not initialized, attempting initialization");
            m6191a(new C2288a(this, z));
        }
    }

    @Nullable
    public String m6169J() {
        for (String str : this.f3919o) {
            if (C2925l.m8621a(str)) {
                return str;
            }
        }
        return null;
    }

    public void m6170K() {
        ManagerApp.m7914e();
        if (C2958p.aj()) {
            ManagerApp.m7915f().m5903a("travel_request", "get_recs");
            if (ManagerApp.m7916g().m8517d()) {
                ManagerApp.m7916g().m8511a((au) this);
            }
        }
    }

    public void m6189a(@NonNull TinderLocation tinderLocation) {
        ManagerApp.m7914e();
        if (C2958p.aj()) {
            TinderLocation c = ManagerApp.m7916g().m8516c();
            int i = (c == null || !c.equals(tinderLocation)) ? 0 : 1;
            if (i == 0) {
                ManagerApp.m7915f().m5903a("travel_request", "get_recs");
                ManagerApp.m7915f().m5902a((Object) "travel_request");
                ManagerApp.m7916g().m8514a(tinderLocation, this);
                return;
            }
            return;
        }
        launchPlusSubscriptionPaywall(2);
    }

    public void m6171L() {
        startActivityForResult(new Intent(this, ActivityPassport.class), 9455);
    }

    public void m6172M() {
        m6161B();
        C2646k a = this.f3906a.m6350a();
        if (a != null) {
            a.m7366c(true);
        }
    }

    public void m6173N() {
        Toast.makeText(this, R.string.error_enabling_passport, 1).show();
    }

    public void m6174O() {
        m6161B();
        C2646k a = this.f3906a.m6350a();
        if (a != null) {
            a.m7368d(true);
        }
    }

    public void m6175P() {
        Toast.makeText(this, R.string.error_enabling_passport, 1).show();
    }

    public void m6176Q() {
        C2646k a = this.f3906a.m6350a();
        if (a != null) {
            a.m7366c(false);
        }
    }

    private void m6144a(@Nullable UserMeta userMeta) {
        C3095y.m9469a();
        if (userMeta != null) {
            if (this.f3919o == null) {
                this.f3919o = new ArrayList(3);
            } else {
                this.f3919o.clear();
            }
            for (Group group : userMeta.getGroups()) {
                if (TextUtils.equals(group.getType(), ProductAction.ACTION_PURCHASE) && !TextUtils.isEmpty(group.getKey())) {
                    this.f3919o.add(group.getKey());
                }
            }
            C3095y.m9471a("skus from usermeta groups:" + this.f3919o.toString());
            if (this.f3919o.isEmpty()) {
                C3095y.m9471a("Not Plus, and got no product purchase skus from user metadata!");
                if (userMeta.getGlobalConfig().isPlusEnabled() && !C2958p.aj()) {
                    C3095y.m9479c("Failed to set any product skus from user metadata!");
                    new Handler(Looper.getMainLooper()).postDelayed(new C22868(this), 2000);
                    return;
                }
                return;
            }
            m6145a(this.f3919o);
            return;
        }
        C3095y.m9479c("Failed to set product skus: no user data to work from.");
    }

    public void m6177R() {
        C3095y.m9469a();
        m5910V();
    }

    @Nullable
    private C2770g m6149b(@NonNull String str) {
        if (this.f3923s == null) {
            return null;
        }
        for (C2770g c2770g : this.f3923s) {
            if (str.equals(c2770g.m7888b())) {
                return c2770g;
            }
        }
        return null;
    }

    public void m6178S() {
        C3095y.m9469a();
        if (this.f3910f != null) {
            this.f3910f.addOnPageChangeListener(this);
        }
    }
}
