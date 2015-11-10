package com.google.android.m4b.maps.p014r;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;

/* renamed from: com.google.android.m4b.maps.r.b */
public final class C1562b extends C1558a<byte[]> {
    private static final C1559c<byte[]> f1763e;

    /* renamed from: com.google.android.m4b.maps.r.b.1 */
    static class C15601 extends C1559c<byte[]> {
        C15601(int i, String str) {
            super(100, str);
        }

        protected final /* bridge */ /* synthetic */ Object m2773a() {
            return new byte[4106];
        }
    }

    /* renamed from: com.google.android.m4b.maps.r.b.a */
    public interface C1561a {
        void m2774a(byte[] bArr, int i);
    }

    static {
        f1763e = new C15601(100, "ByteChunkArrayManager");
    }

    public C1562b(int i) {
        super(i, 12, f1763e);
    }

    public final void m2775a(C1561a c1561a) {
        for (int i = 0; i < this.b; i++) {
            c1561a.m2774a((byte[]) this.a.get(i), AccessibilityNodeInfoCompat.ACTION_SCROLL_FORWARD);
        }
        if (this.b != this.a.size()) {
            c1561a.m2774a((byte[]) this.c, this.d);
        }
    }
}
