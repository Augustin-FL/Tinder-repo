package com.tinder.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.facebook.internal.WebDialog;
import com.tinder.R;
import com.tinder.p029a.C2239e;
import com.tinder.utils.al;

public class ag extends Dialog implements OnClickListener {
    private WebView f4433a;
    private String f4434b;

    /* renamed from: com.tinder.dialogs.ag.1 */
    class C24621 extends WebViewClient {
        final /* synthetic */ ag f4432a;

        C24621(ag agVar) {
            this.f4432a = agVar;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (this.f4432a.f4434b.equals(Uri.parse(str).getHost())) {
                return false;
            }
            return true;
        }
    }

    public ag(@NonNull Context context, String str, String str2) {
        super(context, WebDialog.DEFAULT_THEME);
        getWindow().setLayout(al.m9262a(context), al.m9285b(context));
        getWindow().setWindowAnimations(R.style.dialog_up_down_animation);
        setContentView(R.layout.view_web_dialog);
        findViewById(R.id.view_back_icon).setOnClickListener(this);
        TextView textView = (TextView) findViewById(R.id.view_back_title);
        textView.setText(str2);
        textView.setOnClickListener(this);
        this.f4433a = (WebView) findViewById(R.id.web_dialog_webview);
        if (!al.m9276a()) {
            this.f4433a.setLayerType(1, null);
        }
        this.f4433a.setScrollBarStyle(33554432);
        WebSettings settings = this.f4433a.getSettings();
        settings.setLoadWithOverviewMode(true);
        settings.setJavaScriptEnabled(true);
        settings.setBuiltInZoomControls(true);
        settings.setUserAgentString(C2239e.f3684a);
        this.f4433a.setWebViewClient(new C24621(this));
        this.f4433a.loadUrl(str);
        this.f4434b = Uri.parse(str).getHost();
    }

    public void onClick(@NonNull View view) {
        switch (view.getId()) {
            case R.id.view_back_icon:
                dismiss();
            case R.id.view_back_title:
                dismiss();
            default:
        }
    }
}
