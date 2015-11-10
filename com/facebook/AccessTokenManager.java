package com.facebook;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import com.facebook.GraphRequest.Callback;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.share.internal.ShareConstants;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

final class AccessTokenManager {
    static final String ACTION_CURRENT_ACCESS_TOKEN_CHANGED = "com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED";
    static final String EXTRA_NEW_ACCESS_TOKEN = "com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN";
    static final String EXTRA_OLD_ACCESS_TOKEN = "com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN";
    private static final String ME_PERMISSIONS_GRAPH_PATH = "me/permissions";
    static final String SHARED_PREFERENCES_NAME = "com.facebook.AccessTokenManager.SharedPreferences";
    static final String TAG = "AccessTokenManager";
    private static final String TOKEN_EXTEND_GRAPH_PATH = "oauth/access_token";
    private static final int TOKEN_EXTEND_RETRY_SECONDS = 3600;
    private static final int TOKEN_EXTEND_THRESHOLD_SECONDS = 86400;
    private static volatile AccessTokenManager instance;
    private final AccessTokenCache accessTokenCache;
    private AccessToken currentAccessToken;
    private Date lastAttemptedTokenExtendDate;
    private final LocalBroadcastManager localBroadcastManager;
    private AtomicBoolean tokenRefreshInProgress;

    /* renamed from: com.facebook.AccessTokenManager.1 */
    class C04871 implements Runnable {
        C04871() {
        }

        public void run() {
            AccessTokenManager.this.refreshCurrentAccessTokenImpl();
        }
    }

    /* renamed from: com.facebook.AccessTokenManager.2 */
    class C04882 implements Callback {
        final /* synthetic */ Set val$declinedPermissions;
        final /* synthetic */ Set val$permissions;
        final /* synthetic */ AtomicBoolean val$permissionsCallSucceeded;

        C04882(AtomicBoolean atomicBoolean, Set set, Set set2) {
            this.val$permissionsCallSucceeded = atomicBoolean;
            this.val$permissions = set;
            this.val$declinedPermissions = set2;
        }

