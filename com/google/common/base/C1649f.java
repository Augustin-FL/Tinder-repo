package com.google.common.base;

import com.google.android.gms.location.places.Place;

/* renamed from: com.google.common.base.f */
final class C1649f {
    private static final ThreadLocal<char[]> f1958a;

    /* renamed from: com.google.common.base.f.1 */
    static class C16481 extends ThreadLocal<char[]> {
        C16481() {
        }

        protected /* synthetic */ Object initialValue() {
            return m3076a();
        }

        protected char[] m3076a() {
            return new char[Place.TYPE_SUBLOCALITY_LEVEL_2];
        }
    }

    static long m3077a() {
        return System.nanoTime();
    }

    static {
        f1958a = new C16481();
    }
}
