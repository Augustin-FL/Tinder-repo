package com.tinder.model;

public class ProductFeature {
    private String mDetails;
    private String mIconUrl;
    private String mProductId;
    private String mTitle;

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public String getIconUrl() {
        return this.mIconUrl;
    }

    public void setIconUrl(String str) {
        this.mIconUrl = str;
    }

    public String getDetails() {
        return this.mDetails;
    }

    public void setDetails(String str) {
        this.mDetails = str;
    }

    public String getProductId() {
        return this.mProductId;
    }

    public void setProductId(String str) {
        this.mProductId = str;
    }
}
