package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.C0702d;
import com.google.ads.mediation.C0703e;
import com.google.ads.mediation.C0704f;
import com.google.ads.mediation.C0705g;
import com.google.ads.mediation.C0706h;
import com.google.ads.mediation.MediationServerParameters;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;

@zzgk
public final class zzet<NETWORK_EXTRAS extends C0706h, SERVER_PARAMETERS extends MediationServerParameters> implements C0703e, C0705g {
    private final zzej zzyY;

    /* renamed from: com.google.android.gms.internal.zzet.10 */
    class AnonymousClass10 implements Runnable {
        final /* synthetic */ zzet zzze;
        final /* synthetic */ ErrorCode zzzf;

        AnonymousClass10(zzet com_google_android_gms_internal_zzet, ErrorCode errorCode) {
            this.zzze = com_google_android_gms_internal_zzet;
            this.zzzf = errorCode;
        }

        public void run() {
            try {
                this.zzze.zzyY.onAdFailedToLoad(zzeu.zza(this.zzzf));
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdFailedToLoad.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzet.1 */
    class C10771 implements Runnable {
        final /* synthetic */ zzet zzze;

        C10771(zzet com_google_android_gms_internal_zzet) {
            this.zzze = com_google_android_gms_internal_zzet;
        }

        public void run() {
            try {
                this.zzze.zzyY.onAdClicked();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdClicked.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzet.2 */
    class C10782 implements Runnable {
        final /* synthetic */ zzet zzze;

        C10782(zzet com_google_android_gms_internal_zzet) {
            this.zzze = com_google_android_gms_internal_zzet;
        }

        public void run() {
            try {
                this.zzze.zzyY.onAdOpened();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdOpened.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzet.3 */
    class C10793 implements Runnable {
        final /* synthetic */ zzet zzze;

        C10793(zzet com_google_android_gms_internal_zzet) {
            this.zzze = com_google_android_gms_internal_zzet;
        }

        public void run() {
            try {
                this.zzze.zzyY.onAdLoaded();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLoaded.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzet.4 */
    class C10804 implements Runnable {
        final /* synthetic */ zzet zzze;

        C10804(zzet com_google_android_gms_internal_zzet) {
            this.zzze = com_google_android_gms_internal_zzet;
        }

        public void run() {
            try {
                this.zzze.zzyY.onAdClosed();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdClosed.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzet.5 */
    class C10815 implements Runnable {
        final /* synthetic */ zzet zzze;
        final /* synthetic */ ErrorCode zzzf;

        C10815(zzet com_google_android_gms_internal_zzet, ErrorCode errorCode) {
            this.zzze = com_google_android_gms_internal_zzet;
            this.zzzf = errorCode;
        }

        public void run() {
            try {
                this.zzze.zzyY.onAdFailedToLoad(zzeu.zza(this.zzzf));
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdFailedToLoad.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzet.6 */
    class C10826 implements Runnable {
        final /* synthetic */ zzet zzze;

        C10826(zzet com_google_android_gms_internal_zzet) {
            this.zzze = com_google_android_gms_internal_zzet;
        }

        public void run() {
            try {
                this.zzze.zzyY.onAdLeftApplication();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLeftApplication.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzet.7 */
    class C10837 implements Runnable {
        final /* synthetic */ zzet zzze;

        C10837(zzet com_google_android_gms_internal_zzet) {
            this.zzze = com_google_android_gms_internal_zzet;
        }

        public void run() {
            try {
                this.zzze.zzyY.onAdOpened();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdOpened.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzet.8 */
    class C10848 implements Runnable {
        final /* synthetic */ zzet zzze;

        C10848(zzet com_google_android_gms_internal_zzet) {
            this.zzze = com_google_android_gms_internal_zzet;
        }

        public void run() {
            try {
                this.zzze.zzyY.onAdLoaded();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLoaded.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzet.9 */
    class C10859 implements Runnable {
        final /* synthetic */ zzet zzze;

        C10859(zzet com_google_android_gms_internal_zzet) {
            this.zzze = com_google_android_gms_internal_zzet;
        }

        public void run() {
            try {
                this.zzze.zzyY.onAdClosed();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdClosed.", e);
            }
        }
    }

    public zzet(zzej com_google_android_gms_internal_zzej) {
        this.zzyY = com_google_android_gms_internal_zzej;
    }

    public void onClick(C0702d<?, ?> c0702d) {
        zzb.zzaC("Adapter called onClick.");
        if (zzk.zzcE().zzgI()) {
            try {
                this.zzyY.onAdClicked();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdClicked.", e);
                return;
            }
        }
        zzb.zzaE("onClick must be called on the main UI thread.");
        zza.zzIy.post(new C10771(this));
    }

    public void onDismissScreen(C0702d<?, ?> c0702d) {
        zzb.zzaC("Adapter called onDismissScreen.");
        if (zzk.zzcE().zzgI()) {
            try {
                this.zzyY.onAdClosed();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdClosed.", e);
                return;
            }
        }
        zzb.zzaE("onDismissScreen must be called on the main UI thread.");
        zza.zzIy.post(new C10804(this));
    }

    public void onDismissScreen(C0704f<?, ?> c0704f) {
        zzb.zzaC("Adapter called onDismissScreen.");
        if (zzk.zzcE().zzgI()) {
            try {
                this.zzyY.onAdClosed();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdClosed.", e);
                return;
            }
        }
        zzb.zzaE("onDismissScreen must be called on the main UI thread.");
        zza.zzIy.post(new C10859(this));
    }

    public void onFailedToReceiveAd(C0702d<?, ?> c0702d, ErrorCode errorCode) {
        zzb.zzaC("Adapter called onFailedToReceiveAd with error. " + errorCode);
        if (zzk.zzcE().zzgI()) {
            try {
                this.zzyY.onAdFailedToLoad(zzeu.zza(errorCode));
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        zzb.zzaE("onFailedToReceiveAd must be called on the main UI thread.");
        zza.zzIy.post(new C10815(this, errorCode));
    }

    public void onFailedToReceiveAd(C0704f<?, ?> c0704f, ErrorCode errorCode) {
        zzb.zzaC("Adapter called onFailedToReceiveAd with error " + errorCode + ".");
        if (zzk.zzcE().zzgI()) {
            try {
                this.zzyY.onAdFailedToLoad(zzeu.zza(errorCode));
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        zzb.zzaE("onFailedToReceiveAd must be called on the main UI thread.");
        zza.zzIy.post(new AnonymousClass10(this, errorCode));
    }

    public void onLeaveApplication(C0702d<?, ?> c0702d) {
        zzb.zzaC("Adapter called onLeaveApplication.");
        if (zzk.zzcE().zzgI()) {
            try {
                this.zzyY.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        zzb.zzaE("onLeaveApplication must be called on the main UI thread.");
        zza.zzIy.post(new C10826(this));
    }

    public void onLeaveApplication(C0704f<?, ?> c0704f) {
        zzb.zzaC("Adapter called onLeaveApplication.");
        if (zzk.zzcE().zzgI()) {
            try {
                this.zzyY.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        zzb.zzaE("onLeaveApplication must be called on the main UI thread.");
        zza.zzIy.post(new Runnable() {
            final /* synthetic */ zzet zzze;

            {
                this.zzze = r1;
            }

            public void run() {
                try {
                    this.zzze.zzyY.onAdLeftApplication();
                } catch (Throwable e) {
                    zzb.zzd("Could not call onAdLeftApplication.", e);
                }
            }
        });
    }

    public void onPresentScreen(C0702d<?, ?> c0702d) {
        zzb.zzaC("Adapter called onPresentScreen.");
        if (zzk.zzcE().zzgI()) {
            try {
                this.zzyY.onAdOpened();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdOpened.", e);
                return;
            }
        }
        zzb.zzaE("onPresentScreen must be called on the main UI thread.");
        zza.zzIy.post(new C10837(this));
    }

    public void onPresentScreen(C0704f<?, ?> c0704f) {
        zzb.zzaC("Adapter called onPresentScreen.");
        if (zzk.zzcE().zzgI()) {
            try {
                this.zzyY.onAdOpened();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdOpened.", e);
                return;
            }
        }
        zzb.zzaE("onPresentScreen must be called on the main UI thread.");
        zza.zzIy.post(new C10782(this));
    }

    public void onReceivedAd(C0702d<?, ?> c0702d) {
        zzb.zzaC("Adapter called onReceivedAd.");
        if (zzk.zzcE().zzgI()) {
            try {
                this.zzyY.onAdLoaded();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLoaded.", e);
                return;
            }
        }
        zzb.zzaE("onReceivedAd must be called on the main UI thread.");
        zza.zzIy.post(new C10848(this));
    }

    public void onReceivedAd(C0704f<?, ?> c0704f) {
        zzb.zzaC("Adapter called onReceivedAd.");
        if (zzk.zzcE().zzgI()) {
            try {
                this.zzyY.onAdLoaded();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLoaded.", e);
                return;
            }
        }
        zzb.zzaE("onReceivedAd must be called on the main UI thread.");
        zza.zzIy.post(new C10793(this));
    }
}
