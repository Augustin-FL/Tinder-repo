package io.fabric.sdk.android;

import android.util.Log;

/* renamed from: io.fabric.sdk.android.b */
public class C3213b implements C3212k {
    private int f6938a;

    public C3213b(int i) {
        this.f6938a = i;
    }

    public C3213b() {
        this.f6938a = 4;
    }

    public boolean m9700a(String str, int i) {
        return this.f6938a <= i;
    }

    public void m9699a(String str, String str2, Throwable th) {
        if (m9700a(str, 3)) {
            Log.d(str, str2, th);
        }
    }

    public void m9702b(String str, String str2, Throwable th) {
        if (m9700a(str, 2)) {
            Log.v(str, str2, th);
        }
    }

    public void m9704c(String str, String str2, Throwable th) {
        if (m9700a(str, 4)) {
            Log.i(str, str2, th);
        }
    }

    public void m9706d(String str, String str2, Throwable th) {
        if (m9700a(str, 5)) {
            Log.w(str, str2, th);
        }
    }

    public void m9708e(String str, String str2, Throwable th) {
        if (m9700a(str, 6)) {
            Log.e(str, str2, th);
        }
    }

    public void m9698a(String str, String str2) {
        m9699a(str, str2, null);
    }

    public void m9701b(String str, String str2) {
        m9702b(str, str2, null);
    }

    public void m9703c(String str, String str2) {
        m9704c(str, str2, null);
    }

    public void m9705d(String str, String str2) {
        m9706d(str, str2, null);
    }

    public void m9707e(String str, String str2) {
        m9708e(str, str2, null);
    }

    public void m9696a(int i, String str, String str2) {
        m9697a(i, str, str2, false);
    }

    public void m9697a(int i, String str, String str2, boolean z) {
        if (z || m9700a(str, i)) {
            Log.println(i, str, str2);
        }
    }
}
