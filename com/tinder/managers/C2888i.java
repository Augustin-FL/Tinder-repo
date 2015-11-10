package com.tinder.managers;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.tinder.activities.WebViewActivityInstagram;
import com.tinder.p029a.C2239e;
import com.tinder.utils.C3071j;
import com.tinder.utils.C3095y;
import java.util.Locale;

/* renamed from: com.tinder.managers.i */
public class C2888i {
    private String m8491a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        ManagerApp.m7914e();
        boolean aj = C2958p.aj();
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append("fbe=" + str);
        }
        stringBuilder.append("&u=" + ManagerApp.m7922m().m8598c().f6120e.getId());
        if (aj) {
            stringBuilder.append("&p=true");
        }
        stringBuilder.append("&d=Android");
        stringBuilder.append("&m=" + C3071j.m9374d());
        stringBuilder.append("&os=" + VERSION.SDK_INT);
        stringBuilder.append("&ti=" + ManagerApp.m7934y());
        stringBuilder.append("&loc=" + Locale.getDefault());
        return stringBuilder.toString();
    }

    public void m8492a(@NonNull Activity activity, String str) {
        String str2 = "https://www.gotinder.com/faq" + "?" + m8491a(str);
        C3095y.m9471a("faq url: " + str2);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str2));
        activity.startActivity(intent);
    }

    public void m8493a(Fragment fragment) {
        if (fragment != null && fragment.getActivity() != null) {
            Intent intent = new Intent(fragment.getActivity(), WebViewActivityInstagram.class);
            intent.putExtra(NativeProtocol.WEB_DIALOG_URL, C2239e.f3676S);
            intent.putExtra("url_redirect", C2239e.f3677T);
            fragment.startActivityForResult(intent, 7);
        }
    }
}
