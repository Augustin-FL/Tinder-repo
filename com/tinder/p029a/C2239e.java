package com.tinder.p029a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import com.android.volley.C0304h;
import com.android.volley.Request;
import com.android.volley.toolbox.C0340n;
import com.tinder.enums.Environment;
import com.tinder.managers.ManagerApp;
import com.tinder.utils.C3095y;
import com.tinder.utils.ae;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: com.tinder.a.e */
public class C2239e {
    public static String f3658A;
    public static String f3659B;
    public static String f3660C;
    public static String f3661D;
    public static String f3662E;
    public static String f3663F;
    public static String f3664G;
    public static String f3665H;
    public static String f3666I;
    public static String f3667J;
    public static String f3668K;
    public static String f3669L;
    public static String f3670M;
    public static String f3671N;
    public static String f3672O;
    public static String f3673P;
    public static String f3674Q;
    public static String f3675R;
    public static String f3676S;
    public static String f3677T;
    public static String f3678U;
    public static String f3679V;
    public static String f3680W;
    public static String f3681X;
    public static String f3682Y;
    public static String f3683Z;
    public static final String f3684a;
    public static String aa;
    public static String ab;
    public static String ac;
    public static String ad;
    public static String ae;
    public static String af;
    public static String f3685b;
    public static String f3686c;
    public static String f3687d;
    public static String f3688e;
    public static String f3689f;
    public static String f3690g;
    public static String f3691h;
    public static String f3692i;
    public static String f3693j;
    public static String f3694k;
    public static String f3695l;
    public static String f3696m;
    public static String f3697n;
    public static String f3698o;
    public static String f3699p;
    public static String f3700q;
    public static String f3701r;
    public static String f3702s;
    public static String f3703t;
    public static String f3704u;
    public static String f3705v;
    public static String f3706w;
    public static String f3707x;
    public static String f3708y;
    public static String f3709z;
    private Environment ag;
    private C0304h ah;
    private final CookieManager ai;
    private final ae aj;

    /* renamed from: com.tinder.a.e.1 */
    static /* synthetic */ class C22381 {
        static final /* synthetic */ int[] f3657a;

        static {
            f3657a = new int[Environment.values().length];
            try {
                f3657a[Environment.PROD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3657a[Environment.PRODTEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f3657a[Environment.DEV.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    static {
        f3684a = "Tinder Android Version " + ManagerApp.f5582e;
    }

    public C2239e(@NonNull Context context) {
        this.ag = Environment.PROD;
        this.aj = new ae(context);
        this.ai = new CookieManager(this.aj, CookiePolicy.ACCEPT_ALL);
        CookieHandler.setDefault(this.ai);
        this.ah = C0340n.m382a(context);
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                ae = String.valueOf(packageManager.getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (Throwable e) {
                C3095y.m9474a("Failed to get package info from package manager", e);
            }
        }
        ad = String.valueOf(VERSION.SDK_INT);
        C3095y.m9471a("APP VERSION IS: " + ae + " OS VERSION IS: " + ad);
        m5899a();
    }

    public void m5901a(Environment environment) {
        this.ag = environment;
        m5899a();
    }

    public void m5899a() {
        switch (C22381.f3657a[this.ag.ordinal()]) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                f3685b = "https://api.gotinder.com";
                f3686c = "https://content.gotinder.com";
                f3687d = "https://content.gotinder.com";
                af = "https://api.gotinder.com/assets";
                break;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                f3685b = "https://prodtest2.gotinder.com";
                f3686c = "https://prodtest2.gotinder.com";
                f3687d = "http://prodtest-imageupload.gotinder.com";
                af = "https://prodtest2.gotinder.com/assets";
                break;
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                f3685b = "https://dev-stable.gotinder.com";
                f3686c = "https://content-dev.gotinder.com";
                f3687d = "https://content-dev.gotinder.com";
                af = "https://prodtest.gotinder.com/assets";
                break;
        }
        f3688e = "/media";
        f3689f = f3686c + f3688e;
        f3696m = f3685b + "/user/";
        f3697n = f3685b + "/auth";
        f3698o = f3696m + "matches/";
        f3691h = f3687d + f3688e + "/moment";
        f3690g = f3685b + "/moment";
        f3692i = f3685b + "/feed";
        f3694k = f3692i + "/moments";
        f3693j = f3692i + "/likes";
        f3695l = f3685b + "/user/moments?";
        f3699p = f3696m + "ping";
        f3700q = f3685b + "/profile";
        f3701r = f3696m + "recs?" + "locale" + "=%s";
        f3702s = f3685b + "/updates";
        f3703t = f3685b + "/device/android";
        f3704u = f3685b + "/like/%s";
        f3671N = f3704u + '?' + "user_traveling=true";
        f3672O = f3704u + '?' + "rec_traveling=true";
        f3673P = f3704u + '?' + "user_traveling=true" + '&' + "rec_traveling=true";
        f3705v = f3685b + "/pass/%s";
        f3683Z = f3704u + "/super/";
        ab = f3704u + '?' + "super=1";
        ac = f3705v + '?' + "super=1";
        f3706w = f3685b + "/report/";
        f3707x = f3706w + "user/";
        f3708y = f3685b + "/list";
        f3709z = f3685b + "/sendtoken";
        f3658A = f3685b + "/validate";
        f3662E = f3685b + "/connections";
        f3659B = f3685b + "/friend/";
        f3660C = "/accept";
        f3661D = "/deny";
        f3663F = f3685b + "/location/search?locale=%s&s=%s";
        f3664G = f3685b + "/location/search?locale=%s&lat=%f&lon=%f";
        f3665H = f3685b + "/passport/user/travel";
        f3666I = f3685b + "/passport/user/reset";
        f3670M = f3685b + "/location/popular?locale=%s";
        f3667J = f3685b + "/purchase";
        f3669L = "/android";
        f3668K = f3667J + f3669L;
        f3674Q = f3685b + "/meta";
        aa = f3685b + "/meta/user/tutorials";
        f3675R = f3685b + "/report/ack";
        f3676S = f3685b + "/instagram/authorize";
        f3677T = "http://gotinder.com/instagram/authenticate";
        f3678U = f3685b + "/instagram/authenticate";
        f3679V = f3685b + "/instagram/deauthorize";
        f3680W = f3685b + "/instagram/refresh";
        f3681X = f3696m + "%s" + "/common_connections";
        f3682Y = f3685b + "/feedback";
        f3683Z = f3685b + "/like/%s/super";
    }

    public void m5900a(Request request) {
        this.ah.m272a(request);
    }

    public void m5902a(Object obj) {
        this.ah.m275a(obj);
    }

    public void m5903a(@NonNull Object... objArr) {
        for (Object a : objArr) {
            this.ah.m275a(a);
        }
    }
}
