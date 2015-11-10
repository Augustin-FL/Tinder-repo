package com.tinder.utils;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ad<E extends Comparable<? super E>> {
    private final boolean f6526a;
    @NonNull
    private HashSet<E> f6527b;
    @NonNull
    private ArrayList<E> f6528c;
    @NonNull
    private Comparator<E> f6529d;

    /* renamed from: com.tinder.utils.ad.1 */
    class C30471 implements Comparator<E> {
        final /* synthetic */ ad f6525a;

        C30471(ad adVar) {
            this.f6525a = adVar;
        }

        public /* synthetic */ int compare(@NonNull Object obj, @NonNull Object obj2) {
            return m9212a((Comparable) obj, (Comparable) obj2);
        }

        public int m9212a(@NonNull E e, @NonNull E e2) {
            return e2.compareTo(e);
        }
    }

    public ad(boolean z) {
        this.f6527b = new HashSet();
        this.f6528c = new ArrayList();
        this.f6529d = new C30471(this);
        this.f6526a = z;
    }

    public boolean m9216a(E e) {
        if (this.f6527b.contains(e)) {
            return false;
        }
        this.f6527b.add(e);
        int d = m9213d(e);
        if (d < 0) {
            this.f6528c.add((-d) - 1, e);
            return true;
        } else if (m9215a(d).equals(e)) {
            return false;
        } else {
            this.f6528c.add(d, e);
            return false;
        }
    }

    private int m9213d(E e) {
        if (this.f6526a) {
            return Collections.binarySearch(this.f6528c, e);
        }
        return Collections.binarySearch(this.f6528c, e, this.f6529d);
    }

    public boolean m9219b(E e) {
        return this.f6527b.contains(e);
    }

    public int m9214a() {
        return this.f6528c.size();
    }

    public E m9215a(int i) {
        return (Comparable) this.f6528c.get(i);
    }

    public E m9217b(int i) {
        Comparable comparable = (Comparable) this.f6528c.remove(i);
        if (comparable != null) {
            this.f6527b.remove(comparable);
        }
        return comparable;
    }

    public boolean m9221c(E e) {
        this.f6527b.remove(e);
        return this.f6528c.remove(e);
    }

    public void m9218b() {
        this.f6528c.clear();
        this.f6527b.clear();
    }

    @NonNull
    public List<E> m9220c() {
        return Collections.unmodifiableList(this.f6528c);
    }

    @NonNull
    public ArrayList<E> m9222d() {
        return new ArrayList(this.f6528c);
    }
}
