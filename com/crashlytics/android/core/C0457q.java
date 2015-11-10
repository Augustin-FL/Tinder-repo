package com.crashlytics.android.core;

import io.fabric.sdk.android.C3218c;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.crashlytics.android.core.q */
class C0457q {
    private static final Charset f636a;
    private final File f637b;

    /* renamed from: com.crashlytics.android.core.q.1 */
    static class C04561 extends JSONObject {
        final /* synthetic */ C0483y f635a;

        C04561(C0483y c0483y) throws JSONException {
            this.f635a = c0483y;
            put("userId", this.f635a.f698b);
            put("userName", this.f635a.f699c);
            put("userEmail", this.f635a.f700d);
        }
    }

    static {
        f636a = Charset.forName(HTTP.UTF_8);
    }

    public C0457q(File file) {
        this.f637b = file;
    }

    public void m823a(String str, C0483y c0483y) {
        Closeable bufferedWriter;
        Throwable e;
        File c = m818c(str);
        Closeable closeable = null;
        try {
            String a = C0457q.m816a(c0483y);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(c), f636a));
            try {
                bufferedWriter.write(a);
                bufferedWriter.flush();
                CommonUtils.m9855a(bufferedWriter, "Failed to close user metadata file.");
            } catch (Exception e2) {
                e = e2;
                try {
                    C3218c.m9728h().m9695e("CrashlyticsCore", "Error serializing user metadata.", e);
                    CommonUtils.m9855a(bufferedWriter, "Failed to close user metadata file.");
                } catch (Throwable th) {
                    e = th;
                    closeable = bufferedWriter;
                    CommonUtils.m9855a(closeable, "Failed to close user metadata file.");
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            bufferedWriter = null;
            C3218c.m9728h().m9695e("CrashlyticsCore", "Error serializing user metadata.", e);
            CommonUtils.m9855a(bufferedWriter, "Failed to close user metadata file.");
        } catch (Throwable th2) {
            e = th2;
            CommonUtils.m9855a(closeable, "Failed to close user metadata file.");
            throw e;
        }
    }

    public C0483y m822a(String str) {
        Closeable fileInputStream;
        Throwable e;
        File c = m818c(str);
        if (!c.exists()) {
            return C0483y.f697a;
        }
        try {
            fileInputStream = new FileInputStream(c);
            try {
                C0483y e2 = C0457q.m820e(CommonUtils.m9843a((InputStream) fileInputStream));
                CommonUtils.m9855a(fileInputStream, "Failed to close user metadata file.");
                return e2;
            } catch (Exception e3) {
                e = e3;
                try {
                    C3218c.m9728h().m9695e("CrashlyticsCore", "Error deserializing user metadata.", e);
                    CommonUtils.m9855a(fileInputStream, "Failed to close user metadata file.");
                    return C0483y.f697a;
                } catch (Throwable th) {
                    e = th;
                    CommonUtils.m9855a(fileInputStream, "Failed to close user metadata file.");
                    throw e;
                }
            }
        } catch (Exception e4) {
            e = e4;
            fileInputStream = null;
            C3218c.m9728h().m9695e("CrashlyticsCore", "Error deserializing user metadata.", e);
            CommonUtils.m9855a(fileInputStream, "Failed to close user metadata file.");
            return C0483y.f697a;
        } catch (Throwable th2) {
            e = th2;
            fileInputStream = null;
            CommonUtils.m9855a(fileInputStream, "Failed to close user metadata file.");
            throw e;
        }
    }

    public Map<String, String> m824b(String str) {
        Closeable fileInputStream;
        Throwable e;
        File d = m819d(str);
        if (!d.exists()) {
            return Collections.emptyMap();
        }
        try {
            fileInputStream = new FileInputStream(d);
            try {
                Map<String, String> f = C0457q.m821f(CommonUtils.m9843a((InputStream) fileInputStream));
                CommonUtils.m9855a(fileInputStream, "Failed to close user metadata file.");
                return f;
            } catch (Exception e2) {
                e = e2;
                try {
                    C3218c.m9728h().m9695e("CrashlyticsCore", "Error deserializing user metadata.", e);
                    CommonUtils.m9855a(fileInputStream, "Failed to close user metadata file.");
                    return Collections.emptyMap();
                } catch (Throwable th) {
                    e = th;
                    CommonUtils.m9855a(fileInputStream, "Failed to close user metadata file.");
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            C3218c.m9728h().m9695e("CrashlyticsCore", "Error deserializing user metadata.", e);
            CommonUtils.m9855a(fileInputStream, "Failed to close user metadata file.");
            return Collections.emptyMap();
        } catch (Throwable th2) {
            e = th2;
            fileInputStream = null;
            CommonUtils.m9855a(fileInputStream, "Failed to close user metadata file.");
            throw e;
        }
    }

    private File m818c(String str) {
        return new File(this.f637b, str + "user" + ".meta");
    }

    private File m819d(String str) {
        return new File(this.f637b, str + "keys" + ".meta");
    }

    private static C0483y m820e(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        return new C0483y(C0457q.m817a(jSONObject, "userId"), C0457q.m817a(jSONObject, "userName"), C0457q.m817a(jSONObject, "userEmail"));
    }

    private static String m816a(C0483y c0483y) throws JSONException {
        return new C04561(c0483y).toString();
    }

    private static Map<String, String> m821f(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        Map<String, String> hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            hashMap.put(str2, C0457q.m817a(jSONObject, str2));
        }
        return hashMap;
    }

    private static String m817a(JSONObject jSONObject, String str) {
        return !jSONObject.isNull(str) ? jSONObject.optString(str, null) : null;
    }
}
