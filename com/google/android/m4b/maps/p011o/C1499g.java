package com.google.android.m4b.maps.p011o;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.support.v7.widget.RecyclerView.SmoothScroller.Action;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.facebook.stetho.BuildConfig;
import com.google.android.m4b.maps.al.b;
import com.google.android.m4b.maps.bh.ai;
import com.google.android.m4b.maps.bh.ak;
import com.google.android.m4b.maps.bh.r;
import com.google.android.m4b.maps.bm.m;
import com.google.common.base.C1659k;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.m4b.maps.o.g */
public final class C1499g extends ExploreByTouchHelper {
    private final ai f1490a;
    private final b f1491b;
    private final b f1492c;
    private List<m> f1493d;

    public C1499g(View view, ai aiVar, b bVar) {
        super(view);
        this.f1490a = aiVar;
        this.f1491b = bVar;
        this.f1492c = new b(this.f1491b);
    }

    protected final int getVirtualViewAt(float f, float f2) {
        if (this.f1493d != null) {
            for (int i = 0; i < this.f1493d.size(); i++) {
                if (((m) this.f1493d.get(i)).c(this.f1492c).contains((int) f, (int) f2)) {
                    return i;
                }
            }
        }
        return Action.UNDEFINED_DURATION;
    }

    protected final void getVisibleVirtualViews(List<Integer> list) {
        this.f1492c.a(this.f1491b.f(), this.f1491b.g(), this.f1491b.h());
        this.f1492c.a(this.f1491b.b());
        this.f1493d = m2395b();
        if (this.f1493d != null) {
            int size = this.f1493d.size();
            for (int i = 0; i < size; i++) {
                list.add(Integer.valueOf(i));
            }
        }
    }

    protected final boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
        return false;
    }

    protected final void onPopulateEventForVirtualView(int i, AccessibilityEvent accessibilityEvent) {
        if (this.f1493d == null || i >= this.f1493d.size()) {
            this.f1493d = m2395b();
        }
        if (this.f1493d == null || i >= this.f1493d.size()) {
            accessibilityEvent.setContentDescription(BuildConfig.FLAVOR);
        } else {
            accessibilityEvent.setContentDescription(C1499g.m2394a((m) this.f1493d.get(i)));
        }
    }

    public final void m2396a() {
        invalidateRoot();
        if (this.f1493d != null) {
            for (int i = 0; i < this.f1493d.size(); i++) {
                invalidateVirtualView(i);
            }
        }
    }

    private static String m2394a(m mVar) {
        if (mVar == null) {
            return BuildConfig.FLAVOR;
        }
        String str = BuildConfig.FLAVOR;
        String m = mVar.m();
        String n = mVar.n();
        if (!C1659k.m3119b(m)) {
            str = m + ". ";
        }
        if (C1659k.m3119b(n)) {
            return str;
        }
        return str + n + ".";
    }

    protected final void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (this.f1493d == null || i >= this.f1493d.size()) {
            accessibilityNodeInfoCompat.setContentDescription(BuildConfig.FLAVOR);
            accessibilityNodeInfoCompat.setBoundsInParent(new Rect(-2, -2, -1, -1));
            return;
        }
        m mVar = (m) this.f1493d.get(i);
        accessibilityNodeInfoCompat.setContentDescription(C1499g.m2394a(mVar));
        accessibilityNodeInfoCompat.addAction(16);
        accessibilityNodeInfoCompat.setBoundsInParent(mVar.c(this.f1492c));
        accessibilityNodeInfoCompat.setFocusable(true);
    }

    private List<m> m2395b() {
        ArrayList b = this.f1490a.b();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            r rVar = (r) b.get(i);
            if (rVar instanceof ak) {
                return new ArrayList(((ak) rVar).j());
            }
        }
        return null;
    }
}
