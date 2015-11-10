package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.google.ads.mediation.p007a.C0699a;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdLoader.Builder;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.mediation.zzb;
import com.google.android.gms.internal.zzgk;
import java.util.Date;
import java.util.Set;

@zzgk
/* renamed from: com.google.ads.mediation.a */
public abstract class C0698a implements MediationBannerAdapter, MediationInterstitialAdapter, zza {
    protected AdView f735a;
    protected InterstitialAd f736b;
    private AdLoader f737c;

    /* renamed from: com.google.ads.mediation.a.a */
    static class C0693a extends NativeAppInstallAdMapper {
        private final NativeAppInstallAd f727a;

        public C0693a(NativeAppInstallAd nativeAppInstallAd) {
            this.f727a = nativeAppInstallAd;
            setHeadline(nativeAppInstallAd.getHeadline().toString());
            setImages(nativeAppInstallAd.getImages());
            setBody(nativeAppInstallAd.getBody().toString());
            setIcon(nativeAppInstallAd.getIcon());
            setCallToAction(nativeAppInstallAd.getCallToAction().toString());
            setStarRating(nativeAppInstallAd.getStarRating().doubleValue());
            setStore(nativeAppInstallAd.getStore().toString());
            setPrice(nativeAppInstallAd.getPrice().toString());
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
        }

