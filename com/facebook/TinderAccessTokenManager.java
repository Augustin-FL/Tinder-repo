package com.facebook;

public class TinderAccessTokenManager {
    public boolean loadAccessToken() {
        try {
            return AccessTokenManager.getInstance().loadCurrentAccessToken();
        } catch (NullPointerException e) {
            return false;
        }
    }
}
