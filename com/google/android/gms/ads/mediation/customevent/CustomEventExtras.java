package com.google.android.gms.ads.mediation.customevent;

import com.google.ads.mediation.C0706h;
import java.util.HashMap;

@Deprecated
public final class CustomEventExtras implements C0706h {
    private final HashMap<String, Object> zzJL;

    public CustomEventExtras() {
        this.zzJL = new HashMap();
    }

    public Object getExtra(String str) {
        return this.zzJL.get(str);
    }

    public void setExtra(String str, Object obj) {
        this.zzJL.put(str, obj);
    }
}
