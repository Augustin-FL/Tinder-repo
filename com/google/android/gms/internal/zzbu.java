package com.google.android.gms.internal;

import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzp;

@zzgk
public abstract class zzbu<T> {
    private final String zztP;
    private final T zztQ;

    /* renamed from: com.google.android.gms.internal.zzbu.1 */
    static class C10361 extends zzbu<Boolean> {
        C10361(String str, Boolean bool) {
            super(bool, null);
        }

        public /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
            return zzb(sharedPreferences);
        }

        public Boolean zzb(SharedPreferences sharedPreferences) {
            return Boolean.valueOf(sharedPreferences.getBoolean(getKey(), ((Boolean) zzdd()).booleanValue()));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbu.2 */
    static class C10372 extends zzbu<Integer> {
        C10372(String str, Integer num) {
            super(num, null);
        }

        public /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
            return zzc(sharedPreferences);
        }

        public Integer zzc(SharedPreferences sharedPreferences) {
            return Integer.valueOf(sharedPreferences.getInt(getKey(), ((Integer) zzdd()).intValue()));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbu.3 */
    static class C10383 extends zzbu<Long> {
        C10383(String str, Long l) {
            super(l, null);
        }

        public /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
            return zzd(sharedPreferences);
        }

        public Long zzd(SharedPreferences sharedPreferences) {
            return Long.valueOf(sharedPreferences.getLong(getKey(), ((Long) zzdd()).longValue()));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbu.4 */
    static class C10394 extends zzbu<String> {
        C10394(String str, String str2) {
            super(str2, null);
        }

        public /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
            return zze(sharedPreferences);
        }

        public String zze(SharedPreferences sharedPreferences) {
            return sharedPreferences.getString(getKey(), (String) zzdd());
        }
    }

    private zzbu(String str, T t) {
        this.zztP = str;
        this.zztQ = t;
        zzp.zzbF().zza(this);
    }

    public static zzbu<String> zzP(String str) {
        zzbu<String> zzc = zzc(str, (String) null);
        zzp.zzbF().zzb(zzc);
        return zzc;
    }

    public static zzbu<String> zzQ(String str) {
        zzbu<String> zzc = zzc(str, (String) null);
        zzp.zzbF().zzc(zzc);
        return zzc;
    }

    public static zzbu<Integer> zza(String str, int i) {
        return new C10372(str, Integer.valueOf(i));
    }

    public static zzbu<Boolean> zza(String str, Boolean bool) {
        return new C10361(str, bool);
    }

    public static zzbu<Long> zzb(String str, long j) {
        return new C10383(str, Long.valueOf(j));
    }

    public static zzbu<String> zzc(String str, String str2) {
        return new C10394(str, str2);
    }

    public T get() {
        return zzp.zzbG().zzd(this);
    }

    public String getKey() {
        return this.zztP;
    }

    protected abstract T zza(SharedPreferences sharedPreferences);

    public T zzdd() {
        return this.zztQ;
    }
}
