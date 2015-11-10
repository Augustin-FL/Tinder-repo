package com.android.volley.toolbox;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.http.AndroidHttpClient;
import android.os.Build.VERSION;
import com.android.volley.C0304h;
import com.facebook.stetho.volley.StethoNetwork;
import java.io.File;

/* renamed from: com.android.volley.toolbox.n */
public class C0340n {
    public static C0304h m383a(Context context, C0322e c0322e) {
        File file = new File(context.getCacheDir(), "volley");
        String str = "volley/0";
        try {
            String packageName = context.getPackageName();
            str = packageName + "/" + context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
        } catch (NameNotFoundException e) {
        }
        if (c0322e == null) {
            if (VERSION.SDK_INT >= 9) {
                c0322e = new C0326f();
            } else {
                c0322e = new C0323c(AndroidHttpClient.newInstance(str));
            }
        }
        C0304h c0304h = new C0304h(new C0321b(file), new StethoNetwork(c0322e));
        c0304h.m273a();
        return c0304h;
    }

    public static C0304h m382a(Context context) {
        return C0340n.m383a(context, null);
    }
}
