package com.tinder.utils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.android.volley.AuthFailureError;
import com.android.volley.C0307i.C0305a;
import com.android.volley.C0307i.C0306b;
import com.android.volley.Request.Priority;
import com.google.gson.stream.JsonReader;
import com.tinder.managers.C2855f.C2854d;
import com.tinder.managers.ManagerApp;
import java.util.Date;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class ak extends C3052t<C2854d> {
    private static final Pattern f6560b;

    @NonNull
    public /* synthetic */ Object m9253a(@NonNull JsonReader jsonReader) throws Exception {
        return m9254b(jsonReader);
    }

    static {
        f6560b = Pattern.compile("^.*matches\\[\\d\\]$");
    }

    public ak(int i, @NonNull String str, @Nullable String str2, @NonNull C0306b<C2854d> c0306b, @NonNull C0305a c0305a) {
        super(i, str, str2, c0306b, c0305a);
    }

    @NonNull
    public Priority m9257s() {
        return Priority.HIGH;
    }

    @NonNull
    public byte[] m9256q() throws AuthFailureError {
        JSONObject jSONObject = new JSONObject();
        try {
            Date S = ManagerApp.m7914e().m8815S();
            boolean b = ManagerApp.m7925p().m8285b();
            boolean j = ManagerApp.m7925p().m8295j();
            if (!(S == null || j || !b)) {
                jSONObject.put("last_activity_date", C3070i.m9369b().format(S));
            }
        } catch (Throwable e) {
            C3095y.m9474a("Failed to load last activity date", e);
        }
        return jSONObject.toString().getBytes();
    }

    @NonNull
    public String m9255p() {
        return "application/json";
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.support.annotation.NonNull
    public com.tinder.managers.C2855f.C2854d m9254b(@android.support.annotation.NonNull com.google.gson.stream.JsonReader r6) throws java.lang.Exception {
        /*
        r5 = this;
        r1 = 0;
        com.tinder.utils.C3095y.m9469a();
        r2 = new com.tinder.managers.f$d;
        r2.<init>();
        r6.beginObject();	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
    L_0x000c:
        r0 = r6.hasNext();	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
        if (r0 == 0) goto L_0x00f9;
    L_0x0012:
        r3 = r6.nextName();	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
        r0 = -1;
        r4 = r3.hashCode();	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
        switch(r4) {
            case -1386164858: goto L_0x0039;
            case 492793077: goto L_0x0043;
            case 840862003: goto L_0x002f;
            default: goto L_0x001e;
        };	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
    L_0x001e:
        switch(r0) {
            case 0: goto L_0x004d;
            case 1: goto L_0x00ae;
            case 2: goto L_0x00e4;
            default: goto L_0x0021;
        };	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
    L_0x0021:
        r6.skipValue();	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
        goto L_0x000c;
    L_0x0025:
        r0 = move-exception;
        java.lang.System.gc();
        r1 = "Failed to parse match response, out of memory.";
        com.tinder.utils.C3095y.m9474a(r1, r0);
    L_0x002e:
        return r2;
    L_0x002f:
        r4 = "matches";
        r3 = r3.equals(r4);	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
        if (r3 == 0) goto L_0x001e;
    L_0x0037:
        r0 = r1;
        goto L_0x001e;
    L_0x0039:
        r4 = "blocks";
        r3 = r3.equals(r4);	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
        if (r3 == 0) goto L_0x001e;
    L_0x0041:
        r0 = 1;
        goto L_0x001e;
    L_0x0043:
        r4 = "last_activity_date";
        r3 = r3.equals(r4);	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
        if (r3 == 0) goto L_0x001e;
    L_0x004b:
        r0 = 2;
        goto L_0x001e;
    L_0x004d:
        r6.beginArray();	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
        r0 = com.tinder.managers.ManagerApp.m7925p();	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
        r0 = r0.m8295j();	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
        if (r0 == 0) goto L_0x0062;
    L_0x005a:
        r0 = com.tinder.managers.ManagerApp.m7925p();	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
        r3 = 0;
        r0.m8284b(r3);	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
    L_0x0062:
        r0 = r6.hasNext();	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
        if (r0 == 0) goto L_0x00a2;
    L_0x0068:
        r0 = "Match found!";
        com.tinder.utils.C3095y.m9471a(r0);	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
        r0 = com.tinder.parse.C2974c.m8914a(r6);	 Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x0025, IOException -> 0x00a7 }
        r3 = r2.f5854a;	 Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x0025, IOException -> 0x00a7 }
        r3.add(r0);	 Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x0025, IOException -> 0x00a7 }
        goto L_0x0062;
    L_0x0077:
        r0 = move-exception;
        r3 = "Failed to parse match";
        com.tinder.utils.C3095y.m9474a(r3, r0);	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
        r0 = r6.getPath();	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
    L_0x0081:
        if (r0 == 0) goto L_0x0062;
    L_0x0083:
        r3 = f6560b;	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
        r0 = r3.matcher(r0);	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
        r0 = r0.matches();	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
        if (r0 != 0) goto L_0x0062;
    L_0x008f:
        r6.skipValue();	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
        r0 = r6.peek();	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
        r3 = com.google.gson.stream.JsonToken.END_OBJECT;	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
        if (r0 != r3) goto L_0x009d;
    L_0x009a:
        r6.endObject();	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
    L_0x009d:
        r0 = r6.getPath();	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
        goto L_0x0081;
    L_0x00a2:
        r6.endArray();	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
        goto L_0x000c;
    L_0x00a7:
        r0 = move-exception;
        r1 = "Failed to parse match response.";
        com.tinder.utils.C3095y.m9474a(r1, r0);
        goto L_0x002e;
    L_0x00ae:
        r6.beginArray();	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
    L_0x00b1:
        r0 = r6.hasNext();	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
        if (r0 == 0) goto L_0x00df;
    L_0x00b7:
        r0 = r6.nextString();	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
        r3 = new java.lang.StringBuilder;	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
        r3.<init>();	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
        r4 = "blocked matchId=";
        r3 = r3.append(r4);	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
        r3 = r3.append(r0);	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
        r3 = r3.toString();	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
        com.tinder.utils.C3095y.m9471a(r3);	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
        r3 = r2.f5855b;	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
        r3.add(r0);	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
        goto L_0x00b1;
    L_0x00d7:
        r0 = move-exception;
        r1 = "Failed to parse match response, random error.";
        com.tinder.utils.C3095y.m9474a(r1, r0);
        goto L_0x002e;
    L_0x00df:
        r6.endArray();	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
        goto L_0x000c;
    L_0x00e4:
        r0 = r6.nextString();	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
        r3 = com.tinder.utils.C3070i.m9366a();	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
        r0 = r3.parse(r0);	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
        r3 = com.tinder.managers.ManagerApp.m7925p();	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
        r3.m8283b(r0);	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
        goto L_0x000c;
    L_0x00f9:
        r6.endObject();	 Catch:{ OutOfMemoryError -> 0x0025, IOException -> 0x00a7, Exception -> 0x00d7 }
        goto L_0x002e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tinder.utils.ak.b(com.google.gson.stream.JsonReader):com.tinder.managers.f$d");
    }
}
