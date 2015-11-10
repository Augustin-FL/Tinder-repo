package com.facebook.stetho.dumpapp;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.protocol.HTTP;

public class RawDumpappHandler extends DumpappHandler {
    private static final String RESPONSE_HEADER_EXIT_CODE = "X-FAB-ExitCode";

    public RawDumpappHandler(Context context, Dumper dumper) {
        super(context, dumper);
    }

    protected HttpEntity getResponseEntity(HttpRequest httpRequest, InputStream inputStream, HttpResponse httpResponse) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        try {
            PrintStream printStream = new PrintStream(byteArrayOutputStream2);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                httpResponse.addHeader(RESPONSE_HEADER_EXIT_CODE, String.valueOf(getDumper().dump(inputStream, printStream, new PrintStream(byteArrayOutputStream), DumpappHandler.getArgs(httpRequest))));
                if (byteArrayOutputStream.size() > 0) {
                    System.err.write(byteArrayOutputStream.toByteArray());
                }
                printStream.close();
                inputStream.close();
                return createResponseEntity(byteArrayOutputStream2.toByteArray());
            } catch (Throwable th) {
                byteArrayOutputStream2 = th;
                if (byteArrayOutputStream.size() > 0) {
                    System.err.write(byteArrayOutputStream.toByteArray());
                }
            } finally {
                printStream.close();
            }
        } catch (Throwable th2) {
            inputStream.close();
        }
    }

    private static HttpEntity createResponseEntity(byte[] bArr) {
        Object byteArrayEntity = new ByteArrayEntity(bArr);
        if (isProbablyBinaryData(bArr)) {
            byteArrayEntity.setContentType(HTTP.OCTET_STREAM_TYPE);
        } else {
            byteArrayEntity.setContentType(HTTP.PLAIN_TEXT_TYPE);
        }
        return byteArrayEntity;
    }

    private static boolean isProbablyBinaryData(byte[] bArr) {
        for (byte b : bArr) {
            if (b >= 127 || (b < 32 && b != 13 && b != 10 && b != 9)) {
                return true;
            }
        }
        return false;
    }
}
