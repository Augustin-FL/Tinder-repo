package org.apache.commons.cli;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class OptionGroup implements Serializable {
    private static final long serialVersionUID = 1;
    private Map f7334a;
    private String f7335b;
    private boolean f7336c;

    public OptionGroup() {
        this.f7334a = new HashMap();
    }

    public Collection m10369a() {
        return this.f7334a.values();
    }

    public void m10370a(Option option) throws AlreadySelectedException {
        if (this.f7335b == null || this.f7335b.equals(option.m10355b())) {
            this.f7335b = option.m10355b();
            return;
        }
        throw new AlreadySelectedException(this, option);
    }

    public String m10371b() {
        return this.f7335b;
    }

    public boolean m10372c() {
        return this.f7336c;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = m10369a().iterator();
        stringBuffer.append("[");
        while (it.hasNext()) {
            Option option = (Option) it.next();
            if (option.m10355b() != null) {
                stringBuffer.append("-");
                stringBuffer.append(option.m10355b());
            } else {
                stringBuffer.append("--");
                stringBuffer.append(option.m10356c());
            }
            stringBuffer.append(" ");
            stringBuffer.append(option.m10360g());
            if (it.hasNext()) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
