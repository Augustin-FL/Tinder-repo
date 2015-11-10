package io.fabric.sdk.android.services.settings;

import io.fabric.sdk.android.C0347h;
import io.fabric.sdk.android.C3218c;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.p035c.C3237b;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import org.json.JSONObject;

/* renamed from: io.fabric.sdk.android.services.settings.i */
class C3308i implements C3306g {
    private final C0347h f7214a;

    public C3308i(C0347h c0347h) {
        this.f7214a = c0347h;
    }

    public JSONObject m10104a() {
        Closeable fileInputStream;
        Throwable e;
        Closeable closeable = null;
        C3218c.m9728h().m9687a("Fabric", "Reading cached settings...");
        try {
            JSONObject jSONObject;
            File file = new File(new C3237b(this.f7214a).m9825a(), "com.crashlytics.settings.json");
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    jSONObject = new JSONObject(CommonUtils.m9843a((InputStream) fileInputStream));
                    closeable = fileInputStream;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C3218c.m9728h().m9695e("Fabric", "Failed to fetch cached settings", e);
                        CommonUtils.m9855a(fileInputStream, "Error while closing settings cache file.");
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        closeable = fileInputStream;
                        CommonUtils.m9855a(closeable, "Error while closing settings cache file.");
                        throw e;
                    }
                }
            }
            C3218c.m9728h().m9687a("Fabric", "No cached settings found.");
            jSONObject = null;
            CommonUtils.m9855a(closeable, "Error while closing settings cache file.");
            return jSONObject;
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            C3218c.m9728h().m9695e("Fabric", "Failed to fetch cached settings", e);
            CommonUtils.m9855a(fileInputStream, "Error while closing settings cache file.");
            return null;
        } catch (Throwable th2) {
            e = th2;
            CommonUtils.m9855a(closeable, "Error while closing settings cache file.");
            throw e;
        }
    }

    public void m10105a(long j, JSONObject jSONObject) {
        Closeable fileWriter;
        Throwable e;
        C3218c.m9728h().m9687a("Fabric", "Writing settings to cache file...");
        if (jSONObject != null) {
            Closeable closeable = null;
            try {
                jSONObject.put("expires_at", j);
                fileWriter = new FileWriter(new File(new C3237b(this.f7214a).m9825a(), "com.crashlytics.settings.json"));
                try {
                    fileWriter.write(jSONObject.toString());
                    fileWriter.flush();
                    CommonUtils.m9855a(fileWriter, "Failed to close settings writer.");
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C3218c.m9728h().m9695e("Fabric", "Failed to cache settings", e);
                        CommonUtils.m9855a(fileWriter, "Failed to close settings writer.");
                    } catch (Throwable th) {
                        e = th;
                        closeable = fileWriter;
                        CommonUtils.m9855a(closeable, "Failed to close settings writer.");
                        throw e;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileWriter = null;
                C3218c.m9728h().m9695e("Fabric", "Failed to cache settings", e);
                CommonUtils.m9855a(fileWriter, "Failed to close settings writer.");
            } catch (Throwable th2) {
                e = th2;
                CommonUtils.m9855a(closeable, "Failed to close settings writer.");
                throw e;
            }
        }
    }
}
