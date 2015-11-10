package com.google.android.m4b.maps.p010n;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import com.facebook.stetho.BuildConfig;
import com.google.android.m4b.maps.ag.r.a;
import com.google.android.m4b.maps.bo.h;
import com.google.android.m4b.maps.w.g;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.google.android.m4b.maps.n.c */
public final class C1490c implements a {
    private com.google.android.m4b.maps.ch.a f1463a;
    private boolean f1464b;
    private String f1465c;
    private Context f1466d;

    public C1490c(Context context) {
        this.f1466d = context;
        String a = C1490c.m2320a(context);
        if (a != null) {
            int indexOf = a.indexOf(58);
            a = (indexOf == -1 || indexOf >= a.length()) ? BuildConfig.FLAVOR : "_" + a.substring(indexOf + 1);
        } else {
            a = BuildConfig.FLAVOR;
        }
        this.f1465c = "event_store_v2" + a;
        File fileStreamPath = context.getFileStreamPath("event_store" + a);
        if (fileStreamPath != null && fileStreamPath.exists()) {
            fileStreamPath.delete();
        }
    }

    public final synchronized com.google.android.m4b.maps.ch.a m2322a() {
        if (!this.f1464b) {
            m2321c();
        }
        return this.f1463a;
    }

    public final synchronized void m2323a(com.google.android.m4b.maps.ch.a aVar) {
        this.f1463a = aVar;
        this.f1464b = true;
    }

    private synchronized void m2321c() {
        InputStream inputStream = null;
        synchronized (this) {
            if (this.f1465c != null) {
                try {
                    inputStream = this.f1466d.openFileInput(this.f1465c);
                    if (inputStream != null) {
                        this.f1463a = new com.google.android.m4b.maps.ch.a(h.a);
                        this.f1463a.a(g.a(inputStream));
                        inputStream.close();
                    } else {
                        this.f1463a = null;
                    }
                } catch (IOException e) {
                    this.f1463a = null;
                    g.b(inputStream);
                    this.f1466d.deleteFile(this.f1465c);
                }
            }
            this.f1464b = true;
        }
    }

    public final synchronized void m2324b() {
        OutputStream outputStream = null;
        synchronized (this) {
            if (this.f1465c != null) {
                if (this.f1463a == null) {
                    this.f1466d.deleteFile(this.f1465c);
                } else {
                    try {
                        outputStream = this.f1466d.openFileOutput(this.f1465c, 0);
                        outputStream.write(this.f1463a.d());
                        outputStream.close();
                    } catch (IOException e) {
                        g.a(outputStream);
                        this.f1466d.deleteFile(this.f1465c);
                    }
                }
            }
            this.f1463a = null;
            this.f1464b = false;
        }
    }

    private static String m2320a(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        int myPid = Process.myPid();
        for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }
}
