package com.tinder.dialogs;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.ViewPager.PageTransformer;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.SmoothScroller.Action;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tinder.R;
import com.tinder.adapters.C2365r;
import com.tinder.adapters.C2384w;
import com.tinder.iap.util.C2770g;
import com.tinder.managers.C2807a;
import com.tinder.managers.ManagerApp;
import com.tinder.model.SparksEvent;
import com.tinder.p030d.aw;
import com.tinder.utils.C3079p;
import com.tinder.utils.C3080q;
import com.tinder.utils.C3093w;
import com.tinder.utils.C3095y;
import com.tinder.utils.ai;
import com.tinder.utils.ai.C2495a;
import com.tinder.utils.al;
import com.tinder.views.BaseScroller;
import com.tinder.views.DividerItemDecoration;
import com.viewpagerindicator.CirclePageIndicator;
import java.lang.reflect.Field;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.tinder.dialogs.o */
public class C2501o extends Dialog implements OnCancelListener {
    private aw f4506a;
    private List<C2770g> f4507b;
    private int f4508c;
    private C2770g f4509d;
    private boolean f4510e;
    private boolean f4511f;
    private final Handler f4512g;
    private int f4513h;
    private ViewPager f4514i;
    private C2384w f4515j;
    private List<String> f4516k;

    /* renamed from: com.tinder.dialogs.o.1 */
    class C24961 implements C2495a {
        final /* synthetic */ C2501o f4499a;

        C24961(C2501o c2501o) {
            this.f4499a = c2501o;
        }

        public void m6884a(View view, int i) {
            this.f4499a.f4509d = this.f4499a.f4515j.m6491a(i);
            if (this.f4499a.f4509d != null) {
                SparksEvent sparksEvent = new SparksEvent("TinderPlus.Select");
                sparksEvent.put("term", Integer.valueOf(C3080q.m9421a(this.f4499a.f4509d.m7888b())));
                C2770g b = C3080q.m9424b(this.f4499a.f4507b);
                if (b != null) {
                    sparksEvent.put("basePrice", Float.valueOf(b.m7890d()));
                }
                try {
                    sparksEvent.put("products", C2501o.m6888a(this.f4499a.f4507b));
                } catch (Throwable e) {
                    C3095y.m9474a("Failed to create product JSON for product selection anayltics", e);
                }
                sparksEvent.put("features", this.f4499a.f4516k);
                sparksEvent.put("sku", this.f4499a.f4509d.m7888b());
                sparksEvent.put("price", Float.valueOf(this.f4499a.f4509d.m7890d()));
                sparksEvent.put("locale", C3093w.m9462b());
                sparksEvent.put("currency", this.f4499a.f4509d.m7886a());
                sparksEvent.put("paywallVersion", Integer.valueOf(4));
                sparksEvent.put("from", Integer.valueOf(this.f4499a.f4513h));
                sparksEvent.put("percentLikesLeft", Integer.valueOf(ManagerApp.m7924o().m8692a()));
                sparksEvent.put("unlimitedLikesOffered", Boolean.valueOf(ManagerApp.m7914e().ao()));
                sparksEvent.put("superLikesRemaining", Integer.valueOf(this.f4499a.f4508c));
                C2807a.m8056a(sparksEvent);
                this.f4499a.f4509d.m7887a(this.f4499a.f4516k);
                this.f4499a.f4506a.m6133a(this.f4499a.f4509d);
                return;
            }
            C3095y.m9479c("User tried to buy a product at position " + i + ", but no product exists there!?!");
        }
    }

    /* renamed from: com.tinder.dialogs.o.2 */
    class C24972 implements Runnable {
        final /* synthetic */ C2501o f4500a;

        C24972(C2501o c2501o) {
            this.f4500a = c2501o;
        }

        public void run() {
            if (this.f4500a.f4510e) {
                m6885a();
                return;
            }
            int currentItem = this.f4500a.f4514i.getCurrentItem();
            if (currentItem < this.f4500a.f4514i.getAdapter().getCount() - 1) {
                this.f4500a.f4514i.setCurrentItem(currentItem + 1, true);
            } else {
                this.f4500a.f4514i.setCurrentItem(0, true);
            }
            m6885a();
        }

