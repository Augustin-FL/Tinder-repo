package com.tinder.utils;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Pair;
import java.util.ArrayList;

/* renamed from: com.tinder.utils.h */
public class C3069h {
    @NonNull
    private ArrayList<Pair> f6610a;
    @NonNull
    private Handler f6611b;

    /* renamed from: com.tinder.utils.h.1 */
    class C30681 implements Runnable {
        final /* synthetic */ Pair f6608a;
        final /* synthetic */ C3069h f6609b;

        C30681(C3069h c3069h, Pair pair) {
            this.f6609b = c3069h;
            this.f6608a = pair;
        }

        public void run() {
            ((Runnable) this.f6608a.first).run();
            if (((Boolean) this.f6608a.second).booleanValue()) {
                this.f6609b.f6610a.remove(this.f6608a);
            }
        }
    }

    public C3069h() {
        this.f6610a = new ArrayList(3);
        this.f6611b = new Handler(Looper.getMainLooper());
    }

    public void m9357a(Runnable runnable, boolean z) {
        this.f6610a.add(new Pair(runnable, Boolean.valueOf(z)));
    }

    public void m9356a() {
        C3095y.m9471a(toString());
        for (int i = 0; i < this.f6610a.size(); i++) {
            this.f6611b.post(new C30681(this, (Pair) this.f6610a.get(i)));
        }
    }

    public int m9358b() {
        return this.f6610a.size();
    }

    public void m9359c() {
        this.f6610a.clear();
    }
}
