package p000a;

import android.net.Uri;
import java.util.Collections;
import java.util.List;

/* renamed from: a.b */
public class C0004b {
    private Uri f9a;
    private List<C0003a> f10b;
    private Uri f11c;

    /* renamed from: a.b.a */
    public static class C0003a {
        private final Uri f5a;
        private final String f6b;
        private final String f7c;
        private final String f8d;

        public C0003a(String str, String str2, Uri uri, String str3) {
            this.f6b = str;
            this.f7c = str2;
            this.f5a = uri;
            this.f8d = str3;
        }
    }

    public C0004b(Uri uri, List<C0003a> list, Uri uri2) {
        this.f9a = uri;
        if (list == null) {
            list = Collections.emptyList();
        }
        this.f10b = list;
        this.f11c = uri2;
    }
}
