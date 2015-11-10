package com.google.android.gms.analytics.ecommerce;

import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.analytics.zzc;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzod;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Product {
    Map<String, String> zzLj;

    public Product() {
        this.zzLj = new HashMap();
    }

    void put(String str, String str2) {
        zzx.zzb((Object) str, (Object) "Name should be non-null");
        this.zzLj.put(str, str2);
    }

    public Product setBrand(String str) {
        put("br", str);
        return this;
    }

    public Product setCategory(String str) {
        put("ca", str);
        return this;
    }

    public Product setCouponCode(String str) {
        put("cc", str);
        return this;
    }

    public Product setCustomDimension(int i, String str) {
        put(zzc.zzZ(i), str);
        return this;
    }

    public Product setCustomMetric(int i, int i2) {
        put(zzc.zzaa(i), Integer.toString(i2));
        return this;
    }

    public Product setId(String str) {
        put(ShareConstants.WEB_DIALOG_PARAM_ID, str);
        return this;
    }

    public Product setName(String str) {
        put("nm", str);
        return this;
    }

    public Product setPosition(int i) {
        put("ps", Integer.toString(i));
        return this;
    }

    public Product setPrice(double d) {
        put("pr", Double.toString(d));
        return this;
    }

    public Product setQuantity(int i) {
        put("qt", Integer.toString(i));
        return this;
    }

    public Product setVariant(String str) {
        put("va", str);
        return this;
    }

    public String toString() {
        return zzod.zzF(this.zzLj);
    }

    public Map<String, String> zzaV(String str) {
        Map<String, String> hashMap = new HashMap();
        for (Entry entry : this.zzLj.entrySet()) {
            hashMap.put(str + ((String) entry.getKey()), entry.getValue());
        }
        return hashMap;
    }
}
