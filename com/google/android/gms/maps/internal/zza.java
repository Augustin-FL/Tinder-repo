package com.google.android.gms.maps.internal;

import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public final class zza {
    public static Boolean zza(byte b) {
        switch (b) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
                return Boolean.FALSE;
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                return Boolean.TRUE;
            default:
                return null;
        }
    }

    public static byte zze(Boolean bool) {
        return bool != null ? bool.booleanValue() ? (byte) 1 : (byte) 0 : (byte) -1;
    }
}
