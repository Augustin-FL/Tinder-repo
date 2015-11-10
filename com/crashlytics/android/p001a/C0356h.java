package com.crashlytics.android.p001a;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.facebook.stetho.BuildConfig;
import io.fabric.sdk.android.C3218c;
import io.fabric.sdk.android.services.p002a.C0355d;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* renamed from: com.crashlytics.android.a.h */
public class C0356h implements C0355d<String> {
    public /* synthetic */ Object m443c(Context context) throws Exception {
        return m440a(context);
    }

    public String m440a(Context context) throws Exception {
        long nanoTime = System.nanoTime();
        String str = BuildConfig.FLAVOR;
        ZipInputStream zipInputStream = null;
        try {
            zipInputStream = m442b(context);
            str = m441a(zipInputStream);
            if (zipInputStream != null) {
                try {
                    zipInputStream.close();
                } catch (Throwable e) {
                    C3218c.m9728h().m9695e("Beta", "Failed to close the APK file", e);
                }
            }
        } catch (Throwable e2) {
            C3218c.m9728h().m9695e("Beta", "Failed to find this app in the PackageManager", e2);
            if (zipInputStream != null) {
                try {
                    zipInputStream.close();
                } catch (Throwable e22) {
                    C3218c.m9728h().m9695e("Beta", "Failed to close the APK file", e22);
                }
            }
        } catch (Throwable e222) {
            C3218c.m9728h().m9695e("Beta", "Failed to find the APK file", e222);
            if (zipInputStream != null) {
                try {
                    zipInputStream.close();
                } catch (Throwable e2222) {
                    C3218c.m9728h().m9695e("Beta", "Failed to close the APK file", e2222);
                }
            }
        } catch (Throwable e22222) {
            C3218c.m9728h().m9695e("Beta", "Failed to read the APK file", e22222);
            if (zipInputStream != null) {
                try {
                    zipInputStream.close();
                } catch (Throwable e222222) {
                    C3218c.m9728h().m9695e("Beta", "Failed to close the APK file", e222222);
                }
            }
        } catch (Throwable th) {
            if (zipInputStream != null) {
                try {
                    zipInputStream.close();
                } catch (Throwable e2222222) {
                    C3218c.m9728h().m9695e("Beta", "Failed to close the APK file", e2222222);
                }
            }
        }
        C3218c.m9728h().m9687a("Beta", "Beta device token load took " + (((double) (System.nanoTime() - nanoTime)) / 1000000.0d) + "ms");
        return str;
    }

    ZipInputStream m442b(Context context) throws NameNotFoundException, FileNotFoundException {
        return new ZipInputStream(new FileInputStream(context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir));
    }

    String m441a(ZipInputStream zipInputStream) throws IOException {
        String name;
        do {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                return BuildConfig.FLAVOR;
            }
            name = nextEntry.getName();
        } while (!name.startsWith("assets/com.crashlytics.android.beta/dirfactor-device-token="));
        return name.substring("assets/com.crashlytics.android.beta/dirfactor-device-token=".length(), name.length() - 1);
    }
}
