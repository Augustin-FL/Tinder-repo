package com.crashlytics.android.core;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Build.VERSION;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.stetho.BuildConfig;
import io.fabric.sdk.android.C3218c;
import io.fabric.sdk.android.services.common.C3250g;
import io.fabric.sdk.android.services.common.IdManager.DeviceIdentifierType;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.crashlytics.android.core.w */
class C0481w {
    private static final C0406b f686a;
    private RunningAppProcessInfo f687b;
    private Thread[] f688c;
    private List<StackTraceElement[]> f689d;
    private StackTraceElement[] f690e;
    private final Context f691f;
    private final C0406b f692g;
    private final C0406b f693h;
    private final int f694i;

    static {
        f686a = C0406b.m620a(AppEventsConstants.EVENT_PARAM_VALUE_NO);
    }

    public C0481w(Context context, String str, String str2) {
        this.f694i = 8;
        this.f691f = context;
        this.f692g = C0406b.m620a(str2);
        this.f693h = str == null ? null : C0406b.m620a(str.replace("-", BuildConfig.FLAVOR));
    }

    public void m910a(CodedOutputStream codedOutputStream, String str, String str2, long j) throws Exception {
        codedOutputStream.m594a(1, C0406b.m620a(str2));
        codedOutputStream.m594a(2, C0406b.m620a(str));
        codedOutputStream.m593a(3, j);
    }

    public void m912a(CodedOutputStream codedOutputStream, String str, String str2, String str3, String str4, int i) throws Exception {
        C0406b a = C0406b.m620a(str);
        C0406b a2 = C0406b.m620a(str2);
        C0406b a3 = C0406b.m620a(str3);
        C0406b a4 = C0406b.m620a(str4);
        codedOutputStream.m611g(7, 2);
        codedOutputStream.m613k(m887a(a, a2, a3, a4, i));
        codedOutputStream.m594a(1, a);
        codedOutputStream.m594a(2, a2);
        codedOutputStream.m594a(3, a3);
        codedOutputStream.m611g(5, 2);
        codedOutputStream.m613k(m883a());
        codedOutputStream.m595a(1, new C3250g().m9930a(this.f691f));
        codedOutputStream.m594a(6, a4);
        codedOutputStream.m605b(10, i);
    }

    public void m913a(CodedOutputStream codedOutputStream, boolean z) throws Exception {
        C0406b a = C0406b.m620a(VERSION.RELEASE);
        C0406b a2 = C0406b.m620a(VERSION.CODENAME);
        codedOutputStream.m611g(8, 2);
        codedOutputStream.m613k(m888a(a, a2, z));
        codedOutputStream.m605b(1, 3);
        codedOutputStream.m594a(2, a);
        codedOutputStream.m594a(3, a2);
        codedOutputStream.m596a(4, z);
    }

    public void m909a(CodedOutputStream codedOutputStream, String str, int i, String str2, int i2, long j, long j2, boolean z, Map<DeviceIdentifierType, String> map, int i3, String str3, String str4) throws Exception {
        C0406b a = C0406b.m620a(str);
        C0406b a2 = m897a(str2);
        C0406b a3 = m897a(str4);
        C0406b a4 = m897a(str3);
        codedOutputStream.m611g(9, 2);
        codedOutputStream.m613k(m885a(i, a, a2, i2, j, j2, z, map, i3, a4, a3));
        codedOutputStream.m594a(1, a);
        codedOutputStream.m605b(3, i);
        codedOutputStream.m594a(4, a2);
        codedOutputStream.m592a(5, i2);
        codedOutputStream.m593a(6, j);
        codedOutputStream.m593a(7, j2);
        codedOutputStream.m596a(10, z);
        for (Entry entry : map.entrySet()) {
            codedOutputStream.m611g(11, 2);
            codedOutputStream.m613k(m889a((DeviceIdentifierType) entry.getKey(), (String) entry.getValue()));
            codedOutputStream.m605b(1, ((DeviceIdentifierType) entry.getKey()).f7050h);
            codedOutputStream.m594a(2, C0406b.m620a((String) entry.getValue()));
        }
        codedOutputStream.m592a(12, i3);
        if (a4 != null) {
            codedOutputStream.m594a(13, a4);
        }
        if (a3 != null) {
            codedOutputStream.m594a(14, a3);
        }
    }

