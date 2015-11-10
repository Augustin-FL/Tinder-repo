package com.facebook.applinks;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphResponse;
import com.facebook.stetho.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.C0004b;
import p000a.C0004b.C0003a;
import p000a.C0010f;
import p000a.C0019g;
import p000a.C0019g.C0018a;

public class FacebookAppLinkResolver {
    private static final String APP_LINK_ANDROID_TARGET_KEY = "android";
    private static final String APP_LINK_KEY = "app_links";
    private static final String APP_LINK_TARGET_APP_NAME_KEY = "app_name";
    private static final String APP_LINK_TARGET_CLASS_KEY = "class";
    private static final String APP_LINK_TARGET_PACKAGE_KEY = "package";
    private static final String APP_LINK_TARGET_SHOULD_FALLBACK_KEY = "should_fallback";
    private static final String APP_LINK_TARGET_URL_KEY = "url";
    private static final String APP_LINK_WEB_TARGET_KEY = "web";
    private final HashMap<Uri, C0004b> cachedAppLinks;

    /* renamed from: com.facebook.applinks.FacebookAppLinkResolver.1 */
    class C05201 implements C0010f<Map<Uri, C0004b>, C0004b> {
        final /* synthetic */ Uri val$uri;

        C05201(Uri uri) {
            this.val$uri = uri;
        }

        public C0004b then(C0019g<Map<Uri, C0004b>> c0019g) throws Exception {
            return (C0004b) ((Map) c0019g.m47e()).get(this.val$uri);
        }
    }

    /* renamed from: com.facebook.applinks.FacebookAppLinkResolver.2 */
    class C05212 implements Callback {
        final /* synthetic */ Map val$appLinkResults;
        final /* synthetic */ C0018a val$taskCompletionSource;
        final /* synthetic */ HashSet val$urisToRequest;

        C05212(C0018a c0018a, Map map, HashSet hashSet) {
            this.val$taskCompletionSource = c0018a;
            this.val$appLinkResults = map;
            this.val$urisToRequest = hashSet;
        }

        public void onCompleted(GraphResponse graphResponse) {
            FacebookRequestError error = graphResponse.getError();
            if (error != null) {
                this.val$taskCompletionSource.m18b(error.getException());
                return;
            }
            JSONObject jSONObject = graphResponse.getJSONObject();
            if (jSONObject == null) {
                this.val$taskCompletionSource.m19b(this.val$appLinkResults);
                return;
            }
            Iterator it = this.val$urisToRequest.iterator();
            while (it.hasNext()) {
                Uri uri = (Uri) it.next();
                if (jSONObject.has(uri.toString())) {
                    try {
                        JSONObject jSONObject2 = jSONObject.getJSONObject(uri.toString()).getJSONObject(FacebookAppLinkResolver.APP_LINK_KEY);
                        JSONArray jSONArray = jSONObject2.getJSONArray(FacebookAppLinkResolver.APP_LINK_ANDROID_TARGET_KEY);
                        int length = jSONArray.length();
                        List arrayList = new ArrayList(length);
                        for (int i = 0; i < length; i++) {
                            C0003a access$000 = FacebookAppLinkResolver.getAndroidTargetFromJson(jSONArray.getJSONObject(i));
                            if (access$000 != null) {
                                arrayList.add(access$000);
                            }
                        }
                        C0004b c0004b = new C0004b(uri, arrayList, FacebookAppLinkResolver.getWebFallbackUriFromJson(uri, jSONObject2));
                        this.val$appLinkResults.put(uri, c0004b);
                        synchronized (FacebookAppLinkResolver.this.cachedAppLinks) {
                            FacebookAppLinkResolver.this.cachedAppLinks.put(uri, c0004b);
                        }
                    } catch (JSONException e) {
                    }
                }
            }
            this.val$taskCompletionSource.m19b(this.val$appLinkResults);
        }
    }

