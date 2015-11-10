package com.tinder.enums;

import android.support.annotation.NonNull;
import android.text.TextUtils;

public enum PurchaseType {
    CONSUMABLE("inapp"),
    SUBSCRIPTION("subs");
    
    private static final String TINDER_TYPE_CONSUMABLE = "consumable";
    private static final String TINDER_TYPE_SUBSCRIPTION = "subscription";
    private String mType;

    private PurchaseType(String str) {
        this.mType = str;
    }

    @NonNull
    public static PurchaseType getTypeFromSku(@NonNull String str) {
        if (TextUtils.equals(TINDER_TYPE_CONSUMABLE, str.split("_")[1])) {
            return CONSUMABLE;
        }
        return SUBSCRIPTION;
    }

    public static boolean isConsumable(String str) {
        return TextUtils.equals(CONSUMABLE.toString(), str);
    }

    public static boolean isSubscription(String str) {
        return TextUtils.equals(SUBSCRIPTION.toString(), str);
    }

    public String toString() {
        return this.mType;
    }
}
