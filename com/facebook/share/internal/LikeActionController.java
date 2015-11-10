package com.facebook.share.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.GraphRequestBatch.Callback;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.AppCall;
import com.facebook.internal.BundleJSONConverter;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.FileLruCache;
import com.facebook.internal.FileLruCache.Limits;
import com.facebook.internal.Logger;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient.CompletedListener;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.WorkQueue;
import com.facebook.share.internal.LikeContent.Builder;
import com.facebook.share.widget.LikeView.ObjectType;
import com.facebook.stetho.BuildConfig;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

public class LikeActionController {
    public static final String ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR = "com.facebook.sdk.LikeActionController.DID_ERROR";
    public static final String ACTION_LIKE_ACTION_CONTROLLER_DID_RESET = "com.facebook.sdk.LikeActionController.DID_RESET";
    public static final String ACTION_LIKE_ACTION_CONTROLLER_UPDATED = "com.facebook.sdk.LikeActionController.UPDATED";
    public static final String ACTION_OBJECT_ID_KEY = "com.facebook.sdk.LikeActionController.OBJECT_ID";
    private static final int ERROR_CODE_OBJECT_ALREADY_LIKED = 3501;
    public static final String ERROR_INVALID_OBJECT_ID = "Invalid Object Id";
    public static final String ERROR_PUBLISH_ERROR = "Unable to publish the like/unlike action";
    private static final String JSON_BOOL_IS_OBJECT_LIKED_KEY = "is_object_liked";
    private static final String JSON_BUNDLE_FACEBOOK_DIALOG_ANALYTICS_BUNDLE = "facebook_dialog_analytics_bundle";
    private static final String JSON_INT_OBJECT_TYPE_KEY = "object_type";
    private static final String JSON_INT_VERSION_KEY = "com.facebook.share.internal.LikeActionController.version";
    private static final String JSON_STRING_LIKE_COUNT_WITHOUT_LIKE_KEY = "like_count_string_without_like";
    private static final String JSON_STRING_LIKE_COUNT_WITH_LIKE_KEY = "like_count_string_with_like";
    private static final String JSON_STRING_OBJECT_ID_KEY = "object_id";
    private static final String JSON_STRING_SOCIAL_SENTENCE_WITHOUT_LIKE_KEY = "social_sentence_without_like";
    private static final String JSON_STRING_SOCIAL_SENTENCE_WITH_LIKE_KEY = "social_sentence_with_like";
    private static final String JSON_STRING_UNLIKE_TOKEN_KEY = "unlike_token";
    private static final String LIKE_ACTION_CONTROLLER_STORE = "com.facebook.LikeActionController.CONTROLLER_STORE_KEY";
    private static final String LIKE_ACTION_CONTROLLER_STORE_OBJECT_SUFFIX_KEY = "OBJECT_SUFFIX";
    private static final String LIKE_ACTION_CONTROLLER_STORE_PENDING_OBJECT_ID_KEY = "PENDING_CONTROLLER_KEY";
    private static final int LIKE_ACTION_CONTROLLER_VERSION = 3;
    private static final String LIKE_DIALOG_RESPONSE_LIKE_COUNT_STRING_KEY = "like_count_string";
    private static final String LIKE_DIALOG_RESPONSE_OBJECT_IS_LIKED_KEY = "object_is_liked";
    private static final String LIKE_DIALOG_RESPONSE_SOCIAL_SENTENCE_KEY = "social_sentence";
    private static final String LIKE_DIALOG_RESPONSE_UNLIKE_TOKEN_KEY = "unlike_token";
    private static final int MAX_CACHE_SIZE = 128;
    private static final int MAX_OBJECT_SUFFIX = 1000;
    private static final String TAG;
    private static AccessTokenTracker accessTokenTracker;
    private static final ConcurrentHashMap<String, LikeActionController> cache;
    private static FileLruCache controllerDiskCache;
    private static WorkQueue diskIOWorkQueue;
    private static Handler handler;
    private static boolean isInitialized;
    private static WorkQueue mruCacheWorkQueue;
    private static String objectIdForPendingController;
    private static volatile int objectSuffix;
    private AppEventsLogger appEventsLogger;
    private Bundle facebookDialogAnalyticsBundle;
    private boolean isObjectLiked;
    private boolean isObjectLikedOnServer;
    private boolean isPendingLikeOrUnlike;
    private String likeCountStringWithLike;
    private String likeCountStringWithoutLike;
    private String objectId;
    private boolean objectIsPage;
    private ObjectType objectType;
    private String socialSentenceWithLike;
    private String socialSentenceWithoutLike;
    private String unlikeToken;
    private String verifiedObjectId;

    /* renamed from: com.facebook.share.internal.LikeActionController.11 */
    class AnonymousClass11 implements Callback {
        final /* synthetic */ RequestCompletionCallback val$completionHandler;
        final /* synthetic */ GetOGObjectIdRequestWrapper val$objectIdRequest;
        final /* synthetic */ GetPageIdRequestWrapper val$pageIdRequest;

        AnonymousClass11(GetOGObjectIdRequestWrapper getOGObjectIdRequestWrapper, GetPageIdRequestWrapper getPageIdRequestWrapper, RequestCompletionCallback requestCompletionCallback) {
            this.val$objectIdRequest = getOGObjectIdRequestWrapper;
            this.val$pageIdRequest = getPageIdRequestWrapper;
            this.val$completionHandler = requestCompletionCallback;
        }

