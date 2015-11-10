package com.android.volley.toolbox;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.Looper;
import com.android.volley.C0304h;
import com.android.volley.C0307i.C0305a;
import com.android.volley.C0307i.C0306b;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.android.volley.toolbox.g */
public class C0333g {
    private final C0304h f320a;
    private int f321b;
    private final C0331b f322c;
    private final HashMap<String, C0330a> f323d;
    private final HashMap<String, C0330a> f324e;
    private final Handler f325f;
    private Runnable f326g;

    /* renamed from: com.android.volley.toolbox.g.d */
    public interface C0312d extends C0305a {
        void m292a(C0332c c0332c, boolean z);
    }

    /* renamed from: com.android.volley.toolbox.g.1 */
    class C03271 implements C0306b<Bitmap> {
        final /* synthetic */ String f305a;
        final /* synthetic */ C0333g f306b;

        C03271(C0333g c0333g, String str) {
            this.f306b = c0333g;
            this.f305a = str;
        }

        public void m337a(Bitmap bitmap) {
            this.f306b.m357a(this.f305a, bitmap);
        }
    }

    /* renamed from: com.android.volley.toolbox.g.2 */
    class C03282 implements C0305a {
        final /* synthetic */ String f307a;
        final /* synthetic */ C0333g f308b;

        C03282(C0333g c0333g, String str) {
            this.f308b = c0333g;
            this.f307a = str;
        }

        public void onErrorResponse(VolleyError volleyError) {
            this.f308b.m358a(this.f307a, volleyError);
        }
    }

    /* renamed from: com.android.volley.toolbox.g.3 */
    class C03293 implements Runnable {
        final /* synthetic */ VolleyError f309a;
        final /* synthetic */ C0333g f310b;

        C03293(C0333g c0333g, VolleyError volleyError) {
            this.f310b = c0333g;
            this.f309a = volleyError;
        }

        public void run() {
            for (C0330a c0330a : this.f310b.f324e.values()) {
                Iterator it = c0330a.f314d.iterator();
                while (it.hasNext()) {
                    C0332c c0332c = (C0332c) it.next();
                    if (c0332c.f317c != null) {
                        if (this.f309a == null) {
                            c0332c.f316b = c0330a.f313c;
                            c0332c.f317c.m292a(c0332c, false);
                        } else {
                            c0332c.f317c.onErrorResponse(this.f309a);
                        }
                    }
                }
            }
            this.f310b.f324e.clear();
            this.f310b.f326g = null;
        }
    }

    /* renamed from: com.android.volley.toolbox.g.a */
    private class C0330a {
        final /* synthetic */ C0333g f311a;
        private final Request<?> f312b;
        private Bitmap f313c;
        private final LinkedList<C0332c> f314d;

        public C0330a(C0333g c0333g, Request<?> request, C0332c c0332c) {
            this.f311a = c0333g;
            this.f314d = new LinkedList();
            this.f312b = request;
            this.f314d.add(c0332c);
        }

        public void m342a(C0332c c0332c) {
            this.f314d.add(c0332c);
        }

        public boolean m343b(C0332c c0332c) {
            this.f314d.remove(c0332c);
            if (this.f314d.size() != 0) {
                return false;
            }
            this.f312b.m231g();
            return true;
        }
    }

    /* renamed from: com.android.volley.toolbox.g.b */
    public interface C0331b {
        Bitmap m344a(String str);

        void m345a(String str, Bitmap bitmap);
    }

    /* renamed from: com.android.volley.toolbox.g.c */
    public class C0332c {
        final /* synthetic */ C0333g f315a;
        private Bitmap f316b;
        private final C0312d f317c;
        private final String f318d;
        private final String f319e;

        public C0332c(C0333g c0333g, Bitmap bitmap, String str, String str2, C0312d c0312d) {
            this.f315a = c0333g;
            this.f316b = bitmap;
            this.f319e = str;
            this.f318d = str2;
            this.f317c = c0312d;
        }

        public void m348a() {
            if (this.f317c != null) {
                C0330a c0330a = (C0330a) this.f315a.f323d.get(this.f318d);
                if (c0330a == null) {
                    c0330a = (C0330a) this.f315a.f324e.get(this.f318d);
                    if (c0330a != null) {
                        c0330a.m343b(this);
                        if (c0330a.f314d.size() == 0) {
                            this.f315a.f324e.remove(this.f318d);
                        }
                    }
                } else if (c0330a.m343b(this)) {
                    this.f315a.f323d.remove(this.f318d);
                }
            }
        }

        public Bitmap m349b() {
            return this.f316b;
        }

        public String m350c() {
            return this.f319e;
        }
    }

    public C0332c m361a(String str, C0312d c0312d) {
        return m362a(str, c0312d, 0, 0);
    }

    public C0332c m362a(String str, C0312d c0312d, int i, int i2) {
        m354a();
        String a = C0333g.m352a(str, i, i2);
        Bitmap a2 = this.f322c.m344a(a);
        if (a2 != null) {
            C0332c c0332c = new C0332c(this, a2, str, null, null);
            c0312d.m292a(c0332c, true);
            return c0332c;
        }
        c0332c = new C0332c(this, null, str, a, c0312d);
        c0312d.m292a(c0332c, true);
        C0330a c0330a = (C0330a) this.f323d.get(a);
        if (c0330a != null) {
            c0330a.m342a(c0332c);
            return c0332c;
        }
        Request c0334h = new C0334h(str, new C03271(this, a), i, i2, Config.RGB_565, new C03282(this, a));
        this.f320a.m272a(c0334h);
        this.f323d.put(a, new C0330a(this, c0334h, c0332c));
        return c0332c;
    }

    private void m357a(String str, Bitmap bitmap) {
        this.f322c.m345a(str, bitmap);
        C0330a c0330a = (C0330a) this.f323d.remove(str);
        if (c0330a != null) {
            c0330a.f313c = bitmap;
            m359a(str, c0330a, null);
        }
    }

    private void m358a(String str, VolleyError volleyError) {
        C0330a c0330a = (C0330a) this.f323d.remove(str);
        if (c0330a != null) {
            m359a(str, c0330a, volleyError);
        }
    }

    private void m359a(String str, C0330a c0330a, VolleyError volleyError) {
        this.f324e.put(str, c0330a);
        if (this.f326g == null) {
            this.f326g = new C03293(this, volleyError);
            this.f325f.postDelayed(this.f326g, (long) this.f321b);
        }
    }

    private void m354a() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ImageLoader must be invoked from the main thread.");
        }
    }

    private static String m352a(String str, int i, int i2) {
        return new StringBuilder(str.length() + 12).append("#W").append(i).append("#H").append(i2).append(str).toString();
    }
}
