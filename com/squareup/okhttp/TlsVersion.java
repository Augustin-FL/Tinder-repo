package com.squareup.okhttp;

import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public enum TlsVersion {
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0("SSLv3");
    
    final String f3043e;

    private TlsVersion(String str) {
        this.f3043e = str;
    }

    public static TlsVersion m4867a(String str) {
        Object obj = -1;
        switch (str.hashCode()) {
            case -503070503:
                if (str.equals("TLSv1.1")) {
                    obj = 1;
                    break;
                }
                break;
            case -503070502:
                if (str.equals("TLSv1.2")) {
                    obj = null;
                    break;
                }
                break;
            case 79201641:
                if (str.equals("SSLv3")) {
                    obj = 3;
                    break;
                }
                break;
            case 79923350:
                if (str.equals("TLSv1")) {
                    obj = 2;
                    break;
                }
                break;
        }
        switch (obj) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                return TLS_1_2;
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                return TLS_1_1;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                return TLS_1_0;
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                return SSL_3_0;
            default:
                throw new IllegalArgumentException("Unexpected TLS version: " + str);
        }
    }
}
