package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.apache.http.protocol.HTTP;

@zzgk
public class zzfk implements zzfi {
    private final Context mContext;
    final Set<WebView> zzBE;

    /* renamed from: com.google.android.gms.internal.zzfk.1 */
    class C10941 implements Runnable {
        final /* synthetic */ String zzBF;
        final /* synthetic */ String zzBG;
        final /* synthetic */ zzfk zzBH;

        /* renamed from: com.google.android.gms.internal.zzfk.1.1 */
        class C10931 extends WebViewClient {
            final /* synthetic */ C10941 zzBI;
            final /* synthetic */ WebView zzrZ;

            C10931(C10941 c10941, WebView webView) {
                this.zzBI = c10941;
                this.zzrZ = webView;
            }

            public void onPageFinished(WebView webView, String str) {
                zzb.zzaC("Loading assets have finished");
                this.zzBI.zzBH.zzBE.remove(this.zzrZ);
            }

            public void onReceivedError(WebView webView, int i, String str, String str2) {
                zzb.zzaE("Loading assets have failed.");
                this.zzBI.zzBH.zzBE.remove(this.zzrZ);
            }
        }

        C10941(zzfk com_google_android_gms_internal_zzfk, String str, String str2) {
            this.zzBH = com_google_android_gms_internal_zzfk;
            this.zzBF = str;
            this.zzBG = str2;
        }

        public void run() {
            WebView zzfb = this.zzBH.zzfb();
            zzfb.setWebViewClient(new C10931(this, zzfb));
            this.zzBH.zzBE.add(zzfb);
            zzfb.loadDataWithBaseURL(this.zzBF, this.zzBG, "text/html", HTTP.UTF_8, null);
            zzb.zzaC("Fetching assets finished.");
        }
    }

    public zzfk(Context context) {
        this.zzBE = Collections.synchronizedSet(new HashSet());
        this.mContext = context;
    }

    public void zza(String str, String str2, String str3) {
        zzb.zzaC("Fetching assets for the given html");
        zzhu.zzHK.post(new C10941(this, str2, str3));
    }

    public WebView zzfb() {
        WebView webView = new WebView(this.mContext);
        webView.getSettings().setJavaScriptEnabled(true);
        return webView;
    }
}
