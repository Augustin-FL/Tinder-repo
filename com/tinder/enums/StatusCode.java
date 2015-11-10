package com.tinder.enums;

import org.apache.http.HttpStatus;

public enum StatusCode {
    OK(HttpStatus.SC_OK),
    BAD_REQUEST(HttpStatus.SC_BAD_REQUEST),
    UNAUTHORIZED(HttpStatus.SC_UNAUTHORIZED),
    NOT_FOUND(HttpStatus.SC_NOT_FOUND),
    ERROR(HttpStatus.SC_INTERNAL_SERVER_ERROR);
    
    private final int mCode;

    private StatusCode(int i) {
        this.mCode = i;
    }

    public int getCode() {
        return this.mCode;
    }
}
