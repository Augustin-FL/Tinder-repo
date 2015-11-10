package com.tinder.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.support.annotation.NonNull;
import com.google.android.gms.wearable.Asset;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tinder.model.WearUser;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import org.apache.http.protocol.HTTP;

public class an {
    private static Gson f6588a;

    static {
        f6588a = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    public static String m9320a(WearUser wearUser) {
        return f6588a.toJson((Object) wearUser);
    }

    @NonNull
    public static Asset m9319a(@NonNull Bitmap bitmap) throws IOException {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.JPEG, 90, byteArrayOutputStream);
        Asset createFromBytes = Asset.createFromBytes(byteArrayOutputStream.toByteArray());
        byteArrayOutputStream.close();
        return createFromBytes;
    }

    @NonNull
    public static String m9321a(@NonNull byte[] bArr) {
        return new String(bArr, Charset.forName(HTTP.UTF_8));
    }
}
