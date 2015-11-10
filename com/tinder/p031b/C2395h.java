package com.tinder.p031b;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.NonNull;
import com.facebook.AccessToken;
import com.facebook.share.internal.ShareConstants;
import com.tinder.enums.MomentAction;
import com.tinder.enums.SqlDataType;
import com.tinder.model.Moment;
import com.tinder.model.Moment.RatedType;
import com.tinder.model.Person;
import com.tinder.model.PhotoMoment;
import com.tinder.model.User;
import com.tinder.utils.C3095y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.tinder.b.h */
public class C2395h extends C2388c {
    private static C2396i f4281c;
    private static C2394g f4282d;

    public C2395h() {
        this.a = "moments";
        f4281c = new C2396i();
        f4282d = new C2394g();
        this.b = new C2387a[]{new C2387a(ShareConstants.WEB_DIALOG_PARAM_ID, SqlDataType.TEXT, true), new C2387a(AccessToken.USER_ID_KEY, SqlDataType.TEXT, false), new C2387a("created", SqlDataType.INTEGER, false), new C2387a("text", SqlDataType.TEXT, false), new C2387a("photo_id", SqlDataType.TEXT, false), new C2387a("filter", SqlDataType.TEXT, false), new C2387a("text_alignment", SqlDataType.TEXT, false), new C2387a("text_size", SqlDataType.TEXT, false), new C2387a("text_height", SqlDataType.TEXT, false), new C2387a("is_pending", SqlDataType.BOOLEAN, false), new C2387a("has_failed", SqlDataType.BOOLEAN, false), new C2387a("rated_type", SqlDataType.INTEGER, false), new C2387a("num_likes", SqlDataType.INTEGER, false)};
    }

    public static boolean m6534a(@NonNull List<Moment> list) {
        List arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List arrayList3 = new ArrayList();
        try {
            for (Moment moment : list) {
                arrayList.add(C2395h.m6535b(moment));
                if (moment.getMomentPhoto() != null) {
                    arrayList2.add(moment.getMomentPhoto());
                }
                arrayList3.addAll(moment.getMomentLikes());
            }
        } catch (Exception e) {
            C3095y.m9479c(e.getMessage());
        }
        return C2394g.m6523a(arrayList3) && C2405q.m6574a().m6584a("moments", arrayList) && C2396i.m6538a(arrayList2);
    }

    public static boolean m6533a(@NonNull Moment moment) {
        C3095y.m9485e("momentToAdd=" + moment);
        try {
            ContentValues b = C2395h.m6535b(moment);
            C2394g.m6523a(moment.getMomentLikes());
            C2405q.m6574a().m6583a("moments", b);
            if (moment.getMomentPhoto() != null) {
                f4281c.m6540b(moment.getMomentPhoto());
            }
            return true;
        } catch (Throwable e) {
            C3095y.m9474a("Failed to insert moment into database", e);
            return false;
        }
    }

