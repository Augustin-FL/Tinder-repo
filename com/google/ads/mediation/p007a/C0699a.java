package com.google.ads.mediation.p007a;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.C0698a;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;

/* renamed from: com.google.ads.mediation.a.a */
public final class C0699a extends C0698a implements MediationBannerAdapter, MediationInterstitialAdapter {
    protected Bundle m961a(Bundle bundle, Bundle bundle2) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("gw", 1);
        bundle.putString("mad_hac", bundle2.getString("mad_hac"));
        if (!TextUtils.isEmpty(bundle2.getString("adJson"))) {
            bundle.putString("_ad", bundle2.getString("adJson"));
        }
        bundle.putBoolean("_noRefresh", true);
        return bundle;
    }
}
