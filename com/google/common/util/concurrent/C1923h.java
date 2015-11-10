package com.google.common.util.concurrent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.google.common.util.concurrent.h */
public final class C1923h {

    /* renamed from: com.google.common.util.concurrent.h.1 */
    static class C19211 implements Runnable {
        final /* synthetic */ BlockingQueue f2583a;
        final /* synthetic */ C1908e f2584b;

        C19211(BlockingQueue blockingQueue, C1908e c1908e) {
            this.f2583a = blockingQueue;
            this.f2584b = c1908e;
        }

        public void run() {
            this.f2583a.add(this.f2584b);
        }
    }

    /* renamed from: com.google.common.util.concurrent.h.a */
    private static class C1922a extends C1910a {
        private final Lock f2585a;
        private final Condition f2586b;
        private int f2587c;
        private boolean f2588d;

        private C1922a() {
            this.f2585a = new ReentrantLock();
            this.f2586b = this.f2585a.newCondition();
            this.f2587c = 0;
            this.f2588d = false;
        }

        public void execute(Runnable runnable) {
            m4477a();
            try {
                runnable.run();
            } finally {
                m4478b();
            }
        }

        public boolean isShutdown() {
            this.f2585a.lock();
            try {
                boolean z = this.f2588d;
                return z;
            } finally {
                this.f2585a.unlock();
            }
        }

        public void shutdown() {
            this.f2585a.lock();
            try {
                this.f2588d = true;
            } finally {
                this.f2585a.unlock();
            }
        }

        public List<Runnable> shutdownNow() {
            shutdown();
            return Collections.emptyList();
        }

        public boolean isTerminated() {
            this.f2585a.lock();
            try {
                boolean z = this.f2588d && this.f2587c == 0;
                this.f2585a.unlock();
                return z;
            } catch (Throwable th) {
                this.f2585a.unlock();
            }
        }

        public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
            long toNanos = timeUnit.toNanos(j);
            this.f2585a.lock();
            while (!isTerminated()) {
                if (toNanos <= 0) {
                    return false;
                }
                try {
                    toNanos = this.f2586b.awaitNanos(toNanos);
                } finally {
                    this.f2585a.unlock();
                }
            }
            this.f2585a.unlock();
            return true;
        }

        private void m4477a() {
            this.f2585a.lock();
            try {
                if (isShutdown()) {
                    throw new RejectedExecutionException("Executor already shutdown");
                }
                this.f2587c++;
            } finally {
                this.f2585a.unlock();
            }
        }

