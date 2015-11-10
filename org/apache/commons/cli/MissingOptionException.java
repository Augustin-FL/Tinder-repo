package org.apache.commons.cli;

import com.facebook.stetho.BuildConfig;
import java.util.Iterator;
import java.util.List;

public class MissingOptionException extends ParseException {
    private List f7323a;

    public MissingOptionException(String str) {
        super(str);
    }

    public MissingOptionException(List list) {
        this(m10349a(list));
        this.f7323a = list;
    }

    private static String m10349a(List list) {
        StringBuffer stringBuffer = new StringBuffer("Missing required option");
        stringBuffer.append(list.size() == 1 ? BuildConfig.FLAVOR : "s");
        stringBuffer.append(": ");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next());
            if (it.hasNext()) {
                stringBuffer.append(", ");
            }
        }
        return stringBuffer.toString();
    }
}
