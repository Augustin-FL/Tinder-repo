package com.tinder.model;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.stetho.BuildConfig;
import java.io.Serializable;

public class TinderLocation implements Serializable {
    private String mAddress;
    private String mCity;
    private String mCountryLong;
    private String mCountryShort;
    private String mCounty;
    private long mLastSeenDate;
    private double mLatitude;
    private double mLongitude;
    private String mRoute;
    private String mStateProvinceLong;
    private String mStateProvinceShort;
    private String mStreetNum;

    public TinderLocation() {
        this.mLastSeenDate = System.currentTimeMillis();
    }

    public boolean hasGeoData() {
        return (this.mLatitude == 0.0d || this.mLongitude == 0.0d) ? false : true;
    }

    public String getRoute() {
        return this.mRoute;
    }

    public void setRoute(String str) {
        this.mRoute = str;
    }

    public String getStreetNumber() {
        return this.mStreetNum;
    }

    public void setStreetNumber(String str) {
        this.mStreetNum = str;
    }

    public String getCountryLong() {
        return this.mCountryLong;
    }

    public void setCountryLong(String str) {
        this.mCountryLong = str;
    }

    public String getCountryShort() {
        return this.mCountryShort;
    }

    public void setCountryShort(String str) {
        this.mCountryShort = str;
    }

    public String getCity() {
        return this.mCity;
    }

    public void setCity(String str) {
        this.mCity = str;
    }

    public String getCounty() {
        return this.mCounty;
    }

    public void setCounty(String str) {
        this.mCounty = str;
    }

    public String getAddressShort() {
        String str = BuildConfig.FLAVOR;
        if (!TextUtils.isEmpty(this.mStreetNum)) {
            str = str + this.mStreetNum;
        }
        if (TextUtils.isEmpty(this.mRoute)) {
            return str;
        }
        if (str.length() > 0) {
            str = str + " ";
        }
        return str + this.mRoute;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public void setAddress(String str) {
        this.mAddress = str;
    }

    public String getStateProvinceLong() {
        return this.mStateProvinceLong;
    }

    public void setStateProvinceLong(String str) {
        this.mStateProvinceLong = str;
    }

    public String getStateProvinceShort() {
        return this.mStateProvinceShort;
    }

    public void setStateProvinceShort(String str) {
        this.mStateProvinceShort = str;
    }

    public double getLatitude() {
        return this.mLatitude;
    }

    public void setLatitude(double d) {
        this.mLatitude = d;
    }

    public double getLongitude() {
        return this.mLongitude;
    }

    public void setLongitude(double d) {
        this.mLongitude = d;
    }

    public long getLastSeenDate() {
        return this.mLastSeenDate;
    }

    public void setLastSeenDate(long j) {
        this.mLastSeenDate = j;
    }

    public String getId() {
        return String.format("%s.%s", new Object[]{Double.valueOf(this.mLatitude), Double.valueOf(this.mLongitude)});
    }

    @Nullable
    public Pair<String, String> getLabels() {
        String addressShort = getAddressShort();
        Object city = getCity();
        CharSequence county = getCounty();
        Object stateProvinceLong = getStateProvinceLong();
        CharSequence countryShort = getCountryShort();
        if (!TextUtils.isEmpty(getAddressShort())) {
            if (TextUtils.isEmpty(city)) {
                if (TextUtils.isEmpty(stateProvinceLong)) {
                    city = null;
                } else {
                    city = stateProvinceLong;
                }
            }
            stateProvinceLong = addressShort;
        } else if (TextUtils.isEmpty(city) || TextUtils.isEmpty(stateProvinceLong)) {
            CharSequence charSequence;
            if (!TextUtils.isEmpty(city) && !TextUtils.isEmpty(countryShort)) {
                charSequence = countryShort;
            } else if (!TextUtils.isEmpty(county)) {
                r0 = county;
            } else if (!TextUtils.isEmpty(stateProvinceLong)) {
                city = stateProvinceLong;
                charSequence = countryShort;
            } else if (TextUtils.isEmpty(countryShort)) {
                stateProvinceLong = null;
                city = null;
            } else {
                stateProvinceLong = null;
                r0 = countryShort;
            }
        }
        return new Pair(city, stateProvinceLong);
    }

    public String getDisplayLabel() {
        Pair labels = getLabels();
        return ((String) labels.first) + ", " + ((String) labels.second);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TinderLocation)) {
            return super.equals(obj);
        }
        TinderLocation tinderLocation = (TinderLocation) obj;
        return tinderLocation.getLatitude() == getLatitude() && tinderLocation.getLongitude() == getLongitude();
    }
}
