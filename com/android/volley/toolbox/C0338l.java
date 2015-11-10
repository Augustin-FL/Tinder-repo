package com.android.volley.toolbox;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* renamed from: com.android.volley.toolbox.l */
public class C0338l extends ByteArrayOutputStream {
    private final C0317a f335a;

    public C0338l(C0317a c0317a, int i) {
        this.f335a = c0317a;
        this.buf = this.f335a.m304a(Math.max(i, AccessibilityNodeInfoCompat.ACTION_NEXT_AT_MOVEMENT_GRANULARITY));
    }

    public void close() throws IOException {
        this.f335a.m303a(this.buf);
        this.buf = null;
        super.close();
    }

    public void finalize() {
        this.f335a.m303a(this.buf);
    }

    private void m378a(int i) {
        if (this.count + i > this.buf.length) {
            Object a = this.f335a.m304a((this.count + i) * 2);
            System.arraycopy(this.buf, 0, a, 0, this.count);
            this.f335a.m303a(this.buf);
            this.buf = a;
        }
    }

    public synchronized void write(byte[] bArr, int i, int i2) {
        m378a(i2);
        super.write(bArr, i, i2);
    }

    public synchronized void write(int i) {
        m378a(1);
        super.write(i);
    }
}
