package com.squareup.okhttp.internal.p027b;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import okio.C2071q;
import okio.C2076r;
import okio.C3342l;

/* renamed from: com.squareup.okhttp.internal.b.a */
public interface C2108a {
    public static final C2108a f3183a;

    /* renamed from: com.squareup.okhttp.internal.b.a.1 */
    static class C21091 implements C2108a {
        C21091() {
        }

        public C2076r m5054a(File file) throws FileNotFoundException {
            return C3342l.m10284a(file);
        }

        public C2071q m5056b(File file) throws FileNotFoundException {
            try {
                return C3342l.m10287b(file);
            } catch (FileNotFoundException e) {
                file.getParentFile().mkdirs();
                return C3342l.m10287b(file);
            }
        }

        public C2071q m5057c(File file) throws FileNotFoundException {
            try {
                return C3342l.m10290c(file);
            } catch (FileNotFoundException e) {
                file.getParentFile().mkdirs();
                return C3342l.m10290c(file);
            }
        }

        public void m5058d(File file) throws IOException {
            if (!file.delete() && file.exists()) {
                throw new IOException("failed to delete " + file);
            }
        }

        public boolean m5059e(File file) throws IOException {
            return file.exists();
        }

        public long m5060f(File file) {
            return file.length();
        }

        public void m5055a(File file, File file2) throws IOException {
            m5058d(file2);
            if (!file.renameTo(file2)) {
                throw new IOException("failed to rename " + file + " to " + file2);
            }
        }

        public void m5061g(File file) throws IOException {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                throw new IOException("not a readable directory: " + file);
            }
            int length = listFiles.length;
            int i = 0;
            while (i < length) {
                File file2 = listFiles[i];
                if (file2.isDirectory()) {
                    m5061g(file2);
                }
                if (file2.delete()) {
                    i++;
                } else {
                    throw new IOException("failed to delete " + file2);
                }
            }
        }
    }

    C2076r m5046a(File file) throws FileNotFoundException;

    void m5047a(File file, File file2) throws IOException;

    C2071q m5048b(File file) throws FileNotFoundException;

    C2071q m5049c(File file) throws FileNotFoundException;

    void m5050d(File file) throws IOException;

    boolean m5051e(File file) throws IOException;

    long m5052f(File file);

    void m5053g(File file) throws IOException;

    static {
        f3183a = new C21091();
    }
}
