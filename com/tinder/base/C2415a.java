package com.tinder.base;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import com.tinder.utils.C3095y;
import java.util.LinkedList;
import java.util.Queue;

/* renamed from: com.tinder.base.a */
public class C2415a extends Fragment {
    private boolean f4314a;
    @NonNull
    private Queue<Runnable> f4315b;

    public C2415a() {
        this.f4314a = false;
        this.f4315b = new LinkedList();
        C3095y.m9471a("FragmentBase created as " + getClass().toString());
    }

    public void onResume() {
        super.onResume();
        this.f4314a = true;
        while (this.f4315b.size() > 0) {
            ((Runnable) this.f4315b.poll()).run();
        }
    }

    public void onPause() {
        super.onPause();
        this.f4314a = false;
    }

    protected void m6603a(@NonNull Runnable runnable) {
        if (this.f4314a) {
            runnable.run();
        } else {
            this.f4315b.add(runnable);
        }
    }
}
