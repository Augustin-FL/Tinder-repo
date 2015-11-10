package com.tinder.iap.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/* renamed from: com.tinder.iap.util.c */
public class C2766c {
    int f5546a;
    String f5547b;

    public C2766c(int i, @Nullable String str) {
        this.f5546a = i;
        if (str == null || str.trim().length() == 0) {
            this.f5547b = C2765b.m7845a(i);
        } else {
            this.f5547b = str + " (response: " + C2765b.m7845a(i) + ")";
        }
    }

    public String m7869a() {
        return this.f5547b;
    }

    public boolean m7870b() {
        return this.f5546a == 0;
    }

    public boolean m7871c() {
        return !m7870b();
    }

    @NonNull
    public String toString() {
        return "IabResult: " + m7869a();
    }
}
