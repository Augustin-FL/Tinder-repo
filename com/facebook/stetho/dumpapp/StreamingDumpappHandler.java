package com.facebook.stetho.dumpapp;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.protocol.HTTP;

public class StreamingDumpappHandler extends DumpappHandler {

    private class DumpappHttpEntity extends AbstractHttpEntity {
        private final Dumper mDumper;
        private final InputStream mInput;
        private final HttpRequest mRequest;

        DumpappHttpEntity(HttpRequest httpRequest, Dumper dumper, InputStream inputStream) {
            this.mRequest = httpRequest;
            this.mDumper = dumper;
            this.mInput = inputStream;
        }

        public boolean isRepeatable() {
            return false;
        }

        public long getContentLength() {
            return -1;
        }

        public InputStream getContent() throws IOException, IllegalStateException {
            throw new UnsupportedOperationException();
        }

        public boolean isStreaming() {
            return true;
        }

        public void writeTo(OutputStream outputStream) throws IOException {
            StreamingDumpappHandler.writeTo(this.mRequest, this.mDumper, this.mInput, outputStream);
        }
    }

    public StreamingDumpappHandler(Context context, Dumper dumper) {
        super(context, dumper);
    }

    protected HttpEntity getResponseEntity(HttpRequest httpRequest, InputStream inputStream, HttpResponse httpResponse) throws IOException {
        HttpEntity dumpappHttpEntity = new DumpappHttpEntity(httpRequest, getDumper(), inputStream);
        dumpappHttpEntity.setChunked(true);
        dumpappHttpEntity.setContentType(HTTP.OCTET_STREAM_TYPE);
        return dumpappHttpEntity;
    }

    private static void writeTo(HttpRequest httpRequest, Dumper dumper, InputStream inputStream, OutputStream outputStream) throws IOException {
        StreamFramer streamFramer = new StreamFramer(outputStream);
        try {
            streamFramer.writeExitCode(dumper.dump(inputStream, streamFramer.getStdout(), streamFramer.getStderr(), DumpappHandler.getArgs(httpRequest)));
        } catch (DumpappOutputBrokenException e) {
        } finally {
            streamFramer.close();
        }
    }
}
