package com.tinder.p031b;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.NonNull;
import com.facebook.share.internal.ShareConstants;
import com.tinder.enums.SqlDataType;
import com.tinder.utils.C3095y;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tinder.b.m */
public class C2401m extends C2388c {
    public C2401m() {
        this.a = "recommendations";
        this.b = new C2387a[]{new C2387a(ShareConstants.WEB_DIALOG_PARAM_ID, SqlDataType.TEXT, true), new C2387a("is_superlike", SqlDataType.BOOLEAN, false)};
    }

    @NonNull
    public static Map<String, Boolean> m6562b() {
        Map<String, Boolean> hashMap = new HashMap();
        Cursor cursor = null;
        try {
            cursor = C2405q.m6574a().m6576a("recommendations");
            while (cursor.moveToNext()) {
                hashMap.put(cursor.getString(0), Boolean.valueOf(cursor.getInt(1) == 1));
            }
            C3095y.m9485e("fetched " + hashMap.size() + " past rec ids");
            return hashMap;
        } finally {
            if (!(cursor == null || cursor.isClosed())) {
                cursor.close();
            }
        }
    }

    public static boolean m6561a(String str, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ShareConstants.WEB_DIALOG_PARAM_ID, str);
        contentValues.put("is_superlike", Boolean.valueOf(z));
        return C2405q.m6574a().m6583a("recommendations", contentValues);
    }

    public static void m6560a(String str) {
        C3095y.m9471a("delete recId=" + str);
        C2405q.m6574a().m6581a("recommendations", ShareConstants.WEB_DIALOG_PARAM_ID, str);
    }
}
