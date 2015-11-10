package io.fabric.sdk.android.services.p035c;

import android.content.Context;
import io.fabric.sdk.android.C0347h;
import io.fabric.sdk.android.C3218c;
import java.io.File;

/* renamed from: io.fabric.sdk.android.services.c.b */
public class C3237b implements C3236a {
    private final Context f7013a;
    private final String f7014b;
    private final String f7015c;

    public C3237b(C0347h c0347h) {
        if (c0347h.m402B() == null) {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        }
        this.f7013a = c0347h.m402B();
        this.f7014b = c0347h.m404D();
        this.f7015c = "Android/" + this.f7013a.getPackageName();
    }

    public File m9825a() {
        return m9826a(this.f7013a.getFilesDir());
    }

    File m9826a(File file) {
        if (file == null) {
            C3218c.m9728h().m9687a("Fabric", "Null File");
        } else if (file.exists() || file.mkdirs()) {
            return file;
        } else {
            C3218c.m9728h().m9692d("Fabric", "Couldn't create file");
        }
        return null;
    }
}
