package com.facebook.share;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.internal.CollectionMapper;
import com.facebook.internal.CollectionMapper.Collection;
import com.facebook.internal.CollectionMapper.OnErrorListener;
import com.facebook.internal.CollectionMapper.OnMapValueCompleteListener;
import com.facebook.internal.CollectionMapper.OnMapperCompleteListener;
import com.facebook.internal.CollectionMapper.ValueMapper;
import com.facebook.internal.Mutable;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.share.Sharer.Result;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.internal.ShareContentValidation;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.internal.VideoUploader;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ShareApi {
    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final String DEFAULT_GRAPH_NODE = "me";
    private static final String GRAPH_PATH_FORMAT = "%s/%s";
    private static final String PHOTOS_EDGE = "photos";
    private static final String TAG = "ShareApi";
    private String graphNode;
    private String message;
    private final ShareContent shareContent;

    /* renamed from: com.facebook.share.ShareApi.10 */
    class AnonymousClass10 implements Callback {
        final /* synthetic */ OnMapValueCompleteListener val$onOpenGraphObjectStagedListener;

        AnonymousClass10(OnMapValueCompleteListener onMapValueCompleteListener) {
            this.val$onOpenGraphObjectStagedListener = onMapValueCompleteListener;
        }

        public void onCompleted(GraphResponse graphResponse) {
            FacebookRequestError error = graphResponse.getError();
            String errorMessage;
            if (error != null) {
                errorMessage = error.getErrorMessage();
                if (errorMessage == null) {
                    errorMessage = "Error staging Open Graph object.";
                }
                this.val$onOpenGraphObjectStagedListener.onError(new FacebookGraphResponseException(graphResponse, errorMessage));
                return;
            }
            JSONObject jSONObject = graphResponse.getJSONObject();
            if (jSONObject == null) {
                this.val$onOpenGraphObjectStagedListener.onError(new FacebookGraphResponseException(graphResponse, "Error staging Open Graph object."));
                return;
            }
            errorMessage = jSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_ID);
            if (errorMessage == null) {
                this.val$onOpenGraphObjectStagedListener.onError(new FacebookGraphResponseException(graphResponse, "Error staging Open Graph object."));
            } else {
                this.val$onOpenGraphObjectStagedListener.onComplete(errorMessage);
            }
        }
    }

    /* renamed from: com.facebook.share.ShareApi.11 */
    class AnonymousClass11 implements OnMapperCompleteListener {
        final /* synthetic */ String val$ogType;
        final /* synthetic */ OnMapValueCompleteListener val$onOpenGraphObjectStagedListener;
        final /* synthetic */ Callback val$requestCallback;
        final /* synthetic */ JSONObject val$stagedObject;

        AnonymousClass11(JSONObject jSONObject, String str, Callback callback, OnMapValueCompleteListener onMapValueCompleteListener) {
            this.val$stagedObject = jSONObject;
            this.val$ogType = str;
            this.val$requestCallback = callback;
            this.val$onOpenGraphObjectStagedListener = onMapValueCompleteListener;
        }

        public void onComplete() {
            String jSONObject = this.val$stagedObject.toString();
            Bundle bundle = new Bundle();
            bundle.putString("object", jSONObject);
            try {
                new GraphRequest(AccessToken.getCurrentAccessToken(), ShareApi.this.getGraphPath("objects/" + URLEncoder.encode(this.val$ogType, ShareApi.DEFAULT_CHARSET)), bundle, HttpMethod.POST, this.val$requestCallback).executeAsync();
            } catch (UnsupportedEncodingException e) {
                jSONObject = e.getLocalizedMessage();
                if (jSONObject == null) {
                    jSONObject = "Error staging Open Graph object.";
                }
                this.val$onOpenGraphObjectStagedListener.onError(new FacebookException(jSONObject));
            }
        }

        public void onError(FacebookException facebookException) {
            this.val$onOpenGraphObjectStagedListener.onError(facebookException);
        }
    }

    /* renamed from: com.facebook.share.ShareApi.12 */
    class AnonymousClass12 implements Callback {
        final /* synthetic */ OnMapValueCompleteListener val$onPhotoStagedListener;
        final /* synthetic */ SharePhoto val$photo;

        AnonymousClass12(OnMapValueCompleteListener onMapValueCompleteListener, SharePhoto sharePhoto) {
            this.val$onPhotoStagedListener = onMapValueCompleteListener;
            this.val$photo = sharePhoto;
        }

        public void onCompleted(GraphResponse graphResponse) {
            FacebookRequestError error = graphResponse.getError();
            String errorMessage;
            if (error != null) {
                errorMessage = error.getErrorMessage();
                if (errorMessage == null) {
                    errorMessage = "Error staging photo.";
                }
                this.val$onPhotoStagedListener.onError(new FacebookGraphResponseException(graphResponse, errorMessage));
                return;
            }
            JSONObject jSONObject = graphResponse.getJSONObject();
            if (jSONObject == null) {
                this.val$onPhotoStagedListener.onError(new FacebookException("Error staging photo."));
                return;
            }
            errorMessage = jSONObject.optString("uri");
            if (errorMessage == null) {
                this.val$onPhotoStagedListener.onError(new FacebookException("Error staging photo."));
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(NativeProtocol.WEB_DIALOG_URL, errorMessage);
                jSONObject2.put(NativeProtocol.IMAGE_USER_GENERATED_KEY, this.val$photo.getUserGenerated());
                this.val$onPhotoStagedListener.onComplete(jSONObject2);
            } catch (JSONException e) {
                errorMessage = e.getLocalizedMessage();
                if (errorMessage == null) {
                    errorMessage = "Error staging photo.";
                }
                this.val$onPhotoStagedListener.onError(new FacebookException(errorMessage));
            }
        }
    }

    /* renamed from: com.facebook.share.ShareApi.1 */
    class C05871 implements Callback {
        final /* synthetic */ FacebookCallback val$callback;

        C05871(FacebookCallback facebookCallback) {
            this.val$callback = facebookCallback;
        }

        public void onCompleted(GraphResponse graphResponse) {
            JSONObject jSONObject = graphResponse.getJSONObject();
            ShareInternalUtility.invokeCallbackWithResults(this.val$callback, jSONObject == null ? null : jSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_ID), graphResponse);
        }
    }

    /* renamed from: com.facebook.share.ShareApi.2 */
    class C05882 implements OnMapperCompleteListener {
        final /* synthetic */ ShareOpenGraphAction val$action;
        final /* synthetic */ FacebookCallback val$callback;
        final /* synthetic */ Bundle val$parameters;
        final /* synthetic */ Callback val$requestCallback;

        C05882(Bundle bundle, ShareOpenGraphAction shareOpenGraphAction, Callback callback, FacebookCallback facebookCallback) {
            this.val$parameters = bundle;
            this.val$action = shareOpenGraphAction;
            this.val$requestCallback = callback;
            this.val$callback = facebookCallback;
        }

        public void onComplete() {
            try {
                ShareApi.handleImagesOnAction(this.val$parameters);
                new GraphRequest(AccessToken.getCurrentAccessToken(), ShareApi.this.getGraphPath(URLEncoder.encode(this.val$action.getActionType(), ShareApi.DEFAULT_CHARSET)), this.val$parameters, HttpMethod.POST, this.val$requestCallback).executeAsync();
            } catch (Exception e) {
                ShareInternalUtility.invokeCallbackWithException(this.val$callback, e);
            }
        }

        public void onError(FacebookException facebookException) {
            ShareInternalUtility.invokeCallbackWithException(this.val$callback, facebookException);
        }
    }

    /* renamed from: com.facebook.share.ShareApi.3 */
    class C05893 implements Callback {
        final /* synthetic */ FacebookCallback val$callback;
        final /* synthetic */ ArrayList val$errorResponses;
        final /* synthetic */ Mutable val$requestCount;
        final /* synthetic */ ArrayList val$results;

        C05893(ArrayList arrayList, ArrayList arrayList2, Mutable mutable, FacebookCallback facebookCallback) {
            this.val$results = arrayList;
            this.val$errorResponses = arrayList2;
            this.val$requestCount = mutable;
            this.val$callback = facebookCallback;
        }

        public void onCompleted(GraphResponse graphResponse) {
            JSONObject jSONObject = graphResponse.getJSONObject();
            if (jSONObject != null) {
                this.val$results.add(jSONObject);
            }
            if (graphResponse.getError() != null) {
                this.val$errorResponses.add(graphResponse);
            }
            this.val$requestCount.value = Integer.valueOf(((Integer) this.val$requestCount.value).intValue() - 1);
            if (((Integer) this.val$requestCount.value).intValue() != 0) {
                return;
            }
            if (!this.val$errorResponses.isEmpty()) {
                ShareInternalUtility.invokeCallbackWithResults(this.val$callback, null, (GraphResponse) this.val$errorResponses.get(0));
            } else if (!this.val$results.isEmpty()) {
                ShareInternalUtility.invokeCallbackWithResults(this.val$callback, ((JSONObject) this.val$results.get(0)).optString(ShareConstants.WEB_DIALOG_PARAM_ID), graphResponse);
            }
        }
    }

    /* renamed from: com.facebook.share.ShareApi.4 */
    class C05904 implements Callback {
        final /* synthetic */ FacebookCallback val$callback;

        C05904(FacebookCallback facebookCallback) {
            this.val$callback = facebookCallback;
        }

        public void onCompleted(GraphResponse graphResponse) {
            JSONObject jSONObject = graphResponse.getJSONObject();
            ShareInternalUtility.invokeCallbackWithResults(this.val$callback, jSONObject == null ? null : jSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_ID), graphResponse);
        }
    }

    /* renamed from: com.facebook.share.ShareApi.5 */
    class C05925 implements Collection<Integer> {
        final /* synthetic */ ArrayList val$arrayList;
        final /* synthetic */ JSONArray val$stagedObject;

        /* renamed from: com.facebook.share.ShareApi.5.1 */
        class C05911 implements Iterator<Integer> {
            final /* synthetic */ Mutable val$current;
            final /* synthetic */ int val$size;

            C05911(Mutable mutable, int i) {
                this.val$current = mutable;
                this.val$size = i;
            }

            public boolean hasNext() {
                return ((Integer) this.val$current.value).intValue() < this.val$size;
            }

            public Integer next() {
                Integer num = (Integer) this.val$current.value;
                Mutable mutable = this.val$current;
                mutable.value = Integer.valueOf(((Integer) mutable.value).intValue() + 1);
                return num;
            }

            public void remove() {
            }
        }

        C05925(ArrayList arrayList, JSONArray jSONArray) {
            this.val$arrayList = arrayList;
            this.val$stagedObject = jSONArray;
        }

        public Iterator<Integer> keyIterator() {
            return new C05911(new Mutable(Integer.valueOf(0)), this.val$arrayList.size());
        }

        public Object get(Integer num) {
            return this.val$arrayList.get(num.intValue());
        }

        public void set(Integer num, Object obj, OnErrorListener onErrorListener) {
            try {
                this.val$stagedObject.put(num.intValue(), obj);
            } catch (JSONException e) {
                String localizedMessage = e.getLocalizedMessage();
                if (localizedMessage == null) {
                    localizedMessage = "Error staging object.";
                }
                onErrorListener.onError(new FacebookException(localizedMessage));
            }
        }
    }

    /* renamed from: com.facebook.share.ShareApi.6 */
    class C05936 implements OnMapperCompleteListener {
        final /* synthetic */ OnMapValueCompleteListener val$onArrayListStagedListener;
        final /* synthetic */ JSONArray val$stagedObject;

        C05936(OnMapValueCompleteListener onMapValueCompleteListener, JSONArray jSONArray) {
            this.val$onArrayListStagedListener = onMapValueCompleteListener;
            this.val$stagedObject = jSONArray;
        }

        public void onComplete() {
            this.val$onArrayListStagedListener.onComplete(this.val$stagedObject);
        }

        public void onError(FacebookException facebookException) {
            this.val$onArrayListStagedListener.onError(facebookException);
        }
    }

    /* renamed from: com.facebook.share.ShareApi.7 */
    class C05947 implements ValueMapper {
        C05947() {
        }

        public void mapValue(Object obj, OnMapValueCompleteListener onMapValueCompleteListener) {
            if (obj instanceof ArrayList) {
                ShareApi.this.stageArrayList((ArrayList) obj, onMapValueCompleteListener);
            } else if (obj instanceof ShareOpenGraphObject) {
                ShareApi.this.stageOpenGraphObject((ShareOpenGraphObject) obj, onMapValueCompleteListener);
            } else if (obj instanceof SharePhoto) {
                ShareApi.this.stagePhoto((SharePhoto) obj, onMapValueCompleteListener);
            } else {
                onMapValueCompleteListener.onComplete(obj);
            }
        }
    }

    /* renamed from: com.facebook.share.ShareApi.8 */
    class C05958 implements Collection<String> {
        final /* synthetic */ Bundle val$parameters;

        C05958(Bundle bundle) {
            this.val$parameters = bundle;
        }

        public Iterator<String> keyIterator() {
            return this.val$parameters.keySet().iterator();
        }

        public Object get(String str) {
            return this.val$parameters.get(str);
        }

        public void set(String str, Object obj, OnErrorListener onErrorListener) {
            if (!Utility.putJSONValueInBundle(this.val$parameters, str, obj)) {
                onErrorListener.onError(new FacebookException("Unexpected value: " + obj.toString()));
            }
        }
    }

    /* renamed from: com.facebook.share.ShareApi.9 */
    class C05969 implements Collection<String> {
        final /* synthetic */ ShareOpenGraphObject val$object;
        final /* synthetic */ JSONObject val$stagedObject;

        C05969(ShareOpenGraphObject shareOpenGraphObject, JSONObject jSONObject) {
            this.val$object = shareOpenGraphObject;
            this.val$stagedObject = jSONObject;
        }

        public Iterator<String> keyIterator() {
            return this.val$object.keySet().iterator();
        }

        public Object get(String str) {
            return this.val$object.get(str);
        }

        public void set(String str, Object obj, OnErrorListener onErrorListener) {
            try {
                this.val$stagedObject.put(str, obj);
            } catch (JSONException e) {
                String localizedMessage = e.getLocalizedMessage();
                if (localizedMessage == null) {
                    localizedMessage = "Error staging object.";
                }
                onErrorListener.onError(new FacebookException(localizedMessage));
            }
        }
    }

    public static void share(ShareContent shareContent, FacebookCallback<Result> facebookCallback) {
        new ShareApi(shareContent).share(facebookCallback);
    }

    public ShareApi(ShareContent shareContent) {
        this.shareContent = shareContent;
        this.graphNode = DEFAULT_GRAPH_NODE;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getGraphNode() {
        return this.graphNode;
    }

    public void setGraphNode(String str) {
        this.graphNode = str;
    }

    public ShareContent getShareContent() {
        return this.shareContent;
    }

    public boolean canShare() {
        if (getShareContent() == null) {
            return false;
        }
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (currentAccessToken == null) {
            return false;
        }
        Set permissions = currentAccessToken.getPermissions();
        if (permissions == null || !permissions.contains("publish_actions")) {
            Log.w(TAG, "The publish_actions permissions are missing, the share will fail unless this app was authorized to publish in another installation.");
        }
        return true;
    }

    public void share(FacebookCallback<Result> facebookCallback) {
        if (canShare()) {
            ShareContent shareContent = getShareContent();
            try {
                ShareContentValidation.validateForApiShare(shareContent);
                if (shareContent instanceof ShareLinkContent) {
                    shareLinkContent((ShareLinkContent) shareContent, facebookCallback);
                    return;
                } else if (shareContent instanceof SharePhotoContent) {
                    sharePhotoContent((SharePhotoContent) shareContent, facebookCallback);
                    return;
                } else if (shareContent instanceof ShareVideoContent) {
                    shareVideoContent((ShareVideoContent) shareContent, facebookCallback);
                    return;
                } else if (shareContent instanceof ShareOpenGraphContent) {
                    shareOpenGraphContent((ShareOpenGraphContent) shareContent, facebookCallback);
                    return;
                } else {
                    return;
                }
            } catch (Exception e) {
                ShareInternalUtility.invokeCallbackWithException(facebookCallback, e);
                return;
            }
        }
        ShareInternalUtility.invokeCallbackWithError(facebookCallback, "Insufficient permissions for sharing content via Api.");
    }

    private String getGraphPath(String str) {
        try {
            return String.format(Locale.ROOT, GRAPH_PATH_FORMAT, new Object[]{URLEncoder.encode(getGraphNode(), DEFAULT_CHARSET), str});
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    private void addCommonParameters(Bundle bundle, ShareContent shareContent) {
        java.util.Collection peopleIds = shareContent.getPeopleIds();
        if (!Utility.isNullOrEmpty(peopleIds)) {
            bundle.putString("tags", TextUtils.join(", ", peopleIds));
        }
        if (!Utility.isNullOrEmpty(shareContent.getPlaceId())) {
            bundle.putString("place", shareContent.getPlaceId());
        }
        if (!Utility.isNullOrEmpty(shareContent.getRef())) {
            bundle.putString("ref", shareContent.getRef());
        }
    }

    private void shareOpenGraphContent(ShareOpenGraphContent shareOpenGraphContent, FacebookCallback<Result> facebookCallback) {
        Callback c05871 = new C05871(facebookCallback);
        ShareOpenGraphAction action = shareOpenGraphContent.getAction();
        Bundle bundle = action.getBundle();
        addCommonParameters(bundle, shareOpenGraphContent);
        if (!Utility.isNullOrEmpty(getMessage())) {
            bundle.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, getMessage());
        }
        stageOpenGraphAction(bundle, new C05882(bundle, action, c05871, facebookCallback));
    }

    private static void handleImagesOnAction(Bundle bundle) {
        String string = bundle.getString("image");
        if (string != null) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        putImageInBundleWithArrayFormat(bundle, i, optJSONObject);
                    } else {
                        bundle.putString(String.format(Locale.ROOT, "image[%d][url]", new Object[]{Integer.valueOf(i)}), jSONArray.getString(i));
                    }
                }
                bundle.remove("image");
            } catch (JSONException e) {
                try {
                    putImageInBundleWithArrayFormat(bundle, 0, new JSONObject(string));
                    bundle.remove("image");
                } catch (JSONException e2) {
                }
            }
        }
    }

    private static void putImageInBundleWithArrayFormat(Bundle bundle, int i, JSONObject jSONObject) throws JSONException {
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            Object[] objArr = new Object[]{Integer.valueOf(i), (String) keys.next()};
            bundle.putString(String.format(Locale.ROOT, "image[%d][%s]", objArr), jSONObject.get((String) keys.next()).toString());
        }
    }

    private void sharePhotoContent(SharePhotoContent sharePhotoContent, FacebookCallback<Result> facebookCallback) {
        Mutable mutable = new Mutable(Integer.valueOf(0));
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        ArrayList arrayList = new ArrayList();
        C05893 c05893 = new C05893(new ArrayList(), new ArrayList(), mutable, facebookCallback);
        try {
            for (SharePhoto sharePhoto : sharePhotoContent.getPhotos()) {
                Bitmap bitmap = sharePhoto.getBitmap();
                Uri imageUrl = sharePhoto.getImageUrl();
                String caption = sharePhoto.getCaption();
                if (caption == null) {
                    caption = getMessage();
                }
                if (bitmap != null) {
                    arrayList.add(GraphRequest.newUploadPhotoRequest(currentAccessToken, getGraphPath(PHOTOS_EDGE), bitmap, caption, sharePhoto.getParameters(), (Callback) c05893));
                } else if (imageUrl != null) {
                    arrayList.add(GraphRequest.newUploadPhotoRequest(currentAccessToken, getGraphPath(PHOTOS_EDGE), imageUrl, caption, sharePhoto.getParameters(), (Callback) c05893));
                } else {
                    continue;
                }
            }
            mutable.value = Integer.valueOf(((Integer) mutable.value).intValue() + arrayList.size());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((GraphRequest) it.next()).executeAsync();
            }
        } catch (Exception e) {
            ShareInternalUtility.invokeCallbackWithException(facebookCallback, e);
        }
    }

    private void shareLinkContent(ShareLinkContent shareLinkContent, FacebookCallback<Result> facebookCallback) {
        Callback c05904 = new C05904(facebookCallback);
        Bundle bundle = new Bundle();
        addCommonParameters(bundle, shareLinkContent);
        bundle.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, getMessage());
        bundle.putString(ShareConstants.WEB_DIALOG_PARAM_LINK, Utility.getUriString(shareLinkContent.getContentUrl()));
        bundle.putString(ShareConstants.WEB_DIALOG_PARAM_PICTURE, Utility.getUriString(shareLinkContent.getImageUrl()));
        bundle.putString(ShareConstants.WEB_DIALOG_PARAM_NAME, shareLinkContent.getContentTitle());
        bundle.putString(ShareConstants.WEB_DIALOG_PARAM_DESCRIPTION, shareLinkContent.getContentDescription());
        bundle.putString("ref", shareLinkContent.getRef());
        new GraphRequest(AccessToken.getCurrentAccessToken(), getGraphPath("feed"), bundle, HttpMethod.POST, c05904).executeAsync();
    }

    private void shareVideoContent(ShareVideoContent shareVideoContent, FacebookCallback<Result> facebookCallback) {
        try {
            VideoUploader.uploadAsync(shareVideoContent, getGraphNode(), facebookCallback);
        } catch (Exception e) {
            ShareInternalUtility.invokeCallbackWithException(facebookCallback, e);
        }
    }

    private void stageArrayList(ArrayList arrayList, OnMapValueCompleteListener onMapValueCompleteListener) {
        JSONArray jSONArray = new JSONArray();
        stageCollectionValues(new C05925(arrayList, jSONArray), new C05936(onMapValueCompleteListener, jSONArray));
    }

    private <T> void stageCollectionValues(Collection<T> collection, OnMapperCompleteListener onMapperCompleteListener) {
        CollectionMapper.iterate(collection, new C05947(), onMapperCompleteListener);
    }

    private void stageOpenGraphAction(Bundle bundle, OnMapperCompleteListener onMapperCompleteListener) {
        stageCollectionValues(new C05958(bundle), onMapperCompleteListener);
    }

    private void stageOpenGraphObject(ShareOpenGraphObject shareOpenGraphObject, OnMapValueCompleteListener onMapValueCompleteListener) {
        String string = shareOpenGraphObject.getString("type");
        if (string == null) {
            string = shareOpenGraphObject.getString("og:type");
        }
        if (string == null) {
            onMapValueCompleteListener.onError(new FacebookException("Open Graph objects must contain a type value."));
            return;
        }
        JSONObject jSONObject = new JSONObject();
        stageCollectionValues(new C05969(shareOpenGraphObject, jSONObject), new AnonymousClass11(jSONObject, string, new AnonymousClass10(onMapValueCompleteListener), onMapValueCompleteListener));
    }

    private void stagePhoto(SharePhoto sharePhoto, OnMapValueCompleteListener onMapValueCompleteListener) {
        Bitmap bitmap = sharePhoto.getBitmap();
        Uri imageUrl = sharePhoto.getImageUrl();
        if (bitmap == null && imageUrl == null) {
            onMapValueCompleteListener.onError(new FacebookException("Photos must have an imageURL or bitmap."));
            return;
        }
        Callback anonymousClass12 = new AnonymousClass12(onMapValueCompleteListener, sharePhoto);
        if (bitmap != null) {
            ShareInternalUtility.newUploadStagingResourceWithImageRequest(AccessToken.getCurrentAccessToken(), bitmap, anonymousClass12).executeAsync();
            return;
        }
        try {
            ShareInternalUtility.newUploadStagingResourceWithImageRequest(AccessToken.getCurrentAccessToken(), imageUrl, anonymousClass12).executeAsync();
        } catch (FileNotFoundException e) {
            String localizedMessage = e.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = "Error staging photo.";
            }
            onMapValueCompleteListener.onError(new FacebookException(localizedMessage));
        }
    }
}
