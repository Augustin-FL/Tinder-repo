package com.facebook.stetho.inspector.database;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.helper.ChromePeerManager;
import com.facebook.stetho.inspector.helper.PeerRegistrationListener;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.protocol.module.Database.AddDatabaseEvent;
import com.facebook.stetho.inspector.protocol.module.Database.DatabaseObject;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DatabasePeerManager extends ChromePeerManager {
    private static final String[] UNINTERESTING_FILENAME_SUFFIXES;
    private final Context mContext;
    private final DatabaseFilesProvider mDatabaseFilesProvider;
    private final PeerRegistrationListener mPeerRegistrationListener;

    /* renamed from: com.facebook.stetho.inspector.database.DatabasePeerManager.1 */
    class C06631 implements PeerRegistrationListener {
        C06631() {
        }

        public void onPeerRegistered(JsonRpcPeer jsonRpcPeer) {
            DatabasePeerManager.this.bootstrapNewPeer(jsonRpcPeer);
        }

        public void onPeerUnregistered(JsonRpcPeer jsonRpcPeer) {
        }
    }

    public interface ExecuteResultHandler<T> {
        T handleInsert(long j) throws SQLiteException;

        T handleRawQuery() throws SQLiteException;

        T handleSelect(Cursor cursor) throws SQLiteException;

        T handleUpdateDelete(int i) throws SQLiteException;
    }

    static {
        UNINTERESTING_FILENAME_SUFFIXES = new String[]{"-journal", "-uid"};
    }

    @Deprecated
    public DatabasePeerManager(Context context) {
        this(context, new DefaultDatabaseFilesProvider(context));
    }

    public DatabasePeerManager(Context context, DatabaseFilesProvider databaseFilesProvider) {
        this.mPeerRegistrationListener = new C06631();
        this.mContext = context;
        this.mDatabaseFilesProvider = databaseFilesProvider;
        setListener(this.mPeerRegistrationListener);
    }

    private void bootstrapNewPeer(JsonRpcPeer jsonRpcPeer) {
        for (File file : tidyDatabaseList(this.mDatabaseFilesProvider.getDatabaseFiles())) {
            DatabaseObject databaseObject = new DatabaseObject();
            databaseObject.id = file.getPath();
            databaseObject.name = file.getName();
            databaseObject.domain = this.mContext.getPackageName();
            databaseObject.version = "N/A";
            AddDatabaseEvent addDatabaseEvent = new AddDatabaseEvent();
            addDatabaseEvent.database = databaseObject;
            jsonRpcPeer.invokeMethod("Database.addDatabase", addDatabaseEvent, null);
        }
    }

    static List<File> tidyDatabaseList(List<File> list) {
        Set hashSet = new HashSet(list);
        List<File> arrayList = new ArrayList();
        for (File file : list) {
            String path = file.getPath();
            String removeSuffix = removeSuffix(path, UNINTERESTING_FILENAME_SUFFIXES);
            if (removeSuffix.equals(path) || !hashSet.contains(new File(removeSuffix))) {
                arrayList.add(file);
            }
        }
        return arrayList;
    }

    private static String removeSuffix(String str, String[] strArr) {
        for (String str2 : strArr) {
            if (str.endsWith(str2)) {
                return str.substring(0, str.length() - str2.length());
            }
        }
        return str;
    }

    public List<String> getDatabaseTableNames(String str) throws SQLiteException {
        SQLiteDatabase openDatabase = openDatabase(str);
        Cursor rawQuery;
        try {
            rawQuery = openDatabase.rawQuery("SELECT name FROM sqlite_master WHERE type=?", new String[]{"table"});
            List<String> arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                arrayList.add(rawQuery.getString(0));
            }
            rawQuery.close();
            openDatabase.close();
            return arrayList;
        } catch (Throwable th) {
            openDatabase.close();
        }
    }

    public <T> T executeSQL(String str, String str2, ExecuteResultHandler<T> executeResultHandler) throws SQLiteException {
        Util.throwIfNull(str2);
        Util.throwIfNull(executeResultHandler);
        SQLiteDatabase openDatabase = openDatabase(str);
        try {
            String firstWord = getFirstWord(str2);
            T executeUpdateDelete;
            if (firstWord.equalsIgnoreCase("UPDATE") || firstWord.equalsIgnoreCase("DELETE")) {
                executeUpdateDelete = executeUpdateDelete(openDatabase, str2, executeResultHandler);
                return executeUpdateDelete;
            }
            if (firstWord.equalsIgnoreCase("INSERT")) {
                executeUpdateDelete = executeInsert(openDatabase, str2, executeResultHandler);
                openDatabase.close();
            } else if (firstWord.equalsIgnoreCase("SELECT")) {
                executeUpdateDelete = executeSelect(openDatabase, str2, executeResultHandler);
                openDatabase.close();
            } else {
                executeUpdateDelete = executeRawQuery(openDatabase, str2, executeResultHandler);
                openDatabase.close();
            }
            return executeUpdateDelete;
        } finally {
            openDatabase.close();
        }
    }

    private static String getFirstWord(String str) {
        str.trim();
        int indexOf = str.indexOf(32);
        return indexOf >= 0 ? str.substring(0, indexOf) : str;
    }

    @TargetApi(11)
    private <T> T executeUpdateDelete(SQLiteDatabase sQLiteDatabase, String str, ExecuteResultHandler<T> executeResultHandler) {
        return executeResultHandler.handleUpdateDelete(sQLiteDatabase.compileStatement(str).executeUpdateDelete());
    }

    private <T> T executeInsert(SQLiteDatabase sQLiteDatabase, String str, ExecuteResultHandler<T> executeResultHandler) {
        return executeResultHandler.handleInsert(sQLiteDatabase.compileStatement(str).executeInsert());
    }

    private <T> T executeSelect(SQLiteDatabase sQLiteDatabase, String str, ExecuteResultHandler<T> executeResultHandler) {
        Cursor rawQuery = sQLiteDatabase.rawQuery(str, null);
        try {
            T handleSelect = executeResultHandler.handleSelect(rawQuery);
            return handleSelect;
        } finally {
            rawQuery.close();
        }
    }

    private <T> T executeRawQuery(SQLiteDatabase sQLiteDatabase, String str, ExecuteResultHandler<T> executeResultHandler) {
        sQLiteDatabase.execSQL(str);
        return executeResultHandler.handleRawQuery();
    }

    private SQLiteDatabase openDatabase(String str) throws SQLiteException {
        Util.throwIfNull(str);
        return SQLiteDatabase.openDatabase(this.mContext.getDatabasePath(str).getAbsolutePath(), null, 0);
    }
}