    @NonNull
    public static ArrayList<Moment> m6529a(@NonNull User user, boolean z) {
        C3095y.m9471a("isGettingMyMoments=" + z);
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        ArrayList<Moment> arrayList = new ArrayList();
        Cursor a = C2405q.m6574a().m6577a("moments", "created DESC");
        while (a.moveToNext()) {
            try {
                Moment a2 = C2395h.m6528a(a);
                boolean equals = a2.getUserId().equals(user.getId());
                String userId = a2.getUserId();
                if (z && equals) {
                    if (!hashMap.containsKey(userId)) {
                        hashMap.put(userId, new ArrayList());
                    }
                    hashMap2.put(a2.getId(), a2);
                    ((List) hashMap.get(userId)).add(a2);
                    arrayList.add(a2);
                } else if (z || equals) {
                    C3095y.m9479c("Didn't add moment! gettingMyMoments: " + z + ", isUSerMoment: " + equals);
                } else {
                    if (!hashMap.containsKey(userId)) {
                        hashMap.put(userId, new ArrayList());
                    }
                    hashMap2.put(a2.getId(), a2);
                    ((List) hashMap.get(userId)).add(a2);
                    arrayList.add(a2);
                }
            } catch (Throwable e) {
                C3095y.m9474a("Failed to save moment in database", e);
            } finally {
                C2404p.m6572a(a);
            }
        }
        Person person = new Person(user.getId(), user.getName(), user.getPhotos(), user.getGender(), user.isVerified());
        if (z) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((Moment) it.next()).setPerson(person);
            }
        } else {
            C2392e.m6506a(hashMap);
            new C2398k().m6556b(hashMap);
        }
        C2394g.m6521a(hashMap2);
        return arrayList;
    }

    @NonNull
    private static Moment m6528a(@NonNull Cursor cursor) throws Exception {
        String string = cursor.getString(0);
        String string2 = cursor.getString(1);
        long j = cursor.getLong(2);
        String string3 = cursor.getString(3);
        String string4 = cursor.getString(4);
        String string5 = cursor.getString(5);
        String string6 = cursor.getString(6);
        String string7 = cursor.getString(7);
        String string8 = cursor.getString(8);
        boolean z = cursor.getInt(9) == 1;
        boolean z2 = cursor.getInt(10) == 1;
        int i = cursor.getInt(11);
        Moment moment = new Moment(string, string2, j, string3, f4281c.m6539a(string4), string5, string6, string7, string8, C2394g.m6520a(string), z, MomentAction.CREATE, cursor.getInt(12));
        moment.setHasFailed(z2);
        moment.setRatedType(RatedType.values()[i]);
        return moment;
    }

    @NonNull
    private static ContentValues m6535b(@NonNull Moment moment) throws Exception {
        ContentValues contentValues = new ContentValues();
        if (moment.isPending()) {
            contentValues.put(ShareConstants.WEB_DIALOG_PARAM_ID, Long.valueOf(moment.getCreatedTime()));
        } else {
            contentValues.put(ShareConstants.WEB_DIALOG_PARAM_ID, moment.getId());
        }
        contentValues.put(AccessToken.USER_ID_KEY, moment.getUserId());
        contentValues.put("created", Long.valueOf(moment.getCreatedTime()));
        contentValues.put("text", moment.getText());
        PhotoMoment momentPhoto = moment.getMomentPhoto();
        if (momentPhoto != null) {
            contentValues.put("photo_id", momentPhoto.getPhotoId());
        }
        contentValues.put("filter", moment.getFilter());
        contentValues.put("text_alignment", moment.getAlignment());
        contentValues.put("text_size", moment.getSize());
        contentValues.put("text_height", moment.getHeight());
        contentValues.put("is_pending", Boolean.valueOf(moment.isPending()));
        contentValues.put("has_failed", Boolean.valueOf(moment.hasFailed()));
        contentValues.put("num_likes", Integer.valueOf(moment.getNumLikes()));
        contentValues.put("rated_type", Integer.valueOf(moment.getRatedType().ordinal()));
        return contentValues;
    }

    public static void m6531a(String str) {
        C3095y.m9471a("userId=" + str);
        String str2 = "user_id != '" + str + "' and " + "created" + " < " + (System.currentTimeMillis() - 86400000);
        C3095y.m9471a("delete query = " + str2);
        C3095y.m9471a("numDeleted=" + C2405q.m6574a().m6587b().delete("moments", str2, null));
    }

    public static void m6536b(String str) {
        C3095y.m9471a("momentId=" + str);
        C2405q.m6574a().m6581a("moments", ShareConstants.WEB_DIALOG_PARAM_ID, str);
    }

    public static void m6530a(long j, String str) {
        C3095y.m9471a("timeCreated=" + j);
        String str2 = "user_id = '" + str + "' and " + "created" + " = " + j;
        C3095y.m9471a("delete query = " + str2);
        C3095y.m9471a("numDeleted=" + C2405q.m6574a().m6587b().delete("moments", str2, null));
    }

    public static void m6532a(@NonNull ArrayList<String> arrayList) {
        C3095y.m9469a();
        C2405q.m6574a().m6582a("moments", ShareConstants.WEB_DIALOG_PARAM_ID, (ArrayList) arrayList);
    }
}
