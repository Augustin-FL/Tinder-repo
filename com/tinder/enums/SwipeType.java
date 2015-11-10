package com.tinder.enums;

public enum SwipeType {
    LIKE_SWIPE(true, "SWIPE"),
    LIKE_BUTTON(true, "BUTTON"),
    PASS_SWIPE(false, "SWIPE"),
    PASS_BUTTON(false, "BUTTON"),
    SUPER_LIKE_SWIPE(true, "SWIPE"),
    SUPER_LIKE_BUTTON(true, "BUTTON");
    
    private final boolean mAnalyticsFlag;
    private final String mAnalyticsMethod;

    private SwipeType(boolean z, String str) {
        this.mAnalyticsFlag = z;
        this.mAnalyticsMethod = str;
    }

    public boolean getAnalyticsFlag() {
        return this.mAnalyticsFlag;
    }

    public String getAnalyticsMethod() {
        return this.mAnalyticsMethod;
    }
}
