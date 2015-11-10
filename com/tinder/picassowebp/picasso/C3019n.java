package com.tinder.picassowebp.picasso;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.tinder.picassowebp.picasso.n */
final class C3019n extends InputStream {
    private final InputStream f6398a;
    private long f6399b;
    private long f6400c;
    private long f6401d;
    private long f6402e;

    public C3019n(InputStream inputStream) {
        this(inputStream, AccessibilityNodeInfoCompat.ACTION_SCROLL_FORWARD);
    }

    public C3019n(InputStream inputStream, int i) {
        this.f6402e = -1;
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream, i);
        }
        this.f6398a = inputStream;
    }

    public void mark(int i) {
        this.f6402e = m9089a(i);
    }

    public long m9089a(int i) {
        long j = this.f6399b + ((long) i);
        if (this.f6401d < j) {
            m9088b(j);
        }
        return this.f6399b;
    }

    private void m9088b(long j) {
        try {
            if (this.f6400c >= this.f6399b || this.f6399b > this.f6401d) {
                this.f6400c = this.f6399b;
                this.f6398a.mark((int) (j - this.f6399b));
            } else {
                this.f6398a.reset();
                this.f6398a.mark((int) (j - this.f6400c));
                m9087a(this.f6400c, this.f6399b);
            }
            this.f6401d = j;
        } catch (IOException e) {
            throw new IllegalStateException("Unable to mark: " + e);
        }
    }

    public void reset() throws IOException {
        m9090a(this.f6402e);
    }

    public void m9090a(long j) throws IOException {
        if (this.f6399b > this.f6401d || j < this.f6400c) {
            throw new IOException("Cannot reset");
        }
        this.f6398a.reset();
        m9087a(this.f6400c, j);
        this.f6399b = j;
    }

    private void m9087a(long j, long j2) throws IOException {
        while (j < j2) {
            long skip = this.f6398a.skip(j2 - j);
            if (skip == 0) {
                if (read() != -1) {
                    skip = 1;
                } else {
                    return;
                }
            }
            j += skip;
        }
    }

    public int read() throws IOException {
        int read = this.f6398a.read();
        if (read != -1) {
            this.f6399b++;
        }
        return read;
    }

    public int read(byte[] bArr) throws IOException {
        int read = this.f6398a.read(bArr);
        if (read != -1) {
            this.f6399b += (long) read;
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.f6398a.read(bArr, i, i2);
        if (read != -1) {
            this.f6399b += (long) read;
        }
        return read;
    }

    public long skip(long j) throws IOException {
        long skip = this.f6398a.skip(j);
        this.f6399b += skip;
        return skip;
    }

    public int available() throws IOException {
        return this.f6398a.available();
    }

    public void close() throws IOException {
        this.f6398a.close();
    }

    public boolean markSupported() {
        return this.f6398a.markSupported();
    }
}