        private void m4478b() {
            this.f2585a.lock();
            try {
                this.f2587c--;
                if (isTerminated()) {
                    this.f2586b.signalAll();
                }
                this.f2585a.unlock();
            } catch (Throwable th) {
                this.f2585a.unlock();
            }
        }
    }

    public static C1909g m4480a() {
        return new C1922a();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> T m4481a(com.google.common.util.concurrent.C1909g r19, java.util.Collection<? extends java.util.concurrent.Callable<T>> r20, boolean r21, long r22) throws java.lang.InterruptedException, java.util.concurrent.ExecutionException, java.util.concurrent.TimeoutException {
        /*
        com.google.common.base.C1650g.m3080a(r19);
        r3 = r20.size();
        if (r3 <= 0) goto L_0x0073;
    L_0x0009:
        r2 = 1;
    L_0x000a:
        com.google.common.base.C1650g.m3085a(r2);
        r12 = com.google.common.collect.C1872p.m4317b(r3);
        r13 = com.google.common.collect.C1880w.m4352a();
        r4 = 0;
        if (r21 == 0) goto L_0x0075;
    L_0x0018:
        r6 = java.lang.System.nanoTime();	 Catch:{ all -> 0x0083 }
    L_0x001c:
        r14 = r20.iterator();	 Catch:{ all -> 0x0083 }
        r2 = r14.next();	 Catch:{ all -> 0x0083 }
        r2 = (java.util.concurrent.Callable) r2;	 Catch:{ all -> 0x0083 }
        r0 = r19;
        r2 = com.google.common.util.concurrent.C1923h.m4479a(r0, r2, r13);	 Catch:{ all -> 0x0083 }
        r12.add(r2);	 Catch:{ all -> 0x0083 }
        r3 = r3 + -1;
        r5 = 1;
        r10 = r22;
    L_0x0034:
        r2 = r13.poll();	 Catch:{ all -> 0x0083 }
        r2 = (java.util.concurrent.Future) r2;	 Catch:{ all -> 0x0083 }
        if (r2 != 0) goto L_0x00dc;
    L_0x003c:
        if (r3 <= 0) goto L_0x0078;
    L_0x003e:
        r8 = r3 + -1;
        r3 = r14.next();	 Catch:{ all -> 0x0083 }
        r3 = (java.util.concurrent.Callable) r3;	 Catch:{ all -> 0x0083 }
        r0 = r19;
        r3 = com.google.common.util.concurrent.C1923h.m4479a(r0, r3, r13);	 Catch:{ all -> 0x0083 }
        r12.add(r3);	 Catch:{ all -> 0x0083 }
        r3 = r5 + 1;
        r5 = r8;
        r8 = r10;
        r15 = r2;
        r2 = r3;
        r3 = r15;
    L_0x0056:
        if (r3 == 0) goto L_0x00da;
    L_0x0058:
        r2 = r2 + -1;
        r3 = r3.get();	 Catch:{ ExecutionException -> 0x00d7, RuntimeException -> 0x00ca }
        r4 = r12.iterator();
    L_0x0062:
        r2 = r4.hasNext();
        if (r2 == 0) goto L_0x00d9;
    L_0x0068:
        r2 = r4.next();
        r2 = (java.util.concurrent.Future) r2;
        r5 = 1;
        r2.cancel(r5);
        goto L_0x0062;
    L_0x0073:
        r2 = 0;
        goto L_0x000a;
    L_0x0075:
        r6 = 0;
        goto L_0x001c;
    L_0x0078:
        if (r5 != 0) goto L_0x009a;
    L_0x007a:
        if (r4 != 0) goto L_0x0082;
    L_0x007c:
        r4 = new java.util.concurrent.ExecutionException;	 Catch:{ all -> 0x0083 }
        r2 = 0;
        r4.<init>(r2);	 Catch:{ all -> 0x0083 }
    L_0x0082:
        throw r4;	 Catch:{ all -> 0x0083 }
    L_0x0083:
        r2 = move-exception;
        r3 = r2;
        r4 = r12.iterator();
    L_0x0089:
        r2 = r4.hasNext();
        if (r2 == 0) goto L_0x00d6;
    L_0x008f:
        r2 = r4.next();
        r2 = (java.util.concurrent.Future) r2;
        r5 = 1;
        r2.cancel(r5);
        goto L_0x0089;
    L_0x009a:
        if (r21 == 0) goto L_0x00be;
    L_0x009c:
        r2 = java.util.concurrent.TimeUnit.NANOSECONDS;	 Catch:{ all -> 0x0083 }
        r2 = r13.poll(r10, r2);	 Catch:{ all -> 0x0083 }
        r2 = (java.util.concurrent.Future) r2;	 Catch:{ all -> 0x0083 }
        if (r2 != 0) goto L_0x00ac;
    L_0x00a6:
        r2 = new java.util.concurrent.TimeoutException;	 Catch:{ all -> 0x0083 }
        r2.<init>();	 Catch:{ all -> 0x0083 }
        throw r2;	 Catch:{ all -> 0x0083 }
    L_0x00ac:
        r8 = java.lang.System.nanoTime();	 Catch:{ all -> 0x0083 }
        r6 = r8 - r6;
        r6 = r10 - r6;
        r15 = r2;
        r2 = r5;
        r5 = r3;
        r3 = r15;
        r16 = r8;
        r8 = r6;
        r6 = r16;
        goto L_0x0056;
    L_0x00be:
        r2 = r13.take();	 Catch:{ all -> 0x0083 }
        r2 = (java.util.concurrent.Future) r2;	 Catch:{ all -> 0x0083 }
        r8 = r10;
        r15 = r5;
        r5 = r3;
        r3 = r2;
        r2 = r15;
        goto L_0x0056;
    L_0x00ca:
        r4 = move-exception;
        r3 = new java.util.concurrent.ExecutionException;	 Catch:{ all -> 0x0083 }
        r3.<init>(r4);	 Catch:{ all -> 0x0083 }
    L_0x00d0:
        r4 = r3;
        r10 = r8;
        r3 = r5;
        r5 = r2;
        goto L_0x0034;
    L_0x00d6:
        throw r3;
    L_0x00d7:
        r3 = move-exception;
        goto L_0x00d0;
    L_0x00d9:
        return r3;
    L_0x00da:
        r3 = r4;
        goto L_0x00d0;
    L_0x00dc:
        r8 = r10;
        r15 = r5;
        r5 = r3;
        r3 = r2;
        r2 = r15;
        goto L_0x0056;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.h.a(com.google.common.util.concurrent.g, java.util.Collection, boolean, long):T");
    }

    private static <T> C1908e<T> m4479a(C1909g c1909g, Callable<T> callable, BlockingQueue<Future<T>> blockingQueue) {
        C1908e<T> a = c1909g.m4463a(callable);
        a.m4457a(new C19211(blockingQueue, a), C1923h.m4480a());
        return a;
    }
}
