package com.tinder.model;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private List<ProductFeature> mProductFeatures;
    private String mSku;

    public Product() {
        this.mProductFeatures = new ArrayList();
    }

    public String getSku() {
        return this.mSku;
    }

    public void setSku(String str) {
        this.mSku = str;
    }

    public List<ProductFeature> getProductFeatures() {
        return this.mProductFeatures;
    }

    public void setProductFeatures(List<ProductFeature> list) {
        this.mProductFeatures = list;
    }
}
