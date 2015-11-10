package com.tinder.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.List;

public class TinderReportNotification {
    private static final String VALUE_NOTIFICATION_BANNED = "banned";
    private static final String VALUE_NOTIFICATION_WARNING = "warning";
    private List<Integer> mReasons;
    private int mTier;
    private String mType;

    public enum NotificationType {
        WARNING,
        BANNED
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public Integer getTier() {
        return Integer.valueOf(this.mTier);
    }

    public void setTier(int i) {
        this.mTier = i;
    }

    public List<Integer> getReasons() {
        return this.mReasons;
    }

    public void setReasons(List<Integer> list) {
        this.mReasons = list;
    }

    @NonNull
    public NotificationType getNotificationtype() {
        if (!TextUtils.isEmpty(this.mType)) {
            if (this.mType.toLowerCase().equals(VALUE_NOTIFICATION_WARNING)) {
                return NotificationType.WARNING;
            }
            if (this.mType.toLowerCase().equals(VALUE_NOTIFICATION_BANNED)) {
                return NotificationType.BANNED;
            }
        }
        return NotificationType.WARNING;
    }

    @NonNull
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("type:[" + this.mType + "]");
        stringBuilder.append("tier:[" + this.mTier + "]");
        stringBuilder.append("reasons[" + this.mReasons + "]");
        return stringBuilder.toString();
    }
}
