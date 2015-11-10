package com.facebook.stetho.dumpapp.plugins;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.facebook.stetho.BuildConfig;
import com.facebook.stetho.dumpapp.DumpUsageException;
import com.facebook.stetho.dumpapp.DumperContext;
import com.facebook.stetho.dumpapp.DumperPlugin;
import java.io.File;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class SharedPreferencesDumperPlugin implements DumperPlugin {
    private static final String NAME = "prefs";
    private static final String XML_SUFFIX = ".xml";
    private final Context mAppContext;

    /* renamed from: com.facebook.stetho.dumpapp.plugins.SharedPreferencesDumperPlugin.1 */
    static /* synthetic */ class C06611 {
        static final /* synthetic */ int[] f703x96b4f424;

        static {
            f703x96b4f424 = new int[Type.values().length];
            try {
                f703x96b4f424[Type.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f703x96b4f424[Type.INT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f703x96b4f424[Type.LONG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f703x96b4f424[Type.FLOAT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f703x96b4f424[Type.STRING.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f703x96b4f424[Type.SET.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    private enum Type {
        BOOLEAN("boolean"),
        INT("int"),
        LONG("long"),
        FLOAT("float"),
        STRING("string"),
        SET("set");
        
        private final String name;

        private Type(String str) {
            this.name = str;
        }

        public static Type of(String str) {
            for (Type type : values()) {
                if (type.name.equals(str)) {
                    return type;
                }
            }
            return null;
        }

        public static StringBuilder appendNamesList(StringBuilder stringBuilder, String str) {
            Object obj = 1;
            for (Type type : values()) {
                if (obj != null) {
                    obj = null;
                } else {
                    stringBuilder.append(str);
                }
                stringBuilder.append(type.name);
            }
            return stringBuilder;
        }
    }

    public SharedPreferencesDumperPlugin(Context context) {
        this.mAppContext = context.getApplicationContext();
    }

    public String getName() {
        return NAME;
    }

    public void dump(DumperContext dumperContext) throws DumpUsageException {
        PrintStream stdout = dumperContext.getStdout();
        List argsAsList = dumperContext.getArgsAsList();
        String str = argsAsList.isEmpty() ? BuildConfig.FLAVOR : (String) argsAsList.remove(0);
        if (str.equals("print")) {
            doPrint(stdout, argsAsList);
        } else if (str.equals("write")) {
            doWrite(argsAsList);
        } else {
            doUsage(stdout);
        }
    }

    private void doWrite(List<String> list) throws DumpUsageException {
        String str = "Usage: prefs write <path> <key> <type> <value>, where type is one of: ";
        Iterator it = list.iterator();
        String nextArg = nextArg(it, "Expected <path>");
        String nextArg2 = nextArg(it, "Expected <key>");
        Type of = Type.of(nextArg(it, "Expected <type>"));
        if (of == null) {
            throw new DumpUsageException(", ");
        }
        Editor edit = getSharedPreferences(nextArg).edit();
        switch (C06611.f703x96b4f424[of.ordinal()]) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                edit.putBoolean(nextArg2, Boolean.valueOf(nextArgValue(it)).booleanValue());
                break;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                edit.putInt(nextArg2, Integer.valueOf(nextArgValue(it)).intValue());
                break;
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                edit.putLong(nextArg2, Long.valueOf(nextArgValue(it)).longValue());
                break;
            case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                edit.putFloat(nextArg2, Float.valueOf(nextArgValue(it)).floatValue());
                break;
            case C3374b.SmoothProgressBar_spb_speed /*5*/:
                edit.putString(nextArg2, nextArgValue(it));
                break;
            case C3374b.SmoothProgressBar_spb_progressiveStart_speed /*6*/:
                putStringSet(edit, nextArg2, it);
                break;
        }
        edit.commit();
    }

    private static String nextArg(Iterator<String> it, String str) throws DumpUsageException {
        if (it.hasNext()) {
            return (String) it.next();
        }
        throw new DumpUsageException(str);
    }

    private static String nextArgValue(Iterator<String> it) throws DumpUsageException {
        return nextArg(it, "Expected <value>");
    }

    @TargetApi(11)
    private static void putStringSet(Editor editor, String str, Iterator<String> it) {
        Set hashSet = new HashSet();
        while (it.hasNext()) {
            hashSet.add(it.next());
        }
        editor.putStringSet(str, hashSet);
    }

    private void doPrint(PrintStream printStream, List<String> list) {
        printRecursive(printStream, this.mAppContext.getApplicationInfo().dataDir + "/shared_prefs", BuildConfig.FLAVOR, list.isEmpty() ? BuildConfig.FLAVOR : (String) list.get(0), list.size() > 1 ? (String) list.get(1) : BuildConfig.FLAVOR);
    }

    private void printRecursive(PrintStream printStream, String str, String str2, String str3, String str4) {
        File file = new File(str, str2);
        if (file.isFile()) {
            if (str2.endsWith(XML_SUFFIX)) {
                printFile(printStream, str2.substring(0, str2.length() - XML_SUFFIX.length()), str4);
            }
        } else if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                int i = 0;
                while (i < list.length) {
                    String str5 = TextUtils.isEmpty(str2) ? list[i] : str2 + File.separator + list[i];
                    if (str5.startsWith(str3)) {
                        printRecursive(printStream, str, str5, str3, str4);
                    }
                    i++;
                }
            }
        }
    }

    private void printFile(PrintStream printStream, String str, String str2) {
        printStream.println(str + ":");
        for (Entry entry : getSharedPreferences(str).getAll().entrySet()) {
            if (((String) entry.getKey()).startsWith(str2)) {
                printStream.println("  " + ((String) entry.getKey()) + " = " + entry.getValue());
            }
        }
    }

    private void doUsage(PrintStream printStream) {
        String str = "dumpapp prefs";
        str = "Usage: dumpapp prefs ";
        printStream.println(str + "<command> [command-options]");
        printStream.println(str + "print [pathPrefix [keyPrefix]]");
        printStream.println(Type.appendNamesList(new StringBuilder("       dumpapp prefs ").append("write <path> <key> <"), "|").append("> <value>"));
        printStream.println();
        printStream.println("dumpapp prefs print: Print all matching values from the shared preferences");
        printStream.println();
        printStream.println("dumpapp prefs write: Writes a value to the shared preferences");
    }

    private SharedPreferences getSharedPreferences(String str) {
        return this.mAppContext.getSharedPreferences(str, 4);
    }
}
