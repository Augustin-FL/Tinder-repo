package com.facebook.stetho.inspector.network;

import android.content.Context;
import android.util.Base64OutputStream;
import com.facebook.stetho.common.LogRedirector;
import com.facebook.stetho.common.Util;
import com.google.android.gms.location.places.Place;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.protocol.HTTP;

public class ResponseBodyFileManager {
    private static final String FILENAME_PREFIX = "network-response-body-";
    private static final String TAG = "ResponseBodyFileManager";
    private final Context mContext;

    public ResponseBodyFileManager(Context context) {
        this.mContext = context;
    }

    public void cleanupFiles() {
        for (File file : this.mContext.getFilesDir().listFiles()) {
            if (file.getName().startsWith(FILENAME_PREFIX) && !file.delete()) {
                LogRedirector.m929w(TAG, "Failed to delete " + file.getAbsolutePath());
            }
        }
        LogRedirector.m925i(TAG, "Cleaned up temporary network files.");
    }

    public ResponseBodyData readFile(String str) throws IOException {
        InputStream openFileInput = this.mContext.openFileInput(getFilename(str));
        try {
            int read = openFileInput.read();
            ResponseBodyData responseBodyData = -1;
            if (read == responseBodyData) {
                throw new EOFException("Failed to read base64Encode byte");
            }
            responseBodyData = new ResponseBodyData();
            responseBodyData.base64Encoded = read != 0;
            responseBodyData.data = readContentsAsUTF8(openFileInput);
            return responseBodyData;
        } finally {
            openFileInput.close();
        }
    }

    private static String readContentsAsUTF8(InputStream inputStream) throws IOException {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Util.copy(inputStream, byteArrayOutputStream, new byte[Place.TYPE_SUBLOCALITY_LEVEL_2]);
        return byteArrayOutputStream.toString(HTTP.UTF_8);
    }

    public OutputStream openResponseBodyFile(String str, boolean z) throws IOException {
        int i;
        OutputStream openFileOutput = this.mContext.openFileOutput(getFilename(str), 0);
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        openFileOutput.write(i);
        if (z) {
            return new Base64OutputStream(openFileOutput, 0);
        }
        return openFileOutput;
    }

    private static String getFilename(String str) {
        return FILENAME_PREFIX + str;
    }
}
