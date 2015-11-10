package com.tinder.managers;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.android.volley.AuthFailureError;
import com.android.volley.C0307i.C0305a;
import com.android.volley.C0307i.C0306b;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.C0337j;
import com.facebook.AccessToken;
import com.facebook.internal.NativeProtocol;
import com.facebook.login.LoginManager;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.Scopes;
import com.tinder.model.CommonConnection;
import com.tinder.model.ConnectionsGroup;
import com.tinder.model.FacebookFriend;
import com.tinder.p030d.C2432m;
import com.tinder.utils.C3095y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

/* renamed from: com.tinder.managers.c */
public class C2828c {
    @Nullable
    private static final Comparator<FacebookFriend> f5789a;
    @NonNull
    private final Set<String> f5790b;
    @Nullable
    private Set<String> f5791c;
    @NonNull
    private Map<String, FacebookFriend> f5792d;
    @NonNull
    private List<FacebookFriend> f5793e;

    /* renamed from: com.tinder.managers.c.a */
    public interface C2587a {
        void m7120a(String str);
    }

    /* renamed from: com.tinder.managers.c.1 */
    static class C28221 implements Comparator<FacebookFriend> {
        C28221() {
        }

        public /* synthetic */ int compare(@Nullable Object obj, @Nullable Object obj2) {
            return m8145a((FacebookFriend) obj, (FacebookFriend) obj2);
        }

        public int m8145a(@Nullable FacebookFriend facebookFriend, @Nullable FacebookFriend facebookFriend2) {
            if (facebookFriend == null) {
                return -1;
            }
            if (facebookFriend2 == null) {
                return 1;
            }
            try {
                return facebookFriend.getName().compareTo(facebookFriend2.getName());
            } catch (Exception e) {
                return 0;
            }
        }
    }

    /* renamed from: com.tinder.managers.c.2 */
    static class C28232 implements C0306b<JSONObject> {
        final /* synthetic */ ConnectionsGroup f5783a;
        final /* synthetic */ List f5784b;
        final /* synthetic */ C2432m f5785c;

        C28232(ConnectionsGroup connectionsGroup, List list, C2432m c2432m) {
            this.f5783a = connectionsGroup;
            this.f5784b = list;
            this.f5785c = c2432m;
        }

        public void m8147a(@NonNull JSONObject jSONObject) {
            try {
                this.f5783a.fillIn(C2828c.m8160b(this.f5784b, this.f5783a, jSONObject));
                this.f5783a.setIgnoreUnresolvableIds(true);
                this.f5785c.m6756a(this.f5783a, 1);
            } catch (Throwable e) {
                C3095y.m9474a("Failed to fill in and load common connections", e);
                this.f5785c.m6755a(1);
            }
        }
    }

    /* renamed from: com.tinder.managers.c.3 */
    static class C28243 implements C0305a {
        final /* synthetic */ C2432m f5786a;

        C28243(C2432m c2432m) {
            this.f5786a = c2432m;
        }

        public void onErrorResponse(VolleyError volleyError) {
            this.f5786a.m6755a(1);
        }
    }

    /* renamed from: com.tinder.managers.c.4 */
    static class C28254 implements C0306b<JSONObject> {
        final /* synthetic */ C2587a f5787a;

        C28254(C2587a c2587a) {
            this.f5787a = c2587a;
        }

        public void m8149a(@NonNull JSONObject jSONObject) {
            C3095y.m9471a(jSONObject.toString());
            String optString = jSONObject.optString(Scopes.EMAIL);
            C3095y.m9471a("fb email:" + optString);
            this.f5787a.m7120a(optString);
        }
    }

    /* renamed from: com.tinder.managers.c.5 */
    static class C28265 implements C0305a {
        final /* synthetic */ C2587a f5788a;

        C28265(C2587a c2587a) {
            this.f5788a = c2587a;
        }

        public void onErrorResponse(@NonNull VolleyError volleyError) {
            C3095y.m9471a(volleyError.toString());
            this.f5788a.m7120a(null);
        }
    }

    /* renamed from: com.tinder.managers.c.6 */
    static class C28276 extends C0337j {
        C28276(int i, String str, JSONObject jSONObject, C0306b c0306b, C0305a c0305a) {
            super(i, str, jSONObject, c0306b, c0305a);
        }

        @NonNull
        public Map<String, String> m8150i() throws AuthFailureError {
            Map hashMap = new HashMap(1);
            hashMap.put(HTTP.CONTENT_TYPE, "application/json");
            return hashMap;
        }
    }

    static {
        f5789a = new C28221();
    }

    public C2828c() {
        this.f5792d = new HashMap();
        this.f5793e = new ArrayList();
        C3095y.m9469a();
        ManagerApp.m7914e();
        this.f5790b = new HashSet(12);
        Collections.addAll(this.f5790b, new String[]{"user_likes", Scopes.EMAIL, "user_birthday", "user_relationship_details", "user_education_history", "user_friends", "user_photos"});
    }

    public List<String> m8164a() {
        List<String> arrayList = new ArrayList(this.f5790b.size());
        Collection arrayList2 = new ArrayList(this.f5791c == null ? 0 : this.f5791c.size());
        arrayList.addAll(this.f5790b);
        if (this.f5791c != null) {
            arrayList2.addAll(this.f5791c);
            arrayList.removeAll(arrayList2);
        }
        return arrayList;
    }

