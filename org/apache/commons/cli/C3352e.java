package org.apache.commons.cli;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;

/* renamed from: org.apache.commons.cli.e */
public abstract class C3352e implements C3351a {
    protected CommandLine f7342a;
    private Options f7343b;
    private List f7344c;

    protected abstract String[] m10388b(Options options, String[] strArr, boolean z);

    protected void m10386a(Options options) {
        this.f7343b = options;
        this.f7344c = new ArrayList(options.m10376b());
    }

    protected Options m10382a() {
        return this.f7343b;
    }

    protected List m10387b() {
        return this.f7344c;
    }

    public CommandLine m10381a(Options options, String[] strArr, boolean z) throws ParseException {
        return m10380a(options, strArr, null, z);
    }

    public CommandLine m10380a(Options options, String[] strArr, Properties properties, boolean z) throws ParseException {
        int i = 0;
        for (Option o : options.m10373a()) {
            o.m10368o();
        }
        m10386a(options);
        this.f7342a = new CommandLine();
        if (strArr == null) {
            strArr = new String[0];
        }
        ListIterator listIterator = Arrays.asList(m10388b(m10382a(), strArr, z)).listIterator();
        while (listIterator.hasNext()) {
            String str = (String) listIterator.next();
            if ("--".equals(str)) {
                i = 1;
            } else if ("-".equals(str)) {
                if (z) {
                    i = 1;
                } else {
                    this.f7342a.m10348b(str);
                }
            } else if (!str.startsWith("-")) {
                this.f7342a.m10348b(str);
                if (z) {
                    i = 1;
                }
            } else if (!z || m10382a().m10378b(str)) {
                m10383a(str, listIterator);
            } else {
                this.f7342a.m10348b(str);
                i = 1;
            }
            if (i != 0) {
                while (listIterator.hasNext()) {
                    str = (String) listIterator.next();
                    if (!"--".equals(str)) {
                        this.f7342a.m10348b(str);
                    }
                }
            }
        }
        m10384a(properties);
        m10389c();
        return this.f7342a;
    }

    protected void m10384a(Properties properties) {
        if (properties != null) {
            Enumeration propertyNames = properties.propertyNames();
            while (propertyNames.hasMoreElements()) {
                String obj = propertyNames.nextElement().toString();
                if (!this.f7342a.m10347a(obj)) {
                    Option a = m10382a().m10374a(obj);
                    obj = properties.getProperty(obj);
                    if (a.m10359f()) {
                        if (a.m10367n() == null || a.m10367n().length == 0) {
                            try {
                                a.m10354a(obj);
                            } catch (RuntimeException e) {
                            }
                        }
                    } else if (!("yes".equalsIgnoreCase(obj) || ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(obj) || AppEventsConstants.EVENT_PARAM_VALUE_YES.equalsIgnoreCase(obj))) {
                        return;
                    }
                    this.f7342a.m10346a(a);
                }
            }
        }
    }

    protected void m10389c() throws MissingOptionException {
        if (!m10387b().isEmpty()) {
            throw new MissingOptionException(m10387b());
        }
    }

    public void m10385a(Option option, ListIterator listIterator) throws ParseException {
        while (listIterator.hasNext()) {
            String str = (String) listIterator.next();
            if (m10382a().m10378b(str) && str.startsWith("-")) {
                listIterator.previous();
                break;
            } else {
                try {
                    option.m10354a(C3358f.m10405b(str));
                } catch (RuntimeException e) {
                    listIterator.previous();
                }
            }
        }
        if (option.m10367n() == null && !option.m10357d()) {
            throw new MissingArgumentException(option);
        }
    }

    protected void m10383a(String str, ListIterator listIterator) throws ParseException {
        if (m10382a().m10378b(str)) {
            Option option = (Option) m10382a().m10374a(str).clone();
            if (option.m10361h()) {
                m10387b().remove(option.m10353a());
            }
            if (m10382a().m10377b(option) != null) {
                OptionGroup b = m10382a().m10377b(option);
                if (b.m10372c()) {
                    m10387b().remove(b);
                }
                b.m10370a(option);
            }
            if (option.m10359f()) {
                m10385a(option, listIterator);
            }
            this.f7342a.m10346a(option);
            return;
        }
        throw new UnrecognizedOptionException(new StringBuffer().append("Unrecognized option: ").append(str).toString(), str);
    }
}
