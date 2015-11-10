package com.tinder.enums;

public enum SqlDataType {
    BOOLEAN("BOOLEAN"),
    DATETIME("DATETIME"),
    INTEGER("INTEGER"),
    TEXT("TEXT"),
    REAL("REAL");
    
    private final String mName;

    private SqlDataType(String str) {
        this.mName = str;
    }

    public String getName() {
        return this.mName;
    }
}
