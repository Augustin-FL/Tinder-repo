package com.tinder.p031b;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.facebook.AccessToken;
import com.facebook.share.internal.ShareConstants;
import com.tinder.enums.SqlDataType;
import com.tinder.model.ProcessedPhoto;
import com.tinder.utils.C3095y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tinder.b.j */
public class C2397j extends C2388c {
    public C2397j() {
        this.a = "photos_processed";
        this.b = new C2387a[]{new C2387a(ShareConstants.WEB_DIALOG_PARAM_ID, SqlDataType.TEXT, false), new C2387a(AccessToken.USER_ID_KEY, SqlDataType.TEXT, false), new C2387a("position", SqlDataType.INTEGER, false), new C2387a("image_url", SqlDataType.TEXT, false), new C2387a("height", SqlDataType.INTEGER, false), new C2387a("width", SqlDataType.INTEGER, false), new C2387a("unique_id", SqlDataType.TEXT, true)};
    }

    @NonNull
    public static ContentValues m6541a(@NonNull ProcessedPhoto processedPhoto) {
        ContentValues contentValues = new ContentValues(6);
        contentValues.put(ShareConstants.WEB_DIALOG_PARAM_ID, processedPhoto.getPhotoId());
        contentValues.put(AccessToken.USER_ID_KEY, processedPhoto.getUserId());
        contentValues.put("image_url", processedPhoto.getImageUrl());
        contentValues.put("height", Integer.valueOf(processedPhoto.getHeight()));
        contentValues.put("width", Integer.valueOf(processedPhoto.getWidth()));
        contentValues.put("unique_id", processedPhoto.getPhotoId() + processedPhoto.getWidth());
        return contentValues;
    }

    @NonNull
    public static String m6542b() {
        return "photos_processed";
    }

    public void m6546b(@NonNull ProcessedPhoto processedPhoto) {
        C2405q.m6574a().m6583a(this.a, C2397j.m6541a(processedPhoto));
    }

    public void m6543a(String str) {
        C2405q.m6574a().m6581a(this.a, AccessToken.USER_ID_KEY, str);
    }

    @NonNull
    public List<ProcessedPhoto> m6545b(String str) {
        Throwable th;
        Cursor cursor = null;
        List<ProcessedPhoto> arrayList = new ArrayList();
        try {
            Cursor b = C2405q.m6574a().m6586b(this.a, "user_id='" + str + '\'');
            while (b.moveToNext()) {
                try {
                    arrayList.add(new ProcessedPhoto(b.getString(0), str, b.getString(3), b.getInt(5), b.getInt(4)));
                } catch (Throwable th2) {
                    th = th2;
                    cursor = b;
                }
            }
            if (!(b == null || b.isClosed())) {
                b.close();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            if (!(cursor == null || cursor.isClosed())) {
                cursor.close();
            }
            throw th;
        }
    }

    public void m6544a(@NonNull List<ProcessedPhoto> list, String str) {
        C3095y.m9471a("photoId=" + str);
        for (ProcessedPhoto b : list) {
            m6546b(b);
        }
    }

    @NonNull
    public Map<String, ArrayList<ProcessedPhoto>> m6548c() {
        OutOfMemoryError e;
        Cursor cursor;
        Throwable th;
        Map<String, ArrayList<ProcessedPhoto>> hashMap = new HashMap();
        Cursor query;
        try {
            query = C2405q.m6574a().m6587b().query(this.a, new String[]{"*"}, null, null, null, null, null);
            while (query.moveToNext()) {
                try {
                    String string = query.getString(0);
                    String string2 = query.getString(1);
                    String string3 = query.getString(3);
                    int i = query.getInt(5);
                    int i2 = query.getInt(4);
                    if (!hashMap.containsKey(string)) {
                        hashMap.put(string, new ArrayList());
                    }
                    ((ArrayList) hashMap.get(string)).add(new ProcessedPhoto(string, string2, string3, i, i2));
                } catch (OutOfMemoryError e2) {
                    e = e2;
                    cursor = query;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (!(query == null || query.isClosed())) {
                query.close();
            }
        } catch (OutOfMemoryError e3) {
            e = e3;
            cursor = null;
            try {
                C3095y.m9479c(e.getMessage());
                if (!(cursor == null || cursor.isClosed())) {
                    cursor.close();
                }
                return hashMap;
            } catch (Throwable th3) {
                th = th3;
                query = cursor;
                query.close();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (!(query == null || query.isClosed())) {
                query.close();
            }
            throw th;
        }
        return hashMap;
    }

    @NonNull
    public ArrayList<ProcessedPhoto> m6547c(@Nullable String str) {
        Throwable th;
        Cursor cursor;
        C3095y.m9471a("photoId=" + str);
        ArrayList<ProcessedPhoto> arrayList = new ArrayList();
        try {
            Cursor query = C2405q.m6574a().m6587b().query(this.a, new String[]{"*"}, "id='" + str + '\'', null, null, null, null);
            if (str != null) {
                try {
                    if (query.getCount() > 0) {
                        query.moveToFirst();
                        while (!query.isAfterLast()) {
                            String string = query.getString(1);
                            String string2 = query.getString(3);
                            int i = query.getInt(5);
                            int i2 = query.getInt(4);
                            query.getInt(2);
                            query.moveToNext();
                            arrayList.add(new ProcessedPhoto(str, string, string2, i, i2));
                        }
                        if (!(query == null || query.isClosed())) {
                            query.close();
                        }
                        return arrayList;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    cursor.close();
                    throw th;
                }
            }
            C3095y.m9471a("photoId null or nothing in DB, not returning any processed photos");
            query.close();
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            if (!(cursor == null || cursor.isClosed())) {
                cursor.close();
            }
            throw th;
        }
    }
}
