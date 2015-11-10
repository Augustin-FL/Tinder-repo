package com.google.android.m4b.maps.p014r;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import java.nio.ShortBuffer;

/* renamed from: com.google.android.m4b.maps.r.e */
public final class C1566e extends C1558a<short[]> {
    private static final C1559c<short[]> f1765e;

    /* renamed from: com.google.android.m4b.maps.r.e.1 */
    static class C15651 extends C1559c<short[]> {
        C15651(int i, String str) {
            super(100, str);
        }

        protected final /* bridge */ /* synthetic */ Object m2780a() {
            return new short[2058];
        }
    }

    static {
        f1765e = new C15651(100, "ShortChunkArrayManager");
    }

    public C1566e(int i) {
        super(i, 11, f1765e);
    }

    public final void m2781a(ShortBuffer shortBuffer) {
        for (int i = 0; i < this.b; i++) {
            shortBuffer.put((short[]) this.a.get(i), 0, AccessibilityNodeInfoCompat.ACTION_PREVIOUS_HTML_ELEMENT);
        }
        if (this.b != this.a.size()) {
            shortBuffer.put((short[]) this.c, 0, this.d);
        }
    }
}
