package com.google.android.gms.tagmanager;

import android.content.Context;
import java.net.URLEncoder;
import org.apache.http.protocol.HTTP;

class zzz implements zzar {
    private static final Object zzaOF;
    private static zzz zzaPU;
    private String zzaPV;
    private String zzaPW;
    private zzas zzaPX;
    private zzcd zzaPi;

    static {
        zzaOF = new Object();
    }

    private zzz(Context context) {
        this(zzat.zzaO(context), new zzcs());
    }

    zzz(zzas com_google_android_gms_tagmanager_zzas, zzcd com_google_android_gms_tagmanager_zzcd) {
        this.zzaPX = com_google_android_gms_tagmanager_zzas;
        this.zzaPi = com_google_android_gms_tagmanager_zzcd;
    }

    public static zzar zzaM(Context context) {
        zzar com_google_android_gms_tagmanager_zzar;
        synchronized (zzaOF) {
            if (zzaPU == null) {
                zzaPU = new zzz(context);
            }
            com_google_android_gms_tagmanager_zzar = zzaPU;
        }
        return com_google_android_gms_tagmanager_zzar;
    }

    public boolean zzeH(String str) {
        if (this.zzaPi.zzkp()) {
            if (!(this.zzaPV == null || this.zzaPW == null)) {
                try {
                    str = this.zzaPV + "?" + this.zzaPW + "=" + URLEncoder.encode(str, HTTP.UTF_8);
                    zzbg.m1005v("Sending wrapped url hit: " + str);
                } catch (Throwable e) {
                    zzbg.zzd("Error wrapping URL for testing.", e);
                    return false;
                }
            }
            this.zzaPX.zzeL(str);
            return true;
        }
        zzbg.zzaE("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
        return false;
    }
}
