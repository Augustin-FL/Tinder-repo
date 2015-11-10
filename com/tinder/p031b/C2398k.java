package com.tinder.p031b;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.facebook.AccessToken;
import com.facebook.share.internal.ShareConstants;
import com.tinder.enums.SqlDataType;
import com.tinder.model.Match;
import com.tinder.model.Moment;
import com.tinder.model.PhotoUser;
import com.tinder.model.ProcessedPhoto;
import com.tinder.utils.C3095y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tinder.b.k */
public class C2398k extends C2388c {
    @NonNull
    private final C2397j f4283c;

    public C2398k() {
        this.a = "photos";
        this.f4283c = new C2397j();
        this.b = new C2387a[]{new C2387a(ShareConstants.WEB_DIALOG_PARAM_ID, SqlDataType.TEXT, true), new C2387a(AccessToken.USER_ID_KEY, SqlDataType.TEXT, false), new C2387a("image_url", SqlDataType.TEXT, false), new C2387a("origin_x", SqlDataType.INTEGER, false), new C2387a("origin_y", SqlDataType.INTEGER, false), new C2387a("height", SqlDataType.INTEGER, false), new C2387a("width", SqlDataType.INTEGER, false), new C2387a("xoffset_percent", SqlDataType.REAL, false), new C2387a("yoffset_percent", SqlDataType.REAL, false), new C2387a("xdistance_percent", SqlDataType.REAL, false), new C2387a("ydistance_percent", SqlDataType.REAL, false), new C2387a("photo_order", SqlDataType.INTEGER, false)};
    }

    @NonNull
    public static String m6550b() {
        return "photos";
    }

