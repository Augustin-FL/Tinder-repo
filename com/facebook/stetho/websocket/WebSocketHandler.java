package com.facebook.stetho.websocket;

import android.content.Context;
import android.util.Base64;
import com.facebook.stetho.common.Utf8Charset;
import com.facebook.stetho.server.LocalSocketHttpServerConnection;
import com.facebook.stetho.server.SecureHttpRequestHandler;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import org.apache.http.ConnectionClosedException;
import org.apache.http.Header;
import org.apache.http.HttpConnection;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpServerConnection;
import org.apache.http.HttpStatus;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpCoreContext;

public class WebSocketHandler extends SecureHttpRequestHandler {
    private static final String HEADER_CONNECTION = "Connection";
    private static final String HEADER_CONNECTION_UPGRADE = "Upgrade";
    private static final String HEADER_SEC_WEBSOCKET_ACCEPT = "Sec-WebSocket-Accept";
    private static final String HEADER_SEC_WEBSOCKET_KEY = "Sec-WebSocket-Key";
    private static final String HEADER_SEC_WEBSOCKET_PROTOCOL = "Sec-WebSocket-Protocol";
    private static final String HEADER_SEC_WEBSOCKET_VERSION = "Sec-WebSocket-Version";
    private static final String HEADER_SEC_WEBSOCKET_VERSION_13 = "13";
    private static final String HEADER_UPGRADE = "Upgrade";
    private static final String HEADER_UPGRADE_WEBSOCKET = "websocket";
    private static final String SERVER_KEY_GUID = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    private final SimpleEndpoint mEndpoint;

    private static class RawSocketUpgradeHelper {
        private final HttpServerConnection mConn;
        private final InputStream mIn;
        private final OutputStream mOut;

        public static RawSocketUpgradeHelper fromApacheContext(HttpContext httpContext) throws IOException {
            LocalSocketHttpServerConnection localSocketHttpServerConnection = (LocalSocketHttpServerConnection) httpContext.getAttribute(HttpCoreContext.HTTP_CONNECTION);
            return new RawSocketUpgradeHelper(localSocketHttpServerConnection, joinInputStreams(new ByteArrayInputStream(localSocketHttpServerConnection.clearInputBuffer()), localSocketHttpServerConnection.getSocket().getInputStream()), localSocketHttpServerConnection.getSocket().getOutputStream());
        }

        private RawSocketUpgradeHelper(HttpServerConnection httpServerConnection, InputStream inputStream, OutputStream outputStream) {
            this.mConn = httpServerConnection;
            this.mIn = inputStream;
            this.mOut = outputStream;
        }

        private static InputStream joinInputStreams(InputStream... inputStreamArr) throws IOException {
            return new CompositeInputStream(inputStreamArr);
        }

        public HttpServerConnection getServerConnection() {
            return this.mConn;
        }

        public InputStream getInputStream() {
            return this.mIn;
        }

        public OutputStream getOutputStream() {
            return this.mOut;
        }
    }

    public WebSocketHandler(Context context, SimpleEndpoint simpleEndpoint) {
        super(context);
        this.mEndpoint = simpleEndpoint;
    }

    public void handleSecured(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws IOException, HttpException {
        if (isSupportableUpgradeRequest(httpRequest)) {
            HttpConnection httpConnection = (HttpConnection) httpContext.getAttribute(HttpCoreContext.HTTP_CONNECTION);
            try {
                doUpgrade(httpRequest, httpResponse, httpContext);
                throw new ConnectionClosedException("EOF");
            } finally {
                try {
                    httpConnection.close();
                } catch (IOException e) {
                }
            }
        } else {
            httpResponse.setStatusCode(HttpStatus.SC_NOT_IMPLEMENTED);
            httpResponse.setReasonPhrase("Not Implemented");
            httpResponse.setEntity(new StringEntity("Not a supported WebSocket upgrade request\n"));
        }
    }

    private static boolean isSupportableUpgradeRequest(HttpRequest httpRequest) {
        return HEADER_UPGRADE_WEBSOCKET.equalsIgnoreCase(getFirstHeaderValue(httpRequest, HEADER_UPGRADE)) && HEADER_UPGRADE.equals(getFirstHeaderValue(httpRequest, HEADER_CONNECTION)) && HEADER_SEC_WEBSOCKET_VERSION_13.equals(getFirstHeaderValue(httpRequest, HEADER_SEC_WEBSOCKET_VERSION));
    }

    private void doUpgrade(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws IOException, HttpException {
        RawSocketUpgradeHelper fromApacheContext = RawSocketUpgradeHelper.fromApacheContext(httpContext);
        httpResponse.setStatusCode(HttpStatus.SC_SWITCHING_PROTOCOLS);
        httpResponse.setReasonPhrase("Switching Protocols");
        httpResponse.addHeader(HEADER_UPGRADE, HEADER_UPGRADE_WEBSOCKET);
        httpResponse.addHeader(HEADER_CONNECTION, HEADER_UPGRADE);
        String firstHeaderValue = getFirstHeaderValue(httpRequest, HEADER_SEC_WEBSOCKET_KEY);
        if (firstHeaderValue != null) {
            httpResponse.addHeader(HEADER_SEC_WEBSOCKET_ACCEPT, generateServerKey(firstHeaderValue));
        }
        forceSendResponse(fromApacheContext.getServerConnection(), httpResponse);
        new WebSocketSession(fromApacheContext.getInputStream(), fromApacheContext.getOutputStream(), this.mEndpoint).handle();
    }

    private static String generateServerKey(String str) {
        try {
            String str2 = str + SERVER_KEY_GUID;
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(Utf8Charset.encodeUTF8(str2));
            return Base64.encodeToString(instance.digest(), 2);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static String getFirstHeaderValue(HttpMessage httpMessage, String str) {
        Header firstHeader = httpMessage.getFirstHeader(str);
        return firstHeader != null ? firstHeader.getValue() : null;
    }

    private void forceSendResponse(HttpServerConnection httpServerConnection, HttpResponse httpResponse) throws IOException, HttpException {
        httpServerConnection.sendResponseHeader(httpResponse);
        httpServerConnection.flush();
    }
}
