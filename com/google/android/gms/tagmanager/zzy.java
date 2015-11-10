package com.google.android.gms.tagmanager;

import android.util.Log;

public class zzy implements zzbh {
    private int zzMQ;

    public zzy() {
        this.zzMQ = 5;
    }

    public void m1008e(String str) {
        if (this.zzMQ <= 6) {
            Log.e("GoogleTagManager", str);
        }
    }

    public void setLogLevel(int i) {
        this.zzMQ = i;
    }

    public void m1009v(String str) {
        if (this.zzMQ <= 2) {
            Log.v("GoogleTagManager", str);
        }
    }

    public void zzaC(String str) {
        if (this.zzMQ <= 3) {
            Log.d("GoogleTagManager", str);
        }
    }

    public void zzaD(String str) {
        if (this.zzMQ <= 4) {
            Log.i("GoogleTagManager", str);
        }
    }

    public void zzaE(String str) {
        if (this.zzMQ <= 5) {
            Log.w("GoogleTagManager", str);
        }
    }

    public void zzb(String str, Throwable th) {
        if (this.zzMQ <= 6) {
            Log.e("GoogleTagManager", str, th);
        }
    }

    public void zzd(String str, Throwable th) {
        if (this.zzMQ <= 5) {
            Log.w("GoogleTagManager", str, th);
        }
    }
}
