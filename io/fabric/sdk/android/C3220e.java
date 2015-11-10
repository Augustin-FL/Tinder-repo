package io.fabric.sdk.android;

import android.os.SystemClock;
import android.text.TextUtils;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.Closeable;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: io.fabric.sdk.android.e */
class C3220e implements Callable<Map<String, C3225j>> {
    final String f6969a;

    public /* synthetic */ Object call() throws Exception {
        return m9743a();
    }

    C3220e(String str) {
        this.f6969a = str;
    }

    public Map<String, C3225j> m9743a() throws Exception {
        Map<String, C3225j> hashMap = new HashMap();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        ZipFile b = m9744b();
        Enumeration entries = b.entries();
        int i = 0;
        while (entries.hasMoreElements()) {
            int i2 = i + 1;
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            if (zipEntry.getName().startsWith("fabric/") && zipEntry.getName().length() > "fabric/".length()) {
                C3225j a = m9742a(zipEntry, b);
                if (a != null) {
                    hashMap.put(a.m9779a(), a);
                    C3218c.m9728h().m9690b("Fabric", String.format("Found kit:[%s] version:[%s]", new Object[]{a.m9779a(), a.m9780b()}));
                }
            }
            i = i2;
        }
        if (b != null) {
            try {
                b.close();
            } catch (IOException e) {
            }
        }
        C3218c.m9728h().m9690b("Fabric", "finish scanning in " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " reading:" + i);
        return hashMap;
    }

    private C3225j m9742a(ZipEntry zipEntry, ZipFile zipFile) {
        Throwable e;
        Closeable inputStream;
        try {
            inputStream = zipFile.getInputStream(zipEntry);
            try {
                Properties properties = new Properties();
                properties.load(inputStream);
                Object property = properties.getProperty("fabric-identifier");
                Object property2 = properties.getProperty("fabric-version");
                String property3 = properties.getProperty("fabric-build-type");
                if (TextUtils.isEmpty(property) || TextUtils.isEmpty(property2)) {
                    throw new IllegalStateException("Invalid format of fabric file," + zipEntry.getName());
                }
                C3225j c3225j = new C3225j(property, property2, property3);
                CommonUtils.m9854a(inputStream);
                return c3225j;
            } catch (IOException e2) {
                e = e2;
                try {
                    C3218c.m9728h().m9695e("Fabric", "Error when parsing fabric properties " + zipEntry.getName(), e);
                    CommonUtils.m9854a(inputStream);
                    return null;
                } catch (Throwable th) {
                    e = th;
                    CommonUtils.m9854a(inputStream);
                    throw e;
                }
            }
        } catch (IOException e3) {
            e = e3;
            inputStream = null;
            C3218c.m9728h().m9695e("Fabric", "Error when parsing fabric properties " + zipEntry.getName(), e);
            CommonUtils.m9854a(inputStream);
            return null;
        } catch (Throwable th2) {
            e = th2;
            inputStream = null;
            CommonUtils.m9854a(inputStream);
            throw e;
        }
    }

    protected ZipFile m9744b() throws IOException {
        return new ZipFile(this.f6969a);
    }
}
