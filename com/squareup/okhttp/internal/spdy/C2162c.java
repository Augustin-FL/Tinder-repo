package com.squareup.okhttp.internal.spdy;

import okio.ByteString;

/* renamed from: com.squareup.okhttp.internal.spdy.c */
public final class C2162c {
    public static final ByteString f3383a;
    public static final ByteString f3384b;
    public static final ByteString f3385c;
    public static final ByteString f3386d;
    public static final ByteString f3387e;
    public static final ByteString f3388f;
    public static final ByteString f3389g;
    public final ByteString f3390h;
    public final ByteString f3391i;
    final int f3392j;

    static {
        f3383a = ByteString.m10145a(":status");
        f3384b = ByteString.m10145a(":method");
        f3385c = ByteString.m10145a(":path");
        f3386d = ByteString.m10145a(":scheme");
        f3387e = ByteString.m10145a(":authority");
        f3388f = ByteString.m10145a(":host");
        f3389g = ByteString.m10145a(":version");
    }

    public C2162c(String str, String str2) {
        this(ByteString.m10145a(str), ByteString.m10145a(str2));
    }

    public C2162c(ByteString byteString, String str) {
        this(byteString, ByteString.m10145a(str));
    }

    public C2162c(ByteString byteString, ByteString byteString2) {
        this.f3390h = byteString;
        this.f3391i = byteString2;
        this.f3392j = (byteString.m10157f() + 32) + byteString2.m10157f();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2162c)) {
            return false;
        }
        C2162c c2162c = (C2162c) obj;
        if (this.f3390h.equals(c2162c.f3390h) && this.f3391i.equals(c2162c.f3391i)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f3390h.hashCode() + 527) * 31) + this.f3391i.hashCode();
    }

    public String toString() {
        return String.format("%s: %s", new Object[]{this.f3390h.m10150a(), this.f3391i.m10150a()});
    }
}
