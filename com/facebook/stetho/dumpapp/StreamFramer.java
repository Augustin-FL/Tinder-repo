package com.facebook.stetho.dumpapp;

import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class StreamFramer implements Closeable {
    private static final byte EXIT_FRAME_PREFIX = (byte) 120;
    private static final byte STDERR_FRAME_PREFIX = (byte) 50;
    private static final byte STDOUT_FRAME_PREFIX = (byte) 49;
    private final DataOutputStream mMultiplexedOutputStream;
    private final PrintStream mStderr;
    private final PrintStream mStdout;

    private class FramingOutputStream extends FilterOutputStream {
        private final byte mPrefix;

        FramingOutputStream(DataOutputStream dataOutputStream, byte b) {
            super(dataOutputStream);
            this.mPrefix = b;
        }

        public void write(byte[] bArr, int i, int i2) throws IOException {
            if (i2 > 0) {
                try {
                    synchronized (StreamFramer.this) {
                        StreamFramer.this.writeIntFrame(this.mPrefix, i2);
                        StreamFramer.this.mMultiplexedOutputStream.write(bArr, i, i2);
                        StreamFramer.this.mMultiplexedOutputStream.flush();
                    }
                } catch (Throwable e) {
                    throw new DumpappOutputBrokenException(e);
                }
            }
        }

        public void write(int i) throws IOException {
            byte[] bArr = new byte[]{(byte) i};
            write(bArr, 0, bArr.length);
        }

        public void write(byte[] bArr) throws IOException {
            write(bArr, 0, bArr.length);
        }
    }

    public StreamFramer(OutputStream outputStream) throws IOException {
        this.mMultiplexedOutputStream = new DataOutputStream(outputStream);
        this.mStdout = new PrintStream(new BufferedOutputStream(new FramingOutputStream(this.mMultiplexedOutputStream, STDOUT_FRAME_PREFIX)));
        this.mStderr = new PrintStream(new FramingOutputStream(this.mMultiplexedOutputStream, STDERR_FRAME_PREFIX));
    }

    public PrintStream getStdout() {
        return this.mStdout;
    }

    public PrintStream getStderr() {
        return this.mStderr;
    }

    public synchronized void writeExitCode(int i) throws IOException {
        this.mStdout.flush();
        this.mStderr.flush();
        writeIntFrame(EXIT_FRAME_PREFIX, i);
    }

    public synchronized void close() throws IOException {
        this.mMultiplexedOutputStream.close();
    }

    private void writeIntFrame(byte b, int i) throws IOException {
        this.mMultiplexedOutputStream.write(b);
        this.mMultiplexedOutputStream.writeInt(i);
    }
}
