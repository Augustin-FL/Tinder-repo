package com.tinder.p031b;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.NonNull;
import com.facebook.AccessToken;
import com.tinder.enums.SqlDataType;
import com.tinder.model.Match;
import com.tinder.model.Message;
import com.tinder.utils.C3070i;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tinder.b.f */
public class C2393f extends C2388c {
    public C2393f() {
        this.a = "messages";
        this.b = new C2387a[]{new C2387a(AccessToken.USER_ID_KEY, SqlDataType.TEXT, false), new C2387a("match_id", SqlDataType.TEXT, false), new C2387a("client_created", SqlDataType.BOOLEAN, false), new C2387a("created", SqlDataType.DATETIME, true), new C2387a("has_error", SqlDataType.BOOLEAN, false), new C2387a("text", SqlDataType.TEXT, false), new C2387a("viewed", SqlDataType.BOOLEAN, false)};
    }

    @NonNull
    public static ContentValues m6514a(@NonNull Message message) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(AccessToken.USER_ID_KEY, message.getFromUserId());
        contentValues.put("match_id", message.getMatchId());
        contentValues.put("created", message.getCreationDate());
        contentValues.put("text", message.getText());
        return contentValues;
    }

    @NonNull
    public static String m6515b() {
        return "messages";
    }

    public void m6518b(@NonNull Message message) {
        C2405q.m6574a().m6583a(this.a, C2393f.m6514a(message));
    }

    public void m6517a(@NonNull Map<String, Match> map) {
        Cursor a = C2405q.m6574a().m6576a(this.a);
        while (a.moveToNext()) {
            try {
                String string = a.getString(1);
                String string2 = a.getString(0);
                String string3 = a.getString(3);
                Message message = new Message(string, string3, string2, a.getString(5), false, C3070i.m9362a(string3));
                Match match = (Match) map.get(string);
                if (match != null) {
                    match.addMessage(message);
                }
            } catch (Throwable th) {
                if (!(a == null || a.isClosed())) {
                    a.close();
                }
            }
        }
        if (a != null && !a.isClosed()) {
            a.close();
        }
    }

    @NonNull
    public Set<String> m6516a(String str) {
        Cursor query;
        Throwable th;
        Set<String> hashSet = new HashSet();
        try {
            query = C2405q.m6574a().m6587b().query(this.a, new String[]{"match_id"}, "text LIKE ?", new String[]{'%' + str + '%'}, null, null, null);
            try {
                int columnIndex = query.getColumnIndex("match_id");
                while (query.moveToNext()) {
                    hashSet.add(query.getString(columnIndex));
                }
                if (!(query == null || query.isClosed())) {
                    query.close();
                }
                return hashSet;
            } catch (Throwable th2) {
                th = th2;
                if (!(query == null || query.isClosed())) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            query.close();
            throw th;
        }
    }
}
