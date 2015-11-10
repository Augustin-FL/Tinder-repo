package com.squareup.okhttp.internal.spdy;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import okio.C3334c;

/* renamed from: com.squareup.okhttp.internal.spdy.b */
public interface C2161b extends Closeable {
    void m5383a() throws IOException;

    void m5384a(int i, int i2, List<C2162c> list) throws IOException;

    void m5385a(int i, long j) throws IOException;

    void m5386a(int i, ErrorCode errorCode) throws IOException;

    void m5387a(int i, ErrorCode errorCode, byte[] bArr) throws IOException;

    void m5388a(C2182k c2182k) throws IOException;

    void m5389a(boolean z, int i, int i2) throws IOException;

    void m5390a(boolean z, int i, C3334c c3334c, int i2) throws IOException;

    void m5391a(boolean z, boolean z2, int i, int i2, List<C2162c> list) throws IOException;

    void m5392b() throws IOException;

    void m5393b(C2182k c2182k) throws IOException;

    int m5394c();
}
