package com.facebook.stetho.dumpapp;

import com.facebook.stetho.common.Util;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import org.apache.commons.cli.C3351a;

public class DumperContext {
    private final List<String> mArgs;
    private final C3351a mParser;
    private final PrintStream mStderr;
    private final InputStream mStdin;
    private final PrintStream mStdout;

    protected DumperContext(DumperContext dumperContext, List<String> list) {
        this(dumperContext.getStdin(), dumperContext.getStdout(), dumperContext.getStderr(), dumperContext.getParser(), list);
    }

    public DumperContext(InputStream inputStream, PrintStream printStream, PrintStream printStream2, C3351a c3351a, List<String> list) {
        this.mStdin = (InputStream) Util.throwIfNull(inputStream);
        this.mStdout = (PrintStream) Util.throwIfNull(printStream);
        this.mStderr = (PrintStream) Util.throwIfNull(printStream2);
        this.mParser = (C3351a) Util.throwIfNull(c3351a);
        this.mArgs = (List) Util.throwIfNull(list);
    }

    public InputStream getStdin() {
        return this.mStdin;
    }

    public PrintStream getStdout() {
        return this.mStdout;
    }

    public PrintStream getStderr() {
        return this.mStderr;
    }

    public C3351a getParser() {
        return this.mParser;
    }

    public List<String> getArgsAsList() {
        return this.mArgs;
    }
}
