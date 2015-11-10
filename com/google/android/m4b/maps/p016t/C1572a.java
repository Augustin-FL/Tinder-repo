package com.google.android.m4b.maps.p016t;

import java.io.File;
import java.io.RandomAccessFile;

/* renamed from: com.google.android.m4b.maps.t.a */
public class C1572a {
    private RandomAccessFile f1776a;

    /* renamed from: com.google.android.m4b.maps.t.a.a */
    public interface C1571a {
        private File f1775a;

        C1571a(File file) {
            this.f1775a = file;
        }

        C1572a m2794a(String str, boolean z) {
            return new C1572a(new File(this.f1775a, "cache_" + str), "rw");
        }

        void m2795a(String str) {
            File file = new File(this.f1775a, "cache_" + str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public C1572a(File file, String str) {
        this.f1776a = new RandomAccessFile(file, str);
    }

    public void m2796a() {
        this.f1776a.close();
    }

    public void m2800b() {
        this.f1776a.getFD().sync();
    }

    public void m2797a(long j) {
        this.f1776a.seek(j);
    }

    public void m2801b(byte[] bArr) {
        this.f1776a.readFully(bArr);
    }

    public void m2799a(byte[] bArr, int i, int i2) {
        this.f1776a.read(bArr, 0, i2);
    }

    public void m2798a(byte[] bArr) {
        this.f1776a.write(bArr);
    }

    public void m2802b(byte[] bArr, int i, int i2) {
        this.f1776a.write(bArr, i, i2);
    }
}
