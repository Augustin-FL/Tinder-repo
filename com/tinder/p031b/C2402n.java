package com.tinder.p031b;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.tinder.enums.SqlDataType;
import com.tinder.model.TinderLocation;
import com.tinder.utils.C3095y;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tinder.b.n */
public class C2402n extends C2388c {
    public C2402n() {
        this.a = "tinder_locations";
        this.b = new C2387a[]{new C2387a(ShareConstants.WEB_DIALOG_PARAM_ID, SqlDataType.TEXT, true), new C2387a("latitude", SqlDataType.REAL, false), new C2387a("longitude", SqlDataType.REAL, false), new C2387a("state_province_long", SqlDataType.TEXT, false), new C2387a("state_province_short", SqlDataType.TEXT, false), new C2387a("country_short_name", SqlDataType.TEXT, false), new C2387a("country_long_name", SqlDataType.TEXT, false), new C2387a("country", SqlDataType.TEXT, false), new C2387a("address", SqlDataType.TEXT, false), new C2387a("route", SqlDataType.TEXT, false), new C2387a("street_number", SqlDataType.TEXT, false), new C2387a("city", SqlDataType.TEXT, false), new C2387a("last_seen_date", SqlDataType.INTEGER, false)};
    }

    @NonNull
    private static ContentValues m6564b(@NonNull TinderLocation tinderLocation) throws Exception {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ShareConstants.WEB_DIALOG_PARAM_ID, tinderLocation.getId());
        contentValues.put("latitude", Double.valueOf(tinderLocation.getLatitude()));
        contentValues.put("longitude", Double.valueOf(tinderLocation.getLongitude()));
        contentValues.put("state_province_long", tinderLocation.getStateProvinceLong());
        contentValues.put("state_province_short", tinderLocation.getStateProvinceShort());
        contentValues.put("country_short_name", tinderLocation.getCountryShort());
        contentValues.put("country_long_name", tinderLocation.getCountryLong());
        contentValues.put("country", tinderLocation.getCounty());
        contentValues.put("address", tinderLocation.getAddress());
        contentValues.put("route", tinderLocation.getRoute());
        contentValues.put("street_number", tinderLocation.getStreetNumber());
        contentValues.put("city", tinderLocation.getCity());
        contentValues.put("last_seen_date", Long.valueOf(tinderLocation.getLastSeenDate()));
        return contentValues;
    }

    @NonNull
    public List<TinderLocation> m6567b() {
        List<TinderLocation> arrayList = new ArrayList();
        Cursor a = C2405q.m6574a().m6577a("tinder_locations", "last_seen_date DESC");
        while (a.moveToNext()) {
            try {
                arrayList.add(m6563a(a));
            } catch (Exception e) {
                C3095y.m9479c(e.getMessage());
            } finally {
                C2404p.m6572a(a);
            }
        }
        return arrayList;
    }

    @NonNull
    private TinderLocation m6563a(@NonNull Cursor cursor) {
        TinderLocation tinderLocation = new TinderLocation();
        tinderLocation.setLatitude(cursor.getDouble(cursor.getColumnIndex("latitude")));
        tinderLocation.setLongitude(cursor.getDouble(cursor.getColumnIndex("longitude")));
        tinderLocation.setStateProvinceLong(cursor.getString(cursor.getColumnIndex("state_province_long")));
        tinderLocation.setStateProvinceShort(cursor.getString(cursor.getColumnIndex("state_province_short")));
        tinderLocation.setCountryLong(cursor.getString(cursor.getColumnIndex("country_long_name")));
        tinderLocation.setCountryShort(cursor.getString(cursor.getColumnIndex("country_short_name")));
        tinderLocation.setCounty(cursor.getString(cursor.getColumnIndex("country")));
        tinderLocation.setAddress(cursor.getString(cursor.getColumnIndex("address")));
        tinderLocation.setRoute(cursor.getString(cursor.getColumnIndex("route")));
        tinderLocation.setStreetNumber(cursor.getString(cursor.getColumnIndex("street_number")));
        tinderLocation.setCity(cursor.getString(cursor.getColumnIndex("city")));
        tinderLocation.setLastSeenDate(cursor.getLong(cursor.getColumnIndex("last_seen_date")));
        return tinderLocation;
    }

    public synchronized void m6565a(@NonNull TinderLocation tinderLocation, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("last_seen_date", Long.valueOf(j));
        C2405q.m6574a().m6580a(this.a, contentValues, "id='" + tinderLocation.getId() + "'");
    }

    public synchronized boolean m6566a(@NonNull TinderLocation tinderLocation) {
        boolean z;
        try {
            for (TinderLocation id : m6567b()) {
                if (TextUtils.equals(id.getId(), tinderLocation.getId())) {
                    C3095y.m9471a("TinderLocation already exists in db");
                    z = false;
                    break;
                }
            }
            C3095y.m9471a("TinderLocation insert into db: " + tinderLocation.toString());
            C2405q.m6574a().m6583a(this.a, C2402n.m6564b(tinderLocation));
            z = true;
        } catch (Exception e) {
            C3095y.m9479c(e.getMessage());
            z = false;
        }
        return z;
    }
}
