package org.apache.commons.cli;

public class MissingArgumentException extends ParseException {
    private Option f7322a;

    public MissingArgumentException(String str) {
        super(str);
    }

    public MissingArgumentException(Option option) {
        this(new StringBuffer().append("Missing argument for option: ").append(option.m10353a()).toString());
        this.f7322a = option;
    }
}
