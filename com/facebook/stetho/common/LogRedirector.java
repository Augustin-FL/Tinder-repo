package com.facebook.stetho.common;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class LogRedirector {
    private static volatile Logger sLogger;

    public interface Logger {
        boolean isLoggable(String str, int i);

        void log(int i, String str, String str2);
    }

    public static void setLogger(Logger logger) {
        Util.throwIfNull(logger);
        Util.throwIfNotNull(sLogger);
        sLogger = logger;
    }

    public static void m924e(String str, String str2, Throwable th) {
        m923e(str, str2 + "\n" + formatThrowable(th));
    }

    public static void m923e(String str, String str2) {
        log(6, str, str2);
    }

    public static void m930w(String str, String str2, Throwable th) {
        m929w(str, str2 + "\n" + formatThrowable(th));
    }

    public static void m929w(String str, String str2) {
        log(5, str, str2);
    }

    public static void m926i(String str, String str2, Throwable th) {
        m925i(str, str2 + "\n" + formatThrowable(th));
    }

    public static void m925i(String str, String str2) {
        log(4, str, str2);
    }

    public static void m922d(String str, String str2, Throwable th) {
        m921d(str, str2 + "\n" + formatThrowable(th));
    }

    public static void m921d(String str, String str2) {
        log(3, str, str2);
    }

    public static void m928v(String str, String str2, Throwable th) {
        m927v(str, str2 + "\n" + formatThrowable(th));
    }

    public static void m927v(String str, String str2) {
        log(2, str, str2);
    }

    private static String formatThrowable(Throwable th) {
        Writer stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace();
        printWriter.flush();
        return stringWriter.toString();
    }

    private static void log(int i, String str, String str2) {
        Logger logger = sLogger;
        if (logger != null) {
            logger.log(i, str, str2);
        } else {
            Log.println(i, str, str2);
        }
    }

    public static boolean isLoggable(String str, int i) {
        Logger logger = sLogger;
        if (logger != null) {
            return logger.isLoggable(str, i);
        }
        return Log.isLoggable(str, i);
    }
}
