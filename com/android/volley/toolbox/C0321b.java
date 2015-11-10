package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.C0290a;
import com.android.volley.C0290a.C0289a;
import com.android.volley.C0310l;
import com.facebook.stetho.BuildConfig;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.android.volley.toolbox.b */
public class C0321b implements C0290a {
    private final Map<String, C0319a> f297a;
    private long f298b;
    private final File f299c;
    private final int f300d;

    /* renamed from: com.android.volley.toolbox.b.a */
    private static class C0319a {
        public long f289a;
        public String f290b;
        public String f291c;
        public long f292d;
        public long f293e;
        public long f294f;
        public Map<String, String> f295g;

        private C0319a() {
        }

        public C0319a(String str, C0289a c0289a) {
            this.f290b = str;
            this.f289a = (long) c0289a.f213a.length;
            this.f291c = c0289a.f214b;
            this.f292d = c0289a.f215c;
            this.f293e = c0289a.f216d;
            this.f294f = c0289a.f217e;
            this.f295g = c0289a.f218f;
        }

        public static C0319a m305a(InputStream inputStream) throws IOException {
            C0319a c0319a = new C0319a();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            if (objectInputStream.readByte() != 2) {
                throw new IOException();
            }
            c0319a.f290b = objectInputStream.readUTF();
            c0319a.f291c = objectInputStream.readUTF();
            if (c0319a.f291c.equals(BuildConfig.FLAVOR)) {
                c0319a.f291c = null;
            }
            c0319a.f292d = objectInputStream.readLong();
            c0319a.f293e = objectInputStream.readLong();
            c0319a.f294f = objectInputStream.readLong();
            c0319a.f295g = C0319a.m306a(objectInputStream);
            return c0319a;
        }

        public C0289a m308a(byte[] bArr) {
            C0289a c0289a = new C0289a();
            c0289a.f213a = bArr;
            c0289a.f214b = this.f291c;
            c0289a.f215c = this.f292d;
            c0289a.f216d = this.f293e;
            c0289a.f217e = this.f294f;
            c0289a.f218f = this.f295g;
            return c0289a;
        }

        public boolean m309a(OutputStream outputStream) {
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeByte(2);
                objectOutputStream.writeUTF(this.f290b);
                objectOutputStream.writeUTF(this.f291c == null ? BuildConfig.FLAVOR : this.f291c);
                objectOutputStream.writeLong(this.f292d);
                objectOutputStream.writeLong(this.f293e);
                objectOutputStream.writeLong(this.f294f);
                C0319a.m307a(this.f295g, objectOutputStream);
                objectOutputStream.flush();
                return true;
            } catch (IOException e) {
                C0310l.m288b("%s", e.toString());
                return false;
            }
        }

        private static void m307a(Map<String, String> map, ObjectOutputStream objectOutputStream) throws IOException {
            if (map != null) {
                objectOutputStream.writeInt(map.size());
                for (Entry entry : map.entrySet()) {
                    objectOutputStream.writeUTF((String) entry.getKey());
                    objectOutputStream.writeUTF((String) entry.getValue());
                }
                return;
            }
            objectOutputStream.writeInt(0);
        }

