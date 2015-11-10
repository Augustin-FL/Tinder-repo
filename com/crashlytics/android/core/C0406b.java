package com.crashlytics.android.core;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.apache.http.protocol.HTTP;

/* renamed from: com.crashlytics.android.core.b */
final class C0406b {
    public static final C0406b f526a;
    private final byte[] f527b;
    private volatile int f528c;

    private C0406b(byte[] bArr) {
        this.f528c = 0;
        this.f527b = bArr;
    }

    public int m622a() {
        return this.f527b.length;
    }

    static {
        f526a = new C0406b(new byte[0]);
    }

    public static C0406b m621a(byte[] bArr, int i, int i2) {
        Object obj = new byte[i2];
        System.arraycopy(bArr, i, obj, 0, i2);
        return new C0406b(obj);
    }

    public static C0406b m620a(String str) {
        try {
            return new C0406b(str.getBytes(HTTP.UTF_8));
        } catch (Throwable e) {
            throw new RuntimeException("UTF-8 not supported.", e);
        }
    }

    public void m623a(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.f527b, i, bArr, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0406b)) {
            return false;
        }
        C0406b c0406b = (C0406b) obj;
        int length = this.f527b.length;
        if (length != c0406b.f527b.length) {
            return false;
        }
        byte[] bArr = this.f527b;
        byte[] bArr2 = c0406b.f527b;
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = this.f528c;
        if (i == 0) {
            byte[] bArr = this.f527b;
            int length = this.f527b.length;
            int i2 = 0;
            i = length;
            while (i2 < length) {
                int i3 = bArr[i2] + (i * 31);
                i2++;
                i = i3;
            }
            if (i == 0) {
                i = 1;
            }
            this.f528c = i;
        }
        return i;
    }

    public InputStream m624b() {
        return new ByteArrayInputStream(this.f527b);
    }
}
