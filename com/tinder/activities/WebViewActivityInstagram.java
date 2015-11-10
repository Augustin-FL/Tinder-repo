package com.tinder.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.facebook.internal.NativeProtocol;
import com.facebook.stetho.BuildConfig;
import com.tinder.R;
import com.tinder.model.InstagramCodeError;
import com.tinder.p029a.C2239e;
import com.tinder.parse.C2973b;
import com.tinder.utils.C3095y;

public class WebViewActivityInstagram extends Activity {
    private WebView f4031a;
    @Nullable
    private String f4032b;
    @Nullable
    private String f4033c;
    private ProgressBar f4034d;

    /* renamed from: com.tinder.activities.WebViewActivityInstagram.a */
    public interface C2322a {
        void m6345a(InstagramCodeError instagramCodeError);

        void m6346a(String str);
    }

    /* renamed from: com.tinder.activities.WebViewActivityInstagram.1 */
    class C23231 implements C2322a {
        final /* synthetic */ WebViewActivityInstagram f4027a;

        C23231(WebViewActivityInstagram webViewActivityInstagram) {
            this.f4027a = webViewActivityInstagram;
        }

        public void m6348a(String str) {
            C3095y.m9471a("Instagram access code: " + str);
            Intent intent = this.f4027a.getIntent();
            intent.putExtra("access_code", str);
            this.f4027a.setResult(-1, intent);
            this.f4027a.finish();
        }

        public void m6347a(InstagramCodeError instagramCodeError) {
            C3095y.m9471a("louis");
            C3095y.m9471a("Instagram access code error: " + instagramCodeError);
            Intent intent = this.f4027a.getIntent();
            intent.putExtra("access_code_error", instagramCodeError);
            this.f4027a.setResult(99, intent);
            this.f4027a.finish();
        }
    }

    /* renamed from: com.tinder.activities.WebViewActivityInstagram.2 */
    class C23242 extends WebChromeClient {
        final /* synthetic */ WebViewActivityInstagram f4028a;

        C23242(WebViewActivityInstagram webViewActivityInstagram) {
            this.f4028a = webViewActivityInstagram;
        }

        public void onProgressChanged(WebView webView, int i) {
            if (i < 100 && this.f4028a.f4034d.getVisibility() == 8) {
                this.f4028a.f4034d.setVisibility(0);
            }
            if (i == 100) {
                this.f4028a.f4034d.setVisibility(8);
            }
        }
    }

    /* renamed from: com.tinder.activities.WebViewActivityInstagram.b */
    private class C2325b extends WebViewClient {
        final /* synthetic */ WebViewActivityInstagram f4029a;
        private C2322a f4030b;

        public C2325b(WebViewActivityInstagram webViewActivityInstagram, C2322a c2322a) {
            this.f4029a = webViewActivityInstagram;
            this.f4030b = c2322a;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, @NonNull String str) {
            C3095y.m9471a("shouldOverrideUrlLoading: " + str);
            String str2 = BuildConfig.FLAVOR;
            str2 = BuildConfig.FLAVOR;
            Uri parse = Uri.parse(str);
            if (!str.startsWith(C2239e.f3677T)) {
                return false;
            }
            String queryParameter = parse.getQueryParameter("code");
            if (TextUtils.isEmpty(queryParameter)) {
                this.f4030b.m6345a(C2973b.m8911a(parse));
            } else {
                this.f4030b.m6346a(queryParameter);
            }
            return true;
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            C3095y.m9479c(String.format("onReceivedError errorCode:[%s], description:[%s], failigUrl[%s]", new Object[]{Integer.valueOf(i), str, str2}));
            this.f4029a.finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_webview);
        if (getIntent().getExtras() != null) {
            this.f4032b = getIntent().getExtras().getString(NativeProtocol.WEB_DIALOG_URL);
            this.f4033c = getIntent().getExtras().getString("url_redirect");
        }
        if (TextUtils.isEmpty(this.f4032b)) {
            finish();
        }
        this.f4034d = (ProgressBar) findViewById(R.id.progress_web);
        this.f4031a = (WebView) findViewById(R.id.webView);
        CookieSyncManager.createInstance(this);
        CookieManager.getInstance().removeAllCookie();
        this.f4031a.setWebViewClient(new C2325b(this, new C23231(this)));
        this.f4031a.setWebChromeClient(new C23242(this));
        this.f4031a.getSettings().setJavaScriptEnabled(true);
        this.f4031a.getSettings().setSaveFormData(false);
        this.f4031a.getSettings().setSavePassword(false);
        this.f4031a.loadUrl(this.f4032b);
    }
}
