package com.tinder.model;

import android.support.annotation.NonNull;
import java.io.Serializable;

public abstract class BaseMessage<T extends BaseMessage> implements Serializable, Comparable<T> {
    private final String mCreationDate;
    private final long mTime;

    public abstract String getId();

    public BaseMessage(String str, long j) {
        this.mCreationDate = str;
        this.mTime = j;
    }

    public long getTime() {
        return this.mTime;
    }

    public String getCreationDate() {
        return this.mCreationDate;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BaseMessage)) {
            return false;
        }
        BaseMessage baseMessage = (BaseMessage) obj;
        if (this.mTime != baseMessage.mTime) {
            return false;
        }
        if (this.mCreationDate == null ? baseMessage.mCreationDate != null : !this.mCreationDate.equals(baseMessage.mCreationDate)) {
            return false;
        }
        if (getId() != null) {
            if (getId().equals(getId())) {
                return true;
            }
        } else if (baseMessage.getId() == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        if (this.mCreationDate != null) {
            hashCode = this.mCreationDate.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode = ((hashCode * 31) + ((int) (this.mTime ^ (this.mTime >>> 32)))) * 31;
        if (getId() != null) {
            i = getId().hashCode();
        }
        return hashCode + i;
    }

    public int compareTo(@NonNull T t) {
        if (this.mTime < t.getTime()) {
            return -1;
        }
        return this.mTime == t.getTime() ? 0 : 1;
    }

    public String toString() {
        return "BaseMessage{date='" + this.mCreationDate + '\'' + ", time=" + this.mTime + ", id=" + getId() + '}';
    }
}
