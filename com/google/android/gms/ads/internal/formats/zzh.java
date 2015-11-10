package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzn;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzbb;
import com.google.android.gms.internal.zzdg;
import com.google.android.gms.internal.zzgk;
import com.google.android.gms.internal.zzip;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

@zzgk
public class zzh {
    private final Context mContext;
    private zzip zzoL;
    private final VersionInfoParcel zzpa;
    private final Object zzpc;
    private final zzn zzwb;
    private final JSONObject zzwe;
    private final zzbb zzwf;
    private final zza zzwg;
    private final zzan zzwh;
    private boolean zzwi;
    private String zzwj;

    public interface zza {
        String getCustomTemplateId();

        void zza(zzh com_google_android_gms_ads_internal_formats_zzh);

        String zzdu();

        zza zzdv();
    }

    /* renamed from: com.google.android.gms.ads.internal.formats.zzh.1 */
    class C07141 implements zzdg {
        final /* synthetic */ zzh zzwk;

        /* renamed from: com.google.android.gms.ads.internal.formats.zzh.1.1 */
        class C07131 implements com.google.android.gms.internal.zziq.zza {
            final /* synthetic */ Map zzwl;
            final /* synthetic */ C07141 zzwm;

            C07131(C07141 c07141, Map map) {
                this.zzwm = c07141;
                this.zzwl = map;
            }

