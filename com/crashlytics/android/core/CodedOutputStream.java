package com.crashlytics.android.core;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.tinder.views.RangeSeekBar;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.protocol.HTTP;

final class CodedOutputStream implements Flushable {
    private final byte[] f485a;
    private final int f486b;
    private int f487c;
    private final OutputStream f488d;

    static class OutOfSpaceException extends IOException {
        private static final long serialVersionUID = -6947486886997889499L;

        OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private CodedOutputStream(OutputStream outputStream, byte[] bArr) {
        this.f488d = outputStream;
        this.f485a = bArr;
        this.f487c = 0;
        this.f486b = bArr.length;
    }

    public static CodedOutputStream m566a(OutputStream outputStream) {
        return m567a(outputStream, (int) AccessibilityNodeInfoCompat.ACTION_SCROLL_FORWARD);
    }

    public static CodedOutputStream m567a(OutputStream outputStream, int i) {
        return new CodedOutputStream(outputStream, new byte[i]);
    }

    public void m591a(int i, float f) throws IOException {
        m611g(i, 5);
        m589a(f);
    }

    public void m593a(int i, long j) throws IOException {
        m611g(i, 0);
        m597a(j);
    }

    public void m596a(int i, boolean z) throws IOException {
        m611g(i, 0);
        m601a(z);
    }

    public void m595a(int i, String str) throws IOException {
        m611g(i, 2);
        m600a(str);
    }

    public void m594a(int i, C0406b c0406b) throws IOException {
        m611g(i, 2);
        m598a(c0406b);
    }

    public void m592a(int i, int i2) throws IOException {
        m611g(i, 0);
        m604b(i2);
    }

    public void m605b(int i, int i2) throws IOException {
        m611g(i, 0);
        m606c(i2);
    }

    public void m607c(int i, int i2) throws IOException {
        m611g(i, 0);
        m610d(i2);
    }

    public void m589a(float f) throws IOException {
        m614m(Float.floatToRawIntBits(f));
    }

    public void m597a(long j) throws IOException {
        m608c(j);
    }

    public void m590a(int i) throws IOException {
        if (i >= 0) {
            m613k(i);
        } else {
            m608c((long) i);
        }
    }

    public void m601a(boolean z) throws IOException {
        m612i(z ? 1 : 0);
    }

    public void m600a(String str) throws IOException {
        byte[] bytes = str.getBytes(HTTP.UTF_8);
        m613k(bytes.length);
        m602a(bytes);
    }

    public void m598a(C0406b c0406b) throws IOException {
        m613k(c0406b.m622a());
        m609c(c0406b);
    }

    public void m604b(int i) throws IOException {
        m613k(i);
    }

    public void m606c(int i) throws IOException {
        m590a(i);
    }

    public void m610d(int i) throws IOException {
        m613k(m587n(i));
    }

    public static int m570b(int i, float f) {
        return m585j(i) + m569b(f);
    }

    public static int m571b(int i, long j) {
        return m585j(i) + m574b(j);
    }

    public static int m573b(int i, boolean z) {
        return m585j(i) + m576b(z);
    }

    public static int m572b(int i, C0406b c0406b) {
        return m585j(i) + m575b(c0406b);
    }

    public static int m577d(int i, int i2) {
        return m585j(i) + m581f(i2);
    }

    public static int m580e(int i, int i2) {
        return m585j(i) + m583g(i2);
    }

    public static int m582f(int i, int i2) {
        return m585j(i) + m584h(i2);
    }

    public static int m569b(float f) {
        return 4;
    }

    public static int m574b(long j) {
        return m578d(j);
    }

    public static int m579e(int i) {
        if (i >= 0) {
            return m586l(i);
        }
        return 10;
    }

    public static int m576b(boolean z) {
        return 1;
    }

    public static int m575b(C0406b c0406b) {
        return m586l(c0406b.m622a()) + c0406b.m622a();
    }

    public static int m581f(int i) {
        return m586l(i);
    }

    public static int m583g(int i) {
        return m579e(i);
    }

    public static int m584h(int i) {
        return m586l(m587n(i));
    }

