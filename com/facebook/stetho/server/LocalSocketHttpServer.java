package com.facebook.stetho.server;

import android.net.LocalServerSocket;
import android.net.LocalSocket;
import com.facebook.internal.Utility;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.ProcessUtil;
import com.facebook.stetho.common.Util;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.http.HttpServerConnection;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.DefaultHttpResponseFactory;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestHandlerResolver;
import org.apache.http.protocol.HttpService;
import org.apache.http.protocol.ResponseConnControl;
import org.apache.http.protocol.ResponseContent;
import org.apache.http.protocol.ResponseDate;
import org.apache.http.protocol.ResponseServer;

public class LocalSocketHttpServer {
    private static final int MAX_BIND_RETRIES = 2;
    private static final String SOCKET_NAME_PREFIX = "stetho_";
    private static final String SOCKET_NAME_SUFFIX = "_devtools_remote";
    private static final int TIME_BETWEEN_BIND_RETRIES_MS = 1000;
    private static final String WORKDER_THREAD_NAME_PREFIX = "StethoWorker";
    private static final AtomicInteger sThreadId;
    private final String mAddress;
    private Thread mListenerThread;
    private final RegistryInitializer mRegistryInitializer;
    private LocalServerSocket mServerSocket;
    private boolean mStopped;

    private static class WorkerThread extends Thread {
        private final HttpServerConnection conn;
        private final HttpService httpservice;

