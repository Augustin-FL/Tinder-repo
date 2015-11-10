package com.tinder.p031b;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.facebook.share.internal.ShareConstants;
import com.tinder.enums.PhotoSizeMoment;
import com.tinder.enums.SqlDataType;
import com.tinder.model.PhotoMoment;
import com.tinder.utils.C3095y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tinder.b.i */
public class C2396i extends C2388c {
    public C2396i() {
        this.a = "photos_moments";
        this.b = new C2387a[]{new C2387a(ShareConstants.WEB_DIALOG_PARAM_ID, SqlDataType.TEXT, true), new C2387a("large", SqlDataType.TEXT, false), new C2387a("med", SqlDataType.TEXT, false), new C2387a("orig", SqlDataType.TEXT, false), new C2387a("small", SqlDataType.TEXT, false), new C2387a("thumb", SqlDataType.TEXT, false)};
    }

    public static boolean m6538a(@NonNull ArrayList<PhotoMoment> arrayList) {
        List arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(C2396i.m6537a((PhotoMoment) it.next()));
        }
        return C2405q.m6574a().m6584a("photos_moments", arrayList2);
    }

    @NonNull
    public static ContentValues m6537a(@NonNull PhotoMoment photoMoment) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ShareConstants.WEB_DIALOG_PARAM_ID, photoMoment.getPhotoId());
        contentValues.put("large", photoMoment.getProcessedFile(PhotoSizeMoment.LARGE));
        contentValues.put("med", photoMoment.getProcessedFile(PhotoSizeMoment.MED));
        contentValues.put("orig", photoMoment.getProcessedFile(PhotoSizeMoment.ORIG));
        contentValues.put("small", photoMoment.getProcessedFile(PhotoSizeMoment.SMALL));
        contentValues.put("thumb", photoMoment.getProcessedFile(PhotoSizeMoment.THUMB));
        return contentValues;
    }

    public void m6540b(@NonNull PhotoMoment photoMoment) {
        C2405q.m6574a().m6583a(this.a, C2396i.m6537a(photoMoment));
    }

    @Nullable
    public PhotoMoment m6539a(@Nullable String str) {
        Cursor query;
        Exception e;
        Throwable th;
        C3095y.m9471a("photoId=" + str);
        try {
            query = C2405q.m6574a().m6587b().query(this.a, new String[]{"*"}, "id='" + str + "'", null, null, null, null);
            if (str != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(0);
                        String[] strArr = new String[]{query.getString(1), query.getString(2), query.getString(3), query.getString(4), query.getString(5)};
                        query.moveToNext();
                        PhotoMoment photoMoment = new PhotoMoment(string, strArr);
                        C2404p.m6572a(query);
                        return photoMoment;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C3095y.m9479c(e.getMessage());
                        C2404p.m6572a(query);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        C2404p.m6572a(query);
                        throw th;
                    }
                }
            }
            C3095y.m9471a("photoId null or nothing in DB");
            C2404p.m6572a(query);
        } catch (Exception e3) {
            e = e3;
            query = null;
            C3095y.m9479c(e.getMessage());
            C2404p.m6572a(query);
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            C2404p.m6572a(query);
            throw th;
        }
        return null;
    }
}
