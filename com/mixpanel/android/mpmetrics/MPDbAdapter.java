package com.mixpanel.android.mpmetrics;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.facebook.share.internal.ShareConstants;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class MPDbAdapter {
    private static final String f2757a;
    private static final String f2758b;
    private static final String f2759c;
    private static final String f2760d;
    private final C2001a f2761e;

    public enum Table {
        EVENTS("events"),
        PEOPLE("people");
        
        private final String f2755c;

        private Table(String str) {
            this.f2755c = str;
        }

        public String m4614a() {
            return this.f2755c;
        }
    }

    /* renamed from: com.mixpanel.android.mpmetrics.MPDbAdapter.a */
    private static class C2001a extends SQLiteOpenHelper {
        private final File f2756a;

        C2001a(Context context, String str) {
            super(context, str, null, 4);
            this.f2756a = context.getDatabasePath(str);
        }

        public void m4615a() {
            close();
            this.f2756a.delete();
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            if (C2031g.f2854a) {
                Log.d("MixpanelAPI", "Creating a new Mixpanel events DB");
            }
            sQLiteDatabase.execSQL(MPDbAdapter.f2757a);
            sQLiteDatabase.execSQL(MPDbAdapter.f2758b);
            sQLiteDatabase.execSQL(MPDbAdapter.f2759c);
            sQLiteDatabase.execSQL(MPDbAdapter.f2760d);
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (C2031g.f2854a) {
                Log.d("MixpanelAPI", "Upgrading app, replacing Mixpanel events DB");
            }
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Table.EVENTS.m4614a());
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Table.PEOPLE.m4614a());
            sQLiteDatabase.execSQL(MPDbAdapter.f2757a);
            sQLiteDatabase.execSQL(MPDbAdapter.f2758b);
            sQLiteDatabase.execSQL(MPDbAdapter.f2759c);
            sQLiteDatabase.execSQL(MPDbAdapter.f2760d);
        }
    }

    static {
        f2757a = "CREATE TABLE " + Table.EVENTS.m4614a() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + ShareConstants.WEB_DIALOG_PARAM_DATA + " STRING NOT NULL, " + "created_at" + " INTEGER NOT NULL);";
        f2758b = "CREATE TABLE " + Table.PEOPLE.m4614a() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + ShareConstants.WEB_DIALOG_PARAM_DATA + " STRING NOT NULL, " + "created_at" + " INTEGER NOT NULL);";
        f2759c = "CREATE INDEX IF NOT EXISTS time_idx ON " + Table.EVENTS.m4614a() + " (" + "created_at" + ");";
        f2760d = "CREATE INDEX IF NOT EXISTS time_idx ON " + Table.PEOPLE.m4614a() + " (" + "created_at" + ");";
    }

    public MPDbAdapter(Context context) {
        this(context, "mixpanel");
    }

    public MPDbAdapter(Context context, String str) {
        this.f2761e = new C2001a(context, str);
    }

    public int m4620a(JSONObject jSONObject, Table table) {
        Throwable e;
        Throwable th;
        Cursor cursor = null;
        String a = table.m4614a();
        int i = -1;
        Cursor rawQuery;
        try {
            SQLiteDatabase writableDatabase = this.f2761e.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(ShareConstants.WEB_DIALOG_PARAM_DATA, jSONObject.toString());
            contentValues.put("created_at", Long.valueOf(System.currentTimeMillis()));
            writableDatabase.insert(a, null, contentValues);
            rawQuery = writableDatabase.rawQuery("SELECT COUNT(*) FROM " + a, null);
            try {
                rawQuery.moveToFirst();
                i = rawQuery.getInt(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                this.f2761e.close();
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    Log.e("MixpanelAPI", "addJSON " + a + " FAILED. Deleting DB.", e);
                    if (rawQuery == null) {
                        rawQuery.close();
                    } else {
                        cursor = rawQuery;
                    }
                    try {
                        this.f2761e.m4615a();
                        if (cursor != null) {
                            cursor.close();
                        }
                        this.f2761e.close();
                        return i;
                    } catch (Throwable th2) {
                        th = th2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        this.f2761e.close();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor = rawQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    this.f2761e.close();
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            rawQuery = null;
            Log.e("MixpanelAPI", "addJSON " + a + " FAILED. Deleting DB.", e);
            if (rawQuery == null) {
                cursor = rawQuery;
            } else {
                rawQuery.close();
            }
            this.f2761e.m4615a();
            if (cursor != null) {
                cursor.close();
            }
            this.f2761e.close();
            return i;
        }
        return i;
    }

    public void m4623a(String str, Table table) {
        String a = table.m4614a();
        try {
            this.f2761e.getWritableDatabase().delete(a, "_id <= " + str, null);
        } catch (Throwable e) {
            Log.e("MixpanelAPI", "cleanupEvents " + a + " by id FAILED. Deleting DB.", e);
            this.f2761e.m4615a();
        } finally {
            this.f2761e.close();
        }
    }

    public void m4622a(long j, Table table) {
        String a = table.m4614a();
        try {
            this.f2761e.getWritableDatabase().delete(a, "created_at <= " + j, null);
        } catch (Throwable e) {
            Log.e("MixpanelAPI", "cleanupEvents " + a + " by time FAILED. Deleting DB.", e);
            this.f2761e.m4615a();
        } finally {
            this.f2761e.close();
        }
    }

    public void m4621a() {
        this.f2761e.m4615a();
    }

    public String[] m4624a(Table table) {
        String jSONArray;
        String str;
        Throwable e;
        String a = table.m4614a();
        Cursor rawQuery;
        try {
            rawQuery = this.f2761e.getReadableDatabase().rawQuery("SELECT * FROM " + a + " ORDER BY " + "created_at" + " ASC LIMIT 50", null);
            try {
                JSONArray jSONArray2 = new JSONArray();
                String str2 = null;
                while (rawQuery.moveToNext()) {
                    if (rawQuery.isLast()) {
                        str2 = rawQuery.getString(rawQuery.getColumnIndex("_id"));
                    }
                    try {
                        jSONArray2.put(new JSONObject(rawQuery.getString(rawQuery.getColumnIndex(ShareConstants.WEB_DIALOG_PARAM_DATA))));
                    } catch (JSONException e2) {
                    }
                }
                if (jSONArray2.length() > 0) {
                    jSONArray = jSONArray2.toString();
                } else {
                    jSONArray = null;
                }
                this.f2761e.close();
                if (rawQuery != null) {
                    rawQuery.close();
                    str = jSONArray;
                    jSONArray = str2;
                } else {
                    str = jSONArray;
                    jSONArray = str2;
                }
            } catch (SQLiteException e3) {
                e = e3;
                try {
                    Log.e("MixpanelAPI", "generateDataString " + a, e);
                    this.f2761e.close();
                    if (rawQuery == null) {
                        jSONArray = null;
                        str = null;
                    } else {
                        rawQuery.close();
                        jSONArray = null;
                        str = null;
                    }
                    return jSONArray != null ? null : null;
                } catch (Throwable th) {
                    e = th;
                    this.f2761e.close();
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    throw e;
                }
            }
        } catch (SQLiteException e4) {
            e = e4;
            rawQuery = null;
            Log.e("MixpanelAPI", "generateDataString " + a, e);
            this.f2761e.close();
            if (rawQuery == null) {
                rawQuery.close();
                jSONArray = null;
                str = null;
            } else {
                jSONArray = null;
                str = null;
            }
            if (jSONArray != null) {
            }
        } catch (Throwable th2) {
            e = th2;
            rawQuery = null;
            this.f2761e.close();
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw e;
        }
        if (jSONArray != null && str != null) {
            return new String[]{jSONArray, str};
        }
    }
}
