package io.fabric.sdk.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import io.fabric.sdk.android.C3211a.C0344b;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.concurrency.C3281b;
import io.fabric.sdk.android.services.concurrency.C3286h;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: io.fabric.sdk.android.c */
public class C3218c {
    static volatile C3218c f6953a;
    static final C3212k f6954b;
    final C3212k f6955c;
    final boolean f6956d;
    private final Context f6957e;
    private final Map<Class<? extends C0347h>, C0347h> f6958f;
    private final ExecutorService f6959g;
    private final Handler f6960h;
    private final C3215f<C3218c> f6961i;
    private final C3215f<?> f6962j;
    private final IdManager f6963k;
    private C3211a f6964l;
    private WeakReference<Activity> f6965m;
    private AtomicBoolean f6966n;

    /* renamed from: io.fabric.sdk.android.c.1 */
    class C32141 extends C0344b {
        final /* synthetic */ C3218c f6939a;

        C32141(C3218c c3218c) {
            this.f6939a = c3218c;
        }

        public void m9710a(Activity activity, Bundle bundle) {
            this.f6939a.m9731a(activity);
        }

        public void m9709a(Activity activity) {
            this.f6939a.m9731a(activity);
        }

        public void m9711b(Activity activity) {
            this.f6939a.m9731a(activity);
        }
    }

    /* renamed from: io.fabric.sdk.android.c.2 */
    class C32162 implements C3215f {
        final CountDownLatch f6941a;
        final /* synthetic */ int f6942b;
        final /* synthetic */ C3218c f6943c;

        C32162(C3218c c3218c, int i) {
            this.f6943c = c3218c;
            this.f6942b = i;
            this.f6941a = new CountDownLatch(this.f6942b);
        }

        public void m9715a(Object obj) {
            this.f6941a.countDown();
            if (this.f6941a.getCount() == 0) {
                this.f6943c.f6966n.set(true);
                this.f6943c.f6961i.m9713a(this.f6943c);
            }
        }

        public void m9714a(Exception exception) {
            this.f6943c.f6961i.m9712a(exception);
        }
    }

    /* renamed from: io.fabric.sdk.android.c.a */
    public static class C3217a {
        private final Context f6944a;
        private C0347h[] f6945b;
        private C3286h f6946c;
        private Handler f6947d;
        private C3212k f6948e;
        private boolean f6949f;
        private String f6950g;
        private String f6951h;
        private C3215f<C3218c> f6952i;

        public C3217a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.f6944a = context.getApplicationContext();
        }

        public C3217a m9716a(C0347h... c0347hArr) {
            if (this.f6945b != null) {
                throw new IllegalStateException("Kits already set.");
            }
            this.f6945b = c0347hArr;
            return this;
        }

