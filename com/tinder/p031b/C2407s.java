package com.tinder.p031b;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.internal.ServerProtocol;
import com.tinder.enums.SqlDataType;
import com.tinder.model.Session;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* renamed from: com.tinder.b.s */
public class C2407s extends C2388c {
    private String f4304c;
    private String f4305d;
    private String f4306e;
    private SimpleDateFormat f4307f;

    public C2407s() {
        this.f4304c = "SESSIONS";
        this.f4305d = "date";
        this.f4306e = ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION;
        this.a = this.f4304c;
        this.b = new C2387a[]{new C2387a(this.f4305d, SqlDataType.DATETIME, true), new C2387a(this.f4306e, SqlDataType.TEXT, false)};
        this.f4307f = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    }

    public int m6593b() {
        Cursor a = C2405q.m6574a().m6576a(this.a);
        int count = a.getCount();
        C2404p.m6572a(a);
        return count;
    }

    public void m6594c() {
        Session instance = Session.getInstance();
        String format = this.f4307f.format(Long.valueOf(instance.getOpenDate()));
        String appVersion = instance.getAppVersion();
        ContentValues contentValues = new ContentValues();
        contentValues.put(this.f4305d, format);
        contentValues.put(this.f4306e, appVersion);
        C2405q.m6574a().m6583a(this.a, contentValues);
    }
}
