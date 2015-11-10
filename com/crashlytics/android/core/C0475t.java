package com.crashlytics.android.core;

import io.fabric.sdk.android.C3218c;
import io.fabric.sdk.android.services.common.C3264n;
import io.fabric.sdk.android.services.common.C3264n.C0473c;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import org.apache.http.protocol.HTTP;

/* renamed from: com.crashlytics.android.core.t */
class C0475t implements C0452o {
    private final File f675a;
    private final int f676b;
    private C3264n f677c;

    /* renamed from: com.crashlytics.android.core.t.1 */
    class C04741 implements C0473c {
        final /* synthetic */ byte[] f672a;
        final /* synthetic */ int[] f673b;
        final /* synthetic */ C0475t f674c;

        C04741(C0475t c0475t, byte[] bArr, int[] iArr) {
            this.f674c = c0475t;
            this.f672a = bArr;
            this.f673b = iArr;
        }

        public void m863a(InputStream inputStream, int i) throws IOException {
            try {
                inputStream.read(this.f672a, this.f673b[0], i);
                int[] iArr = this.f673b;
                iArr[0] = iArr[0] + i;
            } finally {
                inputStream.close();
            }
        }
    }

    public C0475t(File file, int i) {
        this.f675a = file;
        this.f676b = i;
    }

    public void m867a(long j, String str) {
        m865d();
        m864b(j, str);
    }

    public C0406b m866a() {
        if (!this.f675a.exists()) {
            return null;
        }
        m865d();
        if (this.f677c == null) {
            return null;
        }
        int[] iArr = new int[]{0};
        byte[] bArr = new byte[this.f677c.m9966a()];
        try {
            this.f677c.m9967a(new C04741(this, bArr, iArr));
        } catch (Throwable e) {
            C3218c.m9728h().m9695e("CrashlyticsCore", "A problem occurred while reading the Crashlytics log file.", e);
        }
        return C0406b.m621a(bArr, 0, iArr[0]);
    }

    public void m868b() {
        CommonUtils.m9855a(this.f677c, "There was a problem closing the Crashlytics log file.");
        this.f677c = null;
    }

    public void m869c() {
        m868b();
        this.f675a.delete();
    }

    private void m865d() {
        if (this.f677c == null) {
            try {
                this.f677c = new C3264n(this.f675a);
            } catch (Throwable e) {
                C3218c.m9728h().m9695e("CrashlyticsCore", "Could not open log file: " + this.f675a, e);
            }
        }
    }

    private void m864b(long j, String str) {
        if (this.f677c != null) {
            String str2;
            if (str == null) {
                str2 = "null";
            } else {
                str2 = str;
            }
            try {
                int i = this.f676b / 4;
                if (str2.length() > i) {
                    str2 = "..." + str2.substring(str2.length() - i);
                }
                str2 = str2.replaceAll("\r", " ").replaceAll("\n", " ");
                this.f677c.m9968a(String.format(Locale.US, "%d %s%n", new Object[]{Long.valueOf(j), str2}).getBytes(HTTP.UTF_8));
                while (!this.f677c.m9971b() && this.f677c.m9966a() > this.f676b) {
                    this.f677c.m9972c();
                }
            } catch (Throwable e) {
                C3218c.m9728h().m9695e("CrashlyticsCore", "There was a problem writing to the Crashlytics log.", e);
            }
        }
    }
}
