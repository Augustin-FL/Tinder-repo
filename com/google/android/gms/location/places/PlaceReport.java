package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class PlaceReport implements SafeParcelable {
    public static final Creator<PlaceReport> CREATOR;
    private final String mTag;
    final int mVersionCode;
    private final String zzaDH;
    private final String zzaDI;

    static {
        CREATOR = new zzj();
    }

    PlaceReport(int i, String str, String str2, String str3) {
        this.mVersionCode = i;
        this.zzaDH = str;
        this.mTag = str2;
        this.zzaDI = str3;
    }

    public static PlaceReport create(String str, String str2) {
        return zzi(str, str2, AnalyticsEvents.PARAMETER_SHARE_OUTCOME_UNKNOWN);
    }

    private static boolean zzdz(String str) {
        boolean z = true;
        switch (str.hashCode()) {
            case -1436706272:
                if (str.equals("inferredGeofencing")) {
                    z = true;
                    break;
                }
                break;
            case -1194968642:
                if (str.equals("userReported")) {
                    z = true;
                    break;
                }
                break;
            case -284840886:
                if (str.equals(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_UNKNOWN)) {
                    z = false;
                    break;
                }
                break;
            case -262743844:
                if (str.equals("inferredReverseGeocoding")) {
                    z = true;
                    break;
                }
                break;
            case 1287171955:
                if (str.equals("inferredRadioSignals")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case C3374b.SmoothProgressBar_spbStyle /*0*/:
            case C3374b.SmoothProgressBar_spb_color /*1*/:
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
            case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                return true;
            default:
                return false;
        }
    }

    public static PlaceReport zzi(String str, String str2, String str3) {
        zzx.zzcs(str);
        zzx.zzcs(str2);
        zzx.zzcs(str3);
        zzx.zzb(zzdz(str3), (Object) "Invalid source");
        return new PlaceReport(1, str, str2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlaceReport)) {
            return false;
        }
        PlaceReport placeReport = (PlaceReport) obj;
        return zzw.equal(this.zzaDH, placeReport.zzaDH) && zzw.equal(this.mTag, placeReport.mTag) && zzw.equal(this.zzaDI, placeReport.zzaDI);
    }

    public String getPlaceId() {
        return this.zzaDH;
    }

    public String getSource() {
        return this.zzaDI;
    }

    public String getTag() {
        return this.mTag;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaDH, this.mTag, this.zzaDI);
    }

    public String toString() {
        zza zzu = zzw.zzu(this);
        zzu.zzg("placeId", this.zzaDH);
        zzu.zzg("tag", this.mTag);
        if (!AnalyticsEvents.PARAMETER_SHARE_OUTCOME_UNKNOWN.equals(this.zzaDI)) {
            zzu.zzg(ShareConstants.FEED_SOURCE_PARAM, this.zzaDI);
        }
        return zzu.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }
}
