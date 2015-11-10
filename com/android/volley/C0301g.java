package com.android.volley;

import java.util.Map;
import org.apache.http.HttpStatus;

/* renamed from: com.android.volley.g */
public class C0301g {
    public final int f243a;
    public final byte[] f244b;
    public final Map<String, String> f245c;
    public final boolean f246d;

    public C0301g(int i, byte[] bArr, Map<String, String> map, boolean z) {
        this.f243a = i;
        this.f244b = bArr;
        this.f245c = map;
        this.f246d = z;
    }

    public C0301g(byte[] bArr, Map<String, String> map) {
        this(HttpStatus.SC_OK, bArr, map, false);
    }
}
