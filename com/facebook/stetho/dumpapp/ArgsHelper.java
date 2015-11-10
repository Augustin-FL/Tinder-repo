package com.facebook.stetho.dumpapp;

import java.util.Iterator;

public class ArgsHelper {
    public static String nextOptionalArg(Iterator<String> it, String str) {
        return it.hasNext() ? (String) it.next() : str;
    }

    public static String nextArg(Iterator<String> it, String str) throws DumpUsageException {
        if (it.hasNext()) {
            return (String) it.next();
        }
        throw new DumpUsageException(str);
    }
}