    public void m8166a(@Nullable Set<String> set) {
        this.f5791c = set;
    }

    public static void m8161b() {
        LoginManager.getInstance().logOut();
    }

    @NonNull
    public static String m8151a(String str) {
        return "https://graph.facebook.com/me/?access_token=" + str;
    }

    @NonNull
    public static String m8152a(String str, String str2) {
        return "https://graph.facebook.com/" + str + '/' + "photos?" + "limit=" + 5000 + '&' + "fields=" + ShareConstants.WEB_DIALOG_PARAM_ID + ',' + ShareConstants.FEED_SOURCE_PARAM + ',' + ShareConstants.WEB_DIALOG_PARAM_PICTURE + '&' + "access_token=" + str2;
    }

    @NonNull
    public static String m8158b(String str) {
        return "https://graph.facebook.com/me/photos?limit=5000&fields=id,source,picture&access_token=" + str;
    }

    @NonNull
    public static String m8163c(String str) {
        return "https://graph.facebook.com/me?fields=albums.limit(5000).fields(id,name,count),photos.limit(5000).fields(id,picture)&access_token=" + str;
    }

    @NonNull
    public static String m8159b(String str, String str2) {
        return "https://graph.facebook.com/" + str + "/picture?type=album" + '&' + "access_token=" + str2;
    }

    public static void m8156a(@Nullable ConnectionsGroup connectionsGroup, int i, @NonNull C2432m c2432m) {
        if (connectionsGroup != null) {
            Object[] objArr = new Object[]{C2828c.m8162c(), C2828c.m8153a(connectionsGroup.getUnbuiltIds()), Integer.valueOf(i), Integer.valueOf(i)};
            ManagerApp.m7915f().m5900a(new C0337j(0, String.format("https://graph.facebook.com/?access_token=%s&ids=%s&fields=id,name,picture.width(%d).height(%d).fields(url)", objArr), (JSONObject) null, new C28232(connectionsGroup, connectionsGroup.getUnbuiltIds(), c2432m), new C28243(c2432m)));
        }
    }

    @NonNull
    private static List<CommonConnection> m8160b(@NonNull List<String> list, @NonNull ConnectionsGroup connectionsGroup, @NonNull JSONObject jSONObject) {
        List<CommonConnection> arrayList = new ArrayList(list.size());
        for (String str : list) {
            int degree = ((CommonConnection) connectionsGroup.getUnbuiltConnections().get(str)).getDegree();
            JSONObject optJSONObject = jSONObject.optJSONObject(str);
            if (optJSONObject != null) {
                String optString;
                String optString2 = optJSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_NAME, null);
                optJSONObject = optJSONObject.optJSONObject(ShareConstants.WEB_DIALOG_PARAM_PICTURE);
                if (optJSONObject != null) {
                    optJSONObject = optJSONObject.optJSONObject(ShareConstants.WEB_DIALOG_PARAM_DATA);
                    if (optJSONObject != null) {
                        optString = optJSONObject.optString(NativeProtocol.WEB_DIALOG_URL, null);
                        arrayList.add(new CommonConnection(str, degree, optString2, optString, optString, optString));
                    }
                }
                optString = null;
                arrayList.add(new CommonConnection(str, degree, optString2, optString, optString, optString));
            }
        }
        return arrayList;
    }

    private static String m8153a(@NonNull List<String> list) {
        int size = list.size();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < size; i++) {
            stringBuffer.append((String) list.get(i));
            if (i + 1 != size) {
                stringBuffer.append(',');
            }
        }
        return stringBuffer.toString();
    }

    @Nullable
    public static String m8162c() {
        return AccessToken.getCurrentAccessToken() == null ? null : AccessToken.getCurrentAccessToken().getToken();
    }

    public static void m8155a(@NonNull C2587a c2587a) {
        ManagerApp.m7915f().m5900a(new C28276(0, C2828c.m8151a(C2828c.m8162c()), (JSONObject) null, new C28254(c2587a), new C28265(c2587a)));
    }

    public void m8167d() {
        this.f5792d.clear();
        this.f5793e.clear();
    }

    @NonNull
    public String[] m8169e() {
        return (String[]) this.f5790b.toArray(new String[this.f5790b.size()]);
    }

    public boolean m8168d(String str) {
        C3095y.m9471a("mActualPermissions=" + this.f5791c);
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (currentAccessToken != null) {
            this.f5791c = currentAccessToken.getPermissions();
            return this.f5791c.contains(str);
        }
        C3095y.m9471a("No active facebook access token");
        return false;
    }

    public void m8170f() {
        AccessToken.setCurrentAccessToken(null);
        m8167d();
    }

    public void m8165a(@NonNull Activity activity, int i, String... strArr) {
        C3095y.m9471a("permission=" + Arrays.toString(strArr));
        if (!m8157a(strArr)) {
            Collections.addAll(this.f5790b, strArr);
        }
        LoginManager.getInstance().logInWithReadPermissions(activity, this.f5790b);
    }

    private boolean m8157a(String... strArr) {
        if (this.f5790b.containsAll(Arrays.asList(strArr))) {
            return true;
        }
        return false;
    }
}
