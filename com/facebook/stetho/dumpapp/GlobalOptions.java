package com.facebook.stetho.dumpapp;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class GlobalOptions {
    public final Option optionHelp;
    public final Option optionListPlugins;
    public final Option optionProcess;
    public final Options options;

    public GlobalOptions() {
        this.optionHelp = new Option("h", "help", false, "Print this help");
        this.optionListPlugins = new Option("l", "list", false, "List available plugins");
        this.optionProcess = new Option("p", "process", true, "Specify target process");
        this.options = new Options();
        this.options.m10375a(this.optionHelp);
        this.options.m10375a(this.optionListPlugins);
        this.options.m10375a(this.optionProcess);
    }
}
