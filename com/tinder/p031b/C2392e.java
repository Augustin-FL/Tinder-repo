package com.tinder.p031b;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.NonNull;
import com.facebook.AccessToken;
import com.facebook.share.internal.ShareConstants;
import com.tinder.enums.Gender;
import com.tinder.enums.SqlDataType;
import com.tinder.managers.ManagerApp;
import com.tinder.model.Match;
import com.tinder.model.Message;
import com.tinder.model.Moment;
import com.tinder.model.Person;
import com.tinder.model.PhotoUser;
import com.tinder.model.ProcessedPhoto;
import com.tinder.utils.C3095y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tinder.b.e */
public class C2392e extends C2388c {

    /* renamed from: com.tinder.b.e.1 */
    class C23911 extends Thread {
        final /* synthetic */ Match f4279a;
        final /* synthetic */ C2392e f4280b;

        C23911(C2392e c2392e, Match match) {
            this.f4280b = c2392e;
            this.f4279a = match;
        }

        public void run() {
            C2405q.m6574a().m6583a(this.f4280b.a, C2392e.m6509d(this.f4279a));
        }
    }

    public C2392e() {
        this.a = "matches";
        this.b = new C2387a[]{new C2387a(ShareConstants.WEB_DIALOG_PARAM_ID, SqlDataType.TEXT, true), new C2387a(AccessToken.USER_ID_KEY, SqlDataType.TEXT, false), new C2387a("created", SqlDataType.DATETIME, false), new C2387a("last_activity", SqlDataType.DATETIME, false), new C2387a("server_message_count", SqlDataType.INTEGER, false), new C2387a("touched", SqlDataType.BOOLEAN, false), new C2387a("viewed", SqlDataType.BOOLEAN, false), new C2387a("user_name", SqlDataType.TEXT, false), new C2387a("draft_msg", SqlDataType.TEXT, false), new C2387a("reported_for", SqlDataType.INTEGER, false), new C2387a("gender", SqlDataType.INTEGER, false), new C2387a("following", SqlDataType.BOOLEAN, false), new C2387a("is_verified", SqlDataType.BOOLEAN, false), new C2387a("is_superlike", SqlDataType.BOOLEAN, false), new C2387a("superliker", SqlDataType.TEXT, false)};
    }

    public static void m6504a(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("draft_msg", str2);
        C2405q.m6574a().m6580a("matches", contentValues, "id='" + str + '\'');
    }

