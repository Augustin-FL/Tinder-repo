package com.tinder.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class FacebookFriend {
    private String mAvatarUrl;
    private FriendState mFriendState;
    private String mId;
    private boolean mIsOnTinder;
    private String mName;

    public enum FriendState {
        UNKNOWN,
        OPEN,
        REQUEST_SENT,
        REQUEST_ACCEPTED
    }

    public FacebookFriend(String str, String str2, String str3, FriendState friendState, boolean z) {
        this.mId = str;
        this.mName = str2;
        this.mAvatarUrl = str3;
        this.mFriendState = friendState;
        this.mIsOnTinder = z;
    }

    public boolean isOnTinder() {
        return this.mIsOnTinder;
    }

    public boolean isInStateUnknown() {
        return this.mFriendState.equals(FriendState.UNKNOWN);
    }

    public boolean isInStateOpen() {
        return this.mFriendState.equals(FriendState.OPEN);
    }

    public boolean isInStateRequestSent() {
        return this.mFriendState.equals(FriendState.REQUEST_SENT);
    }

    public boolean isInStateRequestAccepted() {
        return this.mFriendState.equals(FriendState.REQUEST_ACCEPTED);
    }

    public String getId() {
        return this.mId;
    }

    public FriendState getFriendState() {
        return this.mFriendState;
    }

    public void setFriendState(FriendState friendState) {
        this.mFriendState = friendState;
    }

    public String getName() {
        return this.mName;
    }

    public String getAvatarUrl() {
        return this.mAvatarUrl;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null || !(obj instanceof FacebookFriend)) {
            return false;
        }
        return this.mId.equals(((FacebookFriend) obj).mId);
    }

    public int hashCode() {
        return this.mId.hashCode();
    }

    @NonNull
    public String toString() {
        return "id: " + this.mId + " name: " + this.mName + " state: " + this.mFriendState + " avatarUrl: " + this.mAvatarUrl;
    }
}
