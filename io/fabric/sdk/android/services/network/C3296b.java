package io.fabric.sdk.android.services.network;

import io.fabric.sdk.android.C3212k;
import io.fabric.sdk.android.C3213b;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

/* renamed from: io.fabric.sdk.android.services.network.b */
public class C3296b implements C3295c {
    private final C3212k f7169a;
    private C0432e f7170b;
    private SSLSocketFactory f7171c;
    private boolean f7172d;

    /* renamed from: io.fabric.sdk.android.services.network.b.1 */
    static /* synthetic */ class C32941 {
        static final /* synthetic */ int[] f7168a;

        static {
            f7168a = new int[HttpMethod.values().length];
            try {
                f7168a[HttpMethod.GET.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f7168a[HttpMethod.POST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f7168a[HttpMethod.PUT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f7168a[HttpMethod.DELETE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public C3296b() {
        this(new C3213b());
    }

    public C3296b(C3212k c3212k) {
        this.f7169a = c3212k;
    }

    public void m10085a(C0432e c0432e) {
        if (this.f7170b != c0432e) {
            this.f7170b = c0432e;
            m10080a();
        }
    }

    private synchronized void m10080a() {
        this.f7172d = false;
        this.f7171c = null;
    }

    public HttpRequest m10084a(HttpMethod httpMethod, String str, Map<String, String> map) {
        HttpRequest a;
        switch (C32941.f7168a[httpMethod.ordinal()]) {
            case C3374b.SmoothProgressBar_spb_color /*1*/:
                a = HttpRequest.m10023a((CharSequence) str, (Map) map, true);
                break;
            case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                a = HttpRequest.m10028b((CharSequence) str, (Map) map, true);
                break;
            case C3374b.SmoothProgressBar_spb_stroke_separator_length /*3*/:
                a = HttpRequest.m10031d((CharSequence) str);
                break;
            case C3374b.SmoothProgressBar_spb_sections_count /*4*/:
                a = HttpRequest.m10032e((CharSequence) str);
                break;
            default:
                throw new IllegalArgumentException("Unsupported HTTP method!");
        }
        if (m10081a(str) && this.f7170b != null) {
            SSLSocketFactory b = m10082b();
            if (b != null) {
                ((HttpsURLConnection) a.m10050a()).setSSLSocketFactory(b);
            }
        }
        return a;
    }

    private boolean m10081a(String str) {
        return str != null && str.toLowerCase(Locale.US).startsWith("https");
    }

    private synchronized SSLSocketFactory m10082b() {
        if (this.f7171c == null && !this.f7172d) {
            this.f7171c = m10083c();
        }
        return this.f7171c;
    }

    private synchronized SSLSocketFactory m10083c() {
        SSLSocketFactory a;
        this.f7172d = true;
        try {
            a = C3297d.m10086a(this.f7170b);
            this.f7169a.m9687a("Fabric", "Custom SSL pinning enabled");
        } catch (Throwable e) {
            this.f7169a.m9695e("Fabric", "Exception while validating pinned certs", e);
            a = null;
        }
        return a;
    }
}
