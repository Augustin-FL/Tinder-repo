package org.apache.commons.cli;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Options implements Serializable {
    private static final long serialVersionUID = 1;
    private Map f7337a;
    private Map f7338b;
    private List f7339c;
    private Map f7340d;

    public Options() {
        this.f7337a = new HashMap();
        this.f7338b = new HashMap();
        this.f7339c = new ArrayList();
        this.f7340d = new HashMap();
    }

    public Options m10375a(Option option) {
        String a = option.m10353a();
        if (option.m10358e()) {
            this.f7338b.put(option.m10356c(), option);
        }
        if (option.m10361h()) {
            if (this.f7339c.contains(a)) {
                this.f7339c.remove(this.f7339c.indexOf(a));
            }
            this.f7339c.add(a);
        }
        this.f7337a.put(a, option);
        return this;
    }

    List m10373a() {
        return new ArrayList(this.f7337a.values());
    }

    public List m10376b() {
        return this.f7339c;
    }

    public Option m10374a(String str) {
        String a = C3358f.m10404a(str);
        if (this.f7337a.containsKey(a)) {
            return (Option) this.f7337a.get(a);
        }
        return (Option) this.f7338b.get(a);
    }

    public boolean m10378b(String str) {
        String a = C3358f.m10404a(str);
        return this.f7337a.containsKey(a) || this.f7338b.containsKey(a);
    }

    public OptionGroup m10377b(Option option) {
        return (OptionGroup) this.f7340d.get(option.m10353a());
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[ Options: [ short ");
        stringBuffer.append(this.f7337a.toString());
        stringBuffer.append(" ] [ long ");
        stringBuffer.append(this.f7338b);
        stringBuffer.append(" ]");
        return stringBuffer.toString();
    }
}
