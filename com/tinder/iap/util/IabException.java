package com.tinder.iap.util;

import android.support.annotation.NonNull;

public class IabException extends Exception {
    C2766c f5512a;

    public IabException(@NonNull C2766c c2766c) {
        this(c2766c, null);
    }

    public IabException(int i, String str) {
        this(new C2766c(i, str));
    }

    public IabException(@NonNull C2766c c2766c, Exception exception) {
        super(c2766c.m7869a(), exception);
        this.f5512a = c2766c;
    }

    public IabException(int i, String str, Exception exception) {
        this(new C2766c(i, str), exception);
    }

    public C2766c m7836a() {
        return this.f5512a;
    }
}
