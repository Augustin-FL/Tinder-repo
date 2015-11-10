package com.facebook.stetho.websocket;

import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.location.places.Place;
import com.tinder.views.RangeSeekBar;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import uk.co.senab.actionbarpulltorefresh.library.C3375e.C3374b;

class WebSocketSession implements SimpleSession {
    private final SimpleEndpoint mEndpoint;
    private final WriteCallback mErrorForwardingWriteCallback;
    private AtomicBoolean mIsOpen;
    private final ReadCallback mReadCallback;
    private final ReadHandler mReadHandler;
    private volatile boolean mSentClose;
    private final WriteHandler mWriteHandler;

    /* renamed from: com.facebook.stetho.websocket.WebSocketSession.1 */
    class C06891 implements ReadCallback {
        C06891() {
        }

        public void onCompleteFrame(byte b, byte[] bArr, int i) {
            switch (b) {
                case C3374b.SmoothProgressBar_spb_color /*1*/:
                    handleTextFrame(bArr, i);
                case C3374b.SmoothProgressBar_spb_stroke_width /*2*/:
                    handleBinaryFrame(bArr, i);
                case C3374b.SmoothProgressBar_spb_interpolator /*8*/:
                    handleClose(bArr, i);
                case C3374b.SmoothProgressBar_spb_reversed /*9*/:
                    handlePing(bArr, i);
                case C3374b.SmoothProgressBar_spb_mirror_mode /*10*/:
                    handlePong(bArr, i);
                default:
                    WebSocketSession.this.signalError(new IOException("Unsupported frame opcode=" + b));
            }
        }

        private void handleClose(byte[] bArr, int i) {
            int i2;
            String str;
            if (i >= 2) {
                i2 = (bArr[1] & RangeSeekBar.INVALID_POINTER_ID) | ((bArr[0] & RangeSeekBar.INVALID_POINTER_ID) << 8);
                str = i > 2 ? new String(bArr, 2, i - 2) : null;
            } else {
                i2 = Place.TYPE_FLOOR;
                str = "Unparseable close frame";
            }
            if (!WebSocketSession.this.mSentClose) {
                WebSocketSession.this.sendClose(LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, "Received close frame");
            }
            WebSocketSession.this.markAndSignalClosed(i2, str);
        }

        private void handlePing(byte[] bArr, int i) {
            WebSocketSession.this.doWrite(FrameHelper.createPongFrame(bArr, i));
        }

        private void handlePong(byte[] bArr, int i) {
        }

        private void handleTextFrame(byte[] bArr, int i) {
            WebSocketSession.this.mEndpoint.onMessage(WebSocketSession.this, new String(bArr, 0, i));
        }

        private void handleBinaryFrame(byte[] bArr, int i) {
            WebSocketSession.this.mEndpoint.onMessage(WebSocketSession.this, bArr, i);
        }
    }

    /* renamed from: com.facebook.stetho.websocket.WebSocketSession.2 */
    class C06902 implements WriteCallback {
        C06902() {
        }

        public void onFailure(IOException iOException) {
            WebSocketSession.this.signalError(iOException);
        }

        public void onSuccess() {
        }
    }

    public WebSocketSession(InputStream inputStream, OutputStream outputStream, SimpleEndpoint simpleEndpoint) {
        this.mIsOpen = new AtomicBoolean(false);
        this.mReadCallback = new C06891();
        this.mErrorForwardingWriteCallback = new C06902();
        this.mReadHandler = new ReadHandler(inputStream, simpleEndpoint);
        this.mWriteHandler = new WriteHandler(outputStream);
        this.mEndpoint = simpleEndpoint;
    }

    public void handle() throws IOException {
        markAndSignalOpen();
        try {
            this.mReadHandler.readLoop(this.mReadCallback);
        } catch (EOFException e) {
            markAndSignalClosed(Place.TYPE_NEIGHBORHOOD, "EOF while reading");
        } catch (IOException e2) {
            markAndSignalClosed(Place.TYPE_FLOOR, null);
            throw e2;
        }
    }

    public void sendText(String str) {
        doWrite(FrameHelper.createTextFrame(str));
    }

    public void sendBinary(byte[] bArr) {
        doWrite(FrameHelper.createBinaryFrame(bArr));
    }

    public void close(int i, String str) {
        sendClose(i, str);
        markAndSignalClosed(i, str);
    }

    private void sendClose(int i, String str) {
        doWrite(FrameHelper.createCloseFrame(i, str));
        markSentClose();
    }

    void markSentClose() {
        this.mSentClose = true;
    }

    void markAndSignalOpen() {
        if (!this.mIsOpen.getAndSet(true)) {
            this.mEndpoint.onOpen(this);
        }
    }

    void markAndSignalClosed(int i, String str) {
        if (this.mIsOpen.getAndSet(false)) {
            this.mEndpoint.onClose(this, i, str);
        }
    }

    public boolean isOpen() {
        return this.mIsOpen.get();
    }

    private void doWrite(Frame frame) {
        if (!signalErrorIfNotOpen()) {
            this.mWriteHandler.write(frame, this.mErrorForwardingWriteCallback);
        }
    }

    private boolean signalErrorIfNotOpen() {
        if (isOpen()) {
            return false;
        }
        signalError(new IOException("Session is closed"));
        return true;
    }

    private void signalError(IOException iOException) {
        this.mEndpoint.onError(this, iOException);
    }
}
