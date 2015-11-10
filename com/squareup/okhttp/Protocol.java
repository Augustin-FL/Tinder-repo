package com.squareup.okhttp;

import java.io.IOException;

public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");
    
    private final String f3037e;

    private Protocol(String str) {
        this.f3037e = str;
    }

    public static Protocol m4866a(String str) throws IOException {
        if (str.equals(HTTP_1_0.f3037e)) {
            return HTTP_1_0;
        }
        if (str.equals(HTTP_1_1.f3037e)) {
            return HTTP_1_1;
        }
        if (str.equals(HTTP_2.f3037e)) {
            return HTTP_2;
        }
        if (str.equals(SPDY_3.f3037e)) {
            return SPDY_3;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    public String toString() {
        return this.f3037e;
    }
}
