package com.tinder.base;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import com.crashlytics.android.C0359a;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.search.SearchAuth.StatusCodes;
import com.tinder.R;
import com.tinder.activities.ActivityEditProfile;
import com.tinder.dialogs.C2533w;
import com.tinder.dialogs.ad;
import com.tinder.managers.C2807a;
import com.tinder.managers.C2833d;
import com.tinder.managers.C2833d.C2296a;
import com.tinder.managers.C2956n;
import com.tinder.managers.ManagerApp;
import com.tinder.model.GlobalConfig;
import com.tinder.model.InstagramDataSet;
import com.tinder.model.TinderReportNotification;
import com.tinder.model.UserMeta;
import com.tinder.p030d.C2409u;
import com.tinder.p030d.C2411t;
import com.tinder.p030d.ah;
import com.tinder.utils.C3095y;
import java.util.List;
import org.apache.http.entity.ContentLengthStrategy;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public abstract class ActivityBase extends AppCompatActivity implements ah {
    private boolean f3714a;
    private C2833d f3715b;
    @Nullable
    private ad f3716c;
    @Nullable
    protected C2416b f3717d;
    private FrameLayout f3718e;
    private final boolean f3719f;

    /* renamed from: com.tinder.base.ActivityBase.1 */
    class C24081 implements Runnable {
        final /* synthetic */ ActivityBase f4308a;

        C24081(ActivityBase activityBase) {
            this.f4308a = activityBase;
        }

        public void run() {
            this.f4308a.w_();
        }
    }

    /* renamed from: com.tinder.base.ActivityBase.2 */
    class C24122 implements C2411t {
        final /* synthetic */ ActivityBase f4310a;

        /* renamed from: com.tinder.base.ActivityBase.2.1 */
        class C24101 implements C2409u {
            final /* synthetic */ C24122 f4309a;

            C24101(C24122 c24122) {
                this.f4309a = c24122;
            }

            public void m6597a() {
                ManagerApp.m7914e().m8800F(true);
            }

            public void m6598b() {
            }
        }

        C24122(ActivityBase activityBase) {
            this.f4310a = activityBase;
        }

        public void m6601a() {
            ManagerApp.m7914e().m8800F(true);
            Intent intent = new Intent(this.f4310a, ActivityEditProfile.class);
            intent.addFlags(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
            intent.putExtra("instagramConnectValue", 4);
            this.f4310a.startActivity(intent);
            C2807a.m8058a("Profile.Edit");
        }

        public void m6602b() {
            ManagerApp.m7911b().m8131a(4, new C24101(this));
        }
    }

    /* renamed from: com.tinder.base.ActivityBase.a */
    private class C2414a implements Runnable {
        final /* synthetic */ ActivityBase f4312a;
        private TinderReportNotification f4313b;

        /* renamed from: com.tinder.base.ActivityBase.a.1 */
        class C24131 implements OnDismissListener {
            final /* synthetic */ C2414a f4311a;

            C24131(C2414a c2414a) {
                this.f4311a = c2414a;
            }

            public void onDismiss(DialogInterface dialogInterface) {
                this.f4311a.f4312a.f3716c = null;
            }
        }

        C2414a(ActivityBase activityBase, TinderReportNotification tinderReportNotification) {
            this.f4312a = activityBase;
            this.f4313b = tinderReportNotification;
        }

        public void run() {
            if (this.f4313b != null && !TextUtils.isEmpty(this.f4313b.getType())) {
                CharSequence toLowerCase = this.f4313b.getType().toLowerCase();
                if (TextUtils.equals("banned", toLowerCase)) {
                    C2956n.m8747a(this.f4312a);
                } else if (TextUtils.equals("warning", toLowerCase) && this.f4312a.f3716c == null) {
                    this.f4312a.f3716c = C2956n.m8744a(this.f4312a, this.f4313b);
                    this.f4312a.f3716c.setOnDismissListener(new C24131(this));
                    this.f4312a.f3716c.show();
                }
            }
        }
    }

    public ActivityBase() {
        this.f3717d = null;
        this.f3719f = false;
    }

    public ActivityBase(boolean z) {
        this.f3717d = null;
        this.f3719f = z;
    }

    protected int m5925c() {
        return R.layout.view_activity_base;
    }

    protected void onCreate(Bundle bundle) {
        C3095y.m9469a();
        super.onCreate(bundle);
        m5915a();
        setContentView(m5925c());
        this.f3718e = (FrameLayout) findViewById(R.id.frameLayout_activity_base);
        this.f3717d = new C2416b(this);
        m5927c((int) R.id.frameLayout_activity_base);
        this.f3715b = ManagerApp.m7913d();
    }

    public void setContentView(int i) {
        if (this.f3718e == null) {
            super.setContentView(i);
        } else {
            ((LayoutInflater) getSystemService("layout_inflater")).inflate(i, this.f3718e, true);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 9000:
                ManagerApp.m7913d().m8207g();
                if (i2 == -1) {
                    ManagerApp.m7913d().m8193a();
                    break;
                }
                break;
            case StatusCodes.AUTH_DISABLED /*10000*/:
                switch (i2) {
                    case ContentLengthStrategy.IDENTITY /*-1*/:
                        m5910V();
                        break;
                    case C3374b.SmoothProgressBar_spbStyle /*0*/:
                        m5911W();
                        break;
                    default:
                        break;
                }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onPostResume() {
        try {
            super.onPostResume();
        } catch (Throwable e) {
            C3095y.m9474a("Failed to call super post resume?", e);
        }
    }

    protected void m5915a() {
    }

    protected void s_() {
    }

    public void onPause() {
        super.onPause();
        if (this.f3719f) {
            this.f3715b.m8205e();
        }
        ManagerApp.m7911b().m8140a((ah) this);
    }

    protected void onResume() {
        super.onResume();
        if (this.f3719f) {
            this.f3715b.m8200b((Activity) this);
        }
        ManagerApp.m7911b().m8141b((ah) this);
    }

    public void m5908T() {
        try {
            getSupportActionBar().hide();
        } catch (Throwable e) {
            C3095y.m9474a("Failed to hide action bar", e);
        }
    }

    protected void m5927c(int i) {
        if (findViewById(i) != null) {
            this.f3717d.m6606a(i);
        }
    }

    public void m5917a(Fragment fragment) {
        try {
            this.f3717d.m6611b(fragment);
        } catch (IllegalStateException e) {
            C0359a.m446a(e.toString());
        }
    }

    public void m5919a(Fragment fragment, String str, int i, int i2, int i3, int i4) {
        try {
            if (this.f3717d != null && !fragment.isAdded()) {
                this.f3717d.m6609a(fragment, str, i, i2, i3, i4);
            }
        } catch (IllegalStateException e) {
            C0359a.m446a(e.toString());
        }
    }

    public void m5923b(Fragment fragment) {
        try {
            if (this.f3717d != null && !fragment.isAdded()) {
                this.f3717d.m6607a(fragment);
            }
        } catch (IllegalStateException e) {
            C0359a.m446a(e.toString());
        }
    }

    public void m5918a(Fragment fragment, String str) {
        try {
            if (this.f3717d != null && !fragment.isAdded()) {
                this.f3717d.m6608a(fragment, str);
            }
        } catch (IllegalStateException e) {
            C0359a.m446a(e.toString());
        }
    }

    @Nullable
    public Fragment m5926c(String str) {
        try {
            return this.f3717d.m6604a(str);
        } catch (IllegalStateException e) {
            C0359a.m446a(e.toString());
            return null;
        }
    }

    public void m5928c(Fragment fragment) {
        try {
            this.f3717d.m6612c(fragment);
        } catch (IllegalStateException e) {
            C0359a.m446a(e.toString());
        }
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                onBackPressed();
                break;
        }
        return true;
    }

    public void finish() {
        super.finish();
        s_();
    }

    public void m5909U() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        C3095y.m9471a("BACK STACK CHANGED, BACK STACK SIZE: " + supportFragmentManager.getBackStackEntryCount());
        for (int i = 0; i < supportFragmentManager.getBackStackEntryCount(); i++) {
            C3095y.m9471a("BACK STACK " + i + " : " + supportFragmentManager.getBackStackEntryAt(i).getName());
        }
    }

    protected void m5916a(Activity activity, C2296a c2296a) {
        this.f3715b.m8195a(activity, c2296a);
    }

    protected void m5920a(C2296a c2296a) {
        this.f3715b.m8197a(c2296a);
    }

    protected void w_() {
        C3095y.m9471a("Refreshing location.");
        if (!m5922a((Activity) this)) {
            new Handler().postDelayed(new C24081(this), 10000);
        }
    }

    public void m5910V() {
        C3095y.m9469a();
        if (m5912X()) {
            C3095y.m9471a("Location already enabled, proceed");
            return;
        }
        C3095y.m9476b("Unknown location state");
        w_();
    }

    public void m5911W() {
        C3095y.m9471a("Location settings prompt dismissed, proceeding");
        if (!this.f3714a) {
            m5910V();
        }
    }

    protected boolean m5922a(Activity activity) {
        return this.f3715b.m8199a(activity);
    }

    protected boolean m5912X() {
        return this.f3715b.m8202b();
    }

    public boolean m5913Y() {
        boolean e = ManagerApp.m7911b().m8144e();
        C3095y.m9471a("ready? " + e);
        return e;
    }

    public void m5921a(GlobalConfig globalConfig, @Nullable UserMeta userMeta) {
        if (userMeta == null) {
            return;
        }
        if (m5914Z()) {
            m5924b(userMeta.getTinderReportNotifications());
            if (userMeta.getInstagramDataSet() == null) {
                return;
            }
            if (!userMeta.getInstagramDataSet().isTokenRevoked() || ManagerApp.m7914e().aq()) {
                C3095y.m9471a("instagram dataset set onGlobalsSet");
                ManagerApp.m7911b().m8142c().setInstagramDataSet(userMeta.getInstagramDataSet());
                ManagerApp.m7914e().m8852j(userMeta.getInstagramDataSet().getUserName());
                return;
            }
            userMeta.setInstagramDataSet(new InstagramDataSet());
            new C2533w(this, new C24122(this)).show();
        } else if (userMeta.getInstagramDataSet() != null) {
            C3095y.m9471a("instagram dataset set onGlobalsSet");
            ManagerApp.m7911b().m8142c().setInstagramDataSet(userMeta.getInstagramDataSet());
            ManagerApp.m7914e().m8852j(userMeta.getInstagramDataSet().getUserName());
        }
    }

    public void m5924b(@NonNull List<TinderReportNotification> list) {
        if (!list.isEmpty()) {
            runOnUiThread(new C2414a(this, (TinderReportNotification) list.get(0)));
        }
    }

    public boolean m5914Z() {
        return true;
    }
}
