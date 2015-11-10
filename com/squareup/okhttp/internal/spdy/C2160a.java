package com.squareup.okhttp.internal.spdy;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import okio.C3333e;

/* renamed from: com.squareup.okhttp.internal.spdy.a */
public interface C2160a extends Closeable {

    /* renamed from: com.squareup.okhttp.internal.spdy.a.a */
    public interface C2159a {
        void m5371a(int i, int i2, int i3, boolean z);

        void m5372a(int i, int i2, List<C2162c> list) throws IOException;

        void m5373a(int i, long j);

        void m5374a(int i, ErrorCode errorCode);

        void m5375a(int i, ErrorCode errorCode, ByteString byteString);

        void m5376a(boolean z, int i, int i2);

        void m5377a(boolean z, int i, C3333e c3333e, int i2) throws IOException;

        void m5378a(boolean z, C2182k c2182k);

        void m5379a(boolean z, boolean z2, int i, int i2, List<C2162c> list, HeadersMode headersMode);

        void m5380b();
    }

    void m5381a() throws IOException;

    boolean m5382a(C2159a c2159a) throws IOException;
}
