package com.google.android.gms.internal;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzld<K, V> extends zzlh<K, V> implements Map<K, V> {
    zzlg<K, V> zzaev;

    /* renamed from: com.google.android.gms.internal.zzld.1 */
    class C11601 extends zzlg<K, V> {
        final /* synthetic */ zzld zzaew;

        C11601(zzld com_google_android_gms_internal_zzld) {
            this.zzaew = com_google_android_gms_internal_zzld;
        }

        protected void colClear() {
            this.zzaew.clear();
        }

        protected Object colGetEntry(int i, int i2) {
            return this.zzaew.mArray[(i << 1) + i2];
        }

        protected Map<K, V> colGetMap() {
            return this.zzaew;
        }

        protected int colGetSize() {
            return this.zzaew.mSize;
        }

        protected int colIndexOfKey(Object obj) {
            return obj == null ? this.zzaew.indexOfNull() : this.zzaew.indexOf(obj, obj.hashCode());
        }

        protected int colIndexOfValue(Object obj) {
            return this.zzaew.indexOfValue(obj);
        }

        protected void colPut(K k, V v) {
            this.zzaew.put(k, v);
        }

        protected void colRemoveAt(int i) {
            this.zzaew.removeAt(i);
        }

        protected V colSetValue(int i, V v) {
            return this.zzaew.setValueAt(i, v);
        }
    }

    private zzlg<K, V> zzoV() {
        if (this.zzaev == null) {
            this.zzaev = new C11601(this);
        }
        return this.zzaev;
    }

    public Set<Entry<K, V>> entrySet() {
        return zzoV().getEntrySet();
    }

    public Set<K> keySet() {
        return zzoV().getKeySet();
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        ensureCapacity(this.mSize + map.size());
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Collection<V> values() {
        return zzoV().getValues();
    }
}
