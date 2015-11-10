package com.facebook;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.share.internal.ShareConstants;
import com.facebook.stetho.BuildConfig;
import com.google.android.gms.common.Scopes;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class TestUserManager {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final String LOG_TAG = "TestUserManager";
    private Map<String, JSONObject> appTestAccounts;
    private String testApplicationId;
    private String testApplicationSecret;

    private enum Mode {
        PRIVATE,
        SHARED
    }

    static {
        $assertionsDisabled = !TestUserManager.class.desiredAssertionStatus() ? true : $assertionsDisabled;
    }

    public TestUserManager(String str, String str2) {
        if (Utility.isNullOrEmpty(str2) || Utility.isNullOrEmpty(str)) {
            throw new FacebookException("Must provide app ID and secret");
        }
        this.testApplicationSecret = str;
        this.testApplicationId = str2;
    }

    public AccessToken getAccessTokenForPrivateUser(List<String> list) {
        return getAccessTokenForUser(list, Mode.PRIVATE, null);
    }

    public AccessToken getAccessTokenForSharedUser(List<String> list) {
        return getAccessTokenForSharedUser(list, null);
    }

    public AccessToken getAccessTokenForSharedUser(List<String> list, String str) {
        return getAccessTokenForUser(list, Mode.SHARED, str);
    }

    public synchronized String getTestApplicationId() {
        return this.testApplicationId;
    }

    public synchronized String getTestApplicationSecret() {
        return this.testApplicationSecret;
    }

    private AccessToken getAccessTokenForUser(List<String> list, Mode mode, String str) {
        Object asList;
        JSONObject createTestAccount;
        retrieveTestAccountsForAppIfNeeded();
        if (Utility.isNullOrEmpty((Collection) list)) {
            asList = Arrays.asList(new String[]{Scopes.EMAIL, "publish_actions"});
        } else {
            List<String> list2 = list;
        }
        if (mode == Mode.PRIVATE) {
            createTestAccount = createTestAccount(asList, mode, str);
        } else {
            createTestAccount = findOrCreateSharedTestAccount(asList, mode, str);
        }
        return new AccessToken(createTestAccount.optString(ServerProtocol.DIALOG_PARAM_ACCESS_TOKEN), this.testApplicationId, createTestAccount.optString(ShareConstants.WEB_DIALOG_PARAM_ID), asList, null, AccessTokenSource.TEST_USER, null, null);
    }

    private synchronized void retrieveTestAccountsForAppIfNeeded() {
        if (this.appTestAccounts == null) {
            this.appTestAccounts = new HashMap();
            GraphRequest.setDefaultBatchApplicationId(this.testApplicationId);
            Bundle bundle = new Bundle();
            bundle.putString(ServerProtocol.DIALOG_PARAM_ACCESS_TOKEN, getAppAccessToken());
            GraphRequest graphRequest = new GraphRequest(null, "app/accounts/test-users", bundle, null);
            graphRequest.setBatchEntryName("testUsers");
            graphRequest.setBatchEntryOmitResultOnSuccess($assertionsDisabled);
            bundle = new Bundle();
            bundle.putString(ServerProtocol.DIALOG_PARAM_ACCESS_TOKEN, getAppAccessToken());
            bundle.putString("ids", "{result=testUsers:$.data.*.id}");
            bundle.putString(GraphRequest.FIELDS_PARAM, ShareConstants.WEB_DIALOG_PARAM_NAME);
            new GraphRequest(null, BuildConfig.FLAVOR, bundle, null).setBatchEntryDependsOn("testUsers");
            List executeBatchAndWait = GraphRequest.executeBatchAndWait(graphRequest, r2);
            if (executeBatchAndWait == null || executeBatchAndWait.size() != 2) {
                throw new FacebookException("Unexpected number of results from TestUsers batch query");
            }
            populateTestAccounts(((GraphResponse) executeBatchAndWait.get(0)).getJSONObject().optJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA), ((GraphResponse) executeBatchAndWait.get(1)).getJSONObject());
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void populateTestAccounts(org.json.JSONArray r6, org.json.JSONObject r7) {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = 0;
        r1 = r0;
    L_0x0003:
        r0 = r6.length();	 Catch:{ all -> 0x0032 }
        if (r1 >= r0) goto L_0x0035;
    L_0x0009:
        r2 = r6.optJSONObject(r1);	 Catch:{ all -> 0x0032 }
        r0 = "id";
        r0 = r2.optString(r0);	 Catch:{ all -> 0x0032 }
        r0 = r7.optJSONObject(r0);	 Catch:{ all -> 0x0032 }
        r3 = "name";
        r4 = "name";
        r0 = r0.optString(r4);	 Catch:{ JSONException -> 0x0029 }
        r2.put(r3, r0);	 Catch:{ JSONException -> 0x0029 }
    L_0x0022:
        r5.storeTestAccount(r2);	 Catch:{ all -> 0x0032 }
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0003;
    L_0x0029:
        r0 = move-exception;
        r3 = "TestUserManager";
        r4 = "Could not set name";
        android.util.Log.e(r3, r4, r0);	 Catch:{ all -> 0x0032 }
        goto L_0x0022;
    L_0x0032:
        r0 = move-exception;
        monitor-exit(r5);
        throw r0;
    L_0x0035:
        monitor-exit(r5);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.TestUserManager.populateTestAccounts(org.json.JSONArray, org.json.JSONObject):void");
    }

    private synchronized void storeTestAccount(JSONObject jSONObject) {
        this.appTestAccounts.put(jSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_ID), jSONObject);
    }

    private synchronized JSONObject findTestAccountMatchingIdentifier(String str) {
        JSONObject jSONObject;
        for (JSONObject jSONObject2 : this.appTestAccounts.values()) {
            if (jSONObject2.optString(ShareConstants.WEB_DIALOG_PARAM_NAME).contains(str)) {
                break;
            }
        }
        jSONObject2 = null;
        return jSONObject2;
    }

    final String getAppAccessToken() {
        return this.testApplicationId + "|" + this.testApplicationSecret;
    }

    private JSONObject findOrCreateSharedTestAccount(List<String> list, Mode mode, String str) {
        JSONObject findTestAccountMatchingIdentifier = findTestAccountMatchingIdentifier(getSharedTestAccountIdentifier(list, str));
        return findTestAccountMatchingIdentifier != null ? findTestAccountMatchingIdentifier : createTestAccount(list, mode, str);
    }

    private String getSharedTestAccountIdentifier(List<String> list, String str) {
        return validNameStringFromInteger((str != null ? ((long) str.hashCode()) & 4294967295L : 0) ^ (((long) getPermissionsString(list).hashCode()) & 4294967295L));
    }

    private String validNameStringFromInteger(long j) {
        String l = Long.toString(j);
        StringBuilder stringBuilder = new StringBuilder("Perm");
        char[] toCharArray = l.toCharArray();
        int length = toCharArray.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = toCharArray[i];
            if (i3 == i2) {
                i3 = (char) (i3 + 10);
            }
            stringBuilder.append((char) ((i3 + 97) - 48));
            i++;
            i2 = i3;
        }
        return stringBuilder.toString();
    }

    private JSONObject createTestAccount(List<String> list, Mode mode, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("installed", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        bundle.putString(NativeProtocol.RESULT_ARGS_PERMISSIONS, getPermissionsString(list));
        bundle.putString(ServerProtocol.DIALOG_PARAM_ACCESS_TOKEN, getAppAccessToken());
        if (mode == Mode.SHARED) {
            bundle.putString(ShareConstants.WEB_DIALOG_PARAM_NAME, String.format("Shared %s Testuser", new Object[]{getSharedTestAccountIdentifier(list, str)}));
        }
        GraphResponse executeAndWait = new GraphRequest(null, String.format("%s/accounts/test-users", new Object[]{this.testApplicationId}), bundle, HttpMethod.POST).executeAndWait();
        FacebookRequestError error = executeAndWait.getError();
        JSONObject jSONObject = executeAndWait.getJSONObject();
        if (error != null) {
            return null;
        }
        if ($assertionsDisabled || jSONObject != null) {
            if (mode == Mode.SHARED) {
                try {
                    jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_NAME, bundle.getString(ShareConstants.WEB_DIALOG_PARAM_NAME));
                } catch (Throwable e) {
                    Log.e(LOG_TAG, "Could not set name", e);
                }
                storeTestAccount(jSONObject);
            }
            return jSONObject;
        }
        throw new AssertionError();
    }

    private String getPermissionsString(List<String> list) {
        return TextUtils.join(",", list);
    }
}