            public void zza(zzip com_google_android_gms_internal_zzip, boolean z) {
                this.zzwm.zzwk.zzwj = (String) this.zzwl.get(ShareConstants.WEB_DIALOG_PARAM_ID);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("messageType", "htmlLoaded");
                    jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_ID, this.zzwm.zzwk.zzwj);
                    this.zzwm.zzwk.zzwf.zzb("sendMessageToNativeJs", jSONObject);
                } catch (Throwable e) {
                    zzb.zzb("Unable to dispatch sendMessageToNativeJsevent", e);
                }
            }
        }

        C07141(zzh com_google_android_gms_ads_internal_formats_zzh) {
            this.zzwk = com_google_android_gms_ads_internal_formats_zzh;
        }

        public void zza(zzip com_google_android_gms_internal_zzip, Map<String, String> map) {
            this.zzwk.zzoL.zzgS().zza(new C07131(this, map));
            this.zzwk.zzoL.loadData((String) map.get("overlayHtml"), "text/html", HTTP.UTF_8);
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.formats.zzh.2 */
    class C07152 implements zzdg {
        final /* synthetic */ zzh zzwk;

        C07152(zzh com_google_android_gms_ads_internal_formats_zzh) {
            this.zzwk = com_google_android_gms_ads_internal_formats_zzh;
        }

        public void zza(zzip com_google_android_gms_internal_zzip, Map<String, String> map) {
            this.zzwk.zzoL.getWebView().setVisibility(0);
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.formats.zzh.3 */
    class C07163 implements zzdg {
        final /* synthetic */ zzh zzwk;

        C07163(zzh com_google_android_gms_ads_internal_formats_zzh) {
            this.zzwk = com_google_android_gms_ads_internal_formats_zzh;
        }

        public void zza(zzip com_google_android_gms_internal_zzip, Map<String, String> map) {
            this.zzwk.zzoL.getWebView().setVisibility(8);
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.formats.zzh.4 */
    class C07174 implements zzdg {
        final /* synthetic */ zzh zzwk;

        C07174(zzh com_google_android_gms_ads_internal_formats_zzh) {
            this.zzwk = com_google_android_gms_ads_internal_formats_zzh;
        }

        public void zza(zzip com_google_android_gms_internal_zzip, Map<String, String> map) {
            this.zzwk.zzoL.getWebView().setVisibility(8);
        }
    }

    /* renamed from: com.google.android.gms.ads.internal.formats.zzh.5 */
    class C07185 implements zzdg {
        final /* synthetic */ zzh zzwk;

        C07185(zzh com_google_android_gms_ads_internal_formats_zzh) {
            this.zzwk = com_google_android_gms_ads_internal_formats_zzh;
        }

        public void zza(zzip com_google_android_gms_internal_zzip, Map<String, String> map) {
            JSONObject jSONObject = new JSONObject();
            try {
                for (String str : map.keySet()) {
                    jSONObject.put(str, map.get(str));
                }
                jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_ID, this.zzwk.zzwj);
                this.zzwk.zzwf.zzb("sendMessageToNativeJs", jSONObject);
            } catch (Throwable e) {
                zzb.zzb("Unable to dispatch sendMessageToNativeJs event", e);
            }
        }
    }

    public zzh(Context context, zzn com_google_android_gms_ads_internal_zzn, zzbb com_google_android_gms_internal_zzbb, zzan com_google_android_gms_internal_zzan, JSONObject jSONObject, zza com_google_android_gms_ads_internal_formats_zzh_zza, VersionInfoParcel versionInfoParcel) {
        this.zzpc = new Object();
        this.mContext = context;
        this.zzwb = com_google_android_gms_ads_internal_zzn;
        this.zzwf = com_google_android_gms_internal_zzbb;
        this.zzwh = com_google_android_gms_internal_zzan;
        this.zzwe = jSONObject;
        this.zzwg = com_google_android_gms_ads_internal_formats_zzh_zza;
        this.zzpa = versionInfoParcel;
    }

    public void performClick(String str) {
        zzx.zzch("performClick must be called on the main UI thread.");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("asset", str);
            jSONObject.put("template", this.zzwg.zzdu());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ad", this.zzwe);
            jSONObject2.put(Promotion.ACTION_CLICK, jSONObject);
            jSONObject2.put("has_custom_click_handler", this.zzwb.zzr(this.zzwg.getCustomTemplateId()) != null);
            this.zzwf.zza("google.afma.nativeAds.handleClickGmsg", jSONObject2);
        } catch (Throwable e) {
            zzb.zzb("Unable to create click JSON.", e);
        }
    }

    public void recordImpression() {
        zzx.zzch("recordImpression must be called on the main UI thread.");
        zzl(true);
        this.zzwb.zzaP();
    }

    public zzb zza(OnClickListener onClickListener) {
        zza zzdv = this.zzwg.zzdv();
        if (zzdv == null) {
            return null;
        }
        zzb com_google_android_gms_ads_internal_formats_zzb = new zzb(this.mContext, zzdv);
        com_google_android_gms_ads_internal_formats_zzb.setLayoutParams(new LayoutParams(-1, -1));
        com_google_android_gms_ads_internal_formats_zzb.zzdq().setOnClickListener(onClickListener);
        com_google_android_gms_ads_internal_formats_zzb.zzdq().setContentDescription("Ad attribution icon");
        return com_google_android_gms_ads_internal_formats_zzb;
    }

    public void zzb(MotionEvent motionEvent) {
        this.zzwh.zza(motionEvent);
    }

    public void zzb(View view, Map<String, WeakReference<View>> map) {
        zzx.zzch("performClick must be called on the main UI thread.");
        for (Entry entry : map.entrySet()) {
            if (view.equals((View) ((WeakReference) entry.getValue()).get())) {
                performClick((String) entry.getKey());
                return;
            }
        }
    }

    public zzip zzdy() {
        this.zzoL = zzdz();
        this.zzoL.getWebView().setVisibility(8);
        this.zzwf.zza("/loadHtml", new C07141(this));
        this.zzwf.zza("/showOverlay", new C07152(this));
        this.zzwf.zza("/hideOverlay", new C07163(this));
        this.zzoL.zzgS().zza("/hideOverlay", new C07174(this));
        this.zzoL.zzgS().zza("/sendMessageToSdk", new C07185(this));
        return this.zzoL;
    }

    zzip zzdz() {
        return zzp.zzby().zza(this.mContext, AdSizeParcel.zzs(this.mContext), false, false, this.zzwh, this.zzpa);
    }

    public void zzh(View view) {
    }

    public void zzi(View view) {
        synchronized (this.zzpc) {
            if (this.zzwi) {
            } else if (!view.isShown()) {
            } else if (view.getGlobalVisibleRect(new Rect(), null)) {
                recordImpression();
            }
        }
    }

    protected void zzl(boolean z) {
        this.zzwi = z;
    }
}
