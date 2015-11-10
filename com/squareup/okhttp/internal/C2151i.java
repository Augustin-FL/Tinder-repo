package com.squareup.okhttp.internal;

import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.squareup.okhttp.Protocol;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.net.ssl.SSLSocket;
import okio.C3334c;

/* renamed from: com.squareup.okhttp.internal.i */
public class C2151i {
    private static final C2151i f3335a;

    /* renamed from: com.squareup.okhttp.internal.i.a */
    private static class C2152a extends C2151i {
        private final C2117h<Socket> f3336a;
        private final C2117h<Socket> f3337b;
        private final Method f3338c;
        private final Method f3339d;
        private final C2117h<Socket> f3340e;
        private final C2117h<Socket> f3341f;

        public C2152a(C2117h<Socket> c2117h, C2117h<Socket> c2117h2, Method method, Method method2, C2117h<Socket> c2117h3, C2117h<Socket> c2117h4) {
            this.f3336a = c2117h;
            this.f3337b = c2117h2;
            this.f3338c = method;
            this.f3339d = method2;
            this.f3340e = c2117h3;
            this.f3341f = c2117h4;
        }

        public void m5332a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
            try {
                socket.connect(inetSocketAddress, i);
            } catch (Throwable e) {
                IOException iOException = new IOException("Exception in connect");
                iOException.initCause(e);
                throw iOException;
            }
        }

        public void m5333a(SSLSocket sSLSocket, String str, List<Protocol> list) {
            if (str != null) {
                this.f3336a.m5131b(sSLSocket, Boolean.valueOf(true));
                this.f3337b.m5131b(sSLSocket, str);
            }
            if (this.f3341f != null && this.f3341f.m5130a((Object) sSLSocket)) {
                this.f3341f.m5133d(sSLSocket, C2151i.m5321a((List) list));
            }
        }

        public String m5334b(SSLSocket sSLSocket) {
            if (this.f3340e == null || !this.f3340e.m5130a((Object) sSLSocket)) {
                return null;
            }
            byte[] bArr = (byte[]) this.f3340e.m5133d(sSLSocket, new Object[0]);
            return bArr != null ? new String(bArr, C2157k.f3355c) : null;
        }

        public void m5331a(Socket socket) throws SocketException {
            if (this.f3338c != null) {
                try {
                    this.f3338c.invoke(null, new Object[]{socket});
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e2) {
                    throw new RuntimeException(e2.getCause());
                }
            }
        }

