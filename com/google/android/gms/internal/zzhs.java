package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import java.util.concurrent.Future;

@zzgk
public final class zzhs {

    public interface zzb {
        void zzd(Bundle bundle);
    }

    private static abstract class zza extends zzhq {
        private zza() {
        }

        public void onStop() {
        }
    }

    /* renamed from: com.google.android.gms.internal.zzhs.1 */
    static class C11211 extends zza {
        final /* synthetic */ boolean zzHv;
        final /* synthetic */ Context zzrn;

        C11211(Context context, boolean z) {
            this.zzrn = context;
            this.zzHv = z;
            super();
        }

        public void zzdG() {
            Editor edit = zzhs.zzv(this.zzrn).edit();
            edit.putBoolean("use_https", this.zzHv);
            edit.apply();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzhs.2 */
    static class C11222 extends zza {
        final /* synthetic */ zzb zzHw;
        final /* synthetic */ Context zzrn;

        C11222(Context context, zzb com_google_android_gms_internal_zzhs_zzb) {
            this.zzrn = context;
            this.zzHw = com_google_android_gms_internal_zzhs_zzb;
            super();
        }

        public void zzdG() {
            SharedPreferences zzH = zzhs.zzv(this.zzrn);
            Bundle bundle = new Bundle();
            bundle.putBoolean("use_https", zzH.getBoolean("use_https", true));
            if (this.zzHw != null) {
                this.zzHw.zzd(bundle);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzhs.3 */
    static class C11233 extends zza {
        final /* synthetic */ int zzHx;
        final /* synthetic */ Context zzrn;

        C11233(Context context, int i) {
            this.zzrn = context;
            this.zzHx = i;
            super();
        }

        public void zzdG() {
            Editor edit = zzhs.zzv(this.zzrn).edit();
            edit.putInt("webview_cache_version", this.zzHx);
            edit.apply();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzhs.4 */
    static class C11244 extends zza {
        final /* synthetic */ zzb zzHw;
        final /* synthetic */ Context zzrn;

        C11244(Context context, zzb com_google_android_gms_internal_zzhs_zzb) {
            this.zzrn = context;
            this.zzHw = com_google_android_gms_internal_zzhs_zzb;
            super();
        }

        public void zzdG() {
            SharedPreferences zzH = zzhs.zzv(this.zzrn);
            Bundle bundle = new Bundle();
            bundle.putInt("webview_cache_version", zzH.getInt("webview_cache_version", 0));
            if (this.zzHw != null) {
                this.zzHw.zzd(bundle);
            }
        }
    }

    public static Future zza(Context context, int i) {
        return new C11233(context, i).zzgn();
    }

    public static Future zza(Context context, zzb com_google_android_gms_internal_zzhs_zzb) {
        return new C11222(context, com_google_android_gms_internal_zzhs_zzb).zzgn();
    }

    public static Future zza(Context context, boolean z) {
        return new C11211(context, z).zzgn();
    }

    public static Future zzb(Context context, zzb com_google_android_gms_internal_zzhs_zzb) {
        return new C11244(context, com_google_android_gms_internal_zzhs_zzb).zzgn();
    }

    private static SharedPreferences zzv(Context context) {
        return context.getSharedPreferences("admob", 0);
    }
}