    private void m568a() throws IOException {
        if (this.f488d == null) {
            throw new OutOfSpaceException();
        }
        this.f488d.write(this.f485a, 0, this.f487c);
        this.f487c = 0;
    }

    public void flush() throws IOException {
        if (this.f488d != null) {
            m568a();
        }
    }

    public void m588a(byte b) throws IOException {
        if (this.f487c == this.f486b) {
            m568a();
        }
        byte[] bArr = this.f485a;
        int i = this.f487c;
        this.f487c = i + 1;
        bArr[i] = b;
    }

    public void m612i(int i) throws IOException {
        m588a((byte) i);
    }

    public void m609c(C0406b c0406b) throws IOException {
        m599a(c0406b, 0, c0406b.m622a());
    }

    public void m602a(byte[] bArr) throws IOException {
        m603a(bArr, 0, bArr.length);
    }

    public void m603a(byte[] bArr, int i, int i2) throws IOException {
        if (this.f486b - this.f487c >= i2) {
            System.arraycopy(bArr, i, this.f485a, this.f487c, i2);
            this.f487c += i2;
            return;
        }
        int i3 = this.f486b - this.f487c;
        System.arraycopy(bArr, i, this.f485a, this.f487c, i3);
        int i4 = i + i3;
        i3 = i2 - i3;
        this.f487c = this.f486b;
        m568a();
        if (i3 <= this.f486b) {
            System.arraycopy(bArr, i4, this.f485a, 0, i3);
            this.f487c = i3;
            return;
        }
        this.f488d.write(bArr, i4, i3);
    }

    public void m599a(C0406b c0406b, int i, int i2) throws IOException {
        if (this.f486b - this.f487c >= i2) {
            c0406b.m623a(this.f485a, i, this.f487c, i2);
            this.f487c += i2;
            return;
        }
        int i3 = this.f486b - this.f487c;
        c0406b.m623a(this.f485a, i, this.f487c, i3);
        int i4 = i + i3;
        i3 = i2 - i3;
        this.f487c = this.f486b;
        m568a();
        if (i3 <= this.f486b) {
            c0406b.m623a(this.f485a, i4, 0, i3);
            this.f487c = i3;
            return;
        }
        InputStream b = c0406b.m624b();
        if (((long) i4) != b.skip((long) i4)) {
            throw new IllegalStateException("Skip failed.");
        }
        while (i3 > 0) {
            i4 = Math.min(i3, this.f486b);
            int read = b.read(this.f485a, 0, i4);
            if (read != i4) {
                throw new IllegalStateException("Read failed.");
            }
            this.f488d.write(this.f485a, 0, read);
            i3 -= read;
        }
    }

    public void m611g(int i, int i2) throws IOException {
        m613k(aa.m619a(i, i2));
    }

    public static int m585j(int i) {
        return m586l(aa.m619a(i, 0));
    }

    public void m613k(int i) throws IOException {
        while ((i & -128) != 0) {
            m612i((i & TransportMediator.KEYCODE_MEDIA_PAUSE) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
            i >>>= 7;
        }
        m612i(i);
    }

    public static int m586l(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        if ((-268435456 & i) == 0) {
            return 4;
        }
        return 5;
    }

    public void m608c(long j) throws IOException {
        while ((-128 & j) != 0) {
            m612i((((int) j) & TransportMediator.KEYCODE_MEDIA_PAUSE) | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
            j >>>= 7;
        }
        m612i((int) j);
    }

    public static int m578d(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        if ((Long.MIN_VALUE & j) == 0) {
            return 9;
        }
        return 10;
    }

    public void m614m(int i) throws IOException {
        m612i(i & RangeSeekBar.INVALID_POINTER_ID);
        m612i((i >> 8) & RangeSeekBar.INVALID_POINTER_ID);
        m612i((i >> 16) & RangeSeekBar.INVALID_POINTER_ID);
        m612i((i >> 24) & RangeSeekBar.INVALID_POINTER_ID);
    }

    public static int m587n(int i) {
        return (i << 1) ^ (i >> 31);
    }
}