    @NonNull
    private static ContentValues m6509d(@NonNull Match match) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ShareConstants.WEB_DIALOG_PARAM_ID, match.getId());
        if (match.getPerson() != null) {
            Person person = match.getPerson();
            if (person.getId() != null) {
                contentValues.put(AccessToken.USER_ID_KEY, person.getId());
            }
            if (person.getName() != null) {
                contentValues.put("user_name", person.getName());
            }
            Gender gender = match.getPerson().getGender();
            if (gender != null) {
                contentValues.put("gender", Integer.valueOf(gender.ordinal()));
            }
            contentValues.put("is_verified", Boolean.valueOf(match.isVerified()));
        }
        contentValues.put("created", match.getCreatedDate());
        contentValues.put("last_activity", match.getLastActivityDate());
        contentValues.put("touched", Boolean.valueOf(match.wasTouched()));
        contentValues.put("viewed", Boolean.valueOf(match.wasViewed()));
        contentValues.put("draft_msg", match.getDraftMsg());
        contentValues.put("reported_for", Integer.valueOf(match.getReportedMasks()));
        contentValues.put("following", Boolean.valueOf(match.isFollowed()));
        contentValues.put("is_superlike", Boolean.valueOf(match.isSuperlike()));
        contentValues.put("superliker", match.getSuperLiker());
        return contentValues;
    }

    public static void m6506a(@NonNull Map<String, List<Moment>> map) {
        Cursor a = C2405q.m6574a().m6576a("matches");
        Gender[] values = Gender.values();
        while (a.moveToNext()) {
            try {
                String string = a.getString(1);
                String string2 = a.getString(7);
                int i = a.getInt(10);
                int i2 = a.getInt(12);
                if (map.containsKey(string)) {
                    for (Moment person : (List) map.get(string)) {
                        person.setPerson(new Person(string, string2, values[i], i2 != 0));
                    }
                }
            } finally {
                C2404p.m6572a(a);
            }
        }
    }

    public static void m6505a(String str, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("touched", Boolean.valueOf(z));
        C2405q.m6574a().m6580a("matches", contentValues, "id='" + str + '\'');
    }

    public static void m6503a(String str) {
        C2405q.m6574a().m6581a("matches", ShareConstants.WEB_DIALOG_PARAM_ID, str);
    }

    public static boolean m6507a(@NonNull Match match) {
        if (match == null) {
            return false;
        }
        C3095y.m9485e("inserting match=" + match);
        try {
            C2405q.m6574a().m6583a("matches", C2392e.m6509d(match));
            C2393f c2393f = new C2393f();
            Iterator it = match.getMessages().iterator();
            while (it.hasNext()) {
                c2393f.m6518b((Message) it.next());
            }
            new C2398k().m6552a((ArrayList) match.getPerson().getPhotos(), match.getPerson().getId());
            return true;
        } catch (Throwable e) {
            C3095y.m9474a("Failed to insert match due to exception", e);
            return false;
        }
    }

    public void m6513b(@NonNull Match match) {
        new C23911(this, match).start();
    }

    public boolean m6510a(@NonNull List<Match> list) {
        C3095y.m9469a();
        int size = list.size();
        int ceil = (int) Math.ceil((double) (((float) size) / 50.0f));
        int i = 1;
        int i2 = 1;
        int i3 = 1;
        int i4 = 1;
        int i5 = 0;
        while (i5 < ceil) {
            List<Match> subList = list.subList(i5 * 50, Math.min((i5 + 1) * 50, size));
            List arrayList = new ArrayList(subList.size());
            List arrayList2 = new ArrayList(subList.size());
            List arrayList3 = new ArrayList(subList.size());
            List arrayList4 = new ArrayList(subList.size());
            for (Match match : subList) {
                arrayList.add(C2392e.m6509d(match));
                Iterator it = match.getMessages().iterator();
                while (it.hasNext()) {
                    arrayList2.add(C2393f.m6514a((Message) it.next()));
                }
                if (match.getPerson() != null) {
                    Person person = match.getPerson();
                    List photos = person.getPhotos();
                    for (int i6 = 0; i6 < photos.size(); i6++) {
                        PhotoUser photoUser = (PhotoUser) photos.get(i6);
                        arrayList3.add(C2398k.m6549a(photoUser, person.getId(), i6));
                        for (ProcessedPhoto a : photoUser.getProcessedPhotos()) {
                            arrayList4.add(C2397j.m6541a(a));
                        }
                    }
                }
            }
            i2 &= C2405q.m6574a().m6585a(this.a, arrayList, ShareConstants.WEB_DIALOG_PARAM_ID, true);
            i &= C2405q.m6574a().m6584a(C2393f.m6515b(), arrayList2);
            i3 &= C2405q.m6574a().m6584a(C2398k.m6550b(), arrayList3);
            i5++;
            i4 &= C2405q.m6574a().m6584a(C2397j.m6542b(), arrayList4);
        }
        return (i2 == 0 || i == 0 || i3 == 0 || i4 == 0) ? false : true;
    }

    @NonNull
    public List<Match> m6511b() {
        C3095y.m9469a();
        Cursor a = C2405q.m6574a().m6576a(this.a);
        Map hashMap = new HashMap(a.getCount());
        Map hashMap2 = new HashMap(a.getCount());
        List arrayList = new ArrayList(a.getCount());
        Gender[] values = Gender.values();
        while (a.moveToNext()) {
            try {
                String string = a.getString(0);
                String string2 = a.getString(1);
                String string3 = a.getString(7);
                String string4 = a.getString(2);
                String string5 = a.getString(3);
                String string6 = a.getString(8);
                boolean z = a.getInt(5) == 1;
                boolean z2 = a.getInt(6) == 1;
                int i = a.getInt(9);
                int i2 = a.getInt(10);
                Match match = new Match(new Person(string2, string3, values[i2], a.getInt(12) == 1), string, new String[0], string5, string4, a.getInt(11) == 1, a.getInt(13) == 1, a.getString(14));
                match.setTouched(z);
                match.setViewed(z2);
                match.setDraftMsg(string6);
                match.setReportedMasks(i);
                hashMap.put(string, match);
                hashMap2.put(string2, match);
                arrayList.add(match);
            } finally {
                if (!a.isClosed()) {
                    a.close();
                }
            }
        }
        new C2393f().m6517a(hashMap);
        new C2398k().m6553a(hashMap2);
        return arrayList;
    }

    @NonNull
    public List<Match> m6512b(String str) {
        Set<String> a = new C2393f().m6516a(str);
        Cursor query = C2405q.m6574a().m6587b().query(this.a, new String[]{ShareConstants.WEB_DIALOG_PARAM_ID}, " user_name LIKE ?", new String[]{"%" + str + "%"}, null, null, null);
        try {
            int columnIndex = query.getColumnIndex(ShareConstants.WEB_DIALOG_PARAM_ID);
            while (query.moveToNext()) {
                a.add(query.getString(columnIndex));
            }
            List<Match> arrayList = new ArrayList();
            for (String a2 : a) {
                Match a3 = ManagerApp.m7925p().m8266a(a2);
                if (a3 != null) {
                    arrayList.add(a3);
                }
            }
            Collections.sort(arrayList);
            return arrayList;
        } finally {
            if (!(query == null || query.isClosed())) {
                query.close();
            }
        }
    }
}
