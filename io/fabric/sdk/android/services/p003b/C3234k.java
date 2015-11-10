package io.fabric.sdk.android.services.p003b;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/* renamed from: io.fabric.sdk.android.services.b.k */
public class C3234k extends C3233l {
    public C3234k(Context context, File file, String str, String str2) throws IOException {
        super(context, file, str, str2);
    }

    public OutputStream m9823a(File file) throws IOException {
        return new GZIPOutputStream(new FileOutputStream(file));
    }
}
