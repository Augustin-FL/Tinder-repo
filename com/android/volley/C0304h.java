package com.android.volley;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.android.volley.h */
public class C0304h {
    private final Map<String, Queue<Request>> f249a;
    private final Set<Request> f250b;
    private final PriorityBlockingQueue<Request> f251c;
    private final PriorityBlockingQueue<Request> f252d;
    private final C0290a f253e;
    private final C0299e f254f;
    private final C0297j f255g;
    private AtomicInteger f256h;
    private C0300f[] f257i;
    private C0292b f258j;

    /* renamed from: com.android.volley.h.a */
    public interface C0302a {
        boolean m270a(Request<?> request);
    }

    /* renamed from: com.android.volley.h.1 */
    class C03031 implements C0302a {
        final /* synthetic */ Object f247a;
        final /* synthetic */ C0304h f248b;

        C03031(C0304h c0304h, Object obj) {
            this.f248b = c0304h;
            this.f247a = obj;
        }

        public boolean m271a(Request<?> request) {
            return request.m223b() == this.f247a;
        }
    }

    public C0304h(C0290a c0290a, C0299e c0299e, int i, C0297j c0297j) {
        this.f249a = new HashMap();
        this.f250b = new HashSet();
        this.f251c = new PriorityBlockingQueue();
        this.f252d = new PriorityBlockingQueue();
        this.f256h = new AtomicInteger();
        this.f253e = c0290a;
        this.f254f = c0299e;
        this.f257i = new C0300f[i];
        this.f255g = c0297j;
    }

    public C0304h(C0290a c0290a, C0299e c0299e, int i) {
        this(c0290a, c0299e, i, new C0298d(new Handler(Looper.getMainLooper())));
    }

    public C0304h(C0290a c0290a, C0299e c0299e) {
        this(c0290a, c0299e, 4);
    }

    public void m273a() {
        m276b();
        this.f258j = new C0292b(this.f251c, this.f252d, this.f253e, this.f255g);
        this.f258j.start();
        for (int i = 0; i < this.f257i.length; i++) {
            C0300f c0300f = new C0300f(this.f252d, this.f254f, this.f253e, this.f255g);
            this.f257i[i] = c0300f;
            c0300f.start();
        }
    }

    public void m276b() {
        if (this.f258j != null) {
            this.f258j.m254a();
        }
        for (int i = 0; i < this.f257i.length; i++) {
            if (this.f257i[i] != null) {
                this.f257i[i].m269a();
            }
        }
    }

    public int m278c() {
        return this.f256h.incrementAndGet();
    }

    public void m274a(C0302a c0302a) {
        synchronized (this.f250b) {
            for (Request request : this.f250b) {
                if (c0302a.m270a(request)) {
                    request.m231g();
                }
            }
        }
    }

    public void m275a(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Cannot cancelAll with a null tag");
        }
        m274a(new C03031(this, obj));
    }

    public Request m272a(Request request) {
        request.m218a(this);
        synchronized (this.f250b) {
            this.f250b.add(request);
        }
        request.m216a(m278c());
        request.m221a("add-to-queue");
        if (request.m242r()) {
            synchronized (this.f249a) {
                String e = request.m229e();
                if (this.f249a.containsKey(e)) {
                    Queue queue = (Queue) this.f249a.get(e);
                    if (queue == null) {
                        queue = new LinkedList();
                    }
                    queue.add(request);
                    this.f249a.put(e, queue);
                    if (C0310l.f270b) {
                        C0310l.m286a("Request for cacheKey=%s is in flight, putting on hold.", e);
                    }
                } else {
                    this.f249a.put(e, null);
                    this.f251c.add(request);
                }
            }
        } else {
            this.f252d.add(request);
        }
        return request;
    }

    void m277b(Request request) {
        synchronized (this.f250b) {
            this.f250b.remove(request);
        }
        if (request.m242r()) {
            synchronized (this.f249a) {
                Queue queue = (Queue) this.f249a.remove(request.m229e());
                if (queue != null) {
                    if (C0310l.f270b) {
                        C0310l.m286a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(queue.size()), r2);
                    }
                    this.f251c.addAll(queue);
                }
            }
        }
    }
}
