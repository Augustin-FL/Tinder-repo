package com.squareup.okhttp;

import com.squareup.okhttp.internal.C2157k;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* renamed from: com.squareup.okhttp.i */
public final class C2095i {
    public static final C2095i f3135a;
    public static final C2095i f3136b;
    public static final C2095i f3137c;
    private static final CipherSuite[] f3138f;
    final boolean f3139d;
    final boolean f3140e;
    private final String[] f3141g;
    private final String[] f3142h;

    /* renamed from: com.squareup.okhttp.i.a */
    public static final class C2094a {
        private boolean f3131a;
        private String[] f3132b;
        private String[] f3133c;
        private boolean f3134d;

        C2094a(boolean z) {
            this.f3131a = z;
        }

        public C2094a(C2095i c2095i) {
            this.f3131a = c2095i.f3139d;
            this.f3132b = c2095i.f3141g;
            this.f3133c = c2095i.f3142h;
            this.f3134d = c2095i.f3140e;
        }

        public C2094a m4991a(CipherSuite... cipherSuiteArr) {
            if (this.f3131a) {
                String[] strArr = new String[cipherSuiteArr.length];
                for (int i = 0; i < cipherSuiteArr.length; i++) {
                    strArr[i] = cipherSuiteArr[i].aS;
                }
                this.f3132b = strArr;
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public C2094a m4993a(String... strArr) {
            if (this.f3131a) {
                if (strArr == null) {
                    this.f3132b = null;
                } else {
                    this.f3132b = (String[]) strArr.clone();
                }
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public C2094a m4992a(TlsVersion... tlsVersionArr) {
            if (!this.f3131a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else if (tlsVersionArr.length == 0) {
                throw new IllegalArgumentException("At least one TlsVersion is required");
            } else {
                String[] strArr = new String[tlsVersionArr.length];
                for (int i = 0; i < tlsVersionArr.length; i++) {
                    strArr[i] = tlsVersionArr[i].f3043e;
                }
                this.f3133c = strArr;
                return this;
            }
        }

        public C2094a m4995b(String... strArr) {
            if (this.f3131a) {
                if (strArr == null) {
                    this.f3133c = null;
                } else {
                    this.f3133c = (String[]) strArr.clone();
                }
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public C2094a m4990a(boolean z) {
            if (this.f3131a) {
                this.f3134d = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public C2095i m4994a() {
            return new C2095i();
        }
    }

    static {
        f3138f = new CipherSuite[]{CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_DSS_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
        f3135a = new C2094a(true).m4991a(f3138f).m4992a(TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0).m4990a(true).m4994a();
        f3136b = new C2094a(f3135a).m4992a(TlsVersion.TLS_1_0).m4990a(true).m4994a();
        f3137c = new C2094a(false).m4994a();
    }

    private C2095i(C2094a c2094a) {
        this.f3139d = c2094a.f3131a;
        this.f3141g = c2094a.f3132b;
        this.f3142h = c2094a.f3133c;
        this.f3140e = c2094a.f3134d;
    }

    public List<CipherSuite> m5001a() {
        if (this.f3141g == null) {
            return null;
        }
        Object[] objArr = new CipherSuite[this.f3141g.length];
        for (int i = 0; i < this.f3141g.length; i++) {
            objArr[i] = CipherSuite.m4865a(this.f3141g[i]);
        }
        return C2157k.m5349a(objArr);
    }

    public List<TlsVersion> m5004b() {
        Object[] objArr = new TlsVersion[this.f3142h.length];
        for (int i = 0; i < this.f3142h.length; i++) {
            objArr[i] = TlsVersion.m4867a(this.f3142h[i]);
        }
        return C2157k.m5349a(objArr);
    }

    public boolean m5005c() {
        return this.f3140e;
    }

    void m5002a(SSLSocket sSLSocket, boolean z) {
        C2095i b = m4999b(sSLSocket, z);
        sSLSocket.setEnabledProtocols(b.f3142h);
        String[] strArr = b.f3141g;
        if (strArr != null) {
            sSLSocket.setEnabledCipherSuites(strArr);
        }
    }

    private C2095i m4999b(SSLSocket sSLSocket, boolean z) {
        String[] strArr;
        Object obj = null;
        if (this.f3141g != null) {
            obj = (String[]) C2157k.m5360a(String.class, this.f3141g, sSLSocket.getEnabledCipherSuites());
        }
        if (z) {
            String str = "TLS_FALLBACK_SCSV";
            if (Arrays.asList(sSLSocket.getSupportedCipherSuites()).contains("TLS_FALLBACK_SCSV")) {
                if (obj == null) {
                    obj = sSLSocket.getEnabledCipherSuites();
                }
                strArr = new String[(obj.length + 1)];
                System.arraycopy(obj, 0, strArr, 0, obj.length);
                strArr[strArr.length - 1] = "TLS_FALLBACK_SCSV";
                return new C2094a(this).m4993a(strArr).m4995b((String[]) C2157k.m5360a(String.class, this.f3142h, sSLSocket.getEnabledProtocols())).m4994a();
            }
        }
        Object obj2 = obj;
        return new C2094a(this).m4993a(strArr).m4995b((String[]) C2157k.m5360a(String.class, this.f3142h, sSLSocket.getEnabledProtocols())).m4994a();
    }

    public boolean m5003a(SSLSocket sSLSocket) {
        if (!this.f3139d) {
            return false;
        }
        if (!C2095i.m4997a(this.f3142h, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        if (this.f3141g != null) {
            return C2095i.m4997a(this.f3141g, sSLSocket.getEnabledCipherSuites());
        } else if (sSLSocket.getEnabledCipherSuites().length > 0) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean m4997a(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0) {
            return false;
        }
        for (Object a : strArr) {
            if (C2095i.m4996a((Object[]) strArr2, a)) {
                return true;
            }
        }
        return false;
    }

    private static <T> boolean m4996a(T[] tArr, T t) {
        for (Object a : tArr) {
            if (C2157k.m5358a((Object) t, a)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2095i)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        C2095i c2095i = (C2095i) obj;
        if (this.f3139d != c2095i.f3139d) {
            return false;
        }
        if (!this.f3139d || (Arrays.equals(this.f3141g, c2095i.f3141g) && Arrays.equals(this.f3142h, c2095i.f3142h) && this.f3140e == c2095i.f3140e)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (!this.f3139d) {
            return 17;
        }
        return (this.f3140e ? 0 : 1) + ((((Arrays.hashCode(this.f3141g) + 527) * 31) + Arrays.hashCode(this.f3142h)) * 31);
    }

    public String toString() {
        if (!this.f3139d) {
            return "ConnectionSpec()";
        }
        List a = m5001a();
        return "ConnectionSpec(cipherSuites=" + (a == null ? "[use default]" : a.toString()) + ", tlsVersions=" + m5004b() + ", supportsTlsExtensions=" + this.f3140e + ")";
    }
}
