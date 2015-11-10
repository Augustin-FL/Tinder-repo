package eu.janmuller.android.simplecropimage;

import android.graphics.BitmapFactory.Options;
import java.util.Iterator;
import java.util.WeakHashMap;
import org.apache.http.HttpHeaders;

public class BitmapManager {
    private static BitmapManager f6788b;
    private final WeakHashMap<Thread, C3172b> f6789a;

    private enum State {
        CANCEL,
        ALLOW
    }

    /* renamed from: eu.janmuller.android.simplecropimage.BitmapManager.a */
    public static class C3171a implements Iterable<Thread> {
        private final WeakHashMap<Thread, Object> f6785a;

        public C3171a() {
            this.f6785a = new WeakHashMap();
        }

        public Iterator<Thread> iterator() {
            return this.f6785a.keySet().iterator();
        }
    }

    /* renamed from: eu.janmuller.android.simplecropimage.BitmapManager.b */
    private static class C3172b {
        public State f6786a;
        public Options f6787b;

        private C3172b() {
            this.f6786a = State.ALLOW;
        }

        public String toString() {
            String str;
            if (this.f6786a == State.CANCEL) {
                str = "Cancel";
            } else if (this.f6786a == State.ALLOW) {
                str = HttpHeaders.ALLOW;
            } else {
                str = "?";
            }
            return "thread state = " + str + ", options = " + this.f6787b;
        }
    }

    static {
        f6788b = null;
    }

    private BitmapManager() {
        this.f6789a = new WeakHashMap();
    }

    private synchronized C3172b m9536b(Thread thread) {
        C3172b c3172b;
        c3172b = (C3172b) this.f6789a.get(thread);
        if (c3172b == null) {
            c3172b = new C3172b();
            this.f6789a.put(thread, c3172b);
        }
        return c3172b;
    }

    public synchronized void m9537a(C3171a c3171a) {
        Iterator it = c3171a.iterator();
        while (it.hasNext()) {
            m9538a((Thread) it.next());
        }
    }

    public synchronized void m9538a(Thread thread) {
        C3172b b = m9536b(thread);
        b.f6786a = State.CANCEL;
        if (b.f6787b != null) {
            b.f6787b.requestCancelDecode();
        }
        notifyAll();
    }

    public static synchronized BitmapManager m9535a() {
        BitmapManager bitmapManager;
        synchronized (BitmapManager.class) {
            if (f6788b == null) {
                f6788b = new BitmapManager();
            }
            bitmapManager = f6788b;
        }
        return bitmapManager;
    }
}
