package com.google.ads;

@Deprecated
public final class AdRequest {
    public static final String f719a;

    public enum ErrorCode {
        INVALID_REQUEST("Invalid Ad request."),
        NO_FILL("Ad request successful, but no ad returned due to lack of ad inventory."),
        NETWORK_ERROR("A network error occurred."),
        INTERNAL_ERROR("There was an internal error.");
        
        private final String f714e;

        private ErrorCode(String str) {
            this.f714e = str;
        }

        public String toString() {
            return this.f714e;
        }
    }

    public enum Gender {
        UNKNOWN,
        MALE,
        FEMALE
    }

    static {
        f719a = com.google.android.gms.ads.AdRequest.DEVICE_ID_EMULATOR;
    }
}
