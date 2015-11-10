package com.google.common.cache;

public enum RemovalCause {
    EXPLICIT {
        boolean m3546a() {
            return false;
        }
    },
    REPLACED {
        boolean m3547a() {
            return false;
        }
    },
    COLLECTED {
        boolean m3548a() {
            return true;
        }
    },
    EXPIRED {
        boolean m3549a() {
            return true;
        }
    },
    SIZE {
        boolean m3550a() {
            return true;
        }
    };

    abstract boolean m3545a();
}
