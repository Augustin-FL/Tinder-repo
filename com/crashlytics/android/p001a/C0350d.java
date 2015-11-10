package com.crashlytics.android.p001a;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* renamed from: com.crashlytics.android.a.d */
class C0350d {
    public final String f360a;
    public final String f361b;
    public final String f362c;
    public final String f363d;

    C0350d(String str, String str2, String str3, String str4) {
        this.f360a = str;
        this.f361b = str2;
        this.f362c = str3;
        this.f363d = str4;
    }

    public static C0350d m430a(Properties properties) {
        return new C0350d(properties.getProperty("version_code"), properties.getProperty("version_name"), properties.getProperty("build_id"), properties.getProperty("package_name"));
    }

    public static C0350d m429a(InputStream inputStream) throws IOException {
        Properties properties = new Properties();
        properties.load(inputStream);
        return C0350d.m430a(properties);
    }
}