        public void m5335b(Socket socket) throws SocketException {
            if (this.f3339d != null) {
                try {
                    this.f3339d.invoke(null, new Object[]{socket});
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e2) {
                    throw new RuntimeException(e2.getCause());
                }
            }
        }
    }

    /* renamed from: com.squareup.okhttp.internal.i.b */
    private static class C2153b extends C2151i {
        private final Method f3342a;
        private final Method f3343b;
        private final Method f3344c;
        private final Class<?> f3345d;
        private final Class<?> f3346e;

        public C2153b(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
            this.f3342a = method;
            this.f3343b = method2;
            this.f3344c = method3;
            this.f3345d = cls;
            this.f3346e = cls2;
        }

        public void m5337a(SSLSocket sSLSocket, String str, List<Protocol> list) {
            Object newProxyInstance;
            List arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Protocol protocol = (Protocol) list.get(i);
                if (protocol != Protocol.HTTP_1_0) {
                    arrayList.add(protocol.toString());
                }
            }
            try {
                newProxyInstance = Proxy.newProxyInstance(C2151i.class.getClassLoader(), new Class[]{this.f3345d, this.f3346e}, new C2154c(arrayList));
                this.f3342a.invoke(null, new Object[]{sSLSocket, newProxyInstance});
            } catch (InvocationTargetException e) {
                newProxyInstance = e;
                throw new AssertionError(newProxyInstance);
            } catch (IllegalAccessException e2) {
                newProxyInstance = e2;
                throw new AssertionError(newProxyInstance);
            }
        }

        public void m5336a(SSLSocket sSLSocket) {
            try {
                this.f3344c.invoke(null, new Object[]{sSLSocket});
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            } catch (InvocationTargetException e2) {
                throw new AssertionError();
            }
        }

        public String m5338b(SSLSocket sSLSocket) {
            try {
                C2154c c2154c = (C2154c) Proxy.getInvocationHandler(this.f3343b.invoke(null, new Object[]{sSLSocket}));
                if (c2154c.f3348b || c2154c.f3349c != null) {
                    return c2154c.f3348b ? null : c2154c.f3349c;
                }
                C2113d.f3214a.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
                return null;
            } catch (InvocationTargetException e) {
                throw new AssertionError();
            } catch (IllegalAccessException e2) {
                throw new AssertionError();
            }
        }
    }

    /* renamed from: com.squareup.okhttp.internal.i.c */
    private static class C2154c implements InvocationHandler {
        private final List<String> f3347a;
        private boolean f3348b;
        private String f3349c;

        public C2154c(List<String> list) {
            this.f3347a = list;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class returnType = method.getReturnType();
            if (objArr == null) {
                objArr = C2157k.f3354b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.valueOf(true);
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f3348b = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.f3347a;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                    List list = (List) objArr[0];
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        if (this.f3347a.contains(list.get(i))) {
                            name = (String) list.get(i);
                            this.f3349c = name;
                            return name;
                        }
                    }
                    name = (String) this.f3347a.get(0);
                    this.f3349c = name;
                    return name;
                } else if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                } else {
                    this.f3349c = (String) objArr[0];
                    return null;
                }
            }
        }
    }

    static {
        f3335a = C2151i.m5322c();
    }

    public static C2151i m5320a() {
        return f3335a;
    }

    public String m5328b() {
        return "OkHttp";
    }

    public void m5323a(String str) {
        System.out.println(str);
    }

    public void m5324a(Socket socket) throws SocketException {
    }

    public void m5330b(Socket socket) throws SocketException {
    }

    public void m5327a(SSLSocket sSLSocket, String str, List<Protocol> list) {
    }

    public void m5326a(SSLSocket sSLSocket) {
    }

    public String m5329b(SSLSocket sSLSocket) {
        return null;
    }

    public void m5325a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    private static C2151i m5322c() {
        Method method;
        Method method2;
        C2117h c2117h;
        C2117h c2117h2;
        Method method3;
        C2117h c2117h3;
        C2117h c2117h4;
        Method method4;
        try {
            Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl");
        } catch (ClassNotFoundException e) {
            Class.forName("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
        }
        try {
            C2117h c2117h5 = new C2117h(null, "setUseSessionTickets", Boolean.TYPE);
            C2117h c2117h6 = new C2117h(null, "setHostname", String.class);
            try {
                Class cls = Class.forName("android.net.TrafficStats");
                Method method5 = cls.getMethod("tagSocket", new Class[]{Socket.class});
                try {
                    method = cls.getMethod("untagSocket", new Class[]{Socket.class});
                    method2 = method;
                    c2117h = c2117h2;
                    method3 = method5;
                    c2117h3 = c2117h4;
                } catch (ClassNotFoundException e2) {
                    method4 = method5;
                    method2 = null;
                    method = method4;
                    c2117h4 = null;
                    c2117h3 = null;
                    method3 = method;
                    c2117h = c2117h4;
                    return new C2152a(c2117h5, c2117h6, method3, method2, c2117h, c2117h3);
                } catch (NoSuchMethodException e3) {
                    c2117h4 = null;
                    method2 = null;
                    method = method5;
                    c2117h3 = null;
                    method3 = method;
                    c2117h = c2117h4;
                    return new C2152a(c2117h5, c2117h6, method3, method2, c2117h, c2117h3);
                }
                try {
                    Class.forName("android.net.Network");
                    C2117h c2117h7 = new C2117h(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                    try {
                        c2117h4 = new C2117h(null, "setAlpnProtocols", byte[].class);
                        c2117h2 = c2117h7;
                    } catch (ClassNotFoundException e4) {
                        c2117h4 = c2117h7;
                        c2117h2 = c2117h4;
                        c2117h4 = null;
                        method2 = method;
                        c2117h = c2117h2;
                        method3 = method5;
                        c2117h3 = c2117h4;
                        return new C2152a(c2117h5, c2117h6, method3, method2, c2117h, c2117h3);
                    } catch (NoSuchMethodException e5) {
                        c2117h4 = c2117h7;
                        method2 = method;
                        method = method5;
                        c2117h3 = null;
                        method3 = method;
                        c2117h = c2117h4;
                        return new C2152a(c2117h5, c2117h6, method3, method2, c2117h, c2117h3);
                    }
                } catch (ClassNotFoundException e6) {
                    c2117h4 = null;
                    c2117h2 = c2117h4;
                    c2117h4 = null;
                    method2 = method;
                    c2117h = c2117h2;
                    method3 = method5;
                    c2117h3 = c2117h4;
                    return new C2152a(c2117h5, c2117h6, method3, method2, c2117h, c2117h3);
                } catch (NoSuchMethodException e7) {
                    c2117h4 = null;
                    method2 = method;
                    method = method5;
                    c2117h3 = null;
                    method3 = method;
                    c2117h = c2117h4;
                    return new C2152a(c2117h5, c2117h6, method3, method2, c2117h, c2117h3);
                }
            } catch (ClassNotFoundException e8) {
                method4 = null;
                method2 = null;
                method = method4;
                c2117h4 = null;
                c2117h3 = null;
                method3 = method;
                c2117h = c2117h4;
                return new C2152a(c2117h5, c2117h6, method3, method2, c2117h, c2117h3);
            } catch (NoSuchMethodException e9) {
                c2117h4 = null;
                method2 = null;
                method = null;
                c2117h3 = null;
                method3 = method;
                c2117h = c2117h4;
                return new C2152a(c2117h5, c2117h6, method3, method2, c2117h, c2117h3);
            }
            return new C2152a(c2117h5, c2117h6, method3, method2, c2117h, c2117h3);
        } catch (ClassNotFoundException e10) {
            try {
                String str = "org.eclipse.jetty.alpn.ALPN";
                Class cls2 = Class.forName(str);
                Class cls3 = Class.forName(str + "$Provider");
                Class cls4 = Class.forName(str + "$ClientProvider");
                Class cls5 = Class.forName(str + "$ServerProvider");
                return new C2153b(cls2.getMethod("put", new Class[]{SSLSocket.class, cls3}), cls2.getMethod("get", new Class[]{SSLSocket.class}), cls2.getMethod(ProductAction.ACTION_REMOVE, new Class[]{SSLSocket.class}), cls4, cls5);
            } catch (ClassNotFoundException e11) {
                return new C2151i();
            } catch (NoSuchMethodException e12) {
                return new C2151i();
            }
        }
    }

    static byte[] m5321a(List<Protocol> list) {
        C3334c c3334c = new C3334c();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = (Protocol) list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                c3334c.m10211b(protocol.toString().length());
                c3334c.m10202a(protocol.toString());
            }
        }
        return c3334c.m10250t();
    }
}