        private static Map<String, String> m306a(ObjectInputStream objectInputStream) throws IOException {
            int readInt = objectInputStream.readInt();
            Map<String, String> emptyMap = readInt == 0 ? Collections.emptyMap() : new HashMap(readInt);
            for (int i = 0; i < readInt; i++) {
                emptyMap.put(objectInputStream.readUTF().intern(), objectInputStream.readUTF().intern());
            }
            return emptyMap;
        }
    }

    /* renamed from: com.android.volley.toolbox.b.b */
    private static class C0320b extends FilterInputStream {
        private int f296a;

        private C0320b(InputStream inputStream) {
            super(inputStream);
            this.f296a = 0;
        }

        public int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.f296a++;
            }
            return read;
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.f296a += read;
            }
            return read;
        }
    }

    public C0321b(File file, int i) {
        this.f297a = new LinkedHashMap(16, 0.75f, true);
        this.f298b = 0;
        this.f299c = file;
        this.f300d = i;
    }

    public C0321b(File file) {
        this(file, 5242880);
    }

    public synchronized C0289a m316a(String str) {
        C0289a c0289a;
        C0320b c0320b;
        IOException e;
        Throwable th;
        C0319a c0319a = (C0319a) this.f297a.get(str);
        if (c0319a == null) {
            c0289a = null;
        } else {
            File c = m320c(str);
            try {
                c0320b = new C0320b(null);
                try {
                    C0319a.m305a((InputStream) c0320b);
                    c0289a = c0319a.m308a(C0321b.m313a((InputStream) c0320b, (int) (c.length() - ((long) c0320b.f296a))));
                    if (c0320b != null) {
                        try {
                            c0320b.close();
                        } catch (IOException e2) {
                            c0289a = null;
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        C0310l.m288b("%s: %s", c.getAbsolutePath(), e.toString());
                        m319b(str);
                        if (c0320b != null) {
                            try {
                                c0320b.close();
                            } catch (IOException e4) {
                                c0289a = null;
                            }
                        }
                        c0289a = null;
                        return c0289a;
                    } catch (Throwable th2) {
                        th = th2;
                        if (c0320b != null) {
                            try {
                                c0320b.close();
                            } catch (IOException e5) {
                                c0289a = null;
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e6) {
                e = e6;
                c0320b = null;
                C0310l.m288b("%s: %s", c.getAbsolutePath(), e.toString());
                m319b(str);
                if (c0320b != null) {
                    c0320b.close();
                }
                c0289a = null;
                return c0289a;
            } catch (Throwable th3) {
                th = th3;
                c0320b = null;
                if (c0320b != null) {
                    c0320b.close();
                }
                throw th;
            }
        }
        return c0289a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m317a() {
        /*
        r9 = this;
        r0 = 0;
        monitor-enter(r9);
        r1 = r9.f299c;	 Catch:{ all -> 0x0067 }
        r1 = r1.exists();	 Catch:{ all -> 0x0067 }
        if (r1 != 0) goto L_0x0025;
    L_0x000a:
        r0 = r9.f299c;	 Catch:{ all -> 0x0067 }
        r0 = r0.mkdirs();	 Catch:{ all -> 0x0067 }
        if (r0 != 0) goto L_0x0023;
    L_0x0012:
        r0 = "Unable to create cache dir %s";
        r1 = 1;
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x0067 }
        r2 = 0;
        r3 = r9.f299c;	 Catch:{ all -> 0x0067 }
        r3 = r3.getAbsolutePath();	 Catch:{ all -> 0x0067 }
        r1[r2] = r3;	 Catch:{ all -> 0x0067 }
        com.android.volley.C0310l.m289c(r0, r1);	 Catch:{ all -> 0x0067 }
    L_0x0023:
        monitor-exit(r9);
        return;
    L_0x0025:
        r1 = r9.f299c;	 Catch:{ all -> 0x0067 }
        r3 = r1.listFiles();	 Catch:{ all -> 0x0067 }
        if (r3 == 0) goto L_0x0023;
    L_0x002d:
        r4 = r3.length;	 Catch:{ all -> 0x0067 }
        r2 = r0;
    L_0x002f:
        if (r2 >= r4) goto L_0x0023;
    L_0x0031:
        r5 = r3[r2];	 Catch:{ all -> 0x0067 }
        r1 = 0;
        r0 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x0051, all -> 0x0060 }
        r0.<init>(r5);	 Catch:{ IOException -> 0x0051, all -> 0x0060 }
        r1 = com.android.volley.toolbox.C0321b.C0319a.m305a(r0);	 Catch:{ IOException -> 0x0073 }
        r6 = r5.length();	 Catch:{ IOException -> 0x0073 }
        r1.f289a = r6;	 Catch:{ IOException -> 0x0073 }
        r6 = r1.f290b;	 Catch:{ IOException -> 0x0073 }
        r9.m312a(r6, r1);	 Catch:{ IOException -> 0x0073 }
        if (r0 == 0) goto L_0x004d;
    L_0x004a:
        r0.close();	 Catch:{ IOException -> 0x006a }
    L_0x004d:
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x002f;
    L_0x0051:
        r0 = move-exception;
        r0 = r1;
    L_0x0053:
        if (r5 == 0) goto L_0x0058;
    L_0x0055:
        r5.delete();	 Catch:{ all -> 0x006e }
    L_0x0058:
        if (r0 == 0) goto L_0x004d;
    L_0x005a:
        r0.close();	 Catch:{ IOException -> 0x005e }
        goto L_0x004d;
    L_0x005e:
        r0 = move-exception;
        goto L_0x004d;
    L_0x0060:
        r0 = move-exception;
    L_0x0061:
        if (r1 == 0) goto L_0x0066;
    L_0x0063:
        r1.close();	 Catch:{ IOException -> 0x006c }
    L_0x0066:
        throw r0;	 Catch:{ all -> 0x0067 }
    L_0x0067:
        r0 = move-exception;
        monitor-exit(r9);
        throw r0;
    L_0x006a:
        r0 = move-exception;
        goto L_0x004d;
    L_0x006c:
        r1 = move-exception;
        goto L_0x0066;
    L_0x006e:
        r1 = move-exception;
        r8 = r1;
        r1 = r0;
        r0 = r8;
        goto L_0x0061;
    L_0x0073:
        r1 = move-exception;
        goto L_0x0053;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.b.a():void");
    }

    public synchronized void m318a(String str, C0289a c0289a) {
        m311a(c0289a.f213a.length);
        File c = m320c(str);
        try {
            OutputStream fileOutputStream = new FileOutputStream(c);
            C0319a c0319a = new C0319a(str, c0289a);
            c0319a.m309a(fileOutputStream);
            fileOutputStream.write(c0289a.f213a);
            fileOutputStream.close();
            m312a(str, c0319a);
        } catch (IOException e) {
            if (!c.delete()) {
                C0310l.m288b("Could not clean up file %s", c.getAbsolutePath());
            }
        }
    }

    public synchronized void m319b(String str) {
        boolean delete = m320c(str).delete();
        m315e(str);
        if (!delete) {
            C0310l.m288b("Could not delete cache entry for key=%s, filename=%s", str, m314d(str));
        }
    }

    private String m314d(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    public File m320c(String str) {
        return new File(this.f299c, m314d(str));
    }

    private void m311a(int i) {
        if (this.f298b + ((long) i) >= ((long) this.f300d)) {
            int i2;
            if (C0310l.f270b) {
                C0310l.m286a("Pruning old cache entries.", new Object[0]);
            }
            long j = this.f298b;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator it = this.f297a.entrySet().iterator();
            int i3 = 0;
            while (it.hasNext()) {
                C0319a c0319a = (C0319a) ((Entry) it.next()).getValue();
                if (m320c(c0319a.f290b).delete()) {
                    this.f298b -= c0319a.f289a;
                } else {
                    C0310l.m288b("Could not delete cache entry for key=%s, filename=%s", c0319a.f290b, m314d(c0319a.f290b));
                }
                it.remove();
                i2 = i3 + 1;
                if (((float) (this.f298b + ((long) i))) < ((float) this.f300d) * 0.9f) {
                    break;
                }
                i3 = i2;
            }
            i2 = i3;
            if (C0310l.f270b) {
                C0310l.m286a("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.f298b - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
        }
    }

    private void m312a(String str, C0319a c0319a) {
        if (this.f297a.containsKey(str)) {
            C0319a c0319a2 = (C0319a) this.f297a.get(str);
            this.f298b = (c0319a.f289a - c0319a2.f289a) + this.f298b;
        } else {
            this.f298b += c0319a.f289a;
        }
        this.f297a.put(str, c0319a);
    }

    private void m315e(String str) {
        C0319a c0319a = (C0319a) this.f297a.get(str);
        if (c0319a != null) {
            this.f298b -= c0319a.f289a;
            this.f297a.remove(str);
        }
    }

    private static byte[] m313a(InputStream inputStream, int i) throws IOException {
        if (i < 0) {
            throw new IOException("Array was negative length");
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == i) {
            return bArr;
        }
        throw new IOException("Expected " + i + " bytes, read " + i2 + " bytes");
    }
}
