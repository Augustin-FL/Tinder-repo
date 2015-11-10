package com.crashlytics.android.core;

public class CrashlyticsMissingDependencyException extends RuntimeException {
    private static final long serialVersionUID = -1151536370019872859L;

    CrashlyticsMissingDependencyException(String str) {
        super(m615a(str));
    }

    private static String m615a(String str) {
        return "\n" + str + "\n";
    }
}
