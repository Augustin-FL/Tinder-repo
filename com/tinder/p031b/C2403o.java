package com.tinder.p031b;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.facebook.share.internal.ShareConstants;
import com.tinder.enums.Gender;
import com.tinder.enums.SqlDataType;
import com.tinder.model.User;
import com.tinder.utils.C3095y;
import java.util.Date;

/* renamed from: com.tinder.b.o */
public class C2403o extends C2388c {
    @NonNull
    private final C2398k f4285c;

    public C2403o() {
        this.a = "users";
        this.f4285c = new C2398k();
        this.b = new C2387a[]{new C2387a(ShareConstants.WEB_DIALOG_PARAM_ID, SqlDataType.TEXT, true), new C2387a("bio", SqlDataType.TEXT, false), new C2387a("birth_date", SqlDataType.DATETIME, false), new C2387a("common_friend_count", SqlDataType.INTEGER, false), new C2387a("common_like_count", SqlDataType.INTEGER, false), new C2387a("distance_miles", SqlDataType.INTEGER, false), new C2387a("downloaded", SqlDataType.BOOLEAN, false), new C2387a("failed_choice", SqlDataType.BOOLEAN, false), new C2387a("gender", SqlDataType.INTEGER, false), new C2387a("liked", SqlDataType.BOOLEAN, false), new C2387a("ping_time", SqlDataType.DATETIME, false), new C2387a("first_name", SqlDataType.TEXT, false), new C2387a("last_activity_date", SqlDataType.TEXT, false), new C2387a("traveling", SqlDataType.BOOLEAN, false), new C2387a("is_verified", SqlDataType.BOOLEAN, false), new C2387a("is_superlike", SqlDataType.BOOLEAN, false)};
    }

    public void m6570a(@NonNull User user) {
        C3095y.m9471a("user=" + user);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ShareConstants.WEB_DIALOG_PARAM_ID, user.getId());
        if (user.getBio() != null) {
            contentValues.put("bio", user.getBio());
        }
        if (user.getBirthDate() != null) {
            contentValues.put("birth_date", Long.valueOf(user.getBirthDate().getTime()));
        }
        contentValues.put("common_friend_count", Integer.valueOf(user.getCommonFriendCount()));
        contentValues.put("common_like_count", Integer.valueOf(user.getCommonLikeCount()));
        contentValues.put("distance_miles", Integer.valueOf(user.getDistanceMiles()));
        contentValues.put("gender", Integer.valueOf(user.getGender().ordinal()));
        contentValues.put("last_activity_date", user.getLastActivityDate());
        if (user.getPingTime() != null) {
            contentValues.put("ping_time", Long.valueOf(user.getPingTime().getTime()));
        }
        contentValues.put("first_name", user.getName());
        contentValues.put("traveling", Boolean.valueOf(user.isRecAndPassporting()));
        contentValues.put("is_verified", Boolean.valueOf(user.isVerified()));
        contentValues.put("is_superlike", Boolean.valueOf(user.isSuperLike()));
        C2405q.m6574a().m6583a(this.a, contentValues);
        this.f4285c.m6552a(user.getPhotos(), user.getId());
    }

    @Nullable
    public User m6569a(@Nullable String str) {
        Throwable th;
        Cursor cursor = null;
        C3095y.m9471a("userId=" + str);
        try {
            Cursor query = C2405q.m6574a().m6587b().query(this.a, new String[]{"*"}, "id='" + str + '\'', null, null, null, null);
            if (str != null) {
                try {
                    if (query.getCount() > 0) {
                        query.moveToFirst();
                        User a = m6568a(query);
                        if (query == null || query.isClosed()) {
                            return a;
                        }
                        query.close();
                        return a;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (!(cursor == null || cursor.isClosed())) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            C3095y.m9471a("userId null or nothing in DB, not returning a user");
            if (!(query == null || query.isClosed())) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            cursor.close();
            throw th;
        }
    }

    @NonNull
    private User m6568a(@NonNull Cursor cursor) {
        String string = cursor.getString(0);
        String string2 = cursor.getString(1);
        Date date = new Date(cursor.getLong(2));
        int i = cursor.getInt(5);
        Gender gender = Gender.values()[cursor.getInt(8)];
        Date date2 = new Date(cursor.getLong(10));
        String string3 = cursor.getString(11);
        String string4 = cursor.getString(12);
        boolean z = cursor.getInt(13) > 0;
        User user = new User(string2, date, string, string3, date2, i, null, gender, null, this.f4285c.m6554b(string), string4, cursor.getInt(14) > 0, cursor.getInt(15) > 0, false);
        user.setRecAndPassporting(z);
        return user;
    }
}
