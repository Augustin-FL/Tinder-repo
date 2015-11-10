package io.fabric.sdk.android.services.common;

import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.tinder.views.RangeSeekBar;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: io.fabric.sdk.android.services.common.n */
public class C3264n implements Closeable {
    private static final Logger f7096b;
    int f7097a;
    private final RandomAccessFile f7098c;
    private int f7099d;
    private C3262a f7100e;
    private C3262a f7101f;
    private final byte[] f7102g;

    /* renamed from: io.fabric.sdk.android.services.common.n.c */
    public interface C0473c {
        void m862a(InputStream inputStream, int i) throws IOException;
    }

    /* renamed from: io.fabric.sdk.android.services.common.n.1 */
    class C32611 implements C0473c {
        boolean f7087a;
        final /* synthetic */ StringBuilder f7088b;
        final /* synthetic */ C3264n f7089c;

        C32611(C3264n c3264n, StringBuilder stringBuilder) {
            this.f7089c = c3264n;
            this.f7088b = stringBuilder;
            this.f7087a = true;
        }

        public void m9946a(InputStream inputStream, int i) throws IOException {
            if (this.f7087a) {
                this.f7087a = false;
            } else {
                this.f7088b.append(", ");
            }
            this.f7088b.append(i);
        }
    }

    /* renamed from: io.fabric.sdk.android.services.common.n.a */
    static class C3262a {
        static final C3262a f7090a;
        final int f7091b;
        final int f7092c;

        static {
            f7090a = new C3262a(0, 0);
        }

        C3262a(int i, int i2) {
            this.f7091b = i;
            this.f7092c = i2;
        }

        public String toString() {
            return getClass().getSimpleName() + "[" + "position = " + this.f7091b + ", length = " + this.f7092c + "]";
        }
    }

    /* renamed from: io.fabric.sdk.android.services.common.n.b */
    private final class C3263b extends InputStream {
        final /* synthetic */ C3264n f7093a;
        private int f7094b;
        private int f7095c;

        private C3263b(C3264n c3264n, C3262a c3262a) {
            this.f7093a = c3264n;
            this.f7094b = c3264n.m9957b(c3262a.f7091b + 4);
            this.f7095c = c3262a.f7092c;
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            C3264n.m9959b(bArr, "buffer");
            if ((i | i2) < 0 || i2 > bArr.length - i) {
                throw new ArrayIndexOutOfBoundsException();
            } else if (this.f7095c <= 0) {
                return -1;
            } else {
                if (i2 > this.f7095c) {
                    i2 = this.f7095c;
                }
                this.f7093a.m9960b(this.f7094b, bArr, i, i2);
                this.f7094b = this.f7093a.m9957b(this.f7094b + i2);
                this.f7095c -= i2;
                return i2;
            }
        }

        public int read() throws IOException {
            if (this.f7095c == 0) {
                return -1;
            }
            this.f7093a.f7098c.seek((long) this.f7094b);
            int read = this.f7093a.f7098c.read();
            this.f7094b = this.f7093a.m9957b(this.f7094b + 1);
            this.f7095c--;
            return read;
        }
    }

    static {
        f7096b = Logger.getLogger(C3264n.class.getName());
    }

    public C3264n(File file) throws IOException {
        this.f7102g = new byte[16];
        if (!file.exists()) {
            C3264n.m9955a(file);
        }
        this.f7098c = C3264n.m9958b(file);
        m9964e();
    }

