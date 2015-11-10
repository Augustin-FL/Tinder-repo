package com.tinder.model;

import java.io.Serializable;

public class Interest implements Serializable {
    private String mId;
    private String mName;

    public Interest(String str, String str2) {
        this.mId = str;
        this.mName = str2;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }
}
