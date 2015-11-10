package io.fabric.sdk.android.services.concurrency;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class DependencyPriorityBlockingQueue<E extends C0410a & C0412i & C0411f> extends PriorityBlockingQueue<E> {
    final Queue<E> f7123a;
    private final ReentrantLock f7124b;

    public /* synthetic */ Object peek() {
        return m9986b();
    }

    public /* synthetic */ Object poll() {
        return m9988c();
    }

    public /* synthetic */ Object poll(long j, TimeUnit timeUnit) throws InterruptedException {
        return m9982a(j, timeUnit);
    }

    public /* synthetic */ Object take() throws InterruptedException {
        return m9980a();
    }

    public DependencyPriorityBlockingQueue() {
        this.f7123a = new LinkedList();
        this.f7124b = new ReentrantLock();
    }

    public E m9980a() throws InterruptedException {
        return m9987b(0, null, null);
    }

    public E m9986b() {
        E e = null;
        try {
            e = m9987b(1, null, null);
        } catch (InterruptedException e2) {
        }
        return e;
    }

    public E m9982a(long j, TimeUnit timeUnit) throws InterruptedException {
        return m9987b(3, Long.valueOf(j), timeUnit);
    }

    public E m9988c() {
        E e = null;
        try {
            e = m9987b(2, null, null);
        } catch (InterruptedException e2) {
        }
        return e;
    }

    public int size() {
        try {
            this.f7124b.lock();
            int size = this.f7123a.size() + super.size();
            return size;
        } finally {
            this.f7124b.unlock();
        }
    }

    public <T> T[] toArray(T[] tArr) {
        try {
            this.f7124b.lock();
            T[] a = m9985a(super.toArray(tArr), this.f7123a.toArray(tArr));
            return a;
        } finally {
            this.f7124b.unlock();
        }
    }

    public Object[] toArray() {
        try {
            this.f7124b.lock();
            Object[] a = m9985a(super.toArray(), this.f7123a.toArray());
            return a;
        } finally {
            this.f7124b.unlock();
        }
    }

    public int drainTo(Collection<? super E> collection) {
        try {
            this.f7124b.lock();
            int drainTo = super.drainTo(collection) + this.f7123a.size();
            while (!this.f7123a.isEmpty()) {
                collection.add(this.f7123a.poll());
            }
            return drainTo;
        } finally {
            this.f7124b.unlock();
        }
    }

    public int drainTo(Collection<? super E> collection, int i) {
        try {
            this.f7124b.lock();
            int drainTo = super.drainTo(collection, i);
            while (!this.f7123a.isEmpty() && drainTo <= i) {
                collection.add(this.f7123a.poll());
                drainTo++;
            }
            this.f7124b.unlock();
            return drainTo;
        } catch (Throwable th) {
            this.f7124b.unlock();
        }
    }

    public boolean contains(Object obj) {
        try {
            this.f7124b.lock();
            boolean z = super.contains(obj) || this.f7123a.contains(obj);
            this.f7124b.unlock();
            return z;
        } catch (Throwable th) {
            this.f7124b.unlock();
        }
    }

    public void clear() {
        try {
            this.f7124b.lock();
            this.f7123a.clear();
            super.clear();
        } finally {
            this.f7124b.unlock();
        }
    }

    public boolean remove(Object obj) {
        try {
            this.f7124b.lock();
            boolean z = super.remove(obj) || this.f7123a.remove(obj);
            this.f7124b.unlock();
            return z;
        } catch (Throwable th) {
            this.f7124b.unlock();
        }
    }

    public boolean removeAll(Collection<?> collection) {
        try {
            this.f7124b.lock();
            boolean removeAll = super.removeAll(collection) | this.f7123a.removeAll(collection);
            return removeAll;
        } finally {
            this.f7124b.unlock();
        }
    }

    E m9981a(int i, Long l, TimeUnit timeUnit) throws InterruptedException {
        switch (i) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                return (C0410a) super.take();
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                return (C0410a) super.peek();
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                return (C0410a) super.poll();
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                return (C0410a) super.poll(l.longValue(), timeUnit);
            default:
                return null;
        }
    }

    boolean m9983a(int i, E e) {
        try {
            this.f7124b.lock();
            if (i == 1) {
                super.remove(e);
            }
            boolean offer = this.f7123a.offer(e);
            return offer;
        } finally {
            this.f7124b.unlock();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    E m9987b(int r3, java.lang.Long r4, java.util.concurrent.TimeUnit r5) throws java.lang.InterruptedException {
        /*
        r2 = this;
    L_0x0000:
        r0 = r2.m9981a(r3, r4, r5);
        if (r0 == 0) goto L_0x000c;
    L_0x0006:
        r1 = r2.m9984a(r0);
        if (r1 == 0) goto L_0x000d;
    L_0x000c:
        return r0;
    L_0x000d:
        r2.m9983a(r3, r0);
        goto L_0x0000;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.concurrency.DependencyPriorityBlockingQueue.b(int, java.lang.Long, java.util.concurrent.TimeUnit):E");
    }

    boolean m9984a(E e) {
        return e.m633d();
    }

    public void m9989d() {
        try {
            this.f7124b.lock();
            Iterator it = this.f7123a.iterator();
            while (it.hasNext()) {
                C0410a c0410a = (C0410a) it.next();
                if (m9984a(c0410a)) {
                    super.offer(c0410a);
                    it.remove();
                }
            }
        } finally {
            this.f7124b.unlock();
        }
    }

    <T> T[] m9985a(T[] tArr, T[] tArr2) {
        int length = tArr.length;
        int length2 = tArr2.length;
        Object[] objArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), length + length2);
        System.arraycopy(tArr, 0, objArr, 0, length);
        System.arraycopy(tArr2, 0, objArr, length, length2);
        return objArr;
    }
}