        public void trackView(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.f727a);
            }
        }
    }

    /* renamed from: com.google.ads.mediation.a.b */
    static class C0694b extends NativeContentAdMapper {
        private final NativeContentAd f728a;

        public C0694b(NativeContentAd nativeContentAd) {
            this.f728a = nativeContentAd;
            setHeadline(nativeContentAd.getHeadline().toString());
            setImages(nativeContentAd.getImages());
            setBody(nativeContentAd.getBody().toString());
            setLogo(nativeContentAd.getLogo());
            setCallToAction(nativeContentAd.getCallToAction().toString());
            setAdvertiser(nativeContentAd.getAdvertiser().toString());
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
        }

        public void trackView(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.f728a);
            }
        }
    }

    /* renamed from: com.google.ads.mediation.a.c */
    static final class C0695c extends AdListener implements com.google.android.gms.ads.internal.client.zza {
        final C0698a f729a;
        final MediationBannerListener f730b;

        public C0695c(C0698a c0698a, MediationBannerListener mediationBannerListener) {
            this.f729a = c0698a;
            this.f730b = mediationBannerListener;
        }

        public void onAdClicked() {
            this.f730b.onAdClicked(this.f729a);
        }

        public void onAdClosed() {
            this.f730b.onAdClosed(this.f729a);
        }

        public void onAdFailedToLoad(int i) {
            this.f730b.onAdFailedToLoad(this.f729a, i);
        }

        public void onAdLeftApplication() {
            this.f730b.onAdLeftApplication(this.f729a);
        }

        public void onAdLoaded() {
            this.f730b.onAdLoaded(this.f729a);
        }

        public void onAdOpened() {
            this.f730b.onAdOpened(this.f729a);
        }
    }

    /* renamed from: com.google.ads.mediation.a.d */
    static final class C0696d extends AdListener implements com.google.android.gms.ads.internal.client.zza {
        final C0698a f731a;
        final MediationInterstitialListener f732b;

        public C0696d(C0698a c0698a, MediationInterstitialListener mediationInterstitialListener) {
            this.f731a = c0698a;
            this.f732b = mediationInterstitialListener;
        }

        public void onAdClicked() {
            this.f732b.onAdClicked(this.f731a);
        }

        public void onAdClosed() {
            this.f732b.onAdClosed(this.f731a);
        }

        public void onAdFailedToLoad(int i) {
            this.f732b.onAdFailedToLoad(this.f731a, i);
        }

        public void onAdLeftApplication() {
            this.f732b.onAdLeftApplication(this.f731a);
        }

        public void onAdLoaded() {
            this.f732b.onAdLoaded(this.f731a);
        }

        public void onAdOpened() {
            this.f732b.onAdOpened(this.f731a);
        }
    }

    /* renamed from: com.google.ads.mediation.a.e */
    static final class C0697e extends AdListener implements OnAppInstallAdLoadedListener, OnContentAdLoadedListener, com.google.android.gms.ads.internal.client.zza {
        final C0698a f733a;
        final zzb f734b;

        public C0697e(C0698a c0698a, zzb com_google_android_gms_ads_mediation_zzb) {
            this.f733a = c0698a;
            this.f734b = com_google_android_gms_ads_mediation_zzb;
        }

        public void onAdClicked() {
            this.f734b.zzd(this.f733a);
        }

        public void onAdClosed() {
            this.f734b.zzb(this.f733a);
        }

        public void onAdFailedToLoad(int i) {
            this.f734b.zza(this.f733a, i);
        }

        public void onAdLeftApplication() {
            this.f734b.zzc(this.f733a);
        }

        public void onAdLoaded() {
        }

        public void onAdOpened() {
            this.f734b.zza(this.f733a);
        }

        public void onAppInstallAdLoaded(NativeAppInstallAd nativeAppInstallAd) {
            this.f734b.zza(this.f733a, new C0693a(nativeAppInstallAd));
        }

        public void onContentAdLoaded(NativeContentAd nativeContentAd) {
            this.f734b.zza(this.f733a, new C0694b(nativeContentAd));
        }
    }

    protected abstract Bundle m957a(Bundle bundle, Bundle bundle2);

    Builder m958a(Context context, String str) {
        return new Builder(context, str);
    }

    AdRequest m959a(Context context, MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        AdRequest.Builder builder = new AdRequest.Builder();
        Date birthday = mediationAdRequest.getBirthday();
        if (birthday != null) {
            builder.setBirthday(birthday);
        }
        int gender = mediationAdRequest.getGender();
        if (gender != 0) {
            builder.setGender(gender);
        }
        Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            for (String addKeyword : keywords) {
                builder.addKeyword(addKeyword);
            }
        }
        Location location = mediationAdRequest.getLocation();
        if (location != null) {
            builder.setLocation(location);
        }
        if (mediationAdRequest.isTesting()) {
            builder.addTestDevice(zzk.zzcE().zzQ(context));
        }
        if (mediationAdRequest.taggedForChildDirectedTreatment() != -1) {
            builder.tagForChildDirectedTreatment(mediationAdRequest.taggedForChildDirectedTreatment() == 1);
        }
        builder.addNetworkExtrasBundle(C0699a.class, m957a(bundle, bundle2));
        return builder.build();
    }

    public String m960a(Bundle bundle) {
        return bundle.getString("pubid");
    }

    public View getBannerView() {
        return this.f735a;
    }

    public void onDestroy() {
        if (this.f735a != null) {
            this.f735a.destroy();
            this.f735a = null;
        }
        if (this.f736b != null) {
            this.f736b = null;
        }
        if (this.f737c != null) {
            this.f737c = null;
        }
    }

    public void onPause() {
        if (this.f735a != null) {
            this.f735a.pause();
        }
    }

    public void onResume() {
        if (this.f735a != null) {
            this.f735a.resume();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.f735a = new AdView(context);
        this.f735a.setAdSize(new AdSize(adSize.getWidth(), adSize.getHeight()));
        this.f735a.setAdUnitId(m960a(bundle));
        this.f735a.setAdListener(new C0695c(this, mediationBannerListener));
        this.f735a.loadAd(m959a(context, mediationAdRequest, bundle2, bundle));
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.f736b = new InterstitialAd(context);
        this.f736b.setAdUnitId(m960a(bundle));
        this.f736b.setAdListener(new C0696d(this, mediationInterstitialListener));
        this.f736b.loadAd(m959a(context, mediationAdRequest, bundle2, bundle));
    }

    public void requestNativeAd(Context context, zzb com_google_android_gms_ads_mediation_zzb, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        OnContentAdLoadedListener c0697e = new C0697e(this, com_google_android_gms_ads_mediation_zzb);
        Builder withAdListener = m958a(context, bundle.getString("pubid")).withAdListener(c0697e);
        NativeAdOptions nativeAdOptions = nativeMediationAdRequest.getNativeAdOptions();
        if (nativeAdOptions != null) {
            withAdListener.withNativeAdOptions(nativeAdOptions);
        }
        if (nativeMediationAdRequest.isAppInstallAdRequested()) {
            withAdListener.forAppInstallAd(c0697e);
        }
        if (nativeMediationAdRequest.isContentAdRequested()) {
            withAdListener.forContentAd(c0697e);
        }
        this.f737c = withAdListener.build();
        this.f737c.loadAd(m959a(context, nativeMediationAdRequest, bundle2, bundle));
    }

    public void showInterstitial() {
        this.f736b.show();
    }
}
