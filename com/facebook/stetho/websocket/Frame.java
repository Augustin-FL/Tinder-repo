package com.facebook.stetho.websocket;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.tinder.views.RangeSeekBar;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

class Frame {
    public static final byte OPCODE_BINARY_FRAME = (byte) 2;
    public static final byte OPCODE_CONNECTION_CLOSE = (byte) 8;
    public static final byte OPCODE_CONNECTION_PING = (byte) 9;
    public static final byte OPCODE_CONNECTION_PONG = (byte) 10;
    public static final byte OPCODE_TEXT_FRAME = (byte) 1;
    public boolean fin;
    public boolean hasMask;
    public byte[] maskingKey;
    public byte opcode;
    public byte[] payloadData;
    public long payloadLen;
    public boolean rsv1;
    public boolean rsv2;
    public boolean rsv3;

    Frame() {
    }

    public void readFrom(BufferedInputStream bufferedInputStream) throws IOException {
        decodeFirstByte(readByteOrThrow(bufferedInputStream));
        byte readByteOrThrow = readByteOrThrow(bufferedInputStream);
        this.hasMask = (readByteOrThrow & AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) != 0;
        this.payloadLen = decodeLength((byte) (readByteOrThrow & -129), bufferedInputStream);
        this.maskingKey = this.hasMask ? decodeMaskingKey(bufferedInputStream) : null;
        this.payloadData = new byte[((int) this.payloadLen)];
        readBytesOrThrow(bufferedInputStream, this.payloadData, 0, (int) this.payloadLen);
        MaskingHelper.unmask(this.maskingKey, this.payloadData, 0, (int) this.payloadLen);
    }

    public void writeTo(BufferedOutputStream bufferedOutputStream) throws IOException {
        bufferedOutputStream.write(encodeFirstByte());
        byte[] encodeLength = encodeLength(this.payloadLen);
        if (this.hasMask) {
            encodeLength[0] = (byte) (encodeLength[0] | AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        }
        bufferedOutputStream.write(encodeLength, 0, encodeLength.length);
        if (this.hasMask) {
            throw new UnsupportedOperationException("Writing masked data not implemented");
        }
        bufferedOutputStream.write(this.payloadData, 0, (int) this.payloadLen);
    }

    private void decodeFirstByte(byte b) {
        boolean z;
        boolean z2 = true;
        this.fin = (b & AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS) != 0;
        if ((b & 64) != 0) {
            z = true;
        } else {
            z = false;
        }
        this.rsv1 = z;
        if ((b & 32) != 0) {
            z = true;
        } else {
            z = false;
        }
        this.rsv2 = z;
        if ((b & 16) == 0) {
            z2 = false;
        }
        this.rsv3 = z2;
        this.opcode = (byte) (b & 15);
    }

    private byte encodeFirstByte() {
        int i = 0;
        if (this.fin) {
            i = (byte) AccessibilityNodeInfoCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS;
        }
        if (this.rsv1) {
            i = (byte) (i | 64);
        }
        if (this.rsv2) {
            i = (byte) (i | 32);
        }
        if (this.rsv3) {
            i = (byte) (i | 16);
        }
        return (byte) (i | (this.opcode & 15));
    }

    private long decodeLength(byte b, InputStream inputStream) throws IOException {
        if (b <= 125) {
            return (long) b;
        }
        if (b == 126) {
            return (long) (((readByteOrThrow(inputStream) & RangeSeekBar.INVALID_POINTER_ID) << 8) | (readByteOrThrow(inputStream) & RangeSeekBar.INVALID_POINTER_ID));
        }
        if (b == 127) {
            long j = 0;
            int i = 0;
            while (i < 8) {
                i++;
                j = (j | ((long) (readByteOrThrow(inputStream) & RangeSeekBar.INVALID_POINTER_ID))) << 8;
            }
            return j;
        }
        throw new IOException("Unexpected length byte: " + b);
    }

    private static byte[] encodeLength(long j) {
        if (j <= 125) {
            return new byte[]{(byte) ((int) j)};
        } else if (j <= 65535) {
            return new byte[]{(byte) 126, (byte) ((int) ((j >> 8) & 255)), (byte) ((int) (j & 255))};
        } else {
            return new byte[]{Byte.MAX_VALUE, (byte) ((int) ((j >> 56) & 255)), (byte) ((int) ((j >> 48) & 255)), (byte) ((int) ((j >> 40) & 255)), (byte) ((int) ((j >> 32) & 255)), (byte) ((int) ((j >> 24) & 255)), (byte) ((int) ((j >> 16) & 255)), (byte) ((int) ((j >> 8) & 255)), (byte) ((int) (j & 255))};
        }
    }

    private static byte[] decodeMaskingKey(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[4];
        readBytesOrThrow(inputStream, bArr, 0, bArr.length);
        return bArr;
    }

    private static void readBytesOrThrow(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        while (i2 > 0) {
            int read = inputStream.read(bArr, i, i2);
            if (read == -1) {
                throw new EOFException();
            }
            i2 -= read;
            i += read;
        }
    }

    private static byte readByteOrThrow(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return (byte) read;
        }
        throw new EOFException();
    }
}
