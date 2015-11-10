package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.AutocompletePrediction;
import com.google.android.gms.location.places.AutocompletePrediction.Substring;
import java.util.List;

public class AutocompletePredictionEntity implements SafeParcelable, AutocompletePrediction {
    public static final Creator<AutocompletePredictionEntity> CREATOR;
    final int mVersionCode;
    final String zzaDH;
    final List<Integer> zzaDi;
    final List<SubstringEntity> zzaEb;
    final int zzaEc;
    final String zzaoB;

    public static class SubstringEntity implements SafeParcelable, Substring {
        public static final Creator<SubstringEntity> CREATOR;
        final int mLength;
        final int mOffset;
        final int mVersionCode;

        static {
            CREATOR = new zzu();
        }

        public SubstringEntity(int i, int i2, int i3) {
            this.mVersionCode = i;
            this.mOffset = i2;
            this.mLength = i3;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SubstringEntity)) {
                return false;
            }
            SubstringEntity substringEntity = (SubstringEntity) obj;
            return zzw.equal(Integer.valueOf(this.mOffset), Integer.valueOf(substringEntity.mOffset)) && zzw.equal(Integer.valueOf(this.mLength), Integer.valueOf(substringEntity.mLength));
        }

        public int getLength() {
            return this.mLength;
        }

        public int getOffset() {
            return this.mOffset;
        }

        public int hashCode() {
            return zzw.hashCode(Integer.valueOf(this.mOffset), Integer.valueOf(this.mLength));
        }

        public String toString() {
            return zzw.zzu(this).zzg("offset", Integer.valueOf(this.mOffset)).zzg("length", Integer.valueOf(this.mLength)).toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzu.zza(this, parcel, i);
        }
    }

    static {
        CREATOR = new zza();
    }

    AutocompletePredictionEntity(int i, String str, String str2, List<Integer> list, List<SubstringEntity> list2, int i2) {
        this.mVersionCode = i;
        this.zzaoB = str;
        this.zzaDH = str2;
        this.zzaDi = list;
        this.zzaEb = list2;
        this.zzaEc = i2;
    }

    public static AutocompletePredictionEntity zza(String str, String str2, List<Integer> list, List<SubstringEntity> list2, int i) {
        return new AutocompletePredictionEntity(0, (String) zzx.zzv(str), str2, list, list2, i);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AutocompletePredictionEntity)) {
            return false;
        }
        AutocompletePredictionEntity autocompletePredictionEntity = (AutocompletePredictionEntity) obj;
        return zzw.equal(this.zzaoB, autocompletePredictionEntity.zzaoB) && zzw.equal(this.zzaDH, autocompletePredictionEntity.zzaDH) && zzw.equal(this.zzaDi, autocompletePredictionEntity.zzaDi) && zzw.equal(this.zzaEb, autocompletePredictionEntity.zzaEb) && zzw.equal(Integer.valueOf(this.zzaEc), Integer.valueOf(autocompletePredictionEntity.zzaEc));
    }

    public /* synthetic */ Object freeze() {
        return zzwg();
    }

    public String getDescription() {
        return this.zzaoB;
    }

    public List<? extends Substring> getMatchedSubstrings() {
        return this.zzaEb;
    }

    public String getPlaceId() {
        return this.zzaDH;
    }

    public List<Integer> getPlaceTypes() {
        return this.zzaDi;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaoB, this.zzaDH, this.zzaDi, this.zzaEb, Integer.valueOf(this.zzaEc));
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzw.zzu(this).zzg(ShareConstants.WEB_DIALOG_PARAM_DESCRIPTION, this.zzaoB).zzg("placeId", this.zzaDH).zzg("placeTypes", this.zzaDi).zzg("substrings", this.zzaEb).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public AutocompletePrediction zzwg() {
        return this;
    }
}
