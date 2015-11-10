package com.tinder.iap.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tinder.iap.util.d */
public class C2767d {
    @NonNull
    Map<String, C2770g> f5548a;
    @NonNull
    Map<String, C2768e> f5549b;

    C2767d() {
        this.f5548a = new HashMap();
        this.f5549b = new HashMap();
    }

    @Nullable
    public C2770g m7872a(String str) {
        return (C2770g) this.f5548a.get(str);
    }

    @NonNull
    public List<String> m7873a() {
        return new ArrayList(this.f5549b.keySet());
    }

    @NonNull
    List<String> m7877b(String str) {
        List<String> arrayList = new ArrayList();
        for (C2768e c2768e : this.f5549b.values()) {
            if (c2768e.m7878a().equals(str)) {
                arrayList.add(c2768e.m7879b());
            }
        }
        return arrayList;
    }

    @NonNull
    public List<C2768e> m7876b() {
        return new ArrayList(this.f5549b.values());
    }

    void m7875a(@NonNull C2770g c2770g) {
        this.f5548a.put(c2770g.m7888b(), c2770g);
    }

    void m7874a(@NonNull C2768e c2768e) {
        this.f5549b.put(c2768e.m7879b(), c2768e);
    }
}
