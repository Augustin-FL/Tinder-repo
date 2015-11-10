package com.google.android.m4b.maps.p014r;

import com.google.android.gms.location.places.Place;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

/* renamed from: com.google.android.m4b.maps.r.d */
public final class C1564d extends C1558a<int[]> {
    private static final C1559c<int[]> f1764e;

    /* renamed from: com.google.android.m4b.maps.r.d.1 */
    static class C15631 extends C1559c<int[]> {
        C15631(int i, String str) {
            super(100, str);
        }

        protected final /* bridge */ /* synthetic */ Object m2776a() {
            return new int[1034];
        }
    }

    static {
        f1764e = new C15631(100, "IntChunkArrayManager");
    }

    public C1564d(int i) {
        super(i, 10, f1764e);
    }

    public final void m2778a(IntBuffer intBuffer) {
        for (int i = 0; i < this.b; i++) {
            intBuffer.put((int[]) this.a.get(i), 0, Place.TYPE_SUBLOCALITY_LEVEL_2);
        }
        if (this.b != this.a.size()) {
            intBuffer.put((int[]) this.c, 0, this.d);
        }
    }

    public final void m2779a(ShortBuffer shortBuffer, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < this.b; i3++) {
            int[] iArr = (int[]) this.a.get(i3);
            for (int i4 = 0; i4 < Place.TYPE_SUBLOCALITY_LEVEL_2; i4++) {
                shortBuffer.put((short) (iArr[i4] / i));
            }
        }
        if (this.b != this.a.size()) {
            while (i2 < this.d) {
                shortBuffer.put((short) (((int[]) this.c)[i2] / i));
                i2++;
            }
        }
    }

    public final void m2777a(ByteBuffer byteBuffer, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < this.b; i3++) {
            int[] iArr = (int[]) this.a.get(i3);
            for (int i4 = 0; i4 < Place.TYPE_SUBLOCALITY_LEVEL_2; i4++) {
                byteBuffer.put((byte) (iArr[i4] / i));
            }
        }
        if (this.b != this.a.size()) {
            while (i2 < this.d) {
                byteBuffer.put((byte) (((int[]) this.c)[i2] / i));
                i2++;
            }
        }
    }
}
