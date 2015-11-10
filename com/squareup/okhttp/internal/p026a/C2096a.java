package com.squareup.okhttp.internal.p026a;

import com.squareup.okhttp.C2207l;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;

/* renamed from: com.squareup.okhttp.internal.a.a */
abstract class C2096a extends HttpsURLConnection {
    private final HttpURLConnection f3143a;

    protected abstract C2207l m5006a();

    public C2096a(HttpURLConnection httpURLConnection) {
        super(httpURLConnection.getURL());
        this.f3143a = httpURLConnection;
    }

    public String getCipherSuite() {
        C2207l a = m5006a();
        return a != null ? a.m5673a() : null;
    }

    public Certificate[] getLocalCertificates() {
        C2207l a = m5006a();
        if (a == null) {
            return null;
        }
        List d = a.m5676d();
        if (d.isEmpty()) {
            return null;
        }
        return (Certificate[]) d.toArray(new Certificate[d.size()]);
    }

    public Certificate[] getServerCertificates() throws SSLPeerUnverifiedException {
        C2207l a = m5006a();
        if (a == null) {
            return null;
        }
        List b = a.m5674b();
        if (b.isEmpty()) {
            return null;
        }
        return (Certificate[]) b.toArray(new Certificate[b.size()]);
    }

    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        C2207l a = m5006a();
        return a != null ? a.m5675c() : null;
    }

    public Principal getLocalPrincipal() {
        C2207l a = m5006a();
        return a != null ? a.m5677e() : null;
    }

    public void connect() throws IOException {
        this.connected = true;
        this.f3143a.connect();
    }

    public void disconnect() {
        this.f3143a.disconnect();
    }

    public InputStream getErrorStream() {
        return this.f3143a.getErrorStream();
    }

    public String getRequestMethod() {
        return this.f3143a.getRequestMethod();
    }

    public int getResponseCode() throws IOException {
        return this.f3143a.getResponseCode();
    }

    public String getResponseMessage() throws IOException {
        return this.f3143a.getResponseMessage();
    }

    public void setRequestMethod(String str) throws ProtocolException {
        this.f3143a.setRequestMethod(str);
    }

    public boolean usingProxy() {
        return this.f3143a.usingProxy();
    }

    public boolean getInstanceFollowRedirects() {
        return this.f3143a.getInstanceFollowRedirects();
    }

    public void setInstanceFollowRedirects(boolean z) {
        this.f3143a.setInstanceFollowRedirects(z);
    }

    public boolean getAllowUserInteraction() {
        return this.f3143a.getAllowUserInteraction();
    }

    public Object getContent() throws IOException {
        return this.f3143a.getContent();
    }

    public Object getContent(Class[] clsArr) throws IOException {
        return this.f3143a.getContent(clsArr);
    }

    public String getContentEncoding() {
        return this.f3143a.getContentEncoding();
    }

    public int getContentLength() {
        return this.f3143a.getContentLength();
    }

    public String getContentType() {
        return this.f3143a.getContentType();
    }

    public long getDate() {
        return this.f3143a.getDate();
    }

    public boolean getDefaultUseCaches() {
        return this.f3143a.getDefaultUseCaches();
    }

    public boolean getDoInput() {
        return this.f3143a.getDoInput();
    }

    public boolean getDoOutput() {
        return this.f3143a.getDoOutput();
    }

    public long getExpiration() {
        return this.f3143a.getExpiration();
    }

    public String getHeaderField(int i) {
        return this.f3143a.getHeaderField(i);
    }

    public Map<String, List<String>> getHeaderFields() {
        return this.f3143a.getHeaderFields();
    }

    public Map<String, List<String>> getRequestProperties() {
        return this.f3143a.getRequestProperties();
    }

    public void addRequestProperty(String str, String str2) {
        this.f3143a.addRequestProperty(str, str2);
    }

    public String getHeaderField(String str) {
        return this.f3143a.getHeaderField(str);
    }

    public long getHeaderFieldDate(String str, long j) {
        return this.f3143a.getHeaderFieldDate(str, j);
    }

    public int getHeaderFieldInt(String str, int i) {
        return this.f3143a.getHeaderFieldInt(str, i);
    }

    public String getHeaderFieldKey(int i) {
        return this.f3143a.getHeaderFieldKey(i);
    }

    public long getIfModifiedSince() {
        return this.f3143a.getIfModifiedSince();
    }

    public InputStream getInputStream() throws IOException {
        return this.f3143a.getInputStream();
    }

    public long getLastModified() {
        return this.f3143a.getLastModified();
    }

    public OutputStream getOutputStream() throws IOException {
        return this.f3143a.getOutputStream();
    }

    public Permission getPermission() throws IOException {
        return this.f3143a.getPermission();
    }

    public String getRequestProperty(String str) {
        return this.f3143a.getRequestProperty(str);
    }

    public URL getURL() {
        return this.f3143a.getURL();
    }

    public boolean getUseCaches() {
        return this.f3143a.getUseCaches();
    }

    public void setAllowUserInteraction(boolean z) {
        this.f3143a.setAllowUserInteraction(z);
    }

    public void setDefaultUseCaches(boolean z) {
        this.f3143a.setDefaultUseCaches(z);
    }

    public void setDoInput(boolean z) {
        this.f3143a.setDoInput(z);
    }

    public void setDoOutput(boolean z) {
        this.f3143a.setDoOutput(z);
    }

    public void setIfModifiedSince(long j) {
        this.f3143a.setIfModifiedSince(j);
    }

    public void setRequestProperty(String str, String str2) {
        this.f3143a.setRequestProperty(str, str2);
    }

    public void setUseCaches(boolean z) {
        this.f3143a.setUseCaches(z);
    }

    public void setConnectTimeout(int i) {
        this.f3143a.setConnectTimeout(i);
    }

    public int getConnectTimeout() {
        return this.f3143a.getConnectTimeout();
    }

    public void setReadTimeout(int i) {
        this.f3143a.setReadTimeout(i);
    }

    public int getReadTimeout() {
        return this.f3143a.getReadTimeout();
    }

    public String toString() {
        return this.f3143a.toString();
    }

    public void setFixedLengthStreamingMode(int i) {
        this.f3143a.setFixedLengthStreamingMode(i);
    }

    public void setChunkedStreamingMode(int i) {
        this.f3143a.setChunkedStreamingMode(i);
    }
}
