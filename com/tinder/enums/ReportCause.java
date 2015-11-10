package com.tinder.enums;

public enum ReportCause {
    OTHER("OTHER"),
    SPAM("SPAM"),
    ABUSIVE_CONTENT("OFFENSIVE"),
    UNCOMFORTABLE("UNCOMFORTABLE"),
    INAPPROPRIATE_PHOTOS("INAPPROPRIATE_PHOTOS"),
    OFFLINE_BEHAVIOR("OFFLINE_BEHAVIOR");
    
    private final String mAnalyticsValue;

    private ReportCause(String str) {
        this.mAnalyticsValue = str;
    }

    public String getAnalyticsValue() {
        return this.mAnalyticsValue;
    }
}
