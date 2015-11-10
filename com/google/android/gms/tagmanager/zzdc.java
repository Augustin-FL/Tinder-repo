package com.google.android.gms.tagmanager;

import android.content.Context;
import com.facebook.stetho.BuildConfig;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class zzdc {
    private Context mContext;
    private Tracker zzKq;
    private GoogleAnalytics zzKs;

    static class zza implements Logger {
        zza() {
        }

        private static int zzjl(int i) {
            switch (i) {
                case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                    return 0;
                case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                    return 1;
                case C3374b.SmoothProgressBar_spb_speed /*5*/:
                    return 2;
                default:
                    return 3;
            }
        }

        public void error(Exception exception) {
            zzbg.zzb(BuildConfig.FLAVOR, exception);
        }

        public void error(String str) {
            zzbg.m1004e(str);
        }

        public int getLogLevel() {
            return zzjl(zzbg.getLogLevel());
        }

        public void info(String str) {
            zzbg.zzaD(str);
        }

        public void setLogLevel(int i) {
            zzbg.zzaE("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
        }

        public void verbose(String str) {
            zzbg.m1005v(str);
        }

        public void warn(String str) {
            zzbg.zzaE(str);
        }
    }

    public zzdc(Context context) {
        this.mContext = context;
    }

    private synchronized void zzeW(String str) {
        if (this.zzKs == null) {
            this.zzKs = GoogleAnalytics.getInstance(this.mContext);
            this.zzKs.setLogger(new zza());
            this.zzKq = this.zzKs.newTracker(str);
        }
    }

    public Tracker zzeV(String str) {
        zzeW(str);
        return this.zzKq;
    }
}
