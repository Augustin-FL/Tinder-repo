package com.crashlytics.android.core;

import com.facebook.stetho.BuildConfig;
import io.fabric.sdk.android.C3218c;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.Closeable;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

/* renamed from: com.crashlytics.android.core.n */
final class C0451n {
    public static void m795a(Throwable th, OutputStream outputStream) {
        if (outputStream != null) {
            C0451n.m797b(th, outputStream);
        }
    }

    private static void m797b(Throwable th, OutputStream outputStream) {
        Closeable printWriter;
        Throwable e;
        try {
            printWriter = new PrintWriter(outputStream);
            try {
                C0451n.m796a(th, (Writer) printWriter);
                CommonUtils.m9855a(printWriter, "Failed to close stack trace writer.");
            } catch (Exception e2) {
                e = e2;
                try {
                    C3218c.m9728h().m9695e("CrashlyticsCore", "Failed to create PrintWriter", e);
                    CommonUtils.m9855a(printWriter, "Failed to close stack trace writer.");
                } catch (Throwable th2) {
                    e = th2;
                    CommonUtils.m9855a(printWriter, "Failed to close stack trace writer.");
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            printWriter = null;
            C3218c.m9728h().m9695e("CrashlyticsCore", "Failed to create PrintWriter", e);
            CommonUtils.m9855a(printWriter, "Failed to close stack trace writer.");
        } catch (Throwable th3) {
            e = th3;
            printWriter = null;
            CommonUtils.m9855a(printWriter, "Failed to close stack trace writer.");
            throw e;
        }
    }

    private static void m796a(Throwable th, Writer writer) {
        Object obj = 1;
        while (th != null) {
            try {
                String a = C0451n.m794a(th);
                writer.write((obj != null ? BuildConfig.FLAVOR : "Caused by: ") + th.getClass().getName() + ": " + (a != null ? a : BuildConfig.FLAVOR) + "\n");
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    writer.write("\tat " + stackTraceElement.toString() + "\n");
                }
                th = th.getCause();
                obj = null;
            } catch (Throwable e) {
                C3218c.m9728h().m9695e("CrashlyticsCore", "Could not write stack trace", e);
                return;
            }
        }
    }

    private static String m794a(Throwable th) {
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            return null;
        }
        return localizedMessage.replaceAll("(\r\n|\n|\f)", " ");
    }
}
