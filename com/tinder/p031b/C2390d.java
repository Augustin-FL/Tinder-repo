package com.tinder.p031b;

import com.facebook.share.internal.ShareConstants;
import com.tinder.enums.SqlDataType;

/* renamed from: com.tinder.b.d */
public class C2390d extends C2388c {
    public C2390d() {
        this.a = "facebook_friends";
        this.b = new C2387a[]{new C2387a(ShareConstants.WEB_DIALOG_PARAM_ID, SqlDataType.TEXT, true), new C2387a(ShareConstants.WEB_DIALOG_PARAM_NAME, SqlDataType.TEXT, false), new C2387a("avatar_url", SqlDataType.TEXT, false), new C2387a("state", SqlDataType.INTEGER, false), new C2387a("is_on_tinder", SqlDataType.BOOLEAN, false)};
    }
}
