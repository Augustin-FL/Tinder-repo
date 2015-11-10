package com.android.volley;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.android.volley.C0290a.C0289a;
import com.android.volley.C0307i.C0305a;
import com.android.volley.C0310l.C0309a;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.protocol.HTTP;

public abstract class Request<T> implements Comparable<Request<T>> {
    private final C0309a f199a;
    private final int f200b;
    private final String f201c;
    private final int f202d;
    private final C0305a f203e;
    private Integer f204f;
    private C0304h f205g;
    private boolean f206h;
    private boolean f207i;
    private boolean f208j;
    private long f209k;
    private C0293k f210l;
    private C0289a f211m;
    private Object f212n;

    /* renamed from: com.android.volley.Request.1 */
    class C02881 implements Runnable {
        final /* synthetic */ String f191a;
        final /* synthetic */ long f192b;
        final /* synthetic */ Request f193c;

        C02881(Request request, String str, long j) {
            this.f193c = request;
            this.f191a = str;
            this.f192b = j;
        }

        public void run() {
            this.f193c.f199a.m285a(this.f191a, this.f192b);
            this.f193c.f199a.m284a(toString());
        }
    }

    public enum Priority {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    protected abstract C0307i<T> m215a(C0301g c0301g);

    protected abstract void m225b(T t);

    public /* synthetic */ int compareTo(Object obj) {
        return m213a((Request) obj);
    }

    public Request(int i, String str, C0305a c0305a) {
        C0309a c0309a;
        if (C0309a.f266a) {
            c0309a = new C0309a();
        } else {
            c0309a = null;
        }
        this.f199a = c0309a;
        this.f206h = true;
        this.f207i = false;
        this.f208j = false;
        this.f209k = 0;
        this.f211m = null;
        this.f200b = i;
        this.f201c = str;
        this.f203e = c0305a;
        m219a(new C0294c());
        if (TextUtils.isEmpty(str)) {
            this.f202d = 0;
            return;
        }
        Uri parse = Uri.parse(str);
        if (parse == null || parse.getHost() == null) {
            this.f202d = 0;
        } else {
            this.f202d = parse.getHost().hashCode();
        }
    }

    public int m212a() {
        return this.f200b;
    }

    public Object m223b() {
        return this.f212n;
    }

    public void m220a(Object obj) {
        this.f212n = obj;
    }

    public int m227c() {
        return this.f202d;
    }

    public void m221a(String str) {
        if (C0309a.f266a) {
            this.f199a.m285a(str, Thread.currentThread().getId());
        } else if (this.f209k == 0) {
            this.f209k = SystemClock.elapsedRealtime();
        }
    }

    void m226b(String str) {
        if (this.f205g != null) {
            this.f205g.m277b(this);
        }
        if (C0309a.f266a) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new C02881(this, str, id));
                return;
            }
            this.f199a.m285a(str, id);
            this.f199a.m284a(toString());
            return;
        }
        if (SystemClock.elapsedRealtime() - this.f209k >= 3000) {
            C0310l.m288b("%d ms: %s", Long.valueOf(SystemClock.elapsedRealtime() - this.f209k), toString());
        }
    }

    public void m218a(C0304h c0304h) {
        this.f205g = c0304h;
    }

    public final void m216a(int i) {
        this.f204f = Integer.valueOf(i);
    }

    public String m228d() {
        return this.f201c;
    }

    public String m229e() {
        return m228d();
    }

    public C0289a m230f() {
        return this.f211m;
    }

    public void m217a(C0289a c0289a) {
        this.f211m = c0289a;
    }

    public void m231g() {
        this.f207i = true;
    }

    public boolean m232h() {
        return this.f207i;
    }

    public Map<String, String> m233i() throws AuthFailureError {
        return Collections.emptyMap();
    }

    protected Map<String, String> m234j() throws AuthFailureError {
        return m238n();
    }

    protected String m235k() {
        return m239o();
    }

    public String m236l() {
        return m240p();
    }

    public byte[] m237m() throws AuthFailureError {
        Map j = m234j();
        if (j == null || j.size() <= 0) {
            return null;
        }
        return m210a(j, m235k());
    }

    protected Map<String, String> m238n() throws AuthFailureError {
        return null;
    }

    protected String m239o() {
        return HTTP.UTF_8;
    }

    public String m240p() {
        return "application/x-www-form-urlencoded; charset=" + m239o();
    }

    public byte[] m241q() throws AuthFailureError {
        Map n = m238n();
        if (n == null || n.size() <= 0) {
            return null;
        }
        return m210a(n, m239o());
    }

    private byte[] m210a(Map<String, String> map, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            for (Entry entry : map.entrySet()) {
                stringBuilder.append(URLEncoder.encode((String) entry.getKey(), str));
                stringBuilder.append('=');
                stringBuilder.append(URLEncoder.encode((String) entry.getValue(), str));
                stringBuilder.append('&');
            }
            return stringBuilder.toString().getBytes(str);
        } catch (Throwable e) {
            throw new RuntimeException("Encoding not supported: " + str, e);
        }
    }

    public final void m222a(boolean z) {
        this.f206h = z;
    }

    public final boolean m242r() {
        return this.f206h;
    }

    public Priority m243s() {
        return Priority.NORMAL;
    }

    public final int m244t() {
        return this.f210l.m255a();
    }

    public C0293k m245u() {
        return this.f210l;
    }

    public void m219a(C0293k c0293k) {
        this.f210l = c0293k;
    }

    public void m246v() {
        this.f208j = true;
    }

    public boolean m247w() {
        return this.f208j;
    }

    protected VolleyError m214a(VolleyError volleyError) {
        return volleyError;
    }

    public void m224b(VolleyError volleyError) {
        if (this.f203e != null) {
            this.f203e.onErrorResponse(volleyError);
        }
    }

    public int m213a(Request<T> request) {
        Priority s = m243s();
        Priority s2 = request.m243s();
        if (s == s2) {
            return this.f204f.intValue() - request.f204f.intValue();
        }
        return s2.ordinal() - s.ordinal();
    }

    public String toString() {
        return (this.f207i ? "[X] " : "[ ] ") + m228d() + " " + ("0x" + Integer.toHexString(m227c())) + " " + m243s() + " " + this.f204f;
    }
}
