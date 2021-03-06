package com.tinder.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

public class RateCardConfig implements Parcelable {
    public static final Creator<RateCardConfig> CREATOR;
    @NonNull
    private List<String> carousel;

    /* renamed from: com.tinder.model.RateCardConfig.1 */
    static class C29681 implements Creator<RateCardConfig> {
        C29681() {
        }

        public RateCardConfig createFromParcel(Parcel parcel) {
            return new RateCardConfig(parcel);
        }

        public RateCardConfig[] newArray(int i) {
            return new RateCardConfig[i];
        }
    }

    public RateCardConfig() {
        this.carousel = new ArrayList(5);
    }

    protected RateCardConfig(Parcel parcel) {
        this.carousel = parcel.createStringArrayList();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.carousel);
    }

    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new C29681();
    }

    @NonNull
    public List<String> getCarousel() {
        return this.carousel;
    }

    public void setCarousel(@NonNull List<String> list) {
        this.carousel = list;
    }
}
