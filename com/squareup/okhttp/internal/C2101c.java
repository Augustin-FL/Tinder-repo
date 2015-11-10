package com.squareup.okhttp.internal;

import java.io.IOException;
import okio.C2071q;
import okio.C2072g;
import okio.C3334c;

/* renamed from: com.squareup.okhttp.internal.c */
class C2101c extends C2072g {
    private boolean f3161a;

    public C2101c(C2071q c2071q) {
        super(c2071q);
    }

    public void a_(C3334c c3334c, long j) throws IOException {
        if (this.f3161a) {
            c3334c.m10231g(j);
            return;
        }
        try {
            super.a_(c3334c, j);
        } catch (IOException e) {
            this.f3161a = true;
            m5019a(e);
        }
    }

    public void flush() throws IOException {
        if (!this.f3161a) {
            try {
                super.flush();
            } catch (IOException e) {
                this.f3161a = true;
                m5019a(e);
            }
        }
    }

    public void close() throws IOException {
        if (!this.f3161a) {
            try {
                super.close();
            } catch (IOException e) {
                this.f3161a = true;
                m5019a(e);
            }
        }
    }

    protected void m5019a(IOException iOException) {
    }
}
