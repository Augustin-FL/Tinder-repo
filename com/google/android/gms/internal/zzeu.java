package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdRequest.Gender;
import com.google.ads.C0691a;
import com.google.ads.mediation.C0700b;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.zza;
import java.util.Date;
import java.util.HashSet;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

@zzgk
public final class zzeu {

    /* renamed from: com.google.android.gms.internal.zzeu.1 */
    static /* synthetic */ class C10861 {
        static final /* synthetic */ int[] zzzg;
        static final /* synthetic */ int[] zzzh;

        static {
            zzzh = new int[ErrorCode.values().length];
            try {
                zzzh[ErrorCode.INTERNAL_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                zzzh[ErrorCode.INVALID_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                zzzh[ErrorCode.NETWORK_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                zzzh[ErrorCode.NO_FILL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            zzzg = new int[Gender.values().length];
            try {
                zzzg[Gender.FEMALE.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                zzzg[Gender.MALE.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                zzzg[Gender.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public static int zza(ErrorCode errorCode) {
        switch (C10861.zzzh[errorCode.ordinal()]) {
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                return 1;
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                return 2;
            case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                return 3;
            default:
                return 0;
        }
    }

    public static C0691a zzb(AdSizeParcel adSizeParcel) {
        int i = 0;
        C0691a[] c0691aArr = new C0691a[]{C0691a.f720a, C0691a.f721b, C0691a.f722c, C0691a.f723d, C0691a.f724e, C0691a.f725f};
        while (i < c0691aArr.length) {
            if (c0691aArr[i].m951a() == adSizeParcel.width && c0691aArr[i].m952b() == adSizeParcel.height) {
                return c0691aArr[i];
            }
            i++;
        }
        return new C0691a(zza.zza(adSizeParcel.width, adSizeParcel.height, adSizeParcel.zzsG));
    }

    public static C0700b zzg(AdRequestParcel adRequestParcel) {
        return new C0700b(new Date(adRequestParcel.zzsq), zzr(adRequestParcel.zzsr), adRequestParcel.zzss != null ? new HashSet(adRequestParcel.zzss) : null, adRequestParcel.zzst, adRequestParcel.zzsy);
    }

    public static Gender zzr(int i) {
        switch (i) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                return Gender.MALE;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                return Gender.FEMALE;
            default:
                return Gender.UNKNOWN;
        }
    }
}
