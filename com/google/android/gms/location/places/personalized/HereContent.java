package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.List;

public class HereContent implements SafeParcelable {
    public static final zzb CREATOR;
    final int mVersionCode;
    private final String zzaFe;
    private final List<Action> zzaFf;

    public static final class Action implements SafeParcelable {
        public static final zza CREATOR;
        final int mVersionCode;
        private final String zzPb;
        private final String zzagU;

        static {
            CREATOR = new zza();
        }

        Action(int i, String str, String str2) {
            this.mVersionCode = i;
            this.zzagU = str;
            this.zzPb = str2;
        }

        public int describeContents() {
            zza com_google_android_gms_location_places_personalized_zza = CREATOR;
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Action)) {
                return false;
            }
            Action action = (Action) obj;
            return zzw.equal(this.zzagU, action.zzagU) && zzw.equal(this.zzPb, action.zzPb);
        }

        public String getTitle() {
            return this.zzagU;
        }

        public String getUri() {
            return this.zzPb;
        }

        public int hashCode() {
            return zzw.hashCode(this.zzagU, this.zzPb);
        }

        public String toString() {
            return zzw.zzu(this).zzg(ShareConstants.WEB_DIALOG_PARAM_TITLE, this.zzagU).zzg("uri", this.zzPb).toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            zza com_google_android_gms_location_places_personalized_zza = CREATOR;
            zza.zza(this, parcel, i);
        }
    }

    static {
        CREATOR = new zzb();
    }

    HereContent(int i, String str, List<Action> list) {
        this.mVersionCode = i;
        this.zzaFe = str;
        this.zzaFf = list;
    }

    public int describeContents() {
        zzb com_google_android_gms_location_places_personalized_zzb = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HereContent)) {
            return false;
        }
        HereContent hereContent = (HereContent) obj;
        return zzw.equal(this.zzaFe, hereContent.zzaFe) && zzw.equal(this.zzaFf, hereContent.zzaFf);
    }

    public List<Action> getActions() {
        return this.zzaFf;
    }

    public String getData() {
        return this.zzaFe;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaFe, this.zzaFf);
    }

    public String toString() {
        return zzw.zzu(this).zzg(ShareConstants.WEB_DIALOG_PARAM_DATA, this.zzaFe).zzg("actions", this.zzaFf).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb com_google_android_gms_location_places_personalized_zzb = CREATOR;
        zzb.zza(this, parcel, i);
    }
}
