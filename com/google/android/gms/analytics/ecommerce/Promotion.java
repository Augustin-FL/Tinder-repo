package com.google.android.gms.analytics.ecommerce;

import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzod;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Promotion {
    public static final String ACTION_CLICK = "click";
    public static final String ACTION_VIEW = "view";
    Map<String, String> zzLj;

    public Promotion() {
        this.zzLj = new HashMap();
    }

    void put(String str, String str2) {
        zzx.zzb((Object) str, (Object) "Name should be non-null");
        this.zzLj.put(str, str2);
    }

    public Promotion setCreative(String str) {
        put("cr", str);
        return this;
    }

    public Promotion setId(String str) {
        put(ShareConstants.WEB_DIALOG_PARAM_ID, str);
        return this;
    }

    public Promotion setName(String str) {
        put("nm", str);
        return this;
    }

    public Promotion setPosition(String str) {
        put("ps", str);
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
