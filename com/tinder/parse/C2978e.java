package com.tinder.parse;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.tinder.model.Group;
import com.tinder.model.TinderPurchase;
import com.tinder.utils.C3080q;
import com.tinder.utils.C3095y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tinder.parse.e */
public class C2978e {

    /* renamed from: com.tinder.parse.e.1 */
    static class C29761 implements Comparator<Group> {
        C29761() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m8925a((Group) obj, (Group) obj2);
        }

        public int m8925a(Group group, Group group2) {
            String key = group.getKey();
            String key2 = group2.getKey();
            int a = C3080q.m9421a(key);
            int a2 = C3080q.m9421a(key2);
            if (a > a2) {
                return -1;
            }
            if (a == a2 || a2 <= a) {
                return 0;
            }
            return 1;
        }
    }

    /* renamed from: com.tinder.parse.e.a */
    public static class C2977a {
        private String f6282a;
        private List<TinderPurchase> f6283b;

        public String m8926a() {
            return this.f6282a;
        }

        public void m8927a(String str) {
            this.f6282a = str;
        }

        public List<TinderPurchase> m8929b() {
            return this.f6283b;
        }

        public void m8928a(List<TinderPurchase> list) {
            this.f6283b = list;
        }

        @NonNull
        public String toString() {
            return "error: [" + this.f6282a + "] purchases:[" + this.f6283b + "]";
        }
    }

    @NonNull
    public static C2977a m8930a(@NonNull JSONObject jSONObject) {
        C2977a c2977a = new C2977a();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("results");
            if (!jSONArray.isNull(0)) {
                c2977a.m8927a(C2978e.m8932b(jSONArray.getJSONObject(0)));
                c2977a.m8928a(C2978e.m8933c(jSONObject));
                C3095y.m9471a("purchaseResults:" + c2977a.toString());
            }
        } catch (Throwable e) {
            C3095y.m9474a("Failed to parse tinder purchase result object", e);
        }
        return c2977a;
    }

    public static String m8932b(@NonNull JSONObject jSONObject) {
        return jSONObject.optString(NativeProtocol.BRIDGE_ARG_ERROR_BUNDLE);
    }

    @NonNull
    public static List<TinderPurchase> m8933c(@NonNull JSONObject jSONObject) {
        List<TinderPurchase> arrayList = new ArrayList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("results");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                TinderPurchase tinderPurchase = new TinderPurchase();
                if (jSONObject2.has("_id")) {
                    tinderPurchase.setId(jSONObject2.getString("_id"));
                }
                if (jSONObject2.has("product_id")) {
                    tinderPurchase.setProductId(jSONObject2.getString("product_id"));
                }
                if (jSONObject2.has("product_type")) {
                    tinderPurchase.setProductType(jSONObject2.getString("product_type"));
                }
                if (jSONObject2.has("purchase_type")) {
                    tinderPurchase.setPurchaseType(jSONObject2.getString("purchase_type"));
                }
                if (jSONObject2.has("create_date")) {
                    tinderPurchase.setCreateDate(jSONObject2.getString("create_date"));
                }
                arrayList.add(tinderPurchase);
            }
        } catch (Exception e) {
            C3095y.m9471a(e.getMessage());
        }
        return arrayList;
    }

    @NonNull
    public static List<Group> m8931a(@Nullable JSONArray jSONArray) {
        List<Group> arrayList = new ArrayList();
        if (jSONArray != null) {
            int i = 0;
            while (i < jSONArray.length()) {
                try {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("type");
                        String optString2 = optJSONObject.optString("sub_type");
                        String optString3 = optJSONObject.optString("key");
                        String optString4 = optJSONObject.optString("group_id");
                        String optString5 = optJSONObject.optString(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION);
                        boolean optBoolean = optJSONObject.optBoolean("is_base_group");
                        boolean optBoolean2 = optJSONObject.optBoolean("is_primary");
                        Group group = new Group();
                        group.setIsBase(optBoolean);
                        group.setIsPrimary(optBoolean2);
                        group.setType(optString);
                        group.setSubType(optString2);
                        group.setKey(optString3);
                        group.setGroupId(optString4);
                        group.setVersion(optString5);
                        arrayList.add(group);
                    }
                    i++;
                } catch (Throwable e) {
                    C3095y.m9474a("Failed to parse sku groups from API", e);
                }
            }
            Collections.sort(arrayList, new C29761());
        }
        return arrayList;
    }
}
