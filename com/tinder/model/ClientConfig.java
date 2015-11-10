package com.tinder.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;

public class ClientConfig implements Parcelable {
    public static final Creator<ClientConfig> CREATOR;
    @Nullable
    private RateCardConfig rateCard;

    /* renamed from: com.tinder.model.ClientConfig.1 */
    static class C29651 implements Creator<ClientConfig> {
        C29651() {
        }

        public ClientConfig createFromParcel(Parcel parcel) {
            return new ClientConfig(parcel);
        }

        public ClientConfig[] newArray(int i) {
            return new ClientConfig[i];
        }
    }

    protected ClientConfig(Parcel parcel) {
        this.rateCard = (RateCardConfig) parcel.readParcelable(RateCardConfig.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.rateCard, i);
    }

    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new C29651();
    }

    @Nullable
    public RateCardConfig getRateCard() {
        return this.rateCard;
    }

    public void setRateCard(@Nullable RateCardConfig rateCardConfig) {
        this.rateCard = rateCardConfig;
    }
}
