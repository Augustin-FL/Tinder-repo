package com.tinder.p031b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import com.tinder.managers.ManagerApp;
import com.tinder.utils.C3095y;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tinder.b.q */
public class C2405q {
    private static final C2405q f4301a;
    private SQLiteDatabase f4302b;

    static {
        f4301a = new C2405q();
    }

    private C2405q() {
        C3095y.m9469a();
        this.f4302b = new C2404p(ManagerApp.m7917h()).getWritableDatabase();
    }

    @NonNull
    public static C2405q m6574a() {
        return f4301a;
    }

    public SQLiteDatabase m6587b() {
        return this.f4302b;
    }

    public void m6589c() {
        this.f4302b.close();
    }

    public synchronized Cursor m6576a(@NonNull String str) {
        return this.f4302b.query(str, new String[]{"*"}, null, null, null, null, null);
    }

    public synchronized Cursor m6577a(@NonNull String str, String str2) {
        return this.f4302b.query(str, new String[]{"*"}, null, null, null, null, str2);
    }

    public synchronized Cursor m6586b(@NonNull String str, String str2) {
        return this.f4302b.query(str, new String[]{"*"}, str2, null, null, null, null);
    }

    public synchronized Cursor m6578a(@NonNull String str, String str2, int i) {
        String str3;
        str3 = str;
        return this.f4302b.query(str3, new String[]{"*"}, null, null, null, null, str2, String.valueOf(i));
    }

    public synchronized boolean m6583a(String str, ContentValues contentValues) {
        long j;
        j = 0;
        if (!this.f4302b.isOpen() || this.f4302b.isReadOnly()) {
            C3095y.m9476b("Insert not performed, DB closed");
        } else {
            j = this.f4302b.replace(str, null, contentValues);
        }
        return j != -1;
    }

    public synchronized boolean m6584a(String str, @NonNull List<ContentValues> list) {
        boolean z = false;
        synchronized (this) {
            try {
                this.f4302b.beginTransaction();
                boolean z2 = true;
                for (ContentValues replace : list) {
                    boolean z3;
                    long replace2 = this.f4302b.replace(str, null, replace);
                    if (!z2 || replace2 == -1) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    z2 = z3;
                }
                this.f4302b.setTransactionSuccessful();
                m6575e();
                z = z2;
            } catch (Exception e) {
                C3095y.m9479c("Failure inserting bulk SQLite records: " + e);
                m6575e();
            } catch (Throwable th) {
                m6575e();
            }
        }
        return z;
    }

    private synchronized void m6575e() {
        if (this.f4302b.isOpen()) {
            this.f4302b.endTransaction();
        } else {
            C3095y.m9471a("Didn't end transaction b/c DB was likely cleared by a logout mid-insert");
        }
    }

    public synchronized boolean m6585a(String str, @NonNull List<ContentValues> list, String str2, boolean z) {
        boolean z2;
        try {
            this.f4302b.beginTransaction();
            for (ContentValues contentValues : list) {
                StringBuilder stringBuilder = new StringBuilder(str2);
                if (z) {
                    stringBuilder.append("='").append(contentValues.get(str2)).append('\'');
                } else {
                    stringBuilder.append('=').append(contentValues.get(str2));
                }
                if (this.f4302b.update(str, contentValues, stringBuilder.toString(), null) == 0) {
                    this.f4302b.insert(str, null, contentValues);
                }
            }
            this.f4302b.setTransactionSuccessful();
            m6575e();
            z2 = true;
        } catch (Exception e) {
            C3095y.m9479c("Failure inserting bulk SQLite records (with updating enabled): " + e);
            z2 = false;
            m6575e();
        } catch (Throwable th) {
            m6575e();
        }
        return z2;
    }

    public synchronized void m6580a(String str, ContentValues contentValues, String str2) {
        if (this.f4302b.isOpen()) {
            this.f4302b.update(str, contentValues, str2, null);
        } else {
            C3095y.m9476b("Update not performed, DB closed");
        }
    }

    public synchronized void m6581a(String str, String str2, String str3) {
        if (this.f4302b.isOpen()) {
            C3095y.m9471a("deleted " + this.f4302b.delete(str, str2 + '=' + '\'' + str3 + '\'', null) + " from table " + str);
        } else {
            C3095y.m9476b("DB closed, nothing deleted");
        }
    }

    public synchronized void m6582a(String str, String str2, @NonNull ArrayList<String> arrayList) {
        StringBuilder stringBuilder = new StringBuilder(str2 + " in (");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            stringBuilder.append('\"').append((String) arrayList.get(i)).append('\"');
            if (i < size - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(')');
        if (this.f4302b.isOpen()) {
            C3095y.m9471a("deleted " + this.f4302b.delete(str, stringBuilder.toString(), null) + " from table " + str);
        } else {
            C3095y.m9476b("Delete not performed, DB closed");
        }
    }

    public synchronized void m6588b(String str, String str2, @NonNull ArrayList<Long> arrayList) {
        StringBuilder stringBuilder = new StringBuilder(str2 + " in (");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(arrayList.get(i));
            if (i < size - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(')');
        if (this.f4302b.isOpen()) {
            try {
                C3095y.m9471a("deleted " + this.f4302b.delete(str, stringBuilder.toString(), null) + " from table " + str);
            } catch (Exception e) {
                C3095y.m9479c(e.getMessage());
            }
        } else {
            C3095y.m9476b("Delete not performed, DB closed");
        }
    }

    public synchronized void m6590d() {
        this.f4302b = new C2404p(ManagerApp.m7917h()).getWritableDatabase();
    }

    public synchronized void m6579a(@NonNull Context context, String str) {
        context.deleteDatabase(str);
    }
}
