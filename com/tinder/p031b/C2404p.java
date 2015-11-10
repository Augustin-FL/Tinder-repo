package com.tinder.p031b;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tinder.utils.C3095y;

/* renamed from: com.tinder.b.p */
public class C2404p extends SQLiteOpenHelper {
    private static C2389b f4286a;
    private static C2392e f4287b;
    private static C2393f f4288c;
    private static C2397j f4289d;
    private static C2396i f4290e;
    private static C2398k f4291f;
    private static C2403o f4292g;
    private static C2400l f4293h;
    private static C2401m f4294i;
    private static C2395h f4295j;
    private static C2394g f4296k;
    private static C2390d f4297l;
    private static C2402n f4298m;
    private static C2406r f4299n;
    private static C2407s f4300o;

    public C2404p(Context context) {
        super(context, "tinder.db", null, 14);
        C3095y.m9469a();
        f4286a = new C2389b();
        f4287b = new C2392e();
        f4288c = new C2393f();
        f4295j = new C2395h();
        f4296k = new C2394g();
        f4289d = new C2397j();
        f4291f = new C2398k();
        f4290e = new C2396i();
        f4293h = new C2400l();
        f4292g = new C2403o();
        f4294i = new C2401m();
        f4297l = new C2390d();
        f4298m = new C2402n();
        f4299n = new C2406r();
        f4300o = new C2407s();
    }

    private static void m6573a(@NonNull SQLiteDatabase sQLiteDatabase) {
        C3095y.m9469a();
        sQLiteDatabase.execSQL(f4286a.m6497a());
        sQLiteDatabase.execSQL(f4287b.m6497a());
        sQLiteDatabase.execSQL(f4288c.m6497a());
        sQLiteDatabase.execSQL(f4289d.m6497a());
        sQLiteDatabase.execSQL(f4291f.m6497a());
        sQLiteDatabase.execSQL(f4290e.m6497a());
        sQLiteDatabase.execSQL(f4292g.m6497a());
        sQLiteDatabase.execSQL(f4293h.m6497a());
        sQLiteDatabase.execSQL(f4294i.m6497a());
        sQLiteDatabase.execSQL(f4295j.m6497a());
        sQLiteDatabase.execSQL(f4296k.m6497a());
        sQLiteDatabase.execSQL(f4297l.m6497a());
        sQLiteDatabase.execSQL(f4298m.m6497a());
        sQLiteDatabase.execSQL(f4299n.m6497a());
        sQLiteDatabase.execSQL(f4300o.m6497a());
    }

    public static void m6571a(@NonNull Context context) {
        C2405q.m6574a().m6579a(context, "tinder.db");
    }

    public static void m6572a(@Nullable Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    public void onCreate(@NonNull SQLiteDatabase sQLiteDatabase) {
        C3095y.m9469a();
        C2404p.m6573a(sQLiteDatabase);
    }

    public void onUpgrade(@NonNull SQLiteDatabase sQLiteDatabase, int i, int i2) {
        C3095y.m9476b("Database upgrade from old: " + i + " to: " + i2);
        if (i < 2) {
            sQLiteDatabase.execSQL(f4294i.m6497a());
        }
        if (i < 3) {
            sQLiteDatabase.execSQL("alter table " + f4291f.a + " add column " + "photo_order" + " integer");
            sQLiteDatabase.execSQL("ALTER TABLE " + f4287b.a + " ADD COLUMN " + "draft_msg" + " TEXT");
        }
        if (i < 4) {
            sQLiteDatabase.execSQL("alter table " + f4292g.a + " add column " + "last_activity_date" + " text");
        }
        if (i < 6) {
            sQLiteDatabase.execSQL("alter table " + f4287b.a + " add column " + "reported_for" + " integer");
        }
        if (i < 7) {
            sQLiteDatabase.execSQL(f4286a.m6497a());
        }
        if (i < 8) {
            sQLiteDatabase.execSQL(f4295j.m6497a());
            sQLiteDatabase.execSQL(f4296k.m6497a());
            sQLiteDatabase.execSQL(f4290e.m6497a());
            sQLiteDatabase.execSQL("alter table " + f4287b.a + " add column " + "gender" + " integer");
            sQLiteDatabase.execSQL("alter table " + f4287b.a + " add column " + "following" + " integer default 1");
            sQLiteDatabase.execSQL(f4297l.m6497a());
            sQLiteDatabase.execSQL(f4293h.m6497a());
        }
        if (i < 10) {
            try {
                sQLiteDatabase.execSQL("alter table " + f4295j.a + " add column " + "num_likes" + " integer");
                System.out.println("Column added successfully");
            } catch (Exception e) {
                System.out.println("We've most likely already added this column");
                System.out.println(e.getMessage());
            }
        }
        if (i < 11) {
            sQLiteDatabase.execSQL("alter table " + f4292g.a + " add column " + "traveling" + " integer default 0");
            sQLiteDatabase.execSQL(f4298m.m6497a());
        }
        if (i < 12) {
            sQLiteDatabase.execSQL(f4299n.m6497a());
            sQLiteDatabase.execSQL(f4300o.m6497a());
        }
        if (i < 13) {
            sQLiteDatabase.execSQL("alter table " + f4292g.a + " add column " + "is_verified" + " integer");
            sQLiteDatabase.execSQL("alter table " + f4287b.a + " add column " + "is_verified" + " integer");
        }
        if (i < 14) {
            sQLiteDatabase.execSQL("alter table " + f4292g.a + " add column " + "is_superlike" + " integer");
            sQLiteDatabase.execSQL("alter table " + f4287b.a + " add column " + "is_superlike" + " integer");
            sQLiteDatabase.execSQL("alter table " + f4287b.a + " add column " + "superliker" + " text");
            sQLiteDatabase.execSQL("alter table " + f4293h.a + " add column " + "is_superlike" + " integer");
            sQLiteDatabase.execSQL("alter table " + f4294i.a + " add column " + "is_superlike" + " integer");
        }
    }
}