        public void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
            LikeActionController.this.verifiedObjectId = this.val$objectIdRequest.verifiedObjectId;
            if (Utility.isNullOrEmpty(LikeActionController.this.verifiedObjectId)) {
                LikeActionController.this.verifiedObjectId = this.val$pageIdRequest.verifiedObjectId;
                LikeActionController.this.objectIsPage = this.val$pageIdRequest.objectIsPage;
            }
            if (Utility.isNullOrEmpty(LikeActionController.this.verifiedObjectId)) {
                FacebookRequestError error;
                Logger.log(LoggingBehavior.DEVELOPER_ERRORS, LikeActionController.TAG, "Unable to verify the FB id for '%s'. Verify that it is a valid FB object or page", LikeActionController.this.objectId);
                LikeActionController likeActionController = LikeActionController.this;
                String str = "get_verified_id";
                if (this.val$pageIdRequest.getError() != null) {
                    error = this.val$pageIdRequest.getError();
                } else {
                    error = this.val$objectIdRequest.getError();
                }
                likeActionController.logAppEventForError(str, error);
            }
            if (this.val$completionHandler != null) {
                this.val$completionHandler.onComplete();
            }
        }
    }

    /* renamed from: com.facebook.share.internal.LikeActionController.12 */
    static /* synthetic */ class AnonymousClass12 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$share$widget$LikeView$ObjectType;

        static {
            $SwitchMap$com$facebook$share$widget$LikeView$ObjectType = new int[ObjectType.values().length];
            try {
                $SwitchMap$com$facebook$share$widget$LikeView$ObjectType[ObjectType.PAGE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    public interface CreationCallback {
        void onComplete(LikeActionController likeActionController, FacebookException facebookException);
    }

    /* renamed from: com.facebook.share.internal.LikeActionController.1 */
    static class C05971 implements CreationCallback {
        final /* synthetic */ Intent val$data;
        final /* synthetic */ int val$requestCode;
        final /* synthetic */ int val$resultCode;

        C05971(int i, int i2, Intent intent) {
            this.val$requestCode = i;
            this.val$resultCode = i2;
            this.val$data = intent;
        }

        public void onComplete(LikeActionController likeActionController, FacebookException facebookException) {
            if (facebookException == null) {
                likeActionController.onActivityResult(this.val$requestCode, this.val$resultCode, this.val$data);
            } else {
                Utility.logd(LikeActionController.TAG, (Exception) facebookException);
            }
        }
    }

    /* renamed from: com.facebook.share.internal.LikeActionController.2 */
    static class C05982 implements Runnable {
        final /* synthetic */ LikeActionController val$controllerToRefresh;

        C05982(LikeActionController likeActionController) {
            this.val$controllerToRefresh = likeActionController;
        }

        public void run() {
            this.val$controllerToRefresh.refreshStatusAsync();
        }
    }

    /* renamed from: com.facebook.share.internal.LikeActionController.3 */
    static class C05993 implements CallbackManagerImpl.Callback {
        C05993() {
        }

        public boolean onActivityResult(int i, Intent intent) {
            return LikeActionController.handleOnActivityResult(RequestCodeOffset.Like.toRequestCode(), i, intent);
        }
    }

    /* renamed from: com.facebook.share.internal.LikeActionController.4 */
    static class C06004 implements Runnable {
        final /* synthetic */ CreationCallback val$callback;
        final /* synthetic */ LikeActionController val$controller;
        final /* synthetic */ FacebookException val$error;

        C06004(CreationCallback creationCallback, LikeActionController likeActionController, FacebookException facebookException) {
            this.val$callback = creationCallback;
            this.val$controller = likeActionController;
            this.val$error = facebookException;
        }

        public void run() {
            this.val$callback.onComplete(this.val$controller, this.val$error);
        }
    }

    /* renamed from: com.facebook.share.internal.LikeActionController.5 */
    static class C06015 extends AccessTokenTracker {
        C06015() {
        }

        protected void onCurrentAccessTokenChanged(AccessToken accessToken, AccessToken accessToken2) {
            Context applicationContext = FacebookSdk.getApplicationContext();
            if (accessToken2 == null) {
                LikeActionController.objectSuffix = (LikeActionController.objectSuffix + 1) % LikeActionController.MAX_OBJECT_SUFFIX;
                applicationContext.getSharedPreferences(LikeActionController.LIKE_ACTION_CONTROLLER_STORE, 0).edit().putInt(LikeActionController.LIKE_ACTION_CONTROLLER_STORE_OBJECT_SUFFIX_KEY, LikeActionController.objectSuffix).apply();
                LikeActionController.cache.clear();
                LikeActionController.controllerDiskCache.clearCache();
            }
            LikeActionController.broadcastAction(null, LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_RESET);
        }
    }

    /* renamed from: com.facebook.share.internal.LikeActionController.6 */
    class C06026 extends ResultProcessor {
        final /* synthetic */ Bundle val$analyticsParameters;

        C06026(FacebookCallback facebookCallback, Bundle bundle) {
            this.val$analyticsParameters = bundle;
            super(facebookCallback);
        }

        public void onSuccess(AppCall appCall, Bundle bundle) {
            if (bundle != null && bundle.containsKey(LikeActionController.LIKE_DIALOG_RESPONSE_OBJECT_IS_LIKED_KEY)) {
                String string;
                boolean z = bundle.getBoolean(LikeActionController.LIKE_DIALOG_RESPONSE_OBJECT_IS_LIKED_KEY);
                String access$700 = LikeActionController.this.likeCountStringWithLike;
                String access$800 = LikeActionController.this.likeCountStringWithoutLike;
                if (bundle.containsKey(LikeActionController.LIKE_DIALOG_RESPONSE_LIKE_COUNT_STRING_KEY)) {
                    access$800 = bundle.getString(LikeActionController.LIKE_DIALOG_RESPONSE_LIKE_COUNT_STRING_KEY);
                    access$700 = access$800;
                }
                String access$900 = LikeActionController.this.socialSentenceWithLike;
                String access$1000 = LikeActionController.this.socialSentenceWithoutLike;
                if (bundle.containsKey(LikeActionController.LIKE_DIALOG_RESPONSE_SOCIAL_SENTENCE_KEY)) {
                    access$1000 = bundle.getString(LikeActionController.LIKE_DIALOG_RESPONSE_SOCIAL_SENTENCE_KEY);
                    access$900 = access$1000;
                }
                if (bundle.containsKey(LikeActionController.LIKE_DIALOG_RESPONSE_OBJECT_IS_LIKED_KEY)) {
                    string = bundle.getString(LikeActionController.LIKE_DIALOG_RESPONSE_UNLIKE_TOKEN_KEY);
                } else {
                    string = LikeActionController.this.unlikeToken;
                }
                Bundle bundle2 = this.val$analyticsParameters == null ? new Bundle() : this.val$analyticsParameters;
                bundle2.putString(AnalyticsEvents.PARAMETER_CALL_ID, appCall.getCallId().toString());
                LikeActionController.this.getAppEventsLogger().logSdkEvent(AnalyticsEvents.EVENT_LIKE_VIEW_DIALOG_DID_SUCCEED, null, bundle2);
                LikeActionController.this.updateState(z, access$700, access$800, access$900, access$1000, string);
            }
        }

        public void onError(AppCall appCall, FacebookException facebookException) {
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Like Dialog failed with error : %s", facebookException);
            Bundle bundle = this.val$analyticsParameters == null ? new Bundle() : this.val$analyticsParameters;
            bundle.putString(AnalyticsEvents.PARAMETER_CALL_ID, appCall.getCallId().toString());
            LikeActionController.this.logAppEventForError("present_dialog", bundle);
            LikeActionController.broadcastAction(LikeActionController.this, LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR, NativeProtocol.createBundleForException(facebookException));
        }

        public void onCancel(AppCall appCall) {
            onError(appCall, new FacebookOperationCanceledException());
        }
    }

    private interface RequestCompletionCallback {
        void onComplete();
    }

    /* renamed from: com.facebook.share.internal.LikeActionController.7 */
    class C06047 implements RequestCompletionCallback {
        final /* synthetic */ Bundle val$analyticsParameters;

        /* renamed from: com.facebook.share.internal.LikeActionController.7.1 */
        class C06031 implements Callback {
            final /* synthetic */ PublishLikeRequestWrapper val$likeRequest;

            C06031(PublishLikeRequestWrapper publishLikeRequestWrapper) {
                this.val$likeRequest = publishLikeRequestWrapper;
            }

            public void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
                LikeActionController.this.isPendingLikeOrUnlike = false;
                if (this.val$likeRequest.getError() != null) {
                    LikeActionController.this.publishDidError(false);
                    return;
                }
                LikeActionController.this.unlikeToken = Utility.coerceValueIfNullOrEmpty(this.val$likeRequest.unlikeToken, null);
                LikeActionController.this.isObjectLikedOnServer = true;
                LikeActionController.this.getAppEventsLogger().logSdkEvent(AnalyticsEvents.EVENT_LIKE_VIEW_DID_LIKE, null, C06047.this.val$analyticsParameters);
                LikeActionController.this.publishAgainIfNeeded(C06047.this.val$analyticsParameters);
            }
        }

        C06047(Bundle bundle) {
            this.val$analyticsParameters = bundle;
        }

        public void onComplete() {
            if (Utility.isNullOrEmpty(LikeActionController.this.verifiedObjectId)) {
                Bundle bundle = new Bundle();
                bundle.putString(NativeProtocol.STATUS_ERROR_DESCRIPTION, LikeActionController.ERROR_INVALID_OBJECT_ID);
                LikeActionController.broadcastAction(LikeActionController.this, LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR, bundle);
                return;
            }
            GraphRequestBatch graphRequestBatch = new GraphRequestBatch();
            PublishLikeRequestWrapper publishLikeRequestWrapper = new PublishLikeRequestWrapper(LikeActionController.this.verifiedObjectId, LikeActionController.this.objectType);
            publishLikeRequestWrapper.addToBatch(graphRequestBatch);
            graphRequestBatch.addCallback(new C06031(publishLikeRequestWrapper));
            graphRequestBatch.executeAsync();
        }
    }

    /* renamed from: com.facebook.share.internal.LikeActionController.8 */
    class C06058 implements Callback {
        final /* synthetic */ Bundle val$analyticsParameters;
        final /* synthetic */ PublishUnlikeRequestWrapper val$unlikeRequest;

        C06058(PublishUnlikeRequestWrapper publishUnlikeRequestWrapper, Bundle bundle) {
            this.val$unlikeRequest = publishUnlikeRequestWrapper;
            this.val$analyticsParameters = bundle;
        }

        public void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
            LikeActionController.this.isPendingLikeOrUnlike = false;
            if (this.val$unlikeRequest.getError() != null) {
                LikeActionController.this.publishDidError(true);
                return;
            }
            LikeActionController.this.unlikeToken = null;
            LikeActionController.this.isObjectLikedOnServer = false;
            LikeActionController.this.getAppEventsLogger().logSdkEvent(AnalyticsEvents.EVENT_LIKE_VIEW_DID_UNLIKE, null, this.val$analyticsParameters);
            LikeActionController.this.publishAgainIfNeeded(this.val$analyticsParameters);
        }
    }

    /* renamed from: com.facebook.share.internal.LikeActionController.9 */
    class C06079 implements RequestCompletionCallback {

        /* renamed from: com.facebook.share.internal.LikeActionController.9.1 */
        class C06061 implements Callback {
            final /* synthetic */ GetEngagementRequestWrapper val$engagementRequest;
            final /* synthetic */ LikeRequestWrapper val$likeRequestWrapper;

            C06061(LikeRequestWrapper likeRequestWrapper, GetEngagementRequestWrapper getEngagementRequestWrapper) {
                this.val$likeRequestWrapper = likeRequestWrapper;
                this.val$engagementRequest = getEngagementRequestWrapper;
            }

            public void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
                if (this.val$likeRequestWrapper.getError() == null && this.val$engagementRequest.getError() == null) {
                    LikeActionController.this.updateState(this.val$likeRequestWrapper.isObjectLiked(), this.val$engagementRequest.likeCountStringWithLike, this.val$engagementRequest.likeCountStringWithoutLike, this.val$engagementRequest.socialSentenceStringWithLike, this.val$engagementRequest.socialSentenceStringWithoutLike, this.val$likeRequestWrapper.getUnlikeToken());
                    return;
                }
                Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Unable to refresh like state for id: '%s'", LikeActionController.this.objectId);
            }
        }

        C06079() {
        }

        public void onComplete() {
            LikeRequestWrapper getPageLikesRequestWrapper;
            switch (AnonymousClass12.$SwitchMap$com$facebook$share$widget$LikeView$ObjectType[LikeActionController.this.objectType.ordinal()]) {
                case C3374b.SmoothProgressBar_spb_color /*1*/:
                    getPageLikesRequestWrapper = new GetPageLikesRequestWrapper(LikeActionController.this.verifiedObjectId);
                    break;
                default:
                    getPageLikesRequestWrapper = new GetOGObjectLikesRequestWrapper(LikeActionController.this.verifiedObjectId, LikeActionController.this.objectType);
                    break;
            }
            GetEngagementRequestWrapper getEngagementRequestWrapper = new GetEngagementRequestWrapper(LikeActionController.this.verifiedObjectId, LikeActionController.this.objectType);
            GraphRequestBatch graphRequestBatch = new GraphRequestBatch();
            getPageLikesRequestWrapper.addToBatch(graphRequestBatch);
            getEngagementRequestWrapper.addToBatch(graphRequestBatch);
            graphRequestBatch.addCallback(new C06061(getPageLikesRequestWrapper, getEngagementRequestWrapper));
            graphRequestBatch.executeAsync();
        }
    }

    private interface RequestWrapper {
        void addToBatch(GraphRequestBatch graphRequestBatch);

        FacebookRequestError getError();
    }

    private abstract class AbstractRequestWrapper implements RequestWrapper {
        protected FacebookRequestError error;
        protected String objectId;
        protected ObjectType objectType;
        private GraphRequest request;

        /* renamed from: com.facebook.share.internal.LikeActionController.AbstractRequestWrapper.1 */
        class C06081 implements GraphRequest.Callback {
            C06081() {
            }

            public void onCompleted(GraphResponse graphResponse) {
                AbstractRequestWrapper.this.error = graphResponse.getError();
                if (AbstractRequestWrapper.this.error != null) {
                    AbstractRequestWrapper.this.processError(AbstractRequestWrapper.this.error);
                } else {
                    AbstractRequestWrapper.this.processSuccess(graphResponse);
                }
            }
        }

        protected abstract void processSuccess(GraphResponse graphResponse);

        protected AbstractRequestWrapper(String str, ObjectType objectType) {
            this.objectId = str;
            this.objectType = objectType;
        }

        public void addToBatch(GraphRequestBatch graphRequestBatch) {
            graphRequestBatch.add(this.request);
        }

        public FacebookRequestError getError() {
            return this.error;
        }

        protected void setRequest(GraphRequest graphRequest) {
            this.request = graphRequest;
            graphRequest.setVersion(ServerProtocol.GRAPH_API_VERSION);
            graphRequest.setCallback(new C06081());
        }

        protected void processError(FacebookRequestError facebookRequestError) {
            Object[] objArr = new Object[LikeActionController.LIKE_ACTION_CONTROLLER_VERSION];
            objArr[0] = this.objectId;
            objArr[1] = this.objectType;
            objArr[2] = facebookRequestError;
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error running request for object '%s' with type '%s' : %s", objArr);
        }
    }

    private static class CreateLikeActionControllerWorkItem implements Runnable {
        private CreationCallback callback;
        private String objectId;
        private ObjectType objectType;

        CreateLikeActionControllerWorkItem(String str, ObjectType objectType, CreationCallback creationCallback) {
            this.objectId = str;
            this.objectType = objectType;
            this.callback = creationCallback;
        }

        public void run() {
            LikeActionController.createControllerForObjectIdAndType(this.objectId, this.objectType, this.callback);
        }
    }

    private class GetEngagementRequestWrapper extends AbstractRequestWrapper {
        String likeCountStringWithLike;
        String likeCountStringWithoutLike;
        String socialSentenceStringWithLike;
        String socialSentenceStringWithoutLike;

        GetEngagementRequestWrapper(String str, ObjectType objectType) {
            super(str, objectType);
            this.likeCountStringWithLike = LikeActionController.this.likeCountStringWithLike;
            this.likeCountStringWithoutLike = LikeActionController.this.likeCountStringWithoutLike;
            this.socialSentenceStringWithLike = LikeActionController.this.socialSentenceWithLike;
            this.socialSentenceStringWithoutLike = LikeActionController.this.socialSentenceWithoutLike;
            Bundle bundle = new Bundle();
            bundle.putString(GraphRequest.FIELDS_PARAM, "engagement.fields(count_string_with_like,count_string_without_like,social_sentence_with_like,social_sentence_without_like)");
            setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), str, bundle, HttpMethod.GET));
        }

        protected void processSuccess(GraphResponse graphResponse) {
            JSONObject tryGetJSONObjectFromResponse = Utility.tryGetJSONObjectFromResponse(graphResponse.getJSONObject(), "engagement");
            if (tryGetJSONObjectFromResponse != null) {
                this.likeCountStringWithLike = tryGetJSONObjectFromResponse.optString("count_string_with_like", this.likeCountStringWithLike);
                this.likeCountStringWithoutLike = tryGetJSONObjectFromResponse.optString("count_string_without_like", this.likeCountStringWithoutLike);
                this.socialSentenceStringWithLike = tryGetJSONObjectFromResponse.optString(LikeActionController.JSON_STRING_SOCIAL_SENTENCE_WITH_LIKE_KEY, this.socialSentenceStringWithLike);
                this.socialSentenceStringWithoutLike = tryGetJSONObjectFromResponse.optString(LikeActionController.JSON_STRING_SOCIAL_SENTENCE_WITHOUT_LIKE_KEY, this.socialSentenceStringWithoutLike);
            }
        }

        protected void processError(FacebookRequestError facebookRequestError) {
            Object[] objArr = new Object[LikeActionController.LIKE_ACTION_CONTROLLER_VERSION];
            objArr[0] = this.objectId;
            objArr[1] = this.objectType;
            objArr[2] = facebookRequestError;
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error fetching engagement for object '%s' with type '%s' : %s", objArr);
            LikeActionController.this.logAppEventForError("get_engagement", facebookRequestError);
        }
    }

    private class GetOGObjectIdRequestWrapper extends AbstractRequestWrapper {
        String verifiedObjectId;

        GetOGObjectIdRequestWrapper(String str, ObjectType objectType) {
            super(str, objectType);
            Bundle bundle = new Bundle();
            bundle.putString(GraphRequest.FIELDS_PARAM, "og_object.fields(id)");
            bundle.putString("ids", str);
            setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), BuildConfig.FLAVOR, bundle, HttpMethod.GET));
        }

        protected void processError(FacebookRequestError facebookRequestError) {
            if (facebookRequestError.getErrorMessage().contains("og_object")) {
                this.error = null;
                return;
            }
            Object[] objArr = new Object[LikeActionController.LIKE_ACTION_CONTROLLER_VERSION];
            objArr[0] = this.objectId;
            objArr[1] = this.objectType;
            objArr[2] = facebookRequestError;
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error getting the FB id for object '%s' with type '%s' : %s", objArr);
        }

        protected void processSuccess(GraphResponse graphResponse) {
            JSONObject tryGetJSONObjectFromResponse = Utility.tryGetJSONObjectFromResponse(graphResponse.getJSONObject(), this.objectId);
            if (tryGetJSONObjectFromResponse != null) {
                tryGetJSONObjectFromResponse = tryGetJSONObjectFromResponse.optJSONObject("og_object");
                if (tryGetJSONObjectFromResponse != null) {
                    this.verifiedObjectId = tryGetJSONObjectFromResponse.optString(ShareConstants.WEB_DIALOG_PARAM_ID);
                }
            }
        }
    }

    private interface LikeRequestWrapper extends RequestWrapper {
        String getUnlikeToken();

        boolean isObjectLiked();
    }

    private class GetOGObjectLikesRequestWrapper extends AbstractRequestWrapper implements LikeRequestWrapper {
        private final String objectId;
        private boolean objectIsLiked;
        private final ObjectType objectType;
        private String unlikeToken;

        GetOGObjectLikesRequestWrapper(String str, ObjectType objectType) {
            super(str, objectType);
            this.objectIsLiked = LikeActionController.this.isObjectLiked;
            this.objectId = str;
            this.objectType = objectType;
            Bundle bundle = new Bundle();
            bundle.putString(GraphRequest.FIELDS_PARAM, "id,application");
            bundle.putString("object", this.objectId);
            setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "me/og.likes", bundle, HttpMethod.GET));
        }

        protected void processSuccess(GraphResponse graphResponse) {
            JSONArray tryGetJSONArrayFromResponse = Utility.tryGetJSONArrayFromResponse(graphResponse.getJSONObject(), ShareConstants.WEB_DIALOG_PARAM_DATA);
            if (tryGetJSONArrayFromResponse != null) {
                for (int i = 0; i < tryGetJSONArrayFromResponse.length(); i++) {
                    JSONObject optJSONObject = tryGetJSONArrayFromResponse.optJSONObject(i);
                    if (optJSONObject != null) {
                        this.objectIsLiked = true;
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("application");
                        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
                        if (!(optJSONObject2 == null || currentAccessToken == null || !Utility.areObjectsEqual(currentAccessToken.getApplicationId(), optJSONObject2.optString(ShareConstants.WEB_DIALOG_PARAM_ID)))) {
                            this.unlikeToken = optJSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_ID);
                        }
                    }
                }
            }
        }

        protected void processError(FacebookRequestError facebookRequestError) {
            Object[] objArr = new Object[LikeActionController.LIKE_ACTION_CONTROLLER_VERSION];
            objArr[0] = this.objectId;
            objArr[1] = this.objectType;
            objArr[2] = facebookRequestError;
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error fetching like status for object '%s' with type '%s' : %s", objArr);
            LikeActionController.this.logAppEventForError("get_og_object_like", facebookRequestError);
        }

        public boolean isObjectLiked() {
            return this.objectIsLiked;
        }

        public String getUnlikeToken() {
            return this.unlikeToken;
        }
    }

    private class GetPageIdRequestWrapper extends AbstractRequestWrapper {
        boolean objectIsPage;
        String verifiedObjectId;

        GetPageIdRequestWrapper(String str, ObjectType objectType) {
            super(str, objectType);
            Bundle bundle = new Bundle();
            bundle.putString(GraphRequest.FIELDS_PARAM, ShareConstants.WEB_DIALOG_PARAM_ID);
            bundle.putString("ids", str);
            setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), BuildConfig.FLAVOR, bundle, HttpMethod.GET));
        }

        protected void processSuccess(GraphResponse graphResponse) {
            JSONObject tryGetJSONObjectFromResponse = Utility.tryGetJSONObjectFromResponse(graphResponse.getJSONObject(), this.objectId);
            if (tryGetJSONObjectFromResponse != null) {
                this.verifiedObjectId = tryGetJSONObjectFromResponse.optString(ShareConstants.WEB_DIALOG_PARAM_ID);
                this.objectIsPage = !Utility.isNullOrEmpty(this.verifiedObjectId);
            }
        }

        protected void processError(FacebookRequestError facebookRequestError) {
            Object[] objArr = new Object[LikeActionController.LIKE_ACTION_CONTROLLER_VERSION];
            objArr[0] = this.objectId;
            objArr[1] = this.objectType;
            objArr[2] = facebookRequestError;
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error getting the FB id for object '%s' with type '%s' : %s", objArr);
        }
    }

    private class GetPageLikesRequestWrapper extends AbstractRequestWrapper implements LikeRequestWrapper {
        private boolean objectIsLiked;
        private String pageId;

        GetPageLikesRequestWrapper(String str) {
            super(str, ObjectType.PAGE);
            this.objectIsLiked = LikeActionController.this.isObjectLiked;
            this.pageId = str;
            Bundle bundle = new Bundle();
            bundle.putString(GraphRequest.FIELDS_PARAM, ShareConstants.WEB_DIALOG_PARAM_ID);
            setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "me/likes/" + str, bundle, HttpMethod.GET));
        }

        protected void processSuccess(GraphResponse graphResponse) {
            JSONArray tryGetJSONArrayFromResponse = Utility.tryGetJSONArrayFromResponse(graphResponse.getJSONObject(), ShareConstants.WEB_DIALOG_PARAM_DATA);
            if (tryGetJSONArrayFromResponse != null && tryGetJSONArrayFromResponse.length() > 0) {
                this.objectIsLiked = true;
            }
        }

        protected void processError(FacebookRequestError facebookRequestError) {
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error fetching like status for page id '%s': %s", this.pageId, facebookRequestError);
            LikeActionController.this.logAppEventForError("get_page_like", facebookRequestError);
        }

        public boolean isObjectLiked() {
            return this.objectIsLiked;
        }

        public String getUnlikeToken() {
            return null;
        }
    }

    private static class MRUCacheWorkItem implements Runnable {
        private static ArrayList<String> mruCachedItems;
        private String cacheItem;
        private boolean shouldTrim;

        static {
            mruCachedItems = new ArrayList();
        }

        MRUCacheWorkItem(String str, boolean z) {
            this.cacheItem = str;
            this.shouldTrim = z;
        }

        public void run() {
            if (this.cacheItem != null) {
                mruCachedItems.remove(this.cacheItem);
                mruCachedItems.add(0, this.cacheItem);
            }
            if (this.shouldTrim && mruCachedItems.size() >= LikeActionController.MAX_CACHE_SIZE) {
                while (64 < mruCachedItems.size()) {
                    LikeActionController.cache.remove((String) mruCachedItems.remove(mruCachedItems.size() - 1));
                }
            }
        }
    }

    private class PublishLikeRequestWrapper extends AbstractRequestWrapper {
        String unlikeToken;

        PublishLikeRequestWrapper(String str, ObjectType objectType) {
            super(str, objectType);
            Bundle bundle = new Bundle();
            bundle.putString("object", str);
            setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "me/og.likes", bundle, HttpMethod.POST));
        }

        protected void processSuccess(GraphResponse graphResponse) {
            this.unlikeToken = Utility.safeGetStringFromResponse(graphResponse.getJSONObject(), ShareConstants.WEB_DIALOG_PARAM_ID);
        }

        protected void processError(FacebookRequestError facebookRequestError) {
            if (facebookRequestError.getErrorCode() == LikeActionController.ERROR_CODE_OBJECT_ALREADY_LIKED) {
                this.error = null;
                return;
            }
            Object[] objArr = new Object[LikeActionController.LIKE_ACTION_CONTROLLER_VERSION];
            objArr[0] = this.objectId;
            objArr[1] = this.objectType;
            objArr[2] = facebookRequestError;
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error liking object '%s' with type '%s' : %s", objArr);
            LikeActionController.this.logAppEventForError("publish_like", facebookRequestError);
        }
    }

    private class PublishUnlikeRequestWrapper extends AbstractRequestWrapper {
        private String unlikeToken;

        PublishUnlikeRequestWrapper(String str) {
            super(null, null);
            this.unlikeToken = str;
            setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), str, null, HttpMethod.DELETE));
        }

        protected void processSuccess(GraphResponse graphResponse) {
        }

        protected void processError(FacebookRequestError facebookRequestError) {
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error unliking object with unlike token '%s' : %s", this.unlikeToken, facebookRequestError);
            LikeActionController.this.logAppEventForError("publish_unlike", facebookRequestError);
        }
    }

    private static class SerializeToDiskWorkItem implements Runnable {
        private String cacheKey;
        private String controllerJson;

        SerializeToDiskWorkItem(String str, String str2) {
            this.cacheKey = str;
            this.controllerJson = str2;
        }

        public void run() {
            LikeActionController.serializeToDiskSynchronously(this.cacheKey, this.controllerJson);
        }
    }

    static {
        TAG = LikeActionController.class.getSimpleName();
        cache = new ConcurrentHashMap();
        mruCacheWorkQueue = new WorkQueue(1);
        diskIOWorkQueue = new WorkQueue(1);
    }

    public static boolean handleOnActivityResult(int i, int i2, Intent intent) {
        if (Utility.isNullOrEmpty(objectIdForPendingController)) {
            objectIdForPendingController = FacebookSdk.getApplicationContext().getSharedPreferences(LIKE_ACTION_CONTROLLER_STORE, 0).getString(LIKE_ACTION_CONTROLLER_STORE_PENDING_OBJECT_ID_KEY, null);
        }
        if (Utility.isNullOrEmpty(objectIdForPendingController)) {
            return false;
        }
        getControllerForObjectId(objectIdForPendingController, ObjectType.UNKNOWN, new C05971(i, i2, intent));
        return true;
    }

    public static void getControllerForObjectId(String str, ObjectType objectType, CreationCallback creationCallback) {
        if (!isInitialized) {
            performFirstInitialize();
        }
        LikeActionController controllerFromInMemoryCache = getControllerFromInMemoryCache(str);
        if (controllerFromInMemoryCache != null) {
            verifyControllerAndInvokeCallback(controllerFromInMemoryCache, objectType, creationCallback);
        } else {
            diskIOWorkQueue.addActiveWorkItem(new CreateLikeActionControllerWorkItem(str, objectType, creationCallback));
        }
    }

    private static void verifyControllerAndInvokeCallback(LikeActionController likeActionController, ObjectType objectType, CreationCallback creationCallback) {
        FacebookException facebookException;
        LikeActionController likeActionController2 = null;
        ObjectType mostSpecificObjectType = ShareInternalUtility.getMostSpecificObjectType(objectType, likeActionController.objectType);
        if (mostSpecificObjectType == null) {
            Object[] objArr = new Object[LIKE_ACTION_CONTROLLER_VERSION];
            objArr[0] = likeActionController.objectId;
            objArr[1] = likeActionController.objectType.toString();
            objArr[2] = objectType.toString();
            facebookException = new FacebookException("Object with id:\"%s\" is already marked as type:\"%s\". Cannot change the type to:\"%s\"", objArr);
        } else {
            likeActionController.objectType = mostSpecificObjectType;
            facebookException = null;
            likeActionController2 = likeActionController;
        }
        invokeCallbackWithController(creationCallback, likeActionController2, facebookException);
    }

    private static void createControllerForObjectIdAndType(String str, ObjectType objectType, CreationCallback creationCallback) {
        LikeActionController controllerFromInMemoryCache = getControllerFromInMemoryCache(str);
        if (controllerFromInMemoryCache != null) {
            verifyControllerAndInvokeCallback(controllerFromInMemoryCache, objectType, creationCallback);
            return;
        }
        controllerFromInMemoryCache = deserializeFromDiskSynchronously(str);
        if (controllerFromInMemoryCache == null) {
            controllerFromInMemoryCache = new LikeActionController(str, objectType);
            serializeToDiskAsync(controllerFromInMemoryCache);
        }
        putControllerInMemoryCache(str, controllerFromInMemoryCache);
        handler.post(new C05982(controllerFromInMemoryCache));
        invokeCallbackWithController(creationCallback, controllerFromInMemoryCache, null);
    }

    private static synchronized void performFirstInitialize() {
        synchronized (LikeActionController.class) {
            if (!isInitialized) {
                handler = new Handler(Looper.getMainLooper());
                objectSuffix = FacebookSdk.getApplicationContext().getSharedPreferences(LIKE_ACTION_CONTROLLER_STORE, 0).getInt(LIKE_ACTION_CONTROLLER_STORE_OBJECT_SUFFIX_KEY, 1);
                controllerDiskCache = new FileLruCache(TAG, new Limits());
                registerAccessTokenTracker();
                CallbackManagerImpl.registerStaticCallback(RequestCodeOffset.Like.toRequestCode(), new C05993());
                isInitialized = true;
            }
        }
    }

    private static void invokeCallbackWithController(CreationCallback creationCallback, LikeActionController likeActionController, FacebookException facebookException) {
        if (creationCallback != null) {
            handler.post(new C06004(creationCallback, likeActionController, facebookException));
        }
    }

    private static void registerAccessTokenTracker() {
        accessTokenTracker = new C06015();
    }

    private static void putControllerInMemoryCache(String str, LikeActionController likeActionController) {
        String cacheKeyForObjectId = getCacheKeyForObjectId(str);
        mruCacheWorkQueue.addActiveWorkItem(new MRUCacheWorkItem(cacheKeyForObjectId, true));
        cache.put(cacheKeyForObjectId, likeActionController);
    }

    private static LikeActionController getControllerFromInMemoryCache(String str) {
        String cacheKeyForObjectId = getCacheKeyForObjectId(str);
        LikeActionController likeActionController = (LikeActionController) cache.get(cacheKeyForObjectId);
        if (likeActionController != null) {
            mruCacheWorkQueue.addActiveWorkItem(new MRUCacheWorkItem(cacheKeyForObjectId, false));
        }
        return likeActionController;
    }

    private static void serializeToDiskAsync(LikeActionController likeActionController) {
        String serializeToJson = serializeToJson(likeActionController);
        String cacheKeyForObjectId = getCacheKeyForObjectId(likeActionController.objectId);
        if (!Utility.isNullOrEmpty(serializeToJson) && !Utility.isNullOrEmpty(cacheKeyForObjectId)) {
            diskIOWorkQueue.addActiveWorkItem(new SerializeToDiskWorkItem(cacheKeyForObjectId, serializeToJson));
        }
    }

    private static void serializeToDiskSynchronously(String str, String str2) {
        Closeable closeable = null;
        try {
            closeable = controllerDiskCache.openPutStream(str);
            closeable.write(str2.getBytes());
            if (closeable != null) {
                Utility.closeQuietly(closeable);
            }
        } catch (Throwable e) {
            Log.e(TAG, "Unable to serialize controller to disk", e);
            if (closeable != null) {
                Utility.closeQuietly(closeable);
            }
        } catch (Throwable th) {
            if (closeable != null) {
                Utility.closeQuietly(closeable);
            }
        }
    }

    private static LikeActionController deserializeFromDiskSynchronously(String str) {
        Closeable closeable;
        Throwable e;
        Throwable th;
        LikeActionController likeActionController = null;
        try {
            closeable = controllerDiskCache.get(getCacheKeyForObjectId(str));
            if (closeable != null) {
                try {
                    String readStreamToString = Utility.readStreamToString(closeable);
                    if (!Utility.isNullOrEmpty(readStreamToString)) {
                        likeActionController = deserializeFromJson(readStreamToString);
                    }
                } catch (IOException e2) {
                    e = e2;
                    try {
                        Log.e(TAG, "Unable to deserialize controller from disk", e);
                        if (closeable != null) {
                            Utility.closeQuietly(closeable);
                        }
                        return likeActionController;
                    } catch (Throwable th2) {
                        th = th2;
                        if (closeable != null) {
                            Utility.closeQuietly(closeable);
                        }
                        throw th;
                    }
                }
            }
            if (closeable != null) {
                Utility.closeQuietly(closeable);
            }
        } catch (IOException e3) {
            e = e3;
            closeable = null;
            Log.e(TAG, "Unable to deserialize controller from disk", e);
            if (closeable != null) {
                Utility.closeQuietly(closeable);
            }
            return likeActionController;
        } catch (Throwable e4) {
            closeable = null;
            th = e4;
            if (closeable != null) {
                Utility.closeQuietly(closeable);
            }
            throw th;
        }
        return likeActionController;
    }

    private static LikeActionController deserializeFromJson(String str) {
        LikeActionController likeActionController;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt(JSON_INT_VERSION_KEY, -1) != LIKE_ACTION_CONTROLLER_VERSION) {
                return null;
            }
            likeActionController = new LikeActionController(jSONObject.getString(JSON_STRING_OBJECT_ID_KEY), ObjectType.fromInt(jSONObject.optInt(JSON_INT_OBJECT_TYPE_KEY, ObjectType.UNKNOWN.getValue())));
            likeActionController.likeCountStringWithLike = jSONObject.optString(JSON_STRING_LIKE_COUNT_WITH_LIKE_KEY, null);
            likeActionController.likeCountStringWithoutLike = jSONObject.optString(JSON_STRING_LIKE_COUNT_WITHOUT_LIKE_KEY, null);
            likeActionController.socialSentenceWithLike = jSONObject.optString(JSON_STRING_SOCIAL_SENTENCE_WITH_LIKE_KEY, null);
            likeActionController.socialSentenceWithoutLike = jSONObject.optString(JSON_STRING_SOCIAL_SENTENCE_WITHOUT_LIKE_KEY, null);
            likeActionController.isObjectLiked = jSONObject.optBoolean(JSON_BOOL_IS_OBJECT_LIKED_KEY);
            likeActionController.unlikeToken = jSONObject.optString(LIKE_DIALOG_RESPONSE_UNLIKE_TOKEN_KEY, null);
            jSONObject = jSONObject.optJSONObject(JSON_BUNDLE_FACEBOOK_DIALOG_ANALYTICS_BUNDLE);
            if (jSONObject != null) {
                likeActionController.facebookDialogAnalyticsBundle = BundleJSONConverter.convertToBundle(jSONObject);
            }
            return likeActionController;
        } catch (Throwable e) {
            Log.e(TAG, "Unable to deserialize controller from JSON", e);
            likeActionController = null;
        }
    }

    private static String serializeToJson(LikeActionController likeActionController) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(JSON_INT_VERSION_KEY, LIKE_ACTION_CONTROLLER_VERSION);
            jSONObject.put(JSON_STRING_OBJECT_ID_KEY, likeActionController.objectId);
            jSONObject.put(JSON_INT_OBJECT_TYPE_KEY, likeActionController.objectType.getValue());
            jSONObject.put(JSON_STRING_LIKE_COUNT_WITH_LIKE_KEY, likeActionController.likeCountStringWithLike);
            jSONObject.put(JSON_STRING_LIKE_COUNT_WITHOUT_LIKE_KEY, likeActionController.likeCountStringWithoutLike);
            jSONObject.put(JSON_STRING_SOCIAL_SENTENCE_WITH_LIKE_KEY, likeActionController.socialSentenceWithLike);
            jSONObject.put(JSON_STRING_SOCIAL_SENTENCE_WITHOUT_LIKE_KEY, likeActionController.socialSentenceWithoutLike);
            jSONObject.put(JSON_BOOL_IS_OBJECT_LIKED_KEY, likeActionController.isObjectLiked);
            jSONObject.put(LIKE_DIALOG_RESPONSE_UNLIKE_TOKEN_KEY, likeActionController.unlikeToken);
            if (likeActionController.facebookDialogAnalyticsBundle != null) {
                JSONObject convertToJSON = BundleJSONConverter.convertToJSON(likeActionController.facebookDialogAnalyticsBundle);
                if (convertToJSON != null) {
                    jSONObject.put(JSON_BUNDLE_FACEBOOK_DIALOG_ANALYTICS_BUNDLE, convertToJSON);
                }
            }
            return jSONObject.toString();
        } catch (Throwable e) {
            Log.e(TAG, "Unable to serialize controller to JSON", e);
            return null;
        }
    }

    private static String getCacheKeyForObjectId(String str) {
        String str2 = null;
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (currentAccessToken != null) {
            str2 = currentAccessToken.getToken();
        }
        if (str2 != null) {
            str2 = Utility.md5hash(str2);
        }
        Object[] objArr = new Object[LIKE_ACTION_CONTROLLER_VERSION];
        objArr[0] = str;
        objArr[1] = Utility.coerceValueIfNullOrEmpty(str2, BuildConfig.FLAVOR);
        objArr[2] = Integer.valueOf(objectSuffix);
        return String.format(Locale.ROOT, "%s|%s|com.fb.sdk.like|%d", objArr);
    }

    private static void broadcastAction(LikeActionController likeActionController, String str) {
        broadcastAction(likeActionController, str, null);
    }

    private static void broadcastAction(LikeActionController likeActionController, String str, Bundle bundle) {
        Intent intent = new Intent(str);
        if (likeActionController != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString(ACTION_OBJECT_ID_KEY, likeActionController.getObjectId());
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext()).sendBroadcast(intent);
    }

    private LikeActionController(String str, ObjectType objectType) {
        this.objectId = str;
        this.objectType = objectType;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public String getLikeCountString() {
        return this.isObjectLiked ? this.likeCountStringWithLike : this.likeCountStringWithoutLike;
    }

    public String getSocialSentence() {
        return this.isObjectLiked ? this.socialSentenceWithLike : this.socialSentenceWithoutLike;
    }

    public boolean isObjectLiked() {
        return this.isObjectLiked;
    }

    public boolean shouldEnableView() {
        if (LikeDialog.canShowNativeDialog() || LikeDialog.canShowWebFallback()) {
            return true;
        }
        if (this.objectIsPage || this.objectType == ObjectType.PAGE) {
            return false;
        }
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (currentAccessToken == null || currentAccessToken.getPermissions() == null || !currentAccessToken.getPermissions().contains("publish_actions")) {
            return false;
        }
        return true;
    }

    public void toggleLike(Activity activity, Fragment fragment, Bundle bundle) {
        boolean z = true;
        boolean z2 = !this.isObjectLiked;
        if (canUseOGPublish()) {
            updateLikeState(z2);
            if (this.isPendingLikeOrUnlike) {
                getAppEventsLogger().logSdkEvent(AnalyticsEvents.EVENT_LIKE_VIEW_DID_UNDO_QUICKLY, null, bundle);
                return;
            } else if (!publishLikeOrUnlikeAsync(z2, bundle)) {
                if (z2) {
                    z = false;
                }
                updateLikeState(z);
                presentLikeDialog(activity, fragment, bundle);
                return;
            } else {
                return;
            }
        }
        presentLikeDialog(activity, fragment, bundle);
    }

    private AppEventsLogger getAppEventsLogger() {
        if (this.appEventsLogger == null) {
            this.appEventsLogger = AppEventsLogger.newLogger(FacebookSdk.getApplicationContext());
        }
        return this.appEventsLogger;
    }

    private boolean publishLikeOrUnlikeAsync(boolean z, Bundle bundle) {
        if (canUseOGPublish()) {
            if (z) {
                publishLikeAsync(bundle);
                return true;
            } else if (!Utility.isNullOrEmpty(this.unlikeToken)) {
                publishUnlikeAsync(bundle);
                return true;
            }
        }
        return false;
    }

    private void publishDidError(boolean z) {
        updateLikeState(z);
        Bundle bundle = new Bundle();
        bundle.putString(NativeProtocol.STATUS_ERROR_DESCRIPTION, ERROR_PUBLISH_ERROR);
        broadcastAction(this, ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR, bundle);
    }

    private void updateLikeState(boolean z) {
        updateState(z, this.likeCountStringWithLike, this.likeCountStringWithoutLike, this.socialSentenceWithLike, this.socialSentenceWithoutLike, this.unlikeToken);
    }

    private void updateState(boolean z, String str, String str2, String str3, String str4, String str5) {
        String coerceValueIfNullOrEmpty = Utility.coerceValueIfNullOrEmpty(str, null);
        String coerceValueIfNullOrEmpty2 = Utility.coerceValueIfNullOrEmpty(str2, null);
        String coerceValueIfNullOrEmpty3 = Utility.coerceValueIfNullOrEmpty(str3, null);
        String coerceValueIfNullOrEmpty4 = Utility.coerceValueIfNullOrEmpty(str4, null);
        String coerceValueIfNullOrEmpty5 = Utility.coerceValueIfNullOrEmpty(str5, null);
        Object obj = (z == this.isObjectLiked && Utility.areObjectsEqual(coerceValueIfNullOrEmpty, this.likeCountStringWithLike) && Utility.areObjectsEqual(coerceValueIfNullOrEmpty2, this.likeCountStringWithoutLike) && Utility.areObjectsEqual(coerceValueIfNullOrEmpty3, this.socialSentenceWithLike) && Utility.areObjectsEqual(coerceValueIfNullOrEmpty4, this.socialSentenceWithoutLike) && Utility.areObjectsEqual(coerceValueIfNullOrEmpty5, this.unlikeToken)) ? null : 1;
        if (obj != null) {
            this.isObjectLiked = z;
            this.likeCountStringWithLike = coerceValueIfNullOrEmpty;
            this.likeCountStringWithoutLike = coerceValueIfNullOrEmpty2;
            this.socialSentenceWithLike = coerceValueIfNullOrEmpty3;
            this.socialSentenceWithoutLike = coerceValueIfNullOrEmpty4;
            this.unlikeToken = coerceValueIfNullOrEmpty5;
            serializeToDiskAsync(this);
            broadcastAction(this, ACTION_LIKE_ACTION_CONTROLLER_UPDATED);
        }
    }

    private void presentLikeDialog(Activity activity, Fragment fragment, Bundle bundle) {
        String str;
        if (LikeDialog.canShowNativeDialog()) {
            str = AnalyticsEvents.EVENT_LIKE_VIEW_DID_PRESENT_DIALOG;
        } else if (LikeDialog.canShowWebFallback()) {
            str = AnalyticsEvents.EVENT_LIKE_VIEW_DID_PRESENT_FALLBACK;
        } else {
            logAppEventForError("present_dialog", bundle);
            Utility.logd(TAG, "Cannot show the Like Dialog on this device.");
            broadcastAction(null, ACTION_LIKE_ACTION_CONTROLLER_UPDATED);
            str = null;
        }
        if (str != null) {
            if (this.objectType != null) {
                str = this.objectType.toString();
            } else {
                str = ObjectType.UNKNOWN.toString();
            }
            LikeContent build = new Builder().setObjectId(this.objectId).setObjectType(str).build();
            if (fragment != null) {
                new LikeDialog(fragment).show(build);
            } else {
                new LikeDialog(activity).show(build);
            }
            saveState(bundle);
            getAppEventsLogger().logSdkEvent(AnalyticsEvents.EVENT_LIKE_VIEW_DID_PRESENT_DIALOG, null, bundle);
        }
    }

    private void onActivityResult(int i, int i2, Intent intent) {
        ShareInternalUtility.handleActivityResult(i, i2, intent, getResultProcessor(this.facebookDialogAnalyticsBundle));
        clearState();
    }

    private ResultProcessor getResultProcessor(Bundle bundle) {
        return new C06026(null, bundle);
    }

    private void saveState(Bundle bundle) {
        storeObjectIdForPendingController(this.objectId);
        this.facebookDialogAnalyticsBundle = bundle;
        serializeToDiskAsync(this);
    }

    private void clearState() {
        this.facebookDialogAnalyticsBundle = null;
        storeObjectIdForPendingController(null);
    }

    private static void storeObjectIdForPendingController(String str) {
        objectIdForPendingController = str;
        FacebookSdk.getApplicationContext().getSharedPreferences(LIKE_ACTION_CONTROLLER_STORE, 0).edit().putString(LIKE_ACTION_CONTROLLER_STORE_PENDING_OBJECT_ID_KEY, objectIdForPendingController).apply();
    }

    private boolean canUseOGPublish() {
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        return (this.objectIsPage || this.verifiedObjectId == null || currentAccessToken == null || currentAccessToken.getPermissions() == null || !currentAccessToken.getPermissions().contains("publish_actions")) ? false : true;
    }

    private void publishLikeAsync(Bundle bundle) {
        this.isPendingLikeOrUnlike = true;
        fetchVerifiedObjectId(new C06047(bundle));
    }

    private void publishUnlikeAsync(Bundle bundle) {
        this.isPendingLikeOrUnlike = true;
        GraphRequestBatch graphRequestBatch = new GraphRequestBatch();
        PublishUnlikeRequestWrapper publishUnlikeRequestWrapper = new PublishUnlikeRequestWrapper(this.unlikeToken);
        publishUnlikeRequestWrapper.addToBatch(graphRequestBatch);
        graphRequestBatch.addCallback(new C06058(publishUnlikeRequestWrapper, bundle));
        graphRequestBatch.executeAsync();
    }

    private void refreshStatusAsync() {
        if (AccessToken.getCurrentAccessToken() == null) {
            refreshStatusViaService();
        } else {
            fetchVerifiedObjectId(new C06079());
        }
    }

    private void refreshStatusViaService() {
        LikeStatusClient likeStatusClient = new LikeStatusClient(FacebookSdk.getApplicationContext(), FacebookSdk.getApplicationId(), this.objectId);
        if (likeStatusClient.start()) {
            likeStatusClient.setCompletedListener(new CompletedListener() {
                public void completed(Bundle bundle) {
                    if (bundle != null && bundle.containsKey(ShareConstants.EXTRA_OBJECT_IS_LIKED)) {
                        String string;
                        String string2;
                        String string3;
                        String string4;
                        String string5;
                        boolean z = bundle.getBoolean(ShareConstants.EXTRA_OBJECT_IS_LIKED);
                        if (bundle.containsKey(ShareConstants.EXTRA_LIKE_COUNT_STRING_WITH_LIKE)) {
                            string = bundle.getString(ShareConstants.EXTRA_LIKE_COUNT_STRING_WITH_LIKE);
                        } else {
                            string = LikeActionController.this.likeCountStringWithLike;
                        }
                        if (bundle.containsKey(ShareConstants.EXTRA_LIKE_COUNT_STRING_WITHOUT_LIKE)) {
                            string2 = bundle.getString(ShareConstants.EXTRA_LIKE_COUNT_STRING_WITHOUT_LIKE);
                        } else {
                            string2 = LikeActionController.this.likeCountStringWithoutLike;
                        }
                        if (bundle.containsKey(ShareConstants.EXTRA_SOCIAL_SENTENCE_WITH_LIKE)) {
                            string3 = bundle.getString(ShareConstants.EXTRA_SOCIAL_SENTENCE_WITH_LIKE);
                        } else {
                            string3 = LikeActionController.this.socialSentenceWithLike;
                        }
                        if (bundle.containsKey(ShareConstants.EXTRA_SOCIAL_SENTENCE_WITHOUT_LIKE)) {
                            string4 = bundle.getString(ShareConstants.EXTRA_SOCIAL_SENTENCE_WITHOUT_LIKE);
                        } else {
                            string4 = LikeActionController.this.socialSentenceWithoutLike;
                        }
                        if (bundle.containsKey(ShareConstants.EXTRA_UNLIKE_TOKEN)) {
                            string5 = bundle.getString(ShareConstants.EXTRA_UNLIKE_TOKEN);
                        } else {
                            string5 = LikeActionController.this.unlikeToken;
                        }
                        LikeActionController.this.updateState(z, string, string2, string3, string4, string5);
                    }
                }
            });
        }
    }

    private void publishAgainIfNeeded(Bundle bundle) {
        if (this.isObjectLiked != this.isObjectLikedOnServer && !publishLikeOrUnlikeAsync(this.isObjectLiked, bundle)) {
            publishDidError(!this.isObjectLiked);
        }
    }

    private void fetchVerifiedObjectId(RequestCompletionCallback requestCompletionCallback) {
        if (Utility.isNullOrEmpty(this.verifiedObjectId)) {
            GetOGObjectIdRequestWrapper getOGObjectIdRequestWrapper = new GetOGObjectIdRequestWrapper(this.objectId, this.objectType);
            GetPageIdRequestWrapper getPageIdRequestWrapper = new GetPageIdRequestWrapper(this.objectId, this.objectType);
            GraphRequestBatch graphRequestBatch = new GraphRequestBatch();
            getOGObjectIdRequestWrapper.addToBatch(graphRequestBatch);
            getPageIdRequestWrapper.addToBatch(graphRequestBatch);
            graphRequestBatch.addCallback(new AnonymousClass11(getOGObjectIdRequestWrapper, getPageIdRequestWrapper, requestCompletionCallback));
            graphRequestBatch.executeAsync();
        } else if (requestCompletionCallback != null) {
            requestCompletionCallback.onComplete();
        }
    }

    private void logAppEventForError(String str, Bundle bundle) {
        Bundle bundle2 = new Bundle(bundle);
        bundle2.putString(JSON_STRING_OBJECT_ID_KEY, this.objectId);
        bundle2.putString(JSON_INT_OBJECT_TYPE_KEY, this.objectType.toString());
        bundle2.putString(AnalyticsEvents.PARAMETER_LIKE_VIEW_CURRENT_ACTION, str);
        getAppEventsLogger().logSdkEvent(AnalyticsEvents.EVENT_LIKE_VIEW_ERROR, null, bundle2);
    }

    private void logAppEventForError(String str, FacebookRequestError facebookRequestError) {
        Bundle bundle = new Bundle();
        if (facebookRequestError != null) {
            JSONObject requestResult = facebookRequestError.getRequestResult();
            if (requestResult != null) {
                bundle.putString(NativeProtocol.BRIDGE_ARG_ERROR_BUNDLE, requestResult.toString());
            }
        }
        logAppEventForError(str, bundle);
    }
}
