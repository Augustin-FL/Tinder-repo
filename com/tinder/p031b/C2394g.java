package com.tinder.p031b;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.NonNull;
import com.tinder.enums.SqlDataType;
import com.tinder.model.Moment;
import com.tinder.model.MomentLike;
import com.tinder.utils.C3070i;
import com.tinder.utils.C3095y;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tinder.b.g */
public class C2394g extends C2388c {
    public C2394g() {
        this.a = "moment_likes";
        this.b = new C2387a[]{new C2387a("date", SqlDataType.TEXT, false), new C2387a("moment_id", SqlDataType.TEXT, false), new C2387a("liked_by_id", SqlDataType.TEXT, false), new C2387a("thumb_url", SqlDataType.TEXT, false), new C2387a("has_been_viewed", SqlDataType.BOOLEAN, false), new C2387a("mixed_id", SqlDataType.TEXT, true), new C2387a("by_user_id", SqlDataType.TEXT, false)};
    }

    public static boolean m6523a(@NonNull List<MomentLike> list) {
        List arrayList = new ArrayList();
        for (MomentLike b : list) {
            arrayList.add(C2394g.m6524b(b));
        }
        return C2405q.m6574a().m6584a("moment_likes", arrayList);
    }

    public static boolean m6522a(@NonNull MomentLike momentLike) {
        C3095y.m9485e("momentLikeToAdd=" + momentLike);
        try {
            C2405q.m6574a().m6583a("moment_likes", C2394g.m6524b(momentLike));
            return true;
        } catch (Exception e) {
            C3095y.m9479c(e.getMessage() + e.toString());
            return false;
        }
    }

    public static void m6521a(@NonNull Map<String, Moment> map) {
        Cursor a = C2405q.m6574a().m6576a("moment_likes");
        while (a.moveToNext()) {
            try {
                MomentLike a2 = C2394g.m6519a(a);
                if (map.containsKey(a2.getMomentId())) {
                    ((Moment) map.get(a2.getMomentId())).addLike(a2);
                }
            } catch (Exception e) {
                C3095y.m9479c(String.valueOf(e));
            } finally {
                a.close();
            }
        }
    }

    @NonNull
    public static ArrayList<MomentLike> m6525b() {
        ArrayList<MomentLike> arrayList = new ArrayList();
        Cursor a = C2405q.m6574a().m6577a("moment_likes", "date ASC ");
        while (a.moveToNext()) {
            try {
                arrayList.add(C2394g.m6519a(a));
            } finally {
                C2404p.m6572a(a);
            }
        }
        return arrayList;
    }

    @NonNull
    public static ArrayList<MomentLike> m6520a(String str) {
        ArrayList<MomentLike> arrayList = new ArrayList();
        Cursor b = C2405q.m6574a().m6586b("moment_likes", "moment_id='" + str + "'");
        while (b.moveToNext()) {
            try {
                arrayList.add(C2394g.m6519a(b));
            } finally {
                C2404p.m6572a(b);
            }
        }
        return arrayList;
    }

    @NonNull
    private static MomentLike m6519a(@NonNull Cursor cursor) {
        String string = cursor.getString(0);
        String string2 = cursor.getString(1);
        String string3 = cursor.getString(2);
        String string4 = cursor.getString(3);
        String string5 = cursor.getString(6);
        MomentLike momentLike = new MomentLike(string, string2, string3, string4, C3070i.m9362a(string));
        momentLike.setMomentByUserId(string5);
        return momentLike;
    }

    @NonNull
    private static ContentValues m6524b(@NonNull MomentLike momentLike) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("date", momentLike.getCreationDate());
        contentValues.put("moment_id", momentLike.getMomentId());
        contentValues.put("liked_by_id", momentLike.getLikedbyId());
        contentValues.put("thumb_url", momentLike.getThumbUrl());
        contentValues.put("mixed_id", momentLike.getMixedId());
        contentValues.put("by_user_id", momentLike.getMomentByUserId());
        return contentValues;
    }

    public static void m6526b(String str) {
        C2405q.m6574a().m6581a("moment_likes", "mixed_id", str);
    }

    public void m6527c(String str) {
        C3095y.m9471a("userId=" + str);
        C2405q.m6574a().m6581a("moment_likes", "liked_by_id", str);
    }
}
