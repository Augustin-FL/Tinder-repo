package com.tinder.p031b;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.NonNull;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.Gson;
import com.tinder.enums.SqlDataType;
import com.tinder.model.SparksEvent;
import com.tinder.utils.C3095y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.tinder.b.b */
public class C2389b extends C2388c {
    private static Gson f4278c;

    public C2389b() {
        this.a = "analytics_events";
        this.b = new C2387a[]{new C2387a("timestamp", SqlDataType.INTEGER, true), new C2387a(ShareConstants.WEB_DIALOG_PARAM_NAME, SqlDataType.TEXT, false), new C2387a(NativeProtocol.WEB_DIALOG_PARAMS, SqlDataType.TEXT, false)};
        f4278c = new Gson();
    }

    @NonNull
    private static ContentValues m6498c(@NonNull SparksEvent sparksEvent) {
        C3095y.m9471a(String.valueOf(sparksEvent));
        ContentValues contentValues = new ContentValues();
        contentValues.put("timestamp", Long.valueOf(sparksEvent.getTimestamp()));
        contentValues.put(ShareConstants.WEB_DIALOG_PARAM_NAME, sparksEvent.getName());
        contentValues.put(NativeProtocol.WEB_DIALOG_PARAMS, f4278c.toJson(sparksEvent.getParams()));
        return contentValues;
    }

    public synchronized void m6500a(@NonNull SparksEvent sparksEvent) {
        C2405q.m6574a().m6583a("analytics_events", C2389b.m6498c(sparksEvent));
    }

    @NonNull
    public ArrayList<SparksEvent> m6499a(int i) {
        Cursor a;
        ArrayList<SparksEvent> arrayList = new ArrayList();
        if (i == -1) {
            a = C2405q.m6574a().m6577a(this.a, "timestamp ASC");
        } else {
            a = C2405q.m6574a().m6578a(this.a, "timestamp ASC", i);
        }
        while (a.moveToNext()) {
            try {
                long j = a.getLong(0);
                arrayList.add(new SparksEvent(a.getString(1), j, (HashMap) f4278c.fromJson(a.getString(2), new HashMap().getClass())));
            } finally {
                C2404p.m6572a(a);
            }
        }
        return arrayList;
    }

    public void m6501a(@NonNull List<SparksEvent> list) {
        C3095y.m9471a("Deleting sparks events");
        ArrayList arrayList = new ArrayList();
        for (SparksEvent timestamp : list) {
            arrayList.add(Long.valueOf(timestamp.getTimestamp()));
        }
        C2405q.m6574a().m6588b(this.a, "timestamp", arrayList);
    }

    public void m6502b(@NonNull SparksEvent sparksEvent) {
        C2405q.m6574a().m6581a(this.a, "timestamp", String.valueOf(sparksEvent.getTimestamp()));
    }
}
