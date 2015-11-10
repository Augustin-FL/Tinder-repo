package com.google.android.gms.internal;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

@zzgk
public class zziu extends WebChromeClient {
    private final zzip zzoL;

    /* renamed from: com.google.android.gms.internal.zziu.1 */
    static class C11411 implements OnCancelListener {
        final /* synthetic */ JsResult zzJx;

        C11411(JsResult jsResult) {
            this.zzJx = jsResult;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.zzJx.cancel();
        }
    }

    /* renamed from: com.google.android.gms.internal.zziu.2 */
    static class C11422 implements OnClickListener {
        final /* synthetic */ JsResult zzJx;

        C11422(JsResult jsResult) {
            this.zzJx = jsResult;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.zzJx.cancel();
        }
    }

    /* renamed from: com.google.android.gms.internal.zziu.3 */
    static class C11433 implements OnClickListener {
        final /* synthetic */ JsResult zzJx;

        C11433(JsResult jsResult) {
            this.zzJx = jsResult;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.zzJx.confirm();
        }
    }

    /* renamed from: com.google.android.gms.internal.zziu.4 */
    static class C11444 implements OnCancelListener {
        final /* synthetic */ JsPromptResult zzJy;

        C11444(JsPromptResult jsPromptResult) {
            this.zzJy = jsPromptResult;
        }

        public void onCancel(DialogInterface dialogInterface) {
            this.zzJy.cancel();
        }
    }

    /* renamed from: com.google.android.gms.internal.zziu.5 */
    static class C11455 implements OnClickListener {
        final /* synthetic */ JsPromptResult zzJy;

        C11455(JsPromptResult jsPromptResult) {
            this.zzJy = jsPromptResult;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.zzJy.cancel();
        }
    }

    /* renamed from: com.google.android.gms.internal.zziu.6 */
    static class C11466 implements OnClickListener {
        final /* synthetic */ JsPromptResult zzJy;
        final /* synthetic */ EditText zzJz;

        C11466(JsPromptResult jsPromptResult, EditText editText) {
            this.zzJy = jsPromptResult;
            this.zzJz = editText;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.zzJy.confirm(this.zzJz.getText().toString());
        }
    }

