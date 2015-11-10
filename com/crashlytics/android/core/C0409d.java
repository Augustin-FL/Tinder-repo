package com.crashlytics.android.core;

import com.facebook.stetho.BuildConfig;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

/* renamed from: com.crashlytics.android.core.d */
class C0409d extends FileOutputStream {
    public static final FilenameFilter f531a;
    private final String f532b;
    private File f533c;
    private File f534d;
    private boolean f535e;

    /* renamed from: com.crashlytics.android.core.d.1 */
    static class C04081 implements FilenameFilter {
        C04081() {
        }

        public boolean accept(File file, String str) {
            return str.endsWith(".cls_temp");
        }
    }

    public C0409d(File file, String str) throws FileNotFoundException {
        super(new File(file, str + ".cls_temp"));
        this.f535e = false;
        this.f532b = file + File.separator + str;
        this.f533c = new File(this.f532b + ".cls_temp");
    }

    public synchronized void close() throws IOException {
        if (!this.f535e) {
            this.f535e = true;
            super.flush();
            super.close();
            File file = new File(this.f532b + ".cls");
            if (this.f533c.renameTo(file)) {
                this.f533c = null;
                this.f534d = file;
            } else {
                String str = BuildConfig.FLAVOR;
                if (file.exists()) {
                    str = " (target already exists)";
                } else if (!this.f533c.exists()) {
                    str = " (source does not exist)";
                }
                throw new IOException("Could not rename temp file: " + this.f533c + " -> " + file + str);
            }
        }
    }

    public void m630a() throws IOException {
        if (!this.f535e) {
            this.f535e = true;
            super.flush();
            super.close();
        }
    }

    static {
        f531a = new C04081();
    }
}
