package com.tinder.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import java.util.Map;

public class VideoEnabledWebView extends WebView {
    private boolean addedJavascriptInterface;
    private C3099a videoEnabledWebChromeClient;

    /* renamed from: com.tinder.video.VideoEnabledWebView.a */
    public class C3097a {
        final /* synthetic */ VideoEnabledWebView f6664a;

        public C3097a(VideoEnabledWebView videoEnabledWebView) {
            this.f6664a = videoEnabledWebView;
        }
    }

    public VideoEnabledWebView(Context context) {
        super(context);
        this.addedJavascriptInterface = false;
    }

    public VideoEnabledWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.addedJavascriptInterface = false;
    }

    public VideoEnabledWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.addedJavascriptInterface = false;
    }

    public boolean isVideoFullscreen() {
        return this.videoEnabledWebChromeClient != null && this.videoEnabledWebChromeClient.isVideoFullscreen();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        getSettings().setJavaScriptEnabled(true);
        if (webChromeClient instanceof C3099a) {
            this.videoEnabledWebChromeClient = (C3099a) webChromeClient;
        }
        super.setWebChromeClient(webChromeClient);
    }

    public void loadData(String str, String str2, String str3) {
        addJavascriptInterface();
        super.loadData(str, str2, str3);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        addJavascriptInterface();
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public void loadUrl(String str) {
        addJavascriptInterface();
        super.loadUrl(str);
    }

    public void loadUrl(String str, Map<String, String> map) {
        addJavascriptInterface();
        super.loadUrl(str, map);
    }

    private void addJavascriptInterface() {
        if (!this.addedJavascriptInterface) {
            addJavascriptInterface(new C3097a(this), "_VideoEnabledWebView");
            this.addedJavascriptInterface = true;
        }
    }
}
