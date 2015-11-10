package com.crashlytics.android.core;

import io.fabric.sdk.android.C3218c;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.crashlytics.android.core.x */
class C0482x implements C0476u {
    private final File f695a;
    private final Map<String, String> f696b;

    public C0482x(File file) {
        this(file, Collections.emptyMap());
    }

    public C0482x(File file, Map<String, String> map) {
        this.f695a = file;
        this.f696b = new HashMap(map);
        if (this.f695a.length() == 0) {
            this.f696b.putAll(C0480v.f680a);
        }
    }

    public File m917d() {
        return this.f695a;
    }

    public String m915b() {
        return m917d().getName();
    }

    public String m916c() {
        String b = m915b();
        return b.substring(0, b.lastIndexOf(46));
    }

    public Map<String, String> m918e() {
        return Collections.unmodifiableMap(this.f696b);
    }

    public boolean m914a() {
        C3218c.m9728h().m9687a("CrashlyticsCore", "Removing report at " + this.f695a.getPath());
        return this.f695a.delete();
    }
}
