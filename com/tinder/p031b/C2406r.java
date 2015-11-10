package com.tinder.p031b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tinder.enums.SqlDataType;
import com.tinder.utils.C3095y;

/* renamed from: com.tinder.b.r */
public class C2406r extends C2388c {
    private final String f4303c;

    public C2406r() {
        this.f4303c = "TS";
        this.a = "CRASHES";
        this.b = new C2387a[]{new C2387a("TS", SqlDataType.INTEGER, true)};
    }

    public void m6592a(long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("TS", new Long(j));
        C2405q.m6574a().m6583a(this.a, contentValues);
    }

    public int m6591a(long j, long j2) {
        Cursor rawQuery = C2405q.m6574a().m6587b().rawQuery("SELECT * FROM CRASHES where TS BETWEEN ? AND ?", new String[]{String.valueOf(j), String.valueOf(j2)});
        int count = rawQuery.getCount();
        C3095y.m9471a("count " + count + " between " + r0 + " and " + r1);
        C2404p.m6572a(rawQuery);
        return count;
    }
}