    public void m911a(CodedOutputStream codedOutputStream, String str, String str2, String str3) throws Exception {
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        C0406b a = C0406b.m620a(str);
        C0406b a2 = m897a(str2);
        C0406b a3 = m897a(str3);
        int b = 0 + CodedOutputStream.m572b(1, a);
        if (str2 != null) {
            b += CodedOutputStream.m572b(2, a2);
        }
        if (str3 != null) {
            b += CodedOutputStream.m572b(3, a3);
        }
        codedOutputStream.m611g(6, 2);
        codedOutputStream.m613k(b);
        codedOutputStream.m594a(1, a);
        if (str2 != null) {
            codedOutputStream.m594a(2, a2);
        }
        if (str3 != null) {
            codedOutputStream.m594a(3, a3);
        }
    }

    public void m908a(CodedOutputStream codedOutputStream, long j, Thread thread, Throwable th, String str, Thread[] threadArr, float f, int i, boolean z, int i2, long j2, long j3, RunningAppProcessInfo runningAppProcessInfo, List<StackTraceElement[]> list, StackTraceElement[] stackTraceElementArr, C0455p c0455p, Map<String, String> map) throws Exception {
        this.f687b = runningAppProcessInfo;
        this.f689d = list;
        this.f690e = stackTraceElementArr;
        this.f688c = threadArr;
        C0406b a = c0455p.m810a();
        if (a == null) {
            C3218c.m9728h().m9687a("CrashlyticsCore", "No log data to include with this event.");
        }
        c0455p.m815b();
        codedOutputStream.m611g(10, 2);
        codedOutputStream.m613k(m894a(thread, th, str, j, (Map) map, f, i, z, i2, j2, j3, a));
        codedOutputStream.m593a(1, j);
        codedOutputStream.m594a(2, C0406b.m620a(str));
        m902a(codedOutputStream, thread, th, i2, (Map) map);
        m898a(codedOutputStream, f, i, z, i2, j2, j3);
        m900a(codedOutputStream, a);
    }

    private void m902a(CodedOutputStream codedOutputStream, Thread thread, Throwable th, int i, Map<String, String> map) throws Exception {
        codedOutputStream.m611g(3, 2);
        codedOutputStream.m613k(m893a(thread, th, i, (Map) map));
        m901a(codedOutputStream, thread, th);
        if (!(map == null || map.isEmpty())) {
            m905a(codedOutputStream, (Map) map);
        }
        if (this.f687b != null) {
            codedOutputStream.m596a(3, this.f687b.importance != 100);
        }
        codedOutputStream.m592a(4, i);
    }

    private void m901a(CodedOutputStream codedOutputStream, Thread thread, Throwable th) throws Exception {
        codedOutputStream.m611g(1, 2);
        codedOutputStream.m613k(m892a(thread, th));
        m903a(codedOutputStream, thread, this.f690e, 4, true);
        int length = this.f688c.length;
        for (int i = 0; i < length; i++) {
            m903a(codedOutputStream, this.f688c[i], (StackTraceElement[]) this.f689d.get(i), 0, false);
        }
        m904a(codedOutputStream, th, 1, 2);
        codedOutputStream.m611g(3, 2);
        codedOutputStream.m613k(m907c());
        codedOutputStream.m594a(1, f686a);
        codedOutputStream.m594a(2, f686a);
        codedOutputStream.m593a(3, 0);
        codedOutputStream.m611g(4, 2);
        codedOutputStream.m613k(m906b());
        codedOutputStream.m593a(1, 0);
        codedOutputStream.m593a(2, 0);
        codedOutputStream.m594a(3, this.f692g);
        if (this.f693h != null) {
            codedOutputStream.m594a(4, this.f693h);
        }
    }

