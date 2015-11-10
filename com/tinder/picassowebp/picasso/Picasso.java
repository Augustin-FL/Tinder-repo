package com.tinder.picassowebp.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.InputDeviceCompat;
import android.widget.ImageView;
import com.tinder.picassowebp.picasso.C2993a.C2992a;
import java.io.File;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class Picasso {
    static final Handler f6331a;
    static Picasso f6332b;
    final Context f6333c;
    final C3014i f6334d;
    final C3005d f6335e;
    final C3033v f6336f;
    final Map<Object, C2993a> f6337g;
    final Map<ImageView, C3009h> f6338h;
    final ReferenceQueue<Object> f6339i;
    boolean f6340j;
    volatile boolean f6341k;
    boolean f6342l;
    private final C2989c f6343m;
    private final C2990d f6344n;
    private final C2988b f6345o;

    /* renamed from: com.tinder.picassowebp.picasso.Picasso.1 */
    static class C29851 extends Handler {
        C29851(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                    C2993a c2993a = (C2993a) message.obj;
                    c2993a.f6347a.m8985a(c2993a.m9002d());
                case C3374b.SmoothProgressBar_spb_interpolator /*8*/:
                    List list = (List) message.obj;
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        C2983c c2983c = (C2983c) list.get(i);
                        c2983c.f6297a.m8994a(c2983c);
                    }
                default:
                    throw new AssertionError("Unknown handler message received: " + message.what);
            }
        }
    }

    public enum LoadedFrom {
        MEMORY(-16711936),
        DISK(InputDeviceCompat.SOURCE_ANY),
        NETWORK(SupportMenu.CATEGORY_MASK);
        
        final int f6317d;

        private LoadedFrom(int i) {
            this.f6317d = i;
        }
    }

    /* renamed from: com.tinder.picassowebp.picasso.Picasso.a */
    public static class C2986a {
        private final Context f6318a;
        private Downloader f6319b;
        private ExecutorService f6320c;
        private C3005d f6321d;
        private C2989c f6322e;
        private C2990d f6323f;
        private boolean f6324g;
        private boolean f6325h;

        public C2986a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.f6318a = context.getApplicationContext();
        }

        public C2986a m8977a(ExecutorService executorService) {
            if (executorService == null) {
                throw new IllegalArgumentException("Executor service must not be null.");
            } else if (this.f6320c != null) {
                throw new IllegalStateException("Executor service already set.");
            } else {
                this.f6320c = executorService;
                return this;
            }
        }

        public C2986a m8976a(C3005d c3005d) {
            if (c3005d == null) {
                throw new IllegalArgumentException("Memory cache must not be null.");
            } else if (this.f6321d != null) {
                throw new IllegalStateException("Memory cache already set.");
            } else {
                this.f6321d = c3005d;
                return this;
            }
        }

        public Picasso m8978a() {
            Context context = this.f6318a;
            if (this.f6319b == null) {
                this.f6319b = ab.m9018a(context);
            }
            if (this.f6321d == null) {
                this.f6321d = new C3018m(context);
            }
            if (this.f6320c == null) {
                this.f6320c = new C3023r();
            }
            if (this.f6323f == null) {
                this.f6323f = C2990d.f6330a;
            }
            C3033v c3033v = new C3033v(this.f6321d);
            C3014i c3014i = new C3014i(context, this.f6320c, Picasso.f6331a, this.f6319b, this.f6321d, c3033v);
            return new Picasso(context, c3014i, this.f6321d, this.f6322e, this.f6323f, c3033v, this.f6324g, this.f6325h);
        }
    }

    /* renamed from: com.tinder.picassowebp.picasso.Picasso.b */
    private static class C2988b extends Thread {
        private final ReferenceQueue<?> f6328a;
        private final Handler f6329b;

        /* renamed from: com.tinder.picassowebp.picasso.Picasso.b.1 */
        class C29871 implements Runnable {
            final /* synthetic */ Exception f6326a;
            final /* synthetic */ C2988b f6327b;

            C29871(C2988b c2988b, Exception exception) {
                this.f6327b = c2988b;
                this.f6326a = exception;
            }

            public void run() {
                throw new RuntimeException(this.f6326a);
            }
        }

        C2988b(ReferenceQueue<?> referenceQueue, Handler handler) {
            this.f6328a = referenceQueue;
            this.f6329b = handler;
            setDaemon(true);
            setName("Picasso-refQueue");
        }

        public void run() {
            Process.setThreadPriority(10);
            while (true) {
                try {
                    this.f6329b.sendMessage(this.f6329b.obtainMessage(3, ((C2992a) this.f6328a.remove()).f6346a));
                } catch (InterruptedException e) {
                    return;
                } catch (Exception e2) {
                    this.f6329b.post(new C29871(this, e2));
                    return;
                }
            }
        }
    }

    /* renamed from: com.tinder.picassowebp.picasso.Picasso.c */
    public interface C2989c {
        void m8979a(Picasso picasso, Uri uri, Exception exception);
    }

    /* renamed from: com.tinder.picassowebp.picasso.Picasso.d */
    public interface C2990d {
        public static final C2990d f6330a;

        /* renamed from: com.tinder.picassowebp.picasso.Picasso.d.1 */
        static class C29911 implements C2990d {
            C29911() {
            }

            public C3026s m8981a(C3026s c3026s) {
                return c3026s;
            }
        }

        C3026s m8980a(C3026s c3026s);

        static {
            f6330a = new C29911();
        }
    }

    static {
        f6331a = new C29851(Looper.getMainLooper());
        f6332b = null;
    }

    Picasso(Context context, C3014i c3014i, C3005d c3005d, C2989c c2989c, C2990d c2990d, C3033v c3033v, boolean z, boolean z2) {
        this.f6333c = context;
        this.f6334d = c3014i;
        this.f6335e = c3005d;
        this.f6343m = c2989c;
        this.f6344n = c2990d;
        this.f6336f = c3033v;
        this.f6337g = new WeakHashMap();
        this.f6338h = new WeakHashMap();
        this.f6340j = z;
        this.f6341k = z2;
        this.f6339i = new ReferenceQueue();
        this.f6345o = new C2988b(this.f6339i, f6331a);
        this.f6345o.start();
    }

    public static Picasso m8982a(Context context) {
        if (f6332b == null) {
            synchronized (Picasso.class) {
                if (f6332b == null) {
                    f6332b = new C2986a(context).m8978a();
                }
            }
        }
        return f6332b;
    }

    public void m8991a(ImageView imageView) {
        m8985a((Object) imageView);
    }

    public void m8995a(C2281x c2281x) {
        m8985a((Object) c2281x);
    }

    public C3029t m8988a(Uri uri) {
        return new C3029t(this, uri, 0);
    }

    public C3029t m8990a(String str) {
        if (str == null) {
            return new C3029t(this, null, 0);
        }
        if (str.trim().length() != 0) {
            return m8988a(Uri.parse(str));
        }
        throw new IllegalArgumentException("Path must not be empty.");
    }

    public C3029t m8989a(File file) {
        if (file == null) {
            return new C3029t(this, null, 0);
        }
        return m8988a(Uri.fromFile(file));
    }

    public C3029t m8987a(int i) {
        if (i != 0) {
            return new C3029t(this, null, i);
        }
        throw new IllegalArgumentException("Resource ID must not be zero.");
    }

    C3026s m8986a(C3026s c3026s) {
        C3026s a = this.f6344n.m8980a(c3026s);
        if (a != null) {
            return a;
        }
        throw new IllegalStateException("Request transformer " + this.f6344n.getClass().getCanonicalName() + " returned null for " + c3026s);
    }

    void m8992a(ImageView imageView, C3009h c3009h) {
        this.f6338h.put(imageView, c3009h);
    }

    void m8993a(C2993a c2993a) {
        Object d = c2993a.m9002d();
        if (d != null) {
            m8985a(d);
            this.f6337g.put(d, c2993a);
        }
        m8997b(c2993a);
    }

    void m8997b(C2993a c2993a) {
        this.f6334d.m9062a(c2993a);
    }

    Bitmap m8996b(String str) {
        Bitmap a = this.f6335e.m9041a(str);
        if (a != null) {
            this.f6336f.m9137a();
        } else {
            this.f6336f.m9141b();
        }
        return a;
    }

    void m8994a(C2983c c2983c) {
        Object obj = 1;
        C2993a j = c2983c.m8966j();
        List l = c2983c.m8968l();
        Object obj2 = (l == null || l.isEmpty()) ? null : 1;
        if (j == null && obj2 == null) {
            obj = null;
        }
        if (obj != null) {
            Uri uri = c2983c.m8965i().f6427a;
            Exception m = c2983c.m8969m();
            Bitmap g = c2983c.m8963g();
            LoadedFrom a = c2983c.m8953a();
            if (j != null) {
                m8983a(g, a, j);
            }
            if (obj2 != null) {
                int size = l.size();
                for (int i = 0; i < size; i++) {
                    m8983a(g, a, (C2993a) l.get(i));
                }
            }
            if (this.f6343m != null && m != null) {
                this.f6343m.m8979a(this, uri, m);
            }
        }
    }

    private void m8983a(Bitmap bitmap, LoadedFrom loadedFrom, C2993a c2993a) {
        if (!c2993a.m9004f()) {
            if (!c2993a.m9005g()) {
                this.f6337g.remove(c2993a.m9002d());
            }
            if (bitmap == null) {
                c2993a.m8998a();
                if (this.f6341k) {
                    ab.m9026a("Main", "errored", c2993a.f6348b.m9109a());
                }
            } else if (loadedFrom == null) {
                throw new AssertionError("LoadedFrom cannot be null.");
            } else {
                c2993a.m8999a(bitmap, loadedFrom);
                if (this.f6341k) {
                    ab.m9027a("Main", "completed", c2993a.f6348b.m9109a(), "from " + loadedFrom);
                }
            }
        }
    }

    private void m8985a(Object obj) {
        ab.m9024a();
        C2993a c2993a = (C2993a) this.f6337g.remove(obj);
        if (c2993a != null) {
            c2993a.m9000b();
            this.f6334d.m9067b(c2993a);
        }
        if (obj instanceof ImageView) {
            C3009h c3009h = (C3009h) this.f6338h.remove((ImageView) obj);
            if (c3009h != null) {
                c3009h.m9053a();
            }
        }
    }
}
