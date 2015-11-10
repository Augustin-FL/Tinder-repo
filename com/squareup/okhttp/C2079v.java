package com.squareup.okhttp;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import okio.C3333e;

/* renamed from: com.squareup.okhttp.v */
public abstract class C2079v implements Closeable {
    public abstract long m4905a() throws IOException;

    public abstract C3333e m4906b() throws IOException;

    public final InputStream m4907c() throws IOException {
        return m4906b().m10186h();
    }

    public void close() throws IOException {
        m4906b().close();
    }
}
