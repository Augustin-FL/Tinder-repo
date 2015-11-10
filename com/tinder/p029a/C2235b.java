package com.tinder.p029a;

import android.support.annotation.NonNull;
import java.net.URI;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

/* renamed from: com.tinder.a.b */
public class C2235b extends HttpEntityEnclosingRequestBase {
    public C2235b(@NonNull String str) {
        setURI(URI.create(str));
    }

    @NonNull
    public String getMethod() {
        return "DELETE";
    }
}