        private void m6885a() {
            if (!this.f4500a.f4511f) {
                this.f4500a.f4512g.postDelayed(this, this.f4500a.f4510e ? 8000 : 2000);
            }
        }
    }

    /* renamed from: com.tinder.dialogs.o.3 */
    class C24983 implements OnTouchListener {
        final /* synthetic */ Runnable f4501a;
        final /* synthetic */ C2501o f4502b;

        C24983(C2501o c2501o, Runnable runnable) {
            this.f4502b = c2501o;
            this.f4501a = runnable;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getActionMasked()) {
                case C3374b.SmoothProgressBar_spbStyle /*0*/:
                    this.f4502b.f4510e = true;
                    this.f4502b.f4512g.removeCallbacks(this.f4501a);
                    break;
                case C3374b.SmoothProgressBar_spb_color /*1*/:
                    this.f4502b.f4510e = false;
                    this.f4502b.f4512g.postDelayed(this.f4501a, 8000);
                    break;
            }
            return false;
        }
    }

    /* renamed from: com.tinder.dialogs.o.4 */
    class C24994 implements PageTransformer {
        final /* synthetic */ C2501o f4503a;

        C24994(C2501o c2501o) {
            this.f4503a = c2501o;
        }

        public void transformPage(View view, float f) {
            int width = view.getWidth();
            if (f <= 1.0f) {
                TextView textView = (TextView) view.findViewById(R.id.paywall_perk_title);
                TextView textView2 = (TextView) view.findViewById(R.id.paywall_perk_byline);
                ((ImageView) view.findViewById(R.id.paywall_perk_image)).setTranslationX((float) (((double) f) * (((double) width) / 1.5d)));
                textView.setTranslationX(((float) (width / 1)) * f);
                textView2.setTranslationX((float) (((double) f) * (((double) width) / 0.5d)));
            }
        }
    }

    /* renamed from: com.tinder.dialogs.o.5 */
    class C25005 extends SimpleOnPageChangeListener {
        int f4504a;
        final /* synthetic */ C2501o f4505b;

        C25005(C2501o c2501o) {
            this.f4505b = c2501o;
            this.f4504a = 0;
        }

        public void onPageSelected(int i) {
            try {
                SparksEvent sparksEvent = new SparksEvent("TinderPlus.PaywallFeatureView");
                sparksEvent.put("products", C2501o.m6888a(this.f4505b.f4507b));
                sparksEvent.put("features", this.f4505b.f4516k);
                if (this.f4505b.f4516k.size() > i) {
                    sparksEvent.put("feature", this.f4505b.f4516k.get(i));
                }
                sparksEvent.put("position", Integer.valueOf(i));
                if (this.f4504a != i) {
                    sparksEvent.put("direction", Integer.valueOf(this.f4504a > i ? 0 : 1));
                }
                sparksEvent.put("from", Integer.valueOf(this.f4505b.f4513h));
                sparksEvent.put("superLikesRemaining", Integer.valueOf(this.f4505b.f4508c));
                sparksEvent.put("unlimitedLikesOffered", Boolean.valueOf(ManagerApp.m7914e().ao()));
                C2807a.m8056a(sparksEvent);
            } catch (Throwable e) {
                C3095y.m9474a("Failed to create product JSON for analytics.", e);
            }
            this.f4504a = i;
        }
    }

    public C2501o(@NonNull Context context, @NonNull List<C2770g> list, @Nullable List<String> list2, int i, @NonNull int i2, aw awVar) {
        super(context, R.style.PlusPaywallDialog);
        this.f4510e = false;
        this.f4511f = false;
        this.f4512g = new Handler();
        if (list2 != null) {
            int indexOf;
            switch (i) {
                case C3374b.SmoothProgressBar_spbStyle /*0*/:
                    indexOf = list2.indexOf("undo");
                    break;
                case C3374b.SmoothProgressBar_spb_color /*1*/:
                    indexOf = list2.indexOf("passport");
                    break;
                case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                    indexOf = list2.indexOf("passport");
                    break;
                case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                    indexOf = list2.indexOf("unlimited_likes");
                    break;
                case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                    indexOf = list2.indexOf("super_like");
                    break;
                default:
                    indexOf = -1;
                    break;
            }
            if (indexOf > -1) {
                Collections.swap(list2, 0, indexOf);
            }
            if (!ManagerApp.m7914e().ao()) {
                C3095y.m9483d("Has not viewed roadblock, removing unlimited likes.");
                if (list2.contains("unlimited_likes")) {
                    List<String> arrayList = new ArrayList(list2);
                    arrayList.remove("unlimited_likes");
                    list2 = arrayList;
                }
            }
        }
        this.f4516k = list2;
        this.f4507b = list;
        this.f4508c = i2;
        this.f4513h = i;
        this.f4506a = awVar;
        Window window = getWindow();
        LayoutParams attributes = window.getAttributes();
        attributes.width = (int) al.m9260a(0.92f);
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.dialog_up_down_animation);
        setContentView(R.layout.dialog_paywall);
        m6889a(context);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        setOnCancelListener(this);
    }

    public void show() {
        super.show();
        m6892b();
    }

    public void onCancel(@Nullable DialogInterface dialogInterface) {
        List arrayList = new ArrayList(this.f4507b.size());
        List arrayList2 = new ArrayList(this.f4507b.size());
        for (C2770g c2770g : this.f4507b) {
            arrayList.add(c2770g.m7888b());
            arrayList2.add(Float.valueOf(c2770g.m7890d()));
        }
        SparksEvent sparksEvent = new SparksEvent("TinderPlus.Cancel");
        C2770g c2770g2 = C3080q.m9424b(this.f4507b);
        if (c2770g2 != null) {
            sparksEvent.put("basePrice", Float.valueOf(c2770g2.m7890d()));
            sparksEvent.put("currency", c2770g2.m7886a());
        }
        if (this.f4509d != null) {
            sparksEvent.put("term", Integer.valueOf(C3080q.m9421a(this.f4509d.m7888b())));
        }
        try {
            sparksEvent.put("products", C2501o.m6888a(this.f4507b));
        } catch (Throwable e) {
            C3095y.m9474a("Failed to create JSON for concel analytics", e);
        }
        sparksEvent.put("features", this.f4516k);
        sparksEvent.put("skus", arrayList);
        sparksEvent.put("prices", arrayList2);
        sparksEvent.put("locale", C3093w.m9462b());
        sparksEvent.put("from", Integer.valueOf(this.f4513h));
        sparksEvent.put("paywallVersion", Integer.valueOf(4));
        sparksEvent.put("percentLikesLeft", Integer.valueOf(ManagerApp.m7924o().m8692a()));
        sparksEvent.put("unlimitedLikesOffered", Boolean.valueOf(ManagerApp.m7914e().ao()));
        sparksEvent.put("superLikesRemaining", Integer.valueOf(this.f4508c));
        C2807a.m8056a(sparksEvent);
        dismiss();
    }

    @TargetApi(21)
    private void m6889a(Context context) {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.paywall_list_options);
        this.f4514i = (ViewPager) findViewById(R.id.paywall_view_pager);
        CirclePageIndicator circlePageIndicator = (CirclePageIndicator) findViewById(R.id.paywall_pager_indicator);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.paywall_savings_container);
        TextView textView = (TextView) findViewById(R.id.paywall_savings);
        this.f4514i.setAdapter(new C2365r(context, this.f4516k));
        circlePageIndicator.setViewPager(this.f4514i);
        this.f4515j = new C2384w(context, this.f4507b, C3080q.f6630b);
        LayoutManager c3079p = new C3079p(recyclerView, 1, false);
        c3079p.m9420a(2);
        recyclerView.addOnItemTouchListener(new ai(getContext(), new C24961(this)));
        recyclerView.setHasFixedSize(true);
        if (VERSION.SDK_INT > 21) {
            recyclerView.addItemDecoration(new DividerItemDecoration(getContext().getDrawable(R.drawable.shape_white_bar)));
        } else {
            recyclerView.addItemDecoration(new DividerItemDecoration(getContext().getResources().getDrawable(R.drawable.shape_white_bar)));
        }
        recyclerView.setLayoutManager(c3079p);
        recyclerView.setAdapter(this.f4515j);
        if (this.f4507b.size() > 1) {
            C2770g a = C3080q.m9422a(this.f4507b);
            C2770g b = C3080q.m9424b(this.f4507b);
            if (a == null || b == null || a.m7889c() <= b.m7889c()) {
                linearLayout.setVisibility(8);
            } else {
                int parseInt;
                Matcher matcher = C3080q.f6630b.matcher(a.m7888b());
                if (matcher.matches() && matcher.groupCount() == 1) {
                    parseInt = Integer.parseInt(matcher.group(1));
                } else {
                    linearLayout.setVisibility(8);
                    parseInt = Action.UNDEFINED_DURATION;
                }
                int a2 = C3080q.m9421a(b.m7888b());
                if (parseInt > Action.UNDEFINED_DURATION) {
                    double c = 1.0d - (((double) (a.m7889c() / ((long) parseInt))) / ((double) (b.m7889c() / ((long) a2))));
                    NumberFormat percentInstance = NumberFormat.getPercentInstance();
                    percentInstance.setMinimumFractionDigits(0);
                    textView.setText(percentInstance.format(c));
                }
            }
        } else {
            linearLayout.setVisibility(8);
        }
        Runnable c24972 = new C24972(this);
        this.f4512g.postDelayed(c24972, 2000);
        try {
            BaseScroller baseScroller = new BaseScroller(getContext());
            baseScroller.setDuration(800);
            baseScroller.setFriction(0.025f);
            Field declaredField = this.f4514i.getClass().getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            declaredField.set(this.f4514i, baseScroller);
        } catch (Throwable e) {
            C3095y.m9474a("Failed to override scroller in view pager, view pager implementation has no field 'mScroller'.", e);
        } catch (Throwable e2) {
            C3095y.m9474a("Failed to set paywall scroller found via reflection", e2);
        }
        this.f4514i.setOnTouchListener(new C24983(this, c24972));
        this.f4514i.setPageTransformer(false, new C24994(this));
        OnPageChangeListener c25005 = new C25005(this);
        this.f4514i.addOnPageChangeListener(c25005);
        c25005.onPageSelected(0);
    }

    public static JSONArray m6888a(List<C2770g> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (C2770g c2770g : list) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sku", c2770g.m7888b());
            jSONObject.put("price", (double) c2770g.m7890d());
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    public int m6902a() {
        return this.f4513h;
    }

    private void m6892b() {
        SparksEvent sparksEvent = new SparksEvent("TinderPlus.Paywall");
        List arrayList = new ArrayList(this.f4507b.size());
        for (C2770g c2770g : this.f4507b) {
            arrayList.add(c2770g.m7888b());
            sparksEvent.put(c2770g.m7888b(), Boolean.valueOf(true));
        }
        C2770g c2770g2 = C3080q.m9424b(this.f4507b);
        if (c2770g2 != null) {
            sparksEvent.put("basePrice", Float.valueOf(c2770g2.m7890d()));
            sparksEvent.put("currency", c2770g2.m7886a());
        }
        sparksEvent.put("skus", arrayList);
        try {
            sparksEvent.put("products", C2501o.m6888a(this.f4507b));
        } catch (Throwable e) {
            C3095y.m9474a("Failed to create json for products for Paywall view analytics", e);
        }
        sparksEvent.put("features", this.f4516k);
        sparksEvent.put("locale", C3093w.m9462b());
        sparksEvent.put("from", Integer.valueOf(this.f4513h));
        sparksEvent.put("paywallVersion", Integer.valueOf(4));
        sparksEvent.put("percentLikesLeft", Integer.valueOf(ManagerApp.m7924o().m8692a()));
        sparksEvent.put("unlimitedLikesOffered", Boolean.valueOf(ManagerApp.m7914e().ao()));
        C2807a.m8056a(sparksEvent);
    }

    public void dismiss() {
        super.dismiss();
        this.f4511f = true;
    }
}
