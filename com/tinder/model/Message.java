package com.tinder.model;

import com.tinder.managers.ManagerApp;

public class Message extends BaseMessage<Message> {
    static final long serialVersionUID = 8434895317289603049L;
    private String mFromUserId;
    private boolean mHasError;
    private boolean mIsPending;
    private boolean mIsViewed;
    private final String mMatchId;
    private final String mText;

    public Message(String str, String str2, String str3, String str4, boolean z, long j) {
        super(str2, j);
        this.mMatchId = str;
        this.mFromUserId = str3;
        this.mText = str4;
        this.mIsViewed = z;
    }

    public void setIsPending(boolean z) {
        this.mIsPending = z;
    }

    public boolean isPending() {
        return this.mIsPending;
    }

    public String getMatchId() {
        return this.mMatchId;
    }

    public String getFromUserId() {
        return this.mFromUserId;
    }

    public boolean hasError() {
        return this.mHasError;
    }

    public String getText() {
        return this.mText;
    }

    public boolean isViewed() {
        return this.mIsViewed;
    }

    public void setViewed(boolean z) {
        this.mIsViewed = z;
    }

    public void setHasError(boolean z) {
        this.mHasError = z;
    }

    public boolean isFromMe() {
        User d = ManagerApp.m7922m().m8599d();
        return d != null && this.mFromUserId.equals(d.getId());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Message message = (Message) obj;
        if (this.mHasError != message.mHasError) {
            return false;
        }
        if (this.mIsViewed != message.mIsViewed) {
            return false;
        }
        if (this.mIsPending != message.mIsPending) {
            return false;
        }
        if (this.mMatchId == null ? message.mMatchId != null : !this.mMatchId.equals(message.mMatchId)) {
            return false;
        }
        if (getCreationDate() == null ? message.getCreationDate() != null : !getCreationDate().equals(message.getCreationDate())) {
            return false;
        }
        if (this.mText == null ? message.mText != null : !this.mText.equals(message.mText)) {
            return false;
        }
        if (this.mFromUserId != null) {
            if (this.mFromUserId.equals(message.mFromUserId)) {
                return true;
            }
        } else if (message.mFromUserId == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i = 1;
        int hashCode2 = (this.mMatchId != null ? this.mMatchId.hashCode() : 0) * 31;
        if (this.mText != null) {
            hashCode = this.mText.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (getCreationDate() != null) {
            hashCode = getCreationDate().hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.mFromUserId != null) {
            hashCode = this.mFromUserId.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.mHasError) {
            hashCode = 1;
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.mIsViewed) {
            hashCode = 1;
        } else {
            hashCode = 0;
        }
        hashCode = (hashCode + hashCode2) * 31;
        if (!this.mIsPending) {
            i = 0;
        }
        return hashCode + i;
    }

    public String toString() {
        return "Message{id='" + getId() + '\'' + ", date='" + getCreationDate() + '\'' + ", error=" + this.mHasError + ", viewed=" + this.mIsViewed + ", pending=" + this.mIsPending + '}';
    }

    public String getId() {
        return this.mMatchId + this.mFromUserId;
    }
}
