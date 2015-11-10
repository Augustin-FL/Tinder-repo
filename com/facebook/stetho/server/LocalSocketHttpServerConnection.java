package com.facebook.stetho.server;

import android.net.LocalSocket;
import com.facebook.stetho.common.Util;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.apache.http.impl.AbstractHttpServerConnection;
import org.apache.http.impl.io.AbstractSessionInputBuffer;
import org.apache.http.impl.io.AbstractSessionOutputBuffer;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class LocalSocketHttpServerConnection extends AbstractHttpServerConnection {
    private volatile LocalSocketSessionInputBuffer mInputBuffer;
    private volatile boolean mOpen;
    private volatile LocalSocket mSocket;

    private static class LocalSocketSessionInputBuffer extends AbstractSessionInputBuffer {
        public LocalSocketSessionInputBuffer(LocalSocket localSocket, int i, HttpParams httpParams) throws IOException {
            if (HttpConnectionParams.isStaleCheckingEnabled(httpParams)) {
                throw new UnsupportedOperationException("Stale connection checking should not be used for local sockets");
            }
            init(localSocket.getInputStream(), i, httpParams);
        }

        public byte[] clearCurrentBuffer() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (hasBufferedData()) {
                try {
                    int read = read();
                    Util.throwIfNot(read != -1, "Buffered data cannot EOF", new Object[0]);
                    byteArrayOutputStream.write(read);
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
            return byteArrayOutputStream.toByteArray();
        }

        public boolean isDataAvailable(int i) throws IOException {
            throw new UnsupportedOperationException("CoreConnectionPNames.STALE_CONNECTION_CHECK appears to be true but that can't be?");
        }
    }

    private static class LocalSocketSessionOutputBuffer extends AbstractSessionOutputBuffer {
        public LocalSocketSessionOutputBuffer(LocalSocket localSocket, int i, HttpParams httpParams) throws IOException {
            init(localSocket.getOutputStream(), i, httpParams);
        }

        public void flush() throws IOException {
            flushBuffer();
        }
    }

    public void bind(LocalSocket localSocket, HttpParams httpParams) throws IOException {
        Util.throwIfNull(localSocket);
        Util.throwIfNull(httpParams);
        this.mSocket = localSocket;
        int socketBufferSize = HttpConnectionParams.getSocketBufferSize(httpParams);
        this.mInputBuffer = new LocalSocketSessionInputBuffer(localSocket, socketBufferSize, httpParams);
        init(this.mInputBuffer, new LocalSocketSessionOutputBuffer(localSocket, socketBufferSize, httpParams), httpParams);
        this.mOpen = true;
    }

    public LocalSocket getSocket() {
        return this.mSocket;
    }

    public byte[] clearInputBuffer() {
        return this.mInputBuffer.clearCurrentBuffer();
    }

    protected void assertOpen() throws IllegalStateException {
        Util.throwIfNot(this.mOpen);
    }

    public boolean isOpen() {
        return this.mOpen;
    }

    public void setSocketTimeout(int i) {
        try {
            this.mSocket.setSoTimeout(i);
        } catch (IOException e) {
            Util.throwIfNot(this.mSocket.isClosed());
        }
    }

    public int getSocketTimeout() {
        try {
            return this.mSocket.getSoTimeout();
        } catch (IOException e) {
            Util.throwIfNot(this.mSocket.isClosed());
            return -1;
        }
    }

    public void shutdown() throws IOException {
        close(false);
    }

    public void close() throws IOException {
        close(true);
    }

    private void close(boolean z) throws IOException {
        if (this.mOpen) {
            this.mOpen = false;
            if (z) {
                doFlush();
            }
            this.mSocket.close();
        }
    }
}
