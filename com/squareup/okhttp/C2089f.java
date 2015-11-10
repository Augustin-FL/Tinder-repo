package com.squareup.okhttp;

import com.squareup.okhttp.internal.C2157k;

/* renamed from: com.squareup.okhttp.f */
public final class C2089f {
    private final String f3111a;
    private final String f3112b;

    public C2089f(String str, String str2) {
        this.f3111a = str;
        this.f3112b = str2;
    }

    public String m4955a() {
        return this.f3111a;
    }

    public String m4956b() {
        return this.f3112b;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C2089f) && C2157k.m5358a(this.f3111a, ((C2089f) obj).f3111a) && C2157k.m5358a(this.f3112b, ((C2089f) obj).f3112b);
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        if (this.f3112b != null) {
            hashCode = this.f3112b.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode = (hashCode + 899) * 31;
        if (this.f3111a != null) {
            i = this.f3111a.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return this.f3111a + " realm=\"" + this.f3112b + "\"";
    }
}