    private void m905a(CodedOutputStream codedOutputStream, Map<String, String> map) throws Exception {
        for (Entry entry : map.entrySet()) {
            codedOutputStream.m611g(2, 2);
            codedOutputStream.m613k(m891a((String) entry.getKey(), (String) entry.getValue()));
            codedOutputStream.m594a(1, C0406b.m620a((String) entry.getKey()));
            String str = (String) entry.getValue();
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            codedOutputStream.m594a(2, C0406b.m620a(str));
        }
    }

    private void m904a(CodedOutputStream codedOutputStream, Throwable th, int i, int i2) throws Exception {
        int i3 = 0;
        codedOutputStream.m611g(i2, 2);
        codedOutputStream.m613k(m896a(th, 1));
        codedOutputStream.m594a(1, C0406b.m620a(th.getClass().getName()));
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage != null) {
            codedOutputStream.m594a(3, C0406b.m620a(localizedMessage));
        }
        for (StackTraceElement a : th.getStackTrace()) {
            m899a(codedOutputStream, 4, a, true);
        }
        Throwable cause = th.getCause();
        if (cause == null) {
            return;
        }
        if (i < this.f694i) {
            m904a(codedOutputStream, cause, i + 1, 6);
            return;
        }
        while (cause != null) {
            cause = cause.getCause();
            i3++;
        }
        codedOutputStream.m592a(7, i3);
    }

    private void m903a(CodedOutputStream codedOutputStream, Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z) throws Exception {
        codedOutputStream.m611g(1, 2);
        codedOutputStream.m613k(m895a(thread, stackTraceElementArr, i, z));
        codedOutputStream.m594a(1, C0406b.m620a(thread.getName()));
        codedOutputStream.m592a(2, i);
        for (StackTraceElement a : stackTraceElementArr) {
            m899a(codedOutputStream, 3, a, z);
        }
    }

    private void m899a(CodedOutputStream codedOutputStream, int i, StackTraceElement stackTraceElement, boolean z) throws Exception {
        int i2 = 4;
        codedOutputStream.m611g(i, 2);
        codedOutputStream.m613k(m890a(stackTraceElement, z));
        if (stackTraceElement.isNativeMethod()) {
            codedOutputStream.m593a(1, (long) Math.max(stackTraceElement.getLineNumber(), 0));
        } else {
            codedOutputStream.m593a(1, 0);
        }
        codedOutputStream.m594a(2, C0406b.m620a(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            codedOutputStream.m594a(3, C0406b.m620a(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            codedOutputStream.m593a(4, (long) stackTraceElement.getLineNumber());
        }
        if (!z) {
            i2 = 0;
        }
        codedOutputStream.m592a(5, i2);
    }

    private void m898a(CodedOutputStream codedOutputStream, float f, int i, boolean z, int i2, long j, long j2) throws Exception {
        codedOutputStream.m611g(5, 2);
        codedOutputStream.m613k(m884a(f, i, z, i2, j, j2));
        codedOutputStream.m591a(1, f);
        codedOutputStream.m607c(2, i);
        codedOutputStream.m596a(3, z);
        codedOutputStream.m592a(4, i2);
        codedOutputStream.m593a(5, j);
        codedOutputStream.m593a(6, j2);
    }

    private void m900a(CodedOutputStream codedOutputStream, C0406b c0406b) throws Exception {
        if (c0406b != null) {
            codedOutputStream.m611g(6, 2);
            codedOutputStream.m613k(m886a(c0406b));
            codedOutputStream.m594a(1, c0406b);
        }
    }

    private int m887a(C0406b c0406b, C0406b c0406b2, C0406b c0406b3, C0406b c0406b4, int i) {
        int b = ((0 + CodedOutputStream.m572b(1, c0406b)) + CodedOutputStream.m572b(2, c0406b2)) + CodedOutputStream.m572b(3, c0406b3);
        int a = m883a();
        return ((b + (a + (CodedOutputStream.m585j(5) + CodedOutputStream.m586l(a)))) + CodedOutputStream.m572b(6, c0406b4)) + CodedOutputStream.m580e(10, i);
    }

    private int m883a() {
        return 0 + CodedOutputStream.m572b(1, C0406b.m620a(new C3250g().m9930a(this.f691f)));
    }

    private int m888a(C0406b c0406b, C0406b c0406b2, boolean z) {
        return (((0 + CodedOutputStream.m580e(1, 3)) + CodedOutputStream.m572b(2, c0406b)) + CodedOutputStream.m572b(3, c0406b2)) + CodedOutputStream.m573b(4, z);
    }

    private int m889a(DeviceIdentifierType deviceIdentifierType, String str) {
        return CodedOutputStream.m580e(1, deviceIdentifierType.f7050h) + CodedOutputStream.m572b(2, C0406b.m620a(str));
    }

    private int m885a(int i, C0406b c0406b, C0406b c0406b2, int i2, long j, long j2, boolean z, Map<DeviceIdentifierType, String> map, int i3, C0406b c0406b3, C0406b c0406b4) {
        int i4;
        int i5;
        int e = CodedOutputStream.m580e(3, i) + (0 + CodedOutputStream.m572b(1, c0406b));
        if (c0406b2 == null) {
            i4 = 0;
        } else {
            i4 = CodedOutputStream.m572b(4, c0406b2);
        }
        i4 = ((((i4 + e) + CodedOutputStream.m577d(5, i2)) + CodedOutputStream.m571b(6, j)) + CodedOutputStream.m571b(7, j2)) + CodedOutputStream.m573b(10, z);
        if (map != null) {
            i5 = i4;
            for (Entry entry : map.entrySet()) {
                i4 = m889a((DeviceIdentifierType) entry.getKey(), (String) entry.getValue());
                i5 = (i4 + (CodedOutputStream.m585j(11) + CodedOutputStream.m586l(i4))) + i5;
            }
        } else {
            i5 = i4;
        }
        return (c0406b4 == null ? 0 : CodedOutputStream.m572b(14, c0406b4)) + ((i5 + CodedOutputStream.m577d(12, i3)) + (c0406b3 == null ? 0 : CodedOutputStream.m572b(13, c0406b3)));
    }

    private int m906b() {
        int b = ((0 + CodedOutputStream.m571b(1, 0)) + CodedOutputStream.m571b(2, 0)) + CodedOutputStream.m572b(3, this.f692g);
        if (this.f693h != null) {
            return b + CodedOutputStream.m572b(4, this.f693h);
        }
        return b;
    }

    private int m894a(Thread thread, Throwable th, String str, long j, Map<String, String> map, float f, int i, boolean z, int i2, long j2, long j3, C0406b c0406b) {
        int b = (0 + CodedOutputStream.m571b(1, j)) + CodedOutputStream.m572b(2, C0406b.m620a(str));
        int a = m893a(thread, th, i2, (Map) map);
        b += a + (CodedOutputStream.m585j(3) + CodedOutputStream.m586l(a));
        a = m884a(f, i, z, i2, j2, j3);
        b += a + (CodedOutputStream.m585j(5) + CodedOutputStream.m586l(a));
        if (c0406b == null) {
            return b;
        }
        a = m886a(c0406b);
        return b + (a + (CodedOutputStream.m585j(6) + CodedOutputStream.m586l(a)));
    }

    private int m893a(Thread thread, Throwable th, int i, Map<String, String> map) {
        int i2;
        int a = m892a(thread, th);
        a = (a + (CodedOutputStream.m585j(1) + CodedOutputStream.m586l(a))) + 0;
        if (map != null) {
            i2 = a;
            for (Entry entry : map.entrySet()) {
                a = m891a((String) entry.getKey(), (String) entry.getValue());
                i2 = (a + (CodedOutputStream.m585j(2) + CodedOutputStream.m586l(a))) + i2;
            }
        } else {
            i2 = a;
        }
        if (this.f687b != null) {
            i2 += CodedOutputStream.m573b(3, this.f687b.importance != 100);
        }
        return CodedOutputStream.m577d(4, i) + i2;
    }

    private int m892a(Thread thread, Throwable th) {
        int i;
        int a = m895a(thread, this.f690e, 4, true);
        a = (a + (CodedOutputStream.m585j(1) + CodedOutputStream.m586l(a))) + 0;
        int length = this.f688c.length;
        int i2 = a;
        for (i = 0; i < length; i++) {
            a = m895a(this.f688c[i], (StackTraceElement[]) this.f689d.get(i), 0, false);
            i2 += a + (CodedOutputStream.m585j(1) + CodedOutputStream.m586l(a));
        }
        a = m896a(th, 1);
        a = (a + (CodedOutputStream.m585j(2) + CodedOutputStream.m586l(a))) + i2;
        i = m907c();
        a += i + (CodedOutputStream.m585j(3) + CodedOutputStream.m586l(i));
        i = m906b();
        return a + (i + (CodedOutputStream.m585j(3) + CodedOutputStream.m586l(i)));
    }

    private int m891a(String str, String str2) {
        int b = CodedOutputStream.m572b(1, C0406b.m620a(str));
        if (str2 == null) {
            str2 = BuildConfig.FLAVOR;
        }
        return b + CodedOutputStream.m572b(2, C0406b.m620a(str2));
    }

    private int m884a(float f, int i, boolean z, int i2, long j, long j2) {
        return (((((0 + CodedOutputStream.m570b(1, f)) + CodedOutputStream.m582f(2, i)) + CodedOutputStream.m573b(3, z)) + CodedOutputStream.m577d(4, i2)) + CodedOutputStream.m571b(5, j)) + CodedOutputStream.m571b(6, j2);
    }

    private int m886a(C0406b c0406b) {
        return CodedOutputStream.m572b(1, c0406b);
    }

    private int m896a(Throwable th, int i) {
        int i2 = 0;
        int b = CodedOutputStream.m572b(1, C0406b.m620a(th.getClass().getName())) + 0;
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage != null) {
            b += CodedOutputStream.m572b(3, C0406b.m620a(localizedMessage));
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        int i3 = 0;
        while (i3 < length) {
            int a = m890a(stackTrace[i3], true);
            i3++;
            b = (a + (CodedOutputStream.m585j(4) + CodedOutputStream.m586l(a))) + b;
        }
        Throwable cause = th.getCause();
        if (cause == null) {
            return b;
        }
        if (i < this.f694i) {
            i2 = m896a(cause, i + 1);
            return b + (i2 + (CodedOutputStream.m585j(6) + CodedOutputStream.m586l(i2)));
        }
        while (cause != null) {
            cause = cause.getCause();
            i2++;
        }
        return b + CodedOutputStream.m577d(7, i2);
    }

    private int m907c() {
        return ((0 + CodedOutputStream.m572b(1, f686a)) + CodedOutputStream.m572b(2, f686a)) + CodedOutputStream.m571b(3, 0);
    }

    private int m890a(StackTraceElement stackTraceElement, boolean z) {
        int b;
        int i;
        if (stackTraceElement.isNativeMethod()) {
            b = CodedOutputStream.m571b(1, (long) Math.max(stackTraceElement.getLineNumber(), 0)) + 0;
        } else {
            b = CodedOutputStream.m571b(1, 0) + 0;
        }
        b += CodedOutputStream.m572b(2, C0406b.m620a(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            b += CodedOutputStream.m572b(3, C0406b.m620a(stackTraceElement.getFileName()));
        }
        if (stackTraceElement.isNativeMethod() || stackTraceElement.getLineNumber() <= 0) {
            i = b;
        } else {
            i = b + CodedOutputStream.m571b(4, (long) stackTraceElement.getLineNumber());
        }
        return CodedOutputStream.m577d(5, z ? 2 : 0) + i;
    }

    private int m895a(Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z) {
        int d = CodedOutputStream.m577d(2, i) + CodedOutputStream.m572b(1, C0406b.m620a(thread.getName()));
        for (StackTraceElement a : stackTraceElementArr) {
            int a2 = m890a(a, z);
            d += a2 + (CodedOutputStream.m585j(3) + CodedOutputStream.m586l(a2));
        }
        return d;
    }

    private C0406b m897a(String str) {
        return str == null ? null : C0406b.m620a(str);
    }
}