        public void onCompleted(GraphResponse graphResponse) {
            JSONObject jSONObject = graphResponse.getJSONObject();
            if (jSONObject != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray(ShareConstants.WEB_DIALOG_PARAM_DATA);
                if (optJSONArray != null) {
                    this.val$permissionsCallSucceeded.set(true);
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString("permission");
                            String optString2 = optJSONObject.optString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
                            if (!(Utility.isNullOrEmpty(optString) || Utility.isNullOrEmpty(optString2))) {
                                optString2 = optString2.toLowerCase(Locale.US);
                                if (optString2.equals("granted")) {
                                    this.val$permissions.add(optString);
                                } else if (optString2.equals("declined")) {
                                    this.val$declinedPermissions.add(optString);
                                } else {
                                    Log.w(AccessTokenManager.TAG, "Unexpected status: " + optString2);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: com.facebook.AccessTokenManager.3 */
    class C04893 implements Callback {
        final /* synthetic */ RefreshResult val$refreshResult;

        C04893(RefreshResult refreshResult) {
            this.val$refreshResult = refreshResult;
        }

        public void onCompleted(GraphResponse graphResponse) {
            JSONObject jSONObject = graphResponse.getJSONObject();
            if (jSONObject != null) {
                this.val$refreshResult.accessToken = jSONObject.optString(ServerProtocol.DIALOG_PARAM_ACCESS_TOKEN);
                this.val$refreshResult.expiresAt = jSONObject.optInt("expires_at");
            }
        }
    }

    /* renamed from: com.facebook.AccessTokenManager.4 */
    class C04904 implements GraphRequestBatch.Callback {
        final /* synthetic */ AccessToken val$accessToken;
        final /* synthetic */ Set val$declinedPermissions;
        final /* synthetic */ Set val$permissions;
        final /* synthetic */ AtomicBoolean val$permissionsCallSucceeded;
        final /* synthetic */ RefreshResult val$refreshResult;

        C04904(AccessToken accessToken, AtomicBoolean atomicBoolean, RefreshResult refreshResult, Set set, Set set2) {
            this.val$accessToken = accessToken;
            this.val$permissionsCallSucceeded = atomicBoolean;
            this.val$refreshResult = refreshResult;
            this.val$permissions = set;
            this.val$declinedPermissions = set2;
        }

        public void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
            if (AccessTokenManager.getInstance().getCurrentAccessToken() != null && AccessTokenManager.getInstance().getCurrentAccessToken().getUserId() == this.val$accessToken.getUserId()) {
                try {
                    if (this.val$permissionsCallSucceeded.get() || this.val$refreshResult.accessToken != null || this.val$refreshResult.expiresAt != 0) {
                        String str;
                        Collection collection;
                        Collection collection2;
                        Date date;
                        if (this.val$refreshResult.accessToken != null) {
                            str = this.val$refreshResult.accessToken;
                        } else {
                            str = this.val$accessToken.getToken();
                        }
                        String applicationId = this.val$accessToken.getApplicationId();
                        String userId = this.val$accessToken.getUserId();
                        if (this.val$permissionsCallSucceeded.get()) {
                            collection = this.val$permissions;
                        } else {
                            collection = this.val$accessToken.getPermissions();
                        }
                        if (this.val$permissionsCallSucceeded.get()) {
                            collection2 = this.val$declinedPermissions;
                        } else {
                            collection2 = this.val$accessToken.getDeclinedPermissions();
                        }
                        AccessTokenSource source = this.val$accessToken.getSource();
                        if (this.val$refreshResult.expiresAt != 0) {
                            date = new Date(((long) this.val$refreshResult.expiresAt) * 1000);
                        } else {
                            date = this.val$accessToken.getExpires();
                        }
                        AccessTokenManager.getInstance().setCurrentAccessToken(new AccessToken(str, applicationId, userId, collection, collection2, source, date, new Date()));
                        AccessTokenManager.this.tokenRefreshInProgress.set(false);
                    }
                } finally {
                    AccessTokenManager.this.tokenRefreshInProgress.set(false);
                }
            }
        }
    }

    private static class RefreshResult {
        public String accessToken;
        public int expiresAt;

        private RefreshResult() {
        }
    }

    AccessTokenManager(LocalBroadcastManager localBroadcastManager, AccessTokenCache accessTokenCache) {
        this.tokenRefreshInProgress = new AtomicBoolean(false);
        this.lastAttemptedTokenExtendDate = new Date(0);
        Validate.notNull(localBroadcastManager, "localBroadcastManager");
        Validate.notNull(accessTokenCache, "accessTokenCache");
        this.localBroadcastManager = localBroadcastManager;
        this.accessTokenCache = accessTokenCache;
    }

    static AccessTokenManager getInstance() {
        if (instance == null) {
            synchronized (AccessTokenManager.class) {
                if (instance == null) {
                    instance = new AccessTokenManager(LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext()), new AccessTokenCache());
                }
            }
        }
        return instance;
    }

    AccessToken getCurrentAccessToken() {
        return this.currentAccessToken;
    }

    boolean loadCurrentAccessToken() {
        AccessToken load = this.accessTokenCache.load();
        if (load == null) {
            return false;
        }
        setCurrentAccessToken(load, false);
        return true;
    }

    void setCurrentAccessToken(AccessToken accessToken) {
        setCurrentAccessToken(accessToken, true);
    }

    private void setCurrentAccessToken(AccessToken accessToken, boolean z) {
        AccessToken accessToken2 = this.currentAccessToken;
        this.currentAccessToken = accessToken;
        this.tokenRefreshInProgress.set(false);
        this.lastAttemptedTokenExtendDate = new Date(0);
        if (z) {
            if (accessToken != null) {
                this.accessTokenCache.save(accessToken);
            } else {
                this.accessTokenCache.clear();
                Utility.clearFacebookCookies(FacebookSdk.getApplicationContext());
            }
        }
        if (!Utility.areObjectsEqual(accessToken2, accessToken)) {
            sendCurrentAccessTokenChangedBroadcast(accessToken2, accessToken);
        }
    }

    private void sendCurrentAccessTokenChangedBroadcast(AccessToken accessToken, AccessToken accessToken2) {
        Intent intent = new Intent(ACTION_CURRENT_ACCESS_TOKEN_CHANGED);
        intent.putExtra(EXTRA_OLD_ACCESS_TOKEN, accessToken);
        intent.putExtra(EXTRA_NEW_ACCESS_TOKEN, accessToken2);
        this.localBroadcastManager.sendBroadcast(intent);
    }

    void extendAccessTokenIfNeeded() {
        if (shouldExtendAccessToken()) {
            refreshCurrentAccessToken();
        }
    }

    private boolean shouldExtendAccessToken() {
        if (this.currentAccessToken == null) {
            return false;
        }
        Long valueOf = Long.valueOf(new Date().getTime());
        if (!this.currentAccessToken.getSource().canExtendToken() || valueOf.longValue() - this.lastAttemptedTokenExtendDate.getTime() <= 3600000 || valueOf.longValue() - this.currentAccessToken.getLastRefresh().getTime() <= 86400000) {
            return false;
        }
        return true;
    }

    private static GraphRequest createGrantedPermissionsRequest(AccessToken accessToken, Callback callback) {
        return new GraphRequest(accessToken, ME_PERMISSIONS_GRAPH_PATH, new Bundle(), HttpMethod.GET, callback);
    }

    private static GraphRequest createExtendAccessTokenRequest(AccessToken accessToken, Callback callback) {
        Bundle bundle = new Bundle();
        bundle.putString("grant_type", "fb_extend_sso_token");
        return new GraphRequest(accessToken, TOKEN_EXTEND_GRAPH_PATH, bundle, HttpMethod.GET, callback);
    }

    void refreshCurrentAccessToken() {
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            refreshCurrentAccessTokenImpl();
        } else {
            new Handler(Looper.getMainLooper()).post(new C04871());
        }
    }

    private void refreshCurrentAccessTokenImpl() {
        AccessToken accessToken = this.currentAccessToken;
        if (accessToken != null && this.tokenRefreshInProgress.compareAndSet(false, true)) {
            Validate.runningOnUiThread();
            this.lastAttemptedTokenExtendDate = new Date();
            Set hashSet = new HashSet();
            Set hashSet2 = new HashSet();
            GraphRequestBatch graphRequestBatch = new GraphRequestBatch(createGrantedPermissionsRequest(accessToken, new C04882(new AtomicBoolean(false), hashSet, hashSet2)), createExtendAccessTokenRequest(accessToken, new C04893(new RefreshResult())));
            graphRequestBatch.addCallback(new C04904(accessToken, r3, r4, hashSet, hashSet2));
            graphRequestBatch.executeAsync();
        }
    }
}
