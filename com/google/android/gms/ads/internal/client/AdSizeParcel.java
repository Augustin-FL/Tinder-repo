package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.zza;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzgk;
import org.apache.http.HttpStatus;

@zzgk
public final class AdSizeParcel implements SafeParcelable {
    public static final zzh CREATOR;
    public final int height;
    public final int heightPixels;
    public final int versionCode;
    public final int width;
    public final int widthPixels;
    public final String zzsG;
    public final boolean zzsH;
    public final AdSizeParcel[] zzsI;
    public final boolean zzsJ;

    static {
        CREATOR = new zzh();
    }

    public AdSizeParcel() {
        this(3, "interstitial_mb", 0, 0, true, 0, 0, null, false);
    }

    AdSizeParcel(int i, String str, int i2, int i3, boolean z, int i4, int i5, AdSizeParcel[] adSizeParcelArr, boolean z2) {
        this.versionCode = i;
        this.zzsG = str;
        this.height = i2;
        this.heightPixels = i3;
        this.zzsH = z;
        this.width = i4;
        this.widthPixels = i5;
        this.zzsI = adSizeParcelArr;
        this.zzsJ = z2;
    }

    public AdSizeParcel(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    public AdSizeParcel(Context context, AdSize[] adSizeArr) {
        int i;
        int i2;
        AdSize adSize = adSizeArr[0];
        this.versionCode = 3;
        this.zzsH = false;
        this.width = adSize.getWidth();
        this.height = adSize.getHeight();
        boolean z = this.width == -1;
        boolean z2 = this.height == -2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (z) {
            if (zzk.zzcE().zzS(context) && zzk.zzcE().zzT(context)) {
                this.widthPixels = zza(displayMetrics) - zzk.zzcE().zzU(context);
            } else {
                this.widthPixels = zza(displayMetrics);
            }
            double d = (double) (((float) this.widthPixels) / displayMetrics.density);
            i = (int) d;
            if (d - ((double) ((int) d)) >= 0.01d) {
                i++;
            }
            i2 = i;
        } else {
            i = this.width;
            this.widthPixels = zzk.zzcE().zza(displayMetrics, this.width);
            i2 = i;
        }
        i = z2 ? zzc(displayMetrics) : this.height;
        this.heightPixels = zzk.zzcE().zza(displayMetrics, i);
        if (z || z2) {
            this.zzsG = i2 + "x" + i + "_as";
        } else {
            this.zzsG = adSize.toString();
        }
        if (adSizeArr.length > 1) {
            this.zzsI = new AdSizeParcel[adSizeArr.length];
            for (int i3 = 0; i3 < adSizeArr.length; i3++) {
                this.zzsI[i3] = new AdSizeParcel(context, adSizeArr[i3]);
            }
        } else {
            this.zzsI = null;
        }
        this.zzsJ = false;
    }

    public AdSizeParcel(AdSizeParcel adSizeParcel, AdSizeParcel[] adSizeParcelArr) {
        this(3, adSizeParcel.zzsG, adSizeParcel.height, adSizeParcel.heightPixels, adSizeParcel.zzsH, adSizeParcel.width, adSizeParcel.widthPixels, adSizeParcelArr, adSizeParcel.zzsJ);
    }

    public static int zza(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static int zzb(DisplayMetrics displayMetrics) {
        return (int) (((float) zzc(displayMetrics)) * displayMetrics.density);
    }

    private static int zzc(DisplayMetrics displayMetrics) {
        int i = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        return i <= HttpStatus.SC_BAD_REQUEST ? 32 : i <= 720 ? 50 : 90;
    }

    public static AdSizeParcel zzcB() {
        return new AdSizeParcel(3, "reward_mb", 0, 0, false, 0, 0, null, false);
    }

    public static AdSizeParcel zzs(Context context) {
        return new AdSizeParcel(3, "320x50_mb", 0, 0, false, 0, 0, null, true);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }

    public AdSize zzcC() {
        return zza.zza(this.width, this.height, this.zzsG);
    }
}