        public WorkerThread(HttpService httpService, HttpServerConnection httpServerConnection) {
            super(LocalSocketHttpServer.WORKDER_THREAD_NAME_PREFIX + LocalSocketHttpServer.sThreadId.incrementAndGet());
            this.httpservice = httpService;
            this.conn = httpServerConnection;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        @android.annotation.SuppressLint({"LogMethodNoExceptionInCatch"})
        public void run() {
            /*
            r4 = this;
            r0 = new org.apache.http.protocol.BasicHttpContext;
            r1 = 0;
            r0.<init>(r1);
            r1 = java.lang.Thread.interrupted();	 Catch:{ ConnectionClosedException -> 0x0021, IOException -> 0x0035, HttpException -> 0x0049 }
            if (r1 != 0) goto L_0x001b;
        L_0x000c:
            r1 = r4.conn;	 Catch:{ ConnectionClosedException -> 0x0021, IOException -> 0x0035, HttpException -> 0x0049 }
            r1 = r1.isOpen();	 Catch:{ ConnectionClosedException -> 0x0021, IOException -> 0x0035, HttpException -> 0x0049 }
            if (r1 == 0) goto L_0x001b;
        L_0x0014:
            r1 = r4.httpservice;	 Catch:{ ConnectionClosedException -> 0x0021, IOException -> 0x0035, HttpException -> 0x0049 }
            r2 = r4.conn;	 Catch:{ ConnectionClosedException -> 0x0021, IOException -> 0x0035, HttpException -> 0x0049 }
            r1.handleRequest(r2, r0);	 Catch:{ ConnectionClosedException -> 0x0021, IOException -> 0x0035, HttpException -> 0x0049 }
        L_0x001b:
            r0 = r4.conn;	 Catch:{ IOException -> 0x0066 }
            r0.close();	 Catch:{ IOException -> 0x0066 }
        L_0x0020:
            return;
        L_0x0021:
            r0 = move-exception;
            r1 = "Client closed connection: %s";
            r2 = 1;
            r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x005d }
            r3 = 0;
            r2[r3] = r0;	 Catch:{ all -> 0x005d }
            com.facebook.stetho.common.LogUtil.m948w(r1, r2);	 Catch:{ all -> 0x005d }
            r0 = r4.conn;	 Catch:{ IOException -> 0x0033 }
            r0.close();	 Catch:{ IOException -> 0x0033 }
            goto L_0x0020;
        L_0x0033:
            r0 = move-exception;
            goto L_0x0020;
        L_0x0035:
            r0 = move-exception;
            r1 = "I/O error: %s";
            r2 = 1;
            r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x005d }
            r3 = 0;
            r2[r3] = r0;	 Catch:{ all -> 0x005d }
            com.facebook.stetho.common.LogUtil.m948w(r1, r2);	 Catch:{ all -> 0x005d }
            r0 = r4.conn;	 Catch:{ IOException -> 0x0047 }
            r0.close();	 Catch:{ IOException -> 0x0047 }
            goto L_0x0020;
        L_0x0047:
            r0 = move-exception;
            goto L_0x0020;
        L_0x0049:
            r0 = move-exception;
            r1 = "Unrecoverable HTTP protocol violation: %s";
            r2 = 1;
            r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x005d }
            r3 = 0;
            r2[r3] = r0;	 Catch:{ all -> 0x005d }
            com.facebook.stetho.common.LogUtil.m948w(r1, r2);	 Catch:{ all -> 0x005d }
            r0 = r4.conn;	 Catch:{ IOException -> 0x005b }
            r0.close();	 Catch:{ IOException -> 0x005b }
            goto L_0x0020;
        L_0x005b:
            r0 = move-exception;
            goto L_0x0020;
        L_0x005d:
            r0 = move-exception;
            r1 = r4.conn;	 Catch:{ IOException -> 0x0064 }
            r1.close();	 Catch:{ IOException -> 0x0064 }
        L_0x0063:
            throw r0;
        L_0x0064:
            r1 = move-exception;
            goto L_0x0063;
        L_0x0066:
            r0 = move-exception;
            goto L_0x0020;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.server.LocalSocketHttpServer.WorkerThread.run():void");
        }
    }

    static {
        sThreadId = new AtomicInteger();
    }

    public LocalSocketHttpServer(RegistryInitializer registryInitializer) {
        this(registryInitializer, null);
    }

    public LocalSocketHttpServer(RegistryInitializer registryInitializer, String str) {
        this.mRegistryInitializer = (RegistryInitializer) Util.throwIfNull(registryInitializer);
        this.mAddress = str;
    }

    public void run() throws IOException {
        synchronized (this) {
            if (this.mStopped) {
                return;
            }
            this.mListenerThread = Thread.currentThread();
            listenOnAddress(this.mAddress != null ? this.mAddress : getDefaultAddress());
        }
    }

    private void listenOnAddress(String str) throws IOException {
        HttpService httpService = null;
        this.mServerSocket = bindToSocket(str);
        LogUtil.m939i("Listening on @" + str);
        HttpParams httpParams = null;
        while (!Thread.interrupted()) {
            HttpServerConnection localSocketHttpServerConnection = new LocalSocketHttpServerConnection();
            try {
                LocalSocket accept = this.mServerSocket.accept();
                if (httpParams == null) {
                    httpParams = createParams();
                }
                if (httpService == null) {
                    httpService = createService(httpParams);
                }
                localSocketHttpServerConnection.bind(accept, httpParams);
                Thread workerThread = new WorkerThread(httpService, localSocketHttpServerConnection);
                workerThread.setDaemon(true);
                workerThread.start();
            } catch (Throwable e) {
                if (!Thread.interrupted()) {
                    LogUtil.m949w(e, "I/O error");
                }
            } catch (InterruptedIOException e2) {
                return;
            } catch (Throwable e3) {
                LogUtil.m949w(e3, "I/O error initialising connection thread");
                return;
            }
        }
    }

    private static String getDefaultAddress() throws IOException {
        return SOCKET_NAME_PREFIX + ProcessUtil.getProcessName() + SOCKET_NAME_SUFFIX;
    }

    private HttpParams createParams() {
        return new BasicHttpParams().setIntParameter(CoreConnectionPNames.SO_TIMEOUT, 5000).setIntParameter(CoreConnectionPNames.SOCKET_BUFFER_SIZE, Utility.DEFAULT_STREAM_BUFFER_SIZE).setBooleanParameter(CoreConnectionPNames.STALE_CONNECTION_CHECK, false).setBooleanParameter(CoreConnectionPNames.TCP_NODELAY, true).setParameter(CoreProtocolPNames.ORIGIN_SERVER, "Stetho").setParameter(CoreProtocolPNames.PROTOCOL_VERSION, "HTTP/1.1");
    }

    private HttpService createService(HttpParams httpParams) {
        HttpRequestHandlerResolver registry = this.mRegistryInitializer.getRegistry();
        HttpProcessor basicHttpProcessor = new BasicHttpProcessor();
        basicHttpProcessor.addInterceptor(new ResponseDate());
        basicHttpProcessor.addInterceptor(new ResponseServer());
        basicHttpProcessor.addInterceptor(new ResponseContent());
        basicHttpProcessor.addInterceptor(new ResponseConnControl());
        HttpService httpService = new HttpService(basicHttpProcessor, new DefaultConnectionReuseStrategy(), new DefaultHttpResponseFactory());
        httpService.setParams(httpParams);
        httpService.setHandlerResolver(registry);
        return httpService;
    }

    public void stop() {
        synchronized (this) {
            this.mStopped = true;
            if (this.mListenerThread == null) {
                return;
            }
            this.mListenerThread.interrupt();
            try {
                if (this.mServerSocket != null) {
                    this.mServerSocket.close();
                }
            } catch (IOException e) {
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.net.LocalServerSocket bindToSocket(java.lang.String r6) throws java.io.IOException {
        /*
        r0 = 2;
        r1 = 0;
        r2 = r0;
    L_0x0003:
        r0 = 3;
        r0 = com.facebook.stetho.common.LogUtil.isLoggable(r0);	 Catch:{ BindException -> 0x0026 }
        if (r0 == 0) goto L_0x0020;
    L_0x000a:
        r0 = new java.lang.StringBuilder;	 Catch:{ BindException -> 0x0026 }
        r0.<init>();	 Catch:{ BindException -> 0x0026 }
        r3 = "Trying to bind to @";
        r0 = r0.append(r3);	 Catch:{ BindException -> 0x0026 }
        r0 = r0.append(r6);	 Catch:{ BindException -> 0x0026 }
        r0 = r0.toString();	 Catch:{ BindException -> 0x0026 }
        com.facebook.stetho.common.LogUtil.m931d(r0);	 Catch:{ BindException -> 0x0026 }
    L_0x0020:
        r0 = new android.net.LocalServerSocket;	 Catch:{ BindException -> 0x0026 }
        r0.<init>(r6);	 Catch:{ BindException -> 0x0026 }
        return r0;
    L_0x0026:
        r0 = move-exception;
        r3 = "Binding error, sleep 1000 ms...";
        com.facebook.stetho.common.LogUtil.m949w(r0, r3);
        if (r1 != 0) goto L_0x0038;
    L_0x002e:
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        com.facebook.stetho.common.Util.sleepUninterruptibly(r4);
        r1 = r2 + -1;
        if (r2 > 0) goto L_0x003a;
    L_0x0037:
        throw r0;
    L_0x0038:
        r0 = r1;
        goto L_0x002e;
    L_0x003a:
        r2 = r1;
        r1 = r0;
        goto L_0x0003;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.server.LocalSocketHttpServer.bindToSocket(java.lang.String):android.net.LocalServerSocket");
    }
}
