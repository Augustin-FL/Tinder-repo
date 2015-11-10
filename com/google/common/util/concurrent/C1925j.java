package com.google.common.util.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* renamed from: com.google.common.util.concurrent.j */
public final class C1925j {
    public static <V> V m4485a(Future<V> future) throws ExecutionException {
        V v;
        Object obj = null;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException e) {
                obj = 1;
            } catch (Throwable th) {
                if (obj != null) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        if (obj != null) {
            Thread.currentThread().interrupt();
        }
        return v;
    }
}
