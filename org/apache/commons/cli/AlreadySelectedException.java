package org.apache.commons.cli;

public class AlreadySelectedException extends ParseException {
    private OptionGroup f7318a;
    private Option f7319b;

    public AlreadySelectedException(String str) {
        super(str);
    }

    public AlreadySelectedException(OptionGroup optionGroup, Option option) {
        this(new StringBuffer().append("The option '").append(option.m10353a()).append("' was specified but an option from this group ").append("has already been selected: '").append(optionGroup.m10371b()).append("'").toString());
        this.f7318a = optionGroup;
        this.f7319b = option;
    }
}
