package com.google.common.cache;

import com.google.common.cache.Striped64.C1730a;
import com.google.common.cache.Striped64.C1731b;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

final class LongAdder extends Striped64 implements C1722f, Serializable {
    private static final long serialVersionUID = 7249069246863182397L;

    final long m3541a(long j, long j2) {
        return j + j2;
    }

    public void m3543a(long j) {
        long j2;
        boolean z = true;
        C1730a[] c1730aArr = this.c;
        if (c1730aArr == null) {
            j2 = this.d;
            if (m3539b(j2, j2 + j)) {
                return;
            }
        }
        C1731b c1731b = (C1731b) a.get();
        int i = c1731b.f2171b;
        if (c1730aArr != null) {
            int length = c1730aArr.length;
            if (length >= 1) {
                C1730a c1730a = c1730aArr[i & (length - 1)];
                if (c1730a != null) {
                    j2 = c1730a.f2169a;
                    z = c1730a.m3554a(j2, j2 + j);
                    if (z) {
                        return;
                    }
                }
            }
        }
        m3538a(j, c1731b, z);
    }

    public void m3542a() {
        m3543a(1);
    }

    public long m3544b() {
        long j = this.d;
        C1730a[] c1730aArr = this.c;
        if (c1730aArr != null) {
            for (C1730a c1730a : c1730aArr) {
                if (c1730a != null) {
                    j += c1730a.f2169a;
                }
            }
        }
        return j;
    }

    public String toString() {
        return Long.toString(m3544b());
    }

    public long longValue() {
        return m3544b();
    }

    public int intValue() {
        return (int) m3544b();
    }

    public float floatValue() {
        return (float) m3544b();
    }

    public double doubleValue() {
        return (double) m3544b();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeLong(m3544b());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.e = 0;
        this.c = null;
        this.d = objectInputStream.readLong();
    }
}
