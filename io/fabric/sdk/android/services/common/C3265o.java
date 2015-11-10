package io.fabric.sdk.android.services.common;

import org.apache.http.HttpStatus;

/* renamed from: io.fabric.sdk.android.services.common.o */
public class C3265o {
    public static int m9974a(int i) {
        if (i >= HttpStatus.SC_OK && i <= 299) {
            return 0;
        }
        if (i >= HttpStatus.SC_MULTIPLE_CHOICES && i <= 399) {
            return 1;
        }
        if (i >= HttpStatus.SC_BAD_REQUEST && i <= 499) {
            return 0;
        }
        if (i >= HttpStatus.SC_INTERNAL_SERVER_ERROR) {
            return 1;
        }
        return 1;
    }
}
