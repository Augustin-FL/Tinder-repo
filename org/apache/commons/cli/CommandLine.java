package org.apache.commons.cli;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CommandLine implements Serializable {
    private static final long serialVersionUID = 1;
    private List f7320a;
    private List f7321b;

    CommandLine() {
        this.f7320a = new LinkedList();
        this.f7321b = new ArrayList();
    }

    public boolean m10347a(String str) {
        return this.f7321b.contains(m10344c(str));
    }

    private Option m10344c(String str) {
        String a = C3358f.m10404a(str);
        for (Option option : this.f7321b) {
            if (a.equals(option.m10355b())) {
                return option;
            }
            if (a.equals(option.m10356c())) {
                return option;
            }
        }
        return null;
    }

    public List m10345a() {
        return this.f7320a;
    }

    void m10348b(String str) {
        this.f7320a.add(str);
    }

    void m10346a(Option option) {
        this.f7321b.add(option);
    }
}
