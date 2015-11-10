package com.google.android.gms.analytics.internal;

import android.util.Log;
import com.google.android.gms.analytics.Logger;

class zzs implements Logger {
    private boolean zzKz;
    private int zzMQ;

    zzs() {
        this.zzMQ = 2;
    }

    public void error(Exception exception) {
    }

    public void error(String str) {
    }

    public int getLogLevel() {
        return this.zzMQ;
    }

    public void info(String str) {
    }

    public void setLogLevel(int i) {
        this.zzMQ = i;
        if (!this.zzKz) {
            Log.i((String) zzy.zzNa.get(), "Logger is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag." + ((String) zzy.zzNa.get()) + " DEBUG");
            this.zzKz = true;
        }
    }

    public void verbose(String str) {
    }

    public void warn(String str) {
    }
}
