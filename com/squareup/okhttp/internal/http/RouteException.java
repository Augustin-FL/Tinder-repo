package com.squareup.okhttp.internal.http;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class RouteException extends Exception {
    private static final Method f3221a;
    private IOException f3222b;

    static {
        Method declaredMethod;
        try {
            declaredMethod = Throwable.class.getDeclaredMethod("addSuppressed", new Class[]{Throwable.class});
        } catch (Exception e) {
            declaredMethod = null;
        }
        f3221a = declaredMethod;
    }

    public RouteException(IOException iOException) {
        super(iOException);
        this.f3222b = iOException;
    }

    public IOException m5136a() {
        return this.f3222b;
    }

    public void m5137a(IOException iOException) {
        m5135a(iOException, this.f3222b);
        this.f3222b = iOException;
    }

    private void m5135a(IOException iOException, IOException iOException2) {
        if (f3221a != null) {
            try {
                f3221a.invoke(iOException, new Object[]{iOException2});
            } catch (InvocationTargetException e) {
            } catch (IllegalAccessException e2) {
            }
        }
    }
}