    public FacebookAppLinkResolver() {
        this.cachedAppLinks = new HashMap();
    }

    public C0019g<C0004b> getAppLinkFromUrlInBackground(Uri uri) {
        List arrayList = new ArrayList();
        arrayList.add(uri);
        return getAppLinkFromUrlsInBackground(arrayList).m41b(new C05201(uri));
    }

    public C0019g<Map<Uri, C0004b>> getAppLinkFromUrlsInBackground(List<Uri> list) {
        Object hashMap = new HashMap();
        HashSet hashSet = new HashSet();
        StringBuilder stringBuilder = new StringBuilder();
        for (Uri uri : list) {
            synchronized (this.cachedAppLinks) {
                C0004b c0004b = (C0004b) this.cachedAppLinks.get(uri);
            }
            if (c0004b != null) {
                hashMap.put(uri, c0004b);
            } else {
                if (!hashSet.isEmpty()) {
                    stringBuilder.append(',');
                }
                stringBuilder.append(uri.toString());
                hashSet.add(uri);
            }
        }
        if (hashSet.isEmpty()) {
            return C0019g.m24a(hashMap);
        }
        C0018a a = C0019g.m22a();
        Bundle bundle = new Bundle();
        bundle.putString("ids", stringBuilder.toString());
        bundle.putString(GraphRequest.FIELDS_PARAM, String.format("%s.fields(%s,%s)", new Object[]{APP_LINK_KEY, APP_LINK_ANDROID_TARGET_KEY, APP_LINK_WEB_TARGET_KEY}));
        new GraphRequest(AccessToken.getCurrentAccessToken(), BuildConfig.FLAVOR, bundle, null, new C05212(a, hashMap, hashSet)).executeAsync();
        return a.m15a();
    }

    private static C0003a getAndroidTargetFromJson(JSONObject jSONObject) {
        Uri uri = null;
        String tryGetStringFromJson = tryGetStringFromJson(jSONObject, APP_LINK_TARGET_PACKAGE_KEY, null);
        if (tryGetStringFromJson == null) {
            return null;
        }
        String tryGetStringFromJson2 = tryGetStringFromJson(jSONObject, APP_LINK_TARGET_CLASS_KEY, null);
        String tryGetStringFromJson3 = tryGetStringFromJson(jSONObject, APP_LINK_TARGET_APP_NAME_KEY, null);
        String tryGetStringFromJson4 = tryGetStringFromJson(jSONObject, APP_LINK_TARGET_URL_KEY, null);
        if (tryGetStringFromJson4 != null) {
            uri = Uri.parse(tryGetStringFromJson4);
        }
        return new C0003a(tryGetStringFromJson, tryGetStringFromJson2, uri, tryGetStringFromJson3);
    }

    private static Uri getWebFallbackUriFromJson(Uri uri, JSONObject jSONObject) {
        Uri uri2 = null;
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(APP_LINK_WEB_TARGET_KEY);
            if (!tryGetBooleanFromJson(jSONObject2, APP_LINK_TARGET_SHOULD_FALLBACK_KEY, true)) {
                return null;
            }
            String tryGetStringFromJson = tryGetStringFromJson(jSONObject2, APP_LINK_TARGET_URL_KEY, null);
            if (tryGetStringFromJson != null) {
                uri2 = Uri.parse(tryGetStringFromJson);
            }
            if (uri2 != null) {
                return uri2;
            }
            return uri;
        } catch (JSONException e) {
            return uri;
        }
    }

    private static String tryGetStringFromJson(JSONObject jSONObject, String str, String str2) {
        try {
            str2 = jSONObject.getString(str);
        } catch (JSONException e) {
        }
        return str2;
    }

    private static boolean tryGetBooleanFromJson(JSONObject jSONObject, String str, boolean z) {
        try {
            z = jSONObject.getBoolean(str);
        } catch (JSONException e) {
        }
        return z;
    }
}
