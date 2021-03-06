package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.List;

@zzgk
public class zzcs implements NativeCustomTemplateAd {
    private final zzcr zzwC;

    public zzcs(zzcr com_google_android_gms_internal_zzcr) {
        this.zzwC = com_google_android_gms_internal_zzcr;
    }

    public List<String> getAvailableAssetNames() {
        try {
            return this.zzwC.getAvailableAssetNames();
        } catch (Throwable e) {
            zzb.zzb("Failed to get available asset names.", e);
            return null;
        }
    }

    public String getCustomTemplateId() {
        try {
            return this.zzwC.getCustomTemplateId();
        } catch (Throwable e) {
            zzb.zzb("Failed to get custom template id.", e);
            return null;
        }
    }

    public Image getImage(String str) {
        try {
            zzcj zzT = this.zzwC.zzT(str);
            if (zzT != null) {
                return new zzck(zzT);
            }
        } catch (Throwable e) {
            zzb.zzb("Failed to get image.", e);
        }
        return null;
    }

    public CharSequence getText(String str) {
        try {
            return this.zzwC.zzS(str);
        } catch (Throwable e) {
            zzb.zzb("Failed to get string.", e);
            return null;
        }
    }

    public void performClick(String str) {
        try {
            this.zzwC.performClick(str);
        } catch (Throwable e) {
            zzb.zzb("Failed to perform click.", e);
        }
    }

    public void recordImpression() {
        try {
            this.zzwC.recordImpression();
        } catch (Throwable e) {
            zzb.zzb("Failed to record impression.", e);
        }
    }
}
