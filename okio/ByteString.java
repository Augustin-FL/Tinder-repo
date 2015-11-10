package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class ByteString implements Serializable {
    static final char[] f7265a;
    public static final ByteString f7266b;
    private static final long serialVersionUID = 1;
    final byte[] f7267c;
    transient int f7268d;
    transient String f7269e;

    static {
        f7265a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        f7266b = m10146a(new byte[0]);
    }

    ByteString(byte[] bArr) {
        this.f7267c = bArr;
    }

    public static ByteString m10146a(byte... bArr) {
        if (bArr != null) {
            return new ByteString((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public static ByteString m10145a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        ByteString byteString = new ByteString(str.getBytes(C3350t.f7317a));
        byteString.f7269e = str;
        return byteString;
    }

    public String m10150a() {
        String str = this.f7269e;
        if (str != null) {
            return str;
        }
        str = new String(this.f7267c, C3350t.f7317a);
        this.f7269e = str;
        return str;
    }

    public String m10153b() {
        return C3329b.m10162a(this.f7267c);
    }

    public ByteString m10154c() {
        return m10148c("MD5");
    }

    private ByteString m10148c(String str) {
        try {
            return m10146a(MessageDigest.getInstance(str).digest(this.f7267c));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public static ByteString m10147b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("base64 == null");
        }
        byte[] a = C3329b.m10164a(str);
        return a != null ? new ByteString(a) : null;
    }

    public String m10155d() {
        int i = 0;
        char[] cArr = new char[(this.f7267c.length * 2)];
        byte[] bArr = this.f7267c;
        int length = bArr.length;
        int i2 = 0;
        while (i < length) {
            byte b = bArr[i];
            int i3 = i2 + 1;
            cArr[i2] = f7265a[(b >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = f7265a[b & 15];
            i++;
        }
        return new String(cArr);
    }

    public static ByteString m10144a(InputStream inputStream, int i) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (i < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + i);
        } else {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int read = inputStream.read(bArr, i2, i - i2);
                if (read == -1) {
                    throw new EOFException();
                }
                i2 += read;
            }
            return new ByteString(bArr);
        }
    }

    public ByteString m10156e() {
        int i = 0;
        while (i < this.f7267c.length) {
            byte b = this.f7267c[i];
            if (b < (byte) 65 || b > (byte) 90) {
                i++;
            } else {
                byte[] bArr = (byte[]) this.f7267c.clone();
                int i2 = i + 1;
                bArr[i] = (byte) (b + 32);
                for (i = i2; i < bArr.length; i++) {
                    byte b2 = bArr[i];
                    if (b2 >= (byte) 65 && b2 <= (byte) 90) {
                        bArr[i] = (byte) (b2 + 32);
                    }
                }
                return new ByteString(bArr);
            }
        }
        return this;
    }

    public byte m10149a(int i) {
        return this.f7267c[i];
    }

    public int m10157f() {
        return this.f7267c.length;
    }

    public byte[] m10158g() {
        return (byte[]) this.f7267c.clone();
    }

    void m10151a(C3334c c3334c) {
        c3334c.m10213b(this.f7267c, 0, this.f7267c.length);
    }

    public boolean m10152a(int i, byte[] bArr, int i2, int i3) {
        return i <= this.f7267c.length - i3 && i2 <= bArr.length - i3 && C3350t.m10342a(this.f7267c, i, bArr, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        boolean z = (obj instanceof ByteString) && ((ByteString) obj).m10157f() == this.f7267c.length && ((ByteString) obj).m10152a(0, this.f7267c, 0, this.f7267c.length);
        return z;
    }

    public int hashCode() {
        int i = this.f7268d;
        if (i != 0) {
            return i;
        }
        i = Arrays.hashCode(this.f7267c);
        this.f7268d = i;
        return i;
    }

    public String toString() {
        if (this.f7267c.length == 0) {
            return "ByteString[size=0]";
        }
        if (this.f7267c.length <= 16) {
            return String.format("ByteString[size=%s data=%s]", new Object[]{Integer.valueOf(this.f7267c.length), m10155d()});
        }
        return String.format("ByteString[size=%s md5=%s]", new Object[]{Integer.valueOf(this.f7267c.length), m10154c().m10155d()});
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        ByteString a = m10144a(objectInputStream, objectInputStream.readInt());
        try {
            Field declaredField = ByteString.class.getDeclaredField("c");
            declaredField.setAccessible(true);
            declaredField.set(this, a.f7267c);
        } catch (NoSuchFieldException e) {
            throw new AssertionError();
        } catch (IllegalAccessException e2) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.f7267c.length);
        objectOutputStream.write(this.f7267c);
    }
}
