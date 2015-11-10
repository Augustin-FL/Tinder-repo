package com.facebook.stetho.server;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Credentials;
import android.net.LocalSocket;
import com.facebook.stetho.common.LogUtil;
import java.io.IOException;
import org.apache.http.HttpConnection;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpCoreContext;
import org.apache.http.protocol.HttpRequestHandler;

public abstract class SecureHttpRequestHandler implements HttpRequestHandler {
    private static final Class<?> TAG;
    private final Context mContext;

    protected abstract void handleSecured(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException;

    static {
        TAG = SecureHttpRequestHandler.class;
    }

    public SecureHttpRequestHandler(Context context) {
        this.mContext = context;
    }

    @SuppressLint({"LogMethodNoExceptionInCatch"})
    public final void handle(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
        try {
            ensureSecureRequest(httpRequest, httpContext);
            handleSecured(httpRequest, httpResponse, httpContext);
        } catch (PeerAuthorizationException e) {
            LogUtil.m935e("Unauthorized request: " + e.getMessage());
            httpResponse.setStatusCode(HttpStatus.SC_FORBIDDEN);
            httpResponse.setEntity(new StringEntity(e.getMessage() + "\n", HTTP.UTF_8));
        }
    }

    private void ensureSecureRequest(HttpRequest httpRequest, HttpContext httpContext) throws PeerAuthorizationException, IOException {
        HttpConnection httpConnection = (HttpConnection) httpContext.getAttribute(HttpCoreContext.HTTP_CONNECTION);
        if (httpConnection instanceof LocalSocketHttpServerConnection) {
            enforcePermission(this.mContext, ((LocalSocketHttpServerConnection) httpConnection).getSocket());
            return;
        }
        throw new PeerAuthorizationException("Unexpected connection class: " + httpConnection.getClass().getName());
    }

    private static void enforcePermission(Context context, LocalSocket localSocket) throws IOException, PeerAuthorizationException {
        Credentials peerCredentials = localSocket.getPeerCredentials();
        int uid = peerCredentials.getUid();
        int pid = peerCredentials.getPid();
        if (LogUtil.isLoggable(2)) {
            LogUtil.m944v("Got request from uid=%d, pid=%d", Integer.valueOf(uid), Integer.valueOf(pid));
        }
        String str = "android.permission.DUMP";
        if (context.checkPermission(str, pid, uid) != 0) {
            throw new PeerAuthorizationException("Peer pid=" + pid + ", uid=" + uid + " does not have " + str);
        }
    }
}
