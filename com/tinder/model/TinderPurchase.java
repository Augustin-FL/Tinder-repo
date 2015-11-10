package com.tinder.model;

import android.support.annotation.NonNull;

public class TinderPurchase {
    private String mCreateDate;
    private String mId;
    private String mProductId;
    private String mProductType;
    private String mPurchaseType;

    public String getId() {
        return this.mId;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public String getProductId() {
        return this.mProductId;
    }

    public void setProductId(String str) {
        this.mProductId = str;
    }

    public String getProductType() {
        return this.mProductType;
    }

    public void setProductType(String str) {
        this.mProductType = str;
    }

    public String getPurchaseType() {
        return this.mPurchaseType;
    }

    public void setPurchaseType(String str) {
        this.mPurchaseType = str;
    }

    public String getCreateDate() {
        return this.mCreateDate;
    }

    public void setCreateDate(String str) {
        this.mCreateDate = str;
    }

    @NonNull
    public String toString() {
        return "[id:" + this.mId + ", " + "productId:" + this.mProductId + ", " + "productType:" + this.mProductType + ", " + "purchasetype:" + this.mPurchaseType + ", " + "createDate:" + this.mCreateDate + ']';
    }
}