        public C3218c m9717a() {
            Map hashMap;
            if (this.f6946c == null) {
                this.f6946c = C3286h.m10008a();
            }
            if (this.f6947d == null) {
                this.f6947d = new Handler(Looper.getMainLooper());
            }
            if (this.f6948e == null) {
                if (this.f6949f) {
                    this.f6948e = new C3213b(3);
                } else {
                    this.f6948e = new C3213b();
                }
            }
            if (this.f6951h == null) {
                this.f6951h = this.f6944a.getPackageName();
            }
            if (this.f6952i == null) {
                this.f6952i = C3215f.f6940d;
            }
            if (this.f6945b == null) {
                hashMap = new HashMap();
            } else {
                hashMap = C3218c.m9725b(Arrays.asList(this.f6945b));
            }
            return new C3218c(this.f6944a, hashMap, this.f6946c, this.f6947d, this.f6948e, this.f6949f, this.f6952i, new IdManager(this.f6944a, this.f6951h, this.f6950g, hashMap.values()));
        }
    }

    static {
        f6954b = new C3213b();
    }

    static C3218c m9718a() {
        if (f6953a != null) {
            return f6953a;
        }
        throw new IllegalStateException("Must Initialize Fabric before using singleton()");
    }

    C3218c(Context context, Map<Class<? extends C0347h>, C0347h> map, C3286h c3286h, Handler handler, C3212k c3212k, boolean z, C3215f c3215f, IdManager idManager) {
        this.f6957e = context;
        this.f6958f = map;
        this.f6959g = c3286h;
        this.f6960h = handler;
        this.f6955c = c3212k;
        this.f6956d = z;
        this.f6961i = c3215f;
        this.f6966n = new AtomicBoolean(false);
        this.f6962j = m9732a(map.size());
        this.f6963k = idManager;
    }

    public static C3218c m9719a(Context context, C0347h... c0347hArr) {
        if (f6953a == null) {
            synchronized (C3218c.class) {
                if (f6953a == null) {
                    C3218c.m9727c(new C3217a(context).m9716a(c0347hArr).m9717a());
                }
            }
        }
        return f6953a;
    }

    private static void m9727c(C3218c c3218c) {
        f6953a = c3218c;
        c3218c.m9730j();
    }

    public C3218c m9731a(Activity activity) {
        this.f6965m = new WeakReference(activity);
        return this;
    }

    public Activity m9735b() {
        if (this.f6965m != null) {
            return (Activity) this.f6965m.get();
        }
        return null;
    }

    private void m9730j() {
        m9731a(m9726c(this.f6957e));
        this.f6964l = new C3211a(this.f6957e);
        this.f6964l.m9684a(new C32141(this));
        m9733a(this.f6957e);
    }

    public String m9737c() {
        return "1.3.6.79";
    }

    public String m9738d() {
        return "io.fabric.sdk.android:fabric";
    }

    void m9733a(Context context) {
        StringBuilder append;
        Future b = m9736b(context);
        Collection g = m9741g();
        C3226l c3226l = new C3226l(b, g);
        List<C0347h> arrayList = new ArrayList(g);
        Collections.sort(arrayList);
        c3226l.m409a(context, this, C3215f.f6940d, this.f6963k);
        for (C0347h a : arrayList) {
            a.m409a(context, this, this.f6962j, this.f6963k);
        }
        c3226l.m415z();
        if (C3218c.m9728h().m9689a("Fabric", 3)) {
            append = new StringBuilder("Initializing ").append(m9738d()).append(" [Version: ").append(m9737c()).append("], with the following kits:\n");
        } else {
            append = null;
        }
        for (C0347h a2 : arrayList) {
            a2.f353f.m9762a(c3226l.f);
            m9734a(this.f6958f, a2);
            a2.m415z();
            if (append != null) {
                append.append(a2.m411b()).append(" [Version: ").append(a2.m408a()).append("]\n");
            }
        }
        if (append != null) {
            C3218c.m9728h().m9687a("Fabric", append.toString());
        }
    }

    void m9734a(Map<Class<? extends C0347h>, C0347h> map, C0347h c0347h) {
        C3281b c3281b = (C3281b) c0347h.getClass().getAnnotation(C3281b.class);
        if (c3281b != null) {
            for (Class cls : c3281b.m9995a()) {
                if (cls.isInterface()) {
                    for (C0347h c0347h2 : map.values()) {
                        if (cls.isAssignableFrom(c0347h2.getClass())) {
                            c0347h.f353f.m9762a(c0347h2.f353f);
                        }
                    }
                } else if (((C0347h) map.get(cls)) == null) {
                    throw new UnmetDependencyException("Referenced Kit was null, does the kit exist?");
                } else {
                    c0347h.f353f.m9762a(((C0347h) map.get(cls)).f353f);
                }
            }
        }
    }

    private Activity m9726c(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    public C3211a m9739e() {
        return this.f6964l;
    }

    public ExecutorService m9740f() {
        return this.f6959g;
    }

    public Collection<C0347h> m9741g() {
        return this.f6958f.values();
    }

    public static <T extends C0347h> T m9720a(Class<T> cls) {
        return (C0347h) C3218c.m9718a().f6958f.get(cls);
    }

    public static C3212k m9728h() {
        if (f6953a == null) {
            return f6954b;
        }
        return f6953a.f6955c;
    }

    public static boolean m9729i() {
        if (f6953a == null) {
            return false;
        }
        return f6953a.f6956d;
    }

    private static Map<Class<? extends C0347h>, C0347h> m9725b(Collection<? extends C0347h> collection) {
        Map hashMap = new HashMap(collection.size());
        C3218c.m9723a(hashMap, (Collection) collection);
        return hashMap;
    }

    private static void m9723a(Map<Class<? extends C0347h>, C0347h> map, Collection<? extends C0347h> collection) {
        for (C0347h c0347h : collection) {
            map.put(c0347h.getClass(), c0347h);
            if (c0347h instanceof C0358i) {
                C3218c.m9723a((Map) map, ((C0358i) c0347h).m444c());
            }
        }
    }

    C3215f<?> m9732a(int i) {
        return new C32162(this, i);
    }

    Future<Map<String, C3225j>> m9736b(Context context) {
        return m9740f().submit(new C3220e(context.getPackageCodePath()));
    }
}
