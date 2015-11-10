package com.facebook.stetho.websocket;

import com.google.android.gms.location.places.Place;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class WriteHandler {
    private final BufferedOutputStream mBufferedOutput;

    public WriteHandler(OutputStream outputStream) {
        this.mBufferedOutput = new BufferedOutputStream(outputStream, Place.TYPE_SUBLOCALITY_LEVEL_2);
    }

    public synchronized void write(Frame frame, WriteCallback writeCallback) {
        try {
            frame.writeTo(this.mBufferedOutput);
            this.mBufferedOutput.flush();
            writeCallback.onSuccess();
        } catch (IOException e) {
            writeCallback.onFailure(e);
        }
    }
}
