package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.purchase.InAppPurchase;

@zzgk
public class zzfu implements InAppPurchase {
    private final zzfl zzBZ;

    public zzfu(zzfl com_google_android_gms_internal_zzfl) {
        this.zzBZ = com_google_android_gms_internal_zzfl;
    }

    public String getProductId() {
        try {
            return this.zzBZ.getProductId();
        } catch (Throwable e) {
            zzb.zzd("Could not forward getProductId to InAppPurchase", e);
            return null;
        }
    }

    public void recordPlayBillingResolution(int i) {
        try {
            this.zzBZ.recordPlayBillingResolution(i);
        } catch (Throwable e) {
            zzb.zzd("Could not forward recordPlayBillingResolution to InAppPurchase", e);
        }
    }

    public void recordResolution(int i) {
        try {
            this.zzBZ.recordResolution(i);
        } catch (Throwable e) {
            zzb.zzd("Could not forward recordResolution to InAppPurchase", e);
        }
    }
}
