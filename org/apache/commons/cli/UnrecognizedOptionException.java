package org.apache.commons.cli;

public class UnrecognizedOptionException extends ParseException {
    private String f7341a;

    public UnrecognizedOptionException(String str) {
        super(str);
    }

    public UnrecognizedOptionException(String str, String str2) {
        this(str);
        this.f7341a = str2;
    }
}
