package com.tinder.activities;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.crashlytics.android.C0359a;
import com.facebook.internal.NativeProtocol;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringListener;
import com.tinder.R;
import com.tinder.base.ActivityBase;
import com.tinder.managers.ManagerApp;
import com.tinder.model.SparksEvent;
import com.tinder.utils.C3045a;
import com.tinder.utils.C3067g;
import com.tinder.utils.C3095y;
import com.tinder.utils.al;
import org.apache.http.HttpHost;
import org.apache.http.protocol.HTTP;

public class ActivityCallToActionBrowser extends ActivityBase {
    @NonNull
    public static String f3743a;
    private static boolean f3744b;
    @NonNull
    private Handler f3745c;
    private WebView f3746e;
    private Menu f3747f;
    private boolean f3748g;
    private TextView f3749h;
    private long f3750i;
    private ProgressBar f3751j;
    private ImageView f3752k;
    private boolean f3753l;
    private String f3754m;
    private String f3755n;
    private FailToLoadReason f3756o;

    /* renamed from: com.tinder.activities.ActivityCallToActionBrowser.1 */
    class C22461 implements OnClickListener {
        final /* synthetic */ ActivityCallToActionBrowser f3727a;

        C22461(ActivityCallToActionBrowser activityCallToActionBrowser) {
            this.f3727a = activityCallToActionBrowser;
        }

        public void onClick(View view) {
            this.f3727a.finish();
        }
    }

    /* renamed from: com.tinder.activities.ActivityCallToActionBrowser.2 */
    class C22472 extends WebChromeClient {
        final /* synthetic */ ActivityCallToActionBrowser f3728a;

        C22472(ActivityCallToActionBrowser activityCallToActionBrowser) {
            this.f3728a = activityCallToActionBrowser;
        }

        public void onReceivedTitle(@NonNull WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            this.f3728a.m5960a(webView.getTitle());
        }
    }

    /* renamed from: com.tinder.activities.ActivityCallToActionBrowser.3 */
    class C22503 extends WebViewClient {
        final /* synthetic */ ActivityCallToActionBrowser f3731a;
        private final String[] f3732b;

        /* renamed from: com.tinder.activities.ActivityCallToActionBrowser.3.1 */
        class C22491 implements Runnable {
            final /* synthetic */ C22503 f3730a;

            /* renamed from: com.tinder.activities.ActivityCallToActionBrowser.3.1.1 */
            class C22481 implements SpringListener {
                final /* synthetic */ C22491 f3729a;

                C22481(C22491 c22491) {
                    this.f3729a = c22491;
                }

                public void onSpringUpdate(@NonNull Spring spring) {
                    al.m9274a(this.f3729a.f3730a.f3731a.f3752k, (float) Math.min(1.0d, spring.getCurrentValue()));
                }

                public void onSpringAtRest(Spring spring) {
                    this.f3729a.f3730a.f3731a.f3751j.setVisibility(8);
                    this.f3729a.f3730a.f3731a.f3752k.setVisibility(8);
                }

                public void onSpringActivate(Spring spring) {
                    this.f3729a.f3730a.f3731a.f3751j.setVisibility(0);
                    this.f3729a.f3730a.f3731a.f3752k.setVisibility(0);
                }

                public void onSpringEndStateChange(Spring spring) {
                }
            }

            C22491(C22503 c22503) {
                this.f3730a = c22503;
            }

            public void run() {
                C3045a.m9201a().setCurrentValue(1.0d).setEndValue(0.0d).addListener(new C22481(this));
            }
        }

        C22503(ActivityCallToActionBrowser activityCallToActionBrowser) {
            this.f3731a = activityCallToActionBrowser;
            this.f3732b = new String[]{HttpHost.DEFAULT_SCHEME_NAME, "https", "ftp"};
        }

        private boolean m5937a(String str) {
            String scheme = Uri.parse(str).getScheme();
            for (Object equals : this.f3732b) {
                if (scheme.equals(equals)) {
                    return true;
                }
            }
            return false;
        }

        private boolean m5938b(@Nullable String str) {
            if (this.f3731a.f3754m == null || str == null || !str.equals(this.f3731a.f3754m)) {
                return false;
            }
            return true;
        }

        private String m5939c(String str) {
            return Uri.parse(str).getScheme();
        }