    @NonNull
    public static ContentValues m6549a(@NonNull PhotoUser photoUser, String str, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ShareConstants.WEB_DIALOG_PARAM_ID, photoUser.getPhotoId());
        contentValues.put(AccessToken.USER_ID_KEY, str);
        contentValues.put("image_url", photoUser.getImageUrl());
        contentValues.put("origin_x", Integer.valueOf(photoUser.getOriginX()));
        contentValues.put("origin_y", Integer.valueOf(photoUser.getOriginY()));
        contentValues.put("height", Integer.valueOf(photoUser.getHeight()));
        contentValues.put("width", Integer.valueOf(photoUser.getWidth()));
        contentValues.put("xoffset_percent", Float.valueOf(photoUser.getXOffsetPercent()));
        contentValues.put("yoffset_percent", Float.valueOf(photoUser.getYOffsetPercent()));
        contentValues.put("photo_order", Integer.valueOf(i));
        return contentValues;
    }

    public void m6555b(@NonNull PhotoUser photoUser, String str, int i) {
        C2405q.m6574a().m6583a(this.a, C2398k.m6549a(photoUser, str, i));
        this.f4283c.m6544a(photoUser.getProcessedPhotos(), photoUser.getPhotoId());
    }

    public void m6552a(@NonNull ArrayList<PhotoUser> arrayList, String str) {
        for (int i = 0; i < arrayList.size(); i++) {
            m6555b((PhotoUser) arrayList.get(i), str, i);
        }
    }

    public void m6551a(String str) {
        C2405q.m6574a().m6581a(this.a, AccessToken.USER_ID_KEY, str);
        this.f4283c.m6543a(str);
    }

    public void m6553a(@NonNull Map<String, Match> map) {
        Cursor query;
        OutOfMemoryError e;
        Cursor cursor;
        Throwable th;
        Exception e2;
        Map c = this.f4283c.m6548c();
        try {
            query = C2405q.m6574a().m6587b().query(this.a, new String[]{"*"}, null, null, null, null, "photo_order");
            try {
                if (query.getCount() > 0) {
                    while (query.moveToNext()) {
                        String string = query.getString(0);
                        String string2 = query.getString(1);
                        String string3 = query.getString(2);
                        int i = query.getInt(3);
                        int i2 = query.getInt(4);
                        int i3 = query.getInt(5);
                        PhotoUser photoUser = new PhotoUser(string3, string, query.getInt(6), i3, query.getFloat(9), query.getFloat(10), query.getFloat(7), query.getFloat(8), i, i2, (List) c.get(string));
                        Match match = (Match) map.get(string2);
                        if (match != null) {
                            match.addPhoto(photoUser);
                        }
                    }
                }
                C2404p.m6572a(query);
            } catch (OutOfMemoryError e3) {
                e = e3;
                cursor = query;
                try {
                    C3095y.m9479c(e.getMessage());
                    C2404p.m6572a(cursor);
                } catch (Throwable th2) {
                    th = th2;
                    query = cursor;
                    C2404p.m6572a(query);
                    throw th;
                }
            } catch (Exception e4) {
                e2 = e4;
                try {
                    C3095y.m9479c(e2.getMessage());
                    C2404p.m6572a(query);
                } catch (Throwable th3) {
                    th = th3;
                    C2404p.m6572a(query);
                    throw th;
                }
            }
        } catch (OutOfMemoryError e5) {
            e = e5;
            cursor = null;
            C3095y.m9479c(e.getMessage());
            C2404p.m6572a(cursor);
        } catch (Exception e6) {
            e2 = e6;
            query = null;
            C3095y.m9479c(e2.getMessage());
            C2404p.m6572a(query);
        } catch (Throwable th4) {
            th = th4;
            query = null;
            C2404p.m6572a(query);
            throw th;
        }
    }

    public void m6556b(@NonNull Map<String, List<Moment>> map) {
        OutOfMemoryError e;
        Cursor cursor;
        Throwable th;
        Exception e2;
        Map c = this.f4283c.m6548c();
        Cursor query;
        try {
            query = C2405q.m6574a().m6587b().query(this.a, new String[]{"*"}, null, null, null, null, "photo_order");
            try {
                if (query.getCount() > 0) {
                    while (query.moveToNext()) {
                        String string = query.getString(0);
                        String string2 = query.getString(1);
                        String string3 = query.getString(2);
                        int i = query.getInt(3);
                        int i2 = query.getInt(4);
                        int i3 = query.getInt(5);
                        PhotoUser photoUser = new PhotoUser(string3, string, query.getInt(6), i3, query.getFloat(9), query.getFloat(10), query.getFloat(7), query.getFloat(8), i, i2, (List) c.get(string));
                        if (map.containsKey(string2)) {
                            for (Moment moment : (List) map.get(string2)) {
                                if (!(moment == null || moment.getPerson() == null)) {
                                    moment.getPerson().addPhoto(photoUser);
                                }
                            }
                        }
                    }
                }
                C2404p.m6572a(query);
            } catch (OutOfMemoryError e3) {
                e = e3;
                cursor = query;
                try {
                    C3095y.m9479c(e.getMessage());
                    C2404p.m6572a(cursor);
                } catch (Throwable th2) {
                    th = th2;
                    query = cursor;
                    C2404p.m6572a(query);
                    throw th;
                }
            } catch (Exception e4) {
                e2 = e4;
                try {
                    C3095y.m9479c(e2.getMessage());
                    C2404p.m6572a(query);
                } catch (Throwable th3) {
                    th = th3;
                    C2404p.m6572a(query);
                    throw th;
                }
            }
        } catch (OutOfMemoryError e5) {
            e = e5;
            cursor = null;
            C3095y.m9479c(e.getMessage());
            C2404p.m6572a(cursor);
        } catch (Exception e6) {
            e2 = e6;
            query = null;
            C3095y.m9479c(e2.getMessage());
            C2404p.m6572a(query);
        } catch (Throwable th4) {
            th = th4;
            query = null;
            C2404p.m6572a(query);
            throw th;
        }
    }

    @NonNull
    public ArrayList<PhotoUser> m6554b(@Nullable String str) {
        Exception e;
        Cursor cursor;
        Throwable th;
        C3095y.m9471a("userId=" + str);
        ArrayList<PhotoUser> arrayList = new ArrayList();
        Cursor query;
        try {
            query = C2405q.m6574a().m6587b().query(this.a, new String[]{"*"}, "user_id='" + str + '\'', null, null, null, "photo_order");
            if (str != null) {
                try {
                    if (query.getCount() > 0) {
                        query.moveToFirst();
                        while (!query.isAfterLast()) {
                            String string = query.getString(0);
                            String string2 = query.getString(2);
                            int i = query.getInt(3);
                            int i2 = query.getInt(4);
                            int i3 = query.getInt(5);
                            int i4 = query.getInt(6);
                            float f = query.getFloat(7);
                            float f2 = query.getFloat(8);
                            float f3 = query.getFloat(9);
                            float f4 = query.getFloat(10);
                            query.moveToNext();
                            arrayList.add(new PhotoUser(string2, string, i4, i3, f3, f4, f, f2, i, i2, this.f4283c.m6547c(string)));
                        }
                        if (!(query == null || query.isClosed())) {
                            query.close();
                        }
                        return arrayList;
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursor = query;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            C3095y.m9471a("userId null or nothing in DB, trying old data model");
            List<ProcessedPhoto> b = this.f4283c.m6545b(str);
            HashMap hashMap = new HashMap();
            for (ProcessedPhoto processedPhoto : b) {
                PhotoUser photoUser;
                String photoId = processedPhoto.getPhotoId();
                if (hashMap.containsKey(photoId)) {
                    photoUser = (PhotoUser) hashMap.get(photoId);
                } else {
                    photoUser = new PhotoUser(photoId);
                }
                photoUser.addProcessedPhoto(processedPhoto);
                hashMap.put(photoId, photoUser);
            }
            for (PhotoUser add : hashMap.values()) {
                arrayList.add(add);
            }
            query.close();
        } catch (Exception e3) {
            e = e3;
            cursor = null;
            try {
                C3095y.m9479c(e.getMessage());
                if (!(cursor == null || cursor.isClosed())) {
                    cursor.close();
                }
                return arrayList;
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
        return arrayList;
    }
}