    /* renamed from: com.google.android.gms.internal.zziu.7 */
    static /* synthetic */ class C11477 {
        static final /* synthetic */ int[] zzJA;

        static {
            zzJA = new int[MessageLevel.values().length];
            try {
                zzJA[MessageLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                zzJA[MessageLevel.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                zzJA[MessageLevel.LOG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                zzJA[MessageLevel.TIP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                zzJA[MessageLevel.DEBUG.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public zziu(zzip com_google_android_gms_internal_zzip) {
        this.zzoL = com_google_android_gms_internal_zzip;
    }

    private static void zza(Builder builder, String str, JsResult jsResult) {
        builder.setMessage(str).setPositiveButton(17039370, new C11433(jsResult)).setNegativeButton(17039360, new C11422(jsResult)).setOnCancelListener(new C11411(jsResult)).create().show();
    }

    private static void zza(Context context, Builder builder, String str, String str2, JsPromptResult jsPromptResult) {
        View linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        View textView = new TextView(context);
        textView.setText(str);
        View editText = new EditText(context);
        editText.setText(str2);
        linearLayout.addView(textView);
        linearLayout.addView(editText);
        builder.setView(linearLayout).setPositiveButton(17039370, new C11466(jsPromptResult, editText)).setNegativeButton(17039360, new C11455(jsPromptResult)).setOnCancelListener(new C11444(jsPromptResult)).create().show();
    }

    private final Context zzc(WebView webView) {
        if (!(webView instanceof zzip)) {
            return webView.getContext();
        }
        zzip com_google_android_gms_internal_zzip = (zzip) webView;
        Context zzgN = com_google_android_gms_internal_zzip.zzgN();
        return zzgN == null ? com_google_android_gms_internal_zzip.getContext() : zzgN;
    }

    private final boolean zzho() {
        return zzp.zzbx().zza(this.zzoL.getContext().getPackageManager(), this.zzoL.getContext().getPackageName(), "android.permission.ACCESS_FINE_LOCATION") || zzp.zzbx().zza(this.zzoL.getContext().getPackageManager(), this.zzoL.getContext().getPackageName(), "android.permission.ACCESS_COARSE_LOCATION");
    }

    public final void onCloseWindow(WebView webView) {
        if (webView instanceof zzip) {
            zzd zzgQ = ((zzip) webView).zzgQ();
            if (zzgQ == null) {
                zzb.zzaE("Tried to close an AdWebView not associated with an overlay.");
                return;
            } else {
                zzgQ.close();
                return;
            }
        }
        zzb.zzaE("Tried to close a WebView that wasn't an AdWebView.");
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String str = "JS: " + consoleMessage.message() + " (" + consoleMessage.sourceId() + ":" + consoleMessage.lineNumber() + ")";
        if (str.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        switch (C11477.zzJA[consoleMessage.messageLevel().ordinal()]) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                zzb.m1001e(str);
                break;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                zzb.zzaE(str);
                break;
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
            case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                zzb.zzaD(str);
                break;
            case C3374b.SmoothProgressBar_spb_speed /*5*/:
                zzb.zzaC(str);
                break;
            default:
                zzb.zzaD(str);
                break;
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebViewTransport webViewTransport = (WebViewTransport) message.obj;
        WebView webView2 = new WebView(webView.getContext());
        webView2.setWebViewClient(this.zzoL.zzgS());
        webViewTransport.setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    public final void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, QuotaUpdater quotaUpdater) {
        long j4 = 5242880 - j3;
        if (j4 <= 0) {
            quotaUpdater.updateQuota(j);
            return;
        }
        if (j == 0) {
            if (j2 > j4 || j2 > 1048576) {
                j2 = 0;
            }
        } else if (j2 == 0) {
            j2 = Math.min(Math.min(131072, j4) + j, 1048576);
        } else {
            if (j2 <= Math.min(1048576 - j, j4)) {
                j += j2;
            }
            j2 = j;
        }
        quotaUpdater.updateQuota(j2);
    }

    public final void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        if (callback != null) {
            callback.invoke(str, zzho(), true);
        }
    }

    public final void onHideCustomView() {
        zzd zzgQ = this.zzoL.zzgQ();
        if (zzgQ == null) {
            zzb.zzaE("Could not get ad overlay when hiding custom view.");
        } else {
            zzgQ.zzex();
        }
    }

    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzc(webView), str, str2, null, jsResult, null, false);
    }

    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzc(webView), str, str2, null, jsResult, null, false);
    }

    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzc(webView), str, str2, null, jsResult, null, false);
    }

    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return zza(zzc(webView), str, str2, str3, null, jsPromptResult, true);
    }

    public final void onReachedMaxAppCacheSize(long j, long j2, QuotaUpdater quotaUpdater) {
        long j3 = 131072 + j;
        if (5242880 - j2 < j3) {
            quotaUpdater.updateQuota(0);
        } else {
            quotaUpdater.updateQuota(j3);
        }
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        zza(view, -1, customViewCallback);
    }

    protected final void zza(View view, int i, CustomViewCallback customViewCallback) {
        zzd zzgQ = this.zzoL.zzgQ();
        if (zzgQ == null) {
            zzb.zzaE("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        zzgQ.zza(view, customViewCallback);
        zzgQ.setRequestedOrientation(i);
    }

    protected boolean zza(Context context, String str, String str2, String str3, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        try {
            Builder builder = new Builder(context);
            builder.setTitle(str);
            if (z) {
                zza(context, builder, str2, str3, jsPromptResult);
            } else {
                zza(builder, str2, jsResult);
            }
        } catch (Throwable e) {
            zzb.zzd("Fail to display Dialog.", e);
        }
        return true;
    }
}
