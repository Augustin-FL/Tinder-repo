package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener;
import com.google.android.gms.ads.internal.client.zzc;
import com.google.android.gms.ads.internal.client.zzd;
import com.google.android.gms.ads.internal.client.zzg;
import com.google.android.gms.ads.internal.client.zzo;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzx;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzcz;
import com.google.android.gms.internal.zzda;
import com.google.android.gms.internal.zzdb;
import com.google.android.gms.internal.zzeg;

public class AdLoader {
    private final Context mContext;
    private final zzg zznK;
    private final zzo zznL;

    public static class Builder {
        private final Context mContext;
        private final zzp zznM;

        Builder(Context context, zzp com_google_android_gms_ads_internal_client_zzp) {
            this.mContext = context;
            this.zznM = com_google_android_gms_ads_internal_client_zzp;
        }

        public Builder(Context context, String str) {
            this(context, zzd.zza(context, str, new zzeg()));
        }

        public AdLoader build() {
            try {
                return new AdLoader(this.mContext, this.zznM.zzbk());
            } catch (Throwable e) {
                zzb.zzb("Failed to build AdLoader.", e);
                return null;
            }
        }

        public Builder forAppInstallAd(OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
            try {
                this.zznM.zza(new zzcy(onAppInstallAdLoadedListener));
            } catch (Throwable e) {
                zzb.zzd("Failed to add app install ad listener", e);
            }
            return this;
        }

        public Builder forContentAd(OnContentAdLoadedListener onContentAdLoadedListener) {
            try {
                this.zznM.zza(new zzcz(onContentAdLoadedListener));
            } catch (Throwable e) {
                zzb.zzd("Failed to add content ad listener", e);
            }
            return this;
        }

        public Builder forCustomTemplateAd(String str, OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, OnCustomClickListener onCustomClickListener) {
            try {
                this.zznM.zza(str, new zzdb(onCustomTemplateAdLoadedListener), onCustomClickListener == null ? null : new zzda(onCustomClickListener));
            } catch (Throwable e) {
                zzb.zzd("Failed to add custom template ad listener", e);
            }
            return this;
        }

        public Builder withAdListener(AdListener adListener) {
            try {
                this.zznM.zzb(new zzc(adListener));
            } catch (Throwable e) {
                zzb.zzd("Failed to set AdListener.", e);
            }
            return this;
        }

        public Builder withNativeAdOptions(NativeAdOptions nativeAdOptions) {
            try {
                this.zznM.zza(new NativeAdOptionsParcel(nativeAdOptions));
            } catch (Throwable e) {
                zzb.zzd("Failed to specify native ad options", e);
            }
            return this;
        }
    }

    AdLoader(Context context, zzo com_google_android_gms_ads_internal_client_zzo) {
        this(context, com_google_android_gms_ads_internal_client_zzo, zzg.zzcA());
    }

    AdLoader(Context context, zzo com_google_android_gms_ads_internal_client_zzo, zzg com_google_android_gms_ads_internal_client_zzg) {
        this.mContext = context;
        this.zznL = com_google_android_gms_ads_internal_client_zzo;
        this.zznK = com_google_android_gms_ads_internal_client_zzg;
    }

    private void zza(zzx com_google_android_gms_ads_internal_client_zzx) {
        try {
            this.zznL.zze(this.zznK.zza(this.mContext, com_google_android_gms_ads_internal_client_zzx));
        } catch (Throwable e) {
            zzb.zzb("Failed to load ad.", e);
        }
    }

    public String getMediationAdapterClassName() {
        try {
            return this.zznL.getMediationAdapterClassName();
        } catch (Throwable e) {
            zzb.zzd("Failed to get the mediation adapter class name.", e);
            return null;
        }
    }

    public boolean isLoading() {
        try {
            return this.zznL.isLoading();
        } catch (Throwable e) {
            zzb.zzd("Failed to check if ad is loading.", e);
            return false;
        }
    }

    public void loadAd(AdRequest adRequest) {
        zza(adRequest.zzaF());
    }

    public void loadAd(PublisherAdRequest publisherAdRequest) {
        zza(publisherAdRequest.zzaF());
    }
}
