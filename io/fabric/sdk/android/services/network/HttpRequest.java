package io.fabric.sdk.android.services.network;

import com.facebook.internal.Utility;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URI;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpStatus;
import org.apache.http.entity.mime.MIME;
import org.apache.http.protocol.HTTP;

public class HttpRequest {
    private static final String[] f7156b;
    private static C3290b f7157c;
    public final URL f7158a;
    private HttpURLConnection f7159d;
    private final String f7160e;
    private C3292d f7161f;
    private boolean f7162g;
    private boolean f7163h;
    private boolean f7164i;
    private int f7165j;
    private String f7166k;
    private int f7167l;

    /* renamed from: io.fabric.sdk.android.services.network.HttpRequest.c */
    protected static abstract class C3287c<V> implements Callable<V> {
        protected abstract V m10011b() throws HttpRequestException, IOException;

        protected abstract void m10012c() throws IOException;

        protected C3287c() {
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public V call() throws io.fabric.sdk.android.services.network.HttpRequest.HttpRequestException {
            /*
            r3 = this;
            r1 = 1;
            r2 = 0;
            r0 = r3.m10011b();	 Catch:{ HttpRequestException -> 0x0011, IOException -> 0x0018, all -> 0x0028 }
            r3.m10012c();	 Catch:{ IOException -> 0x000a }
            return r0;
        L_0x000a:
            r0 = move-exception;
            r1 = new io.fabric.sdk.android.services.network.HttpRequest$HttpRequestException;
            r1.<init>(r0);
            throw r1;
        L_0x0011:
            r0 = move-exception;
            throw r0;	 Catch:{ all -> 0x0013 }
        L_0x0013:
            r0 = move-exception;
        L_0x0014:
            r3.m10012c();	 Catch:{ IOException -> 0x001f }
        L_0x0017:
            throw r0;
        L_0x0018:
            r0 = move-exception;
            r2 = new io.fabric.sdk.android.services.network.HttpRequest$HttpRequestException;	 Catch:{ all -> 0x0013 }
            r2.<init>(r0);	 Catch:{ all -> 0x0013 }
            throw r2;	 Catch:{ all -> 0x0013 }
        L_0x001f:
            r2 = move-exception;
            if (r1 != 0) goto L_0x0017;
        L_0x0022:
            r0 = new io.fabric.sdk.android.services.network.HttpRequest$HttpRequestException;
            r0.<init>(r2);
            throw r0;
        L_0x0028:
            r0 = move-exception;
            r1 = r2;
            goto L_0x0014;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.network.HttpRequest.c.call():V");
        }
    }

    /* renamed from: io.fabric.sdk.android.services.network.HttpRequest.a */
    protected static abstract class C3288a<V> extends C3287c<V> {
        private final Closeable f7149a;
        private final boolean f7150b;

        protected C3288a(Closeable closeable, boolean z) {
            this.f7149a = closeable;
            this.f7150b = z;
        }

        protected void m10013c() throws IOException {
            if (this.f7149a instanceof Flushable) {
                ((Flushable) this.f7149a).flush();
            }
            if (this.f7150b) {
                try {
                    this.f7149a.close();
                    return;
                } catch (IOException e) {
                    return;
                }
            }
            this.f7149a.close();
        }
    }

    /* renamed from: io.fabric.sdk.android.services.network.HttpRequest.1 */
    class C32891 extends C3288a<HttpRequest> {
        final /* synthetic */ InputStream f7151a;
        final /* synthetic */ OutputStream f7152b;
        final /* synthetic */ HttpRequest f7153c;

        C32891(HttpRequest httpRequest, Closeable closeable, boolean z, InputStream inputStream, OutputStream outputStream) {
            this.f7153c = httpRequest;
            this.f7151a = inputStream;
            this.f7152b = outputStream;
            super(closeable, z);
        }

        public /* synthetic */ Object m10015b() throws HttpRequestException, IOException {
            return m10014a();
        }

        public HttpRequest m10014a() throws IOException {
            byte[] bArr = new byte[this.f7153c.f7165j];
            while (true) {
                int read = this.f7151a.read(bArr);
                if (read == -1) {
                    return this.f7153c;
                }
                this.f7152b.write(bArr, 0, read);
            }
        }
    }

    public static class HttpRequestException extends RuntimeException {
        private static final long serialVersionUID = -1170466989781746231L;

        public /* synthetic */ Throwable getCause() {
            return m10016a();
        }

        protected HttpRequestException(IOException iOException) {
            super(iOException);
        }

        public IOException m10016a() {
            return (IOException) super.getCause();
        }
    }

    /* renamed from: io.fabric.sdk.android.services.network.HttpRequest.b */
    public interface C3290b {
        public static final C3290b f7154a;

        /* renamed from: io.fabric.sdk.android.services.network.HttpRequest.b.1 */
        static class C32911 implements C3290b {
            C32911() {
            }

            public HttpURLConnection m10019a(URL url) throws IOException {
                return (HttpURLConnection) url.openConnection();
            }

            public HttpURLConnection m10020a(URL url, Proxy proxy) throws IOException {
                return (HttpURLConnection) url.openConnection(proxy);
            }
        }

        HttpURLConnection m10017a(URL url) throws IOException;

        HttpURLConnection m10018a(URL url, Proxy proxy) throws IOException;

        static {
            f7154a = new C32911();
        }
    }

    /* renamed from: io.fabric.sdk.android.services.network.HttpRequest.d */
    public static class C3292d extends BufferedOutputStream {
        private final CharsetEncoder f7155a;

        public C3292d(OutputStream outputStream, String str, int i) {
            super(outputStream, i);
            this.f7155a = Charset.forName(HttpRequest.m10034f(str)).newEncoder();
        }

        public C3292d m10021a(String str) throws IOException {
            ByteBuffer encode = this.f7155a.encode(CharBuffer.wrap(str));
            super.write(encode.array(), 0, encode.limit());
            return this;
        }
    }

    static {
        f7156b = new String[0];
        f7157c = C3290b.f7154a;
    }

    private static String m10034f(String str) {
        return (str == null || str.length() <= 0) ? HTTP.UTF_8 : str;
    }

    private static StringBuilder m10026a(String str, StringBuilder stringBuilder) {
        if (str.indexOf(58) + 2 == str.lastIndexOf(47)) {
            stringBuilder.append('/');
        }
        return stringBuilder;
    }

    private static StringBuilder m10029b(String str, StringBuilder stringBuilder) {
        int indexOf = str.indexOf(63);
        int length = stringBuilder.length() - 1;
        if (indexOf == -1) {
            stringBuilder.append('?');
        } else if (indexOf < length && str.charAt(length) != '&') {
            stringBuilder.append('&');
        }
        return stringBuilder;
    }

    public static String m10024a(CharSequence charSequence) throws HttpRequestException {
        try {
            URL url = new URL(charSequence.toString());
            String host = url.getHost();
            int port = url.getPort();
            if (port != -1) {
                host = host + ':' + Integer.toString(port);
            }
            try {
                String toASCIIString = new URI(url.getProtocol(), host, url.getPath(), url.getQuery(), null).toASCIIString();
                int indexOf = toASCIIString.indexOf(63);
                if (indexOf > 0 && indexOf + 1 < toASCIIString.length()) {
                    toASCIIString = toASCIIString.substring(0, indexOf + 1) + toASCIIString.substring(indexOf + 1).replace("+", "%2B");
                }
                return toASCIIString;
            } catch (Throwable e) {
                IOException iOException = new IOException("Parsing URI failed");
                iOException.initCause(e);
                throw new HttpRequestException(iOException);
            }
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    public static String m10025a(CharSequence charSequence, Map<?, ?> map) {
        String charSequence2 = charSequence.toString();
        if (map == null || map.isEmpty()) {
            return charSequence2;
        }
        StringBuilder stringBuilder = new StringBuilder(charSequence2);
        m10026a(charSequence2, stringBuilder);
        m10029b(charSequence2, stringBuilder);
        Iterator it = map.entrySet().iterator();
        Entry entry = (Entry) it.next();
        stringBuilder.append(entry.getKey().toString());
        stringBuilder.append('=');
        Object value = entry.getValue();
        if (value != null) {
            stringBuilder.append(value);
        }
        while (it.hasNext()) {
            stringBuilder.append('&');
            entry = (Entry) it.next();
            stringBuilder.append(entry.getKey().toString());
            stringBuilder.append('=');
            value = entry.getValue();
            if (value != null) {
                stringBuilder.append(value);
            }
        }
        return stringBuilder.toString();
    }

    public static HttpRequest m10027b(CharSequence charSequence) throws HttpRequestException {
        return new HttpRequest(charSequence, "GET");
    }

    public static HttpRequest m10023a(CharSequence charSequence, Map<?, ?> map, boolean z) {
        CharSequence a = m10025a(charSequence, (Map) map);
        if (z) {
            a = m10024a(a);
        }
        return m10027b(a);
    }

    public static HttpRequest m10030c(CharSequence charSequence) throws HttpRequestException {
        return new HttpRequest(charSequence, "POST");
    }

    public static HttpRequest m10028b(CharSequence charSequence, Map<?, ?> map, boolean z) {
        CharSequence a = m10025a(charSequence, (Map) map);
        if (z) {
            a = m10024a(a);
        }
        return m10030c(a);
    }

    public static HttpRequest m10031d(CharSequence charSequence) throws HttpRequestException {
        return new HttpRequest(charSequence, "PUT");
    }

    public static HttpRequest m10032e(CharSequence charSequence) throws HttpRequestException {
        return new HttpRequest(charSequence, "DELETE");
    }

    public HttpRequest(CharSequence charSequence, String str) throws HttpRequestException {
        this.f7159d = null;
        this.f7163h = true;
        this.f7164i = false;
        this.f7165j = Utility.DEFAULT_STREAM_BUFFER_SIZE;
        try {
            this.f7158a = new URL(charSequence.toString());
            this.f7160e = str;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    private Proxy m10035q() {
        return new Proxy(Type.HTTP, new InetSocketAddress(this.f7166k, this.f7167l));
    }

    private HttpURLConnection m10036r() {
        try {
            HttpURLConnection a;
            if (this.f7166k != null) {
                a = f7157c.m10018a(this.f7158a, m10035q());
            } else {
                a = f7157c.m10017a(this.f7158a);
            }
            a.setRequestMethod(this.f7160e);
            return a;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public String toString() {
        return m10075p() + ' ' + m10074o();
    }

    public HttpURLConnection m10050a() {
        if (this.f7159d == null) {
            this.f7159d = m10036r();
        }
        return this.f7159d;
    }

    public int m10051b() throws HttpRequestException {
        try {
            m10070k();
            return m10050a().getResponseCode();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public boolean m10057c() throws HttpRequestException {
        return HttpStatus.SC_OK == m10051b();
    }

    protected ByteArrayOutputStream m10060d() {
        int j = m10069j();
        if (j > 0) {
            return new ByteArrayOutputStream(j);
        }
        return new ByteArrayOutputStream();
    }

    public String m10049a(String str) throws HttpRequestException {
        OutputStream d = m10060d();
        try {
            m10039a(m10065f(), d);
            return d.toString(m10034f(str));
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public String m10062e() throws HttpRequestException {
        return m10049a(m10067h());
    }

    public BufferedInputStream m10065f() throws HttpRequestException {
        return new BufferedInputStream(m10066g(), this.f7165j);
    }

    public InputStream m10066g() throws HttpRequestException {
        if (m10051b() < HttpStatus.SC_BAD_REQUEST) {
            try {
                InputStream inputStream = m10050a().getInputStream();
            } catch (IOException e) {
                throw new HttpRequestException(e);
            }
        }
        inputStream = m10050a().getErrorStream();
        if (inputStream == null) {
            try {
                inputStream = m10050a().getInputStream();
            } catch (IOException e2) {
                throw new HttpRequestException(e2);
            }
        }
        if (!this.f7164i || !"gzip".equals(m10068i())) {
            return inputStream;
        }
        try {
            return new GZIPInputStream(inputStream);
        } catch (IOException e22) {
            throw new HttpRequestException(e22);
        }
    }

    public HttpRequest m10038a(int i) {
        m10050a().setConnectTimeout(i);
        return this;
    }

    public HttpRequest m10041a(String str, String str2) {
        m10050a().setRequestProperty(str, str2);
        return this;
    }

    public HttpRequest m10047a(Entry<String, String> entry) {
        return m10041a((String) entry.getKey(), (String) entry.getValue());
    }

    public String m10053b(String str) throws HttpRequestException {
        m10071l();
        return m10050a().getHeaderField(str);
    }

    public int m10055c(String str) throws HttpRequestException {
        return m10037a(str, -1);
    }

    public int m10037a(String str, int i) throws HttpRequestException {
        m10071l();
        return m10050a().getHeaderFieldInt(str, i);
    }

    public String m10054b(String str, String str2) {
        return m10056c(m10053b(str), str2);
    }

    protected String m10056c(String str, String str2) {
        if (str == null || str.length() == 0) {
            return null;
        }
        int length = str.length();
        int indexOf = str.indexOf(59) + 1;
        if (indexOf == 0 || indexOf == length) {
            return null;
        }
        int indexOf2 = str.indexOf(59, indexOf);
        if (indexOf2 == -1) {
            indexOf2 = indexOf;
            indexOf = length;
        } else {
            int i = indexOf2;
            indexOf2 = indexOf;
            indexOf = i;
        }
        while (indexOf2 < indexOf) {
            int indexOf3 = str.indexOf(61, indexOf2);
            if (indexOf3 != -1 && indexOf3 < indexOf && str2.equals(str.substring(indexOf2, indexOf3).trim())) {
                String trim = str.substring(indexOf3 + 1, indexOf).trim();
                indexOf3 = trim.length();
                if (indexOf3 != 0) {
                    if (indexOf3 > 2 && '\"' == trim.charAt(0) && '\"' == trim.charAt(indexOf3 - 1)) {
                        return trim.substring(1, indexOf3 - 1);
                    }
                    return trim;
                }
            }
            indexOf++;
            indexOf2 = str.indexOf(59, indexOf);
            if (indexOf2 == -1) {
                indexOf2 = length;
            }
            i = indexOf2;
            indexOf2 = indexOf;
            indexOf = i;
        }
        return null;
    }

    public String m10067h() {
        return m10054b(HTTP.CONTENT_TYPE, "charset");
    }

    public HttpRequest m10048a(boolean z) {
        m10050a().setUseCaches(z);
        return this;
    }

    public String m10068i() {
        return m10053b(HTTP.CONTENT_ENCODING);
    }

    public HttpRequest m10058d(String str) {
        return m10059d(str, null);
    }

    public HttpRequest m10059d(String str, String str2) {
        if (str2 == null || str2.length() <= 0) {
            return m10041a(HTTP.CONTENT_TYPE, str);
        }
        String str3 = HTTP.CHARSET_PARAM;
        return m10041a(HTTP.CONTENT_TYPE, str + HTTP.CHARSET_PARAM + str2);
    }

    public int m10069j() {
        return m10055c(HTTP.CONTENT_LEN);
    }

    protected HttpRequest m10039a(InputStream inputStream, OutputStream outputStream) throws IOException {
        return (HttpRequest) new C32891(this, inputStream, this.f7163h, inputStream, outputStream).call();
    }

    protected HttpRequest m10070k() throws IOException {
        if (this.f7161f != null) {
            if (this.f7162g) {
                this.f7161f.m10021a("\r\n--00content0boundary00--\r\n");
            }
            if (this.f7163h) {
                try {
                    this.f7161f.close();
                } catch (IOException e) {
                }
            } else {
                this.f7161f.close();
            }
            this.f7161f = null;
        }
        return this;
    }

    protected HttpRequest m10071l() throws HttpRequestException {
        try {
            return m10070k();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    protected HttpRequest m10072m() throws IOException {
        if (this.f7161f == null) {
            m10050a().setDoOutput(true);
            this.f7161f = new C3292d(m10050a().getOutputStream(), m10056c(m10050a().getRequestProperty(HTTP.CONTENT_TYPE), "charset"), this.f7165j);
        }
        return this;
    }

    protected HttpRequest m10073n() throws IOException {
        if (this.f7162g) {
            this.f7161f.m10021a("\r\n--00content0boundary00\r\n");
        } else {
            this.f7162g = true;
            m10058d("multipart/form-data; boundary=00content0boundary00").m10072m();
            this.f7161f.m10021a("--00content0boundary00\r\n");
        }
        return this;
    }

    protected HttpRequest m10043a(String str, String str2, String str3) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("form-data; name=\"").append(str);
        if (str2 != null) {
            stringBuilder.append("\"; filename=\"").append(str2);
        }
        stringBuilder.append('\"');
        m10064f(MIME.CONTENT_DISPOSITION, stringBuilder.toString());
        if (str3 != null) {
            m10064f(HTTP.CONTENT_TYPE, str3);
        }
        return m10063f((CharSequence) "\r\n");
    }

    public HttpRequest m10061e(String str, String str2) {
        return m10052b(str, null, str2);
    }

    public HttpRequest m10052b(String str, String str2, String str3) throws HttpRequestException {
        return m10046a(str, str2, null, str3);
    }

    public HttpRequest m10046a(String str, String str2, String str3, String str4) throws HttpRequestException {
        try {
            m10073n();
            m10043a(str, str2, str3);
            this.f7161f.m10021a(str4);
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest m10040a(String str, Number number) throws HttpRequestException {
        return m10042a(str, null, number);
    }

    public HttpRequest m10042a(String str, String str2, Number number) throws HttpRequestException {
        return m10052b(str, str2, number != null ? number.toString() : null);
    }

    public HttpRequest m10044a(String str, String str2, String str3, File file) throws HttpRequestException {
        InputStream bufferedInputStream;
        IOException e;
        Throwable th;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                HttpRequest a = m10045a(str, str2, str3, bufferedInputStream);
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e2) {
                    }
                }
                return a;
            } catch (IOException e3) {
                e = e3;
                try {
                    throw new HttpRequestException(e);
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e5) {
            e = e5;
            bufferedInputStream = null;
            throw new HttpRequestException(e);
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            throw th;
        }
    }

    public HttpRequest m10045a(String str, String str2, String str3, InputStream inputStream) throws HttpRequestException {
        try {
            m10073n();
            m10043a(str, str2, str3);
            m10039a(inputStream, this.f7161f);
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest m10064f(String str, String str2) throws HttpRequestException {
        return m10063f((CharSequence) str).m10063f((CharSequence) ": ").m10063f((CharSequence) str2).m10063f((CharSequence) "\r\n");
    }

    public HttpRequest m10063f(CharSequence charSequence) throws HttpRequestException {
        try {
            m10072m();
            this.f7161f.m10021a(charSequence.toString());
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public URL m10074o() {
        return m10050a().getURL();
    }

    public String m10075p() {
        return m10050a().getRequestMethod();
    }
}
