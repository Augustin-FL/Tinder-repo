package com.squareup.okhttp.internal.spdy;

public enum HeadersMode {
    SPDY_SYN_STREAM,
    SPDY_REPLY,
    SPDY_HEADERS,
    HTTP_20_HEADERS;

    public boolean m5367a() {
        return this == SPDY_REPLY || this == SPDY_HEADERS;
    }

    public boolean m5368b() {
        return this == SPDY_SYN_STREAM;
    }

    public boolean m5369c() {
        return this == SPDY_HEADERS;
    }

    public boolean m5370d() {
        return this == SPDY_REPLY;
    }
}
