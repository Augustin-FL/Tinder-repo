package com.crashlytics.android;

import com.crashlytics.android.answers.C0362a;
import com.crashlytics.android.core.C0427e;
import com.crashlytics.android.p001a.C0349c;
import io.fabric.sdk.android.C0347h;
import io.fabric.sdk.android.C0358i;
import io.fabric.sdk.android.C3218c;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/* renamed from: com.crashlytics.android.a */
public class C0359a extends C0347h<Void> implements C0358i {
    public final C0362a f377a;
    public final C0349c f378b;
    public final C0427e f379c;
    public final Collection<? extends C0347h> f380d;

    protected /* synthetic */ Object m456f() {
        return m455d();
    }

    public C0359a() {
        this(new C0362a(), new C0349c(), new C0427e());
    }

    C0359a(C0362a c0362a, C0349c c0349c, C0427e c0427e) {
        this.f377a = c0362a;
        this.f378b = c0349c;
        this.f379c = c0427e;
        this.f380d = Collections.unmodifiableCollection(Arrays.asList(new C0347h[]{c0362a, c0349c, c0427e}));
    }

    public String m452a() {
        return "2.5.2.79";
    }

    public String m453b() {
        return "com.crashlytics.sdk.android:crashlytics";
    }

    public Collection<? extends C0347h> m454c() {
        return this.f380d;
    }

    protected Void m455d() {
        return null;
    }

    public static C0359a m450e() {
        return (C0359a) C3218c.m9720a(C0359a.class);
    }

    public static void m447a(Throwable th) {
        C0359a.m451g();
        C0359a.m450e().f379c.m680a(th);
    }

    public static void m446a(String str) {
        C0359a.m451g();
        C0359a.m450e().f379c.m679a(str);
    }

    public static void m445a(int i, String str, String str2) {
        C0359a.m451g();
        C0359a.m450e().f379c.m678a(i, str, str2);
    }

    public static void m448b(String str) {
        C0359a.m451g();
        C0359a.m450e().f379c.m684b(str);
    }

    public static void m449c(String str) {
        C0359a.m451g();
        C0359a.m450e().f379c.m685c(str);
    }

    private static void m451g() {
        if (C0359a.m450e() == null) {
            throw new IllegalStateException("Crashlytics must be initialized by calling Fabric.with(Context) prior to calling Crashlytics.getInstance()");
        }
    }
}
