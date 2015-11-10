package okio;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.ViewCompat;
import com.tinder.views.RangeSeekBar;
import java.nio.charset.Charset;
import org.apache.http.protocol.HTTP;

/* renamed from: okio.t */
final class C3350t {
    public static final Charset f7317a;

    static {
        f7317a = Charset.forName(HTTP.UTF_8);
    }

    public static void m10340a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}));
        }
    }

    public static short m10339a(short s) {
        int i = SupportMenu.USER_MASK & s;
        return (short) (((i & RangeSeekBar.INVALID_POINTER_ID) << 8) | ((RangeSeekBar.ACTION_POINTER_INDEX_MASK & i) >>> 8));
    }

    public static int m10338a(int i) {
        return ((((ViewCompat.MEASURED_STATE_MASK & i) >>> 24) | ((16711680 & i) >>> 8)) | ((RangeSeekBar.ACTION_POINTER_INDEX_MASK & i) << 8)) | ((i & RangeSeekBar.INVALID_POINTER_ID) << 24);
    }

    public static void m10341a(Throwable th) {
        C3350t.m10343b(th);
    }

    private static <T extends Throwable> void m10343b(Throwable th) throws Throwable {
        throw th;
    }

    public static boolean m10342a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }
}
