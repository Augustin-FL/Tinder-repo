package com.squareup.okhttp.internal;

import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.Socket;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import okio.ByteString;
import okio.C2076r;
import org.apache.http.HttpHost;
import org.apache.http.protocol.HTTP;

/* renamed from: com.squareup.okhttp.internal.k */
public final class C2157k {
    public static final byte[] f3353a;
    public static final String[] f3354b;
    public static final Charset f3355c;

    /* renamed from: com.squareup.okhttp.internal.k.1 */
    static class C21561 implements ThreadFactory {
        final /* synthetic */ String f3351a;
        final /* synthetic */ boolean f3352b;

        C21561(String str, boolean z) {
            this.f3351a = str;
            this.f3352b = z;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f3351a);
            thread.setDaemon(this.f3352b);
            return thread;
        }
    }

    public static boolean m5362b(okio.C2076r r12, int r13, java.util.concurrent.TimeUnit r14) throws java.io.IOException {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x006a in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:58)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
        /*
        r2 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r6 = java.lang.System.nanoTime();
        r0 = r12.m4902a();
        r0 = r0.o_();
        if (r0 == 0) goto L_0x0051;
    L_0x0013:
        r0 = r12.m4902a();
        r0 = r0.m5628d();
        r0 = r0 - r6;
    L_0x001c:
        r4 = r12.m4902a();
        r8 = (long) r13;
        r8 = r14.toNanos(r8);
        r8 = java.lang.Math.min(r0, r8);
        r8 = r8 + r6;
        r4.m5626a(r8);
        r4 = new okio.c;	 Catch:{ InterruptedIOException -> 0x0042, all -> 0x0073 }
        r4.<init>();	 Catch:{ InterruptedIOException -> 0x0042, all -> 0x0073 }
    L_0x0032:
        r8 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;	 Catch:{ InterruptedIOException -> 0x0042, all -> 0x0073 }
        r8 = r12.m4901a(r4, r8);	 Catch:{ InterruptedIOException -> 0x0042, all -> 0x0073 }
        r10 = -1;	 Catch:{ InterruptedIOException -> 0x0042, all -> 0x0073 }
        r5 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));	 Catch:{ InterruptedIOException -> 0x0042, all -> 0x0073 }
        if (r5 == 0) goto L_0x0053;	 Catch:{ InterruptedIOException -> 0x0042, all -> 0x0073 }
    L_0x003e:
        r4.m10251u();	 Catch:{ InterruptedIOException -> 0x0042, all -> 0x0073 }
        goto L_0x0032;
    L_0x0042:
        r4 = move-exception;
        r4 = 0;
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 != 0) goto L_0x006a;
    L_0x0048:
        r0 = r12.m4902a();
        r0.m5629f();
    L_0x004f:
        r0 = r4;
    L_0x0050:
        return r0;
    L_0x0051:
        r0 = r2;
        goto L_0x001c;
    L_0x0053:
        r4 = 1;
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 != 0) goto L_0x0061;
    L_0x0058:
        r0 = r12.m4902a();
        r0.m5629f();
    L_0x005f:
        r0 = r4;
        goto L_0x0050;
    L_0x0061:
        r2 = r12.m4902a();
        r0 = r0 + r6;
        r2.m5626a(r0);
        goto L_0x005f;
    L_0x006a:
        r2 = r12.m4902a();
        r0 = r0 + r6;
        r2.m5626a(r0);
        goto L_0x004f;
    L_0x0073:
        r4 = move-exception;
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 != 0) goto L_0x0080;
    L_0x0078:
        r0 = r12.m4902a();
        r0.m5629f();
    L_0x007f:
        throw r4;
    L_0x0080:
        r2 = r12.m4902a();
        r0 = r0 + r6;
        r2.m5626a(r0);
        goto L_0x007f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.k.b(okio.r, int, java.util.concurrent.TimeUnit):boolean");
    }

    static {
        f3353a = new byte[0];
        f3354b = new String[0];
        f3355c = Charset.forName(HTTP.UTF_8);
    }

    public static int m5346a(URI uri) {
        return C2157k.m5345a(uri.getScheme(), uri.getPort());
    }

    public static int m5347a(URL url) {
        return C2157k.m5345a(url.getProtocol(), url.getPort());
    }

    private static int m5345a(String str, int i) {
        return i != -1 ? i : C2157k.m5344a(str);
    }

    public static int m5344a(String str) {
        if (HttpHost.DEFAULT_SCHEME_NAME.equals(str)) {
            return 80;
        }
        if ("https".equals(str)) {
            return 443;
        }
        return -1;
    }

    public static void m5354a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static boolean m5358a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static void m5355a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    public static void m5357a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    public static void m5356a(Closeable closeable, Closeable closeable2) throws IOException {
        Object obj = null;
        try {
            closeable.close();
        } catch (Throwable th) {
            obj = th;
        }
        try {
            closeable2.close();
        } catch (Throwable th2) {
            if (obj == null) {
                Throwable th3 = th2;
            }
        }
        if (obj != null) {
            if (obj instanceof IOException) {
                throw ((IOException) obj);
            } else if (obj instanceof RuntimeException) {
                throw ((RuntimeException) obj);
            } else if (obj instanceof Error) {
                throw ((Error) obj);
            } else {
                throw new AssertionError(obj);
            }
        }
    }

    public static boolean m5359a(C2076r c2076r, int i, TimeUnit timeUnit) {
        try {
            return C2157k.m5362b(c2076r, i, timeUnit);
        } catch (IOException e) {
            return false;
        }
    }

    public static String m5361b(String str) {
        Object e;
        try {
            return ByteString.m10146a(MessageDigest.getInstance("MD5").digest(str.getBytes(HTTP.UTF_8))).m10155d();
        } catch (NoSuchAlgorithmException e2) {
            e = e2;
            throw new AssertionError(e);
        } catch (UnsupportedEncodingException e3) {
            e = e3;
            throw new AssertionError(e);
        }
    }

    public static ByteString m5353a(ByteString byteString) {
        try {
            return ByteString.m10146a(MessageDigest.getInstance("SHA-1").digest(byteString.m10158g()));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public static <T> List<T> m5348a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> m5349a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static <K, V> Map<K, V> m5351a(Map<K, V> map) {
        return Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    public static ThreadFactory m5352a(String str, boolean z) {
        return new C21561(str, z);
    }

    public static <T> T[] m5360a(Class<T> cls, T[] tArr, T[] tArr2) {
        List a = C2157k.m5350a((Object[]) tArr, (Object[]) tArr2);
        return a.toArray((Object[]) Array.newInstance(cls, a.size()));
    }

    private static <T> List<T> m5350a(T[] tArr, T[] tArr2) {
        List<T> arrayList = new ArrayList();
        for (Object obj : tArr) {
            for (Object obj2 : tArr2) {
                if (obj.equals(obj2)) {
                    arrayList.add(obj2);
                    break;
                }
            }
        }
        return arrayList;
    }
}