    private static void m9961b(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    private static void m9956a(byte[] bArr, int... iArr) {
        int i = 0;
        int length = iArr.length;
        int i2 = 0;
        while (i < length) {
            C3264n.m9961b(bArr, i2, iArr[i]);
            i2 += 4;
            i++;
        }
    }

    private static int m9948a(byte[] bArr, int i) {
        return ((((bArr[i] & RangeSeekBar.INVALID_POINTER_ID) << 24) + ((bArr[i + 1] & RangeSeekBar.INVALID_POINTER_ID) << 16)) + ((bArr[i + 2] & RangeSeekBar.INVALID_POINTER_ID) << 8)) + (bArr[i + 3] & RangeSeekBar.INVALID_POINTER_ID);
    }

    private void m9964e() throws IOException {
        this.f7098c.seek(0);
        this.f7098c.readFully(this.f7102g);
        this.f7097a = C3264n.m9948a(this.f7102g, 0);
        if (((long) this.f7097a) > this.f7098c.length()) {
            throw new IOException("File is truncated. Expected length: " + this.f7097a + ", Actual length: " + this.f7098c.length());
        }
        this.f7099d = C3264n.m9948a(this.f7102g, 4);
        int a = C3264n.m9948a(this.f7102g, 8);
        int a2 = C3264n.m9948a(this.f7102g, 12);
        this.f7100e = m9949a(a);
        this.f7101f = m9949a(a2);
    }

    private void m9952a(int i, int i2, int i3, int i4) throws IOException {
        C3264n.m9956a(this.f7102g, i, i2, i3, i4);
        this.f7098c.seek(0);
        this.f7098c.write(this.f7102g);
    }

    private C3262a m9949a(int i) throws IOException {
        if (i == 0) {
            return C3262a.f7090a;
        }
        this.f7098c.seek((long) i);
        return new C3262a(i, this.f7098c.readInt());
    }

    private static void m9955a(File file) throws IOException {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile b = C3264n.m9958b(file2);
        try {
            b.setLength(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
            b.seek(0);
            byte[] bArr = new byte[16];
            C3264n.m9956a(bArr, AccessibilityNodeInfoCompat.ACTION_SCROLL_FORWARD, 0, 0, 0);
            b.write(bArr);
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } finally {
            b.close();
        }
    }

    private static RandomAccessFile m9958b(File file) throws FileNotFoundException {
        return new RandomAccessFile(file, "rwd");
    }

    private int m9957b(int i) {
        return i < this.f7097a ? i : (i + 16) - this.f7097a;
    }

    private void m9953a(int i, byte[] bArr, int i2, int i3) throws IOException {
        int b = m9957b(i);
        if (b + i3 <= this.f7097a) {
            this.f7098c.seek((long) b);
            this.f7098c.write(bArr, i2, i3);
            return;
        }
        int i4 = this.f7097a - b;
        this.f7098c.seek((long) b);
        this.f7098c.write(bArr, i2, i4);
        this.f7098c.seek(16);
        this.f7098c.write(bArr, i2 + i4, i3 - i4);
    }

    private void m9960b(int i, byte[] bArr, int i2, int i3) throws IOException {
        int b = m9957b(i);
        if (b + i3 <= this.f7097a) {
            this.f7098c.seek((long) b);
            this.f7098c.readFully(bArr, i2, i3);
            return;
        }
        int i4 = this.f7097a - b;
        this.f7098c.seek((long) b);
        this.f7098c.readFully(bArr, i2, i4);
        this.f7098c.seek(16);
        this.f7098c.readFully(bArr, i2 + i4, i3 - i4);
    }

    public void m9968a(byte[] bArr) throws IOException {
        m9969a(bArr, 0, bArr.length);
    }

    public synchronized void m9969a(byte[] bArr, int i, int i2) throws IOException {
        C3264n.m9959b(bArr, "buffer");
        if ((i | i2) < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        int i3;
        m9962c(i2);
        boolean b = m9971b();
        if (b) {
            i3 = 16;
        } else {
            i3 = m9957b((this.f7101f.f7091b + 4) + this.f7101f.f7092c);
        }
        C3262a c3262a = new C3262a(i3, i2);
        C3264n.m9961b(this.f7102g, 0, i2);
        m9953a(c3262a.f7091b, this.f7102g, 0, 4);
        m9953a(c3262a.f7091b + 4, bArr, i, i2);
        m9952a(this.f7097a, this.f7099d + 1, b ? c3262a.f7091b : this.f7100e.f7091b, c3262a.f7091b);
        this.f7101f = c3262a;
        this.f7099d++;
        if (b) {
            this.f7100e = this.f7101f;
        }
    }

    public int m9966a() {
        if (this.f7099d == 0) {
            return 16;
        }
        if (this.f7101f.f7091b >= this.f7100e.f7091b) {
            return (((this.f7101f.f7091b - this.f7100e.f7091b) + 4) + this.f7101f.f7092c) + 16;
        }
        return (((this.f7101f.f7091b + 4) + this.f7101f.f7092c) + this.f7097a) - this.f7100e.f7091b;
    }

    private int m9965f() {
        return this.f7097a - m9966a();
    }

    public synchronized boolean m9971b() {
        return this.f7099d == 0;
    }

    private void m9962c(int i) throws IOException {
        int i2 = i + 4;
        int f = m9965f();
        if (f < i2) {
            int i3 = this.f7097a;
            do {
                f += i3;
                i3 <<= 1;
            } while (f < i2);
            m9963d(i3);
            i2 = m9957b((this.f7101f.f7091b + 4) + this.f7101f.f7092c);
            if (i2 < this.f7100e.f7091b) {
                FileChannel channel = this.f7098c.getChannel();
                channel.position((long) this.f7097a);
                int i4 = i2 - 4;
                if (channel.transferTo(16, (long) i4, channel) != ((long) i4)) {
                    throw new AssertionError("Copied insufficient number of bytes!");
                }
            }
            if (this.f7101f.f7091b < this.f7100e.f7091b) {
                f = (this.f7097a + this.f7101f.f7091b) - 16;
                m9952a(i3, this.f7099d, this.f7100e.f7091b, f);
                this.f7101f = new C3262a(f, this.f7101f.f7092c);
            } else {
                m9952a(i3, this.f7099d, this.f7100e.f7091b, this.f7101f.f7091b);
            }
            this.f7097a = i3;
        }
    }

    private void m9963d(int i) throws IOException {
        this.f7098c.setLength((long) i);
        this.f7098c.getChannel().force(true);
    }

    public synchronized void m9967a(C0473c c0473c) throws IOException {
        int i = this.f7100e.f7091b;
        for (int i2 = 0; i2 < this.f7099d; i2++) {
            C3262a a = m9949a(i);
            c0473c.m862a(new C3263b(a, null), a.f7092c);
            i = m9957b(a.f7092c + (a.f7091b + 4));
        }
    }

    private static <T> T m9959b(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public synchronized void m9972c() throws IOException {
        if (m9971b()) {
            throw new NoSuchElementException();
        } else if (this.f7099d == 1) {
            m9973d();
        } else {
            int b = m9957b((this.f7100e.f7091b + 4) + this.f7100e.f7092c);
            m9960b(b, this.f7102g, 0, 4);
            int a = C3264n.m9948a(this.f7102g, 0);
            m9952a(this.f7097a, this.f7099d - 1, b, this.f7101f.f7091b);
            this.f7099d--;
            this.f7100e = new C3262a(b, a);
        }
    }

    public synchronized void m9973d() throws IOException {
        m9952a((int) AccessibilityNodeInfoCompat.ACTION_SCROLL_FORWARD, 0, 0, 0);
        this.f7099d = 0;
        this.f7100e = C3262a.f7090a;
        this.f7101f = C3262a.f7090a;
        if (this.f7097a > AccessibilityNodeInfoCompat.ACTION_SCROLL_FORWARD) {
            m9963d(AccessibilityNodeInfoCompat.ACTION_SCROLL_FORWARD);
        }
        this.f7097a = AccessibilityNodeInfoCompat.ACTION_SCROLL_FORWARD;
    }

    public synchronized void close() throws IOException {
        this.f7098c.close();
    }

    public boolean m9970a(int i, int i2) {
        return (m9966a() + 4) + i <= i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName()).append('[');
        stringBuilder.append("fileLength=").append(this.f7097a);
        stringBuilder.append(", size=").append(this.f7099d);
        stringBuilder.append(", first=").append(this.f7100e);
        stringBuilder.append(", last=").append(this.f7101f);
        stringBuilder.append(", element lengths=[");
        try {
            m9967a(new C32611(this, stringBuilder));
        } catch (Throwable e) {
            f7096b.log(Level.WARNING, "read error", e);
        }
        stringBuilder.append("]]");
        return stringBuilder.toString();
    }
}
