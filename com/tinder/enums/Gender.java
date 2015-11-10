package com.tinder.enums;

public enum Gender {
    MALE(0),
    FEMALE(1);
    
    int backendId;

    private Gender(int i) {
        this.backendId = i;
    }

    public int getBackendId() {
        return this.backendId;
    }
}
