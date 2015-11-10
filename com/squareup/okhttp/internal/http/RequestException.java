package com.squareup.okhttp.internal.http;

import java.io.IOException;

public final class RequestException extends Exception {
    public /* synthetic */ Throwable getCause() {
        return m5134a();
    }

    public RequestException(IOException iOException) {
        super(iOException);
    }

    public IOException m5134a() {
        return (IOException) super.getCause();
    }
}
