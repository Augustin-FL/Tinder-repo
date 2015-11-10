package com.google.common.p023b;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.common.base.C1650g;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.google.common.b.a */
public final class C1617a {
    private static final OutputStream f1901a;

    /* renamed from: com.google.common.b.a.1 */
    static class C16161 extends OutputStream {
        C16161() {
        }

        public void write(int i) {
        }

        public void write(byte[] bArr) {
            C1650g.m3080a((Object) bArr);
        }

        public void write(byte[] bArr, int i, int i2) {
            C1650g.m3080a((Object) bArr);
        }

        public String toString() {
            return "ByteStreams.nullOutputStream()";
        }
    }

    public static long m2977a(InputStream inputStream, OutputStream outputStream) throws IOException {
        C1650g.m3080a((Object) inputStream);
        C1650g.m3080a((Object) outputStream);
        byte[] bArr = new byte[AccessibilityNodeInfoCompat.ACTION_SCROLL_FORWARD];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }

    public static byte[] m2978a(InputStream inputStream) throws IOException {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        C1617a.m2977a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    static {
        f1901a = new C16161();
    }
}