        public boolean shouldOverrideUrlLoading(@NonNull WebView webView, String str) {
            boolean a = m5937a(str);
            if (m5938b(str) && this.f3731a.f3746e.canGoBack()) {
                this.f3731a.f3746e.goBack();
                return false;
            } else if (a) {
                webView.loadUrl(str);
                return true;
            } else {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                try {
                    this.f3731a.startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    String c = m5939c(str);
                    c = Character.toUpperCase(c.charAt(0)) + c.substring(1);
                    Toast.makeText(this.f3731a, String.format(this.f3731a.getResources().getString(R.string.mad_ave_no_intent_to_launch), new Object[]{c}), 0).show();
                }
                return true;
            }
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            this.f3731a.m5945a(FailToLoadReason.BROWSER_ERROR);
        }

        public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            this.f3731a.m5945a(FailToLoadReason.BROWSER_AUTH_REQUEST);
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            this.f3731a.m5945a(FailToLoadReason.BROWSER_SSL_ERROR);
        }

        public void onTooManyRedirects(WebView webView, Message message, Message message2) {
            this.f3731a.m5945a(FailToLoadReason.BROWSER_TOO_MANY_REDIRECTS);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (this.f3731a.f3755n == null) {
                this.f3731a.f3755n = str;
            }
            this.f3731a.f3754m = str;
            this.f3731a.onPrepareOptionsMenu(this.f3731a.f3747f);
            if (this.f3731a.f3746e.copyBackForwardList().getSize() == 1) {
                this.f3731a.f3750i = System.currentTimeMillis();
                this.f3731a.m5949b("AdDetails.Open").fire();
                return;
            }
            this.f3731a.m5949b("AdDetails.BrowseStart").put(NativeProtocol.WEB_DIALOG_URL, str).fire();
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (!this.f3731a.f3753l) {
                this.f3731a.f3753l = true;
                this.f3731a.f3745c.post(new C22491(this));
                this.f3731a.f3751j.setVisibility(8);
            }
            this.f3731a.m5949b("AdDetails.BrowseEnd").put(NativeProtocol.WEB_DIALOG_URL, str).fire();
        }
    }

    public enum FailToLoadReason {
        NO_EXTRAS(Integer.valueOf(R.string.mad_ave_error_no_extras), true),
        MISSING_URL(Integer.valueOf(R.string.mad_ave_error_missing_url), true),
        ALREADY_RUNNING(Integer.valueOf(R.string.mad_ave_error_already_running), false),
        BROWSER_ERROR(Integer.valueOf(R.string.mad_ave_error_browser_error), true),
        BROWSER_AUTH_REQUEST(Integer.valueOf(R.string.mad_ave_error_browser_auth_request), true),
        BROWSER_SSL_ERROR(Integer.valueOf(R.string.mad_ave_error_browser_ssl_error), true),
        BROWSER_TOO_MANY_REDIRECTS(Integer.valueOf(R.string.mad_ave_error_browser_too_many_redirects), true);
        
        private Integer f3741h;
        private boolean f3742i;

        private FailToLoadReason(Integer num, boolean z) {
            this.f3741h = num;
            this.f3742i = z;
        }

        public boolean m5940a() {
            return this.f3742i;
        }

        public Integer m5941b() {
            return this.f3741h;
        }
    }

    public ActivityCallToActionBrowser() {
        this.f3745c = new Handler(Looper.getMainLooper());
    }

    static {
        f3743a = "URL";
        f3744b = false;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (f3744b) {
            m5945a(FailToLoadReason.ALREADY_RUNNING);
        }
        f3744b = true;
        setContentView(R.layout.activity_cta_viewer);
        m5954e();
        if (getIntent().getExtras() == null) {
            m5945a(FailToLoadReason.NO_EXTRAS);
        } else {
            String string = getIntent().getExtras().getString(f3743a);
            if (string == null || string.trim().isEmpty()) {
                m5945a(FailToLoadReason.MISSING_URL);
            } else {
                this.f3746e.loadUrl(string);
            }
        }
        f3744b = true;
    }

    private void m5945a(@NonNull FailToLoadReason failToLoadReason) {
        if (failToLoadReason.m5940a()) {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.mad_ave_loading_failure), 0).show();
        }
        Integer b = failToLoadReason.m5941b();
        if (b != null) {
            String string = getResources().getString(b.intValue());
            C3095y.m9479c(String.format("Failed to load CTA browser: %s", new Object[]{string}));
            C0359a.m445a(3, "CTA browser", string);
            m5949b("AdDetails.Error").put("errorMessage", string).fire();
        } else {
            C3095y.m9479c("Failed to load CTA browser, no error string provided");
        }
        this.f3756o = failToLoadReason;
        if (!ActivityManager.isRunningInTestHarness()) {
            finish();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_cta_viewer, menu);
        this.f3747f = menu;
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.webView_share:
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType(HTTP.PLAIN_TEXT_TYPE);
                intent.putExtra("android.intent.extra.SUBJECT", ManagerApp.m7931v().m7981l());
                intent.putExtra("android.intent.extra.TEXT", ManagerApp.m7931v().m7981l() + ' ' + ManagerApp.m7931v().m7982m());
                startActivity(Intent.createChooser(intent, getResources().getText(R.string.mad_ave_share)));
                break;
        }
        return true;
    }

    public boolean onPrepareOptionsMenu(@NonNull Menu menu) {
        if (this.f3747f != null) {
            MenuItem findItem = menu.findItem(R.id.webView_share);
            findItem.getIcon().setColorFilter(getResources().getColor(R.color.ab_text_color), Mode.SRC_ATOP);
            findItem.setVisible(this.f3748g);
        }
        return true;
    }

    private void m5954e() {
        View view = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.ab_title_text, null);
        getSupportActionBar().setCustomView(view);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayUseLogoEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        ((Toolbar) view.getParent()).setContentInsetsAbsolute(0, 0);
        this.f3749h = (TextView) view.findViewById(R.id.title);
        OnClickListener c22461 = new C22461(this);
        this.f3749h.setOnClickListener(c22461);
        view.findViewById(R.id.back).setOnClickListener(c22461);
        boolean z = C3067g.m9354b(ManagerApp.m7931v().m7982m()) && C3067g.m9354b(ManagerApp.m7931v().m7981l());
        this.f3748g = z;
        m5960a(getResources().getString(R.string.mad_ave_loading));
        this.f3751j = (ProgressBar) findViewById(R.id.progress);
        this.f3752k = (ImageView) findViewById(R.id.progress_bg);
        this.f3746e = (WebView) findViewById(R.id.webView);
        this.f3746e.setLayerType(2, null);
        this.f3746e.getSettings().setJavaScriptEnabled(true);
        this.f3746e.getSettings().setLoadWithOverviewMode(true);
        this.f3746e.getSettings().setUseWideViewPort(true);
        this.f3746e.setWebChromeClient(new C22472(this));
        this.f3746e.setWebViewClient(new C22503(this));
    }

    public void onBackPressed() {
        if (this.f3746e.canGoBackOrForward(-2)) {
            this.f3746e.goBack();
        } else {
            finish();
        }
    }

    protected void m5959a() {
        super.m5915a();
        overridePendingTransition(R.anim.activity_passport_in, 0);
    }

    protected void s_() {
        super.s_();
        overridePendingTransition(0, R.anim.activity_passport_out);
    }

    public void onPause() {
        al.m9268a(this.f3746e.getWindowToken(), (Activity) this);
        super.onPause();
    }

    public void finish() {
        m5949b("AdDetails.Close").put("timeViewed", Long.valueOf(System.currentTimeMillis() - this.f3750i)).fire();
        super.finish();
        f3744b = false;
    }

    public void m5960a(String str) {
        if (C3067g.m9353a(str)) {
            str = getResources().getString(R.string.mad_ave_loading);
        }
        if (this.f3749h != null) {
            this.f3749h.setText(str);
        }
    }

    @NonNull
    private SparksEvent m5949b(String str) {
        return new SparksEvent(str).put("creativeId", ManagerApp.m7931v().m7975f()).put("campaignId", ManagerApp.m7931v().m7974e()).put("provider", ManagerApp.m7931v().m7976g()).put("type", "webview").put("from", "recs").put(NativeProtocol.WEB_DIALOG_URL, this.f3754m).put("originalUrl", this.f3755n).put("method", "BUTTON");
    }
}
