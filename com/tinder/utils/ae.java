package com.tinder.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tinder.views.RangeSeekBar;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.HttpHost;

public final class ae implements CookieStore {
    private final Map<URI, List<HttpCookie>> f6530a;
    private final SharedPreferences f6531b;

    public ae(Context context) {
        int i = 0;
        this.f6531b = context.getSharedPreferences("CookiePrefsFile", 0);
        this.f6530a = new HashMap();
        String string = this.f6531b.getString("names", null);
        if (string != null) {
            String[] split = TextUtils.split(string, ",");
            int length = split.length;
            while (i < length) {
                String str = split[i];
                String string2 = this.f6531b.getString("cookie_" + str, null);
                if (string2 != null) {
                    HttpCookie a = m9226a(string2);
                    if (a != null) {
                        List arrayList = new ArrayList();
                        arrayList.add(a);
                        this.f6530a.put(URI.create(str), arrayList);
                    }
                }
                i++;
            }
        }
    }

    public synchronized void add(URI uri, HttpCookie httpCookie) {
        if (httpCookie == null) {
            throw new NullPointerException("cookie == null");
        }
        URI a = m9223a(uri);
        List list = (List) this.f6530a.get(a);
        if (list == null) {
            list = new ArrayList();
            this.f6530a.put(a, list);
        } else {
            list.remove(httpCookie);
        }
        list.add(httpCookie);
        Editor edit = this.f6531b.edit();
        edit.putString("names", TextUtils.join(",", this.f6530a.keySet()));
        String a2 = m9224a(new SerializableHttpCookie(httpCookie));
        if (a2 != null) {
            edit.putString("cookie_" + a, a2);
            edit.commit();
        } else {
            list.remove(httpCookie);
            C3095y.m9487f(String.format("Failed to encode cookie: %s", new Object[]{httpCookie}));
        }
    }

    public synchronized List<HttpCookie> get(URI uri) {
        List arrayList;
        if (uri == null) {
            throw new NullPointerException("uri == null");
        }
        Iterator it;
        HttpCookie httpCookie;
        arrayList = new ArrayList();
        List list = (List) this.f6530a.get(uri);
        if (list != null) {
            it = list.iterator();
            while (it.hasNext()) {
                httpCookie = (HttpCookie) it.next();
                if (httpCookie.hasExpired()) {
                    it.remove();
                } else {
                    arrayList.add(httpCookie);
                }
            }
        }
        for (Entry entry : this.f6530a.entrySet()) {
            if (!uri.equals(entry.getKey())) {
                Iterator it2 = ((List) entry.getValue()).iterator();
                while (it2.hasNext()) {
                    httpCookie = (HttpCookie) it2.next();
                    if (HttpCookie.domainMatches(httpCookie.getDomain(), uri.getHost())) {
                        if (httpCookie.hasExpired()) {
                            it2.remove();
                        } else if (!arrayList.contains(httpCookie)) {
                            arrayList.add(httpCookie);
                        }
                    }
                }
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public synchronized List<HttpCookie> getCookies() {
        List arrayList;
        arrayList = new ArrayList();
        for (List it : this.f6530a.values()) {
            Iterator it2 = it.iterator();
            while (it2.hasNext()) {
                HttpCookie httpCookie = (HttpCookie) it2.next();
                if (httpCookie.hasExpired()) {
                    it2.remove();
                } else if (!arrayList.contains(httpCookie)) {
                    arrayList.add(httpCookie);
                }
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public synchronized List<URI> getURIs() {
        List arrayList;
        arrayList = new ArrayList(this.f6530a.keySet());
        arrayList.remove(null);
        return Collections.unmodifiableList(arrayList);
    }

    public synchronized boolean remove(URI uri, HttpCookie httpCookie) {
        boolean remove;
        if (httpCookie == null) {
            throw new NullPointerException("cookie == null");
        }
        URI a = m9223a(uri);
        List list = (List) this.f6530a.get(a);
        if (list != null) {
            this.f6531b.edit().remove("cookie_" + a).commit();
            remove = list.remove(httpCookie);
        } else {
            remove = false;
        }
        return remove;
    }

    public synchronized boolean removeAll() {
        this.f6531b.edit().clear().commit();
        if (this.f6530a.isEmpty()) {
            this.f6530a.clear();
        } else {
            this.f6530a.clear();
        }
        return true;
    }

    protected String m9224a(SerializableHttpCookie serializableHttpCookie) {
        if (serializableHttpCookie == null) {
            return null;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(byteArrayOutputStream).writeObject(serializableHttpCookie);
            String a = m9225a(byteArrayOutputStream.toByteArray());
            try {
                byteArrayOutputStream.close();
                return a;
            } catch (IOException e) {
                return null;
            }
        } catch (Throwable e2) {
            C3095y.m9474a("IOException in encodeCookie", e2);
            return null;
        }
    }

    protected HttpCookie m9226a(String str) {
        HttpCookie a;
        Throwable e;
        Throwable th;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(m9227b(str)));
            a = ((SerializableHttpCookie) objectInputStream.readObject()).m9199a();
            try {
                objectInputStream.close();
            } catch (IOException e2) {
                e = e2;
                C3095y.m9474a("IOException in decodeCookie", e);
                return a;
            } catch (ClassNotFoundException e3) {
                e = e3;
                C3095y.m9474a("ClassNotFoundException in decodeCookie", e);
                return a;
            }
        } catch (Throwable e4) {
            th = e4;
            a = null;
            e = th;
            C3095y.m9474a("IOException in decodeCookie", e);
            return a;
        } catch (Throwable e42) {
            th = e42;
            a = null;
            e = th;
            C3095y.m9474a("ClassNotFoundException in decodeCookie", e);
            return a;
        }
        return a;
    }

    protected String m9225a(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            int i = b & RangeSeekBar.INVALID_POINTER_ID;
            if (i < 16) {
                stringBuilder.append('0');
            }
            stringBuilder.append(Integer.toHexString(i));
        }
        return stringBuilder.toString().toUpperCase(Locale.US);
    }

    protected byte[] m9227b(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    private URI m9223a(URI uri) {
        if (uri == null) {
            return null;
        }
        try {
            return new URI(HttpHost.DEFAULT_SCHEME_NAME, uri.getHost(), null, null);
        } catch (URISyntaxException e) {
            return uri;
        }
    }
}
