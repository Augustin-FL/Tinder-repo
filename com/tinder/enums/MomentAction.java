package com.tinder.enums;

import android.support.annotation.NonNull;

public enum MomentAction {
    CREATE("create"),
    DELETE("delete");
    
    private String mAction;

    private MomentAction(String str) {
        this.mAction = str;
    }

    @NonNull
    public static MomentAction get(String str) {
        for (MomentAction momentAction : values()) {
            if (momentAction.mAction.equals(str)) {
                return momentAction;
            }
        }
        return CREATE;
    }

    public String getAction() {
        return this.mAction;
    }
}
