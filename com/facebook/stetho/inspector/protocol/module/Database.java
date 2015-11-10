package com.facebook.stetho.inspector.protocol.module;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.facebook.GraphResponse;
import com.facebook.internal.ServerProtocol;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.database.DatabaseFilesProvider;
import com.facebook.stetho.inspector.database.DatabasePeerManager;
import com.facebook.stetho.inspector.database.DatabasePeerManager.ExecuteResultHandler;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.json.ObjectMapper;
import com.facebook.stetho.json.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

@TargetApi(11)
public class Database implements ChromeDevtoolsDomain {
    private static final int MAX_EXECUTE_RESULTS = 250;
    private final DatabasePeerManager mDatabasePeerManager;
    private final ObjectMapper mObjectMapper;

    /* renamed from: com.facebook.stetho.inspector.protocol.module.Database.1 */
    class C06831 implements ExecuteResultHandler<ExecuteSQLResponse> {
        C06831() {
        }

        public ExecuteSQLResponse handleRawQuery() throws SQLiteException {
            ExecuteSQLResponse executeSQLResponse = new ExecuteSQLResponse();
            executeSQLResponse.columnNames = Arrays.asList(new String[]{GraphResponse.SUCCESS_KEY});
            executeSQLResponse.values = Arrays.asList(new Object[]{ServerProtocol.DIALOG_RETURN_SCOPES_TRUE});
            return executeSQLResponse;
        }

        public ExecuteSQLResponse handleSelect(Cursor cursor) throws SQLiteException {
            ExecuteSQLResponse executeSQLResponse = new ExecuteSQLResponse();
            executeSQLResponse.columnNames = Arrays.asList(cursor.getColumnNames());
            executeSQLResponse.values = Database.this.flattenRows(cursor, Database.MAX_EXECUTE_RESULTS);
            return executeSQLResponse;
        }

        public ExecuteSQLResponse handleInsert(long j) throws SQLiteException {
            ExecuteSQLResponse executeSQLResponse = new ExecuteSQLResponse();
            executeSQLResponse.columnNames = Arrays.asList(new String[]{"ID of last inserted row"});
            executeSQLResponse.values = Arrays.asList(new Object[]{Long.valueOf(j)});
            return executeSQLResponse;
        }

        public ExecuteSQLResponse handleUpdateDelete(int i) throws SQLiteException {
            ExecuteSQLResponse executeSQLResponse = new ExecuteSQLResponse();
            executeSQLResponse.columnNames = Arrays.asList(new String[]{"Modified rows"});
            executeSQLResponse.values = Arrays.asList(new Object[]{Integer.valueOf(i)});
            return executeSQLResponse;
        }
    }

    public static class AddDatabaseEvent {
        @JsonProperty(required = true)
        public DatabaseObject database;
    }

    public static class DatabaseObject {
        @JsonProperty(required = true)
        public String domain;
        @JsonProperty(required = true)
        public String id;
        @JsonProperty(required = true)
        public String name;
        @JsonProperty(required = true)
        public String version;
    }

    public static class Error {
        @JsonProperty(required = true)
        public int code;
        @JsonProperty(required = true)
        public String message;
    }

    private static class ExecuteSQLRequest {
        @JsonProperty(required = true)
        public String databaseId;
        @JsonProperty(required = true)
        public String query;

        private ExecuteSQLRequest() {
        }
    }

    private static class ExecuteSQLResponse implements JsonRpcResult {
        @JsonProperty
        public List<String> columnNames;
        @JsonProperty
        public Error sqlError;
        @JsonProperty
        public List<Object> values;

        private ExecuteSQLResponse() {
        }
    }

    private static class GetDatabaseTableNamesRequest {
        @JsonProperty(required = true)
        public String databaseId;

        private GetDatabaseTableNamesRequest() {
        }
    }

    private static class GetDatabaseTableNamesResponse implements JsonRpcResult {
        @JsonProperty(required = true)
        public List<String> tableNames;

        private GetDatabaseTableNamesResponse() {
        }
    }

    @Deprecated
    public Database(Context context) {
        this.mDatabasePeerManager = new DatabasePeerManager(context);
        this.mObjectMapper = new ObjectMapper();
    }

    public Database(Context context, DatabaseFilesProvider databaseFilesProvider) {
        this.mDatabasePeerManager = new DatabasePeerManager(context, databaseFilesProvider);
        this.mObjectMapper = new ObjectMapper();
    }

    @ChromeDevtoolsMethod
    public void enable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        this.mDatabasePeerManager.addPeer(jsonRpcPeer);
    }

    @ChromeDevtoolsMethod
    public void disable(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        this.mDatabasePeerManager.removePeer(jsonRpcPeer);
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult getDatabaseTableNames(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        GetDatabaseTableNamesRequest getDatabaseTableNamesRequest = (GetDatabaseTableNamesRequest) this.mObjectMapper.convertValue(jSONObject, GetDatabaseTableNamesRequest.class);
        JsonRpcResult getDatabaseTableNamesResponse = new GetDatabaseTableNamesResponse();
        getDatabaseTableNamesResponse.tableNames = this.mDatabasePeerManager.getDatabaseTableNames(getDatabaseTableNamesRequest.databaseId);
        return getDatabaseTableNamesResponse;
    }

    @ChromeDevtoolsMethod
    public JsonRpcResult executeSQL(JsonRpcPeer jsonRpcPeer, JSONObject jSONObject) {
        ExecuteSQLRequest executeSQLRequest = (ExecuteSQLRequest) this.mObjectMapper.convertValue(jSONObject, ExecuteSQLRequest.class);
        try {
            return (JsonRpcResult) this.mDatabasePeerManager.executeSQL(executeSQLRequest.databaseId, executeSQLRequest.query, new C06831());
        } catch (SQLiteException e) {
            Error error = new Error();
            error.code = 0;
            error.message = e.getMessage();
            JsonRpcResult executeSQLResponse = new ExecuteSQLResponse();
            executeSQLResponse.sqlError = error;
            return executeSQLResponse;
        }
    }

    private List<Object> flattenRows(Cursor cursor, int i) {
        boolean z;
        int i2 = 0;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        Util.throwIfNot(z);
        List<Object> arrayList = new ArrayList();
        int columnCount = cursor.getColumnCount();
        for (int i3 = 0; i3 < i && cursor.moveToNext(); i3++) {
            for (int i4 = 0; i4 < columnCount; i4++) {
                switch (cursor.getType(i4)) {
                    case C3374b.SmoothProgressBar_spbStyle /*0*/:
                        arrayList.add(null);
                        break;
                    case C3374b.SmoothProgressBar_spb_color /*1*/:
                        arrayList.add(Long.valueOf(cursor.getLong(i4)));
                        break;
                    case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                        arrayList.add(Double.valueOf(cursor.getDouble(i4)));
                        break;
                    case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                        arrayList.add(cursor.getBlob(i4));
                        break;
                    default:
                        arrayList.add(cursor.getString(i4));
                        break;
                }
            }
        }
        if (!cursor.isAfterLast()) {
            while (i2 < columnCount) {
                arrayList.add("{truncated}");
                i2++;
            }
        }
        return arrayList;
    }
}
