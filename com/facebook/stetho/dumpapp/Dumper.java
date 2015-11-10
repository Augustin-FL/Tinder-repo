package com.facebook.stetho.dumpapp;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.cli.C3351a;
import org.apache.commons.cli.C3353b;
import org.apache.commons.cli.C3356c;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.ParseException;

public class Dumper {
    private final Map<String, DumperPlugin> mDumperPlugins;
    private final GlobalOptions mGlobalOptions;
    private final C3351a mParser;

    public Dumper(Iterable<DumperPlugin> iterable) {
        this(iterable, new C3353b());
    }

    public Dumper(Iterable<DumperPlugin> iterable, C3351a c3351a) {
        this.mDumperPlugins = generatePluginMap(iterable);
        this.mParser = c3351a;
        this.mGlobalOptions = new GlobalOptions();
    }

    private static Map<String, DumperPlugin> generatePluginMap(Iterable<DumperPlugin> iterable) {
        Map hashMap = new HashMap();
        for (DumperPlugin dumperPlugin : iterable) {
            hashMap.put(dumperPlugin.getName(), dumperPlugin);
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public int dump(InputStream inputStream, PrintStream printStream, PrintStream printStream2, String[] strArr) {
        int i = 1;
        try {
            i = doDump(inputStream, printStream, printStream2, strArr);
        } catch (ParseException e) {
            printStream2.println(e.getMessage());
            dumpUsage(printStream2);
        } catch (DumpException e2) {
            printStream2.println(e2.getMessage());
        } catch (DumpappOutputBrokenException e3) {
            throw e3;
        } catch (RuntimeException e4) {
            e4.printStackTrace(printStream2);
        }
        return i;
    }

    private int doDump(InputStream inputStream, PrintStream printStream, PrintStream printStream2, String[] strArr) throws ParseException, DumpException {
        CommandLine a = this.mParser.m10379a(this.mGlobalOptions.options, strArr, true);
        if (a.m10347a(this.mGlobalOptions.optionHelp.m10355b())) {
            dumpUsage(printStream);
            return 0;
        } else if (a.m10347a(this.mGlobalOptions.optionListPlugins.m10355b())) {
            dumpAvailablePlugins(printStream);
            return 0;
        } else if (a.m10345a().isEmpty()) {
            dumpUsage(printStream2);
            return 1;
        } else {
            dumpPluginOutput(inputStream, printStream, printStream2, a);
            return 0;
        }
    }

    private void dumpAvailablePlugins(PrintStream printStream) {
        List<String> arrayList = new ArrayList();
        for (DumperPlugin name : this.mDumperPlugins.values()) {
            arrayList.add(name.getName());
        }
        Collections.sort(arrayList);
        for (String println : arrayList) {
            printStream.println(println);
        }
    }

    private void dumpPluginOutput(InputStream inputStream, PrintStream printStream, PrintStream printStream2, CommandLine commandLine) throws DumpException {
        List arrayList = new ArrayList(commandLine.m10345a());
        if (arrayList.size() < 1) {
            throw new DumpException("Expected plugin argument");
        }
        String str = (String) arrayList.remove(0);
        DumperPlugin dumperPlugin = (DumperPlugin) this.mDumperPlugins.get(str);
        if (dumperPlugin == null) {
            throw new DumpException("No plugin named '" + str + "'");
        }
        dumperPlugin.dump(new DumperContext(inputStream, printStream, printStream2, this.mParser, arrayList));
    }

    private void dumpUsage(PrintStream printStream) {
        String str = "dumpapp";
        C3356c c3356c = new C3356c();
        printStream.println("Usage: dumpapp [options] <plugin> [plugin-options]");
        PrintWriter printWriter = new PrintWriter(printStream);
        try {
            c3356c.m10397a(printWriter, c3356c.m10391a(), this.mGlobalOptions.options, c3356c.m10398b(), c3356c.m10399c());
        } finally {
            printWriter.flush();
        }
    }
}
