package com.google.android.gms.tagmanager;

import android.util.LruCache;
import com.google.android.gms.tagmanager.zzm.zza;

class zzba<K, V> implements zzl<K, V> {
    private LruCache<K, V> zzaQy;

    /* renamed from: com.google.android.gms.tagmanager.zzba.1 */
    class C12511 extends LruCache<K, V> {
        final /* synthetic */ zzba zzaQA;
        final /* synthetic */ zza zzaQz;

        C12511(zzba com_google_android_gms_tagmanager_zzba, int i, zza com_google_android_gms_tagmanager_zzm_zza) {
            this.zzaQA = com_google_android_gms_tagmanager_zzba;
            this.zzaQz = com_google_android_gms_tagmanager_zzm_zza;
            super(i);
        }

        protected int sizeOf(K k, V v) {
            return this.zzaQz.sizeOf(k, v);
        }
    }

    zzba(int i, zza<K, V> com_google_android_gms_tagmanager_zzm_zza_K__V) {
        this.zzaQy = new C12511(this, i, com_google_android_gms_tagmanager_zzm_zza_K__V);
    }

    public V get(K k) {
        return this.zzaQy.get(k);
    }

    public void zzf(K k, V v) {
        this.zzaQy.put(k, v);
    }
}
