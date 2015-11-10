package com.tinder.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.android.volley.C0304h;
import com.android.volley.C0307i.C0305a;
import com.android.volley.C0307i.C0306b;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tinder.utils.r */
public class C3088r {
    private final C0304h f6647a;
    private final C3085b f6648b;
    private final HashMap<String, C3084a> f6649c;
    private final HashMap<String, C3084a> f6650d;
    private final Handler f6651e;
    private int f6652f;
    @Nullable
    private Runnable f6653g;

    /* renamed from: com.tinder.utils.r.1 */
    class C30811 implements C0306b<Bitmap> {
        final /* synthetic */ String f6632a;
        final /* synthetic */ C3088r f6633b;

        C30811(C3088r c3088r, String str) {
            this.f6633b = c3088r;
            this.f6632a = str;
        }

        public void m9425a(Bitmap bitmap) {
            this.f6633b.m9445a(this.f6632a, bitmap);
        }
    }

    /* renamed from: com.tinder.utils.r.2 */
    class C30822 implements C0305a {
        final /* synthetic */ String f6634a;
        final /* synthetic */ C3088r f6635b;

        C30822(C3088r c3088r, String str) {
            this.f6635b = c3088r;
            this.f6634a = str;
        }

        public void onErrorResponse(VolleyError volleyError) {
            this.f6635b.m9446a(this.f6634a, volleyError);
        }
    }

    /* renamed from: com.tinder.utils.r.3 */
    class C30833 implements Runnable {
        final /* synthetic */ VolleyError f6636a;
        final /* synthetic */ C3088r f6637b;

        C30833(C3088r c3088r, VolleyError volleyError) {
            this.f6637b = c3088r;
            this.f6636a = volleyError;
        }

        public void run() {
            for (C3084a c3084a : this.f6637b.f6650d.values()) {
                Iterator it = c3084a.f6640c.iterator();
                while (it.hasNext()) {
                    C3086c c3086c = (C3086c) it.next();
                    if (c3086c.f6643b != null) {
                        if (this.f6636a == null) {
                            c3086c.f6646e = c3084a.f6641d;
                            c3086c.f6643b.onResponse(c3086c, false);
                        } else {
                            c3086c.f6643b.onErrorResponse(this.f6636a);
                        }
                    }
                }
            }
            this.f6637b.f6650d.clear();
            this.f6637b.f6653g = null;
        }
    }

    /* renamed from: com.tinder.utils.r.a */
    private class C3084a {
        final /* synthetic */ C3088r f6638a;
        private final Request<?> f6639b;
        private final LinkedList<C3086c> f6640c;
        private Bitmap f6641d;

        public C3084a(C3088r c3088r, Request<?> request, C3086c c3086c) {
            this.f6638a = c3088r;
            this.f6640c = new LinkedList();
            this.f6639b = request;
            this.f6640c.add(c3086c);
        }

        public void m9430a(C3086c c3086c) {
            this.f6640c.add(c3086c);
        }

        public boolean m9431b(C3086c c3086c) {
            this.f6640c.remove(c3086c);
            if (this.f6640c.size() != 0) {
                return false;
            }
            this.f6639b.m231g();
            return true;
        }
    }

    /* renamed from: com.tinder.utils.r.b */
    public interface C3085b {
        Bitmap m9432a(String str);

        void m9433a(String str, Bitmap bitmap);
    }

    /* renamed from: com.tinder.utils.r.c */
    public class C3086c {
        final /* synthetic */ C3088r f6642a;
        private final C3087d f6643b;
        private final String f6644c;
        private final String f6645d;
        private Bitmap f6646e;

        public C3086c(C3088r c3088r, Bitmap bitmap, String str, String str2, C3087d c3087d) {
            this.f6642a = c3088r;
            this.f6646e = bitmap;
            this.f6645d = str;
            this.f6644c = str2;
            this.f6643b = c3087d;
        }

        public void m9436a() {
            if (this.f6643b != null) {
                C3084a c3084a = (C3084a) this.f6642a.f6649c.get(this.f6644c);
                if (c3084a == null) {
                    c3084a = (C3084a) this.f6642a.f6650d.get(this.f6644c);
                    if (c3084a != null) {
                        c3084a.m9431b(this);
                        if (c3084a.f6640c.size() == 0) {
                            this.f6642a.f6650d.remove(this.f6644c);
                        }
                    }
                } else if (c3084a.m9431b(this)) {
                    this.f6642a.f6649c.remove(this.f6644c);
                }
            }
        }

        public Bitmap m9437b() {
            return this.f6646e;
        }

        public String m9438c() {
            return this.f6645d;
        }
    }

    /* renamed from: com.tinder.utils.r.d */
    public interface C3087d extends C0305a {
        void onResponse(C3086c c3086c, boolean z);
    }

    private static String m9440a(@NonNull String str, int i, int i2) {
        return new StringBuilder(str.length() + 12).append("#W").append(i).append("#H").append(i2).append(str).toString();
    }

    @Nullable
    public C3086c m9449a(@NonNull String str, @NonNull C3087d c3087d) {
        return m9450a(str, c3087d, 0, 0);
    }

    @Nullable
    public C3086c m9450a(@NonNull String str, @NonNull C3087d c3087d, int i, int i2) {
        m9442a();
        String a = C3088r.m9440a(str, i, i2);
        Bitmap a2 = this.f6648b.m9432a(a);
        if (a2 != null) {
            C3086c c3086c = new C3086c(this, a2, str, null, null);
            c3087d.onResponse(c3086c, true);
            return c3086c;
        }
        c3086c = new C3086c(this, null, str, a, c3087d);
        c3087d.onResponse(c3086c, true);
        C3084a c3084a = (C3084a) this.f6649c.get(a);
        if (c3084a != null) {
            c3084a.m9430a(c3086c);
            return c3086c;
        }
        Request c3089s = new C3089s(str, new C30811(this, a), i, i2, Config.RGB_565, new C30822(this, a));
        this.f6647a.m272a(c3089s);
        this.f6649c.put(a, new C3084a(this, c3089s, c3086c));
        return c3086c;
    }

    private void m9445a(String str, Bitmap bitmap) {
        this.f6648b.m9433a(str, bitmap);
        C3084a c3084a = (C3084a) this.f6649c.remove(str);
        if (c3084a != null) {
            c3084a.f6641d = bitmap;
            m9447a(str, c3084a, null);
        }
    }

    private void m9446a(String str, VolleyError volleyError) {
        C3084a c3084a = (C3084a) this.f6649c.remove(str);
        if (c3084a != null) {
            m9447a(str, c3084a, volleyError);
        }
    }

    private void m9447a(String str, C3084a c3084a, @Nullable VolleyError volleyError) {
        this.f6650d.put(str, c3084a);
        if (this.f6653g == null) {
            this.f6653g = new C30833(this, volleyError);
            this.f6651e.postDelayed(this.f6653g, (long) this.f6652f);
        }
    }

    private void m9442a() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ImageLoader must be invoked from the main thread.");
        }
    }
}
