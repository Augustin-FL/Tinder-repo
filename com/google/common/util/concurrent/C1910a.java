package com.google.common.util.concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.google.common.util.concurrent.a */
public abstract class C1910a implements C1909g {
    public /* synthetic */ Future submit(Runnable runnable) {
        return m4464a(runnable);
    }

    public /* synthetic */ Future submit(Runnable runnable, Object obj) {
        return m4465a(runnable, obj);
    }

    public /* synthetic */ Future submit(Callable callable) {
        return m4466a(callable);
    }

    public C1908e<?> m4464a(Runnable runnable) {
        Object a = C1920f.m4474a(runnable, null);
        execute(a);
        return a;
    }

    public <T> C1908e<T> m4465a(Runnable runnable, T t) {
        Object a = C1920f.m4474a(runnable, (Object) t);
        execute(a);
        return a;
    }

    public <T> C1908e<T> m4466a(Callable<T> callable) {
        Object a = C1920f.m4475a(callable);
        execute(a);
        return a;
    }

    public <T> T invokeAny(Collection<Callable<T>> collection) throws InterruptedException, ExecutionException {
        try {
            return C1923h.m4481a(this, collection, false, 0);
        } catch (TimeoutException e) {
            throw new AssertionError();
        }
    }

    public <T> T invokeAny(Collection<Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return C1923h.m4481a(this, collection, true, timeUnit.toNanos(j));
    }

    public <T> List<Future<T>> invokeAll(Collection<Callable<T>> collection) throws InterruptedException {
        if (collection == null) {
            throw new NullPointerException();
        }
        List<Future<T>> arrayList = new ArrayList(collection.size());
        try {
            for (Callable a : collection) {
                Runnable a2 = C1920f.m4475a(a);
                arrayList.add(a2);
                execute(a2);
            }
            for (Future future : arrayList) {
                if (!future.isDone()) {
                    try {
                        future.get();
                    } catch (CancellationException e) {
                    } catch (ExecutionException e2) {
                    }
                }
            }
            return arrayList;
        } catch (Throwable th) {
            Throwable th2 = th;
            for (Future future2 : arrayList) {
                future2.cancel(true);
            }
        }
    }

    public <T> List<Future<T>> invokeAll(Collection<Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
        if (collection == null || timeUnit == null) {
            throw new NullPointerException();
        }
        long toNanos = timeUnit.toNanos(j);
        List<Future<T>> arrayList = new ArrayList(collection.size());
        try {
            long nanoTime;
            for (Callable a : collection) {
                arrayList.add(C1920f.m4475a(a));
            }
            long nanoTime2 = System.nanoTime();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                execute((Runnable) it.next());
                nanoTime = System.nanoTime();
                toNanos -= nanoTime - nanoTime2;
                if (toNanos <= 0) {
                    for (Future cancel : arrayList) {
                        cancel.cancel(true);
                    }
                    return arrayList;
                }
                nanoTime2 = nanoTime;
            }
            for (Future cancel2 : arrayList) {
                if (cancel2.isDone()) {
                    nanoTime = nanoTime2;
                    nanoTime2 = toNanos;
                } else if (toNanos <= 0) {
                    for (Future cancel22 : arrayList) {
                        cancel22.cancel(true);
                    }
                    return arrayList;
                } else {
                    try {
                        cancel22.get(toNanos, TimeUnit.NANOSECONDS);
                    } catch (CancellationException e) {
                    } catch (ExecutionException e2) {
                    } catch (TimeoutException e3) {
                        for (Future cancel222 : arrayList) {
                            cancel222.cancel(true);
                        }
                        return arrayList;
                    }
                    nanoTime = System.nanoTime();
                    nanoTime2 = toNanos - (nanoTime - nanoTime2);
                }
                toNanos = nanoTime2;
                nanoTime2 = nanoTime;
            }
            return arrayList;
        } catch (Throwable th) {
            Throwable th2 = th;
            for (Future cancel2222 : arrayList) {
                cancel2222.cancel(true);
            }
        }
    }
}
