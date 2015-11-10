package com.google.android.gms.ads;

import android.content.Context;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzk;
import org.apache.http.HttpStatus;

public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final AdSize BANNER;
    public static final AdSize FULL_BANNER;
    public static final int FULL_WIDTH = -1;
    public static final AdSize LARGE_BANNER;
    public static final AdSize LEADERBOARD;
    public static final AdSize MEDIUM_RECTANGLE;
    public static final AdSize SMART_BANNER;
    public static final AdSize WIDE_SKYSCRAPER;
    private final int zznP;
    private final int zznQ;
    private final String zznR;

    static {
        BANNER = new AdSize(320, 50, "320x50_mb");
        FULL_BANNER = new AdSize(468, 60, "468x60_as");
        LARGE_BANNER = new AdSize(320, 100, "320x100_as");
        LEADERBOARD = new AdSize(728, 90, "728x90_as");
        MEDIUM_RECTANGLE = new AdSize(HttpStatus.SC_MULTIPLE_CHOICES, Callback.DEFAULT_SWIPE_ANIMATION_DURATION, "300x250_as");
        WIDE_SKYSCRAPER = new AdSize(160, 600, "160x600_as");
        SMART_BANNER = new AdSize(FULL_WIDTH, AUTO_HEIGHT, "smart_banner");
    }

    public AdSize(int i, int i2) {
        this(i, i2, (i == FULL_WIDTH ? "FULL" : String.valueOf(i)) + "x" + (i2 == AUTO_HEIGHT ? "AUTO" : String.valueOf(i2)) + "_as");
    }

    AdSize(int i, int i2, String str) {
        if (i < 0 && i != FULL_WIDTH) {
            throw new IllegalArgumentException("Invalid width for AdSize: " + i);
        } else if (i2 >= 0 || i2 == AUTO_HEIGHT) {
            this.zznP = i;
            this.zznQ = i2;
            this.zznR = str;
        } else {
            throw new IllegalArgumentException("Invalid height for AdSize: " + i2);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) obj;
        return this.zznP == adSize.zznP && this.zznQ == adSize.zznQ && this.zznR.equals(adSize.zznR);
    }

    public int getHeight() {
        return this.zznQ;
    }

    public int getHeightInPixels(Context context) {
        return this.zznQ == AUTO_HEIGHT ? AdSizeParcel.zzb(context.getResources().getDisplayMetrics()) : zzk.zzcE().zzb(context, this.zznQ);
    }

    public int getWidth() {
        return this.zznP;
    }

    public int getWidthInPixels(Context context) {
        return this.zznP == FULL_WIDTH ? AdSizeParcel.zza(context.getResources().getDisplayMetrics()) : zzk.zzcE().zzb(context, this.zznP);
    }

    public int hashCode() {
        return this.zznR.hashCode();
    }

    public boolean isAutoHeight() {
        return this.zznQ == AUTO_HEIGHT;
    }

    public boolean isFullWidth() {
        return this.zznP == FULL_WIDTH;
    }

    public String toString() {
        return this.zznR;
    }
}
