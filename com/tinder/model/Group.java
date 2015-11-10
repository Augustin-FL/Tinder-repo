package com.tinder.model;

public class Group {
    private boolean isBase;
    private boolean isPrimary;
    private String mGroupId;
    private String mKey;
    private String mSubType;
    private String mType;
    private String mVersion;

    public boolean isBase() {
        return this.isBase;
    }

    public void setIsBase(boolean z) {
        this.isBase = z;
    }

    public boolean isPrimary() {
        return this.isPrimary;
    }

    public void setIsPrimary(boolean z) {
        this.isPrimary = z;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public String getSubType() {
        return this.mSubType;
    }

    public void setSubType(String str) {
        this.mSubType = str;
    }

    public String getKey() {
        return this.mKey;
    }

    public void setKey(String str) {
        this.mKey = str;
    }

    public String getGroupId() {
        return this.mGroupId;
    }

    public void setGroupId(String str) {
        this.mGroupId = str;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public void setVersion(String str) {
        this.mVersion = str;
    }
}
