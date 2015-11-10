package io.fabric.sdk.android.services.common;

public enum DeliveryMechanism {
    DEVELOPER(1),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);
    
    private final int f7041e;

    private DeliveryMechanism(int i) {
        this.f7041e = i;
    }

    public int m9881a() {
        return this.f7041e;
    }

    public String toString() {
        return Integer.toString(this.f7041e);
    }

    public static DeliveryMechanism m9880a(String str) {
        if ("io.crash.air".equals(str)) {
            return TEST_DISTRIBUTION;
        }
        if (str != null) {
            return APP_STORE;
        }
        return DEVELOPER;
    }
}
